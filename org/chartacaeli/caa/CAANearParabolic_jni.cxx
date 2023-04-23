// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AANearParabolic.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANearParabolic__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jlong elements, jboolean bHighPrecision)
{
CAANearParabolic* __obj = (CAANearParabolic*) __imp;
CAANearParabolicObjectDetails __retval_temp(__obj->Calculate((double)JD, *((CAANearParabolicObjectElements*) elements), (bool)bHighPrecision));
CAANearParabolicObjectDetails* __retval = new CAANearParabolicObjectDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANearParabolic__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble x)
{
CAANearParabolic* __obj = (CAANearParabolic*) __imp;
double __retval = __obj->cbrt((double)x);
return (jdouble) __retval;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAANearParabolic__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jlong elements, jdoubleArray v, jdoubleArray r)
{
CAANearParabolic* __obj = (CAANearParabolic*) __imp;
jdouble* __Tv = __env->GetDoubleArrayElements(v, NULL);
jdouble* __Tr = __env->GetDoubleArrayElements(r, NULL);
__obj->CalculateTrueAnomalyAndRadius((double)JD, *((CAANearParabolicObjectElements*) elements), *((double*)__Tv), *((double*)__Tr));
__env->ReleaseDoubleArrayElements(v, __Tv, 0);
__env->ReleaseDoubleArrayElements(r, __Tr, 0);
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANearParabolic__1_1cdefault(JNIEnv* __env, jobject)
{
CAANearParabolic* __obj = new CAANearParabolic();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAANearParabolic__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAANearParabolic* __obj = (CAANearParabolic*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
