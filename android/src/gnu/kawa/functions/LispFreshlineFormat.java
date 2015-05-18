// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispFreshlineFormat extends ReportFormat
{

    int count;

    public LispFreshlineFormat(int i)
    {
        count = i;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int k = getParam(count, 1, aobj, i);
        int j = i;
        if (count == 0xa0000000)
        {
            j = i + 1;
        }
        if (k > 0)
        {
            i = k;
            if (writer instanceof OutPort)
            {
                ((OutPort)writer).freshLine();
                i = k - 1;
            }
            do
            {
                i--;
                if (i < 0)
                {
                    break;
                }
                writer.write(10);
            } while (true);
        }
        return j;
    }
}
