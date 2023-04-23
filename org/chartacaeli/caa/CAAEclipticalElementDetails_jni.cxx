// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEclipticalElements.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEclipticalElementDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAEclipticalElementDetails* __obj = (CAAEclipticalElementDetails*) __imp;
return (jdouble) __obj->i;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEclipticalElementDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAEclipticalElementDetails* __obj = (CAAEclipticalElementDetails*) __imp;
return (jdouble) __obj->w;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEclipticalElementDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAEclipticalElementDetails* __obj = (CAAEclipticalElementDetails*) __imp;
return (jdouble) __obj->omega;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEclipticalElementDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEclipticalElementDetails* __obj = new CAAEclipticalElementDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEclipticalElementDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEclipticalElementDetails* __obj = (CAAEclipticalElementDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
