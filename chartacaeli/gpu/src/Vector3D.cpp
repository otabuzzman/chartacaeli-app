#include "Vector3D.h"
using namespace std;

Vector3D Vector3D::ZERO ;

Vector3D::Vector3D() : x( 0 ), y( 0 ), z( 0 ) {
}

Vector3D::Vector3D( double v[3] ) {
	set( v[0], v[1], v[2] ) ;
}

Vector3D::Vector3D( Vector3D& v ) {
	set( v.x, v.y, v.z ) ;
}

Vector3D::Vector3D( double x, double y, double z ) {
	set( x, y, z ) ;
}

void Vector3D::set( double x, double y, double z ) {
	this->x = x ;
	this->y = y ;
	this->z = z ;
}

Vector3D* Vector3D::add( Vector3D& v ) {
	Vector3D *r = new Vector3D( x+v.x, y+v.y, z+v.z ) ;

	return r ;
}

Vector3D* Vector3D::sub( Vector3D& v ) {
	Vector3D *r = new Vector3D( x-v.x, y-v.y, z-v.z ) ;

	return r ;
}

Vector3D* Vector3D::mul( double a ) {
	Vector3D *r = new Vector3D( x*a, y*a, z*a ) ;

	return r ;
}

double Vector3D::dot( Vector3D& v ) {
	return x*v.x+y*v.y+z*v.z ;
}

Vector3D* Vector3D::cross( Vector3D& v ) {
	Vector3D *r ;
	double x, y, z ;

	x = this->x ; y = this->y ; z = this->z ;
	r = new Vector3D( y*v.z-z*v.y, z*v.x-x*v.z, x*v.y-y*v.x ) ;

	return r ;
}

double* Vector3D::toArray() {
	double* r = new double[3] ;

	r[0] = x ;
	r[1] = y ;
	r[2] = z ;

	return r ;
}
