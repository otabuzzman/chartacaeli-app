// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPhysicalSun.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalSun__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAPhysicalSun* __obj = (CAAPhysicalSun*) __imp;
CAAPhysicalSunDetails __retval_temp(__obj->Calculate((double)JD, (bool)bHighPrecision));
CAAPhysicalSunDetails* __retval = new CAAPhysicalSunDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalSun__1_1m1(JNIEnv* __env, jclass, jlong __imp, jlong C)
{
CAAPhysicalSun* __obj = (CAAPhysicalSun*) __imp;
double __retval = __obj->TimeOfStartOfRotation((long)C);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalSun__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPhysicalSun* __obj = new CAAPhysicalSun();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPhysicalSun__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalSun* __obj = (CAAPhysicalSun*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
