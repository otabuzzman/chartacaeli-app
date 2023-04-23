// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPhysicalMars.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMarsDetails* __obj = (CAAPhysicalMarsDetails*) __imp;
return (jdouble) __obj->DE;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMarsDetails* __obj = (CAAPhysicalMarsDetails*) __imp;
return (jdouble) __obj->DS;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMarsDetails* __obj = (CAAPhysicalMarsDetails*) __imp;
return (jdouble) __obj->w;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMarsDetails* __obj = (CAAPhysicalMarsDetails*) __imp;
return (jdouble) __obj->P;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMarsDetails* __obj = (CAAPhysicalMarsDetails*) __imp;
return (jdouble) __obj->X;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMarsDetails* __obj = (CAAPhysicalMarsDetails*) __imp;
return (jdouble) __obj->k;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMarsDetails* __obj = (CAAPhysicalMarsDetails*) __imp;
return (jdouble) __obj->q;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1m7(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMarsDetails* __obj = (CAAPhysicalMarsDetails*) __imp;
return (jdouble) __obj->d;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPhysicalMarsDetails* __obj = new CAAPhysicalMarsDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPhysicalMarsDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMarsDetails* __obj = (CAAPhysicalMarsDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
