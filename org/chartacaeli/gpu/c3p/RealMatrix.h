#ifndef __REALMATRIX_H__
#define __REALMATRIX_H__

class RealMatrix {

public:
	RealMatrix( double matrix[], int rows, int cols ) ;

	~RealMatrix() ;

	void set( double matrix[], int rows, int cols ) ;
	double* operate( double vector[] ) ;

	// CXXWRAP/ JUnit
	void operate( /* arg(s) */ double vector[], /* return */ double retval[] ) ;

private:
	double* matrix ;
	int rows ;
	int cols ;
} ;
#endif // __REALMATRIX_H__
