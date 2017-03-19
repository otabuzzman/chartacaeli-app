#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Vector4D.h"

__device__ Vector4D::Vector4D() : e0( 0 ), e1( 0 ), e2( 0 ), e3( 0 ) {
}

__device__ Vector4D::Vector4D( const Vector4D& v ) {
	set( v.e0, v.e1, v.e2, v.e3 ) ;
}

__device__ Vector4D::Vector4D( float e0, float e1, float e2, float e3 ) {
	set( e0, e1, e2, e3 ) ;
}

__device__ void Vector4D::set( float e0, float e1, float e2, float e3 ) {
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
			const float m00, const float m01, const float m02, const float m03,
			const float m10, const float m11, const float m12, const float m13,
			const float m20, const float m21, const float m22, const float m23,
			const float m30, const float m31, const float m32, const float m33 ) {
	float _e0 = e0, _e1 = e1, _e2 = e2, _e3 = e3 ;

	e0 = _e0*m00+_e1*m01+_e2*m02+_e3*m03 ;
	e1 = _e0*m10+_e1*m11+_e2*m12+_e3*m13 ;
	e2 = _e0*m20+_e1*m21+_e2*m22+_e3*m23 ;
	e3 = _e0*m30+_e1*m31+_e2*m32+_e3*m33 ;

	return *this ;
}
