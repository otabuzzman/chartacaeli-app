
package org.chartacaeli;

import java.util.Hashtable;

import com.vividsolutions.jts.geom.Coordinate;

@SuppressWarnings("serial")
public class ChartAzimuthal extends ChartType {

	// configuration key (CK_)
	public final static String CK_DEFOBLIQUELON			= "defobliquelon" ;
	public final static String CK_DEFOBLIQUELAT			= "defobliquelat" ;

	public final static double DEFAULT_DEFOBLIQUELON	= 0 ;
	public final static double DEFAULT_DEFOBLIQUELAT	= 90 ;

	// attribute value (AV_)
	private final static String AV_ORTHOGRAPHIC			= "orthographic" ;
	private final static String AV_STEREOGRAPHIC		= "stereographic" ;

	private final static Hashtable<String, P4Projector> projection = new Hashtable<String, P4Projector>() ;

	private P4Projector projector ;

	public ChartAzimuthal( org.chartacaeli.model.ChartAzimuthal peer ) {
		super( peer ) ;

		double lam0, phi1, R ;

		if ( getOblique() == null ) {
			lam0 = Configuration.getValue( this, CK_DEFOBLIQUELON, DEFAULT_DEFOBLIQUELON ) ;
			phi1 = Configuration.getValue( this, CK_DEFOBLIQUELAT, DEFAULT_DEFOBLIQUELAT ) ;
		} else {
			lam0 = valueOf( getOblique().getLongitude() ) ;
			phi1 = valueOf( getOblique().getLatitude() ) ;
		}

		R = scale() ;

		projector = projection.get( peer.getProjection() ) ;
		projector.init( lam0, phi1, R, 1 ) ;
	}

	public Coordinate project( Coordinate coordinate, boolean inverse ) {
		return inverse ?
				projector.inverse( coordinate ) :
					projector.forward( coordinate ) ;
	}

	public Object clone() {
		ChartAzimuthal clone ;

		clone = (ChartAzimuthal) super.clone() ;
		clone.projector = (P4Projector) projector.clone() ;

		return clone ;
	}

	public void register() {
		super.register() ;

		Registry.register( P4Projector.class.getName(), projector ) ;
	}

	public void degister() {
		super.degister() ;

		Registry.degister( P4Projector.class.getName() ) ;
	}

	static {
		projection.put( AV_ORTHOGRAPHIC, new P4Orthographic() ) ;
		projection.put( AV_STEREOGRAPHIC, new P4Stereographic() ) ;
	}
}
