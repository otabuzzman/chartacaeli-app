
package org.chartacaeli;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.vividsolutions.jts.geom.Coordinate;

import org.chartacaeli.caa.CAA2DCoordinate;
import org.chartacaeli.caa.CAACoordinateTransformation;
import org.chartacaeli.caa.CAAElliptical;
import org.chartacaeli.caa.CAAEllipticalPlanetaryDetails;
import org.chartacaeli.caa.CAANutation;

@SuppressWarnings("serial")
public class BodyPlanet extends BodyOrbitalType {

	// configuration key (CK_)
	private final static String CK_STRETCH			= "stretch" ;

	private final static double DEFAULT_STRETCH		= 0 ;

	private org.chartacaeli.model.BodyPlanet peer ;

	public BodyPlanet( org.chartacaeli.model.BodyPlanet peer, Converter converter, Projector projector ) {
		super( converter, projector ) ;

		this.peer = peer ;
	}

	public Coordinate jdToEquatorial( double jd, Coordinate eq ) {
		double l, b, o ;
		double epoch, stretch ;
		Class<?> caaPlanet, caaElliptical ;
		Method eclipticLongitude ;
		Method eclipticLatitude ;
		Field fldPlanet ;
		int planet ;
		CAA2DCoordinate c2d ;
		CAAEllipticalPlanetaryDetails details ;

		l = 0 ;
		b = 0 ;

		epoch = getEpochAlpha() ;

		if ( getStretch() )
			stretch = Configuration.getValue( this, CK_STRETCH, DEFAULT_STRETCH ) ;
		else
			stretch = 0 ;

		try {
			caaPlanet = Class.forName( "org.chartacaeli.caa.CAA"+peer.getType().substring( 0, 1 ).toUpperCase()+peer.getType().substring( 1 ) ) ;

			eclipticLongitude = caaPlanet.getMethod( "EclipticLongitude", new Class[] { double.class, boolean.class } ) ;
			eclipticLatitude = caaPlanet.getMethod( "EclipticLatitude", new Class[] { double.class, boolean.class } ) ;

			l = (Double) eclipticLongitude.invoke( null, new Object[] { new Double( jd ), new Boolean( false ) } ) ;
			b = (Double) eclipticLatitude.invoke( null, new Object[] { new Double( jd ), new Boolean( false ) } ) ;

			caaElliptical = Class.forName( "org.chartacaeli.caa.CAAElliptical" ) ;
			fldPlanet = caaElliptical.getField( peer.getType().toUpperCase() ) ;
			planet = fldPlanet.getInt( null ) ;

		} catch ( ClassNotFoundException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( NoSuchMethodException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( InvocationTargetException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( IllegalAccessException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch (NoSuchFieldException e) {
			throw new RuntimeException( e.toString() ) ;
		} catch (SecurityException e) {
			throw new RuntimeException( e.toString() ) ;
		}

		if ( eq != null ) {
			o = CAANutation.MeanObliquityOfEcliptic( epoch ) ;
			c2d = CAACoordinateTransformation.Ecliptic2Equatorial( l, b, o ) ;
			eq.x = CAACoordinateTransformation.HoursToDegrees( c2d.X() ) ;
			eq.y = c2d.Y() ;
		}

		b += ( jd-epoch )*stretch ;
		o = CAANutation.MeanObliquityOfEcliptic( epoch ) ;
		c2d = CAACoordinateTransformation.Ecliptic2Equatorial( l, b, o ) ;

		if ( ! peer.getGeocentric() )
			return new Coordinate( CAACoordinateTransformation.HoursToDegrees( c2d.X() ), c2d.Y() ) ;

		details = CAAElliptical.Calculate( jd, planet, false ) ;
		return new Coordinate( CAACoordinateTransformation.HoursToDegrees( details.ApparentGeocentricRA() ), details.ApparentGeocentricDeclination() ) ;
	}
}
