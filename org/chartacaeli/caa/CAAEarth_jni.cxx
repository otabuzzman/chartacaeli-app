// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEarth.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEarth__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAEarth* __obj = (CAAEarth*) __imp;
double __retval = __obj->EclipticLongitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEarth__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAEarth* __obj = (CAAEarth*) __imp;
double __retval = __obj->EclipticLatitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEarth__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAEarth* __obj = (CAAEarth*) __imp;
double __retval = __obj->RadiusVector((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEarth__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAEarth* __obj = (CAAEarth*) __imp;
double __retval = __obj->SunMeanAnomaly((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEarth__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAEarth* __obj = (CAAEarth*) __imp;
double __retval = __obj->Eccentricity((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEarth__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAEarth* __obj = (CAAEarth*) __imp;
double __retval = __obj->EclipticLongitudeJ2000((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEarth__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAEarth* __obj = (CAAEarth*) __imp;
double __retval = __obj->EclipticLatitudeJ2000((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEarth__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEarth* __obj = new CAAEarth();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEarth__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEarth* __obj = (CAAEarth*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
