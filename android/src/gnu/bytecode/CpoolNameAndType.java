// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            CpoolEntry, CpoolUtf8, ClassTypeWriter, ConstantPool

public class CpoolNameAndType extends CpoolEntry
{

    CpoolUtf8 name;
    CpoolUtf8 type;

    CpoolNameAndType()
    {
    }

    CpoolNameAndType(ConstantPool constantpool, int i, CpoolUtf8 cpoolutf8, CpoolUtf8 cpoolutf8_1)
    {
        super(constantpool, i);
        name = cpoolutf8;
        type = cpoolutf8_1;
    }

    static final int hashCode(CpoolUtf8 cpoolutf8, CpoolUtf8 cpoolutf8_1)
    {
        return cpoolutf8.hashCode() ^ cpoolutf8_1.hashCode();
    }

    public final CpoolUtf8 getName()
    {
        return name;
    }

    public int getTag()
    {
        return 12;
    }

    public final CpoolUtf8 getType()
    {
        return type;
    }

    public int hashCode()
    {
        if (hash == 0)
        {
            hash = hashCode(name, type);
        }
        return hash;
    }

    public void print(ClassTypeWriter classtypewriter, int i)
    {
        if (i == 1)
        {
            classtypewriter.print("NameAndType ");
        } else
        if (i > 1)
        {
            classtypewriter.print("NameAndType name: ");
            classtypewriter.printOptionalIndex(name);
        }
        classtypewriter.printName(name.string);
        if (i <= 1)
        {
            classtypewriter.print(' ');
        } else
        {
            classtypewriter.print(", signature: ");
            classtypewriter.printOptionalIndex(type);
        }
        classtypewriter.printSignature(type.string);
    }

    void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(12);
        dataoutputstream.writeShort(name.index);
        dataoutputstream.writeShort(type.index);
    }
}
