// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAVSOP87A_Mercury extends Object {
/**

This method may <var>not</var> be extended in Java.
*/
public static double X(double JD)
{
double __retval = 0.0;
__retval = __m0(0, JD);
return __retval;
}
private native static double __m0(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double X_DASH(double JD)
{
double __retval = 0.0;
__retval = __m1(0, JD);
return __retval;
}
private native static double __m1(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Y(double JD)
{
double __retval = 0.0;
__retval = __m2(0, JD);
return __retval;
}
private native static double __m2(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Y_DASH(double JD)
{
double __retval = 0.0;
__retval = __m3(0, JD);
return __retval;
}
private native static double __m3(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Z(double JD)
{
double __retval = 0.0;
__retval = __m4(0, JD);
return __retval;
}
private native static double __m4(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Z_DASH(double JD)
{
double __retval = 0.0;
__retval = __m5(0, JD);
return __retval;
}
private native static double __m5(long __imp, double JD);
public CAAVSOP87A_Mercury() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAVSOP87A_Mercury(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAVSOP87A_Mercury)) return false;
  return implementation.equals(((CAAVSOP87A_Mercury)o).implementation);
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
