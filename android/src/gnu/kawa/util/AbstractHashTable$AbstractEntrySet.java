// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package gnu.kawa.util:
//            AbstractHashTable

static class htable extends AbstractSet
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
            final AbstractHashTable.AbstractEntrySet this$0;

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
                this$0 = AbstractHashTable.AbstractEntrySet.this;
                super();
                curIndex = -1;
            }
        };
    }

    public int size()
    {
        return htable.size();
    }

    public _cls1.curIndex(AbstractHashTable abstracthashtable)
    {
        htable = abstracthashtable;
    }
}
