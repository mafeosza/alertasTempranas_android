// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import kawa.lib.misc;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    Object end1;
    final ModuleMethod lambda$Fn131 = new ModuleMethod(this, 108, null, 0);
    final ModuleMethod lambda$Fn132 = new ModuleMethod(this, 109, null, 8194);
    Object rest;
    Object start1;
    _cls2 staticLink;

    static Boolean lambda133(Object obj)
    {
        return Boolean.FALSE;
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 108)
        {
            return lambda131();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 109)
        {
            return lambda132(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda131()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnci$Gr$Eq, staticLink.s2, rest);
    }

    Object lambda132(Object obj, Object obj1)
    {
        boolean flag;
        if (staticLink.s1 == staticLink.s2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag ? Scheme.numEqu.apply2(start1, obj) != Boolean.FALSE : flag)
        {
            return Scheme.numGEq.apply2(end1, obj1);
        } else
        {
            return srfi13.$PcStringCompareCi(staticLink.s1, start1, end1, staticLink.s2, obj, obj1, srfi13.lambda$Fn133, misc.values, misc.values);
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 108)
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
        if (modulemethod.selector == 109)
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
    }
}
