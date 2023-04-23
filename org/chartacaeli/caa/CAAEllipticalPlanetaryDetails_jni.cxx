// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAElliptical.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->ApparentGeocentricEclipticalLongitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->ApparentGeocentricEclipticalLatitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->ApparentGeocentricDistance;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->ApparentLightTime;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->ApparentGeocentricRA;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->ApparentGeocentricDeclination;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m7(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->TrueHeliocentricEclipticalLongitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m8(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->TrueHeliocentricEclipticalLatitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m9(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->TrueHeliocentricDistance;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m10(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->TrueGeocentricEclipticalLongitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m11(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->TrueGeocentricEclipticalLatitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m12(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->TrueGeocentricDistance;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m13(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->TrueLightTime;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m14(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->TrueGeocentricRA;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1m15(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
return (jdouble) __obj->TrueGeocentricDeclination;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEllipticalPlanetaryDetails* __obj = new CAAEllipticalPlanetaryDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEllipticalPlanetaryDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEllipticalPlanetaryDetails* __obj = (CAAEllipticalPlanetaryDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
