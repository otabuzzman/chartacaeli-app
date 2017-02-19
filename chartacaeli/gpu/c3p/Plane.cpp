#include <cstdio>
#include <cstdlib>

#include "Plane.h"
#include "Vector3D.h"
using namespace std;

Plane::Plane( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) {
	set( p1, p2, p3 ) ;
}

void Plane::set( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) {
	Vector3D d21( p2 ) ;
	Vector3D d31( p3 ) ;

	d21.sub( p1 ) ;
	d31.sub( p1 ) ;

	this->p1.set( p1.x, p1.y, p1.z ) ;
	this->p2.set( p2.x, p2.y, p2.z ) ;
	this->p3.set( p3.x, p3.y, p3.z ) ;

	d21.cross( d31 ) ;
	normal.set( d21.x, d21.y, d21.z ) ;
}

// https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection#Algebraic_form
Vector3D* Plane::intersection( const Vector3D& l1, const Vector3D& l2 ) {
	Vector3D d00( p1 ), l( l2 ), nd0( normal ), ndl( normal ), *x ;
	double a, b, d ;

	d00.sub( l1 ) ;

	l.sub( l1 ) ;

	a = nd0.dot( d00 ) ;
	b = ndl.dot( l ) ;
	d = a/b ;
	l.mul( d ) ;

	x = new Vector3D( l1 ) ;
	x->add( l ) ;

	return x ;
}

// CXXWRAP/ JUnit
Plane::Plane( double p1[], double p2[], double p3[] ) {
	Vector3D a( p1[0], p1[1], p1[2] ), b( p2[0], p2[1], p2[2] ), c( p3[0], p3[1], p3[2] ) ;
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
	Vector3D p1, p2, p3 ;
	Plane plane ;
	Vector3D l0, l1, *x ;
	double* buf ;
	double a, b, c ;

	p1.set( 1., 3., 7. ) ;
	p2.set( 3., 7., 1. ) ;
	p3.set( 7., 1., 3. ) ;
	plane.set( p1, p2, p3 ) ;

	l1 = new Vector3D() ;
	buf = new double[3*NUM_THREADS] ;

	for ( int i=0 ; NUM_THREADS>i ; i++ ) {
		a = i ; b = a+1 ; c = b+1 ;
		l1.set( ( ( a+4 )+( a+1 )+( a-2 ) )/4, ( ( b+4 )+( b+1 )+( b-2 ) )/4, ( ( c+4 )+( c+1 )+( c-2 ) )/4 ) ;
		x = plane.intersection( l0, l1 ) ;
		buf[3*i] = x->x ;
		buf[3*i+1] = x->y ;
		buf[3*i+2] = x->z ;
		delete x ;
	}

	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.8f %.8f %.8f\n", buf[3*i], buf[3*i+1], buf[3*i+2] ) ;

	delete buf ;

	return EXIT_SUCCESS ;
}
#endif // PLANE_MAIN
