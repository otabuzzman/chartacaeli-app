// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoon.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->MeanLongitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->MeanElongation((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->MeanAnomaly((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->ArgumentOfLatitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->MeanLongitudeAscendingNode((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->MeanLongitudePerigee((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->TrueLongitudeAscendingNode((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->EclipticLongitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->EclipticLatitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->RadiusVector((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m10(JNIEnv* __env, jclass, jlong __imp, jdouble RadiusVector)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->RadiusVectorToHorizontalParallax((double)RadiusVector);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1m11(JNIEnv* __env, jclass, jlong __imp, jdouble Parallax)
{
CAAMoon* __obj = (CAAMoon*) __imp;
double __retval = __obj->HorizontalParallaxToRadiusVector((double)Parallax);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoon* __obj = new CAAMoon();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoon__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoon* __obj = (CAAMoon*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
