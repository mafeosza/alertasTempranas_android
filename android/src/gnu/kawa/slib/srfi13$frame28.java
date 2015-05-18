// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    Object end1;
    final ModuleMethod lambda$Fn62 = new ModuleMethod(this, 56, null, 0);
    final ModuleMethod lambda$Fn63 = new ModuleMethod(this, 57, null, 8194);
    Object rest;
    Object start1;
    _cls2 staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 56)
        {
            return lambda62();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 57)
        {
            return lambda63(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda62()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncompare, staticLink.s2, rest);
    }

    Object lambda63(Object obj, Object obj1)
    {
        return srfi13.$PcStringCompare(staticLink.s1, start1, end1, staticLink.s2, obj, obj1, staticLink.Ls, staticLink.Eq, staticLink.Gr);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 56)
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
        if (modulemethod.selector == 57)
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
