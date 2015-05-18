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

public class lambda.Fn6 extends ModuleBody
{

    Object arg;
    final ModuleMethod lambda$Fn5;
    final ModuleMethod lambda$Fn6;
    LList pieces;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 4: // '\004'
            lambda5(obj);
            return Values.empty;

        case 5: // '\005'
            lambda6(obj);
            break;
        }
        return Values.empty;
    }

    void lambda5(Object obj)
    {
        ports.display(pieces, obj);
    }

    void lambda6(Object obj)
    {
        ports.display(arg, obj);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 5: // '\005'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 4: // '\004'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 4, null, 4097);
        modulemethod.setProperty("source-location", "/tmp/runtime2895667505349593926.scm:1227");
        lambda$Fn5 = modulemethod;
        modulemethod = new ModuleMethod(this, 5, null, 4097);
        modulemethod.setProperty("source-location", "/tmp/runtime2895667505349593926.scm:1228");
        lambda$Fn6 = modulemethod;
    }
}
