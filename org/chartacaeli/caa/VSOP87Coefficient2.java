// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class VSOP87Coefficient2 extends Object {
/**

This method may <var>not</var> be extended in Java.
*/
public VSOP87Coefficient pCoefficients()
{
long __retval = 0;
__retval = __m0(implementation.longValue());
return (__retval == 0 ? null : new VSOP87Coefficient(new Long(__retval)));
}
private native long __m0(long __imp);
public VSOP87Coefficient2() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public VSOP87Coefficient2(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof VSOP87Coefficient2)) return false;
  return implementation.equals(((VSOP87Coefficient2)o).implementation);
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
