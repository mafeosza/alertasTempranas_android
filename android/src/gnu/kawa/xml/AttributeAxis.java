// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

// Referenced classes of package gnu.kawa.xml:
//            TreeScanner

public class AttributeAxis extends TreeScanner
{

    public AttributeAxis()
    {
    }

    public static AttributeAxis make(NodePredicate nodepredicate)
    {
        AttributeAxis attributeaxis = new AttributeAxis();
        attributeaxis.type = nodepredicate;
        return attributeaxis;
    }

    public void scan(AbstractSequence abstractsequence, int i, PositionConsumer positionconsumer)
    {
        i = abstractsequence.firstAttributePos(i);
_L5:
        if (i == 0 || abstractsequence.getNextKind(i) != 35) goto _L2; else goto _L1
_L1:
        if (!type.isInstancePos(abstractsequence, i)) goto _L4; else goto _L3
_L3:
        positionconsumer.writePosition(abstractsequence, i);
_L6:
        i = abstractsequence.nextPos(i);
          goto _L5
_L4:
        if (abstractsequence.getNextKind(i) == 35) goto _L6; else goto _L2
_L2:
    }
}
