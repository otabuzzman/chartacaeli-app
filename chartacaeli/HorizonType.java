
package chartacaeli;

import com.vividsolutions.jts.geom.Coordinate;

@SuppressWarnings("serial")
abstract public class HorizonType extends chartacaeli.model.HorizonType implements PostscriptEmitter, Converter {

	// configuration key (CK_)
	private final static String CK_PRECISION	= "precision" ;

	private final static int DEFAULT_PRECISION	= 2 ;

	private Projector projector ;

	public HorizonType( Projector projector ) {
		this.projector = projector ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
		String gstate ;

		if ( ( gstate = Configuration.getValue( this, getPracticality(), null ) ) == null )
			return ;
		ps.script( gstate ) ;
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		chartacaeli.model.Circle circle ;
		chartacaeli.model.Body body ;
		PostscriptEmitter emitter ;

		for ( int an=0 ; an<getAnnotationStraightCount() ; an++ ) {
			emitter = new AnnotationStraight() ;
			getAnnotationStraight( an ).copyValues( emitter ) ;

			ps.op( "gsave" ) ;

			emitter.headPS( ps ) ;
			emitter.emitPS( ps ) ;
			emitter.tailPS( ps ) ;

			ps.op( "grestore" ) ;
		}

		for ( int cl=0 ; cl<getCircleCount() ; cl++ ) {
			circle = getCircle( cl ) ;

			if ( circle.getCircleParallel() != null ) {
				circle( ps, circle.getCircleParallel() ) ;
			} else if ( circle.getCircleMeridian() != null ) {
				circle( ps, circle.getCircleMeridian() ) ;
			} else if ( circle.getCircleSouthernPolar() != null ) {
				circle( ps, circle.getCircleSouthernPolar() ) ;
			} else if ( circle.getCircleNorthernPolar() != null ) {
				circle( ps, circle.getCircleNorthernPolar() ) ;
			} else if (  circle.getCircleSouthernTropic() != null ) {
				circle( ps, circle.getCircleSouthernTropic() ) ;
			} else { // circle.getCircleNorthernTropic() != null
				circle( ps, circle.getCircleNorthernTropic() ) ;
			}
		}

		for ( int bd=0 ; bd<getBodyCount() ; bd++ ) {
			body = getBody( bd ) ;

			if ( body.getBodyStellar() != null ) {
				body( ps, body.getBodyStellar() ) ;
			} else if ( body.getBodyAreal() != null ) {
				body( ps, body.getBodyAreal() ) ;
			} else if ( body.getBodyPlanet() != null ) {
				body( ps, body.getBodyPlanet() ) ;
			} else if ( body.getBodyMoon() != null ) {
				body( ps, body.getBodyMoon() ) ;
			} else if ( body.getBodySun() != null ) {
				body( ps, body.getBodySun() ) ;
			} else if ( body.getBodyElliptical() != null ) {
				body( ps, body.getBodyElliptical() ) ;
			} else { // body.getBodyParabolical() != null
				body( ps, body.getBodyParabolical() ) ;
			}
		}
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
	}

	abstract public Coordinate convert( Coordinate local, boolean inverse ) ;

	private void circle( ApplicationPostscriptStream ps, chartacaeli.model.CircleMeridian peer ) {
		CircleMeridian circle ;

		circle = new CircleMeridian( this, projector ) ;
		peer.copyValues( circle ) ;

		circle.register() ;
		emitPS( ps, circle ) ;
		circle.degister() ;

		if ( circle.getName() != null )
			Registry.register( circle.getName(), circle ) ;

		if ( circle.getFieldofview() )
			updateFieldOfView( circle.list( circle.alpha(), circle.omega() ) ) ;
	}

	private void circle( ApplicationPostscriptStream ps, chartacaeli.model.CircleParallel peer ) {
		CircleParallel circle ;

		circle = new CircleParallel( this, projector ) ;
		peer.copyValues( circle ) ;

		circle.register() ;
		emitPS( ps, circle ) ;
		circle.degister() ;

		if ( circle.getName() != null )
			Registry.register( circle.getName(), circle ) ;

		if ( circle.getFieldofview() )
			updateFieldOfView( circle.list( circle.alpha(), circle.omega() ) ) ;
	}

	private void circle( ApplicationPostscriptStream ps, chartacaeli.model.CircleNorthernPolar peer ) {
		CircleNorthernPolar circle ;

		circle = new CircleNorthernPolar( this, projector ) ;
		peer.copyValues( circle ) ;

		circle.register() ;
		emitPS( ps, circle ) ;
		circle.degister() ;

		if ( circle.getName() != null )
			Registry.register( circle.getName(), circle ) ;

		if ( circle.getFieldofview() )
			updateFieldOfView( circle.list( circle.alpha(), circle.omega() ) ) ;
	}

