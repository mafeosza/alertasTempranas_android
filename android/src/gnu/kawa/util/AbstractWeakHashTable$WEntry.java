// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;

import java.lang.ref.WeakReference;

// Referenced classes of package gnu.kawa.util:
//            AbstractWeakHashTable

public static class hash extends WeakReference
    implements java.util.try
{

    public int hash;
    AbstractWeakHashTable htable;
    public it> next;

    public Object getKey()
    {
        Object obj = get();
        if (obj == null)
        {
            return null;
        } else
        {
            return htable.getKeyFromValue(obj);
        }
    }

    public Object getValue()
    {
        return get();
    }

    public Object setValue(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public (Object obj, AbstractWeakHashTable abstractweakhashtable, int i)
    {
        super(obj, abstractweakhashtable.rqueue);
        htable = abstractweakhashtable;
        hash = i;
    }
}
