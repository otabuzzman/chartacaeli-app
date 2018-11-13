
package chartacaeli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderMonitor {

	private BufferedReader src ;

	public InputReaderMonitor( InputStreamReader src ) {
		this.src = new BufferedReader( src ) ;
	}

	public void start() {
		new Thread() { public void run() { log() ; } }
		.start() ;
	}

	private void log() {
		String l ;

		try {
			while ( ( l = src.readLine() ) != null )
				System.err.println( l ) ;
		} catch ( IOException e ) {}
	}
}
