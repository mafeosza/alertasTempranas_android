// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import java.util.Iterator;

public class IteratorItems extends MethodProc
{

    public static IteratorItems iteratorItems = new IteratorItems();

    public IteratorItems()
    {
    }

    public void apply(CallContext callcontext)
    {
        gnu.lists.Consumer consumer = callcontext.consumer;
        Object obj = callcontext.getNextArg();
        callcontext.lastArg();
        for (callcontext = (Iterator)obj; callcontext.hasNext(); Values.writeValues(callcontext.next(), consumer)) { }
    }

}
