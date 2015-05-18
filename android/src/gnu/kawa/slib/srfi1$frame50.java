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
import gnu.mapping.WrongType;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn52 extends ModuleBody
{

    Object a$Mnint$Mnb;
    final ModuleMethod lambda$Fn52;
     staticLink;

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 49)
        {
            return lambda69(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda69(Object obj, Object obj1)
    {
        if (lists.member(lists.car.apply1(obj), a$Mnint$Mnb, staticLink.staticLink.Eq) != Boolean.FALSE)
        {
            return obj1;
        }
        Pair pair;
        try
        {
            pair = (Pair)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "set-cdr!", 1, obj);
        }
        lists.setCdr$Ex(pair, obj1);
        return obj;
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 49)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 49, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1568");
        lambda$Fn52 = modulemethod;
    }
}
