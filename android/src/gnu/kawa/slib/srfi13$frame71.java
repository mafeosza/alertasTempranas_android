// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongType;
import kawa.lib.numbers;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class ception extends ModuleBody
{

    final ModuleMethod lambda$Fn161 = new ModuleMethod(this, 138, null, 0);
    final ModuleMethod lambda$Fn162 = new ModuleMethod(this, 139, null, 8194);
    Object n;
    Object s;

    static boolean lambda163(Object obj)
    {
        boolean flag1 = numbers.isInteger(obj);
        boolean flag = flag1;
        if (flag1)
        {
            boolean flag2 = numbers.isExact(obj);
            flag = flag2;
            if (flag2)
            {
                flag = ((Boolean)Scheme.numLEq.apply2(srfi13.Lit0, obj)).booleanValue();
            }
        }
        return flag;
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 138)
        {
            return lambda161();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 139)
        {
            return lambda162(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda161()
    {
        ModuleMethod modulemethod = srfi13.string$Mnpad$Mnright;
        Object obj = s;
        Object obj1 = srfi13.loc$rest;
        try
        {
            obj1 = ((Location) (obj1)).get();
        }
        catch (UnboundLocationException unboundlocationexception)
        {
            unboundlocationexception.setLine("srfi13.scm", 1046, 58);
            throw unboundlocationexception;
        }
        return srfi13.stringParseFinalStart$PlEnd(modulemethod, obj, obj1);
    }

    Object lambda162(Object obj, Object obj1)
    {
        Object obj2 = Scheme.applyToArgs;
        Object obj3 = srfi13.loc$check$Mnarg;
        try
        {
            obj3 = ((Location) (obj3)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1047, 7);
            throw obj;
        }
        ((Procedure) (obj2)).apply4(obj3, srfi13.lambda$Fn163, n, srfi13.string$Mnpad$Mnright);
        obj2 = AddOp.$Mn.apply2(obj1, obj);
        if (Scheme.numLEq.apply2(n, obj2) != Boolean.FALSE)
        {
            obj1 = s;
            CharSequence charsequence;
            CharSequence charsequence1;
            int i;
            int j;
            try
            {
                obj2 = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "%substring/shared", 0, obj1);
            }
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "%substring/shared", 1, obj);
            }
            obj = AddOp.$Pl.apply2(obj, n);
            try
            {
                j = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "%substring/shared", 2, obj);
            }
            return srfi13.$PcSubstring$SlShared(((CharSequence) (obj2)), i, j);
        }
        obj2 = n;
        try
        {
            i = ((Number)obj2).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "make-string", 1, obj2);
        }
        charsequence = strings.makeString(i, LangPrimType.charType);
        obj2 = s;
        try
        {
            charsequence1 = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-copy!", 2, obj2);
        }
        try
        {
            i = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "%string-copy!", 3, obj);
        }
        try
        {
            j = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-copy!", 4, obj1);
        }
        srfi13.$PcStringCopy$Ex(charsequence, 0, charsequence1, i, j);
        return charsequence;
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 138)
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
        if (modulemethod.selector == 139)
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

    public ception()
    {
    }
}
