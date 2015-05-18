// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

// Referenced classes of package gnu.kawa.xml:
//            TreeScanner

public class SelfAxis extends TreeScanner
{

    public SelfAxis()
    {
    }

    public static SelfAxis make(NodePredicate nodepredicate)
    {
        SelfAxis selfaxis = new SelfAxis();
        selfaxis.type = nodepredicate;
        return selfaxis;
    }

    public void scan(AbstractSequence abstractsequence, int i, PositionConsumer positionconsumer)
    {
        if (type.isInstancePos(abstractsequence, i))
        {
            positionconsumer.writePosition(abstractsequence, i);
        }
    }
}
