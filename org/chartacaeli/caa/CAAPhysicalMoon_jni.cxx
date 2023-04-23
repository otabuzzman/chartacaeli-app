// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPhysicalMoon.h"
#include "AA2DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoon__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAPhysicalMoon* __obj = (CAAPhysicalMoon*) __imp;
CAAPhysicalMoonDetails __retval_temp(__obj->CalculateGeocentric((double)JD));
CAAPhysicalMoonDetails* __retval = new CAAPhysicalMoonDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoon__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jdouble Longitude, jdouble Latitude)
{
CAAPhysicalMoon* __obj = (CAAPhysicalMoon*) __imp;
CAAPhysicalMoonDetails __retval_temp(__obj->CalculateTopocentric((double)JD, (double)Longitude, (double)Latitude));
CAAPhysicalMoonDetails* __retval = new CAAPhysicalMoonDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoon__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAPhysicalMoon* __obj = (CAAPhysicalMoon*) __imp;
CAASelenographicMoonDetails __retval_temp(__obj->CalculateSelenographicPositionOfSun((double)JD, (bool)bHighPrecision));
CAASelenographicMoonDetails* __retval = new CAASelenographicMoonDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoon__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jdouble Longitude, jdouble Latitude, jboolean bHighPrecision)
{
CAAPhysicalMoon* __obj = (CAAPhysicalMoon*) __imp;
double __retval = __obj->AltitudeOfSun((double)JD, (double)Longitude, (double)Latitude, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoon__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jdouble Longitude, jdouble Latitude, jboolean bHighPrecision)
{
CAAPhysicalMoon* __obj = (CAAPhysicalMoon*) __imp;
double __retval = __obj->TimeOfSunrise((double)JD, (double)Longitude, (double)Latitude, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoon__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jdouble Longitude, jdouble Latitude, jboolean bHighPrecision)
{
CAAPhysicalMoon* __obj = (CAAPhysicalMoon*) __imp;
double __retval = __obj->TimeOfSunset((double)JD, (double)Longitude, (double)Latitude, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoon__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPhysicalMoon* __obj = new CAAPhysicalMoon();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPhysicalMoon__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalMoon* __obj = (CAAPhysicalMoon*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
