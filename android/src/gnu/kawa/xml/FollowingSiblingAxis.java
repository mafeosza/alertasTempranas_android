// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

// Referenced classes of package gnu.kawa.xml:
//            TreeScanner

public class FollowingSiblingAxis extends TreeScanner
{

    public FollowingSiblingAxis()
    {
    }

    public static FollowingSiblingAxis make(NodePredicate nodepredicate)
    {
        FollowingSiblingAxis followingsiblingaxis = new FollowingSiblingAxis();
        followingsiblingaxis.type = nodepredicate;
        return followingsiblingaxis;
    }

    public void scan(AbstractSequence abstractsequence, int i, PositionConsumer positionconsumer)
    {
        int j = abstractsequence.endPos();
        do
        {
            i = abstractsequence.nextMatching(i, type, j, false);
            if (i == 0)
            {
                return;
            }
            positionconsumer.writePosition(abstractsequence, i);
        } while (true);
    }
}
