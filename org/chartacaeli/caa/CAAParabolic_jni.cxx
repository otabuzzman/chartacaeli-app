// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAParabolic.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolic__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble W, jdouble epsilon)
{
CAAParabolic* __obj = (CAAParabolic*) __imp;
double __retval = __obj->CalculateBarkers((double)W, (double)epsilon);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAParabolic__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jlong elements, jboolean bHighPrecision, jdouble epsilon)
{
CAAParabolic* __obj = (CAAParabolic*) __imp;
CAAParabolicObjectDetails __retval_temp(__obj->Calculate((double)JD, *((CAAParabolicObjectElements*) elements), (bool)bHighPrecision, (double)epsilon));
CAAParabolicObjectDetails* __retval = new CAAParabolicObjectDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAParabolic__1_1cdefault(JNIEnv* __env, jobject)
{
CAAParabolic* __obj = new CAAParabolic();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAParabolic__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolic* __obj = (CAAParabolic*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
