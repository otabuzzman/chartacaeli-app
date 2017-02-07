rem test compilation on Windows without CUDA capable device
set CUDA_HOME=%userprofile%\lab\cudacons\cuda_8.0.44_windows\compiler
cd %userprofile%\src\chartacaeli\chartacaeli\gpu
rem compile object files
for %%n in ( dcp\P4Stereographic dcp\P4Orthographic dcp\P4Mollweide dcp\Coordinate dcp\RealMatrix dcp\Vector3D dcp\Plane dcp\Math PJ2TextureMapperGpu ) do (
	if not exist %%n.o (
		%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o %%n.o -dc %%n.cu ) )
rem link executable file (https://devtalk.nvidia.com/default/topic/914699/create-single-ptx-or-cubin-file-from-multiple-cu-sources/)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets --resource-usage -cubin -dlink -arch=sm_30 -o PJ2TextureMapperGpu.cubin PJ2TextureMapperGpu.o dcp\P4Stereographic.o dcp\P4Orthographic.o dcp\P4Mollweide.o dcp\Coordinate.o dcp\RealMatrix.o dcp\Vector3D.o dcp\Plane.o dcp\Math.o
