// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.mapping.CallContext;

// Referenced classes of package kawa.lang:
//            Continuation

public class CalledContinuation extends RuntimeException
{

    public Continuation continuation;
    public CallContext ctx;
    public Object values[];

    CalledContinuation(Object aobj[], Continuation continuation1, CallContext callcontext)
    {
        super("call/cc called");
        values = aobj;
        continuation = continuation1;
        ctx = callcontext;
    }
}
