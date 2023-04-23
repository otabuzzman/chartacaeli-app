// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AADate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACalendarDate__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAACalendarDate* __obj = (CAACalendarDate*) __imp;
return (jlong) __obj->Year;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACalendarDate__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAACalendarDate* __obj = (CAACalendarDate*) __imp;
return (jlong) __obj->Month;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACalendarDate__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAACalendarDate* __obj = (CAACalendarDate*) __imp;
return (jlong) __obj->Day;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACalendarDate__1_1cdefault(JNIEnv* __env, jobject)
{
CAACalendarDate* __obj = new CAACalendarDate();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAACalendarDate__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAACalendarDate* __obj = (CAACalendarDate*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
