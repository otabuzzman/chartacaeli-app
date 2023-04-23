// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAParallax.h"
#include "AA2DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAParallax__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Delta, jdouble Distance, jdouble Longitude, jdouble Latitude, jdouble Height, jdouble JD)
{
CAAParallax* __obj = (CAAParallax*) __imp;
CAA2DCoordinate __retval_temp(__obj->Equatorial2TopocentricDelta((double)Alpha, (double)Delta, (double)Distance, (double)Longitude, (double)Latitude, (double)Height, (double)JD));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAParallax__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Delta, jdouble Distance, jdouble Longitude, jdouble Latitude, jdouble Height, jdouble JD)
{
CAAParallax* __obj = (CAAParallax*) __imp;
CAA2DCoordinate __retval_temp(__obj->Equatorial2Topocentric((double)Alpha, (double)Delta, (double)Distance, (double)Longitude, (double)Latitude, (double)Height, (double)JD));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAParallax__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble Lambda, jdouble Beta, jdouble Semidiameter, jdouble Distance, jdouble Epsilon, jdouble Latitude, jdouble Height, jdouble JD)
{
CAAParallax* __obj = (CAAParallax*) __imp;
CAATopocentricEclipticDetails __retval_temp(__obj->Ecliptic2Topocentric((double)Lambda, (double)Beta, (double)Semidiameter, (double)Distance, (double)Epsilon, (double)Latitude, (double)Height, (double)JD));
CAATopocentricEclipticDetails* __retval = new CAATopocentricEclipticDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParallax__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble Parallax)
{
CAAParallax* __obj = (CAAParallax*) __imp;
double __retval = __obj->ParallaxToDistance((double)Parallax);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParallax__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble Distance)
{
CAAParallax* __obj = (CAAParallax*) __imp;
double __retval = __obj->DistanceToParallax((double)Distance);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAParallax__1_1cdefault(JNIEnv* __env, jobject)
{
CAAParallax* __obj = new CAAParallax();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAParallax__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAParallax* __obj = (CAAParallax*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
