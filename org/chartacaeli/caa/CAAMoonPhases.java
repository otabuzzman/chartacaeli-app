// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAMoonPhases extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double K(double Year)
{
double __retval = 0.0;
__retval = __m0(0, Year);
return __retval;
}
private native static double __m0(long __imp, double Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanPhase(double k)
{
double __retval = 0.0;
__retval = __m1(0, k);
return __retval;
}
private native static double __m1(long __imp, double k);
/**

This method may <var>not</var> be extended in Java.
*/
public static double TruePhase(double k)
{
double __retval = 0.0;
__retval = __m2(0, k);
return __retval;
}
private native static double __m2(long __imp, double k);
public CAAMoonPhases() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAMoonPhases(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAMoonPhases)) return false;
  return implementation.equals(((CAAMoonPhases)o).implementation);
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
