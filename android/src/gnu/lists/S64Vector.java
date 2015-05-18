// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.lists:
//            SimpleVector, Sequence, Consumer, Convert

public class S64Vector extends SimpleVector
    implements Externalizable, Comparable
{

    protected static long empty[] = new long[0];
    long data[];

    public S64Vector()
    {
        data = empty;
    }

    public S64Vector(int i)
    {
        data = new long[i];
        size = i;
    }

    public S64Vector(int i, long l)
    {
        long al[] = new long[i];
        data = al;
        size = i;
        do
        {
            i--;
            if (i >= 0)
            {
                al[i] = l;
            } else
            {
                return;
            }
        } while (true);
    }

    public S64Vector(Sequence sequence)
    {
        data = new long[sequence.size()];
        addAll(sequence);
    }

    public S64Vector(long al[])
    {
        data = al;
        size = al.length;
    }

    protected void clearBuffer(int i, int j)
    {
        do
        {
            j--;
            if (j >= 0)
            {
                data[i] = 0L;
                i++;
            } else
            {
                return;
            }
        } while (true);
    }

    public int compareTo(Object obj)
    {
        return compareToLong(this, (S64Vector)obj);
    }

    public boolean consumeNext(int i, Consumer consumer)
    {
        i >>>= 1;
        if (i >= size)
        {
            return false;
        } else
        {
            consumer.writeLong(data[i]);
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
                consumer.writeLong(data[j]);
                j++;
            }
        }
    }

    public final Object get(int i)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return Convert.toObject(data[i]);
        }
    }

    protected Object getBuffer()
    {
        return data;
    }

    public final Object getBuffer(int i)
    {
        return Convert.toObject(data[i]);
    }

    public int getBufferLength()
    {
        return data.length;
    }

    public int getElementKind()
    {
        return 24;
    }

    public String getTag()
    {
        return "s64";
    }

    public final int intAtBuffer(int i)
    {
        return (int)data[i];
    }

    public final long longAt(int i)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return data[i];
        }
    }

    public final long longAtBuffer(int i)
    {
        return data[i];
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        int j = objectinput.readInt();
        long al[] = new long[j];
        for (int i = 0; i < j; i++)
        {
            al[i] = objectinput.readLong();
        }

        data = al;
        size = j;
    }

    public Object setBuffer(int i, Object obj)
    {
        long l = data[i];
        data[i] = Convert.toLong(obj);
        return Convert.toObject(l);
    }

    public void setBufferLength(int i)
    {
        int j = data.length;
        if (j != i)
        {
            long al[] = new long[i];
            long al1[] = data;
            if (j < i)
            {
                i = j;
            }
            System.arraycopy(al1, 0, al, 0, i);
            data = al;
        }
    }

    public final void setLongAt(int i, long l)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            data[i] = l;
            return;
        }
    }

    public final void setLongAtBuffer(int i, long l)
    {
        data[i] = l;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        int j = size;
        objectoutput.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            objectoutput.writeLong(data[i]);
        }

    }

}
