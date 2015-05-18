// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package gnu.lists:
//            SeqPosition, Sequence, Consumer, ItemPredicate, 
//            TreePosition, SubSequence

public abstract class AbstractSequence
{

    public AbstractSequence()
    {
    }

    public static int compare(AbstractSequence abstractsequence, int i, AbstractSequence abstractsequence1, int j)
    {
        if (abstractsequence == abstractsequence1)
        {
            return abstractsequence.compare(i, j);
        } else
        {
            return abstractsequence.stableCompare(abstractsequence1);
        }
    }

    public static RuntimeException unsupportedException(String s)
    {
        return new UnsupportedOperationException(s);
    }

    public void add(int i, Object obj)
    {
        i = createPos(i, false);
        addPos(i, obj);
        releasePos(i);
    }

    public boolean add(Object obj)
    {
        addPos(endPos(), obj);
        return true;
    }

    public boolean addAll(int i, Collection collection)
    {
        boolean flag = false;
        i = createPos(i, false);
        for (collection = collection.iterator(); collection.hasNext();)
        {
            i = addPos(i, collection.next());
            flag = true;
        }

        releasePos(i);
        return flag;
    }

    public boolean addAll(Collection collection)
    {
        return addAll(size(), collection);
    }

    protected int addPos(int i, Object obj)
    {
        throw unsupported("addPos");
    }

    public void clear()
    {
        removePos(startPos(), endPos());
    }

    public int compare(int i, int j)
    {
        i = nextIndex(i);
        j = nextIndex(j);
        if (i < j)
        {
            return -1;
        }
        return i <= j ? 0 : 1;
    }

    public final int compare(SeqPosition seqposition, SeqPosition seqposition1)
    {
        return compare(seqposition.ipos, seqposition1.ipos);
    }

    public void consume(Consumer consumer)
    {
        boolean flag = this instanceof Sequence;
        if (flag)
        {
            consumer.startElement("#sequence");
        }
        consumePosRange(startPos(), endPos(), consumer);
        if (flag)
        {
            consumer.endElement();
        }
    }

    public boolean consumeNext(int i, Consumer consumer)
    {
        int j = nextPos(i);
        if (j == 0)
        {
            return false;
        } else
        {
            consumePosRange(i, j, consumer);
            return true;
        }
    }

    public void consumePosRange(int i, int j, Consumer consumer)
    {
        if (consumer.ignoring())
        {
            return;
        }
        for (i = copyPos(i); !equals(i, j); i = nextPos(i))
        {
            if (!hasNext(i))
            {
                throw new RuntimeException();
            }
            consumer.writeObject(getPosNext(i));
        }

        releasePos(i);
    }

    public boolean contains(Object obj)
    {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (!contains(collection.next()))
            {
                return false;
            }
        }

