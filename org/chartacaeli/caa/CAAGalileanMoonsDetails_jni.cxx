// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAGalileanMoons.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonsDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonsDetails* __obj = (CAAGalileanMoonsDetails*) __imp;
return (jlong) &__obj->Satellite1;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonsDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonsDetails* __obj = (CAAGalileanMoonsDetails*) __imp;
return (jlong) &__obj->Satellite2;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonsDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonsDetails* __obj = (CAAGalileanMoonsDetails*) __imp;
return (jlong) &__obj->Satellite3;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonsDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonsDetails* __obj = (CAAGalileanMoonsDetails*) __imp;
return (jlong) &__obj->Satellite4;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonsDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAAGalileanMoonsDetails* __obj = new CAAGalileanMoonsDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonsDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonsDetails* __obj = (CAAGalileanMoonsDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
