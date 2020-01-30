@echo off
rem Charta Caeli launch utility. Store and exec in WEB-INF directory.
rem

set JAVA_HOME=c:/program files/java/jdk1.8.0_151
set PATH=c:/program files/java/jdk1.8.0_151/bin;%PATH%
set PATH=c:/program files/cygwin/usr/x86_64-w64-mingw32/sys-root/mingw/bin;%PATH%
set PATH=lib;%PATH%
set VIEWER=gswin64c.exe -dBATCH -dNOPAUSE -q -
if not defined GS_FONTPATH ( for /f "tokens=*" %%x in ( 'cd' ) do (set GS_FONTPATH=%%x ) )
if not defined CLASSPATH ( set CLASSPATH=classes;lib;lib/* )

set keep=0
set args=

:parse
if "%~1"=="/k" ( set keep=1 & goto parsenext )
if "%~1"=="/v" ( set args=viewer=%VIEWER% & goto parsenext )
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
	-Djava.library.path=lib ^
	-Djava.util.logging.config.file=lib/logging.properties ^
	org.chartacaeli.ChartaCaeli %args% %1 %2

exit /b %errorlevel%

:usage
echo "chartacaeli.bat [ /k /v ] <cdefs> [ <prefs> ]"
echo "  /k keep user preferences"
echo "  /v spawn viewer process"
exit /b 1