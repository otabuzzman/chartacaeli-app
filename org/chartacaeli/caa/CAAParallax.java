// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAParallax extends Object {
/**Conversion functions

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate Equatorial2TopocentricDelta(double Alpha, double Delta, double Distance, double Longitude, double Latitude, double Height, double JD)
{
long __retval = 0;
__retval = __m0(0, Alpha, Delta, Distance, Longitude, Latitude, Height, JD);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m0(long __imp, double Alpha, double Delta, double Distance, double Longitude, double Latitude, double Height, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate Equatorial2Topocentric(double Alpha, double Delta, double Distance, double Longitude, double Latitude, double Height, double JD)
{
long __retval = 0;
__retval = __m1(0, Alpha, Delta, Distance, Longitude, Latitude, Height, JD);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m1(long __imp, double Alpha, double Delta, double Distance, double Longitude, double Latitude, double Height, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAATopocentricEclipticDetails Ecliptic2Topocentric(double Lambda, double Beta, double Semidiameter, double Distance, double Epsilon, double Latitude, double Height, double JD)
{
long __retval = 0;
__retval = __m2(0, Lambda, Beta, Semidiameter, Distance, Epsilon, Latitude, Height, JD);
return (__retval == 0 ? null : new CAATopocentricEclipticDetails(new Long(__retval)));
}
private native static long __m2(long __imp, double Lambda, double Beta, double Semidiameter, double Distance, double Epsilon, double Latitude, double Height, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double ParallaxToDistance(double Parallax)
{
double __retval = 0.0;
__retval = __m3(0, Parallax);
return __retval;
}
private native static double __m3(long __imp, double Parallax);
/**

This method may <var>not</var> be extended in Java.
*/
public static double DistanceToParallax(double Distance)
{
double __retval = 0.0;
__retval = __m4(0, Distance);
return __retval;
}
private native static double __m4(long __imp, double Distance);
public CAAParallax() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAParallax(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAParallax)) return false;
  return implementation.equals(((CAAParallax)o).implementation);
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
