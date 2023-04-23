// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAElliptical.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalObjectElements__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalObjectElements* __obj = (CAAEllipticalObjectElements*) __imp;
return (jdouble) __obj->a;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalObjectElements__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalObjectElements* __obj = (CAAEllipticalObjectElements*) __imp;
return (jdouble) __obj->e;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalObjectElements__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalObjectElements* __obj = (CAAEllipticalObjectElements*) __imp;
return (jdouble) __obj->i;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalObjectElements__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalObjectElements* __obj = (CAAEllipticalObjectElements*) __imp;
return (jdouble) __obj->w;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalObjectElements__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalObjectElements* __obj = (CAAEllipticalObjectElements*) __imp;
return (jdouble) __obj->omega;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalObjectElements__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalObjectElements* __obj = (CAAEllipticalObjectElements*) __imp;
return (jdouble) __obj->JDEquinox;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalObjectElements__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalObjectElements* __obj = (CAAEllipticalObjectElements*) __imp;
return (jdouble) __obj->T;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEllipticalObjectElements__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEllipticalObjectElements* __obj = new CAAEllipticalObjectElements();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEllipticalObjectElements__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalObjectElements* __obj = (CAAEllipticalObjectElements*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
