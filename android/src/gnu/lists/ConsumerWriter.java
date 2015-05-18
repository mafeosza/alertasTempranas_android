// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Writer;

// Referenced classes of package gnu.lists:
//            Consumer

public class ConsumerWriter extends Writer
{

    protected Consumer out;

    public ConsumerWriter(Consumer consumer)
    {
        out = consumer;
    }

    public void close()
    {
        flush();
    }

    public void finalize()
    {
        close();
    }

    public void flush()
    {
    }

    public void write(char ac[], int i, int j)
    {
        out.write(ac, i, j);
    }
}
