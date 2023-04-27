// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAANutation extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double NutationInLongitude(double JD)
{
double __retval = 0.0;
__retval = __m0(0, JD);
return __retval;
}
private native static double __m0(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double NutationInObliquity(double JD)
{
double __retval = 0.0;
__retval = __m1(0, JD);
return __retval;
}
private native static double __m1(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double NutationInRightAscension(double Alpha, double Delta, double Obliquity, double NutationInLongitude, double NutationInObliquity)
{
double __retval = 0.0;
__retval = __m2(0, Alpha, Delta, Obliquity, NutationInLongitude, NutationInObliquity);
return __retval;
}
private native static double __m2(long __imp, double Alpha, double Delta, double Obliquity, double NutationInLongitude, double NutationInObliquity);
/**

This method may <var>not</var> be extended in Java.
*/
public static double NutationInDeclination(double Alpha, double Obliquity, double NutationInLongitude, double NutationInObliquity)
{
double __retval = 0.0;
__retval = __m3(0, Alpha, Obliquity, NutationInLongitude, NutationInObliquity);
return __retval;
}
private native static double __m3(long __imp, double Alpha, double Obliquity, double NutationInLongitude, double NutationInObliquity);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanObliquityOfEcliptic(double JD)
{
double __retval = 0.0;
__retval = __m4(0, JD);
return __retval;
}
private native static double __m4(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double TrueObliquityOfEcliptic(double JD)
{
double __retval = 0.0;
__retval = __m5(0, JD);
return __retval;
}
private native static double __m5(long __imp, double JD);
public CAANutation() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAANutation(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAANutation)) return false;
  return implementation.equals(((CAANutation)o).implementation);
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
