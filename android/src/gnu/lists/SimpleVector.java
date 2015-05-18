// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package gnu.lists:
//            AbstractSequence, Sequence, Array, Consumer, 
//            Convert, GeneralArray

public abstract class SimpleVector extends AbstractSequence
    implements Sequence, Array
{

    public int size;

    public SimpleVector()
    {
    }

    protected static int compareToInt(SimpleVector simplevector, SimpleVector simplevector1)
    {
        int k = simplevector.size;
        int l = simplevector1.size;
        int i;
        int j;
        if (k > l)
        {
            i = l;
        } else
        {
            i = k;
        }
        for (j = 0; j < i; j++)
        {
            int i1 = simplevector.intAtBuffer(j);
            int j1 = simplevector1.intAtBuffer(j);
            if (11 != j1)
            {
                return i1 <= j1 ? -1 : 1;
            }
        }

        return k - l;
    }

    protected static int compareToLong(SimpleVector simplevector, SimpleVector simplevector1)
    {
        int k = simplevector.size;
        int l = simplevector1.size;
        int i;
        int j;
        if (k > l)
        {
            i = l;
        } else
        {
            i = k;
        }
        for (j = 0; j < i; j++)
        {
            long l1 = simplevector.longAtBuffer(j);
            long l2 = simplevector1.longAtBuffer(j);
            if (l1 != l2)
            {
                return l1 <= l2 ? -1 : 1;
            }
        }

        return k - l;
    }

    public void add(int i, Object obj)
    {
        int j = 16;
        int k = size + 1;
        size = k;
        int l = getBufferLength();
        if (k > l)
        {
            if (l >= 16)
            {
                j = l * 2;
            }
            setBufferLength(j);
        }
        size = k;
        if (size != i)
        {
            shift(i, i + 1, size - i);
        }
        set(i, obj);
    }

    public boolean add(Object obj)
    {
        add(size, obj);
        return true;
    }

    public boolean addAll(int i, Collection collection)
    {
        boolean flag = false;
        int j = collection.size();
        setSize(size + j);
        shift(i, i + j, size - j - i);
        for (collection = collection.iterator(); collection.hasNext();)
        {
            set(i, collection.next());
            flag = true;
            i++;
        }

        return flag;
    }

    protected int addPos(int i, Object obj)
    {
        i >>>= 1;
        add(i, obj);
        return (i << 1) + 3;
    }

    public void clear()
    {
        setSize(0);
    }

    protected abstract void clearBuffer(int i, int j);

    public void consume(int i, int j, Consumer consumer)
    {
        consumePosRange(i << 1, i + j << 1, consumer);
    }

    public boolean consumeNext(int i, Consumer consumer)
    {
        i >>>= 1;
        if (i >= size)
        {
            return false;
        } else
        {
            consumer.writeObject(getBuffer(i));
            return true;
        }
    }

    public void consumePosRange(int i, int j, Consumer consumer)
    {
        if (!consumer.ignoring())
        {
            int k = i >>> 1;
            int l = j >>> 1;
            i = l;
            j = k;
            if (l > size)
            {
                i = size;
                j = k;
            }
            while (j < i) 
            {
                consumer.writeObject(getBuffer(j));
                j++;
            }
        }
    }

    public int createPos(int i, boolean flag)
    {
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag1 | i << 1;
    }

    public void fill(int i, int j, Object obj)
    {
        if (i < 0 || j > size)
        {
            throw new IndexOutOfBoundsException();
        }
        for (; i < j; i++)
        {
            setBuffer(i, obj);
        }

    }

    public void fill(Object obj)
    {
        int i = size;
        do
        {
            i--;
            if (i >= 0)
            {
                setBuffer(i, obj);
            } else
            {
                return;
            }
        } while (true);
    }

    public void fillPosRange(int i, int j, Object obj)
    {
        if (i == -1)
        {
            i = size;
        } else
        {
            i >>>= 1;
        }
        if (j == -1)
        {
            j = size;
        } else
        {
            j >>>= 1;
        }
        for (; i < j; i++)
        {
            setBuffer(i, obj);
        }

    }

    public Object get(int i)
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return getBuffer(i);
        }
    }

    protected abstract Object getBuffer();

    protected abstract Object getBuffer(int i);

    public abstract int getBufferLength();

    public int getElementKind()
    {
        return 32;
    }

    public int getNextKind(int i)
    {
        if (hasNext(i))
        {
            return getElementKind();
        } else
        {
            return 0;
        }
    }

    public Object getPosNext(int i)
    {
        i >>>= 1;
        if (i >= size)
        {
            return eofValue;
        } else
        {
            return getBuffer(i);
        }
    }

    public Object getRowMajor(int i)
    {
        return get(i);
    }

    public String getTag()
    {
        return null;
    }

    public int intAt(int i)
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return intAtBuffer(i);
        }
    }

    public int intAtBuffer(int i)
    {
        return Convert.toInt(getBuffer(i));
    }

    protected boolean isAfterPos(int i)
    {
        return (i & 1) != 0;
    }

    public long longAt(int i)
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return longAtBuffer(i);
        }
    }

    public long longAtBuffer(int i)
    {
        return Convert.toLong(getBuffer(i));
    }

    protected int nextIndex(int i)
    {
        if (i == -1)
        {
            return size;
        } else
        {
            return i >>> 1;
        }
    }

    public int nextPos(int i)
    {
        if (i != -1)
        {
            if ((i >>>= 1) != size)
            {
                return (i << 1) + 3;
            }
        }
        return 0;
    }

    public Object remove(int i)
    {
        if (i < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            Object obj = get(i);
            shift(i + 1, i, 1);
            size = size - 1;
            clearBuffer(size, 1);
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
            shift(i + 1, i, 1);
            size = size - 1;
            clearBuffer(size, 1);
            return true;
        }
    }

    public boolean removeAll(Collection collection)
    {
        boolean flag = false;
        int j = 0;
        int i = 0;
        while (i < size) 
        {
            Object obj = get(i);
            if (collection.contains(obj))
            {
                flag = true;
            } else
            {
                if (flag)
                {
                    set(j, obj);
                }
                j++;
            }
            i++;
        }
        setSize(j);
        return flag;
    }

    public void removePos(int i, int j)
    {
        int k = i >>> 1;
        i = k;
        if (k > size)
        {
            i = size;
        }
        if (j >= 0)
        {
            k = i;
            i += j;
        } else
        {
            k = i + j;
            j = -j;
        }
        if (k < 0 || i >= size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            shift(i, k, size - i);
            size = size - j;
            clearBuffer(size, j);
            return;
        }
    }

    protected void removePosRange(int i, int j)
    {
        int k = i >>> 1;
        j >>>= 1;
        if (k >= j)
        {
            return;
        }
        i = j;
        if (j > size)
        {
            i = size;
        }
        shift(i, k, size - i);
        i -= k;
        size = size - i;
        clearBuffer(size, i);
    }

    protected void resizeShift(int i, int j, int k, int l)
    {
        int i1 = l - k;
        int j1 = getBufferLength();
        int k1 = (j1 - (j - i)) + i1;
        if (k1 > j1)
        {
            setBufferLength(k1);
            size = k1;
        }
        int l1 = i - k;
        if (l1 >= 0)
        {
            i = j1 - j;
            shift(j, k1 - i, i);
            if (l1 > 0)
            {
                shift(k, l, l1);
            }
        } else
        {
            k1 -= l;
            shift(j1 - k1, l, k1);
            shift(j, i, k - i);
        }
        clearBuffer(k, i1);
    }

    public boolean retainAll(Collection collection)
    {
        boolean flag = false;
        int j = 0;
        int i = 0;
        while (i < size) 
        {
            Object obj = get(i);
            if (!collection.contains(obj))
            {
                flag = true;
            } else
            {
                if (flag)
                {
                    set(j, obj);
                }
                j++;
            }
            i++;
        }
        setSize(j);
        return flag;
    }

    public Object set(int i, Object obj)
    {
        if (i >= size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            Object obj1 = getBuffer(i);
            setBuffer(i, obj);
            return obj1;
        }
    }

    protected abstract Object setBuffer(int i, Object obj);

    public abstract void setBufferLength(int i);

    public void setSize(int i)
    {
        int j = 16;
        int k = size;
        size = i;
        if (i < k)
        {
            clearBuffer(i, k - i);
        } else
        {
            int l = getBufferLength();
            if (i > l)
            {
                if (l >= 16)
                {
                    j = l * 2;
                }
                if (i <= j)
                {
                    i = j;
                }
                setBufferLength(i);
                return;
            }
        }
    }

    public void shift(int i, int j, int k)
    {
        Object obj = getBuffer();
        System.arraycopy(obj, i, obj, j, k);
    }

    public final int size()
    {
        return size;
    }

    public Array transpose(int ai[], int ai1[], int i, int ai2[])
    {
        GeneralArray generalarray = new GeneralArray();
        generalarray.strides = ai2;
        generalarray.dimensions = ai1;
        generalarray.lowBounds = ai;
        generalarray.offset = i;
        generalarray.base = this;
        generalarray.simple = false;
        return generalarray;
    }
}
