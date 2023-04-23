// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEclipses.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m0(JNIEnv* __env, jclass, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jint) __obj->TOTAL_ECLIPSE;
}

JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m1(JNIEnv* __env, jclass, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jint) __obj->ANNULAR_ECLIPSE;
}

JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m2(JNIEnv* __env, jclass, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jint) __obj->ANNULAR_TOTAL_ECLIPSE;
}

JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m3(JNIEnv* __env, jclass, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jint) __obj->CENTRAL_ECLIPSE;
}

JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m4(JNIEnv* __env, jclass, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jint) __obj->PARTIAL_ECLIPSE;
}

JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m5(JNIEnv* __env, jclass, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jint) __obj->NON_CENTRAL_ECLIPSE;
}

JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jint) __obj->Flags;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m7(JNIEnv* __env, jobject, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jdouble) __obj->TimeOfMaximumEclipse;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m8(JNIEnv* __env, jobject, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jdouble) __obj->F;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m9(JNIEnv* __env, jobject, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jdouble) __obj->u;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m10(JNIEnv* __env, jobject, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jdouble) __obj->gamma;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1m11(JNIEnv* __env, jobject, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
return (jdouble) __obj->GreatestMagnitude;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAASolarEclipseDetails* __obj = new CAASolarEclipseDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAASolarEclipseDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAASolarEclipseDetails* __obj = (CAASolarEclipseDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
