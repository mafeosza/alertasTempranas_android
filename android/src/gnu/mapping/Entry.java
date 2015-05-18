// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.lang.ref.WeakReference;

class Entry
{

    Entry chain;
    Object key1;
    Object key2;
    Object value;

    Entry()
    {
    }

    public Object getKey1()
    {
        if (key1 instanceof WeakReference)
        {
            return ((WeakReference)key1).get();
        } else
        {
            return key1;
        }
    }

    public Object getKey2()
    {
        if (key2 instanceof WeakReference)
        {
            return ((WeakReference)key2).get();
        } else
        {
            return key2;
        }
    }

    public Object getValue()
    {
        if (value == this)
        {
            return null;
        } else
        {
            return value;
        }
    }

    public boolean matches(Object obj, Object obj1)
    {
        return obj == getKey1() && obj1 == getKey2();
    }
}
