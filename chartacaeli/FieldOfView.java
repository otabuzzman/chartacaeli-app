
package chartacaeli;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.io.WKTReader;

public class FieldOfView implements PostscriptEmitter {

	// configuration key (CK_)
	private final static String CK_VIEWER		= "viewer" ;
	private final static String CK_PRECISION	= "precision" ;

	private final static int DEFAULT_PRECISION	= 2 ;

	// message key (MK_)
	private final static String MK_EUPDATE		= "eupdate" ;
	private final static String MK_ENUMINT		= "enumint" ;
	private final static String MK_UPDATE		= "update" ;

	private final static int FOV_TYPE_NUM		= 4 ;

	public final static int FOV_TYPE_NUL		= 0 ;
	public final static int FOV_TYPE_LIN		= 1 ;
	public final static int FOV_TYPE_RNG		= 2 ;
	public final static int FOV_TYPE_RIN		= 3 ;

	private CoordinateList clist ;
	private int type ;

	private int precision ;

	private final static Log log = LogFactory.getLog( FieldOfView.class ) ;

	public FieldOfView() {
		int exponent ;

		clist = new CoordinateList() ;
		type = FOV_TYPE_NUL ;

		exponent = Configuration.getValue( this, CK_PRECISION, DEFAULT_PRECISION ) ;
		precision = (int) java.lang.Math.pow( 10, exponent ) ;
	}

	public FieldOfView( Coordinate[] c ) throws ParameterNotValidException {
		this() ;

		update( c ) ;
	}

	public FieldOfView( FieldOfView fov ) throws ParameterNotValidException {
		this() ;

		update( fov.toCoordinateArray() ) ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		if ( clist.size() == 0 )
			return ;

		ps.array( true ) ;
		for ( Coordinate xy : clist.toCoordinateArray() ) {
			ps.push( xy.x ) ;
			ps.push( xy.y ) ;
		}
		ps.array( false ) ;

		ps.op( "newpath" ) ;
		ps.op( "gdraw" ) ;

		ps.op( "stroke" ) ;
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
	}

	public void update( Coordinate[] c ) throws ParameterNotValidException {
		update( c, false ) ;
	}

	public void update( FieldOfView fov ) throws ParameterNotValidException {
		update( fov.toCoordinateArray(), false ) ;
	}

	@SuppressWarnings("unchecked")
	public void update( Coordinate[] c, boolean usealtfov ) throws ParameterNotValidException {
		CoordinateList clist ;
		int type, caze ;

		if ( c == null || c.length == 1 )
			throw new ParameterNotValidException( MessageCatalog.compose( this, MK_EUPDATE,
					new Object[] { Arrays.toString( this.clist.toArray() ), Arrays.toString( c ) } ) ) ;

		clist = new CoordinateList() ;
		clist.add( c, false ) ;

		type = getType( clist, precision ) ;
		caze = this.type*FOV_TYPE_NUM+type ;

		log.info( MessageCatalog.compose( this, MK_UPDATE, new Object[] { caze } ) ) ;

		switch ( caze ) {
		case 1: // update A0 with Bo
		case 2: // update A0 with Bc
		case 3: // update A0 with Bci
			this.clist.addAll( clist ) ;

			break ;
		case 5: // update Ao with Bo
			updateC5( c, usealtfov ) ;

			break ;
		case 6: // update Ao with Bc
			updateC6( c, usealtfov ) ;

			break ;
		case 7: // update Ao with Bci
			clist.closeRing() ;
			updateC6( clist.toCoordinateArray(), usealtfov ) ;

			break ;
		case 9: // update Ac with Bo
			updateC9( c, usealtfov ) ;

			break ;
		case 10: // update Ac with Bc
			updateC10( c, usealtfov ) ;

			break ;
		case 11: // update Ac with Bci
			clist.closeRing() ;
			updateC10( clist.toCoordinateArray(), usealtfov ) ;

			break ;
		case 0: // update A0 with B0
		case 4: // update Ao with B0
		case 8: // update Ac with B0
		case 12: // update (an unlikely) Aci with B0
		case 13: // update (an unlikely) Aci with Bo
		case 14: // update (an unlikely) Aci with Bc
		case 15: // update (an unlikely) Aci with Bci
		default:
			log.warn( MessageCatalog.compose( this, MK_EUPDATE, new Object[] { Arrays.toString( this.clist.toArray() ), Arrays.toString( c ) } ) ) ;

			return ;
		}

		this.type = getType() ;
		if ( this.type == FOV_TYPE_RIN ) {
			this.clist.closeRing() ;
			this.type = FOV_TYPE_RNG ;
		}
	}

