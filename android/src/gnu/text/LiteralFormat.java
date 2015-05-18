// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.ParsePosition;

// Referenced classes of package gnu.text:
//            ReportFormat

public class LiteralFormat extends ReportFormat
{

    char text[];

    public LiteralFormat(String s)
    {
        text = s.toCharArray();
    }

    public LiteralFormat(StringBuffer stringbuffer)
    {
        int i = stringbuffer.length();
        text = new char[i];
        stringbuffer.getChars(0, i, text, 0);
    }

    public LiteralFormat(char ac[])
    {
        text = ac;
    }

    public String content()
    {
        return new String(text);
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        writer.write(text);
        return i;
    }

    public Object parseObject(String s, ParsePosition parseposition)
    {
        throw new Error("LiteralFormat.parseObject - not implemented");
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("LiteralFormat[\"");
        stringbuffer.append(text);
        stringbuffer.append("\"]");
        return stringbuffer.toString();
    }
}
