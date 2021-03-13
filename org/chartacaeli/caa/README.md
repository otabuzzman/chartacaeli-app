# Astronomical Algorithms in Java
---
A Java wrapper for the [AA+](http://www.naughter.com/aa.html) library from PJ Naughter. AA+ is a comprehensive C++ implementation of astronomical algorithms presented by Jean Meeus in his book [Astronomical Algorithms](http://www.willbell.com/math/mc1.htm).

### Concept

Manually extending a particular C++ library for use from Java code is tedious and error-prone. This is especially true when the library in question is as large and comprehensive as AA+. Therefore, any support to do this at least partially automatically would be greatly appreciated. However, it seems that there is not much need for such tasks, as few tools are available. [JNAerator](https://github.com/nativelibs4java/JNAerator) and [SWIG](http://www.swig.org/index.php) are two and there is a third called [CXXWRAP](http://sourceforge.net/projects/cxxwrap/) that got the job. Both others could do it too, but CXXWRAP proved it first and that's where it stayed.

CXXWRAP parses header files for C++ class definitions and generates corresponding JNI wrappers consisting of Java and JNI files. The latter are essentially C++ files that function as bridges between Java and the C++ library in question. Each C++ class gets its own Java and JNI file. In case of multiple classes per header file there will be multiple Java/ JNI pairs as well.

A drawback of CXXWRAP is its age. Maintenance ended in 2006 and there is thus no support for C++ features that came afterward. AA+ is under continuous development and conforms of course with modern C++ standards and so there is some tooling around building the wrapper.

The good news is everything's controlled by a Makefile. So we'll be fine as long as there are no significant changes to the sources of AA+. However, for fresh builds or after a `make tidy` the Makefile will download AA+ as it does not contain a copy of AA+. And this is where the bad news comes in: there is only the newest version of AA+ available for download and depending on what changed it might be necessary to adjust the Makefile.

### Update AA+

Depending on what changed in a new version of AA+ the Makefile needs one or more of the following adjustments.

1. Update AA+ version. This is an easy one. Just update the comment `# AA+ V2.21` near the beginning of Makefile accordingly.

2. Update variable `AADLLSRC` with a list of `.cpp` files in AA+. This is simply the output of `ls src/*.cpp` with some postprocessing.
  ```
  # sample AADLLSRC
  # AADLLSRC = \
  # 	$(srcdir)/AAAberration.cpp \
  # 	$(srcdir)/AAAngularSeparation.cpp \
  # 	$(srcdir)/AABinaryStar.cpp \
  # 	... \

  ```

3. Update variable `CAADLLSRC` with a list of `.cxx` files. CXXWRAP generates these JNI code files for class definitions in header files. A pipe with some postprocessing will do.
  ```
  # grep header for class definitions, delete CR, construct and output file name
  grep "class  *AAPLUS_EXT_CLASS" src/*.h | sed 's,\r,,' | gawk '{print $3 "_jni.cxx"}'

  # sample CAADLLSRC
  # CAADLLSRC = \
  # 	CAA2DCoordinate_jni.cxx \
  # 	CAA3DCoordinate_jni.cxx \
  # 	CAAAberration_jni.cxx \
  # 	...\

  ```

4. Update JNI code dependencies. CXXWRAP scans AA+ header files for class definitions. For this to function, the header files must comply with a rather old C++ standard and need therefore some preparation first. The rule `$(tmpdir)/%.h: $(srcdir)/%.h` picks each header from AA+ performs the necessary changes and saves it in a new file to be picked by CXXWRAP. These files are the dependencies to set up in this step. Again, a pipe with some postprocessing will do.
  ```
  # grep header for class definitions, delete CR, construct rule, postprocess and output result
  grep "class  *AAPLUS_EXT_CLASS" src/*.h | sed 's,\r,,' | gawk '{printf("%s_jni.cxx: %s\n",$3, $1)}' | sed -e 's,src/,$(tmpdir)/,' -e 's,:class,,'

  # sample JNI code dependencies
  # CAA2DCoordinate_jni.cxx: $(tmpdir)/AA2DCoordinate.h
  # CAA3DCoordinate_jni.cxx: $(tmpdir)/AA3DCoordinate.h
  # CAAAberration_jni.cxx: $(tmpdir)/AAAberration.h
  # ...

  ```

5. Update AA+ header inter-dependencies. Some header files depend on others. The Makefile must know about this to schedule work in proper order. The C preprocessor helps to find out, as does some post-processing. Run the processor on all AA+ header files and truncate the resulting list to include entries with no dependencies, that is those with the header file being the only prerequisite.
  ```
  g++ -MM src/*.h

  # sample inter-dependencies
  # $(tmpdir)/AACoordinateTransformation.h: $(tmpdir)/AA2DCoordinate.h
  # $(tmpdir)/AADate.h: $(tmpdir)/AADefines.h
  # $(tmpdir)/AADiameters.h: $(tmpdir)/AACoordinateTransformation.h $(tmpdir)/AA2DCoordinate.h
  # ...

  ```

6. Update internal dependencies. Some header files include headers without class definitions. To share their location with the other header files eases compilation. Finding these files is a manual task done by scanning preprocessor output in the previous step. Add an appropriate rule for each.
  ```
  # internal dependency rule for AADefines.h
  # $(tmpdir)/AADefines.h:
  # 	ln $(srcdir)/$(@F) $@

  ```

### Build
1. Download AA+
  ```
  make
  ```

2. Compile JNI code
  ```
  make all
  ```

3. Compile Java
  ```
  cd ../../.. ; make classes
  ```

  Read and follow instructions in file `README.md` in top-level directory of repository.

#### Parallelism
Running make with multiple jobs option demands [proper dependency settings](https://www.cmcrossroads.com/article/pitfalls-and-benefits-gnu-make-parallelization). The Makefile does not allow for parallel execution for the generated JNI code. It works however for AA+. To make use run `make ; make -j $(nproc) aaplus.dll ; make all`.
