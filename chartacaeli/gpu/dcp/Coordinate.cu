#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Coordinate.h"
#include "Math.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Coordinate::Coordinate() : x( 0 ), y( 0 ), z( 0 ) {
}

__device__ Coordinate::Coordinate( double c[3] ) {
	set( c[0], c[1], c[2] ) ;
}

__device__ Coordinate::Coordinate( Coordinate& c ) {
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

__device__ Coordinate* Coordinate::spherical() {
	double x, y ;
	Coordinate *c ;

	x = degrees( atan2( this->y, this->x ) ) ;
	y = degrees( asin( z/sqrt( this->x*this->x+this->y*this->y+z*z ) ) ) ;

	c = new Coordinate( x, y, 0 ) ;

	return c ;
}

__device__ Coordinate* Coordinate::cartesian() {
	double x, y, z ;
	Coordinate *c ;

	x = radians( cos( this->y ) )*radians( cos( this->x ) ) ;
	y = radians( cos( this->y ) )*radians( sin( this->x ) ) ;
	z = radians( sin( this->y ) ) ;

	c = new Coordinate( x, y, z ) ;

	return c ;
}

__device__ double* Coordinate::toArray() {
	double* r = new double[3] ;

	r[0] = x ;
	r[1] = y ;
	r[2] = z ;

	return r ;
}

// kernel
__global__ void coordinate( double* buf ) {
	Coordinate c( threadIdx.x, threadIdx.x+1, threadIdx.x+2 ), *t0, *t1 ;

	t0 = c.spherical() ;
	t1 = t0->cartesian() ;
	buf[3*threadIdx.x] = t1->x ;
	buf[3*threadIdx.x+1] = t1->y ;
	buf[3*threadIdx.x+2] = t1->z ;
	delete t1 ;
	delete t0 ;
}

#ifdef COORDINATE_MAIN
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
