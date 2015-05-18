// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.mapping.Procedure2;
import gnu.math.Complex;
import gnu.math.IntNum;
import gnu.math.Numeric;

public class expt extends Procedure2
{

    public static final expt expt = new expt("expt");

    public expt(String s)
    {
        super(s);
    }

    public static IntNum expt(IntNum intnum, int i)
    {
        return IntNum.power(intnum, i);
    }

    public static Numeric expt(Object obj, Object obj1)
    {
        if (obj1 instanceof IntNum)
        {
            return ((Numeric)obj).power((IntNum)obj1);
        } else
        {
            return Complex.power((Complex)obj, (Complex)obj1);
        }
    }

    public Object apply2(Object obj, Object obj1)
    {
        return expt(obj, obj1);
    }

}
