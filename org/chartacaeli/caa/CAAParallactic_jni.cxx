// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAParallactic.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParallactic__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble HourAngle, jdouble Latitude, jdouble delta)
{
CAAParallactic* __obj = (CAAParallactic*) __imp;
double __retval = __obj->ParallacticAngle((double)HourAngle, (double)Latitude, (double)delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParallactic__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble LocalSiderealTime, jdouble ObliquityOfEcliptic, jdouble Latitude)
{
CAAParallactic* __obj = (CAAParallactic*) __imp;
double __retval = __obj->EclipticLongitudeOnHorizon((double)LocalSiderealTime, (double)ObliquityOfEcliptic, (double)Latitude);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParallactic__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble LocalSiderealTime, jdouble ObliquityOfEcliptic, jdouble Latitude)
{
CAAParallactic* __obj = (CAAParallactic*) __imp;
double __retval = __obj->AngleBetweenEclipticAndHorizon((double)LocalSiderealTime, (double)ObliquityOfEcliptic, (double)Latitude);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParallactic__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble Lambda, jdouble Beta, jdouble ObliquityOfEcliptic)
{
CAAParallactic* __obj = (CAAParallactic*) __imp;
double __retval = __obj->AngleBetweenNorthCelestialPoleAndNorthPoleOfEcliptic((double)Lambda, (double)Beta, (double)ObliquityOfEcliptic);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAParallactic__1_1cdefault(JNIEnv* __env, jobject)
{
CAAParallactic* __obj = new CAAParallactic();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAParallactic__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAParallactic* __obj = (CAAParallactic*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
