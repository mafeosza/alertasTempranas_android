// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package gnu.lists:
//            ExtSequence, Sequence, Pair, Consumer, 
//            LListPosition, PositionManager, SeqPosition

public class LList extends ExtSequence
    implements Sequence, Externalizable, Comparable
{

    public static final LList Empty = new LList();

    public LList()
    {
    }

    public static Pair chain1(Pair pair, Object obj)
    {
        obj = new Pair(obj, Empty);
        pair.cdr = obj;
        return ((Pair) (obj));
    }

    public static Pair chain4(Pair pair, Object obj, Object obj1, Object obj2, Object obj3)
    {
        obj3 = new Pair(obj3, Empty);
        pair.cdr = new Pair(obj, new Pair(obj1, new Pair(obj2, obj3)));
        return ((Pair) (obj3));
    }

    public static Object checkNonList(Object obj)
    {
        Object obj1 = obj;
        if (obj instanceof LList)
        {
            obj1 = "#<not a pair>";
        }
        return obj1;
    }

    public static Object consX(Object aobj[])
    {
        Object obj = aobj[0];
        int j = aobj.length - 1;
        if (j <= 0)
        {
            return obj;
        }
        Pair pair = new Pair(obj, null);
        obj = pair;
        for (int i = 1; i < j; i++)
        {
            Pair pair1 = new Pair(aobj[i], null);
            obj.cdr = pair1;
            obj = pair1;
        }

        obj.cdr = aobj[j];
        return pair;
    }

    public static final int length(Object obj)
    {
        int i = 0;
        for (; obj instanceof Pair; obj = ((Pair)obj).cdr)
        {
            i++;
        }

        return i;
    }

    public static Pair list1(Object obj)
    {
        return new Pair(obj, Empty);
    }

    public static Pair list2(Object obj, Object obj1)
    {
        return new Pair(obj, new Pair(obj1, Empty));
    }

    public static Pair list3(Object obj, Object obj1, Object obj2)
    {
        return new Pair(obj, new Pair(obj1, new Pair(obj2, Empty)));
    }

    public static Pair list4(Object obj, Object obj1, Object obj2, Object obj3)
    {
        return new Pair(obj, new Pair(obj1, new Pair(obj2, new Pair(obj3, Empty))));
    }

    public static int listLength(Object obj, boolean flag)
    {
        int i = 0;
        Object obj1 = obj;
        do
        {
            if (obj == Empty)
            {
                return i;
            }
            if (!(obj instanceof Pair))
            {
                if ((obj instanceof Sequence) && flag)
                {
                    int k = ((Sequence)obj).size();
                    int j = k;
                    if (k >= 0)
                    {
                        j = k + i;
                    }
                    return j;
                } else
                {
                    return -2;
                }
            }
            Pair pair = (Pair)obj;
            if (pair.cdr == Empty)
            {
                return i + 1;
            }
            if (obj == obj1 && i > 0)
            {
                return -1;
            }
            if (!(pair.cdr instanceof Pair))
            {
                i++;
                obj = pair.cdr;
            } else
            {
                if (!(obj1 instanceof Pair))
                {
                    return -2;
                }
                obj1 = ((Pair)obj1).cdr;
                obj = ((Pair)pair.cdr).cdr;
                i += 2;
            }
        } while (true);
    }

    public static Object listTail(Object obj, int i)
    {
        do
        {
            i--;
            if (i >= 0)
            {
                if (!(obj instanceof Pair))
                {
                    throw new IndexOutOfBoundsException("List is too short.");
                }
                obj = ((Pair)obj).cdr;
            } else
            {
                return obj;
            }
        } while (true);
    }

    public static LList makeList(List list)
    {
        Iterator iterator = list.iterator();
        Object obj = Empty;
        List list5 = null;
        while (iterator.hasNext()) 
        {
            list = new Pair(iterator.next(), Empty);
            if (list5 == null)
            {
                obj = list;
            } else
            {
                list5.cdr = list;
            }
            list5 = list;
        }
        return ((LList) (obj));
    }

    public static LList makeList(Object aobj[], int i)
    {
        Object obj = Empty;
        int j = aobj.length - i;
        do
        {
            j--;
            if (j >= 0)
            {
                obj = new Pair(aobj[i + j], obj);
            } else
            {
                return ((LList) (obj));
            }
        } while (true);
    }

    public static LList makeList(Object aobj[], int i, int j)
    {
        Object obj = Empty;
        do
        {
            j--;
            if (j >= 0)
            {
                obj = new Pair(aobj[i + j], obj);
            } else
            {
                return ((LList) (obj));
            }
        } while (true);
    }

    public static LList reverseInPlace(Object obj)
    {
        Object obj2 = Empty;
        Object obj1 = obj;
        for (obj = obj2; obj1 != Empty; obj = obj2)
        {
            obj2 = (Pair)obj1;
            obj1 = ((Pair) (obj2)).cdr;
            obj2.cdr = obj;
        }

        return ((LList) (obj));
    }

    public int compareTo(Object obj)
    {
        return obj != Empty ? -1 : 0;
    }

    public void consume(Consumer consumer)
    {
        Object obj = this;
        consumer.startElement("list");
        for (; obj instanceof Pair; obj = ((Pair) (obj)).cdr)
        {
            if (obj != this)
            {
                consumer.write(32);
            }
            obj = (Pair)obj;
            consumer.writeObject(((Pair) (obj)).car);
        }

        if (obj != Empty)
        {
            consumer.write(32);
            consumer.write(". ");
            consumer.writeObject(checkNonList(obj));
        }
        consumer.endElement();
    }

    public int createPos(int i, boolean flag)
    {
        LListPosition llistposition = new LListPosition(this, i, flag);
        return PositionManager.manager.register(llistposition);
    }

    public int createRelativePos(int i, int j, boolean flag)
    {
        boolean flag1 = isAfterPos(i);
        if (j < 0 || i == 0)
        {
            return super.createRelativePos(i, j, flag);
        }
        if (j == 0)
        {
            if (flag == flag1)
            {
                return copyPos(i);
            }
            if (flag && !flag1)
            {
                return super.createRelativePos(i, j, flag);
            }
        }
        if (i < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        Object obj = (LListPosition)PositionManager.getPositionObject(i);
        if (((LListPosition) (obj)).xpos == null)
        {
            return super.createRelativePos(i, j, flag);
        }
        LListPosition llistposition = new LListPosition(((LListPosition) (obj)));
        Object obj1 = llistposition.xpos;
        int l = llistposition.ipos;
        i = l;
        int k = j;
        if (flag)
        {
            i = l;
            k = j;
            if (!flag1)
            {
                k = j - 1;
                i = l + 3;
            }
        }
        j = i;
        obj = obj1;
        l = k;
        if (!flag)
        {
            j = i;
            obj = obj1;
            l = k;
            if (flag1)
            {
                l = k + 1;
                j = i - 3;
                obj = obj1;
            }
        }
        do
        {
            if (!(obj instanceof Pair))
            {
                throw new IndexOutOfBoundsException();
            }
            l--;
            if (l < 0)
            {
                llistposition.ipos = j;
                llistposition.xpos = obj;
                return PositionManager.manager.register(llistposition);
            }
            obj = (Pair)obj;
            j += 2;
            obj = ((Pair) (obj)).cdr;
        } while (true);
    }

    public boolean equals(Object obj)
    {
        return this == obj;
    }

    public Object get(int i)
    {
        throw new IndexOutOfBoundsException();
    }

    public SeqPosition getIterator(int i)
    {
        return new LListPosition(this, i, false);
    }

    public Object getPosNext(int i)
    {
        return eofValue;
    }

    public Object getPosPrevious(int i)
    {
        return eofValue;
    }

    public boolean hasNext(int i)
    {
        return false;
    }

    public boolean isEmpty()
    {
        return true;
    }

    public int nextPos(int i)
    {
        return 0;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        return Empty;
    }

    protected void setPosNext(int i, Object obj)
    {
        if (i <= 0)
        {
            if (i == -1 || !(this instanceof Pair))
            {
                throw new IndexOutOfBoundsException();
            } else
            {
                ((Pair)this).car = obj;
                return;
            }
        } else
        {
            PositionManager.getPositionObject(i).setNext(obj);
            return;
        }
    }

    protected void setPosPrevious(int i, Object obj)
    {
        if (i <= 0)
        {
            if (i == 0 || !(this instanceof Pair))
            {
                throw new IndexOutOfBoundsException();
            } else
            {
                ((Pair)this).lastPair().car = obj;
                return;
            }
        } else
        {
            PositionManager.getPositionObject(i).setPrevious(obj);
            return;
        }
    }

    public int size()
    {
        return 0;
    }

    public String toString()
    {
        Object obj;
        StringBuffer stringbuffer;
        int i;
        obj = this;
        i = 0;
        stringbuffer = new StringBuffer(100);
        stringbuffer.append('(');
_L1:
        if (obj != Empty)
        {
label0:
            {
                if (i > 0)
                {
                    stringbuffer.append(' ');
                }
                if (i < 10)
                {
                    break label0;
                }
                stringbuffer.append("...");
            }
        }
_L2:
        stringbuffer.append(')');
        return stringbuffer.toString();
label1:
        {
            if (!(obj instanceof Pair))
            {
                break label1;
            }
            obj = (Pair)obj;
            stringbuffer.append(((Pair) (obj)).car);
            obj = ((Pair) (obj)).cdr;
            i++;
        }
          goto _L1
        stringbuffer.append(". ");
        stringbuffer.append(checkNonList(obj));
          goto _L2
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
    }

}
