// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AbstractHashTable extends AbstractMap
{
    static class AbstractEntrySet extends AbstractSet
    {

        AbstractHashTable htable;

        public Iterator iterator()
        {
            return new Iterator() {

                int curIndex;
                java.util.Map.Entry currentEntry;
                java.util.Map.Entry nextEntry;
                int nextIndex;
                java.util.Map.Entry previousEntry;
                final AbstractEntrySet this$0;

                private void advance()
                {
                    do
                    {
                        if (nextEntry != null)
                        {
                            break;
                        }
                        int i = nextIndex - 1;
                        nextIndex = i;
                        if (i < 0)
                        {
                            break;
                        }
                        nextEntry = htable.table[nextIndex];
                    } while (true);
                }

                public boolean hasNext()
                {
                    if (curIndex < 0)
                    {
                        nextIndex = htable.table.length;
                        curIndex = nextIndex;
                        advance();
                    }
                    return nextEntry != null;
                }

                public volatile Object next()
                {
                    return next();
                }

                public java.util.Map.Entry next()
                {
                    if (nextEntry == null)
                    {
                        throw new NoSuchElementException();
                    } else
                    {
                        previousEntry = currentEntry;
                        currentEntry = nextEntry;
                        curIndex = nextIndex;
                        nextEntry = htable.getEntryNext(currentEntry);
                        advance();
                        return currentEntry;
                    }
                }

                public void remove()
                {
                    if (previousEntry == currentEntry)
                    {
                        throw new IllegalStateException();
                    }
                    AbstractHashTable abstracthashtable;
                    if (previousEntry == null)
                    {
                        htable.table[curIndex] = nextEntry;
                    } else
                    {
                        htable.setEntryNext(previousEntry, nextEntry);
                    }
                    abstracthashtable = htable;
                    abstracthashtable.num_bindings = abstracthashtable.num_bindings - 1;
                    previousEntry = currentEntry;
                }

            
            {
                this$0 = AbstractEntrySet.this;
                super();
                curIndex = -1;
            }
            };
        }

        public int size()
        {
            return htable.size();
        }

        public AbstractEntrySet(AbstractHashTable abstracthashtable)
        {
            htable = abstracthashtable;
        }
    }


    public static final int DEFAULT_INITIAL_SIZE = 64;
    protected int mask;
    protected int num_bindings;
    protected java.util.Map.Entry table[];

    public AbstractHashTable()
    {
        this(64);
    }

    public AbstractHashTable(int i)
    {
        int j;
        for (j = 4; i > 1 << j; j++) { }
        i = 1 << j;
        table = allocEntries(i);
        mask = i - 1;
    }

    protected abstract java.util.Map.Entry[] allocEntries(int i);

    public void clear()
    {
        java.util.Map.Entry aentry[] = table;
        int i = aentry.length;
        do
        {
            i--;
            if (i >= 0)
            {
                java.util.Map.Entry entry1;
                for (java.util.Map.Entry entry = aentry[i]; entry != null; entry = entry1)
                {
                    entry1 = getEntryNext(entry);
                    setEntryNext(entry, null);
                }

                aentry[i] = null;
            } else
            {
                num_bindings = 0;
                return;
            }
        } while (true);
    }

    public Set entrySet()
    {
        return new AbstractEntrySet(this);
    }

    public Object get(Object obj)
    {
        return get(obj, null);
    }

    public Object get(Object obj, Object obj1)
    {
        obj = getNode(obj);
        if (obj == null)
        {
            return obj1;
        } else
        {
            return ((java.util.Map.Entry) (obj)).getValue();
        }
    }

    protected abstract int getEntryHashCode(java.util.Map.Entry entry);

    protected abstract java.util.Map.Entry getEntryNext(java.util.Map.Entry entry);

    public java.util.Map.Entry getNode(Object obj)
    {
        int i = hash(obj);
        int j = hashToIndex(i);
        for (java.util.Map.Entry entry = table[j]; entry != null; entry = getEntryNext(entry))
        {
            if (matches(obj, i, entry))
            {
                return entry;
            }
        }

        return null;
    }

    public int hash(Object obj)
    {
        if (obj == null)
        {
            return 0;
        } else
        {
            return obj.hashCode();
        }
    }

    protected int hashToIndex(int i)
    {
        return mask & (i ^ i >>> 15);
    }

    protected abstract java.util.Map.Entry makeEntry(Object obj, int i, Object obj1);

    protected boolean matches(Object obj, int i, java.util.Map.Entry entry)
    {
        return getEntryHashCode(entry) == i && matches(entry.getKey(), obj);
    }

    protected boolean matches(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public Object put(Object obj, int i, Object obj1)
    {
        int j = hashToIndex(i);
        java.util.Map.Entry entry = table[j];
        java.util.Map.Entry entry1 = entry;
        do
        {
            if (entry1 == null)
            {
                int k = num_bindings + 1;
                num_bindings = k;
                if (k >= table.length)
                {
                    rehash();
                    j = hashToIndex(i);
                    entry = table[j];
                }
                obj = makeEntry(obj, i, obj1);
                setEntryNext(((java.util.Map.Entry) (obj)), entry);
                table[j] = ((java.util.Map.Entry) (obj));
                return null;
            }
            if (matches(obj, i, entry1))
            {
                obj = entry1.getValue();
                entry1.setValue(obj1);
                return obj;
            }
            entry1 = getEntryNext(entry1);
        } while (true);
    }

    public Object put(Object obj, Object obj1)
    {
        return put(obj, hash(obj), obj1);
    }

    protected void rehash()
    {
        java.util.Map.Entry aentry[] = table;
        int i = aentry.length;
        int j = i * 2;
        java.util.Map.Entry aentry1[] = allocEntries(j);
        table = aentry1;
        mask = j - 1;
        do
        {
label0:
            {
                int k = i - 1;
                if (k < 0)
                {
                    break label0;
                }
                java.util.Map.Entry entry1 = aentry[k];
                java.util.Map.Entry entry = entry1;
                if (entry1 != null)
                {
                    entry = entry1;
                    if (getEntryNext(entry1) != null)
                    {
                        java.util.Map.Entry entry3 = null;
                        java.util.Map.Entry entry4;
                        do
                        {
                            entry = entry1;
                            entry4 = getEntryNext(entry);
                            setEntryNext(entry, entry3);
                            entry1 = entry4;
                            entry3 = entry;
                        } while (entry4 != null);
                    }
                }
                do
                {
                    i = k;
                    if (entry == null)
                    {
                        break;
                    }
                    java.util.Map.Entry entry2 = getEntryNext(entry);
                    i = hashToIndex(getEntryHashCode(entry));
                    setEntryNext(entry, aentry1[i]);
                    aentry1[i] = entry;
                    entry = entry2;
                } while (true);
            }
        } while (true);
    }

    public Object remove(Object obj)
    {
        int i = hash(obj);
        int j = hashToIndex(i);
        java.util.Map.Entry entry1 = null;
        java.util.Map.Entry entry2;
        for (java.util.Map.Entry entry = table[j]; entry != null; entry = entry2)
        {
            entry2 = getEntryNext(entry);
            if (matches(obj, i, entry))
            {
                if (entry1 == null)
                {
                    table[j] = entry2;
                } else
                {
                    setEntryNext(entry1, entry2);
                }
                num_bindings = num_bindings - 1;
                return entry.getValue();
            }
            entry1 = entry;
        }

        return null;
    }

    protected abstract void setEntryNext(java.util.Map.Entry entry, java.util.Map.Entry entry1);

    public int size()
    {
        return num_bindings;
    }
}
