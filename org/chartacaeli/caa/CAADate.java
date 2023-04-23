// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAADate extends Object {
/**Enums*/
public final static int SUNDAY = 0;
public final static int MONDAY = 1;
public final static int TUESDAY = 2;
public final static int WEDNESDAY = 3;
public final static int THURSDAY = 4;
public final static int FRIDAY = 5;
public final static int SATURDAY = 6;
/**Constructors / Destructors*/
public CAADate()
{
implementation = new Long(__c1());
}
private native long __c1();
/***/
public CAADate(long Year, long Month, double Day, boolean bGregorianCalendar)
{
implementation = new Long(__c2(Year, Month, Day, bGregorianCalendar));
}
private native long __c2(long Year, long Month, double Day, boolean bGregorianCalendar);
/***/
public CAADate(long Year, long Month, double Day, double Hour, double Minute, double Second, boolean bGregorianCalendar)
{
implementation = new Long(__c3(Year, Month, Day, Hour, Minute, Second, bGregorianCalendar));
}
private native long __c3(long Year, long Month, double Day, double Hour, double Minute, double Second, boolean bGregorianCalendar);
/***/
public CAADate(double JD, boolean bGregorianCalendar)
{
implementation = new Long(__c4(JD, bGregorianCalendar));
}
private native long __c4(double JD, boolean bGregorianCalendar);
/**Static Methods

This method may <var>not</var> be extended in Java.
*/
public static double DateToJD(long Year, long Month, double Day, boolean bGregorianCalendar)
{
double __retval = 0.0;
__retval = __m5(0, Year, Month, Day, bGregorianCalendar);
return __retval;
}
private native static double __m5(long __imp, long Year, long Month, double Day, boolean bGregorianCalendar);
/**

This method may <var>not</var> be extended in Java.
*/
public static boolean IsLeap(long Year, boolean bGregorianCalendar)
{
boolean __retval = false;
__retval = __m6(0, Year, bGregorianCalendar);
return __retval;
}
private native static boolean __m6(long __imp, long Year, boolean bGregorianCalendar);
/**

This method may <var>not</var> be extended in Java.
*/
public static void DayOfYearToDayAndMonth(long DayOfYear, boolean bLeap, long[] DayOfMonth, long[] Month)
{
__m7(0, DayOfYear, bLeap, DayOfMonth, Month);
}
private native static void __m7(long __imp, long DayOfYear, boolean bLeap, long[] DayOfMonth, long[] Month);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAACalendarDate JulianToGregorian(long Year, long Month, long Day)
{
long __retval = 0;
__retval = __m8(0, Year, Month, Day);
return (__retval == 0 ? null : new CAACalendarDate(new Long(__retval)));
}
private native static long __m8(long __imp, long Year, long Month, long Day);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAACalendarDate GregorianToJulian(long Year, long Month, long Day)
{
long __retval = 0;
__retval = __m9(0, Year, Month, Day);
return (__retval == 0 ? null : new CAACalendarDate(new Long(__retval)));
}
private native static long __m9(long __imp, long Year, long Month, long Day);
/**

This method may <var>not</var> be extended in Java.
*/
public static long INT(double value)
{
long __retval = 0;
__retval = __m10(0, value);
return __retval;
}
private native static long __m10(long __imp, double value);
/**

This method may <var>not</var> be extended in Java.
*/
public static boolean AfterPapalReform(long Year, long Month, double Day)
{
boolean __retval = false;
__retval = __m11(0, Year, Month, Day);
return __retval;
}
private native static boolean __m11(long __imp, long Year, long Month, double Day);
/**

This method may <var>not</var> be extended in Java.
*/
public static boolean AfterPapalReform(double JD)
{
boolean __retval = false;
__retval = __m12(0, JD);
return __retval;
}
private native static boolean __m12(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double DayOfYear(double JD, long Year, boolean bGregorianCalendar)
{
double __retval = 0.0;
__retval = __m13(0, JD, Year, bGregorianCalendar);
return __retval;
}
private native static double __m13(long __imp, double JD, long Year, boolean bGregorianCalendar);
/**

This method may <var>not</var> be extended in Java.
*/
public static long DaysInMonth(long Month, boolean bLeap)
{
long __retval = 0;
__retval = __m14(0, Month, bLeap);
return __retval;
}
private native static long __m14(long __imp, long Month, boolean bLeap);
/**

This method may <var>not</var> be extended in Java.
*/
public double Julian()
{
double __retval = 0.0;
__retval = __m15(implementation.longValue());
return __retval;
}
private native double __m15(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public long Day()
{
long __retval = 0;
__retval = __m17(implementation.longValue());
return __retval;
}
private native long __m17(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public long Month()
{
long __retval = 0;
__retval = __m18(implementation.longValue());
return __retval;
}
private native long __m18(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public long Year()
{
long __retval = 0;
__retval = __m19(implementation.longValue());
return __retval;
}
private native long __m19(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public long Hour()
{
long __retval = 0;
__retval = __m20(implementation.longValue());
return __retval;
}
private native long __m20(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public long Minute()
{
long __retval = 0;
__retval = __m21(implementation.longValue());
return __retval;
}
private native long __m21(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double Second()
{
double __retval = 0.0;
__retval = __m22(implementation.longValue());
return __retval;
}
private native double __m22(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public void Set(long Year, long Month, double Day, double Hour, double Minute, double Second, boolean bGregorianCalendar)
{
__m23(implementation.longValue(), Year, Month, Day, Hour, Minute, Second, bGregorianCalendar);
}
private native void __m23(long __imp, long Year, long Month, double Day, double Hour, double Minute, double Second, boolean bGregorianCalendar);
/**

This method may <var>not</var> be extended in Java.
*/
public void Set(double JD, boolean bGregorianCalendar)
{
__m24(implementation.longValue(), JD, bGregorianCalendar);
}
private native void __m24(long __imp, double JD, boolean bGregorianCalendar);
/**

This method may <var>not</var> be extended in Java.
*/
public void SetInGregorianCalendar(boolean bGregorianCalendar)
{
__m25(implementation.longValue(), bGregorianCalendar);
}
private native void __m25(long __imp, boolean bGregorianCalendar);
/**

This method may <var>not</var> be extended in Java.
*/
public void Get(long[] Year, long[] Month, long[] Day, long[] Hour, long[] Minute, double[] Second)
{
__m26(implementation.longValue(), Year, Month, Day, Hour, Minute, Second);
}
private native void __m26(long __imp, long[] Year, long[] Month, long[] Day, long[] Hour, long[] Minute, double[] Second);
/**

This method may <var>not</var> be extended in Java.
*/
public int DayOfWeek()
{
int __retval = 0;
__retval = __m27(implementation.longValue());
return __retval;
}
private native int __m27(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double DayOfYear()
{
double __retval = 0.0;
__retval = __m28(implementation.longValue());
return __retval;
}
private native double __m28(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public long DaysInMonth()
{
long __retval = 0;
__retval = __m29(implementation.longValue());
return __retval;
}
private native long __m29(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public long DaysInYear()
{
long __retval = 0;
__retval = __m30(implementation.longValue());
return __retval;
}
private native long __m30(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public boolean Leap()
{
boolean __retval = false;
__retval = __m31(implementation.longValue());
return __retval;
}
private native boolean __m31(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public boolean InGregorianCalendar()
{
boolean __retval = false;
__retval = __m32(implementation.longValue());
return __retval;
}
private native boolean __m32(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double FractionalYear()
{
double __retval = 0.0;
__retval = __m33(implementation.longValue());
return __retval;
}
private native double __m33(long __imp);
// cxxwrap ctor, do not use
public CAADate(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAADate)) return false;
  return implementation.equals(((CAADate)o).implementation);
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
