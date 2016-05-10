# CHARTA CAELI
---
A tool to make star charts. Just define your star chart in XML and run the tool. If all goes well you end up with a PDF of your chart. The main purpose of Charta Caeli was to practise Java and related concepts. There are a couple of samples in the lab directory. Read them run them and take a look at the results. Questions? Question!

### Concept

Charta Caeli reads definitions of star charts from XML files. These definition files must match a model given in XSD. The model is designed to allow chart definitions in common terms. Almost every metrics and other more technical information provides a preferences file. Finally there is a properties file to support different languages. Processing these files the tool generates Postscript code on stdout. Pipe it to Ghostscript (e.g.) to get PDF.

###  Build on Windows

- Download and install [Cygwin](http://cygwin.com/). Consider a full install to avoid problems due to missing packages. Make sure that gcc, g++, mingw, flex, bison and make are installed as well as bzip, gzip, unzip and wget.
- Download and compile [CXXWRAP](http://sourceforge.net/projects/cxxwrap/).
- Download and install [JDK7](http://www.oracle.com/technetwork/java/javase/downloads/index.html).
- Download and install [Ghostscript](http://ghostscript.com/download/).
- Run a bash (Cygwin) and set shell variables:

  `CXX` to mingw C++ compiler.<br>
  `CXXWRAP` to cxxwrap.exe.<br>
  `JDK` to JDK7 installation directory.<br>
  Extend `PATH` with . and lib.<br>
  Extend `PATH` with mingw bin directory.

  Commands for setting variables with common values:
  ```
  export CXX=x86_64-w64-mingw32-c++.exe
  export CXXWRAP=/usr/src/cxxwrap-20061217/cxxwrap.exe
  export JDK="/cygdrive/c/program\ files/java/jdk1.7.0_71"
  export PATH=.:lib:/usr/x86_64-w64-mingw32/sys-root/mingw/bin:$PATH
  ```
- Clone Charta Caeli from GitHub to local computer.
- Change directory (bash) to top-level directory of Charta Caeli.
- Run build commands:

  ```
  cd caa
  make all
  cd ..
  make all
  ```
- Read and run the samples:

  ```  
  for sample in \
	layout-and-text \
	unicode-and-fonts \
	field-of-view \
	variables-and-expressions \
	milkyway-with-catalogds9 \
	azimuthal-projection ; do ( make ${sample}.pdf ) ; done
  ```

  Registry errors might occur during the first run without administrator priviliges. In that case run the tool once in a bash with admin rights. Further executions can be done with user rights.

### Build on Linux

Not done yet.
