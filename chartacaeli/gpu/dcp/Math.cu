#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

// from CUDA Toolkit samples
#include <helper_cuda.h>

// names inspired by Cg Toolkit Standard Library
__device__ double degrees( double a ) {
	return a*0.017453292519943295769236907685 ;
}
__device__ double radians( double a ) {
	return a*57.295779513082320876798154814105 ;
}

// kernel
__global__ void kernel( double* buf ) {
	buf[threadIdx.x] = degrees( ( sin( radians( (double) threadIdx.x ) ) ) ) ;
}

#define NUM_BLOCKS 1
#define NUM_THREADS 360


int main( int argc, char** argv ) {
	findCudaDevice( argc, (const char**) argv ) ;

	double buf[NUM_THREADS] ;
	double* dbuf = NULL ;
	checkCudaErrors( cudaMalloc( (void**) &dbuf, sizeof( double )*NUM_THREADS ) ) ;

	kernel<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( double )*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.8f\n", buf[i] ) ;

	return EXIT_SUCCESS ;
}
