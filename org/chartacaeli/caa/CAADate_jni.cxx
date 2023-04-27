// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AADate.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1c1(JNIEnv* __env, jobject __jobj)
{
CAADate* __obj = new CAADate();
return (jlong) __obj;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1c2(JNIEnv* __env, jobject __jobj, jlong Year, jlong Month, jdouble Day, jboolean bGregorianCalendar)
{
CAADate* __obj = new CAADate((long)Year, (long)Month, (double)Day, (bool)bGregorianCalendar);
return (jlong) __obj;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1c3(JNIEnv* __env, jobject __jobj, jlong Year, jlong Month, jdouble Day, jdouble Hour, jdouble Minute, jdouble Second, jboolean bGregorianCalendar)
{
CAADate* __obj = new CAADate((long)Year, (long)Month, (double)Day, (double)Hour, (double)Minute, (double)Second, (bool)bGregorianCalendar);
return (jlong) __obj;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1c4(JNIEnv* __env, jobject __jobj, jdouble JD, jboolean bGregorianCalendar)
{
CAADate* __obj = new CAADate((double)JD, (bool)bGregorianCalendar);
return (jlong) __obj;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADate__1_1m5(JNIEnv* __env, jclass, jlong __imp, jlong Year, jlong Month, jdouble Day, jboolean bGregorianCalendar)
{
CAADate* __obj = (CAADate*) __imp;
double __retval = __obj->DateToJD((long)Year, (long)Month, (double)Day, (bool)bGregorianCalendar);
return (jdouble) __retval;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAADate__1_1m6(JNIEnv* __env, jclass, jlong __imp, jlong Year, jboolean bGregorianCalendar)
{
CAADate* __obj = (CAADate*) __imp;
bool __retval = __obj->IsLeap((long)Year, (bool)bGregorianCalendar);
return (jboolean) __retval;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAADate__1_1m7(JNIEnv* __env, jclass, jlong __imp, jlong DayOfYear, jboolean bLeap, jlongArray DayOfMonth, jlongArray Month)
{
CAADate* __obj = (CAADate*) __imp;
jlong* __TDayOfMonth = __env->GetLongArrayElements(DayOfMonth, NULL);
jlong* __TMonth = __env->GetLongArrayElements(Month, NULL);
__obj->DayOfYearToDayAndMonth((long)DayOfYear, (bool)bLeap, *((long*)__TDayOfMonth), *((long*)__TMonth));
__env->ReleaseLongArrayElements(DayOfMonth, __TDayOfMonth, 0);
__env->ReleaseLongArrayElements(Month, __TMonth, 0);
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m8(JNIEnv* __env, jclass, jlong __imp, jlong Year, jlong Month, jlong Day)
{
CAADate* __obj = (CAADate*) __imp;
CAACalendarDate __retval_temp(__obj->JulianToGregorian((long)Year, (long)Month, (long)Day));
CAACalendarDate* __retval = new CAACalendarDate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m9(JNIEnv* __env, jclass, jlong __imp, jlong Year, jlong Month, jlong Day)
{
CAADate* __obj = (CAADate*) __imp;
CAACalendarDate __retval_temp(__obj->GregorianToJulian((long)Year, (long)Month, (long)Day));
CAACalendarDate* __retval = new CAACalendarDate(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m10(JNIEnv* __env, jclass, jlong __imp, jdouble value)
{
CAADate* __obj = (CAADate*) __imp;
long __retval = __obj->INT((double)value);
return (jlong) __retval;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAADate__1_1m11(JNIEnv* __env, jclass, jlong __imp, jlong Year, jlong Month, jdouble Day)
{
CAADate* __obj = (CAADate*) __imp;
const bool __retval = __obj->AfterPapalReform((long)Year, (long)Month, (double)Day);
return (jboolean) __retval;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAADate__1_1m12(JNIEnv* __env, jclass, jlong __imp, jdouble JD)
{
CAADate* __obj = (CAADate*) __imp;
const bool __retval = __obj->AfterPapalReform((double)JD);
return (jboolean) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADate__1_1m13(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jlong Year, jboolean bGregorianCalendar)
{
CAADate* __obj = (CAADate*) __imp;
double __retval = __obj->DayOfYear((double)JD, (long)Year, (bool)bGregorianCalendar);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m14(JNIEnv* __env, jclass, jlong __imp, jlong Month, jboolean bLeap)
{
CAADate* __obj = (CAADate*) __imp;
long __retval = __obj->DaysInMonth((long)Month, (bool)bLeap);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADate__1_1m15(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
double __retval = __obj->Julian();
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m17(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
long __retval = __obj->Day();
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m18(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
long __retval = __obj->Month();
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m19(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
long __retval = __obj->Year();
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m20(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
long __retval = __obj->Hour();
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m21(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
long __retval = __obj->Minute();
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADate__1_1m22(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
double __retval = __obj->Second();
return (jdouble) __retval;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAADate__1_1m23(JNIEnv* __env, jobject, jlong __imp, jlong Year, jlong Month, jdouble Day, jdouble Hour, jdouble Minute, jdouble Second, jboolean bGregorianCalendar)
{
CAADate* __obj = (CAADate*) __imp;
__obj->Set((long)Year, (long)Month, (double)Day, (double)Hour, (double)Minute, (double)Second, (bool)bGregorianCalendar);
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAADate__1_1m24(JNIEnv* __env, jobject, jlong __imp, jdouble JD, jboolean bGregorianCalendar)
{
CAADate* __obj = (CAADate*) __imp;
__obj->Set((double)JD, (bool)bGregorianCalendar);
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAADate__1_1m25(JNIEnv* __env, jobject, jlong __imp, jboolean bGregorianCalendar)
{
CAADate* __obj = (CAADate*) __imp;
__obj->SetInGregorianCalendar((bool)bGregorianCalendar);
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAADate__1_1m26(JNIEnv* __env, jobject, jlong __imp, jlongArray Year, jlongArray Month, jlongArray Day, jlongArray Hour, jlongArray Minute, jdoubleArray Second)
{
CAADate* __obj = (CAADate*) __imp;
jlong* __TYear = __env->GetLongArrayElements(Year, NULL);
jlong* __TMonth = __env->GetLongArrayElements(Month, NULL);
jlong* __TDay = __env->GetLongArrayElements(Day, NULL);
jlong* __THour = __env->GetLongArrayElements(Hour, NULL);
jlong* __TMinute = __env->GetLongArrayElements(Minute, NULL);
jdouble* __TSecond = __env->GetDoubleArrayElements(Second, NULL);
__obj->Get(*((long*)__TYear), *((long*)__TMonth), *((long*)__TDay), *((long*)__THour), *((long*)__TMinute), *((double*)__TSecond));
__env->ReleaseLongArrayElements(Year, __TYear, 0);
__env->ReleaseLongArrayElements(Month, __TMonth, 0);
__env->ReleaseLongArrayElements(Day, __TDay, 0);
__env->ReleaseLongArrayElements(Hour, __THour, 0);
__env->ReleaseLongArrayElements(Minute, __TMinute, 0);
__env->ReleaseDoubleArrayElements(Second, __TSecond, 0);
}

JNIEXPORT jint JNICALL Java_org_chartacaeli_caa_CAADate__1_1m27(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
CAADate::DOW __retval = __obj->DayOfWeek();
return static_cast<jint>(__retval);
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADate__1_1m28(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
double __retval = __obj->DayOfYear();
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m29(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
long __retval = __obj->DaysInMonth();
return (jlong) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAADate__1_1m30(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
long __retval = __obj->DaysInYear();
return (jlong) __retval;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAADate__1_1m31(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
bool __retval = __obj->Leap();
return (jboolean) __retval;
}

JNIEXPORT jboolean JNICALL Java_org_chartacaeli_caa_CAADate__1_1m32(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
bool __retval = __obj->InGregorianCalendar();
return (jboolean) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAADate__1_1m33(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
double __retval = __obj->FractionalYear();
return (jdouble) __retval;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAADate__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAADate* __obj = (CAADate*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
