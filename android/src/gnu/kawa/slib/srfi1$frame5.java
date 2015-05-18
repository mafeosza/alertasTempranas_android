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

public class lambda.Fn8 extends ModuleBody
{
    public class srfi1.frame6 extends ModuleBody
    {

        Object elt;
        final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, 0);
        final ModuleMethod lambda$Fn8;
        Object lis;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 7)
            {
                return lambda12();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object applyN(ModuleMethod modulemethod, Object aobj[])
        {
            if (modulemethod.selector == 8)
            {
                return lambda13(aobj[0], aobj[1], aobj[2], aobj[3], aobj[4]);
            } else
            {
                return super.applyN(modulemethod, aobj);
            }
        }

        Object lambda12()
        {
            return srfi1.frame5.lambda11recur(lists.cdr.apply1(lis));
        }

        Object lambda13(Object obj, Object obj1, Object obj2, Object obj3, Object obj4)
        {
            return misc.values(new Object[] {
                lists.cons(lists.car.apply1(elt), obj), lists.cons(lists.cadr.apply1(elt), obj1), lists.cons(lists.caddr.apply1(elt), obj2), lists.cons(lists.cadddr.apply1(elt), obj3), lists.cons(lists.car.apply1(lists.cddddr.apply1(elt)), obj4)
            });
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 7)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
        {
            if (modulemethod.selector == 8)
            {
                callcontext.values = aobj;
                callcontext.proc = modulemethod;
                callcontext.pc = 5;
                return 0;
            } else
            {
                return super.matchN(modulemethod, aobj, callcontext);
            }
        }

        public srfi1.frame6()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 8, null, 20485);
            modulemethod.setProperty("source-location", "srfi1.scm:654");
            lambda$Fn8 = modulemethod;
        }
    }


    public static Object lambda11recur(Object obj)
    {
        > > = new <init>();
        >.lis = obj;
        if (srfi1.isNullList(>.lis) != Boolean.FALSE)
        {
            return misc.values(new Object[] {
                >.lis, >.lis, >.lis, >.lis, >.lis
            });
        } else
        {
            >.elt = lists.car.apply1(>.lis);
            return call_with_values.callWithValues(>.Fn7, >.Fn8);
        }
    }

    public lambda.Fn8()
    {
    }
}
