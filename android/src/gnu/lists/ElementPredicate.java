// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            NodePredicate, AbstractSequence

public interface ElementPredicate
    extends NodePredicate
{

    public abstract boolean isInstance(AbstractSequence abstractsequence, int i, Object obj);
}
