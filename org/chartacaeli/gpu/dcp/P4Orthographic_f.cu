#include <cstdio>
#include <cstdlib>

#include "P4Orthographic_f.h"
#include "Coordinate_f.h"
#include "Math_f.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ P4Orthographic::P4Orthographic() {
	init( 0, 90, 1, 1 ) ;
}

__device__ void P4Orthographic::init( float lam0, float phi1, float R, float k0 ) {
	this->lam0 = lam0 ;
	this->phi1 = phi1 ;
	sincospif( __fdividef( phi1, 180.f ), &sinphi1, &cosphi1 ) ;
	this->R = R ;

	if ( phi1 == 90 )
		mode = M_NORTH ;
	else if ( phi1 == -90 )
		mode = M_SOUTH ;
	else if ( phi1 == 0 )
		mode = M_EQUATOR ;
	else
		mode = M_OBLIQUE ;
}

__device__ Coordinate& P4Orthographic::forward( const Coordinate& lamphi, Coordinate& xy ) {
	float sinlamdif, coslamdif ;
	float sinphi, cosphi ;

	sincospif( __fdividef( ( lamphi.x-lam0 ), 180.f ), &sinlamdif, &coslamdif ) ;
	sincospif( __fdividef( lamphi.y, 180.f ), &sinphi, &cosphi ) ;

	xy.x = R*cosphi*sinlamdif ;

	switch ( mode ) {
	case M_NORTH:
		xy.y = -R*cosphi*coslamdif ;

		break ;
	case M_SOUTH:
		xy.y = R*cosphi*coslamdif ;

		break ;
	case M_EQUATOR:
		xy.y = R*sinphi ;

		break ;
	case M_OBLIQUE:
		xy.y = R*( cosphi1*sinphi-sinphi1*cosphi*coslamdif ) ;

		break ;
	}

	return xy ;
}

__device__ Coordinate& P4Orthographic::inverse( const Coordinate& xy, Coordinate& lamphi ) {
	float p, c, sinc, cosc ;

	p = sqrtf( xy.x*xy.x+xy.y*xy.y ) ;
	c = degrees( asinf( __fdividef( p, R ) ) ) ;

	sincospif( __fdividef( c, 180.f ), &sinc, &cosc ) ;

	lamphi.y = degrees( asinf( cosc*sinphi1+( xy.y*sinc*__fdividef( cosphi1, p ) ) ) ) ;

	switch ( mode ) {
	case M_NORTH:
		lamphi.x = lam0+degrees( atan2f(xy.x, -xy.y ) ) ;

		break ;
	case M_SOUTH:
		lamphi.x = lam0+degrees( atan2f(xy.x, xy.y ) ) ;

		break ;
	case M_EQUATOR:
	case M_OBLIQUE:
		lamphi.x = lam0+degrees( atan2f( xy.x*sinc, p*cosphi1*cosc-xy.y*sinphi1*sinc ) ) ;

		break ;
	}

	return lamphi ;
}

#ifdef P4ORTHOGRAPHIC_MAIN
// kernel
__global__ void p4orthographic( float* buf ) {
	P4Orthographic proj ;
	Coordinate lamphi, xy, res ;
	int i = threadIdx.x ;

	lamphi.set( (float) i, (float) ( i%90 ), 0 ) ;
	proj.forward( lamphi, xy ) ;
	proj.inverse( xy, res ) ;
	buf[2*i] = res.x ;
	buf[2*i+1] = res.y ;
}

#define NUM_BLOCKS 1
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	// host buffer
	float buf[2*NUM_THREADS] ;
	// device buffer
	float* dbuf = NULL ;
	cudaDeviceProp devProp ;
	int devID ;

	// find device and output compute capability on stderr
	devID = gpuGetMaxGflopsDeviceId() ;
	checkCudaErrors( cudaSetDevice( devID ) ) ;
	checkCudaErrors( cudaGetDeviceProperties( &devProp, devID ) ) ;
	fprintf( stderr, "%d%d\n", devProp.major, devProp.minor ) ;

	// allocate device buffer memory
	checkCudaErrors( cudaMalloc( (void**) &dbuf, sizeof( float )*2*NUM_THREADS ) ) ;

	// run kernel
	p4orthographic<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( float )*2*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.4f %.4f\n", buf[2*i], buf[2*i+1] ) ;

	return EXIT_SUCCESS ;
}
#endif // P4ORTHOGRAPHIC_MAIN
