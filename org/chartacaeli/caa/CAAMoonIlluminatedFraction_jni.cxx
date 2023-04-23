// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoonIlluminatedFraction.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonIlluminatedFraction__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble ObjectAlpha, jdouble ObjectDelta, jdouble SunAlpha, jdouble SunDelta)
{
CAAMoonIlluminatedFraction* __obj = (CAAMoonIlluminatedFraction*) __imp;
double __retval = __obj->GeocentricElongation((double)ObjectAlpha, (double)ObjectDelta, (double)SunAlpha, (double)SunDelta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonIlluminatedFraction__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble GeocentricElongation, jdouble EarthObjectDistance, jdouble EarthSunDistance)
{
CAAMoonIlluminatedFraction* __obj = (CAAMoonIlluminatedFraction*) __imp;
double __retval = __obj->PhaseAngle((double)GeocentricElongation, (double)EarthObjectDistance, (double)EarthSunDistance);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonIlluminatedFraction__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble PhaseAngle)
{
CAAMoonIlluminatedFraction* __obj = (CAAMoonIlluminatedFraction*) __imp;
double __retval = __obj->IlluminatedFraction((double)PhaseAngle);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonIlluminatedFraction__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha0, jdouble Delta0, jdouble Alpha, jdouble Delta)
{
CAAMoonIlluminatedFraction* __obj = (CAAMoonIlluminatedFraction*) __imp;
double __retval = __obj->PositionAngle((double)Alpha0, (double)Delta0, (double)Alpha, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoonIlluminatedFraction__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoonIlluminatedFraction* __obj = new CAAMoonIlluminatedFraction();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoonIlluminatedFraction__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonIlluminatedFraction* __obj = (CAAMoonIlluminatedFraction*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
