
package org.chartacaeli;

public class BilinearInterpolator {

	public static int operate( double x, double y, double x1, double x2, double y1, double y2, int q11, int q21, int q12, int q22 ) {
		double x2mx = x2-x ;
		double x2mx1 = x2-x1 ;
		double xmx1 = x-x1 ;

		double f1 = x2mx/x2mx1 ;
		double f2 = xmx1/x2mx1 ;

		double r1 = f1*q11+f2*q21 ;
		double r2 = f1*q12+f2*q22 ;

		double y2my1 = y2-y1 ;

		return (int) ( ( ( y2-y )/y2my1 )*r1+( ( y-y1 )/y2my1 )*r2 ) ;
	}
}
