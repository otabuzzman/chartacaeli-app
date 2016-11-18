ifeq ($(OS),Windows_NT)
	winos := 1
else
	linos := 1
endif

APP		= chartacaeli
MOD		= $(APP).xsd

PKG		= $(APP)

# Java VM non-standard options
JVMX_OPTS = \
		-Xcheck:jni \
		-Xmx1536m

topdir	= .
pkgdir	= $(subst .,/,$(PKG))
moddir	= $(pkgdir)/model
libdir	= lib
caadir	= caa

JARDEPMOD = castor-codegen-1.3.3.jar \
			castor-xml-schema-1.3.3.jar
JARDEPEXT = $(libdir)/castor-core-1.3.3.jar \
			$(libdir)/castor-xml-1.3.3.jar \
			$(libdir)/jts-1.14.jar \
			$(libdir)/jtsio-1.14.jar \
			$(libdir)/runcc.jar \
			$(libdir)/commons-lang-2.6.jar \
			$(libdir)/commons-math3-3.5.jar \
			$(libdir)/commons-logging-1.2.jar
JARDEPPKG = $(caadir)/caa.jar \
			$(JARDEPEXT) \
			$(PJ2_GENERAL_PATHJAR)

UCBSRC = $(pkgdir)/UnicodeBlock.java
UCBCMD = prepUnicodeBlock.sh
UCBDEF = Blocks-4.1.0.txt
UCBURL = ftp://unicode.org/Public/4.1.0/ucd/Blocks.txt

# hand-crafted Java classes
PKGSRC = \
$(pkgdir)/AnnotationCurved.java \
$(pkgdir)/AnnotationStraight.java \
$(pkgdir)/ApplicationPostscriptStream.java \
$(pkgdir)/ApplicationResource.java \
$(pkgdir)/Artwork.java \
$(pkgdir)/ASCII85OutputStream.java \
$(pkgdir)/ASCII85StringBuilder.java \
$(pkgdir)/AuxiliaryEmitter.java \
$(pkgdir)/Baseline.java \
$(pkgdir)/BodyAreal.java \
$(pkgdir)/BodyElliptical.java \
$(pkgdir)/BodyMoon.java \
$(pkgdir)/BodyOrbitalType.java \
$(pkgdir)/BodyParabolical.java \
$(pkgdir)/BodyPlanet.java \
$(pkgdir)/BodyStellar.java \
$(pkgdir)/BodySun.java \
$(pkgdir)/CAADate.java \
$(pkgdir)/CastorJREEvaluator.java \
$(pkgdir)/CatalogADC1239H.java \
$(pkgdir)/CatalogADC1239HRecord.java \
$(pkgdir)/CatalogADC1239T.java \
$(pkgdir)/CatalogADC1239TRecord.java \
$(pkgdir)/CatalogADC5050.java \
$(pkgdir)/CatalogADC5050Record.java \
$(pkgdir)/CatalogADC5109.java \
$(pkgdir)/CatalogADC5109Record.java \
$(pkgdir)/CatalogADC6049.java \
$(pkgdir)/CatalogADC6049Record.java \
$(pkgdir)/CatalogADC7118.java \
$(pkgdir)/CatalogADC7118Record.java \
$(pkgdir)/CatalogADC7237.java \
$(pkgdir)/CatalogADC7237Record.java \
$(pkgdir)/CatalogDS9.java \
$(pkgdir)/CatalogDS9Record.java \
$(pkgdir)/CatalogRecord.java \
$(pkgdir)/ChartaCaeli.java \
$(pkgdir)/ChartAzimuthal.java \
$(pkgdir)/ChartPage.java \
$(pkgdir)/ChartPseudoCylindrical.java \
$(pkgdir)/ChartType.java \
$(pkgdir)/CircleMeridian.java \
$(pkgdir)/CircleNorthernPolar.java \
$(pkgdir)/CircleNorthernTropic.java \
$(pkgdir)/CircleParallel.java \
$(pkgdir)/CircleSouthernPolar.java \
$(pkgdir)/CircleSouthernTropic.java \
$(pkgdir)/Configuration.java \
$(pkgdir)/Converter.java \
$(pkgdir)/Coordinate.java \
$(pkgdir)/DialDay.java \
$(pkgdir)/DialDeg.java \
$(pkgdir)/DMS.java \
$(pkgdir)/Epoch.java \
$(pkgdir)/FieldOfView.java \
$(pkgdir)/HorizonEcliptical.java \
$(pkgdir)/HorizonEquatorial.java \
$(pkgdir)/HorizonGalactic.java \
$(pkgdir)/HorizonLocal.java \
$(pkgdir)/HorizonType.java \
$(pkgdir)/ImageDiscrete.java \
$(pkgdir)/ImageOperator.java \
$(pkgdir)/LinearScale.java \
$(pkgdir)/Math.java \
$(pkgdir)/MessageCatalog.java \
$(pkgdir)/P4Mollweide.java \
$(pkgdir)/P4Orthographic.java \
$(pkgdir)/P4Projector.java \
$(pkgdir)/P4Stereographic.java \
$(pkgdir)/ParameterNotValidError.java \
$(pkgdir)/ParameterNotValidException.java \
$(pkgdir)/ParserAttribute.java \
$(pkgdir)/ParserSubstitute.java \
$(pkgdir)/Peer.java \
$(pkgdir)/PolygonPlane.java \
$(pkgdir)/PolygonSphere.java \
$(pkgdir)/PostscriptEmitter.java \
$(pkgdir)/PostscriptStream.java \
$(pkgdir)/Projector.java \
$(pkgdir)/RandomDataset.java \
$(pkgdir)/Rational.java \
$(pkgdir)/Registry.java \
$(pkgdir)/Scaleline.java \
$(pkgdir)/ShapeElliptical.java \
$(pkgdir)/Sign.java \
$(pkgdir)/SubstituteCatalog.java \
$(pkgdir)/TeeOutputStream.java \
$(pkgdir)/UnicodePostscriptStream.java \
$(pkgdir)/Vector.java \
$(pkgdir)/Wheel360Scale.java \
$(pkgdir)/WheelScale.java \

