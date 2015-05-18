// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

// Referenced classes of package kawa:
//            Telnet

public class TelnetInputStream extends FilterInputStream
{

    static final int SB_IAC = 400;
    protected byte buf[];
    Telnet connection;
    int count;
    int pos;
    int state;
    int subCommandLength;

    public TelnetInputStream(InputStream inputstream, Telnet telnet)
        throws IOException
    {
        super(inputstream);
        state = 0;
        subCommandLength = 0;
        buf = new byte[512];
        connection = telnet;
    }

    public int read()
        throws IOException
    {
_L7:
        if (pos < count) goto _L2; else goto _L1
_L1:
        int i;
        int l = in.available();
        if (l <= 0)
        {
            i = 1;
        } else
        {
            i = l;
            if (l > buf.length - subCommandLength)
            {
                i = buf.length - subCommandLength;
            }
        }
        i = in.read(buf, subCommandLength, i);
        pos = subCommandLength;
        count = i;
        if (i > 0) goto _L2; else goto _L3
_L3:
        i = -1;
_L5:
        return i;
_L2:
        int i1;
        byte abyte0[] = buf;
        i = pos;
        pos = i + 1;
        i1 = abyte0[i] & 0xff;
        if (state != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = i1;
        if (i1 == 255)
        {
            state = 255;
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (state == 255)
        {
            if (i1 == 255)
            {
                state = 0;
                return 255;
            }
            if (i1 == 251 || i1 == 252 || i1 == 253 || i1 == 254 || i1 == 250)
            {
                state = i1;
            } else
            if (i1 == 244)
            {
                System.err.println("Interrupt Process");
                state = 0;
            } else
            {
                if (i1 == 236)
                {
                    return -1;
                }
                state = 0;
            }
        } else
        if (state == 251 || state == 252 || state == 253 || state == 254)
        {
            connection.handle(state, i1);
            state = 0;
        } else
        if (state == 250)
        {
            if (i1 == 255)
            {
                state = 400;
            } else
            {
                byte abyte1[] = buf;
                int j = subCommandLength;
                subCommandLength = j + 1;
                abyte1[j] = (byte)i1;
            }
        } else
        if (state == 400)
        {
            if (i1 == 255)
            {
                byte abyte2[] = buf;
                int k = subCommandLength;
                subCommandLength = k + 1;
                abyte2[k] = (byte)i1;
                state = 250;
            } else
            if (i1 == 240)
            {
                connection.subCommand(buf, 0, subCommandLength);
                state = 0;
                subCommandLength = 0;
            } else
            {
                state = 0;
                subCommandLength = 0;
            }
        } else
        {
            System.err.println((new StringBuilder()).append("Bad state ").append(state).toString());
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j > 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int l;
        k = 0;
        if (state == 0)
        {
            l = i;
            if (pos < count)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        l = read();
        k = l;
        if (l < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        abyte0[i] = (byte)l;
        k = 0 + 1;
        l = i + 1;
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        i = k;
        if (state != 0) goto _L6; else goto _L5
_L5:
        i = k;
        if (pos >= count) goto _L6; else goto _L7
_L7:
        i = k;
        if (k >= j) goto _L6; else goto _L8
_L8:
        byte byte0 = buf[pos];
        if (byte0 != -1) goto _L10; else goto _L9
_L9:
        i = k;
_L6:
        return i;
_L10:
        abyte0[l] = byte0;
        k++;
        pos = pos + 1;
        l++;
        if (true) goto _L5; else goto _L11
_L11:
    }
}
