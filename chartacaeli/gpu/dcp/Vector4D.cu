#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Vector4D.h"

__device__ Vector4D::Vector4D() : e0( 0 ), e1( 0 ), e2( 0 ), e3( 0 ) {
}

__device__ Vector4D::Vector4D( const Vector4D& v ) {
	set( v.e0, v.e1, v.e2, v.e3 ) ;
}

__device__ Vector4D::Vector4D( double e0, double e1, double e2, double e3 ) {
	set( e0, e1, e2, e3 ) ;
}

__device__ void Vector4D::set( double e0, double e1, double e2, double e3 ) {
	this->e0 = e0 ;
	this->e1 = e1 ;
	this->e2 = e2 ;
	this->e3 = e3 ;
}

__device__ Vector4D& Vector4D::apply( const Vector4D& matcol0, const Vector4D& matcol1, const Vector4D& matcol2, const Vector4D& matcol3 ) {
	return apply(
			matcol0.e0, matcol1.e0, matcol2.e0, matcol3.e0,
			matcol0.e1, matcol1.e1, matcol2.e1, matcol3.e1,
			matcol0.e2, matcol1.e2, matcol2.e2, matcol3.e2,
			matcol0.e3, matcol1.e3, matcol2.e3, matcol3.e3 ) ;
}

__device__ Vector4D& Vector4D::apply(
			const double m00, const double m01, const double m02, const double m03,
			const double m10, const double m11, const double m12, const double m13,
			const double m20, const double m21, const double m22, const double m23,
			const double m30, const double m31, const double m32, const double m33 ) {
	e0 = e0*m00+e0*m01+e0*m02+e0*m03 ;
	e1 = e1*m10+e1*m11+e1*m12+e1*m13 ;
	e2 = e2*m20+e2*m21+e2*m22+e2*m23 ;
	e3 = e3*m30+e3*m31+e3*m32+e3*m33 ;

	return *this ;
}
