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
import kawa.lib.numbers;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class lambda.Fn6 extends ModuleBody
{

    final ModuleMethod lambda$Fn6;
    int slen;
    Object start;

    static boolean lambda5(Object obj)
    {
        boolean flag1 = numbers.isInteger(obj);
        boolean flag = flag1;
        if (flag1)
        {
            boolean flag2 = numbers.isExact(obj);
            flag = flag2;
            if (flag2)
            {
                flag = ((Boolean)Scheme.numLEq.apply2(srfi13.Lit0, obj)).booleanValue();
            }
        }
        return flag;
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 5)
        {
            if (lambda6(obj))
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

    boolean lambda6(Object obj)
    {
        boolean flag1 = numbers.isInteger(obj);
        boolean flag = flag1;
        if (flag1)
        {
            boolean flag2 = numbers.isExact(obj);
            flag = flag2;
            if (flag2)
            {
                Object obj1 = Scheme.numLEq.apply2(start, obj);
                boolean flag3;
                try
                {
                    flag3 = ((Boolean)obj1).booleanValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "x", -2, obj1);
                }
                flag = flag3;
                if (flag3)
                {
                    flag = ((Boolean)Scheme.numLEq.apply2(obj, Integer.valueOf(slen))).booleanValue();
                }
            }
        }
        return flag;
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 5)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 5, null, 4097);
        modulemethod.setProperty("source-location", "srfi13.scm:227");
        lambda$Fn6 = modulemethod;
    }
}
