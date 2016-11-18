ifeq ($(OS),Windows_NT)
	winos := 1
else
	linos := 1
endif

# AA+ V1.73
JPKG  = caa
CPKG  = aaplus

srcdir  = src

AAZIP = $(CPKG).zip
AAURL = http://www.naughter.com/download/$(AAZIP)
ifdef winos
AADLL = $(CPKG).dll
AAEXE = AATest.exe

JAADLL = $(JPKG).dll
else
AADLL = lib$(CPKG).so
AAEXE = AATest

JAADLL = lib$(JPKG).so
endif
JAAJAR = $(JPKG).jar

# default goal
$(srcdir): $(AAZIP)
	unzip -o `basename $(AAURL)` -d $@
	@echo AAHDR = `find $(srcdir) -name '*.h' -print` >Makefile.d
	@echo AASRC = `find $(srcdir) -name '*.cpp' -print` >>Makefile.d
	# pre-process and rename header files to avoid no classes found errors of CXXWRAP
	( cd $(srcdir) ; for h in AA[!+]*.h ; do $(CXX) -E $$h -o ../C$$h ; done )
	for h in C*.h ; do $(CXXWRAP) --jni --jni-attributes --package-prefix=$(JPKG) $$h ; done
	# restore original header files due to redefined type errors of CXX
	( cd $(srcdir) ; for h in AA[!+]*.h ; do ln -f $$h ../C$$h ; done )
	@echo JNIJSRC = `find $(JPKG) -name 'C*.java' -print` >>Makefile.d

$(AAZIP):
	wget -q -O $@ $(AAURL)

-include Makefile.d

AADLLSRC = $(filter-out $(srcdir)/AATest.cpp $(srcdir)/stdafx.cpp,$(AASRC))
AADLLOBJ = $(patsubst $(srcdir)/%.cpp,%.o,$(AADLLSRC))

JNIJCLS = $(subst .java,.class,$(JNIJSRC))
JNICSRC = $(subst .java,_jni.cxx,$(JNIJSRC))
JNICOBJ = $(subst .cxx,.o,$(JNICSRC))

.PHONY: all clean lclean rclean tidy
.SUFFIXES: .cxx
.SECONDARY:

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
else
.cpp.o:
	$(CXX) -Wall -shared -fPIC -c $< -o $@

.cxx.o:
	$(CXX) -Wall -shared -fPIC \
	-I$(JAVA_HOME)/include \
	-I$(JAVA_HOME)/include/linux \
	-I. -I$(srcdir) \
	-c $< -o $@
endif

$(JAAJAR):
	javac -d . $(JNIJSRC)
	jar -cf $@ `find $(JPKG) -name '*.class' -print`

ifdef winos
$(JAADLL): $(AADLL) $(JNICOBJ)
	$(CXX) -Wall -shared \
	-static-libgcc -static-libstdc++ \
	-o $@ $(JNICOBJ) \
	-L. -l$(CPKG)
else
$(JAADLL): $(JNICOBJ)
	$(CXX) -Wall -shared \
	-o $@ $^ \
	-L. -l$(CPKG)
endif

$(AADLL): $(AADLLOBJ)
	$(CXX) -Wall -shared \
	-o $@ $^

$(AAEXE): AATest.o $(AADLL)
	$(CXX) -o $@ $< -L. -l$(CPKG)

all: $(JAADLL) $(JAAJAR)

# compiler objects
clean:
	rm -f $(AADLLOBJ) AATest.o $(JNICOBJ)
	find $(JPKG) -name '*.class' -exec rm -f {} \;

# local clean
lclean: clean
	rm -rf $(srcdir) $(JPKG)
	rm -f C*.h Makefile.d
	rm -f $(AADLL) $(AAEXE) $(JAADLL) $(JAAJAR)

# real clean
rclean: lclean
	rm -rf $(AAZIP)

tidy: rclean
