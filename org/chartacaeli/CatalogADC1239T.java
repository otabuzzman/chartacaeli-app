
package org.chartacaeli;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.ValidationException;

import org.chartacaeli.caa.CAA2DCoordinate;
import org.chartacaeli.caa.CAACoordinateTransformation;
import org.chartacaeli.caa.CAAPrecession;

@SuppressWarnings("serial")
public class CatalogADC1239T extends org.chartacaeli.model.CatalogADC1239T implements PostscriptEmitter {

	// configuration key (CK_)
	private final static String CK_PROPROMOT		= "prepromot" ;

	private final static boolean DEFAULT_PROPROMOT	= true ;

	private final static int C_CHUNK = 350+1/*0x0a*/ ;

	private final static Log log = LogFactory.getLog( CatalogADC1239T.class ) ;

	private Hashtable<String, CatalogADC1239TRecord> catalog ;

	private Converter converter ;
	private Projector projector ;

	public CatalogADC1239T( Converter converter, Projector projector ) {
		this.converter = converter ;
		this.projector = projector ;
	}

	@SuppressWarnings("unchecked")
	private Hashtable<String, CatalogADC1239TRecord> unsafecast( Object hashtable ) {
		return (Hashtable<String, CatalogADC1239TRecord>) hashtable ;
	}

