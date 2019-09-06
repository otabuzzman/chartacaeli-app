
package org.chartacaeli;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.prefs.Preferences;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

@SuppressWarnings("serial")
public class ChartaCaeli extends org.chartacaeli.model.ChartaCaeli implements PostscriptEmitter {

	// configuration key (CK_)
	private final static String CK_LIBCAA		= "libcaa" ;

	private final static String DEFAULT_LIBCAA	= "caa" ;

	// message key (MK_)
	private final static String MK_EUNREC		= "eunrec" ;

	private final static Log log = LogFactory.getLog( ChartaCaeli.class ) ;

	public void headPS( ApplicationPostscriptStream ps ) {
		ps.emitDSCHeader() ;
		ps.emitDSCProlog() ;
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		Epoch epoch ;
		org.chartacaeli.model.Chart chart ;
		ParserAttribute parser ;

		parser = new ParserAttribute() ;
		Registry.register( ParserAttribute.class.getName(), parser ) ;

		epoch = new Epoch() ;
		if ( getEpoch() != null )
			getEpoch().copyValues( epoch ) ;
		Registry.register( Epoch.class.getName(), epoch ) ;

		for ( int ch=0 ; ch<getChartCount() ; ch++ ) {
			chart = getChart( ch ) ;

			if ( chart.getChartAzimuthal() != null ) {
				chart( ps, chart.getChartAzimuthal() ) ;
			} else { // chart.getChartPseudoCylindrical() != null
				chart( ps, chart.getChartPseudoCylindrical() ) ;
			}
		}

		Registry.degister( Epoch.class.getName() ) ;
		Registry.degister( ParserAttribute.class.getName() ) ;

		Registry.remove() ;
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
		ps.emitDSCTrailer() ;
	}

	public static void main( String[] argv ) {
		String chart, prefs, viewerOpt ;
		InputStreamReader d8n ;
		InputStream p9s ;
		File file ;
		Process viewerRun ;
		TeeOutputStream tee ;
		ApplicationPostscriptStream ps ;
		ChartaCaeli chartacaeli ;

		chart = StringUtils.EMPTY ;
		prefs = StringUtils.EMPTY ;
		viewerOpt = StringUtils.EMPTY ;

		for ( int i=0 ; argv.length>i ; i++ ) {
			if ( argv[i].endsWith( ".xml" ) ) {
				chart = argv[i] ;
			} else if ( argv[i].endsWith( ".preferences" ) ) {
				prefs = argv[i] ;
			} else if ( argv[i].startsWith( "viewer=" ) ) {
				viewerOpt = argv[i].substring( 7 ) ;
			}
		}

		try {
			if ( chart.length() == 0 )
				d8n = new InputStreamReader( System.in, "UTF-8" ) ;
			else
				d8n = new InputStreamReader( new FileInputStream( chart ), "UTF-8" ) ;

			chartacaeli = new ChartaCaeli() ;
			readModel( d8n ).copyValues( chartacaeli ) ;

			d8n.close() ;

			if ( prefs.length() == 0 ) {
				if ( chart.length()>0 ) {
					file = new File( chart.substring( 0, chart.length()-4 )+".preferences" ) ;
					if ( file.exists() ) {
						p9s = new FileInputStream( file ) ;
						Preferences.importPreferences( p9s ) ;

						p9s.close() ;
					}
				}
			} else {
				p9s =  new FileInputStream( prefs ) ;
				Preferences.importPreferences( p9s ) ;

				p9s.close() ;
			}


			if ( viewerOpt.length()>0 ) {
				viewerRun = Runtime.getRuntime().exec( viewerOpt.trim().split( "\\p{Space}+" ) ) ;

				new InputReaderMonitor( new InputStreamReader( viewerRun.getInputStream(), "UTF-8" ) )
				.start() ;
				new InputReaderMonitor( new InputStreamReader( viewerRun.getErrorStream(), "UTF-8" ) )
				.start() ;

				tee = new TeeOutputStream( System.out ) ;
				tee.add( viewerRun.getOutputStream() ) ;

				ps = new ApplicationPostscriptStream( tee ) ;

				chartacaeli.headPS( ps ) ;
				chartacaeli.emitPS( ps ) ;
				chartacaeli.tailPS( ps ) ;

				ps.flush() ;
				ps.close() ;

				viewerRun.waitFor() ;
			} else {
				ps = new ApplicationPostscriptStream( System.out ) ;

				chartacaeli.headPS( ps ) ;
				chartacaeli.emitPS( ps ) ;
				chartacaeli.tailPS( ps ) ;

				ps.flush() ;
				ps.close() ;
			}
		} catch ( Exception e ) {
			log.error( MessageCatalog.compose( ChartaCaeli.class, MK_EUNREC, null ) ) ;

			e.printStackTrace() ;
			System.exit( 1 ) ;
		}

		System.exit( 0 ) ;
	}

	public static org.chartacaeli.model.ChartaCaeli readModel( Reader d8n ) {
		try {
			return (org.chartacaeli.model.ChartaCaeli) org.chartacaeli.model.ChartaCaeli.unmarshal( d8n ) ;
		} catch ( MarshalException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( ValidationException e ) {
			throw new RuntimeException( e.toString() ) ;
		}
	}

	public static org.chartacaeli.model.ChartaCaeli readModel( String d8n ) {
		StringReader r ;
		org.chartacaeli.model.ChartaCaeli c ;

		r = new StringReader( d8n ) ;

		try {
			c = readModel( r ) ;
		} finally {
			r.close() ;
		}

		return c ;
	}

	private void chart( ApplicationPostscriptStream ps, org.chartacaeli.model.ChartAzimuthal peer ) {
		ChartAzimuthal chart ;

		chart = new ChartAzimuthal( peer ) ;

		chart.register() ;
		emitPS( ps, chart ) ;
		chart.degister() ;
	}

	private void chart( ApplicationPostscriptStream ps, org.chartacaeli.model.ChartPseudoCylindrical peer ) {
		ChartPseudoCylindrical chart ;

		chart = new ChartPseudoCylindrical( peer ) ;

		chart.register() ;
		emitPS( ps, chart ) ;
		chart.degister() ;
	}

	private void emitPS( ApplicationPostscriptStream ps, PostscriptEmitter emitter ) {
		ps.op( "gsave" ) ;

		emitter.headPS( ps ) ;
		emitter.emitPS( ps ) ;
		emitter.tailPS( ps ) ;

		ps.op( "grestore" ) ;
	}

	static {
		String libcaa ;

		libcaa = Configuration.getValue(
				ChartaCaeli.class, CK_LIBCAA, DEFAULT_LIBCAA ) ;
		System.loadLibrary( libcaa ) ;
	}
}
