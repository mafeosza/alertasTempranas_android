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

public class F32Vector extends SimpleVector
    implements Externalizable, Comparable
{

    protected static float empty[] = new float[0];
    float data[];

    public F32Vector()
    {
        data = empty;
    }

    public F32Vector(int i)
    {
        data = new float[i];
        size = i;
    }

    public F32Vector(int i, float f)
    {
        float af[] = new float[i];
        data = af;
        size = i;
        do
        {
            i--;
            if (i >= 0)
            {
                af[i] = f;
            } else
            {
                return;
            }
        } while (true);
    }

    public F32Vector(Sequence sequence)
    {
        data = new float[sequence.size()];
        addAll(sequence);
    }

    public F32Vector(float af[])
    {
        data = af;
        size = af.length;
    }

    protected void clearBuffer(int i, int j)
    {
        do
        {
            j--;
            if (j >= 0)
            {
                data[i] = 0.0F;
                i++;
            } else
            {
                return;
            }
        } while (true);
    }

    public int compareTo(Object obj)
    {
        obj = (F32Vector)obj;
        float af[] = data;
        float af1[] = ((F32Vector) (obj)).data;
        int k = size;
        int l = ((F32Vector) (obj)).size;
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
            float f = af[j];
            float f1 = af1[j];
            if (f != f1)
            {
                return f <= f1 ? -1 : 1;
            }
        }

        return k - l;
    }

    public boolean consumeNext(int i, Consumer consumer)
    {
        i >>>= 1;
        if (i >= size)
        {
            return false;
        } else
        {
            consumer.writeFloat(data[i]);
            return true;
        }
    }

    public void consumePosRange(int i, int j, Consumer consumer)
    {
        if (!consumer.ignoring())
        {
            i >>>= 1;
            while (i < j >>> 1) 
            {
                consumer.writeFloat(data[i]);
                i++;
            }
        }
    }

    public final float floatAt(int i)
    {
        if (i >= size)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return data[i];
        }
    }

    public final float floatAtBuffer(int i)
    {
        return data[i];
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
        return 25;
    }

    public String getTag()
    {
        return "f32";
    }

    public final int intAtBuffer(int i)
    {
        return (int)data[i];
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        int j = objectinput.readInt();
        float af[] = new float[j];
        for (int i = 0; i < j; i++)
        {
            af[i] = objectinput.readFloat();
        }

        data = af;
        size = j;
    }

    public final Object setBuffer(int i, Object obj)
    {
        Object obj1 = Convert.toObject(data[i]);
        data[i] = Convert.toFloat(obj);
        return obj1;
    }

    public void setBufferLength(int i)
    {
        int j = data.length;
        if (j != i)
        {
            float af[] = new float[i];
            float af1[] = data;
            if (j < i)
            {
                i = j;
            }
            System.arraycopy(af1, 0, af, 0, i);
            data = af;
        }
    }

    public final void setFloatAt(int i, float f)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            data[i] = f;
            return;
        }
    }

    public final void setFloatAtBuffer(int i, float f)
    {
        data[i] = f;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        int j = size;
        objectoutput.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            objectoutput.writeFloat(data[i]);
        }

    }

}
