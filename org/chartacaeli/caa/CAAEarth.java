// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAEarth extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLongitude(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m0(0, JD, bHighPrecision);
return __retval;
}
private native static double __m0(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLatitude(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m1(0, JD, bHighPrecision);
return __retval;
}
private native static double __m1(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiusVector(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m2(0, JD, bHighPrecision);
return __retval;
}
private native static double __m2(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double SunMeanAnomaly(double JD)
{
double __retval = 0.0;
__retval = __m3(0, JD);
return __retval;
}
private native static double __m3(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Eccentricity(double JD)
{
double __retval = 0.0;
__retval = __m4(0, JD);
return __retval;
}
private native static double __m4(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLongitudeJ2000(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m5(0, JD, bHighPrecision);
return __retval;
}
private native static double __m5(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLatitudeJ2000(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m6(0, JD, bHighPrecision);
return __retval;
}
private native static double __m6(long __imp, double JD, boolean bHighPrecision);
public CAAEarth() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAEarth(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAEarth)) return false;
  return implementation.equals(((CAAEarth)o).implementation);
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
