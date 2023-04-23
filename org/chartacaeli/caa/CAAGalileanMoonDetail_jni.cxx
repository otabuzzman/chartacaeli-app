// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAGalileanMoons.h"
#include "AA3DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jdouble) __obj->MeanLongitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jdouble) __obj->TrueLongitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jdouble) __obj->TropicalLongitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jdouble) __obj->EquatorialLatitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jdouble) __obj->r;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jlong) &__obj->TrueRectangularCoordinates;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jlong) &__obj->ApparentRectangularCoordinates;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m7(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jboolean) __obj->bInTransit;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m8(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jboolean) __obj->bInOccultation;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m9(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jboolean) __obj->bInEclipse;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1m10(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
return (jboolean) __obj->bInShadowTransit;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1cdefault(JNIEnv* __env, jobject)
{
CAAGalileanMoonDetail* __obj = new CAAGalileanMoonDetail();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAGalileanMoonDetail__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAGalileanMoonDetail* __obj = (CAAGalileanMoonDetail*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
