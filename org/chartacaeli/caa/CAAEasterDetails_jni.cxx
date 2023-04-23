// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEaster.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEasterDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAEasterDetails* __obj = (CAAEasterDetails*) __imp;
return (jlong) __obj->Month;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEasterDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAEasterDetails* __obj = (CAAEasterDetails*) __imp;
return (jlong) __obj->Day;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEasterDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEasterDetails* __obj = new CAAEasterDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEasterDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEasterDetails* __obj = (CAAEasterDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
