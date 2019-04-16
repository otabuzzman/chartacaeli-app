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

__device__ RealMatrix::RealMatrix(
						const double rc00, const double rc01, const double rc02,
						const double rc10, const double rc11, const double rc12,
						const double rc20, const double rc21, const double rc22 ) {
	this->rows = 3 ;
	this->cols = 3 ;
	this->matrix = new double[9] {
			rc00, rc01, rc02,
			rc10, rc11, rc12,
			rc20, rc21, rc22 } ;
}

__device__ RealMatrix::RealMatrix(
						const double rc00, const double rc01, const double rc02, const double rc03,
						const double rc10, const double rc11, const double rc12, const double rc13,
						const double rc20, const double rc21, const double rc22, const double rc23,
						const double rc30, const double rc31, const double rc32, const double rc33 ) {
	this->rows = 4 ;
	this->cols = 4 ;
	this->matrix = new double[16] {
			rc00, rc01, rc02, rc03,
			rc10, rc11, rc12, rc13,
			rc20, rc21, rc22, rc23,
			rc30, rc31, rc32, rc33 } ;
}

__device__ RealMatrix::~RealMatrix() {
	delete[] matrix ;
}

__device__ void RealMatrix::set( double matrix[], int rows, int cols ) {
	int size = rows*cols ;

	this->rows = rows ;
	this->cols = cols ;
	this->matrix = new double[size] ;

	for ( int i=0 ; size>i ; i++ )
		this->matrix[i] = matrix[i] ;
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

#ifdef REALMATRIX_MAIN
// kernel
__global__ void realmatrix( double* buf ) {
	double dat[] = {
		10, 12, 12, 14,
		21, 22, 23, 25,
		32, 32, 34, 36,
		43, 42, 45, 47
	}, vec[4], *res ;
	RealMatrix mat( dat, 4, 4 ) ;
	int i = threadIdx.x ;

	vec[0] = i+.12 ;
	vec[1] = i+1+.34 ;
	vec[2] = i+2+.56 ;
	vec[3] = i+3+.78 ;
	res = mat.operate( vec ) ;
	buf[4*i] = res[0] ;
	buf[4*i+1] = res[1] ;
	buf[4*i+2] = res[2] ;
	buf[4*i+3] = res[3] ;

	delete[] res ;
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
