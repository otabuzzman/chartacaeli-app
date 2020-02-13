@echo off
rem Charta Caeli launch utility.
rem

set PATH=%ProgramFiles%\Cygwin\usr\x86_64-w64-mingw32\sys-root\mingw\bin;%PATH%

rem if CLASSPATH is set assume propper values for JAVA_LIBRARY_PATH, JAVA_LOGPROP_FILE and PATH as well
if not defined CLASSPATH set JAVA_LIBRARY_PATH=lib
if not defined CLASSPATH set JAVA_LOGPROP_FILE=lib\logging.properties
if not defined CLASSPATH set PATH=lib;%PATH%
if not defined CLASSPATH set CLASSPATH=classes;lib;lib/*
set VIEWER=gswin64c.exe -dBATCH -dNOPAUSE -q -

set keep=0
set args=

:parse
if "%~1"=="/k" ( set keep=1 & goto parsenext )
if "%~1"=="/v" ( set args=viewer=%VIEWER% & goto parsenext )
if "%~1"=="/h" goto usage
set param=%~1
if "%param:~0,1%"=="/" goto usage
goto parsestop
:parsenext
shift
goto parse
:parsestop

if "%keep%"=="0" (
	java -classpath %CLASSPATH% ^
		org.chartacaeli.PreferencesTool tree=user command=delete
	if %errorlevel% neq 0 exit /b %errorlevel%
)

java -classpath %CLASSPATH% ^
	-Djava.library.path=%JAVA_LIBRARY_PATH% ^
	-Djava.util.logging.config.file=%JAVA_LOGPROP_FILE% ^
	org.chartacaeli.ChartaCaeli %args% %1 %2

exit /b %errorlevel%

:usage
echo chartacaeli.bat [ /h /k /v ] ^<cdefs^> [ ^<prefs^> ]
echo.
echo   /k keep user preferences
echo   /v spawn viewer process
echo   /h show this message and exit
echo.
echo The script assumes to be executed in web/WEB-INF if CLASSPATH is unset.
echo To run the script from another folder several variable are required:
echo.
echo   JAVA_LIBRARY_PATH - list (PATH format) of folders the JVM searches for
echo                       shared objects. (default lib)
echo   JAVA_LOGPROP_FILE - path and file name of logging.properties.
echo                       (default lib^\logging.properties)
echo   PATH              - list of folders the dynamic link loader searches
echo                       for nested objects (e.g. caa.dll -^> aaplus.dll).
echo                       (default lib:%%PATH%%)
echo   CLASSPATH         - list of directories the JVM looks up class files
echo                       and JARs. (default classes;lib;lib/*)
exit /b 1