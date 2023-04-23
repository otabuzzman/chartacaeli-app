// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAParabolic.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->HeliocentricEclipticLongitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->HeliocentricEclipticLatitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->TrueGeocentricRA;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->TrueGeocentricDeclination;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->TrueGeocentricDistance;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m7(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->TrueGeocentricLightTime;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m8(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->AstrometricGeocenticRA;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m9(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->AstrometricGeocentricDeclination;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m10(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->AstrometricGeocentricDistance;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m11(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->AstrometricGeocentricLightTime;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m12(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->Elongation;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1m13(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
return (jdouble) __obj->PhaseAngle;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAAParabolicObjectDetails* __obj = new CAAParabolicObjectDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAParabolicObjectDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAParabolicObjectDetails* __obj = (CAAParabolicObjectDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
