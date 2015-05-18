// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            pregexp

public class lambda.Fn14 extends ModuleBody
{

    final ModuleMethod lambda$Fn14;
    Object res;
    _cls1 staticLink;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 2)
        {
            return lambda21(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda21(Object obj)
    {
        return staticLink.lambda6loupSeq(lists.cdr.apply1(res), obj);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 2)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 2, null, 4097);
        modulemethod.setProperty("source-location", "pregexp.scm:519");
        lambda$Fn14 = modulemethod;
    }
}
