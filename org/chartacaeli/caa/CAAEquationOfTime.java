// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAEquationOfTime extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double Calculate(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m0(0, JD, bHighPrecision);
return __retval;
}
private native static double __m0(long __imp, double JD, boolean bHighPrecision);
public CAAEquationOfTime() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAEquationOfTime(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAEquationOfTime)) return false;
  return implementation.equals(((CAAEquationOfTime)o).implementation);
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