
package chartacaeli.gpu.tst;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Vector;

import org.apache.commons.math3.linear.MatrixUtils;
import org.junit.Test;

public class RealMatrixTest {

	// dataset matrices
	static final double[][][] ds_mat3 = new double[][][] {
		new double[][] {
				{ 0., 0., 0. },
				{ 0., 0., 0. },
				{ 0., 0., 0. }, },
				new double[][] {
				{ 1., 1., 1. },
				{ 1., 1., 1. },
				{ 1., 1., 1. }, },
				new double[][] {
				{ 1., 2., 3. },
				{ 4., 5., 6. },
				{ 7., 8., 9. }, },
				new double[][] {
				{ 0.78503852, -0.38325148, 0.87073448 },
				{ -0.45306376, 0.42897599, 0.19854752 },
				{ -0.74207540, -0.97542537, 0.05768403 }, },
	} ;
	static final double[][][] ds_mat4 = new double[][][] {
		new double[][] {
				{ 0., 0., 0., 0. },
				{ 0., 0., 0., 0. },
				{ 0., 0., 0., 0. },
				{ 0., 0., 0., 0. }, },
				new double[][] {
				{ 1., 1., 1., 1. },
				{ 1., 1., 1., 1. },
				{ 1., 1., 1., 1. },
				{ 1., 1., 1., 1. }, },
				new double[][] {
				{ 1., 2., 3., 4. },
				{ 5., 6., 7., 8. },
				{ 9., 0., 1., 2. },
				{ 3., 4., 5., 6. }, },
				new double[][] {
				{ 0.22169402, -0.27361799, -0.78093494, -0.94930205 },
				{ -0.26562674, 0.27975055, -0.55448441, -0.68632607 },
				{ 0.16160128, 0.23707935, -0.41731743, 0.12192442 },
				{ 0.66116184, -0.76267301, 0.90822475, 0.68881377 }, },
	} ;
	// dataset input vectors
	static final double[][] ds_vec3 = new double[][] {
		{ 0., 0., 0. },
		{ 1., 1., 1. },
		{ 7., 5., 3. },
		{ 0.78503852, 0.42897599, 0.05768403 },
	} ;
	static final double[][] ds_vec4 = new double[][] {
		{ 0., 0., 0., 0. },
		{ 1., 1., 1., 1. },
		{ 3., 0., 7., 4. },
		{ 0.22169402, 0.27975055, -0.41731743, 0.68881377 },
	} ;
	// dataset result vectors
	static final double[][] ds_res3 = new double[][] {
		{ 0.00000000, 0.00000000, 0.00000000  }, // m0/v0
		{ 0.00000000, 0.00000000, 0.00000000 }, // m1/v0
		{ 0.00000000, 0.00000000, 0.00000000 }, // ...
		{ 0.00000000, 0.00000000, 0.00000000 },
		{ 0.00000000, 0.00000000, 0.00000000 }, // m0/v1
		{ 3.00000000, 3.00000000, 3.00000000 },
		{ 6.00000000, 15.00000000, 24.00000000 },
		{ 1.27252152, 0.17445975, -1.65981674 },
		{ 0.00000000, 0.00000000, 0.00000000 }, // m0/v2
		{ 15.00000000, 15.00000000, 15.00000000 },
		{ 26.00000000, 71.00000000, 116.00000000 },
		{ 6.19121568, -0.43092381, -9.89860256 },
		{ 0.00000000, 0.00000000, 0.00000000 }, // m0/v3
		{ 1.27169854, 1.27169854, 1.27169854 },
		{ 1.81604259, 5.63113821, 9.44623383 },
		{ 0.50210727, -0.16019908, -0.99766439 },
	} ;
	static final double[][] ds_res4 = new double[][] {
		{ 0.00000000, 0.00000000, 0.00000000, 0.00000000 },
		{ 0.00000000, 0.00000000, 0.00000000, 0.00000000 },
		{ 0.00000000, 0.00000000, 0.00000000, 0.00000000 },
		{ 0.00000000, 0.00000000, 0.00000000, 0.00000000 },
		{ 0.00000000, 0.00000000, 0.00000000, 0.00000000 },
		{ 4.00000000, 4.00000000, 4.00000000, 4.00000000 },
		{ 10.00000000, 26.00000000, 12.00000000, 18.00000000 },
		{ -1.78216096, -1.22668667, 0.10328762, 1.49552735 },
		{ 0.00000000, 0.00000000, 0.00000000, 0.00000000 },
		{ 14.00000000, 14.00000000, 14.00000000, 14.00000000 },
		{ 40.00000000, 96.00000000, 42.00000000, 68.00000000 },
		{ -8.59867072, -7.42357537, -1.94872049, 11.09631385 },
		{ 0.00000000, 0.00000000, 0.00000000, 0.00000000 },
		{ 0.77294091, 0.77294091, 0.77294091, 0.77294091 },
		{ 2.28449791, 5.37626155, 2.95555629, 3.83037973 },
		{ -0.35539111, -0.22198233, 0.36028617, 0.02866382 },
	} ;

