set JAVA_HOME=c:/program files/java/jdk1.8.0_151
set PATH=c:/program files/java/jdk1.8.0_151/bin;%PATH%
set PATH=c:/program files/cygwin/usr/x86_64-w64-mingw32/sys-root/mingw/bin;%PATH%
set PATH=lib;%PATH%
set VIEWER=gswin64c.exe -dBATCH -dNOPAUSE -q -
for /f "tokens=*" %%x in ('cd') do (set GS_FONTPATH=%%x)

java -classpath "classes;lib;lib/*" ^
	-Djava.library.path=lib ^
	-Djava.util.logging.config.file=lib/logging.properties ^
	org.chartacaeli.ChartaCaeli viewer=%VIEWER% %*
