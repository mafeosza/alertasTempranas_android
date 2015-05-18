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
    final ModuleMethod lambda$Fn185 = new ModuleMethod(this, 160, null, 0);
    final ModuleMethod lambda$Fn186 = new ModuleMethod(this, 161, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 160)
        {
            return lambda185();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 161)
        {
            return lambda186(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda185()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncount, s, maybe$Mnstart$Plend);
    }

    Object lambda186(Object obj, Object obj1)
    {
        if (!characters.isChar(criterion)) goto _L2; else goto _L1
_L1:
        Object obj2;
        Object obj3;
        obj2 = srfi13.Lit0;
        obj3 = obj;
_L5:
        obj = obj2;
        if (Scheme.numGEq.apply2(obj3, obj1) != Boolean.FALSE) goto _L4; else goto _L3
_L3:
        Object obj4 = AddOp.$Pl.apply2(obj3, srfi13.Lit1);
        obj = criterion;
        Object obj5;
        Object obj6;
        Object obj7;
        CharSequence charsequence;
        int i;
        try
        {
            obj5 = (Char)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "char=?", 1, obj);
        }
        obj = s;
        try
        {
            obj6 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
        }
        try
        {
            i = ((Number)obj3).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj3);
        }
        obj = obj2;
        if (characters.isChar$Eq(((Char) (obj5)), Char.make(strings.stringRef(((CharSequence) (obj6)), i))))
        {
            obj = AddOp.$Pl.apply2(obj2, srfi13.Lit1);
        }
        obj3 = obj4;
        obj2 = obj;
        if (true) goto _L5; else goto _L4
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
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1246, 5);
            throw obj;
        }
        if (((Procedure) (obj2)).apply2(obj3, criterion) == Boolean.FALSE) goto _L7; else goto _L6
_L6:
        obj2 = srfi13.Lit0;
        obj3 = obj;
_L9:
        obj = obj2;
        if (Scheme.numGEq.apply2(obj3, obj1) != Boolean.FALSE) goto _L4; else goto _L8
_L8:
        obj4 = AddOp.$Pl.apply2(obj3, srfi13.Lit1);
        obj5 = Scheme.applyToArgs;
        obj = srfi13.loc$char$Mnset$Mncontains$Qu;
        try
        {
            obj6 = ((Location) (obj)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1248, 16);
            throw obj;
        }
        obj7 = criterion;
        obj = s;
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
            i = ((Number)obj3).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj3);
        }
        obj = obj2;
        if (((Procedure) (obj5)).apply3(obj6, obj7, Char.make(strings.stringRef(charsequence, i))) != Boolean.FALSE)
        {
            obj = AddOp.$Pl.apply2(obj2, srfi13.Lit1);
        }
        obj3 = obj4;
        obj2 = obj;
        if (true) goto _L9; else goto _L4
_L7:
        if (!misc.isProcedure(criterion)) goto _L11; else goto _L10
_L10:
        obj2 = srfi13.Lit0;
        obj3 = obj;
_L13:
        obj = obj2;
        if (Scheme.numGEq.apply2(obj3, obj1) != Boolean.FALSE) goto _L4; else goto _L12
_L12:
        obj4 = AddOp.$Pl.apply2(obj3, srfi13.Lit1);
        obj5 = Scheme.applyToArgs;
        obj6 = criterion;
        obj = s;
        try
        {
            obj7 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
        }
        try
        {
            i = ((Number)obj3).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj3);
        }
        obj = obj2;
        if (((Procedure) (obj5)).apply2(obj6, Char.make(strings.stringRef(((CharSequence) (obj7)), i))) != Boolean.FALSE)
        {
            obj = AddOp.$Pl.apply2(obj2, srfi13.Lit1);
        }
        obj3 = obj4;
        obj2 = obj;
        if (true) goto _L13; else goto _L4
_L11:
        obj = misc.error$V("CRITERION param is neither char-set or char.", new Object[] {
            srfi13.string$Mncount, criterion
        });
_L4:
        return obj;
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 160)
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
        if (modulemethod.selector == 161)
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
