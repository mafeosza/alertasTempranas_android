// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;


public class OrientationSensorUtil
{

    private OrientationSensorUtil()
    {
    }

    static float mod(float f, float f1)
    {
        float f2 = f % f1;
        if (f2 == 0.0F || Math.signum(f) == Math.signum(f1))
        {
            return f2;
        } else
        {
            return f2 + f1;
        }
    }

    public static float normalizeAzimuth(float f)
    {
        return mod(f, 360F);
    }

    public static float normalizePitch(float f)
    {
        return mod(f + 180F, 360F) - 180F;
    }

    public static float normalizeRoll(float f)
    {
        f = Math.max(Math.min(f, 180F), -180F);
        if (f < -90F || f > 90F)
        {
            float f1 = 180F - f;
            f = f1;
            if (f1 >= 270F)
            {
                return f1 - 360F;
            }
        }
        return f;
    }
}
