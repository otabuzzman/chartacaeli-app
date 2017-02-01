rem test compilation on Windows without CUDA capable device
set CUDA_HOME=%userprofile%\lab\cudacons\cuda_8.0.44_windows\compiler
cd %userprofile%\src\chartacaeli\chartacaeli\gpu
rem compile object files
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Coordinate.o -dc dcp\Coordinate.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math.o -dc dcp\Math.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\P4Mollweide.o -dc dcp\P4Mollweide.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\P4Orthographic.o -dc dcp\P4Orthographic.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\P4Stereographic.o -dc dcp\P4Stereographic.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o PJ2TextureMapperGpu.o -dc PJ2TextureMapperGpu.cu
rem link executable file (https://devtalk.nvidia.com/default/topic/914699/create-single-ptx-or-cubin-file-from-multiple-cu-sources/)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -cubin -dlink -arch=sm_30 PJ2TextureMapperGpu.o dcp\Coordinate.o dcp\Math.o dcp\P4Mollweide.o dcp\P4Orthographic.o dcp\P4Stereographic.o -o PJ2TextureMapperGpu.cubin
