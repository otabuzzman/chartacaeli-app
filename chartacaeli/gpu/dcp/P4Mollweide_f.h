#ifndef __P4MOLLWEIDE_H__
#define __P4MOLLWEIDE_H__

#include "P4Projector.h"
#include "Coordinate.h"

class P4Mollweide : public P4Projector {

public:
	__device__ P4Mollweide() ;

	__device__ void init( float lam0, float phi1, float R, float k0 ) ;
	__device__ Coordinate& forward( const Coordinate& lamphi, Coordinate& xy ) ;
	__device__ Coordinate& inverse( const Coordinate& xy, Coordinate& lamphi ) ;

private:
	float lam0 ;
	float R ;

	const float V_CON ;
	const float radperdeg ;
	const float degperrad ;
} ;

#endif // __P4MOLLWEIDE_H__
