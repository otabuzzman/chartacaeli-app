// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAPlanetaryPhenomena2 extends Object {
/**Enums*/
public final static int MERCURY = 0;
public final static int VENUS = MERCURY + 1;
public final static int MARS = VENUS + 1;
public final static int JUPITER = MARS + 1;
public final static int SATURN = JUPITER + 1;
public final static int URANUS = SATURN + 1;
public final static int NEPTUNE = URANUS + 1;
public CAAPlanetaryPhenomena2() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAPlanetaryPhenomena2(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAPlanetaryPhenomena2)) return false;
  return implementation.equals(((CAAPlanetaryPhenomena2)o).implementation);
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
