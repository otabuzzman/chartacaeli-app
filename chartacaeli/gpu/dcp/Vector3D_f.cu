#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Vector3D.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Vector3D::Vector3D() : Coordinate( 0, 0, 0 ) {
}

__device__ Vector3D::Vector3D( const Vector3D& v ) : Coordinate( v.x, v.y, v.z ) {
}

__device__ Vector3D::Vector3D( float x, float y, float z ) : Coordinate( x, y, z ) {
}

__device__ Vector3D& Vector3D::add( const Vector3D& v ) {
	x += v.x ;
	y += v.y ;
	z += v.z ;

	return *this ;
}

__device__ Vector3D& Vector3D::sub( const Vector3D& v ) {
	x -= v.x ;
	y -= v.y ;
	z -= v.z ;

	return *this ;
}

__device__ Vector3D& Vector3D::mul( float a ) {
	x *= a ;
	y *= a ;
	z *= a ;

	return *this ;
}

__device__ float Vector3D::dot( const Vector3D& v ) {
	return x*v.x+y*v.y+z*v.z ;
}

__device__ Vector3D& Vector3D::cross( const Vector3D& v ) {
	float x, y, z ;

	x = this->x ;
	y = this->y ;
	z = this->z ;

	this->x = y*v.z-z*v.y ;
	this->y = z*v.x-x*v.z ;
	this->z = x*v.y-y*v.x ;

	return *this ;
}

__device__ Vector3D& Vector3D::apply( const Vector3D& matcol0, const Vector3D& matcol1, const Vector3D& matcol2 ) {
	return apply(
			matcol0.x, matcol1.x, matcol2.x,
			matcol0.y, matcol1.y, matcol2.y,
			matcol0.z, matcol1.z, matcol2.z ) ;
}

__device__ Vector3D& Vector3D::apply(
			const float m00, const float m01, const float m02,
			const float m10, const float m11, const float m12,
			const float m20, const float m21, const float m22 ) {
	float _x = x, _y = y, _z = z ;

	x = _x*m00+_y*m01+_z*m02 ;
	y = _x*m10+_y*m11+_z*m12 ;
	z = _x*m20+_y*m21+_z*m22 ;

	return *this ;
}
