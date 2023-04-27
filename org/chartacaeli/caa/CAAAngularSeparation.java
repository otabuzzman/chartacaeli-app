// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAAngularSeparation extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double Separation(double Alpha1, double Delta1, double Alpha2, double Delta2)
{
double __retval = 0.0;
__retval = __m0(0, Alpha1, Delta1, Alpha2, Delta2);
return __retval;
}
private native static double __m0(long __imp, double Alpha1, double Delta1, double Alpha2, double Delta2);
/**

This method may <var>not</var> be extended in Java.
*/
public static double PositionAngle(double Alpha1, double Delta1, double Alpha2, double Delta2)
{
double __retval = 0.0;
__retval = __m1(0, Alpha1, Delta1, Alpha2, Delta2);
return __retval;
}
private native static double __m1(long __imp, double Alpha1, double Delta1, double Alpha2, double Delta2);
/**

This method may <var>not</var> be extended in Java.
*/
public static double DistanceFromGreatArc(double Alpha1, double Delta1, double Alpha2, double Delta2, double Alpha3, double Delta3)
{
double __retval = 0.0;
__retval = __m2(0, Alpha1, Delta1, Alpha2, Delta2, Alpha3, Delta3);
return __retval;
}
private native static double __m2(long __imp, double Alpha1, double Delta1, double Alpha2, double Delta2, double Alpha3, double Delta3);
/**

This method may <var>not</var> be extended in Java.
*/
public static double SmallestCircle(double Alpha1, double Delta1, double Alpha2, double Delta2, double Alpha3, double Delta3, boolean[] bType1)
{
double __retval = 0.0;
__retval = __m3(0, Alpha1, Delta1, Alpha2, Delta2, Alpha3, Delta3, bType1);
return __retval;
}
private native static double __m3(long __imp, double Alpha1, double Delta1, double Alpha2, double Delta2, double Alpha3, double Delta3, boolean[] bType1);
public CAAAngularSeparation() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAAngularSeparation(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAAngularSeparation)) return false;
  return implementation.equals(((CAAAngularSeparation)o).implementation);
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
