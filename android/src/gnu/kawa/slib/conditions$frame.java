// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            conditions

public class lambda.Fn1 extends ModuleBody
{

    final ModuleMethod lambda$Fn1;
    type type;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            if (lambda2(obj))
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

    boolean lambda2(Object obj)
    {
        obj = lists.car.apply1(obj);
        lambda2 lambda2_1;
        try
        {
            lambda2_1 = (lambda2)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "condition-subtype?", 0, obj);
        }
        return conditions.isConditionSubtype(lambda2_1, type);
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

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
        modulemethod.setProperty("source-location", "conditions.scm:166");
        lambda$Fn1 = modulemethod;
    }
}
