#ifndef __P4MOLLWEIDE_H__
#define __P4MOLLWEIDE_H__

#include "Coordinate.h"

class P4Mollweide {

public:
	P4Mollweide() ;
	
	void init( double lam0, double phi1, double R, double k0 ) ;
	Coordinate forward( Coordinate lamphi ) ;
	Coordinate inverse( Coordinate xy ) ;

private:
	double lam0 ;
	double R ;
	
	const double V_CON ;
	const double radperdeg ;
	const double degperrad ;
} ;

#endif // __P4MOLLWEIDE_H__
