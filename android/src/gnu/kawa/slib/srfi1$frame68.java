// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.call_with_values;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn72 extends ModuleBody
{
    public class srfi1.frame69 extends ModuleBody
    {

        final ModuleMethod lambda$Fn73 = new ModuleMethod(this, 72, null, 0);
        final ModuleMethod lambda$Fn74;
        Object list;
        Object other$Mnlists;
        srfi1.frame68 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 72)
            {
                return lambda95();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 73)
            {
                return lambda96(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda95()
        {
            return srfi1.car$PlCdr(list);
        }

        Object lambda96(Object obj, Object obj1)
        {
            srfi1.frame70 frame70_1 = new srfi1.frame70();
            frame70_1.staticLink = this;
            frame70_1.a = obj;
            frame70_1.d = obj1;
            return call_with_values.callWithValues(frame70_1.lambda$Fn75, frame70_1.lambda$Fn76);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 72)
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
            if (modulemethod.selector == 73)
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

        public srfi1.frame69()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 73, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:795");
            lambda$Fn74 = modulemethod;
        }
    }

    public class srfi1.frame70 extends ModuleBody
    {

        Object a;
        Object d;
        final ModuleMethod lambda$Fn75 = new ModuleMethod(this, 70, null, 0);
        final ModuleMethod lambda$Fn76;
        srfi1.frame69 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 70)
            {
                return lambda97();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 71)
            {
                return lambda98(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda97()
        {
            return srfi1.frame67.lambda92recur(staticLink.other$Mnlists);
        }

        Object lambda98(Object obj, Object obj1)
        {
            return misc.values(new Object[] {
                kawa.lib.lists.cons(a, obj), kawa.lib.lists.cons(d, obj1)
            });
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 70)
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
            if (modulemethod.selector == 71)
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

        public srfi1.frame70()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 71, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:796");
            lambda$Fn76 = modulemethod;
        }
    }


    final ModuleMethod lambda$Fn71 = new ModuleMethod(this, 74, null, 0);
    final ModuleMethod lambda$Fn72;
    Object lists;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 74)
        {
            return lambda93();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 75)
        {
            return lambda94(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda93()
    {
        return srfi1.car$PlCdr(lists);
    }

    Object lambda94(Object obj, Object obj1)
    {
        lists lists1 = new <init>();
        lists1.staticLink = this;
        lists1.list = obj;
        lists1.Mnlists = obj1;
        return call_with_values.callWithValues(lists1.Fn73, lists1.Fn74);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 74)
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
        if (modulemethod.selector == 75)
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

    public lambda.Fn74()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 75, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:794");
        lambda$Fn72 = modulemethod;
    }
}
