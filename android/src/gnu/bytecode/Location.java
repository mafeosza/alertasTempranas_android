// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            Type, ConstantPool, CpoolUtf8

public class Location
{

    protected String name;
    int name_index;
    int signature_index;
    protected Type type;

    public Location()
    {
    }

    public final String getName()
    {
        return name;
    }

    public final String getSignature()
    {
        return type.getSignature();
    }

    public final Type getType()
    {
        return type;
    }

    public final void setName(int i, ConstantPool constantpool)
    {
        if (i <= 0)
        {
            name = null;
        } else
        {
            name = ((CpoolUtf8)constantpool.getForced(i, 1)).string;
        }
        name_index = i;
    }

    public final void setName(String s)
    {
        name = s;
    }

    public void setSignature(int i, ConstantPool constantpool)
    {
        constantpool = (CpoolUtf8)constantpool.getForced(i, 1);
        signature_index = i;
        type = Type.signatureToType(((CpoolUtf8) (constantpool)).string);
    }

    public final void setType(Type type1)
    {
        type = type1;
    }
}
