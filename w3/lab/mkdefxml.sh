# mkdefxml.sh - generate JS for empty attributes in XML string to initialize Xonomy
#



# join lines
# delete white space
# replace quotes with @@
#
xml=`<$1 sed \
	-e ':a;N;$!ba;s,[\r\n], ,g' \
	-e 's,>\s*<,><,g' \
	-e s,\",@,g`

# extract JS var definitions
#
echo $xml | gawk '\
	BEGIN{FS="><"}{
		for (i=0;NF>i;i++)
			if ($i~/^[A-Z]/&&$i~/@@/) {
				nf=split($i,v," ")
				print "// defaults for " v[1] " element"
				for (j=2;nf>=j;j++)
					printf("var def_%s = \"\";\n",substr(v[j],0,index(v[j],"=")-1))
			}
	}'

# replace @@ with vars
# replace @ with quotes
# get rid of trailing space
#
echo -n var xml = \"
echo $xml | sed -E \
	-e s,\([a-z]*\)=@@,\\1=\'\"+def_\\1+\"\',g \
	-e s,@,\',g |\
	gawk '{print $0 "\";"}'
