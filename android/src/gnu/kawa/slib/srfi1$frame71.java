// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class  extends ModuleBody
{

    final ModuleMethod lambda$Fn77 = new ModuleMethod(this, 76, null, 0);
    Object lists;

    static Pair lambda100(Object obj, Object obj1)
    {
        return kawa.lib.lists.cons(obj, obj1);
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 76)
        {
            return lambda99();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    Object lambda99()
    {
        return srfi1.$PcCars$PlCdrs$SlNoTest(lists);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 76)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public ()
    {
    }
}
