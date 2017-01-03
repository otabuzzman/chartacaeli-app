#include <cmath>

#include "Coordinate.h"
#include "Math.h"
using namespace std;

Coordinate::Coordinate() : x( 0 ), y( 0 ), z( 0 ) {
}

Coordinate::Coordinate( double c[3] ) {
	set( c[0], c[1], c[2] ) ;
}

Coordinate::Coordinate( Coordinate& c ) {
	set( c.x, c.y, c.z ) ;
}

Coordinate::Coordinate( double x, double y, double z ) {
	set( x, y, z ) ;
}

void Coordinate::set( double x, double y, double z ) {
	this->x = x ;
	this->y = y ;
	this->z = z ;
}

Coordinate* Coordinate::spherical() {
	double x, y ;
	Coordinate *c ;

	x = Math::atan2( this->y, this->x ) ;
	y = Math::asin( z/sqrt( this->x*this->x+this->y*this->y+z*z ) ) ;

	c = new Coordinate( x, y, z ) ;

	return c ;
}

Coordinate* Coordinate::cartesian() {
	double x, y, z ;
	Coordinate *c ;

	x = Math::cos( this->y )*Math::cos( this->x ) ;
	y = Math::cos( this->y )*Math::sin( this->x ) ;
	z = Math::sin( this->y ) ;

	c = new Coordinate( x, y, z ) ;

	return c ;
}

double* Coordinate::toArray() {
	double* r = new double[3] ;

	r[0] = x ;
	r[1] = y ;
	r[2] = z ;

	return r ;
}

// CXXWRAP/ JUnit
void Coordinate::spercical( /* return */ double retval[] ) {
	Coordinate* c = spherical() ;
	retval[0] = c->x ;
	retval[1] = c->y ;
	retval[2] = c->z ;
	delete c ;
}

void Coordinate::cartesian( /* return */ double retval[] ) {
	Coordinate* c = cartesian() ;
	retval[0] = c->x ;
	retval[1] = c->y ;
	retval[2] = c->z ;
	delete c ;
}