	@Test
	public void testOperateDoubleArrayDoubleArray() {
		RealMatrix rmc = new RealMatrix() ;
		org.apache.commons.math3.linear.RealMatrix rmj ;
		double resc[], resj[], rmf[] ;
		int rows, cols ;

		rmj = MatrixUtils.createRealMatrix( ds_mat3[0] ) ;
		rows = cols = 3 ;
		rmf = new double[rows*cols] ;
		resc = new double[rows] ;

		for ( int mat=0 ; ds_mat3.length>mat ; mat++ ) {
			// set Java matrix
			rmj.setSubMatrix( ds_mat3[mat], 0, 0 ) ;
			// flatten C3P matrix
			for ( int r=0 ; rows>r ; r++ )
				for ( int c=0 ; cols>c ; c++ )
					rmf[rows*r+c] = ds_mat3[mat][r][c] ;
			// set C3P matrix
			rmc.set( rmf, rows, cols ) ;

			for ( int vec=0 ; ds_vec3.length>vec ; vec++ ) {
				// check C3P classes
				rmc.operate( ds_vec3[vec], resc ) ;
				assertArrayEquals( ds_res3[mat+ds_mat3.length*vec], resc, .000001 ) ;

				// check Java classes
				resj = rmj.operate( ds_vec3[vec] ) ;
				assertArrayEquals( ds_res3[mat+ds_mat3.length*vec], resj, .000001 ) ;
			}
		}

		rows = cols = 4 ;
		rmj = MatrixUtils.createRealMatrix( ds_mat4[0] ) ;
		rmf = new double[rows*cols] ;
		resc = new double[rows] ;

		for ( int mat=0 ; ds_mat4.length>mat ; mat++ ) {
			// set Java matrix
			rmj.setSubMatrix( ds_mat4[mat], 0, 0 ) ;
			// flatten C3P matrix
			for ( int r=0 ; rows>r ; r++ )
				for ( int c=0 ; cols>c ; c++ )
					rmf[rows*r+c] = ds_mat4[mat][r][c] ;
			// set C3P matrix
			rmc.set( rmf, rows, cols ) ;

			for ( int vec=0 ; ds_vec4.length>vec ; vec++ ) {
				// check C3P classes
				rmc.operate( ds_vec4[vec], resc ) ;
				assertArrayEquals( ds_res4[mat+ds_mat4.length*vec], resc, .000001 ) ;

				// check Java classes
				resj = rmj.operate( ds_vec4[vec] ) ;
				assertArrayEquals( ds_res4[mat+ds_mat4.length*vec], resj, .000001 ) ;
			}
		}
	}

	public static void main( String[] argv ) {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in ) ) ;
		String format, lt, lr, lv[] ;
		Vector<String> data = new Vector<String>() ;
		double[] mat[], vec, m3vec ;
		int prec, rows, cols, sets, r ;
		org.apache.commons.math3.linear.RealMatrix m3mat ;

		if ( ! ( argv.length==1 || argv.length==3 ) )
			usageAndExit() ;

		if ( argv[0].equals( "list" ) ) {
			System.err.println( "// matrices 3d") ;
			for ( double[][] m : ds_mat3 )
				for ( double[] v : m ) {
					for ( double x : v )
						System.out.printf( Locale.ROOT, "%f ", x ) ;
					System.out.println() ;
				}
			System.err.println( "// vectors 3d") ;
			for ( double[] v : ds_vec3 ) {
				for ( double x : v )
					System.out.printf( Locale.ROOT, "%f ", x ) ;
				System.out.println() ;
			}
			System.err.println( "// results 3d") ;
			for ( double[] v : ds_res4 ) {
				for ( double x : v )
					System.out.printf( Locale.ROOT, "%f ", x ) ;
				System.out.println() ;
			}
			System.err.println( "// matrices 4d") ;
			for ( double[][] m : ds_mat4 )
				for ( double[] v : m ) {
					for ( double x : v )
						System.out.printf( Locale.ROOT, "%f ", x ) ;
					System.out.println() ;
				}
			System.err.println( "// vectors 4d") ;
			for ( double[] v : ds_vec4 ) {
				for ( double x : v )
					System.out.printf( Locale.ROOT, "%f ", x ) ;
				System.out.println() ;
			}
			System.err.println( "// results 4d") ;
			for ( double[] v : ds_res4 ) {
				for ( double x : v )
					System.out.printf( Locale.ROOT, "%f ", x ) ;
				System.out.println() ;
			}
			System.exit( 0 ) ;
		}

		if ( ! argv[0].equals( "operate" ) )
			usageAndExit() ;

		prec = Integer.parseInt( argv[2] ) ;
		rows = cols = Integer.parseInt( argv[1] ) ;
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

		sets = data.size()/( rows+1 ) ;

		for ( int s=0 ; sets>s ; s++ ) {
			mat = new double[rows][cols] ;
			// read matrix
			for ( r=0 ; rows>r ; r++ ) {
				lv = data.get( s*( rows+1 )+r ).split( "\\p{Space}+" ) ;
				for ( int c=0 ; cols>c ; c++ )
					mat[r][c] = Double.parseDouble( lv[c] ) ;
			}
			// read vector
			lv = data.get( s*( rows+1 )+r ).split( "\\p{Space}+" ) ;
			vec = new double[rows] ;
			for ( int c=0 ; cols>c ; c++ )
				vec[c] = Double.parseDouble( lv[c] ) ;
			// create RealMatrix from dataset matrix
			m3mat = MatrixUtils.createRealMatrix( mat ) ;
			// operate dataset vector
			m3vec = m3mat.operate( vec ) ;

			for ( int i=0 ; rows>i ; i++ )
				System.out.printf( Locale.ROOT, format, m3vec[i] ) ;
			System.out.println() ;
		}

		System.exit( 0 ) ;
	}

	private static void usageAndExit() {
		System.err.println( "Usage: java RealMatrixTest list | operate <rows> <decimals>" ) ;
		System.exit( 1 ) ;
	}

	static {
		System.loadLibrary( "gpu" ) ;
	}
}
