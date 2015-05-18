// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            CpoolEntry, CpoolClass, CpoolNameAndType, ClassTypeWriter, 
//            ConstantPool

public class CpoolRef extends CpoolEntry
{

    CpoolClass clas;
    CpoolNameAndType nameAndType;
    int tag;

    CpoolRef(int i)
    {
        tag = i;
    }

    CpoolRef(ConstantPool constantpool, int i, int j, CpoolClass cpoolclass, CpoolNameAndType cpoolnameandtype)
    {
        super(constantpool, i);
        tag = j;
        clas = cpoolclass;
        nameAndType = cpoolnameandtype;
    }

    static final int hashCode(CpoolClass cpoolclass, CpoolNameAndType cpoolnameandtype)
    {
        return cpoolclass.hashCode() ^ cpoolnameandtype.hashCode();
    }

    public final CpoolClass getCpoolClass()
    {
        return clas;
    }

    public final CpoolNameAndType getNameAndType()
    {
        return nameAndType;
    }

    public int getTag()
    {
        return tag;
    }

    public int hashCode()
    {
        if (hash == 0)
        {
            hash = hashCode(clas, nameAndType);
        }
        return hash;
    }

    public void print(ClassTypeWriter classtypewriter, int i)
    {
        tag;
        JVM INSTR tableswitch 9 11: default 32
    //                   9 104
    //                   10 110
    //                   11 116;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_116;
_L1:
        String s = "<Unknown>Ref";
_L5:
        if (i > 0)
        {
            classtypewriter.print(s);
            if (i == 2)
            {
                classtypewriter.print(" class: ");
                classtypewriter.printOptionalIndex(clas);
            } else
            {
                classtypewriter.print(' ');
            }
        }
        clas.print(classtypewriter, 0);
        if (i < 2)
        {
            classtypewriter.print('.');
        } else
        {
            classtypewriter.print(" name_and_type: ");
            classtypewriter.printOptionalIndex(nameAndType);
            classtypewriter.print('<');
        }
        nameAndType.print(classtypewriter, 0);
        if (i == 2)
        {
            classtypewriter.print('>');
        }
        return;
_L2:
        s = "Field";
          goto _L5
_L3:
        s = "Method";
          goto _L5
        s = "InterfaceMethod";
          goto _L5
    }

    void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(tag);
        dataoutputstream.writeShort(clas.index);
        dataoutputstream.writeShort(nameAndType.index);
    }
}
