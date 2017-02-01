#include <cstdio>
#include <cstdlib>

#include "Plane.h"
#include "Vector3D.h"

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

// CXXWRAP/ JUnit
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

#ifdef PLANE_MAIN
// pseudo-kernel (ridiculous)
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	Vector3D *p1, *p2, *p3 ;
	Plane* plane ;
	Vector3D *l0, *l1, *x ;
	double* buf ;
	double a, b, c ;

	p1 = new Vector3D( 1., 3., 7. ) ;
	p2 = new Vector3D( 3., 7., 1. ) ;
	p3 = new Vector3D( 7., 1., 3. ) ;
	plane = new Plane( *p1, *p2, *p3 ) ;

	l0 = new Vector3D() ;
	l1 = new Vector3D() ;
	buf = new double[3*NUM_THREADS] ;

	for ( int i=0 ; NUM_THREADS>i ; i++ ) {
		a = i ; b = a+1 ; c = b+1 ;
		l1->set( ( ( a+4 )+( a+1 )+( a-2 ) )/4, ( ( b+4 )+( b+1 )+( b-2 ) )/4, ( ( c+4 )+( c+1 )+( c-2 ) )/4 ) ;
		x = plane->intersection( *l0, *l1 ) ;
		buf[3*i] = x->x ;
		buf[3*i+1] = x->y ;
		buf[3*i+2] = x->z ;
		delete x ;
	}

	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.8f %.8f %.8f\n", buf[3*i], buf[3*i+1], buf[3*i+2] ) ;

	delete buf ;
	delete l1 ;
	delete l0 ;
	delete plane ;
	delete p3 ;
	delete p2 ;
	delete p1 ;

	return EXIT_SUCCESS ;
}
#endif // PLANE_MAIN
