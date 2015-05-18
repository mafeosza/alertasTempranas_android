// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.json.zip:
//            BitReader

public class BitInputStream
    implements BitReader
{

    static final int mask[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255
    };
    private int available;
    private InputStream in;
    private long nrBits;
    private int unread;

    public BitInputStream(InputStream inputstream)
    {
        available = 0;
        unread = 0;
        nrBits = 0L;
        in = inputstream;
    }

    public BitInputStream(InputStream inputstream, int i)
    {
        available = 0;
        unread = 0;
        nrBits = 0L;
        in = inputstream;
        unread = i;
        available = 8;
    }

    public boolean bit()
        throws IOException
    {
        return read(1) != 0;
    }

    public long nrBits()
    {
        return nrBits;
    }

    public boolean pad(int i)
        throws IOException
    {
        int k = (int)(nrBits % (long)i);
        boolean flag = true;
        for (int j = 0; j < i - k; j++)
        {
            if (bit())
            {
                flag = false;
            }
        }

        return flag;
    }

    public int read(int i)
        throws IOException
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        if (i < 0 || i > 32)
        {
            throw new IOException("Bad read width.");
        }
        int j = 0;
        do
        {
            k = j;
            if (i <= 0)
            {
                continue;
            }
            if (available == 0)
            {
                unread = in.read();
                if (unread < 0)
                {
                    throw new IOException("Attempt to read past end.");
                }
                available = 8;
            }
            int l = i;
            k = l;
            if (l > available)
            {
                k = available;
            }
            j |= (unread >>> available - k & mask[k]) << i - k;
            nrBits = nrBits + (long)k;
            available = available - k;
            i -= k;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
