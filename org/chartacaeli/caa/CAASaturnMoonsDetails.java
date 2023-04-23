// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAASaturnMoonsDetails extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public CAASaturnMoonDetail Satellite1()
{
long __retval = 0;
__retval = __m0(implementation.longValue());
return (__retval == 0 ? null : new CAASaturnMoonDetail(new Long(__retval)));
}
private native long __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAASaturnMoonDetail Satellite2()
{
long __retval = 0;
__retval = __m1(implementation.longValue());
return (__retval == 0 ? null : new CAASaturnMoonDetail(new Long(__retval)));
}
private native long __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAASaturnMoonDetail Satellite3()
{
long __retval = 0;
__retval = __m2(implementation.longValue());
return (__retval == 0 ? null : new CAASaturnMoonDetail(new Long(__retval)));
}
private native long __m2(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAASaturnMoonDetail Satellite4()
{
long __retval = 0;
__retval = __m3(implementation.longValue());
return (__retval == 0 ? null : new CAASaturnMoonDetail(new Long(__retval)));
}
private native long __m3(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAASaturnMoonDetail Satellite5()
{
long __retval = 0;
__retval = __m4(implementation.longValue());
return (__retval == 0 ? null : new CAASaturnMoonDetail(new Long(__retval)));
}
private native long __m4(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAASaturnMoonDetail Satellite6()
{
long __retval = 0;
__retval = __m5(implementation.longValue());
return (__retval == 0 ? null : new CAASaturnMoonDetail(new Long(__retval)));
}
private native long __m5(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAASaturnMoonDetail Satellite7()
{
long __retval = 0;
__retval = __m6(implementation.longValue());
return (__retval == 0 ? null : new CAASaturnMoonDetail(new Long(__retval)));
}
private native long __m6(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAASaturnMoonDetail Satellite8()
{
long __retval = 0;
__retval = __m7(implementation.longValue());
return (__retval == 0 ? null : new CAASaturnMoonDetail(new Long(__retval)));
}
private native long __m7(long __imp);
public CAASaturnMoonsDetails() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAASaturnMoonsDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAASaturnMoonsDetails)) return false;
  return implementation.equals(((CAASaturnMoonsDetails)o).implementation);
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
