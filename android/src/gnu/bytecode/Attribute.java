// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            AttrContainer, ClassType, ConstantPool, CpoolUtf8, 
//            ClassTypeWriter

public abstract class Attribute
{

    AttrContainer container;
    String name;
    int name_index;
    Attribute next;

    public Attribute(String s)
    {
        name = s;
    }

    public static void assignConstants(AttrContainer attrcontainer, ClassType classtype)
    {
        for (attrcontainer = attrcontainer.getAttributes(); attrcontainer != null; attrcontainer = ((Attribute) (attrcontainer)).next)
        {
            if (!attrcontainer.isSkipped())
            {
                attrcontainer.assignConstants(classtype);
            }
        }

    }

    public static int count(AttrContainer attrcontainer)
    {
        int i = 0;
        for (attrcontainer = attrcontainer.getAttributes(); attrcontainer != null;)
        {
            int j = i;
            if (!attrcontainer.isSkipped())
            {
                j = i + 1;
            }
            attrcontainer = ((Attribute) (attrcontainer)).next;
            i = j;
        }

        return i;
    }

    public static Attribute get(AttrContainer attrcontainer, String s)
    {
        for (attrcontainer = attrcontainer.getAttributes(); attrcontainer != null; attrcontainer = ((Attribute) (attrcontainer)).next)
        {
            if (attrcontainer.getName() == s)
            {
                return attrcontainer;
            }
        }

        return null;
    }

    public static int getLengthAll(AttrContainer attrcontainer)
    {
        int i = 0;
        for (attrcontainer = attrcontainer.getAttributes(); attrcontainer != null;)
        {
            int j = i;
            if (!attrcontainer.isSkipped())
            {
                j = i + (attrcontainer.getLength() + 6);
            }
            attrcontainer = ((Attribute) (attrcontainer)).next;
            i = j;
        }

        return i;
    }

    public static void writeAll(AttrContainer attrcontainer, DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(count(attrcontainer));
        attrcontainer = attrcontainer.getAttributes();
        while (attrcontainer != null) 
        {
            if (!attrcontainer.isSkipped())
            {
                if (((Attribute) (attrcontainer)).name_index == 0)
                {
                    throw new Error("Attribute.writeAll called without assignConstants");
                }
                dataoutputstream.writeShort(((Attribute) (attrcontainer)).name_index);
                dataoutputstream.writeInt(attrcontainer.getLength());
                attrcontainer.write(dataoutputstream);
            }
            attrcontainer = ((Attribute) (attrcontainer)).next;
        }
    }

    public void addToFrontOf(AttrContainer attrcontainer)
    {
        setContainer(attrcontainer);
        setNext(attrcontainer.getAttributes());
        attrcontainer.setAttributes(this);
    }

    public void assignConstants(ClassType classtype)
    {
        if (name_index == 0)
        {
            name_index = classtype.getConstants().addUtf8(name).getIndex();
        }
    }

    public final AttrContainer getContainer()
    {
        return container;
    }

    public abstract int getLength();

    public final String getName()
    {
        return name;
    }

    public final int getNameIndex()
    {
        return name_index;
    }

    public final Attribute getNext()
    {
        return next;
    }

    public final boolean isSkipped()
    {
        return name_index < 0;
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.println(getLength());
    }

    public final void setContainer(AttrContainer attrcontainer)
    {
        container = attrcontainer;
    }

    public final void setName(String s)
    {
        name = s.intern();
    }

    public final void setNameIndex(int i)
    {
        name_index = i;
    }

    public final void setNext(Attribute attribute)
    {
        next = attribute;
    }

    public final void setSkipped()
    {
        name_index = -1;
    }

    public final void setSkipped(boolean flag)
    {
        int i;
        if (flag)
        {
            i = -1;
        } else
        {
            i = 0;
        }
        name_index = i;
    }

    public abstract void write(DataOutputStream dataoutputstream)
        throws IOException;
}
