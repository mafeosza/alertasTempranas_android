// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispEscapeFormat extends ReportFormat
{

    public static final int ESCAPE_ALL = 242;
    public static final int ESCAPE_NORMAL = 241;
    public static final LispEscapeFormat alwaysTerminate = new LispEscapeFormat(0, 0xc0000000);
    boolean escapeAll;
    int param1;
    int param2;
    int param3;

    public LispEscapeFormat(int i, int j)
    {
        param1 = i;
        param2 = j;
        param3 = 0xc0000000;
    }

    public LispEscapeFormat(int i, int j, int k)
    {
        param1 = i;
        param2 = j;
        param3 = k;
    }

    static Numeric getParam(int i, Object aobj[], int j)
    {
        if (i == 0xb0000000)
        {
            return IntNum.make(aobj.length - j);
        }
        if (i == 0xa0000000)
        {
            aobj = ((Object []) (aobj[j]));
            if (aobj instanceof Numeric)
            {
                return (Numeric)aobj;
            }
            if (aobj instanceof Number)
            {
                if ((aobj instanceof Float) || (aobj instanceof Double))
                {
                    return new DFloNum(((Number)aobj).doubleValue());
                } else
                {
                    return IntNum.make(((Number)aobj).longValue());
                }
            }
            if (aobj instanceof Char)
            {
                return new IntNum(((Char)aobj).intValue());
            }
            if (aobj instanceof Character)
            {
                return new IntNum(((Character)aobj).charValue());
            } else
            {
                return new DFloNum((0.0D / 0.0D));
            }
        } else
        {
            return IntNum.make(i);
        }
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        boolean flag2 = true;
        boolean flag1 = true;
        boolean flag = false;
        int j;
        if (param1 == 0xc0000000)
        {
            if (i != aobj.length)
            {
                flag1 = false;
            }
        } else
        if (param2 == 0xc0000000 && param1 == 0)
        {
            flag1 = true;
        } else
        {
            writer = getParam(param1, aobj, i);
            j = i;
            if (param1 == 0xa0000000)
            {
                j = i + 1;
            }
            if (param2 == 0xc0000000)
            {
                flag1 = writer.isZero();
                i = j;
            } else
            {
                fieldposition = getParam(param2, aobj, j);
                i = j;
                if (param2 == 0xa0000000)
                {
                    i = j + 1;
                }
                if (param3 == 0xc0000000)
                {
                    flag1 = writer.equals(fieldposition);
                } else
                {
                    aobj = getParam(param3, aobj, i);
                    j = i;
                    if (param3 == 0xa0000000)
                    {
                        j = i + 1;
                    }
                    if (fieldposition.geq(writer) && ((Numeric) (aobj)).geq(fieldposition))
                    {
                        flag1 = flag2;
                    } else
                    {
                        flag1 = false;
                    }
                    i = j;
                }
            }
        }
        if (!flag1)
        {
            j = ((flag) ? 1 : 0);
        } else
        if (escapeAll)
        {
            j = 242;
        } else
        {
            j = 241;
        }
        return result(j, i);
    }

}
