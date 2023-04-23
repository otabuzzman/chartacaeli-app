// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAKepler.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAKepler__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble M, jdouble e, jint nIterations)
{
CAAKepler* __obj = (CAAKepler*) __imp;
double __retval = __obj->Calculate((double)M, (double)e, (int)nIterations);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAKepler__1_1cdefault(JNIEnv* __env, jobject)
{
CAAKepler* __obj = new CAAKepler();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAKepler__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAKepler* __obj = (CAAKepler*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
