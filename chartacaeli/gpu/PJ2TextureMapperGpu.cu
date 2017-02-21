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
extern "C" __global__ void run( const char* pnam, double* tmM2P, double* tmH2T, double** spT, const int** texture, int** mapping ) {
	int t, s ;
	P4Projector* proj ;
	RealMatrix m2p( tmM2P, 3, 3 ), h2t( tmH2T, 4, 4 ) ;
	Vector3D p1( spT[0][0], spT[0][1], spT[0][2] ) ;
	Vector3D p2( spT[1][0], spT[1][1], spT[1][2] ) ;
	Vector3D p3( spT[2][0], spT[2][1], spT[2][2] ) ;
	Plane spt( p1, p2, p3 ) ;
	double st[] = { 0, 0, 1 }, *t0, *op, ca[] = { 0, 0, 0, 1 } ;
	Coordinate uv, *eq ;
	Vector3D l0, l1, *t1 ;

	t = blockIdx.y*blockDim.y+threadIdx.y ;
	s = blockIdx.x*blockDim.x+threadIdx.x ;

	if ( t>=dimt || s>=dims )
		return ;

	proj = createP4Projector( pnam ) ;
	proj->init( lim0, phi1, R, k0 ) ;

	st[1] = t*ups ;
	st[0] = s*ups ;

	// transform s/t to projection coordinates u/v
	t0 = m2p.operate( st ) ;
	uv.set( t0[0], t0[1], t0[2] ) ;
	// transform u/v to spherical (equatorial) coordinates
	eq = proj->inverse( uv ) ;
	// convert spherical to cartesian
	eq->cartesian() ;
	l1.set( eq->x, eq->y, eq->z ) ;
	// find cartesian coordinates c/a of spatial intersection with texture
	t1 = spt.intersection( l0, l1 ) ;
	ca[0] = t1->x ;
	ca[1] = t1->y ;
	ca[2] = t1->z ;
	// transform c/a to texture coordinates o/p
	op = h2t.operate( ca ) ;

	// map o/p if on texture
	if ( op[0]>=0 && op[1]>=0 && dimo>op[0] && dimp>op[1] )
		mapping[t][s] = texture[(int) op[1]][(int) op[0]] ;

	delete[] op ;
	delete t1 ;
	delete[] t0 ;
	delete proj ;
}

#ifdef PJ2TEXTUREMAPPERGPU_MAIN
int main( int argc, char** argv ) {
	return EXIT_SUCCESS ;
}
#endif // PJ2TEXTUREMAPPERGPU_MAIN
