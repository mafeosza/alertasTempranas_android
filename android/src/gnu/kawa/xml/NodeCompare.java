// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import gnu.mapping.WrongType;

public class NodeCompare extends Procedure2
{

    public static final NodeCompare $Eq = make("is", 8);
    public static final NodeCompare $Gr = make(">>", 16);
    public static final NodeCompare $Ls = make("<<", 4);
    public static final NodeCompare $Ne = make("isnot", 20);
    static final int RESULT_EQU = 0;
    static final int RESULT_GRT = 1;
    static final int RESULT_LSS = -1;
    static final int TRUE_IF_EQU = 8;
    static final int TRUE_IF_GRT = 16;
    static final int TRUE_IF_LSS = 4;
    int flags;

    public NodeCompare()
    {
    }

    public static NodeCompare make(String s, int i)
    {
        NodeCompare nodecompare = new NodeCompare();
        nodecompare.setName(s);
        nodecompare.flags = i;
        return nodecompare;
    }

    public Object apply2(Object obj, Object obj1)
    {
        Object obj2;
        if (obj == null || obj1 == null)
        {
            obj2 = null;
        } else
        {
            obj2 = obj;
            if (obj != Values.empty)
            {
                if (obj1 == Values.empty)
                {
                    return obj1;
                }
                int i;
                int j;
                if (obj instanceof AbstractSequence)
                {
                    obj = (AbstractSequence)obj;
                    i = ((AbstractSequence) (obj)).startPos();
                } else
                {
                    AbstractSequence abstractsequence;
                    try
                    {
                        SeqPosition seqposition = (SeqPosition)obj;
                        abstractsequence = seqposition.sequence;
                        i = seqposition.getPos();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        throw WrongType.make(((ClassCastException) (obj1)), this, 1, obj);
                    }
                    obj = abstractsequence;
                }
                if (obj1 instanceof AbstractSequence)
                {
                    obj1 = (AbstractSequence)obj1;
                    j = ((AbstractSequence) (obj1)).startPos();
                } else
                {
                    AbstractSequence abstractsequence1;
                    try
                    {
                        SeqPosition seqposition1 = (SeqPosition)obj1;
                        abstractsequence1 = seqposition1.sequence;
                        j = seqposition1.getPos();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw WrongType.make(((ClassCastException) (obj)), this, 2, obj1);
                    }
                    obj1 = abstractsequence1;
                }
                if (obj == obj1)
                {
                    i = ((AbstractSequence) (obj)).compare(i, j);
                } else
                {
                    if (this == $Eq)
                    {
                        return Boolean.FALSE;
                    }
                    if (this == $Ne)
                    {
                        return Boolean.TRUE;
                    }
                    i = ((AbstractSequence) (obj)).stableCompare(((AbstractSequence) (obj1)));
                }
                if ((1 << i + 3 & flags) != 0)
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            }
        }
        return obj2;
    }

}
