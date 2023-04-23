// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPrecession.h"
#include "AA2DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPrecession__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Delta, jdouble JD0, jdouble JD)
{
CAAPrecession* __obj = (CAAPrecession*) __imp;
CAA2DCoordinate __retval_temp(__obj->PrecessEquatorial((double)Alpha, (double)Delta, (double)JD0, (double)JD));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPrecession__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Delta, jdouble JD0, jdouble JD)
{
CAAPrecession* __obj = (CAAPrecession*) __imp;
CAA2DCoordinate __retval_temp(__obj->PrecessEquatorialFK4((double)Alpha, (double)Delta, (double)JD0, (double)JD));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPrecession__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble Lambda, jdouble Beta, jdouble JD0, jdouble JD)
{
CAAPrecession* __obj = (CAAPrecession*) __imp;
CAA2DCoordinate __retval_temp(__obj->PrecessEcliptic((double)Lambda, (double)Beta, (double)JD0, (double)JD));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPrecession__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Delta, jdouble Beta, jdouble PMAlpha, jdouble PMDelta, jdouble Epsilon)
{
CAAPrecession* __obj = (CAAPrecession*) __imp;
CAA2DCoordinate __retval_temp(__obj->EquatorialPMToEcliptic((double)Alpha, (double)Delta, (double)Beta, (double)PMAlpha, (double)PMDelta, (double)Epsilon));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPrecession__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble t, jdouble Alpha, jdouble Delta, jdouble PMAlpha, jdouble PMDelta)
{
CAAPrecession* __obj = (CAAPrecession*) __imp;
CAA2DCoordinate __retval_temp(__obj->AdjustPositionUsingUniformProperMotion((double)t, (double)Alpha, (double)Delta, (double)PMAlpha, (double)PMDelta));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPrecession__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble deltar, jdouble t, jdouble Alpha, jdouble Delta, jdouble PMAlpha, jdouble PMDelta)
{
CAAPrecession* __obj = (CAAPrecession*) __imp;
CAA2DCoordinate __retval_temp(__obj->AdjustPositionUsingMotionInSpace((double)r, (double)deltar, (double)t, (double)Alpha, (double)Delta, (double)PMAlpha, (double)PMDelta));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPrecession__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPrecession* __obj = new CAAPrecession();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPrecession__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPrecession* __obj = (CAAPrecession*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
