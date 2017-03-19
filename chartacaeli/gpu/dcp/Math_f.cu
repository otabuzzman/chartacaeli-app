#include <cstdio>
#include <cstdlib>

#include <cuda_runtime.h>

// from CUDA Toolkit samples
#include <helper_cuda.h>

// names inspired by Cg Toolkit Standard Library
__device__ float degrees( float a ) {
	return a*57.295779513082320876798154814105f ;
}
__device__ float radians( float a ) {
	return a*0.017453292519943295769236907685f ;
}
