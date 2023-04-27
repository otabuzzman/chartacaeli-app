// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAARiseTransitSet extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAARiseTransitSetDetails Calculate(double JD, double Alpha1, double Delta1, double Alpha2, double Delta2, double Alpha3, double Delta3, double Longitude, double Latitude, double h0)
{
long __retval = 0;
__retval = __m0(0, JD, Alpha1, Delta1, Alpha2, Delta2, Alpha3, Delta3, Longitude, Latitude, h0);
return (__retval == 0 ? null : new CAARiseTransitSetDetails(Long.valueOf(__retval)));
}
private native static long __m0(long __imp, double JD, double Alpha1, double Delta1, double Alpha2, double Delta2, double Alpha3, double Delta3, double Longitude, double Latitude, double h0);
/**

This method may <var>not</var> be extended in Java.
*/
public static void CorrectRAValuesForInterpolation(double[] Alpha1, double[] Alpha2, double[] Alpha3)
{
__m1(0, Alpha1, Alpha2, Alpha3);
}
private native static void __m1(long __imp, double[] Alpha1, double[] Alpha2, double[] Alpha3);
public CAARiseTransitSet() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAARiseTransitSet(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAARiseTransitSet)) return false;
  return implementation.equals(((CAARiseTransitSet)o).implementation);
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
