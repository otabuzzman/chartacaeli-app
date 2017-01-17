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

// devive kernel
extern "C" __global__ void run(
	const char* pnam,
	const double** tmM2P,
	const double** tmH2T,
	const double** spT,
	const int** texture,
	const int** mapping ) {
}
