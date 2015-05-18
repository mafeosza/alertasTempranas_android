// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import kawa.lib.lists;
import kawa.lib.misc;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class lambda.Fn4 extends ModuleBody
{

    Object args;
    final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn4;
    Object proc;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 3)
        {
            return lambda3();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 4)
        {
            return lambda4(obj, obj1, obj2);
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    Object lambda3()
    {
        return srfi13.stringParseStart$PlEnd(proc, s, args);
    }

    Object lambda4(Object obj, Object obj1, Object obj2)
    {
        if (lists.isPair(obj))
        {
            return misc.error$V("Extra arguments to procedure", new Object[] {
                proc, obj
            });
        } else
        {
            return misc.values(new Object[] {
                obj1, obj2
            });
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 3)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        if (modulemethod.selector == 4)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        } else
        {
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 4, null, 12291);
        modulemethod.setProperty("source-location", "srfi13.scm:174");
        lambda$Fn4 = modulemethod;
    }
}
