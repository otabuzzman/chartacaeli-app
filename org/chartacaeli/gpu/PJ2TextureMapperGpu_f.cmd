rem test compilation on Windows without CUDA capable device
cd %userprofile%\src\chartacaeli\org\chartacaeli\gpu
rem compile object files
for %%n in ( dcp\P4Stereographic_f dcp\P4Orthographic_f dcp\P4Mollweide_f dcp\Math dcp\Coordinate_f dcp\Vector3D_f dcp\Vector4D_f dcp\Plane_f PJ2TextureMapperGpu_f ) do (
	if not exist %%n.o (
		%CUDA_HOME%\bin\nvcc -DPJ2TEXTUREMAPPERGPU_MAIN -Wno-deprecated-gpu-targets -I%CUDA_HOME%\..\CUDASamples\common\inc -o %%n.o -dc %%n.cu ) )
rem link cubin file (https://devtalk.nvidia.com/default/topic/914699/create-single-ptx-or-cubin-file-from-multiple-cu-sources/)
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets --resource-usage -cubin -dlink -arch=sm_30 -o PJ2TextureMapperGpu_f.cubin PJ2TextureMapperGpu_f.o dcp\Plane_f.o dcp\Vector4D_f.o dcp\Vector3D_f.o dcp\Coordinate_f.o dcp\Math_f.o dcp\P4Mollweide_f.o dcp\P4Orthographic_f.o dcp\P4Stereographic_f.o
rem link executable file
%CUDA_HOME%\bin\nvcc -Wno-deprecated-gpu-targets --resource-usage -arch=sm_30 -o PJ2TextureMapperGpu_f.exe PJ2TextureMapperGpu_f.o dcp\Plane_f.o dcp\Vector4D_f.o dcp\Vector3D_f.o dcp\Coordinate_f.o dcp\Math_f.o dcp\P4Mollweide_f.o dcp\P4Orthographic_f.o dcp\P4Stereographic_f.o
rem cleanup
del PJ2TextureMapperGpu_f.lib PJ2TextureMapperGpu_f.exp
