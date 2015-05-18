// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.text.FieldPosition;

// Referenced classes of package gnu.text:
//            ReportFormat

public class IntegerFormat extends ReportFormat
{

    public static final int MIN_DIGITS = 64;
    public static final int PAD_RIGHT = 16;
    public static final int SHOW_BASE = 8;
    public static final int SHOW_GROUPS = 1;
    public static final int SHOW_PLUS = 2;
    public static final int SHOW_SPACE = 4;
    public static final int UPPERCASE = 32;
    public int base;
    public int commaChar;
    public int commaInterval;
    public int flags;
    public int minWidth;
    public int padChar;

    public IntegerFormat()
    {
        base = 10;
        minWidth = 1;
        padChar = 32;
        commaChar = 44;
        commaInterval = 3;
        flags = 0;
    }

    public String convertToIntegerString(Object obj, int i)
    {
        if (!(obj instanceof Number))
        {
            return null;
        }
        if (obj instanceof BigInteger)
        {
            return ((BigInteger)obj).toString(i);
        } else
        {
            return Long.toString(((Number)obj).longValue(), i);
        }
    }

    public int format(Object obj, int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int k1;
        int i2;
        boolean flag;
        boolean flag1;
        boolean flag2;
        char c1;
        char c2;
        int l2;
        int j;
        int i1;
        if (obj instanceof Object[])
        {
            fieldposition = ((FieldPosition) ((Object[])(Object[])obj));
        } else
        {
            fieldposition = null;
        }
        k1 = getParam(minWidth, 1, fieldposition, i);
        i1 = i;
        if (minWidth == 0xa0000000)
        {
            i1 = i + 1;
        }
        c1 = getParam(padChar, ' ', fieldposition, i1);
        j = i1;
        if (padChar == 0xa0000000)
        {
            j = i1 + 1;
        }
        c2 = getParam(commaChar, ',', fieldposition, j);
        i = j;
        if (commaChar == 0xa0000000)
        {
            i = j + 1;
        }
        l2 = getParam(commaInterval, 3, fieldposition, i);
        i2 = i;
        if (commaInterval == 0xa0000000)
        {
            i2 = i + 1;
        }
        if ((flags & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((flags & 0x10) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (c1 == '0')
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (fieldposition != null)
        {
            if (i2 >= fieldposition.length)
            {
                writer.write("#<missing format argument>");
                return i2;
            }
            obj = fieldposition[i2];
        }
        fieldposition = convertToIntegerString(obj, base);
        if (fieldposition == null) goto _L2; else goto _L1
_L1:
        int j1;
        int j2;
        boolean flag3;
        char c3;
label0:
        {
            c3 = fieldposition.charAt(0);
            int k;
            int k2;
            if (c3 == '-')
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            k2 = fieldposition.length();
            if (flag3)
            {
                k = k2 - 1;
            } else
            {
                k = k2;
            }
            if (flag)
            {
                i = (k - 1) / l2;
            } else
            {
                i = 0;
            }
            i = k + i;
            if (!flag3)
            {
                j1 = i;
                if ((flags & 6) == 0)
                {
                    break label0;
                }
            }
            j1 = i + 1;
        }
        i = j1;
        if ((flags & 8) == 0) goto _L4; else goto _L3
_L3:
        if (base != 16) goto _L6; else goto _L5
_L5:
        i = j1 + 2;
_L4:
        j1 = k2;
        j2 = i;
        if ((flags & 0x40) != 0)
        {
            j1 = k2;
            j2 = k;
            if (k2 == 1)
            {
                j1 = k2;
                j2 = k;
                if (c3 == '0')
                {
                    j1 = k2;
                    j2 = k;
                    if (k1 == 0)
                    {
                        j1 = 0;
                        j2 = k;
                    }
                }
            }
        }
        i = k1;
        if (!flag1)
        {
            i = k1;
            if (!flag2)
            {
                k = k1;
                do
                {
                    i = k;
                    if (k <= j2)
                    {
                        break;
                    }
                    writer.write(c1);
                    k--;
                } while (true);
            }
        }
        break; /* Loop/switch isn't completed */
_L6:
        i = j1;
        if (base == 8)
        {
            i = j1;
            if (c3 != '0')
            {
                i = j1 + 1;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
        boolean flag4 = false;
        int l;
        int l1;
        if (flag3)
        {
            writer.write(45);
            l1 = 0 + 1;
            l = j1 - 1;
        } else
        if ((flags & 2) != 0)
        {
            writer.write(43);
            l1 = ((flag4) ? 1 : 0);
            l = j1;
        } else
        {
            l1 = ((flag4) ? 1 : 0);
            l = j1;
            if ((flags & 4) != 0)
            {
                writer.write(32);
                l1 = ((flag4) ? 1 : 0);
                l = j1;
            }
        }
        if (base > 10 && (flags & 0x20) != 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if ((flags & 8) != 0)
        {
            if (base == 16)
            {
                writer.write(48);
                if (flag3)
                {
                    j1 = 88;
                } else
                {
                    j1 = 120;
                }
                writer.write(j1);
            } else
            if (base == 8 && c3 != '0')
            {
                writer.write(48);
            }
        }
        j1 = i;
        char c;
        if (flag2)
        {
            do
            {
                j1 = i;
                if (i <= j2)
                {
                    break;
                }
                writer.write(c1);
                i--;
            } while (true);
        }
        i = l1;
          goto _L8
_L11:
        while (l != 0) 
        {
            c = fieldposition.charAt(i);
            l1 = c;
            if (flag3)
            {
                l1 = Character.toUpperCase(c);
            }
            writer.write(l1);
            l--;
            if (flag && l > 0 && l % l2 == 0)
            {
                writer.write(c2);
            }
            i++;
        }
        if (flag1)
        {
            for (; j1 > j2; j1--)
            {
                writer.write(c1);
            }

        }
          goto _L9
_L2:
        print(writer, obj.toString());
_L9:
        return i2 + 1;
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        return format(((Object) (aobj)), i, writer, fieldposition);
    }
}
