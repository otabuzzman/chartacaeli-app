// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AANutation.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANutation__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAANutation* __obj = (CAANutation*) __imp;
double __retval = __obj->NutationInLongitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANutation__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAANutation* __obj = (CAANutation*) __imp;
double __retval = __obj->NutationInObliquity((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANutation__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Delta, jdouble Obliquity, jdouble NutationInLongitude, jdouble NutationInObliquity)
{
CAANutation* __obj = (CAANutation*) __imp;
double __retval = __obj->NutationInRightAscension((double)Alpha, (double)Delta, (double)Obliquity, (double)NutationInLongitude, (double)NutationInObliquity);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANutation__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Obliquity, jdouble NutationInLongitude, jdouble NutationInObliquity)
{
CAANutation* __obj = (CAANutation*) __imp;
double __retval = __obj->NutationInDeclination((double)Alpha, (double)Obliquity, (double)NutationInLongitude, (double)NutationInObliquity);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANutation__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAANutation* __obj = (CAANutation*) __imp;
double __retval = __obj->MeanObliquityOfEcliptic((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAANutation__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAANutation* __obj = (CAANutation*) __imp;
double __retval = __obj->TrueObliquityOfEcliptic((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANutation__1_1cdefault(JNIEnv* __env, jobject)
{
CAANutation* __obj = new CAANutation();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAANutation__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAANutation* __obj = (CAANutation*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
