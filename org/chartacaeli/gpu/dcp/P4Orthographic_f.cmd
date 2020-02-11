rem test compilation on Windows without CUDA capable device

rem compile object file(s)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Coordinate_f.o -dc dcp\Coordinate_f.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math_f.o -dc dcp\Math_f.cu
%CUDA_HOME%\bin\nvcc -DP4Orthographic_f_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\P4Orthographic_f.o -dc dcp\P4Orthographic_f.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\P4Orthographic_f.exe dcp\P4Orthographic_f.o dcp\Coordinate_f.o dcp\Math_f.o
rem cleanup
del dcp\P4Orthographic_f.lib dcp\P4Orthographic_f.exp
