// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AASaturnMoons.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASaturnMoons__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASaturnMoons* __obj = (CAASaturnMoons*) __imp;
CAASaturnMoonsDetails __retval_temp(__obj->Calculate((double)JD, (bool)bHighPrecision));
CAASaturnMoonsDetails* __retval = new CAASaturnMoonsDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASaturnMoons__1_1cdefault(JNIEnv* __env, jobject)
{
CAASaturnMoons* __obj = new CAASaturnMoons();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAASaturnMoons__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnMoons* __obj = (CAASaturnMoons*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
