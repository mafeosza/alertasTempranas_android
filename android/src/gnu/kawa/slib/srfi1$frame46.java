// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import kawa.lib.lists;
import kawa.standard.append;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn47 extends ModuleBody
{
    public class srfi1.frame47 extends ModuleBody
    {

        Object a$Mnint$Mnb;
        final ModuleMethod lambda$Fn48;
        srfi1.frame46 staticLink;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 45)
            {
                return lambda65(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda65(Object obj, Object obj1)
        {
            if (lists.member(obj, a$Mnint$Mnb, staticLink.staticLink.$Eq) != Boolean.FALSE)
            {
                return obj1;
            } else
            {
                return lists.cons(obj, obj1);
            }
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 45)
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

        public srfi1.frame47()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 45, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:1547");
            lambda$Fn48 = modulemethod;
        }
    }


    Object a;
    Object b;
    final ModuleMethod lambda$Fn46 = new ModuleMethod(this, 46, null, 0);
    final ModuleMethod lambda$Fn47;
     staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 46)
        {
            return lambda63();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 47)
        {
            return lambda64(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda63()
    {
        return srfi1.lsetDiff$PlIntersection$V(staticLink.Eq, a, new Object[] {
            b
        });
    }

    Object lambda64(Object obj, Object obj1)
    {
        b b1 = new <init>();
        b1.staticLink = this;
        b1.Mnb = obj1;
        if (lists.isNull(obj))
        {
            return srfi1.lsetDifference$V(staticLink.Eq, b, new Object[] {
                a
            });
        }
        if (lists.isNull(b1.Mnb))
        {
            return append.append$V(new Object[] {
                b, a
            });
        } else
        {
            return srfi1.fold$V(b1.Fn48, obj, b, new Object[0]);
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 46)
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
        if (modulemethod.selector == 47)
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

    public lambda.Fn48()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 47, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1544");
        lambda$Fn47 = modulemethod;
    }
}
