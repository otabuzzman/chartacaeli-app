// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AARiseTransitSet2.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails2__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails2* __obj = (CAARiseTransitSetDetails2*) __imp;
return static_cast<jint> (__obj->type);
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails2__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails2* __obj = (CAARiseTransitSetDetails2*) __imp;
return (jdouble) __obj->JD;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails2__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails2* __obj = (CAARiseTransitSetDetails2*) __imp;
return (jdouble) __obj->Bearing;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails2__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails2* __obj = (CAARiseTransitSetDetails2*) __imp;
return (jdouble) __obj->GeometricAltitude;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails2__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails2* __obj = (CAARiseTransitSetDetails2*) __imp;
return (jboolean) __obj->bAboveHorizon;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails2__1_1cdefault(JNIEnv* __env, jobject)
{
CAARiseTransitSetDetails2* __obj = new CAARiseTransitSetDetails2();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails2__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails2* __obj = (CAARiseTransitSetDetails2*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
