// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.FieldPosition;

class LispNewlineFormat extends ReportFormat
{

    static final String line_separator = System.getProperty("line.separator", "\n");
    int count;
    int kind;

    LispNewlineFormat()
    {
    }

    public static LispNewlineFormat getInstance(int i, int j)
    {
        LispNewlineFormat lispnewlineformat = new LispNewlineFormat();
        lispnewlineformat.count = i;
        lispnewlineformat.kind = j;
        return lispnewlineformat;
    }

    public static void printNewline(int i, Writer writer)
        throws IOException
    {
        if ((writer instanceof OutPort) && i != 76)
        {
            ((OutPort)writer).writeBreak(i);
            return;
        }
        if (writer instanceof PrintWriter)
        {
            ((PrintWriter)writer).println();
            return;
        } else
        {
            writer.write(line_separator);
            return;
        }
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int l = getParam(count, 1, aobj, i);
        int k = l;
        int j = i;
        if (count == 0xa0000000)
        {
            j = i + 1;
            k = l;
        }
        do
        {
            k--;
            if (k >= 0)
            {
                printNewline(kind, writer);
            } else
            {
                return j;
            }
        } while (true);
    }

}
