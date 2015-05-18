// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;

import java.util.Hashtable;

public class RangeTable
    implements Cloneable
{

    Hashtable hash;
    Object index[];

    public RangeTable()
    {
        index = new Object[128];
        hash = new Hashtable(200);
    }

    public Object clone()
    {
        return copy();
    }

    public RangeTable copy()
    {
        RangeTable rangetable = new RangeTable();
        rangetable.index = (Object[])(Object[])((Object []) (index)).clone();
        rangetable.hash = (Hashtable)hash.clone();
        return rangetable;
    }

    public Object lookup(int i, Object obj)
    {
        if ((i & 0x7f) == i)
        {
            return index[i];
        } else
        {
            return hash.get(new Integer(i));
        }
    }

    public void remove(int i)
    {
        remove(i, i);
    }

    public void remove(int i, int j)
    {
        if (i <= j) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((i & 0x7f) == i)
        {
            index[i] = null;
        } else
        {
            hash.remove(new Integer(i));
        }
        if (i == j) goto _L1; else goto _L3
_L3:
        i++;
          goto _L2
    }

    public void set(int i, int j, Object obj)
    {
        if (i <= j) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((i & 0x7f) == i)
        {
            index[i] = obj;
        } else
        {
            hash.put(new Integer(i), obj);
        }
        if (i == j) goto _L1; else goto _L3
_L3:
        i++;
          goto _L2
    }

    public void set(int i, Object obj)
    {
        set(i, i, obj);
    }
}
