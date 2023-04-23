// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAMoslemCalendar.h"
#include "AADate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoslemCalendar__1_1m0(JNIEnv* __env, jclass, jlong __imp, jlong Year, jlong Month, jlong Day)
{
CAAMoslemCalendar* __obj = (CAAMoslemCalendar*) __imp;
CAACalendarDate __retval_temp(__obj->MoslemToJulian((long)Year, (long)Month, (long)Day));
CAACalendarDate* __retval = new CAACalendarDate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoslemCalendar__1_1m1(JNIEnv* __env, jclass, jlong __imp, jlong Year, jlong Month, jlong Day)
{
CAAMoslemCalendar* __obj = (CAAMoslemCalendar*) __imp;
CAACalendarDate __retval_temp(__obj->JulianToMoslem((long)Year, (long)Month, (long)Day));
CAACalendarDate* __retval = new CAACalendarDate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAAMoslemCalendar__1_1m2(JNIEnv* __env, jclass, jlong __imp, jlong Year)
{
CAAMoslemCalendar* __obj = (CAAMoslemCalendar*) __imp;
bool __retval = __obj->IsLeap((long)Year);
return (jboolean) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAMoslemCalendar__1_1cdefault(JNIEnv* __env, jobject)
{
CAAMoslemCalendar* __obj = new CAAMoslemCalendar();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAMoslemCalendar__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAMoslemCalendar* __obj = (CAAMoslemCalendar*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
