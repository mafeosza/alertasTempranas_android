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

public class lambda.Fn13 extends ModuleBody
{

    Object chars;
    final ModuleMethod lambda$Fn13;
    r staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 1)
        {
            return lambda20();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    Object lambda20()
    {
        return staticLink.lambda5loupOneOfChars(lists.cdr.apply1(chars));
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 0);
        modulemethod.setProperty("source-location", "pregexp.scm:508");
        lambda$Fn13 = modulemethod;
    }
}
