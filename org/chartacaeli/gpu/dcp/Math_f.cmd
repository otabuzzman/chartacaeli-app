rem test compilation on Windows without CUDA capable device

rem compile object file(s)
%CUDA_HOME%\bin\nvcc -DMath_f_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math_f.o -dc dcp\Math_f.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\Math_f.exe dcp\Math_f.o
rem cleanup
del dcp\Math_f.lib dcp\Math_f.exp
