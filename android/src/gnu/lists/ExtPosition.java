// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            SeqPosition, PositionManager, AbstractSequence

public class ExtPosition extends SeqPosition
{

    int position;

    public ExtPosition()
    {
        position = -1;
    }

    public int getPos()
    {
        if (position < 0)
        {
            position = PositionManager.manager.register(this);
        }
        return position;
    }

    public final boolean isAfter()
    {
        return (ipos & 1) != 0;
    }

    public void release()
    {
        if (position >= 0)
        {
            PositionManager.manager.release(position);
        }
        sequence = null;
    }

    public void setPos(AbstractSequence abstractsequence, int i)
    {
        throw abstractsequence.unsupported("setPos");
    }
}
