#include <cmath>

#include "P4Mollweide.h"
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

double *P4Mollweide::forward( double lamphi[3] ) {
	double *xy = new double[3] ;
	double tht2 = lamphi[1], dtht2 = 0, sintht2, costht2 ;
	double sinphi, tht, sintht, costht ;

	sinphi = Math::sin( lamphi[1] ) ;

	do {
		tht2 = tht2+dtht2 ;

		sintht2 = Math::sin( tht2 ) ;
		costht2 = Math::cos( tht2 ) ;

		dtht2 = -( tht2*radperdeg+sintht2-Math::PI*sinphi )/( 1+costht2 )*degperrad ;
	} while ( std::abs( dtht2 )>V_CON ) ;

	tht = tht2*.5 ;
	sintht = Math::sin( tht ) ;
	costht = Math::cos( tht ) ;

	xy[0] = ( std::pow( 8, .5 )/Math::PI )*R*( lamphi[0]-lam0 )*costht*radperdeg ;
	xy[1] = std::pow( 2, .5 )*R*sintht ;

	return xy ;
}

double *P4Mollweide::inverse( double xy[3] ) {
	double *lamphi = new double[3] ;
	double tht, sin2tht, costht ;

	tht = Math::asin( xy[1]/( std::pow( 2, .5 )*R ) ) ;

	sin2tht = Math::sin( 2*tht ) ;
	lamphi[1] = Math::asin( ( 2*tht*radperdeg+sin2tht )/Math::PI ) ;

	if ( std::abs( lamphi[1] ) == 90 )
		lamphi[0] = lam0 ;
	else {
		costht = Math::cos( tht ) ;
		lamphi[0] = lam0+( Math::PI*xy[0]/( std::pow( 8, .5 )*R*costht ) )*degperrad ;
	}

	return lamphi ;
}
