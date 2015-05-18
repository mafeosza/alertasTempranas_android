// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.math.IntNum;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispPluralFormat extends ReportFormat
{

    boolean backup;
    boolean y;

    LispPluralFormat()
    {
    }

    public static LispPluralFormat getInstance(boolean flag, boolean flag1)
    {
        LispPluralFormat lisppluralformat = new LispPluralFormat();
        lisppluralformat.backup = flag;
        lisppluralformat.y = flag1;
        return lisppluralformat;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int j = i;
        if (backup)
        {
            j = i - 1;
        }
        int k = j + 1;
        if (aobj[j] != IntNum.one())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (y)
        {
            if (i != 0)
            {
                aobj = "ies";
            } else
            {
                aobj = "y";
            }
            print(writer, ((String) (aobj)));
        } else
        if (i != 0)
        {
            writer.write(115);
            return k;
        }
        return k;
    }
}
