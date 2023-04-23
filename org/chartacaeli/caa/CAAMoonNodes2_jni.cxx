// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoonNodes2.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoonNodes2__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoonNodes2* __obj = new CAAMoonNodes2();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoonNodes2__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonNodes2* __obj = (CAAMoonNodes2*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
