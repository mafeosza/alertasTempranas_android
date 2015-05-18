// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.lists:
//            SimpleVector, S16Vector, Sequence, Consumer, 
//            Convert

public class U16Vector extends SimpleVector
    implements Externalizable, Comparable
{

    short data[];

    public U16Vector()
    {
        data = S16Vector.empty;
    }

    public U16Vector(int i)
    {
        data = new short[i];
        size = i;
    }

    public U16Vector(int i, short word0)
    {
        short aword0[] = new short[i];
        data = aword0;
        size = i;
        do
        {
            i--;
            if (i >= 0)
            {
                aword0[i] = word0;
            } else
            {
                return;
            }
        } while (true);
    }

    public U16Vector(Sequence sequence)
    {
        data = new short[sequence.size()];
        addAll(sequence);
    }

    public U16Vector(short aword0[])
    {
        data = aword0;
        size = aword0.length;
    }

    protected void clearBuffer(int i, int j)
    {
        do
        {
            j--;
            if (j >= 0)
            {
                data[i] = 0;
                i++;
            } else
            {
                return;
            }
        } while (true);
    }

    public int compareTo(Object obj)
    {
        return compareToInt(this, (U16Vector)obj);
    }

    public boolean consumeNext(int i, Consumer consumer)
    {
        i >>>= 1;
        if (i >= size)
        {
            return false;
        } else
        {
            consumer.writeInt(data[i] & 0xffff);
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
                consumer.writeInt(data[j] & 0xffff);
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
            return Convert.toObjectUnsigned(data[i]);
        }
    }

    protected Object getBuffer()
    {
        return data;
    }

    public final Object getBuffer(int i)
    {
        return Convert.toObjectUnsigned(data[i]);
    }

    public int getBufferLength()
    {
        return data.length;
    }

    public int getElementKind()
    {
        return 19;
    }

    public String getTag()
    {
        return "u16";
    }

    public final int intAtBuffer(int i)
    {
        return data[i] & 0xffff;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        int j = objectinput.readInt();
        short aword0[] = new short[j];
        for (int i = 0; i < j; i++)
        {
            aword0[i] = objectinput.readShort();
        }

        data = aword0;
        size = j;
    }

    public Object setBuffer(int i, Object obj)
    {
        short word0 = data[i];
        data[i] = Convert.toShortUnsigned(obj);
        return Convert.toObjectUnsigned(word0);
    }

    public void setBufferLength(int i)
    {
        int j = data.length;
        if (j != i)
        {
            short aword0[] = new short[i];
            short aword1[] = data;
            if (j < i)
            {
                i = j;
            }
            System.arraycopy(aword1, 0, aword0, 0, i);
            data = aword0;
        }
    }

    public final void setShortAt(int i, short word0)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            data[i] = word0;
            return;
        }
    }

    public final void setShortAtBuffer(int i, short word0)
    {
        data[i] = word0;
    }

    public final short shortAt(int i)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return data[i];
        }
    }

    public final short shortAtBuffer(int i)
    {
        return data[i];
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        int j = size;
        objectoutput.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            objectoutput.writeShort(data[i]);
        }

    }
}
