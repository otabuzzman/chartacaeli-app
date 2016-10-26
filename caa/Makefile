ifeq ($(OS),Windows_NT)
	winos := 1
else
	linos := 1
endif

# AA+ V1.73
JPKG  = caa
CPKG  = aaplus

srcdir  = $(CPKG)
pkgdir  = $(JPKG)

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

.PHONY: all clean tidy
.SUFFIXES: .cxx .java .class

aahdr = $(wildcard $(srcdir)/AA[!+]*.h)
aasrc = $(filter-out $(srcdir)/AATest.cpp,$(wildcard $(srcdir)/AA*.cpp))
aaobj = $(patsubst $(srcdir)/%.cpp,%.o,$(aasrc))

jaahdr = $(patsubst $(srcdir)/%.h,$(pkgdir)/C%.h,$(aahdr))



# pragma vars begin (see pragma rules below)
jaasrcexc = %_EAR.java \
%_MAR.java \
%_MER.java \
%_NEP.java \
%_JUP.java \
%_SAT.java \
%_SUN.java \
%_URA.java \
%_VEN.java \
%CAAVSOP87.java
jaasrcdir = $(filter-out $(jaasrcexc),$(patsubst $(pkgdir)/%.h,$(pkgdir)/%.java,$(jaahdr)))
jaasrcind = $(pkgdir)/CAAVSOP87_Jupiter.java \
$(pkgdir)/CAAVSOP87_Mars.java \
$(pkgdir)/CAAVSOP87_Mercury.java \
$(pkgdir)/CAAVSOP87_Neptune.java \
$(pkgdir)/CAAVSOP87_Saturn.java \
$(pkgdir)/CAAVSOP87_Uranus.java \
$(pkgdir)/CAAVSOP87_Venus.java \
$(pkgdir)/CAAVSOP87A_Earth.java \
$(pkgdir)/CAAVSOP87A_Jupiter.java \
$(pkgdir)/CAAVSOP87A_Mars.java \
$(pkgdir)/CAAVSOP87A_Mercury.java \
$(pkgdir)/CAAVSOP87A_Neptune.java \
$(pkgdir)/CAAVSOP87A_Saturn.java \
$(pkgdir)/CAAVSOP87A_Uranus.java \
$(pkgdir)/CAAVSOP87A_Venus.java \
$(pkgdir)/CAAVSOP87B_Earth.java \
$(pkgdir)/CAAVSOP87B_Jupiter.java \
$(pkgdir)/CAAVSOP87B_Mars.java \
$(pkgdir)/CAAVSOP87B_Mercury.java \
$(pkgdir)/CAAVSOP87B_Neptune.java \
$(pkgdir)/CAAVSOP87B_Saturn.java \
$(pkgdir)/CAAVSOP87B_Uranus.java \
$(pkgdir)/CAAVSOP87B_Venus.java \
$(pkgdir)/CAAVSOP87C_Earth.java \
$(pkgdir)/CAAVSOP87C_Jupiter.java \
$(pkgdir)/CAAVSOP87C_Mars.java \
$(pkgdir)/CAAVSOP87C_Mercury.java \
$(pkgdir)/CAAVSOP87C_Neptune.java \
$(pkgdir)/CAAVSOP87C_Saturn.java \
$(pkgdir)/CAAVSOP87C_Uranus.java \
$(pkgdir)/CAAVSOP87C_Venus.java \
$(pkgdir)/CAAVSOP87D_Earth.java \
$(pkgdir)/CAAVSOP87D_Jupiter.java \
$(pkgdir)/CAAVSOP87D_Mars.java \
$(pkgdir)/CAAVSOP87D_Mercury.java \
$(pkgdir)/CAAVSOP87D_Neptune.java \
$(pkgdir)/CAAVSOP87D_Saturn.java \
$(pkgdir)/CAAVSOP87D_Uranus.java \
$(pkgdir)/CAAVSOP87D_Venus.java \
$(pkgdir)/CAAVSOP87E_Earth.java \
$(pkgdir)/CAAVSOP87E_Jupiter.java \
$(pkgdir)/CAAVSOP87E_Mars.java \
$(pkgdir)/CAAVSOP87E_Mercury.java \
$(pkgdir)/CAAVSOP87E_Neptune.java \
$(pkgdir)/CAAVSOP87E_Saturn.java \
$(pkgdir)/CAAVSOP87E_Sun.java \
$(pkgdir)/CAAVSOP87E_Uranus.java \
$(pkgdir)/CAAVSOP87E_Venus.java
# pragma vars end



jaasrc = $(jaasrcdir) $(jaasrcind)
jaaobj = $(patsubst $(pkgdir)/%.java,$(pkgdir)/%_jni.o,$(jaasrc))
jaacls = $(patsubst $(pkgdir)/%.java,$(pkgdir)/%.class,$(jaasrc))

vpath %.cpp $(srcdir)
vpath %.cxx $(pkgdir)
vpath %.java $(pkgdir)

