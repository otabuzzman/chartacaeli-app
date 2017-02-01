#ifndef __COORDINATE_H__
#define __COORDINATE_H__

class Coordinate {

public:
	double x ;
	double y ;
	double z ;

	__device__ Coordinate() ;
	__device__ Coordinate( double c[3] ) ;
	__device__ Coordinate( Coordinate& c ) ;
	__device__ Coordinate( double x, double y, double z ) ;

	__device__ void set( double x, double y, double z ) ;
	__device__ Coordinate* spherical() ;
	__device__ Coordinate* cartesian() ;

	__device__ double* toArray() ;
} ;

#endif // __COORDINATE_H__
