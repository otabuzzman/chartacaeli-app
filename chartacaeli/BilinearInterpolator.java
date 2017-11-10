
package chartacaeli;

public class BilinearInterpolator {

	private double xratio ;
	private double yratio ;

	public BilinearInterpolator( double xratio, double yratio ) {
		this.xratio = xratio ;
		this.yratio = yratio ;
	}

	public int operate( int a, int b, int c, int d, int x, int y ) {
		double w, h ;

		w = xratio*x ;
		w -= (int) w ;
		h = yratio*y ;
		h -= (int) h ;

		return (int) ( a*( 1-w )*( 1-h )+b*w*( 1-h )+c*h*( 1-w )+d*w*h ) ;
	}
}
