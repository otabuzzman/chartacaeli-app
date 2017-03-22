#include <cstdio>
#include <cstdlib>

#include <math_constants.h>

#include "P4Mollweide_f.h"
#include "Coordinate_f.h"
#include "Math_f.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ P4Mollweide::P4Mollweide() {
	init( 0, 0, 1, 1 ) ;
}

__device__ void P4Mollweide::init( float lam0, float phi1, float R, float k0 ) {
	this->lam0 = lam0 ;
	this->R = R ;
}

__device__ Coordinate& P4Mollweide::forward( const Coordinate& lamphi, Coordinate& xy ) {
	float tht2 = lamphi.y, dtht2 = 0, sintht2, costht2 ;
	float sinphi, tht, sintht, costht ;

	sinphi = sinpif( __fdividef( lamphi.y, 180.f ) ) ;

	do {
		tht2 = tht2+dtht2 ;

		sincospif( __fdividef( tht2, 180.f ), &sintht2, &costht2 ) ;

		dtht2 = __fdividef( -( tht2*radperdeg+sintht2-CUDART_PI_F*sinphi ), ( 1+costht2 )*degperrad ) ;
	} while ( abs( dtht2 )>V_CON ) ;

	tht = tht2*.5f ;
	sincospif( __fdividef( tht, 180.f ), &sintht, &costht ) ;

	xy.x = ( __fdividef( 2.82842712475f, CUDART_PI_F ) )*R*( lamphi.x-lam0 )*costht*radperdeg ;
	xy.y = 1.41421356237f*R*sintht ;

	return xy ;
}

__device__ Coordinate& P4Mollweide::inverse( const Coordinate& xy, Coordinate& lamphi ) {
	float tht, sin2tht, costht ;

	tht = degrees( asinf( __fdividef( xy.y, ( 1.41421356237f*R ) ) ) ) ;

	sin2tht = sinpif( __fdividef( ( 2*tht ), 180.f ) ) ;
	lamphi.y = degrees( asinf( __fdividef( ( 2*tht*radperdeg+sin2tht ), CUDART_PI_F ) ) ) ;

	if ( abs( lamphi.y ) == 90 )
		lamphi.x = lam0 ;
	else {
		costht = cospif( __fdividef( tht, 180.f ) ) ;
		lamphi.x = lam0+( CUDART_PI_F*__fdividef( xy.x, ( 2.82842712475f*R*costht ) ) )*degperrad ;
	}

	return lamphi ;
}

#ifdef P4MOLLWEIDE_MAIN
// kernel
__global__ void p4mollweide( float* buf ) {
	P4Mollweide proj ;
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
	p4mollweide<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( float )*2*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.4f %.4f\n", buf[2*i], buf[2*i+1] ) ;

	return EXIT_SUCCESS ;
}
#endif // P4MOLLWEIDE_MAIN
