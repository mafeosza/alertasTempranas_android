// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.lib.lists;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            testing

public class lambda.Fn12 extends ModuleBody
{

    final ModuleMethod lambda$Fn12;
    LList pred$Mnlist;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 9)
        {
            return lambda13(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda13(Object obj)
    {
        Boolean boolean1 = Boolean.TRUE;
        Object obj1 = pred$Mnlist;
        do
        {
            if (lists.isNull(obj1))
            {
                return boolean1;
            }
            if (Scheme.applyToArgs.apply2(lists.car.apply1(obj1), obj) == Boolean.FALSE)
            {
                boolean1 = Boolean.FALSE;
            }
            obj1 = lists.cdr.apply1(obj1);
        } while (true);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 9)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 9, null, 4097);
        modulemethod.setProperty("source-location", "testing.scm:915");
        lambda$Fn12 = modulemethod;
    }
}
