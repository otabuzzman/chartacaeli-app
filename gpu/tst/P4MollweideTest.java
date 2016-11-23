
package gpu.tst;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

import org.junit.Test;

import chartacaeli.caa.CAACoordinateTransformation;

import com.vividsolutions.jts.geom.Coordinate;

public class P4MollweideTest {

	// dataset forward
	double[][] dataset_f = {
			{ 0, 0 },
			{ 360, 90 },
			{ 360, -90 },
			{ -360, -90 },
			{ -390, 125 },
			{ 390, -125 },
			{ 285.96507320, 57.19645503 },
			{ 281.00543042, -30.64417613 },
			{ 198.32294673, 44.54854348 },
			{ 222.66537100, -27.62091553 },
			{ 350.41479725, -20.22673364 },
			{ 31.15271854, -67.58308292 },
			{ -118.80829765, -77.26883507 },
			{ -129.32911838, 66.23282586 },
	} ;

	// dataset inverse
	double[][] dataset_i = {
			{ 0.000000000000, 0.000000000000 },
			{ 0.000035326531, 1.414213562346 },
			{ 0.000035326531, -1.414213562346 },
			{ -0.000035326531, -1.414213562346 },
			{ -4.327589541727, 1.001323735770 },
			{ 4.327589541727, -1.001323735770 },
			{ 3.060247851411, 1.035555621636 },
			{ 4.022756620023, -0.583111505572 },
			{ 2.523845979837, 0.829583384946 },
			{ 3.246394243562, -0.527448659196 },
			{ 5.293863032894, -0.388977905861 },
			{ 0.266273425030, -1.186691069606 },
			{ -0.711308364542, -1.307539563996 },
			{ -1.145463050023, 1.168156349324 },
	} ;

	@Test
	public void testForward() {
		P4Mollweide p4j = new P4Mollweide() ;
		Coordinate lamphi = new Coordinate(), xyC ;
		gpu.P4Mollweide p4c = new gpu.P4Mollweide() ;
		double[] xyA = new double[3] ;

		for ( int i=0 ; dataset_f.length>i ; i++ ) {
			lamphi.x = dataset_f[i][0] ;
			lamphi.y = dataset_f[i][1] ;

			xyC = p4j.forward( lamphi ) ;
			assertEquals( dataset_i[i][0], xyC.x, .000001 ) ;
			assertEquals( dataset_i[i][1], xyC.y, .000001 ) ;

			p4c.forward( new double[] { lamphi.x, lamphi.y, 0 }, xyA ) ;
			assertEquals( dataset_i[i][0], xyA[0], .000001 ) ;
			assertEquals( dataset_i[i][1], xyA[1], .000001 ) ;
		}
	}

	@Test
	public void testInverse() {
		P4Mollweide p4j = new P4Mollweide() ;
		Coordinate xy = new Coordinate(), lamphiC ;
		gpu.P4Mollweide p4c = new gpu.P4Mollweide() ;
		double[] lamphiA = new double[3] ;

		for ( int i=0 ; dataset_i.length>i ; i++ ) {
			xy.x = dataset_i[i][0] ;
			xy.y = dataset_i[i][1] ;

			lamphiC = p4j.inverse( xy ) ;
			assertEquals(
					CAACoordinateTransformation.MapTo0To360Range( dataset_f[i][0] ),
					CAACoordinateTransformation.MapTo0To360Range( lamphiC.x ), .000001 ) ;
			assertEquals(
					CAACoordinateTransformation.MapToMinus90To90Range( dataset_f[i][1] ),
					CAACoordinateTransformation.MapToMinus90To90Range( lamphiC.y ), .000001 ) ;

			p4c.inverse( new double[] { xy.x, xy.y, 0 }, lamphiA ) ;
			assertEquals(
					CAACoordinateTransformation.MapTo0To360Range( dataset_f[i][0] ),
					CAACoordinateTransformation.MapTo0To360Range( lamphiA[0] ), .000001 ) ;
			assertEquals(
					CAACoordinateTransformation.MapToMinus90To90Range( dataset_f[i][1] ),
					CAACoordinateTransformation.MapToMinus90To90Range( lamphiA[1] ), .000001 ) ;
		}
	}

	public static void main( String[] argv ) {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in ) ) ;
		P4Mollweide p4 = new P4Mollweide() ;
		String format, lr, lv[] ;
		int prec ;
		double a, b ;
		Coordinate c ;

		if ( ! ( argv.length==2 ) )
			usageAndExit() ;

		prec = Integer.parseInt( argv[0] ) ;
		format = String.format( "%%.%df %%.%df%%n", prec, prec ) ;

		try {
			if ( argv[1].equals( "forward" ) ) {
				while ( ( lr = in.readLine() ) != null && lr.length()>0 ) {
					lv = lr.trim().split( "\\p{Space}+" ) ;
					a = Double.parseDouble( lv[0] ) ;
					b = Double.parseDouble( lv[1] ) ;
					c = p4.forward( new Coordinate( a, b ) ) ;
					System.out.printf( Locale.ROOT, format, c.x, c.y ) ;
				}
			} else if ( argv[1].equals( "inverse" ) ) {
				while ( ( lr = in.readLine() ) != null && lr.length()>0 ) {
					lv = lr.trim().split( "\\p{Space}+" ) ;
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
		System.err.println( "Usage: java P4MollweideTest <decimals> forward | reverse" ) ;
		System.exit( 1 ) ;
	}

	static {
		System.loadLibrary( "caa" ) ;
		System.loadLibrary( "gpu" ) ;
	}
}
