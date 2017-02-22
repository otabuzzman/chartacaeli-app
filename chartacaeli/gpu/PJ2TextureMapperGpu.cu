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
	P4Projector* proj ;
	RealMatrix m2p(
		m2p00, m2p01, m2p02,
		m2p10, m2p11, m2p12,
		m2p20, m2p21, m2p22 ) ;
	RealMatrix h2t(
		h2t00, h2t01, h2t02, h2t03,
		h2t10, h2t11, h2t12, h2t13,
		h2t20, h2t21, h2t22, h2t23,
		h2t30, h2t31, h2t32, h2t33 ) ;
	Plane spt( p1x, p1y, p1z, p2x, p2y, p2z, p3x, p3y, p3z ) ;
	double st[] = { 0, 0, 1 }, *t0, *op, ca[] = { 0, 0, 0, 1 } ;
	Coordinate uv, *eq ;
	Vector3D l0, l1, *t1 ;

	t = blockIdx.y*blockDim.y+threadIdx.y ;
	s = blockIdx.x*blockDim.x+threadIdx.x ;

	if ( t>=dimt || s>=dims )
		return ;

	proj = createP4Projector( pnam ) ;
	proj->init( lam0, phi1, R, k0 ) ;

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
	delete eq ;
	delete[] t0 ;
	delete proj ;
}

#ifdef PJ2TEXTUREMAPPERGPU_MAIN
int main( int argc, char** argv ) {
	return EXIT_SUCCESS ;
}
#endif // PJ2TEXTUREMAPPERGPU_MAIN
