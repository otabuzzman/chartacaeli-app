# Astronomical Algorithms in Java
---
A Java wrapper for the [AA+](http://www.naughter.com/aa.html) library from Naughter Software. AA+ is a comprehensive C++ implementation of astronomical algorithms presented by Jean Meeus in his book [Astronomical Algorithms](http://www.willbell.com/math/mc1.htm).

### Concept

Manually extending a particular C++ library for use from Java code is tedious and error-prone. This is especially true when the library in question is as large and comprehensive as AA+. Therefore, any support to do this at least partially automatically would be greatly appreciated. However, it seems that there is not much need for such tasks, as few tools are available. [JNAerator](https://github.com/nativelibs4java/JNAerator) and [SWIG](http://www.swig.org/index.php) are two and there is a third called [CXXWRAP](http://sourceforge.net/projects/cxxwrap/) that got the job. Both others could do it too, but CXXWRAP proved it first and that's where it stayed.

CXXWRAP parses header files for C++ class definitions and generates corresponding JNI wrappers consisting of Java and JNI files. The latter are essentially C++ files that function as bridges between Java and the C++ library in question. Each C++ class gets its own Java and JNI file. In case of multiple classes per header file there will be multiple Java/ JNI pairs as well.

A disadvantage of CXXWRAP is that development stopped in 2006 while AA+ continues to evolve and conform to modern C++ standards. To deal with this, the Charta Caeli project maintains a specialized version of CXXWRAP. It is on GitHub while the original version is hosted on Sourceforge.

### Update AA+ 2.50

1. In Makefile update AA+ version in comment `# AA+ X.XX`.

2. Download the source archive.
  ```
  make tidy # clean-up previous version
  
  make src
  ```

3. Update variable `AADLLSRC` in Makefile with `AA*.cpp` files in AA+.
  ```
  # list C++ source files of AA+ and format them for Makefile.
  (cd src ; ls AA*.cpp | gawk '{ print "\t" "$(srcdir)/" $1 " \\" }')
  ```
  - exclude file `AATest.cpp` (handled by `test` target)
  - exclude file `AAVSOP2013.h` (compilation errors on Winos)
  
4. Create the header files for CXXWRAP. Remove file `AAVSOP2013.h`.
  ```
  make hdr
  ```

5. Create C++ and Java files for JNI.
  ```
  make jni
  ```

6. Update variable `CAADLLSRC` in Makefile with `*.cxx` files generated from CXXWRAP.
  ```
  # list C++ files for JNI and format them for Makefile.
  ls *.cxx | gawk '{ print "\t" $1 " \\" }'
  ```

7. Check `stdout` for lines containing
  - "syntax not parsed correctly"
    Inspect reported header files. Decide to ignore or fix by grammar extension to CXXWRAP or other.
  - "cannot be wrapped"
    Update variable `CXXWRAP_CACHE` in Makefile with files for reported classes if supported by CXXWRAP.

8. Replace enumeration casts (types `DOW`, `Type`) with casts to `static_cast<jint>` in files
  `CAADate_jni.cxx` (type `DOW`),<br>
  `CAAEquinoxSolsticeDetails2_jni.cxx` (type `Type`),<br>
  `CAAMoonMaxDeclinationsDetails2_jni.cxx`,<br>
  `CAAMoonNodesDetails2_jni.cxx`,<br>
  `CAAMoonPerigeeApogeeDetails2_jni.cxx`,<br>
  `CAAMoonPhasesDetails2_jni.cxx`,<br>
  `CAAPlanetPerihelionAphelionDetails2_jni.cxx`,<br>
  `CAAPlanetaryPhenomenaDetails2_jni.cxx`,<br>
  `CAARiseTransitSetDetails2_jni.cxx`

9. Run `make -j` to build libraries

### Acknowledgements
Copyrights (c) 2004, Naughter Software
- You are allowed to include the source code in any product (commercial, shareware, freeware or otherwise) when your product is released in binary form.
- You are allowed to modify the source code in any way you want except you cannot modify the copyright details at the top of each module.
- If you want to distribute source code with your application, then you are only allowed to distribute versions released by the author. This is to maintain a single distribution point for the source code.
