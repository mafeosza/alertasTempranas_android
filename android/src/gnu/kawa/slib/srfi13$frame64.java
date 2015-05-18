// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import kawa.lib.numbers;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class lambda.Fn151 extends ModuleBody
{

    final ModuleMethod lambda$Fn151;
    Object n;
    Object s;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 128)
        {
            if (lambda151(obj))
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

    boolean lambda151(Object obj)
    {
        boolean flag1 = numbers.isInteger(n);
        boolean flag = flag1;
        if (flag1)
        {
            boolean flag2 = numbers.isExact(n);
            flag = flag2;
            if (flag2)
            {
                gnu.kawa.functions.NumberCompare numbercompare = Scheme.numLEq;
                gnu.math.IntNum intnum = srfi13.Lit0;
                Object obj1 = n;
                obj = s;
                CharSequence charsequence;
                try
                {
                    charsequence = (CharSequence)obj;
                }
                catch (ClassCastException classcastexception)
                {
                    throw new WrongType(classcastexception, "string-length", 1, obj);
                }
                flag = ((Boolean)numbercompare.apply3(intnum, obj1, Integer.valueOf(strings.stringLength(charsequence)))).booleanValue();
            }
        }
        return flag;
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 128)
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

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 128, null, 4097);
        modulemethod.setProperty("source-location", "srfi13.scm:996");
        lambda$Fn151 = modulemethod;
    }
}
