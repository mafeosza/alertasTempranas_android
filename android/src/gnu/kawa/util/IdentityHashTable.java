// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;


// Referenced classes of package gnu.kawa.util:
//            GeneralHashTable

public class IdentityHashTable extends GeneralHashTable
{

    public IdentityHashTable()
    {
    }

    public IdentityHashTable(int i)
    {
        super(i);
    }

    public int hash(Object obj)
    {
        return System.identityHashCode(obj);
    }

    public boolean matches(Object obj, Object obj1)
    {
        return obj == obj1;
    }
}
