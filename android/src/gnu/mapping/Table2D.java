// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.lang.ref.WeakReference;

// Referenced classes of package gnu.mapping:
//            Entry, Symbol

public class Table2D
{

    private static Table2D instance = new Table2D();
    int log2Size;
    int mask;
    int num_bindings;
    Entry table[];

    public Table2D()
    {
        this(64);
    }

    public Table2D(int i)
    {
        for (log2Size = 4; i > 1 << log2Size; log2Size = log2Size + 1) { }
        i = 1 << log2Size;
        table = new Entry[i];
        mask = i - 1;
    }

    public static final Table2D getInstance()
    {
        return instance;
    }

    public Object get(Object obj, Object obj1, Object obj2)
    {
        obj = lookup(obj, obj1, System.identityHashCode(obj), System.identityHashCode(obj1), false);
        if (obj == null || ((Entry) (obj)).value == obj)
        {
            return obj2;
        } else
        {
            return ((Entry) (obj)).value;
        }
    }

    public boolean isBound(Object obj, Object obj1)
    {
        boolean flag1 = false;
        obj = lookup(obj, obj1, System.identityHashCode(obj), System.identityHashCode(obj1), false);
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (((Entry) (obj)).value != obj)
            {
                flag = true;
            }
        }
        return flag;
    }

    protected Entry lookup(Object obj, Object obj1, int i, int j, boolean flag)
    {
        j = (i ^ j) & mask;
        Entry entry2 = null;
        Entry entry3 = table[j];
        Entry entry = entry3;
        while (entry != null) 
        {
            Object obj3 = entry.key1;
            Object obj4 = entry.key2;
            i = 0;
            Object obj2 = obj3;
            if (obj3 instanceof WeakReference)
            {
                obj2 = ((WeakReference)obj3).get();
                if (obj2 == null)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            }
            obj3 = obj4;
            if (obj4 instanceof WeakReference)
            {
                obj3 = ((WeakReference)obj4).get();
                if (obj3 != null);
                i = 1;
            }
            obj4 = entry.chain;
            if (i != 0)
            {
                if (entry2 == null)
                {
                    table[j] = ((Entry) (obj4));
                } else
                {
                    entry2.chain = ((Entry) (obj4));
                }
                num_bindings = num_bindings - 1;
                entry.value = entry;
            } else
            {
                if (obj2 == obj && obj3 == obj1)
                {
                    return entry;
                }
                entry2 = entry;
            }
            entry = ((Entry) (obj4));
        }
        if (flag)
        {
            Entry entry1 = new Entry();
            obj = wrapReference(obj);
            obj1 = wrapReference(obj1);
            entry1.key1 = obj;
            entry1.key2 = obj1;
            num_bindings = num_bindings + 1;
            entry1.chain = entry3;
            table[j] = entry1;
            entry1.value = entry1;
            return entry1;
        } else
        {
            return null;
        }
    }

    public Object put(Object obj, Object obj1, Object obj2)
    {
        obj = lookup(obj, obj1, System.identityHashCode(obj), System.identityHashCode(obj1), true);
        obj1 = ((Entry) (obj)).getValue();
        obj.value = obj2;
        return obj1;
    }

    void rehash()
    {
        Entry aentry1[];
        int i1;
        Entry aentry[] = table;
        int i = aentry.length;
        int k = i * 2;
        aentry1 = new Entry[k];
        i1 = k - 1;
        num_bindings = 0;
        do
        {
label0:
            {
                int l = i - 1;
                if (l < 0)
                {
                    break label0;
                }
                Entry entry = aentry[l];
                do
                {
                    i = l;
                    if (entry == null)
                    {
                        break;
                    }
                    Object obj1 = entry.key1;
                    Object obj2 = entry.key2;
                    boolean flag = false;
                    Object obj = obj1;
                    if (obj1 instanceof WeakReference)
                    {
                        obj = ((WeakReference)obj1).get();
                        if (obj == null)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    }
                    obj1 = obj2;
                    if (obj2 instanceof WeakReference)
                    {
                        obj1 = ((WeakReference)obj2).get();
                        if (obj1 == null)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    }
                    obj2 = entry.chain;
                    if (flag)
                    {
                        entry.value = entry;
                    } else
                    {
                        int j = (System.identityHashCode(obj) ^ System.identityHashCode(obj1)) & i1;
                        entry.chain = aentry1[j];
                        aentry1[j] = entry;
                        num_bindings = num_bindings + 1;
                    }
                    entry = ((Entry) (obj2));
                } while (true);
            }
        } while (true);
        table = aentry1;
        log2Size = log2Size + 1;
        mask = i1;
        return;
    }

    public Object remove(Object obj, Object obj1)
    {
        return remove(obj, obj1, System.identityHashCode(obj) ^ System.identityHashCode(obj1));
    }

    public Object remove(Object obj, Object obj1, int i)
    {
        return remove(obj, obj1, i);
    }

    public Object remove(Object obj, Object obj1, int i, int j)
    {
        int k = (i ^ j) & mask;
        Entry entry1 = null;
        Entry entry = table[k];
        while (entry != null) 
        {
            Object obj3 = entry.key1;
            Object obj4 = entry.key2;
            i = 0;
            Object obj2 = obj3;
            Object obj5;
            if (obj3 instanceof WeakReference)
            {
                obj2 = ((WeakReference)obj3).get();
                if (obj2 == null)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            }
            obj3 = obj4;
            if (obj4 instanceof WeakReference)
            {
                obj3 = ((WeakReference)obj4).get();
                if (obj3 == null)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            }
            obj4 = entry.chain;
            obj5 = entry.value;
            if (obj2 == obj && obj3 == obj1)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (i != 0 || j != 0)
            {
                if (entry1 == null)
                {
                    table[k] = ((Entry) (obj4));
                } else
                {
                    entry1.chain = ((Entry) (obj4));
                }
                num_bindings = num_bindings - 1;
                entry.value = entry;
            } else
            {
                if (j != 0)
                {
                    return obj5;
                }
                entry1 = entry;
            }
            entry = ((Entry) (obj4));
        }
        return null;
    }

    protected Object wrapReference(Object obj)
    {
        if (obj == null || (obj instanceof Symbol))
        {
            return obj;
        } else
        {
            return new WeakReference(obj);
        }
    }

}
