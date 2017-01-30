#include <cstdio>
#include <cstdlib>

#include "Math.h"
#include "AACoordinateTransformation.h"

double Math::sin( double a ) {
	return std::sin( CAACoordinateTransformation::DegreesToRadians( a ) ) ;
}

double Math::cos( double a ) {
	return std::cos( CAACoordinateTransformation::DegreesToRadians( a ) ) ;
}

double Math::tan( double a ) {
	return std::tan( CAACoordinateTransformation::DegreesToRadians( a ) ) ;
}

double Math::asin( double a ) {
	return CAACoordinateTransformation::RadiansToDegrees( std::asin( a ) ) ;
}

double Math::atan( double a ) {
	return CAACoordinateTransformation::RadiansToDegrees( std::atan( a ) ) ;
}

double Math::atan2( double y, double x ) {
	return CAACoordinateTransformation::RadiansToDegrees( std::atan2( y, x ) ) ;
}

#ifdef MATH_MAIN
// pseudo-kernel (ridiculous)
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	double* buf ;

	buf = new double[NUM_THREADS] ;

	for ( int i=0 ; NUM_THREADS>i ; i++ )
		buf[i] = Math::asin( Math::sin( i ) ) ;

	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.8f\n", buf[i] ) ;

	delete buf ;

	return EXIT_SUCCESS ;
}
#endif // MATH_MAIN
