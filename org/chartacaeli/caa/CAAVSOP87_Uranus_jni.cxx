// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAVSOP87_URA.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87_1Uranus__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87_Uranus* __obj = (CAAVSOP87_Uranus*) __imp;
double __retval = __obj->A((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87_1Uranus__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87_Uranus* __obj = (CAAVSOP87_Uranus*) __imp;
double __retval = __obj->L((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87_1Uranus__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87_Uranus* __obj = (CAAVSOP87_Uranus*) __imp;
double __retval = __obj->K((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87_1Uranus__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87_Uranus* __obj = (CAAVSOP87_Uranus*) __imp;
double __retval = __obj->H((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87_1Uranus__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87_Uranus* __obj = (CAAVSOP87_Uranus*) __imp;
double __retval = __obj->Q((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87_1Uranus__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87_Uranus* __obj = (CAAVSOP87_Uranus*) __imp;
double __retval = __obj->P((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAVSOP87_1Uranus__1_1cdefault(JNIEnv* __env, jobject)
{
CAAVSOP87_Uranus* __obj = new CAAVSOP87_Uranus();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAVSOP87_1Uranus__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAVSOP87_Uranus* __obj = (CAAVSOP87_Uranus*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
