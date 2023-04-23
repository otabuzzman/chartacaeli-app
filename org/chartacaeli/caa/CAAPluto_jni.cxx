// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPluto.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPluto__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAPluto* __obj = (CAAPluto*) __imp;
double __retval = __obj->EclipticLongitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPluto__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAPluto* __obj = (CAAPluto*) __imp;
double __retval = __obj->EclipticLatitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPluto__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAPluto* __obj = (CAAPluto*) __imp;
double __retval = __obj->RadiusVector((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPluto__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPluto* __obj = new CAAPluto();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPluto__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPluto* __obj = (CAAPluto*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