        return true;
    }

    public int copyPos(int i)
    {
        return i;
    }

    public abstract int createPos(int i, boolean flag);

    public int createRelativePos(int i, int j, boolean flag)
    {
        return createPos(nextIndex(i) + j, flag);
    }

    public final Enumeration elements()
    {
        return getIterator();
    }

    public int endPos()
    {
        return -1;
    }

    public boolean equals(int i, int j)
    {
        return compare(i, j) == 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = false;
        if ((this instanceof List) && (obj instanceof List)) goto _L2; else goto _L1
_L1:
        if (this != obj)
        {
            flag = false;
        }
_L4:
        return flag;
_L2:
        Iterator iterator1;
        iterator1 = iterator();
        obj = ((List)obj).iterator();
_L6:
        boolean flag2;
        flag2 = iterator1.hasNext();
        flag = flag1;
        if (flag2 != ((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        Object obj1;
        Object obj2;
        if (!flag2)
        {
            return true;
        }
        obj1 = iterator1.next();
        obj2 = ((Iterator) (obj)).next();
        if (obj1 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj2 == null) goto _L6; else goto _L5
_L5:
        return false;
        if (obj1.equals(obj2)) goto _L6; else goto _L7
_L7:
        return false;
    }

    public void fill(int i, int j, Object obj)
    {
        i = createPos(i, false);
        for (j = createPos(j, true); compare(i, j) < 0; i = nextPos(i))
        {
            setPosNext(i, obj);
        }

        releasePos(i);
        releasePos(j);
    }

    public void fill(Object obj)
    {
        int i = startPos();
        do
        {
            i = nextPos(i);
            if (i != 0)
            {
                setPosPrevious(i, obj);
            } else
            {
                return;
            }
        } while (true);
    }

    public void fillPosRange(int i, int j, Object obj)
    {
        for (i = copyPos(i); compare(i, j) < 0; i = nextPos(i))
        {
            setPosNext(i, obj);
        }

        releasePos(i);
    }

    public int firstAttributePos(int i)
    {
        return 0;
    }

    public int firstChildPos(int i)
    {
        return 0;
    }

    public int firstChildPos(int i, ItemPredicate itempredicate)
    {
        int j = firstChildPos(i);
        if (j == 0)
        {
            i = 0;
        } else
        {
            i = j;
            if (!itempredicate.isInstancePos(this, j))
            {
                return nextMatching(j, itempredicate, endPos(), false);
            }
        }
        return i;
    }

    protected int fromEndIndex(int i)
    {
        return size() - nextIndex(i);
    }

    public abstract Object get(int i);

    public Object get(int ai[])
    {
        return get(ai[0]);
    }

    public Object getAttribute(int i)
    {
        return null;
    }

    public int getAttributeLength()
    {
        return 0;
    }

    protected int getContainingSequenceSize(int i)
    {
        return size();
    }

    public int getEffectiveIndex(int ai[])
    {
        return ai[0];
    }

    protected int getIndexDifference(int i, int j)
    {
        return nextIndex(i) - nextIndex(j);
    }

    public final SeqPosition getIterator()
    {
        return getIterator(0);
    }

    public SeqPosition getIterator(int i)
    {
        return new SeqPosition(this, i, false);
    }

    public SeqPosition getIteratorAtPos(int i)
    {
        return new SeqPosition(this, copyPos(i));
    }

    public int getLowBound(int i)
    {
        return 0;
    }

    public int getNextKind(int i)
    {
        return !hasNext(i) ? 0 : 32;
    }

    public String getNextTypeName(int i)
    {
        return null;
    }

    public Object getNextTypeObject(int i)
    {
        return null;
    }

    public Object getPosNext(int i)
    {
        if (!hasNext(i))
        {
            return Sequence.eofValue;
        } else
        {
            return get(nextIndex(i));
        }
    }

    public Object getPosPrevious(int i)
    {
        i = nextIndex(i);
        if (i <= 0)
        {
            return Sequence.eofValue;
        } else
        {
            return get(i - 1);
        }
    }

    public int getSize(int i)
    {
        if (i == 0)
        {
            return size();
        } else
        {
            return 1;
        }
    }

    protected boolean gotoAttributesStart(TreePosition treeposition)
    {
        return false;
    }

    public final boolean gotoChildrenStart(TreePosition treeposition)
    {
        int i = firstChildPos(treeposition.getPos());
        if (i == 0)
        {
            return false;
        } else
        {
            treeposition.push(this, i);
            return true;
        }
    }

    protected boolean gotoParent(TreePosition treeposition)
    {
        if (treeposition.depth < 0)
        {
            return false;
        } else
        {
            treeposition.pop();
            return true;
        }
    }

    public boolean hasNext(int i)
    {
        return nextIndex(i) != size();
    }

    protected boolean hasPrevious(int i)
    {
        return nextIndex(i) != 0;
    }

    public int hashCode()
    {
        int i = 1;
        int j = startPos();
        do
        {
            int k = nextPos(j);
            if (k != 0)
            {
                Object obj = getPosPrevious(k);
                if (obj == null)
                {
                    j = 0;
                } else
                {
                    j = obj.hashCode();
                }
                i = i * 31 + j;
                j = k;
            } else
            {
                return i;
            }
        } while (true);
    }

    public int indexOf(Object obj)
    {
        int i = 0;
        int j = startPos();
        do
        {
            j = nextPos(j);
            if (j != 0)
            {
                Object obj1 = getPosPrevious(j);
                if (obj != null ? obj.equals(obj1) : obj1 == null)
                {
                    releasePos(j);
                    return i;
                }
                i++;
            } else
            {
                return -1;
            }
        } while (true);
    }

    protected boolean isAfterPos(int i)
    {
        return (i & 1) != 0;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public final Iterator iterator()
    {
        return getIterator();
    }

    public int lastIndexOf(Object obj)
    {
        int i = size();
        do
        {
            int j = i - 1;
            if (j >= 0)
            {
                Object obj1 = get(j);
                if (obj == null)
                {
                    i = j;
                    if (obj1 == null)
                    {
                        return j;
                    }
                } else
                {
                    i = j;
                    if (obj.equals(obj1))
                    {
                        return j;
                    }
                }
            } else
            {
                return -1;
            }
        } while (true);
    }

    public final ListIterator listIterator()
    {
        return getIterator(0);
    }

    public final ListIterator listIterator(int i)
    {
        return getIterator(i);
    }

    protected int nextIndex(int i)
    {
        return getIndexDifference(i, startPos());
    }

    public final int nextIndex(SeqPosition seqposition)
    {
        return nextIndex(seqposition.ipos);
    }

    public int nextMatching(int i, ItemPredicate itempredicate, int j, boolean flag)
    {
        if (flag)
        {
            throw unsupported("nextMatching with descend");
        }
        int k;
        do
        {
            if (compare(i, j) >= 0)
            {
                return 0;
            }
            k = nextPos(i);
            i = k;
        } while (!itempredicate.isInstancePos(this, k));
        return k;
    }

    public int nextPos(int i)
    {
        if (!hasNext(i))
        {
            return 0;
        } else
        {
            int j = createRelativePos(i, 1, true);
            releasePos(i);
            return j;
        }
    }

    public int parentPos(int i)
    {
        return endPos();
    }

    public int previousPos(int i)
    {
        if (!hasPrevious(i))
        {
            return 0;
        } else
        {
            int j = createRelativePos(i, -1, false);
            releasePos(i);
            return j;
        }
    }

    public int rank()
    {
        return 1;
    }

    protected void releasePos(int i)
    {
    }

    public Object remove(int i)
    {
        if (i < 0 || i >= size())
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            i = createPos(i, false);
            Object obj = getPosNext(i);
            removePos(i, 1);
            releasePos(i);
            return obj;
        }
    }

    public boolean remove(Object obj)
    {
        int i = indexOf(obj);
        if (i < 0)
        {
            return false;
        } else
        {
            i = createPos(i, false);
            removePos(i, 1);
            releasePos(i);
            return true;
        }
    }

    public boolean removeAll(Collection collection)
    {
        boolean flag = false;
        int i = startPos();
        do
        {
            int j = nextPos(i);
            if (j == 0)
            {
                break;
            }
            i = j;
            if (collection.contains(getPosPrevious(j)))
            {
                removePos(j, -1);
                flag = true;
                i = j;
            }
        } while (true);
        return flag;
    }

    public void removePos(int i, int j)
    {
        int k = createRelativePos(i, j, false);
        if (j >= 0)
        {
            removePosRange(i, k);
        } else
        {
            removePosRange(k, i);
        }
        releasePos(k);
    }

    protected void removePosRange(int i, int j)
    {
        throw unsupported("removePosRange");
    }

    public boolean retainAll(Collection collection)
    {
        boolean flag = false;
        int i = startPos();
        do
        {
            int j = nextPos(i);
            if (j == 0)
            {
                break;
            }
            i = j;
            if (!collection.contains(getPosPrevious(j)))
            {
                removePos(j, -1);
                flag = true;
                i = j;
            }
        } while (true);
        return flag;
    }

    public Object set(int i, Object obj)
    {
        throw unsupported("set");
    }

    public Object set(int ai[], Object obj)
    {
        return set(ai[0], obj);
    }

    protected void setPosNext(int i, Object obj)
    {
        i = nextIndex(i);
        if (i >= size())
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            set(i, obj);
            return;
        }
    }

    protected void setPosPrevious(int i, Object obj)
    {
        i = nextIndex(i);
        if (i == 0)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            set(i - 1, obj);
            return;
        }
    }

    public abstract int size();

    public int stableCompare(AbstractSequence abstractsequence)
    {
        int i = System.identityHashCode(this);
        int j = System.identityHashCode(abstractsequence);
        if (i < j)
        {
            return -1;
        }
        return i <= j ? 0 : 1;
    }

    public int startPos()
    {
        return 0;
    }

    public List subList(int i, int j)
    {
        return subSequencePos(createPos(i, false), createPos(j, true));
    }

    public Sequence subSequence(SeqPosition seqposition, SeqPosition seqposition1)
    {
        return subSequencePos(seqposition.ipos, seqposition1.ipos);
    }

    protected Sequence subSequencePos(int i, int j)
    {
        return new SubSequence(this, i, j);
    }

    public Object[] toArray()
    {
        Object aobj[] = new Object[size()];
        int j = startPos();
        int i = 0;
        do
        {
            j = nextPos(j);
            if (j != 0)
            {
                aobj[i] = getPosPrevious(j);
                i++;
            } else
            {
                return aobj;
            }
        } while (true);
    }

    public Object[] toArray(Object aobj[])
    {
        int j = aobj.length;
        int l = size();
        int i = j;
        Object aobj1[] = aobj;
        if (l > j)
        {
            aobj1 = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), l);
            i = l;
        }
        int k = startPos();
        j = 0;
        do
        {
            k = nextPos(k);
            if (k == 0)
            {
                break;
            }
            aobj1[j] = getPosPrevious(k);
            j++;
        } while (true);
        if (l < i)
        {
            aobj1[l] = null;
        }
        return aobj1;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(100);
        if (this instanceof Sequence)
        {
            stringbuffer.append('[');
        }
        toString(", ", stringbuffer);
        if (this instanceof Sequence)
        {
            stringbuffer.append(']');
        }
        return stringbuffer.toString();
    }

    public void toString(String s, StringBuffer stringbuffer)
    {
        boolean flag = false;
        int i = startPos();
        do
        {
            i = nextPos(i);
            if (i != 0)
            {
                if (flag)
                {
                    stringbuffer.append(s);
                } else
                {
                    flag = true;
                }
                stringbuffer.append(getPosPrevious(i));
            } else
            {
                return;
            }
        } while (true);
    }

    protected RuntimeException unsupported(String s)
    {
        return unsupportedException((new StringBuilder()).append(getClass().getName()).append(" does not implement ").append(s).toString());
    }
}
