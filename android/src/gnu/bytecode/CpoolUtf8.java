// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            CpoolEntry, ClassTypeWriter, ConstantPool

public class CpoolUtf8 extends CpoolEntry
{

    String string;

    CpoolUtf8()
    {
    }

    CpoolUtf8(ConstantPool constantpool, int i, String s)
    {
        super(constantpool, i);
        string = s;
    }

    public final String getString()
    {
        return string;
    }

    public int getTag()
    {
        return 1;
    }

    public int hashCode()
    {
        if (hash == 0)
        {
            hash = string.hashCode();
        }
        return hash;
    }

    public final void intern()
    {
        string = string.intern();
    }

    public void print(ClassTypeWriter classtypewriter, int i)
    {
        if (i > 0)
        {
            classtypewriter.print("Utf8: ");
        }
        classtypewriter.printQuotedString(string);
    }

    void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(1);
        dataoutputstream.writeUTF(string);
    }
}
