call ..\..\lab\TornadoVM\setvars.cmd

set PATH=org\chartacaeli\caa;%PATH%
set PATH=c:\cygwin64\usr\x86_64-w64-mingw32\sys-root\mingw\bin;%PATH%

set classpath=^
lib;^
org/chartacaeli;^
org/chartacaeli/gpu;^
lib/pj2.jar;^
lib/castor-core-1.3.3.jar;^
lib/castor-xml-1.3.3.jar;^
lib/jts-1.14.jar;^
lib/jtsio-1.14.jar;^
lib/runcc.jar;^
lib/commons-lang-2.6.jar;^
lib/commons-math3-3.5.jar;^
lib/commons-logging-1.2.jar;

set tvmdev=-Ds0.t0.device=1:0

set tvmlib=%TORNADO_SDK%\lib

rem did not get viewer to work properly yet, thus omitted.
python %TORNADO_SDK%\bin\tornado --jvm "%tvmdev% -Djava.library.path=%tvmlib%;org/chartacaeli/caa;org/chartacaeli/gpu;lib; -Djava.util.logging.config.file=lib/logging.properties -classpath %classpath%" org.chartacaeli.ChartaCaeli %1 >%2
