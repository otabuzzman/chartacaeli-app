
package org.chartacaeli;

import java.util.Calendar;

import org.chartacaeli.caa.CAADate;

@SuppressWarnings("serial")
public class Epoch extends org.chartacaeli.model.Epoch {

	private double alpha = Double.NEGATIVE_INFINITY ;
	private double omega = Double.NEGATIVE_INFINITY ;

	public double alpha() {
		int y ;
		CAADate a ;

		if ( alpha>Double.NEGATIVE_INFINITY )
			return alpha ;

		if ( getCalendar() != null )
			return alpha = valueOf( getCalendar() ) ;
		if ( getJD() != null )
			return alpha = valueOf( getJD() ) ;

		y = Calendar.getInstance().get( Calendar.YEAR ) ;
		a = new CAADate( y, 1, 1, 12, 0, 0, y>1582?true:false ) ;
		alpha = a.Julian() ;
		a.delete() ;

		setJD( new org.chartacaeli.model.JD() ) ;
		getJD().setValue( alpha ) ;

		return alpha ;
	}

	public double finis() {
		if ( omega>Double.NEGATIVE_INFINITY )
			return omega ;

		if ( getFinis() != null ) {
			if ( getFinis().getCalendar() != null )
				return omega = valueOf( getFinis().getCalendar() ) ;
			return omega = valueOf( getFinis().getJD() ) ;
		}

		return omega = alpha+365 ;
	}
}
