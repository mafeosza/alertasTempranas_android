// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            GeneralArray, Sequence, Consumer, SimpleVector

public class GeneralArray1 extends GeneralArray
    implements Sequence
{

    public GeneralArray1()
    {
    }

    public void consumePosRange(int i, int j, Consumer consumer)
    {
        if (!consumer.ignoring())
        {
            while (!equals(i, j)) 
            {
                if (!hasNext(i))
                {
                    throw new RuntimeException();
                }
                base.consume(offset + strides[0] * (i >>> 1), 1, consumer);
                i = nextPos(i);
            }
        }
    }

    public int createPos(int i, boolean flag)
    {
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag1 | i << 1;
    }

    protected int nextIndex(int i)
    {
        if (i == -1)
        {
            return size();
        } else
        {
            return i >>> 1;
        }
    }
}
