// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.IsEqual;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;

// Referenced classes of package gnu.kawa.slib:
//            testing

public class lambda.Fn14 extends ModuleBody
{

    final ModuleMethod lambda$Fn14;
    Object name;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 11)
        {
            if (lambda15(obj))
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

    boolean lambda15(Object obj)
    {
        return IsEqual.apply(name, testing.testRunnerTestName(obj));
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 11)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 11, null, 4097);
        modulemethod.setProperty("source-location", "testing.scm:971");
        lambda$Fn14 = modulemethod;
    }
}
