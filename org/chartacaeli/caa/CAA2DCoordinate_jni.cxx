// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AA2DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAA2DCoordinate__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAA2DCoordinate* __obj = (CAA2DCoordinate*) __imp;
return (jdouble) __obj->X;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAA2DCoordinate__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAA2DCoordinate* __obj = (CAA2DCoordinate*) __imp;
return (jdouble) __obj->Y;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAA2DCoordinate__1_1cdefault(JNIEnv* __env, jobject)
{
CAA2DCoordinate* __obj = new CAA2DCoordinate();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAA2DCoordinate__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAA2DCoordinate* __obj = (CAA2DCoordinate*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
