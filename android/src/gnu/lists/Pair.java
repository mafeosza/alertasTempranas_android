// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

// Referenced classes of package gnu.lists:
//            LList, Sequence, PositionManager, SeqPosition, 
//            LListPosition

public class Pair extends LList
    implements Externalizable
{

    protected Object car;
    protected Object cdr;

    public Pair()
    {
    }

    public Pair(Object obj, Object obj1)
    {
        car = obj;
        cdr = obj1;
    }

    public static int compareTo(Pair pair, Pair pair1)
    {
        if (pair != pair1) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        return i;
_L2:
        Pair pair2;
        if (pair == null)
        {
            return -1;
        }
        pair2 = pair;
        pair = pair1;
        if (pair1 == null)
        {
            return 1;
        }
_L5:
        pair1 = ((Pair) (pair2.car));
        Object obj = pair.car;
        int j = ((Comparable)pair1).compareTo((Comparable)obj);
        i = j;
        if (j != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        pair1 = ((Pair) (pair2.cdr));
        pair = ((Pair) (pair.cdr));
        if (pair1 == pair)
        {
            return 0;
        }
        if (pair1 == null)
        {
            return -1;
        }
        if (pair == null)
        {
            return 1;
        }
        if (!(pair1 instanceof Pair) || !(pair instanceof Pair))
        {
            return ((Comparable)pair1).compareTo((Comparable)pair);
        }
        if (true) goto _L4; else goto _L3
_L4:
        pair2 = (Pair)pair1;
        pair = (Pair)pair;
        if (true) goto _L5; else goto _L3
_L3:
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static boolean equals(Pair pair, Pair pair1)
    {
        if (pair != pair1) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (pair == null) goto _L4; else goto _L3
_L3:
        Pair pair2;
        pair2 = pair;
        pair = pair1;
        if (pair1 != null) goto _L5; else goto _L4
_L4:
        return false;
_L7:
        pair2 = (Pair)pair1;
        pair = (Pair)pair;
_L5:
        pair1 = ((Pair) (pair2.car));
        Object obj = pair.car;
        if (pair1 != obj && (pair1 == null || !pair1.equals(obj)))
        {
            return false;
        }
        pair1 = ((Pair) (pair2.cdr));
        pair = ((Pair) (pair.cdr));
        if (pair1 == pair)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (pair1 == null || pair == null)
        {
            return false;
        }
        if (!(pair1 instanceof Pair) || !(pair instanceof Pair))
        {
            return pair1.equals(pair);
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (true) goto _L1; else goto _L8
_L8:
    }

    public static Pair make(Object obj, Object obj1)
    {
        return new Pair(obj, obj1);
    }

    public int compareTo(Object obj)
    {
        if (obj == Empty)
        {
            return 1;
        } else
        {
            return compareTo(this, (Pair)obj);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof Pair))
        {
            return equals(this, (Pair)obj);
        } else
        {
            return false;
        }
    }

    public Object get(int i)
    {
        Pair pair;
        int j;
label0:
        {
            pair = this;
            do
            {
                j = i;
                if (i <= 0)
                {
                    break label0;
                }
                i--;
                if (!(pair.cdr instanceof Pair))
                {
                    break;
                }
                pair = (Pair)pair.cdr;
            } while (true);
            j = i;
            if (pair.cdr instanceof Sequence)
            {
                return ((Sequence)pair.cdr).get(i);
            }
        }
        if (j == 0)
        {
            return pair.car;
        } else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object getCar()
    {
        return car;
    }

    public Object getCdr()
    {
        return cdr;
    }

    public Object getPosNext(int i)
    {
        if (i <= 0)
        {
            if (i == 0)
            {
                return car;
            } else
            {
                return eofValue;
            }
        } else
        {
            return PositionManager.getPositionObject(i).getNext();
        }
    }

    public Object getPosPrevious(int i)
    {
        if (i <= 0)
        {
            if (i == 0)
            {
                return eofValue;
            } else
            {
                return lastPair().car;
            }
        } else
        {
            return PositionManager.getPositionObject(i).getPrevious();
        }
    }

    public boolean hasNext(int i)
    {
        if (i <= 0)
        {
            return i == 0;
        } else
        {
            return PositionManager.getPositionObject(i).hasNext();
        }
    }

    public int hashCode()
    {
        int i = 1;
        Object obj = this;
        while (obj instanceof Pair) 
        {
            obj = (Pair)obj;
            Object obj1 = ((Pair) (obj)).car;
            int j;
            if (obj1 == null)
            {
                j = 0;
            } else
            {
                j = obj1.hashCode();
            }
            i = i * 31 + j;
            obj = ((Pair) (obj)).cdr;
        }
        int k = i;
        if (obj != LList.Empty)
        {
            k = i;
            if (obj != null)
            {
                k = i ^ obj.hashCode();
            }
        }
        return k;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public final Pair lastPair()
    {
        Pair pair = this;
        do
        {
            Object obj = pair.cdr;
            if (obj instanceof Pair)
            {
                pair = (Pair)obj;
            } else
            {
                return pair;
            }
        } while (true);
    }

    public int length()
    {
        int i = 0;
        Object obj = this;
        Object obj1 = this;
        do
        {
            if (obj == Empty)
            {
                return i;
            }
            if (!(obj instanceof Pair))
            {
                if (obj instanceof Sequence)
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

    public int nextPos(int i)
    {
        if (i <= 0)
        {
            if (i < 0)
            {
                return 0;
            } else
            {
                return PositionManager.manager.register(new LListPosition(this, 1, true));
            }
        }
        if (!((LListPosition)PositionManager.getPositionObject(i)).gotoNext())
        {
            i = 0;
        }
        return i;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        car = objectinput.readObject();
        cdr = objectinput.readObject();
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        return this;
    }

    public void setCar(Object obj)
    {
        car = obj;
    }

    public void setCdr(Object obj)
    {
        cdr = obj;
    }

    public void setCdrBackdoor(Object obj)
    {
        cdr = obj;
    }

    public int size()
    {
        int i = listLength(this, true);
        if (i >= 0)
        {
            return i;
        }
        if (i == -1)
        {
            return 0x7fffffff;
        } else
        {
            throw new RuntimeException("not a true list");
        }
    }

    public Object[] toArray()
    {
        int k = size();
        Object aobj[] = new Object[k];
        int i = 0;
        Object obj;
        for (obj = this; i < k && (obj instanceof Pair); i++)
        {
            obj = (Pair)obj;
            aobj[i] = ((Pair) (obj)).car;
            obj = (Sequence)((Pair) (obj)).cdr;
        }

        for (int j = i; j < k; j++)
        {
            aobj[j] = ((Sequence) (obj)).get(j - i);
        }

        return aobj;
    }

    public Object[] toArray(Object aobj[])
    {
        int i = aobj.length;
        int l = length();
        int k = i;
        if (l > i)
        {
            aobj = new Object[l];
            k = l;
        }
        i = 0;
        Object obj;
        for (obj = this; i < l && (obj instanceof Pair); i++)
        {
            obj = (Pair)obj;
            aobj[i] = ((Pair) (obj)).car;
            obj = (Sequence)((Pair) (obj)).cdr;
        }

        for (int j = i; j < l; j++)
        {
            aobj[j] = ((Sequence) (obj)).get(j - i);
        }

        if (l < k)
        {
            aobj[l] = null;
        }
        return aobj;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(car);
        objectoutput.writeObject(cdr);
    }
}
