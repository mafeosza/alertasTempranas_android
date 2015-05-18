// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

// Referenced classes of package gnu.kawa.xml:
//            TreeScanner

public class PrecedingAxis extends TreeScanner
{

    public PrecedingAxis()
    {
    }

    public static PrecedingAxis make(NodePredicate nodepredicate)
    {
        PrecedingAxis precedingaxis = new PrecedingAxis();
        precedingaxis.type = nodepredicate;
        return precedingaxis;
    }

    private static void scan(AbstractSequence abstractsequence, int i, int j, NodePredicate nodepredicate, PositionConsumer positionconsumer)
    {
        int k = abstractsequence.parentPos(i);
        if (k != j) goto _L2; else goto _L1
_L1:
        return;
_L2:
        scan(abstractsequence, k, j, nodepredicate, positionconsumer);
        k = abstractsequence.firstChildPos(k);
        if (k == 0)
        {
            continue;
        }
        j = k;
        if (nodepredicate.isInstancePos(abstractsequence, k))
        {
            positionconsumer.writePosition(abstractsequence, k);
            j = k;
        }
        do
        {
            j = abstractsequence.nextMatching(j, nodepredicate, i, true);
            if (j == 0)
            {
                continue;
            }
            positionconsumer.writePosition(abstractsequence, j);
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void scan(AbstractSequence abstractsequence, int i, PositionConsumer positionconsumer)
    {
        scan(abstractsequence, i, abstractsequence.endPos(), type, positionconsumer);
    }
}
