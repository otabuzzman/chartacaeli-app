#include "Math.h"
#include "AACoordinateTransformation.h"

double Math::sin( double a ) {
	return std::sin( CAACoordinateTransformation::DegreesToRadians( a ) ) ;
}

double Math::cos( double a ) {
	return std::cos( CAACoordinateTransformation::DegreesToRadians( a ) ) ;
}

double Math::asin( double a ) {
	return std::asin( CAACoordinateTransformation::DegreesToRadians( a ) ) ;
}
