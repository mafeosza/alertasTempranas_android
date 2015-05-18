// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.TreeList;

// Referenced classes of package gnu.kawa.xml:
//            TreeScanner, NodeType

public class DescendantOrSelfAxis extends TreeScanner
{

    public static final DescendantOrSelfAxis anyNode;

    private DescendantOrSelfAxis(NodePredicate nodepredicate)
    {
        type = nodepredicate;
    }

    public static DescendantOrSelfAxis make(NodePredicate nodepredicate)
    {
        if (nodepredicate == NodeType.anyNodeTest)
        {
            return anyNode;
        } else
        {
            return new DescendantOrSelfAxis(nodepredicate);
        }
    }

    public void scan(AbstractSequence abstractsequence, int i, PositionConsumer positionconsumer)
    {
        if (type.isInstancePos(abstractsequence, i))
        {
            positionconsumer.writePosition(abstractsequence, i);
        }
        if (abstractsequence instanceof TreeList) goto _L2; else goto _L1
_L1:
        for (i = abstractsequence.firstChildPos(i); i != 0; i = abstractsequence.nextPos(i))
        {
            scan(abstractsequence, i, positionconsumer);
        }

          goto _L3
_L2:
        int j = abstractsequence.nextPos(i);
_L6:
        i = abstractsequence.nextMatching(i, type, j, true);
        if (i != 0) goto _L4; else goto _L3
_L3:
        return;
_L4:
        positionconsumer.writePosition(abstractsequence, i);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        anyNode = new DescendantOrSelfAxis(NodeType.anyNodeTest);
    }
}
