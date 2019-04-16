
package org.chartacaeli.gpu.tst;

import java.util.Locale;
import java.util.Random;

@SuppressWarnings("serial")
public class RandomDataset extends Random {

	public RandomDataset() {
		super( System.currentTimeMillis() ) ;
	}

	public static void main( String[] argv ) {
		String format ;
		int prec, nrec ;
		double base, ival ;
		RandomDataset rand ;

		rand = new RandomDataset() ;

		if ( argv.length>2 && argv.length%2==0 ) {
			prec = Integer.parseInt( argv[0] ) ;
			nrec = Integer.parseInt( argv[1] ) ;
			format = String.format( "%%.%df%%c", prec ) ;

			for ( int r=0 ; nrec>r ; r++ )
				for ( int a=2 ; argv.length>a ; ) {
					base = Double.parseDouble( argv[a++] ) ;
					ival = Double.parseDouble( argv[a++] ) ;

					System.out.printf( Locale.ROOT, format, rand.nextDouble()*ival+base, a==argv.length?'\n':' ' ) ;
				}
		} else
			usageAndExit() ;

		System.exit( 0 ) ;
	}

	private static void usageAndExit() {
		System.err.println( "Usage: java RandomDataset <decimals> <records> <element base> <element interval> [ <element base> <element interval> ... ]" ) ;
		System.exit( 1 ) ;
	}
}
