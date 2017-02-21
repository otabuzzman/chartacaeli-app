#ifndef __REALMATRIX_H__
#define __REALMATRIX_H__

class RealMatrix {

public:
	__device__ RealMatrix( double matrix[], int rows, int cols ) ;

	__device__ ~RealMatrix() ;

	__device__ void set( double matrix[], int rows, int cols ) ;
	__device__ double* operate( double vector[] ) ;

private:
	double* matrix ;
	int rows ;
	int cols ;
} ;
#endif // __REALMATRIX_H__
