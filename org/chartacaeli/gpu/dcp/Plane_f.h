#ifndef __PLANE_H__
#define __PLANE_H__

#include "Vector3D_f.h"

class Plane {

public:
	__device__ Plane( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) ;
	__device__ Plane(
		const float p1x, const float p1y, const float p1z,
		const float p2x, const float p2y, const float p2z,
		const float p3x, const float p3y, const float p3z ) ;

	__device__ Vector3D& intersection( const Vector3D& l1, const Vector3D& l2, Vector3D& x ) ;
	// CXXWRAP/ JUnit
	Plane( float p1[3], float p2[3], float p3[3] ) ;

	void intersection( /* arg(s) */ float l1[3], float l2[3], /* return */ float x[3] ) ;

private:
	Vector3D p1 ;
	Vector3D p2 ;
	Vector3D p3 ;
	Vector3D normal ;

	__device__ void set( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) ;
} ;
#endif // __PLANE_H__
