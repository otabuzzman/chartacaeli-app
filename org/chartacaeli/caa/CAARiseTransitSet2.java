// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAARiseTransitSet2 extends Object {
/**Enums*/
public final static int SUN = 0;
public final static int MOON = SUN + 1;
public final static int MERCURY = MOON + 1;
public final static int VENUS = MERCURY + 1;
public final static int MARS = VENUS + 1;
public final static int JUPITER = MARS + 1;
public final static int SATURN = JUPITER + 1;
public final static int URANUS = SATURN + 1;
public final static int NEPTUNE = URANUS + 1;
public final static int STAR = NEPTUNE + 1;
public final static int MeeusTruncated = 0 #ifndef AAPLUS_NO_ELP2000;
public final static int ELP2000 = 1 #endif //#ifndef AAPLUS_NO_ELP2000 #ifndef AAPLUS_NO_ELPMPP02;
public final static int ELPMPP02Nominal = 2;
public final static int ELPMPP02LLR = 3;
public final static int ELPMPP02DE405 = 4;
public final static int ELPMPP02DE406 = 5 #endif //#ifndef AAPLUS_NO_ELPMPP02;
public CAARiseTransitSet2() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAARiseTransitSet2(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAARiseTransitSet2)) return false;
  return implementation.equals(((CAARiseTransitSet2)o).implementation);
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
