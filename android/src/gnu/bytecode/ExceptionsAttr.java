// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, ClassType, ConstantPool, CpoolClass, 
//            ClassTypeWriter, Method

public class ExceptionsAttr extends Attribute
{

    short exception_table[];
    ClassType exceptions[];

    public ExceptionsAttr(Method method)
    {
        super("Exceptions");
        addToFrontOf(method);
    }

    public void assignConstants(ClassType classtype)
    {
        super.assignConstants(classtype);
        classtype = classtype.getConstants();
        int i = exceptions.length;
        exception_table = new short[i];
        for (i--; i >= 0; i--)
        {
            exception_table[i] = (short)classtype.addClass(exceptions[i]).index;
        }

    }

    public final ClassType[] getExceptions()
    {
        return exceptions;
    }

    public final int getLength()
    {
        int i;
        if (exceptions == null)
        {
            i = 0;
        } else
        {
            i = exceptions.length;
        }
        return i * 2 + 2;
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.print(getLength());
        classtypewriter.print(", count: ");
        int j = exceptions.length;
        classtypewriter.println(j);
        for (int i = 0; i < j; i++)
        {
            int k = exception_table[i] & 0xffff;
            classtypewriter.print("  ");
            classtypewriter.printOptionalIndex(k);
            classtypewriter.printConstantTersely(k, 7);
            classtypewriter.println();
        }

    }

    public void setExceptions(ClassType aclasstype[])
    {
        exceptions = aclasstype;
    }

    public void setExceptions(short aword0[], ClassType classtype)
    {
        exception_table = aword0;
        exceptions = new ClassType[aword0.length];
        classtype = classtype.getConstants();
        for (int i = aword0.length - 1; i >= 0; i--)
        {
            exceptions[i] = (ClassType)((CpoolClass)classtype.getPoolEntry(aword0[i])).getClassType();
        }

    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        int j = exceptions.length;
        dataoutputstream.writeShort(j);
        for (int i = 0; i < j; i++)
        {
            dataoutputstream.writeShort(exception_table[i]);
        }

    }
}
