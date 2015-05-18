// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class lambda.Fn4 extends ModuleBody
{

    Object digs;
    Object ex;
    final ModuleMethod lambda$Fn4;
    Object sgn;
     staticLink;

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 1)
        {
            return lambda8(obj, obj1, obj2);
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    Object lambda8(Object obj, Object obj1, Object obj2)
    {
        return Scheme.applyToArgs.applyN(new Object[] {
            staticLink.staticLink.roc, sgn, digs, ex, obj, obj1, obj2
        });
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 12291);
        modulemethod.setProperty("source-location", "printf.scm:126");
        lambda$Fn4 = modulemethod;
    }
}
