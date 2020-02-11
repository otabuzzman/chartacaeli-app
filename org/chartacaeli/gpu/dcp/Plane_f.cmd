rem test compilation on Windows without CUDA capable device

rem compile object file(s)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Math_f.o -dc dcp\Math_f.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Coordinate_f.o -dc dcp\Coordinate_f.cu
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Vector3D_f.o -dc dcp\Vector3D_f.cu
%CUDA_HOME%\bin\nvcc -DPLANE_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o dcp\Plane_f.o -dc dcp\Plane_f.cu
rem compile executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -o dcp\Plane.exe dcp\Plane_f.o dcp\Vector3D_f.o dcp\Coordinate_f.o dcp\Math_f.o
rem cleanup
del dcp\Plane.lib dcp\Plane.exp
