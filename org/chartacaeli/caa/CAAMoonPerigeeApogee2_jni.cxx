// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoonPerigeeApogee2.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee2__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoonPerigeeApogee2* __obj = new CAAMoonPerigeeApogee2();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee2__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonPerigeeApogee2* __obj = (CAAMoonPerigeeApogee2*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
