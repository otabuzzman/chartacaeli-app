// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAANearParabolic extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAANearParabolicObjectDetails Calculate(double JD, CAANearParabolicObjectElements elements, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m0(0, JD, (elements == null ? 0 : elements.getCxxwrapImpl().longValue()), bHighPrecision);
return (__retval == 0 ? null : new CAANearParabolicObjectDetails(new Long(__retval)));
}
private native static long __m0(long __imp, double JD, long elements, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double cbrt(double x)
{
double __retval = 0.0;
__retval = __m1(0, x);
return __retval;
}
private native static double __m1(long __imp, double x);
/**

This method may <var>not</var> be extended in Java.
*/
public static void CalculateTrueAnomalyAndRadius(double JD, CAANearParabolicObjectElements elements, double[] v, double[] r)
{
__m2(0, JD, (elements == null ? 0 : elements.getCxxwrapImpl().longValue()), v, r);
}
private native static void __m2(long __imp, double JD, long elements, double[] v, double[] r);
public CAANearParabolic() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAANearParabolic(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAANearParabolic)) return false;
  return implementation.equals(((CAANearParabolic)o).implementation);
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
