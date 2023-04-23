// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAACoordinateTransformation extends Object {
/**Conversion functions

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate Equatorial2Ecliptic(double Alpha, double Delta, double Epsilon)
{
long __retval = 0;
__retval = __m0(0, Alpha, Delta, Epsilon);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m0(long __imp, double Alpha, double Delta, double Epsilon);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate Ecliptic2Equatorial(double Lambda, double Beta, double Epsilon)
{
long __retval = 0;
__retval = __m1(0, Lambda, Beta, Epsilon);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m1(long __imp, double Lambda, double Beta, double Epsilon);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate Equatorial2Horizontal(double LocalHourAngle, double Delta, double Latitude)
{
long __retval = 0;
__retval = __m2(0, LocalHourAngle, Delta, Latitude);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m2(long __imp, double LocalHourAngle, double Delta, double Latitude);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate Horizontal2Equatorial(double A, double h, double Latitude)
{
long __retval = 0;
__retval = __m3(0, A, h, Latitude);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m3(long __imp, double A, double h, double Latitude);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate Equatorial2Galactic(double Alpha, double Delta)
{
long __retval = 0;
__retval = __m4(0, Alpha, Delta);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m4(long __imp, double Alpha, double Delta);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate Galactic2Equatorial(double l, double b)
{
long __retval = 0;
__retval = __m5(0, l, b);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m5(long __imp, double l, double b);
/**Inlined functions

This method may <var>not</var> be extended in Java.
*/
public static double DegreesToRadians(double Degrees)
{
double __retval = 0.0;
__retval = __m6(0, Degrees);
return __retval;
}
private native static double __m6(long __imp, double Degrees);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiansToDegrees(double Radians)
{
double __retval = 0.0;
__retval = __m7(0, Radians);
return __retval;
}
private native static double __m7(long __imp, double Radians);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiansToHours(double Radians)
{
double __retval = 0.0;
__retval = __m8(0, Radians);
return __retval;
}
private native static double __m8(long __imp, double Radians);
/**

This method may <var>not</var> be extended in Java.
*/
public static double HoursToRadians(double Hours)
{
double __retval = 0.0;
__retval = __m9(0, Hours);
return __retval;
}
private native static double __m9(long __imp, double Hours);
/**

This method may <var>not</var> be extended in Java.
*/
public static double HoursToDegrees(double Hours)
{
double __retval = 0.0;
__retval = __m10(0, Hours);
return __retval;
}
private native static double __m10(long __imp, double Hours);
/**

This method may <var>not</var> be extended in Java.
*/
public static double DegreesToHours(double Degrees)
{
double __retval = 0.0;
__retval = __m11(0, Degrees);
return __retval;
}
private native static double __m11(long __imp, double Degrees);
/**

This method may <var>not</var> be extended in Java.
*/
public static double PI()
{
double __retval = 0.0;
__retval = __m12(0);
return __retval;
}
private native static double __m12(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MapTo0To360Range(double Degrees)
{
double __retval = 0.0;
__retval = __m13(0, Degrees);
return __retval;
}
private native static double __m13(long __imp, double Degrees);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MapToMinus90To90Range(double Degrees)
{
double __retval = 0.0;
__retval = __m14(0, Degrees);
return __retval;
}
private native static double __m14(long __imp, double Degrees);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MapTo0To24Range(double HourAngle)
{
double __retval = 0.0;
__retval = __m15(0, HourAngle);
return __retval;
}
private native static double __m15(long __imp, double HourAngle);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MapTo0To2PIRange(double Angle)
{
double __retval = 0.0;
__retval = __m16(0, Angle);
return __retval;
}
private native static double __m16(long __imp, double Angle);
/**

This method may <var>not</var> be extended in Java.
*/
public static double DMSToDegrees(double Degrees, double Minutes, double Seconds, boolean bPositive)
{
double __retval = 0.0;
__retval = __m17(0, Degrees, Minutes, Seconds, bPositive);
return __retval;
}
private native static double __m17(long __imp, double Degrees, double Minutes, double Seconds, boolean bPositive);
public CAACoordinateTransformation() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAACoordinateTransformation(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAACoordinateTransformation)) return false;
  return implementation.equals(((CAACoordinateTransformation)o).implementation);
}
// override hashCode() from Object, return the implementation values hashCode()
public int hashCode() { return implementation.hashCode(); }
public void delete()
{

__d(implementation.longValue());
 implementation = null;
}
private native void __d(long __imp);
};
