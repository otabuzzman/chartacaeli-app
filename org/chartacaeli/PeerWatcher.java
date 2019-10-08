
package org.chartacaeli;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PeerWatcher {

	private final static Log log = LogFactory.getLog( PeerWatcher.class ) ;

	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool( 1 ) ;
	private static ScheduledFuture<?> watcher ;

	public static void launch( int interval ) {
		Runnable runnable ;

		runnable = new Runnable() {

			public void run() {
				log.info( Peer.getTotal()+" "+Peer.getCount() );
			}
		} ;

		watcher = scheduler.scheduleAtFixedRate( runnable, interval, interval, TimeUnit.SECONDS ) ;
	}

	public static void finish() {
		if ( watcher == null )
			return ;

		watcher.cancel( false ) ;
	}
}
