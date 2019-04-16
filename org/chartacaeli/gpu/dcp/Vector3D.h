#ifndef __VECTOR3D_H__
#define __VECTOR3D_H__

#include "Coordinate.h"

class Vector3D : public Coordinate {

public:
	__device__ Vector3D() ;
	__device__ Vector3D( const Vector3D& v ) ;
	__device__ Vector3D( double x, double y, double z ) ;

	__device__ Vector3D& add( const Vector3D& v ) ;
	__device__ Vector3D& sub( const Vector3D& v ) ;
	__device__ Vector3D& mul( double s ) ;
	__device__ double dot( const Vector3D& v ) ;
	__device__ Vector3D& cross( const Vector3D& v ) ;
	__device__ Vector3D& apply( const Vector3D& matcol0, const Vector3D& matcol1, const Vector3D& matcol2 ) ;
	__device__ Vector3D& apply(
			const double m00, const double m01, const double m02,
			const double m10, const double m11, const double m12,
			const double m20, const double m21, const double m22 ) ;
} ;
#endif // __VECTOR3D_H__
