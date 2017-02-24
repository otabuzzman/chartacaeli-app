#ifndef __P4MOLLWEIDE_H__
#define __P4MOLLWEIDE_H__

#include "P4Projector.h"
#include "Coordinate.h"

class P4Mollweide : public P4Projector {

public:
	__device__ P4Mollweide() ;

	__device__ void init( double lam0, double phi1, double R, double k0 ) ;
	__device__ Coordinate& forward( const Coordinate& lamphi, Coordinate& xy ) ;
	__device__ Coordinate& inverse( const Coordinate& xy, Coordinate& lamphi ) ;

private:
	double lam0 ;
	double R ;

	const double V_CON ;
	const double radperdeg ;
	const double degperrad ;
} ;

#endif // __P4MOLLWEIDE_H__
