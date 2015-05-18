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
import kawa.lang.Continuation;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.call_with_values;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn66 extends ModuleBody
{
    public class srfi1.frame64 extends ModuleBody
    {

        final ModuleMethod lambda$Fn65 = new ModuleMethod(this, 68, null, 0);
        final ModuleMethod lambda$Fn66;
        Object lists;
        srfi1.frame63 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 68)
            {
                return lambda86();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 69)
            {
                return lambda87(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda86()
        {
            return srfi1.car$PlCdr(lists);
        }

        Object lambda87(Object obj, Object obj1)
        {
            srfi1.frame65 frame65_1 = new srfi1.frame65();
            frame65_1.staticLink = this;
            frame65_1.list = obj;
            frame65_1.other$Mnlists = obj1;
            if (srfi1.isNullList(frame65_1.list) != Boolean.FALSE)
            {
                return staticLink.abort.apply2(LList.Empty, LList.Empty);
            } else
            {
                return call_with_values.callWithValues(frame65_1.lambda$Fn67, frame65_1.lambda$Fn68);
            }
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 68)
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
            if (modulemethod.selector == 69)
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

        public srfi1.frame64()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 69, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:783");
            lambda$Fn66 = modulemethod;
        }
    }

    public class srfi1.frame65 extends ModuleBody
    {

        final ModuleMethod lambda$Fn67 = new ModuleMethod(this, 66, null, 0);
        final ModuleMethod lambda$Fn68;
        Object list;
        Object other$Mnlists;
        srfi1.frame64 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 66)
            {
                return lambda88();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 67)
            {
                return lambda89(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda88()
        {
            return srfi1.car$PlCdr(list);
        }

        Object lambda89(Object obj, Object obj1)
        {
            srfi1.frame66 frame66_1 = new srfi1.frame66();
            frame66_1.staticLink = this;
            frame66_1.a = obj;
            frame66_1.d = obj1;
            return call_with_values.callWithValues(frame66_1.lambda$Fn69, frame66_1.lambda$Fn70);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 66)
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
            if (modulemethod.selector == 67)
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

        public srfi1.frame65()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 67, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:785");
            lambda$Fn68 = modulemethod;
        }
    }

    public class srfi1.frame66 extends ModuleBody
    {

        Object a;
        Object d;
        final ModuleMethod lambda$Fn69 = new ModuleMethod(this, 64, null, 0);
        final ModuleMethod lambda$Fn70;
        srfi1.frame65 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 64)
            {
                return lambda90();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 65)
            {
                return lambda91(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda90()
        {
            return staticLink.staticLink.staticLink.lambda85recur(staticLink.other$Mnlists);
        }

        Object lambda91(Object obj, Object obj1)
        {
            return misc.values(new Object[] {
                lists.cons(a, obj), lists.cons(d, obj1)
            });
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 64)
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
            if (modulemethod.selector == 65)
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

        public srfi1.frame66()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 65, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:786");
            lambda$Fn70 = modulemethod;
        }
    }


    Continuation abort;
    cars.Mnfinal staticLink;

    public Object lambda85recur(Object obj)
    {
          = new <init>();
        .staticLink = this;
        .lists = obj;
        if (lists.isPair(.lists))
        {
            return call_with_values.callWithValues(.Fn65, .Fn66);
        } else
        {
            return misc.values(new Object[] {
                LList.list1(staticLink.Mnfinal), LList.Empty
            });
        }
    }

    public lambda.Fn66()
    {
    }
}
