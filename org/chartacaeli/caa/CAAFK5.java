// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAFK5 extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double CorrectionInLongitude(double Longitude, double Latitude, double JD)
{
double __retval = 0.0;
__retval = __m0(0, Longitude, Latitude, JD);
return __retval;
}
private native static double __m0(long __imp, double Longitude, double Latitude, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double CorrectionInLatitude(double Longitude, double JD)
{
double __retval = 0.0;
__retval = __m1(0, Longitude, JD);
return __retval;
}
private native static double __m1(long __imp, double Longitude, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate ConvertVSOPToFK5J2000(CAA3DCoordinate value)
{
long __retval = 0;
__retval = __m2(0, (value == null ? 0 : value.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m2(long __imp, long value);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate ConvertVSOPToFK5B1950(CAA3DCoordinate value)
{
long __retval = 0;
__retval = __m3(0, (value == null ? 0 : value.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m3(long __imp, long value);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate ConvertVSOPToFK5AnyEquinox(CAA3DCoordinate value, double JDEquinox)
{
long __retval = 0;
__retval = __m4(0, (value == null ? 0 : value.getCxxwrapImpl().longValue()), JDEquinox);
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m4(long __imp, long value, double JDEquinox);
public CAAFK5() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAFK5(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAFK5)) return false;
  return implementation.equals(((CAAFK5)o).implementation);
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
