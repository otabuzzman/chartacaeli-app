
package chartacaeli;

import caa.CAANutation;

@SuppressWarnings("serial")
public class CircleSouthernPolar extends CircleParallel {

	public CircleSouthernPolar( Converter converter, Projector projector ) {
		super( converter, projector ) ;
	}

	public chartacaeli.model.Angle getAngle() {
		chartacaeli.model.Angle r ;
		double e, o ;
		Epoch epoch ;

		epoch = (Epoch) Registry.retrieve( Epoch.class.getName() ) ;
		if ( epoch == null )
			e = new Epoch().alpha() ;
		else
			e = epoch.alpha() ;
		o = CAANutation.MeanObliquityOfEcliptic( e ) ;

		r = new chartacaeli.model.Angle() ;
		r.setRational( new chartacaeli.model.Rational() ) ;
		r.getRational().setValue( -90+o ) ;

		return r ;
	}
}
