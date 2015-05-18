// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.lists.Sequence;

// Referenced classes of package gnu.mapping:
//            Values

public class ValueStack extends Values
    implements Sequence
{

    public ValueStack()
    {
    }

    public void clear()
    {
        oindex = 0;
        super.clear();
    }
}
