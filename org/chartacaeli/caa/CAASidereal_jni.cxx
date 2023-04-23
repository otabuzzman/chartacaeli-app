// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AASidereal.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASidereal__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAASidereal* __obj = (CAASidereal*) __imp;
double __retval = __obj->MeanGreenwichSiderealTime((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASidereal__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAASidereal* __obj = (CAASidereal*) __imp;
double __retval = __obj->ApparentGreenwichSiderealTime((double)JD);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASidereal__1_1cdefault(JNIEnv* __env, jobject)
{
CAASidereal* __obj = new CAASidereal();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAASidereal__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAASidereal* __obj = (CAASidereal*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
