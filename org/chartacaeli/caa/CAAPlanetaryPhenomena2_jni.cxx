// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPlanetaryPhenomena2.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPlanetaryPhenomena2__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPlanetaryPhenomena2* __obj = new CAAPlanetaryPhenomena2();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPlanetaryPhenomena2__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPlanetaryPhenomena2* __obj = (CAAPlanetaryPhenomena2*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
