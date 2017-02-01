#ifndef __P4ORTHOGRAPHIC_H__
#define __P4ORTHOGRAPHIC_H__

#include "P4Projector.h"
#include "Coordinate.h"

class P4Orthographic : public P4Projector {

public:
	__device__ P4Orthographic() ;

	__device__ void init( double lam0, double phi1, double R, double k0 ) ;
	__device__ Coordinate* forward( Coordinate& lamphi ) ;
	__device__ Coordinate* inverse( Coordinate& xy ) ;

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
} ;

#endif // __P4ORTHOGRAPHIC_H__
