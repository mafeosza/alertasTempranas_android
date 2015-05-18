// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;


// Referenced classes of package org.json.zip:
//            PostMortem, Huff

private static class zero
    implements PostMortem
{

    public one back;
    public final int integer;
    public one next;
    public one one;
    public long weight;
    public one zero;

    public boolean postMortem(PostMortem postmortem)
    {
        boolean flag1;
        boolean flag2;
        flag1 = true;
        flag2 = true;
        postmortem = (zero)postmortem;
        if (integer == ((integer) (postmortem)).integer && weight == ((weight) (postmortem)).weight) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        zero zero1;
        zero zero2;
        boolean flag;
        if (back != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((back) (postmortem)).back == null)
        {
            flag1 = false;
        }
        if (flag != flag1) goto _L1; else goto _L3
_L3:
        zero1 = zero;
        zero2 = one;
        if (zero1 != null) goto _L5; else goto _L4
_L4:
        if (((one) (postmortem)).zero != null) goto _L1; else goto _L6
_L6:
        if (zero2 != null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        if (((zero) (postmortem)).one != null) goto _L1; else goto _L7
_L7:
        return flag2;
_L5:
        flag2 = zero1.postMortem(((PostMortem) (((postMortem) (postmortem)).zero)));
          goto _L6
        flag2 = zero2.postMortem(((PostMortem) (((postMortem) (postmortem)).one)));
          goto _L7
    }

    public (int i)
    {
        integer = i;
        weight = 0L;
        next = null;
        back = null;
        one = null;
        zero = null;
    }
}
