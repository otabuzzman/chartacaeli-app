// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAParabolic extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double CalculateBarkers(double W, double epsilon)
{
double __retval = 0.0;
__retval = __m0(0, W, epsilon);
return __retval;
}
private native static double __m0(long __imp, double W, double epsilon);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAAParabolicObjectDetails Calculate(double JD, CAAParabolicObjectElements elements, boolean bHighPrecision, double epsilon)
{
long __retval = 0;
__retval = __m1(0, JD, (elements == null ? 0 : elements.getCxxwrapImpl().longValue()), bHighPrecision, epsilon);
return (__retval == 0 ? null : new CAAParabolicObjectDetails(Long.valueOf(__retval)));
}
private native static long __m1(long __imp, double JD, long elements, boolean bHighPrecision, double epsilon);
public CAAParabolic() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAParabolic(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAParabolic)) return false;
  return implementation.equals(((CAAParabolic)o).implementation);
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
