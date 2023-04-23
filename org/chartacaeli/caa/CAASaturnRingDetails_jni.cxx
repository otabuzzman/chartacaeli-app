// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AASaturnRings.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRingDetails* __obj = (CAASaturnRingDetails*) __imp;
return (jdouble) __obj->B;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRingDetails* __obj = (CAASaturnRingDetails*) __imp;
return (jdouble) __obj->Bdash;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRingDetails* __obj = (CAASaturnRingDetails*) __imp;
return (jdouble) __obj->P;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRingDetails* __obj = (CAASaturnRingDetails*) __imp;
return (jdouble) __obj->a;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRingDetails* __obj = (CAASaturnRingDetails*) __imp;
return (jdouble) __obj->b;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRingDetails* __obj = (CAASaturnRingDetails*) __imp;
return (jdouble) __obj->DeltaU;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRingDetails* __obj = (CAASaturnRingDetails*) __imp;
return (jdouble) __obj->U1;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1m7(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRingDetails* __obj = (CAASaturnRingDetails*) __imp;
return (jdouble) __obj->U2;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAASaturnRingDetails* __obj = new CAASaturnRingDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAASaturnRingDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRingDetails* __obj = (CAASaturnRingDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
