#ifndef __REALMATRIX_H__
#define __REALMATRIX_H__

class RealMatrix {

public:
	RealMatrix( double matrix[], int rows, int cols ) ;
	~RealMatrix() ;

	double* operate( double vector[] ) ;
	// CXXWRAP/ JUnit
	RealMatrix() ;

	void set( double matrix[], int rows, int cols ) ;
	void operate( /* arg(s) */ double vector[], /* return */ double retval[] ) ;

private:
	double* matrix ;
	int rows ;
	int cols ;
} ;
#endif // __REALMATRIX_H__
