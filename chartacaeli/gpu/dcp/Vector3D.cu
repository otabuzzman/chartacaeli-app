#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Vector3D.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Vector3D::Vector3D() : x( 0 ), y( 0 ), z( 0 ) {
}

__device__ Vector3D::Vector3D( double v[3] ) {
	set( v[0], v[1], v[2] ) ;
}

__device__ Vector3D::Vector3D( Vector3D& v ) {
	set( v.x, v.y, v.z ) ;
}

__device__ Vector3D::Vector3D( double x, double y, double z ) {
	set( x, y, z ) ;
}

__device__ void Vector3D::set( double x, double y, double z ) {
	this->x = x ;
	this->y = y ;
	this->z = z ;
}

__device__ Vector3D* Vector3D::add( Vector3D& v ) {
	x += v.x ;
	y += v.y ;
	z += v.z ;

	return this ;
}

__device__ Vector3D* Vector3D::sub( Vector3D& v ) {
	x -= v.x ;
	y -= v.y ;
	z -= v.z ;

	return this ;
}

__device__ Vector3D* Vector3D::mul( double a ) {
	x *= a ;
	y *= a ;
	z *= a ;

	return this ;
}

__device__ double Vector3D::dot( Vector3D& v ) {
	return x*v.x+y*v.y+z*v.z ;
}

__device__ Vector3D* Vector3D::cross( Vector3D& v ) {
	double x, y, z ;

	x = this->x ;
	y = this->y ;
	z = this->z ;

	this->x = y*v.z-z*v.y ;
	this->y = z*v.x-x*v.z ;
	this->z = x*v.y-y*v.x ;

	return this ;
}

__device__ double* Vector3D::toArray() {
	double* r = new double[3] ;

	r[0] = x ;
	r[1] = y ;
	r[2] = z ;

	return r ;
}

#ifdef VECTOR3D_MAIN
// kernel
__global__ void vector3d( double* buf ) {
	Vector3D *a, *b ;
	int i = threadIdx.x ;

	a = new Vector3D( i, i+.123, i+.234 ) ;
	b = new Vector3D( i+.234, i+.123, i ) ;
	buf[i] = a->cross( *b )->dot( *a ) ;

	delete b ;
	delete a ;
}

#define NUM_BLOCKS 1
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	// host buffer
	double buf[NUM_THREADS] ;
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
	checkCudaErrors( cudaMalloc( (void**) &dbuf, sizeof( double )*NUM_THREADS ) ) ;

	// run kernel
	vector3d<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( double )*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.6f\n", buf[i] ) ;

	return EXIT_SUCCESS ;
}
#endif // VECTOR3D_MAIN
