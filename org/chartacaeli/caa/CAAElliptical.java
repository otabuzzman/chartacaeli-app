// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAElliptical extends Object {
/**Enums*/
public final static int SUN = 0;
public final static int MERCURY = SUN + 1;
public final static int VENUS = MERCURY + 1;
public final static int MARS = VENUS + 1;
public final static int JUPITER = MARS + 1;
public final static int SATURN = JUPITER + 1;
public final static int URANUS = SATURN + 1;
public final static int NEPTUNE = URANUS + 1;
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double DistanceToLightTime(double Distance)
{
double __retval = 0.0;
__retval = __m1(0, Distance);
return __retval;
}
private native static double __m1(long __imp, double Distance);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAAEllipticalPlanetaryDetails Calculate(double JD, int object, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m2(0, JD, object, bHighPrecision);
return (__retval == 0 ? null : new CAAEllipticalPlanetaryDetails(new Long(__retval)));
}
private native static long __m2(long __imp, double JD, int object, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double SemiMajorAxisFromPerihelionDistance(double q, double e)
{
double __retval = 0.0;
__retval = __m3(0, q, e);
return __retval;
}
private native static double __m3(long __imp, double q, double e);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MeanMotionFromSemiMajorAxis(double a)
{
double __retval = 0.0;
__retval = __m4(0, a);
return __retval;
}
private native static double __m4(long __imp, double a);
/**

This method may <var>not</var> be extended in Java.
*/
public static CAAEllipticalObjectDetails Calculate(double JD, CAAEllipticalObjectElements elements, boolean bHighPrecision)
{
long __retval = 0;
__retval = __m5(0, JD, (elements == null ? 0 : elements.getCxxwrapImpl().longValue()), bHighPrecision);
return (__retval == 0 ? null : new CAAEllipticalObjectDetails(new Long(__retval)));
}
private native static long __m5(long __imp, double JD, long elements, boolean bHighPrecision);
/**

This method may <var>not</var> be extended in Java.
*/
public static double InstantaneousVelocity(double r, double a)
{
double __retval = 0.0;
__retval = __m6(0, r, a);
return __retval;
}
private native static double __m6(long __imp, double r, double a);
/**

This method may <var>not</var> be extended in Java.
*/
public static double VelocityAtPerihelion(double e, double a)
{
double __retval = 0.0;
__retval = __m7(0, e, a);
return __retval;
}
private native static double __m7(long __imp, double e, double a);
/**

This method may <var>not</var> be extended in Java.
*/
public static double VelocityAtAphelion(double e, double a)
{
double __retval = 0.0;
__retval = __m8(0, e, a);
return __retval;
}
private native static double __m8(long __imp, double e, double a);
/**

This method may <var>not</var> be extended in Java.
*/
public static double LengthOfEllipse(double e, double a)
{
double __retval = 0.0;
__retval = __m9(0, e, a);
return __retval;
}
private native static double __m9(long __imp, double e, double a);
/**

This method may <var>not</var> be extended in Java.
*/
public static double CometMagnitude(double g, double delta, double k, double r)
{
double __retval = 0.0;
__retval = __m10(0, g, delta, k, r);
return __retval;
}
private native static double __m10(long __imp, double g, double delta, double k, double r);
/**

This method may <var>not</var> be extended in Java.
*/
public static double MinorPlanetMagnitude(double H, double delta, double G, double r, double PhaseAngle)
{
double __retval = 0.0;
__retval = __m11(0, H, delta, G, r, PhaseAngle);
return __retval;
}
private native static double __m11(long __imp, double H, double delta, double G, double r, double PhaseAngle);
public CAAElliptical() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAElliptical(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAElliptical)) return false;
  return implementation.equals(((CAAElliptical)o).implementation);
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
