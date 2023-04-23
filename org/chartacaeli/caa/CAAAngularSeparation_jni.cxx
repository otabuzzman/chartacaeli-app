// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAAngularSeparation.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAAngularSeparation__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha1, jdouble Delta1, jdouble Alpha2, jdouble Delta2)
{
CAAAngularSeparation* __obj = (CAAAngularSeparation*) __imp;
double __retval = __obj->Separation((double)Alpha1, (double)Delta1, (double)Alpha2, (double)Delta2);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAAngularSeparation__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha1, jdouble Delta1, jdouble Alpha2, jdouble Delta2)
{
CAAAngularSeparation* __obj = (CAAAngularSeparation*) __imp;
double __retval = __obj->PositionAngle((double)Alpha1, (double)Delta1, (double)Alpha2, (double)Delta2);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAAngularSeparation__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha1, jdouble Delta1, jdouble Alpha2, jdouble Delta2, jdouble Alpha3, jdouble Delta3)
{
CAAAngularSeparation* __obj = (CAAAngularSeparation*) __imp;
double __retval = __obj->DistanceFromGreatArc((double)Alpha1, (double)Delta1, (double)Alpha2, (double)Delta2, (double)Alpha3, (double)Delta3);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAAngularSeparation__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble Alpha1, jdouble Delta1, jdouble Alpha2, jdouble Delta2, jdouble Alpha3, jdouble Delta3, jbooleanArray bType1)
{
CAAAngularSeparation* __obj = (CAAAngularSeparation*) __imp;
jboolean* __TbType1 = __env->GetBooleanArrayElements(bType1, NULL);
double __retval = __obj->SmallestCircle((double)Alpha1, (double)Delta1, (double)Alpha2, (double)Delta2, (double)Alpha3, (double)Delta3, *((bool*)__TbType1));
__env->ReleaseBooleanArrayElements(bType1, __TbType1, 0);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAAngularSeparation__1_1cdefault(JNIEnv* __env, jobject)
{
CAAAngularSeparation* __obj = new CAAAngularSeparation();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAAngularSeparation__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAAngularSeparation* __obj = (CAAAngularSeparation*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
