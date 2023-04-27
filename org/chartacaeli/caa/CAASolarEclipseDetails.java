// created by cxxwrap -- DO NOT EDIT
package org.chartacaeli.caa;
/**////////////////// Classes //////////////////////////////////////////////////*/
public class CAASolarEclipseDetails extends Object {
/**Constants (used by Flags member variable)

This method may <var>not</var> be extended in Java.
*/
public static int TOTAL_ECLIPSE()
{
int __retval = 0;
__retval = __m0(0);
return __retval;
}
private native static int __m0(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public static int ANNULAR_ECLIPSE()
{
int __retval = 0;
__retval = __m1(0);
return __retval;
}
private native static int __m1(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public static int ANNULAR_TOTAL_ECLIPSE()
{
int __retval = 0;
__retval = __m2(0);
return __retval;
}
private native static int __m2(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public static int CENTRAL_ECLIPSE()
{
int __retval = 0;
__retval = __m3(0);
return __retval;
}
private native static int __m3(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public static int PARTIAL_ECLIPSE()
{
int __retval = 0;
__retval = __m4(0);
return __retval;
}
private native static int __m4(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public static int NON_CENTRAL_ECLIPSE()
{
int __retval = 0;
__retval = __m5(0);
return __retval;
}
private native static int __m5(long __imp);
/**Member variables

This method may <var>not</var> be extended in Java.
*/
public int Flags()
{
int __retval = 0;
__retval = __m6(implementation.longValue());
return __retval;
}
private native int __m6(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double TimeOfMaximumEclipse()
{
double __retval = 0.0;
__retval = __m7(implementation.longValue());
return __retval;
}
private native double __m7(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double F()
{
double __retval = 0.0;
__retval = __m8(implementation.longValue());
return __retval;
}
private native double __m8(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double u()
{
double __retval = 0.0;
__retval = __m9(implementation.longValue());
return __retval;
}
private native double __m9(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double gamma()
{
double __retval = 0.0;
__retval = __m10(implementation.longValue());
return __retval;
}
private native double __m10(long __imp);
/**

This method may <var>not</var> be extended in Java.
*/
public double GreatestMagnitude()
{
double __retval = 0.0;
__retval = __m11(implementation.longValue());
return __retval;
}
private native double __m11(long __imp);
public CAASolarEclipseDetails() {

implementation = Long.valueOf(__cdefault());

}
private native long __cdefault();
// cxxwrap ctor, do not use
public CAASolarEclipseDetails(Long __imp) { implementation = __imp; }
protected Long implementation = null;
protected boolean extensible = false;
public Long getCxxwrapImpl() { return implementation; }
// override equals() from Object, compare the implementation value
public boolean equals(Object o) {
  if (!(o instanceof CAASolarEclipseDetails)) return false;
  return implementation.equals(((CAASolarEclipseDetails)o).implementation);
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
