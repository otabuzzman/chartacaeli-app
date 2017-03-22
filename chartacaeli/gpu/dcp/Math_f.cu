#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

// from CUDA Toolkit samples
#include <helper_cuda.h>

// names inspired by Cg Toolkit Standard Library
__device__ float degrees( float a ) {
	return a*57.295779513082320876798154814105f ;
}
__device__ float radians( float a ) {
	return a*0.017453292519943295769236907685f ;
}

#ifdef MATH_MAIN
// kernel
__global__ void math( float* buf ) {
	buf[threadIdx.x] = degrees( asin ( __sinf( radians( (float) threadIdx.x ) ) ) ) ;
}

#define NUM_BLOCKS 1
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	// host buffer
	float buf[NUM_THREADS] ;
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
	checkCudaErrors( cudaMalloc( (void**) &dbuf, sizeof( float )*NUM_THREADS ) ) ;

	// run kernel
	math<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( float )*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.6f\n", buf[i] ) ;

	return EXIT_SUCCESS ;
}
#endif // MATH_MAIN
