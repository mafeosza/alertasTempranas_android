// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn34 extends ModuleBody
{
    public class srfi1.frame36 extends ModuleBody
    {

        Object elt;
        final ModuleMethod lambda$Fn36;
        srfi1.frame35 staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 34)
            {
                return lambda53(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda53(Object obj)
        {
            return staticLink.$Eq.apply2(obj, elt);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 34)
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

        public srfi1.frame36()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 34, null, 4097);
            modulemethod.setProperty("source-location", "srfi1.scm:1490");
            lambda$Fn36 = modulemethod;
        }
    }


    Procedure $Eq;
    final ModuleMethod lambda$Fn34;
    final ModuleMethod lambda$Fn35;

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 35: // '#'
            return lambda52(obj, obj1);

        case 36: // '$'
            return lambda51(obj, obj1);
        }
    }

    Object lambda51(Object obj, Object obj1)
    {
        if (!lists.isNull(obj))
        {
            if (lists.isNull(obj1))
            {
                return obj;
            }
            if (obj != obj1)
            {
                return srfi1.pairFold$V(lambda$Fn35, obj1, obj, new Object[0]);
            }
        }
        return obj1;
    }

    Object lambda52(Object obj, Object obj1)
    {
        Object obj2 = new <init>();
        obj2.staticLink = this;
        obj2.elt = lists.car.apply1(obj);
        if (srfi1.any$V((() (obj2)).Fn36, obj1, new Object[0]) != Boolean.FALSE)
        {
            return obj1;
        }
        try
        {
            obj2 = (Pair)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "set-cdr!", 1, obj);
        }
        lists.setCdr$Ex(((Pair) (obj2)), obj1);
        return obj;
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 36: // '$'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 35: // '#'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public lambda.Fn36()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 35, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1488");
        lambda$Fn35 = modulemethod;
        modulemethod = new ModuleMethod(this, 36, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1483");
        lambda$Fn34 = modulemethod;
    }
}
