#ifndef __VECTOR3D_H__
#define __VECTOR3D_H__

class Vector3D {

public:
	static Vector3D ZERO ;

	double x ;
	double y ;
	double z ;

	Vector3D() ;
	Vector3D( double v[3] ) ;
	Vector3D( Vector3D& v ) ;
	Vector3D( double x, double y, double z ) ;

	void set( double x, double y, double z ) ;
	Vector3D* add( Vector3D& v ) ;
	Vector3D* sub( Vector3D& v ) ;
	Vector3D* mul( double s ) ;
	double dot( Vector3D& v ) ;
	Vector3D* cross( Vector3D& v ) ;

	double* toArray() ;
} ;
#endif // __VECTOR3D_H__
