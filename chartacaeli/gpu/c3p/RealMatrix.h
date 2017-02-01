#ifndef __REALMATRIX_H__
#define __REALMATRIX_H__

class RealMatrix {

public:
	RealMatrix( double matrix[], int rows, int cols ) ;
	RealMatrix() ;

	~RealMatrix() ;

	double* operate( double vector[] ) ;
	void set( double matrix[], int rows, int cols ) ;

	// CXXWRAP/ JUnit
	void operate( /* arg(s) */ double vector[], /* return */ double retval[] ) ;

private:
	double* matrix ;
	int rows ;
	int cols ;
} ;
#endif // __REALMATRIX_H__
