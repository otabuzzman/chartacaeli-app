// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAGlobe extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double RhoSinThetaPrime(double GeographicalLatitude, double Height)
{
double __retval = 0.0;
__retval = __m0(0, GeographicalLatitude, Height);
return __retval;
}
private native static double __m0(long __imp, double GeographicalLatitude, double Height);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RhoCosThetaPrime(double GeographicalLatitude, double Height)
{
double __retval = 0.0;
__retval = __m1(0, GeographicalLatitude, Height);
return __retval;
}
private native static double __m1(long __imp, double GeographicalLatitude, double Height);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiusOfParallelOfLatitude(double GeographicalLatitude)
{
double __retval = 0.0;
__retval = __m2(0, GeographicalLatitude);
return __retval;
}
private native static double __m2(long __imp, double GeographicalLatitude);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiusOfCurvature(double GeographicalLatitude)
{
double __retval = 0.0;
__retval = __m3(0, GeographicalLatitude);
return __retval;
}
private native static double __m3(long __imp, double GeographicalLatitude);
/**

This method may <var>not</var> be extended in Java.
*/
public static double DistanceBetweenPoints(double GeographicalLatitude1, double GeographicalLongitude1, double GeographicalLatitude2, double GeographicalLongitude2)
{
double __retval = 0.0;
__retval = __m4(0, GeographicalLatitude1, GeographicalLongitude1, GeographicalLatitude2, GeographicalLongitude2);
return __retval;
}
private native static double __m4(long __imp, double GeographicalLatitude1, double GeographicalLongitude1, double GeographicalLatitude2, double GeographicalLongitude2);
public CAAGlobe() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAGlobe(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAGlobe)) return false;
  return implementation.equals(((CAAGlobe)o).implementation);
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
