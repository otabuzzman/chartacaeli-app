#ifndef __P4ORTHOGRAPHIC_H__
#define __P4ORTHOGRAPHIC_H__

#include "P4Projector_f.h"
#include "Coordinate_f.h"

class P4Orthographic : public P4Projector {

public:
	__device__ P4Orthographic() ;

	__device__ void init( float lam0, float phi1, float R, float k0 ) ;
	__device__ Coordinate& forward( const Coordinate& lamphi, Coordinate& xy ) ;
	__device__ Coordinate& inverse( const Coordinate& xy, Coordinate& lamphi ) ;

private:
	float lam0 ;
	float phi1 ;
	float sinphi1 ;
	float cosphi1 ;
	float R ;

	int mode ;

	static const int M_NORTH = 0 ;
	static const int M_SOUTH = 1 ;
	static const int M_EQUATOR = 2 ;
	static const int M_OBLIQUE = 3 ;
} ;

#endif // __P4ORTHOGRAPHIC_H__
