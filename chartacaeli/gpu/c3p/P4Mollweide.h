#ifndef __P4MOLLWEIDE_H__
#define __P4MOLLWEIDE_H__

#include "P4Projector.h"
#include "P4ProjectorFactory.h"
#include "Coordinate.h"

class P4Mollweide : public P4Projector {

public:
	P4Mollweide() ;

	void init( double lam0, double phi1, double R, double k0 ) ;
	Coordinate* forward( Coordinate& lamphi ) ;
	Coordinate* inverse( Coordinate& xy ) ;
	// CXXWRAP/ JUnit
	void forward( /* arg(s) */ double lamphi[3], /* return */ double xy[3] ) ;
	void inverse( /* arg(s) */ double xy[3], /* return */ double lamphi[3] ) ;

private:
	double lam0 ;
	double R ;

	const double V_CON ;
	const double radperdeg ;
	const double degperrad ;

	P4PROJECTOR_CDEC(P4Mollweide) ;
} ;

#endif // __P4MOLLWEIDE_H__
