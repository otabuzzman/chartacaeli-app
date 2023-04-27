// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAEclipses extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAASolarEclipseDetails CalculateSolar(double k)
{
long __retval = 0;
__retval = __m0(0, k);
return (__retval == 0 ? null : new CAASolarEclipseDetails(Long.valueOf(__retval)));
}
private native static long __m0(long __imp, double k);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAALunarEclipseDetails CalculateLunar(double k)
{
long __retval = 0;
__retval = __m1(0, k);
return (__retval == 0 ? null : new CAALunarEclipseDetails(Long.valueOf(__retval)));
}
private native static long __m1(long __imp, double k);
public CAAEclipses() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAEclipses(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAEclipses)) return false;
  return implementation.equals(((CAAEclipses)o).implementation);
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
