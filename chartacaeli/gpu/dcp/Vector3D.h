#ifndef __VECTOR3D_H__
#define __VECTOR3D_H__

class Vector3D {

public:
	double x ;
	double y ;
	double z ;

	__device__ Vector3D() ;
	__device__ Vector3D( double v[3] ) ;
	__device__ Vector3D( Vector3D& v ) ;
	__device__ Vector3D( double x, double y, double z ) ;

	__device__ void set( double x, double y, double z ) ;
	__device__ Vector3D* add( Vector3D& v ) ;
	__device__ Vector3D* sub( Vector3D& v ) ;
	__device__ Vector3D* mul( double s ) ;
	__device__ double dot( Vector3D& v ) ;
	__device__ Vector3D* cross( Vector3D& v ) ;

	__device__ double* toArray() ;
} ;
#endif // __VECTOR3D_H__
