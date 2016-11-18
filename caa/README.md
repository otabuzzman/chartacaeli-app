# Astronomical Algorithms in Java
---
A Java wrapper for the [AA+](http://www.naughter.com/aa.html) library written by PJ Naughter. AA+ is a comprehensive C++ implementation of astronomical algorithms presented by Jean Meeus in his book [Astronomical Algorithms](http://www.willbell.com/math/mc1.htm).

### Concept

The [CXXWRAP](http://sourceforge.net/projects/cxxwrap/) tool is used to generate JNI and Java files from the C++ header files automaticaly. Some post-processing is necessary in cases of header file names that do not match the names of the C++ classes they define. Search the `Makefile` for sections embraced by comments that start with `# pragma` to see the details.

###  Build

Read and follow instructions in file `README.md` in parent directory.
