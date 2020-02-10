rem test compilation on Windows without CUDA capable device
cd %userprofile%\src\chartacaeli\org\chartacaeli\gpu
rem compile object file(s)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Coordinate.o -dc dcp\Coordinate.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math.o -dc dcp\Math.cu
%CUDA_HOME%\bin\nvcc -DP4STEREOGRAPHIC_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\P4Stereographic.o -dc dcp\P4Stereographic.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\P4Stereographic.exe dcp\P4Stereographic.o dcp\Coordinate.o dcp\Math.o
rem cleanup
del dcp\P4Stereographic.lib dcp\P4Stereographic.exp
