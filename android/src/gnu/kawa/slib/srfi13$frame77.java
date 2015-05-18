// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class ception extends ModuleBody
{

    Object criterion;
    final ModuleMethod lambda$Fn177 = new ModuleMethod(this, 152, null, 0);
    final ModuleMethod lambda$Fn178 = new ModuleMethod(this, 153, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 152)
        {
            return lambda177();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 153)
        {
            return lambda178(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda177()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnindex, str, maybe$Mnstart$Plend);
    }

    Object lambda178(Object obj, Object obj1)
    {
        if (!characters.isChar(criterion)) goto _L2; else goto _L1
_L1:
        Object obj2;
        obj2 = Scheme.numLss.apply2(obj, obj1);
        Object obj4;
        Object obj5;
        CharSequence charsequence;
        int i;
        boolean flag;
        try
        {
            flag = ((Boolean)obj2).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj2);
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        Object obj3 = criterion;
        try
        {
            obj2 = (Char)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "char=?", 1, obj3);
        }
        obj3 = str;
        try
        {
            obj4 = (CharSequence)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj3);
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
        if (!characters.isChar$Eq(((Char) (obj2)), Char.make(strings.stringRef(((CharSequence) (obj4)), i)))) goto _L6; else goto _L5
_L5:
        return obj;
_L6:
        obj = AddOp.$Pl.apply2(obj, srfi13.Lit1);
          goto _L1
_L4:
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
_L2:
        obj2 = Scheme.applyToArgs;
        obj3 = srfi13.loc$char$Mnset$Qu;
        try
        {
            obj3 = ((Location) (obj3)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1159, 5);
            throw obj;
        }
        if (((Procedure) (obj2)).apply2(obj3, criterion) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        obj2 = obj;
        obj = Scheme.numLss.apply2(obj2, obj1);
        try
        {
            flag = ((Boolean)obj).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "x", -2, obj);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        obj3 = Scheme.applyToArgs;
        obj = srfi13.loc$char$Mnset$Mncontains$Qu;
        try
        {
            obj4 = ((Location) (obj)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1162, 9);
            throw obj;
        }
        obj5 = criterion;
        obj = str;
        try
        {
            charsequence = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
        }
        try
        {
            i = ((Number)obj2).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj2);
        }
        obj = obj2;
        if (((Procedure) (obj3)).apply3(obj4, obj5, Char.make(strings.stringRef(charsequence, i))) != Boolean.FALSE) goto _L5; else goto _L7
_L7:
        obj2 = AddOp.$Pl.apply2(obj2, srfi13.Lit1);
        break MISSING_BLOCK_LABEL_147;
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
        if (!misc.isProcedure(criterion))
        {
            break MISSING_BLOCK_LABEL_383;
        }
        obj2 = obj;
_L9:
        obj = Scheme.numLss.apply2(obj2, obj1);
        try
        {
            flag = ((Boolean)obj).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "x", -2, obj);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        obj3 = Scheme.applyToArgs;
        obj4 = criterion;
        obj = str;
        try
        {
            obj5 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
        }
        try
        {
            i = ((Number)obj2).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj2);
        }
        obj = obj2;
        if (((Procedure) (obj3)).apply2(obj4, Char.make(strings.stringRef(((CharSequence) (obj5)), i))) != Boolean.FALSE) goto _L5; else goto _L8
_L8:
        obj2 = AddOp.$Pl.apply2(obj2, srfi13.Lit1);
          goto _L9
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
        return misc.error$V("Second param is neither char-set, char, or predicate procedure.", new Object[] {
            srfi13.string$Mnindex, criterion
        });
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 152)
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
        if (modulemethod.selector == 153)
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
