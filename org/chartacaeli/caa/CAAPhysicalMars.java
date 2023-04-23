// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAPhysicalMars extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAAPhysicalMarsDetails Calculate(double JD, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m0(0, JD, bHighPrecision);
return (__retval == 0 ? null : new CAAPhysicalMarsDetails(new Long(__retval)));
}
private native static long __m0(long __imp, double JD, boolean bHighPrecision);
public CAAPhysicalMars() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAPhysicalMars(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAPhysicalMars)) return false;
  return implementation.equals(((CAAPhysicalMars)o).implementation);
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
