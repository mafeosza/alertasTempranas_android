// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class CountValues extends Procedure1
{

    public static final CountValues countValues = new CountValues();

    public CountValues()
    {
    }

    public static int countValues(Object obj)
    {
        if (obj instanceof Values)
        {
            return ((Values)obj).size();
        } else
        {
            return 1;
        }
    }

    public void apply(CallContext callcontext)
    {
        Consumer consumer = callcontext.consumer;
        Object obj = callcontext.getNextArg();
        callcontext.lastArg();
        consumer.writeInt(countValues(obj));
    }

    public Object apply1(Object obj)
    {
        return IntNum.make(countValues(obj));
    }

}
