// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAGlobe.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGlobe__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble GeographicalLatitude, jdouble Height)
{
CAAGlobe* __obj = (CAAGlobe*) __imp;
double __retval = __obj->RhoSinThetaPrime((double)GeographicalLatitude, (double)Height);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGlobe__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble GeographicalLatitude, jdouble Height)
{
CAAGlobe* __obj = (CAAGlobe*) __imp;
double __retval = __obj->RhoCosThetaPrime((double)GeographicalLatitude, (double)Height);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGlobe__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble GeographicalLatitude)
{
CAAGlobe* __obj = (CAAGlobe*) __imp;
double __retval = __obj->RadiusOfParallelOfLatitude((double)GeographicalLatitude);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGlobe__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble GeographicalLatitude)
{
CAAGlobe* __obj = (CAAGlobe*) __imp;
double __retval = __obj->RadiusOfCurvature((double)GeographicalLatitude);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAGlobe__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble GeographicalLatitude1, jdouble GeographicalLongitude1, jdouble GeographicalLatitude2, jdouble GeographicalLongitude2)
{
CAAGlobe* __obj = (CAAGlobe*) __imp;
double __retval = __obj->DistanceBetweenPoints((double)GeographicalLatitude1, (double)GeographicalLongitude1, (double)GeographicalLatitude2, (double)GeographicalLongitude2);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAGlobe__1_1cdefault(JNIEnv* __env, jobject)
{
CAAGlobe* __obj = new CAAGlobe();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAGlobe__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAGlobe* __obj = (CAAGlobe*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
