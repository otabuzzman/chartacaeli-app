#include <cmath>

#include "P4Mollweide.h"
#include "Coordinate.h"
#include "Math.h"
using namespace std;

P4Mollweide::P4Mollweide() : V_CON( 1e-7 ),
								radperdeg( 3.141592653589793/180. ) ,
								degperrad( 180./3.141592653589793 ) {
	init( 0, 0, 1, 1 ) ;
}

void P4Mollweide::init( double lam0, double phi1, double R, double k0 ) {
	this->lam0 = lam0 ;
	this->R = R ;
}

Coordinate P4Mollweide::forward( Coordinate lamphi ) {
	Coordinate xy ;
	double tht2 = lamphi.y, dtht2 = 0, sintht2, costht2 ;
	double sinphi, tht, sintht, costht ;

	sinphi = Math::sin( lamphi.y ) ;

	do {
		tht2 = tht2+dtht2 ;

		sintht2 = Math::sin( tht2 ) ;
		costht2 = Math::cos( tht2 ) ;

		dtht2 = -( tht2*radperdeg+sintht2-Math::PI*sinphi )/( 1+costht2 )*degperrad ;
	} while ( std::abs( dtht2 )>V_CON ) ;

	tht = tht2*.5 ;
	sintht = Math::sin( tht ) ;
	costht = Math::cos( tht ) ;

	xy.x = ( std::pow( 8, .5 )/Math::PI )*R*( lamphi.x-lam0 )*costht*radperdeg ;
	xy.y = std::pow( 2, .5 )*R*sintht ;

	return xy ;
}

Coordinate P4Mollweide::inverse( Coordinate xy ) {
	Coordinate lamphi ;
	double tht, sin2tht, costht ;

	tht = Math::asin( xy.y/( std::pow( 2, .5 )*R ) ) ;

	sin2tht = Math::sin( 2*tht ) ;
	lamphi.y = Math::asin( ( 2*tht*radperdeg+sin2tht )/Math::PI ) ;

	if ( std::abs( lamphi.y ) == 90 )
		lamphi.x = lam0 ;
	else {
		costht = Math::cos( tht ) ;
		lamphi.x = lam0+( Math::PI*xy.x/( std::pow( 8, .5 )*R*costht ) )*degperrad ;
	}

	return lamphi ;
}
