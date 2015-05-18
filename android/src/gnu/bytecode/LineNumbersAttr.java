// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, CodeAttr, ClassTypeWriter

public class LineNumbersAttr extends Attribute
{

    int linenumber_count;
    short linenumber_table[];

    public LineNumbersAttr(CodeAttr codeattr)
    {
        super("LineNumberTable");
        addToFrontOf(codeattr);
        codeattr.lines = this;
    }

    public LineNumbersAttr(short aword0[], CodeAttr codeattr)
    {
        this(codeattr);
        linenumber_table = aword0;
        linenumber_count = aword0.length >> 1;
    }

    public final int getLength()
    {
        return linenumber_count * 4 + 2;
    }

    public int getLineCount()
    {
        return linenumber_count;
    }

    public short[] getLineNumberTable()
    {
        return linenumber_table;
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.print(getLength());
        classtypewriter.print(", count: ");
        classtypewriter.println(linenumber_count);
        for (int i = 0; i < linenumber_count; i++)
        {
            classtypewriter.print("  line: ");
            classtypewriter.print(linenumber_table[i * 2 + 1] & 0xffff);
            classtypewriter.print(" at pc: ");
            classtypewriter.println(linenumber_table[i * 2] & 0xffff);
        }

    }

    public void put(int i, int j)
    {
        if (linenumber_table != null) goto _L2; else goto _L1
_L1:
        linenumber_table = new short[32];
_L4:
        linenumber_table[linenumber_count * 2] = (short)j;
        linenumber_table[linenumber_count * 2 + 1] = (short)i;
        linenumber_count = linenumber_count + 1;
        return;
_L2:
        if (linenumber_count * 2 >= linenumber_table.length)
        {
            short aword0[] = new short[linenumber_table.length * 2];
            System.arraycopy(linenumber_table, 0, aword0, 0, linenumber_count * 2);
            linenumber_table = aword0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(linenumber_count);
        int j = linenumber_count;
        for (int i = 0; i < j * 2; i++)
        {
            dataoutputstream.writeShort(linenumber_table[i]);
        }

    }
}
