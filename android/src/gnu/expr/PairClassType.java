// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;

public class PairClassType extends ClassType
{

    public ClassType instanceType;
    Object staticLink;

    public PairClassType()
    {
    }

    PairClassType(Class class1, Class class2)
    {
        super(class1.getName());
        setExisting(true);
        reflectClass = class1;
        Type.registerTypeForClass(class1, this);
        instanceType = (ClassType)Type.make(class2);
    }

    public static Object extractStaticLink(ClassType classtype)
    {
        return ((PairClassType)classtype).staticLink;
    }

    public static PairClassType make(Class class1, Class class2)
    {
        return new PairClassType(class1, class2);
    }

    public static PairClassType make(Class class1, Class class2, Object obj)
    {
        class1 = new PairClassType(class1, class2);
        class1.staticLink = obj;
        return class1;
    }

    public Object getStaticLink()
    {
        return staticLink;
    }
}
