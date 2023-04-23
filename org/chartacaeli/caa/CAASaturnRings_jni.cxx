// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AASaturnRings.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASaturnRings__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASaturnRings* __obj = (CAASaturnRings*) __imp;
CAASaturnRingDetails __retval_temp(__obj->Calculate((double)JD, (bool)bHighPrecision));
CAASaturnRingDetails* __retval = new CAASaturnRingDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASaturnRings__1_1cdefault(JNIEnv* __env, jobject)
{
CAASaturnRings* __obj = new CAASaturnRings();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAASaturnRings__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnRings* __obj = (CAASaturnRings*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
