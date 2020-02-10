rem test compilation on Windows without CUDA capable device
cd %userprofile%\src\chartacaeli\org\chartacaeli\gpu
rem compile object file(s)
%CUDA_HOME%\bin\nvcc -DREALMATRIX_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\RealMatrix.o -dc dcp\RealMatrix.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\RealMatrix.exe dcp\RealMatrix.o
rem cleanup
del dcp\RealMatrix.lib dcp\RealMatrix.exp
