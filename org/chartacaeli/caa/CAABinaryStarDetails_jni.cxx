// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AABinaryStar.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAABinaryStarDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAABinaryStarDetails* __obj = (CAABinaryStarDetails*) __imp;
return (jdouble) __obj->r;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAABinaryStarDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAABinaryStarDetails* __obj = (CAABinaryStarDetails*) __imp;
return (jdouble) __obj->Theta;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAABinaryStarDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAABinaryStarDetails* __obj = (CAABinaryStarDetails*) __imp;
return (jdouble) __obj->Rho;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAABinaryStarDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAABinaryStarDetails* __obj = (CAABinaryStarDetails*) __imp;
return (jdouble) __obj->x;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAABinaryStarDetails__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAABinaryStarDetails* __obj = (CAABinaryStarDetails*) __imp;
return (jdouble) __obj->y;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAABinaryStarDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAABinaryStarDetails* __obj = new CAABinaryStarDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAABinaryStarDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAABinaryStarDetails* __obj = (CAABinaryStarDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
