// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            ByteVector, Sequence, Convert

public class S8Vector extends ByteVector
{

    public S8Vector()
    {
        data = ByteVector.empty;
    }

    public S8Vector(int i)
    {
        data = new byte[i];
        size = i;
    }

    public S8Vector(int i, byte byte0)
    {
        byte abyte0[] = new byte[i];
        data = abyte0;
        size = i;
        do
        {
            i--;
            if (i >= 0)
            {
                abyte0[i] = byte0;
            } else
            {
                return;
            }
        } while (true);
    }

    public S8Vector(Sequence sequence)
    {
        data = new byte[sequence.size()];
        addAll(sequence);
    }

    public S8Vector(byte abyte0[])
    {
        data = abyte0;
        size = abyte0.length;
    }

    public int compareTo(Object obj)
    {
        return compareToInt(this, (S8Vector)obj);
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

    public final Object getBuffer(int i)
    {
        return Convert.toObject(data[i]);
    }

    public int getElementKind()
    {
        return 18;
    }

    public String getTag()
    {
        return "s8";
    }

    public final int intAtBuffer(int i)
    {
        return data[i];
    }

    public Object setBuffer(int i, Object obj)
    {
        byte byte0 = data[i];
        data[i] = Convert.toByte(obj);
        return Convert.toObject(byte0);
    }
}
