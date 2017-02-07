#include <cstdlib>

#include "dcp/P4Projector.h"
#include "dcp/P4Stereographic.h"
#include "dcp/P4Orthographic.h"
#include "dcp/P4Mollweide.h"
#include "dcp/RealMatrix.h"
#include "dcp/Vector3D.h"
#include "dcp/Plane.h"
#include "dcp/Coordinate.h"

__device__ P4Projector* createP4Projector( const char *pnam ) {
	switch ( *( pnam+2 ) ) {
		case 'S':
			return new P4Stereographic() ;
		case 'O':
			return new P4Orthographic() ;
		case 'M':
			return new P4Mollweide() ;
		default:
			return NULL ;
	}
}

// projector params in global memory
__device__ double lim0 ;
__device__ double phi1 ;
__device__ double R ;
__device__ double k0 ;

// texture params (dimo, dimp) in global memory
__device__ int dimo ;
__device__ int dimp ;

// mapping params (dims, dimt) in global memory
__device__ int dims ;
__device__ int dimt ;

// general params in global memory
__device__ double ups ;

// CUDA kernel
extern "C" __global__ void run( const char* pnam, double* tmM2Pj, double* tmH2Tj, double** spTj, const int** texture, int** mapping ) {
	int t, s ;
	P4Projector* proj ;
	RealMatrix *tmM2P, *tmH2T ;
	Vector3D *p1, *p2, *p3 ;
	Plane* spT ;
	double st[] = { 0, 0, 1 }, *t0, *op, ca[] = { 0, 0, 0, 1 } ;
	Coordinate uv, *eq, *t1 ;
	Vector3D l0, l1, *t2 ;

	t = blockIdx.y*blockDim.y+threadIdx.y ;
	s = blockIdx.x*blockDim.x+threadIdx.x ;

	if ( dimt>t || dims>s )
		return ;

	proj = createP4Projector( pnam ) ;
	proj->init( lim0, phi1, R, k0 ) ;

	tmM2P = new RealMatrix( tmM2Pj, 3, 3 ) ;
	tmH2T = new RealMatrix( tmH2Tj, 4, 4 ) ;

	p1 = new Vector3D( spTj[0] ) ;
	p2 = new Vector3D( spTj[1] ) ;
	p3 = new Vector3D( spTj[2] ) ;
	spT = new Plane( *p1, *p2, *p3 ) ;

	st[1] = t*ups ;
	st[0] = s*ups ;

	// transform s/t to projection coordinates u/v
	t0 = tmM2P->operate( st ) ;
	uv.set( t0[0], t0[1], t0[2] ) ;
	// transform u/v to spherical (equatorial) coordinates
	eq = proj->inverse( uv ) ;
	// convert spherical to cartesian
	t1 = eq->cartesian() ;
	l1.set( t1->x, t1->y, t1->z ) ;
	// find cartesian coordinates c/a of spatial intersection with texture
	t2 = spT->intersection( l0, l1 ) ;
	ca[0] = t2->x ;
	ca[1] = t2->y ;
	ca[2] = t2->z ;
	// transform c/a to texture coordinates o/p
	op = tmH2T->operate( ca ) ;

	// map o/p if on texture
	if ( op[0]>=0 && op[1]>=0 && dimo>op[0] && dimp>op[1] )
		mapping[t][s] = texture[(int) op[1]][(int) op[0]] ;

	delete op ;
	delete t2 ;
	delete t1 ;
	delete eq ;
	delete t0 ;
	delete spT ;
	delete p3 ;
	delete p2;
	delete p1 ;
	delete tmH2T ;
	delete tmM2P ;
	delete proj ;
}

#ifdef PJ2TEXTUREMAPPERGPU_MAIN
int main( int argc, char** argv ) {
	return EXIT_SUCCESS ;
}
#endif // PJ2TEXTUREMAPPERGPU_MAIN
