// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAASaturnMoonDetail extends Object {
/**

This method may <var>not</var> be extended in Java.
*/
public CAA3DCoordinate TrueRectangularCoordinates()
{
long __retval = 0;
__retval = __m0(implementation.longValue());
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native long __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAA3DCoordinate ApparentRectangularCoordinates()
{
long __retval = 0;
__retval = __m1(implementation.longValue());
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native long __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public boolean bInTransit()
{
boolean __retval = false;
__retval = __m2(implementation.longValue());
return __retval;
}
private native boolean __m2(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public boolean bInOccultation()
{
boolean __retval = false;
__retval = __m3(implementation.longValue());
return __retval;
}
private native boolean __m3(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public boolean bInEclipse()
{
boolean __retval = false;
__retval = __m4(implementation.longValue());
return __retval;
}
private native boolean __m4(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public boolean bInShadowTransit()
{
boolean __retval = false;
__retval = __m5(implementation.longValue());
return __retval;
}
private native boolean __m5(long __imp);
public CAASaturnMoonDetail() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAASaturnMoonDetail(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAASaturnMoonDetail)) return false;
  return implementation.equals(((CAASaturnMoonDetail)o).implementation);
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
