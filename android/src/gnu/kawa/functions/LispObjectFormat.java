// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.text.PadFormat;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispObjectFormat extends ReportFormat
{

    ReportFormat base;
    int colInc;
    int minPad;
    int minWidth;
    int padChar;
    int where;

    public LispObjectFormat(ReportFormat reportformat, int i, int j, int k, int l, int i1)
    {
        base = reportformat;
        minWidth = i;
        colInc = j;
        minPad = k;
        padChar = l;
        where = i1;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int k = getParam(minWidth, 0, aobj, i);
        int j = i;
        if (minWidth == 0xa0000000)
        {
            j = i + 1;
        }
        int l = getParam(colInc, 1, aobj, j);
        i = j;
        if (colInc == 0xa0000000)
        {
            i = j + 1;
        }
        int i1 = getParam(minPad, 0, aobj, i);
        j = i;
        if (minPad == 0xa0000000)
        {
            j = i + 1;
        }
        char c = getParam(padChar, ' ', aobj, j);
        i = j;
        if (padChar == 0xa0000000)
        {
            i = j + 1;
        }
        return PadFormat.format(base, aobj, i, writer, c, k, l, i1, where, fieldposition);
    }
}
