// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPlanetaryPhenomena.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetaryPhenomena__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble Year, jint planet, jint type)
{
CAAPlanetaryPhenomena* __obj = (CAAPlanetaryPhenomena*) __imp;
double __retval = __obj->K((double)Year, (CAAPlanetaryPhenomena::Planet) planet, (CAAPlanetaryPhenomena::Type) type);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetaryPhenomena__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble k, jint planet, jint type)
{
CAAPlanetaryPhenomena* __obj = (CAAPlanetaryPhenomena*) __imp;
double __retval = __obj->Mean((double)k, (CAAPlanetaryPhenomena::Planet) planet, (CAAPlanetaryPhenomena::Type) type);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetaryPhenomena__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble k, jint planet, jint type)
{
CAAPlanetaryPhenomena* __obj = (CAAPlanetaryPhenomena*) __imp;
double __retval = __obj->True((double)k, (CAAPlanetaryPhenomena::Planet) planet, (CAAPlanetaryPhenomena::Type) type);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPlanetaryPhenomena__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble k, jint planet, jboolean bEastern)
{
CAAPlanetaryPhenomena* __obj = (CAAPlanetaryPhenomena*) __imp;
double __retval = __obj->ElongationValue((double)k, (CAAPlanetaryPhenomena::Planet) planet, (bool)bEastern);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPlanetaryPhenomena__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPlanetaryPhenomena* __obj = new CAAPlanetaryPhenomena();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPlanetaryPhenomena__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPlanetaryPhenomena* __obj = (CAAPlanetaryPhenomena*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
