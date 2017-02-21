#ifndef __P4STEREOGRAPHIC_H__
#define __P4STEREOGRAPHIC_H__

#include "P4Projector.h"
#include "Coordinate.h"

class P4Stereographic : public P4Projector {

public:
	__device__ P4Stereographic() ;

	__device__ void init( double lam0, double phi1, double R, double k0 ) ;
	__device__ Coordinate* forward( const Coordinate& lamphi ) ;
	__device__ Coordinate* inverse( const Coordinate& xy ) ;

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
} ;

#endif // __P4STEREOGRAPHIC_H__
