// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            AbstractSequence, Array, FVector, SimpleVector, 
//            GeneralArray1

public class GeneralArray extends AbstractSequence
    implements Array
{

    static final int zeros[] = new int[8];
    SimpleVector base;
    int dimensions[];
    int lowBounds[];
    int offset;
    boolean simple;
    int strides[];

    public GeneralArray()
    {
        simple = true;
    }

    public GeneralArray(int ai[])
    {
        simple = true;
        int i = 1;
        int j = ai.length;
        int ai1[];
        if (j <= zeros.length)
        {
            lowBounds = zeros;
        } else
        {
            lowBounds = new int[j];
        }
        ai1 = new int[j];
        do
        {
            j--;
            if (j >= 0)
            {
                ai1[j] = i;
                i *= ai[j];
            } else
            {
                base = new FVector(i);
                dimensions = ai;
                offset = 0;
                return;
            }
        } while (true);
    }

    public static Array makeSimple(int ai[], int ai1[], SimpleVector simplevector)
    {
        int j = ai1.length;
        int ai2[] = ai;
        if (ai == null)
        {
            ai = zeros;
            ai2 = ai;
            if (j > ai.length)
            {
                ai2 = new int[j];
            }
        }
        if (j == 1 && ai2[0] == 0)
        {
            return simplevector;
        }
        ai = new GeneralArray();
        int ai3[] = new int[j];
        int i = 1;
        do
        {
            j--;
            if (j >= 0)
            {
                ai3[j] = i;
                i *= ai1[j];
            } else
            {
                ai.strides = ai3;
                ai.dimensions = ai1;
                ai.lowBounds = ai2;
                ai.base = simplevector;
                return ai;
            }
        } while (true);
    }

    public static void toString(Array array, StringBuffer stringbuffer)
    {
        stringbuffer.append("#<array");
        int j = array.rank();
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(' ');
            int k = array.getLowBound(i);
            int l = array.getSize(i);
            if (k != 0)
            {
                stringbuffer.append(k);
                stringbuffer.append(':');
            }
            stringbuffer.append(k + l);
        }

        stringbuffer.append('>');
    }

    public int createPos(int i, boolean flag)
    {
        int j = offset;
        int k = dimensions.length;
        do
        {
            int l = i;
            k--;
            if (k < 0)
            {
                break;
            }
            int i1 = dimensions[k];
            i = l / i1;
            j += strides[k] * (l % i1);
        } while (true);
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i | j << 1;
    }

    public Object get(int i)
    {
        return getRowMajor(i);
    }

    public Object get(int ai[])
    {
        return base.get(getEffectiveIndex(ai));
    }

    public int getEffectiveIndex(int ai[])
    {
        int i = offset;
        int j = dimensions.length;
label0:
        do
        {
            int k;
label1:
            {
                j--;
                if (j < 0)
                {
                    break label0;
                }
                k = ai[j];
                int l = lowBounds[j];
                if (k >= l)
                {
                    k -= l;
                    if (k < dimensions[j])
                    {
                        break label1;
                    }
                }
                throw new IndexOutOfBoundsException();
            }
            i += strides[j] * k;
        } while (true);
        return i;
    }

    public int getLowBound(int i)
    {
        return lowBounds[i];
    }

    public Object getRowMajor(int i)
    {
        if (simple)
        {
            return base.get(i);
        }
        int j = offset;
        int k = dimensions.length;
        do
        {
            int l = i;
            k--;
            if (k >= 0)
            {
                int i1 = dimensions[k];
                i = l / i1;
                j += strides[k] * (l % i1);
            } else
            {
                return base.get(j);
            }
        } while (true);
    }

    public int getSize(int i)
    {
        return dimensions[i];
    }

    public int rank()
    {
        return dimensions.length;
    }

    public Object set(int ai[], Object obj)
    {
        return base.set(getEffectiveIndex(ai), obj);
    }

    public int size()
    {
        int i = 1;
        int j = dimensions.length;
        do
        {
            j--;
            if (j >= 0)
            {
                i *= dimensions[j];
            } else
            {
                return i;
            }
        } while (true);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        toString(((Array) (this)), stringbuffer);
        return stringbuffer.toString();
    }

    public Array transpose(int ai[], int ai1[], int i, int ai2[])
    {
        Object obj;
        if (ai1.length == 1 && ai[0] == 0)
        {
            obj = new GeneralArray1();
        } else
        {
            obj = new GeneralArray();
        }
        obj.offset = i;
        obj.strides = ai2;
        obj.dimensions = ai1;
        obj.lowBounds = ai;
        obj.base = base;
        obj.simple = false;
        return ((Array) (obj));
    }

}
