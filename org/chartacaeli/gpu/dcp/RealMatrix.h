#ifndef __REALMATRIX_H__
#define __REALMATRIX_H__

class RealMatrix {

public:
	__device__ RealMatrix( double matrix[], int rows, int cols ) ;
	__device__ RealMatrix(
		const double rc00, const double rc01, const double rc02,
		const double rc10, const double rc11, const double rc12,
		const double rc20, const double rc21, const double rc22 ) ;
	__device__ RealMatrix(
		const double rc00, const double rc01, const double rc02, const double rc03,
		const double rc10, const double rc11, const double rc12, const double rc13,
		const double rc20, const double rc21, const double rc22, const double rc23,
		const double rc30, const double rc31, const double rc32, const double rc33 ) ;

	__device__ ~RealMatrix() ;

	__device__ void set( double matrix[], int rows, int cols ) ;
	__device__ double* operate( double vector[] ) ;

private:
	double* matrix ;
	int rows ;
	int cols ;
} ;
#endif // __REALMATRIX_H__