ifdef winos
.cpp.o:
	$(CXX) -Wall -shared -c $< -o $@
else
.cpp.o:
	$(CXX) -Wall -shared -fPIC -c $< -o $@
endif

.h.cxx:
.h.java:
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<

ifdef winos
.cxx.o:
	$(CXX) -Wall -shared \
	-I"$(JAVA_HOME)/include" \
	-I"$(JAVA_HOME)/include/win32" \
	-I$(srcdir) \
	-c $< -o $@
else
.cxx.o:
	$(CXX) -Wall -shared -fPIC \
	-I$(JAVA_HOME)/include \
	-I$(JAVA_HOME)/include/linux \
	-I$(srcdir) \
	-c $< -o $@
endif

.java.class:
	javac -d . $<

$(AAZIP):
	wget -q -O $@ $(AAURL)

$(srcdir): $(AAZIP)
	unzip -o `basename $(AAURL)` -d $@

$(pkgdir):
	mkdir $@

all: $(srcdir) $(pkgdir)
	make $(AADLL) $(AAEXE) $(JAADLL) $(JAAJAR)

$(aaobj): %.o: $(srcdir)/%.cpp

ifdef winos
$(AADLL): $(aaobj)
	$(CXX) -Wall -shared \
	-Wl,--export-all-symbols -Wl,--add-stdcall-alias \
	-o $@ $(aaobj)
else
$(AADLL): $(aaobj)
	$(CXX) -Wall -shared -fPIC \
	-o $@ $(aaobj)
endif

$(AAEXE): AATest.o stdafx.o $(AADLL)
	$(CXX) -o $@ $< -L. -l$(CPKG)

$(jaahdr): $(pkgdir)/C%.h: $(srcdir)/%.h
	$(CXX) -E -I$(srcdir) $< -o $@

$(jaaobj): $(pkgdir)/%.o: $(pkgdir)/%.cxx

ifdef winos
$(JAADLL): $(jaahdr) $(jaasrc) $(jaaobj)
	$(CXX) -Wall -shared \
	-static-libgcc -static-libstdc++ \
	-Wl,--export-all-symbols -Wl,--add-stdcall-alias \
	-o $@ $(jaaobj) \
	-L. -l$(CPKG)
else
$(JAADLL): $(jaahdr) $(jaasrc) $(jaaobj)
	$(CXX) -Wall -shared -fPIC \
	-o $@ $(jaaobj) \
	-L. -l$(CPKG)
endif

$(JAAJAR): $(jaacls)
	jar -cf $@ $(jaacls)

