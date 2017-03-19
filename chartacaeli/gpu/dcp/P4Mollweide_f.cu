#include <cstdio>
#include <cstdlib>

#include <math_constants.h>

#include "P4Mollweide_f.h"
#include "Coordinate_f.h"
#include "Math_f.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ P4Mollweide::P4Mollweide() : V_CON( 1e-7f ),
								radperdeg( 3.141592653589793f/180.f ) ,
								degperrad( 180.f/3.141592653589793f ) {
	init( 0, 0, 1, 1 ) ;
}

__device__ void P4Mollweide::init( float lam0, float phi1, float R, float k0 ) {
	this->lam0 = lam0 ;
	this->R = R ;
}

__device__ Coordinate& P4Mollweide::forward( const Coordinate& lamphi, Coordinate& xy ) {
	float tht2 = lamphi.y, dtht2 = 0, sintht2, costht2 ;
	float sinphi, tht, sintht, costht ;

	sinphi = sinpif( lamphi.y/180 ) ;

	do {
		tht2 = tht2+dtht2 ;

		sincospif( tht2/180, &sintht2, &costht2 ) ;

		dtht2 = -( tht2*radperdeg+sintht2-CUDART_PI_F*sinphi )/( 1+costht2 )*degperrad ;
	} while ( abs( dtht2 )>V_CON ) ;

	tht = tht2*.5f ;
	sincospif( tht/180, &sintht, &costht ) ;

	xy.x = ( 2.82842712475f/CUDART_PI_F )*R*( lamphi.x-lam0 )*costht*radperdeg ;
	xy.y = 1.41421356237f*R*sintht ;

	return xy ;
}

__device__ Coordinate& P4Mollweide::inverse( const Coordinate& xy, Coordinate& lamphi ) {
	float tht, sin2tht, costht ;

	tht = degrees( asinf( xy.y/( 1.41421356237f*R ) ) ) ;

	sin2tht = sinpif( ( 2*tht )/180 ) ;
	lamphi.y = degrees( asinf( ( 2*tht*radperdeg+sin2tht )/CUDART_PI_F ) ) ;

	if ( abs( lamphi.y ) == 90 )
		lamphi.x = lam0 ;
	else {
		costht = cospif( tht/180 ) ;
		lamphi.x = lam0+( CUDART_PI_F*xy.x/( 2.82842712475f*R*costht ) )*degperrad ;
	}

	return lamphi ;
}
