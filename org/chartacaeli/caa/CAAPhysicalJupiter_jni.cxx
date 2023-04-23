// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPhysicalJupiter.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiter__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAPhysicalJupiter* __obj = (CAAPhysicalJupiter*) __imp;
CAAPhysicalJupiterDetails __retval_temp(__obj->Calculate((double)JD, (bool)bHighPrecision));
CAAPhysicalJupiterDetails* __retval = new CAAPhysicalJupiterDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiter__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPhysicalJupiter* __obj = new CAAPhysicalJupiter();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiter__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalJupiter* __obj = (CAAPhysicalJupiter*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
