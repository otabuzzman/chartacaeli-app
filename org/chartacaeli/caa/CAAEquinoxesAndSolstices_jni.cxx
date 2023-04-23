// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEquinoxesAndSolstices.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1m0(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bHighPrecision)
{
CAAEquinoxesAndSolstices* __obj = (CAAEquinoxesAndSolstices*) __imp;
double __retval = __obj->NorthwardEquinox((long)Year, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1m1(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bHighPrecision)
{
CAAEquinoxesAndSolstices* __obj = (CAAEquinoxesAndSolstices*) __imp;
double __retval = __obj->NorthernSolstice((long)Year, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1m2(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bHighPrecision)
{
CAAEquinoxesAndSolstices* __obj = (CAAEquinoxesAndSolstices*) __imp;
double __retval = __obj->SouthwardEquinox((long)Year, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1m3(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bHighPrecision)
{
CAAEquinoxesAndSolstices* __obj = (CAAEquinoxesAndSolstices*) __imp;
double __retval = __obj->SouthernSolstice((long)Year, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1m4(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bNorthernHemisphere, jboolean bHighPrecision)
{
CAAEquinoxesAndSolstices* __obj = (CAAEquinoxesAndSolstices*) __imp;
double __retval = __obj->LengthOfSpring((long)Year, (bool)bNorthernHemisphere, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1m5(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bNorthernHemisphere, jboolean bHighPrecision)
{
CAAEquinoxesAndSolstices* __obj = (CAAEquinoxesAndSolstices*) __imp;
double __retval = __obj->LengthOfSummer((long)Year, (bool)bNorthernHemisphere, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1m6(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bNorthernHemisphere, jboolean bHighPrecision)
{
CAAEquinoxesAndSolstices* __obj = (CAAEquinoxesAndSolstices*) __imp;
double __retval = __obj->LengthOfAutumn((long)Year, (bool)bNorthernHemisphere, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1m7(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bNorthernHemisphere, jboolean bHighPrecision)
{
CAAEquinoxesAndSolstices* __obj = (CAAEquinoxesAndSolstices*) __imp;
double __retval = __obj->LengthOfWinter((long)Year, (bool)bNorthernHemisphere, (bool)bHighPrecision);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEquinoxesAndSolstices* __obj = new CAAEquinoxesAndSolstices();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEquinoxesAndSolstices__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEquinoxesAndSolstices* __obj = (CAAEquinoxesAndSolstices*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
