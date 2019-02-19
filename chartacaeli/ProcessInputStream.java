
package chartacaeli;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcessInputStream extends FilterInputStream {

	private Process flt ;
	private OutputStream flti ;
	private InputStream flto ;

	public ProcessInputStream( InputStream in, String cmd ) throws IOException {
		super( in ) ;

		flt = Runtime.getRuntime().exec( cmd.trim().split( "\\p{Space}+" ) ) ;
		flti = new BufferedOutputStream( flt.getOutputStream() ) ;
		flto = new BufferedInputStream( flt.getInputStream() ) ;

		new InputReaderMonitor( new InputStreamReader( flt.getErrorStream(), "UTF-8" ) )
		.start() ;

		new Thread() { public void run() { pipe() ; } }
		.start() ;
	}

	public int read() throws IOException {
		return flto.read() ;
	}

	public int read( byte[] buf ) throws IOException {
		return flto.read( buf ) ;
	}

	public int read( byte[] buf, int off, int len ) throws IOException {
		return flto.read( buf, off, len ) ;
	}

	public void close() {
		try {
			flt.waitFor() ;
			super.close() ;
		} catch ( InterruptedException e ) {
		} catch ( IOException e ) {
		}
	}

	private void pipe() {
		int b ;

		try {
			while ( ( b = super.read() )>-1 )
				flti.write( b ) ;

			flti.flush() ;
			flti.close() ;
		} catch ( IOException e ) {
			throw new RuntimeException( e.toString() ) ;
		}
	}
}
