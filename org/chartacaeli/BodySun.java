
package org.chartacaeli;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.vividsolutions.jts.geom.Coordinate;

import org.chartacaeli.caa.CAA2DCoordinate;
import org.chartacaeli.caa.CAACoordinateTransformation;
import org.chartacaeli.caa.CAANutation;
import org.chartacaeli.caa.CAASun;

@SuppressWarnings("serial")
public class BodySun extends BodyOrbitalType {

	// configuration key (CK_)
	private final static String CK_STRETCH			= "stretch" ;

	private final static double DEFAULT_STRETCH		= 0 ;

	private org.chartacaeli.model.BodySun peer ;

	public BodySun( org.chartacaeli.model.BodySun peer, Converter converter, Projector projector ) {
		super( converter, projector ) ;

		this.peer = peer ;
	}

	public Coordinate jdToEquatorial( double jd, Coordinate eq ) {
		double l, b, o ;
		double epoch, stretch ;
		CAA2DCoordinate c ;
		Method eclipticLongitude ;
		Method eclipticLatitude ;

		l = 0 ;
		b = 0 ;

		epoch = getEpochAlpha() ;

		if ( getStretch() )
			stretch = Configuration.getValue( this, CK_STRETCH, DEFAULT_STRETCH ) ;
		else
			stretch = 0 ;

		try {
			eclipticLongitude = getClass().getMethod( peer.getType()+"EclipticLongitude", new Class[] { double.class } ) ;
			eclipticLatitude = getClass().getMethod( peer.getType()+"EclipticLatitude", new Class[] { double.class } ) ;

			l = (Double) eclipticLongitude.invoke( null, new Object[] { Double.valueOf( jd ) } ) ;
			b = (Double) eclipticLatitude.invoke( null, new Object[] { Double.valueOf( jd ) } ) ;
		} catch ( NoSuchMethodException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( InvocationTargetException e ) {
			throw new RuntimeException( e.toString() ) ;
		} catch ( IllegalAccessException e ) {
			throw new RuntimeException( e.toString() ) ;
		}

		if ( eq != null ) {
			o = CAANutation.MeanObliquityOfEcliptic( epoch ) ;
			c = CAACoordinateTransformation.Ecliptic2Equatorial( l, b, o ) ;
			eq.x = CAACoordinateTransformation.HoursToDegrees( c.X() ) ;
			eq.y = c.Y() ;
		}

		b += ( jd-epoch )*stretch ; ;
		o = CAANutation.MeanObliquityOfEcliptic( epoch ) ;
		c = CAACoordinateTransformation.Ecliptic2Equatorial( l, b, o ) ;

		return new Coordinate( CAACoordinateTransformation.HoursToDegrees( c.X() ), c.Y() ) ;
	}

	public static double meanEclipticLongitude( double JD ) {
		double rho, rho2, rho3, rho4, rho5 ;

		rho = ( JD-2451545 )/365250 ;
		rho2 = rho*rho ;
		rho3 = rho2*rho ;
		rho4 = rho3*rho ;
		rho5 = rho4*rho ;

		return CAACoordinateTransformation.MapTo0To360Range(
				280.4664567+360007.6982779*rho+0.03032028*rho2+rho3/49931-rho4/15300-rho5/2000000 ) ;
	}

	public static double meanEclipticLatitude( double JD ) {
		return 0 ;
	}

	public static double trueEclipticLongitude( double JD ) {
		return CAASun.GeometricEclipticLongitude( JD, false ) ;
	}

	public static double trueEclipticLatitude( double JD ) {
		return CAASun.GeometricEclipticLatitude( JD, false ) ;
	}
}
