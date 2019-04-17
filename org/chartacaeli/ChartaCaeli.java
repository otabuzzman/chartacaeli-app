
package org.chartacaeli;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

@SuppressWarnings("serial")
public class ChartaCaeli extends org.chartacaeli.model.ChartaCaeli implements PostscriptEmitter {

	// configuration key (CK_)
	private final static String CK_VIEWER		= "viewer" ;
	private final static String CK_LIBCAA		= "libcaa" ;

	private final static String DEFAULT_LIBCAA	= "caa" ;

	// message key (MK_)
	private final static String MK_EUNREC		= "eunrec" ;
	private final static String MK_ERUNEXT		= "erunext" ;

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
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
		ps.emitDSCTrailer() ;
	}

	public static void main( String[] argv ) {
		String subarg, d8n = null ;
		Preferences user ;
		String app, name, p9s ;
		ByteArrayOutputStream backup = null ;
		ByteArrayInputStream imp0rt ;
		FileInputStream s ;
		InputStreamReader r ;
		ChartaCaeli chartacaeli ;
		String viewerDecl ;
		Process viewerProc ;
		TeeOutputStream out ;
		ApplicationPostscriptStream ps ;

		try {
			// parse command line
			for ( int i=0 ; argv.length>i ; i++ ) {
				if ( argv[i].startsWith( "preferences=" ) ) {
					subarg = argv[i].substring( 12 ) ;
					if ( subarg.equals( "backup" ) ) {
						backup = new ByteArrayOutputStream() ;
						user = Preferences.userRoot() ;
						user.exportSubtree( backup ) ;

						deleteUserPreferences() ;
					} else if ( subarg.equals( "delete" ) )
						deleteUserPreferences() ;
					else if ( ! subarg.equals( "update" ) )
						throw new ParameterNotValidException( ParameterNotValidError.errmsg( argv[i], null ) ) ;
				} else
					d8n = argv[i] ;
			}

			// read chart definition
			if ( d8n != null ) {
				s = new FileInputStream( d8n ) ;
				r = new InputStreamReader( s, "UTF-8" ) ;
			} else
				r = new InputStreamReader( System.in, "UTF-8" ) ;
			chartacaeli = new ChartaCaeli() ;
			readModel( r ).copyValues( chartacaeli ) ;

			// load system preferences
			app = ChartaCaeli.class.getPackage().getName()+".app" ;
			p9s = System.getProperty( app )+".preferences" ;
			Configuration.importPreferences( new File( p9s ) ) ;

			// load user preferences
			name = chartacaeli.getName() ;
			if ( name == null || name.length() == 0 )
				if ( d8n != null )
					name = d8n ;
			if ( name != null )
				p9s = new String( name )
				.replaceAll( "\\.[^\\.]*$", "" )+".preferences" ;
			Configuration.importPreferences( new File( p9s ) ) ;

			viewerDecl = Configuration.getValue( ChartaCaeli.class, CK_VIEWER, null ) ;
			if ( viewerDecl == null || viewerDecl.length() == 0 ) {
				viewerProc = null ;
			} else {
				try {
					viewerProc = Runtime.getRuntime().exec( viewerDecl.trim().split( "\\p{Space}+" ) ) ;

					new InputReaderMonitor( new InputStreamReader( viewerProc.getInputStream(), "UTF-8" ) )
					.start() ;
					new InputReaderMonitor( new InputStreamReader( viewerProc.getErrorStream(), "UTF-8" ) )
					.start() ;
				} catch ( Exception e ) {
					log.info( MessageCatalog.compose( ChartaCaeli.class, MK_ERUNEXT, new Object[] { viewerDecl } ) ) ;

					viewerDecl = null ;
					viewerProc = null ;
				}
			}

			out = new TeeOutputStream( System.out ) ;
			if ( viewerProc != null )
				out.add( viewerProc.getOutputStream() ) ;

			ps = new ApplicationPostscriptStream( out ) ;

//			chartacaeli.headPS( ps ) ;
//			chartacaeli.emitPS( ps ) ;
//			chartacaeli.tailPS( ps ) ;

			ps.flush() ;
			ps.close() ;

			if ( viewerDecl != null )
				viewerProc.waitFor() ;

			if ( backup != null ) {
				deleteUserPreferences() ;

				imp0rt = new ByteArrayInputStream( backup.toByteArray() ) ;
				Preferences.importPreferences( imp0rt ) ;
			}

			Registry.degister( ParserAttribute.class.getName() ) ;
			Registry.degister( Epoch.class.getName() ) ;
			Registry.remove() ;
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

	private static void deleteUserPreferences() throws BackingStoreException {
		Preferences user, node ;

		user = Preferences.userRoot() ;
		for ( String name : user.childrenNames() ) {
			node = user.node( name ) ;
			node.removeNode() ;
		}
		user.flush() ;
	}

	static {
		String libcaa ;

		libcaa = Configuration.getValue(
				ChartaCaeli.class, CK_LIBCAA, DEFAULT_LIBCAA ) ;
		System.loadLibrary( libcaa ) ;
	}
}
