rem test compilation on Windows without CUDA capable device
set CUDA_HOME=%userprofile%\lab\cudacons\cuda_8.0.44_windows\compiler
cd %userprofile%\src\chartacaeli\chartacaeli\gpu
rem compile object files
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o PJ2TextureMapperGpu.o -dc PJ2TextureMapperGpu.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math.o -dc dcp\Math.cu
rem ...
rem link executable file (https://devtalk.nvidia.com/default/topic/914699/create-single-ptx-or-cubin-file-from-multiple-cu-sources/)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -cubin -dlink -arch=sm_30 PJ2TextureMapperGpu.o dcp\Math.o -o PJ2TextureMapperGpu.cubin
