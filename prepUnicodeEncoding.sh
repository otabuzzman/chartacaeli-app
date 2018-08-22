# ./prepUnicodeEncoding.sh <postscript font name> <cmap file path> <CharStrings file path>
#

join $2 $3 |\
java -cp $USERPROFILE/src/chartacaeli\;$USERPROFILE/src/chartacaeli/lib/commons-logging-1.2.jar \
	chartacaeli/UnicodePostscriptStream $1
