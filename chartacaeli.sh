# Charta Caeli launch utility.
#

export LD_LIBRARY_PATH=lib:$LD_LIBRARY_PATH 

usage() {
	echo "chartacaeli.sh [ -kv ] <cdefs> [ <prefs> ]"
	echo ""
	echo "  -k keep user preferences"
	echo "  -v spawn viewer process"
	echo "  -h show this message and exit"
	echo ""
	echo "Script must exec in web/WEB-INF folder. Control variables are:"
	echo "  CLASSPATH  - Lookup Java classes, ressources and JAR files."
	echo "               (default classes:lib:lib/*)"
	echo "  LANG       - Set language code. Codes for region and variant ignored"
	echo "               if present. Syntax <lang>[_<region>.<variant>]."
	echo "               (default en)"
	echo "  _JAVA_OPTS - Override JVM command line (not recommended: SO#28327620)."
	echo "               (default -classpath \$CLASSPATH"
	echo "                   -Duser.language=\$LANG"
	echo "                   -Djava.library.path=lib"
	echo "                   -Djava.util.logging.config.file=lib/logging.properties)"
	echo "  VIEWER     - Command line to spawn viewer process for PS output."
	echo "               (default gs -dBATCH -d NOPAUSE -q -)"
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
		args="viewer=${VIEWER:-${GS:-gs} -dBATCH -dNOPAUSE -q -}"
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
	java -classpath ${CLASSPATH:-classes:lib:lib/*} \
		org.chartacaeli.PreferencesTool tree=user command=delete || exit $?
}

java -classpath ${CLASSPATH:-classes:lib:lib/*} \
	-Duser.language=$(echo ${LANG:-en} | sed 's,_.*,,') \
	-Djava.library.path=lib \
	-Djava.util.logging.config.file=lib/logging.properties \
	org.chartacaeli.ChartaCaeli $args $1 $2

exit $?
