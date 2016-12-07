package chartacaeli.gpu.tst;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Vector;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.junit.Test;

public class PlaneTest {

	// dataset planes
	static final double[][][] ds_pln = new double[][][] {
		new double[][] {
				{ 1., 0., 0. },
				{ 0., 0., 0. },
				{ 0., 1., 0. }, },
				new double[][] {
				{ 10., 1., 2. },
				{ -1., -.5, 2.1 },
				{ 1., 11., 2.2 }, },
				new double[][] {
				{ 0.78503852, -0.38325148, 0.87073448 },
				{ -0.45306376, 0.42897599, 0.19854752 },
				{ -0.74207540, -0.97542537, 0.05768403 }, },
	} ;

	// dataset lines
	static final double[][][] ds_lin = new double[][][] {
		new double[][] {
				{ -1., -1., -1. },
				{ 1., 2., 3. }, },
				new double[][] {
				{ 1., 1., -1. },
				{ -1., -2., 3. }, },
				new double[][] {
				{ 1.81604259, 5.63113821, -9.44623383 },
				{ -0.50210727, -0.16019908, 0.99766439 }, },
	} ;

	// dataset intersection results
	static final double[][] ds_res = new double[][] {
		{ -0.500000000000, -0.250000000000, 0.000000000000 }, // p0/l0
		{ 0.551451187335, 1.327176781003, 2.102902374670 }, // p1/l0
		{ -0.378136653705, -0.067204980558, 0.243726692589 }, // p2/l0
		{ 0.500000000000, 0.250000000000, 0.000000000000 }, // p0/l1
		{ -0.543307086614, -1.314960629921, 2.086614173228 },
		{ 0.217798631506, -0.173302052741, 0.564402736988 },
		{ -0.280663560258, 0.393024521284, -0.000000000000 }, // p0/l2
		{ -0.745562415672, -0.768412935325, 2.094496310319 },
		{ -0.338746596707, 0.247918089337, 0.261679942029 },
	} ;

	@Test
	public void testIntersectionLine() {
		Plane plc ;
		double[] lc1, lc2, xc = new double[3] ;
		org.apache.commons.math3.geometry.euclidean.threed.Plane plj ;
		org.apache.commons.math3.geometry.euclidean.threed.Line lnj ;
		Vector3D xj ;

		for ( int p=0 ; ds_pln.length>p ; p++ ) {
			plc = new Plane( ds_pln[p][0], ds_pln[p][1], ds_pln[p][2] ) ;
			plj = new org.apache.commons.math3.geometry.euclidean.threed.Plane( new Vector3D( ds_pln[p][0] ), new Vector3D( ds_pln[p][1] ), new Vector3D( ds_pln[p][2] ), 1.0e-10 ) ;
			for ( int l=0 ; ds_lin.length>l ; l++ ) {
				lc1 = ds_lin[l][0] ;
				lc2 = ds_lin[l][1] ;
				lnj = new org.apache.commons.math3.geometry.euclidean.threed.Line( new Vector3D( ds_lin[l][0] ), new Vector3D( ds_lin[l][1] ), 1.0e-10 ) ;

				// check C3P classes
				plc.intersection( lc1, lc2, xc ) ;
				assertArrayEquals( ds_res[p+ds_pln.length*l], xc, .000001 ) ;

				// check Java classes
				xj = plj.intersection( lnj ) ;
				assertArrayEquals( ds_res[p+ds_pln.length*l], xj.toArray(), .000001 ) ;
			}
		}
	}


	public static void main( String[] argv ) {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in ) ) ;
		String format, lt, lr, lv[] ;
		int prec, sets ;
		Vector<String> data = new Vector<String>() ;
		double[] p1 = new double[3], p2 = new double[3], p3 = new double[3] ;
		org.apache.commons.math3.geometry.euclidean.threed.Plane plane ;
		org.apache.commons.math3.geometry.euclidean.threed.Line line ;
		Vector3D X ;

		if ( ! ( argv.length==1 || argv.length==2 ) )
			usageAndExit() ;

		if ( argv[0].equals( "list" ) ) {
			System.err.println( "// planes") ;
			for ( double[][] p : ds_pln )
				for ( double[] v : p ) {
					for ( double x : v )
						System.out.printf( Locale.ROOT, "%f ", x ) ;
					System.out.println() ;
				}
			System.err.println( "// lines") ;
			for ( double[][] l : ds_lin ) {
				for ( double[] v : l ) {
					for ( double x : v )
						System.out.printf( Locale.ROOT, "%f ", x ) ;
					System.out.println() ;
				}
			}
			System.err.println( "// results 3d") ;
			for ( double[] v : ds_res ) {
				for ( double x : v )
					System.out.printf( Locale.ROOT, "%f ", x ) ;
				System.out.println() ;
			}
			System.exit( 0 ) ;
		}

		if ( ! argv[0].equals( "intersection" ) )
			usageAndExit() ;

		prec = Integer.parseInt( argv[1] ) ;
		format = String.format( "%%.%df ", prec ) ;

		try {
			while ( ( lr = in.readLine() ) != null && lr.length()>0 ) {
				lt = lr.trim() ;
				if ( lt.startsWith( "//" ) )
					continue ;
				data.add( lt ) ;
			}
		} catch ( Exception e ) {
			e.printStackTrace() ;
			System.exit( 1 ) ;
		}

		sets = data.size()/5 ;

		for ( int s=0 ; sets>s ; s++ ) {
			// read plane
			lv = data.get( s*5+0 ).split( "\\p{Space}+" ) ;
			for ( int i=0 ; 3>i ; i++ )
				p1[i] = Double.parseDouble( lv[i] ) ;
			lv = data.get( s*5+1 ).split( "\\p{Space}+" ) ;
			for ( int i=0 ; 3>i ; i++ )
				p2[i] = Double.parseDouble( lv[i] ) ;
			lv = data.get( s*5+2 ).split( "\\p{Space}+" ) ;
			for ( int i=0 ; 3>i ; i++ )
				p3[i] = Double.parseDouble( lv[i] ) ;
			// create plane
			plane = new org.apache.commons.math3.geometry.euclidean.threed.Plane ( new Vector3D( p1 ), new Vector3D( p2 ) , new Vector3D( p3 ), 1.0e-10 ) ;

			// read line
			lv = data.get( s*5+3 ).split( "\\p{Space}+" ) ;
			for ( int i=0 ; 3>i ; i++ )
				p1[i] = Double.parseDouble( lv[i] ) ;
			lv = data.get( s*5+4 ).split( "\\p{Space}+" ) ;
			for ( int i=0 ; 3>i ; i++ )
				p2[i] = Double.parseDouble( lv[i] ) ;

			// intersection
			line = new org.apache.commons.math3.geometry.euclidean.threed.Line( new Vector3D( p1 ), new Vector3D( p2 ), 1.0e-10 ) ;
			X = plane.intersection( line ) ;

			System.out.printf( Locale.ROOT, format, X.getX() ) ;
			System.out.printf( Locale.ROOT, format, X.getY() ) ;
			System.out.printf( Locale.ROOT, format, X.getZ() ) ;
			System.out.println() ;
		}

		System.exit( 0 ) ;
	}

	private static void usageAndExit() {
		System.err.println( "Usage: java PlaneTest list | intersection <decimals>" ) ;
		System.exit( 1 ) ;
	}

	static {
		System.loadLibrary( "gpu" ) ;
	}
}
