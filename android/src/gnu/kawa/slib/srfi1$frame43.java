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
//            srfi1

public class lambda.Fn43 extends ModuleBody
{
    public class srfi1.frame44 extends ModuleBody
    {

        final ModuleMethod lambda$Fn44;
        srfi1.frame43 staticLink;
        Object x;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 43)
            {
                if (lambda61(obj))
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

        boolean lambda61(Object obj)
        {
            int i;
            if (kawa.lib.lists.member(x, obj, staticLink.$Eq) != Boolean.FALSE)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            return i + 1 & 1;
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 43)
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

        public srfi1.frame44()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 43, null, 4097);
            modulemethod.setProperty("source-location", "srfi1.scm:1528");
            lambda$Fn44 = modulemethod;
        }
    }


    Procedure $Eq;
    final ModuleMethod lambda$Fn43;
    Object lists;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 44)
        {
            return lambda60(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda60(Object obj)
    {
        lambda60 lambda60_1 = new <init>();
        lambda60_1.staticLink = this;
        lambda60_1.x = obj;
        return srfi1.every$V(lambda60_1.Fn44, lists, new Object[0]);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 44)
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

    public lambda.Fn44()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 44, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1527");
        lambda$Fn43 = modulemethod;
    }
}
