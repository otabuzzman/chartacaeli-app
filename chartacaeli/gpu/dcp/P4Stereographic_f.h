#ifndef __P4STEREOGRAPHIC_H__
#define __P4STEREOGRAPHIC_H__

#include "P4Projector.h"
#include "Coordinate.h"

class P4Stereographic : public P4Projector {

public:
	__device__ P4Stereographic() ;

	__device__ void init( float lam0, float phi1, float R, float k0 ) ;
	__device__ Coordinate& forward( const Coordinate& lamphi, Coordinate& xy ) ;
	__device__ Coordinate& inverse( const Coordinate& xy, Coordinate& lamphi ) ;

private:
	float lam0 ;
	float phi1 ;
	float sinphi1 ;
	float cosphi1 ;
	float R ;
	float k0 ;

	int mode ;

	static const int M_NORTH = 0 ;
	static const int M_SOUTH = 1 ;
	static const int M_EQUATOR = 2 ;
	static const int M_OBLIQUE = 3 ;
} ;

#endif // __P4STEREOGRAPHIC_H__
