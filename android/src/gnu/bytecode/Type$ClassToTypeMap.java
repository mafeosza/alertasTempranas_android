// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import gnu.kawa.util.AbstractWeakHashTable;

// Referenced classes of package gnu.bytecode:
//            Type

static class le extends AbstractWeakHashTable
{

    protected Class getKeyFromValue(Type type)
    {
        return type.reflectClass;
    }

    protected volatile Object getKeyFromValue(Object obj)
    {
        return getKeyFromValue((Type)obj);
    }

    protected boolean matches(Class class1, Class class2)
    {
        return class1 == class2;
    }

    le()
    {
    }
}
