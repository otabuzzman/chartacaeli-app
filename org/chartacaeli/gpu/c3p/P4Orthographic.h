#ifndef __P4ORTHOGRAPHIC_H__
#define __P4ORTHOGRAPHIC_H__

#include "P4Projector.h"
#include "P4ProjectorFactory.h"
#include "Coordinate.h"

class P4Orthographic : public P4Projector {

public:
	P4Orthographic() ;

	void init( double lam0, double phi1, double R, double k0 ) ;
	Coordinate* forward( const Coordinate& lamphi ) ;
	Coordinate* inverse( const Coordinate& xy ) ;

	// CXXWRAP/ JUnit
	void forward( /* arg(s) */ double lamphi[3], /* return */ double xy[3] ) ;
	void inverse( /* arg(s) */ double xy[3], /* return */ double lamphi[3] ) ;

private:
	double lam0 ;
	double phi1 ;
	double sinphi1 ;
	double cosphi1 ;
	double R ;

	int mode ;

	static const int M_NORTH = 0 ;
	static const int M_SOUTH = 1 ;
	static const int M_EQUATOR = 2 ;
	static const int M_OBLIQUE = 3 ;

	P4PROJECTOR_CDEC(P4Orthographic) ;
} ;

#endif // __P4ORTHOGRAPHIC_H__
