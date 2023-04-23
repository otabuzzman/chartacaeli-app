// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAAberration.h"
#include "AA3DCoordinate.h"
#include "AA2DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAAberration__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAAAberration* __obj = (CAAAberration*) __imp;
CAA3DCoordinate __retval_temp(__obj->EarthVelocity((double)JD, (bool)bHighPrecision));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAAberration__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Delta, jdouble JD, jboolean bHighPrecision)
{
CAAAberration* __obj = (CAAAberration*) __imp;
CAA2DCoordinate __retval_temp(__obj->EclipticAberration((double)Alpha, (double)Delta, (double)JD, (bool)bHighPrecision));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAAberration__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble Lambda, jdouble Beta, jdouble JD, jboolean bHighPrecision)
{
CAAAberration* __obj = (CAAAberration*) __imp;
CAA2DCoordinate __retval_temp(__obj->EquatorialAberration((double)Lambda, (double)Beta, (double)JD, (bool)bHighPrecision));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAAberration__1_1cdefault(JNIEnv* __env, jobject)
{
CAAAberration* __obj = new CAAAberration();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAAberration__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAAberration* __obj = (CAAAberration*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
