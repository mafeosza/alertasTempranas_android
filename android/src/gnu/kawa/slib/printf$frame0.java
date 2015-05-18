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
import gnu.math.Complex;
import gnu.text.Char;
import kawa.lib.numbers;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class lambda.Fn3 extends ModuleBody
{
    public class printf.frame1 extends ModuleBody
    {

        Object digs;
        Object ex;
        final ModuleMethod lambda$Fn4;
        Object sgn;
        printf.frame0 staticLink;

        public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
        {
            if (modulemethod.selector == 1)
            {
                return lambda8(obj, obj1, obj2);
            } else
            {
                return super.apply3(modulemethod, obj, obj1, obj2);
            }
        }

        Object lambda8(Object obj, Object obj1, Object obj2)
        {
            return Scheme.applyToArgs.applyN(new Object[] {
                staticLink.staticLink.proc, sgn, digs, ex, obj, obj1, obj2
            });
        }

        public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
        {
            if (modulemethod.selector == 1)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            } else
            {
                return super.match3(modulemethod, obj, obj1, obj2, callcontext);
            }
        }

        public printf.frame1()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 12291);
            modulemethod.setProperty("source-location", "printf.scm:126");
            lambda$Fn4 = modulemethod;
        }
    }


    Object digs;
    Object ex;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    Object num;
    Object sgn;
     staticLink;

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 3)
        {
            return lambda7(obj, obj1, obj2);
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        if (modulemethod.selector == 2)
        {
            return lambda6(obj, obj1, obj2, obj3);
        } else
        {
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);
        }
    }

    Object lambda6(Object obj, Object obj1, Object obj2, Object obj3)
    {
        Object obj4;
        obj4 = Scheme.numEqu.apply2(obj, Integer.valueOf(staticLink. - 1));
        Char char1;
        CharSequence charsequence;
        int i;
        boolean flag;
        try
        {
            flag = ((Boolean)obj4).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj4);
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        char1 = printf.Lit3;
        obj4 = staticLink.tr;
        try
        {
            charsequence = (CharSequence)obj4;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj4);
        }
        try
        {
            i = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
        }
        if (!unicode.isCharCi$Eq(char1, Char.make(strings.stringRef(charsequence, i)))) goto _L4; else goto _L3
_L3:
        return Scheme.applyToArgs.applyN(new Object[] {
            staticLink.roc, sgn, digs, ex, obj1, obj2, obj3
        });
_L2:
        if (flag) goto _L3; else goto _L4
_L4:
        return ambda1parseError();
    }

    Object lambda7(Object obj, Object obj1, Object obj2)
    {
          = new <init>();
        .staticLink = this;
        .sgn = obj;
        .digs = obj1;
        .ex = obj2;
        obj = num;
        try
        {
            obj1 = (Complex)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "imag-part", 1, obj);
        }
        return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.imagPart(((Complex) (obj1)))), .Fn4);
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        if (modulemethod.selector == 3)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        } else
        {
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);
        }
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        if (modulemethod.selector == 2)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.value4 = obj3;
            callcontext.proc = modulemethod;
            callcontext.pc = 4;
            return 0;
        } else
        {
            return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);
        }
    }

    public lambda.Fn4()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 2, null, 16388);
        modulemethod.setProperty("source-location", "printf.scm:111");
        lambda$Fn2 = modulemethod;
        modulemethod = new ModuleMethod(this, 3, null, 12291);
        modulemethod.setProperty("source-location", "printf.scm:123");
        lambda$Fn3 = modulemethod;
    }
}
