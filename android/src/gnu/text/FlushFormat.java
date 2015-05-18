// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

// Referenced classes of package gnu.text:
//            ReportFormat

public class FlushFormat extends ReportFormat
{

    private static FlushFormat flush;

    public FlushFormat()
    {
    }

    public static FlushFormat getInstance()
    {
        if (flush == null)
        {
            flush = new FlushFormat();
        }
        return flush;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        writer.flush();
        return i;
    }
}
