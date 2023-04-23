// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAPhysicalJupiter.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiterDetails__1_1m0(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalJupiterDetails* __obj = (CAAPhysicalJupiterDetails*) __imp;
return (jdouble) __obj->DE;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiterDetails__1_1m1(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalJupiterDetails* __obj = (CAAPhysicalJupiterDetails*) __imp;
return (jdouble) __obj->DS;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiterDetails__1_1m2(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalJupiterDetails* __obj = (CAAPhysicalJupiterDetails*) __imp;
return (jdouble) __obj->Geometricw1;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiterDetails__1_1m3(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalJupiterDetails* __obj = (CAAPhysicalJupiterDetails*) __imp;
return (jdouble) __obj->Geometricw2;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiterDetails__1_1m4(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalJupiterDetails* __obj = (CAAPhysicalJupiterDetails*) __imp;
return (jdouble) __obj->Apparentw1;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiterDetails__1_1m5(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalJupiterDetails* __obj = (CAAPhysicalJupiterDetails*) __imp;
return (jdouble) __obj->Apparentw2;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiterDetails__1_1m6(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalJupiterDetails* __obj = (CAAPhysicalJupiterDetails*) __imp;
return (jdouble) __obj->P;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiterDetails__1_1cdefault(JNIEnv* __env, jobject)
{
CAAPhysicalJupiterDetails* __obj = new CAAPhysicalJupiterDetails();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAPhysicalJupiterDetails__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAPhysicalJupiterDetails* __obj = (CAAPhysicalJupiterDetails*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
