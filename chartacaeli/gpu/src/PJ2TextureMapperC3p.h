#ifndef __PJ2TEXTUREMAPPERC3P_H__
#define __PJ2TEXTUREMAPPERC3P_H__

#include "P4Projector.h"
#include "RealMatrix.h"
#include "Plane.h"

class PJ2TextureMapperC3p {

public:
	PJ2TextureMapperC3p( char* projtype, double projparm[4], double tmM2P[9], double tmH2T[16], double spT[9], double ups, int dimo, int dimp, int dims, int dimt ) ;
	~PJ2TextureMapperC3p() ;

	void run( /* arg(s) */ int texture[], /* return */ int mapping[] ) ;

private:
	P4Projector* proj ;

	double ups ;
	int dimo, dimp ;
	int dims, dimt ;

	RealMatrix* tmM2P ;
	RealMatrix* tmH2T ;

	Plane* spT ;
} ;

#endif // __PJ2TEXTUREMAPPERC3P_H__
