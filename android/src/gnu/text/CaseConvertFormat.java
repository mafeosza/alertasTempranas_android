// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

// Referenced classes of package gnu.text:
//            ReportFormat

public class CaseConvertFormat extends ReportFormat
{

    Format baseFormat;
    char code;

    public CaseConvertFormat(Format format1, char c)
    {
        baseFormat = format1;
        code = c;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        StringBuffer stringbuffer = new StringBuffer(100);
        int j = format(baseFormat, aobj, i, stringbuffer, fieldposition);
        int k = stringbuffer.length();
        char c = ' ';
        i = 0;
        while (i < k) 
        {
            char c1 = stringbuffer.charAt(i);
            if (code == 'U')
            {
                c = Character.toUpperCase(c1);
            } else
            if (code == 'T' && i == 0 || code == 'C' && !Character.isLetterOrDigit(c))
            {
                c = Character.toTitleCase(c1);
            } else
            {
                c = Character.toLowerCase(c1);
            }
            c1 = c;
            writer.write(c);
            i++;
            c = c1;
        }
        return j;
    }

    public Format getBaseFormat()
    {
        return baseFormat;
    }

    public void setBaseFormat(Format format1)
    {
        baseFormat = format1;
    }
}