# compiler objects
clean:
	rm -f $(aaobj) AATest.o stdafx.o $(jaaobj) $(pkgdir)/*.class

# local clean
lclean: clean
	rm -f $(pkgdir)/*.h $(pkgdir)/*.cxx $(pkgdir)/*.java
	rm -f $(AADLL) $(AAEXE) $(JAADLL) $(JAAJAR)
	rm -rf $(srcdir) $(pkgdir)

# real clean
rclean: lclean
	rm -rf $(AAZIP)

tidy: rclean



# pragma rules begin
$(pkgdir)/CAAVSOP87_Jupiter.java: $(pkgdir)/CAAVSOP87_JUP.h
$(pkgdir)/CAAVSOP87_Mars.java: $(pkgdir)/CAAVSOP87_MAR.h
$(pkgdir)/CAAVSOP87_Mercury.java: $(pkgdir)/CAAVSOP87_MER.h
$(pkgdir)/CAAVSOP87_Neptune.java: $(pkgdir)/CAAVSOP87_NEP.h
$(pkgdir)/CAAVSOP87_Saturn.java: $(pkgdir)/CAAVSOP87_SAT.h
$(pkgdir)/CAAVSOP87_Uranus.java: $(pkgdir)/CAAVSOP87_URA.h
$(pkgdir)/CAAVSOP87_Venus.java: $(pkgdir)/CAAVSOP87_VEN.h
$(pkgdir)/CAAVSOP87A_Earth.java: $(pkgdir)/CAAVSOP87A_EAR.h
$(pkgdir)/CAAVSOP87A_Jupiter.java: $(pkgdir)/CAAVSOP87A_JUP.h
$(pkgdir)/CAAVSOP87A_Mars.java: $(pkgdir)/CAAVSOP87A_MAR.h
$(pkgdir)/CAAVSOP87A_Mercury.java: $(pkgdir)/CAAVSOP87A_MER.h
$(pkgdir)/CAAVSOP87A_Neptune.java: $(pkgdir)/CAAVSOP87A_NEP.h
$(pkgdir)/CAAVSOP87A_Saturn.java: $(pkgdir)/CAAVSOP87A_SAT.h
$(pkgdir)/CAAVSOP87A_Uranus.java: $(pkgdir)/CAAVSOP87A_URA.h
$(pkgdir)/CAAVSOP87A_Venus.java: $(pkgdir)/CAAVSOP87A_VEN.h
$(pkgdir)/CAAVSOP87B_Earth.java: $(pkgdir)/CAAVSOP87B_EAR.h
$(pkgdir)/CAAVSOP87B_Jupiter.java: $(pkgdir)/CAAVSOP87B_JUP.h
$(pkgdir)/CAAVSOP87B_Mars.java: $(pkgdir)/CAAVSOP87B_MAR.h
$(pkgdir)/CAAVSOP87B_Mercury.java: $(pkgdir)/CAAVSOP87B_MER.h
$(pkgdir)/CAAVSOP87B_Neptune.java: $(pkgdir)/CAAVSOP87B_NEP.h
$(pkgdir)/CAAVSOP87B_Saturn.java: $(pkgdir)/CAAVSOP87B_SAT.h
$(pkgdir)/CAAVSOP87B_Uranus.java: $(pkgdir)/CAAVSOP87B_URA.h
$(pkgdir)/CAAVSOP87B_Venus.java: $(pkgdir)/CAAVSOP87B_VEN.h
$(pkgdir)/CAAVSOP87C_Earth.java: $(pkgdir)/CAAVSOP87C_EAR.h
$(pkgdir)/CAAVSOP87C_Jupiter.java: $(pkgdir)/CAAVSOP87C_JUP.h
$(pkgdir)/CAAVSOP87C_Mars.java: $(pkgdir)/CAAVSOP87C_MAR.h
$(pkgdir)/CAAVSOP87C_Mercury.java: $(pkgdir)/CAAVSOP87C_MER.h
$(pkgdir)/CAAVSOP87C_Neptune.java: $(pkgdir)/CAAVSOP87C_NEP.h
$(pkgdir)/CAAVSOP87C_Saturn.java: $(pkgdir)/CAAVSOP87C_SAT.h
$(pkgdir)/CAAVSOP87C_Uranus.java: $(pkgdir)/CAAVSOP87C_URA.h
$(pkgdir)/CAAVSOP87C_Venus.java: $(pkgdir)/CAAVSOP87C_VEN.h
$(pkgdir)/CAAVSOP87D_Earth.java: $(pkgdir)/CAAVSOP87D_EAR.h
$(pkgdir)/CAAVSOP87D_Jupiter.java: $(pkgdir)/CAAVSOP87D_JUP.h
$(pkgdir)/CAAVSOP87D_Mars.java: $(pkgdir)/CAAVSOP87D_MAR.h
$(pkgdir)/CAAVSOP87D_Mercury.java: $(pkgdir)/CAAVSOP87D_MER.h
$(pkgdir)/CAAVSOP87D_Neptune.java: $(pkgdir)/CAAVSOP87D_NEP.h
$(pkgdir)/CAAVSOP87D_Saturn.java: $(pkgdir)/CAAVSOP87D_SAT.h
$(pkgdir)/CAAVSOP87D_Uranus.java: $(pkgdir)/CAAVSOP87D_URA.h
$(pkgdir)/CAAVSOP87D_Venus.java: $(pkgdir)/CAAVSOP87D_VEN.h
$(pkgdir)/CAAVSOP87E_Earth.java: $(pkgdir)/CAAVSOP87E_EAR.h
$(pkgdir)/CAAVSOP87E_Jupiter.java: $(pkgdir)/CAAVSOP87E_JUP.h
$(pkgdir)/CAAVSOP87E_Mars.java: $(pkgdir)/CAAVSOP87E_MAR.h
$(pkgdir)/CAAVSOP87E_Mercury.java: $(pkgdir)/CAAVSOP87E_MER.h
$(pkgdir)/CAAVSOP87E_Neptune.java: $(pkgdir)/CAAVSOP87E_NEP.h
$(pkgdir)/CAAVSOP87E_Saturn.java: $(pkgdir)/CAAVSOP87E_SAT.h
$(pkgdir)/CAAVSOP87E_Sun.java: $(pkgdir)/CAAVSOP87E_SUN.h
$(pkgdir)/CAAVSOP87E_Uranus.java: $(pkgdir)/CAAVSOP87E_URA.h
$(pkgdir)/CAAVSOP87E_Venus.java: $(pkgdir)/CAAVSOP87E_VEN.h

%_Earth.java: %_EAR.h
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<
%_Jupiter.java: %_JUP.h
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<
%_Mars.java: %_MAR.h
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<
%_Mercury.java: %_MER.h
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<
%_Neptune.java: %_NEP.h
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<
%_Saturn.java: %_SAT.h
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<
%_Sun.java: %_SUN.h
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<
%_Uranus.java: %_URA.h
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<
%_Venus.java: %_VEN.h
	$(CXXWRAP) --jni --jni-attributes --root=$(pkgdir) --package-prefix=$(JPKG) $(<F)
	ln -f $(srcdir)/$(subst CAA,AA,$(<F)) $<
# pragma rules end