	private void updateC5( Coordinate[] c, boolean usealtfov ) {
		Geometry A, B, X, D ;
		LineString A0, A1, B0, B1 ;
		Geometry AR, BR ;
		int numint ;
		double lenA0, lenA1 ;
		double lenB0, lenB1 ;
		Coordinate[] cAX, cBX ;
		boolean dir ;

		A = new GeometryFactory().createLineString( clist.toCoordinateArray() ) ;
		B = new GeometryFactory().createLineString( c ) ;
		X = A.intersection( B ) ;

		numint = X.getNumPoints() ;
		if ( numint == 0 || numint>2 ) {
			log.warn( MessageCatalog.compose( this, MK_ENUMINT, new Object[] { numint } ) ) ;

			return ;
		}

		D = A.symDifference( B ) ;

		if ( numint == 1 ) {
			A0 = new GeometryFactory().createLineString( D.getGeometryN( 0 ).getCoordinates() ) ;
			lenA0 = A0.getLength() ;
			A1 = new GeometryFactory().createLineString( D.getGeometryN( 1 ).getCoordinates() ) ;
			lenA1 = A1.getLength() ;
			B0 = new GeometryFactory().createLineString( D.getGeometryN( 2 ).getCoordinates() ) ;
			lenB0 = B0.getLength() ;
			B1 = new GeometryFactory().createLineString( D.getGeometryN( 3 ).getCoordinates() ) ;
			lenB1 = B1.getLength() ;

			if ( usealtfov ) { // shortest path
				AR = lenA0>lenA1 ? A1 : A0 ;
				BR = lenB0>lenB1 ? B1 : B0 ;
			} else { // longest path
				AR = lenA0>lenA1 ? A0 : A1 ;
				BR = lenB0>lenB1 ? B0 : B1 ;
			}
		} else { // numint == 2
			AR = D.getGeometryN( 1 ) ;
			BR = D.getGeometryN( 4 ) ;
		}

		cAX = AR.getCoordinates() ;
		cBX = BR.getCoordinates() ;
		dir = cAX[cAX.length-1].equals( cBX[0] ) ;

		clist.clear() ;
		clist.add( cAX, false ) ;
		clist.add( cBX, false, dir ) ;
	}

	private void updateC6( Coordinate[] c, boolean usealtfov ) {
		Geometry A, B, X, D ;
		Geometry T, R0, R1, R ;
		Coordinate[] cA1, cB1, cB02 ;
		Coordinate[] cX0, cX1 ;
		CoordinateList clistB02 ;
		CoordinateList clistX0, clistX1 ;
		int numint ;
		boolean dir ;
		double areaR0, areaR1 ;

		A = new GeometryFactory().createLineString( clist.toCoordinateArray() ) ;
		B = new GeometryFactory().createLineString( c ) ;
		X = A.intersection( B ) ;

		numint = X.getNumPoints() ;
		if ( numint != 2 ) {
			log.warn( MessageCatalog.compose( this, MK_ENUMINT, new Object[] { numint } ) ) ;

			return ;
		}

		D = A.symDifference( B ) ;

		cA1 = D.getGeometryN( 1 ).getCoordinates() ;
		cB1 = D.getGeometryN( 4 ).getCoordinates() ;
		dir = cA1[cA1.length-1].equals( cB1[0] ) ;
		clistX0 = new CoordinateList() ;
		clistX0.add( cA1, false ) ;
		clistX0.add( cB1, false, dir ) ;

		clistB02 = new CoordinateList() ;
		clistB02.add( D.getGeometryN( 5 ).getCoordinates(), false ) ;
		clistB02.add( D.getGeometryN( 3 ).getCoordinates(), false ) ;
		cB02 = clistB02.toCoordinateArray() ;
		dir = cA1[cA1.length-1].equals( cB02[0] ) ;
		clistX1 = new CoordinateList() ;
		clistX1.add( cA1, false ) ;
		clistX1.add( cB02, false, dir ) ;

		cX0 = clistX0.toCoordinateArray() ;
		R0 = new GeometryFactory().createLinearRing( cX0 ) ;
		T = new GeometryFactory().createPolygon( cX0 ) ;
		areaR0 = T.getArea() ;
		cX1 = clistX1.toCoordinateArray() ;
		R1 = new GeometryFactory().createLinearRing( cX1 ) ;
		T = new GeometryFactory().createPolygon( cX1 ) ;
		areaR1 = T.getArea() ;

		if ( usealtfov ) { // smaller area
			R = areaR0>areaR1 ? R1 : R0 ;
		} else { // bigger area
			R = areaR0>areaR1 ? R0 : R1 ;
		}

		clist.clear() ;
		clist.add( R.getCoordinates(), true ) ;
	}

