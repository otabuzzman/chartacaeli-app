// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAPlanetPerihelionAphelion extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double MercuryK(double Year)
{
double __retval = 0.0;
__retval = __m0(0, Year);
return __retval;
}
private native static double __m0(long __imp, double Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Mercury(double k)
{
double __retval = 0.0;
__retval = __m1(0, k);
return __retval;
}
private native static double __m1(long __imp, double k);
/**

This method may <var>not</var> be extended in Java.
*/
public static double VenusK(double Year)
{
double __retval = 0.0;
__retval = __m2(0, Year);
return __retval;
}
private native static double __m2(long __imp, double Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Venus(double k)
{
double __retval = 0.0;
__retval = __m3(0, k);
return __retval;
}
private native static double __m3(long __imp, double k);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EarthK(double Year)
{
double __retval = 0.0;
__retval = __m4(0, Year);
return __retval;
}
private native static double __m4(long __imp, double Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EarthPerihelion(double k, boolean bBarycentric)
{
double __retval = 0.0;
__retval = __m5(0, k, bBarycentric);
return __retval;
}
private native static double __m5(long __imp, double k, boolean bBarycentric);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EarthAphelion(double k, boolean bBarycentric)
{
double __retval = 0.0;
__retval = __m6(0, k, bBarycentric);
return __retval;
}
private native static double __m6(long __imp, double k, boolean bBarycentric);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MarsK(double Year)
{
double __retval = 0.0;
__retval = __m7(0, Year);
return __retval;
}
private native static double __m7(long __imp, double Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Mars(double k)
{
double __retval = 0.0;
__retval = __m8(0, k);
return __retval;
}
private native static double __m8(long __imp, double k);
/**

This method may <var>not</var> be extended in Java.
*/
public static double JupiterK(double Year)
{
double __retval = 0.0;
__retval = __m9(0, Year);
return __retval;
}
private native static double __m9(long __imp, double Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Jupiter(double k)
{
double __retval = 0.0;
__retval = __m10(0, k);
return __retval;
}
private native static double __m10(long __imp, double k);
/**

This method may <var>not</var> be extended in Java.
*/
public static double SaturnK(double Year)
{
double __retval = 0.0;
__retval = __m11(0, Year);
return __retval;
}
private native static double __m11(long __imp, double Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Saturn(double k)
{
double __retval = 0.0;
__retval = __m12(0, k);
return __retval;
}
private native static double __m12(long __imp, double k);
/**

This method may <var>not</var> be extended in Java.
*/
public static double UranusK(double Year)
{
double __retval = 0.0;
__retval = __m13(0, Year);
return __retval;
}
private native static double __m13(long __imp, double Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Uranus(double k)
{
double __retval = 0.0;
__retval = __m14(0, k);
return __retval;
}
private native static double __m14(long __imp, double k);
/**

This method may <var>not</var> be extended in Java.
*/
public static double NeptuneK(double Year)
{
double __retval = 0.0;
__retval = __m15(0, Year);
return __retval;
}
private native static double __m15(long __imp, double Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Neptune(double k)
{
double __retval = 0.0;
__retval = __m16(0, k);
return __retval;
}
private native static double __m16(long __imp, double k);
public CAAPlanetPerihelionAphelion() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAPlanetPerihelionAphelion(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAPlanetPerihelionAphelion)) return false;
  return implementation.equals(((CAAPlanetPerihelionAphelion)o).implementation);
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
