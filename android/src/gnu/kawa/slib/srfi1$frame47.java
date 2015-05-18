// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn48 extends ModuleBody
{

    Object a$Mnint$Mnb;
    final ModuleMethod lambda$Fn48;
     staticLink;

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 45)
        {
            return lambda65(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda65(Object obj, Object obj1)
    {
        if (lists.member(obj, a$Mnint$Mnb, staticLink.staticLink.Eq) != Boolean.FALSE)
        {
            return obj1;
        } else
        {
            return lists.cons(obj, obj1);
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 45)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 45, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1547");
        lambda$Fn48 = modulemethod;
    }
}
