ifeq ($(OS),Windows_NT)
	winos := 1
else
	linos := 1
endif

APP		= chartacaeli
PKG		= org.chartacaeli

MOD		= $(APP).xsd

# Java VM non-standard options
JVMX_OPTS = \
		-Xmx3072m

pkgdir	= $(subst .,/,$(PKG))
moddir	= $(pkgdir)/model
libdir	= lib

instdir	= /opt/$(APP)

jnilib	= \
		$(pkgdir)/caa \
		$(pkgdir)/gpu \
		$(libdir) \

JARMOD = \
		castor-codegen-1.3.3.jar \
		castor-xml-schema-1.3.3.jar \

JAREXT = \
		$(libdir)/pj2.jar \
		$(libdir)/castor-core-1.3.3.jar \
		$(libdir)/castor-xml-1.3.3.jar \
		$(libdir)/jts-1.14.jar \
		$(libdir)/jtsio-1.14.jar \
		$(libdir)/runcc.jar \
		$(libdir)/commons-lang-2.6.jar \
		$(libdir)/commons-math3-3.5.jar \
		$(libdir)/commons-logging-1.2.jar \

CLSUCB = $(pkgdir)/UnicodeBlock.java
UCBCMD = prepUnicodeBlock.sh
UCBDEF = Blocks-4.1.0.txt
UCBURL = ftp://unicode.org/Public/4.1.0/ucd/Blocks.txt

# JUnit test classes
CLSTST	= $(shell find $(pkgdir) -name '*Test.java' -print)

# classes excluded from build
CLSEXC	= $(CLSTST)

.PHONY: all classes clean mclean lclean rclean tidy
.SUFFIXES: .xml .ps .pdf .java .class .map .raw .png
.SECONDARY: $(APP).ps

empty =
space = $(empty) $(empty)

vpath %.xml lab

ifdef winos
sep := ;
else
sep := :
endif

# default goal
$(moddir): $(MOD) | $(JARMOD) $(JAREXT)
	@echo -n "Generate model classes... "
	@java $(JVMX_OPTS) \
		-classpath "$(subst $(space),$(sep), \
		$(JARMOD) \
		$(JAREXT))" \
		org.exolab.castor.builder.SourceGeneratorMain -i $< \
		-binding-file ./binding.xml
	@echo "done!"

CLSAPP = $(shell find $(pkgdir) -name '*.java' -print)
CLSAPP := $(filter-out $(CLSEXC),$(CLSAPP))

$(UCBDEF):
	wget -q -O $@ $(UCBURL)

$(CLSUCB): $(UCBDEF) $(UCBCMD)
	$${SHELL:-sh} $(UCBCMD) $(UCBDEF) >$@

classes: $(CLSUCB)
	javac \
			-classpath "$(subst $(space),$(sep), \
			$(pkgdir) \
			$(JAREXT))" \
			-d . $^ $(CLSAPP)

ifdef winos
VIEWER = $${GS:-gswin64c.exe} -dBATCH -dNOPAUSE -q -
else
# VIEWER = $${GS:-gs} -dBATCH -dNOPAUSE -q -
endif

.xml.ps:
	# note that caa loads aaplus thus needs PATH set as well as java.library.path
	@time java $$JFRX_OPTS $(JVMX_OPTS) \
			-Duser.language=$$(echo $${LANG:-en} | sed 's,_.*,,') \
			-Djava.library.path="$(subst $(space),$(sep),$(jnilib))" \
			-Djava.util.logging.config.file=lib/logging.properties \
			-classpath "$(subst $(space),$(sep), \
			$(libdir) \
			$(pkgdir) \
			$(JAREXT))" \
			$(PKG).ChartaCaeli viewer="$(VIEWER)" $< >$@

.ps.pdf:
ifdef winos
	@export GS_FONTPATH=$$(cygpath -m $$(pwd)) ; time $${GS:-gswin64c.exe} -q -dBATCH -dNOPAUSE -sDEVICE=pdfwrite -sOutputFile=$@ $<
