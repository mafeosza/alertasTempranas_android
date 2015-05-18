// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn40 extends ModuleBody
{

    final ModuleMethod lambda$Fn40;
     staticLink;
    Object x;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 39)
        {
            return lambda57(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda57(Object obj)
    {
        return lists.member(x, obj, staticLink.Eq);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 39)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 39, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1510");
        lambda$Fn40 = modulemethod;
    }
}
