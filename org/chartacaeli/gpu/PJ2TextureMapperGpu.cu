#include <new>

#include "dcp/P4Projector.h"
#include "dcp/P4Stereographic.h"
#include "dcp/P4Orthographic.h"
#include "dcp/P4Mollweide.h"
#include "dcp/Plane.h"
#include "dcp/Vector4D.h"
#include "dcp/Vector3D.h"
#include "dcp/Coordinate.h"

// CUDA kernel
extern "C" __global__ void run(
			const char* pnam, const double lam0, const double phi1, const double R, const double k0,
			const double m2p00, const double m2p01, const double m2p02,
			const double m2p10, const double m2p11, const double m2p12,
			const double m2p20, const double m2p21, const double m2p22,
			const double h2t00, const double h2t01, const double h2t02, const double h2t03,
			const double h2t10, const double h2t11, const double h2t12, const double h2t13,
			const double h2t20, const double h2t21, const double h2t22, const double h2t23,
			const double h2t30, const double h2t31, const double h2t32, const double h2t33,
			const double p1x, const double p1y, const double p1z,
			const double p2x, const double p2y, const double p2z,
			const double p3x, const double p3y, const double p3z,
			const int dimo, const int dimp, const int** texture,
			const int dims, const int dimt, int** mapping,
			const double ups ) {
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
	double lam0, phi1, R, k0 ;
	double m2p00, m2p01, m2p02 ;
	double m2p10, m2p11, m2p12 ;
	double m2p20, m2p21, m2p22 ;
	double h2t00, h2t01, h2t02, h2t03 ;
	double h2t10, h2t11, h2t12, h2t13 ;
	double h2t20, h2t21, h2t22, h2t23 ;
	double h2t30, h2t31, h2t32, h2t33 ;
	double p1x, p1y, p1z ;
	double p2x, p2y, p2z ;
	double p3x, p3y, p3z ;
	int dimo, dimp, *texture, **h_texture, **d_texture ;
	int dims, dimt, *mapping, **h_mapping, **d_mapping ;
	double ups ;

	lam0 = 0.0 ; phi1 = 90.0 ; R = 118.8 ; k0 = 1.0 ;
	m2p00 = 0.5175793085449578 ;  m2p01 = 0.8556352373331308 ; m2p02 = -27.61474066215803 ;
	m2p10 = -0.8556352373331311 ; m2p11 = 0.5175793085449577 ; m2p12 = -100.85847174398357 ;
	m2p20 = 0.0 ;                 m2p21 = 0.0 ;                m2p22 = 1.0 ;
	h2t00 = -3402.8858901402996 ;    h2t01 = -1220.9974680683858 ;   h2t02 = -3419.719730243767 ;      h2t03 = 5148.3305361527955 ;
	h2t10 = -4519.169481016445 ;     h2t11 = -933.648235895421 ;     h2t12 = -2788.9911878218313 ;     h2t13 = 5525.831502438334 ;
	h2t20 = 19.06000692773117 ;      h2t21 = 7.920202046020817 ;     h2t22 = 13.632963600546473 ;      h2t23 = -24.275149004126146 ;
	h2t30 = -1.289164294604532E-14 ; h2t31 = -5.10584599744509E-15 ; h2t32 = -1.0503453106267556E-14 ; h2t33 = 1.000000000000018 ;
	p1x = 0.7360690204252228 ; p1y = 0.16255538665963573 ; p1z = 0.6570982753273586 ;
	p2x = 0.8458053524679503 ; p2y = 0.14657741169931554 ; p2z = 0.5129603962452617 ;
	p3x = 0.6338551355901809 ; p3y = 0.3804772484154413 ;  p3z = 0.6733978991088165 ;
	dimo = 512 ; dimp = 512 ;
	dims = 1360 ; dimt = 1517 ;
	ups = 0.06349999259166753 ;

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
//	lam0 = 0.0 ;
//	phi1 = 90.0 ;
//	R = 118.8 ;
//	k0 = 1.0 ;
//	m2p00 = 0.5175793085449578 ;
//	m2p01 = 0.8556352373331308 ;
//	m2p02 = -27.61474066215803 ;
//	m2p10 = -0.8556352373331311 ;
//	m2p11 = 0.5175793085449577 ;
//	m2p12 = -100.85847174398357 ;
//	m2p20 = 0.0 ;
//	m2p21 = 0.0 ;
//	m2p22 = 1.0 ;
//	h2t00 = -3402.8858901402996 ;
//	h2t01 = -1220.9974680683858 ;
//	h2t02 = -3419.719730243767 ;
//	h2t03 = 5148.3305361527955 ;
//	h2t10 = -4519.169481016445 ;
//	h2t11 = -933.648235895421 ;
//	h2t12 = -2788.9911878218313 ;
//	h2t13 = 5525.831502438334 ;
//	h2t20 = 19.06000692773117 ;
//	h2t21 = 7.920202046020817 ;
//	h2t22 = 13.632963600546473 ;
//	h2t23 = -24.275149004126146 ;
//	h2t30 = -1.289164294604532E-14 ;
//	h2t31 = -5.10584599744509E-15 ;
//	h2t32 = -1.0503453106267556E-14 ;
//	h2t33 = 1.000000000000018 ;
//	p1x = 0.7360690204252228 ;
//	p1y = 0.16255538665963573 ;
//	p1z = 0.6570982753273586 ;
//	p2x = 0.8458053524679503 ;
//	p2y = 0.14657741169931554 ;
//	p2z = 0.5129603962452617 ;
//	p3x = 0.6338551355901809 ;
//	p3y = 0.3804772484154413 ;
//	p3z = 0.6733978991088165 ;
//	dimo = 512 ;
//	dimp = 512 ;
//	dims = 1360 ;
//	dimt = 1517 ;
//	ups = 0.06349999259166753 ;
