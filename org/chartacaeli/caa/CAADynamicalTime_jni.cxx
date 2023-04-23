// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AADynamicalTime.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
double __retval = __obj->DeltaT((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
double __retval = __obj->CumulativeLeapSeconds((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
double __retval = __obj->TT2UTC((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
double __retval = __obj->UTC2TT((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
const double __retval = __obj->TT2TAI((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
const double __retval = __obj->TAI2TT((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
double __retval = __obj->TT2UT1((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
double __retval = __obj->UT12TT((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
double __retval = __obj->UT1MinusUTC((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1cdefault(JNIEnv* __env, jobject)
{
CAADynamicalTime* __obj = new CAADynamicalTime();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAADynamicalTime__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAADynamicalTime* __obj = (CAADynamicalTime*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
