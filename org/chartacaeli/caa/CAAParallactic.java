// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAParallactic extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double ParallacticAngle(double HourAngle, double Latitude, double delta)
{
double __retval = 0.0;
__retval = __m0(0, HourAngle, Latitude, delta);
return __retval;
}
private native static double __m0(long __imp, double HourAngle, double Latitude, double delta);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLongitudeOnHorizon(double LocalSiderealTime, double ObliquityOfEcliptic, double Latitude)
{
double __retval = 0.0;
__retval = __m1(0, LocalSiderealTime, ObliquityOfEcliptic, Latitude);
return __retval;
}
private native static double __m1(long __imp, double LocalSiderealTime, double ObliquityOfEcliptic, double Latitude);
/**

This method may <var>not</var> be extended in Java.
*/
public static double AngleBetweenEclipticAndHorizon(double LocalSiderealTime, double ObliquityOfEcliptic, double Latitude)
{
double __retval = 0.0;
__retval = __m2(0, LocalSiderealTime, ObliquityOfEcliptic, Latitude);
return __retval;
}
private native static double __m2(long __imp, double LocalSiderealTime, double ObliquityOfEcliptic, double Latitude);
/**

This method may <var>not</var> be extended in Java.
*/
public static double AngleBetweenNorthCelestialPoleAndNorthPoleOfEcliptic(double Lambda, double Beta, double ObliquityOfEcliptic)
{
double __retval = 0.0;
__retval = __m3(0, Lambda, Beta, ObliquityOfEcliptic);
return __retval;
}
private native static double __m3(long __imp, double Lambda, double Beta, double ObliquityOfEcliptic);
public CAAParallactic() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAParallactic(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAParallactic)) return false;
  return implementation.equals(((CAAParallactic)o).implementation);
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
