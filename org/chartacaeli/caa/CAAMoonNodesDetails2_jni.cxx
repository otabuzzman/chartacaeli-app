// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoonNodes2.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAAMoonNodesDetails2__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonNodesDetails2* __obj = (CAAMoonNodesDetails2*) __imp;
return static_cast<jint> (__obj->type);
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonNodesDetails2__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonNodesDetails2* __obj = (CAAMoonNodesDetails2*) __imp;
return (jdouble) __obj->JD;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoonNodesDetails2__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoonNodesDetails2* __obj = new CAAMoonNodesDetails2();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoonNodesDetails2__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonNodesDetails2* __obj = (CAAMoonNodesDetails2*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
