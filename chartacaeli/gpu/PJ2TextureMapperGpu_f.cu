#include <new>

#include "dcp/P4Projector_f.h"
#include "dcp/P4Stereographic_f.h"
#include "dcp/P4Orthographic_f.h"
#include "dcp/P4Mollweide_f.h"
#include "dcp/Plane_f.h"
#include "dcp/Vector4D_f.h"
#include "dcp/Vector3D_f.h"
#include "dcp/Coordinate_f.h"

// CUDA kernel
extern "C" __global__ void run(
			const char* pnam, const float lam0, const float phi1, const float R, const float k0,
			const float m2p00, const float m2p01, const float m2p02,
			const float m2p10, const float m2p11, const float m2p12,
			const float m2p20, const float m2p21, const float m2p22,
			const float h2t00, const float h2t01, const float h2t02, const float h2t03,
			const float h2t10, const float h2t11, const float h2t12, const float h2t13,
			const float h2t20, const float h2t21, const float h2t22, const float h2t23,
			const float h2t30, const float h2t31, const float h2t32, const float h2t33,
			const float p1x, const float p1y, const float p1z,
			const float p2x, const float p2y, const float p2z,
			const float p3x, const float p3y, const float p3z,
			const int dimo, const int dimp, const int** texture,
			const int dims, const int dimt, int** mapping,
			const float ups ) {
	int t, s, p, o ;
	__shared__ unsigned char pool[256] ;
	__shared__ P4Projector* proj ;
	__shared__ Plane* spt ;
	Vector3D uv, l0, l1, ca ;
	Vector4D op ;

	t = blockIdx.y*blockDim.y+threadIdx.y ;
	s = blockIdx.x*blockDim.x+threadIdx.x ;

	if ( t>=dimt || s>=dims )
		return ;

	if ( threadIdx.y == 0 && threadIdx.x == 0 ) {
		switch ( *( pnam+2 ) ) {
			case 'S':
				proj = new( &pool[0] ) P4Stereographic() ;
				break ;
			case 'O':
				proj = new( &pool[0] ) P4Orthographic() ;
				break ;
			case 'M':
				proj = new( &pool[0] ) P4Mollweide() ;
				break ;
			default:
				asm( "trap ;" ) ;
		}

		spt = new( &pool[128] ) Plane( p1x, p1y, p1z, p2x, p2y, p2z, p3x, p3y, p3z ) ;
	}

	__syncthreads() ;

	// transform s/t to projection coordinates u/v
	uv.set( s*ups, t*ups, 1 ) ;
	uv.apply(
		m2p00, m2p01, m2p02,
		m2p10, m2p11, m2p12,
		m2p20, m2p21, m2p22 ) ;

	// transform u/v to spherical (equatorial) coordinates
	proj->init( lam0, phi1, R, k0 ) ;
	proj->inverse( uv, l1 ) ;

	// convert spherical to cartesian
	l1.cartesian() ;

	// find spatial intersection with texture
	spt->intersection( l0, l1, ca ) ;

	// transform to texture coordinates o/p
	op.set( ca.x, ca.y, ca.z, 1 ) ;
	op.apply(
		h2t00, h2t01, h2t02, h2t03,
		h2t10, h2t11, h2t12, h2t13,
		h2t20, h2t21, h2t22, h2t23,
		h2t30, h2t31, h2t32, h2t33 ) ;

	// map o/p if on texture
	p = (int) op.e1 ;
	o = (int) op.e0 ;
	if ( (unsigned int) p<dimp && (unsigned int) o<dimo )
		mapping[t][s] = texture[p][o] ;
}

#ifdef PJ2TEXTUREMAPPERGPU_MAIN
#include <cuda.h>

// from CUDA Toolkit samples
#include <helper_cuda.h>

