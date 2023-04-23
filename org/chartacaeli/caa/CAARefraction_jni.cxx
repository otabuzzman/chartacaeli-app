// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AARefraction.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAARefraction__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Altitude, jdouble Pressure, jdouble Temperature)
{
CAARefraction* __obj = (CAARefraction*) __imp;
double __retval = __obj->RefractionFromApparent((double)Altitude, (double)Pressure, (double)Temperature);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAARefraction__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble Altitude, jdouble Pressure, jdouble Temperature)
{
CAARefraction* __obj = (CAARefraction*) __imp;
double __retval = __obj->RefractionFromTrue((double)Altitude, (double)Pressure, (double)Temperature);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAARefraction__1_1cdefault(JNIEnv* __env, jobject)
{
CAARefraction* __obj = new CAARefraction();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAARefraction__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAARefraction* __obj = (CAARefraction*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
