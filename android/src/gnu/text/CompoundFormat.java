// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

// Referenced classes of package gnu.text:
//            ReportFormat

public class CompoundFormat extends ReportFormat
{

    protected Format formats[];
    protected int length;

    public CompoundFormat(Format aformat[])
    {
        formats = aformat;
        length = aformat.length;
    }

    public CompoundFormat(Format aformat[], int i)
    {
        formats = aformat;
        length = i;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int j = 0;
        while (j < length) 
        {
            Format format1 = formats[j];
            if (format1 instanceof ReportFormat)
            {
                int k = ((ReportFormat)format1).format(aobj, i, writer, fieldposition);
                i = k;
                if (k < 0)
                {
                    return k;
                }
            } else
            if (i >= aobj.length)
            {
                writer.write("#<missing format argument>");
            } else
            {
                StringBuffer stringbuffer = new StringBuffer();
                format1.format(aobj[i], stringbuffer, fieldposition);
                writer.write(stringbuffer.toString());
                i++;
            }
            j++;
        }
        return i;
    }

    public final int format(Object aobj[], int i, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        for (int j = 0; j < length; j++)
        {
            Format format1 = formats[j];
            if (format1 instanceof ReportFormat)
            {
                int k = ((ReportFormat)format1).format(aobj, i, stringbuffer, fieldposition);
                i = k;
                if (k < 0)
                {
                    return k;
                }
            } else
            {
                format1.format(aobj[i], stringbuffer, fieldposition);
                i++;
            }
        }

        return i;
    }

    public Object parseObject(String s, ParsePosition parseposition)
    {
        throw new Error("CompoundFormat.parseObject - not implemented");
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("CompoundFormat[");
        for (int i = 0; i < length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(", ");
            }
            stringbuffer.append(formats[i]);
        }

        stringbuffer.append("]");
        return stringbuffer.toString();
    }
}
