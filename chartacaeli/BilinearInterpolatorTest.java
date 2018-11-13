
package chartacaeli;

import static org.junit.Assert.*;

import org.junit.Test;

public class BilinearInterpolatorTest {

	@Test
	public void testOperate() {
		double x, y ;
		double x1, y1 ;
		double x2, y2 ;
		int q11, q21, q12, q22 ;
		long p ;

		x = 4.7 ;
		y = 7.4 ;

		x1 = 2.3 ;
		y1 = 3.2 ;
		x2 = 5.6 ;
		y2 = 6.5 ;

		q11 = 23 ;
		q21 = 45 ;
		q12 = 67 ;
		q22 = 89 ;

		p = (long) BilinearInterpolator.operate( x, y, x1, x2, y1, y2, q11, q21, q12, q22 ) ;

		assertEquals( 95L, p ) ;
	}

}
