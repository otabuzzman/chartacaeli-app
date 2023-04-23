// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoonNodes.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonNodes__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Year)
{
CAAMoonNodes* __obj = (CAAMoonNodes*) __imp;
const double __retval = __obj->K((double)Year);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAMoonNodes__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble k)
{
CAAMoonNodes* __obj = (CAAMoonNodes*) __imp;
double __retval = __obj->PassageThroNode((double)k);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoonNodes__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoonNodes* __obj = new CAAMoonNodes();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoonNodes__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoonNodes* __obj = (CAAMoonNodes*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
