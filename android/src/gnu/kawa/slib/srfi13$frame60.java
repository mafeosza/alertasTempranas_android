// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import kawa.lib.rnrs.unicode;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    final ModuleMethod lambda$Fn143 = new ModuleMethod(this, 120, null, 0);
    final ModuleMethod lambda$Fn144 = new ModuleMethod(this, 121, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 120)
        {
            return lambda143();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 121)
        {
            return lambda144(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda143()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mndowncase, s, maybe$Mnstart$Plend);
    }

    Object lambda144(Object obj, Object obj1)
    {
        return srfi13.$PcStringMap(unicode.char$Mndowncase, s, obj, obj1);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 120)
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
        if (modulemethod.selector == 121)
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
