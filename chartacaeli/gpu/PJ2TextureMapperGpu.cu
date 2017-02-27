#include <new>
#include <cstdlib>

#include "dcp/P4Projector.h"
#include "dcp/P4Stereographic.h"
#include "dcp/P4Orthographic.h"
#include "dcp/P4Mollweide.h"
#include "dcp/Plane.h"
#include "dcp/Vector4D.h"
#include "dcp/Vector3D.h"
#include "dcp/Coordinate.h"

__device__ P4Projector* createP4Projector( const char *pnam, unsigned char* pmem ) {
	switch ( *( pnam+2 ) ) {
		case 'S':
			return new( pmem ) P4Stereographic() ;
		case 'O':
			return new( pmem ) P4Orthographic() ;
		case 'M':
			return new( pmem ) P4Mollweide() ;
		default:
			return nullptr ;
	}
}

// CUDA kernel
extern "C" __global__ void run(
			const char* pnam, const double lam0, const double phi1, const double R, const double k0,
			const double m2p00, const double m2p01, const double m2p02,
			const double m2p10, const double m2p11, const double m2p12,
			const double m2p20, const double m2p21, const double m2p22,
			const double h2t00, const double h2t01, const double h2t02, const double h2t03,
			const double h2t10, const double h2t11, const double h2t12, const double h2t13,
			const double h2t20, const double h2t21, const double h2t22, const double h2t23,
			const double h2t30, const double h2t31, const double h2t32, const double h2t33,
			const double p1x, const double p1y, const double p1z,
			const double p2x, const double p2y, const double p2z,
			const double p3x, const double p3y, const double p3z,
			const int dimo, const int dimp, const int** texture,
			const int dims, const int dimt, int** mapping,
			const double ups ) {
	int t, s ;
	__shared__ unsigned char pool[256] ;
	__shared__ P4Projector* proj ;
	__shared__ Plane* spt ;
	Vector3D uv, l0, l1, ca ;
	Vector4D op ;

	t = blockIdx.y*blockDim.y+threadIdx.y ;
	s = blockIdx.x*blockDim.x+threadIdx.x ;

	if ( t>=dimt || s>=dims )
		return ;

	if ( threadIdx.y == 0 && threadIdx.x == 0 ) {
		proj = createP4Projector( pnam, &pool[0] ) ;
		if ( proj == nullptr )
			return ;
		proj->init( lam0, phi1, R, k0 ) ;

		spt = new( &pool[128] ) Plane( p1x, p1y, p1z, p2x, p2y, p2z, p3x, p3y, p3z ) ;
	}

	__syncthreads() ;

	// transform s/t to projection coordinates u/v
	uv.set( s*ups, t*ups, 1 ) ;
	uv.apply(
		m2p00, m2p01, m2p02,
		m2p10, m2p11, m2p12,
		m2p20, m2p21, m2p22 ) ;

	// transform u/v to spherical (equatorial) coordinates
	proj->inverse( uv, l1 ) ;

	// convert spherical to cartesian
	l1.cartesian() ;

	// find spatial intersection with texture
	spt->intersection( l0, l1, ca ) ;

	// transform to texture coordinates o/p
	op.set( ca.x, ca.y, ca.z, 1 ) ;
	op.apply(
		h2t00, h2t01, h2t02, h2t03,
		h2t10, h2t11, h2t12, h2t13,
		h2t20, h2t21, h2t22, h2t23,
		h2t30, h2t31, h2t32, h2t33 ) ;

	// map o/p if on texture
	if ( op.e0>=0 && op.e1>=0 && dimo>op.e0 && dimp>op.e1 )
		mapping[t][s] = texture[(int) op.e1][(int) op.e0] ;
}

#ifdef PJ2TEXTUREMAPPERGPU_MAIN
int main( int argc, char** argv ) {
	return EXIT_SUCCESS ;
}
#endif // PJ2TEXTUREMAPPERGPU_MAIN
