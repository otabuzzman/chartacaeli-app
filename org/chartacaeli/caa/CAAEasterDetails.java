// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAEasterDetails extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public long Month()
{
long __retval = 0;
__retval = __m0(implementation.longValue());
return __retval;
}
private native long __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public long Day()
{
long __retval = 0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native long __m1(long __imp);
public CAAEasterDetails() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAEasterDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAEasterDetails)) return false;
  return implementation.equals(((CAAEasterDetails)o).implementation);
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
