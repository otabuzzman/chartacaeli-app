rem test compilation on Windows without CUDA capable device

rem compile object file(s)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math.o -dc dcp\Math.cu
%CUDA_HOME%\bin\nvcc -DCOORDINATE_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Coordinate.o -dc dcp\Coordinate.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\Coordinate.exe dcp\Coordinate.o dcp\Math.o
rem cleanup
del dcp\Coordinate.lib dcp\Coordinate.exp
