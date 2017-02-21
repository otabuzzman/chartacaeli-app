#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Coordinate.h"
#include "Math.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Coordinate::Coordinate() : x( 0 ), y( 0 ), z( 0 ) {
}

__device__ Coordinate::Coordinate( const Coordinate& c ) {
	set( c.x, c.y, c.z ) ;
}

__device__ Coordinate::Coordinate( double x, double y, double z ) {
	set( x, y, z ) ;
}

__device__ void Coordinate::set( double x, double y, double z ) {
	this->x = x ;
	this->y = y ;
	this->z = z ;
}

__device__ void Coordinate::spherical() {
	double r = sqrt( x*x+y*y+z*z ) ;

	x = degrees( atan2( y, x ) ) ;
	y = degrees( asin( z/r ) ) ;
	z = 0 ;
}

__device__ void Coordinate::cartesian() {
	double _x = x, _y = y ;

	x = cos( radians( _y ) )*cos( radians( _x ) ) ;
	y = cos( radians( _y ) )*sin( radians( _x ) ) ;
	z = sin( radians( _y ) ) ;
}

#ifdef COORDINATE_MAIN
// kernel
__global__ void coordinate( double* buf ) {
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
	double buf[3*NUM_THREADS] ;
	// device buffer
	double* dbuf = NULL ;
	cudaDeviceProp devProp ;
	int devID ;

	// find device and output compute capability on stderr
	devID = gpuGetMaxGflopsDeviceId() ;
	checkCudaErrors( cudaSetDevice( devID ) ) ;
	checkCudaErrors( cudaGetDeviceProperties( &devProp, devID ) ) ;
	fprintf( stderr, "%d%d\n", devProp.major, devProp.minor ) ;

	// allocate device buffer memory
	checkCudaErrors( cudaMalloc( (void**) &dbuf, sizeof( double )*3*NUM_THREADS ) ) ;

	// run kernel
	coordinate<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( double )*3*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.8f %.8f %.8f\n", buf[3*i], buf[3*i+1], buf[3*i+2] ) ;

	return EXIT_SUCCESS ;
}
#endif // COORDINATE_MAIN
