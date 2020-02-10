rem test compilation on Windows without CUDA capable device
cd %userprofile%\src\chartacaeli\org\chartacaeli\gpu
rem compile object file(s)
%CUDA_HOME%\bin\nvcc -DMATH_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math.o -dc dcp\Math.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\Math.exe dcp\Math.o
rem cleanup
del dcp\Math.lib dcp\Math.exp
