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
    final ModuleMethod lambda$Fn25 = new ModuleMethod(this, 22, null, 0);
    final ModuleMethod lambda$Fn26 = new ModuleMethod(this, 23, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 22)
        {
            return lambda25();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 23)
        {
            return lambda26(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda25()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnany, s, maybe$Mnstart$Plend);
    }

    Object lambda26(Object obj, Object obj1)
    {
        if (!characters.isChar(criterion)) goto _L2; else goto _L1
_L1:
        Object obj2;
        Object obj3;
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
        obj3 = criterion;
        try
        {
            obj2 = (Char)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "char=?", 1, obj3);
        }
        obj3 = s;
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
        flag = characters.isChar$Eq(((Char) (obj2)), Char.make(strings.stringRef(((CharSequence) (obj4)), i)));
        if (!flag) goto _L6; else goto _L5
_L5:
        if (flag)
        {
            obj = Boolean.TRUE;
        } else
        {
            obj = Boolean.FALSE;
        }
_L7:
        return obj;
_L6:
        obj = AddOp.$Pl.apply2(obj, srfi13.Lit1);
          goto _L1
_L4:
        if (flag)
        {
            obj = Boolean.TRUE;
        } else
        {
            obj = Boolean.FALSE;
        }
          goto _L7
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
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 515, 5);
            throw obj;
        }
        if (((Procedure) (obj2)).apply2(obj3, criterion) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_298;
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
            break MISSING_BLOCK_LABEL_285;
        }
        obj = Scheme.applyToArgs;
        obj3 = srfi13.loc$char$Mnset$Mncontains$Qu;
        try
        {
            obj4 = ((Location) (obj3)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 518, 9);
            throw obj;
        }
        obj5 = criterion;
        obj3 = s;
        try
        {
            charsequence = (CharSequence)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj3);
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
        obj3 = ((Procedure) (obj)).apply3(obj4, obj5, Char.make(strings.stringRef(charsequence, i)));
        obj = obj3;
        if (obj3 != Boolean.FALSE) goto _L7; else goto _L8
_L8:
        obj2 = AddOp.$Pl.apply2(obj2, srfi13.Lit1);
        break MISSING_BLOCK_LABEL_173;
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
        if (!misc.isProcedure(criterion))
        {
            break MISSING_BLOCK_LABEL_447;
        }
        obj2 = Scheme.numLss.apply2(obj, obj1);
        try
        {
            flag = ((Boolean)obj2).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj2);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_434;
        }
        obj2 = s;
        try
        {
            obj3 = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj2);
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
        i = strings.stringRef(((CharSequence) (obj3)), i);
        obj2 = AddOp.$Pl.apply2(obj, srfi13.Lit1);
        if (Scheme.numEqu.apply2(obj2, obj1) != Boolean.FALSE)
        {
            return Scheme.applyToArgs.apply2(criterion, Char.make(i));
        }
        obj3 = Scheme.applyToArgs.apply2(criterion, Char.make(i));
        obj = obj3;
        if (obj3 != Boolean.FALSE) goto _L7; else goto _L9
_L9:
        obj = obj2;
        break MISSING_BLOCK_LABEL_331;
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
        return misc.error$V("Second param is neither char-set, char, or predicate procedure.", new Object[] {
            srfi13.string$Mnany, criterion
        });
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 22)
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
        if (modulemethod.selector == 23)
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
