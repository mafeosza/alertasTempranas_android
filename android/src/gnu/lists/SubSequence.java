// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            AbstractSequence, Sequence

public class SubSequence extends AbstractSequence
    implements Sequence
{

    AbstractSequence base;
    int ipos0;
    int ipos1;

    public SubSequence()
    {
    }

    public SubSequence(AbstractSequence abstractsequence)
    {
        base = abstractsequence;
    }

    public SubSequence(AbstractSequence abstractsequence, int i, int j)
    {
        base = abstractsequence;
        ipos0 = i;
        ipos1 = j;
    }

    public void clear()
    {
        removePosRange(ipos0, ipos1);
    }

    public int compare(int i, int j)
    {
        return base.compare(i, j);
    }

    public int createPos(int i, boolean flag)
    {
        return base.createRelativePos(ipos0, i, flag);
    }

    public int createRelativePos(int i, int j, boolean flag)
    {
        return base.createRelativePos(i, j, flag);
    }

    public int endPos()
    {
        return ipos1;
    }

    public void finalize()
    {
        base.releasePos(ipos0);
        base.releasePos(ipos1);
    }

    public Object get(int i)
    {
        if (i < 0 || i >= size())
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            int j = base.nextIndex(ipos0);
            return base.get(j + i);
        }
    }

    protected int getIndexDifference(int i, int j)
    {
        return base.getIndexDifference(i, j);
    }

    public int getNextKind(int i)
    {
        if (base.compare(i, ipos1) >= 0)
        {
            return 0;
        } else
        {
            return base.getNextKind(i);
        }
    }

    public Object getPosNext(int i)
    {
        if (base.compare(i, ipos1) >= 0)
        {
            return eofValue;
        } else
        {
            return base.getPosNext(i);
        }
    }

    public Object getPosPrevious(int i)
    {
        if (base.compare(i, ipos0) <= 0)
        {
            return eofValue;
        } else
        {
            return base.getPosPrevious(i);
        }
    }

    protected boolean isAfterPos(int i)
    {
        return base.isAfterPos(i);
    }

    protected int nextIndex(int i)
    {
        return getIndexDifference(i, ipos0);
    }

    public void releasePos(int i)
    {
        base.releasePos(i);
    }

    public void removePosRange(int i, int j)
    {
        AbstractSequence abstractsequence = base;
        int k;
        if (i == 0)
        {
            k = ipos0;
        } else
        {
            k = i;
            if (i == -1)
            {
                k = ipos1;
            }
        }
        if (j == -1)
        {
            i = ipos1;
        } else
        {
            i = j;
            if (j == 0)
            {
                i = ipos0;
            }
        }
        abstractsequence.removePosRange(k, i);
    }

    public int size()
    {
        return base.getIndexDifference(ipos1, ipos0);
    }

    public int startPos()
    {
        return ipos0;
    }

    protected Sequence subSequencePos(int i, int j)
    {
        return new SubSequence(base, i, j);
    }
}
