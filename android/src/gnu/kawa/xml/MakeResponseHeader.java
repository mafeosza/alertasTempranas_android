// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;

public class MakeResponseHeader extends MethodProc
{

    public static MakeResponseHeader makeResponseHeader = new MakeResponseHeader();

    public MakeResponseHeader()
    {
    }

    public void apply(CallContext callcontext)
    {
        String s = callcontext.getNextArg().toString();
        Object obj = callcontext.getNextArg();
        callcontext.lastArg();
        callcontext = callcontext.consumer;
        callcontext.startAttribute(s);
        callcontext.write(obj.toString());
        callcontext.endAttribute();
    }

}
