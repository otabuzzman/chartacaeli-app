#ifndef __COORDINATE_H__
#define __COORDINATE_H__

class Coordinate {

public:
	double x ;
	double y ;
	double z ;

	__device__ Coordinate() ;
	__device__ Coordinate( const Coordinate& c ) ;
	__device__ Coordinate( double x, double y, double z ) ;

	__device__ void set( double x, double y, double z ) ;
	__device__ void spherical() ;
	__device__ void cartesian() ;
} ;

#endif // __COORDINATE_H__
