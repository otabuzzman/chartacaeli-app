#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Coordinate.h"
#include "Math.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Coordinate::Coordinate() : x( 0 ), y( 0 ), z( 0 ) {
}

__device__ Coordinate::Coordinate( const Coordinate& c ) {
	set( c.x, c.y, c.z ) ;
}

__device__ Coordinate::Coordinate( float x, float y, float z ) {
	set( x, y, z ) ;
}

__device__ void Coordinate::set( float x, float y, float z ) {
	this->x = x ;
	this->y = y ;
	this->z = z ;
}

__device__ void Coordinate::spherical() {
	float r = sqrtf( x*x+y*y+z*z ) ;

	x = degrees( atan2f( y, x ) ) ;
	y = degrees( asinf( z/r ) ) ;
	z = 0 ;
}

__device__ void Coordinate::cartesian() {
	float sinx, cosx, siny, cosy ;

	sincospif( x/180, &sinx, &cosx ) ;
	sincospif( y/180, &siny, &cosy ) ;

	x = cosy*cosx ;
	y = cosy*sinx ;
	z = siny ;
}
