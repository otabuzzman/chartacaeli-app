
package chartacaeli;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

@SuppressWarnings("serial")
abstract public class ChartType extends chartacaeli.model.ChartType implements PostscriptEmitter, Projector {

	public double scale() {
		ChartPage page ;
		double x, view[] ;

		page = (ChartPage) Registry.retrieve( ChartPage.class.getName() ) ;
		if ( page == null ) {
			page = new ChartPage() ;
			getChartPage().copyValues( page ) ;
		}

		view = page.view() ;
		x = view[0]/2 ;

		return x*getScale()/100 ;
	}

	public void register() {
		ChartPage page ;
		FieldOfView fov ;

		page = new ChartPage() ;
		getChartPage().copyValues( page ) ;
		Registry.register( ChartPage.class.getName(), page ) ;
		try {
			fov = new FieldOfView( new Coordinate[0] ) ;
			Registry.register( FieldOfView.class.getName(), fov ) ;
		} catch ( Exception e ) {}
	}

	public void degister() {
		Registry.degister( ChartPage.class.getName() ) ;
		Registry.degister( FieldOfView.class.getName() ) ;
	}

	public static Geometry findFieldOfView() {
		return findFieldOfView( false ) ;
	}

	public static Geometry findFieldOfView( boolean global ) {
		FieldOfView fov ;
		ChartPage page ;
		Geometry gov ;

		page = (ChartPage) Registry.retrieve( ChartPage.class.getName() ) ;
		if ( page != null )
			gov = FieldOfView.makeGeometry( page.getViewRectangle(), true ) ;
		else
			gov = null ;

		if ( global )
			return gov ;

		fov = (FieldOfView) Registry.retrieve( FieldOfView.class.getName() ) ;
		if ( fov != null && fov.isClosed() )
			return fov.makeGeometry() ;	
		return gov ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
		ChartPage page ;

		page = (ChartPage) Registry.retrieve( ChartPage.class.getName() ) ;
		if ( page == null ) {
			page = new ChartPage() ;
			getChartPage().copyValues( page ) ;
		}

		page.headPS( ps ) ;
		page.emitPS( ps ) ;
		page.tailPS( ps ) ;
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		chartacaeli.model.Horizon horizon ;

		for ( int ho=0 ; ho<getHorizonCount() ; ho++ ) {
			horizon = getHorizon( ho ) ;

			if ( horizon.getHorizonLocal() != null ) {
				horizon( ps, horizon.getHorizonLocal() ) ;
			} else if ( horizon.getHorizonEquatorial() != null ) {
				horizon( ps, horizon.getHorizonEquatorial() ) ;
			} else if ( horizon.getHorizonEcliptical() != null ) {
				horizon( ps, horizon.getHorizonEcliptical() ) ;
			} else { // horizon.getHorizonGalactic() != null
				horizon( ps, horizon.getHorizonGalactic() ) ;
			}
		}
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
		ps.op( "showpage" ) ;
		ps.dc( "%PageTrailer", null ) ;
	}

	abstract public Coordinate project( Coordinate celestial, boolean inverse ) ;

	private void horizon( ApplicationPostscriptStream ps, chartacaeli.model.HorizonLocal peer ) {
		HorizonLocal horizon ;

		horizon = new HorizonLocal( peer, this ) ;
		peer.copyValues( horizon ) ;

		horizon.register() ;
		emitPS( ps, horizon ) ;
		horizon.degister() ;
	}

	private void horizon( ApplicationPostscriptStream ps, chartacaeli.model.HorizonEquatorial peer ) {
		HorizonEquatorial horizon ;

		horizon = new HorizonEquatorial( peer, this ) ;
		peer.copyValues( horizon ) ;

		emitPS( ps, horizon ) ;
	}

	private void horizon( ApplicationPostscriptStream ps, chartacaeli.model.HorizonEcliptical peer ) {
		HorizonEcliptical horizon ;

		horizon = new HorizonEcliptical( this ) ;
		peer.copyValues( horizon ) ;

		horizon.register() ;
		emitPS( ps, horizon ) ;
		horizon.degister() ;
	}

	private void horizon( ApplicationPostscriptStream ps, chartacaeli.model.HorizonGalactic peer ) {
		HorizonGalactic horizon ;

		horizon = new HorizonGalactic( this ) ;
		peer.copyValues( horizon ) ;

		horizon.register() ;
		emitPS( ps, horizon ) ;
		horizon.degister() ;
	}

	private void emitPS( ApplicationPostscriptStream ps, PostscriptEmitter emitter ) {
		ps.op( "gsave" ) ;

		emitter.headPS( ps ) ;
		emitter.emitPS( ps ) ;
		emitter.tailPS( ps ) ;

		ps.op( "grestore" ) ;
	}
}
