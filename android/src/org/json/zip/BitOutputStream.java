// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.json.zip:
//            BitWriter, BitInputStream

public class BitOutputStream
    implements BitWriter
{

    private long nrBits;
    private OutputStream out;
    private int unwritten;
    private int vacant;

    public BitOutputStream(OutputStream outputstream)
    {
        nrBits = 0L;
        vacant = 8;
        out = outputstream;
    }

    public long nrBits()
    {
        return nrBits;
    }

    public void one()
        throws IOException
    {
        write(1, 1);
    }

    public void pad(int i)
        throws IOException
    {
        int j = i - (int)(nrBits % (long)i);
        int k = j & 7;
        i = j;
        if (k > 0)
        {
            write(0, k);
            i = j - k;
        }
        for (; i > 0; i -= 8)
        {
            write(0, 8);
        }

        out.flush();
    }

    public void write(int i, int j)
        throws IOException
    {
        if (i != 0 || j != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k;
label0:
        {
            if (j > 0)
            {
                k = j;
                if (j <= 32)
                {
                    break label0;
                }
            }
            throw new IOException("Bad write width.");
        }
        while (k > 0) 
        {
            int l = k;
            j = l;
            if (l > vacant)
            {
                j = vacant;
            }
            unwritten = unwritten | (i >>> k - j & BitInputStream.mask[j]) << vacant - j;
            l = k - j;
            nrBits = nrBits + (long)j;
            vacant = vacant - j;
            k = l;
            if (vacant == 0)
            {
                out.write(unwritten);
                unwritten = 0;
                vacant = 8;
                k = l;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void zero()
        throws IOException
    {
        write(0, 1);
    }
}
