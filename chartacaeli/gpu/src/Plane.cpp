#include "Plane.h"
#include "Vector3D.h"
using namespace std;

Plane::Plane( Vector3D& p1, Vector3D& p2, Vector3D& p3 ) {
	set( p1, p2, p3 ) ;
}

Vector3D* Plane::intersection( Vector3D& p1, Vector3D& p2 ) {
	Vector3D *u, *x ;
	double d ;

	// https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection#Algebraic_form
	u = p2.sub( p1 ) ;
	d = normal.dot( *( this->p1.sub( p1 ) ) )/normal.dot( *u ) ;
	x = p1.add( *( u->mul( d ) ) ) ;

	return x ;
}

// CXXWRAP/ JUnit
void Plane::set( Vector3D& p1, Vector3D& p2, Vector3D& p3 ) {
	Vector3D *n ;

	this->p1.set( p1.x, p1.y, p1.z ) ;
	this->p2.set( p2.x, p2.y, p2.z ) ;
	this->p3.set( p3.x, p3.y, p3.z ) ;

	n = p2.sub( p1 )->cross( *( p3.sub( p1 ) ) ) ;
	normal.set( n->x, n->y, n->z ) ;
}

Plane::Plane( double p1[], double p2[], double p3[] ) {
	Vector3D a( p1 ), b( p2 ), c( p3 ) ;
	set( a, b, c ) ;
}

void Plane::intersection( /* arg(s) */ double p1[3], double p2[3], /* return */ double x[3] ) {
	Vector3D t0( p1[0], p1[1], p1[2] ), t1( p2[0], p2[1], p2[2] ) ;
	Vector3D *t2 = intersection( t0, t1 ) ;
	x[0] = t2->x ;
	x[1] = t2->y ;
	x[2] = t2->z ;
}
