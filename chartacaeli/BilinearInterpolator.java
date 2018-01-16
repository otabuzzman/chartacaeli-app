
package chartacaeli;

public class BilinearInterpolator {

	public static double operate( double x, double y, double x1, double x2, double y1, double y2, double q11, double q21, double q12, double q22 ) {
		double den = ( x2-x1 )*( y2-y1 ) ;
		double x2mx = x2-x, y2my = y2-y ;
		double xmx1 = x-x1, ymy1 = y-y1 ;

		return x2mx*y2my/den*q11+xmx1*y2my/den*q21+x2mx*ymy1/den*q12+xmx1*ymy1/den*q22 ;
	}

	public static double operate( double x, double y, double q11, double q21, double q12, double q22 ) {
		return q11*( 1-x )*( 1-y )+q21*x*( 1-y )+q12*( 1-x )*y+q22*x*y ;
	}
}
