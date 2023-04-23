// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAABinaryStar extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAABinaryStarDetails Calculate(double t, double P, double T, double e, double a, double i, double omega, double w)
{
long __retval = 0;
__retval = __m0(0, t, P, T, e, a, i, omega, w);
return (__retval == 0 ? null : new CAABinaryStarDetails(new Long(__retval)));
}
private native static long __m0(long __imp, double t, double P, double T, double e, double a, double i, double omega, double w);
/**

This method may <var>not</var> be extended in Java.
*/
public static double ApparentEccentricity(double e, double i, double w)
{
double __retval = 0.0;
__retval = __m1(0, e, i, w);
return __retval;
}
private native static double __m1(long __imp, double e, double i, double w);
public CAABinaryStar() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAABinaryStar(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAABinaryStar)) return false;
  return implementation.equals(((CAABinaryStar)o).implementation);
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