else
	@export GS_FONTPATH=$$(pwd) ; time $${GS:-gs} -q -dBATCH -dNOPAUSE -sDEVICE=pdfwrite -sOutputFile=$@ $<
endif

.class.map:
	java $(JVMX_OPTS) \
		-classpath "$(subst $(space),$(sep), \
		$(JAREXT))" \
		org.exolab.castor.tools.MappingTool -i $(subst /,.,$(subst .class,,$<)) -o $@

$(instdir):
	mkdir -p $@ -m 775
ifdef linos
	sudo chown $$(id -u) $@
	sudo chgrp $$(id -g) $@
endif

install: $(instdir)
	mvn compile
	tar cf - web | ( cd $< ; tar xf - )

# compiler objects
clean:
	rm -f $(addsuffix *.class,$(basename $(CLSAPP)))

# model clean
mclean:
	rm -rf $(moddir)

# local clean
lclean: clean mclean
	rm -f $(CLSUCB)

# real clean
rclean: lclean
	rm -f $(UCBDEF)
	rm -f $(JARMOD) $(JAREXT)
	rm -f runcc-0.7.zip jts-1.14.zip

tidy: rclean



castor-codegen-1.3.3.jar:
	wget -q https://repo.maven.apache.org/maven2/org/codehaus/castor/castor-codegen/1.3.3/castor-codegen-1.3.3.jar
castor-xml-schema-1.3.3.jar:
	wget -q https://repo.maven.apache.org/maven2/org/codehaus/castor/castor-xml-schema/1.3.3/castor-xml-schema-1.3.3.jar
$(libdir)/castor-core-1.3.3.jar:
	wget -q -O $@ https://repo.maven.apache.org/maven2/org/codehaus/castor/castor-core/1.3.3/castor-core-1.3.3.jar
$(libdir)/castor-xml-1.3.3.jar:
	wget -q -O $@ https://repo.maven.apache.org/maven2/org/codehaus/castor/castor-xml/1.3.3/castor-xml-1.3.3.jar
jts-1.14.zip:
	wget -q https://sourceforge.net/projects/jts-topo-suite/files/jts/1.14/jts-1.14.zip
$(libdir)/jts-1.14.jar $(libdir)/jtsio-1.14.jar: jts-1.14.zip
	unzip -uo $< $@
	touch $@
runcc-0.7.zip:
	wget -q http://sourceforge.net/projects/runcc/files/latest/runcc-0.7.zip
$(libdir)/runcc.jar: runcc-0.7.zip
	unzip -juo $< runcc-0.7/$(@F) -d $(libdir)
	touch $@
$(libdir)/commons-lang-2.6.jar:
	wget -q -O $@ https://repo.maven.apache.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.jar
$(libdir)/commons-math3-3.5.jar:
	wget -q -O $@ https://repo.maven.apache.org/maven2/org/apache/commons/commons-math3/3.5/commons-math3-3.5.jar
$(libdir)/commons-logging-1.2.jar:
	wget -q -O $@ https://repo.maven.apache.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar
$(libdir)/pj2.jar:
	wget -q -O $@ https://www.cs.rit.edu/~ark/pj2_20190611.jar



# test targets
FieldOfView.ps: lab/FieldOfView.dat
	@eval java $(JVMX_OPTS) \
		-Djava.library.path='"$(subst $(space),$(sep),$(jnilib))"' \
		-Djava.util.logging.config.file=lib/logging.properties \
		-classpath '"$(subst $(space),$(sep), \
		$(pkgdir) \
		$(JAREXT))"' \
		$(PKG).FieldOfView '"viewer=$(VIEWER)"' `egrep -v '^#|^$$' $<` >$@



# utility targets
.raw.png:
	( n=$< p=$${n##*-} s=$${p%.*} ; magick convert -depth 8 -size $$s rgb:$< $@ )
