// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispIndentFormat extends ReportFormat
{

    int columns;
    boolean current;

    LispIndentFormat()
    {
    }

    public static LispIndentFormat getInstance(int i, boolean flag)
    {
        LispIndentFormat lispindentformat = new LispIndentFormat();
        lispindentformat.columns = i;
        lispindentformat.current = flag;
        return lispindentformat;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int k = getParam(columns, 0, aobj, i);
        int j = i;
        if (columns == 0xa0000000)
        {
            j = i + 1;
        }
        if (writer instanceof OutPort)
        {
            ((OutPort)writer).setIndentation(k, current);
        }
        return j;
    }
}
