// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEaster.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEaster__1_1m0(JNIEnv* __env, jclass, jlong __imp, jint nYear, jboolean GregorianCalendar)
{
CAAEaster* __obj = (CAAEaster*) __imp;
CAAEasterDetails __retval_temp(__obj->Calculate((int)nYear, (bool)GregorianCalendar));
const CAAEasterDetails* __retval = new CAAEasterDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEaster__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEaster* __obj = new CAAEaster();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEaster__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEaster* __obj = (CAAEaster*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
