// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAEclipticalElements.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEclipticalElements__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble i0, jdouble w0, jdouble omega0, jdouble JD0, jdouble JD)
{
CAAEclipticalElements* __obj = (CAAEclipticalElements*) __imp;
CAAEclipticalElementDetails __retval_temp(__obj->Calculate((double)i0, (double)w0, (double)omega0, (double)JD0, (double)JD));
CAAEclipticalElementDetails* __retval = new CAAEclipticalElementDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEclipticalElements__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble i0, jdouble w0, jdouble omega0)
{
CAAEclipticalElements* __obj = (CAAEclipticalElements*) __imp;
CAAEclipticalElementDetails __retval_temp(__obj->FK4B1950ToFK5J2000((double)i0, (double)w0, (double)omega0));
CAAEclipticalElementDetails* __retval = new CAAEclipticalElementDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAEclipticalElements__1_1cdefault(JNIEnv* __env, jobject)
{
CAAEclipticalElements* __obj = new CAAEclipticalElements();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAEclipticalElements__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAEclipticalElements* __obj = (CAAEclipticalElements*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
