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
    final ModuleMethod lambda$Fn179 = new ModuleMethod(this, 154, null, 0);
    final ModuleMethod lambda$Fn180 = new ModuleMethod(this, 155, null, 8194);
    LList maybe$Mnstart$Plend;
    Object str;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 154)
        {
            return lambda179();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 155)
        {
            return lambda180(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda179()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnindex$Mnright, str, maybe$Mnstart$Plend);
    }

    Object lambda180(Object obj, Object obj1)
    {
        if (!characters.isChar(criterion)) goto _L2; else goto _L1
_L1:
        obj1 = AddOp.$Mn.apply2(obj1, srfi13.Lit1);
_L7:
        Object obj2;
        obj2 = Scheme.numGEq.apply2(obj1, obj);
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
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
        }
        if (!characters.isChar$Eq(((Char) (obj2)), Char.make(strings.stringRef(((CharSequence) (obj4)), i)))) goto _L6; else goto _L5
_L5:
        return obj1;
_L6:
        obj1 = AddOp.$Mn.apply2(obj1, srfi13.Lit1);
          goto _L7
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
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1179, 5);
            throw obj;
        }
        if (((Procedure) (obj2)).apply2(obj3, criterion) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        obj2 = AddOp.$Mn.apply2(obj1, srfi13.Lit1);
        obj1 = Scheme.numGEq.apply2(obj2, obj);
        try
        {
            flag = ((Boolean)obj1).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj1);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        obj3 = Scheme.applyToArgs;
        obj1 = srfi13.loc$char$Mnset$Mncontains$Qu;
        try
        {
            obj4 = ((Location) (obj1)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1182, 9);
            throw obj;
        }
        obj5 = criterion;
        obj1 = str;
        try
        {
            charsequence = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj1);
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
        obj1 = obj2;
        if (((Procedure) (obj3)).apply3(obj4, obj5, Char.make(strings.stringRef(charsequence, i))) != Boolean.FALSE) goto _L5; else goto _L8
_L8:
        obj2 = AddOp.$Mn.apply2(obj2, srfi13.Lit1);
        break MISSING_BLOCK_LABEL_167;
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
        if (!misc.isProcedure(criterion))
        {
            break MISSING_BLOCK_LABEL_412;
        }
        obj2 = AddOp.$Mn.apply2(obj1, srfi13.Lit1);
_L10:
        obj1 = Scheme.numGEq.apply2(obj2, obj);
        try
        {
            flag = ((Boolean)obj1).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj1);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        obj3 = Scheme.applyToArgs;
        obj4 = criterion;
        obj1 = str;
        try
        {
            obj5 = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj1);
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
        obj1 = obj2;
        if (((Procedure) (obj3)).apply2(obj4, Char.make(strings.stringRef(((CharSequence) (obj5)), i))) != Boolean.FALSE) goto _L5; else goto _L9
_L9:
        obj2 = AddOp.$Mn.apply2(obj2, srfi13.Lit1);
          goto _L10
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
        return misc.error$V("Second param is neither char-set, char, or predicate procedure.", new Object[] {
            srfi13.string$Mnindex$Mnright, criterion
        });
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 154)
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
        if (modulemethod.selector == 155)
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
