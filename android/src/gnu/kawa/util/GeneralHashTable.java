// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;


// Referenced classes of package gnu.kawa.util:
//            AbstractHashTable, HashNode

public class GeneralHashTable extends AbstractHashTable
{

    public GeneralHashTable()
    {
    }

    public GeneralHashTable(int i)
    {
        super(i);
    }

    protected HashNode[] allocEntries(int i)
    {
        return (HashNode[])new HashNode[i];
    }

    protected volatile java.util.Map.Entry[] allocEntries(int i)
    {
        return allocEntries(i);
    }

    protected int getEntryHashCode(HashNode hashnode)
    {
        return hashnode.hash;
    }

    protected volatile int getEntryHashCode(java.util.Map.Entry entry)
    {
        return getEntryHashCode((HashNode)entry);
    }

    protected HashNode getEntryNext(HashNode hashnode)
    {
        return hashnode.next;
    }

    protected volatile java.util.Map.Entry getEntryNext(java.util.Map.Entry entry)
    {
        return getEntryNext((HashNode)entry);
    }

    public HashNode getNode(Object obj)
    {
        return (HashNode)super.getNode(obj);
    }

    public volatile java.util.Map.Entry getNode(Object obj)
    {
        return getNode(obj);
    }

    protected HashNode makeEntry(Object obj, int i, Object obj1)
    {
        obj = new HashNode(obj, obj1);
        obj.hash = i;
        return ((HashNode) (obj));
    }

    protected volatile java.util.Map.Entry makeEntry(Object obj, int i, Object obj1)
    {
        return makeEntry(obj, i, obj1);
    }

    protected void setEntryNext(HashNode hashnode, HashNode hashnode1)
    {
        hashnode.next = hashnode1;
    }

    protected volatile void setEntryNext(java.util.Map.Entry entry, java.util.Map.Entry entry1)
    {
        setEntryNext((HashNode)entry, (HashNode)entry1);
    }
}
