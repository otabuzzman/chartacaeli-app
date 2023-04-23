// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAStellarMagnitudes.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAStellarMagnitudes__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble m1, jdouble m2)
{
CAAStellarMagnitudes* __obj = (CAAStellarMagnitudes*) __imp;
double __retval = __obj->CombinedMagnitude((double)m1, (double)m2);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAStellarMagnitudes__1_1m1(JNIEnv* __env, jclass, jlong __imp, jint Magnitudes, jdoubleArray pMagnitudes)
{
CAAStellarMagnitudes* __obj = (CAAStellarMagnitudes*) __imp;
jdouble* __TpMagnitudes = __env->GetDoubleArrayElements(pMagnitudes, NULL);
double __retval = __obj->CombinedMagnitude((int)Magnitudes, (const double*)__TpMagnitudes);
__env->ReleaseDoubleArrayElements(pMagnitudes, __TpMagnitudes, 0);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAStellarMagnitudes__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble m1, jdouble m2)
{
CAAStellarMagnitudes* __obj = (CAAStellarMagnitudes*) __imp;
double __retval = __obj->BrightnessRatio((double)m1, (double)m2);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAStellarMagnitudes__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble brightnessRatio)
{
CAAStellarMagnitudes* __obj = (CAAStellarMagnitudes*) __imp;
double __retval = __obj->MagnitudeDifference((double)brightnessRatio);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAStellarMagnitudes__1_1cdefault(JNIEnv* __env, jobject)
{
CAAStellarMagnitudes* __obj = new CAAStellarMagnitudes();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAStellarMagnitudes__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAStellarMagnitudes* __obj = (CAAStellarMagnitudes*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
