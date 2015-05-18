// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.lists:
//            SimpleVector, Consumer

public abstract class ByteVector extends SimpleVector
    implements Externalizable, Comparable
{

    protected static byte empty[] = new byte[0];
    byte data[];

    public ByteVector()
    {
    }

    public final byte byteAt(int i)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return data[i];
        }
    }

    public final byte byteAtBuffer(int i)
    {
        return data[i];
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

    public boolean consumeNext(int i, Consumer consumer)
    {
        i >>>= 1;
        if (i >= size)
        {
            return false;
        } else
        {
            consumer.writeInt(intAtBuffer(i));
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
                consumer.writeInt(intAtBuffer(j));
                j++;
            }
        }
    }

    protected Object getBuffer()
    {
        return data;
    }

    public int getBufferLength()
    {
        return data.length;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        int j = objectinput.readInt();
        byte abyte0[] = new byte[j];
        for (int i = 0; i < j; i++)
        {
            abyte0[i] = objectinput.readByte();
        }

        data = abyte0;
        size = j;
    }

    public void setBufferLength(int i)
    {
        int j = data.length;
        if (j != i)
        {
            byte abyte0[] = new byte[i];
            byte abyte1[] = data;
            if (j < i)
            {
                i = j;
            }
            System.arraycopy(abyte1, 0, abyte0, 0, i);
            data = abyte0;
        }
    }

    public final void setByteAt(int i, byte byte0)
    {
        if (i > size)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            data[i] = byte0;
            return;
        }
    }

    public final void setByteAtBuffer(int i, byte byte0)
    {
        data[i] = byte0;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        int j = size;
        objectoutput.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            objectoutput.writeByte(data[i]);
        }

    }

}
