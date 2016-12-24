#include <algorithm>

#include "RealMatrix.h"
using namespace std;

RealMatrix::RealMatrix( double matrix[], int rows, int cols ) {
	set( matrix, rows, cols ) ;
}

double* RealMatrix::operate( double vector[] ) {
	double sum, *retval = new double[rows*cols] ;

	for ( int r=0 ; rows>r ; r++ ) {
		sum = 0 ;
		for ( int c=0 ; cols>c ; c++ )
			sum += matrix[rows*r+c]*vector[c] ;
		retval[r] = sum ;
	}

	return retval ;
}

// CXXWRAP/ JUnit
RealMatrix::RealMatrix() {}

void RealMatrix::set( double matrix[], int rows, int cols ) {
	int size = rows*cols ;
	this->rows = rows ;
	this->cols = cols ;
	this->matrix = new double[size] ;
	copy( &matrix[0], &matrix[0]+size, this->matrix ) ;
}

void RealMatrix::operate( /* arg(s) */ double vector[], /* return */ double retval[] ) {
	double* t0 = operate( vector ) ;
	
	for ( int r=0 ; rows>r ; r++ )
		retval[r] = t0[r] ;
}
