# Charta Caeli launch utility. Store and exec in WEB-INF directory.
#
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk
export PATH=$JAVA_HOME/bin:lib:$PATH
export LD_LIBRARY_PATH=lib:$CUDA_HOME/lib64:$LD_LIBRARY_PATH
VIEWER=${GS:-gs}\ -dBATCH\ -dNOPAUSE\ -q\ -
export GS_FONTPATH=${GS_FONTPATH:-$(pwd)}

# Cygwin or what
case $(uname -s) in
	CYGWIN*)
	CLASSPATH=classes\;lib\;lib/*
	;;
	*)
	CLASSPATH=classes:lib:lib/*
	;;
esac

case $1 in
	-v|--view)
	args="viewer=$VIEWER"
	shift
	;;
	*)
	args=""
	;;
esac

java -classpath $CLASSPATH \
	-Djava.library.path=lib \
	-Djava.util.logging.config.file=lib/logging.properties \
	org.chartacaeli.ChartaCaeli $args $1 $2 ;
