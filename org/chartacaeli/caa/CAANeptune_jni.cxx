// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AANeptune.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANeptune__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAANeptune* __obj = (CAANeptune*) __imp;
double __retval = __obj->EclipticLongitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANeptune__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAANeptune* __obj = (CAANeptune*) __imp;
double __retval = __obj->EclipticLatitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANeptune__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAANeptune* __obj = (CAANeptune*) __imp;
double __retval = __obj->RadiusVector((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANeptune__1_1cdefault(JNIEnv* __env, jobject)
{
CAANeptune* __obj = new CAANeptune();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAANeptune__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAANeptune* __obj = (CAANeptune*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
