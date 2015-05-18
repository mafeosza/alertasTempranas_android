// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            ExtPosition, LList, Pair, SeqPosition, 
//            AbstractSequence

class LListPosition extends ExtPosition
{

    Object xpos;

    public LListPosition(LList llist, int i, boolean flag)
    {
        set(llist, i, flag);
    }

    public LListPosition(LListPosition llistposition)
    {
        sequence = llistposition.sequence;
        ipos = llistposition.ipos;
        xpos = llistposition.xpos;
    }

    public SeqPosition copy()
    {
        return new LListPosition(this);
    }

    public Object getNext()
    {
        Pair pair = getNextPair();
        if (pair == null)
        {
            return LList.eofValue;
        } else
        {
            return pair.car;
        }
    }

    public Pair getNextPair()
    {
        Object obj;
        if ((ipos & 1) > 0)
        {
            if (xpos == null)
            {
                AbstractSequence abstractsequence = sequence;
                obj = abstractsequence;
                if (ipos >> 1 != 0)
                {
                    obj = ((Pair)abstractsequence).cdr;
                }
            } else
            {
                obj = ((Pair)(Pair)((Pair)xpos).cdr).cdr;
            }
        } else
        if (xpos == null)
        {
            obj = sequence;
        } else
        {
            obj = ((Pair)xpos).cdr;
        }
        if (obj == LList.Empty)
        {
            return null;
        } else
        {
            return (Pair)obj;
        }
    }

    public Object getPrevious()
    {
        Pair pair = getPreviousPair();
        if (pair == null)
        {
            return LList.eofValue;
        } else
        {
            return pair.car;
        }
    }

    public Pair getPreviousPair()
    {
        int i = ipos;
        Object obj1 = xpos;
        Object obj;
        if ((i & 1) > 0)
        {
            if (obj1 == null)
            {
                obj = sequence;
            } else
            {
                obj = ((Pair)obj1).cdr;
            }
        } else
        {
            obj = obj1;
            if (obj1 == null)
            {
                return null;
            }
        }
        if (obj == LList.Empty)
        {
            return null;
        } else
        {
            return (Pair)obj;
        }
    }

    public boolean gotoNext()
    {
        Object obj;
        Object obj1;
        boolean flag;
        int i;
        if ((ipos & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = ipos;
        obj1 = xpos;
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (flag)
        {
            obj = ((Pair)obj1).cdr;
        }
        if (((Pair)obj).cdr != LList.Empty) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        xpos = obj;
        ipos = (ipos | 1) + 2;
_L6:
        return true;
_L2:
        if (ipos >> 1 != 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (sequence == LList.Empty) goto _L3; else goto _L5
_L5:
        ipos = 3;
          goto _L6
        obj = sequence;
        if (((Pair)obj).cdr == LList.Empty) goto _L3; else goto _L7
_L7:
        ipos = 5;
        xpos = obj;
          goto _L6
    }

    public boolean gotoPrevious()
    {
        if (ipos >>> 1 == 0)
        {
            return false;
        }
        if ((ipos & 1) != 0)
        {
            ipos = ipos - 3;
            return true;
        } else
        {
            int i = nextIndex();
            set((LList)sequence, i - 1, false);
            return true;
        }
    }

    public boolean hasNext()
    {
        boolean flag = true;
        if (xpos != null) goto _L2; else goto _L1
_L1:
        if (ipos >> 1 != 0) goto _L4; else goto _L3
_L3:
        if (sequence != LList.Empty)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L6:
        return flag;
_L4:
        if (((Pair)sequence).cdr == LList.Empty)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Object obj1 = ((Pair)xpos).cdr;
        Object obj = obj1;
        if ((ipos & 1) > 0)
        {
            obj = ((Pair)obj1).cdr;
        }
        if (obj == LList.Empty)
        {
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean hasPrevious()
    {
        return ipos >>> 1 != 0;
    }

    public int nextIndex()
    {
        return ipos >> 1;
    }

    public void set(AbstractSequence abstractsequence, int i, boolean flag)
    {
        set((LList)abstractsequence, i, flag);
    }

    public void set(LList llist, int i, boolean flag)
    {
        sequence = llist;
        boolean flag1;
        if (flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ipos = flag1 | i << 1;
        if (flag)
        {
            i -= 2;
        } else
        {
            i--;
        }
        if (i >= 0)
        {
            do
            {
                i--;
                if (i >= 0)
                {
                    llist = ((LList) (((Pair)llist).cdr));
                } else
                {
                    xpos = llist;
                    return;
                }
            } while (true);
        } else
        {
            xpos = null;
            return;
        }
    }

    public void setNext(Object obj)
    {
        getNextPair().car = obj;
    }

    public void setPrevious(Object obj)
    {
        getPreviousPair().car = obj;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("LListPos[");
        stringbuffer.append("index:");
        stringbuffer.append(ipos);
        if (isAfter())
        {
            stringbuffer.append(" after");
        }
        if (position >= 0)
        {
            stringbuffer.append(" position:");
            stringbuffer.append(position);
        }
        stringbuffer.append(']');
        return stringbuffer.toString();
    }
}
