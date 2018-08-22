# ./printCMAP <TTF font file path>
#

${TTFDUMP:?parameter not valid} -tcmap $1 |\
gawk '
	$0~/Char [0-9a-fA-F]{4,6}.* Index/ {
		print $NF " " $(NF-3)
	}
'
