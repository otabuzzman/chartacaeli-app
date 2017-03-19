#ifndef __VECTOR3D_H__
#define __VECTOR3D_H__

#include "Coordinate.h"

class Vector3D : public Coordinate {

public:
	__device__ Vector3D() ;
	__device__ Vector3D( const Vector3D& v ) ;
	__device__ Vector3D( float x, float y, float z ) ;

	__device__ Vector3D& add( const Vector3D& v ) ;
	__device__ Vector3D& sub( const Vector3D& v ) ;
	__device__ Vector3D& mul( float s ) ;
	__device__ float dot( const Vector3D& v ) ;
	__device__ Vector3D& cross( const Vector3D& v ) ;
	__device__ Vector3D& apply( const Vector3D& matcol0, const Vector3D& matcol1, const Vector3D& matcol2 ) ;
	__device__ Vector3D& apply(
			const float m00, const float m01, const float m02,
			const float m10, const float m11, const float m12,
			const float m20, const float m21, const float m22 ) ;
} ;
#endif // __VECTOR3D_H__
