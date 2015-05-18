// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            testing

public class lambda.Fn4 extends ModuleBody
{

    Object error;
    final ModuleMethod lambda$Fn4;

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 1)
        {
            if (lambda5(obj, obj1))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    boolean lambda5(Object obj, Object obj1)
    {
        Object obj2 = Scheme.numGEq.apply2(obj, AddOp.$Mn.apply2(obj1, error));
        boolean flag;
        boolean flag1;
        try
        {
            flag = ((Boolean)obj2).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj2);
        }
        flag1 = flag;
        if (flag)
        {
            flag1 = ((Boolean)Scheme.numLEq.apply2(obj, AddOp.$Pl.apply2(obj1, error))).booleanValue();
        }
        return flag1;
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 8194);
        modulemethod.setProperty("source-location", "testing.scm:640");
        lambda$Fn4 = modulemethod;
    }
}
