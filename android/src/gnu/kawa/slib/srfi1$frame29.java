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
//            srfi1

public class lambda.Fn27 extends ModuleBody
{

    Object heads;
    final ModuleMethod lambda$Fn26 = new ModuleMethod(this, 24, null, 0);
    final ModuleMethod lambda$Fn27;
     staticLink;
    Object tails;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 24)
        {
            return lambda42();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 25)
        {
            return lambda43(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda42()
    {
        return srfi1.$PcCars$PlCdrs(tails);
    }

    Object lambda43(Object obj, Object obj1)
    {
        if (lists.isPair(obj))
        {
            Object obj3 = Scheme.apply.apply2(staticLink.staticLink.pred, heads);
            Object obj2 = obj3;
            if (obj3 != Boolean.FALSE)
            {
                obj2 = staticLink.lambda41lp(obj, obj1);
            }
            return obj2;
        } else
        {
            return Scheme.apply.apply2(staticLink.staticLink.pred, heads);
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 24)
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
        if (modulemethod.selector == 25)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 25, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1381");
        lambda$Fn27 = modulemethod;
    }
}
