#ifndef __P4STEREOGRAPHIC_H__
#define __P4STEREOGRAPHIC_H__

#include "P4Projector.h"
#include "P4ProjectorFactory.h"
#include "Coordinate.h"

class P4Stereographic : public P4Projector {

public:
	P4Stereographic() ;
	
	void init( double lam0, double phi1, double R, double k0 ) ;
	Coordinate* forward( Coordinate& lamphi ) ;
	Coordinate* inverse( Coordinate& xy ) ;
	// CXXWRAP/ JUnit
	void forward( /* arg(s) */ double lamphi[3], /* return */ double xy[3] ) ;
	void inverse( /* arg(s) */ double xy[3], /* return */ double lamphi[3] ) ;

private:
	double lam0 ;
	double phi1 ;
	double sinphi1 ;
	double cosphi1 ;
	double R ;
	double k0 ;

	int mode ;
	
	static const int M_NORTH = 0 ;
	static const int M_SOUTH = 1 ;
	static const int M_EQUATOR = 2 ;
	static const int M_OBLIQUE = 3 ;

	P4PROJECTOR_CDEC(P4Stereographic) ;
} ;

#endif // __P4STEREOGRAPHIC_H__
