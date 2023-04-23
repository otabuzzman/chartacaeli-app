// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AANodes.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANodeObjectDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAANodeObjectDetails* __obj = (CAANodeObjectDetails*) __imp;
return (jdouble) __obj->t;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANodeObjectDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAANodeObjectDetails* __obj = (CAANodeObjectDetails*) __imp;
return (jdouble) __obj->radius;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANodeObjectDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAANodeObjectDetails* __obj = new CAANodeObjectDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAANodeObjectDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAANodeObjectDetails* __obj = (CAANodeObjectDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
