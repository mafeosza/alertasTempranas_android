// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            GapVector, SimpleVector, Consumer

public class StableVector extends GapVector
{

    static final int END_POSITION = 1;
    protected static final int FREE_POSITION = -2;
    static final int START_POSITION = 0;
    protected int free;
    protected int positions[];

    protected StableVector()
    {
    }

    public StableVector(SimpleVector simplevector)
    {
        super(simplevector);
        positions = new int[16];
        positions[0] = 0;
        positions[1] = simplevector.getBufferLength() << 1 | 1;
        free = -1;
        int i = positions.length;
        do
        {
            i--;
            if (i > 1)
            {
                positions[i] = free;
                free = i;
            } else
            {
                return;
            }
        } while (true);
    }

    protected int addPos(int i, Object obj)
    {
        int l = positions[i];
        int k = l >>> 1;
        int j = k;
        if (k >= gapStart)
        {
            j = k + (gapEnd - gapStart);
        }
        k = i;
        if ((l & 1) == 0)
        {
            if (i == 0)
            {
                k = createPos(0, true);
            } else
            {
                positions[i] = l | 1;
                k = i;
            }
        }
        add(j, obj);
        return k;
    }

    protected void adjustPositions(int i, int j, int k)
    {
        if (free >= -1)
        {
            unchainFreelist();
        }
        int l = positions.length;
        do
        {
            int i1 = l - 1;
            if (i1 <= 0)
            {
                break;
            }
            int j1 = positions[i1];
            l = i1;
            if (j1 != -2)
            {
                int k1 = j1 ^ 0x80000000;
                l = i1;
                if (k1 >= (i ^ 0x80000000))
                {
                    l = i1;
                    if (k1 <= (j ^ 0x80000000))
                    {
                        positions[i1] = j1 + k;
                        l = i1;
                    }
                }
            }
        } while (true);
    }

    protected int allocPositionIndex()
    {
        if (free == -2)
        {
            chainFreelist();
        }
        if (free < 0)
        {
            int k = positions.length;
            int ai[] = new int[k * 2];
            System.arraycopy(positions, 0, ai, 0, k);
            int i = k * 2;
            do
            {
                i--;
                if (i < k)
                {
                    break;
                }
                ai[i] = free;
                free = i;
            } while (true);
            positions = ai;
        }
        int j = free;
        free = positions[free];
        return j;
    }

    protected void chainFreelist()
    {
        free = -1;
        int i = positions.length;
        do
        {
            int j = i - 1;
            if (j <= 1)
            {
                break;
            }
            i = j;
            if (positions[j] == -2)
            {
                positions[j] = free;
                free = j;
                i = j;
            }
        } while (true);
    }

    public void consumePosRange(int i, int j, Consumer consumer)
    {
        super.consumePosRange(positions[i], positions[j], consumer);
    }

    public int copyPos(int i)
    {
        int j = i;
        if (i > 1)
        {
            j = allocPositionIndex();
            positions[j] = positions[i];
        }
        return j;
    }

    public int createPos(int i, boolean flag)
    {
        int j;
        boolean flag1;
label0:
        {
            flag1 = true;
            if (i == 0 && !flag)
            {
                return 0;
            }
            if (flag && i == size())
            {
                return 1;
            }
            if (i <= gapStart)
            {
                j = i;
                if (i != gapStart)
                {
                    break label0;
                }
                j = i;
                if (!flag)
                {
                    break label0;
                }
            }
            j = i + (gapEnd - gapStart);
        }
        int k = allocPositionIndex();
        int ai[] = positions;
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 0;
        }
        ai[k] = i | j << 1;
        return k;
    }

    public int endPos()
    {
        return 1;
    }

    public void fillPosRange(int i, int j, Object obj)
    {
        fillPosRange(positions[i], positions[j], obj);
    }

    protected void gapReserve(int i, int j)
    {
        int k;
        int l;
        k = gapEnd;
        l = gapStart;
        if (j <= k - l) goto _L2; else goto _L1
_L1:
        int i1;
        i1 = base.size;
        super.gapReserve(i, j);
        j = base.size;
        if (i != l) goto _L4; else goto _L3
_L3:
        adjustPositions(k << 1, j << 1 | 1, j - i1 << 1);
_L6:
        return;
_L4:
        adjustPositions(k << 1, i1 << 1 | 1, l - k << 1);
        adjustPositions(gapStart << 1, j << 1 | 1, gapEnd - gapStart << 1);
        return;
_L2:
        if (i != gapStart)
        {
            shiftGap(i);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean hasNext(int i)
    {
        int j = positions[i] >>> 1;
        i = j;
        if (j >= gapStart)
        {
            i = j + (gapEnd - gapStart);
        }
        return i < base.getBufferLength();
    }

    protected boolean isAfterPos(int i)
    {
        return (positions[i] & 1) != 0;
    }

    public int nextIndex(int i)
    {
        int j = positions[i] >>> 1;
        i = j;
        if (j > gapStart)
        {
            i = j - (gapEnd - gapStart);
        }
        return i;
    }

    public int nextPos(int i)
    {
        int l = positions[i];
        int k = l >>> 1;
        int j = k;
        if (k >= gapStart)
        {
            j = k + (gapEnd - gapStart);
        }
        if (j >= base.getBufferLength())
        {
            releasePos(i);
            return 0;
        }
        j = i;
        if (i == 0)
        {
            j = createPos(0, true);
        }
        positions[j] = l | 1;
        return j;
    }

    public void releasePos(int i)
    {
        if (i >= 2)
        {
            if (free == -2)
            {
                chainFreelist();
            }
            positions[i] = free;
            free = i;
        }
    }

    protected void removePosRange(int i, int j)
    {
        super.removePosRange(positions[i], positions[j]);
        int k = gapStart;
        int l = gapEnd;
        if (free >= -1)
        {
            unchainFreelist();
        }
        i = positions.length;
        do
        {
            j = i - 1;
            if (j <= 0)
            {
                break;
            }
            int j1 = positions[j];
            i = j;
            if (j1 != -2)
            {
                int i1 = j1 >> 1;
                if ((j1 & 1) != 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    i = j;
                    if (i1 >= k)
                    {
                        i = j;
                        if (i1 < l)
                        {
                            positions[j] = gapEnd << 1 | 1;
                            i = j;
                        }
                    }
                } else
                {
                    i = j;
                    if (i1 > k)
                    {
                        i = j;
                        if (i1 <= l)
                        {
                            positions[j] = gapStart << 1;
                            i = j;
                        }
                    }
                }
            }
        } while (true);
    }

    protected void shiftGap(int i)
    {
        int j;
        int k;
        j = gapStart;
        k = i - j;
        if (k <= 0) goto _L2; else goto _L1
_L1:
        int l;
        int i1 = gapEnd;
        j = j - i1 << 1;
        l = i1 << 1;
        k = (i1 + k << 1) - 1;
_L6:
        super.shiftGap(i);
        adjustPositions(l, k, j);
_L4:
        return;
_L2:
        if (i == j) goto _L4; else goto _L3
_L3:
        l = (i << 1) + 1;
        k = j << 1;
        j = gapEnd - j << 1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int startPos()
    {
        return 0;
    }

    protected void unchainFreelist()
    {
        int j;
        for (int i = free; i >= 0; i = j)
        {
            j = positions[i];
            positions[i] = -2;
        }

        free = -2;
    }
}
