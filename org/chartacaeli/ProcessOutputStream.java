
package org.chartacaeli;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcessOutputStream extends FilterOutputStream {

	private Process flt ;
	private OutputStream flti ;
	private InputStream flto ;

	private Thread pipe ;

	public ProcessOutputStream( OutputStream out, String cmd ) throws IOException {
		super( out ) ;

		flt = Runtime.getRuntime().exec( cmd.trim().split( "\\p{Space}+" ) ) ;
		flti = new BufferedOutputStream( flt.getOutputStream() ) ;
		flto = new BufferedInputStream( flt.getInputStream() ) ;

		new InputReaderMonitor( new InputStreamReader( flt.getErrorStream(), "UTF-8" ) )
		.start() ;

		pipe = new Thread() { public void run() { pipe() ; } } ;
		pipe.start() ;
	}

	public void write( int b ) throws IOException {
		flti.write( b ) ;
	}

	public void flush() throws IOException {
		flti.flush() ;
	}

	public void close() throws IOException {
		try {
			flti.close() ;
			flt.waitFor() ;

			pipe.join() ;
		} catch ( InterruptedException e ) {
		} catch ( IOException e ) {
		}
	}

	private void pipe() {
		int b ;

		try {
			while ( ( b = flto.read() )>-1 )
				super.write( b ) ;

			super.flush() ;
			super.close() ;
		} catch ( IOException e ) {
			throw new RuntimeException( e.toString() ) ;
		}
	}
}
