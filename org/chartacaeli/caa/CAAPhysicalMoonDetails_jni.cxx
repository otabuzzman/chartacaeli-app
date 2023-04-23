// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPhysicalMoon.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoonDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMoonDetails* __obj = (CAAPhysicalMoonDetails*) __imp;
return (jdouble) __obj->ldash;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoonDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMoonDetails* __obj = (CAAPhysicalMoonDetails*) __imp;
return (jdouble) __obj->bdash;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoonDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMoonDetails* __obj = (CAAPhysicalMoonDetails*) __imp;
return (jdouble) __obj->ldash2;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoonDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMoonDetails* __obj = (CAAPhysicalMoonDetails*) __imp;
return (jdouble) __obj->bdash2;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoonDetails__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMoonDetails* __obj = (CAAPhysicalMoonDetails*) __imp;
return (jdouble) __obj->l;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoonDetails__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMoonDetails* __obj = (CAAPhysicalMoonDetails*) __imp;
return (jdouble) __obj->b;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoonDetails__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMoonDetails* __obj = (CAAPhysicalMoonDetails*) __imp;
return (jdouble) __obj->P;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoonDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPhysicalMoonDetails* __obj = new CAAPhysicalMoonDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoonDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMoonDetails* __obj = (CAAPhysicalMoonDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
