// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAVSOP87.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_VSOP87Coefficient2__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
VSOP87Coefficient2* __obj = (VSOP87Coefficient2*) __imp;
return (jlong) __obj->pCoefficients;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_VSOP87Coefficient2__1_1cdefault(JNIEnv* __env, jobject)
{
VSOP87Coefficient2* __obj = new VSOP87Coefficient2();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_VSOP87Coefficient2__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
VSOP87Coefficient2* __obj = (VSOP87Coefficient2*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
