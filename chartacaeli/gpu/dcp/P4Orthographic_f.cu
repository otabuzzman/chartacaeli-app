#include <cstdio>
#include <cstdlib>

#include "P4Orthographic.h"
#include "Coordinate.h"
#include "Math.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ P4Orthographic::P4Orthographic() {
	init( 0, 90, 1, 1 ) ;
}

__device__ void P4Orthographic::init( float lam0, float phi1, float R, float k0 ) {
	this->lam0 = lam0 ;
	this->phi1 = phi1 ;
	sincospif( phi1/180, &sinphi1, &cosphi1 ) ;
	this->R = R ;

	if ( phi1 == 90 )
		mode = M_NORTH ;
	else if ( phi1 == -90 )
		mode = M_SOUTH ;
	else if ( phi1 == 0 )
		mode = M_EQUATOR ;
	else
		mode = M_OBLIQUE ;
}

__device__ Coordinate& P4Orthographic::forward( const Coordinate& lamphi, Coordinate& xy ) {
	float sinlamdif, coslamdif ;
	float sinphi, cosphi ;

	sincospif( ( lamphi.x-lam0 )/180, &sinlamdif, &coslamdif ) ;
	sincospif( lamphi.y/180, &sinphi, &cosphi ) ;

	xy.x = R*cosphi*sinlamdif ;

	switch ( mode ) {
	case M_NORTH:
		xy.y = -R*cosphi*coslamdif ;

		break ;
	case M_SOUTH:
		xy.y = R*cosphi*coslamdif ;

		break ;
	case M_EQUATOR:
		xy.y = R*sinphi ;

		break ;
	case M_OBLIQUE:
		xy.y = R*( cosphi1*sinphi-sinphi1*cosphi*coslamdif ) ;

		break ;
	}

	return xy ;
}

__device__ Coordinate& P4Orthographic::inverse( const Coordinate& xy, Coordinate& lamphi ) {
	float p, c, sinc, cosc ;

	p = sqrtf( xy.x*xy.x+xy.y*xy.y ) ;
	c = degrees( asinf( p/R ) ) ;

	sincospif( c/180, &sinc, &cosc ) ;

	lamphi.y = degrees( asinf( cosc*sinphi1+( xy.y*sinc*cosphi1/p ) ) ) ;

	switch ( mode ) {
	case M_NORTH:
		lamphi.x = lam0+degrees( atan2f(xy.x, -xy.y ) ) ;

		break ;
	case M_SOUTH:
		lamphi.x = lam0+degrees( atan2f(xy.x, xy.y ) ) ;

		break ;
	case M_EQUATOR:
	case M_OBLIQUE:
		lamphi.x = lam0+degrees( atan2f( xy.x*sinc, p*cosphi1*cosc-xy.y*sinphi1*sinc ) ) ;

		break ;
	}

	return lamphi ;
}
