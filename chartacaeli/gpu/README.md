# CUDA implementation of *Artwork*
The class *Artwork* draws artistic images of star signs on the star chart. A *for-loop* handles the images sequentially pixel by pixel. It is substituted and thus parallelized by a CUDA kernel. To this end [Parallel Java 2 Library](https://www.cs.rit.edu/~ark/pj2.shtml) (PJ2) acts as a bridge from Java to CUDA and vice versa. PJ2 allows to run a CUDA kernel from a Java application. With PJ2 the parallelization of Java classes is essentially reduced to kernel development. At least in terms of coding. Note however that PJ2 does not change the basic procedure for the [parallelization of existing sequential software](http://alecu.ase.ro/conferences/conf_2003_cluj.pdf).

### Approach
Find the code suitable to parallization (the *for-loop* mentioned above). Get familiar with PJ2 by enabling the *for-loop* to make use of multiple cores. That is turning a sequentional Java application into one that makes use of Symmetric Multiprocessing. Find the Java objects used or referenced by the *for-loop* and implement them as C/C++ peer objects (C3P) to get used by the CUDA kernel. Note that there is no way to run STDL on a CUDA capable device (search Google for "[*STDL functions on CUDA device*](https://www.google.de/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=STDL+functions+on+CUDA+device)"). Assure C3Ps and corresponding Java objects work identically. Use JNI for instance to make C3Ps available inside Java and define [JUnit](http://junit.org/junit4/) test cases that compares results of a given C3P with it's corresponding Java object. Another approach could be to use JUnit on the Java side, implement a different unit test subsystem for the C3Ps ([googletest](https://github.com/google/googletest/blob/master/googletest/docs/Primer.md) for instance) and finally compare the results by using some shell tools. Write and implement the CUDA kernel. Consider a pseudo-kernel before the real one to make sure the C3Ps work as expected when tied together in a single program.

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

### Cues and findings
- [CXXWRAP](http://sourceforge.net/projects/cxxwrap/) does not support Java objects as return types as stated in [changelog](http://cxxwrap.sourceforge.net/CHANGELOG.txt) entry *20010424*. See [screenshot](screenshot-return-type-object-unsupported.png) of CXXWRAP output for using a Java object as return type.
- Restriction on Java object return types applies to arrays of primitive types as well. See [screenshot](screenshot-return-type-primitive-array-unsupported.png) with CXXWRAP output for replacing Java object by array of primitive type and [generated code](screenshot-return-type-primitive-array-unsupported-code.png).
- Notes on [Argument conversion](http://cxxwrap.sourceforge.net/doc/design.html). CXXWRAP will not generate any code in case of arguments of unsupported types (`size_t` for instance).
- A really nice [Introduction to Parallel Computing](https://computing.llnl.gov/tutorials/parallel_comp/)
- Online book about [Programming on Parallel Machines](http://heather.cs.ucdavis.edu/~matloff/158/PLN/ParProcBook.pdf)
