// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAVSOP87.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_VSOP87Coefficient__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
VSOP87Coefficient* __obj = (VSOP87Coefficient*) __imp;
return (jdouble) __obj->A;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_VSOP87Coefficient__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
VSOP87Coefficient* __obj = (VSOP87Coefficient*) __imp;
return (jdouble) __obj->B;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_VSOP87Coefficient__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
VSOP87Coefficient* __obj = (VSOP87Coefficient*) __imp;
return (jdouble) __obj->C;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_VSOP87Coefficient__1_1cdefault(JNIEnv* __env, jobject)
{
VSOP87Coefficient* __obj = new VSOP87Coefficient();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_VSOP87Coefficient__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
VSOP87Coefficient* __obj = (VSOP87Coefficient*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
