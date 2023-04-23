// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AARiseTransitSet.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails* __obj = (CAARiseTransitSetDetails*) __imp;
return (jboolean) __obj->bRiseValid;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails* __obj = (CAARiseTransitSetDetails*) __imp;
return (jdouble) __obj->Rise;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails* __obj = (CAARiseTransitSetDetails*) __imp;
return (jboolean) __obj->bTransitValid;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails* __obj = (CAARiseTransitSetDetails*) __imp;
return (jboolean) __obj->bTransitAboveHorizon;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails* __obj = (CAARiseTransitSetDetails*) __imp;
return (jdouble) __obj->Transit;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails* __obj = (CAARiseTransitSetDetails*) __imp;
return (jboolean) __obj->bSetValid;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails* __obj = (CAARiseTransitSetDetails*) __imp;
return (jdouble) __obj->Set;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAARiseTransitSetDetails* __obj = new CAARiseTransitSetDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAARiseTransitSetDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSetDetails* __obj = (CAARiseTransitSetDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
