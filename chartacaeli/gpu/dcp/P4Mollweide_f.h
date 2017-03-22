#ifndef __P4MOLLWEIDE_H__
#define __P4MOLLWEIDE_H__

#include "P4Projector_f.h"
#include "Coordinate_f.h"

class P4Mollweide : public P4Projector {

public:
	__device__ P4Mollweide() ;

	__device__ void init( float lam0, float phi1, float R, float k0 ) ;
	__device__ Coordinate& forward( const Coordinate& lamphi, Coordinate& xy ) ;
	__device__ Coordinate& inverse( const Coordinate& xy, Coordinate& lamphi ) ;

private:
	float lam0 ;
	float R ;

	const float V_CON = 1e-7f ;
	const float radperdeg = 0.01745329251f ; // __fdividef( 3.141592653589793f, 180.f )
	const float degperrad = 57.2957795131f ; // __fdividef( 180.f, 3.141592653589793f )
} ;

#endif // __P4MOLLWEIDE_H__
