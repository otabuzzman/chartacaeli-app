// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AARiseTransitSet.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAARiseTransitSet__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jdouble Alpha1, jdouble Delta1, jdouble Alpha2, jdouble Delta2, jdouble Alpha3, jdouble Delta3, jdouble Longitude, jdouble Latitude, jdouble h0)
{
CAARiseTransitSet* __obj = (CAARiseTransitSet*) __imp;
CAARiseTransitSetDetails __retval_temp(__obj->Calculate((double)JD, (double)Alpha1, (double)Delta1, (double)Alpha2, (double)Delta2, (double)Alpha3, (double)Delta3, (double)Longitude, (double)Latitude, (double)h0));
CAARiseTransitSetDetails* __retval = new CAARiseTransitSetDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAARiseTransitSet__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdoubleArray Alpha1, jdoubleArray Alpha2, jdoubleArray Alpha3)
{
CAARiseTransitSet* __obj = (CAARiseTransitSet*) __imp;
jdouble* __TAlpha1 = __env->GetDoubleArrayElements(Alpha1, NULL);
jdouble* __TAlpha2 = __env->GetDoubleArrayElements(Alpha2, NULL);
jdouble* __TAlpha3 = __env->GetDoubleArrayElements(Alpha3, NULL);
__obj->CorrectRAValuesForInterpolation(*((double*)__TAlpha1), *((double*)__TAlpha2), *((double*)__TAlpha3));
__env->ReleaseDoubleArrayElements(Alpha1, __TAlpha1, 0);
__env->ReleaseDoubleArrayElements(Alpha2, __TAlpha2, 0);
__env->ReleaseDoubleArrayElements(Alpha3, __TAlpha3, 0);
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAARiseTransitSet__1_1cdefault(JNIEnv* __env, jobject)
{
CAARiseTransitSet* __obj = new CAARiseTransitSet();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAARiseTransitSet__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAARiseTransitSet* __obj = (CAARiseTransitSet*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
