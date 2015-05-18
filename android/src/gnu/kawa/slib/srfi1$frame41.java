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

public class lambda.Fn41 extends ModuleBody
{
    public class srfi1.frame42 extends ModuleBody
    {

        final ModuleMethod lambda$Fn42;
        srfi1.frame41 staticLink;
        Object x;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 41)
            {
                if (lambda59(obj))
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

        boolean lambda59(Object obj)
        {
            int i;
            if (kawa.lib.lists.member(x, obj, staticLink.$Eq) != Boolean.FALSE)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            return i + 1 & 1;
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 41)
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

        public srfi1.frame42()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 41, null, 4097);
            modulemethod.setProperty("source-location", "srfi1.scm:1519");
            lambda$Fn42 = modulemethod;
        }
    }


    Procedure $Eq;
    final ModuleMethod lambda$Fn41;
    Object lists;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 42)
        {
            return lambda58(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda58(Object obj)
    {
        lambda58 lambda58_1 = new <init>();
        lambda58_1.staticLink = this;
        lambda58_1.x = obj;
        return srfi1.every$V(lambda58_1.Fn42, lists, new Object[0]);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 42)
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

    public lambda.Fn42()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 42, null, 4097);
        modulemethod.setProperty("source-location", "srfi1.scm:1518");
        lambda$Fn41 = modulemethod;
    }
}
