// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAASelenographicMoonDetails extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public double l0()
{
double __retval = 0.0;
__retval = __m0(implementation.longValue());
return __retval;
}
private native double __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double b0()
{
double __retval = 0.0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native double __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double c0()
{
double __retval = 0.0;
__retval = __m2(implementation.longValue());
return __retval;
}
private native double __m2(long __imp);
public CAASelenographicMoonDetails() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAASelenographicMoonDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAASelenographicMoonDetails)) return false;
  return implementation.equals(((CAASelenographicMoonDetails)o).implementation);
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
