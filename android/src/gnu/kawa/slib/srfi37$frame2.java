// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import kawa.lib.lists;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi37

public class  extends ModuleBody
{

    final ModuleMethod lambda$Fn10 = new ModuleMethod(this, 10, null, -4096);
    final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, 0);
    Object operands;
    Object seeds;
     staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 9)
        {
            return lambda14();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        if (modulemethod.selector == 10)
        {
            return lambda15$V(aobj);
        } else
        {
            return super.applyN(modulemethod, aobj);
        }
    }

    Object lambda14()
    {
        return Scheme.apply.apply3(staticLink.Mnproc, lists.car.apply1(operands), seeds);
    }

    Object lambda15$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return staticLink.ambda4scanOperands(lists.cdr.apply1(operands), ((Object) (aobj)));
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 9)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        if (modulemethod.selector == 10)
        {
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        } else
        {
            return super.matchN(modulemethod, aobj, callcontext);
        }
    }

    public ()
    {
    }
}
