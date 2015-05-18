// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import kawa.lib.rnrs.unicode;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    final ModuleMethod lambda$Fn195 = new ModuleMethod(this, 168, null, 0);
    final ModuleMethod lambda$Fn196 = new ModuleMethod(this, 169, null, 8194);
    Object rest;
    _cls2 staticLink;
    Object t$Mnend;
    Object t$Mnstart;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 168)
        {
            return lambda195();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 169)
        {
            return lambda196(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda195()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncontains$Mnci, staticLink.pattern, rest);
    }

    Object lambda196(Object obj, Object obj1)
    {
        return srfi13.$PcKmpSearch(staticLink.pattern, staticLink.text, unicode.char$Mnci$Eq$Qu, obj, obj1, t$Mnstart, t$Mnend);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 168)
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
        if (modulemethod.selector == 169)
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
