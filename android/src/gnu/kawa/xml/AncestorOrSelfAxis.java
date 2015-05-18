// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

// Referenced classes of package gnu.kawa.xml:
//            TreeScanner

public class AncestorOrSelfAxis extends TreeScanner
{

    public AncestorOrSelfAxis()
    {
    }

    public static AncestorOrSelfAxis make(NodePredicate nodepredicate)
    {
        AncestorOrSelfAxis ancestororselfaxis = new AncestorOrSelfAxis();
        ancestororselfaxis.type = nodepredicate;
        return ancestororselfaxis;
    }

    private static void scan(AbstractSequence abstractsequence, int i, int j, NodePredicate nodepredicate, PositionConsumer positionconsumer)
    {
        if (i != j)
        {
            scan(abstractsequence, abstractsequence.parentPos(i), j, nodepredicate, positionconsumer);
            if (nodepredicate.isInstancePos(abstractsequence, i))
            {
                positionconsumer.writePosition(abstractsequence, i);
            }
        }
    }

    public void scan(AbstractSequence abstractsequence, int i, PositionConsumer positionconsumer)
    {
        scan(abstractsequence, i, abstractsequence.endPos(), type, positionconsumer);
    }
}
