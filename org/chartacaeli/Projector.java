
package org.chartacaeli;

import com.vividsolutions.jts.geom.Coordinate;

public interface Projector extends Cloneable {
	public Coordinate project( Coordinate celestial, boolean inverse ) ;
	public Object clone() ;
}