	private void updateC9( Coordinate[] c, boolean usealtfov ) {
		Geometry A, B, X ;
		int numint ;
		Coordinate[] mem ;

		A = new GeometryFactory().createLineString( clist.toCoordinateArray() ) ;
		B = new GeometryFactory().createLineString( c ) ;

		X = A.intersection( B ) ;

		numint = X.getNumPoints() ;
		if ( numint != 2 ) {
			log.warn( MessageCatalog.compose( this, MK_ENUMINT, new Object[] { numint } ) ) ;

			return ;
		}

		mem = clist.toCoordinateArray() ;
		clist.clear() ;
		clist.add( c, false ) ;

		updateC6( mem, usealtfov ) ;
	}

	private void updateC10( Coordinate[] c, boolean usealtfov ) {
		Geometry A, B, X ;

		A = new GeometryFactory().createPolygon( clist.toCoordinateArray() ) ;
		B = new GeometryFactory().createPolygon( c ) ;

		X = A.intersection( B ) ;

		if ( X.isEmpty() ) {
			log.warn( MessageCatalog.compose( this, MK_ENUMINT, new Object[] { 0 } ) ) ;

			return ;
		}

		clist.clear() ;
		if ( B.contains( A ) )
			clist.add( c, false ) ;
		else
			clist.add( X.getCoordinates(), false ) ;
	}

	public int getType() {
		return getType( clist, precision ) ;
	}

	private static int getType( CoordinateList clist, int precision ) {
		if ( clist.isEmpty() )
			return FOV_TYPE_NUL ;
		else if ( clist.isClosed() )
			return FOV_TYPE_RNG ;
		else if ( CoordinateList.isCloseIntended( clist, precision ) )
			return FOV_TYPE_RIN ;
		else
			return FOV_TYPE_LIN ;
	}

	public Coordinate[] toCoordinateArray() {
		return clist.toCoordinateArray() ;
	}

	public static Geometry createEOVGeometry() {
		FieldOfView gov, cov, eov = null ; // global, combined and effective field of view
		String govRegistryKey, covRegistryKey ;
		Geometry eovG = null ;

		govRegistryKey = "G"+FieldOfView.class.getName() ;
		gov = (FieldOfView) Registry.retrieve( govRegistryKey ) ;

		covRegistryKey = "C"+FieldOfView.class.getName() ;
		cov = (FieldOfView) Registry.retrieve( covRegistryKey ) ;

		try {
			if ( gov != null ) {
				eov = new FieldOfView( gov ) ;
				if ( cov != null )
					eov.update( cov ) ;
			} else {
				if ( cov != null )
					eov = new FieldOfView( cov ) ;
			}

			if ( eov != null )
				eovG = new GeometryFactory().createPolygon( eov.toCoordinateArray() ) ;
		} catch ( ParameterNotValidException e ) {
			log.warn( e.getMessage() ) ;
		}

		return eovG ;
	}

