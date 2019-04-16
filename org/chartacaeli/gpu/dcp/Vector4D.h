#ifndef __VECTOR4D_H__
#define __VECTOR4D_H__

class Vector4D {

public:
	double e0 ;
	double e1 ;
	double e2 ;
	double e3 ;

	__device__ Vector4D() ;
	__device__ Vector4D( const Vector4D& v ) ;
	__device__ Vector4D( double e0, double e1, double e2, double e3 ) ;

	__device__ void set( double e0, double e1, double e2, double e3 ) ;
	__device__ Vector4D& apply( const Vector4D& matcol0, const Vector4D& matcol1, const Vector4D& matcol2, const Vector4D& matcol3 ) ;
	__device__ Vector4D& apply(
			const double m00, const double m01, const double m02, const double m03,
			const double m10, const double m11, const double m12, const double m13,
			const double m20, const double m21, const double m22, const double m23,
			const double m30, const double m31, const double m32, const double m33 ) ;
} ;
#endif // __VECTOR4D_H__
