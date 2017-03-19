#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "P4Stereographic_f.h"
#include "Coordinate_f.h"
#include "Math_f.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ P4Stereographic::P4Stereographic() {
	init( 0, 90, 1, 1 ) ;
}

__device__ void P4Stereographic::init( float lam0, float phi1, float R, float k0 ) {
	this->lam0 = lam0 ;
	this->phi1 = phi1 ;
	sincospif( phi1/180, &sinphi1, &cosphi1 ) ;
	this->R = R ;
	this->k0 = k0 ;

	if ( phi1 == 90 )
		mode = M_NORTH ;
	else if ( phi1 == -90 )
		mode = M_SOUTH ;
	else if ( phi1 == 0 )
		mode = M_EQUATOR ;
	else
		mode = M_OBLIQUE ;
}

__device__ Coordinate& P4Stereographic::forward( const Coordinate& lamphi, Coordinate& xy ) {
	float sinlamdif, coslamdif ;
	float sinphi, cosphi, k, t ;

	sincospif( ( lamphi.x-lam0 )/180, &sinlamdif, &coslamdif ) ;
	sincospif( lamphi.y/180, &sinphi, &cosphi ) ;

	switch ( mode ) {
	case M_NORTH:
		t = __tanf( radians( 45-lamphi.y/2 ) ) ;
		xy.x = 2*R*k0*t*sinlamdif ;
		xy.y = -2*R*k0*t*coslamdif ;

		break ;
	case M_SOUTH:
		t = __tanf( radians( 45+lamphi.y/2 ) ) ;
		xy.x = 2*R*k0*t*sinlamdif ;
		xy.y = 2*R*k0*t*coslamdif ;

		break ;
	case M_EQUATOR:
		k = 2*k0/( 1+cosphi*coslamdif ) ;
		xy.x = R*k*cosphi*sinlamdif ;
		xy.y = R*k*sinphi ;

		break ;
	case M_OBLIQUE:
		k = 2*k0/( 1+sinphi1*sinphi+cosphi1*cosphi*coslamdif ) ;
		xy.x = R*k*cosphi*sinlamdif ;
		xy.y = R*k*( cosphi1*sinphi-sinphi1*cosphi*coslamdif ) ;

		break ;
	}

	return xy ;
}

__device__ Coordinate& P4Stereographic::inverse( const Coordinate& xy, Coordinate& lamphi ) {
	float p, c, sinc, cosc ;

	p = sqrtf( xy.x*xy.x+xy.y*xy.y ) ;
	c = 2*degrees( atan2f( p, 2*R*k0 ) ) ;

	sincospif( c/180, &sinc, &cosc ) ;

	lamphi.y = degrees( asinf( cosc*sinphi1+( xy.y*sinc*cosphi1/p ) ) ) ;

	switch ( mode ) {
	case M_NORTH:
		lamphi.x = lam0+degrees( atan2f( xy.x, -xy.y ) ) ;

		break ;
	case M_SOUTH:
		lamphi.x = lam0+degrees( atan2f( xy.x, xy.y ) ) ;

		break ;
	case M_EQUATOR:
	case M_OBLIQUE:
		lamphi.x = lam0+degrees( atan2f( xy.x*sinc, p*cosphi1*cosc-xy.y*sinphi1*sinc ) ) ;

		break ;
	}

	return lamphi ;
}
