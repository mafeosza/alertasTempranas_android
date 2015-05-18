// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.standard.Scheme;

// Referenced classes of package kawa.lib:
//            syntax, lists

public class lambda.Fn1 extends ModuleBody
{

    final ModuleMethod lambda$Fn1;
    Object list;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            return lambda1(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda1(Object obj)
    {
        Object obj2 = list;
        Object obj1 = obj;
        obj = obj2;
        do
        {
            boolean flag;
            if (obj1 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag ? flag : lists.isNull(obj))
            {
                return obj1;
            }
            Object obj3 = lists.cdr.apply1(obj);
            obj1 = Scheme.applyToArgs.apply3(lists.caar.apply1(obj), obj1, lists.cdar.apply1(obj));
            obj = obj3;
        } while (true);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
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

    public t()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
        modulemethod.setProperty("source-location", "syntax.scm:83");
        lambda$Fn1 = modulemethod;
    }
}
