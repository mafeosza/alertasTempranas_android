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
    final ModuleMethod lambda$Fn87 = new ModuleMethod(this, 76, null, 0);
    final ModuleMethod lambda$Fn88 = new ModuleMethod(this, 77, null, 8194);
    Object rest;
    Object start1;
    _cls2 staticLink;

    static Boolean lambda89(Object obj)
    {
        return Boolean.FALSE;
    }

    static Boolean lambda90(Object obj)
    {
        return Boolean.FALSE;
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 76)
        {
            return lambda87();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 77)
        {
            return lambda88(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda87()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Gr, staticLink.s2, rest);
    }

    Object lambda88(Object obj, Object obj1)
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
            return Scheme.numGrt.apply2(end1, obj1);
        } else
        {
            return srfi13.$PcStringCompare(staticLink.s1, start1, end1, staticLink.s2, obj, obj1, srfi13.lambda$Fn89, srfi13.lambda$Fn90, misc.values);
        }
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

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 77)
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
