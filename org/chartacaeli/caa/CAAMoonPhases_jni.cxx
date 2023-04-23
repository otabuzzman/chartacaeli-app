// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoonPhases.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPhases__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAMoonPhases* __obj = (CAAMoonPhases*) __imp;
const double __retval = __obj->K((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPhases__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonPhases* __obj = (CAAMoonPhases*) __imp;
double __retval = __obj->MeanPhase((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPhases__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonPhases* __obj = (CAAMoonPhases*) __imp;
double __retval = __obj->TruePhase((double)k);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoonPhases__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoonPhases* __obj = new CAAMoonPhases();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoonPhases__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonPhases* __obj = (CAAMoonPhases*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
