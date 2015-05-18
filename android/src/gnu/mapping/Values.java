// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package gnu.mapping:
//            Procedure

public class Values extends TreeList
    implements Printable, Externalizable
{

    public static final Values empty;
    public static final Object noArgs[];

    public Values()
    {
    }

    public Values(Object aobj[])
    {
        for (int i = 0; i < aobj.length; i++)
        {
            writeObject(aobj[i]);
        }

    }

    public static int countValues(Object obj)
    {
        if (obj instanceof Values)
        {
            return ((Values)obj).size();
        } else
        {
            return 1;
        }
    }

    public static Values make()
    {
        return new Values();
    }

    public static Object make(TreeList treelist)
    {
        return make(treelist, 0, treelist.data.length);
    }

    public static Object make(TreeList treelist, int i, int j)
    {
        int k;
label0:
        {
            if (i != j)
            {
                k = treelist.nextDataIndex(i);
                if (k > 0)
                {
                    break label0;
                }
            }
            return empty;
        }
        if (k == j || treelist.nextDataIndex(k) < 0)
        {
            return treelist.getPosNext(i << 1);
        } else
        {
            Values values1 = new Values();
            treelist.consumeIRange(i, j, values1);
            return values1;
        }
    }

    public static Object make(List list)
    {
        int i;
        if (list == null)
        {
            i = 0;
        } else
        {
            i = list.size();
        }
        if (i != 0) goto _L2; else goto _L1
_L1:
        list = empty;
_L4:
        return list;
_L2:
        if (i == 1)
        {
            return list.get(0);
        }
        Values values1 = new Values();
        Iterator iterator = list.iterator();
        do
        {
            list = values1;
            if (!iterator.hasNext())
            {
                continue;
            }
            values1.writeObject(iterator.next());
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Object make(Object aobj[])
    {
        if (aobj.length == 1)
        {
            return aobj[0];
        }
        if (aobj.length == 0)
        {
            return empty;
        } else
        {
            return new Values(aobj);
        }
    }

    public static int nextIndex(Object obj, int i)
    {
        if (obj instanceof Values)
        {
            return ((Values)obj).nextDataIndex(i);
        }
        return i != 0 ? -1 : 1;
    }

    public static Object nextValue(Object obj, int i)
    {
        Object obj1 = obj;
        if (obj instanceof Values)
        {
            obj1 = (Values)obj;
            int j = i;
            if (i >= ((Values) (obj1)).gapEnd)
            {
                j = i - (((Values) (obj1)).gapEnd - ((Values) (obj1)).gapStart);
            }
            obj1 = ((Values)obj).getPosNext(j << 1);
        }
        return obj1;
    }

    public static transient Object values(Object aobj[])
    {
        return make(aobj);
    }

    public static void writeValues(Object obj, Consumer consumer)
    {
        if (obj instanceof Values)
        {
            ((Values)obj).consume(consumer);
            return;
        } else
        {
            consumer.writeObject(obj);
            return;
        }
    }

    public Object call_with(Procedure procedure)
        throws Throwable
    {
        return procedure.applyN(toArray());
    }

    public final Object canonicalize()
    {
        Values values1 = this;
        if (gapEnd == data.length)
        {
            if (gapStart == 0)
            {
                values1 = empty;
            } else
            {
                values1 = this;
                if (nextDataIndex(0) == gapStart)
                {
                    return getPosNext(0);
                }
            }
        }
        return values1;
    }

    public Object[] getValues()
    {
        if (isEmpty())
        {
            return noArgs;
        } else
        {
            return toArray();
        }
    }

    public void print(Consumer consumer)
    {
        if (this != empty) goto _L2; else goto _L1
_L1:
        consumer.write("#!void");
_L4:
        return;
_L2:
        int i = toArray().length;
        if (true)
        {
            consumer.write("#<values");
        }
        i = 0;
        do
        {
            int k;
label0:
            {
                k = nextDataIndex(i);
                if (k >= 0)
                {
                    break label0;
                }
                if (true)
                {
                    consumer.write(62);
                    return;
                }
            }
            if (true)
            {
                continue;
            }
            consumer.write(32);
            int j = i;
            if (i >= gapEnd)
            {
                j = i - (gapEnd - gapStart);
            }
            Object obj = getPosNext(j << 1);
            if (obj instanceof Printable)
            {
                ((Printable)obj).print(consumer);
            } else
            {
                consumer.writeObject(obj);
            }
            i = k;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        int j = objectinput.readInt();
        for (int i = 0; i < j; i++)
        {
            writeObject(objectinput.readObject());
        }

    }

    public Object readResolve()
        throws ObjectStreamException
    {
        Values values1 = this;
        if (isEmpty())
        {
            values1 = empty;
        }
        return values1;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        Object aobj[] = toArray();
        int j = aobj.length;
        objectoutput.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            objectoutput.writeObject(aobj[i]);
        }

    }

    static 
    {
        noArgs = new Object[0];
        empty = new Values(noArgs);
    }
}
