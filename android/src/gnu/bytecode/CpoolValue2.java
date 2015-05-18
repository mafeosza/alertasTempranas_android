// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            CpoolEntry, ConstantPool, ClassTypeWriter

public class CpoolValue2 extends CpoolEntry
{

    int tag;
    long value;

    CpoolValue2(int i)
    {
        tag = i;
    }

    CpoolValue2(ConstantPool constantpool, int i, int j, long l)
    {
        super(constantpool, j);
        tag = i;
        value = l;
        constantpool.count = constantpool.count + 1;
    }

    static int hashCode(long l)
    {
        return (int)l;
    }

    public int getTag()
    {
        return tag;
    }

    public final long getValue()
    {
        return value;
    }

    public int hashCode()
    {
        if (hash == 0)
        {
            hash = hashCode(value);
        }
        return hash;
    }

    public void print(ClassTypeWriter classtypewriter, int i)
    {
        if (tag == 5)
        {
            if (i > 0)
            {
                classtypewriter.print("Long ");
            }
            classtypewriter.print(value);
            if (i > 1 && value != 0L)
            {
                classtypewriter.print("=0x");
                classtypewriter.print(Long.toHexString(value));
            }
        } else
        {
            if (i > 0)
            {
                classtypewriter.print("Double ");
            }
            classtypewriter.print(Double.longBitsToDouble(value));
            if (i > 1)
            {
                classtypewriter.print("=0x");
                classtypewriter.print(Long.toHexString(value));
                return;
            }
        }
    }

    void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(tag);
        dataoutputstream.writeLong(value);
    }
}