	public static void main( String[] argv ) {
		ApplicationPostscriptStream ps ;
		Configuration conf ;
		String viewerDecl ;
		Process viewerProc ;
		TeeOutputStream out ;
		boolean usealtfov ;
		WKTReader reader ;
		Geometry A, B ;
		FieldOfView fov  ;
		String typeA, typeB, msg ;
		Coordinate[] cA, cB ;
		CoordinateList clistA, clistB ;
		int numint, precision ;

		conf = new Configuration( FieldOfView.class ) ;
		viewerDecl = conf.getValue( CK_VIEWER, null ) ;
		out =  new TeeOutputStream( System.out ) ;

		if ( viewerDecl == null ) {
			viewerProc = null ;
		} else {
			try {
				viewerProc = Runtime.getRuntime().exec( viewerDecl.trim().split( "\\p{Space}+" ) ) ;

				viewerProc.getInputStream().close() ;
				viewerProc.getErrorStream().close() ;

				out.add( viewerProc.getOutputStream() ) ;
			} catch ( IOException e ) {
				viewerDecl = null ;
				viewerProc = null ;
			}
		}

		ps = new ApplicationPostscriptStream( out ) ;
		ps.emitDSCHeader() ;
		ps.emitDSCProlog() ;

		try {
			reader = new WKTReader() ;

			for ( int i=0 ; argv.length>i ; i++ ) {
				usealtfov = argv[i].equals( "usealtfov" ) ;

				if ( usealtfov ) {
					A = reader.read( argv[++i] ) ;
					B = reader.read( argv[++i] ) ;
				} else {
					A = reader.read( argv[i] ) ;
					B = reader.read( argv[++i] ) ;
				}


				// init A
				fov = new FieldOfView( A.getCoordinates() ) ;

				cA = A.getCoordinates() ;
				clistA = new CoordinateList( cA, false ) ;
				precision = conf.getValue( CK_PRECISION, DEFAULT_PRECISION ) ;

				switch ( FieldOfView.getType( clistA, precision ) ) {
				case FieldOfView.FOV_TYPE_NUL:
					typeA = "A0" ;

					break ;
				case FieldOfView.FOV_TYPE_LIN:
					typeA = "Ao" ;

					break ;
				case FieldOfView.FOV_TYPE_RNG:
					typeA = "Ac" ;

					break ;
				case FieldOfView.FOV_TYPE_RIN:
				default:
					typeA = "Aci" ;

					break ;
				}

				cB = B.getCoordinates() ;
				clistB = new CoordinateList( cB, false ) ;

				switch ( FieldOfView.getType( clistB, precision ) ) {
				case FieldOfView.FOV_TYPE_NUL:
					typeB = "B0" ;

					break ;
				case FieldOfView.FOV_TYPE_LIN:
					typeB = "Bo" ;

					break ;
				case FieldOfView.FOV_TYPE_RNG:
					typeB = "Bc" ;

					break ;
				case FieldOfView.FOV_TYPE_RIN:
				default:
					typeB = "Bci" ;

					break ;
				}

				numint = A.intersection( B ).getNumPoints() ;

				// update B
				fov.update( cB, usealtfov ? true : false ) ;

				ps.push( 1.2 ) ;
				ps.op( "setlinewidth" ) ;

				ps.script( "/Helvetica" ) ;
				ps.op( "findfont" ) ;
				ps.push( 12 ) ;
				ps.op( "scalefont" ) ;
				ps.op( "setfont" ) ;

				// output field of view
				ps.op( "gsave" ) ;
				ps.push( 6 ) ;
				ps.op( "setlinewidth" ) ;
				ps.push( .72 ) ;
				ps.op( "setgray" ) ;
				fov.headPS( ps ) ;
				fov.emitPS( ps ) ;
				fov.tailPS( ps ) ;
				ps.op( "grestore" ) ;

				// output A
				if ( A.getNumPoints()>0 ) {
					ps.op( "gsave" ) ;
					ps.push( 2 ) ;
					ps.op( "setlinewidth" ) ;
					ps.push( 0 ) ;
					ps.push( 0 ) ;
					ps.push( 1 ) ;
					ps.op( "setrgbcolor" ) ;
					ps.array( true ) ;
					for ( Coordinate xy : A.getCoordinates() ) {
						ps.push( xy.x ) ;
						ps.push( xy.y ) ;
					}
					ps.array( false ) ;

					ps.op( "newpath" ) ;
					ps.op( "gdraw" ) ;

					ps.op( "stroke" ) ;

					// legend
					ps.push( -200 ) ;
					ps.push( 200 ) ;
					ps.op( "moveto" ) ;
					ps.script( String.format( "(%s : %s)", typeA, A.toText() ) ) ;
					ps.op( "show" ) ;

					ps.op( "grestore" ) ;
				}

				// output B
				if ( B.getNumPoints()>0 ) {
					ps.op( "gsave" ) ;
					ps.push( 1.2 ) ;
					ps.op( "setlinewidth" ) ;
					ps.push( 1 ) ;
					ps.push( 0 ) ;
					ps.push( 0 ) ;
					ps.op( "setrgbcolor" ) ;
					ps.array( true ) ;
					for ( Coordinate xy : B.getCoordinates() ) {
						ps.push( xy.x ) ;
						ps.push( xy.y ) ;
					}
					ps.array( false ) ;

					ps.op( "newpath" ) ;
					ps.op( "gdraw" ) ;

					ps.op( "stroke" ) ;

					// legend
					ps.push( -200 ) ;
					ps.push( 188 ) ;
					ps.op( "moveto" ) ;
					ps.script( String.format( "(%s : %s)", typeB, B.toText() ) ) ;
					ps.op( "show" ) ;

					ps.op( "grestore" ) ;
				}

				msg = String.format( "*** updated %s with %s, %d intersection points, usealtfov %s ***",
						typeA, typeB, numint, usealtfov ? "true" : "false" ) ;

				// legend
				ps.push( -200 ) ;
				ps.push( 174 ) ;
				ps.op( "moveto" ) ;
				ps.script( String.format( "(%s)", msg ) ) ;
				ps.op( "show" ) ;

				ps.op( "showpage" ) ;
				ps.dc( "%PageTrailer", null ) ;

				log.info( msg ) ;
			}

			ps.emitDSCTrailer() ;

			ps.flush() ;
			ps.flush() ;
			ps.close() ;

			if ( viewerDecl != null )
				viewerProc.waitFor() ;
		} catch ( Exception e ) {
			e.printStackTrace() ;
			System.exit( 1 ) ;
		}
	}
}
