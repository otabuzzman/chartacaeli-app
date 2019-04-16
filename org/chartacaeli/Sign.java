
package org.chartacaeli;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

import org.chartacaeli.model.SignType;

@SuppressWarnings("serial")
public class Sign extends org.chartacaeli.model.Sign implements PostscriptEmitter {

	// configuration key (CK_), node (CN_)
	private final static String CK_SHORTENING		= "shortening" ;
	private final static String CK_HALO				= "halo" ;
	private final static String CK_HALOMIN			= "halomin" ;
	private final static String CK_HALOMAX			= "halomax" ;

	private final static double DEFAULT_HALO		= 4 ;
	private final static double DEFAULT_HALOMIN		= .08 ;
	private final static double DEFAULT_HALOMAX		= .4 ;
	private final static double DEFAULT_SHORTENING	= 2.62 ;

	private Projector projector ;

	public Sign( Projector projector ) {
		this.projector = projector ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
		String gstate ;

		if ( ( gstate = Configuration.getValue( this, getNature(), null ) ) == null )
			return ;
		ps.script( gstate ) ;
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		emitPS( ps, this ) ;
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
	}

	private void emitPS( ApplicationPostscriptStream ps, SignType limb ) {
		double shortening ;
		Vector va, vb, vc, vca, vco ;
		Geometry eovG, ab, l ;
		Coordinate a, b ;
		Configuration conf ;
		org.chartacaeli.model.Annotation annotation ;
		PostscriptEmitter emitter ;

		shortening = Configuration.getValue( this, CK_SHORTENING, DEFAULT_SHORTENING ) ;

		a = projector.project( valueOf( limb.getPosition( 0 ) ), false ) ;
		b = projector.project( valueOf( limb.getPosition( 1 ) ), false ) ;

		if ( a.distance( b )>2*shortening ) {
			va = new Vector( a ) ;
			vb = new Vector( b ) ;
			vc = vb.sub( va ) ;
			vca = new Vector( va ).add( new Vector( vc ).scale( shortening ) ) ;
			vco = new Vector( va ).add( new Vector( vc ).scale( vc.abs()-shortening ) ) ;

			ab = l = new GeometryFactory().createLineString( new Coordinate[] { vca, vco } ) ;
		} else
			ab = l = new GeometryFactory().createLineString( new Coordinate[] { a, b } ) ;

		eovG = FieldOfView.createEOVGeometry() ;
		if ( eovG != null && eovG.intersects( ab ) ) {
			if ( ! eovG.contains( ab ) )
				l = eovG.intersection( ab ) ;

			ps.array( true ) ;
			for ( Coordinate xy : l.getCoordinates() ) {
				ps.push( xy.x ) ;
				ps.push( xy.y ) ;
			}
			ps.array( false ) ;

			ps.op( "newpath" ) ;
			ps.op( "gdraw" ) ;

			// halo stroke
			ps.op( "currentlinewidth" ) ;

			ps.op( "dup" ) ;
			ps.push( 100 ) ;
			ps.op( "div" ) ;
			conf = new Configuration( this ) ;
			ps.push( conf.getValue( CK_HALO, DEFAULT_HALO ) ) ;
			ps.op( "mul" ) ;
			ps.push( conf.getValue( CK_HALOMIN, DEFAULT_HALOMIN ) ) ;
			ps.op( "max" ) ;
			ps.push( conf.getValue( CK_HALOMAX, DEFAULT_HALOMAX ) ) ;
			ps.op( "min" ) ;

			ps.push( 2 ) ;
			ps.op( "mul" ) ;
			ps.op( "add" ) ;
			ps.op( "gsave" ) ;
			ps.op( "setlinewidth" ) ;
			ps.push( 1 ) ;
			ps.op( "setlinecap" ) ;
			ps.array( true ) ;
			ps.array( false ) ;
			ps.push( 0 ) ;
			ps.op( "setdash" ) ;
			ps.push( 1 ) ;
			ps.op( "setgray" ) ;
			ps.op( "stroke" ) ;
			ps.op( "grestore" ) ;

			ps.op( "stroke" ) ;

			if ( limb.getAnnotation() != null ) {
				annotation = limb.getAnnotation() ;

				if ( annotation.getAnnotationStraight() != null ) {
					emitter = annotation( annotation.getAnnotationStraight() ) ;
				} else { // annotation.getAnnotationCurved() != null
					emitter = annotation( annotation.getAnnotationCurved() ) ;
				}

				ps.op( "gsave" ) ;

				emitter.headPS( ps ) ;
				emitter.emitPS( ps ) ;
				emitter.tailPS( ps ) ;

				ps.op( "grestore" ) ;
			}
		}

		if ( limb.getLimb() != null )
			emitPS( ps, limb.getLimb() ) ;
	}

	private PostscriptEmitter annotation( org.chartacaeli.model.AnnotationStraight peer ) {
		AnnotationStraight annotation ;

		annotation = new AnnotationStraight() ;
		peer.copyValues( annotation ) ;

		return annotation ;
	}

	private PostscriptEmitter annotation( org.chartacaeli.model.AnnotationCurved peer ) {
		AnnotationCurved annotation ;

		annotation = new AnnotationCurved() ;
		peer.copyValues( annotation ) ;

		return annotation ;
	}
}
