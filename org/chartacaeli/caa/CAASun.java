// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAASun extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double GeometricEclipticLongitude(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m0(0, JD, bHighPrecision);
return __retval;
}
private native static double __m0(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double GeometricEclipticLatitude(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m1(0, JD, bHighPrecision);
return __retval;
}
private native static double __m1(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double GeometricEclipticLongitudeJ2000(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m2(0, JD, bHighPrecision);
return __retval;
}
private native static double __m2(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double GeometricEclipticLatitudeJ2000(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m3(0, JD, bHighPrecision);
return __retval;
}
private native static double __m3(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double GeometricFK5EclipticLongitude(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m4(0, JD, bHighPrecision);
return __retval;
}
private native static double __m4(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double GeometricFK5EclipticLatitude(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m5(0, JD, bHighPrecision);
return __retval;
}
private native static double __m5(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double ApparentEclipticLongitude(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m6(0, JD, bHighPrecision);
return __retval;
}
private native static double __m6(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double ApparentEclipticLatitude(double JD, boolean bHighPrecision)
{
double __retval = 0.0;
__retval = __m7(0, JD, bHighPrecision);
return __retval;
}
private native static double __m7(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double VariationGeometricEclipticLongitude(double JD)
{
double __retval = 0.0;
__retval = __m8(0, JD);
return __retval;
}
private native static double __m8(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EquatorialRectangularCoordinatesMeanEquinox(double JD, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m9(0, JD, bHighPrecision);
return (__retval == 0 ? null : new CAA3DCoordinate(Long.valueOf(__retval)));
}
private native static long __m9(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EclipticRectangularCoordinatesJ2000(double JD, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m10(0, JD, bHighPrecision);
return (__retval == 0 ? null : new CAA3DCoordinate(Long.valueOf(__retval)));
}
private native static long __m10(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EquatorialRectangularCoordinatesJ2000(double JD, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m11(0, JD, bHighPrecision);
return (__retval == 0 ? null : new CAA3DCoordinate(Long.valueOf(__retval)));
}
private native static long __m11(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EquatorialRectangularCoordinatesB1950(double JD, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m12(0, JD, bHighPrecision);
return (__retval == 0 ? null : new CAA3DCoordinate(Long.valueOf(__retval)));
}
private native static long __m12(long __imp, double JD, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EquatorialRectangularCoordinatesAnyEquinox(double JD, double JDEquinox, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m13(0, JD, JDEquinox, bHighPrecision);
return (__retval == 0 ? null : new CAA3DCoordinate(Long.valueOf(__retval)));
}
private native static long __m13(long __imp, double JD, double JDEquinox, boolean bHighPrecision);
public CAASun() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAASun(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAASun)) return false;
  return implementation.equals(((CAASun)o).implementation);
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
