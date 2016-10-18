
package chartacaeli;

public class ImageDiscrete implements PostscriptEmitter {

	// configuration key (CK_), node (CN_)
	private final static String CK_BACKGROUND		= "background" ;
	private final static String CK_TONEMAP			= "tonemap" ;

	private final static String DEFAULT_BACKGROUND	= "0:0:0,0:0:0" ;
	private final static String DEFAULT_TONEMAP		= "0:0:0,1:1:1" ;

	private int[] image ;
	private int dimx ;
	private int dimy ;

	public ImageDiscrete( int[] image, int dimx, int dimy ) {
		this.image = image ;
		this.dimx = dimx ;
		this.dimy = dimy ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		String[] bgv, bgav, bgov ;
		int bgar, bgag, bgab, bga ;
		int bgor, bgog, bgob, bgo ;
		String[] tmv, tmav, tmov ;
		double tmar, tmag, tmab ;
		double tmor, tmog, tmob ;
		double tmr, tmg, tmb ;
		int p ;
		double r, g, b ;

		bgv = Configuration.getValue( this, CK_BACKGROUND, DEFAULT_BACKGROUND )
				.split( "," ) ;
		bgav = bgv[0].split( ":" ) ;
		bgar = (int) ( Double.parseDouble( bgav[0] )*255 ) ;
		bgag = (int) ( Double.parseDouble( bgav[1] )*255 ) ;
		bgab = (int) ( Double.parseDouble( bgav[2] )*255 ) ;
		bgov = bgv[1].split( ":" ) ;
		bga = bgar<<16|bgag<<8|bgab ;
		bgor = (int) ( Double.parseDouble( bgov[0] )*255 ) ;
		bgog = (int) ( Double.parseDouble( bgov[1] )*255 ) ;
		bgob = (int) ( Double.parseDouble( bgov[2] )*255 ) ;
		bgo = bgor<<16|bgog<<8|bgob ;

		tmv = Configuration.getValue( this, CK_TONEMAP, DEFAULT_TONEMAP )
				.split( "," ) ;
		tmav = tmv[0].split( ":" ) ;
		tmar = Double.parseDouble( tmav[0] ) ;
		tmag = Double.parseDouble( tmav[1] ) ;
		tmab = Double.parseDouble( tmav[2] ) ;
		tmov = tmv[1].split( ":" ) ;
		tmor = Double.parseDouble( tmov[0] ) ;
		tmog = Double.parseDouble( tmov[1] ) ;
		tmob = Double.parseDouble( tmov[2] ) ;
		tmr = tmor-tmar ;
		tmg = tmog-tmag ;
		tmb = tmob-tmab ;

		for ( int y=0 ; dimy>y ; y++ )
			for ( int x=0 ; dimx>x ; x++ ) {
				p = image[y*dimx+x]&0xffffff ;

				if ( p>=bga && bgo>=p )
					continue ;

				r = tmar+( ( p>>16)&0xff )*tmr/255 ;
				g = tmag+( ( p>>8)&0xff )*tmg/255 ;
				b = tmab+( p&0xff )*tmb/255 ;

				ps.op( "gsave" ) ;
				ps.op( "currentpoint" ) ;
				ps.op( "translate" ) ;
				ps.push( r ) ;
				ps.push( g ) ;
				ps.push( b ) ;
				ps.op( "setrgbcolor" ) ;
				ps.op( "upix" ) ;
				ps.op( "grestore" ) ;

				ps.push( x ) ;
				ps.push( y ) ;
				ps.op( "moveto" ) ;
			}
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
	}
}
