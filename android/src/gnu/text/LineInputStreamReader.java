// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

// Referenced classes of package gnu.text:
//            LineBufferedReader

public class LineInputStreamReader extends LineBufferedReader
{

    byte barr[];
    ByteBuffer bbuf;
    char carr[];
    CharBuffer cbuf;
    Charset cset;
    CharsetDecoder decoder;
    InputStream istrm;

    public LineInputStreamReader(InputStream inputstream)
    {
        super((Reader)null);
        barr = new byte[8192];
        cbuf = null;
        bbuf = ByteBuffer.wrap(barr);
        bbuf.position(barr.length);
        istrm = inputstream;
    }

    private int fillBytes(int i)
        throws IOException
    {
        int j = 0;
        int k = istrm.read(barr, i, barr.length - i);
        bbuf.position(0);
        ByteBuffer bytebuffer = bbuf;
        if (k >= 0)
        {
            j = k;
        }
        bytebuffer.limit(j + i);
        return k;
    }

    public void close()
        throws IOException
    {
        if (in != null)
        {
            in.close();
        }
        istrm.close();
    }

    public int fill(int i)
        throws IOException
    {
        int j;
        if (cset == null)
        {
            setCharset("UTF-8");
        }
        if (buffer != carr)
        {
            cbuf = CharBuffer.wrap(buffer);
            carr = buffer;
        }
        cbuf.limit(pos + i);
        cbuf.position(pos);
        j = 0;
_L2:
        CoderResult coderresult = decoder.decode(bbuf, cbuf, false);
        int k = cbuf.position() - pos;
        i = j;
        if (k <= 0)
        {
            if (!coderresult.isUnderflow())
            {
                i = j;
            } else
            {
                i = bbuf.remaining();
                if (i > 0)
                {
                    bbuf.compact();
                }
                if (fillBytes(i) >= 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                i = 1;
            }
        }
        j = k;
        if (k == 0)
        {
            j = k;
            if (i != 0)
            {
                j = -1;
            }
        }
        return j;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int getByte()
        throws IOException
    {
        if (!bbuf.hasRemaining() && fillBytes(0) <= 0)
        {
            return -1;
        } else
        {
            return bbuf.get() & 0xff;
        }
    }

    public void markStart()
        throws IOException
    {
    }

    public boolean ready()
        throws IOException
    {
        return pos < limit || bbuf.hasRemaining() || istrm.available() > 0;
    }

    public void resetStart(int i)
        throws IOException
    {
        bbuf.position(i);
    }

    public void setCharset(String s)
    {
        Charset charset = Charset.forName(s);
        if (cset == null)
        {
            setCharset(charset);
        } else
        if (!charset.equals(cset))
        {
            throw new RuntimeException((new StringBuilder()).append("encoding ").append(s).append(" does not match previous ").append(cset).toString());
        }
    }

    public void setCharset(Charset charset)
    {
        cset = charset;
        decoder = charset.newDecoder();
    }
}
