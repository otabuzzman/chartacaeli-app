#include "PJ2TextureMapperC3p.h"
#include "P4ProjectorFactory.h"
#include "Vector3D.h"
#include "RealMatrix.h"
#include "Plane.h"
using namespace std;

PJ2TextureMapperC3p::PJ2TextureMapperC3p( char* projtype, double projparm[4], double tmM2P[9], double tmH2T[16], double spT[9], double ups, int dimo, int dimp, int dims, int dimt ) {
	Vector3D p0( spT[0], spT[1], spT[2] ) ;
	Vector3D p1( spT[3], spT[4], spT[5] ) ;
	Vector3D p2( spT[6], spT[7], spT[8] ) ;

	proj = P4ProjectorFactory::createInstance( projtype ) ;
	proj->init( projparm[0], projparm[1], projparm[2], projparm[3] ) ;

	this->tmM2P = new RealMatrix( tmM2P, 3, 3 ) ;
	this->tmH2T = new RealMatrix( tmH2T, 4, 4 ) ;

	this->spT = new Plane( p0, p1, p2 ) ;

	this->ups = ups ;

	this->dimo = dimo ;
	this->dimp = dimp ;

	this->dims = dims ;
	this->dimt = dimt ;
}

void PJ2TextureMapperC3p::c3pFor( /* arg(s) */ int texture[], /* return */ int mapping[] ) {
	double st[] = { 0, 0, 1 }, uv[3] ;
	double lamphi[3] ;
	Coordinate eq ;
	double l0[3] = { 0 }, l1[3], ca[] = { 0, 0, 0, 1 } ;
	double op[4] ;

	// s/t coordinates of rectangle enclosing projected texture
	for ( int y=0 ; dimt>y ; y++ ) {
		st[1] = y*ups ;
		for ( int x=0 ; dims>x ; x++ ) {
			st[0] = x*ups ;

			// transform s/t to projection coordinates u/v
			tmM2P->operate( st,  uv ) ;
			// transform u/v to spherical (equatorial) coordinates
			proj->inverse( uv, lamphi ) ;
			// convert spherical to cartesian
			eq.set( lamphi[0], lamphi[1], lamphi[2] ) ;
			eq.cartesian( l1 ) ;
			// find cartesian coordinates c/a of spatial intersection with texture
			spT->intersection( l0, l1, ca ) ;
			// transform c/a to texture coordinates o/p
			tmH2T->operate( ca, op ) ;

			// map o/p if on texture
			if ( op[0]>=0 && op[1]>=0 && dimo>op[0] && dimp>op[1] )
				mapping[y*dims+x] = texture[(int) op[1]*dimo+(int) op[0]] ;
		}
	}
}
