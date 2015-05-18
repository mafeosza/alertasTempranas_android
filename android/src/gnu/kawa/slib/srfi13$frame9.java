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

public class  extends ModuleBody
{

    Object criterion;
    final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 20, null, 0);
    final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 21, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 20)
        {
            return lambda23();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 21)
        {
            return lambda24(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda23()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnevery, s, maybe$Mnstart$Plend);
    }

    Object lambda24(Object obj, Object obj1)
    {
        Object obj2;
        Object obj3;
        CharSequence charsequence;
        int i;
        boolean flag;
        if (characters.isChar(criterion))
        {
            do
            {
                obj2 = Scheme.numGEq.apply2(obj, obj1);
                try
                {
                    flag = ((Boolean)obj2).booleanValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "x", -2, obj2);
                }
                if (flag)
                {
                    if (flag)
                    {
                        return Boolean.TRUE;
                    } else
                    {
                        return Boolean.FALSE;
                    }
                }
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
                    charsequence = (CharSequence)obj3;
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
                flag = characters.isChar$Eq(((Char) (obj2)), Char.make(strings.stringRef(charsequence, i)));
                if (flag)
                {
                    obj = AddOp.$Pl.apply2(obj, srfi13.Lit1);
                } else
                if (flag)
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            } while (true);
        }
        obj2 = Scheme.applyToArgs;
        obj3 = srfi13.loc$char$Mnset$Qu;
        try
        {
            obj3 = ((Location) (obj3)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 489, 5);
            throw obj;
        }
        if (((Procedure) (obj2)).apply2(obj3, criterion) != Boolean.FALSE)
        {
            do
            {
                obj2 = Scheme.numGEq.apply2(obj, obj1);
                Object obj4;
                Object obj5;
                CharSequence charsequence1;
                int j;
                boolean flag1;
                try
                {
                    flag1 = ((Boolean)obj2).booleanValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "x", -2, obj2);
                }
                if (flag1)
                {
                    if (flag1)
                    {
                        return Boolean.TRUE;
                    } else
                    {
                        return Boolean.FALSE;
                    }
                }
                obj2 = Scheme.applyToArgs;
                obj3 = srfi13.loc$char$Mnset$Mncontains$Qu;
                try
                {
                    obj4 = ((Location) (obj3)).get();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((UnboundLocationException) (obj)).setLine("srfi13.scm", 492, 9);
                    throw obj;
                }
                obj5 = criterion;
                obj3 = s;
                try
                {
                    charsequence1 = (CharSequence)obj3;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj3);
                }
                try
                {
                    j = ((Number)obj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
                }
                obj2 = ((Procedure) (obj2)).apply3(obj4, obj5, Char.make(strings.stringRef(charsequence1, j)));
                if (obj2 != Boolean.FALSE)
                {
                    obj = AddOp.$Pl.apply2(obj, srfi13.Lit1);
                } else
                {
                    return obj2;
                }
            } while (true);
        } else
        if (misc.isProcedure(criterion))
        {
            obj2 = Scheme.numEqu.apply2(obj, obj1);
            try
            {
                flag1 = ((Boolean)obj2).booleanValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "x", -2, obj2);
            }
            if (flag1)
            {
                if (flag1)
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            }
            do
            {
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
                    j = ((Number)obj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
                }
                j = strings.stringRef(((CharSequence) (obj3)), j);
                obj = AddOp.$Pl.apply2(obj, srfi13.Lit1);
                if (Scheme.numEqu.apply2(obj, obj1) != Boolean.FALSE)
                {
                    return Scheme.applyToArgs.apply2(criterion, Char.make(j));
                }
                obj2 = Scheme.applyToArgs.apply2(criterion, Char.make(j));
            } while (obj2 != Boolean.FALSE);
            return obj2;
        } else
        {
            return misc.error$V("Second param is neither char-set, char, or predicate procedure.", new Object[] {
                srfi13.string$Mnevery, criterion
            });
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 20)
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
        if (modulemethod.selector == 21)
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
