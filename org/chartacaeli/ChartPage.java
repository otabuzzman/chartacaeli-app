
package org.chartacaeli;

import java.util.Date;

import com.vividsolutions.jts.geom.Coordinate;

@SuppressWarnings("serial")
public class ChartPage extends org.chartacaeli.model.ChartPage implements PostscriptEmitter {

	private double[] layCLeftEdge ;
	private double[] layRTopEdge ;

	// configuration key (CK_)
	private final static String CK_PSUNIT			= "psunit" ;
	private final static String CK_LAYOUT			= "layout" ;
	private final static String CK_BACKGROUND		= "background" ;

	private final static double DEFAULT_PSUNIT		= 2.834646 ;
	private final static String DEFAULT_LAYOUT		= "100x100" ;
	private final static String DEFAULT_BACKGROUND	= "1:1:1" ;

	public Coordinate size() {
		String szraw, szdis[] ;

		szraw = Configuration.getValue( this, getSize(), null ) ;
		if ( szraw == null ) {
			szdis = getSize().split( "x" ) ;
		} else {
			szdis = szraw.split( "x" ) ;
		}

		return new Coordinate( Double.parseDouble( szdis[0] ), Double.parseDouble( szdis[1] ) ) ;
	}

	public Coordinate view() {
		Coordinate size ;
		double view, x, y ;

		size = size() ;
		view = getView() ;
		x = size.x*view/100 ;
		y = size.y*view/100 ;

		return new Coordinate( x, y ) ;
	}

	public double[] frame( int num ) {
		String layout ;
		String[] layVRaw, layCRaw, layRRaw ;
		double[] layCVal, layRVal ;
		double colVal, rowVal ;
		int numC, numR, numF ;
		int i, col, row ;
		Coordinate size ;
		double ox, oy, dx, dy ;

		if ( layCLeftEdge == null ) {
			layout = Configuration.getValue( this, CK_LAYOUT, DEFAULT_LAYOUT ) ;
			layVRaw = layout.split( "x" ) ;
			layCRaw = layVRaw[0].split( ":" ) ;
			layRRaw = layVRaw[1].split( ":" ) ;

			layCVal = new double[ layCRaw.length+1 ] ;
			layRVal = new double[ layRRaw.length+1 ] ;
			layCVal[0] = 0 ;
			layRVal[0] = 0 ;

			for ( int c=0 ; c<layCRaw.length ; c++ ) {
				colVal = Double.parseDouble( layCRaw[c] ) ;
				layCVal[c+1] = colVal+layCVal[c] ;
			}
			for ( int r=0 ; r<layRRaw.length ; r++ ) {
				rowVal = Double.parseDouble( layRRaw[r] ) ;
				layRVal[r+1] = rowVal+layRVal[r] ;
			}

			layCLeftEdge = new double[ layCVal.length ] ;
			layRTopEdge = new double[ layRVal.length ] ;

			for ( int c=0 ; c<layCVal.length ; c++ ) {
				layCLeftEdge[c] = layCVal[c]/layCVal[layCVal.length-1] ;
			}
			for ( int r=0 ; r<layRVal.length ; r++ ) {
				layRTopEdge[r] = 1-layRVal[r]/layRVal[layRVal.length-1] ;
			}
		}

		numC = layCLeftEdge.length-1 ;
		numR = layRTopEdge.length-1 ;
		numF = numC*numR ;

		i = ( num-1 )%numF ;
		col = i%numC ;
		row = i/numC ;

		size = size() ;

		ox = -size.x/2+size.x*layCLeftEdge[col] ;
		oy = -size.y/2+size.y*layRTopEdge[row+1] ;

		dx = size.x*( layCLeftEdge[col+1]-layCLeftEdge[col] ) ;
		dy = size.y*( layRTopEdge[row]-layRTopEdge[row+1] ) ;

		return new double[] { ox, oy, dx, dy } ;
	}

	public void headPS( ApplicationPostscriptStream ps ) {
	}

	public void emitPS( ApplicationPostscriptStream ps ) {
		Coordinate size, view[] ;
		double psunit ;
		long seed ;
		String bgv[] ;

		psunit = Configuration.getValue( this, CK_PSUNIT, DEFAULT_PSUNIT ) ;

		ps.dc( "%BeginSetup", null ) ;

		size = size() ;
		ps.dict( true ) ;
		ps.script( "/PageSize" ) ;
		ps.array( true ) ;
		ps.push( size.x*psunit ) ;
		ps.push( size.y*psunit ) ;
		ps.array( false ) ;
		ps.dict( false ) ;
		ps.op( "setpagedevice" ) ;

		seed = new Date().getTime()/1000 ;
		ps.push( seed ) ;
		ps.op( "srand" ) ;

		bgv = Configuration.getValue( this, CK_BACKGROUND, DEFAULT_BACKGROUND ).split( ":" ) ;
		ps.script( "/AVbackground" ) ;
		ps.proc( true ) ;
		ps.push( Double.parseDouble( bgv[0] ) ) ;
		ps.push( Double.parseDouble( bgv[1] ) ) ;
		ps.push( Double.parseDouble( bgv[2] ) ) ;
		ps.proc( false ) ;
		ps.op( "bind" ) ;
		ps.op( "def" ) ;

		ps.dc( "%EndSetup", null ) ;

		ps.dc( "%BeginPageSetup", null ) ;

		ps.push( psunit ) ;
		ps.push( psunit ) ;
		ps.op( "scale" ) ;

		ps.dc( "%EndPageSetup", null ) ;

		view = toViewCoordinateArray() ;
		if ( 100>getView() ) {
			ps.array( true ) ;
			for ( Coordinate xy : view ) {
				ps.push( xy.x ) ;
				ps.push( xy.y ) ;
			}
			ps.array( false ) ;

			ps.op( "newpath" ) ;
			ps.op( "gdraw" ) ;

			ps.op( "stroke" ) ;
		}

		ps.push( view[0].x ) ;
		ps.push( view[0].y ) ;
		ps.op( "moveto" ) ;
	}

	public void tailPS( ApplicationPostscriptStream ps ) {
	}

	public Coordinate[] toViewCoordinateArray() {
		Coordinate view ;
		double x, y ;

		view = view() ;
		x = view.x/2 ;
		y = view.y/2 ;

		return new Coordinate[] {
				new Coordinate( -x, y ),
				new Coordinate( -x, -y ),
				new Coordinate( x, -y ),
				new Coordinate( x, y ),
				new Coordinate( -x, y ),
		} ;
	}
}
