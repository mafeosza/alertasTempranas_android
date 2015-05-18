// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.Reader;

public class NullReader extends Reader
{

    public static final NullReader nullReader = new NullReader();

    public NullReader()
    {
    }

    public void close()
    {
    }

    public int read(char ac[], int i, int j)
    {
        return -1;
    }

    public boolean ready()
    {
        return true;
    }

}
