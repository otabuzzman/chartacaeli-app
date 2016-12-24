
package chartacaeli;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.math3.geometry.euclidean.threed.Line;
import org.apache.commons.math3.geometry.euclidean.threed.Plane;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import com.vividsolutions.jts.algorithm.MinimumDiameter;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

import edu.rit.pj2.Loop;
import edu.rit.pj2.Task;

@SuppressWarnings("serial")
public class Artwork extends chartacaeli.model.Artwork implements PostscriptEmitter {

	// configuration key (CK_)
	private final static String CK_PSUNIT			= "psunit" ;
	private final static String CK_DPI				= "dpi" ;
	private final static String CK_INTERVAL			= "interval" ;
	private final static String CK_IMAGEOP			= "imageop" ;
	private final static String CK_MINVISIBLE		= "minvisible" ;
	private final static String CK_BACKGROUND		= "background" ;
	private final static String CK_PJ2CLASS			= "pj2class" ;
	private final static String CK_LIBGPU			= "libgpu" ;

	private final static double DEFAULT_PSUNIT		= 2.834646 ;
	private final static double DEFAULT_DPI			= 72 ;
	private final static int DEFAULT_INTERVAL		= 1 ;
	private final static boolean DEFAULT_IMAGEOP	= false ;
	private final static double DEFAULT_MINVISIBLE	= 25 ;
	private final static String DEFAULT_BACKGROUND	= "0:0:0,0:0:0" ;
	private final static String DEFAULT_PJ2CLASS	= "chartacaeli.Artwork$PJ2TextureMapperSeq" ;
	private final static String DEFAULT_LIBGPU		= "gpu" ;

	private final static Log log = LogFactory.getLog( Artwork.class ) ;
	private static boolean verbose = false ;

	// set by init
	private boolean initialized = false ;

	private Projector projector ;

	// global FOV
	private Geometry got ;

	// cartesian poppers P1, P2 and P3 of heaven
	private Coordinate popHP1 ;
	private Coordinate popHP2 ;
	private Coordinate popHP3 ;

	// cartesian poppers P1, P2 and P3 of texture
	private Coordinate popTP1 ;
	private Coordinate popTP2 ;
	private Coordinate popTP3 ;

	// texture image and it's features, top left origin
	private int[] texture ;
	// names of texture coordinates are o, p
	private int dimo, dimp ;
	private int maxo, maxp ;

	// mapping image of texture projection
	private int[] mapping ;

	// spatial plane of texture in heaven's coordinate system
	private Plane spT ;

	// units per dot
	private double ups ;

	// names of mapping coordinates are s, t
	private int dims, dimt ;
	private double maxs, maxt ;

	// outline of texture projection
	private Coordinate[] cOPT ;
	// bounding box of texture projection
	private Coordinate[] cBBT ;

	// transformation matrices
	private RealMatrix tmT2H ; // transform texture to heaven coordinates...
	private RealMatrix tmH2T ; // ...and vice versa
	private RealMatrix tmM2P ; // transform texture mapping to projection coordinates

	@SuppressWarnings("unused")
	private class PJ2TextureMapperSeq extends Task {

		private double[] st ;
		private Coordinate uv ;

		private chartacaeli.Coordinate eq ;
		private double[] ca ;

		public PJ2TextureMapperSeq() {
			st = new double[] { 0, 0, 1 } ;
			uv = new Coordinate() ;

			eq = new chartacaeli.Coordinate( 0, 0, 0 ) ;
			ca = new double[] { 0, 0, 0, 1 } ;
		}

