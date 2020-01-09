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

usage() {
	echo "chartacaeli.sh [ -kv ] <cdefs> [ <prefs> ]"
	echo "  -k keep user preferences"
	echo "  -v spawn viewer process"
	exit 1
}

keep=0
args=""

while getopts "kv" opt ; do
	case $opt in
		k)
		keep=1
		;;
		v)
		args="viewer=$VIEWER"
		;;
		*)
		usage
		;;
	esac
done
shift $((OPTIND-1))

test $keep -eq 0 && {
	java -classpath $CLASSPATH \
		org.chartacaeli.PreferencesTool tree=user command=delete || exit $?
}

java -classpath $CLASSPATH \
	-Djava.library.path=lib \
	-Djava.util.logging.config.file=lib/logging.properties \
	org.chartacaeli.ChartaCaeli $args $1 $2

exit $?
