// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, ClassTypeWriter

public class MiscAttr extends Attribute
{

    byte data[];
    int dataLength;
    int offset;

    public MiscAttr(String s, byte abyte0[])
    {
        this(s, abyte0, 0, abyte0.length);
    }

    public MiscAttr(String s, byte abyte0[], int i, int j)
    {
        super(s);
        data = abyte0;
        offset = i;
        dataLength = j;
    }

    public int getLength()
    {
        return dataLength;
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        super.print(classtypewriter);
        int k = getLength();
        int i = 0;
        do
        {
            if (i >= k)
            {
                break;
            }
            int j = data[i];
            if (i % 20 == 0)
            {
                classtypewriter.print(' ');
            }
            classtypewriter.print(' ');
            classtypewriter.print(Character.forDigit(j >> 4 & 0xf, 16));
            classtypewriter.print(Character.forDigit(j & 0xf, 16));
            j = i + 1;
            if (j % 20 != 0)
            {
                i = j;
                if (j != k)
                {
                    continue;
                }
            }
            classtypewriter.println();
            i = j;
        } while (true);
    }

    protected void put1(int i)
    {
        if (data != null) goto _L2; else goto _L1
_L1:
        data = new byte[20];
_L4:
        byte abyte0[] = data;
        int j = dataLength;
        dataLength = j + 1;
        abyte0[j] = (byte)i;
        return;
_L2:
        if (dataLength >= data.length)
        {
            byte abyte1[] = new byte[data.length * 2];
            System.arraycopy(data, 0, abyte1, 0, dataLength);
            data = abyte1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void put2(int i)
    {
        put1((byte)(i >> 8));
        put1((byte)i);
    }

    protected void put2(int i, int j)
    {
        data[i] = (byte)(j >> 8);
        data[i + 1] = (byte)j;
    }

    protected int u1()
    {
        int i = offset;
        offset = i + 1;
        return u1(i);
    }

    protected int u1(int i)
    {
        return data[i] & 0xff;
    }

    protected int u2()
    {
        int i = u2(offset);
        offset = offset + 2;
        return i;
    }

    protected int u2(int i)
    {
        return ((data[i] & 0xff) << 8) + (data[i + 1] & 0xff);
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.write(data, offset, dataLength);
    }
}
