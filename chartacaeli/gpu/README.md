# CUDA implementation of *Artwork*

#### [JUnit](http://junit.org/junit4/) test data definition for *P4MollweideTest* class
- Manually defined *lamphi* limit values...
	```
	0 0
	360 90
	360 -90
	-360 -90
	```

- ...and some exceedances.
	```
	-390 125
	390 -125
	```

- Generated random *lamphi* values. Command `java -classpath "chartacaeli;" chartacaeli.gpu.tst.RandomDataset 8 8 -180 540 -90 180` will output 8 records, 2 elements each, randomly ranging from -180 to 360 and -90 to 90 degrees with 8 decimals:
	```
	285.96507320 57.19645503
	281.00543042 -30.64417613
	198.32294673 44.54854348
	222.66537100 -27.62091553
	350.41479725 -20.22673364
	31.15271854 -67.58308292
	-118.80829765 -77.26883507
	-129.32911838 66.23282586
	```

- Forward projection of *lamphi* dataset from above with 12 decimals using command `PATH=chartacaeli/gpu:$PATH java -classpath "chartacaeli;lib/jts-1.14.jar;" chartacaeli.gpu.tst.P4MollweideTest 12 forward`:
	```
	0.000000000000 0.000000000000
	0.000035326531 1.414213562346
	0.000035326531 -1.414213562346
	-0.000035326531 -1.414213562346
	-4.327589541727 1.001323735770
	4.327589541727 -1.001323735770
	3.060247851411 1.035555621636
	4.022756620023 -0.583111505572
	2.523845979837 0.829583384946
	3.246394243562 -0.527448659196
	5.293863032894 -0.388977905861
	0.266273425030 -1.186691069606
	-0.711308364542 -1.307539563996
	-1.145463050023 1.168156349324
	```

- Manually created Java objects for JUnit test of forward and inverse projections:
	```
	// dataset forward (lamphi values)
	double[][] dataset_f = {
	{ 0, 0 },
	{ 360, 90 },
	{ 360, -90 },
	{ -360, -90 },
	{ -390, 125 },
	{ 390, -125 },
	{ 285.96507320, 57.19645503 },
	{ 281.00543042, -30.64417613 },
	{ 198.32294673, 44.54854348 },
	{ 222.66537100, -27.62091553 },
	{ 350.41479725, -20.22673364 },
	{ 31.15271854, -67.58308292 },
	{ -118.80829765, -77.26883507 },
	{ -129.32911838, 66.23282586 },
	} ;

	// dataset inverse (xy values)
	double[][] dataset_i = {
	{ 0.000000000000, 0.000000000000 },
	{ 0.000035326531, 1.414213562346 },
	{ 0.000035326531, -1.414213562346 },
	{ -0.000035326531, -1.414213562346 },
	{ -4.327589541727, 1.001323735770 },
	{ 4.327589541727, -1.001323735770 },
	{ 3.060247851411, 1.035555621636 },
	{ 4.022756620023, -0.583111505572 },
	{ 2.523845979837, 0.829583384946 },
	{ 3.246394243562, -0.527448659196 },
	{ 5.293863032894, -0.388977905861 },
	{ 0.266273425030, -1.186691069606 },
	{ -0.711308364542, -1.307539563996 },
	{ -1.145463050023, 1.168156349324 },
	} ;
	```

#### Cues and findings
- [CXXWRAP](http://sourceforge.net/projects/cxxwrap/) does not support Java objects as return types as stated in [changelog](http://cxxwrap.sourceforge.net/CHANGELOG.txt) entry *20010424*. Restriction applies to arrays of primitive types as well. Here is a [screenshot](screenshot-return-type-object-unsupported.png) of CXXWRAP output for using a Java object as return type. This [screenshot](screenshot-return-type-primitive-array-unsupported.png) shows results of replacing Java object by array of primitive type (see [generated code](screenshot-return-type-primitive-array-unsupported-code.png) as well).
- Argument types/ conversion http://cxxwrap.sourceforge.net/doc/design.html
- googletest is a JUnit for C++
- STDL functions on CUDA device