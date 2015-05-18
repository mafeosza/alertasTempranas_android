// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            CpoolEntry, ClassTypeWriter, ConstantPool

public class CpoolValue1 extends CpoolEntry
{

    int tag;
    int value;

    CpoolValue1(int i)
    {
        tag = i;
    }

    CpoolValue1(ConstantPool constantpool, int i, int j, int k)
    {
        super(constantpool, j);
        tag = i;
        value = k;
    }

    static int hashCode(int i)
    {
        return i;
    }

    public int getTag()
    {
        return tag;
    }

    public final int getValue()
    {
        return value;
    }

    public int hashCode()
    {
        if (hash == 0)
        {
            hash = value;
        }
        return hash;
    }

    public void print(ClassTypeWriter classtypewriter, int i)
    {
        if (tag == 3)
        {
            if (i > 0)
            {
                classtypewriter.print("Integer ");
            }
            classtypewriter.print(value);
            if (i > 1 && value != 0)
            {
                classtypewriter.print("=0x");
                classtypewriter.print(Integer.toHexString(value));
            }
        } else
        {
            if (i > 0)
            {
                classtypewriter.print("Float ");
            }
            classtypewriter.print(Float.intBitsToFloat(value));
            if (i > 1)
            {
                classtypewriter.print("=0x");
                classtypewriter.print(Integer.toHexString(value));
                return;
            }
        }
    }

    void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(tag);
        dataoutputstream.writeInt(value);
    }
}
