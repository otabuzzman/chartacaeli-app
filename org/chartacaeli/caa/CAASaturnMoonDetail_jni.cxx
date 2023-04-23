// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AASaturnMoons.h"
#include "AA3DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASaturnMoonDetail__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnMoonDetail* __obj = (CAASaturnMoonDetail*) __imp;
return (jlong) &__obj->TrueRectangularCoordinates;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASaturnMoonDetail__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnMoonDetail* __obj = (CAASaturnMoonDetail*) __imp;
return (jlong) &__obj->ApparentRectangularCoordinates;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAASaturnMoonDetail__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnMoonDetail* __obj = (CAASaturnMoonDetail*) __imp;
return (jboolean) __obj->bInTransit;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAASaturnMoonDetail__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnMoonDetail* __obj = (CAASaturnMoonDetail*) __imp;
return (jboolean) __obj->bInOccultation;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAASaturnMoonDetail__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnMoonDetail* __obj = (CAASaturnMoonDetail*) __imp;
return (jboolean) __obj->bInEclipse;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAASaturnMoonDetail__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnMoonDetail* __obj = (CAASaturnMoonDetail*) __imp;
return (jboolean) __obj->bInShadowTransit;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASaturnMoonDetail__1_1cdefault(JNIEnv* __env, jobject)
{
CAASaturnMoonDetail* __obj = new CAASaturnMoonDetail();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAASaturnMoonDetail__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAASaturnMoonDetail* __obj = (CAASaturnMoonDetail*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
