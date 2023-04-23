// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAIlluminatedFraction.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m0(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble R, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->PhaseAngle((double)r, (double)R, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble R, jdouble R0, jdouble B, jdouble L, jdouble L0, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->PhaseAngle((double)R, (double)R0, (double)B, (double)L, (double)L0, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble x, jdouble y, jdouble z, jdouble B, jdouble L, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->PhaseAngleRectangular((double)x, (double)y, (double)z, (double)B, (double)L, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble PhaseAngle)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->IlluminatedFraction((double)PhaseAngle);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble R, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
const double __retval = __obj->IlluminatedFraction((double)r, (double)R, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta, jdouble i)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->MercuryMagnitudeMuller((double)r, (double)Delta, (double)i);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta, jdouble i)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->VenusMagnitudeMuller((double)r, (double)Delta, (double)i);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta, jdouble i)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->MarsMagnitudeMuller((double)r, (double)Delta, (double)i);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->JupiterMagnitudeMuller((double)r, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta, jdouble DeltaU, jdouble B)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->SaturnMagnitudeMuller((double)r, (double)Delta, (double)DeltaU, (double)B);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m10(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->UranusMagnitudeMuller((double)r, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m11(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->NeptuneMagnitudeMuller((double)r, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m12(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta, jdouble i)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->MercuryMagnitudeAA((double)r, (double)Delta, (double)i);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m13(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta, jdouble i)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->VenusMagnitudeAA((double)r, (double)Delta, (double)i);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m14(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta, jdouble i)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->MarsMagnitudeAA((double)r, (double)Delta, (double)i);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m15(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta, jdouble i)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->JupiterMagnitudeAA((double)r, (double)Delta, (double)i);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m16(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta, jdouble DeltaU, jdouble B)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->SaturnMagnitudeAA((double)r, (double)Delta, (double)DeltaU, (double)B);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m17(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->UranusMagnitudeAA((double)r, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m18(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->NeptuneMagnitudeAA((double)r, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1m19(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble Delta)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
double __retval = __obj->PlutoMagnitudeAA((double)r, (double)Delta);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1cdefault(JNIEnv* __env, jobject)
{
CAAIlluminatedFraction* __obj = new CAAIlluminatedFraction();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAIlluminatedFraction__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAIlluminatedFraction* __obj = (CAAIlluminatedFraction*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
