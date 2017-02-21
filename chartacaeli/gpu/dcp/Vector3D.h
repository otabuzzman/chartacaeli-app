#ifndef __VECTOR3D_H__
#define __VECTOR3D_H__

class Vector3D {

public:
	double x ;
	double y ;
	double z ;

	__device__ Vector3D() ;
	__device__ Vector3D( const Vector3D& v ) ;
	__device__ Vector3D( double x, double y, double z ) ;

	__device__ void set( double x, double y, double z ) ;
	__device__ Vector3D& add( const Vector3D& v ) ;
	__device__ Vector3D& sub( const Vector3D& v ) ;
	__device__ Vector3D& mul( double s ) ;
	__device__ double dot( const Vector3D& v ) ;
	__device__ Vector3D& cross( const Vector3D& v ) ;
} ;
#endif // __VECTOR3D_H__
