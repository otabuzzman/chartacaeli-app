// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAANearParabolicObjectDetails extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public CAA3DCoordinate HeliocentricRectangularEquatorial()
{
long __retval = 0;
__retval = __m0(implementation.longValue());
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native long __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAA3DCoordinate HeliocentricRectangularEcliptical()
{
long __retval = 0;
__retval = __m1(implementation.longValue());
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native long __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double HeliocentricEclipticLongitude()
{
double __retval = 0.0;
__retval = __m2(implementation.longValue());
return __retval;
}
private native double __m2(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double HeliocentricEclipticLatitude()
{
double __retval = 0.0;
__retval = __m3(implementation.longValue());
return __retval;
}
private native double __m3(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueGeocentricRA()
{
double __retval = 0.0;
__retval = __m4(implementation.longValue());
return __retval;
}
private native double __m4(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueGeocentricDeclination()
{
double __retval = 0.0;
__retval = __m5(implementation.longValue());
return __retval;
}
private native double __m5(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueGeocentricDistance()
{
double __retval = 0.0;
__retval = __m6(implementation.longValue());
return __retval;
}
private native double __m6(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueGeocentricLightTime()
{
double __retval = 0.0;
__retval = __m7(implementation.longValue());
return __retval;
}
private native double __m7(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double AstrometricGeocentricRA()
{
double __retval = 0.0;
__retval = __m8(implementation.longValue());
return __retval;
}
private native double __m8(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double AstrometricGeocentricDeclination()
{
double __retval = 0.0;
__retval = __m9(implementation.longValue());
return __retval;
}
private native double __m9(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double AstrometricGeocentricDistance()
{
double __retval = 0.0;
__retval = __m10(implementation.longValue());
return __retval;
}
private native double __m10(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double AstrometricGeocentricLightTime()
{
double __retval = 0.0;
__retval = __m11(implementation.longValue());
return __retval;
}
private native double __m11(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double Elongation()
{
double __retval = 0.0;
__retval = __m12(implementation.longValue());
return __retval;
}
private native double __m12(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double PhaseAngle()
{
double __retval = 0.0;
__retval = __m13(implementation.longValue());
return __retval;
}
private native double __m13(long __imp);
public CAANearParabolicObjectDetails() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAANearParabolicObjectDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAANearParabolicObjectDetails)) return false;
  return implementation.equals(((CAANearParabolicObjectDetails)o).implementation);
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
