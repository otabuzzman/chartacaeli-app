#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Coordinate_f.h"
#include "Math_f.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Coordinate::Coordinate() : x( 0 ), y( 0 ), z( 0 ) {
}

__device__ Coordinate::Coordinate( const Coordinate& c ) {
	set( c.x, c.y, c.z ) ;
}

__device__ Coordinate::Coordinate( float x, float y, float z ) {
	set( x, y, z ) ;
}

__device__ void Coordinate::set( float x, float y, float z ) {
	this->x = x ;
	this->y = y ;
	this->z = z ;
}

__device__ void Coordinate::spherical() {
	float r = sqrtf( x*x+y*y+z*z ) ;

	x = degrees( atan2f( y, x ) ) ;
	y = degrees( asinf( __fdividef( z, r ) ) ) ;
	z = 0 ;
}

__device__ void Coordinate::cartesian() {
	float sinx, cosx, siny, cosy ;

	sincospif( __fdividef( x, 180.f ), &sinx, &cosx ) ;
	sincospif( __fdividef( y, 180.f ), &siny, &cosy ) ;

	x = cosy*cosx ;
	y = cosy*sinx ;
	z = siny ;
}

#ifdef COORDINATE_MAIN
// kernel
__global__ void coordinate( float* buf ) {
	Coordinate c ;

	c.set( threadIdx.x, threadIdx.x+1, threadIdx.x+2 ) ;
	c.spherical() ;
	c.cartesian() ;
	buf[3*threadIdx.x] = c.x ;
	buf[3*threadIdx.x+1] = c.y ;
	buf[3*threadIdx.x+2] = c.z ;
}

#define NUM_BLOCKS 1
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	// host buffer
	float buf[3*NUM_THREADS] ;
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
	checkCudaErrors( cudaMalloc( (void**) &dbuf, sizeof( float )*3*NUM_THREADS ) ) ;

	// run kernel
	coordinate<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( float )*3*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.6f %.6f %.6f\n", buf[3*i], buf[3*i+1], buf[3*i+2] ) ;

	return EXIT_SUCCESS ;
}
#endif // COORDINATE_MAIN
