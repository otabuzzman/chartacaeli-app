// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAJewishCalendar extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAACalendarDate DateOfPesach(long Year, boolean bGregorianCalendar)
{
long __retval = 0;
__retval = __m0(0, Year, bGregorianCalendar);
return (__retval == 0 ? null : new CAACalendarDate(new Long(__retval)));
}
private native static long __m0(long __imp, long Year, boolean bGregorianCalendar);
/**

This method may <var>not</var> be extended in Java.
*/
public static boolean IsLeap(long Year)
{
boolean __retval = false;
__retval = __m1(0, Year);
return __retval;
}
private native static boolean __m1(long __imp, long Year);
/**

This method may <var>not</var> be extended in Java.
*/
public static long DaysInYear(long Year)
{
long __retval = 0;
__retval = __m2(0, Year);
return __retval;
}
private native static long __m2(long __imp, long Year);
public CAAJewishCalendar() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAJewishCalendar(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAJewishCalendar)) return false;
  return implementation.equals(((CAAJewishCalendar)o).implementation);
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