int main( int argc, char** argv ) {
	cudaDeviceProp devProp ;
	int devID ;
	unsigned char buf[3] ;
	const char *h_pnam = "P4Stereographic" ;
	char *d_pnam ;
	float lam0, phi1, R, k0 ;
	float m2p00, m2p01, m2p02 ;
	float m2p10, m2p11, m2p12 ;
	float m2p20, m2p21, m2p22 ;
	float h2t00, h2t01, h2t02, h2t03 ;
	float h2t10, h2t11, h2t12, h2t13 ;
	float h2t20, h2t21, h2t22, h2t23 ;
	float h2t30, h2t31, h2t32, h2t33 ;
	float p1x, p1y, p1z ;
	float p2x, p2y, p2z ;
	float p3x, p3y, p3z ;
	int dimo, dimp, *texture, **h_texture, **d_texture ;
	int dims, dimt, *mapping, **h_mapping, **d_mapping ;
	float ups ;

	lam0 = 0.0f ; phi1 = 90.0f ; R = 118.8f ; k0 = 1.0f ;
	m2p00 = 0.5175793085449578f ;  m2p01 = 0.8556352373331308f ; m2p02 = -27.61474066215803f ;
	m2p10 = -0.8556352373331311f ; m2p11 = 0.5175793085449577f ; m2p12 = -100.85847174398357f ;
	m2p20 = 0.0f ;                 m2p21 = 0.0f ;                m2p22 = 1.0f ;
	h2t00 = -3402.8858901402996f ;    h2t01 = -1220.9974680683858f ;   h2t02 = -3419.719730243767f ;      h2t03 = 5148.3305361527955f ;
	h2t10 = -4519.169481016445f ;     h2t11 = -933.648235895421f ;     h2t12 = -2788.9911878218313f ;     h2t13 = 5525.831502438334f ;
	h2t20 = 19.06000692773117f ;      h2t21 = 7.920202046020817f ;     h2t22 = 13.632963600546473f ;      h2t23 = -24.275149004126146f ;
	h2t30 = -1.289164294604532E-14f ; h2t31 = -5.10584599744509E-15f ; h2t32 = -1.0503453106267556E-14f ; h2t33 = 1.000000000000018f ;
	p1x = 0.7360690204252228f ; p1y = 0.16255538665963573f ; p1z = 0.6570982753273586f ;
	p2x = 0.8458053524679503f ; p2y = 0.14657741169931554f ; p2z = 0.5129603962452617f ;
	p3x = 0.6338551355901809f ; p3y = 0.3804772484154413f ;  p3z = 0.6733978991088165f ;
	dimo = 512 ; dimp = 512 ;
	dims = 1360 ; dimt = 1517 ;
	ups = 0.06349999259166753f ;

	// find device and output compute capability on stderr
	devID = gpuGetMaxGflopsDeviceId() ;
	checkCudaErrors( cudaSetDevice( devID ) ) ;
	checkCudaErrors( cudaGetDeviceProperties( &devProp, devID ) ) ;
	fprintf( stderr, "%d%d\n", devProp.major, devProp.minor ) ;

	// allocate device memeory for projector name
	checkCudaErrors( cudaMalloc( (void**) &d_pnam, strlen( h_pnam )+1 ) ) ;
	checkCudaErrors( cudaMemcpy( d_pnam, h_pnam, strlen( h_pnam )+1, cudaMemcpyHostToDevice ) ) ;

	// allocate host memory for texture
	texture = (int*) malloc( dimo*dimp*sizeof( int ) ) ;
	// initialize texture with RGB data
	for ( int i=0 ; dimo*dimp>i ; i++ ) {
		fread( &buf[0], 1, 3, stdin ) ;
		if ( ferror( stdin ) || feof( stdin ) )
			break ;
		texture[i] = buf[0]<<16|buf[1]<<8|buf[2] ;
	}
	// allocate device memory pendant and copy texture from host (mind 'array of arrays' type)
	h_texture = (int**) malloc( dimp*sizeof( int* ) ) ;
	for ( int i=0 ; dimp>i ; i++ ) {
		checkCudaErrors( cudaMalloc( (void**) &h_texture[i], dimo*sizeof( int ) ) ) ;
		checkCudaErrors( cudaMemcpy( h_texture[i], &texture[i*dimo], dimo*sizeof( int ), cudaMemcpyHostToDevice ) ) ;
	}
	checkCudaErrors( cudaMalloc( (void**) &d_texture, dimp*sizeof( int* ) ) ) ;
	checkCudaErrors( cudaMemcpy( d_texture, h_texture, dimp*sizeof( int* ), cudaMemcpyHostToDevice ) ) ;

	// allocate host...
	mapping = (int*) malloc( dims*dimt*sizeof( int ) ) ;
	// ...and device memory for mapping (mind 'array of arrays' type)
	h_mapping = (int**) malloc( dimt*sizeof( int* ) ) ;
	for ( int i=0 ; dimt>i ; i++ )
		checkCudaErrors( cudaMalloc( (void**) &h_mapping[i], dims*sizeof( int ) ) ) ;
	checkCudaErrors( cudaMalloc( (void**) &d_mapping, dimt*sizeof( int* ) ) ) ;
	checkCudaErrors( cudaMemcpy( d_mapping, h_mapping, dimt*sizeof( int* ), cudaMemcpyHostToDevice ) ) ;

	// run kernel
	dim3 gdim( ( dims+32-1 )/32, ( dimt+32-1 )/32 ) ;
	dim3 bdim( 32, 32 ) ;
	run<<<gdim, bdim>>>(
			d_pnam, lam0, phi1, R, k0,
			m2p00, m2p01, m2p02,
			m2p10, m2p11, m2p12,
			m2p20, m2p21, m2p22,
			h2t00, h2t01, h2t02, h2t03,
			h2t10, h2t11, h2t12, h2t13,
			h2t20, h2t21, h2t22, h2t23,
			h2t30, h2t31, h2t32, h2t33,
			p1x, p1y, p1z,
			p2x, p2y, p2z,
			p3x, p3y, p3z,
			dimo, dimp, (const int**) d_texture,
			dims, dimt, d_mapping,
			ups ) ;

	// copy mapping from device back to host
	for ( int i=0 ; dimt>i ; i++ )
		checkCudaErrors( cudaMemcpy( &mapping[i*dims], h_mapping[i], dims*sizeof( int ), cudaMemcpyDeviceToHost ) ) ;
	// output mapping result RGB data
	for ( int i=0 ; dims*dimt>i ; i++ ) {
		buf[0] = mapping[i]>>16&255 ;
		buf[1] = mapping[i]>>8&255 ;
		buf[2] = mapping[i]&255 ;
		fwrite( &buf[0], 1, 3, stdout ) ;
	}

	for ( int i=0 ; dimt>i ; i++ )
		checkCudaErrors( cudaFree( h_mapping[i] ) ) ;
	checkCudaErrors( cudaFree( d_mapping ) ) ;
	free( h_mapping ) ;
	free( mapping ) ;

	for ( int i=0 ; dimp>i ; i++ )
		checkCudaErrors( cudaFree( h_texture[i] ) ) ;
	checkCudaErrors( cudaFree( d_texture ) ) ;
	free( h_texture ) ;
	free( texture ) ;

	checkCudaErrors( cudaFree( d_pnam ) ) ;

	return EXIT_SUCCESS ;
}
#endif // PJ2TEXTUREMAPPERGPU_MAIN



