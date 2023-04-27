// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAADynamicalTime extends Object {
/**

This method may <var>not</var> be extended in Java.
*/
public static double DeltaT(double JD)
{
double __retval = 0.0;
__retval = __m1(0, JD);
return __retval;
}
private native static double __m1(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double CumulativeLeapSeconds(double JD)
{
double __retval = 0.0;
__retval = __m2(0, JD);
return __retval;
}
private native static double __m2(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double TT2UTC(double JD)
{
double __retval = 0.0;
__retval = __m3(0, JD);
return __retval;
}
private native static double __m3(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double UTC2TT(double JD)
{
double __retval = 0.0;
__retval = __m4(0, JD);
return __retval;
}
private native static double __m4(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double TT2TAI(double JD)
{
double __retval = 0.0;
__retval = __m5(0, JD);
return __retval;
}
private native static double __m5(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double TAI2TT(double JD)
{
double __retval = 0.0;
__retval = __m6(0, JD);
return __retval;
}
private native static double __m6(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double TT2UT1(double JD)
{
double __retval = 0.0;
__retval = __m7(0, JD);
return __retval;
}
private native static double __m7(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double UT12TT(double JD)
{
double __retval = 0.0;
__retval = __m8(0, JD);
return __retval;
}
private native static double __m8(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double UT1MinusUTC(double JD)
{
double __retval = 0.0;
__retval = __m9(0, JD);
return __retval;
}
private native static double __m9(long __imp, double JD);
public CAADynamicalTime() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAADynamicalTime(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAADynamicalTime)) return false;
  return implementation.equals(((CAADynamicalTime)o).implementation);
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
