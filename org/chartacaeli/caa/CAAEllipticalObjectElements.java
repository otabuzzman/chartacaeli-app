// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAEllipticalObjectElements extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public double a()
{
double __retval = 0.0;
__retval = __m0(implementation.longValue());
return __retval;
}
private native double __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double e()
{
double __retval = 0.0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native double __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double i()
{
double __retval = 0.0;
__retval = __m2(implementation.longValue());
return __retval;
}
private native double __m2(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double w()
{
double __retval = 0.0;
__retval = __m3(implementation.longValue());
return __retval;
}
private native double __m3(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double omega()
{
double __retval = 0.0;
__retval = __m4(implementation.longValue());
return __retval;
}
private native double __m4(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double JDEquinox()
{
double __retval = 0.0;
__retval = __m5(implementation.longValue());
return __retval;
}
private native double __m5(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double T()
{
double __retval = 0.0;
__retval = __m6(implementation.longValue());
return __retval;
}
private native double __m6(long __imp);
public CAAEllipticalObjectElements() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAEllipticalObjectElements(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAEllipticalObjectElements)) return false;
  return implementation.equals(((CAAEllipticalObjectElements)o).implementation);
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
