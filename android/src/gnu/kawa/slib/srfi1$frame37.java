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

public class lambda.Fn37 extends ModuleBody
{
    public class srfi1.frame38 extends ModuleBody
    {

        final ModuleMethod lambda$Fn38;
        srfi1.frame37 staticLink;
        Object x;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 37)
            {
                return lambda55(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda55(Object obj)
        {
            return kawa.lib.lists.member(x, obj, staticLink.$Eq);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 37)
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

        public srfi1.frame38()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 37, null, 4097);
            modulemethod.setProperty("source-location", "srfi1.scm:1502");
            lambda$Fn38 = modulemethod;
        }
    }


    Procedure $Eq;
    final ModuleMethod lambda$Fn37;
    Object lists;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 38)
        {
            return lambda54(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda54(Object obj)
    {
        lambda54 lambda54_1 = new <init>();
        lambda54_1.staticLink = this;
        lambda54_1.x = obj;
        return srfi1.every$V(lambda54_1.Fn38, lists, new Object[0]);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 38)
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

    public lambda.Fn38()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 38, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1501");
        lambda$Fn37 = modulemethod;
    }
}
