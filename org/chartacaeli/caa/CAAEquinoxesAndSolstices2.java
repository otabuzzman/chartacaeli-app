// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAEquinoxesAndSolstices2 extends Object {
public CAAEquinoxesAndSolstices2() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAEquinoxesAndSolstices2(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAEquinoxesAndSolstices2)) return false;
  return implementation.equals(((CAAEquinoxesAndSolstices2)o).implementation);
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