ifeq ($(OS),Windows_NT)
	winos := 1
else
	linos := 1
endif

JNI = gpu

# this package
PKG = chartacaeli.$(JNI)

# sub-package with test classes
TST = $(PKG).$(tstdir)

# top-level diretory is current minus package (e.g. /foo/bar/hot minus bar.hot yields /foo)
topdir = $(subst $(subst .,/,$(PKG)),,$(CURDIR))
srcdir = src
tstdir = tst
pkgdir	= $(subst .,/,$(PKG))

ifdef winos
GPUDLL = $(JNI).dll
else
GPUDLL = lib$(JNI).so
endif

# C++ peer classes
C3PSRC = \
	$(srcdir)/Coordinate.cpp \
	$(srcdir)/Vector3D.cpp \
	$(srcdir)/Plane.cpp \
	$(srcdir)/Math.cpp \
	$(srcdir)/RealMatrix.cpp \
	$(srcdir)/P4Mollweide.cpp \
	$(srcdir)/P4Orthographic.cpp \
	$(srcdir)/P4Stereographic.cpp \

# C++ auxiliary classes
AUXSRC = \
	$(srcdir)/P4ProjectorFactory.cpp \

# C++ experimental classes
EXPSRC = \
	$(srcdir)/PJ2TextureMapperC3p.cpp \

C3POBJ = $(patsubst $(srcdir)/%.cpp,%.o,$(C3PSRC))
AUXOBJ = $(patsubst $(srcdir)/%.cpp,%.o,$(AUXSRC))
EXPOBJ = $(patsubst $(srcdir)/%.cpp,%.o,$(EXPSRC))

# JNI wrapper for JUnit testing
JNICLS = $(patsubst $(srcdir)/%.cpp,$(tstdir)/%.java,$(C3PSRC) $(EXPSRC))
JNISRC = $(subst .java,_jni.cxx,$(JNICLS))
JNIOBJ = $(subst .cxx,.o,$(JNISRC))

# JUnit test classes
TSTCLS = $(wildcard $(tstdir)/*Test.java)

# default goal
cuda: PJ2TextureMapperGpu.ptx

$(JNISRC):
	( cd $(srcdir) ; for c in $(notdir $(basename $(C3PSRC) $(EXPSRC))) ; do \
		$(CXXWRAP) \
			--jni --jni-attributes \
			--classpath=$(topdir) \
			--package-prefix=$(TST) $$c.h ; \
		if expr $$c : P4 ; then \
			sed -e 's,public class.*,public class '$$c' extends Object implements P4Projector {,' \
			<../$(tstdir)/$$c.java \
			>../$(tstdir)/$$c.$$$$ ; \
			mv ../$(tstdir)/$$c.$$$$ ../$(tstdir)/$$c.java ; fi ; done )

JAREXT = \
	junit4.jar \
	hamcrest.jar \

# pragma to build test classes from command line...
testbuild: $(GPUDLL) | $(JAREXT)
	( cd $(topdir) ; \
		javac -classpath "$(subst $(space),$(sep), \
			$| \
			lib/jts-1.14.jar \
			lib/commons-math3-3.5.jar \
			$(addprefix $(pkgdir)/,$(JAREXT)))" \
			-d . $(addprefix $(pkgdir)/,$(JNICLS) $(TSTCLS)) )

# pragma to run test classes from command line...
testrun: $(TSTCLS)
	@( cd $(topdir) ; \
		PATH=$(pkgdir):$$PATH ; \
		LD_LIBRARY_PATH=$(pkgdir):$$LD_LIBRARY_PATH ; \
		for t in $(notdir $(basename $(TSTCLS))) ; do \
			echo "*** $$t ***" ; \
			java -classpath "$(subst $(space),$(sep), \
				chartacaeli \
				lib/jts-1.14.jar \
				lib/commons-math3-3.5.jar \
				$(addprefix $(pkgdir)/,$(JAREXT)))" \
				org.junit.runner.JUnitCore $(TST).$$t ; done )

.PHONY: all cuda testbuild testrun clean lclean rclean tidy
.SUFFIXES: .cxx .cu .ptx .dll .so

empty =
space = $(empty) $(empty)

vpath %.cpp $(srcdir)
vpath %.cu $(srcdir)

ifdef winos
sep := ;
else
sep := :
endif

# see GNU make manual 4.14 "Generating Prerequisites Automatically"
%.d: %.cpp
	set -e; rm -f $@; \
		$(CXX) -MM -I../caa/src $< > $(@F).$$$$; \
		sed 's,\($(*F)\)\.o[ :]*,\1.o $(@F) : ,g' < $(@F).$$$$ > $(@F); \
		rm -f $(@F).$$$$

include $(notdir $(C3PSRC:.cpp=.d) $(AUXSRC:.cpp=.d) $(EXPSRC:.cpp=.d))

.cu.ptx:

ifdef winos
.cpp.o:
	$(CXX) -Wall -shared \
	-I../caa/src \
	-I$(CUDA_HOME)/include \
	-c $< -o $@

.cxx.o:
	$(CXX) -Wall -shared \
	-Isrc \
	-I"$(JAVA_HOME)/include" \
	-I"$(JAVA_HOME)/include/win32" \
	-c $< -o $@

$(GPUDLL): $(C3POBJ) $(AUXOBJ) $(EXPOBJ) $(JNIOBJ)
	$(CXX) -Wall -shared \
	-static-libgcc -static-libstdc++ \
	-o $@ $^
else
.cpp.o:
	$(CXX) -Wall -shared -fPIC \
	-I../caa/src \
	-I$(CUDA_HOME)/include \
	-c $< -o $@

.cxx.o:
	$(CXX) -Wall -shared -fPIC \
	-Isrc \
	-I$(JAVA_HOME)/include \
	-I$(JAVA_HOME)/include/linux \
	-c $< -o $@

$(GPUDLL): $(C3POBJ) $(AUXOBJ) $(EXPOBJ) $(JNIOBJ)
	$(CXX) -Wall -shared \
	-o $@ $^
endif

all: cuda

# compiler objects
clean:
	rm -f $(C3POBJ) $(AUXOBJ) $(EXPOBJ) $(JNIOBJ)
	rm -f $(addsuffix *.class,$(basename $(JNICLS)))

# local clean
lclean: clean
	rm -f $(JNISRC) $(JNICLS)
	rm -f $(GPUDLL)

# real clean
rclean: lclean
	rm -f $(notdir $(C3PSRC:.cpp=.d) $(AUXSRC:.cpp=.d) $(EXPSRC:.cpp=.d))
	rm -f $(JAREXT)

tidy: rclean



junit4.jar:
	wget -q -O $@ http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar
hamcrest.jar:
	wget -q -O $@ http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
