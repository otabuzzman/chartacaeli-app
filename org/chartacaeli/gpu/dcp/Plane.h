#ifndef __PLANE_H__
#define __PLANE_H__

#include "Vector3D.h"

class Plane {

public:
	__device__ Plane( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) ;
	__device__ Plane(
		const double p1x, const double p1y, const double p1z,
		const double p2x, const double p2y, const double p2z,
		const double p3x, const double p3y, const double p3z ) ;

	__device__ Vector3D& intersection( const Vector3D& l1, const Vector3D& l2, Vector3D& x ) ;
	// CXXWRAP/ JUnit
	Plane( double p1[3], double p2[3], double p3[3] ) ;

	void intersection( /* arg(s) */ double l1[3], double l2[3], /* return */ double x[3] ) ;

private:
	Vector3D p1 ;
	Vector3D p2 ;
	Vector3D p3 ;
	Vector3D normal ;

	__device__ void set( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) ;
} ;
#endif // __PLANE_H__
