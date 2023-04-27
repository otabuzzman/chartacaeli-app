// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAEquinoxesAndSolstices extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double NorthwardEquinox(long Year, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m0(0, Year, bHighPrecision);
return __retval;
}
private native static double __m0(long __imp, long Year, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double NorthernSolstice(long Year, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m1(0, Year, bHighPrecision);
return __retval;
}
private native static double __m1(long __imp, long Year, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double SouthwardEquinox(long Year, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m2(0, Year, bHighPrecision);
return __retval;
}
private native static double __m2(long __imp, long Year, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double SouthernSolstice(long Year, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m3(0, Year, bHighPrecision);
return __retval;
}
private native static double __m3(long __imp, long Year, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double LengthOfSpring(long Year, boolean bNorthernHemisphere, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m4(0, Year, bNorthernHemisphere, bHighPrecision);
return __retval;
}
private native static double __m4(long __imp, long Year, boolean bNorthernHemisphere, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double LengthOfSummer(long Year, boolean bNorthernHemisphere, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m5(0, Year, bNorthernHemisphere, bHighPrecision);
return __retval;
}
private native static double __m5(long __imp, long Year, boolean bNorthernHemisphere, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double LengthOfAutumn(long Year, boolean bNorthernHemisphere, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m6(0, Year, bNorthernHemisphere, bHighPrecision);
return __retval;
}
private native static double __m6(long __imp, long Year, boolean bNorthernHemisphere, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double LengthOfWinter(long Year, boolean bNorthernHemisphere, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m7(0, Year, bNorthernHemisphere, bHighPrecision);
return __retval;
}
private native static double __m7(long __imp, long Year, boolean bNorthernHemisphere, boolean bHighPrecision);
public CAAEquinoxesAndSolstices() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAEquinoxesAndSolstices(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAEquinoxesAndSolstices)) return false;
  return implementation.equals(((CAAEquinoxesAndSolstices)o).implementation);
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
