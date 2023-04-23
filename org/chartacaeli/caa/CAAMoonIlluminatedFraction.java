// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAMoonIlluminatedFraction extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double GeocentricElongation(double ObjectAlpha, double ObjectDelta, double SunAlpha, double SunDelta)
{
double __retval = 0.0;
__retval = __m0(0, ObjectAlpha, ObjectDelta, SunAlpha, SunDelta);
return __retval;
}
private native static double __m0(long __imp, double ObjectAlpha, double ObjectDelta, double SunAlpha, double SunDelta);
/**

This method may <var>not</var> be extended in Java.
*/
public static double PhaseAngle(double GeocentricElongation, double EarthObjectDistance, double EarthSunDistance)
{
double __retval = 0.0;
__retval = __m1(0, GeocentricElongation, EarthObjectDistance, EarthSunDistance);
return __retval;
}
private native static double __m1(long __imp, double GeocentricElongation, double EarthObjectDistance, double EarthSunDistance);
/**

This method may <var>not</var> be extended in Java.
*/
public static double IlluminatedFraction(double PhaseAngle)
{
double __retval = 0.0;
__retval = __m2(0, PhaseAngle);
return __retval;
}
private native static double __m2(long __imp, double PhaseAngle);
/**

This method may <var>not</var> be extended in Java.
*/
public static double PositionAngle(double Alpha0, double Delta0, double Alpha, double Delta)
{
double __retval = 0.0;
__retval = __m3(0, Alpha0, Delta0, Alpha, Delta);
return __retval;
}
private native static double __m3(long __imp, double Alpha0, double Delta0, double Alpha, double Delta);
public CAAMoonIlluminatedFraction() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAMoonIlluminatedFraction(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAMoonIlluminatedFraction)) return false;
  return implementation.equals(((CAAMoonIlluminatedFraction)o).implementation);
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
