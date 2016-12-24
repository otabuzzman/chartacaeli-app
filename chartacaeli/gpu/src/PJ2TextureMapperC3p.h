#ifndef __PJ2TEXTUREMAPPERC3P_H__
#define __PJ2TEXTUREMAPPERC3P_H__

#include <map>
#include <string>

#include "RealMatrix.h"
#include "P4Projector.h"
#include "Plane.h"

// http://stackoverflow.com/questions/582331/is-there-a-way-to-instantiate-objects-from-a-string-holding-their-class-name
template<typename T>
P4Projector* createInstance() { return new T ; }
typedef std::map<std::string, P4Projector*(*)()> pmap_t ;

class PJ2TextureMapperC3p {

public:
	PJ2TextureMapperC3p( char* projtype, double projparm[4], double tmM2P[9], double tmH2T[16], double spT[9], double ups, int dimo, int dimp, int dims, int dimt ) ;

	void c3pFor( /* arg(s) */ int texture[], /* return */ int mapping[] ) ;

private:
	pmap_t pmap ;

	P4Projector* proj ;

	double ups ;
	int dimo, dimp ;
	int dims, dimt ;

	RealMatrix* tmM2P ;
	RealMatrix* tmH2T ;

	Plane* spT ;
} ;

#endif // __PJ2TEXTUREMAPPERC3P_H__
