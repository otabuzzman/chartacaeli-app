@echo off
rem Charta Caeli launch utility.
rem

rem update PATH to point at Cygwin DLLs needed by caa.dll (aaplus.dll)
set PATH=%ProgramFiles%\Cygwin\usr\x86_64-w64-mingw32\sys-root\mingw\bin;%PATH%

set PATH=lib;%PATH%
if not defined JAVA set JAVA=java.exe
if not defined CLASSPATH set CLASSPATH=classes;lib;lib\*
if not defined LANG ( set LANG=en ) else ( for /f "tokens=1 delims=_" %%l in ( "%LANG%" ) do set LANG=%%l )
if not defined VIEWER set VIEWER=gswin64c.exe -dBATCH -dNOPAUSE -dNOSAFER -q -

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
	-Duser.language=%LANG% ^
	-Djava.library.path=lib ^
	-Djava.util.logging.config.file=lib\logging.properties ^
	org.chartacaeli.ChartaCaeli "%args%" %1 %2

exit /b %errorlevel%

:usage
echo chartacaeli.bat [ /h /k /v ] ^<cdefs^> [ ^<prefs^> ]
echo.
echo   /k keep user preferences
echo   /v spawn viewer process
echo   /h show this message and exit
echo.
echo Script must exec in web\WEB-INF folder. Control variables are:
echo   JAVA       - The Java Virtual Machine. (default java.exe)
echo   CLASSPATH  - Lookup Java classes, ressources and JAR files.
echo                (default classes;lib;lib\*)
echo   LANG       - Set language code. Codes for region and variant ignored
echo                if present. Syntax ^<lang^>[_^<region^>.^<variant^>].
echo                (default en)
echo   _JAVA_OPTS - Override JVM command line (not recommended: SO#28327620).
echo                (default -classpath %CLASSPATH%
echo                    -Duser.language=%LANG%
echo                    -Djava.library.path=lib
echo                    -Djava.util.logging.config.file=lib\logging.properties)
echo   VIEWER     - Command line to spawn viewer process for PS output.
echo                (default gswin64c.exe -dBATCH -d NOPAUSE -dNOSAFER -q -)
exit /b 1