// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAELPMPP02 extends Object {
/**Enums*/
public final static int Nominal = 0;
public final static int LLR = Nominal + 1;
public final static int DE405 = LLR + 1;
public final static int DE406 = DE405 + 1;
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLongitude(double JD, int correction, double[] pDerivative)
{
double __retval = 0.0;
__retval = __m1(0, JD, correction, pDerivative);
return __retval;
}
private native static double __m1(long __imp, double JD, int correction, double[] pDerivative);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLongitude(double[] pT, int nTSize, int correction, double[] pDerivative)
{
double __retval = 0.0;
__retval = __m2(0, pT, nTSize, correction, pDerivative);
return __retval;
}
private native static double __m2(long __imp, double[] pT, int nTSize, int correction, double[] pDerivative);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLatitude(double JD, int correction, double[] pDerivative)
{
double __retval = 0.0;
__retval = __m3(0, JD, correction, pDerivative);
return __retval;
}
private native static double __m3(long __imp, double JD, int correction, double[] pDerivative);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLatitude(double[] pT, int nTSize, int correction, double[] pDerivative)
{
double __retval = 0.0;
__retval = __m4(0, pT, nTSize, correction, pDerivative);
return __retval;
}
private native static double __m4(long __imp, double[] pT, int nTSize, int correction, double[] pDerivative);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiusVector(double JD, int correction, double[] pDerivative)
{
double __retval = 0.0;
__retval = __m5(0, JD, correction, pDerivative);
return __retval;
}
private native static double __m5(long __imp, double JD, int correction, double[] pDerivative);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiusVector(double[] pT, int nTSize, int correction, double[] pDerivative)
{
double __retval = 0.0;
__retval = __m6(0, pT, nTSize, correction, pDerivative);
return __retval;
}
private native static double __m6(long __imp, double[] pT, int nTSize, int correction, double[] pDerivative);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EclipticRectangularCoordinates(double JD, int correction, CAA3DCoordinate pDerivative)
{
long __retval = 0;
__retval = __m7(0, JD, correction, (pDerivative == null ? 0 : pDerivative.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m7(long __imp, double JD, int correction, long pDerivative);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EclipticRectangularCoordinates(double[] pT, int nTSize, int correction, CAA3DCoordinate pDerivative)
{
long __retval = 0;
__retval = __m8(0, pT, nTSize, correction, (pDerivative == null ? 0 : pDerivative.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m8(long __imp, double[] pT, int nTSize, int correction, long pDerivative);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EclipticRectangularCoordinatesJ2000(double JD, int correction, CAA3DCoordinate pDerivative)
{
long __retval = 0;
__retval = __m9(0, JD, correction, (pDerivative == null ? 0 : pDerivative.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m9(long __imp, double JD, int correction, long pDerivative);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EclipticRectangularCoordinatesJ2000(double[] pT, int nTSize, int correction, CAA3DCoordinate pDerivative)
{
long __retval = 0;
__retval = __m10(0, pT, nTSize, correction, (pDerivative == null ? 0 : pDerivative.getCxxwrapImpl().longValue()));
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m10(long __imp, double[] pT, int nTSize, int correction, long pDerivative);
public CAAELPMPP02() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAELPMPP02(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAELPMPP02)) return false;
  return implementation.equals(((CAAELPMPP02)o).implementation);
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
