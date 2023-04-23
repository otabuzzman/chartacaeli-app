// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoonPerigeeApogee.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAMoonPerigeeApogee* __obj = (CAAMoonPerigeeApogee*) __imp;
const double __retval = __obj->K((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonPerigeeApogee* __obj = (CAAMoonPerigeeApogee*) __imp;
double __retval = __obj->MeanPerigee((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonPerigeeApogee* __obj = (CAAMoonPerigeeApogee*) __imp;
double __retval = __obj->MeanApogee((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonPerigeeApogee* __obj = (CAAMoonPerigeeApogee*) __imp;
double __retval = __obj->TruePerigee((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonPerigeeApogee* __obj = (CAAMoonPerigeeApogee*) __imp;
double __retval = __obj->TrueApogee((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonPerigeeApogee* __obj = (CAAMoonPerigeeApogee*) __imp;
double __retval = __obj->PerigeeParallax((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonPerigeeApogee* __obj = (CAAMoonPerigeeApogee*) __imp;
double __retval = __obj->ApogeeParallax((double)k);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoonPerigeeApogee* __obj = new CAAMoonPerigeeApogee();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoonPerigeeApogee__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonPerigeeApogee* __obj = (CAAMoonPerigeeApogee*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
