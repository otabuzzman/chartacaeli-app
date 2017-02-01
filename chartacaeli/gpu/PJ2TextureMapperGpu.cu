#include <cstdlib>

#include "dcp/P4Projector.h"
#include "dcp/P4Stereographic.h"
#include "dcp/P4Orthographic.h"
#include "dcp/P4Mollweide.h"

__device__ P4Projector* createP4Projector( const char *pnam ) {
	P4Projector* proj ;

	switch ( *( pnam+2 ) ) {
		case 'S':
			return new P4Stereographic() ;
		case 'O':
			return new P4Orthographic() ;
		case 'M':
			return new P4Mollweide() ;
		default:
			break ;
	}

	return NULL ;
}

// projector params in global memory
__device__ double lim0 ;
__device__ double phi1 ;
__device__ double R ;
__device__ double k0 ;

// texture params (dimo, dimp) in global memory
__device__ double dimo ;
__device__ double dimp ;

// mapping params (dims, dimt) in global memory
__device__ double dims ;
__device__ double dimt ;

// general params in global memory
__device__ double ups ;

// CUDA kernel
extern "C" __global__ void run(
	const char* pnam,
	const double** tmM2P,
	const double** tmH2T,
	const double** spT,
	const int** texture,
	const int** mapping ) {
}

int main( int argc, char** argv ) {
	return EXIT_SUCCESS ;
}
