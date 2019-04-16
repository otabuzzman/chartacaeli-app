#ifndef __VECTOR4D_H__
#define __VECTOR4D_H__

class Vector4D {

public:
	float e0 ;
	float e1 ;
	float e2 ;
	float e3 ;

	__device__ Vector4D() ;
	__device__ Vector4D( const Vector4D& v ) ;
	__device__ Vector4D( float e0, float e1, float e2, float e3 ) ;

	__device__ void set( float e0, float e1, float e2, float e3 ) ;
	__device__ Vector4D& apply( const Vector4D& matcol0, const Vector4D& matcol1, const Vector4D& matcol2, const Vector4D& matcol3 ) ;
	__device__ Vector4D& apply(
			const float m00, const float m01, const float m02, const float m03,
			const float m10, const float m11, const float m12, const float m13,
			const float m20, const float m21, const float m22, const float m23,
			const float m30, const float m31, const float m32, const float m33 ) ;
} ;
#endif // __VECTOR4D_H__
