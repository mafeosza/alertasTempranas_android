// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

// Referenced classes of package gnu.kawa.xml:
//            TreeScanner

public class ParentAxis extends TreeScanner
{

    public ParentAxis()
    {
    }

    public static ParentAxis make(NodePredicate nodepredicate)
    {
        ParentAxis parentaxis = new ParentAxis();
        parentaxis.type = nodepredicate;
        return parentaxis;
    }

    public void scan(AbstractSequence abstractsequence, int i, PositionConsumer positionconsumer)
    {
        i = abstractsequence.parentPos(i);
        if (i != abstractsequence.endPos() && type.isInstancePos(abstractsequence, i))
        {
            positionconsumer.writePosition(abstractsequence, i);
        }
    }
}
