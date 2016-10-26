
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

	private final static double DEFAULT_PSUNIT		= 2.834646 ;
	private final static double DEFAULT_DPI			= 72 ;
	private final static int DEFAULT_INTERVAL		= 1 ;
	private final static boolean DEFAULT_IMAGEOP	= false ;
	private final static double DEFAULT_MINVISIBLE	= 25 ;
	private final static String DEFAULT_BACKGROUND	= "0:0:0,0:0:0" ;
	private final static String DEFAULT_PJ2CLASS	= "chartacaeli.Artwork$PJ2TextureMapperSeq" ;

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

	// constant for cartesian origin
	private Vector3D vO = new Vector3D( 0, 0, 0 ) ;
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

		public PJ2TextureMapperSeq() {
		}

		public void main( String[] argv ) throws Exception {
			chartacaeli.Coordinate eq = new chartacaeli.Coordinate( 0, 0, 0 ) ;
			double s, t, t0[], op[] ;
			Coordinate uv, ca ;
			Vector3D V, X ;

			for ( int y=0 ; dimt>y ; y++ ) {
				t = y*ups ;

				for ( int x=0 ; dims>x ; x++ ) {
					s = x*ups ;

					t0 = tmM2P.operate( new double[] { s, t, 1 } ) ;
					uv = new Coordinate( t0[0], t0[1] ) ;

					eq.setCoordinate( projector.project( uv, true ) ) ;
					ca = eq.cartesian() ;

					V = new Vector3D( ca.x, ca.y, ca.z ) ;
					X = spT.intersection( new Line( vO, V, 1.0e-10 ) ) ;

					op = tmH2T.operate( new double[] { X.getX(), X.getY(), X.getZ(), 1 } ) ;

					if ( op[0]>=0 && op[1]>=0 && dimo>op[0] && dimp>op[1] )
						mapping[y*dims+x] = texture[(int) op[1]*dimo+(int) op[0]] ;
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private class PJ2TextureMapperSmp extends Task {

		public PJ2TextureMapperSmp() {
		}

		public void main( String[] argv ) throws Exception {
			parallelFor( 0, dims*dimt-1 ).exec( new Loop() {
				public void run ( int i ) {
					chartacaeli.Coordinate eq = new chartacaeli.Coordinate( 0, 0, 0 ) ;
					double s, t, t0[], op[] ;
					Coordinate uv, ca ;
					Vector3D V, X ;
					int x, y ;

					x = i%dims ;
					y = i%dimt ;

					s = x*ups ;
					t = y*ups ;

					t0 = tmM2P.operate( new double[] { s, t, 1 } ) ;
					uv = new Coordinate( t0[0], t0[1] ) ;

					eq.setCoordinate( projector.project( uv, true ) ) ;
					ca = eq.cartesian() ;

					V = new Vector3D( ca.x, ca.y, ca.z ) ;
					X = spT.intersection( new Line( vO, V, 1.0e-10 ) ) ;

					op = tmH2T.operate( new double[] { X.getX(), X.getY(), X.getZ(), 1 } ) ;

					if ( op[0]>=0 && op[1]>=0 && dimo>op[0] && dimp>op[1] )
						mapping[y*dims+x] = texture[(int) op[1]*dimo+(int) op[0]] ;
				}
			} );
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
