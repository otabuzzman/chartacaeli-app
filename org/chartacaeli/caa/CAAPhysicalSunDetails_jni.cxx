// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPhysicalSun.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalSunDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalSunDetails* __obj = (CAAPhysicalSunDetails*) __imp;
return (jdouble) __obj->P;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalSunDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalSunDetails* __obj = (CAAPhysicalSunDetails*) __imp;
return (jdouble) __obj->B0;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalSunDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalSunDetails* __obj = (CAAPhysicalSunDetails*) __imp;
return (jdouble) __obj->L0;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalSunDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPhysicalSunDetails* __obj = new CAAPhysicalSunDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPhysicalSunDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalSunDetails* __obj = (CAAPhysicalSunDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
