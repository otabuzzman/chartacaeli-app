// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoonPhases2.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoonPhases2__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoonPhases2* __obj = new CAAMoonPhases2();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoonPhases2__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonPhases2* __obj = (CAAMoonPhases2*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
