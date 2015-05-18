// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            ByteVector, Sequence, Convert

public class U8Vector extends ByteVector
{

    public U8Vector()
    {
        data = ByteVector.empty;
    }

    public U8Vector(int i)
    {
        data = new byte[i];
        size = i;
    }

    public U8Vector(int i, byte byte0)
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

    public U8Vector(Sequence sequence)
    {
        data = new byte[sequence.size()];
        addAll(sequence);
    }

    public U8Vector(byte abyte0[])
    {
        data = abyte0;
        size = abyte0.length;
    }

    public int compareTo(Object obj)
    {
        return compareToInt(this, (U8Vector)obj);
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

    public final Object getBuffer(int i)
    {
        return Convert.toObjectUnsigned(data[i]);
    }

    public int getElementKind()
    {
        return 17;
    }

    public String getTag()
    {
        return "u8";
    }

    public final int intAtBuffer(int i)
    {
        return data[i] & 0xff;
    }

    public Object setBuffer(int i, Object obj)
    {
        byte byte0 = data[i];
        data[i] = Convert.toByteUnsigned(obj);
        return Convert.toObjectUnsigned(byte0);
    }
}
