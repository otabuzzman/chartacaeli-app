ifeq ($(OS),Windows_NT)
	winos := 1
else
	linos := 1
endif

# AA+ V1.73
DST = aaplus
JNI = caa

PKG = chartacaeli.$(JNI)

# top-level diretory is current minus package (e.g. /foo/bar/hot minus bar.hot yields /foo)
topdir = $(subst $(subst .,/,$(PKG)),,$(CURDIR))
srcdir = src

AAZIP = $(DST).zip
AAURL = http://www.naughter.com/download/$(AAZIP)
ifdef winos
AADLL = $(DST).dll
AAEXE = AATest.exe

CAADLL = $(JNI).dll
else
AADLL = lib$(DST).so
AAEXE = AATest

CAADLL = lib$(JNI).so
endif

# default goal
$(srcdir): $(AAZIP)
	unzip -o `basename $(AAURL)` -d $@
	# pre-process and rename header files to avoid no classes found errors of CXXWRAP
	( cd $(srcdir) ; for h in AA[!+]*.h ; do $(CXX) -E $$h |\
		sed -e s,constexpr,, -e s,noexcept,, -e s,class.*DAY_OF_WEEK,DAY_OF_WEEK, > ../C$$h ; done )
	for h in C*.h ; do \
		$(CXXWRAP) --verbose \
			--jni --jni-attributes \
			--classpath=$(topdir) \
			--package-prefix=$(PKG) $$h ; done
	# restore original header files due to redefined type errors of CXX
	( cd $(srcdir) ; for h in AA[!+]*.h ; do ln -f $$h ../C$$h ; done )

AADLLSRC = $(filter-out $(srcdir)/AATest.cpp $(srcdir)/stdafx.cpp,$(wildcard $(srcdir)/*.cpp))
AADLLOBJ = $(patsubst $(srcdir)/%.cpp,%.o,$(AADLLSRC))

CAADLLOBJ = $(subst .cxx,.o,$(wildcard *_jni.cxx))
CAADLLOBJ := $(filter-out _%,$(CAADLLOBJ))

.PHONY: all clean lclean rclean tidy
.SUFFIXES: .cxx .dll .so

vpath %.cpp $(srcdir)

ifdef winos
.cpp.o:
	$(CXX) -Wall -shared -c $< -o $@

.cxx.o:
	$(CXX) -Wall -shared \
	-I"$(JAVA_HOME)/include" \
	-I"$(JAVA_HOME)/include/win32" \
	-I. -I$(srcdir) \
	-c $< -o $@

$(CAADLL): $(AADLL) $(CAADLLOBJ)
	$(CXX) -Wall -shared \
	-o $@ $(CAADLLOBJ) \
	-L. -l$(DST)
else
.cpp.o:
	$(CXX) -std=gnu++11 -Wall -shared -fPIC -c $< -o $@

.cxx.o:
	$(CXX) -std=gnu++11 -Wall -shared -fPIC \
	-I$(JAVA_HOME)/include \
	-I$(JAVA_HOME)/include/linux \
	-I. -I$(srcdir) \
	-c $< -o $@

$(CAADLL): $(AADLL) $(CAADLLOBJ)
	$(CXX) -Wall -shared \
	-o $@ $(CAADLLOBJ) \
	-L. -l$(DST)
endif

$(AAZIP):
	wget -q -O $@ $(AAURL)

$(AADLL): $(AADLLOBJ)
	$(CXX) -Wall -shared \
	-o $@ $^

$(AAEXE): AATest.o $(AADLL)
	$(CXX) -o $@ $< -L. -l$(DST)

all: $(CAADLL)

# compiler objects
clean:
	rm -f *.o

# local clean
lclean: clean
	# restrict removal of header files on those found in $(srcdir) 
	( cd $(srcdir) ; for h in AA[^+]*.h ; do rm -f ../C$$h ; done )
	rm -rf $(srcdir)
	# derive Java classes from .cxx files
	rm -f $(subst _jni.cxx,.java,$(wildcard *_jni.cxx))
	rm -f $(wildcard *_jni.cxx)
	rm -f $(AADLL) $(CAADLL) $(AAEXE)

# real clean
rclean: lclean
	rm -rf $(AAZIP)

tidy: rclean
