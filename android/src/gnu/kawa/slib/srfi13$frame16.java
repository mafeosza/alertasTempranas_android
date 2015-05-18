// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.WrongType;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    Object end1;
    final ModuleMethod lambda$Fn38 = new ModuleMethod(this, 32, null, 0);
    final ModuleMethod lambda$Fn39 = new ModuleMethod(this, 33, null, 8194);
    Object rest;
    Object start1;
    _cls2 staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 32)
        {
            return lambda38();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 33)
        {
            return Integer.valueOf(lambda39(obj, obj1));
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda38()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnprefix$Mnlength$Mnci, staticLink.s2, rest);
    }

    int lambda39(Object obj, Object obj1)
    {
        Object obj2 = staticLink.s1;
        Object obj3 = start1;
        int i;
        int j;
        int k;
        int l;
        try
        {
            i = ((Number)obj3).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-prefix-length-ci", 1, obj3);
        }
        obj3 = end1;
        try
        {
            j = ((Number)obj3).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-prefix-length-ci", 2, obj3);
        }
        obj3 = staticLink.s2;
        try
        {
            k = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "%string-prefix-length-ci", 4, obj);
        }
        try
        {
            l = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-prefix-length-ci", 5, obj1);
        }
        return srfi13.$PcStringPrefixLengthCi(obj2, i, j, obj3, k, l);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 32)
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
        if (modulemethod.selector == 33)
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

    public ()
    {
    }
}
