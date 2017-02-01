#include <cstdio>
#include <cstdlib>
#include <algorithm>

#include "RealMatrix.h"
using namespace std;

RealMatrix::RealMatrix( double matrix[], int rows, int cols ) {
	set( matrix, rows, cols ) ;
}

RealMatrix::RealMatrix() {}

RealMatrix::~RealMatrix() {
	delete matrix ;
}

double* RealMatrix::operate( double vector[] ) {
	double sum, *retval = new double[rows] ;

	for ( int r=0 ; rows>r ; r++ ) {
		sum = 0 ;
		for ( int c=0 ; cols>c ; c++ )
			sum += matrix[rows*r+c]*vector[c] ;
		retval[r] = sum ;
	}

	return retval ;
}

void RealMatrix::set( double matrix[], int rows, int cols ) {
	int size = rows*cols ;
	this->rows = rows ;
	this->cols = cols ;
	this->matrix = new double[size] ;
	copy( &matrix[0], &matrix[0]+size, this->matrix ) ;
}

// CXXWRAP/ JUnit
void RealMatrix::operate( /* arg(s) */ double vector[], /* return */ double retval[] ) {
	double* t0 = operate( vector ) ;
	
	for ( int r=0 ; rows>r ; r++ )
		retval[r] = t0[r] ;

	delete t0 ;
}

#ifdef REALMATRIX_MAIN
// pseudo-kernel (ridiculous)
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	RealMatrix* mat ;
	double dat[] = {
		10, 12, 12, 14,
		21, 22, 23, 25,
		32, 32, 34, 36,
		43, 42, 45, 47
	}, vec[4], *res ;
	double* buf ;

	mat = new RealMatrix( dat, 4, 4 ) ;
	buf = new double[4*NUM_THREADS] ;

	for ( int i=0 ; NUM_THREADS>i ; i++ ) {
		vec[0] = i+.12 ;
		vec[1] = i+1+.34 ;
		vec[2] = i+2+.56 ;
		vec[3] = i+3+.78 ;
		res = mat->operate( vec ) ;
		buf[4*i] = res[0] ;
		buf[4*i+1] = res[1] ;
		buf[4*i+2] = res[2] ;
		buf[4*i+3] = res[3] ;
		delete res ;
	}

	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.4f %.4f %.4f %.4f\n", buf[4*i], buf[4*i+1], buf[4*i+2], buf[4*i+3] ) ;

	delete buf ;
	delete mat ;

	return EXIT_SUCCESS ;
}
#endif // REALMATRIX_MAIN
