// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;

public class XStrings extends ModuleBody
{

    public static final XStrings $instance;
    static final IntNum Lit0 = IntNum.make(0x7fffffff);
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    public static final ModuleMethod string$Mnlength;
    public static final ModuleMethod substring;

    public XStrings()
    {
        ModuleInfo.register(this);
    }

    public static Object stringLength(Object obj)
    {
        if (obj == Values.empty)
        {
            return Values.empty;
        } else
        {
            return Integer.valueOf(((String)obj).length());
        }
    }

    public static Object substring(Object obj, Object obj1)
    {
        return substring(obj, obj1, Lit0);
    }

    public static Object substring(Object obj, Object obj1, Object obj2)
    {
        int i;
        if (obj == Values.empty)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!i) goto _L2; else goto _L1
_L1:
        if (!i) goto _L4; else goto _L3
_L3:
        return Values.empty;
_L2:
        String s;
        int j;
        int k;
        if (obj1 == Values.empty)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0 ? obj2 != Values.empty : i == 0) goto _L4; else goto _L3
_L4:
        try
        {
            s = (String)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "s", -2, obj);
        }
        j = s.length();
        try
        {
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "sindex", -2, obj1);
        }
        k = i - 1;
        try
        {
            i = ((Number)obj2).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "len", -2, obj2);
        }
        j -= k;
        if (i > j)
        {
            i = j;
        }
        return s.substring(k, k + i);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 3)
        {
            return stringLength(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 1)
        {
            return substring(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 1)
        {
            return substring(obj, obj1, obj2);
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 3)
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

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
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

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit2 = (SimpleSymbol)(new SimpleSymbol("string-length")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("substring")).readResolve();
        $instance = new XStrings();
        XStrings xstrings = $instance;
        substring = new ModuleMethod(xstrings, 1, Lit1, 12290);
        string$Mnlength = new ModuleMethod(xstrings, 3, Lit2, 4097);
        $instance.run();
    }
}
