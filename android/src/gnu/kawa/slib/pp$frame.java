// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import kawa.lib.ports;

// Referenced classes of package gnu.kawa.slib:
//            pp

public class lambda.Fn1 extends ModuleBody
{

    final ModuleMethod lambda$Fn1;
    Object port;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            return lambda1(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Boolean lambda1(Object obj)
    {
        ports.display(obj, port);
        return Boolean.TRUE;
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
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

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
        modulemethod.setProperty("source-location", "pp.scm:9");
        lambda$Fn1 = modulemethod;
    }
}
