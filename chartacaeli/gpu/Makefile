ifeq ($(OS),Windows_NT)
	winos := 1
else
	linos := 1
endif

JNI = gpu

PKG = chartacaeli.$(JNI)

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
C3PSRC = $(srcdir)/Math.cpp $(srcdir)/Coordinate.cpp $(srcdir)/P4Mollweide.cpp
C3POBJ = $(patsubst $(srcdir)/%.cpp,%.o,$(C3PSRC))

# Java test classes
TSTCLS = $(patsubst $(srcdir)/%.cpp,$(tstdir)/%.java,$(C3PSRC))
TSTSRC = $(subst .java,_jni.cxx,$(TSTCLS))
TSTOBJ = $(subst .cxx,.o,$(TSTSRC))

# default goal
cuda: $(C3POBJ)

$(TSTSRC):
	( cd $(srcdir) ; for h in *.h ; do \
		$(CXXWRAP) \
			--jni --jni-attributes \
			--classpath=$(topdir) \
			--package-prefix=$(PKG).tst $$h ; done )

JAREXT = \
		junit4.jar \
		hamcrest.jar \

# to run test cases from command line...
$(notdir $(basename $(wildcard $(tstdir)/*Test.java))):
	@( cd $(topdir) ; PATH=$(pkgdir):$$PATH ; \
		java -classpath "$(subst $(space),$(sep), \
			chartacaeli \
			lib/jts-1.14.jar \
			$(addprefix $(pkgdir)/,$(JAREXT)))" \
			org.junit.runner.JUnitCore $(PKG).tst.$@ )

test: $(GPUDLL) | $(JAREXT) $(notdir $(basename $(wildcard $(tstdir)/*Test.java)))

.PHONY: all cuda test clean lclean rclean tidy
.SUFFIXES: .cxx .dll .so

empty =
space = $(empty) $(empty)

vpath %.cpp $(srcdir)

ifdef winos
sep := ;
else
sep := :
endif

ifdef winos
.cpp.o:
	$(CXX) -Wall -shared \
	-I../caa/src \
	-c $< -o $@

.cxx.o:
	$(CXX) -Wall -shared \
	-Isrc \
	-I"$(JAVA_HOME)/include" \
	-I"$(JAVA_HOME)/include/win32" \
	-c $< -o $@

$(GPUDLL): $(C3POBJ) $(TSTOBJ)
	$(CXX) -Wall -shared \
	-static-libgcc -static-libstdc++ \
	-o $@ $^
else
.cpp.o:
	$(CXX) -Wall -shared -fPIC \
	-I../caa/src \
	-c $< -o $@

.cxx.o:
	$(CXX) -Wall -shared -fPIC \
	-Isrc \
	-I$(JAVA_HOME)/include \
	-I$(JAVA_HOME)/include/linux \
	-c $< -o $@

$(GPUDLL): $(C3POBJ) $(TSTOBJ)
	$(CXX) -Wall -shared \
	-o $@ $^
endif

all: cuda

# compiler objects
clean:
	rm -f $(C3POBJ) $(TSTOBJ)

# local clean
lclean: clean
	rm -f $(TSTSRC) $(TSTCLS)
	rm -f $(GPUDLL)

# real clean
rclean: lclean
	rm -f $(JAREXT)

tidy: rclean



junit4.jar:
	wget -q -O $@ http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar
hamcrest.jar:
	wget -q -O $@ http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
