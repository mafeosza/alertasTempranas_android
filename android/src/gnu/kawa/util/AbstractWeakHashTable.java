// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package gnu.kawa.util:
//            AbstractHashTable

public abstract class AbstractWeakHashTable extends AbstractHashTable
{
    public static class WEntry extends WeakReference
        implements java.util.Map.Entry
    {

        public int hash;
        AbstractWeakHashTable htable;
        public WEntry next;

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

        public WEntry(Object obj, AbstractWeakHashTable abstractweakhashtable, int i)
        {
            super(obj, abstractweakhashtable.rqueue);
            htable = abstractweakhashtable;
            hash = i;
        }
    }


    ReferenceQueue rqueue;

    public AbstractWeakHashTable()
    {
        super(64);
        rqueue = new ReferenceQueue();
    }

    public AbstractWeakHashTable(int i)
    {
        super(i);
        rqueue = new ReferenceQueue();
    }

    static void cleanup(AbstractHashTable abstracthashtable, ReferenceQueue referencequeue)
    {
_L2:
        java.util.Map.Entry entry3 = (java.util.Map.Entry)referencequeue.poll();
        if (entry3 == null)
        {
            return;
        }
        int i = abstracthashtable.hashToIndex(abstracthashtable.getEntryHashCode(entry3));
        java.util.Map.Entry entry1 = null;
        java.util.Map.Entry entry = abstracthashtable.table[i];
        do
        {
            java.util.Map.Entry entry2;
label0:
            {
                if (entry != null)
                {
                    entry2 = abstracthashtable.getEntryNext(entry);
                    if (entry != entry3)
                    {
                        break label0;
                    }
                    if (entry1 == null)
                    {
                        abstracthashtable.table[i] = entry2;
                    } else
                    {
                        abstracthashtable.setEntryNext(entry1, entry2);
                    }
                }
                abstracthashtable.num_bindings = abstracthashtable.num_bindings - 1;
            }
            if (true)
            {
                continue;
            }
            entry1 = entry;
            entry = entry2;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected WEntry[] allocEntries(int i)
    {
        return (WEntry[])new WEntry[i];
    }

    protected volatile java.util.Map.Entry[] allocEntries(int i)
    {
        return allocEntries(i);
    }

    protected void cleanup()
    {
        cleanup(((AbstractHashTable) (this)), rqueue);
    }

    public Object get(Object obj, Object obj1)
    {
        cleanup();
        return super.get(obj, obj1);
    }

    protected int getEntryHashCode(WEntry wentry)
    {
        return wentry.hash;
    }

    protected volatile int getEntryHashCode(java.util.Map.Entry entry)
    {
        return getEntryHashCode((WEntry)entry);
    }

    protected WEntry getEntryNext(WEntry wentry)
    {
        return wentry.next;
    }

    protected volatile java.util.Map.Entry getEntryNext(java.util.Map.Entry entry)
    {
        return getEntryNext((WEntry)entry);
    }

    protected abstract Object getKeyFromValue(Object obj);

    protected Object getValueIfMatching(WEntry wentry, Object obj)
    {
        wentry = ((WEntry) (wentry.getValue()));
        if (wentry != null && matches(getKeyFromValue(wentry), obj))
        {
            return wentry;
        } else
        {
            return null;
        }
    }

    public int hash(Object obj)
    {
        return System.identityHashCode(obj);
    }

    protected WEntry makeEntry(Object obj, int i, Object obj1)
    {
        return new WEntry(obj1, this, i);
    }

    protected volatile java.util.Map.Entry makeEntry(Object obj, int i, Object obj1)
    {
        return makeEntry(obj, i, obj1);
    }

    public Object put(Object obj, Object obj1)
    {
        cleanup();
        int j = hash(obj);
        int i = hashToIndex(j);
        WEntry wentry = ((WEntry[])table)[i];
        obj = wentry;
        Object obj3 = null;
        Object obj2 = null;
        do
        {
            if (obj == null)
            {
                int k = num_bindings + 1;
                num_bindings = k;
                if (k >= ((WEntry[])table).length)
                {
                    rehash();
                    i = hashToIndex(j);
                    wentry = ((WEntry[])table)[i];
                }
                obj = makeEntry(null, j, obj1);
                obj.next = wentry;
                ((WEntry[])table)[i] = ((WEntry) (obj));
                return obj2;
            }
            Object obj4 = ((WEntry) (obj)).getValue();
            if (obj4 == obj1)
            {
                return obj4;
            }
            WEntry wentry1 = ((WEntry) (obj)).next;
            if (obj4 != null && valuesEqual(obj4, obj1))
            {
                if (obj3 == null)
                {
                    ((WEntry[])table)[i] = wentry1;
                } else
                {
                    obj3.next = wentry1;
                }
                obj2 = obj4;
            } else
            {
                obj3 = obj;
            }
            obj = wentry1;
        } while (true);
    }

    protected void setEntryNext(WEntry wentry, WEntry wentry1)
    {
        wentry.next = wentry1;
    }

    protected volatile void setEntryNext(java.util.Map.Entry entry, java.util.Map.Entry entry1)
    {
        setEntryNext((WEntry)entry, (WEntry)entry1);
    }

    protected boolean valuesEqual(Object obj, Object obj1)
    {
        return obj == obj1;
    }
}