		public void main( String[] argv ) throws Exception {
			double t0[], op[] ;
			Coordinate t1 ;
			Vector3D vca, xca ;

			for ( int y=0 ; dimt>y ; y++ ) {
				st[1] = y*ups ;

				for ( int x=0 ; dims>x ; x++ ) {
					st[0] = x*ups ;

					t0 = tmM2P.operate( st ) ;
					uv.x = t0[0] ;
					uv.y = t0[1] ;

					eq.setCoordinate( projector.project( uv, true ) ) ;
					t1 = eq.cartesian() ;

					vca = new Vector3D( t1.x, t1.y, t1.z ) ;
					xca = spT.intersection( new Line( Vector3D.ZERO, vca, 1.0e-10 ) ) ;
					ca[0] = xca.getX() ;
					ca[1] = xca.getY() ;
					ca[2] = xca.getZ() ;

					op = tmH2T.operate( ca ) ;

					if ( op[0]>=0 && op[1]>=0 && dimo>op[0] && dimp>op[1] )
						mapping[y*dims+x] = texture[(int) op[1]*dimo+(int) op[0]] ;
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private class PJ2TextureMapperJni extends Task {

		private double[] st ;
		private double[] uv ;

		private double[] lamphi ;
		chartacaeli.gpu.tst.Coordinate eq ;

		private double[] l0 ;
		private double[] l1 ;
		private double[] ca ;

		private double[] op ;

		public PJ2TextureMapperJni() {
			String libgpu = Configuration.getValue(
					this, CK_LIBGPU, DEFAULT_LIBGPU ) ;
			System.loadLibrary( libgpu ) ;

			st = new double[] { 0, 0, 1 } ;
			uv = new double[3] ;

			lamphi = new double[3] ;
			eq = new chartacaeli.gpu.tst.Coordinate() ;

			l0 = new double[] { 0, 0, 0 } ;
			l1 = new double[3] ;
			ca = new double[] { 0, 0, 0, 1 } ;

			op = new double[4] ;
		}

		public void main( String[] argv ) throws Exception {
			chartacaeli.gpu.tst.RealMatrix tmM2Pc3p ;
			double[] tmM2Pj[], tmM2Pc = new double[9] ;
			chartacaeli.gpu.tst.RealMatrix tmH2Tc3p ;
			double[] tmH2Tj[], tmH2Tc = new double[16] ;
			chartacaeli.gpu.tst.Plane spTc3p ;
			P4Projector projj ;
			chartacaeli.gpu.tst.P4Projector projc ;
			Class<?> projcls ;
			Constructor<?> projctr ;


			tmM2Pj = tmM2P.getData() ;
			for ( int r=0 ; 3>r ; r++ )
				for ( int c=0 ; 3>c ; c++ )
					tmM2Pc[3*r+c] = tmM2Pj[r][c] ;
			tmM2Pc3p = new chartacaeli.gpu.tst.RealMatrix( tmM2Pc, 3, 3 ) ;

			projj = (P4Projector) Registry.retrieve( P4Projector.class.getName() ) ;
			projcls = Class.forName( "chartacaeli.gpu.tst."+projj.getClass().getSimpleName() ) ;
			projctr = projcls.getConstructor() ;
			projc = (chartacaeli.gpu.tst.P4Projector) projctr.newInstance() ;
			projc.init( projj.lam0(), projj.phi1(), projj.R(), projj.k0() ) ;

			spTc3p = new chartacaeli.gpu.tst.Plane(
					new double[] { popHP1.x, popHP1.y, popHP1.z },
					new double[] { popHP2.x, popHP2.y, popHP2.z },
					new double[] { popHP3.x, popHP3.y, popHP3.z } ) ;

			tmH2Tj = tmH2T.getData() ;
			for ( int r=0 ; 4>r ; r++ )
				for ( int c=0 ; 4>c ; c++ )
					tmH2Tc[4*r+c] = tmH2Tj[r][c] ;
			tmH2Tc3p = new chartacaeli.gpu.tst.RealMatrix( tmH2Tc, 4, 4 ) ;

			for ( int y=0 ; dimt>y ; y++ ) {
				st[1] = y*ups ;

				for ( int x=0 ; dims>x ; x++ ) {
					st[0] = x*ups ;

					tmM2Pc3p.operate( st,  uv ) ;

					projc.inverse( uv, lamphi ) ;

					eq.set( lamphi[0], lamphi[1], lamphi[2] ) ;
					eq.cartesian( l1 ) ;

					spTc3p.intersection( l0, l1, ca ) ;

					tmH2Tc3p.operate( ca, op ) ;

					if ( op[0]>=0 && op[1]>=0 && dimo>op[0] && dimp>op[1] )
						mapping[y*dims+x] = texture[(int) op[1]*dimo+(int) op[0]] ;
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private class PJ2TextureMapperC3p extends Task {

		public PJ2TextureMapperC3p() {
			String libgpu = Configuration.getValue(
					this, CK_LIBGPU, DEFAULT_LIBGPU ) ;
			System.loadLibrary( libgpu ) ;
		}

		public void main( String[] argv ) throws Exception {
			double[] tmM2Pj[], tmM2Pc = new double[9] ;
			double[] tmH2Tj[], tmH2Tc = new double[16] ;
			double[] spTc ;
			P4Projector proj ;
			chartacaeli.gpu.tst.PJ2TextureMapperC3p texMapC3p ;

			tmM2Pj = tmM2P.getData() ;
			for ( int r=0 ; 3>r ; r++ )
				for ( int c=0 ; 3>c ; c++ )
					tmM2Pc[3*r+c] = tmM2Pj[r][c] ;

			tmH2Tj = tmH2T.getData() ;
			for ( int r=0 ; 4>r ; r++ )
				for ( int c=0 ; 4>c ; c++ )
					tmH2Tc[4*r+c] = tmH2Tj[r][c] ;

			spTc = new double[] {
					popHP1.x, popHP1.y, popHP1.z,
					popHP2.x, popHP2.y, popHP2.z,
					popHP3.x, popHP3.y, popHP3.z
			} ;

			proj = (P4Projector) Registry.retrieve( P4Projector.class.getName() ) ;
			texMapC3p = new chartacaeli.gpu.tst.PJ2TextureMapperC3p( proj.getClass().getSimpleName(),
					new double[] { proj.lam0(), proj.phi1(), proj.R(), proj.k0() },
					tmM2Pc, tmH2Tc, spTc, ups, dimo, dimp, dims, dimt ) ;
			texMapC3p.c3pFor( texture, mapping ) ;
		}
	}

	@SuppressWarnings("unused")
	private class PJ2TextureMapperSmp extends Task {

		public PJ2TextureMapperSmp() {
		}

		public void main( String[] argv ) throws Exception {
			parallelFor( 0, dims*dimt-1 ).exec( new Loop() {

				private chartacaeli.Coordinate eq ;
				private Coordinate uv ;

				private double[] st ;
				private double[] ca ;

				public void start() {
					eq = new chartacaeli.Coordinate( 0, 0, 0 ) ;
					uv = new Coordinate() ;

					st = new double[] { 0, 0, 1 } ;
					ca = new double[] { 0, 0, 0, 1 } ;
				}

				public void run ( int i ) {
					double t0[], op[] ;
					Coordinate t1 ;
					Vector3D vca, xca ;
					int x, y ;

					x = i%dims ;
					y = i%dimt ;

					st[0] = x*ups ;
					st[1] = y*ups ;

					t0 = tmM2P.operate( st ) ;
					uv.x = t0[0] ;
					uv.y = t0[1] ;

					eq.setCoordinate( projector.project( uv, true ) ) ;
					t1 = eq.cartesian() ;

					vca = new Vector3D( t1.x, t1.y, t1.z ) ;
					xca = spT.intersection( new Line( Vector3D.ZERO, vca, 1.0e-10 ) ) ;
					ca[0] = xca.getX() ;
					ca[1] = xca.getY() ;
					ca[2] = xca.getZ() ;

					op = tmH2T.operate( ca ) ;

					if ( op[0]>=0 && op[1]>=0 && dimo>op[0] && dimp>op[1] )
						mapping[y*dims+x] = texture[(int) op[1]*dimo+(int) op[0]] ;
				}
			} ) ;
		}
	}

	public Artwork( Projector projector ) {
		this.projector = projector ;
	}

	public void load() {
		chartacaeli.Coordinate c ;

		// poppers of heaven
		c = new chartacaeli.Coordinate( valueOf( getPopper( 0 ).getPosition() ) ) ;
		popHP1 = c.cartesian() ;
		c.setCoordinate( valueOf( getPopper( 1 ).getPosition() ) );
		popHP2 = c.cartesian() ;
		c.setCoordinate( valueOf( getPopper( 2 ).getPosition() ) );
		popHP3 = c.cartesian() ;

		// poppers of texture
		popTP1 = valueOf( getPopper( 0 ).getCartesian() ) ;
		popTP2 = valueOf( getPopper( 1 ).getCartesian() ) ;
		popTP3 = valueOf( getPopper( 2 ).getCartesian() ) ;
	}

	public boolean init() {
		BufferedImage image ;
		Coordinate cHZ ;
		RealMatrix bmH, bmT ;	// base matrices for heaven and texture
		RealMatrix bmP, bmM ;	// base matrices for projection and mapping
		double dpi, psu ;		// dots per inch, dots per unit
		String bgv[] ;
		int bgr, bgg, bgb, bg ;

		try {
			image = ImageIO.read( reader() ) ;

			dimo = image.getWidth() ;
			dimp = image.getHeight() ;
			maxo = dimo-1 ;
			maxp = dimp-1 ;
			texture = new int[dimo*dimp] ;

			// assuming TYPE_4BYTE_ABGR
			for ( int p=0 ; dimp>p ; p++ )
				for ( int o=0 ; dimo>o ; o++ )
					texture[p*dimo+o] = image.getRGB( o, p ) ;

		} catch ( URISyntaxException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( MalformedURLException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( IOException e ) {
			throw new RuntimeException( e.toString() ) ;
		}

		spT = new Plane(
				new Vector3D( popHP1.x, popHP1.y, popHP1.z ),
				new Vector3D( popHP2.x, popHP2.y, popHP2.z ),
				new Vector3D( popHP3.x, popHP3.y, popHP3.z ), 1.0e-10
				) ;

		// base matrix of heaven
		cHZ = calcZ( popHP1, popHP2, popHP3 ) ;
		bmH = MatrixUtils.createRealMatrix( new double[][] {
				{ popHP1.x, popHP1.y, popHP1.z, 1 },
				{ popHP2.x, popHP2.y, popHP2.z, 1 },
				{ popHP3.x, popHP3.y, popHP3.z, 1 },
				{ cHZ.x, cHZ.y, cHZ.z, 1 }
		} )
		.transpose() ;

		// base matrix of texture
		bmT = MatrixUtils.createRealMatrix( new double[][] {
				{ popTP1.x, popTP1.y, 0, 1 },
				{ popTP2.x, popTP2.y, 0, 1 },
				{ popTP3.x, popTP3.y, 0, 1 },
				{ 0, 0, 1, 1 }
		} )
		.transpose() ;

		// transformation matrix texture to heaven
		tmT2H = bmH.multiply( new LUDecomposition( bmT ).getSolver().getInverse() ) ;
		// transformation matrix heaven to texture
		tmH2T = new LUDecomposition( tmT2H ).getSolver().getInverse() ;

		// dimensions of texture mapping
		cBBT = calcBBT() ;
		if ( cBBT == null )
			return initialized = false ;
		maxs = cBBT[0].distance( cBBT[1] ) ;
		maxt = cBBT[0].distance( cBBT[3] ) ;
		psu = Configuration.getValue( this, CK_PSUNIT, DEFAULT_PSUNIT ) ;	// ps dots per app unit
		dpi = Configuration.getValue( this, CK_DPI, DEFAULT_DPI) ;			// dots per inch
		ups = 72/( psu*dpi ) ;												// app units per ps dot
		dims = (int) ( maxs/ups+1 ) ;
		dimt = (int) ( maxt/ups+1 ) ;
		mapping = new int[dims*dimt] ;

		bgv = Configuration.getValue( this, CK_BACKGROUND, DEFAULT_BACKGROUND )
				.split( "," )[0].split( ":" ) ;
		bgr = (int) ( Double.parseDouble( bgv[0] )*255 )&0xff ;
		bgg = (int) ( Double.parseDouble( bgv[1] )*255 )&0xff ;
		bgb = (int) ( Double.parseDouble( bgv[2] )*255 )&0xff ;
		bg = bgr<<16|bgg<<8|bgb ;

		for ( int t=0 ; dimt>t ; t++ )
			for ( int s=0 ; dims>s ; s++ )
				mapping[t*dims+s] = bg ;

		// base matrix of texture projection
		bmP = MatrixUtils.createRealMatrix( new double[][] {
				{ cBBT[1].x, cBBT[1].y, 1 },
				{ cBBT[3].x, cBBT[3].y, 1 },
				{ cBBT[0].x, cBBT[0].y, 1 }
		} )
		.transpose() ;

		// base matrix of texture mapping
		bmM = MatrixUtils.createRealMatrix( new double[][] {
				{ maxs, 0, 1 },
				{ 0, maxt, 1 },
				{ 0, 0, 1 }
		} )
		.transpose() ;

		// transformation matrix texture mapping to projection
		tmM2P = bmP.multiply( new LUDecomposition( bmM ).getSolver().getInverse() ) ;

		return initialized = true ;
	}

	@Override
	public void headPS( ApplicationPostscriptStream ps ) {
		if ( ! initialized )
			return ;
	}

	@Override
	public void emitPS( ApplicationPostscriptStream ps ) {
		PostscriptEmitter psimage ;
		Vector2D A, B, R ;
		double r ;

		if ( ! initialized )
			return ;

		try {
			parallelTask() ;
		} catch ( Exception e ) {
			throw new RuntimeException( e.toString() ) ;
		}

		A = new Vector2D( cBBT[0].x, cBBT[0].y ) ;
		B = new Vector2D( cBBT[1].x, cBBT[1].y ) ;
		R = B.subtract( A ) ;
		r = Math.atan2( R.getY(), R.getX() ) ;

		ps.op( "gsave" ) ;

		ps.array( true ) ;
		for ( Coordinate xy : got.getCoordinates() ) {
			ps.push( xy.x ) ;
			ps.push( xy.y ) ;
		}
		ps.array( false ) ;

		ps.op( "newpath" ) ;
		ps.op( "gdraw" ) ;
		ps.op( "clip" ) ;

		ps.push( cBBT[0].x ) ;
		ps.push( cBBT[0].y ) ;
		ps.op( "translate" ) ;
		ps.push( r ) ;
		ps.op( "rotate" ) ;

		if ( Configuration.getValue( this, CK_IMAGEOP, DEFAULT_IMAGEOP ) ) {
			psimage = new ImageOperator( mapping, dims, dimt ) ;

			ps.push( maxs ) ;
			ps.push( maxt ) ;
		} else {
			psimage = new ImageDiscrete( mapping, dims, dimt ) ;

			ps.push( ups ) ;
			ps.push( ups ) ;
		}
		ps.op( "scale" ) ;

		psimage.headPS( ps ) ;
		psimage.emitPS( ps ) ;
		psimage.tailPS( ps ) ;			

		ps.op( "grestore" ) ;

		if ( verbose ) {
			linePS( ps, cOPT, 1, 0, 0 ) ; // outline projection of texture
			linePS( ps, new Coordinate[] { new Coordinate( 10, 10 ), cOPT[0] }, 1, 0, 0  ) ; // P1, Pi, Pj
			linePS( ps, new Coordinate[] { new Coordinate( 10, 10 ), cOPT[(int) (cOPT.length*.333 )] }, 0, 1, 0  ) ;
			linePS( ps, new Coordinate[] { new Coordinate( 10, 10 ), cOPT[(int) (cOPT.length*.666 )] }, 0, 0, 1  ) ;
			linePS( ps, cBBT, 0, 1, 0 ) ; // bounding box of outline
			linePS( ps, new Coordinate[] { new Coordinate( 0, 0 ), cBBT[0] }, 1, 0, 0  ) ; // P1, P2, P3
			linePS( ps, new Coordinate[] { new Coordinate( 0, 0 ), cBBT[1] }, 0, 1, 0  ) ;
			linePS( ps, new Coordinate[] { new Coordinate( 0, 0 ), cBBT[2] }, 0, 0, 1  ) ;
		}
	}

	private void parallelTask() throws Exception {
		String classconf ;
		Class<?> classtask ;
		Constructor<?> thisctor ;
		Task taskinst ;

		classconf = Configuration.getValue( this, CK_PJ2CLASS, DEFAULT_PJ2CLASS ) ;
		classtask = Class.forName( classconf ) ;

		if ( Task.class.isAssignableFrom( classtask ) ) {
			thisctor = classtask.getDeclaredConstructor( Artwork.class ) ;
			taskinst = (Task) thisctor.newInstance( this ) ;
		} else
			throw new ParameterNotValidException() ;

		long t0 = System.currentTimeMillis() ;
		taskinst.main( null ) ;
		long t1 = System.currentTimeMillis() ;
		log.info( classconf+" took "+( t1-t0 )+" msec" ) ;
	}

	@Override
	public void tailPS( ApplicationPostscriptStream ps ) {
		if ( ! initialized )
			return ;
	}

	public static boolean verbose() {
		boolean config = Configuration.getValue( Artwork.class, ChartaCaeli.CK_VERBOSE, ChartaCaeli.DEFAULT_VERBOSE ) ;

		if ( config )
			return ! ( verbose = ! verbose ) ;
		return config ;
	}

	private InputStream reader() throws URISyntaxException, MalformedURLException {
		URI uri ;
		URL url ;
		File file ;
		InputStream in ;
		GZIPInputStream gz ;

		uri = new URI( getUrl() ) ;
		if ( uri.isAbsolute() ) {
			file = new File( uri ) ;	
		} else {
			file = new File( uri.getPath() ) ;
		}
		url = file.toURI().toURL() ;

		try {
			in = url.openStream() ;

			gz = new GZIPInputStream( in ) ;
			return new BufferedInputStream( gz ) ;
		} catch ( IOException egz ) {
			try {
				in = url.openStream() ;

				return new BufferedInputStream( in ) ;
			} catch ( IOException ein ) {
				throw new RuntimeException ( egz.toString() ) ;
			}
		}
	}

	// calculate vector perpendicular to plane spanned by c1, c2 and c3
	private Coordinate calcZ( Coordinate c1, Coordinate c2, Coordinate c3 ) {
		Vector v0, va, vb, vz ;

		v0 = new Vector( c1 ) ;
		va = new Vector( c2 ).sub( v0 ) ;
		vb = new Vector( c3 ).sub( v0 ) ;
		vz = v0.add( new Vector( va ).cross( vb ) ) ;

		return vz ;
	}

	// calculate bounding box of texture projection, take FOV into account
	private Coordinate[] calcBBT() {
		Coordinate[] cBB ;
		Geometry t0, gBB, fov ;
		double minsection ;

		cOPT = projT() ;
		cBB = new MinimumDiameter( new GeometryFactory().createLinearRing( cOPT ) )
		.getMinimumRectangle()
		.getCoordinates() ;
		gBB = new GeometryFactory().createPolygon( cBB ) ;

		fov = ChartType.findFieldOfView() ;
		if ( fov != null && ! fov.intersects( gBB ) )
			return null ;
		if ( fov == null || fov.contains( gBB ) )
			got = gBB ;
		else {
			got = fov.intersection( gBB ) ;

			minsection = Configuration.getValue( this, CK_MINVISIBLE, DEFAULT_MINVISIBLE )/100 ;
			t0 = new GeometryFactory().createPolygon( cOPT ) ;
			if ( minsection>got.getArea()/t0.getArea() )
				return null ;

			cBB = new MinimumDiameter( new GeometryFactory().createLinearRing( got.getCoordinates() ) )
			.getMinimumRectangle()
			.getCoordinates() ;
		}

		return cBB ;
	}

	// project texture outline on chart page
	private Coordinate[] projT() {
		java.util.Vector<Coordinate> outline = new java.util.Vector<Coordinate>() ;
		double c[], m, n ;
		Vector v0, v1, v2, va, vb ;
		int interval, stepping ;

		interval = Configuration.getValue( this, CK_INTERVAL, DEFAULT_INTERVAL ) ;

		// check if projection of edge AB is bend:
		// 1. divide image edge arbitrarily in two halves
		// 2. project three resulting position vectors
		// 3. calculate differences between 2nd and 1st as well as 3rd and 2nd
		// 4. check if dot product (almost) equals product of vector magnitudes
		c = tmT2H.operate( new double[] { 0, 0, 0, 1 } ) ;
		v0 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		c = tmT2H.operate( new double[] { maxo/2, 0, 0, 1 } ) ;
		v1 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		c = tmT2H.operate( new double[] { maxo, 0, 0, 1 } ) ;
		v2 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;

		va = new Vector( v1 ).sub( v0 ) ;
		vb = new Vector( v2 ).sub( v1 ) ;

		m = new Vector( va ).dot( vb ) ;
		n = va.abs()*vb.abs() ;

		stepping = interval ;
		if ( (int) m-(int) n == 0 )
			stepping = maxo ;

		outline.add( v0 ) ;
		for ( int o=stepping ; maxo-1>o ; o+=stepping ) {
			c = tmT2H.operate( new double[] { o, 0, 0, 1 } ) ;
			outline.add( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		}

		// edge BC
		c = tmT2H.operate( new double[] { maxo, 0, 0, 1 } ) ;
		v0 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		c = tmT2H.operate( new double[] { maxo, maxp/2, 0, 1 } ) ;
		v1 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		c = tmT2H.operate( new double[] { maxo, maxp, 0, 1 } ) ;
		v2 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;

		va = new Vector( v1 ).sub( v0 ) ;
		vb = new Vector( v2 ).sub( v1 ) ;

		m = new Vector( va ).dot( vb ) ;
		n = va.abs()*vb.abs() ;

		stepping = interval ;
		if ( (int) m-(int) n == 0 )
			stepping = maxp ;

		outline.add( v0 ) ;
		for ( int p=stepping ; maxp-1>p ; p+=stepping ) {
			c = tmT2H.operate( new double[] { maxo, p, 0, 1 } ) ;
			outline.add( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		}

		// edge CD
		c = tmT2H.operate( new double[] { maxo, maxp, 0, 1 } ) ;
		v0 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		c = tmT2H.operate( new double[] { maxo/2, maxp, 0, 1 } ) ;
		v1 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		c = tmT2H.operate( new double[] { 0, maxp, 0, 1 } ) ;
		v2 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;

		va = new Vector( v1 ).sub( v0 ) ;
		vb = new Vector( v2 ).sub( v1 ) ;

		m = new Vector( va ).dot( vb ) ;
		n = va.abs()*vb.abs() ;

		stepping = interval ;
		if ( (int) m-(int) n == 0 )
			stepping = maxo ;

		outline.add( v0 ) ;
		for ( int o=maxo-stepping ; o+1>stepping ; o-=stepping ) {
			c = tmT2H.operate( new double[] { o, maxp, 0, 1 } ) ;
			outline.add( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		}

		// edge DA
		c = tmT2H.operate( new double[] { 0, maxp, 0, 1 } ) ;
		v0 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		c = tmT2H.operate( new double[] { 0, maxp/2, 0, 1 } ) ;
		v1 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		c = tmT2H.operate( new double[] { 0, 0, 0, 1 } ) ;
		v2 = new Vector( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;

		va = new Vector( v1 ).sub( v0 ) ;
		vb = new Vector( v2 ).sub( v1 ) ;

		m = new Vector( va ).dot( vb ) ;
		n = va.abs()*vb.abs() ;

		stepping = interval ;
		if ( (int) m-(int) n == 0 )
			stepping = maxp ;

		outline.add( v0 ) ;
		for ( int p=maxp-stepping ; p+1>stepping ; p-=stepping ) {
			c = tmT2H.operate( new double[] { 0, p, 0, 1 } ) ;
			outline.add( projector.project( new chartacaeli.Coordinate( c[0], c[1], c[2] ).spherical(), false ) ) ;
		}

		// close geometry in terms of JTS
		outline.add( outline.firstElement() ) ;

		return outline.toArray( new Coordinate[0] ) ;
	}

	private void linePS( ApplicationPostscriptStream ps, Coordinate[] list, double gray ) {
		ps.push( gray ); ;
		ps.op( "setgray" );

		linePS( ps, list ) ;
	}

	private void linePS( ApplicationPostscriptStream ps, Coordinate[] list, double r, double g, double b ) {
		ps.push( r ) ;
		ps.push( g ) ;
		ps.push( b ) ;
		ps.op( "setrgbcolor" ) ;

		linePS( ps, list ) ;
	}

	private void linePS( ApplicationPostscriptStream ps, Coordinate[] list ) {
		ps.array( true ) ;
		for ( Coordinate c : list ) {
			ps.push( c.x ) ;
			ps.push( c.y ) ;
		}
		ps.array( false ) ;

		ps.op( "newpath" ) ;
		ps.op( "gdraw" ) ;

		ps.op( "stroke" ) ;
	}
}
