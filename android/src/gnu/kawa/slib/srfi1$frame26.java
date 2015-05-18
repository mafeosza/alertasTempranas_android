// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.lib.lists;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn23 extends ModuleBody
{

    final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 22, null, 0);
    final ModuleMethod lambda$Fn23;
    Object lis1;
    LList lists;
    Procedure pred;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 22)
        {
            return lambda37();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 23)
        {
            return lambda38(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda37()
    {
        return srfi1.$PcCars$PlCdrs(kawa.lib.lists.cons(lis1, lists));
    }

    Object lambda38(Object obj, Object obj1)
    {
        boolean flag = kawa.lib.lists.isPair(obj);
        Object obj2;
        if (flag)
        {
            do
            {
                obj1 = srfi1.$PcCars$PlCdrs$SlPair(obj1);
                obj2 = lists.car.apply1(obj1);
                obj1 = lists.cdr.apply1(obj1);
                if (kawa.lib.lists.isPair(obj2))
                {
                    obj = Scheme.apply.apply2(pred, obj);
                    if (obj != Boolean.FALSE)
                    {
                        return obj;
                    }
                    obj = obj2;
                } else
                {
                    return Scheme.apply.apply2(pred, obj);
                }
            } while (true);
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
        if (modulemethod.selector == 22)
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
        if (modulemethod.selector == 23)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 23, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1350");
        lambda$Fn23 = modulemethod;
    }
}
