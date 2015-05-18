// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.IsEqual;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;

// Referenced classes of package gnu.kawa.slib:
//            srfi37

public class lambda.Fn1 extends ModuleBody
{

    final ModuleMethod lambda$Fn1;
    final ModuleMethod lambda$Fn2;
    Object name;
     staticLink;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            if (lambda7(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 2: // '\002'
            return lambda6(obj);
        }
    }

    Object lambda6(Object obj)
    {
         ;
        try
        {
             = ()obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "option-names", 0, obj);
        }
        return ambda1find(srfi37.optionNames(), lambda$Fn2);
    }

    boolean lambda7(Object obj)
    {
        return IsEqual.apply(name, obj);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 1: // '\001'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
        modulemethod.setProperty("source-location", "srfi37.scm:75");
        lambda$Fn2 = modulemethod;
        modulemethod = new ModuleMethod(this, 2, null, 4097);
        modulemethod.setProperty("source-location", "srfi37.scm:72");
        lambda$Fn1 = modulemethod;
    }
}