	public void addAllCatalogRecord() {
		Reader reader ;
		CatalogADC1239TRecord record ;
		String key, ident ;

		key = getClass().getSimpleName()+":"+getName() ;
		catalog = unsafecast( Registry.retrieve( key ) ) ;
		if ( catalog == null ) {
			catalog = new Hashtable<String, CatalogADC1239TRecord>() ;
			Registry.register( key, catalog ) ;
		} else
			return ;

		try {
			reader = reader() ;

			while ( ( record = record( reader ) ) != null ) {
				try {
					record.inspect() ;
				} catch ( ParameterNotValidException e ) {
					log.warn( ParameterNotValidError.errmsg( record.TYC, e.getMessage() ) ) ;

					continue ;
				}

				record.register() ;

				for ( org.chartacaeli.model.CatalogADC1239TRecord select : getCatalogADC1239TRecord() ) {
					select.copyValues( record ) ;
					if ( Boolean.parseBoolean( record.getSelect() ) ) {
						ident = record.TYC
								.replaceAll( "[ ]+", "-" ) ;
						catalog.put( ident, record ) ;

						break ;
					}
				}

				record.degister() ;
			}

			reader.close() ;
		} catch ( URISyntaxException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( MalformedURLException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( IOException e ) {
			throw new RuntimeException( e.toString() ) ;
		}
	}

	public void delAllCatalogRecord() {
		catalog.clear() ;
	}

	public CatalogRecord[] getCatalogRecord() {
		return catalog.values().toArray( new CatalogRecord[0] ) ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		PostscriptEmitter emitter ;
		List<CatalogADC1239TRecord> catalog ;
		Comparator<CatalogADC1239TRecord> comparator = new Comparator<CatalogADC1239TRecord>() {
			public int compare( CatalogADC1239TRecord a, CatalogADC1239TRecord b ) {
				double amag, bmag ;

				amag = Double.valueOf( a.Vmag ).doubleValue() ;
				bmag = Double.valueOf( b.Vmag ).doubleValue() ;

				return amag<bmag?-1:
					amag>bmag?1:
						0 ;
			}
		} ;
		org.chartacaeli.model.Body body ;
		BodyStellar bodyStellar ;
		org.chartacaeli.model.Position pm ;
		CAA2DCoordinate cpm, ceq ;
		double e, ra, de, pmRA, pmDE ;
		Epoch epoch ;

		for ( int a=0 ; a<getArtworkCount() ; a++ ) {
			Artwork artwork = new Artwork( projector ) ;
			getArtwork( a ).copyValues( artwork ) ;
			artwork.load() ;
			artwork.init() ;

			ps.op( "gsave" ) ;

			artwork.headPS( ps ) ;
			artwork.emitPS( ps ) ;
			artwork.tailPS( ps ) ;

			ps.op( "grestore" ) ;
		}

		for ( int s=0 ; s<getSignCount() ; s++ ) {
			emitter = new Sign( projector ) ;
			getSign( s ).copyValues( emitter ) ;

			ps.op( "gsave" ) ;

			emitter.headPS( ps ) ;
			emitter.emitPS( ps ) ;
			emitter.tailPS( ps ) ;

			ps.op( "grestore" ) ;
		}

		epoch = (Epoch) Registry.retrieve( Epoch.class.getName() ) ;

		if ( epoch == null )
			e = new Epoch().alpha() ;
		else
			e = epoch.alpha() ;

		catalog = Arrays.asList( this.catalog
				.values()
				.toArray( new CatalogADC1239TRecord[0] ) ) ;
		Collections.sort( catalog, comparator ) ;

		for ( CatalogADC1239TRecord record : catalog ) {
			if ( Configuration.getValue( this, CK_PROPROMOT, DEFAULT_PROPROMOT ) ) {
				pmRA = 0 ;
				if ( record.pmRA.length()>0 )
					pmRA = new Double( record.pmRA ).doubleValue() ;
				pmDE = 0 ;
				if ( record.pmDE.length()>0 )
					pmDE = new Double( record.pmDE ).doubleValue() ;
				cpm = CAAPrecession.AdjustPositionUsingUniformProperMotion(
						e-2451545., record.RA(), record.de(), pmRA/1000., pmDE/1000. ) ;
				ceq = CAAPrecession.PrecessEquatorial( cpm.X(), cpm.Y(), 2451545./*J2000*/, e ) ;
				ra = CAACoordinateTransformation.HoursToDegrees( ceq.X() ) ;
				de = ceq.Y() ;
				cpm.delete() ;
				ceq.delete() ;
			} else {
				ra = CAACoordinateTransformation.HoursToDegrees( record.RA() ) ;
				de = record.de() ;
			}

			record.register() ;

			body = new org.chartacaeli.model.Body() ;
			body.setBodyStellar( new org.chartacaeli.model.BodyStellar() ) ;
			body.getBodyStellar().setName( record.TYC.replaceAll( "[ ]+", "-" ) ) ;
			body.getBodyStellar().initValues() ;

			body.getBodyStellar().setScript( record.getScript() ) ;
			body.getBodyStellar().setAnnotation( record.getAnnotation() ) ;

			pm = new org.chartacaeli.model.Position() ;
			// org.chartacaeli.model.AngleType
			pm.setLongitude( new org.chartacaeli.model.Longitude() ) ;
			pm.getLongitude().setRational( new org.chartacaeli.model.Rational() ) ;
			pm.getLongitude().getRational().setValue( ra ) ;
			// org.chartacaeli.model.AngleType
			pm.setLatitude( new org.chartacaeli.model.Latitude() ) ;
			pm.getLatitude().setRational( new org.chartacaeli.model.Rational() ) ;
			pm.getLatitude().getRational().setValue( de ) ;

			body.getBodyStellar().setPosition( pm ) ;

			try {
				body.validate() ;
			} catch ( ValidationException ee ) {
				throw new RuntimeException( ee.toString() ) ;
			}

			bodyStellar = new BodyStellar( converter, projector ) ;
			body.getBodyStellar().copyValues( bodyStellar ) ;

			bodyStellar.register() ;
			ps.op( "gsave" ) ;

			bodyStellar.headPS( ps ) ;
			bodyStellar.emitPS( ps ) ;
			bodyStellar.tailPS( ps ) ;

			ps.op( "grestore" ) ;
			bodyStellar.degister() ;

			record.degister() ;
		}
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
	}

	public Reader reader() throws URISyntaxException, MalformedURLException {
		URI uri ;
		URL url ;
		File file ;
		InputStream in ;
		GZIPInputStream gz ;

		uri = new URI( getUrl() ) ;
		if ( uri.isAbsolute() ) {
			url = uri.toURL() ;
		} else {
			file = new File( uri.getPath() ) ;
			url = file.toURI().toURL() ;
		}

		try {
			in = url.openStream() ;

			gz = new GZIPInputStream( in ) ;
			return new InputStreamReader( gz ) ;
		} catch ( IOException egz ) {
			try {
				in = url.openStream() ;

				return new InputStreamReader( in ) ;
			} catch ( IOException ein ) {
				throw new RuntimeException ( egz.toString() ) ;
			}
		}
	}

	public CatalogADC1239TRecord record( java.io.Reader catalog ) {
		CatalogADC1239TRecord r = null ;
		char[] cl ;
		String rl ;
		int cn, co = 0 ;

		cl = new char[C_CHUNK] ;

		try {
			while ( ( cn = catalog.read( cl, co, C_CHUNK-co ) ) != -1 ) {
				if ( cn == -1 ) // issue #57
					break ;
				co += cn ; if ( C_CHUNK>co )
					continue ;
				co = 0 ;

				rl = new String( cl ) ;
				rl = rl.substring( 0, rl.length()-1 ) ;

				if ( ( r = record( rl ) ) != null )
					break ;
			}
		} catch ( IOException e ) {
			throw new RuntimeException( e.toString() ) ;
		}

		return r ;
	}

	private CatalogADC1239TRecord record( String record ) {
		CatalogADC1239TRecord r = null ;

		try {
			r = new CatalogADC1239TRecord( record ) ;
		} catch ( ParameterNotValidException e ) {
			log.warn( ParameterNotValidError.errmsg( '"'+record+'"', e.getMessage() ) ) ;
		}

		return r ;
	}
}
