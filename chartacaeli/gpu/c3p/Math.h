#ifndef __MATH_H__
#define __MATH_H__

class Math {

public:
	static double sin( double a ) ;
	static double cos( double a ) ;
	static double tan( double a ) ;
	static double asin( double a ) ;
	static double atan( double a ) ;
	static double atan2( double y, double x ) ;

	constexpr static const double PI = 3.141592653589793 ;
} ;
#endif // __MATH_H__
