#include <cmath>
#include <cstdio>
#include <cstdlib>

#include "Coordinate.h"
#include "Math.h"
using namespace std;

Coordinate::Coordinate() : x( 0 ), y( 0 ), z( 0 ) {
}

Coordinate::Coordinate( const Coordinate& c ) {
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

void Coordinate::spherical() {
	double r = sqrt( x*x+y*y+z*z ) ;

	x = Math::atan2( y, x ) ;
	y = Math::asin( z/r ) ;
	z = 0 ;
}

void Coordinate::cartesian() {
	double _x = x, _y = y ;

	x = Math::cos( _y )*Math::cos( _x ) ;
	y = Math::cos( _y )*Math::sin( _x ) ;
	z = Math::sin( _y ) ;
}

// CXXWRAP/ JUnit
void Coordinate::spherical( /* return */ double retval[] ) {
	spherical() ;
	retval[0] = x ;
	retval[1] = y ;
	retval[2] = z ;
}

void Coordinate::cartesian( /* return */ double retval[] ) {
	cartesian() ;
	retval[0] = x ;
	retval[1] = y ;
	retval[2] = z ;
}

#ifdef COORDINATE_MAIN
// pseudo-kernel (ridiculous)
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	Coordinate c ;
	double* buf ;

	buf = new double[3*NUM_THREADS] ;

	for ( int i=0 ; NUM_THREADS>i ; i++ ) {
		c.set( i, i+1, i+2 ) ;
		c.spherical() ;
		c.cartesian() ;
		buf[3*i] = c.x ;
		buf[3*i+1] = c.y ;
		buf[3*i+2] = c.z ;
	}

	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.8f %.8f %.8f\n", buf[3*i], buf[3*i+1], buf[3*i+2] ) ;

	delete[] buf ;

	return EXIT_SUCCESS ;
}
#endif // COORDINATE_MAIN
