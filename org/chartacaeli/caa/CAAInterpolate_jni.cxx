// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAInterpolate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble n, jdouble Y1, jdouble Y2, jdouble Y3)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
double __retval = __obj->Interpolate((double)n, (double)Y1, (double)Y2, (double)Y3);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble n, jdouble Y1, jdouble Y2, jdouble Y3, jdouble Y4, jdouble Y5)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
double __retval = __obj->Interpolate((double)n, (double)Y1, (double)Y2, (double)Y3, (double)Y4, (double)Y5);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble Y1, jdouble Y2, jdouble Y3, jdouble Y4)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
const double __retval = __obj->InterpolateToHalves((double)Y1, (double)Y2, (double)Y3, (double)Y4);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble X, jint n, jdoubleArray pX, jdoubleArray pY)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
jdouble* __TpX = __env->GetDoubleArrayElements(pX, NULL);
jdouble* __TpY = __env->GetDoubleArrayElements(pY, NULL);
double __retval = __obj->LagrangeInterpolate((double)X, (int)n, (const double*)__TpX, (const double*)__TpY);
__env->ReleaseDoubleArrayElements(pX, __TpX, 0);
__env->ReleaseDoubleArrayElements(pY, __TpY, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble Y1, jdouble Y2, jdouble Y3, jdoubleArray nm)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
jdouble* __Tnm = __env->GetDoubleArrayElements(nm, NULL);
double __retval = __obj->Extremum((double)Y1, (double)Y2, (double)Y3, *((double*)__Tnm));
__env->ReleaseDoubleArrayElements(nm, __Tnm, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble Y1, jdouble Y2, jdouble Y3, jdouble Y4, jdouble Y5, jdoubleArray nm, jdouble epsilon)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
jdouble* __Tnm = __env->GetDoubleArrayElements(nm, NULL);
double __retval = __obj->Extremum((double)Y1, (double)Y2, (double)Y3, (double)Y4, (double)Y5, *((double*)__Tnm), (double)epsilon);
__env->ReleaseDoubleArrayElements(nm, __Tnm, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble Y1, jdouble Y2, jdouble Y3, jdouble epsilon)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
double __retval = __obj->Zero((double)Y1, (double)Y2, (double)Y3, (double)epsilon);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble Y1, jdouble Y2, jdouble Y3, jdouble Y4, jdouble Y5, jdouble epsilon)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
double __retval = __obj->Zero((double)Y1, (double)Y2, (double)Y3, (double)Y4, (double)Y5, (double)epsilon);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdouble Y1, jdouble Y2, jdouble Y3, jdouble epsilon)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
double __retval = __obj->Zero2((double)Y1, (double)Y2, (double)Y3, (double)epsilon);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdouble Y1, jdouble Y2, jdouble Y3, jdouble Y4, jdouble Y5, jdouble epsilon)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
double __retval = __obj->Zero2((double)Y1, (double)Y2, (double)Y3, (double)Y4, (double)Y5, (double)epsilon);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1cdefault(JNIEnv* __env, jobject)
{
CAAInterpolate* __obj = new CAAInterpolate();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAInterpolate__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAInterpolate* __obj = (CAAInterpolate*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
