rem test compilation on Windows without CUDA capable device
cd %userprofile%\src\chartacaeli\org\chartacaeli\gpu
rem compile object file(s)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Coordinate.o -dc dcp\Coordinate.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math.o -dc dcp\Math.cu
%CUDA_HOME%\bin\nvcc -DP4MOLLWEIDE_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\P4Mollweide.o -dc dcp\P4Mollweide.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\P4Mollweide.exe dcp\P4Mollweide.o dcp\Math.o dcp\Coordinate.o
rem cleanup
del dcp\P4Mollweide.lib dcp\P4Mollweide.exp
