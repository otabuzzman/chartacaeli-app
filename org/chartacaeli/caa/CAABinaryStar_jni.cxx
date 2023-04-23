// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AABinaryStar.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAABinaryStar__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble t, jdouble P, jdouble T, jdouble e, jdouble a, jdouble i, jdouble omega, jdouble w)
{
CAABinaryStar* __obj = (CAABinaryStar*) __imp;
CAABinaryStarDetails __retval_temp(__obj->Calculate((double)t, (double)P, (double)T, (double)e, (double)a, (double)i, (double)omega, (double)w));
CAABinaryStarDetails* __retval = new CAABinaryStarDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAABinaryStar__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble e, jdouble i, jdouble w)
{
CAABinaryStar* __obj = (CAABinaryStar*) __imp;
double __retval = __obj->ApparentEccentricity((double)e, (double)i, (double)w);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAABinaryStar__1_1cdefault(JNIEnv* __env, jobject)
{
CAABinaryStar* __obj = new CAABinaryStar();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAABinaryStar__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAABinaryStar* __obj = (CAABinaryStar*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
