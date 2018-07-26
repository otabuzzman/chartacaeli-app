
package chartacaeli;

public class ImageOperator implements PostscriptEmitter {

	// configuration key (CK_), node (CN_)
	private final static String CR_MASKOUT		= "maskout" ;
	private final static String CK_TONEMAP		= "tonemap" ;

	private final static String DEFAULT_MASKOUT	= "0:0:0,0:0:0" ;
	private final static String DEFAULT_TONEMAP	= "0:0:0,1:1:1" ;

	private int[] image ;
	private int dimx ;
	private int dimy ;

	public ImageOperator( int[] image, int dimx, int dimy ) {
		this.image = image ;
		this.dimx = dimx ;
		this.dimy = dimy ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		String[] mov, moav, moov ;
		int moar, moag, moab ;
		int moor, moog, moob ;		
		String[] tmv, tmav, tmov ;
		double tmar, tmag, tmab ;
		double tmor, tmog, tmob ;
		ASCII85StringBuilder a85 ;
		int p, r, g, b ;

		mov = Configuration.getValue( this, CR_MASKOUT, DEFAULT_MASKOUT ).split( "," ) ;
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

		ps.script( "/DeviceRGB" ) ;
		ps.op( "setcolorspace" ) ;

		ps.dict( true ) ;
		ps.script( "/ImageType" ) ;
		ps.push( 4 ) ;
		ps.script( "/Width" ) ;
		ps.push( dimx ) ;
		ps.script( "/Height" ) ;
		ps.push( dimy ) ;
		ps.script( "/ImageMatrix" ) ;
		ps.array( true ) ;
		ps.push( dimx ) ;
		ps.push( 0 ) ;
		ps.push( 0 ) ;
		ps.push( dimy ) ;
		ps.push( 0 ) ;
		ps.push( 0 ) ;
		ps.array( false ) ;
		ps.script( "/BitsPerComponent" ) ;
		ps.push( 8 ) ;
		ps.script( "/MaskColor" ) ;
		ps.array( true ) ;
		ps.push( moar ) ;
		ps.push( moor ) ;
		ps.push( moag ) ;
		ps.push( moog ) ;
		ps.push( moab ) ;
		ps.push( moob ) ;
		ps.array( false ) ;
		ps.script( "/Decode" ) ;
		ps.array( true ) ;
		ps.push( tmar ) ;
		ps.push( tmor ) ;
		ps.push( tmag ) ;
		ps.push( tmog ) ;
		ps.push( tmab ) ;
		ps.push( tmob ) ;
		ps.array( false ) ;
		ps.script( "/DataSource" ) ;
		ps.op( "currentfile" ) ;
		ps.script( "/ASCII85Decode" ) ;
		ps.op( "filter" ) ;
		ps.dict( false ) ;

		ps.op( "systemdict" ) ;
		ps.op( "begin" ) ;
		ps.op( "image" ) ;
		ps.op( "end" ) ;

		a85 = new ASCII85StringBuilder() ;

		for ( int y=0 ; dimy>y ; y++ )
			for ( int x=0 ; dimx>x ; x++ ) {
				p = image[y*dimx+x] ;

				r = p>>16&0xff ;
				g = p>> 8&0xff ;
				b = p    &0xff ;

				a85.append( (byte) ( r ) ) ;
				a85.append( (byte) ( g ) ) ;
				a85.append( (byte) ( b ) ) ;
			}

		a85.finish() ;
		ps.script( a85.toString() ) ;
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
	}
}
