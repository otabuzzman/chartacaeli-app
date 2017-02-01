#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Plane.h"
#include "Vector3D.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Plane::Plane( Vector3D& p1, Vector3D& p2, Vector3D& p3 ) {
	set( p1, p2, p3 ) ;
}

__device__ Plane::~Plane() {
	delete p1 ;
	delete p2 ;
	delete p3 ;
	delete normal ;
}

// https://en.wikipedia.org/wiki/Line%E2%80%93plane_intersection#Algebraic_form
__device__ Vector3D* Plane::intersection( Vector3D& l1, Vector3D& l2 ) {
	Vector3D *d00, *l, *x ;
	double d ;

	d00 = new Vector3D( *p1) ;
	d00->sub( l1 ) ;

	l = new Vector3D( l2 ) ;
	l->sub( l1 ) ;

	d = normal->dot( *d00 )/normal->dot( *l ) ;
	l->mul( d ) ;

	x = new Vector3D( l1) ;
	x->add( *l ) ;

	delete d00 ;
	delete l ;

	return x ;
}

__device__ void Plane::set( Vector3D& p1, Vector3D& p2, Vector3D& p3 ) {
	Vector3D* d21 = ( new Vector3D( p2 ) )->sub( p1 ) ;
	Vector3D* d31 = ( new Vector3D( p3 ) )->sub( p1 ) ;

	this->p1 = new Vector3D( p1.x, p1.y, p1.z ) ;
	this->p2 = new Vector3D( p2.x, p2.y, p2.z ) ;
	this->p3 = new Vector3D( p3.x, p3.y, p3.z ) ;

	normal = new Vector3D( *( d21->cross( *d31 ) ) ) ;

	delete d21 ;
	delete d31 ;
}

// kernel
__global__ void plane( double* buf ) {
	Vector3D *p1, *p2, *p3 ;
	Plane* p ;
	Vector3D *l0, *l1, *x ;
	double a, b, c ;
	int i = threadIdx.x ;

	p1 = new Vector3D( 1., 3., 7. ) ;
	p2 = new Vector3D( 3., 7., 1. ) ;
	p3 = new Vector3D( 7., 1., 3. ) ;
	p = new Plane( *p1, *p2, *p3 ) ;

	l0 = new Vector3D() ;
	l1 = new Vector3D() ;

	a = i ; b = a+1 ; c = b+1 ;
	l1->set( ( ( a+4 )+( a+1 )+( a-2 ) )/4, ( ( b+4 )+( b+1 )+( b-2 ) )/4, ( ( c+4 )+( c+1 )+( c-2 ) )/4 ) ;
	x = p->intersection( *l0, *l1 ) ;
	buf[3*i] = x->x ;
	buf[3*i+1] = x->y ;
	buf[3*i+2] = x->z ;

	delete x ;

	delete l1 ;
	delete l0 ;
	delete p ;
	delete p3 ;
	delete p2 ;
	delete p1 ;
}

#ifdef PLANE_MAIN
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
	plane<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( double )*3*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.8f %.8f %.8f\n", buf[3*i], buf[3*i+1], buf[3*i+2] ) ;

	return EXIT_SUCCESS ;
}
#endif // PLANE_MAIN
