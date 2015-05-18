// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import java.util.Iterator;
import java.util.List;

public class ListItems extends MethodProc
{

    public static ListItems listItems = new ListItems();

    public ListItems()
    {
    }

    public void apply(CallContext callcontext)
    {
        gnu.lists.Consumer consumer = callcontext.consumer;
        Object obj = callcontext.getNextArg();
        callcontext.lastArg();
        callcontext = (List)obj;
        if (obj instanceof AbstractSequence)
        {
            ((AbstractSequence)obj).consumePosRange(0, -1, consumer);
        } else
        {
            callcontext = callcontext.iterator();
            while (callcontext.hasNext()) 
            {
                Values.writeValues(callcontext.next(), consumer);
            }
        }
    }

}
