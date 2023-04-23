// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAParallax.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAATopocentricEclipticDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAATopocentricEclipticDetails* __obj = (CAATopocentricEclipticDetails*) __imp;
return (jdouble) __obj->Lambda;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAATopocentricEclipticDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAATopocentricEclipticDetails* __obj = (CAATopocentricEclipticDetails*) __imp;
return (jdouble) __obj->Beta;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAATopocentricEclipticDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAATopocentricEclipticDetails* __obj = (CAATopocentricEclipticDetails*) __imp;
return (jdouble) __obj->Semidiameter;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAATopocentricEclipticDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAATopocentricEclipticDetails* __obj = new CAATopocentricEclipticDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAATopocentricEclipticDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAATopocentricEclipticDetails* __obj = (CAATopocentricEclipticDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
