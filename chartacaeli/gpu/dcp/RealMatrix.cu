#include <cstdio>
#include <cstdlib>
#include <algorithm>

#include <cuda_runtime.h>

#include "RealMatrix.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ RealMatrix::RealMatrix( double matrix[], int rows, int cols ) {
	set( matrix, rows, cols ) ;
}

__device__ RealMatrix::RealMatrix() {}

__device__ RealMatrix::~RealMatrix() {
	delete matrix ;
}

__device__ double* RealMatrix::operate( double vector[] ) {
	double sum, *retval = new double[rows] ;

	for ( int r=0 ; rows>r ; r++ ) {
		sum = 0 ;
		for ( int c=0 ; cols>c ; c++ )
			sum += matrix[rows*r+c]*vector[c] ;
		retval[r] = sum ;
	}

	return retval ;
}

__device__ void RealMatrix::set( double matrix[], int rows, int cols ) {
	int size = rows*cols ;
	this->rows = rows ;
	this->cols = cols ;
	this->matrix = new double[size] ;
	for ( int i=0 ; size>i ; i++ )
		this->matrix[i] = matrix[i] ;
}

#ifdef REALMATRIX_MAIN
// kernel
__global__ void realmatrix( double* buf ) {
	RealMatrix* mat ;
	double dat[] = {
		10, 12, 12, 14,
		21, 22, 23, 25,
		32, 32, 34, 36,
		43, 42, 45, 47
	}, vec[4], *res ;
	int i = threadIdx.x ;

	mat = new RealMatrix( dat, 4, 4 ) ;

	vec[0] = i+.12 ;
	vec[1] = i+1+.34 ;
	vec[2] = i+2+.56 ;
	vec[3] = i+3+.78 ;
	res = mat->operate( vec ) ;
	buf[4*i] = res[0] ;
	buf[4*i+1] = res[1] ;
	buf[4*i+2] = res[2] ;
	buf[4*i+3] = res[3] ;

	delete mat ;
	delete res ;
}

#define NUM_BLOCKS 1
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	// host buffer
	double buf[4*NUM_THREADS] ;
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
	checkCudaErrors( cudaMalloc( (void**) &dbuf, sizeof( double )*4*NUM_THREADS ) ) ;

	// run kernel
	realmatrix<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( double )*4*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.4f %.4f %.4f %.4f\n", buf[4*i], buf[4*i+1], buf[4*i+2], buf[4*i+3] ) ;

	return EXIT_SUCCESS ;
}
#endif // REALMATRIX_MAIN
