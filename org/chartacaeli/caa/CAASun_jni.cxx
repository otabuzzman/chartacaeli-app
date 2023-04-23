// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AASun.h"
#include "AA3DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASun__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
double __retval = __obj->GeometricEclipticLongitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASun__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
double __retval = __obj->GeometricEclipticLatitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASun__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
double __retval = __obj->GeometricEclipticLongitudeJ2000((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASun__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
double __retval = __obj->GeometricEclipticLatitudeJ2000((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASun__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
double __retval = __obj->GeometricFK5EclipticLongitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASun__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
double __retval = __obj->GeometricFK5EclipticLatitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASun__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
double __retval = __obj->ApparentEclipticLongitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASun__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
double __retval = __obj->ApparentEclipticLatitude((double)JD, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASun__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAASun* __obj = (CAASun*) __imp;
double __retval = __obj->VariationGeometricEclipticLongitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASun__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
CAA3DCoordinate __retval_temp(__obj->EquatorialRectangularCoordinatesMeanEquinox((double)JD, (bool)bHighPrecision));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASun__1_1m10(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
CAA3DCoordinate __retval_temp(__obj->EclipticRectangularCoordinatesJ2000((double)JD, (bool)bHighPrecision));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASun__1_1m11(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
CAA3DCoordinate __retval_temp(__obj->EquatorialRectangularCoordinatesJ2000((double)JD, (bool)bHighPrecision));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASun__1_1m12(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
CAA3DCoordinate __retval_temp(__obj->EquatorialRectangularCoordinatesB1950((double)JD, (bool)bHighPrecision));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASun__1_1m13(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jdouble JDEquinox, jboolean bHighPrecision)
{
CAASun* __obj = (CAASun*) __imp;
CAA3DCoordinate __retval_temp(__obj->EquatorialRectangularCoordinatesAnyEquinox((double)JD, (double)JDEquinox, (bool)bHighPrecision));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASun__1_1cdefault(JNIEnv* __env, jobject)
{
CAASun* __obj = new CAASun();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAASun__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAASun* __obj = (CAASun*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
