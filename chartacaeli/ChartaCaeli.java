
package chartacaeli;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;

@SuppressWarnings("serial")
public class ChartaCaeli extends chartacaeli.model.ChartaCaeli implements PostscriptEmitter {

	// configuration key (CK_)
	public final static String CK_VERBOSE		= "verbose" ;
	public final static boolean DEFAULT_VERBOSE	= false ;

	private final static String CK_VIEWER		= "viewer" ;
	private final static String CK_LIBCAA		= "libcaa" ;

	private final static String DEFAULT_LIBCAA	= "caa" ;

	public void headPS( ApplicationPostscriptStream ps ) {
		ps.emitDSCHeader() ;
		ps.emitDSCProlog() ;
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		Epoch epoch ;
		chartacaeli.model.Chart chart ;
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
		String prop, path ;
		File preferences ;
		FileInputStream s ;
		InputStreamReader r ;
		ChartaCaeli chartacaeli ;
		String viewerDecl ;
		Process viewerProc ;
		TeeOutputStream out ;
		ApplicationPostscriptStream ps ;

		try {
			prop = ChartaCaeli.class.getPackage().getName()+".app" ;
			path = System.getProperty( prop )+".preferences" ;
			preferences = new File( path ) ;
			Configuration.importPreferences( preferences ) ;

			path = new String( argv[0] ).replaceAll( "\\.[^\\.]*$", "" )+".preferences" ;
			preferences = new File( path ) ;
			Configuration.importPreferences( preferences ) ;

			Configuration.verbose() ;
			ApplicationResource.verbose() ;

			viewerDecl = Configuration.getValue( ChartaCaeli.class, CK_VIEWER, null ) ;
			out =  new TeeOutputStream( System.out ) ;

			if ( viewerDecl == null ) {
				viewerProc = null ;
			} else {
				try {
					viewerProc = Runtime.getRuntime().exec( viewerDecl.trim().split( "\\p{Space}+" ) ) ;

					viewerProc.getInputStream().close() ;
					viewerProc.getErrorStream().close() ;

					out.add( viewerProc.getOutputStream() ) ;
				} catch ( IOException e ) {
					viewerDecl = null ;
					viewerProc = null ;
				}
			}

			s = new FileInputStream( argv[0] ) ;
			r = new InputStreamReader( s, "UTF-8" ) ;
			chartacaeli = new ChartaCaeli() ;
			readModel( r ).copyValues( chartacaeli ) ;

			ps = new ApplicationPostscriptStream( out ) ;

			chartacaeli.headPS( ps ) ;
			chartacaeli.emitPS( ps ) ;
			chartacaeli.tailPS( ps ) ;

			ps.flush() ;
			ps.flush() ;
			ps.close() ;

			if ( viewerDecl != null )
				viewerProc.waitFor() ;

			Registry.degister( ParserAttribute.class.getName() ) ;
			Registry.degister( Epoch.class.getName() ) ;
			Registry.remove() ;

			Configuration.verbose() ;
			ApplicationResource.verbose() ;
		} catch ( Exception e ) {
			e.printStackTrace() ;
			System.exit( 1 ) ;
		}

		System.exit( 0 ) ;
	} 

	public static chartacaeli.model.ChartaCaeli readModel( Reader model ) {
		try {
			return (chartacaeli.model.ChartaCaeli) chartacaeli.model.ChartaCaeli.unmarshal( model ) ;
		} catch ( MarshalException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( ValidationException e ) {
			throw new RuntimeException( e.toString() ) ;
		}
	}

	public static chartacaeli.model.ChartaCaeli readModel( String model ) {
		StringReader r ;
		chartacaeli.model.ChartaCaeli c ;

		r = new StringReader( model ) ;

		try {
			c = readModel( r ) ;
		} finally {
			r.close() ;
		}

		return c ;
	}

	private void chart( ApplicationPostscriptStream ps, chartacaeli.model.ChartAzimuthal peer ) {
		ChartAzimuthal chart ;

		chart = new ChartAzimuthal( peer ) ;

		chart.register() ;
		emitPS( ps, chart ) ;
		chart.degister() ;
	}

	private void chart( ApplicationPostscriptStream ps, chartacaeli.model.ChartPseudoCylindrical peer ) {
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
