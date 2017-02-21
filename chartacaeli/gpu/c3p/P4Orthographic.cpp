#include <cstdio>
#include <cstdlib>
#include <cmath>

#include "P4Orthographic.h"
#include "Coordinate.h"
#include "Math.h"
using namespace std;

P4PROJECTOR_CDEF(P4Orthographic) ;

P4Orthographic::P4Orthographic() {
	init( 0, 90, 1, 1 ) ;
}

void P4Orthographic::init( double lam0, double phi1, double R, double k0 ) {
	this->lam0 = lam0 ;
	this->phi1 = phi1 ;
	sinphi1 = Math::sin( phi1 ) ;
	cosphi1 = Math::cos( phi1 ) ;
	this->R = R ;

	if ( phi1 == 90 )
		mode = M_NORTH ;
	else if ( phi1 == -90 )
		mode = M_SOUTH ;
	else if ( phi1 == 0 )
		mode = M_EQUATOR ;
	else
		mode = M_OBLIQUE ;
}

Coordinate* P4Orthographic::forward( const Coordinate& lamphi ) {
	Coordinate* xy = new Coordinate() ;
	double sinlamdif, coslamdif ;
	double sinphi, cosphi ;

	sinlamdif = Math::sin( lamphi.x-lam0 ) ;
	coslamdif = Math::cos( lamphi.x-lam0 ) ;
	sinphi = Math::sin( lamphi.y ) ;
	cosphi = Math::cos( lamphi.y ) ;

	xy->x = R*cosphi*sinlamdif ;

	switch ( mode ) {
	case M_NORTH:
		xy->y = -R*cosphi*coslamdif ;

		break ;
	case M_SOUTH:
		xy->y = R*cosphi*coslamdif ;

		break ;
	case M_EQUATOR:
		xy->y = R*sinphi ;

		break ;
	case M_OBLIQUE:
		xy->y = R*( cosphi1*sinphi-sinphi1*cosphi*coslamdif ) ;

		break ;
	}

	return xy ;
}

Coordinate* P4Orthographic::inverse( const Coordinate& xy ) {
	Coordinate* lamphi = new Coordinate() ;
	double p, c, sinc, cosc ;

	p = pow( xy.x*xy.x+xy.y*xy.y, .5 ) ;
	c = Math::asin( p/R ) ;

	sinc = Math::sin( c ) ;
	cosc = Math::cos( c ) ;

	lamphi->y = Math::asin( cosc*sinphi1+( xy.y*sinc*cosphi1/p ) ) ;

	switch ( mode ) {
	case M_NORTH:
		lamphi->x = lam0+Math::atan2(xy.x, -xy.y ) ;

		break ;
	case M_SOUTH:
		lamphi->x = lam0+Math::atan2(xy.x, xy.y ) ;

		break ;
	case M_EQUATOR:
	case M_OBLIQUE:
		lamphi->x = lam0+Math::atan2( xy.x*sinc, p*cosphi1*cosc-xy.y*sinphi1*sinc ) ;

		break ;
	}

	return lamphi ;
}

// CXXWRAP/ JUnit
void P4Orthographic::forward( /* arg(s) */ double lamphi[3], /* return */ double xy[3] ) {
	Coordinate t0( lamphi[0], lamphi[1], lamphi[2] ) ;
	Coordinate* t1 = forward( t0 ) ;
	xy[0] = t1->x ;
	xy[1] = t1->y ;
	delete t1 ;
}

void P4Orthographic::inverse( /* arg(s) */ double xy[3], /* return */ double lamphi[3] ) {
	Coordinate t0( xy[0], xy[1], xy[2] ) ;
	Coordinate* t1 = inverse( t0 ) ;
	lamphi[0] = t1->x ;
	lamphi[1] = t1->y ;
	delete t1 ;
}

#ifdef P4ORTHOGRAPHIC_MAIN
// pseudo-kernel (ridiculous)
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	P4Orthographic proj ;
	Coordinate lamphi, *xy, *res ;
	double* buf ;

	buf = new double[2*NUM_THREADS] ;

	for ( int i=0 ; NUM_THREADS>i ; i++ ) {
		lamphi.set( (double) i, (double) ( i%90 ), 0 ) ;
		xy = proj.forward( lamphi ) ;
		res = proj.inverse( *xy ) ;
		buf[2*i] = res->x ;
		buf[2*i+1] = res->y ;
		delete xy ;
		delete res ;
	}

	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.4f %.4f\n", buf[2*i], buf[2*i+1] ) ;

	delete[] buf ;

	return EXIT_SUCCESS ;
}
#endif // P4ORTHOGRAPHIC_MAIN
