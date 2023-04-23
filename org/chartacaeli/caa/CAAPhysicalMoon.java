// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAPhysicalMoon extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAAPhysicalMoonDetails CalculateGeocentric(double JD)
{
long __retval = 0;
__retval = __m0(0, JD);
return (__retval == 0 ? null : new CAAPhysicalMoonDetails(new Long(__retval)));
}
private native static long __m0(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAAPhysicalMoonDetails CalculateTopocentric(double JD, double Longitude, double Latitude)
{
long __retval = 0;
__retval = __m1(0, JD, Longitude, Latitude);
return (__retval == 0 ? null : new CAAPhysicalMoonDetails(new Long(__retval)));
}
private native static long __m1(long __imp, double JD, double Longitude, double Latitude);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAASelenographicMoonDetails CalculateSelenographicPositionOfSun(double JD, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m2(0, JD, bHighPrecision);
return (__retval == 0 ? null : new CAASelenographicMoonDetails(new Long(__retval)));
}
private native static long __m2(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double AltitudeOfSun(double JD, double Longitude, double Latitude, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m3(0, JD, Longitude, Latitude, bHighPrecision);
return __retval;
}
private native static double __m3(long __imp, double JD, double Longitude, double Latitude, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double TimeOfSunrise(double JD, double Longitude, double Latitude, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m4(0, JD, Longitude, Latitude, bHighPrecision);
return __retval;
}
private native static double __m4(long __imp, double JD, double Longitude, double Latitude, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double TimeOfSunset(double JD, double Longitude, double Latitude, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m5(0, JD, Longitude, Latitude, bHighPrecision);
return __retval;
}
private native static double __m5(long __imp, double JD, double Longitude, double Latitude, boolean bHighPrecision);
public CAAPhysicalMoon() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAPhysicalMoon(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAPhysicalMoon)) return false;
  return implementation.equals(((CAAPhysicalMoon)o).implementation);
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
