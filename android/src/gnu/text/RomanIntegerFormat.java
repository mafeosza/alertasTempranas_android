// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class RomanIntegerFormat extends NumberFormat
{

    static final String codes = "IVXLCDM";
    private static RomanIntegerFormat newRoman;
    private static RomanIntegerFormat oldRoman;
    public boolean oldStyle;

    public RomanIntegerFormat()
    {
    }

    public RomanIntegerFormat(boolean flag)
    {
        oldStyle = flag;
    }

    public static String format(int i)
    {
        return format(i, false);
    }

    public static String format(int i, boolean flag)
    {
        StringBuffer stringbuffer;
        int j;
        int k;
        if (i <= 0 || i >= 4999)
        {
            return Integer.toString(i);
        }
        stringbuffer = new StringBuffer(20);
        j = 3;
        k = 1000;
_L2:
        int l;
        int i1;
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        l = i / k;
        i1 = i - l * k;
        if (l != 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        k /= 10;
        j--;
        i = i1;
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            if (flag || l != 4 && l != 9)
            {
                break label0;
            }
            stringbuffer.append("IVXLCDM".charAt(j * 2));
            stringbuffer.append("IVXLCDM".charAt(j * 2 + (l + 1) / 5));
        }
          goto _L3
        i = l;
        if (l >= 5)
        {
            stringbuffer.append("IVXLCDM".charAt(j * 2 + 1));
            i = l - 5;
        }
_L5:
        i--;
        if (i < 0) goto _L3; else goto _L4
_L4:
        stringbuffer.append("IVXLCDM".charAt(j * 2));
          goto _L5
          goto _L3
        return stringbuffer.toString();
    }

    public static RomanIntegerFormat getInstance(boolean flag)
    {
        if (flag)
        {
            if (oldRoman == null)
            {
                oldRoman = new RomanIntegerFormat(true);
            }
            return oldRoman;
        }
        if (newRoman == null)
        {
            newRoman = new RomanIntegerFormat(false);
        }
        return newRoman;
    }

    public StringBuffer format(double d, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        long l = (long)d;
        if ((double)l == d)
        {
            return format(l, stringbuffer, fieldposition);
        } else
        {
            stringbuffer.append(Double.toString(d));
            return stringbuffer;
        }
    }

    public StringBuffer format(long l, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        if (l <= 0L) goto _L2; else goto _L1
_L1:
        String s;
        int i;
        int j;
        if (oldStyle)
        {
            i = 4999;
        } else
        {
            i = 3999;
        }
        if (l >= (long)i) goto _L2; else goto _L3
_L3:
        s = format((int)l, oldStyle);
_L5:
        if (fieldposition == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        l = 1L;
        j = s.length();
        i = j;
        do
        {
            i--;
            if (i <= 0)
            {
                break;
            }
            l = 10L * l + 9L;
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        s = Long.toString(l);
        if (true) goto _L5; else goto _L4
_L4:
        StringBuffer stringbuffer1 = new StringBuffer(j);
        (new DecimalFormat("0")).format(l, stringbuffer1, fieldposition);
        stringbuffer.append(s);
        return stringbuffer;
    }

    public Number parse(String s, ParsePosition parseposition)
    {
        throw new Error("RomanIntegerFormat.parseObject - not implemented");
    }
}
