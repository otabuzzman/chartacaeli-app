// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAAPlanetaryPhenomena extends Object {
/**Enums*/
public final static int MERCURY = 0;
public final static int VENUS = MERCURY + 1;
public final static int MARS = VENUS + 1;
public final static int JUPITER = MARS + 1;
public final static int SATURN = JUPITER + 1;
public final static int URANUS = SATURN + 1;
public final static int NEPTUNE = URANUS + 1;
public final static int INFERIOR_CONJUNCTION = 0;
public final static int SUPERIOR_CONJUNCTION = INFERIOR_CONJUNCTION + 1;
public final static int OPPOSITION = SUPERIOR_CONJUNCTION + 1;
public final static int CONJUNCTION = OPPOSITION + 1;
public final static int EASTERN_ELONGATION = CONJUNCTION + 1;
public final static int WESTERN_ELONGATION = EASTERN_ELONGATION + 1;
public final static int STATION1 = WESTERN_ELONGATION + 1;
public final static int STATION2 = STATION1 + 1;
/**Static methods

This method may <var>not</var> be extended in Java.
*/
public static double K(double Year, int planet, int type)
{
double __retval = 0.0;
__retval = __m2(0, Year, planet, type);
return __retval;
}
private native static double __m2(long __imp, double Year, int planet, int type);
/**

This method may <var>not</var> be extended in Java.
*/
public static double Mean(double k, int planet, int type)
{
double __retval = 0.0;
__retval = __m3(0, k, planet, type);
return __retval;
}
private native static double __m3(long __imp, double k, int planet, int type);
/**

This method may <var>not</var> be extended in Java.
*/
public static double True(double k, int planet, int type)
{
double __retval = 0.0;
__retval = __m4(0, k, planet, type);
return __retval;
}
private native static double __m4(long __imp, double k, int planet, int type);
/**

This method may <var>not</var> be extended in Java.
*/
public static double ElongationValue(double k, int planet, boolean bEastern)
{
double __retval = 0.0;
__retval = __m5(0, k, planet, bEastern);
return __retval;
}
private native static double __m5(long __imp, double k, int planet, boolean bEastern);
public CAAPlanetaryPhenomena() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAPlanetaryPhenomena(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAPlanetaryPhenomena)) return false;
  return implementation.equals(((CAAPlanetaryPhenomena)o).implementation);
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
