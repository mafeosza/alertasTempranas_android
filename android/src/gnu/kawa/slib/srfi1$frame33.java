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

public class lambda.Fn31 extends ModuleBody
{
    public class srfi1.frame34 extends ModuleBody
    {

        Object elt;
        final ModuleMethod lambda$Fn33;
        srfi1.frame33 staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 31)
            {
                return lambda50(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda50(Object obj)
        {
            return staticLink.$Eq.apply2(obj, elt);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 31)
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

        public srfi1.frame34()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 31, null, 4097);
            modulemethod.setProperty("source-location", "srfi1.scm:1476");
            lambda$Fn33 = modulemethod;
        }
    }


    Procedure $Eq;
    final ModuleMethod lambda$Fn31;
    final ModuleMethod lambda$Fn32;

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 32: // ' '
            return lambda49(obj, obj1);

        case 33: // '!'
            return lambda48(obj, obj1);
        }
    }

    Object lambda48(Object obj, Object obj1)
    {
        if (!lists.isNull(obj))
        {
            if (lists.isNull(obj1))
            {
                return obj;
            }
            if (obj != obj1)
            {
                return srfi1.fold$V(lambda$Fn32, obj1, obj, new Object[0]);
            }
        }
        return obj1;
    }

    Object lambda49(Object obj, Object obj1)
    {
        lambda.Fn32 fn32 = new <init>();
        fn32.staticLink = this;
        fn32.elt = obj;
        if (srfi1.any$V(fn32.Fn33, obj1, new Object[0]) != Boolean.FALSE)
        {
            return obj1;
        } else
        {
            return lists.cons(fn32.elt, obj1);
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 33: // '!'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 32: // ' '
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public lambda.Fn33()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 32, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1476");
        lambda$Fn32 = modulemethod;
        modulemethod = new ModuleMethod(this, 33, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1471");
        lambda$Fn31 = modulemethod;
    }
}
