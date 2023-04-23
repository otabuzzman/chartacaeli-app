// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAANodes extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAANodeObjectDetails PassageThroAscendingNode(CAAEllipticalObjectElements elements)
{
long __retval = 0;
__retval = __m0(0, (elements == null ? 0 : elements.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAANodeObjectDetails(new Long(__retval)));
}
private native static long __m0(long __imp, long elements);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAANodeObjectDetails PassageThroDescendingNode(CAAEllipticalObjectElements elements)
{
long __retval = 0;
__retval = __m1(0, (elements == null ? 0 : elements.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAANodeObjectDetails(new Long(__retval)));
}
private native static long __m1(long __imp, long elements);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAANodeObjectDetails PassageThroAscendingNode(CAAParabolicObjectElements elements)
{
long __retval = 0;
__retval = __m2(0, (elements == null ? 0 : elements.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAANodeObjectDetails(new Long(__retval)));
}
private native static long __m2(long __imp, long elements);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAANodeObjectDetails PassageThroDescendingNode(CAAParabolicObjectElements elements)
{
long __retval = 0;
__retval = __m3(0, (elements == null ? 0 : elements.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAANodeObjectDetails(new Long(__retval)));
}
private native static long __m3(long __imp, long elements);
public CAANodes() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAANodes(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAANodes)) return false;
  return implementation.equals(((CAANodes)o).implementation);
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
