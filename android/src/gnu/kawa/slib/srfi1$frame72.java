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
//            srfi1

public class lambda.Fn79 extends ModuleBody
{

    Object $Eq;
    final ModuleMethod lambda$Fn79;
    Object lis2;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 77)
        {
            return lambda101(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda101(Object obj)
    {
        Object obj2 = lis2;
        Object obj1 = $Eq;
        Procedure procedure;
        try
        {
            procedure = (Procedure)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "member", 3, obj1);
        }
        return lists.member(obj, obj2, procedure);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 77)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 77, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1443");
        lambda$Fn79 = modulemethod;
    }
}
