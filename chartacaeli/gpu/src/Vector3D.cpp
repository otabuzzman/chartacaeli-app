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
	x += v.x ;
	y += v.y ;
	z += v.z ;

	return this ;
}

Vector3D* Vector3D::sub( Vector3D& v ) {
	x -= v.x ;
	y -= v.y ;
	z -= v.z ;

	return this ;
}

Vector3D* Vector3D::mul( double a ) {
	x *= a ;
	y *= a ;
	z *= a ;

	return this ;
}

double Vector3D::dot( Vector3D& v ) {
	return x*v.x+y*v.y+z*v.z ;
}

Vector3D* Vector3D::cross( Vector3D& v ) {
	double x, y, z ;

	x = this->x ;
	y = this->y ;
	z = this->z ;

	this->x = y*v.z-z*v.y ;
	this->y = z*v.x-x*v.z ;
	this->z = x*v.y-y*v.x ;

	return this ;
}

double* Vector3D::toArray() {
	double* r = new double[3] ;

	r[0] = x ;
	r[1] = y ;
	r[2] = z ;

	return r ;
}
