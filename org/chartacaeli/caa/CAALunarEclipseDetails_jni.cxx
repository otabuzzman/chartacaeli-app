// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEclipses.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jboolean) __obj->bEclipse;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->TimeOfMaximumEclipse;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->F;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->u;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->gamma;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->PenumbralRadii;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->UmbralRadii;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m7(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->PenumbralMagnitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m8(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->UmbralMagnitude;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m9(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->PartialPhaseSemiDuration;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m10(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->TotalPhaseSemiDuration;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1m11(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
return (jdouble) __obj->PartialPhasePenumbraSemiDuration;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAALunarEclipseDetails* __obj = new CAALunarEclipseDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAALunarEclipseDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAALunarEclipseDetails* __obj = (CAALunarEclipseDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
