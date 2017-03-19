#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Plane_f.h"
#include "Vector3D_f.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Plane::Plane( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) {
	set( p1, p2, p3 ) ;
}

__device__ Plane::Plane(
					const float p1x, const float p1y, const float p1z,
					const float p2x, const float p2y, const float p2z,
					const float p3x, const float p3y, const float p3z ) {
	Vector3D p1( p1x, p1y, p1z ) ;
	Vector3D p2( p2x, p2y, p2z ) ;
	Vector3D p3( p3x, p3y, p3z ) ;
	set( p1, p2, p3 ) ;
}

// https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection#Algebraic_form
__device__ Vector3D& Plane::intersection( const Vector3D& l1, const Vector3D& l2, Vector3D& x ) {
	Vector3D d00( p1 ), l( l2 ), nd0( normal ), ndl( normal ) ;
	float a, b, d ;

	d00.sub( l1 ) ;

	l.sub( l1 ) ;

	a = nd0.dot( d00 ) ;
	b = ndl.dot( l ) ;
	d = __fdividef( a, b ) ;
	l.mul( d ) ;

	x.set( l.x, l.y, l.z ) ;
	x.add( l1 ) ;

	return x ;
}

// private
__device__ void Plane::set( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) {
	Vector3D d21( p2 ) ;
	Vector3D d31( p3 ) ;

	d21.sub( p1 ) ;
	d31.sub( p1 ) ;

	this->p1.set( p1.x, p1.y, p1.z ) ;
	this->p2.set( p2.x, p2.y, p2.z ) ;
	this->p3.set( p3.x, p3.y, p3.z ) ;

	d21.cross( d31 ) ;
	normal.set( d21.x, d21.y, d21.z ) ;
}
