#ifndef __COORDINATE_H__
#define __COORDINATE_H__

class Coordinate {

public:
	double x ;
	double y ;
	double z ;

	Coordinate() ;
	Coordinate( double c[3] ) ;
	Coordinate( Coordinate& c ) ;
	Coordinate( double x, double y, double z ) ;

	void set( double x, double y, double z ) ;
	Coordinate* spherical() ;
	Coordinate* cartesian() ;

	double* toArray() ;
	// CXXWRAP/ JUnit
	void spercical( /* return */ double retval[] ) ;
	void cartesian( /* return */ double retval[] ) ;
} ;

#endif // __COORDINATE_H__
