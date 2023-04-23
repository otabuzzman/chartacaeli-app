// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEquationOfTime.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEquationOfTime__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAEquationOfTime* __obj = (CAAEquationOfTime*) __imp;
double __retval = __obj->Calculate((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEquationOfTime__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEquationOfTime* __obj = new CAAEquationOfTime();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEquationOfTime__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEquationOfTime* __obj = (CAAEquationOfTime*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
