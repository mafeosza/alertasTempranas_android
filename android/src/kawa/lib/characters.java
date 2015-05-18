// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.text.Char;

public class characters extends ModuleBody
{

    public static final characters $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    public static final ModuleMethod char$Eq$Qu;
    public static final ModuleMethod char$Gr$Eq$Qu;
    public static final ModuleMethod char$Gr$Qu;
    public static final ModuleMethod char$Ls$Eq$Qu;
    public static final ModuleMethod char$Ls$Qu;
    public static final ModuleMethod char$Mn$Grinteger;
    public static final ModuleMethod char$Qu;
    public static final ModuleMethod integer$Mn$Grchar;

    public characters()
    {
        ModuleInfo.register(this);
    }

    public static int char$To$Integer(Char char1)
    {
        return char1.intValue();
    }

    public static Char integer$To$Char(int i)
    {
        return Char.make(i);
    }

    public static boolean isChar(Object obj)
    {
        return obj instanceof Char;
    }

    public static boolean isChar$Eq(Char char1, Char char2)
    {
        return char1.intValue() == char2.intValue();
    }

    public static boolean isChar$Gr(Char char1, Char char2)
    {
        return char1.intValue() > char2.intValue();
    }

    public static boolean isChar$Gr$Eq(Char char1, Char char2)
    {
        return char1.intValue() >= char2.intValue();
    }

    public static boolean isChar$Ls(Char char1, Char char2)
    {
        return char1.intValue() < char2.intValue();
    }

    public static boolean isChar$Ls$Eq(Char char1, Char char2)
    {
        return char1.intValue() <= char2.intValue();
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            if (isChar(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 2: // '\002'
            int i;
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char->integer", 1, obj);
            }
            return Integer.valueOf(char$To$Integer(modulemethod));

        case 3: // '\003'
            break;
        }
        try
        {
            i = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "integer->char", 1, obj);
        }
        return integer$To$Char(i);
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 4: // '\004'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char=?", 1, obj);
            }
            try
            {
                obj = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char=?", 2, obj1);
            }
            if (isChar$Eq(modulemethod, ((Char) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 5: // '\005'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char<?", 1, obj);
            }
            try
            {
                obj = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char<?", 2, obj1);
            }
            if (isChar$Ls(modulemethod, ((Char) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 6: // '\006'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char>?", 1, obj);
            }
            try
            {
                obj = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char>?", 2, obj1);
            }
            if (isChar$Gr(modulemethod, ((Char) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 7: // '\007'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char<=?", 1, obj);
            }
            try
            {
                obj = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char<=?", 2, obj1);
            }
            if (isChar$Ls$Eq(modulemethod, ((Char) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 8: // '\b'
            break;
        }
        try
        {
            modulemethod = (Char)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "char>=?", 1, obj);
        }
        try
        {
            obj = (Char)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "char>=?", 2, obj1);
        }
        if (isChar$Gr$Eq(modulemethod, ((Char) (obj))))
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 3: // '\003'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 2: // '\002'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 1: // '\001'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 4 8: default 44
    //                   4 230
    //                   5 187
    //                   6 144
    //                   7 101
    //                   8 58;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        i = super.match2(modulemethod, obj, obj1, callcontext);
_L8:
        return i;
_L6:
        if (obj instanceof Char)
        {
            callcontext.value1 = obj;
            if (!(obj1 instanceof Char))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (obj instanceof Char)
        {
            callcontext.value1 = obj;
            if (!(obj1 instanceof Char))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (obj instanceof Char)
        {
            callcontext.value1 = obj;
            if (!(obj1 instanceof Char))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (obj instanceof Char)
        {
            callcontext.value1 = obj;
            if (!(obj1 instanceof Char))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (obj instanceof Char)
        {
            callcontext.value1 = obj;
            if (!(obj1 instanceof Char))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit7 = (SimpleSymbol)(new SimpleSymbol("char>=?")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("char<=?")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("char>?")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("char<?")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("char=?")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("integer->char")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("char->integer")).readResolve();
        Lit0 = (SimpleSymbol)(new SimpleSymbol("char?")).readResolve();
        $instance = new characters();
        characters characters1 = $instance;
        char$Qu = new ModuleMethod(characters1, 1, Lit0, 4097);
        char$Mn$Grinteger = new ModuleMethod(characters1, 2, Lit1, 4097);
        integer$Mn$Grchar = new ModuleMethod(characters1, 3, Lit2, 4097);
        char$Eq$Qu = new ModuleMethod(characters1, 4, Lit3, 8194);
        char$Ls$Qu = new ModuleMethod(characters1, 5, Lit4, 8194);
        char$Gr$Qu = new ModuleMethod(characters1, 6, Lit5, 8194);
        char$Ls$Eq$Qu = new ModuleMethod(characters1, 7, Lit6, 8194);
        char$Gr$Eq$Qu = new ModuleMethod(characters1, 8, Lit7, 8194);
        $instance.run();
    }
}
