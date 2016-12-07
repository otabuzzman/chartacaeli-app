#ifndef __CHARTPSEUDOCYLINDRICAL_H__
#define __CHARTPSEUDOCYLINDRICAL_H__

#include "Projector.h"
#include "Coordinate.h"

class ChartPseudoCylindrical : public Projector {

public:
	Coordinate project( Coordinate coordinate, bool inverse ) ;
	// CXXWRAP/ JUnit
	void project( /* arg(s) */ double coordinate[3], bool inverse, /* return */ double retval[3] ) ;
} ;
#endif // __CHARTPSEUDOCYLINDRICAL_H__
