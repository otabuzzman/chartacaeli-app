// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAEllipticalPlanetaryDetails extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public double ApparentGeocentricEclipticalLongitude()
{
double __retval = 0.0;
__retval = __m0(implementation.longValue());
return __retval;
}
private native double __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double ApparentGeocentricEclipticalLatitude()
{
double __retval = 0.0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native double __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double ApparentGeocentricDistance()
{
double __retval = 0.0;
__retval = __m2(implementation.longValue());
return __retval;
}
private native double __m2(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double ApparentLightTime()
{
double __retval = 0.0;
__retval = __m3(implementation.longValue());
return __retval;
}
private native double __m3(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double ApparentGeocentricRA()
{
double __retval = 0.0;
__retval = __m4(implementation.longValue());
return __retval;
}
private native double __m4(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double ApparentGeocentricDeclination()
{
double __retval = 0.0;
__retval = __m5(implementation.longValue());
return __retval;
}
private native double __m5(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueHeliocentricEclipticalLongitude()
{
double __retval = 0.0;
__retval = __m7(implementation.longValue());
return __retval;
}
private native double __m7(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueHeliocentricEclipticalLatitude()
{
double __retval = 0.0;
__retval = __m8(implementation.longValue());
return __retval;
}
private native double __m8(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueHeliocentricDistance()
{
double __retval = 0.0;
__retval = __m9(implementation.longValue());
return __retval;
}
private native double __m9(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueGeocentricEclipticalLongitude()
{
double __retval = 0.0;
__retval = __m10(implementation.longValue());
return __retval;
}
private native double __m10(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueGeocentricEclipticalLatitude()
{
double __retval = 0.0;
__retval = __m11(implementation.longValue());
return __retval;
}
private native double __m11(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueGeocentricDistance()
{
double __retval = 0.0;
__retval = __m12(implementation.longValue());
return __retval;
}
private native double __m12(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueLightTime()
{
double __retval = 0.0;
__retval = __m13(implementation.longValue());
return __retval;
}
private native double __m13(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueGeocentricRA()
{
double __retval = 0.0;
__retval = __m14(implementation.longValue());
return __retval;
}
private native double __m14(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TrueGeocentricDeclination()
{
double __retval = 0.0;
__retval = __m15(implementation.longValue());
return __retval;
}
private native double __m15(long __imp);
public CAAEllipticalPlanetaryDetails() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAEllipticalPlanetaryDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAEllipticalPlanetaryDetails)) return false;
  return implementation.equals(((CAAEllipticalPlanetaryDetails)o).implementation);
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
