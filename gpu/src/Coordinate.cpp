#include "Coordinate.h"
using namespace std;

Coordinate::Coordinate() : x( 0 ), y( 0 ), z( 0 ) {
}

Coordinate::Coordinate( double x, double y, double z ) {
	this->x = x ;
	this->y = y ;
	this->z = z ;
}
