// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

// Referenced classes of package gnu.lists:
//            SimpleVector, Consumable, Consumer

public class FVector extends SimpleVector
    implements Externalizable, Consumable, Comparable
{

    protected static Object empty[] = new Object[0];
    public Object data[];

    public FVector()
    {
        data = empty;
    }

    public FVector(int i)
    {
        size = i;
        data = new Object[i];
    }

    public FVector(int i, Object obj)
    {
        Object aobj[] = new Object[i];
        if (obj != null)
        {
            for (int j = 0; j < i; j++)
            {
                aobj[j] = obj;
            }

        }
        data = aobj;
        size = i;
    }

    public FVector(List list)
    {
        data = new Object[list.size()];
        addAll(list);
    }

    public FVector(Object aobj[])
    {
        size = aobj.length;
        data = aobj;
    }

    public static transient FVector make(Object aobj[])
    {
        return new FVector(aobj);
    }

    protected void clearBuffer(int i, int j)
    {
        Object aobj[] = data;
        do
        {
            j--;
            if (j >= 0)
            {
                aobj[i] = null;
                i++;
            } else
            {
                return;
            }
        } while (true);
    }

    public int compareTo(Object obj)
    {
        obj = (FVector)obj;
        Object aobj[] = data;
        Object aobj1[] = ((FVector) (obj)).data;
        int k = size;
        int l = ((FVector) (obj)).size;
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
            int i1 = ((Comparable)aobj[j]).compareTo((Comparable)aobj1[j]);
            if (i1 != 0)
            {
                return i1;
            }
        }

        return k - l;
    }

    public void consume(Consumer consumer)
    {
        consumer.startElement("#vector");
        int j = size;
        for (int i = 0; i < j; i++)
        {
            consumer.writeObject(data[i]);
        }

        consumer.endElement();
    }

    public boolean consumeNext(int i, Consumer consumer)
    {
        i >>>= 1;
        if (i >= size)
        {
            return false;
        } else
        {
            consumer.writeObject(data[i]);
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
                consumer.writeObject(data[j]);
                j++;
            }
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof FVector)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        FVector fvector = (FVector)obj;
        int j = size;
        if (fvector.data != null && fvector.size == j)
        {
            obj = ((Object) (data));
            Object aobj[] = fvector.data;
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= j)
                    {
                        break label1;
                    }
                    if (!obj[i].equals(aobj[i]))
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public final Object get(int i)
    {
        if (i >= size)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return data[i];
        }
    }

    protected Object getBuffer()
    {
        return ((Object) (data));
    }

    public final Object getBuffer(int i)
    {
        return data[i];
    }

    public int getBufferLength()
    {
        return data.length;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        int j = objectinput.readInt();
        Object aobj[] = new Object[j];
        for (int i = 0; i < j; i++)
        {
            aobj[i] = objectinput.readObject();
        }

        size = j;
        data = aobj;
    }

    public final void setAll(Object obj)
    {
        Object aobj[] = data;
        int i = size;
        do
        {
            i--;
            if (i >= 0)
            {
                aobj[i] = obj;
            } else
            {
                return;
            }
        } while (true);
    }

    public final Object setBuffer(int i, Object obj)
    {
        Object obj1 = data[i];
        data[i] = obj;
        return obj1;
    }

    public void setBufferLength(int i)
    {
        int j = data.length;
        if (j != i)
        {
            Object aobj[] = new Object[i];
            Object aobj1[] = data;
            if (j < i)
            {
                i = j;
            }
            System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj)), 0, i);
            data = aobj;
        }
    }

    public void shift(int i, int j, int k)
    {
        System.arraycopy(((Object) (data)), i, ((Object) (data)), j, k);
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        int j = size;
        objectoutput.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            objectoutput.writeObject(data[i]);
        }

    }

}
