// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AACoordinateTransformation.h"
#include "AA2DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Delta, jdouble Epsilon)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
CAA2DCoordinate __retval_temp(__obj->Equatorial2Ecliptic((double)Alpha, (double)Delta, (double)Epsilon));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble Lambda, jdouble Beta, jdouble Epsilon)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
CAA2DCoordinate __retval_temp(__obj->Ecliptic2Equatorial((double)Lambda, (double)Beta, (double)Epsilon));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble LocalHourAngle, jdouble Delta, jdouble Latitude)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
CAA2DCoordinate __retval_temp(__obj->Equatorial2Horizontal((double)LocalHourAngle, (double)Delta, (double)Latitude));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble A, jdouble h, jdouble Latitude)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
CAA2DCoordinate __retval_temp(__obj->Horizontal2Equatorial((double)A, (double)h, (double)Latitude));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha, jdouble Delta)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
CAA2DCoordinate __retval_temp(__obj->Equatorial2Galactic((double)Alpha, (double)Delta));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble l, jdouble b)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
CAA2DCoordinate __retval_temp(__obj->Galactic2Equatorial((double)l, (double)b));
CAA2DCoordinate* __retval = new CAA2DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble Degrees)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
const double __retval = __obj->DegreesToRadians((double)Degrees);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble Radians)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
const double __retval = __obj->RadiansToDegrees((double)Radians);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdouble Radians)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
const double __retval = __obj->RadiansToHours((double)Radians);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdouble Hours)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
const double __retval = __obj->HoursToRadians((double)Hours);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m10(JNIEnv* __env, jclass, jlong __imp, jdouble Hours)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
const double __retval = __obj->HoursToDegrees((double)Hours);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m11(JNIEnv* __env, jclass, jlong __imp, jdouble Degrees)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
const double __retval = __obj->DegreesToHours((double)Degrees);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m12(JNIEnv* __env, jclass, jlong __imp)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
const double __retval = __obj->PI();
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m13(JNIEnv* __env, jclass, jlong __imp, jdouble Degrees)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
double __retval = __obj->MapTo0To360Range((double)Degrees);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m14(JNIEnv* __env, jclass, jlong __imp, jdouble Degrees)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
double __retval = __obj->MapToMinus90To90Range((double)Degrees);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m15(JNIEnv* __env, jclass, jlong __imp, jdouble HourAngle)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
double __retval = __obj->MapTo0To24Range((double)HourAngle);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m16(JNIEnv* __env, jclass, jlong __imp, jdouble Angle)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
double __retval = __obj->MapTo0To2PIRange((double)Angle);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1m17(JNIEnv* __env, jclass, jlong __imp, jdouble Degrees, jdouble Minutes, jdouble Seconds, jboolean bPositive)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
double __retval = __obj->DMSToDegrees((double)Degrees, (double)Minutes, (double)Seconds, (bool)bPositive);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1cdefault(JNIEnv* __env, jobject)
{
CAACoordinateTransformation* __obj = new CAACoordinateTransformation();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAACoordinateTransformation__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAACoordinateTransformation* __obj = (CAACoordinateTransformation*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
