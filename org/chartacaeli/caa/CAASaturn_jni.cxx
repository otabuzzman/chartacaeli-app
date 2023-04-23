// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AASaturn.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturn__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASaturn* __obj = (CAASaturn*) __imp;
double __retval = __obj->EclipticLongitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturn__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASaturn* __obj = (CAASaturn*) __imp;
double __retval = __obj->EclipticLatitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturn__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASaturn* __obj = (CAASaturn*) __imp;
double __retval = __obj->RadiusVector((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASaturn__1_1cdefault(JNIEnv* __env, jobject)
{
CAASaturn* __obj = new CAASaturn();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAASaturn__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturn* __obj = (CAASaturn*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
