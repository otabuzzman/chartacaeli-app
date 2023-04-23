// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAPhysicalMarsDetails extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public double DE()
{
double __retval = 0.0;
__retval = __m0(implementation.longValue());
return __retval;
}
private native double __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double DS()
{
double __retval = 0.0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native double __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double w()
{
double __retval = 0.0;
__retval = __m2(implementation.longValue());
return __retval;
}
private native double __m2(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double P()
{
double __retval = 0.0;
__retval = __m3(implementation.longValue());
return __retval;
}
private native double __m3(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double X()
{
double __retval = 0.0;
__retval = __m4(implementation.longValue());
return __retval;
}
private native double __m4(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double k()
{
double __retval = 0.0;
__retval = __m5(implementation.longValue());
return __retval;
}
private native double __m5(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double q()
{
double __retval = 0.0;
__retval = __m6(implementation.longValue());
return __retval;
}
private native double __m6(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double d()
{
double __retval = 0.0;
__retval = __m7(implementation.longValue());
return __retval;
}
private native double __m7(long __imp);
public CAAPhysicalMarsDetails() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAPhysicalMarsDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAPhysicalMarsDetails)) return false;
  return implementation.equals(((CAAPhysicalMarsDetails)o).implementation);
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
