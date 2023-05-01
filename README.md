# CHARTA CAELI
A tool to make star charts. Just define your star chart in XML and run the tool. If all goes well you end up with a PDF of your chart. The main purpose of Charta Caeli was to practise Java and related concepts. There are a couple of samples available in the repository. Read them run them and take a look at the results. Questions? Question!

## Concept
Charta Caeli reads definitions of star charts from XML files. These definition files must match a model given in XSD. The model is designed to allow chart definitions in common terms. Any metrics and other more technical information is in a preferences file. Finally there are property files to support different languages. Putting these files together the tool generates Postscript code on its stdout. Pipe it to Ghostscript (e.g.) to get PDF.

## Build
Charta Caeli is a Java application with some C/C++ and [CUDA](https://en.wikipedia.org/wiki/CUDA) (Compute Unified Device Architecture) modules accessed via [JNI](https://www.google.de/search?q=oracle+java+native+interface+jni) (Java Native Interface). The build process is entirely controlled from the command line and requires a Linux environment or [Cygwin](https://www.cygwin.com/) in case of Windows. To run the build commands a couple of tools are expected to be installed:

- C/C++ development tools ([GCC](https://gcc.gnu.org/), make, flex, bison etc. and [MinGW](http://www.mingw.org/) if on Windows/ Cygwin)
- Various shell tools (gawk, diff, patch, bzip, gzip, unzip, curl, wget etc.)
- [CXXWRAP](https://github.com/otabuzzman/CXXWRAP) JNI wrapper generator for C++ APIs
- [CUDA Toolkit](https://developer.nvidia.com/cuda-toolkit-archive) to build CUDA programs
- [Java Development Kit](https://www.oracle.com/de/java/technologies/downloads/) (JDK)
- [Apache Maven](https://maven.apache.org/) build tool for Java
- [Ghostscript](http://ghostscript.com/download/) PDF generation program (if on Windows do not use Cygwin package but MSI)
- [ImageMagick](https://www.imagemagick.org/script/download.php) 7 image processing CLI (if on Windows do not use Cygwin package but MSI)

Not required to build but handy anyway:
- [XMLStarlet](http://xmlstar.sourceforge.net/) for CLI based XML manipulation
- [pdf toolkit](https://www.pdflabs.com/tools/pdftk-the-pdf-toolkit/) for CLI based PDF processing

**Linux build commands**

```bash
# setup environment (sample values)
export CXX=g++
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH
export LD_LIBRARY_PATH=.:lib:org/chartacaeli/caa:$LD_LIBRARY_PATH

# ##################################
# # install prerequisites if missing
# ##################################

# install C/C++ development tools
sudo yum groupinstall "Development Tools"

# install JDK
sudo yum install java-17-openjdk-devel.x86_64

# install Maven
wget -q -O - https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz |\
    ( cd /usr/lib ; sudo tar zxf - )

# install Ghostscript
sudo yum install ghostscript

# install ImageMagick 7
( cd ~/lab ; wget -q https://www.imagemagick.org/download/ImageMagick-7.0.8-27.tar.gz \
&& tar xf ImageMagick-7.0.8-27.tar.gz \
|| echo failed to download or unpack ImageMagick. )
( cd ~/lab/ImageMagick-7.0.8-27 ; ./configure ; make ; make check ; sudo make install )

# install Git shell
sudo yum install git

# ######################
# # end of prerequisites
# ######################

# Clone Charta Caeli
cd ~/lab ; git clone https://github.com/otabuzzman/chartacaeli-app.git ; cd chartacaeli-app

( cd org/chartacaeli/caa ; make -j )
( cd org/chartacaeli/gpu ; make )
make
make classes
```

**Windows build commands**

```bash
# setup environment (sample values)
export CXX=x86_64-w64-mingw32-c++.exe
export PATH=/usr/x86_64-w64-mingw32/sys-root/mingw/bin:$PATH
export JAVA_HOME=/cygdrive/c/program\ files/java/jdk-17
export PATH=$JAVA_HOME/bin:$PATH
export PATH=.:lib:org/chartacaeli/caa:$PATH

# Clone Charta Caeli core application
cd ~/src ; git clone https://github.com/otabuzzman/chartacaeli-app.git ; cd chartacaeli-app

( cd org/chartacaeli/caa ; make -j )
( cd org/chartacaeli/gpu ; make )
make
make classes
```

### PJ2 and CUDA
Charta Caeli utilizes the [Parallel Java 2 Library](https://www.cs.rit.edu/~ark/pj2.shtml) (PJ2) to enable Java code for parallel execution on multiple cores and GPU devices. To achieve the latter PJ2 provides a JNI implementation for CUDA. The bad news is you have to build it yourself but it's quite simple: just download the PJ2 source, run the compiler and put the JNI somewhere your JVM can pick it up.

**Build PJ2 CUDA JNI on Linux**

```bash
# setup environment (sample values)
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export CUDA_HOME=/usr/local/cuda
export PATH=$JAVA_HOME/bin:$PATH

# download an unpack PJ2 source
( cd ~/lab ; wget -q \
	-O pj2src.jar https://www.cs.rit.edu/~ark/pj2src_20190611.jar \
	&& jar xf pj2src.jar \
	|| echo failed to download or unpack PJ2 source. )

# build and install JNI
( cd ~/lab/pj2/lib ; gcc -Wall -shared -fPIC \
	-I$JAVA_HOME/include \
	-I$JAVA_HOME/include/linux \
	-I$CUDA_HOME/include \
	-o libEduRitGpuCuda.so edu_rit_gpu_Cuda.c \
	-L$CUDA_HOME/lib64 -lcudart \
	&& install -m 755 libEduRitGpuCuda.so ~/lab/chartacaeli-app/lib \
	|| echo failed to compile or install libEduRitGpuCuda.so )
```

**Build PJ2 CUDA JNI on Windows**

```bash
# setup environment (sample values)
export JAVA_HOME=/cygdrive/c/program\ files/java/jdk-17
export CUDA_HOME=/cygdrive/c/program\ files/nvidia\ gpu\ computing\ toolkit/cuda/v12.1
export PATH=$JAVA_HOME/bin:$PATH

# download an unpack PJ2 source
( cd ~/src ; wget -q \
	-O pj2src.jar https://www.cs.rit.edu/~ark/pj2src_20190611.jar \
	&& jar xf pj2src.jar \
	|| echo download PJ2 source failed. )

# build and install JNI
( cd ~/src/pj2/lib ; nvcc -shared \
	-I"$(cygpath -w "$JAVA_HOME/include")" \
	-I"$(cygpath -w "$JAVA_HOME/include/win32")" \
	-I"$(cygpath -w "$CUDA_HOME/include")" \
	-o EduRitGpuCuda.dll edu_rit_gpu_Cuda.c \
	-L"$(cygpath -w "$CUDA_HOME/lib/x64")" -lcuda \
	&& install -m 755 EduRitGpuCuda.dll ~/src/chartacaeli-app/lib \
	|| echo failed to compile EduRitGpuCuda.dll )
```

Things get tricky however if there is no CUDA capable device. Apart from the fact that a CUDA program cannot execute without a device, there might still be the wish to build a CUDA kernel anyway, for example to carry it to a different environment. In that case you have to install the CUDA Toolkit manually because the installer expects a device. There is a potentially helpful [repository](https://github.com/otabuzzman/cudacons) dealing with this in a certain way.

Charta Caeli best supports building kernels on Linux. Windows requires more manual steps. Have a look at the `README.md` file and the code in package `org.chartacaeli.gpu` of this repository to find out more about building a CUDA kernel for Charta Caeli to boost image processing of class `org.chartacaeli.Artwork`.

## Check
For a rough check if a build works as expected just run the samples and compare the resulting PDF files with those contained in the repository.

The samples - especially `unicode-and-fonts` - make use of the [Arial Unicode MS](https://en.wikipedia.org/wiki/Arial_Unicode_MS) font which contains a quite comprehensive collection of Unicode glyphs. Formerly the font was part of the Microsoft Office distribution. Find and get a copy of the font file `ARIALUNI.TTF` from somewhere and save it in the top-level directory.

Charta Caeli makes use of the [Java Preferences API](https://docs.oracle.com/javase/8/docs/technotes/guides/preferences/overview.html). It stores default values of any variable in the `system` tree. To set it up you need to initialize it as a superuser once before the first run on a computer.

```bash
# init system prefs after 1st build as superuser

# simulate sudo on Windows/ Cygwin
alias sudo='cygstart --action=runas'

sudo "$JAVA_HOME/bin/java" org.chartacaeli.PreferencesTool tree=system command=update chartacaeli.preferences
```

```bash
# clear user prefs
java org.chartacaeli.PreferencesTool tree=user command=delete

# run the samples
for sample in \
	layout-and-text \
	unicode-and-fonts \
	field-of-view \
	variables-and-expressions \
	milkyway-with-catalogds9 \
	azimuthal-projection ; do ( ( make ${sample}.pdf ) & ) ; done
```

Compare and save results to PNG files. Deviating pixels are marked by color.

```bash
# compare samples
for sample in \
	layout-and-text \
	unicode-and-fonts \
	field-of-view \
	variables-and-expressions \
	milkyway-with-catalogds9 \
	azimuthal-projection ; do \
	( magick compare ${sample}.pdf lab/${sample}.pdf -compose src ${sample}.png ) ; done
```
## Install

**Linux**

Installation requires a user account `ccaeli` with a HOME of `/opt/chartacaeli`.

```bash
# setup environment (sample values)
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH
export PATH=/usr/lib/apache-maven-3.9.1/bin:$PATH

mvn compile

# create Charta Caeli group (if missing)
sudo groupadd ccaeli
# create Charta Caeli user (if missing)
sudo mkdir -pm 0775 /opt/chartacaeli
sudo useradd -c "Charta Caeli" -d /opt/chartacaeli -s /sbin/nologin -g ccaeli ccaeli

sudo -u ccaeli -- bash -c "chmod 775 ~"
sudo -u ccaeli -- make install
```

**Windows/ Cygwin**

User and group are not required. Just create a folder `%USERPROFILE%\opt\chartacaeli` and configure Cygwin to mount `%USERPROFILE%\opt` on `/opt`.

```bash
# setup environment (sample values)
export JAVA_HOME=/cygdrive/c/program\ files/java/jdk-17
export PATH=$JAVA_HOME/bin:$PATH

mvn compile

make install
```

## Run
There are two scripts to ease running Charta Caeli on Linux and Windows. Both scripts, `chatacaeli.sh` and `chartacaeli.bat`, must exec in `/opt/chartacaeli/web/WEB-INF` folder. When on Windows/ Cygwin the Linux script can be used as well, but a special setup is required. Below are examples for the various cases.

A special font (`ARIALUNI.TTF`) is assumed to live in `/opt/chartacaeli`. The JVM executable is expected to be in PATH.

Run unicode-and-fonts sample on **Linux**

```bash
# unicode-and-fonts sample depends on layout-and-text
java org.chartacaeli.PreferencesTool tree=user command=update lab/layout-and-text.preferences

export GS_FONTPATH=/opt/chartacaeli
( cd /opt/chartacaeli/web/WEB-INF ; ./chartacaeli.sh -k ~/lab/chartacaeli-app/lab/unicode-and-fonts.xml |\
	${GS:-gs} -q -dBATCH -dNOPAUSE -dNOSAFER -sDEVICE=pdfwrite -sOutputFile=/tmp/unicode-and-fonts.pdf - )
```

Run unicode-and-fonts sample on **Windows**:

```cmd
set GS_FONTPATH=%USERPROFILE%\opt\chartacaeli
cd %USERPROFILE%\opt\chartacaeli\web\WEB-INF
chartacaeli.bat /k /v %USERPROFILE%\src\chartacaeli-app\lab\unicode-and-fonts.xml
```

Run unicode-and-fonts sample on **Windwos/ Cygwin** using Linux script:

```bash
install -m 755 chartacaeli.sh /opt/chartacaeli/web/WEB-INF

( cd /opt/chartacaeli/web/WEB-INF ;
PATH=lib:/usr/x86_64-w64-mingw32/sys-root/mingw/bin:$PATH \
CLASSPATH=$(cygpath -mp classes:lib:lib/*) \
GS_FONTPATH=$(cygpath -mp /opt/chartacaeli) \
./chartacaeli.sh -kv $(cygpath -m ~/src/chartacaeli-app/lab/unicode-and-fonts.xml) )
```

## Model or Java updates
After an update of the XSD model, new Java source files must be generated. While compiling these, Java reports various warnings or errors due to deprecated or removed features. This is because the work on Castor has long ended and newer Java standards are thus not supported. Fixing these issues is a manual task.
```
# remove old
rm -r model
# create new
make model

make classes # fix warnings and errors manually
```
Updates to newer Java versions may also report warnings or errors during compilation.

## Helpful links
- [Sample Pages](http://www.skymaps.com/store/samples/Millennium%20Star%20Atlas.pdf) from The Millenium Star Atlas
- The [User Manual](https://github.com/OSGeo/PROJ/blob/master/docs/old/proj_4_3_12.pdf) of the [PROJ.4](https://github.com/OSGeo/proj.4) Cartographic Projections Library
- [Map Projections - A Working Manual](http://pubs.usgs.gov/pp/1395/report.pdf) describing history and mathematics of map projections used by the U.S. Geological Survey
- [An Album Of Map Projections](http://pubs.usgs.gov/pp/1453/report.pdf) containing profiles of many popular projections with general information mathematics and samples
- [Mark's Blog](http://markchensblog.blogspot.de/2012/11/key-keyref-and-unique-in-xsd.html) demonstrates the use of the XSD elements `key`, `keyref` and `unique`
- To interactively play with the features of the [JTS Topology Suite](http://tsusiatsoftware.net/jts/main.html) run `%INSTDIR%\bin\testbuilder.bat`
