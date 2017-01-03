#include "Plane.h"
#include "Vector3D.h"
using namespace std;

Plane::Plane( Vector3D& p1, Vector3D& p2, Vector3D& p3 ) {
	set( p1, p2, p3 ) ;
}

Plane::~Plane() {
	delete p1 ;
	delete p2 ;
	delete p3 ;
	delete normal ;
}

// https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection#Algebraic_form
Vector3D* Plane::intersection( Vector3D& l1, Vector3D& l2 ) {
	Vector3D *d00, *l, *x ;
	double d ;

	d00 = new Vector3D( *p1) ;
	d00->sub( l1 ) ;

	l = new Vector3D( l2 ) ;
	l->sub( l1 ) ;

	d = normal->dot( *d00 )/normal->dot( *l ) ;
	l->mul( d ) ;

	x = new Vector3D( l1) ;
	x->add( *l ) ;

	delete d00 ;
	delete l ;

	return x ;
}

// CXXWRAP/ JUnit
void Plane::set( Vector3D& p1, Vector3D& p2, Vector3D& p3 ) {
	Vector3D* d21 = ( new Vector3D( p2 ) )->sub( p1 ) ;
	Vector3D* d31 = ( new Vector3D( p3 ) )->sub( p1 ) ;

	this->p1 = new Vector3D( p1.x, p1.y, p1.z ) ;
	this->p2 = new Vector3D( p2.x, p2.y, p2.z ) ;
	this->p3 = new Vector3D( p3.x, p3.y, p3.z ) ;

	normal = new Vector3D( *( d21->cross( *d31 ) ) ) ;

	delete d21 ;
	delete d31 ;
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
	delete t2 ;
}
