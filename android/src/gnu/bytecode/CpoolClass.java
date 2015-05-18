// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            CpoolEntry, CpoolUtf8, Type, ObjectType, 
//            ClassType, ClassTypeWriter, ConstantPool

public class CpoolClass extends CpoolEntry
{

    ObjectType clas;
    CpoolUtf8 name;

    CpoolClass()
    {
    }

    CpoolClass(ConstantPool constantpool, int i, CpoolUtf8 cpoolutf8)
    {
        super(constantpool, i);
        name = cpoolutf8;
    }

    static final int hashCode(CpoolUtf8 cpoolutf8)
    {
        return cpoolutf8.hashCode() ^ 0xf0f;
    }

    public final String getClassName()
    {
        return name.string.replace('/', '.');
    }

    public final ObjectType getClassType()
    {
        Object obj = clas;
        if (obj != null)
        {
            return ((ObjectType) (obj));
        }
        obj = name.string;
        if (((String) (obj)).charAt(0) == '[')
        {
            obj = (ObjectType)Type.signatureToType(((String) (obj)));
        } else
        {
            obj = ClassType.make(((String) (obj)).replace('/', '.'));
        }
        clas = ((ObjectType) (obj));
        return ((ObjectType) (obj));
    }

    public final CpoolUtf8 getName()
    {
        return name;
    }

    public final String getStringName()
    {
        return name.string;
    }

    public int getTag()
    {
        return 7;
    }

    public int hashCode()
    {
        if (hash == 0)
        {
            hash = hashCode(name);
        }
        return hash;
    }

    public void print(ClassTypeWriter classtypewriter, int i)
    {
        String s;
        if (i == 1)
        {
            classtypewriter.print("Class ");
        } else
        if (i > 1)
        {
            classtypewriter.print("Class name: ");
            classtypewriter.printOptionalIndex(name);
        }
        s = name.string;
        i = s.length();
        if (i > 1 && s.charAt(0) == '[')
        {
            Type.printSignature(s, 0, i, classtypewriter);
            return;
        } else
        {
            classtypewriter.print(s.replace('/', '.'));
            return;
        }
    }

    void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(7);
        dataoutputstream.writeShort(name.index);
    }
}
