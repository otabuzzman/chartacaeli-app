// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAMoon extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double MeanLongitude(double JD)
{
double __retval = 0.0;
__retval = __m0(0, JD);
return __retval;
}
private native static double __m0(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanElongation(double JD)
{
double __retval = 0.0;
__retval = __m1(0, JD);
return __retval;
}
private native static double __m1(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanAnomaly(double JD)
{
double __retval = 0.0;
__retval = __m2(0, JD);
return __retval;
}
private native static double __m2(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double ArgumentOfLatitude(double JD)
{
double __retval = 0.0;
__retval = __m3(0, JD);
return __retval;
}
private native static double __m3(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanLongitudeAscendingNode(double JD)
{
double __retval = 0.0;
__retval = __m4(0, JD);
return __retval;
}
private native static double __m4(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanLongitudePerigee(double JD)
{
double __retval = 0.0;
__retval = __m5(0, JD);
return __retval;
}
private native static double __m5(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double TrueLongitudeAscendingNode(double JD)
{
double __retval = 0.0;
__retval = __m6(0, JD);
return __retval;
}
private native static double __m6(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLongitude(double JD)
{
double __retval = 0.0;
__retval = __m7(0, JD);
return __retval;
}
private native static double __m7(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLatitude(double JD)
{
double __retval = 0.0;
__retval = __m8(0, JD);
return __retval;
}
private native static double __m8(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiusVector(double JD)
{
double __retval = 0.0;
__retval = __m9(0, JD);
return __retval;
}
private native static double __m9(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiusVectorToHorizontalParallax(double RadiusVector)
{
double __retval = 0.0;
__retval = __m10(0, RadiusVector);
return __retval;
}
private native static double __m10(long __imp, double RadiusVector);
/**

This method may <var>not</var> be extended in Java.
*/
public static double HorizontalParallaxToRadiusVector(double Parallax)
{
double __retval = 0.0;
__retval = __m11(0, Parallax);
return __retval;
}
private native static double __m11(long __imp, double Parallax);
public CAAMoon() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAMoon(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAMoon)) return false;
  return implementation.equals(((CAAMoon)o).implementation);
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
