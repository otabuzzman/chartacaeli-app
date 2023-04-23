// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAVSOP87A_URA.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87A_1Uranus__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87A_Uranus* __obj = (CAAVSOP87A_Uranus*) __imp;
double __retval = __obj->X((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87A_1Uranus__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87A_Uranus* __obj = (CAAVSOP87A_Uranus*) __imp;
double __retval = __obj->X_DASH((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87A_1Uranus__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87A_Uranus* __obj = (CAAVSOP87A_Uranus*) __imp;
double __retval = __obj->Y((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87A_1Uranus__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87A_Uranus* __obj = (CAAVSOP87A_Uranus*) __imp;
double __retval = __obj->Y_DASH((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87A_1Uranus__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87A_Uranus* __obj = (CAAVSOP87A_Uranus*) __imp;
double __retval = __obj->Z((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87A_1Uranus__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87A_Uranus* __obj = (CAAVSOP87A_Uranus*) __imp;
double __retval = __obj->Z_DASH((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAVSOP87A_1Uranus__1_1cdefault(JNIEnv* __env, jobject)
{
CAAVSOP87A_Uranus* __obj = new CAAVSOP87A_Uranus();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAVSOP87A_1Uranus__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAVSOP87A_Uranus* __obj = (CAAVSOP87A_Uranus*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
