
package chartacaeli;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class RGBOutputStream extends FilterOutputStream {

	public RGBOutputStream( OutputStream out ) {
		super( out ) ;
	}

	public void write( int RGB ) throws IOException {
		int r, g, b ;

		r = RGB>>16&255 ;
		g = RGB>> 8&255 ;
		b = RGB    &255 ;
		super.write( r ) ;
		super.write( g ) ;
		super.write( b ) ;
	}

	public void write( int[] RGB ) throws IOException {
		if ( RGB == null || RGB.length == 0 )
			return ;

		for ( int rgb : RGB )
			write( rgb ) ;
	}

	public void write( int[] RGB, int off, int len ) throws IOException {
		int end = off+len ;

		if ( end>RGB.length )
			return ;
		if ( 0>off || 0>len )
			throw new IndexOutOfBoundsException() ;
		if ( RGB == null || RGB.length == 0 )
			return ;

		for ( int i=off ; end>i ; i++ )
			write( RGB[i] ) ;
	}
}
