// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAA2DCoordinate extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public double X()
{
double __retval = 0.0;
__retval = __m0(implementation.longValue());
return __retval;
}
private native double __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double Y()
{
double __retval = 0.0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native double __m1(long __imp);
public CAA2DCoordinate() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAA2DCoordinate(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAA2DCoordinate)) return false;
  return implementation.equals(((CAA2DCoordinate)o).implementation);
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
