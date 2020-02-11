# Charta Caeli launch utility. Store and exec in WEB-INF directory.
#

# if CLASSPATH is set assume propper values for JAVA_LIBRARY_PATH and LD_LIBRARY_PATH as well
test -z "$CLASSPATH" && { JAVA_LIBRARY_PATH=lib ; export LD_LIBRARY_PATH=lib:$LD_LIBRARY_PATH ; export CLASSPATH=classes:lib:lib/* ; }
VIEWER=${GS:-gs}\ -dBATCH\ -dNOPAUSE\ -q\ -

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
	-Djava.library.path=$JAVA_LIBRARY_PATH \
	-Djava.util.logging.config.file=lib/logging.properties \
	org.chartacaeli.ChartaCaeli $args $1 $2

exit $?
