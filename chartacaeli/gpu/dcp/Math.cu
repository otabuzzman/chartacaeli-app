#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

// from CUDA Toolkit samples
#include <helper_cuda.h>

// names inspired by Cg Toolkit Standard Library
__device__ double degrees( double a ) {
	return a*57.295779513082320876798154814105 ;
}
__device__ double radians( double a ) {
	return a*0.017453292519943295769236907685 ;
}

// kernel
__global__ void kernel( double* buf ) {
	buf[threadIdx.x] = degrees( asin ( sin( radians( (double) threadIdx.x ) ) ) ) ;
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
	kernel<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( double )*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.8f\n", buf[i] ) ;

	return EXIT_SUCCESS ;
}