	private void circle( ApplicationPostscriptStream ps, chartacaeli.model.CircleNorthernTropic peer ) {
		CircleNorthernTropic circle ;

		circle = new CircleNorthernTropic( this, projector ) ;
		peer.copyValues( circle ) ;

		circle.register() ;
		emitPS( ps, circle ) ;
		circle.degister() ;

		if ( circle.getName() != null )
			Registry.register( circle.getName(), circle ) ;

		if ( circle.getFieldofview() )
			updateFieldOfView( circle.list( circle.alpha(), circle.omega() ) ) ;
	}

	private void circle( ApplicationPostscriptStream ps, chartacaeli.model.CircleSouthernTropic peer ) {
		CircleSouthernTropic circle ;

		circle = new CircleSouthernTropic( this, projector ) ;
		peer.copyValues( circle ) ;

		circle.register() ;
		emitPS( ps, circle ) ;
		circle.degister() ;

		if ( circle.getName() != null )
			Registry.register( circle.getName(), circle ) ;

		if ( circle.getFieldofview() )
			updateFieldOfView( circle.list( circle.alpha(), circle.omega() ) ) ;
	}

	private void circle( ApplicationPostscriptStream ps, chartacaeli.model.CircleSouthernPolar peer ) {
		CircleSouthernPolar circle ;

		circle = new CircleSouthernPolar( this, projector ) ;
		peer.copyValues( circle ) ;

		circle.register() ;
		emitPS( ps, circle ) ;
		circle.degister() ;

		if ( circle.getName() != null )
			Registry.register( circle.getName(), circle ) ;

		if ( circle.getFieldofview() )
			updateFieldOfView( circle.list( circle.alpha(), circle.omega() ) ) ;
	}

	private void updateFieldOfView( Coordinate[] line ) {
		FieldOfView fov ;
		Coordinate l[], a, o ;
		double p ;
		int e ;

		l = line ;
		a = new Coordinate( l[0] ) ;
		o = new Coordinate( l[l.length-1] ) ;

		if ( ! a.equals2D( o ) ) {
			e = Configuration.getValue( this, CK_PRECISION, DEFAULT_PRECISION ) ;
			p = java.lang.Math.pow( 10, e ) ;

			a.x = java.lang.Math.round( a.x*p )/p ;
			a.y = java.lang.Math.round( a.y*p )/p ;
			o.x = java.lang.Math.round( o.x*p )/p ;
			o.y = java.lang.Math.round( o.y*p )/p ;

			if ( a.equals2D( o ) ) {
				l = new Coordinate[line.length+1] ;
				l[l.length-1] = new Coordinate( line[0] ) ;
				System.arraycopy( line, 0, l, 0, line.length ) ;
			}
		}

		fov = (FieldOfView) Registry.retrieve( FieldOfView.class.getName() ) ;
		if ( fov == null )
			return ;
		fov.add( l ) ;

		Registry.degister( FieldOfView.class.getName() ) ;
		Registry.register( FieldOfView.class.getName(), fov ) ;
	}

	private void body( ApplicationPostscriptStream ps, chartacaeli.model.BodyStellar peer ) {
		BodyStellar body ;

		body = new BodyStellar( this, projector ) ;
		peer.copyValues( body ) ;

		body.register() ;
		emitPS( ps, body ) ;
		body.degister() ;
	}

	private void body( ApplicationPostscriptStream ps, chartacaeli.model.BodyAreal peer ) {
		BodyAreal body ;

		body = new BodyAreal( this, projector ) ;
		peer.copyValues( body ) ;

		body.register() ;
		emitPS( ps, body ) ;
		body.degister() ;
	}

	private void body( ApplicationPostscriptStream ps, chartacaeli.model.BodySun peer ) {
		BodySun body ;

		body = new BodySun( peer, this, projector ) ;
		peer.copyValues( body ) ;

		emitPS( ps, body ) ;
	}

	private void body( ApplicationPostscriptStream ps, chartacaeli.model.BodyMoon peer ) {
		BodyMoon body ;

		body = new BodyMoon( this, projector ) ;
		peer.copyValues( body ) ;

		emitPS( ps, body ) ;
	}

	private void body( ApplicationPostscriptStream ps, chartacaeli.model.BodyPlanet peer ) {
		BodyPlanet body ;

		body = new BodyPlanet( peer, this, projector ) ;
		peer.copyValues( body ) ;

		emitPS( ps, body ) ;
	}

	private void body( ApplicationPostscriptStream ps, chartacaeli.model.BodyElliptical peer ) {
		BodyElliptical body ;

		body = new BodyElliptical( peer, this, projector ) ;
		peer.copyValues( body ) ;

		emitPS( ps, body ) ;
	}

	private void body( ApplicationPostscriptStream ps, chartacaeli.model.BodyParabolical peer ) {
		BodyParabolical body ;

		body = new BodyParabolical( peer, this, projector ) ;
		peer.copyValues( body ) ;

		emitPS( ps, body ) ;
	}

	private void emitPS( ApplicationPostscriptStream ps, PostscriptEmitter emitter ) {
		ps.op( "gsave" ) ;

		emitter.headPS( ps ) ;
		emitter.emitPS( ps ) ;
		emitter.tailPS( ps ) ;

		ps.op( "grestore" ) ;
	}
}
