// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.lib.lists;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn29 extends ModuleBody
{

    final ModuleMethod lambda$Fn28 = new ModuleMethod(this, 28, null, 0);
    final ModuleMethod lambda$Fn29;
    Object lists;
    Object n;
     staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 28)
        {
            return lambda45();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 29)
        {
            return lambda46(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda45()
    {
        return srfi1.$PcCars$PlCdrs(lists);
    }

    Object lambda46(Object obj, Object obj1)
    {
        boolean flag = kawa.lib.lists.isPair(obj);
        if (flag)
        {
            if (Scheme.apply.apply2(staticLink.pred, obj) != Boolean.FALSE)
            {
                return n;
            } else
            {
                return staticLink.lambda44lp(obj1, AddOp.$Pl.apply2(n, srfi1.Lit1));
            }
        }
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 28)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 29)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return super.match2(modulemethod, obj, obj1, callcontext);
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 29, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1404");
        lambda$Fn29 = modulemethod;
    }
}
