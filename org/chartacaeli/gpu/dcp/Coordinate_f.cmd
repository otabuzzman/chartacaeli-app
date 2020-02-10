rem test compilation on Windows without CUDA capable device
cd %userprofile%\src\chartacaeli\org\chartacaeli\gpu
rem compile object file(s)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math_f.o -dc dcp\Math_f.cu
%CUDA_HOME%\bin\nvcc -DCoordinate_f_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Coordinate_f.o -dc dcp\Coordinate_f.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\Coordinate_f.exe dcp\Coordinate_f.o dcp\Math_f.o
rem cleanup
del dcp\Coordinate_f.lib dcp\Coordinate_f.exp
