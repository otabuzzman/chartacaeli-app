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

$(TSTSRC):
	( cd $(srcdir) ; for h in *.h ; do \
		$(CXXWRAP) \
			--jni --jni-attributes \
			--classpath=$(topdir) \
			--package-prefix=$(PKG).tst $$h ; done )

# default goal
cuda: $(C3POBJ)

test: $(GPUDLL)

.PHONY: all cuda test clean tidy
.SUFFIXES: .cxx .dll .so

vpath %.cpp $(srcdir)

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

clean:
	rm -f $(C3POBJ) $(TSTOBJ)

tidy: clean
	rm -f $(TSTSRC) $(TSTCLS)
	rm -f $(GPUDLL)
