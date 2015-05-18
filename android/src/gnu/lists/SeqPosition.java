// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.util.Enumeration;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// Referenced classes of package gnu.lists:
//            AbstractSequence, Sequence

public class SeqPosition
    implements ListIterator, Enumeration
{

    public int ipos;
    public AbstractSequence sequence;

    public SeqPosition()
    {
    }

    public SeqPosition(AbstractSequence abstractsequence)
    {
        sequence = abstractsequence;
    }

    public SeqPosition(AbstractSequence abstractsequence, int i)
    {
        sequence = abstractsequence;
        ipos = i;
    }

    public SeqPosition(AbstractSequence abstractsequence, int i, boolean flag)
    {
        sequence = abstractsequence;
        ipos = abstractsequence.createPos(i, flag);
    }

    public static SeqPosition make(AbstractSequence abstractsequence, int i)
    {
        return new SeqPosition(abstractsequence, abstractsequence.copyPos(i));
    }

    public void add(Object obj)
    {
        setPos(sequence.addPos(getPos(), obj));
    }

    public SeqPosition copy()
    {
        return new SeqPosition(sequence, sequence.copyPos(getPos()));
    }

    public void finalize()
    {
        release();
    }

    public final int fromEndIndex()
    {
        return sequence.fromEndIndex(getPos());
    }

    public int getContainingSequenceSize()
    {
        return sequence.getContainingSequenceSize(getPos());
    }

    public Object getNext()
    {
        return sequence.getPosNext(getPos());
    }

    public int getNextKind()
    {
        return sequence.getNextKind(getPos());
    }

    public String getNextTypeName()
    {
        return sequence.getNextTypeName(getPos());
    }

    public Object getNextTypeObject()
    {
        return sequence.getNextTypeObject(getPos());
    }

    public int getPos()
    {
        return ipos;
    }

    public Object getPrevious()
    {
        return sequence.getPosPrevious(getPos());
    }

    public boolean gotoChildrenStart()
    {
        int i = sequence.firstChildPos(getPos());
        if (i == 0)
        {
            return false;
        } else
        {
            ipos = i;
            return true;
        }
    }

    public final void gotoEnd(AbstractSequence abstractsequence)
    {
        setPos(abstractsequence, abstractsequence.endPos());
    }

    public boolean gotoNext()
    {
        int i = sequence.nextPos(ipos);
        if (i != 0)
        {
            ipos = i;
            return true;
        } else
        {
            ipos = -1;
            return false;
        }
    }

    public boolean gotoPrevious()
    {
        int i = sequence.previousPos(ipos);
        if (i != -1)
        {
            ipos = i;
            return true;
        } else
        {
            ipos = 0;
            return false;
        }
    }

    public final void gotoStart(AbstractSequence abstractsequence)
    {
        setPos(abstractsequence, abstractsequence.startPos());
    }

    public final boolean hasMoreElements()
    {
        return hasNext();
    }

    public boolean hasNext()
    {
        return sequence.hasNext(getPos());
    }

    public boolean hasPrevious()
    {
        return sequence.hasPrevious(getPos());
    }

    public boolean isAfter()
    {
        return sequence.isAfterPos(getPos());
    }

    public Object next()
    {
        Object obj = getNext();
        if (obj == Sequence.eofValue || !gotoNext())
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public final Object nextElement()
    {
        return next();
    }

    public int nextIndex()
    {
        return sequence.nextIndex(getPos());
    }

    public Object previous()
    {
        Object obj = getPrevious();
        if (obj == Sequence.eofValue || !gotoPrevious())
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public final int previousIndex()
    {
        return sequence.nextIndex(getPos()) - 1;
    }

    public void release()
    {
        if (sequence != null)
        {
            sequence.releasePos(getPos());
            sequence = null;
        }
    }

    public void remove()
    {
        AbstractSequence abstractsequence = sequence;
        int i = getPos();
        byte byte0;
        if (isAfter())
        {
            byte0 = -1;
        } else
        {
            byte0 = 1;
        }
        abstractsequence.removePos(i, byte0);
    }

    public void set(AbstractSequence abstractsequence, int i, boolean flag)
    {
        if (sequence != null)
        {
            sequence.releasePos(ipos);
        }
        sequence = abstractsequence;
        ipos = abstractsequence.createPos(i, flag);
    }

    public void set(SeqPosition seqposition)
    {
        if (sequence != null)
        {
            sequence.releasePos(ipos);
        }
        sequence = seqposition.sequence;
        seqposition.ipos = sequence.copyPos(seqposition.ipos);
    }

    public final void set(Object obj)
    {
        if (isAfter())
        {
            setPrevious(obj);
            return;
        } else
        {
            setNext(obj);
            return;
        }
    }

    public void setNext(Object obj)
    {
        sequence.setPosNext(getPos(), obj);
    }

    public void setPos(int i)
    {
        if (sequence != null)
        {
            sequence.releasePos(getPos());
        }
        ipos = i;
    }

    public void setPos(AbstractSequence abstractsequence, int i)
    {
        if (sequence != null)
        {
            sequence.releasePos(getPos());
        }
        ipos = i;
        sequence = abstractsequence;
    }

    public void setPrevious(Object obj)
    {
        sequence.setPosPrevious(getPos(), obj);
    }

    public String toInfo()
    {
        StringBuffer stringbuffer = new StringBuffer(60);
        stringbuffer.append('{');
        if (sequence == null)
        {
            stringbuffer.append("null sequence");
        } else
        {
            stringbuffer.append(sequence.getClass().getName());
            stringbuffer.append('@');
            stringbuffer.append(System.identityHashCode(sequence));
        }
        stringbuffer.append(" ipos: ");
        stringbuffer.append(ipos);
        stringbuffer.append('}');
        return stringbuffer.toString();
    }

    public String toString()
    {
        if (sequence == null)
        {
            return toInfo();
        }
        Object obj = sequence.getPosNext(ipos);
        StringBuilder stringbuilder = (new StringBuilder()).append("@").append(nextIndex()).append(": ");
        if (obj == null)
        {
            obj = "(null)";
        } else
        {
            obj = obj.toString();
        }
        return stringbuilder.append(((String) (obj))).toString();
    }
}
