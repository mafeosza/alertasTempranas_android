// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import kawa.standard.Scheme;
import kawa.standard.call_with_values;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn13 extends ModuleBody
{
    public class srfi1.frame14 extends ModuleBody
    {

        final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 12, null, 0);
        final ModuleMethod lambda$Fn13;
        Object lists;
        Object res;
        srfi1.frame13 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 12)
            {
                return lambda24();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 13)
            {
                return lambda25(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda24()
        {
            return srfi1.$PcCars$PlCdrs(lists);
        }

        Object lambda25(Object obj, Object obj1)
        {
            if (srfi1.isNotPair(obj))
            {
                obj = res;
                try
                {
                    obj1 = (LList)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "reverse!", 1, obj);
                }
                return kawa.lib.lists.reverse$Ex(((LList) (obj1)));
            }
            obj = Scheme.apply.apply2(staticLink.f, obj);
            if (obj != Boolean.FALSE)
            {
                return staticLink.lambda23recur(obj1, kawa.lib.lists.cons(obj, res));
            } else
            {
                return staticLink.lambda23recur(obj1, res);
            }
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 12)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 13)
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

        public srfi1.frame14()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 13, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:969");
            lambda$Fn13 = modulemethod;
        }
    }


    Procedure f;

    public Object lambda23recur(Object obj, Object obj1)
    {
          = new <init>();
        .staticLink = this;
        .lists = obj;
        .res = obj1;
        return call_with_values.callWithValues(.Fn12, .Fn13);
    }

    public lambda.Fn13()
    {
    }
}
