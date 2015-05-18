// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.math.NamedUnit;
import gnu.math.Quantity;
import gnu.math.Unit;
import kawa.lang.GenericError;

public class sleep
{

    public sleep()
    {
    }

    public static void sleep(Quantity quantity)
    {
        Unit unit = quantity.unit();
        if (unit == Unit.Empty || unit.dimensions() == Unit.second.dimensions())
        {
            double d = quantity.doubleValue();
            long l = (long)(1000D * d);
            int i = (int)(1000000000D * d - (double)l * 1000000D);
            try
            {
                Thread.sleep(l, i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Quantity quantity)
            {
                throw new GenericError("sleep was interrupted");
            }
        } else
        {
            throw new GenericError("bad unit for sleep");
        }
    }
}
