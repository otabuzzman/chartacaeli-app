// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAPrecession extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate PrecessEquatorial(double Alpha, double Delta, double JD0, double JD)
{
long __retval = 0;
__retval = __m0(0, Alpha, Delta, JD0, JD);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m0(long __imp, double Alpha, double Delta, double JD0, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate PrecessEquatorialFK4(double Alpha, double Delta, double JD0, double JD)
{
long __retval = 0;
__retval = __m1(0, Alpha, Delta, JD0, JD);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m1(long __imp, double Alpha, double Delta, double JD0, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate PrecessEcliptic(double Lambda, double Beta, double JD0, double JD)
{
long __retval = 0;
__retval = __m2(0, Lambda, Beta, JD0, JD);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m2(long __imp, double Lambda, double Beta, double JD0, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate EquatorialPMToEcliptic(double Alpha, double Delta, double Beta, double PMAlpha, double PMDelta, double Epsilon)
{
long __retval = 0;
__retval = __m3(0, Alpha, Delta, Beta, PMAlpha, PMDelta, Epsilon);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m3(long __imp, double Alpha, double Delta, double Beta, double PMAlpha, double PMDelta, double Epsilon);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate AdjustPositionUsingUniformProperMotion(double t, double Alpha, double Delta, double PMAlpha, double PMDelta)
{
long __retval = 0;
__retval = __m4(0, t, Alpha, Delta, PMAlpha, PMDelta);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m4(long __imp, double t, double Alpha, double Delta, double PMAlpha, double PMDelta);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate AdjustPositionUsingMotionInSpace(double r, double deltar, double t, double Alpha, double Delta, double PMAlpha, double PMDelta)
{
long __retval = 0;
__retval = __m5(0, r, deltar, t, Alpha, Delta, PMAlpha, PMDelta);
return (__retval == 0 ? null : new CAA2DCoordinate(new Long(__retval)));
}
private native static long __m5(long __imp, double r, double deltar, double t, double Alpha, double Delta, double PMAlpha, double PMDelta);
public CAAPrecession() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAPrecession(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAPrecession)) return false;
  return implementation.equals(((CAAPrecession)o).implementation);
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
