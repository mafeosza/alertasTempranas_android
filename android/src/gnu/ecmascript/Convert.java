// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.ecmascript;


public class Convert
{

    public Convert()
    {
    }

    public static double toInteger(double d)
    {
        if (Double.isNaN(d))
        {
            return 0.0D;
        }
        if (d < 0.0D)
        {
            return Math.ceil(d);
        } else
        {
            return Math.floor(d);
        }
    }

    public static double toInteger(Object obj)
    {
        return toInteger(toNumber(obj));
    }

    public static double toNumber(Object obj)
    {
        double d = (0.0D / 0.0D);
        if (obj instanceof Number)
        {
            d = ((Number)obj).doubleValue();
        } else
        {
            if (obj instanceof Boolean)
            {
                return !((Boolean)obj).booleanValue() ? 0.0D : 1.0D;
            }
            if (obj instanceof String)
            {
                double d1;
                try
                {
                    d1 = Double.valueOf((String)obj).doubleValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return (0.0D / 0.0D);
                }
                return d1;
            }
        }
        return d;
    }

    public int toInt32(double d)
    {
        if (Double.isNaN(d) || Double.isInfinite(d))
        {
            return 0;
        } else
        {
            return (int)d;
        }
    }

    public int toInt32(Object obj)
    {
        return toInt32(toNumber(obj));
    }
}
