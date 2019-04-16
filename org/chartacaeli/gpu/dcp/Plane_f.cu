#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Plane_f.h"
#include "Vector3D_f.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Plane::Plane( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) {
	set( p1, p2, p3 ) ;
}

__device__ Plane::Plane(
					const float p1x, const float p1y, const float p1z,
					const float p2x, const float p2y, const float p2z,
					const float p3x, const float p3y, const float p3z ) {
	Vector3D p1( p1x, p1y, p1z ) ;
	Vector3D p2( p2x, p2y, p2z ) ;
	Vector3D p3( p3x, p3y, p3z ) ;
	set( p1, p2, p3 ) ;
}

// https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection#Algebraic_form
__device__ Vector3D& Plane::intersection( const Vector3D& l1, const Vector3D& l2, Vector3D& x ) {
	Vector3D d00( p1 ), l( l2 ), nd0( normal ), ndl( normal ) ;
	float a, b, d ;

	d00.sub( l1 ) ;

	l.sub( l1 ) ;

	a = nd0.dot( d00 ) ;
	b = ndl.dot( l ) ;
	d = __fdividef( a, b ) ;
	l.mul( d ) ;

	x.set( l.x, l.y, l.z ) ;
	x.add( l1 ) ;

	return x ;
}

// private
__device__ void Plane::set( const Vector3D& p1, const Vector3D& p2, const Vector3D& p3 ) {
	Vector3D d21( p2 ) ;
	Vector3D d31( p3 ) ;

	d21.sub( p1 ) ;
	d31.sub( p1 ) ;

	this->p1.set( p1.x, p1.y, p1.z ) ;
	this->p2.set( p2.x, p2.y, p2.z ) ;
	this->p3.set( p3.x, p3.y, p3.z ) ;

	d21.cross( d31 ) ;
	normal.set( d21.x, d21.y, d21.z ) ;
}

#ifdef PLANE_MAIN
// kernel
__global__ void plane( float* buf ) {
	Vector3D p1( 1., 3., 7. ) ;
	Vector3D p2( 3., 7., 1. ) ;
	Vector3D p3( 7., 1., 3. ) ;
	Plane p( p1, p2, p3 ) ;
	Vector3D l0, l1, x ;
	float a, b, c ;
	int i = threadIdx.x ;

	a = i ; b = a+1 ; c = b+1 ;
	l1.set( __fdividef( ( ( a+4 )+( a+1 )+( a-2 ) ), 4.f ), __fdividef( ( ( b+4 )+( b+1 )+( b-2 ) ), 4.f ), __fdividef( ( ( c+4 )+( c+1 )+( c-2 ) ), 4.f ) ) ;
	p.intersection( l0, l1, x ) ;
	buf[3*i] = x.x ;
	buf[3*i+1] = x.y ;
	buf[3*i+2] = x.z ;
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
	plane<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( float )*3*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.6f %.6f %.6f\n", buf[3*i], buf[3*i+1], buf[3*i+2] ) ;

	return EXIT_SUCCESS ;
}
#endif // PLANE_MAIN