.PHONY: all classes clean mclean lclean rclean tidy
.SUFFIXES: .xml .ps .pdf .java .class .map
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
$(moddir): $(MOD) $(JARDEPMOD) $(JARDEPEXT)
	@echo -n "Remove model... "
	@rm -rf $@
	@echo "done!"
	@echo -n "Generate new... "
	@java $(JVMX_OPTS) \
		-classpath "$(subst $(space),$(sep), \
		$(JARDEPMOD) \
		$(JARDEPEXT))" \
		org.exolab.castor.builder.SourceGeneratorMain -i $< \
		-binding-file ./binding.xml
	@echo "done!"
	@echo MODSRC = \\ >Makefile.d
	@find $@ -name '*.java' -print | sed -e 's,$$, \\,' >>Makefile.d

-include Makefile.d

$(UCBDEF):
	wget -q -O $@ $(UCBURL)

$(UCBSRC): $(UCBDEF) $(UCBCMD)
	$${SHELL:-sh} $(UCBCMD) $(UCBDEF) >$@

classes: $(UCBSRC)
	javac \
			-classpath "$(subst $(space),$(sep), \
			$(pkgdir) \
			$(moddir) \
			$(moddir)/descriptors \
			$(JARDEPPKG))" \
			-d . $(UCBSRC) $(MODSRC) $(PKGSRC)

all: classes

.xml.ps:
	@time java $(JVMX_OPTS) \
			-D$(PKG).app=$(APP) \
			-Djava.library.path=$(caadir) \
			-classpath "$(subst $(space),$(sep), \
			$(pkgdir) \
			$(moddir) \
			$(moddir)/descriptors \
			$(JARDEPPKG))" \
			$(PKG).ChartaCaeli $< >$@

.ps.pdf:
	@time $${GS:-gs} -q -dBATCH -dNOPAUSE -sDEVICE=pdfwrite -sOutputFile=$@ $<

.class.map:
	java $(JVMX_OPTS) \
		-classpath "$(subst $(space),$(sep), \
		$(JARDEPEXT))" \
		org.exolab.castor.tools.MappingTool -i $(subst /,.,$(subst .class,,$<)) -o $@

# compiler objects
clean:
	find $(pkgdir) -name '*.class' -exec rm -f {} \;

# model clean
mclean:
	rm -rf $(moddir)
	rm -f Makefile.d

# local clean
lclean: clean mclean
	rm -f $(UCBSRC)

# real clean
rclean: lclean
	rm -f $(UCBDEF)
	rm -f $(JARDEPMOD) $(JARDEPEXT)
	rm -f runcc-0.7.zip jts-1.14.zip

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
	wget -q -O $@ http://central.maven.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.jar
$(libdir)/commons-math3-3.5.jar:
	wget -q -O $@ http://central.maven.org/maven2/org/apache/commons/commons-math3/3.5/commons-math3-3.5.jar
$(libdir)/commons-logging-1.2.jar:
	wget -q -O $@ http://central.maven.org/maven2/commons-logging/commons-logging/1.2/commons-logging-1.2.jar
