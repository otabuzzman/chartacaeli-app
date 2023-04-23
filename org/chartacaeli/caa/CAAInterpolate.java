// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAInterpolate extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double Interpolate(double n, double Y1, double Y2, double Y3)
{
double __retval = 0.0;
__retval = __m0(0, n, Y1, Y2, Y3);
return __retval;
}
private native static double __m0(long __imp, double n, double Y1, double Y2, double Y3);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Interpolate(double n, double Y1, double Y2, double Y3, double Y4, double Y5)
{
double __retval = 0.0;
__retval = __m1(0, n, Y1, Y2, Y3, Y4, Y5);
return __retval;
}
private native static double __m1(long __imp, double n, double Y1, double Y2, double Y3, double Y4, double Y5);
/**

This method may <var>not</var> be extended in Java.
*/
public static double InterpolateToHalves(double Y1, double Y2, double Y3, double Y4)
{
double __retval = 0.0;
__retval = __m2(0, Y1, Y2, Y3, Y4);
return __retval;
}
private native static double __m2(long __imp, double Y1, double Y2, double Y3, double Y4);
/**

This method may <var>not</var> be extended in Java.
*/
public static double LagrangeInterpolate(double X, int n, double[] pX, double[] pY)
{
double __retval = 0.0;
__retval = __m3(0, X, n, pX, pY);
return __retval;
}
private native static double __m3(long __imp, double X, int n, double[] pX, double[] pY);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Extremum(double Y1, double Y2, double Y3, double[] nm)
{
double __retval = 0.0;
__retval = __m4(0, Y1, Y2, Y3, nm);
return __retval;
}
private native static double __m4(long __imp, double Y1, double Y2, double Y3, double[] nm);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Extremum(double Y1, double Y2, double Y3, double Y4, double Y5, double[] nm, double epsilon)
{
double __retval = 0.0;
__retval = __m5(0, Y1, Y2, Y3, Y4, Y5, nm, epsilon);
return __retval;
}
private native static double __m5(long __imp, double Y1, double Y2, double Y3, double Y4, double Y5, double[] nm, double epsilon);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Zero(double Y1, double Y2, double Y3, double epsilon)
{
double __retval = 0.0;
__retval = __m6(0, Y1, Y2, Y3, epsilon);
return __retval;
}
private native static double __m6(long __imp, double Y1, double Y2, double Y3, double epsilon);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Zero(double Y1, double Y2, double Y3, double Y4, double Y5, double epsilon)
{
double __retval = 0.0;
__retval = __m7(0, Y1, Y2, Y3, Y4, Y5, epsilon);
return __retval;
}
private native static double __m7(long __imp, double Y1, double Y2, double Y3, double Y4, double Y5, double epsilon);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Zero2(double Y1, double Y2, double Y3, double epsilon)
{
double __retval = 0.0;
__retval = __m8(0, Y1, Y2, Y3, epsilon);
return __retval;
}
private native static double __m8(long __imp, double Y1, double Y2, double Y3, double epsilon);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Zero2(double Y1, double Y2, double Y3, double Y4, double Y5, double epsilon)
{
double __retval = 0.0;
__retval = __m9(0, Y1, Y2, Y3, Y4, Y5, epsilon);
return __retval;
}
private native static double __m9(long __imp, double Y1, double Y2, double Y3, double Y4, double Y5, double epsilon);
public CAAInterpolate() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAInterpolate(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAInterpolate)) return false;
  return implementation.equals(((CAAInterpolate)o).implementation);
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
