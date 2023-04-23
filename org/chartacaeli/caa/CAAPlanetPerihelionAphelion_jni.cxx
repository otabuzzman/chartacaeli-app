// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPlanetPerihelionAphelion.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->MercuryK((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->Mercury((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->VenusK((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->Venus((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->EarthK((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble k, jboolean bBarycentric)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
double __retval = __obj->EarthPerihelion((double)k, (bool)bBarycentric);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble k, jboolean bBarycentric)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
double __retval = __obj->EarthAphelion((double)k, (bool)bBarycentric);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->MarsK((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->Mars((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->JupiterK((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m10(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->Jupiter((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m11(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->SaturnK((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m12(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->Saturn((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m13(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->UranusK((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m14(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->Uranus((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m15(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->NeptuneK((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1m16(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
const double __retval = __obj->Neptune((double)k);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPlanetPerihelionAphelion* __obj = new CAAPlanetPerihelionAphelion();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPlanetPerihelionAphelion* __obj = (CAAPlanetPerihelionAphelion*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
