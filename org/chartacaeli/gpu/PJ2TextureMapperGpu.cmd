rem test compilation on Windows without CUDA capable device
set CUDA_HOME=%userprofile%\lab\cudacons\cuda_8.0.44_windows\compiler
cd %userprofile%\src\chartacaeli\org\chartacaeli\gpu
rem compile object files
for %%n in ( dcp\P4Stereographic dcp\P4Orthographic dcp\P4Mollweide dcp\Math dcp\Coordinate dcp\Vector3D dcp\Vector4D dcp\Plane PJ2TextureMapperGpu ) do (
	if not exist %%n.o (
		%CUDA_HOME%\bin\nvcc -DPJ2TEXTUREMAPPERGPU_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o %%n.o -dc %%n.cu ) )
rem link cubin file (https://devtalk.nvidia.com/default/topic/914699/create-single-ptx-or-cubin-file-from-multiple-cu-sources/)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets --resource-usage -cubin -dlink -arch=sm_30 -o PJ2TextureMapperGpu.cubin PJ2TextureMapperGpu.o dcp\Plane.o dcp\Vector4D.o dcp\Vector3D.o dcp\Coordinate.o dcp\Math.o dcp\P4Mollweide.o dcp\P4Orthographic.o dcp\P4Stereographic.o
rem link executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets --resource-usage -arch=sm_30 -o PJ2TextureMapperGpu.exe PJ2TextureMapperGpu.o dcp\Plane.o dcp\Vector4D.o dcp\Vector3D.o dcp\Coordinate.o dcp\Math.o dcp\P4Mollweide.o dcp\P4Orthographic.o dcp\P4Stereographic.o
rem cleanup
del PJ2TextureMapperGpu.lib PJ2TextureMapperGpu.exp
