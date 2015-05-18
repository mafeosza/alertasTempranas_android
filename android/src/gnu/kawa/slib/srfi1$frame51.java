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

public class lambda.Fn53 extends ModuleBody
{
    public class srfi1.frame52 extends ModuleBody
    {

        Object elt;
        final ModuleMethod lambda$Fn54;
        srfi1.frame51 staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 53)
            {
                return lambda71(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda71(Object obj)
        {
            return kawa.lib.lists.member(elt, obj, staticLink.$Eq);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 53)
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

        public srfi1.frame52()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 53, null, 4097);
            modulemethod.setProperty("source-location", "srfi1.scm:1580");
            lambda$Fn54 = modulemethod;
        }
    }


    Procedure $Eq;
    final ModuleMethod lambda$Fn53;
    LList lists;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 54)
        {
            if (lambda70(obj))
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

    boolean lambda70(Object obj)
    {
        int i = 0;
        lambda70 lambda70_1 = new <init>();
        lambda70_1.staticLink = this;
        lambda70_1.elt = obj;
        if (srfi1.any$V(lambda70_1.Fn54, lists, new Object[0]) != Boolean.FALSE)
        {
            i = 1;
        }
        return i + 1 & 1;
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 54)
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

    public lambda.Fn54()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 54, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1579");
        lambda$Fn53 = modulemethod;
    }
}
