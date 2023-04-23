// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAFK5.h"
#include "AA3DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAFK5__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Longitude, jdouble Latitude, jdouble JD)
{
CAAFK5* __obj = (CAAFK5*) __imp;
double __retval = __obj->CorrectionInLongitude((double)Longitude, (double)Latitude, (double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAFK5__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble Longitude, jdouble JD)
{
CAAFK5* __obj = (CAAFK5*) __imp;
double __retval = __obj->CorrectionInLatitude((double)Longitude, (double)JD);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAFK5__1_1m2(JNIEnv* __env, jclass, jlong __imp, jlong value)
{
CAAFK5* __obj = (CAAFK5*) __imp;
CAA3DCoordinate __retval_temp(__obj->ConvertVSOPToFK5J2000(*((CAA3DCoordinate*) value)));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAFK5__1_1m3(JNIEnv* __env, jclass, jlong __imp, jlong value)
{
CAAFK5* __obj = (CAAFK5*) __imp;
CAA3DCoordinate __retval_temp(__obj->ConvertVSOPToFK5B1950(*((CAA3DCoordinate*) value)));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAFK5__1_1m4(JNIEnv* __env, jclass, jlong __imp, jlong value, jdouble JDEquinox)
{
CAAFK5* __obj = (CAAFK5*) __imp;
CAA3DCoordinate __retval_temp(__obj->ConvertVSOPToFK5AnyEquinox(*((CAA3DCoordinate*) value), (double)JDEquinox));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAFK5__1_1cdefault(JNIEnv* __env, jobject)
{
CAAFK5* __obj = new CAAFK5();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAFK5__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAFK5* __obj = (CAAFK5*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
