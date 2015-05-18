// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.youngandroid;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.numbers;
import kawa.lib.ports;

// Referenced classes of package com.google.youngandroid:
//            runtime

public class lambda.Fn8 extends ModuleBody
{

    final ModuleMethod lambda$Fn7;
    final ModuleMethod lambda$Fn8;
    Object n;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 6: // '\006'
            lambda7(obj);
            return Values.empty;

        case 7: // '\007'
            lambda8(obj);
            break;
        }
        return Values.empty;
    }

    void lambda7(Object obj)
    {
        ports.display(n, obj);
    }

    void lambda8(Object obj)
    {
        Object obj1 = n;
        Number number;
        try
        {
            number = (Number)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "exact", 1, obj1);
        }
        ports.display(numbers.exact(number), obj);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 7: // '\007'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 6: // '\006'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 6, null, 4097);
        modulemethod.setProperty("source-location", "/tmp/runtime2895667505349593926.scm:1291");
        lambda$Fn7 = modulemethod;
        modulemethod = new ModuleMethod(this, 7, null, 4097);
        modulemethod.setProperty("source-location", "/tmp/runtime2895667505349593926.scm:1299");
        lambda$Fn8 = modulemethod;
    }
}
