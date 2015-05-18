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

public class lambda.Fn39 extends ModuleBody
{
    public class srfi1.frame40 extends ModuleBody
    {

        final ModuleMethod lambda$Fn40;
        srfi1.frame39 staticLink;
        Object x;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 39)
            {
                return lambda57(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda57(Object obj)
        {
            return kawa.lib.lists.member(x, obj, staticLink.$Eq);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 39)
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

        public srfi1.frame40()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 39, null, 4097);
            modulemethod.setProperty("source-location", "srfi1.scm:1510");
            lambda$Fn40 = modulemethod;
        }
    }


    Procedure $Eq;
    final ModuleMethod lambda$Fn39;
    Object lists;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 40)
        {
            return lambda56(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda56(Object obj)
    {
        lambda56 lambda56_1 = new <init>();
        lambda56_1.staticLink = this;
        lambda56_1.x = obj;
        return srfi1.every$V(lambda56_1.Fn40, lists, new Object[0]);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 40)
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

    public lambda.Fn40()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 40, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1509");
        lambda$Fn39 = modulemethod;
    }
}
