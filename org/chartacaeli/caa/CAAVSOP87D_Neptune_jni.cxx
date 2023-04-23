// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAVSOP87D_NEP.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87D_1Neptune__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87D_Neptune* __obj = (CAAVSOP87D_Neptune*) __imp;
double __retval = __obj->L((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87D_1Neptune__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87D_Neptune* __obj = (CAAVSOP87D_Neptune*) __imp;
double __retval = __obj->L_DASH((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87D_1Neptune__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87D_Neptune* __obj = (CAAVSOP87D_Neptune*) __imp;
double __retval = __obj->B((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87D_1Neptune__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87D_Neptune* __obj = (CAAVSOP87D_Neptune*) __imp;
double __retval = __obj->B_DASH((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87D_1Neptune__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87D_Neptune* __obj = (CAAVSOP87D_Neptune*) __imp;
double __retval = __obj->R((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAVSOP87D_1Neptune__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAVSOP87D_Neptune* __obj = (CAAVSOP87D_Neptune*) __imp;
double __retval = __obj->R_DASH((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAVSOP87D_1Neptune__1_1cdefault(JNIEnv* __env, jobject)
{
CAAVSOP87D_Neptune* __obj = new CAAVSOP87D_Neptune();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAVSOP87D_1Neptune__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAVSOP87D_Neptune* __obj = (CAAVSOP87D_Neptune*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
