// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEclipses.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEclipses__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAEclipses* __obj = (CAAEclipses*) __imp;
CAASolarEclipseDetails __retval_temp(__obj->CalculateSolar((double)k));
CAASolarEclipseDetails* __retval = new CAASolarEclipseDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEclipses__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAEclipses* __obj = (CAAEclipses*) __imp;
CAALunarEclipseDetails __retval_temp(__obj->CalculateLunar((double)k));
CAALunarEclipseDetails* __retval = new CAALunarEclipseDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEclipses__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEclipses* __obj = new CAAEclipses();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEclipses__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEclipses* __obj = (CAAEclipses*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
