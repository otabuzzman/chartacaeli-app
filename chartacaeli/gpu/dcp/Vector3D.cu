#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

#include "Vector3D.h"

// from CUDA Toolkit samples
#include <helper_cuda.h>

__device__ Vector3D::Vector3D() : Coordinate( 0, 0, 0 ) {
}

__device__ Vector3D::Vector3D( const Vector3D& v ) : Coordinate( v.x, v.y, v.z ) {
}

__device__ Vector3D::Vector3D( double x, double y, double z ) : Coordinate( x, y, z ) {
}

__device__ Vector3D& Vector3D::add( const Vector3D& v ) {
	x += v.x ;
	y += v.y ;
	z += v.z ;

	return *this ;
}

__device__ Vector3D& Vector3D::sub( const Vector3D& v ) {
	x -= v.x ;
	y -= v.y ;
	z -= v.z ;

	return *this ;
}

__device__ Vector3D& Vector3D::mul( double a ) {
	x *= a ;
	y *= a ;
	z *= a ;

	return *this ;
}

__device__ double Vector3D::dot( const Vector3D& v ) {
	return x*v.x+y*v.y+z*v.z ;
}

__device__ Vector3D& Vector3D::cross( const Vector3D& v ) {
	double x, y, z ;

	x = this->x ;
	y = this->y ;
	z = this->z ;

	this->x = y*v.z-z*v.y ;
	this->y = z*v.x-x*v.z ;
	this->z = x*v.y-y*v.x ;

	return *this ;
}

__device__ Vector3D& Vector3D::apply( const Vector3D& matcol0, const Vector3D& matcol1, const Vector3D& matcol2 ) {
	return apply(
			matcol0.x, matcol1.x, matcol2.x,
			matcol0.y, matcol1.y, matcol2.y,
			matcol0.z, matcol1.z, matcol2.z ) ;
}

__device__ Vector3D& Vector3D::apply(
			const double m00, const double m01, const double m02,
			const double m10, const double m11, const double m12,
			const double m20, const double m21, const double m22 ) {
	double _x = x, _y = y, _z = z ;

	x = _x*m00+_y*m01+_z*m02 ;
	y = _x*m10+_y*m11+_z*m12 ;
	z = _x*m20+_y*m21+_z*m22 ;

	return *this ;
}

#ifdef VECTOR3D_MAIN
// kernel
__global__ void vector3d( double* buf ) {
	Vector3D a, b ;
	int i = threadIdx.x ;

	a.set( i, i+.123, i+.234 ) ;
	b.set( i+.234, i+.123, i ) ;
	buf[i] = a.cross( b ).dot( a ) ;
}

#define NUM_BLOCKS 1
#define NUM_THREADS 360

int main( int argc, char** argv ) {
	// host buffer
	double buf[NUM_THREADS] ;
	// device buffer
	double* dbuf = NULL ;
	cudaDeviceProp devProp ;
	int devID ;

	// find device and output compute capability on stderr
	devID = gpuGetMaxGflopsDeviceId() ;
	checkCudaErrors( cudaSetDevice( devID ) ) ;
	checkCudaErrors( cudaGetDeviceProperties( &devProp, devID ) ) ;
	fprintf( stderr, "%d%d\n", devProp.major, devProp.minor ) ;

	// allocate device buffer memory
	checkCudaErrors( cudaMalloc( (void**) &dbuf, sizeof( double )*NUM_THREADS ) ) ;

	// run kernel
	vector3d<<<NUM_BLOCKS, NUM_THREADS>>>( dbuf ) ;

	// copy kernel results from device buffer to host
	checkCudaErrors( cudaMemcpy( buf, dbuf, sizeof( double )*NUM_THREADS, cudaMemcpyDeviceToHost ) ) ;
	checkCudaErrors( cudaFree( dbuf ) ) ;

	// output result on stdout
	for ( int i=0 ; NUM_THREADS>i ; i++ )
		printf( "%.6f\n", buf[i] ) ;

	return EXIT_SUCCESS ;
}
#endif // VECTOR3D_MAIN
