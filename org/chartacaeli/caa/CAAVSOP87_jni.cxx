// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAVSOP87.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAVSOP87__1_1cdefault(JNIEnv* __env, jobject)
{
CAAVSOP87* __obj = new CAAVSOP87();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAVSOP87__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAVSOP87* __obj = (CAAVSOP87*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
