#include "ChartPseudoCylindrical.h"
#include "Coordinate.h"
using namespace std;

Coordinate ChartPseudoCylindrical::project( Coordinate coordinate, bool inverse ) {
	Coordinate retval ;
	return retval ;
}

// CXXWRAP/ JUnit
void ChartPseudoCylindrical::project( /* arg(s) */ double coordinate[3], bool inverse, /* return */ double retval[3] ) {
	Coordinate t0( coordinate[0], coordinate[1], coordinate[2] ) ;
	Coordinate t1 = project( t0, inverse ) ;
	retval[0] = t1.x ;
	retval[1] = t1.y ;
}
