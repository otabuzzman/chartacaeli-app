// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AANodes.h"
#include "AAParabolic.h"
#include "AAElliptical.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANodes__1_1m0(JNIEnv* __env, jclass, jlong __imp, jlong elements)
{
CAANodes* __obj = (CAANodes*) __imp;
CAANodeObjectDetails __retval_temp(__obj->PassageThroAscendingNode(*((CAAEllipticalObjectElements*) elements)));
CAANodeObjectDetails* __retval = new CAANodeObjectDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANodes__1_1m1(JNIEnv* __env, jclass, jlong __imp, jlong elements)
{
CAANodes* __obj = (CAANodes*) __imp;
CAANodeObjectDetails __retval_temp(__obj->PassageThroDescendingNode(*((CAAEllipticalObjectElements*) elements)));
CAANodeObjectDetails* __retval = new CAANodeObjectDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANodes__1_1m2(JNIEnv* __env, jclass, jlong __imp, jlong elements)
{
CAANodes* __obj = (CAANodes*) __imp;
CAANodeObjectDetails __retval_temp(__obj->PassageThroAscendingNode(*((CAAParabolicObjectElements*) elements)));
CAANodeObjectDetails* __retval = new CAANodeObjectDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANodes__1_1m3(JNIEnv* __env, jclass, jlong __imp, jlong elements)
{
CAANodes* __obj = (CAANodes*) __imp;
CAANodeObjectDetails __retval_temp(__obj->PassageThroDescendingNode(*((CAAParabolicObjectElements*) elements)));
CAANodeObjectDetails* __retval = new CAANodeObjectDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAANodes__1_1cdefault(JNIEnv* __env, jobject)
{
CAANodes* __obj = new CAANodes();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAANodes__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAANodes* __obj = (CAANodes*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
