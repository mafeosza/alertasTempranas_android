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
import kawa.standard.Scheme;
import kawa.standard.call_with_values;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn10 extends ModuleBody
{
    public class srfi1.frame8 extends ModuleBody
    {

        Object ans;
        final ModuleMethod lambda$Fn10;
        final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, 0);
        Object lists;
        srfi1.frame7 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 9)
            {
                return lambda15();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 10)
            {
                return lambda16(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda15()
        {
            return srfi1.$PcCars$PlCdrs$Pl(lists, ans);
        }

        Object lambda16(Object obj, Object obj1)
        {
            if (kawa.lib.lists.isNull(obj))
            {
                return ans;
            } else
            {
                return staticLink.lambda14lp(obj1, Scheme.apply.apply2(staticLink.kons, obj));
            }
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 9)
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
            if (modulemethod.selector == 10)
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

        public srfi1.frame8()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 10, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:859");
            lambda$Fn10 = modulemethod;
        }
    }


    Procedure kons;

    public Object lambda14lp(Object obj, Object obj1)
    {
        > > = new <init>();
        >.staticLink = this;
        >.lists = obj;
        >.ans = obj1;
        return call_with_values.callWithValues(>.Fn9, >.Fn10);
    }

    public lambda.Fn10()
    {
    }
}
