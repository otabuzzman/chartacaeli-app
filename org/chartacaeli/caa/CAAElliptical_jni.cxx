// created by cxxwrap -- DO NOT EDIT
#include "jni.h"
#include "AAElliptical.h"
#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m1(JNIEnv* __env, jclass, jlong __imp, jdouble Distance)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
const double __retval = __obj->DistanceToLightTime((double)Distance);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m2(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jint object, jboolean bHighPrecision)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
CAAEllipticalPlanetaryDetails __retval_temp(__obj->Calculate((double)JD, (CAAElliptical::Object) object, (bool)bHighPrecision));
CAAEllipticalPlanetaryDetails* __retval = new CAAEllipticalPlanetaryDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m3(JNIEnv* __env, jclass, jlong __imp, jdouble q, jdouble e)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
const double __retval = __obj->SemiMajorAxisFromPerihelionDistance((double)q, (double)e);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m4(JNIEnv* __env, jclass, jlong __imp, jdouble a)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
double __retval = __obj->MeanMotionFromSemiMajorAxis((double)a);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m5(JNIEnv* __env, jclass, jlong __imp, jdouble JD, jlong elements, jboolean bHighPrecision)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
CAAEllipticalObjectDetails __retval_temp(__obj->Calculate((double)JD, *((CAAEllipticalObjectElements*) elements), (bool)bHighPrecision));
CAAEllipticalObjectDetails* __retval = new CAAEllipticalObjectDetails(__retval_temp);
return (jlong) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m6(JNIEnv* __env, jclass, jlong __imp, jdouble r, jdouble a)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
double __retval = __obj->InstantaneousVelocity((double)r, (double)a);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m7(JNIEnv* __env, jclass, jlong __imp, jdouble e, jdouble a)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
double __retval = __obj->VelocityAtPerihelion((double)e, (double)a);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m8(JNIEnv* __env, jclass, jlong __imp, jdouble e, jdouble a)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
double __retval = __obj->VelocityAtAphelion((double)e, (double)a);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m9(JNIEnv* __env, jclass, jlong __imp, jdouble e, jdouble a)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
double __retval = __obj->LengthOfEllipse((double)e, (double)a);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m10(JNIEnv* __env, jclass, jlong __imp, jdouble g, jdouble delta, jdouble k, jdouble r)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
double __retval = __obj->CometMagnitude((double)g, (double)delta, (double)k, (double)r);
return (jdouble) __retval;
}

JNIEXPORT jdouble JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1m11(JNIEnv* __env, jclass, jlong __imp, jdouble H, jdouble delta, jdouble G, jdouble r, jdouble PhaseAngle)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
double __retval = __obj->MinorPlanetMagnitude((double)H, (double)delta, (double)G, (double)r, (double)PhaseAngle);
return (jdouble) __retval;
}

JNIEXPORT jlong JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1cdefault(JNIEnv* __env, jobject)
{
CAAElliptical* __obj = new CAAElliptical();
return (jlong) __obj;
}

JNIEXPORT void JNICALL Java_org_chartacaeli_caa_CAAElliptical__1_1d(JNIEnv* __env, jobject, jlong __imp)
{
CAAElliptical* __obj = (CAAElliptical*) __imp;
delete __obj;
}

#ifdef __cplusplus
}
#endif
