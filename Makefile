APP		= chartacaeli
MOD		= $(APP).xsd

PKG		= $(APP)

JVO		= -Xcheck:jni \
		  -Xmx1536m

topdir	= .
srcdir	= $(subst .,/,$(PKG))
libdir	= lib
caadir	= caa

JARDEPBLD = castor-codegen-1.3.3.jar \
			castor-xml-schema-1.3.3.jar
JARDEPEXT = $(libdir)/castor-core-1.3.3.jar \
			$(libdir)/castor-xml-1.3.3.jar \
			$(libdir)/jts-1.14.jar \
			$(libdir)/jtsio-1.14.jar \
			$(libdir)/runcc.jar \
			$(libdir)/commons-lang-2.6.jar \
			$(libdir)/commons-math3-3.5.jar \
			$(libdir)/commons-logging-1.2.jar
JARDEPPKG = $(libdir)/caa.jar \
			$(JARDEPEXT)
JARDEPTMP = runcc-0.7.zip jts-1.14.zip

UCBSRC = $(srcdir)/UnicodeBlock.java
UCBCMD = $(topdir)/prepUnicodeBlock.sh
UCBDEF = Blocks-4.1.0.txt
UCBURL = ftp://unicode.org/Public/4.1.0/ucd/Blocks.txt

.PHONY: all clean tidy
.SUFFIXES: .xml .ps .pdf .java .class .map
.SECONDARY: $(APP).ps

empty =
space = $(empty) $(empty)

vpath %.class $(srcdir)/model
vpath %.xml lab

all: $(JARDEPBLD) $(JARDEPPKG) $(UCBSRC) $(srcdir)/model
	make $(srcdir)/*.class $(srcdir)/model/*.class $(srcdir)/model/descriptors/*.class

.xml.ps:
	@time $(JDK)/bin/java $(JVO) \
			-D$(PKG).app=$(APP) \
			-Djava.library.path=$(libdir) \
			-classpath $(subst $(space),\;, \
			$(srcdir) \
			$(srcdir)/model \
			$(srcdir)/model/descriptors \
			$(JARDEPPKG)) \
			$(PKG).ChartaCaeli $< >$@

.ps.pdf:
	@time $${GS:-gs} -q -dBATCH -dNOPAUSE -sDEVICE=pdfwrite -sOutputFile=$@ $<

.java.class:
	$(JDK)/bin/javac \
			-classpath $(subst $(space),\;, \
			$(srcdir) \
			$(srcdir)/model \
			$(srcdir)/model/descriptors \
			$(JARDEPPKG)) \
			-d . $^

.class.map:
	@$(JDK)/bin/java $(JVO) \
		-classpath $(subst $(space),\;, \
		$(JARDEPEXT)) \
		org.exolab.castor.tools.MappingTool -i $(subst /,.,$(subst .class,,$<)) -o $@

$(srcdir)/model: $(MOD)
	@echo -n "Building model... "
	@$(JDK)/bin/java $(JVO) \
		-classpath $(subst $(space),\;, \
		$(JARDEPBLD) \
		$(JARDEPEXT)) \
		org.exolab.castor.builder.SourceGeneratorMain -i $< \
		-binding-file ./binding.xml \
	@touch $@
	@echo "done!"

$(UCBDEF):
	wget -q -O $@ $(UCBURL)

$(UCBSRC): $(UCBDEF) $(UCBCMD)
	$(UCBCMD) $(UCBDEF) >$@

$(libdir)/caa.jar: $(caadir)/caa.jar $(caadir)/caa.dll $(caadir)/aaplus.dll
	install $^ $(libdir)

# compiler objects
clean:
	rm -f $(srcdir)/*.class $(srcdir)/model/*.class $(srcdir)/model/descriptors/*.class

# model clean
mclean: clean
	rm -rf $(srcdir)/model

# local clean
lclean: mclean
	rm -f $(UCBSRC)
	rm -f $(libdir)/caa.jar $(libdir)/caa.dll $(libdir)/aaplus.dll

# real clean
rclean: lclean
	rm -f $(UCBDEF)
	rm -f $(JARDEPBLD) $(JARDEPEXT) $(JARDEPTMP)

tidy: rclean



castor-codegen-1.3.3.jar:
	wget -q http://central.maven.org/maven2/org/codehaus/castor/castor-codegen/1.3.3/castor-codegen-1.3.3.jar
castor-xml-schema-1.3.3.jar:
	wget -q http://central.maven.org/maven2/org/codehaus/castor/castor-xml-schema/1.3.3/castor-xml-schema-1.3.3.jar
$(libdir)/castor-core-1.3.3.jar:
	wget -q -O $@ http://central.maven.org/maven2/org/codehaus/castor/castor-core/1.3.3/castor-core-1.3.3.jar
$(libdir)/castor-xml-1.3.3.jar:
	wget -q -O $@ http://central.maven.org/maven2/org/codehaus/castor/castor-xml/1.3.3/castor-xml-1.3.3.jar
jts-1.14.zip:
	wget -q http://sourceforge.net/projects/jts-topo-suite/files/latest/jts-1.14.zip
$(libdir)/jts-1.14.jar $(libdir)/jtsio-1.14.jar: jts-1.14.zip
	unzip -uo $^ $@
	touch $@
runcc-0.7.zip:	
	wget -q http://sourceforge.net/projects/runcc/files/latest/runcc-0.7.zip
$(libdir)/runcc.jar: runcc-0.7.zip
	unzip -juo $^ runcc-0.7/$(@F) -d $(libdir)
	touch $@
$(libdir)/commons-lang-2.6.jar:
	wget -q -O $@ http://central.maven.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.jar
$(libdir)/commons-math3-3.5.jar:
	wget -q -O $@ http://central.maven.org/maven2/org/apache/commons/commons-math3/3.5/commons-math3-3.5.jar
$(libdir)/commons-logging-1.2.jar:
	wget -q -O $@ http://central.maven.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar
