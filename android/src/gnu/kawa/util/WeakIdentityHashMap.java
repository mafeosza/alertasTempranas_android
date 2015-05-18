// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;

import java.lang.ref.ReferenceQueue;

// Referenced classes of package gnu.kawa.util:
//            AbstractHashTable, WeakHashNode, AbstractWeakHashTable

public class WeakIdentityHashMap extends AbstractHashTable
{

    ReferenceQueue rqueue;

    public WeakIdentityHashMap()
    {
        super(64);
        rqueue = new ReferenceQueue();
    }

    public WeakIdentityHashMap(int i)
    {
        super(i);
        rqueue = new ReferenceQueue();
    }

    protected WeakHashNode[] allocEntries(int i)
    {
        return (WeakHashNode[])new WeakHashNode[i];
    }

    protected volatile java.util.Map.Entry[] allocEntries(int i)
    {
        return allocEntries(i);
    }

    void cleanup()
    {
        AbstractWeakHashTable.cleanup(this, rqueue);
    }

    public Object get(Object obj, Object obj1)
    {
        cleanup();
        return super.get(obj, obj1);
    }

    protected int getEntryHashCode(WeakHashNode weakhashnode)
    {
        return weakhashnode.hash;
    }

    protected volatile int getEntryHashCode(java.util.Map.Entry entry)
    {
        return getEntryHashCode((WeakHashNode)entry);
    }

    protected WeakHashNode getEntryNext(WeakHashNode weakhashnode)
    {
        return weakhashnode.next;
    }

    protected volatile java.util.Map.Entry getEntryNext(java.util.Map.Entry entry)
    {
        return getEntryNext((WeakHashNode)entry);
    }

    public int hash(Object obj)
    {
        return System.identityHashCode(obj);
    }

    protected WeakHashNode makeEntry(Object obj, int i, Object obj1)
    {
        obj = new WeakHashNode(obj, rqueue, i);
        obj.value = obj1;
        return ((WeakHashNode) (obj));
    }

    protected volatile java.util.Map.Entry makeEntry(Object obj, int i, Object obj1)
    {
        return makeEntry(obj, i, obj1);
    }

    protected boolean matches(Object obj, Object obj1)
    {
        return obj == obj1;
    }

    public Object put(Object obj, int i, Object obj1)
    {
        cleanup();
        return super.put(obj, i, obj1);
    }

    public Object remove(Object obj)
    {
        cleanup();
        return super.remove(obj);
    }

    protected void setEntryNext(WeakHashNode weakhashnode, WeakHashNode weakhashnode1)
    {
        weakhashnode.next = weakhashnode1;
    }

    protected volatile void setEntryNext(java.util.Map.Entry entry, java.util.Map.Entry entry1)
    {
        setEntryNext((WeakHashNode)entry, (WeakHashNode)entry1);
    }
}
