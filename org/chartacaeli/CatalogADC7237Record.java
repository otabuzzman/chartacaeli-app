
package org.chartacaeli;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

@SuppressWarnings("serial")
public class CatalogADC7237Record extends org.chartacaeli.model.CatalogADC7237Record implements CatalogRecord {

	private final static String DEFAULT_TOKENPATTERN = ".+" ;

	private final static int CR_LENGTH = 521 ;

	private final static String QK_PGC		= "PGC" ;
	private final static String QK_RAH		= "RAh" ;
	private final static String QK_RAM		= "RAm" ;
	private final static String QK_RAS		= "RAs" ;
	private final static String QK_DE		= "DE" ;
	private final static String QK_DED		= "DEd" ;
	private final static String QK_DEM		= "DEm" ;
	private final static String QK_DES		= "DEs" ;
	private final static String QK_OTYPE	= "OType" ;
	private final static String QK_MTYPE	= "MType" ;
	private final static String QK_LOGD25	= "logD25" ;
	private final static String QK_E_LOGD25	= "e_logD25" ;
	private final static String QK_LOGR25	= "logR25" ;
	private final static String QK_E_LOGR25	= "e_logR25" ;
	private final static String QK_PA		= "PA" ;
	private final static String QK_E_PA		= "e_PA" ;
	private final static String QK_O_ANAMES	= "o_ANames" ;
	private final static String QK_ANAMES	= "ANames" ;

	public String PGC	; // [1/3099300] PGC number
	public String RAh	; // Right ascension (J2000)
	public String RAm	; // Right ascension (J2000)
	public String RAs	; // Right ascension (J2000)
	public String DE	; // Declination sign (J2000)
	public String DEd	; // Declination (J2000)
	public String DEm	; // Declination (J2000)
	public String DEs	; // Declination (J2000)
	public String OType	; // [GM ] Object type (1)
	public String MType	; // Provisional morphological type from LEDA
	// according to the RC2 code.
	public String logD25	; // ?=9.99 Apparent diameter (2)
	public String e_logD25	; // ?=9.99 Actual error of logD25
	public String logR25	; // ?=9.99 Axis ratio in log scale
	// (log of major axis to minor axis)
	public String e_logR25	; // ?=9.99 Actual error on logR25
	public String PA	; // ?=999. Adopted 1950-position angle (3)
	public String e_PA	; // ?=999. rms uncertainty on PA
	public String o_ANames	; // Number of alternate names.
	public String ANames	; // Alternate names (4)

	// message key (MK_)
	private final static String MK_ERECLEN = "ereclen" ;
	private final static String MK_ERECVAL = "erecval" ;

	public CatalogADC7237Record( String data ) throws ParameterNotValidException {
		MessageCatalog cat ;
		StringBuffer msg ;
		String fmt ;

		if ( data.length() != CR_LENGTH ) {
			cat = new MessageCatalog( this ) ;
			fmt = cat.message( MK_ERECLEN, null ) ;
			if ( fmt != null ) {
				msg = new StringBuffer() ;
				msg.append( MessageFormat.format( fmt, new Object[] { CR_LENGTH } ) ) ;
			} else
				msg = null ;

			throw new ParameterNotValidException( ParameterNotValidError.errmsg( data.length(), msg.toString() ) ) ;
		}

		PGC			= data.substring( 3, 10 ).trim() ;
		RAh			= data.substring( 12, 14 ).trim() ;
		RAm			= data.substring( 14, 16 ).trim() ;
		RAs			= data.substring( 16, 20 ).trim() ;
		DE			= data.substring( 20, 21 ).trim() ;
		DEd			= data.substring( 21, 23 ).trim() ;
		DEm			= data.substring( 23, 25 ).trim() ;
		DEs			= data.substring( 25, 27 ).trim() ;
		OType		= data.substring( 28, 30 ).trim() ;
		MType		= data.substring( 31, 36 ).trim() ;
		logD25		= data.substring( 36, 41 ).trim() ;
		e_logD25	= data.substring( 44, 48 ).trim() ;
		logR25		= data.substring( 50, 54 ).trim() ;
		e_logR25	= data.substring( 57, 61 ).trim() ;
		PA			= data.substring( 63, 67 ).trim() ;
		e_PA		= data.substring( 70, 74 ).trim() ;
		o_ANames	= data.substring( 75, 77 ).trim() ;
		ANames		= data.substring( 78, 341 ).trim() ;
	}

