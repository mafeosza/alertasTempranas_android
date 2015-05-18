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

public class lambda.Fn11 extends ModuleBody
{

    Object count;
    Object i;
    final ModuleMethod lambda$Fn11;
    Object n;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 8)
        {
            if (lambda12(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    boolean lambda12(Object obj)
    {
        i = AddOp.$Pl.apply2(i, testing.Lit13);
        obj = Scheme.numGEq.apply2(i, n);
        boolean flag;
        boolean flag1;
        try
        {
            flag = ((Boolean)obj).booleanValue();
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "x", -2, obj);
        }
        flag1 = flag;
        if (flag)
        {
            flag1 = ((Boolean)Scheme.numLss.apply2(i, AddOp.$Pl.apply2(n, count))).booleanValue();
        }
        return flag1;
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 8)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 8, null, 4097);
        modulemethod.setProperty("source-location", "testing.scm:903");
        lambda$Fn11 = modulemethod;
    }
}
