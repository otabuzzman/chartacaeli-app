// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAGalileanMoons.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoons__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAGalileanMoons* __obj = (CAAGalileanMoons*) __imp;
CAAGalileanMoonsDetails __retval_temp(__obj->Calculate((double)JD, (bool)bHighPrecision));
CAAGalileanMoonsDetails* __retval = new CAAGalileanMoonsDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoons__1_1cdefault(JNIEnv* __env, jobject)
{
CAAGalileanMoons* __obj = new CAAGalileanMoons();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAGalileanMoons__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoons* __obj = (CAAGalileanMoons*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
