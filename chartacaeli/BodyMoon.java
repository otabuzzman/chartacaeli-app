
package chartacaeli;

import com.vividsolutions.jts.geom.Coordinate;

import chartacaeli.caa.CAA2DCoordinate;
import chartacaeli.caa.CAACoordinateTransformation;
import chartacaeli.caa.CAAMoon;
import chartacaeli.caa.CAANutation;

@SuppressWarnings("serial")
public class BodyMoon extends BodyOrbitalType {

	// configuration key (CK_)
	private final static String CK_STRETCH			= "stretch" ;

	private final static double DEFAULT_STRETCH		= 0 ;

	public BodyMoon( Converter converter, Projector projector ) {
		super( converter, projector ) ;
	}

	public Coordinate jdToEquatorial( double jd, Coordinate eq ) {
		double l, b, o ;
		double epoch, stretch ;
		CAA2DCoordinate c ;

		epoch = getEpochAlpha() ;

		if ( getStretch() )
			stretch = Configuration.getValue( this, CK_STRETCH, DEFAULT_STRETCH ) ;
		else
			stretch = 0 ;

		l = CAAMoon.EclipticLongitude( jd ) ;
		b = CAAMoon.EclipticLatitude( jd ) ;

		if ( eq != null ) {
			o = CAANutation.MeanObliquityOfEcliptic( epoch ) ;
			c = CAACoordinateTransformation.Ecliptic2Equatorial( l, b, o ) ;
			eq.x = CAACoordinateTransformation.HoursToDegrees( c.X() ) ;
			eq.y = c.Y() ;
		}

		b += ( jd-epoch )*stretch ;
		o = CAANutation.MeanObliquityOfEcliptic( epoch ) ;
		c = CAACoordinateTransformation.Ecliptic2Equatorial( l, b, o ) ;

		return new Coordinate( CAACoordinateTransformation.HoursToDegrees( c.X() ), c.Y() ) ;
	}
}
