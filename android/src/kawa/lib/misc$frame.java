// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;

// Referenced classes of package kawa.lib:
//            misc, ports

public class lambda.Fn4 extends ModuleBody
{

    final ModuleMethod lambda$Fn4;
    Object msg;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 2)
        {
            lambda3(obj);
            return Values.empty;
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    void lambda3(Object obj)
    {
        ports.display(msg, obj);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 2)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public d()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 2, null, 4097);
        modulemethod.setProperty("source-location", "misc.scm:104");
        lambda$Fn4 = modulemethod;
    }
}
