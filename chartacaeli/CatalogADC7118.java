
package chartacaeli;

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

import com.vividsolutions.jts.geom.Coordinate;

import chartacaeli.caa.CAA2DCoordinate;
import chartacaeli.caa.CAACoordinateTransformation;
import chartacaeli.caa.CAAPrecession;

@SuppressWarnings("serial")
public class CatalogADC7118 extends chartacaeli.model.CatalogADC7118 implements PostscriptEmitter {

	// configuration key (CK_)
	private final static String CK_PROPROMOT		= "prepromot" ;

	private final static boolean DEFAULT_PROPROMOT	= true ;

	// configuration key (CK_)
	private final static String CK_THRESHOLDSCALE		= "thresholdscale" ;

	private final static double DEFAULT_THRESHOLDSCALE	= 5.2 ;

	private final static int I_CHUNK = 70+1/*0x0a*/ ;
	private final static int C_CHUNK = 96+1/*0x0a*/ ;

	private final static Log log = LogFactory.getLog( CatalogADC7118.class ) ;

	protected class Catalog {
		public Hashtable<String, CatalogADC7118Record> main = new Hashtable<String, CatalogADC7118Record>() ;

		public Supplement supp = new Supplement() ;

		protected class Supplement {
			public Hashtable<String, String> index = new Hashtable<String, String>() ;
		}
	}

	private Catalog catalog ;

	private Converter converter ;
	private Projector projector ;

	public CatalogADC7118( Converter converter, Projector projector ) {
		this.converter = converter ;
		this.projector = projector ;
	}

