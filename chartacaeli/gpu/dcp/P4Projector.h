#ifndef __P4PROJECTOR_H__
#define __P4PROJECTOR_H__

#include "Coordinate.h"

class P4Projector {

public:
	__device__ virtual ~P4Projector() {}

	__device__ virtual void init( double lam0, double phi1, double R, double k0 ) = 0 ;
	__device__ virtual Coordinate* forward( Coordinate& lamphi ) = 0 ;
	__device__ virtual Coordinate* inverse( Coordinate& xy ) = 0 ;
} ;

#endif // __P4PROJECTOR_H__
