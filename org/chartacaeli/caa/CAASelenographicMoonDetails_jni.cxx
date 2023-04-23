// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPhysicalMoon.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASelenographicMoonDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAASelenographicMoonDetails* __obj = (CAASelenographicMoonDetails*) __imp;
return (jdouble) __obj->l0;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASelenographicMoonDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAASelenographicMoonDetails* __obj = (CAASelenographicMoonDetails*) __imp;
return (jdouble) __obj->b0;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASelenographicMoonDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAASelenographicMoonDetails* __obj = (CAASelenographicMoonDetails*) __imp;
return (jdouble) __obj->c0;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASelenographicMoonDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAASelenographicMoonDetails* __obj = new CAASelenographicMoonDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAASelenographicMoonDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAASelenographicMoonDetails* __obj = (CAASelenographicMoonDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
