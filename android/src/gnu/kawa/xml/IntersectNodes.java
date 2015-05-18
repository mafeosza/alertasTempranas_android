// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;

// Referenced classes of package gnu.kawa.xml:
//            SortedNodes

public class IntersectNodes extends Procedure2
{

    public static final IntersectNodes exceptNodes = new IntersectNodes(true);
    public static final IntersectNodes intersectNodes = new IntersectNodes(false);
    boolean isExcept;

    public IntersectNodes(boolean flag)
    {
        isExcept = flag;
    }

    public Object apply2(Object obj, Object obj1)
    {
        SortedNodes sortednodes;
        SortedNodes sortednodes1;
        SortedNodes sortednodes2;
        int i;
        int j;
        int k;
        int l;
        sortednodes = new SortedNodes();
        sortednodes1 = new SortedNodes();
        sortednodes2 = new SortedNodes();
        Values.writeValues(obj, sortednodes);
        Values.writeValues(obj1, sortednodes1);
        i = 0;
        obj = null;
        k = 0;
        j = 0;
        l = 0;
_L1:
        obj1 = sortednodes.getSeq(l);
        if (obj1 == null)
        {
            return sortednodes2;
        }
        int j1 = sortednodes.getPos(l);
        int i1;
        boolean flag;
        if (j == -1)
        {
            j = AbstractSequence.compare(((AbstractSequence) (obj1)), j1, ((AbstractSequence) (obj)), k);
            i1 = k;
        } else
        if (j == 0)
        {
            j = 1;
            i1 = k;
        } else
        {
            i1 = k;
        }
label0:
        {
            k = j;
            if (j > 0)
            {
                obj = sortednodes1.getSeq(i);
                if (obj != null)
                {
                    break label0;
                }
                k = -2;
            }
            if (k == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag != isExcept)
            {
                sortednodes2.writePosition(((AbstractSequence) (obj1)), j1);
            }
            l++;
            j = k;
            k = i1;
        }
          goto _L1
        i1 = sortednodes1.getPos(i);
        j = AbstractSequence.compare(((AbstractSequence) (obj1)), j1, ((AbstractSequence) (obj)), i1);
        i++;
        break MISSING_BLOCK_LABEL_94;
    }

}
