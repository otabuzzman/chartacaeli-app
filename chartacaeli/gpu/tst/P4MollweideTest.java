
package chartacaeli.gpu.tst;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

import org.junit.Test;

import chartacaeli.caa.CAACoordinateTransformation;

import com.vividsolutions.jts.geom.Coordinate;

public class P4MollweideTest {

	// dataset forward
	static final double[][] ds_forward = {
		{ 0, 0 },
		{ 360, 90 },
		//			{ -180, 90 },
		{ 0, -90 },
		{ 194.46483796, -45.03414077 },
		{ -52.30259486, -87.15777906 },
		{ 37.28801542, -44.20015022 },
		{ -104.89724582, -62.15268687 },
		{ 320.66126018, -87.04437573 },
		{ 29.76859813, -25.41348531 },
		{ -142.52404743, -17.41959066 },
		{ 245.68921127, -60.84775510 },
	} ;

	// dataset inverse
	static final double[][] ds_inverse = {
		{ 0.000000000000, 0.000000000000 },
		{ 0.000035326531, 1.414213562346 },
		//			{ -0.000017663265, 1.414213562346 },
		{ 0.000000000000, -1.414213562346 },
		{ 2.461704979620, -0.837854112630 },
		{ -0.116940157577, -1.399824385634 },
		{ 0.476300796475, -0.823633664313 },
		{ -1.021299625672, -1.110033030798 },
		{ 0.735807947339, -1.399053183154 },
		{ 0.439227206867, -0.486432642666 },
		{ -2.175541122942, -0.335692810318 },
		{ 2.457076813480, -1.090815387378 },
	} ;

	@Test
	public void testForward() {
		chartacaeli.P4Mollweide p4j = new chartacaeli.P4Mollweide() ;
		Coordinate lamphi = new Coordinate(), xyC ;
		P4Mollweide p4c = new P4Mollweide() ;
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
		chartacaeli.P4Mollweide p4j = new chartacaeli.P4Mollweide() ;
		Coordinate xy = new Coordinate(), lamphiC ;
		P4Mollweide p4c = new P4Mollweide() ;
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
		chartacaeli.P4Mollweide p4 = new chartacaeli.P4Mollweide() ;
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
		System.err.println( "Usage: java P4MollweideTest list | forward  <decimals> | inverse <decimals> " ) ;
		System.exit( 1 ) ;
	}

	static {
		System.loadLibrary( "caa" ) ;
		System.loadLibrary( "c3p" ) ;
	}
}
