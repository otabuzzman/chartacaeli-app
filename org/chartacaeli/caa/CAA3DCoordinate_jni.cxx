// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AA3DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAA3DCoordinate__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAA3DCoordinate* __obj = (CAA3DCoordinate*) __imp;
return (jdouble) __obj->X;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAA3DCoordinate__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAA3DCoordinate* __obj = (CAA3DCoordinate*) __imp;
return (jdouble) __obj->Y;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAA3DCoordinate__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAA3DCoordinate* __obj = (CAA3DCoordinate*) __imp;
return (jdouble) __obj->Z;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAA3DCoordinate__1_1cdefault(JNIEnv* __env, jobject)
{
CAA3DCoordinate* __obj = new CAA3DCoordinate();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAA3DCoordinate__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAA3DCoordinate* __obj = (CAA3DCoordinate*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
