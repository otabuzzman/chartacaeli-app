// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAELPMPP02.h"
#include "AA3DCoordinate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jint correction, jdoubleArray pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
jdouble* __TpDerivative = __env->GetDoubleArrayElements(pDerivative, NULL);
double __retval = __obj->EclipticLongitude((double)JD, (CAAELPMPP02::Correction) correction, (double*)__TpDerivative);
__env->ReleaseDoubleArrayElements(pDerivative, __TpDerivative, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize, jint correction, jdoubleArray pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
jdouble* __TpDerivative = __env->GetDoubleArrayElements(pDerivative, NULL);
double __retval = __obj->EclipticLongitude((const double*)__TpT, (int)nTSize, (CAAELPMPP02::Correction) correction, (double*)__TpDerivative);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
__env->ReleaseDoubleArrayElements(pDerivative, __TpDerivative, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jint correction, jdoubleArray pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
jdouble* __TpDerivative = __env->GetDoubleArrayElements(pDerivative, NULL);
double __retval = __obj->EclipticLatitude((double)JD, (CAAELPMPP02::Correction) correction, (double*)__TpDerivative);
__env->ReleaseDoubleArrayElements(pDerivative, __TpDerivative, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize, jint correction, jdoubleArray pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
jdouble* __TpDerivative = __env->GetDoubleArrayElements(pDerivative, NULL);
double __retval = __obj->EclipticLatitude((const double*)__TpT, (int)nTSize, (CAAELPMPP02::Correction) correction, (double*)__TpDerivative);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
__env->ReleaseDoubleArrayElements(pDerivative, __TpDerivative, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jint correction, jdoubleArray pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
jdouble* __TpDerivative = __env->GetDoubleArrayElements(pDerivative, NULL);
double __retval = __obj->RadiusVector((double)JD, (CAAELPMPP02::Correction) correction, (double*)__TpDerivative);
__env->ReleaseDoubleArrayElements(pDerivative, __TpDerivative, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize, jint correction, jdoubleArray pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
jdouble* __TpDerivative = __env->GetDoubleArrayElements(pDerivative, NULL);
double __retval = __obj->RadiusVector((const double*)__TpT, (int)nTSize, (CAAELPMPP02::Correction) correction, (double*)__TpDerivative);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
__env->ReleaseDoubleArrayElements(pDerivative, __TpDerivative, 0);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jint correction, jlong pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
CAA3DCoordinate __retval_temp(__obj->EclipticRectangularCoordinates((double)JD, (CAAELPMPP02::Correction) correction, (CAA3DCoordinate*) pDerivative));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize, jint correction, jlong pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
CAA3DCoordinate __retval_temp(__obj->EclipticRectangularCoordinates((const double*)__TpT, (int)nTSize, (CAAELPMPP02::Correction) correction, (CAA3DCoordinate*) pDerivative));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jint correction, jlong pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
CAA3DCoordinate __retval_temp(__obj->EclipticRectangularCoordinatesJ2000((double)JD, (CAAELPMPP02::Correction) correction, (CAA3DCoordinate*) pDerivative));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1m10(JNIEnv* __env, jclass, jlong __imp, jdoubleArray pT, jint nTSize, jint correction, jlong pDerivative)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
jdouble* __TpT = __env->GetDoubleArrayElements(pT, NULL);
CAA3DCoordinate __retval_temp(__obj->EclipticRectangularCoordinatesJ2000((const double*)__TpT, (int)nTSize, (CAAELPMPP02::Correction) correction, (CAA3DCoordinate*) pDerivative));
CAA3DCoordinate* __retval = new CAA3DCoordinate(__retval_temp);
__env->ReleaseDoubleArrayElements(pT, __TpT, 0);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1cdefault(JNIEnv* __env, jobject)
{
CAAELPMPP02* __obj = new CAAELPMPP02();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAELPMPP02__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAELPMPP02* __obj = (CAAELPMPP02*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
