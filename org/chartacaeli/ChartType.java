
package org.chartacaeli;

import com.vividsolutions.jts.geom.Coordinate;

@SuppressWarnings("serial")
abstract public class ChartType extends org.chartacaeli.model.ChartType implements PostscriptEmitter, Projector {

	public ChartType( org.chartacaeli.model.ChartType peer ) {
		peer.copyValues( this ) ;
	}

	public double scale() {
		ChartPage page ;
		Coordinate view ;

		page = new ChartPage() ;
		getChartPage().copyValues( page ) ;
		view = page.view() ;

		return view.x/2*getScale()/100 ;
	}

	public void register() {
		ChartPage page ;
		FieldOfView gov ;

		page = new ChartPage() ;
		getChartPage().copyValues( page ) ;
		Registry.register( ChartPage.class.getName(), page ) ;

		try {
			gov = new FieldOfView( page.toViewCoordinateArray() ) ;
			Registry.register( "G"+FieldOfView.class.getName(), gov ) ;
		} catch ( ParameterNotValidException e ) {}
	}

	public void degister() {
		Registry.degister( ChartPage.class.getName() ) ;
		Registry.degister( "G"+FieldOfView.class.getName() ) ;
		Registry.degister( "C"+FieldOfView.class.getName() ) ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
		ChartPage page ;

		page = new ChartPage() ;
		getChartPage().copyValues( page ) ;

		page.headPS( ps ) ;
		page.emitPS( ps ) ;
		page.tailPS( ps ) ;
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		org.chartacaeli.model.Horizon horizon ;

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

	public Object clone() {
		try {
			return (ChartType) super.clone() ;
		} catch ( CloneNotSupportedException e ) {
			return null ;
		}
	}

	private void horizon( ApplicationPostscriptStream ps, org.chartacaeli.model.HorizonLocal peer ) {
		HorizonLocal horizon ;

		horizon = new HorizonLocal( peer, this ) ;
		peer.copyValues( horizon ) ;

		horizon.register() ;
		emitPS( ps, horizon ) ;
		horizon.degister() ;
	}

	private void horizon( ApplicationPostscriptStream ps, org.chartacaeli.model.HorizonEquatorial peer ) {
		HorizonEquatorial horizon ;

		horizon = new HorizonEquatorial( peer, this ) ;
		peer.copyValues( horizon ) ;

		emitPS( ps, horizon ) ;
	}

	private void horizon( ApplicationPostscriptStream ps, org.chartacaeli.model.HorizonEcliptical peer ) {
		HorizonEcliptical horizon ;

		horizon = new HorizonEcliptical( this ) ;
		peer.copyValues( horizon ) ;

		horizon.register() ;
		emitPS( ps, horizon ) ;
		horizon.degister() ;
	}

	private void horizon( ApplicationPostscriptStream ps, org.chartacaeli.model.HorizonGalactic peer ) {
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
