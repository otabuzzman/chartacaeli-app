// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoonMaxDeclinations.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonMaxDeclinations__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAMoonMaxDeclinations* __obj = (CAAMoonMaxDeclinations*) __imp;
const double __retval = __obj->K((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonMaxDeclinations__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble k, jboolean bNortherly)
{
CAAMoonMaxDeclinations* __obj = (CAAMoonMaxDeclinations*) __imp;
double __retval = __obj->MeanGreatestDeclination((double)k, (bool)bNortherly);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonMaxDeclinations__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonMaxDeclinations* __obj = (CAAMoonMaxDeclinations*) __imp;
double __retval = __obj->MeanGreatestDeclinationValue((double)k);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonMaxDeclinations__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble k, jboolean bNortherly)
{
CAAMoonMaxDeclinations* __obj = (CAAMoonMaxDeclinations*) __imp;
double __retval = __obj->TrueGreatestDeclination((double)k, (bool)bNortherly);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonMaxDeclinations__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble k, jboolean bNortherly)
{
CAAMoonMaxDeclinations* __obj = (CAAMoonMaxDeclinations*) __imp;
double __retval = __obj->TrueGreatestDeclinationValue((double)k, (bool)bNortherly);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoonMaxDeclinations__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoonMaxDeclinations* __obj = new CAAMoonMaxDeclinations();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoonMaxDeclinations__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonMaxDeclinations* __obj = (CAAMoonMaxDeclinations*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
