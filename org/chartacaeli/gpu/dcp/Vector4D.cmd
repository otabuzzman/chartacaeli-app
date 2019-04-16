rem test compilation on Windows without CUDA capable device
set CUDA_HOME=%userprofile%\lab\cudacons\cuda_8.0.44_windows\compiler
cd %userprofile%\src\chartacaeli\org\chartacaeli\gpu
rem compile object file(s)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Vector4D.o -dc dcp\Vector4D.cu
rem cleanup
del dcp\Vector4D.lib dcp\Vector4D.exp
