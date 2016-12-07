#ifndef __PROJECTOR_H__
#define __PROJECTOR_H__

#include "Coordinate.h"

class Projector {

public:
	virtual ~Projector() {}

	virtual Coordinate project( Coordinate coordinate, bool inverse ) = 0 ;
	// CXXWRAP/ JUnit
	virtual void project( /* arg(s) */ double coordinate[3], bool inverse, /* return */ double retval[3] ) = 0 ;
} ;

#endif // __PROJECTOR_H__
