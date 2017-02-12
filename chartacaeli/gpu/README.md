# CUDA implementation of *Artwork*
The class *Artwork* draws artistic images of star signs on the star chart. A *for-loop* handles the images sequentially pixel by pixel. The aim is to substitute the loop by a CUDA kernel and thus parallelize it. Tool of choice is [Parallel Java 2 Library](https://www.cs.rit.edu/~ark/pj2.shtml) (PJ2) which acts as a bridge from Java to CUDA and vice versa. PJ2 allows to run a CUDA kernel from a Java application. With PJ2 the parallelization of Java classes is essentially reduced to kernel development. At least in terms of coding. Note however that PJ2 does not change the basic procedure for the [parallelization of existing sequential software](http://alecu.ase.ro/conferences/conf_2003_cluj.pdf).

### Approach
Find the code suitable to parallization (the *for-loop* mentioned above). Get familiar with PJ2 by using it to enable the *for-loop* to make use of multiple cores. That is turning a sequentional Java application into one that makes use of Symmetric Multiprocessing. Find the Java objects used or referenced by the *for-loop* and implement them as C/C++ peer objects (C3P) to get used by the CUDA kernel later. Note that there is no way to run STDL on a CUDA capable device (search Google for "[*STDL functions on CUDA device*](https://www.google.de/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=STDL+functions+on+CUDA+device)"). Assure C3P and corresponding Java objects work identically. Use JNI for instance to make C3P objects available inside Java and define [JUnit](http://junit.org/junit4/) test cases that compares results of a given C3P with it's corresponding Java object. Another approach could be to use JUnit on the Java side, implement a different unit test subsystem for C3P objects ([googletest](https://github.com/google/googletest/blob/master/googletest/docs/Primer.md) for instance) and finally compare the results by using some shell tools. Prepare writing the CUDA kernel. Consider a pseudo-kernel before the real one to make sure C3P objects work as expected when tied together to a single program (see section on experimental classes below). This pseudo-kernel is a regular C/C++ program mimicking the actual CUDA kernel. There is no CUDA code in it. Derive CUDA code from C3P modules so that there is a derived CUDA peer (DCP) for each C3P. Implement a `main` function in each C3P performing an arbitrary test for some functions (or even all) of the C3P in question. Implement a real kernel in each DCP perfoming the same test as the corresponding C3P does. Assure equal results. Write the kernel.

### Notes on C3P and DCP test programs
There will be linker errors in case of modules (both C3P and DCP) that depend on others (e.g. *Coordinate* depends on *Math*). These errors are due to the fact that each module defines a global `main` function. To come around this there is a preprocessor constant that controls which `main` to compile. For *Math* the constant is `MATH_MAIN` for *Vector3D* it's `VECTOR3D_MAIN`. Same linker errors will occur if building a program that depends on one (or more) that has been build before. To avoid this remove artefacts of previous build(s).
```
# build C3P test program
make CXXFLAGS=-DCOORDINATE_MAIN c3pclean c3p/Coordinate
# build DCP pendant
make CXXFLAGS=-DCOORDINATE_MAIN dcpclean dcp/Coordinate
# capture stdout
c3p/Coordinate >c3p/Coordinate.3
dcp/Coordinate >dcp/Coordinate.C
# compare results
cmp c3p/Coordinate.3 dcp/Coordinate.C
```

```
# build and run DCP test programs automatically
( set -e ; for p in Coordinate Vector3D Plane Math RealMatrix P4Mollweide P4Orthographic P4Stereographic ; do
	cxxflags=CXXFLAGS=-D`echo $p | tr [[a-z]] [[A-Z]]`_MAIN
	make $cxxflags c3pclean c3p/$p
	make $cxxflags dcpclean dcp/$p
	c3p/$p >c3p/$p.out
	dcp/$p >dcp/$p.out
	cmp c3p/$p.out dcp/$p.out && ( echo $p : OK ; rm -f c3p/$p.out dcp/$p.out )
done )
```

### Notes on C3P test classes
There are JUnit test classes for some of the C3P objects. Those without are utilized by the others and thus implicitly tested.
```
# build all C3P test classes
make testbuild
# run 'em all
make testrun
```

### Notes on test data
Datasets should contain random values and limits. Latter depend on the test case. Limits for latitude are 90 and -90 degrees for instance. Random values depend on the test case as well. The utility class *RandomDataset* generates pseudo-random values.
```
# to show usage of RandomDataset class run
java -classpath "chartacaeli;" chartacaeli.gpu.tst.RandomDataset

# test data generation example for pseudocylindrical projection classes (e.g. P4Mollweide)
# 8 records, 2 elements ranging from -180 to 360 and -90 to 90 degress, 8 decimals
java -classpath "chartacaeli;" chartacaeli.gpu.tst.RandomDataset 8 8 -180 540 -90 90

# test data generation example for azimuthal projection classes (e.g. P4Orthographic)
# 8 records, 2 elements ranging from -180 to 360 and 0 to 90 degress, 8 decimals
java -classpath "chartacaeli;" chartacaeli.gpu.tst.RandomDataset 8 8 -180 360 0 90

# test data generation examples for RealMatrix class
# 3 records, 3 elements ranging from -1 to 1, 8 decimals (3D matrix)
java -classpath "chartacaeli;" chartacaeli.gpu.tst.RandomDataset 8 3 -1 2 -1 2 -1 2
# 4 records, 4 elements ranging from -1 to 1, 8 decimals (4D matrix)
java -classpath "chartacaeli;" chartacaeli.gpu.tst.RandomDataset 8 4 -1 2 -1 2 -1 2 -1 2
```

### Notes on test classes
Each test class supports a command line option *list* that prints out the dataset used by the class in question. There may be further options for instance to assist in dataset definition. For hints on usage call test classes without any commands.
```
# print usage of test classes

# PlaneTest
PATH=chartacaeli/gpu:$PATH java -classpath "chartacaeli;lib/jts-1.14.jar;lib/commons-math3-3.5.jar;" chartacaeli.gpu.tst.PlaneTest
# RealMatrixTest
PATH=chartacaeli/gpu:$PATH java -classpath "chartacaeli;lib/jts-1.14.jar;lib/commons-math3-3.5.jar;" chartacaeli.gpu.tst.RealMatrixTest
# P4StereographicTest
PATH=chartacaeli/gpu:$PATH java -classpath "chartacaeli;lib/jts-1.14.jar;" chartacaeli.gpu.tst.P4StereographicTest
# P4OrthographicTest
PATH=chartacaeli/gpu:$PATH java -classpath "chartacaeli;lib/jts-1.14.jar;" chartacaeli.gpu.tst.P4OrthographicTest
# P4MollweideTest
PATH=chartacaeli/gpu:$PATH java -classpath "chartacaeli;lib/jts-1.14.jar;" chartacaeli.gpu.tst.P4MollweideTest
```

### Notes on experimental inner classes of Artwork
These are for testing the C3P classes from inside the application (JUnit not involved). `Artwork$PJ2TextureMapperJni` is a C3P version of `Artwork$PJ2TextureMapperSeq`. It uses C3P objects (e.g. `RealMatrix`, `Plane`, `P4Projector`) instead of corresponding objects in `chartacaeli`. `Artwork$PJ2TextureMapperC3p` is a pure C++ implementation of `Artwork$PJ2TextureMapperSeq`. Both are marked as comments in `Artwork`. To use them run `make testbuild` in `gpu` folder. Then remove comments and compile `Artwork`.

### Cues and findings
- [CXXWRAP](http://sourceforge.net/projects/cxxwrap/) does not support Java objects as return types as stated in [changelog](http://cxxwrap.sourceforge.net/CHANGELOG.txt) entry *20010424*. See [screenshot](screenshot-return-type-object-unsupported.png) of CXXWRAP output for using a Java object as return type.
- Restriction on Java object return types applies to arrays of primitive types as well. See [screenshot](screenshot-return-type-primitive-array-unsupported.png) with CXXWRAP output for replacing Java object by array of primitive type and [generated code](screenshot-return-type-primitive-array-unsupported-code.png).
- Notes on [Argument conversion](http://cxxwrap.sourceforge.net/doc/design.html). CXXWRAP will not generate any code in case of arguments of unsupported types (`size_t` for instance).
- A really nice [Introduction to Parallel Computing](https://computing.llnl.gov/tutorials/parallel_comp/)
- Online book about [Programming on Parallel Machines](http://heather.cs.ucdavis.edu/~matloff/158/PLN/ParProcBook.pdf)
- C++ [programming guide](http://www.lmpt.univ-tours.fr/~volkov/C++.pdf) and [online reference](http://www.cplusplus.com/reference/)
- Stackoverflow answer on [how to instantiate C++ objects from class names](http://stackoverflow.com/questions/582331/is-there-a-way-to-instantiate-objects-from-a-string-holding-their-class-name)
- [Sample implementation](https://github.com/egaburov/vanaheimr) of `std::map` with [usage example](https://devtalk.nvidia.com/default/topic/523766/std-map-in-device-code/) from [CUDA ZONE](https://developer.nvidia.com/cuda-zone)
- Stackoverflow answer on [how to access class members from within CUDA kernel](http://stackoverflow.com/questions/39006348/accessing-class-data-members-from-within-cuda-kernel-how-to-design-proper-host)
- [CUDA Toolkit Documentation](http://docs.nvidia.com/cuda/index.html#) containing [programming guides](http://docs.nvidia.com/cuda/index.html#programming-guides), [API references](http://docs.nvidia.com/cuda/index.html#cuda-api-references) and [NVCC documentation](http://docs.nvidia.com/cuda/cuda-compiler-driver-nvcc/index.html#abstract) (among others)
- [Separate Compilation and Linking of CUDA C++ Device Code](https://devblogs.nvidia.com/parallelforall/separate-compilation-linking-cuda-device-code/)
- [CUDAcons repository](https://github.com/otabuzzman/cudacons) with information about setting up CUDA without capable device
- An Idiot's Guide to C++ Templates [Part 1](https://www.codeproject.com/Articles/257589/An-Idiots-Guide-to-Cplusplus-Templates-Part) and [Part 2](https://www.codeproject.com/Articles/268849/An-Idiots-Guide-to-Cplusplus-Templates-Part) on [Codeproject](https://www.codeproject.com/)