	public void register() {
		SubstituteCatalog cat ;
		String sub ;

		cat = new SubstituteCatalog( this ) ;

		sub = cat.substitute( QK_PGC, QK_PGC ) ;
		Registry.register( sub, PGC ) ;
		sub = cat.substitute( QK_RAH, QK_RAH ) ;
		Registry.register( sub, RAh ) ;
		sub = cat.substitute( QK_RAM, QK_RAM ) ;
		Registry.register( sub, RAm ) ;
		sub = cat.substitute( QK_RAS, QK_RAS ) ;
		Registry.register( sub, RAs ) ;
		sub = cat.substitute( QK_DE, QK_DE ) ;
		Registry.register( sub, DE ) ;
		sub = cat.substitute( QK_DED, QK_DED ) ;
		Registry.register( sub, DEd ) ;
		sub = cat.substitute( QK_DEM, QK_DEM ) ;
		Registry.register( sub, DEm ) ;
		sub = cat.substitute( QK_DES, QK_DES ) ;
		Registry.register( sub, DEs ) ;
		sub = cat.substitute( QK_OTYPE, QK_OTYPE ) ;
		Registry.register( sub, OType ) ;
		sub = cat.substitute( QK_MTYPE, QK_MTYPE ) ;
		Registry.register( sub, MType ) ;
		sub = cat.substitute( QK_LOGD25, QK_LOGD25 ) ;
		Registry.register( sub, logD25 ) ;
		sub = cat.substitute( QK_E_LOGD25, QK_E_LOGD25 ) ;
		Registry.register( sub, e_logD25 ) ;
		sub = cat.substitute( QK_LOGR25, QK_LOGR25 ) ;
		Registry.register( sub, logR25 ) ;
		sub = cat.substitute( QK_E_LOGR25, QK_E_LOGR25 ) ;
		Registry.register( sub, e_logR25 ) ;
		sub = cat.substitute( QK_PA, QK_PA ) ;
		Registry.register( sub, PA ) ;
		sub = cat.substitute( QK_E_PA, QK_E_PA ) ;
		Registry.register( sub, e_PA ) ;
		sub = cat.substitute( QK_O_ANAMES, QK_O_ANAMES ) ;
		Registry.register( sub, o_ANames ) ;
		sub = cat.substitute( QK_ANAMES, QK_ANAMES ) ;
		Registry.register( sub, ANames ) ;
	}

	public void degister() {
		SubstituteCatalog cat ;
		String sub ;

		cat = new SubstituteCatalog( this ) ;

		sub = cat.substitute( QK_PGC, QK_PGC ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_RAH, QK_RAH ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_RAM, QK_RAM ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_RAS, QK_RAS ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_DE, QK_DE ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_DED, QK_DED ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_DEM, QK_DEM ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_DES, QK_DES ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_OTYPE, QK_OTYPE ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_MTYPE, QK_MTYPE ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_LOGD25, QK_LOGD25 ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_E_LOGD25, QK_E_LOGD25 ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_LOGR25, QK_LOGR25 ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_E_LOGR25, QK_E_LOGR25 ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_PA, QK_PA ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_E_PA, QK_E_PA ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_O_ANAMES, QK_O_ANAMES ) ;
		Registry.degister( sub ) ;
		sub = cat.substitute( QK_ANAMES, QK_ANAMES ) ;
		Registry.degister( sub ) ;
	}

	public boolean isOK() {
		try {
			inspect() ;
		} catch ( ParameterNotValidException e ) {
			return false ;
		}

		return true ;
	}

	public void inspect() throws ParameterNotValidException {
		Preferences node ;
		Field token ;
		String name, value, pattern ;
		MessageCatalog cat ;
		StringBuffer msg ;
		String fmt ;

		try {
			name = this.getClass().getName().replaceAll( "\\.", "/" ) ;
			if ( Preferences.userRoot().nodeExists( name ) )
				node = Preferences.userRoot().node( name ) ;
			else if ( Preferences.systemRoot().nodeExists( name ) )
				node = Preferences.systemRoot().node( name ) ;
			else
				return ;

			for ( String key : node.keys() ) {
				try {
					token = getClass().getDeclaredField( key ) ;
					value = (String) token.get( this ) ;
					pattern = node.get( key, DEFAULT_TOKENPATTERN ) ;
					if ( ! value.matches( pattern ) ) {
						cat = new MessageCatalog( this ) ;
						fmt = cat.message( MK_ERECVAL, null ) ;
						if ( fmt != null ) {
							msg = new StringBuffer() ;
							msg.append( MessageFormat.format( fmt, new Object[] { value, pattern } ) ) ;
						} else
							msg = null ;

						throw new ParameterNotValidException( ParameterNotValidError.errmsg( key, msg.toString() ) ) ;
					}
				} catch ( NoSuchFieldException e ) {
					continue ;
				} catch ( IllegalAccessException e ) {
					throw new RuntimeException( e.toString() ) ;
				}
			}
		} catch ( BackingStoreException e ) {
			throw new RuntimeException( e.toString() ) ;
		}
	}

	public double RA() {
		return RAh()+RAm()/60.+RAs()/3600. ;
	}

	public double de() {
		return DEd()+DEm()/60.+DEs()/3600. ;
	}

	private double RAh() {
		return Double.parseDouble( RAh ) ;
	}

	private double RAm() {
		return Double.parseDouble( RAm ) ;
	}

	private double RAs() {
		return Double.parseDouble( RAs ) ;
	}

	private double DEd() {
		return Double.parseDouble( DE+DEd ) ;
	}

	private double DEm() {
		return Double.parseDouble( DE+DEm ) ;
	}

	private double DEs() {
		return Double.parseDouble( DE+DEs ) ;
	}

	public Geometry list() {
		return new GeometryFactory().createPoint( new Coordinate( RA(), de() ) ) ;
	}
}
