
package org.chartacaeli;

public class ImageDiscrete implements PostscriptEmitter {

	// configuration key (CK_), node (CN_)
	private final static String CK_MASKOUT		= "maskout" ;
	private final static String CK_TONEMAP		= "tonemap" ;

	private final static String DEFAULT_MASKOUT	= "0:0:0,0:0:0" ;
	private final static String DEFAULT_TONEMAP	= "0:0:0,1:1:1" ;

	private byte[] image ;
	private int dimx ;
	private int dimy ;

	public ImageDiscrete( byte[] image, int dimx, int dimy ) {
		this.image = image ;
		this.dimx = dimx ;
		this.dimy = dimy ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
		ps.op( "newpath" ) ;
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		String[] mov, moav, moov ;
		int moar, moag, moab, i ;
		int moor, moog, moob ;
		String[] tmv, tmav, tmov ;
		double tmar, tmag, tmab ;
		double tmor, tmog, tmob ;
		double tmr, tmg, tmb ;
		double r, g, b ;

		mov = Configuration.getValue( this, CK_MASKOUT, DEFAULT_MASKOUT ).split( "," ) ;
		moav = mov[0].split( ":" ) ;
		moar = (int) ( Double.parseDouble( moav[0] )*255 ) ;
		moag = (int) ( Double.parseDouble( moav[1] )*255 ) ;
		moab = (int) ( Double.parseDouble( moav[2] )*255 ) ;
		moov = mov[1].split( ":" ) ;
		moor = (int) ( Double.parseDouble( moov[0] )*255 ) ;
		moog = (int) ( Double.parseDouble( moov[1] )*255 ) ;
		moob = (int) ( Double.parseDouble( moov[2] )*255 ) ;

		tmv = Configuration.getValue( this, CK_TONEMAP, DEFAULT_TONEMAP ).split( "," ) ;
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
				i = y*dimx*3+x*3 ;

				r = image[i] ;
				g = image[i+1] ;
				b = image[i+2] ;

				if ( r>=moar && moor>=r && g>=moag && moog>=g && b>=moab && moob>=b )
					continue ;

				r = tmar+r*tmr/255 ;
				g = tmag+g*tmg/255 ;
				b = tmab+b*tmb/255 ;

				ps.push( x ) ;
				ps.push( y ) ;
				ps.op( "moveto" ) ;

				ps.op( "gsave" ) ;
				ps.push( r ) ;
				ps.push( g ) ;
				ps.push( b ) ;
				ps.op( "setrgbcolor" ) ;
				ps.op( "currentpoint" ) ;
				ps.op( "translate" ) ;
				ps.op( "upix" ) ;
				ps.op( "grestore" ) ;
			}
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
	}
}
