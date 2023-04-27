// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAANodeObjectDetails extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public double t()
{
double __retval = 0.0;
__retval = __m0(implementation.longValue());
return __retval;
}
private native double __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double radius()
{
double __retval = 0.0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native double __m1(long __imp);
public CAANodeObjectDetails() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAANodeObjectDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAANodeObjectDetails)) return false;
  return implementation.equals(((CAANodeObjectDetails)o).implementation);
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
