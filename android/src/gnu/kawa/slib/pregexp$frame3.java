// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.lib.lists;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            pregexp

public class lambda.Fn16 extends ModuleBody
{

    final ModuleMethod lambda$Fn15;
    final ModuleMethod lambda$Fn16;
    Object res;
    _cls1 staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 4)
        {
            return lambda23();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 3)
        {
            return lambda22(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda22(Object obj)
    {
        obj = Scheme.applyToArgs.apply2(staticLink.sk, obj);
        if (obj != Boolean.FALSE)
        {
            return obj;
        } else
        {
            return staticLink.lambda7loupOr(lists.cdr.apply1(res));
        }
    }

    Object lambda23()
    {
        return staticLink.lambda7loupOr(lists.cdr.apply1(res));
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 4)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 3)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 3, null, 4097);
        modulemethod.setProperty("source-location", "pregexp.scm:526");
        lambda$Fn15 = modulemethod;
        modulemethod = new ModuleMethod(this, 4, null, 0);
        modulemethod.setProperty("source-location", "pregexp.scm:529");
        lambda$Fn16 = modulemethod;
    }
}
