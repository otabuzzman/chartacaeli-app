// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAARefraction extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double RefractionFromApparent(double Altitude, double Pressure, double Temperature)
{
double __retval = 0.0;
__retval = __m0(0, Altitude, Pressure, Temperature);
return __retval;
}
private native static double __m0(long __imp, double Altitude, double Pressure, double Temperature);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RefractionFromTrue(double Altitude, double Pressure, double Temperature)
{
double __retval = 0.0;
__retval = __m1(0, Altitude, Pressure, Temperature);
return __retval;
}
private native static double __m1(long __imp, double Altitude, double Pressure, double Temperature);
public CAARefraction() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAARefraction(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAARefraction)) return false;
  return implementation.equals(((CAARefraction)o).implementation);
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
