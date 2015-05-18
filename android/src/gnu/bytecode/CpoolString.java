// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            CpoolEntry, CpoolUtf8, ClassTypeWriter, ConstantPool

public class CpoolString extends CpoolEntry
{

    CpoolUtf8 str;

    CpoolString()
    {
    }

    CpoolString(ConstantPool constantpool, int i, CpoolUtf8 cpoolutf8)
    {
        super(constantpool, i);
        str = cpoolutf8;
    }

    static final int hashCode(CpoolUtf8 cpoolutf8)
    {
        return cpoolutf8.hashCode() ^ 0xf30f;
    }

    public final CpoolUtf8 getString()
    {
        return str;
    }

    public int getTag()
    {
        return 8;
    }

    public int hashCode()
    {
        if (hash == 0)
        {
            hash = hashCode(str);
        }
        return hash;
    }

    public void print(ClassTypeWriter classtypewriter, int i)
    {
        if (i > 0)
        {
            classtypewriter.print("String ");
            if (i == 2)
            {
                classtypewriter.printOptionalIndex(str);
            }
        }
        classtypewriter.printConstantTersely(str.index, 1);
    }

    void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(8);
        dataoutputstream.writeShort(str.index);
    }
}
