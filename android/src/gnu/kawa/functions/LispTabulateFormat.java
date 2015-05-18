// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispTabulateFormat extends ReportFormat
{

    int colinc;
    int colnum;
    int padChar;
    boolean relative;

    public LispTabulateFormat(int i, int j, int k, boolean flag)
    {
        colnum = i;
        colinc = j;
        relative = flag;
        padChar = k;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int k = getParam(colnum, 1, aobj, i);
        int j = i;
        if (colnum == 0xa0000000)
        {
            j = i + 1;
        }
        int l = getParam(colinc, 1, aobj, j);
        i = j;
        if (colinc == 0xa0000000)
        {
            i = j + 1;
        }
        char c = getParam(padChar, ' ', aobj, i);
        j = i;
        if (padChar == 0xa0000000)
        {
            j = i + 1;
        }
        i = -1;
        if (writer instanceof OutPort)
        {
            i = ((OutPort)writer).getColumnNumber();
        }
        if (i >= 0)
        {
            if (!relative)
            {
                if (i < k)
                {
                    i = k - i;
                } else
                if (l <= 0)
                {
                    i = 0;
                } else
                {
                    i = l - (i - k) % l;
                }
            } else
            {
                i = (k + l) - (i + k) % l;
            }
        } else
        if (relative)
        {
            i = k;
        } else
        {
            i = 2;
        }
        do
        {
            i--;
            if (i >= 0)
            {
                writer.write(c);
            } else
            {
                return j;
            }
        } while (true);
    }
}
