// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.lib.numbers;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class lambda.Fn153 extends ModuleBody
{

    final ModuleMethod lambda$Fn153;
    int len;
    Object n;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 130)
        {
            if (lambda153(obj))
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

    boolean lambda153(Object obj)
    {
        boolean flag1 = numbers.isInteger(n);
        boolean flag = flag1;
        if (flag1)
        {
            boolean flag2 = numbers.isExact(n);
            flag = flag2;
            if (flag2)
            {
                flag = ((Boolean)Scheme.numLEq.apply3(srfi13.Lit0, n, Integer.valueOf(len))).booleanValue();
            }
        }
        return flag;
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 130)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 130, null, 4097);
        modulemethod.setProperty("source-location", "srfi13.scm:1010");
        lambda$Fn153 = modulemethod;
    }
}
