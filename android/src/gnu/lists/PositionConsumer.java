// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            SeqPosition, AbstractSequence

public interface PositionConsumer
{

    public abstract void consume(SeqPosition seqposition);

    public abstract void writePosition(AbstractSequence abstractsequence, int i);
}
