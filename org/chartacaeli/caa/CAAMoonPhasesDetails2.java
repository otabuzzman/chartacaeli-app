// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAMoonPhasesDetails2 extends Object {
/**Enums*/
public final static int NotDefined = 0;
public final static int NewMoon = 1;
public final static int FirstQuarter = 2;
public final static int FullMoon = 3;
public final static int LastQuarter = 4;
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public int type()
{
int __retval = 0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native int __m1(long __imp);
/**The type of the event which has occurred

This method may <var>not</var> be extended in Java.
*/
public double JD()
{
double __retval = 0.0;
__retval = __m2(implementation.longValue());
return __retval;
}
private native double __m2(long __imp);
public CAAMoonPhasesDetails2() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAMoonPhasesDetails2(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAMoonPhasesDetails2)) return false;
  return implementation.equals(((CAAMoonPhasesDetails2)o).implementation);
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
