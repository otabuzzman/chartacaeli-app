
package chartacaeli.gpu.tst;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

import org.junit.Test;

import chartacaeli.caa.CAACoordinateTransformation;

import com.vividsolutions.jts.geom.Coordinate;

public class P4OrthographicTest {

	// dataset forward
	static final double[][] ds_forward = {
		{ 0, 0 },
		//			{ 180, 90 },
		//			{ -180, 90 },
		{ 138.65453503, 9.95533043 },
		{ -46.73806978, 1.44587627 },
		{ -133.35373407, 59.61747595 },
		{ 70.76351978, 88.44017684 },
		{ -160.71417415, 66.95699627 },
		{ 120.32587940, 36.75595763 },
		{ 54.49598998, 5.80344346 },
		{ -176.65442778, 64.14836147 },
	} ;

	// dataset inverse
	static final double[][] ds_inverse = {
		{ 0.000000000000, -1.000000000000 },
		//			{ 0.000000000000, 0.000000000000 },
		//			{ -0.000000000000, 0.000000000000 },
		{ 0.650650871390, 0.739436158304 },
		{ -0.727996421158, -0.685116432082 },
		{ -0.367760643869, 0.347211854910 },
		{ 0.025700868812, -0.008968341670 },
		{ -0.129279180469, 0.369456363705 },
		{ 0.691562607368, 0.404535698114 },
		{ 0.809902442069, -0.577783325190 },
		{ -0.025446591953, 0.435299205605 },
	} ;

	@Test
	public void testForward() {
		chartacaeli.P4Orthographic p4j = new chartacaeli.P4Orthographic() ;
		Coordinate lamphi = new Coordinate(), xyC ;
		P4Orthographic p4c = new P4Orthographic() ;
		double[] xyA = new double[3] ;

		for ( int i=0 ; ds_forward.length>i ; i++ ) {
			lamphi.x = ds_forward[i][0] ;
			lamphi.y = ds_forward[i][1] ;

			// check C3P classes
			p4c.forward( new double[] { lamphi.x, lamphi.y, 0 }, xyA ) ;
			assertEquals( ds_inverse[i][0], xyA[0], .000001 ) ;
			assertEquals( ds_inverse[i][1], xyA[1], .000001 ) ;

			// check Java classes
			xyC = p4j.forward( lamphi ) ;
			assertEquals( ds_inverse[i][0], xyC.x, .000001 ) ;
			assertEquals( ds_inverse[i][1], xyC.y, .000001 ) ;
		}
	}

	@Test
	public void testInverse() {
		chartacaeli.P4Orthographic p4j = new chartacaeli.P4Orthographic() ;
		Coordinate xy = new Coordinate(), lamphiC ;
		P4Orthographic p4c = new P4Orthographic() ;
		double[] lamphiA = new double[3] ;

		for ( int i=0 ; ds_inverse.length>i ; i++ ) {
			xy.x = ds_inverse[i][0] ;
			xy.y = ds_inverse[i][1] ;

			// check C3P classes
			p4c.inverse( new double[] { xy.x, xy.y, 0 }, lamphiA ) ;
			assertEquals(
					CAACoordinateTransformation.MapTo0To360Range( ds_forward[i][0] ),
					CAACoordinateTransformation.MapTo0To360Range( lamphiA[0] ), .000001 ) ;
			assertEquals(
					CAACoordinateTransformation.MapToMinus90To90Range( ds_forward[i][1] ),
					CAACoordinateTransformation.MapToMinus90To90Range( lamphiA[1] ), .000001 ) ;

			// check Java classes
			lamphiC = p4j.inverse( xy ) ;
			assertEquals(
					CAACoordinateTransformation.MapTo0To360Range( ds_forward[i][0] ),
					CAACoordinateTransformation.MapTo0To360Range( lamphiC.x ), .000001 ) ;
			assertEquals(
					CAACoordinateTransformation.MapToMinus90To90Range( ds_forward[i][1] ),
					CAACoordinateTransformation.MapToMinus90To90Range( lamphiC.y ), .000001 ) ;
		}
	}

	public static void main( String[] argv ) {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in ) ) ;
		chartacaeli.P4Orthographic p4 = new chartacaeli.P4Orthographic() ;
		String format, lt, lr, lv[] ;
		int prec ;
		double a, b ;
		Coordinate c ;

		if ( ! ( argv.length==1 || argv.length==2 ) )
			usageAndExit() ;

		if ( argv[0].equals( "list" ) ) {
			System.err.println( "// forward") ;
			for ( double[] e : ds_forward )
				System.out.printf( Locale.ROOT, "%f %f%n", e[0], e[1] ) ;
			System.err.println( "// inverse") ;
			for ( double[] e : ds_inverse )
				System.out.printf( Locale.ROOT, "%f %f%n", e[0], e[1] ) ;
			System.exit( 0 ) ;
		}

		prec = Integer.parseInt( argv[1] ) ;
		format = String.format( "%%.%df %%.%df%%n", prec, prec ) ;

		try {
			if ( argv[0].equals( "forward" ) ) {
				while ( ( lr = in.readLine() ) != null && lr.length()>0 ) {
					lt = lr.trim() ;
					if ( lt.startsWith( "//" ) )
						continue ;
					lv = lt.split( "\\p{Space}+" ) ;
					a = Double.parseDouble( lv[0] ) ;
					b = Double.parseDouble( lv[1] ) ;
					c = p4.forward( new Coordinate( a, b ) ) ;
					System.out.printf( Locale.ROOT, format, c.x, c.y ) ;
				}
			} else if ( argv[0].equals( "inverse" ) ) {
				while ( ( lr = in.readLine() ) != null && lr.length()>0 ) {
					lt = lr.trim() ;
					if ( lt.startsWith( "//" ) )
						continue ;
					lv = lt.split( "\\p{Space}+" ) ;
					a = Double.parseDouble( lv[0] ) ;
					b = Double.parseDouble( lv[1] ) ;
					c = p4.inverse( new Coordinate( a, b ) ) ;
					System.out.printf( Locale.ROOT, format, c.x, c.y ) ;
				}
			} else
				usageAndExit() ;
		} catch ( Exception e ) {
			e.printStackTrace() ;
			System.exit( 1 ) ;
		}

		System.exit( 0 ) ;
	}

	private static void usageAndExit() {
		System.err.println( "Usage: java P4OrthographicTest list | forward  <decimals> | inverse <decimals>" ) ;
		System.exit( 1 ) ;
	}

	static {
		System.loadLibrary( "caa" ) ;
		System.loadLibrary( "c3p" ) ;
	}
}
