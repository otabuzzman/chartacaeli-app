export JAVA_HOME=/cygdrive/c/program\ files/java/jdk1.8.0_151
export PATH=/cygdrive/c/program\ files/java/jdk1.8.0_151/bin:$PATH
export PATH=/usr/x86_64-w64-mingw32/sys-root/mingw/bin:$PATH
export PATH=lib:$PATH
export VIEWER=gs\ -dBATCH\ -dNOPAUSE\ -q\ -
export GS_FONTPATH=`pwd`

java -classpath "classes:lib:lib/*" \
	-Djava.library.path=lib \
	-Djava.util.logging.config.file=lib/logging.properties \
	org.chartacaeli.ChartaCaeli viewer=$VIEWER $*
