rem test compilation on Windows without CUDA capable device

rem compile object file(s)
%CUDA_HOME%\bin\nvcc -DREALMATRIX_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\RealMatrix_f.o -dc dcp\RealMatrix_f.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\RealMatrix.exe dcp\RealMatrix_f.o
rem cleanup
del dcp\RealMatrix_f.lib dcp\RealMatrix_f.exp
