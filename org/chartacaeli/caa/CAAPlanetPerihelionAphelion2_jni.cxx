// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPlanetPerihelionAphelion2.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion2__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPlanetPerihelionAphelion2* __obj = new CAAPlanetPerihelionAphelion2();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPlanetPerihelionAphelion2__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPlanetPerihelionAphelion2* __obj = (CAAPlanetPerihelionAphelion2*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
