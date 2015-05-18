// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            AbstractSequence, PositionManager, SeqPosition

public abstract class ExtSequence extends AbstractSequence
{

    public ExtSequence()
    {
    }

    public int copyPos(int i)
    {
        if (i <= 0)
        {
            return i;
        } else
        {
            return PositionManager.manager.register(PositionManager.getPositionObject(i).copy());
        }
    }

    protected boolean isAfterPos(int i)
    {
        if (i > 0) goto _L2; else goto _L1
_L1:
        if (i >= 0) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if ((PositionManager.getPositionObject(i).ipos & 1) == 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    protected int nextIndex(int i)
    {
        if (i == -1)
        {
            return size();
        }
        if (i == 0)
        {
            return 0;
        } else
        {
            return PositionManager.getPositionObject(i).nextIndex();
        }
    }

    protected void releasePos(int i)
    {
        if (i > 0)
        {
            PositionManager.manager.release(i);
        }
    }
}
