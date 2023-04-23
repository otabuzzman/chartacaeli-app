// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAELP2000.h"
#include "AA3DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->EclipticLongitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->EclipticLongitude((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->EclipticLatitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->EclipticLatitude((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->RadiusVector((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->RadiusVector((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
CAA3DCoordinate __retval_temp(__obj->EclipticRectangularCoordinates((double)JD));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
CAA3DCoordinate __retval_temp(__obj->EclipticRectangularCoordinatesJ2000((double)JD));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
CAA3DCoordinate __retval_temp(__obj->EquatorialRectangularCoordinatesFK5((double)JD));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->MoonMeanMeanLongitude((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m10(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MoonMeanMeanLongitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m11(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->MeanLongitudeLunarPerigee((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m12(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MeanLongitudeLunarPerigee((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m13(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->MeanLongitudeLunarAscendingNode((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m14(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MeanLongitudeLunarAscendingNode((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m15(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->MeanHeliocentricMeanLongitudeEarthMoonBarycentre((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m16(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MeanHeliocentricMeanLongitudeEarthMoonBarycentre((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m17(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->MeanLongitudeOfPerihelionOfEarthMoonBarycentre((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m18(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MeanLongitudeOfPerihelionOfEarthMoonBarycentre((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m19(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->MoonMeanSolarElongation((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m20(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MoonMeanSolarElongation((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m21(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->SunMeanAnomaly((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m22(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->SunMeanAnomaly((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m23(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->MoonMeanAnomaly((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m24(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MoonMeanAnomaly((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m25(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
double __retval = __obj->MoonMeanArgumentOfLatitude((const double*)__TpT, (int)nTSize);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m26(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MoonMeanArgumentOfLatitude((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m27(JNIEnv* __env, jclass, jlong __imp, jdouble T)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MercuryMeanLongitude((double)T);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m28(JNIEnv* __env, jclass, jlong __imp, jdouble T)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->VenusMeanLongitude((double)T);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m29(JNIEnv* __env, jclass, jlong __imp, jdouble T)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->MarsMeanLongitude((double)T);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m30(JNIEnv* __env, jclass, jlong __imp, jdouble T)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->JupiterMeanLongitude((double)T);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m31(JNIEnv* __env, jclass, jlong __imp, jdouble T)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->SaturnMeanLongitude((double)T);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m32(JNIEnv* __env, jclass, jlong __imp, jdouble T)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->UranusMeanLongitude((double)T);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1m33(JNIEnv* __env, jclass, jlong __imp, jdouble T)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
double __retval = __obj->NeptuneMeanLongitude((double)T);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1cdefault(JNIEnv* __env, jobject)
{
CAAELP2000* __obj = new CAAELP2000();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAELP2000__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAELP2000* __obj = (CAAELP2000*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
