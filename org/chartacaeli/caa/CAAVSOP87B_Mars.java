// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAVSOP87B_Mars extends Object {
/**

This method may <var>not</var> be extended in Java.
*/
public static double L(double JD)
{
double __retval = 0.0;
__retval = __m0(0, JD);
return __retval;
}
private native static double __m0(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double L_DASH(double JD)
{
double __retval = 0.0;
__retval = __m1(0, JD);
return __retval;
}
private native static double __m1(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double B(double JD)
{
double __retval = 0.0;
__retval = __m2(0, JD);
return __retval;
}
private native static double __m2(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double B_DASH(double JD)
{
double __retval = 0.0;
__retval = __m3(0, JD);
return __retval;
}
private native static double __m3(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double R(double JD)
{
double __retval = 0.0;
__retval = __m4(0, JD);
return __retval;
}
private native static double __m4(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double R_DASH(double JD)
{
double __retval = 0.0;
__retval = __m5(0, JD);
return __retval;
}
private native static double __m5(long __imp, double JD);
public CAAVSOP87B_Mars() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAVSOP87B_Mars(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAVSOP87B_Mars)) return false;
  return implementation.equals(((CAAVSOP87B_Mars)o).implementation);
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
