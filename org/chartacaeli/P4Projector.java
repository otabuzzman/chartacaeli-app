
package org.chartacaeli;

import com.vividsolutions.jts.geom.Coordinate;

public interface P4Projector extends Cloneable {
	public void init( double lam0, double phi1, double R, double k0 ) ;
	public double lam0() ;
	public double phi1() ;
	public double R() ;
	public double k0() ;
	public Coordinate forward( Coordinate lamphi ) ;
	public Coordinate inverse( Coordinate xy ) ;
	public Object clone() ;
}
