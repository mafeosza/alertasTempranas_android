// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class lambda.Fn197 extends ModuleBody
{

    final ModuleMethod lambda$Fn197;
    Object pattern;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 172)
        {
            return lambda197(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda197(Object obj)
    {
        return srfi13.stringParseStart$PlEnd(srfi13.make$Mnkmp$Mnrestart$Mnvector, pattern, obj);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 172)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 172, null, 4097);
        modulemethod.setProperty("source-location", "srfi13.scm:1399");
        lambda$Fn197 = modulemethod;
    }
}
