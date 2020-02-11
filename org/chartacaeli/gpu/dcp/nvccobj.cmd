@echo off
rem compile CUDA source files to objects
rem assume NVCC option if file doesn't exist
setlocal enabledelayedexpansion
set fil=
set opt=
for %%x in ( %* ) do (
	if exist %%x ( set fil=!fil! %%x ) ^
	else ( set opt=!opt! %%x )
)
for %%x in ( %fil% ) do (
	set src=%%x
	%CUDA_HOME%\bin\nvcc %opt% -Wno-deprecated-gpu-targets -o !src:.cu=.o! -dc !src!
)
