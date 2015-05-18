// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.youngandroid;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import kawa.lib.ports;

// Referenced classes of package com.google.youngandroid:
//            runtime

public class lambda.Fn3 extends ModuleBody
{

    Object arg;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    LList pieces;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 2: // '\002'
            lambda2(obj);
            return Values.empty;

        case 3: // '\003'
            lambda3(obj);
            break;
        }
        return Values.empty;
    }

    void lambda2(Object obj)
    {
        ports.display(pieces, obj);
    }

    void lambda3(Object obj)
    {
        ports.display(arg, obj);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 3: // '\003'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 2, null, 4097);
        modulemethod.setProperty("source-location", "/tmp/runtime2895667505349593926.scm:1199");
        lambda$Fn2 = modulemethod;
        modulemethod = new ModuleMethod(this, 3, null, 4097);
        modulemethod.setProperty("source-location", "/tmp/runtime2895667505349593926.scm:1200");
        lambda$Fn3 = modulemethod;
    }
}
