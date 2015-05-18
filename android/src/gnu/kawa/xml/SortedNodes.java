// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;

// Referenced classes of package gnu.kawa.xml:
//            Nodes

public class SortedNodes extends Nodes
{

    int nesting;

    public SortedNodes()
    {
        nesting = 0;
    }

    int compareIndex(int i, AbstractSequence abstractsequence, int j)
    {
        if (data[i] != '\uF10F')
        {
            throw new RuntimeException("invalid kind of value to compare");
        } else
        {
            return AbstractSequence.compare((AbstractSequence)objects[getIntN(i + 1)], getIntN(i + 3), abstractsequence, j);
        }
    }

    int find(int i, int j, AbstractSequence abstractsequence, int k)
    {
        boolean flag = false;
        int l = j;
        for (j = ((flag) ? 1 : 0); j < l;)
        {
            int i1 = j + l >>> 1;
            int j1 = compareIndex(i1 * 5 + i, abstractsequence, k);
            if (j1 == 0)
            {
                return -1;
            }
            if (j1 > 0)
            {
                l = i1;
            } else
            {
                j = i1 + 1;
            }
        }

        return j * 5 + i;
    }

    public void writePosition(AbstractSequence abstractsequence, int i)
    {
        if (count <= 0) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        j = gapStart - 5;
        k = compareIndex(j, abstractsequence, i);
        if (k >= 0) goto _L4; else goto _L3
_L3:
        j = gapEnd;
        j = find(j, (data.length - j) / 5, abstractsequence, i);
        if (j >= 0) goto _L6; else goto _L5
_L5:
        return;
_L6:
        k = j - gapEnd;
        if (k > 0)
        {
            System.arraycopy(data, gapEnd, data, gapStart, k);
            gapEnd = j;
            gapStart = gapStart + k;
        }
_L2:
        super.writePosition(abstractsequence, i);
        return;
_L4:
        if (k == 0) goto _L5; else goto _L7
_L7:
        j = find(0, j / 5, abstractsequence, i);
        if (j < 0) goto _L5; else goto _L8
_L8:
        int l = gapStart - j;
        if (l > 0)
        {
            System.arraycopy(data, j, data, gapEnd - l, l);
            gapStart = j;
            gapEnd = gapEnd - l;
        }
          goto _L2
    }
}
