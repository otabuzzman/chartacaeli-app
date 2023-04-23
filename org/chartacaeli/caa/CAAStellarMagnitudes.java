// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAStellarMagnitudes extends Object {
/**functions

This method may <var>not</var> be extended in Java.
*/
public static double CombinedMagnitude(double m1, double m2)
{
double __retval = 0.0;
__retval = __m0(0, m1, m2);
return __retval;
}
private native static double __m0(long __imp, double m1, double m2);
/**

This method may <var>not</var> be extended in Java.
*/
public static double CombinedMagnitude(int Magnitudes, double[] pMagnitudes)
{
double __retval = 0.0;
__retval = __m1(0, Magnitudes, pMagnitudes);
return __retval;
}
private native static double __m1(long __imp, int Magnitudes, double[] pMagnitudes);
/**

This method may <var>not</var> be extended in Java.
*/
public static double BrightnessRatio(double m1, double m2)
{
double __retval = 0.0;
__retval = __m2(0, m1, m2);
return __retval;
}
private native static double __m2(long __imp, double m1, double m2);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MagnitudeDifference(double brightnessRatio)
{
double __retval = 0.0;
__retval = __m3(0, brightnessRatio);
return __retval;
}
private native static double __m3(long __imp, double brightnessRatio);
public CAAStellarMagnitudes() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAStellarMagnitudes(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAStellarMagnitudes)) return false;
  return implementation.equals(((CAAStellarMagnitudes)o).implementation);
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
