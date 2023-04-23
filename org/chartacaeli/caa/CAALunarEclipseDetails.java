// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAALunarEclipseDetails extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public boolean bEclipse()
{
boolean __retval = false;
__retval = __m0(implementation.longValue());
return __retval;
}
private native boolean __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TimeOfMaximumEclipse()
{
double __retval = 0.0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native double __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double F()
{
double __retval = 0.0;
__retval = __m2(implementation.longValue());
return __retval;
}
private native double __m2(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double u()
{
double __retval = 0.0;
__retval = __m3(implementation.longValue());
return __retval;
}
private native double __m3(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double gamma()
{
double __retval = 0.0;
__retval = __m4(implementation.longValue());
return __retval;
}
private native double __m4(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double PenumbralRadii()
{
double __retval = 0.0;
__retval = __m5(implementation.longValue());
return __retval;
}
private native double __m5(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double UmbralRadii()
{
double __retval = 0.0;
__retval = __m6(implementation.longValue());
return __retval;
}
private native double __m6(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double PenumbralMagnitude()
{
double __retval = 0.0;
__retval = __m7(implementation.longValue());
return __retval;
}
private native double __m7(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double UmbralMagnitude()
{
double __retval = 0.0;
__retval = __m8(implementation.longValue());
return __retval;
}
private native double __m8(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double PartialPhaseSemiDuration()
{
double __retval = 0.0;
__retval = __m9(implementation.longValue());
return __retval;
}
private native double __m9(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TotalPhaseSemiDuration()
{
double __retval = 0.0;
__retval = __m10(implementation.longValue());
return __retval;
}
private native double __m10(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double PartialPhasePenumbraSemiDuration()
{
double __retval = 0.0;
__retval = __m11(implementation.longValue());
return __retval;
}
private native double __m11(long __imp);
public CAALunarEclipseDetails() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAALunarEclipseDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAALunarEclipseDetails)) return false;
  return implementation.equals(((CAALunarEclipseDetails)o).implementation);
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
