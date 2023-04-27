// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes ///////////////////////////////////////////////*/
public class CAAAberration extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EarthVelocity(double JD, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m0(0, JD, bHighPrecision);
return (__retval == 0 ? null : new CAA3DCoordinate(Long.valueOf(__retval)));
}
private native static long __m0(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate EclipticAberration(double Alpha, double Delta, double JD, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m1(0, Alpha, Delta, JD, bHighPrecision);
return (__retval == 0 ? null : new CAA2DCoordinate(Long.valueOf(__retval)));
}
private native static long __m1(long __imp, double Alpha, double Delta, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA2DCoordinate EquatorialAberration(double Lambda, double Beta, double JD, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m2(0, Lambda, Beta, JD, bHighPrecision);
return (__retval == 0 ? null : new CAA2DCoordinate(Long.valueOf(__retval)));
}
private native static long __m2(long __imp, double Lambda, double Beta, double JD, boolean bHighPrecision);
public CAAAberration() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAAberration(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAAberration)) return false;
  return implementation.equals(((CAAAberration)o).implementation);
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
