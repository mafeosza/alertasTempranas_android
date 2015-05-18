// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            AbstractSequence, Sequence, SimpleVector, Consumer

public class GapVector extends AbstractSequence
    implements Sequence
{

    public SimpleVector base;
    public int gapEnd;
    public int gapStart;

    protected GapVector()
    {
    }

    public GapVector(SimpleVector simplevector)
    {
        base = simplevector;
        gapStart = 0;
        gapEnd = simplevector.size;
    }

    public void add(int i, Object obj)
    {
        gapReserve(i, 1);
        base.set(i, obj);
        gapStart = gapStart + 1;
    }

    protected int addPos(int i, Object obj)
    {
        int j = i >>> 1;
        i = j;
        if (j >= gapStart)
        {
            i = j + (gapEnd - gapStart);
        }
        add(i, obj);
        return i + 1 << 1 | 1;
    }

    public void consumePosRange(int i, int j, Consumer consumer)
    {
        if (!consumer.ignoring())
        {
            int l = i >>> 1;
            int i1 = j >>> 1;
            if (l < gapStart)
            {
                int k;
                if (i1 > gapStart)
                {
                    k = i1;
                } else
                {
                    k = gapStart;
                }
                consumePosRange(i, k << 1, consumer);
            }
            if (i1 > gapEnd)
            {
                i = l;
                if (l < gapEnd)
                {
                    i = gapEnd;
                }
                consumePosRange(i << 1, j, consumer);
                return;
            }
        }
    }

    public int createPos(int i, boolean flag)
    {
        int j = i;
        if (i > gapStart)
        {
            j = i + (gapEnd - gapStart);
        }
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i | j << 1;
    }

    public void fill(Object obj)
    {
        base.fill(gapEnd, base.size, obj);
        base.fill(0, gapStart, obj);
    }

    public void fillPosRange(int i, int j, Object obj)
    {
        int k;
        if (i == -1)
        {
            k = base.size;
        } else
        {
            k = i >>> 1;
        }
        if (j == -1)
        {
            i = base.size;
        } else
        {
            i = j >>> 1;
        }
        if (gapStart < i)
        {
            j = gapStart;
        } else
        {
            j = i;
        }
        for (; k < j; k++)
        {
            base.setBuffer(k, obj);
        }

        for (j = gapEnd; j < i; j++)
        {
            base.setBuffer(j, obj);
        }

    }

    protected final void gapReserve(int i)
    {
        gapReserve(gapStart, i);
    }

    protected void gapReserve(int i, int j)
    {
        int k = 16;
        if (j > gapEnd - gapStart)
        {
            int l = base.size;
            int i1;
            if (l >= 16)
            {
                k = l * 2;
            }
            i1 = l - (gapEnd - gapStart);
            l = i1 + j;
            j = k;
            if (k < l)
            {
                j = l;
            }
            j = (j - i1) + i;
            base.resizeShift(gapStart, gapEnd, i, j);
            gapStart = i;
            gapEnd = j;
        } else
        if (i != gapStart)
        {
            shiftGap(i);
            return;
        }
    }

    public Object get(int i)
    {
        int j = i;
        if (i >= gapStart)
        {
            j = i + (gapEnd - gapStart);
        }
        return base.get(j);
    }

    public int getNextKind(int i)
    {
        if (hasNext(i))
        {
            return base.getElementKind();
        } else
        {
            return 0;
        }
    }

    public int getSegment(int i, int j)
    {
        int l = size();
        if (i < 0 || i > l)
        {
            j = -1;
        } else
        {
            int k;
            if (j < 0)
            {
                k = 0;
            } else
            {
                k = j;
                if (i + j > l)
                {
                    k = l - i;
                }
            }
            j = i;
            if (i + k > gapStart)
            {
                if (i >= gapStart)
                {
                    return i + (gapEnd - gapStart);
                }
                if (gapStart - i > k >> 1)
                {
                    shiftGap(i + k);
                    return i;
                } else
                {
                    shiftGap(i);
                    return i + (gapEnd - gapStart);
                }
            }
        }
        return j;
    }

    public boolean hasNext(int i)
    {
        int j = i >>> 1;
        i = j;
        if (j >= gapStart)
        {
            i = j + (gapEnd - gapStart);
        }
        return i < base.size;
    }

    protected boolean isAfterPos(int i)
    {
        return (i & 1) != 0;
    }

    protected int nextIndex(int i)
    {
        int j;
        if (i == -1)
        {
            i = base.size;
        } else
        {
            i >>>= 1;
        }
        j = i;
        if (i > gapStart)
        {
            j = i - (gapEnd - gapStart);
        }
        return j;
    }

    protected void removePosRange(int i, int j)
    {
        i >>>= 1;
        j >>>= 1;
        if (i <= gapEnd) goto _L2; else goto _L1
_L1:
        shiftGap((i - gapEnd) + gapStart);
_L4:
        if (i < gapStart)
        {
            base.clearBuffer(i, gapStart - i);
            gapStart = i;
        }
        if (j > gapEnd)
        {
            base.clearBuffer(gapEnd, j - gapEnd);
            gapEnd = j;
        }
        return;
_L2:
        if (j < gapStart)
        {
            shiftGap(j);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object set(int i, Object obj)
    {
        int j = i;
        if (i >= gapStart)
        {
            j = i + (gapEnd - gapStart);
        }
        return base.set(j, obj);
    }

    protected void shiftGap(int i)
    {
        int j = i - gapStart;
        if (j <= 0) goto _L2; else goto _L1
_L1:
        base.shift(gapEnd, gapStart, j);
_L4:
        gapEnd = gapEnd + j;
        gapStart = i;
        return;
_L2:
        if (j < 0)
        {
            base.shift(i, gapEnd + j, -j);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int size()
    {
        return base.size - (gapEnd - gapStart);
    }
}
