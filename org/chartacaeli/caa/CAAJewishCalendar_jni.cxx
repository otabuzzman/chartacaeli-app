// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAJewishCalendar.h"
#include "AADate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAJewishCalendar__1_1m0(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bGregorianCalendar)
{
CAAJewishCalendar* __obj = (CAAJewishCalendar*) __imp;
CAACalendarDate __retval_temp(__obj->DateOfPesach((long)Year, (bool)bGregorianCalendar));
CAACalendarDate* __retval = new CAACalendarDate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAAJewishCalendar__1_1m1(JNIEnv* __env, jclass, jlong __imp, jlong Year)
{
CAAJewishCalendar* __obj = (CAAJewishCalendar*) __imp;
bool __retval = __obj->IsLeap((long)Year);
return (jboolean) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAJewishCalendar__1_1m2(JNIEnv* __env, jclass, jlong __imp, jlong Year)
{
CAAJewishCalendar* __obj = (CAAJewishCalendar*) __imp;
long __retval = __obj->DaysInYear((long)Year);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAJewishCalendar__1_1cdefault(JNIEnv* __env, jobject)
{
CAAJewishCalendar* __obj = new CAAJewishCalendar();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAJewishCalendar__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAJewishCalendar* __obj = (CAAJewishCalendar*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
