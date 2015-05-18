// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.ecmascript;

import gnu.mapping.Procedure2;

// Referenced classes of package gnu.ecmascript:
//            Convert

public class BinaryOp extends Procedure2
{

    int op;

    public BinaryOp(String s, int i)
    {
        setName(s);
        op = i;
    }

    public double apply(double d, double d1)
    {
        switch (op)
        {
        default:
            return (0.0D / 0.0D);

        case 1: // '\001'
            return d + d1;

        case 2: // '\002'
            return d - d1;

        case 3: // '\003'
            return d * d1;

        case 4: // '\004'
            return (double)((int)d << ((int)d1 & 0x1f));
        }
    }

    public Object apply2(Object obj, Object obj1)
    {
        if (op == 5)
        {
            if (Convert.toNumber(obj) < Convert.toNumber(obj1))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        } else
        {
            return new Double(apply(Convert.toNumber(obj), Convert.toNumber(obj1)));
        }
    }
}
