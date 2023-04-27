// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAPlanetaryPhenomenaDetails2 extends Object {
/**Enums*/
public final static int NotDefined = 0;
public final static int InferiorConjunctionInEclipticLongitude = 1;
public final static int InferiorConjunctionInRA = 2;
public final static int InferiorConjunctionInAngularDistance = 3;
public final static int SuperiorConjunctionInEclipticLongitude = 4;
public final static int SuperiorConjunctionInRA = 5;
public final static int SuperiorConjunctionInAngularDistance = 6;
public final static int GreatestWesternElongationInEclipticLongitude = 7;
public final static int GreatestWesternElongationInRA = 8;
public final static int GreatestWesternElongationInAngularDistance = 9;
public final static int GreatestEasternElongationInEclipticLongitude = 10;
public final static int GreatestEasternElongationInRA = 11;
public final static int GreatestEasternElongationInAngularDistance = 12;
public final static int OppositionInEclipticLongitude = 13;
public final static int OppositionInRA = 14;
public final static int OppositionInAngularDistance = 15;
public final static int ConjunctionInEclipticLongitude = 16;
public final static int ConjunctionInRA = 17;
public final static int ConjunctionInAngularDistance = 18;
public final static int Station1InEclipticLongitude = 19;
public final static int Station1InRA = 20;
public final static int Station2InEclipticLongitude = 21;
public final static int Station2InRA = 22;
public final static int WesternQuadratureInEclipticLongitude = 23;
public final static int WesternQuadratureInRA = 24;
public final static int WesternQuadratureInAngularDistance = 25;
public final static int EasternQuadratureInEclipticLongitude = 26;
public final static int EasternQuadratureInRA = 27;
public final static int EasternQuadratureInAngularDistance = 28;
public final static int MaximumDistance = 29;
public final static int MinimumDistance = 30;
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
public double Value()
{
double __retval = 0.0;
__retval = __m3(implementation.longValue());
return __retval;
}
private native double __m3(long __imp);
public CAAPlanetaryPhenomenaDetails2() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAPlanetaryPhenomenaDetails2(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAPlanetaryPhenomenaDetails2)) return false;
  return implementation.equals(((CAAPlanetaryPhenomenaDetails2)o).implementation);
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
