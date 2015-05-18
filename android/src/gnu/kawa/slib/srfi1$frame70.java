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
//            srfi1

public class lambda.Fn76 extends ModuleBody
{

    Object a;
    Object d;
    final ModuleMethod lambda$Fn75 = new ModuleMethod(this, 70, null, 0);
    final ModuleMethod lambda$Fn76;
     staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 70)
        {
            return lambda97();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 71)
        {
            return lambda98(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda97()
    {
        return lambda92recur(staticLink.Mnlists);
    }

    Object lambda98(Object obj, Object obj1)
    {
        return misc.values(new Object[] {
            lists.cons(a, obj), lists.cons(d, obj1)
        });
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 70)
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
        if (modulemethod.selector == 71)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 71, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:796");
        lambda$Fn76 = modulemethod;
    }
}
