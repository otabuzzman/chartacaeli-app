rem test compilation on Windows without CUDA capable device
cd %userprofile%\src\chartacaeli\org\chartacaeli\gpu
rem compile object file(s)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Vector4D_f.o -dc dcp\Vector4D_f.cu
rem cleanup
del dcp\Vector4D_f.lib dcp\Vector4D_f.exp
