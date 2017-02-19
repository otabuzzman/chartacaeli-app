#ifndef __VECTOR3D_H__
#define __VECTOR3D_H__

class Vector3D {

public:
	static Vector3D ZERO ;

	double x ;
	double y ;
	double z ;

	Vector3D() ;
	Vector3D( const Vector3D& v ) ;
	Vector3D( double x, double y, double z ) ;

	void set( double x, double y, double z ) ;
	Vector3D& add( const Vector3D& v ) ;
	Vector3D& sub( const Vector3D& v ) ;
	Vector3D& mul( double s ) ;
	double dot( const Vector3D& v ) ;
	Vector3D& cross( const Vector3D& v ) ;
} ;
#endif // __VECTOR3D_H__
