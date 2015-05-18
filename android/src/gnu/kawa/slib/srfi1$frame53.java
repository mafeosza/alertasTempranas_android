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
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn55 extends ModuleBody
{
    public class srfi1.frame54 extends ModuleBody
    {

        Object elt;
        final ModuleMethod lambda$Fn56;
        srfi1.frame53 staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 55)
            {
                return lambda73(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda73(Object obj)
        {
            return kawa.lib.lists.member(elt, obj, staticLink.$Eq);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 55)
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

        public srfi1.frame54()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 55, null, 4097);
            modulemethod.setProperty("source-location", "srfi1.scm:1588");
            lambda$Fn56 = modulemethod;
        }
    }


    Procedure $Eq;
    final ModuleMethod lambda$Fn55;
    LList lists;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 56)
        {
            if (lambda72(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    boolean lambda72(Object obj)
    {
        int i = 0;
        lambda72 lambda72_1 = new <init>();
        lambda72_1.staticLink = this;
        lambda72_1.elt = obj;
        if (srfi1.any$V(lambda72_1.Fn56, lists, new Object[0]) != Boolean.FALSE)
        {
            i = 1;
        }
        return i + 1 & 1;
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 56)
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

    public lambda.Fn56()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 56, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1587");
        lambda$Fn55 = modulemethod;
    }
}
