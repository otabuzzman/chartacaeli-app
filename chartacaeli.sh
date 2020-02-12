# Charta Caeli launch utility.
#

# if CLASSPATH is set assume propper values for JAVA_LIBRARY_PATH, JAVA_LOGPROP_FILE and LD_LIBRARY_PATH as well
test -z "$CLASSPATH" && {
	JAVA_LIBRARY_PATH=lib
	test -s lib/logging.properties \
	&& JAVA_LOGPROP_FILE=lib/logging.properties \
	|| JAVA_LOGPROP_FILE=classes/logging.properties
	export LD_LIBRARY_PATH=lib:$LD_LIBRARY_PATH
	export CLASSPATH=classes:lib:lib/* ; }
VIEWER=${GS:-gs}\ -dBATCH\ -dNOPAUSE\ -q\ -

usage() {
	echo "chartacaeli.sh [ -kv ] <cdefs> [ <prefs> ]"
	echo ""
	echo "  -k keep user preferences"
	echo "  -v spawn viewer process"
	echo ""
	echo "The script assumes to be executed in web/WEB-INF if CLASSPATH is unset."
	echo "To run the script from another folder several variable are required:"
	echo ""
	echo "  JAVA_LIBRARY_PATH - list (PATH format) of folders the JVM searches for"
	echo "                      shared objects."
	echo "  JAVA_LOGPROP_FILE - path and file name of logging.properties."
	echo "  LD_LIBRARY_PATH   - list of folders the dynamic link loader searches"
	echo "                      for nested objects (e.g. caa.so -> aaplus.so)."
	echo "  CLASSPATH         - list of directories the JVM looks up class files"
	echo "                      and JARs."
	exit 1
}

keep=0
args=""

while getopts "hkv" opt ; do
	case $opt in
		k)
		keep=1
		;;
		v)
		args="viewer=$VIEWER"
		;;
		h)
		usage
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
	-Djava.util.logging.config.file=$JAVA_LOGPROP_FILE \
	org.chartacaeli.ChartaCaeli $args $1 $2

exit $?