	public void addAllCatalogRecord() {
		Reader reader ;
		CatalogADC7118Record record ;
		String key ;

		key = getClass().getSimpleName()+":"+getName() ;
		catalog = (Catalog) Registry.retrieve( key ) ;
		if ( catalog == null ) {
			catalog = new Catalog() ;
			Registry.register( key, catalog ) ;
		} else
			return ;

		try {

			reader = reader( new URI( getUrl() ) ) ;
			index( reader( new URI( getIndex() ) ) ) ;

			while ( ( record = record( reader ) ) != null ) {
				try {
					record.inspect() ;
				} catch ( ParameterNotValidException e ) {
					log.warn( ParameterNotValidError.errmsg( record.Name, e.getMessage() ) ) ;

					continue ;
				}

				record.register() ;

				for ( chartacaeli.model.CatalogADC7118Record select : getCatalogADC7118Record() ) {
					select.copyValues( record ) ;
					if ( Boolean.parseBoolean( record.getSelect() ) ) {
						catalog.main.put( record.Name, record ) ;

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
		catalog.main.clear() ;
	}

	public CatalogRecord[] getCatalogRecord() {
		return catalog.main.values().toArray( new CatalogRecord[0] ) ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		double threshold, d, s ;
		Coordinate p, a ;
		Vector vp, va ;
		List<CatalogADC7118Record> catalog ;
		Comparator<CatalogADC7118Record> comparator = new Comparator<CatalogADC7118Record>() {
			public int compare( CatalogADC7118Record a, CatalogADC7118Record b ) {
				double amag, bmag ;

				amag = Double.valueOf( a.mag ).doubleValue() ;
				bmag = Double.valueOf( b.mag ).doubleValue() ;

				return amag<bmag?-1:
					amag>bmag?1:
						0 ;
			}
		} ;
		BodyStellar star ;
		BodyAreal area ;
		chartacaeli.model.ShapeElliptical shapeElliptical ;
		chartacaeli.model.Position position ;
		CAA2DCoordinate ceq ;
		double e, ra, de ;
		Epoch epoch ;

		epoch = (Epoch) Registry.retrieve( Epoch.class.getName() ) ;

		if ( epoch == null )
			e = new Epoch().alpha() ;
		else
			e = epoch.alpha() ;

		threshold = Configuration.getValue( this, CK_THRESHOLDSCALE, DEFAULT_THRESHOLDSCALE ) ;

		catalog = Arrays.asList( this.catalog.main
				.values()
				.toArray( new CatalogADC7118Record[0] ) ) ;
		Collections.sort( catalog, comparator ) ;

		for ( CatalogADC7118Record record : catalog ) {
			if ( Configuration.getValue( this, CK_PROPROMOT, DEFAULT_PROPROMOT ) ) {
				ceq = CAAPrecession.PrecessEquatorial( record.RA(), record.de(), 2451545./*J2000*/, e ) ;
				ra = CAACoordinateTransformation.HoursToDegrees( ceq.X() ) ;
				de = ceq.Y() ;
				ceq.delete() ;
			} else {
				ra = CAACoordinateTransformation.HoursToDegrees( record.RA() ) ;
				de = record.de() ;
			}


			record.register() ;

			position = new chartacaeli.model.Position() ;
			// chartacaeli.model.AngleType
			position.setLongitude( new chartacaeli.model.Longitude() ) ;
			position.getLongitude().setRational( new chartacaeli.model.Rational() ) ;
			position.getLongitude().getRational().setValue( ra ) ;
			// chartacaeli.model.AngleType
			position.setLatitude( new chartacaeli.model.Latitude() ) ;
			position.getLatitude().setRational( new chartacaeli.model.Rational() ) ;
			position.getLatitude().getRational().setValue( de ) ;

			d = 0 ;
			s = 0 ;
			if ( record.size.length()>0 ) {
				d = Double.valueOf( record.size )/60. ;
				p = projector.project( converter.convert( new Coordinate( ra, de ), false ), false ) ;
				vp = new Vector( p ) ;
				a = projector.project( converter.convert( new Coordinate( ra+d, de ), false ), false ) ;
				va = new Vector( a ) ;
				s = va.sub( vp ).abs() ;
			}

			try {
				ps.op( "gsave" ) ;

				if ( s>threshold ) {
					area = new BodyAreal( converter, projector ) ;
					area.setName( record.Name ) ;
					area.initValues() ;

					area.setAnnotation( record.getAnnotation() ) ;

					area.setBodyArealTypeChoice( new chartacaeli.model.BodyArealTypeChoice() ) ;
					shapeElliptical = new chartacaeli.model.ShapeElliptical() ;
					area.getBodyArealTypeChoice().setShapeElliptical( shapeElliptical ) ;

					shapeElliptical.setProportion( 1 ) ;
					shapeElliptical.setPA( 0 ) ;
					shapeElliptical.setRational( new chartacaeli.model.Rational() ) ;
					shapeElliptical.getRational().setValue( d ) ;
					shapeElliptical.setPosition( position ) ;

					area.validate() ;

					ps.script( Configuration.getValue( this, record.Type, "" ) ) ;

					area.headPS( ps ) ;
					area.emitPS( ps ) ;
					area.tailPS( ps ) ;
				} else {
					star = new BodyStellar( converter, projector ) ;
					star.setName( record.Name ) ;
					star.initValues() ;

					star.setScript( record.getScript() ) ;
					star.setAnnotation( record.getAnnotation() ) ;

					star.setPosition( position ) ;

					star.validate() ;

					star.headPS( ps ) ;
					star.emitPS( ps ) ;
					star.tailPS( ps ) ;
				}

				ps.op( "grestore" ) ;
			} catch ( ValidationException ee ) {
				throw new RuntimeException( ee.toString() ) ;
			}

			record.degister() ;
		}
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
	}

	public Reader reader( URI uri ) throws URISyntaxException, MalformedURLException {
		URL url ;
		File file ;
		InputStream in ;
		GZIPInputStream gz ;

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

	public void index( java.io.Reader index ) {
		char[] cl ;
		int cn, co ;
		String rl ;
		String k, n ;

		cl = new char[I_CHUNK] ;
		co = 0 ;

		try {
			while ( ( cn = index.read( cl, co++, 1 ) ) != -1 ) {
				if ( cn == -1 ) // issue #57
					break ;
				if ( cn == 0 )
					continue ;

				if ( cl[co-1] == '\n' ) {
					if ( co<I_CHUNK ) {
						for ( co-- ; co<I_CHUNK ; co++ ) {
							cl[co] = ' ' ;
						}
						cl[co-1] = '\n' ;
					}
					rl = new String( cl ) ;
					co = 0 ;
					rl = rl.substring( 0, rl.length()-1 ) ;

					k = rl.substring( 36, 41 ).replaceAll( " ", "" ) ;
					n = rl.substring( 0, 35 ).trim() ;

					catalog.supp.index.put( k, n ) ;
				}
			}
		} catch ( IOException e ) {
			throw new RuntimeException( e.toString() ) ;
		}
	}

	public CatalogADC7118Record record( java.io.Reader catalog ) {
		CatalogADC7118Record r = null ;
		char[] cl ;
		String rl ;
		int cn, co ;

		cl = new char[C_CHUNK] ;
		co = 0 ;

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

	private CatalogADC7118Record record( String record ) {
		CatalogADC7118Record r = null ;

		try {
			r = new CatalogADC7118Record( record, catalog.supp ) ;
		} catch ( ParameterNotValidException e ) {
			log.warn( ParameterNotValidError.errmsg( '"'+record+'"', e.getMessage() ) ) ;
		}

		return r ;
	}
}
