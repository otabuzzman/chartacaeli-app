rem test compilation on Windows without CUDA capable device

rem compile object file(s)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math.o -dc dcp\Math.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Coordinate.o -dc dcp\Coordinate.cu
%CUDA_HOME%\bin\nvcc -DVECTOR3D_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Vector3D.o -dc dcp\Vector3D.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\Vector3D.exe dcp\Vector3D.o dcp\Coordinate.o dcp\Math.o
rem cleanup
del dcp\Vector3D.lib dcp\Vector3D.exp
