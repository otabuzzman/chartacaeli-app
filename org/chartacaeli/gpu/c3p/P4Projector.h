#ifndef __P4PROJECTOR_H__
#define __P4PROJECTOR_H__

#include "Coordinate.h"

class P4Projector {

public:
	virtual ~P4Projector() {}

	virtual void init( double lam0, double phi1, double R, double k0 ) = 0 ;
	virtual Coordinate* forward( const Coordinate& lamphi ) = 0 ;
	virtual Coordinate* inverse( const Coordinate& xy ) = 0 ;

	// CXXWRAP/ JUnit
	virtual void forward( /* arg(s) */ double lamphi[3], /* return */ double xy[3] ) = 0 ;
	virtual void inverse( /* arg(s) */ double xy[3], /* return */ double lamphi[3] ) = 0 ;
} ;

#endif // __P4PROJECTOR_H__
