#ifndef __P4PROJECTOR_H__
#define __P4PROJECTOR_H__

#include "Coordinate.h"

class P4Projector {

public:
	virtual ~P4Projector() {}

	virtual Coordinate forward( Coordinate lamphi ) = 0 ;
	virtual Coordinate inverse( Coordinate xy ) = 0 ;
	// CXXWRAP/ JUnit
	virtual void forward( /* arg(s) */ double lamphi[3], /* return */ double xy[3] ) = 0 ;
	virtual void inverse( /* arg(s) */ double xy[3], /* return */ double lamphi[3] ) = 0 ;
} ;

#endif // __P4PROJECTOR_H__
