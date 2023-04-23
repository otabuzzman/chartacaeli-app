// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
public class CAAGalileanMoonsDetails extends Object {
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public CAAGalileanMoonDetail Satellite1()
{
long __retval = 0;
__retval = __m0(implementation.longValue());
return (__retval == 0 ? null : new CAAGalileanMoonDetail(new Long(__retval)));
}
private native long __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAAGalileanMoonDetail Satellite2()
{
long __retval = 0;
__retval = __m1(implementation.longValue());
return (__retval == 0 ? null : new CAAGalileanMoonDetail(new Long(__retval)));
}
private native long __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAAGalileanMoonDetail Satellite3()
{
long __retval = 0;
__retval = __m2(implementation.longValue());
return (__retval == 0 ? null : new CAAGalileanMoonDetail(new Long(__retval)));
}
private native long __m2(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public CAAGalileanMoonDetail Satellite4()
{
long __retval = 0;
__retval = __m3(implementation.longValue());
return (__retval == 0 ? null : new CAAGalileanMoonDetail(new Long(__retval)));
}
private native long __m3(long __imp);
public CAAGalileanMoonsDetails() {

implementation = new Long(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAAGalileanMoonsDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAAGalileanMoonsDetails)) return false;
  return implementation.equals(((CAAGalileanMoonsDetails)o).implementation);
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
