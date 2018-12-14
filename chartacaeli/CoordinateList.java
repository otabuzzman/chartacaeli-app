
package chartacaeli;

import com.vividsolutions.jts.geom.Coordinate;

@SuppressWarnings("serial")
public class CoordinateList extends com.vividsolutions.jts.geom.CoordinateList {

	public CoordinateList() {
		super() ;
	}

	public CoordinateList( Coordinate[] c ) {
		super( c ) ;
	}

	public CoordinateList( Coordinate[] c, boolean allowRepeated ) {
		super( c, allowRepeated ) ;
	}

	public boolean isOpen() {
		return ! isClosed() ;
	}

	public boolean isClosed() {
		return 2>size() ? false : getCoordinate( 0 ).equals( getCoordinate( size()-1 ) ) ;
	}

	public static boolean isCloseIntended( chartacaeli.CoordinateList c, int precision ) {
		double realDistanceAO, precDistanceAO ;

		realDistanceAO = c.getCoordinate( 0 ).distance( c.getCoordinate( c.size()-1 ) ) ;
		precDistanceAO = java.lang.Math.round( realDistanceAO*precision )/precision ;

		return precDistanceAO == 0 ;
	}
}
