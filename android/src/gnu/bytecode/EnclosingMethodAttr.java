// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, ClassType, Method, ConstantPool, 
//            CpoolClass, CpoolNameAndType, ClassTypeWriter, CpoolEntry

public class EnclosingMethodAttr extends Attribute
{

    int class_index;
    Method method;
    int method_index;

    public EnclosingMethodAttr(int i, int j, ClassType classtype)
    {
        this(classtype);
        class_index = i;
        method_index = j;
    }

    public EnclosingMethodAttr(ClassType classtype)
    {
        super("EnclosingMethod");
        addToFrontOf(classtype);
    }

    public static EnclosingMethodAttr getFirstEnclosingMethod(Attribute attribute)
    {
        do
        {
            if (attribute == null || (attribute instanceof EnclosingMethodAttr))
            {
                return (EnclosingMethodAttr)attribute;
            }
            attribute = attribute.next;
        } while (true);
    }

    public void assignConstants(ClassType classtype)
    {
        super.assignConstants(classtype);
        if (method != null)
        {
            classtype = classtype.getConstants();
            class_index = classtype.addClass(method.getDeclaringClass()).getIndex();
            method_index = classtype.addNameAndType(method).getIndex();
        }
    }

    public int getLength()
    {
        return 4;
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        ConstantPool constantpool = ((ClassType)container).getConstants();
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.println(getLength());
        classtypewriter.print("  class: ");
        classtypewriter.printOptionalIndex(class_index);
        classtypewriter.print(((CpoolClass)constantpool.getForced(class_index, 7)).getStringName());
        classtypewriter.print(", method: ");
        classtypewriter.printOptionalIndex(method_index);
        constantpool.getForced(method_index, 12).print(classtypewriter, 0);
        classtypewriter.println();
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(class_index);
        dataoutputstream.writeShort(method_index);
    }
}
