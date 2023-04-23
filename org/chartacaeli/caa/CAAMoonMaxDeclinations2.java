// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAMoonMaxDeclinations2 extends Object {
/**Enums*/
public final static int MeeusTruncated = 0 #ifndef AAPLUS_NO_ELP2000;
public final static int ELP2000 = 1 #endif //#ifndef AAPLUS_NO_ELP2000 #ifndef AAPLUS_NO_ELPMPP02;
public final static int ELPMPP02Nominal = 2;
public final static int ELPMPP02LLR = 3;
public final static int ELPMPP02DE405 = 4;
public final static int ELPMPP02DE406 = 5 #endif //#ifndef AAPLUS_NO_ELPMPP02;
public CAAMoonMaxDeclinations2() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAMoonMaxDeclinations2(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAMoonMaxDeclinations2)) return false;
  return implementation.equals(((CAAMoonMaxDeclinations2)o).implementation);
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