// runtime values from tf-0032
//	lam0 = 0.0f ;
//	phi1 = 90.0f ;
//	R = 118.8f ;
//	k0 = 1.0f ;
//	m2p00 = 0.5175793085449578f ;
//	m2p01 = 0.8556352373331308f ;
//	m2p02 = -27.61474066215803f ;
//	m2p10 = -0.8556352373331311f ;
//	m2p11 = 0.5175793085449577f ;
//	m2p12 = -100.85847174398357f ;
//	m2p20 = 0.0f ;
//	m2p21 = 0.0f ;
//	m2p22 = 1.0f ;
//	h2t00 = -3402.8858901402996f ;
//	h2t01 = -1220.9974680683858f ;
//	h2t02 = -3419.719730243767f ;
//	h2t03 = 5148.3305361527955f ;
//	h2t10 = -4519.169481016445f ;
//	h2t11 = -933.648235895421f ;
//	h2t12 = -2788.9911878218313f ;
//	h2t13 = 5525.831502438334f ;
//	h2t20 = 19.06000692773117f ;
//	h2t21 = 7.920202046020817f ;
//	h2t22 = 13.632963600546473f ;
//	h2t23 = -24.275149004126146f ;
//	h2t30 = -1.289164294604532E-14f ;
//	h2t31 = -5.10584599744509E-15f ;
//	h2t32 = -1.0503453106267556E-14f ;
//	h2t33 = 1.000000000000018f ;
//	p1x = 0.7360690204252228f ;
//	p1y = 0.16255538665963573f ;
//	p1z = 0.6570982753273586f ;
//	p2x = 0.8458053524679503f ;
//	p2y = 0.14657741169931554f ;
//	p2z = 0.5129603962452617f ;
//	p3x = 0.6338551355901809f ;
//	p3y = 0.3804772484154413f ;
//	p3z = 0.6733978991088165f ;
//	dimo = 512 ;
//	dimp = 512 ;
//	dims = 1360 ;
//	dimt = 1517 ;
//	ups = 0.06349999259166753f ;
