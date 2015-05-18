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
import kawa.lib.misc;
import kawa.standard.call_with_values;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn6 extends ModuleBody
{
    public class srfi1.frame4 extends ModuleBody
    {

        Object elt;
        final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, 0);
        final ModuleMethod lambda$Fn6;
        Object lis;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 5)
            {
                return lambda9();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
        {
            if (modulemethod.selector == 6)
            {
                return lambda10(obj, obj1, obj2, obj3);
            } else
            {
                return super.apply4(modulemethod, obj, obj1, obj2, obj3);
            }
        }

        Object lambda10(Object obj, Object obj1, Object obj2, Object obj3)
        {
            return misc.values(new Object[] {
                lists.cons(lists.car.apply1(elt), obj), lists.cons(lists.cadr.apply1(elt), obj1), lists.cons(lists.caddr.apply1(elt), obj2), lists.cons(lists.cadddr.apply1(elt), obj3)
            });
        }

        Object lambda9()
        {
            return srfi1.frame3.lambda8recur(lists.cdr.apply1(lis));
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 5)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
        {
            if (modulemethod.selector == 6)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            } else
            {
                return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);
            }
        }

        public srfi1.frame4()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 6, null, 16388);
            modulemethod.setProperty("source-location", "srfi1.scm:644");
            lambda$Fn6 = modulemethod;
        }
    }


    public static Object lambda8recur(Object obj)
    {
        > > = new <init>();
        >.lis = obj;
        if (srfi1.isNullList(>.lis) != Boolean.FALSE)
        {
            return misc.values(new Object[] {
                >.lis, >.lis, >.lis, >.lis
            });
        } else
        {
            >.elt = lists.car.apply1(>.lis);
            return call_with_values.callWithValues(>.Fn5, >.Fn6);
        }
    }

    public lambda.Fn6()
    {
    }
}
