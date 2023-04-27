// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAEclipticalElements extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAAEclipticalElementDetails Calculate(double i0, double w0, double omega0, double JD0, double JD)
{
long __retval = 0;
__retval = __m0(0, i0, w0, omega0, JD0, JD);
return (__retval == 0 ? null : new CAAEclipticalElementDetails(Long.valueOf(__retval)));
}
private native static long __m0(long __imp, double i0, double w0, double omega0, double JD0, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAAEclipticalElementDetails FK4B1950ToFK5J2000(double i0, double w0, double omega0)
{
long __retval = 0;
__retval = __m1(0, i0, w0, omega0);
return (__retval == 0 ? null : new CAAEclipticalElementDetails(Long.valueOf(__retval)));
}
private native static long __m1(long __imp, double i0, double w0, double omega0);
public CAAEclipticalElements() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAEclipticalElements(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAEclipticalElements)) return false;
  return implementation.equals(((CAAEclipticalElements)o).implementation);
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
