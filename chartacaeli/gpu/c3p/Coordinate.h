#ifndef __COORDINATE_H__
#define __COORDINATE_H__

class Coordinate {

public:
	double x ;
	double y ;
	double z ;

	Coordinate() ;
	Coordinate( const Coordinate& c ) ;
	Coordinate( double x, double y, double z ) ;

	void set( double x, double y, double z ) ;
	void spherical() ;
	void cartesian() ;

	// CXXWRAP/ JUnit
	void spherical( /* return */ double retval[] ) ;
	void cartesian( /* return */ double retval[] ) ;
} ;

#endif // __COORDINATE_H__
