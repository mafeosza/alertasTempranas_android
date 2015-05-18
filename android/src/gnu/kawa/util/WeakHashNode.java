// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakHashNode extends WeakReference
    implements java.util.Map.Entry
{

    public int hash;
    public WeakHashNode next;
    public Object value;

    public WeakHashNode(Object obj, ReferenceQueue referencequeue, int i)
    {
        super(obj, referencequeue);
        hash = i;
    }

    public Object getKey()
    {
        return get();
    }

    public Object getValue()
    {
        return value;
    }

    public Object setValue(Object obj)
    {
        Object obj1 = value;
        value = obj;
        return obj1;
    }
}
