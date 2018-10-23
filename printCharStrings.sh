# ./printCharStrings <font name>
#

# 1. set GS_FONTPATH to point at font file directory
#      example:
#      export GS_FONTPATH=c:/users/jschuck/src/chartacaeli
# 2. run script
#
# Alternatively
# 1. create a directory
# 2. put TTF font file into directory
# 3. create Fontmap file in same directory:
#      <font name> (<TTF font file name>) ;
#      example:
#      /ArialUnicodeMS (ARIALUNI.TTF) ;
#      /LucidaSansUnicode (l_10646.ttf) ;
# 4. run script in same directory
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
${GS:?parameter not valid} -q - |\
sort
