// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.math.IntNum;
import gnu.math.RealNum;
import gnu.text.EnglishIntegerFormat;
import gnu.text.RomanIntegerFormat;
import java.text.Format;

public class IntegerFormat extends gnu.text.IntegerFormat
{

    private static IntegerFormat plainDecimalFormat;

    public IntegerFormat()
    {
    }

    public static IntegerFormat getInstance()
    {
        if (plainDecimalFormat == null)
        {
            plainDecimalFormat = new IntegerFormat();
        }
        return plainDecimalFormat;
    }

    public static Format getInstance(int i, int j, int k, int l, int i1, int j1)
    {
        boolean flag = true;
        int k1 = i;
        if (i == 0xc0000000)
        {
            if (k == 0xc0000000 && k == 0xc0000000 && l == 0xc0000000 && i1 == 0xc0000000)
            {
                if ((j1 & 1) == 0)
                {
                    flag = false;
                }
                if ((j1 & 2) != 0)
                {
                    return RomanIntegerFormat.getInstance(flag);
                } else
                {
                    return EnglishIntegerFormat.getInstance(flag);
                }
            }
            k1 = 10;
        }
        i = j;
        if (j == 0xc0000000)
        {
            i = 1;
        }
        j = k;
        if (k == 0xc0000000)
        {
            j = 32;
        }
        k = l;
        if (l == 0xc0000000)
        {
            k = 44;
        }
        l = i1;
        if (i1 == 0xc0000000)
        {
            l = 3;
        }
        if (k1 == 10 && i == 1 && j == 32 && k == 44 && l == 3 && j1 == 0)
        {
            return getInstance();
        } else
        {
            IntegerFormat integerformat = new IntegerFormat();
            integerformat.base = k1;
            integerformat.minWidth = i;
            integerformat.padChar = j;
            integerformat.commaChar = k;
            integerformat.commaInterval = l;
            integerformat.flags = j1;
            return integerformat;
        }
    }

    public String convertToIntegerString(Object obj, int i)
    {
        if (obj instanceof RealNum)
        {
            return ((RealNum)obj).toExactInt(4).toString(i);
        } else
        {
            return super.convertToIntegerString(obj, i);
        }
    }
}
