// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAELP2000 extends Object {
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLongitude(double JD)
{
double __retval = 0.0;
__retval = __m0(0, JD);
return __retval;
}
private native static double __m0(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLongitude(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m1(0, pT, nTSize);
return __retval;
}
private native static double __m1(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLatitude(double JD)
{
double __retval = 0.0;
__retval = __m2(0, JD);
return __retval;
}
private native static double __m2(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double EclipticLatitude(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m3(0, pT, nTSize);
return __retval;
}
private native static double __m3(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiusVector(double JD)
{
double __retval = 0.0;
__retval = __m4(0, JD);
return __retval;
}
private native static double __m4(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double RadiusVector(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m5(0, pT, nTSize);
return __retval;
}
private native static double __m5(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EclipticRectangularCoordinates(double JD)
{
long __retval = 0;
__retval = __m6(0, JD);
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m6(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EclipticRectangularCoordinatesJ2000(double JD)
{
long __retval = 0;
__retval = __m7(0, JD);
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m7(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAA3DCoordinate EquatorialRectangularCoordinatesFK5(double JD)
{
long __retval = 0;
__retval = __m8(0, JD);
return (__retval == 0 ? null : new CAA3DCoordinate(new Long(__retval)));
}
private native static long __m8(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MoonMeanMeanLongitude(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m9(0, pT, nTSize);
return __retval;
}
private native static double __m9(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MoonMeanMeanLongitude(double JD)
{
double __retval = 0.0;
__retval = __m10(0, JD);
return __retval;
}
private native static double __m10(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanLongitudeLunarPerigee(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m11(0, pT, nTSize);
return __retval;
}
private native static double __m11(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanLongitudeLunarPerigee(double JD)
{
double __retval = 0.0;
__retval = __m12(0, JD);
return __retval;
}
private native static double __m12(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanLongitudeLunarAscendingNode(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m13(0, pT, nTSize);
return __retval;
}
private native static double __m13(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanLongitudeLunarAscendingNode(double JD)
{
double __retval = 0.0;
__retval = __m14(0, JD);
return __retval;
}
private native static double __m14(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanHeliocentricMeanLongitudeEarthMoonBarycentre(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m15(0, pT, nTSize);
return __retval;
}
private native static double __m15(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanHeliocentricMeanLongitudeEarthMoonBarycentre(double JD)
{
double __retval = 0.0;
__retval = __m16(0, JD);
return __retval;
}
private native static double __m16(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanLongitudeOfPerihelionOfEarthMoonBarycentre(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m17(0, pT, nTSize);
return __retval;
}
private native static double __m17(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanLongitudeOfPerihelionOfEarthMoonBarycentre(double JD)
{
double __retval = 0.0;
__retval = __m18(0, JD);
return __retval;
}
private native static double __m18(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MoonMeanSolarElongation(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m19(0, pT, nTSize);
return __retval;
}
private native static double __m19(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MoonMeanSolarElongation(double JD)
{
double __retval = 0.0;
__retval = __m20(0, JD);
return __retval;
}
private native static double __m20(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double SunMeanAnomaly(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m21(0, pT, nTSize);
return __retval;
}
private native static double __m21(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double SunMeanAnomaly(double JD)
{
double __retval = 0.0;
__retval = __m22(0, JD);
return __retval;
}
private native static double __m22(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MoonMeanAnomaly(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m23(0, pT, nTSize);
return __retval;
}
private native static double __m23(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MoonMeanAnomaly(double JD)
{
double __retval = 0.0;
__retval = __m24(0, JD);
return __retval;
}
private native static double __m24(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MoonMeanArgumentOfLatitude(double[] pT, int nTSize)
{
double __retval = 0.0;
__retval = __m25(0, pT, nTSize);
return __retval;
}
private native static double __m25(long __imp, double[] pT, int nTSize);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MoonMeanArgumentOfLatitude(double JD)
{
double __retval = 0.0;
__retval = __m26(0, JD);
return __retval;
}
private native static double __m26(long __imp, double JD);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MercuryMeanLongitude(double T)
{
double __retval = 0.0;
__retval = __m27(0, T);
return __retval;
}
private native static double __m27(long __imp, double T);
/**

This method may <var>not</var> be extended in Java.
*/
public static double VenusMeanLongitude(double T)
{
double __retval = 0.0;
__retval = __m28(0, T);
return __retval;
}
private native static double __m28(long __imp, double T);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MarsMeanLongitude(double T)
{
double __retval = 0.0;
__retval = __m29(0, T);
return __retval;
}
private native static double __m29(long __imp, double T);
/**

This method may <var>not</var> be extended in Java.
*/
public static double JupiterMeanLongitude(double T)
{
double __retval = 0.0;
__retval = __m30(0, T);
return __retval;
}
private native static double __m30(long __imp, double T);
/**

This method may <var>not</var> be extended in Java.
*/
public static double SaturnMeanLongitude(double T)
{
double __retval = 0.0;
__retval = __m31(0, T);
return __retval;
}
private native static double __m31(long __imp, double T);
/**

This method may <var>not</var> be extended in Java.
*/
public static double UranusMeanLongitude(double T)
{
double __retval = 0.0;
__retval = __m32(0, T);
return __retval;
}
private native static double __m32(long __imp, double T);
/**

This method may <var>not</var> be extended in Java.
*/
public static double NeptuneMeanLongitude(double T)
{
double __retval = 0.0;
__retval = __m33(0, T);
return __retval;
}
private native static double __m33(long __imp, double T);
public CAAELP2000() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAELP2000(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAELP2000)) return false;
  return implementation.equals(((CAAELP2000)o).implementation);
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
