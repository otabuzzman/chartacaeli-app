// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPhysicalMars.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalMars__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAPhysicalMars* __obj = (CAAPhysicalMars*) __imp;
CAAPhysicalMarsDetails __retval_temp(__obj->Calculate((double)JD, (bool)bHighPrecision));
CAAPhysicalMarsDetails* __retval = new CAAPhysicalMarsDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalMars__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPhysicalMars* __obj = new CAAPhysicalMars();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPhysicalMars__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMars* __obj = (CAAPhysicalMars*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
