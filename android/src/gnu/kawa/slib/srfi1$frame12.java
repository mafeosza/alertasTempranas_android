// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn11 extends ModuleBody
{

    Procedure f;
    final ModuleMethod lambda$Fn11;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 11)
        {
            lambda22(obj);
            return Values.empty;
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    void lambda22(Object obj)
    {
        Pair pair;
        try
        {
            pair = (Pair)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "set-car!", 1, obj);
        }
        lists.setCar$Ex(pair, f.apply1(lists.car.apply1(obj)));
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
        modulemethod.setProperty("source-location", "srfi1.scm:961");
        lambda$Fn11 = modulemethod;
    }
}
