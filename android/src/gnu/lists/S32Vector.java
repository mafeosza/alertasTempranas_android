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

public class S32Vector extends SimpleVector
    implements Externalizable, Comparable
{

    protected static int empty[] = new int[0];
    int data[];

    public S32Vector()
    {
        data = empty;
    }

    public S32Vector(int i)
    {
        data = new int[i];
        size = i;
    }

    public S32Vector(int i, int j)
    {
        int ai[] = new int[i];
        data = ai;
        size = i;
        do
        {
            i--;
            if (i >= 0)
            {
                ai[i] = j;
            } else
            {
                return;
            }
        } while (true);
    }

    public S32Vector(Sequence sequence)
    {
        data = new int[sequence.size()];
        addAll(sequence);
    }

    public S32Vector(int ai[])
    {
        data = ai;
        size = ai.length;
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
        return compareToInt(this, (S32Vector)obj);
    }

    public boolean consumeNext(int i, Consumer consumer)
    {
        i >>>= 1;
        if (i >= size)
        {
            return false;
        } else
        {
            consumer.writeInt(data[i]);
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
                consumer.writeInt(data[j]);
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
        return 22;
    }

    public String getTag()
    {
        return "s32";
    }

    public final int intAt(int i)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return data[i];
        }
    }

    public final int intAtBuffer(int i)
    {
        return data[i];
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        int j = objectinput.readInt();
        int ai[] = new int[j];
        for (int i = 0; i < j; i++)
        {
            ai[i] = objectinput.readInt();
        }

        data = ai;
        size = j;
    }

    public Object setBuffer(int i, Object obj)
    {
        int j = data[i];
        data[i] = Convert.toInt(obj);
        return Convert.toObject(j);
    }

    public void setBufferLength(int i)
    {
        int j = data.length;
        if (j != i)
        {
            int ai[] = new int[i];
            int ai1[] = data;
            if (j < i)
            {
                i = j;
            }
            System.arraycopy(ai1, 0, ai, 0, i);
            data = ai;
        }
    }

    public final void setIntAt(int i, int j)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            data[i] = j;
            return;
        }
    }

    public final void setIntAtBuffer(int i, int j)
    {
        data[i] = j;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        int j = size;
        objectoutput.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            objectoutput.writeInt(data[i]);
        }

    }

}
