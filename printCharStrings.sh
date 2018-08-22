# ./printCharStrings <font name>
#

# 1. create a directory
# 2. put TTF font file into directory
# 3. create Fontmap file in same directory:
#      <font name> (<TTF font file name>) ;
#      example:
#      /ArialUnicodeMS (ARIALUNI.TTF) ;
#      /LucidaSansUnicode (l_10646.ttf) ;
# 4. execute this script in same directory
#

echo "
$1 findfont
/CharStrings get
{
	8 string
	cvs print
	( ) print
	(/) print
	dup
	length string 
	cvs print
	(\n) print
} forall
" |\
${GS:?parameter not valid} -q -
