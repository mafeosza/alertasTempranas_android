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

public class lambda.Fn58 extends ModuleBody
{
    public class srfi1.frame58 extends ModuleBody
    {

        final ModuleMethod lambda$Fn57 = new ModuleMethod(this, 61, null, 0);
        final ModuleMethod lambda$Fn58;
        Object lists;
        srfi1.frame57 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 61)
            {
                return lambda77();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 62)
            {
                return lambda78(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda77()
        {
            return srfi1.car$PlCdr(lists);
        }

        Object lambda78(Object obj, Object obj1)
        {
            srfi1.frame59 frame59_1 = new srfi1.frame59();
            frame59_1.staticLink = this;
            frame59_1.list = obj;
            frame59_1.other$Mnlists = obj1;
            if (srfi1.isNullList(frame59_1.list) != Boolean.FALSE)
            {
                return staticLink.abort.apply2(LList.Empty, LList.Empty);
            } else
            {
                return call_with_values.callWithValues(frame59_1.lambda$Fn59, frame59_1.lambda$Fn60);
            }
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 61)
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
            if (modulemethod.selector == 62)
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

        public srfi1.frame58()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 62, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:762");
            lambda$Fn58 = modulemethod;
        }
    }

    public class srfi1.frame59 extends ModuleBody
    {

        final ModuleMethod lambda$Fn59 = new ModuleMethod(this, 59, null, 0);
        final ModuleMethod lambda$Fn60;
        Object list;
        Object other$Mnlists;
        srfi1.frame58 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 59)
            {
                return lambda79();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 60)
            {
                return lambda80(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda79()
        {
            return srfi1.car$PlCdr(list);
        }

        Object lambda80(Object obj, Object obj1)
        {
            srfi1.frame60 frame60_1 = new srfi1.frame60();
            frame60_1.staticLink = this;
            frame60_1.a = obj;
            frame60_1.d = obj1;
            return call_with_values.callWithValues(frame60_1.lambda$Fn61, frame60_1.lambda$Fn62);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 59)
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
            if (modulemethod.selector == 60)
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

        public srfi1.frame59()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 60, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:764");
            lambda$Fn60 = modulemethod;
        }
    }

    public class srfi1.frame60 extends ModuleBody
    {

        Object a;
        Object d;
        final ModuleMethod lambda$Fn61 = new ModuleMethod(this, 57, null, 0);
        final ModuleMethod lambda$Fn62;
        srfi1.frame59 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 57)
            {
                return lambda81();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 58)
            {
                return lambda82(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda81()
        {
            return staticLink.staticLink.staticLink.lambda76recur(staticLink.other$Mnlists);
        }

        Object lambda82(Object obj, Object obj1)
        {
            return misc.values(new Object[] {
                lists.cons(a, obj), lists.cons(d, obj1)
            });
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 57)
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
            if (modulemethod.selector == 58)
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

        public srfi1.frame60()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 58, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:765");
            lambda$Fn62 = modulemethod;
        }
    }


    Continuation abort;

    public Object lambda76recur(Object obj)
    {
          = new <init>();
        .staticLink = this;
        .lists = obj;
        if (lists.isPair(.lists))
        {
            return call_with_values.callWithValues(.Fn57, .Fn58);
        } else
        {
            return misc.values(new Object[] {
                LList.Empty, LList.Empty
            });
        }
    }

    public lambda.Fn58()
    {
    }
}
