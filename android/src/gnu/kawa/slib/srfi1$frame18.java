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
//            srfi1

public class lambda.Fn17 extends ModuleBody
{

    final ModuleMethod lambda$Fn17;
    Object maybe$Mn$Eq;
    Object x;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 17)
        {
            if (lambda29(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    boolean lambda29(Object obj)
    {
        int i;
        if (Scheme.applyToArgs.apply3(maybe$Mn$Eq, x, obj) != Boolean.FALSE)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + 1 & 1;
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 17)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 17, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1225");
        lambda$Fn17 = modulemethod;
    }
}
