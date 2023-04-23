// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAARiseTransitSetDetails2 extends Object {
/**Enums*/
public final static int NotDefined = 0;
public final static int Rise = 1;
public final static int Set = 2;
public final static int SouthernTransit = 3;
public final static int NorthernTransit = 4;
public final static int CivilDusk = 5;
public final static int NauticalDusk = 6;
public final static int AstronomicalDusk = 7;
public final static int AstronomicalDawn = 8;
public final static int NauticalDawn = 9;
public final static int CivilDawn = 10;
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public int type()
{
int __retval = 0;
__retval = __m1(implementation.longValue());
return __retval;
}
private native int __m1(long __imp);
/**The type of the event which has occurred

This method may <var>not</var> be extended in Java.
*/
public double JD()
{
double __retval = 0.0;
__retval = __m2(implementation.longValue());
return __retval;
}
private native double __m2(long __imp);
/**When the event occurred in TT

This method may <var>not</var> be extended in Java.
*/
public double Bearing()
{
double __retval = 0.0;
__retval = __m3(implementation.longValue());
return __retval;
}
private native double __m3(long __imp);
/**Applicable for rise or sets only, this will be the bearing (degrees west of south) of the event

This method may <var>not</var> be extended in Java.
*/
public double GeometricAltitude()
{
double __retval = 0.0;
__retval = __m4(implementation.longValue());
return __retval;
}
private native double __m4(long __imp);
/**For transits only, this will contain the geometric altitude in degrees of the center of the object not including correction for refraction

This method may <var>not</var> be extended in Java.
*/
public boolean bAboveHorizon()
{
boolean __retval = false;
__retval = __m5(implementation.longValue());
return __retval;
}
private native boolean __m5(long __imp);
public CAARiseTransitSetDetails2() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAARiseTransitSetDetails2(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAARiseTransitSetDetails2)) return false;
  return implementation.equals(((CAARiseTransitSetDetails2)o).implementation);
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
