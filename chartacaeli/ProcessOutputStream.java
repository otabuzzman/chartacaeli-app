
package chartacaeli;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcessOutputStream extends FilterOutputStream {

	private Process flt ;
	private OutputStream flti ;
	private InputStream flto ;

	public ProcessOutputStream( OutputStream out, String cmd ) throws IOException {
		super( out ) ;

		flt = Runtime.getRuntime().exec( cmd.trim().split( "\\p{Space}+" ) ) ;
		flti = flt.getOutputStream() ;
		flto = flt.getInputStream() ;

		new InputReaderMonitor( new InputStreamReader( flt.getErrorStream(), "UTF-8" ) )
		.start() ;

		new Thread() { public void run() { pipe() ; } }
		.start() ;
	}

	public void write( int b ) throws IOException {
		flti.write( b ) ;
	}

	public void close() throws IOException {
		try {
			flti.close() ;
			flt.waitFor() ;
		} catch ( InterruptedException e ) {
		} catch ( IOException e ) {
		}
	}

	private void pipe() {
		int b ;

		try {
			while ( ( b = flto.read() )>-1 ) {
				super.write( b ) ;

				flush() ;
				flush() ;
			}

			super.close();
		} catch ( IOException e ) {
			throw new RuntimeException( e.toString() ) ;
		}
	}
}
