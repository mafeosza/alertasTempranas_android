// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            ObjectType, ClassType, Label, Type

public class UninitializedType extends ObjectType
{

    ClassType ctype;
    Label label;

    UninitializedType(ClassType classtype)
    {
        super(classtype.getName());
        setSignature(classtype.getSignature());
        ctype = classtype;
    }

    UninitializedType(ClassType classtype, Label label1)
    {
        this(classtype);
        label = label1;
    }

    static UninitializedType uninitializedThis(ClassType classtype)
    {
        return new UninitializedType(classtype);
    }

    public Type getImplementationType()
    {
        return ctype;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Uninitialized<").append(ctype.getName()).append('>').toString();
    }
}
