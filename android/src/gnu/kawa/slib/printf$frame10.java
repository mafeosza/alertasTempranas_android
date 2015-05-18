// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.append;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class lambda.Fn16 extends ModuleBody
{

    Object alternate$Mnform;
    Object args;
    Object blank;
    final ModuleMethod lambda$Fn13;
    final ModuleMethod lambda$Fn14;
    final ModuleMethod lambda$Fn15;
    final ModuleMethod lambda$Fn16;
    Object leading$Mn0s;
    Object left$Mnadjust;
    Object os;
    Procedure pad;
    Object pr;
    Object precision;
    Object signed;
    s staticLink;
    Object width;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 16: // '\020'
            return lambda25(obj);

        case 17: // '\021'
            if (lambda26(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 18: // '\022'
            return lambda27(obj);

        case 19: // '\023'
            break;
        }
        if (lambda28(obj))
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        if (modulemethod.selector == 15)
        {
            modulemethod = ((ModuleMethod) (aobj[0]));
            int i = aobj.length - 1;
            Object aobj1[] = new Object[i];
            do
            {
                i--;
                if (i < 0)
                {
                    return lambda23pad$V(modulemethod, aobj1);
                }
                aobj1[i] = aobj[i + 1];
            } while (true);
        } else
        {
            return super.applyN(modulemethod, aobj);
        }
    }

    public Object lambda22readFormatNumber()
    {
        if (Scheme.isEqv.apply2(printf.Lit66, staticLink.c) != Boolean.FALSE)
        {
            staticLink.ambda18mustAdvance();
            Object obj = lists.car.apply1(args);
            args = lists.cdr.apply1(args);
            return obj;
        }
        Object obj1 = staticLink.c;
        Object obj2 = printf.Lit1;
        do
        {
            Object obj3 = staticLink.c;
            Char char1;
            try
            {
                char1 = (Char)obj3;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "char-numeric?", 1, obj3);
            }
            if (unicode.isCharNumeric(char1))
            {
                staticLink.ambda18mustAdvance();
                obj3 = staticLink.c;
                AddOp addop = AddOp.$Pl;
                obj2 = MultiplyOp.$St.apply2(obj2, printf.Lit45);
                if (obj1 instanceof Object[])
                {
                    obj1 = ((Object) ((Object[])obj1));
                } else
                {
                    obj1 = ((Object) (new Object[] {
                        obj1
                    }));
                }
                obj2 = addop.apply2(obj2, numbers.string$To$Number(strings.$make$string$(((Object []) (obj1)))));
                obj1 = obj3;
            } else
            {
                return obj2;
            }
        } while (true);
    }

    public Object lambda23pad$V(Object obj, Object aobj[])
    {
        LList llist = LList.makeList(aobj, 0);
        Object obj1;
        try
        {
            aobj = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new WrongType(((ClassCastException) (aobj)), "string-length", 1, obj);
        }
        obj1 = Integer.valueOf(strings.stringLength(((CharSequence) (aobj))));
        aobj = llist;
        do
        {
            if (Scheme.numGEq.apply2(obj1, width) != Boolean.FALSE)
            {
                return lists.cons(obj, llist);
            }
            Object obj2;
            if (lists.isNull(((Object) (aobj))))
            {
                if (left$Mnadjust != Boolean.FALSE)
                {
                    aobj = ((Object []) (AddOp.$Mn.apply2(width, obj1)));
                    AddOp addop;
                    CharSequence charsequence;
                    int i;
                    try
                    {
                        i = ((Number)aobj).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "make-string", 1, ((Object) (aobj)));
                    }
                    return lists.cons(obj, append.append$V(new Object[] {
                        llist, LList.list1(strings.makeString(i, printf.Lit29))
                    }));
                }
                if (leading$Mn0s != Boolean.FALSE)
                {
                    aobj = ((Object []) (AddOp.$Mn.apply2(width, obj1)));
                    try
                    {
                        i = ((Number)aobj).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "make-string", 1, ((Object) (aobj)));
                    }
                    return lists.cons(obj, lists.cons(strings.makeString(i, printf.Lit9), llist));
                }
                aobj = ((Object []) (AddOp.$Mn.apply2(width, obj1)));
                try
                {
                    i = ((Number)aobj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "make-string", 1, ((Object) (aobj)));
                }
                return lists.cons(strings.makeString(i, printf.Lit29), lists.cons(obj, llist));
            }
            addop = AddOp.$Pl;
            obj2 = lists.car.apply1(((Object) (aobj)));
            try
            {
                charsequence = (CharSequence)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj2);
            }
            obj1 = addop.apply2(obj1, Integer.valueOf(strings.stringLength(charsequence)));
            aobj = ((Object []) (lists.cdr.apply1(((Object) (aobj)))));
        } while (true);
    }

    public Object lambda24integerConvert(Object obj, Object obj1, Object obj2)
    {
        Object obj3;
        obj3 = precision;
        Object obj4;
        int i;
        boolean flag;
        try
        {
            obj4 = LangObjType.coerceRealNum(obj3);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "negative?", 1, obj3);
        }
        if (numbers.isNegative(((gnu.math.RealNum) (obj4)))) goto _L2; else goto _L1
_L1:
        leading$Mn0s = Boolean.FALSE;
        obj3 = precision;
        try
        {
            obj4 = (Number)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "zero?", 1, obj3);
        }
        flag = numbers.isZero(((Number) (obj4)));
        if (!flag) goto _L4; else goto _L3
_L3:
        obj3 = obj;
        if (Scheme.isEqv.apply2(printf.Lit1, obj) == Boolean.FALSE) goto _L6; else goto _L5
_L5:
        obj3 = "";
_L6:
        obj = obj3;
_L2:
        if (misc.isSymbol(obj))
        {
            try
            {
                obj3 = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "symbol->string", 1, obj);
            }
            obj = misc.symbol$To$String(((Symbol) (obj3)));
        } else
        if (numbers.isNumber(obj))
        {
            try
            {
                obj3 = (Number)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "number->string", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "number->string", 2, obj1);
            }
            obj = numbers.number$To$String(((Number) (obj3)), i);
        } else
        {
            try
            {
                obj3 = Boolean.FALSE;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "x", -2, obj);
            }
            if (obj != obj3)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            i = i + 1 & 1;
            if (i == 0 ? lists.isNull(obj) : i != 0)
            {
                obj = "0";
            } else
            if (!strings.isString(obj))
            {
                obj = "1";
            }
        }
_L10:
        obj3 = obj;
        if (obj2 != Boolean.FALSE)
        {
            obj3 = Scheme.applyToArgs.apply2(obj2, obj);
        }
        if (!IsEqual.apply("", obj3)) goto _L8; else goto _L7
_L7:
        obj = "";
_L9:
        obj1 = Scheme.numLss;
        try
        {
            obj2 = (CharSequence)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj3);
        }
        if (((Procedure) (obj1)).apply2(Integer.valueOf(strings.stringLength(((CharSequence) (obj2)))), precision) != Boolean.FALSE)
        {
            obj1 = AddOp.$Mn;
            obj2 = precision;
            try
            {
                obj4 = (CharSequence)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj3);
            }
            obj1 = ((Procedure) (obj1)).apply2(obj2, Integer.valueOf(strings.stringLength(((CharSequence) (obj4)))));
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "make-string", 1, obj1);
            }
            obj1 = strings.makeString(i, printf.Lit9);
        } else
        {
            obj1 = "";
        }
        return lambda23pad$V(obj, new Object[] {
            obj1, obj3
        });
_L4:
        obj3 = obj;
        if (!flag) goto _L6; else goto _L5
_L8:
        obj = Scheme.isEqv;
        obj2 = printf.Lit5;
        try
        {
            obj4 = (CharSequence)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj3);
        }
        if (((Procedure) (obj)).apply2(obj2, Char.make(strings.stringRef(((CharSequence) (obj4)), 0))) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_410;
        }
        try
        {
            obj = (CharSequence)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj3);
        }
        obj1 = (CharSequence)obj3;
        obj3 = strings.substring(((CharSequence) (obj)), 1, strings.stringLength(((CharSequence) (obj1))));
        obj = "-";
          goto _L9
        if (signed != Boolean.FALSE)
        {
            obj = "+";
        } else
        if (blank != Boolean.FALSE)
        {
            obj = " ";
        } else
        if (alternate$Mnform != Boolean.FALSE)
        {
            if (Scheme.isEqv.apply2(obj1, printf.Lit48) != Boolean.FALSE)
            {
                obj = "0";
            } else
            if (Scheme.isEqv.apply2(obj1, printf.Lit50) != Boolean.FALSE)
            {
                obj = "0x";
            } else
            {
                obj = "";
            }
        } else
        {
            obj = "";
        }
          goto _L9
        obj;
        throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj3);
          goto _L10
    }

    Object lambda25(Object obj)
    {
        AddOp addop = AddOp.$Pl;
        Object obj1 = pr;
        CharSequence charsequence;
        try
        {
            charsequence = (CharSequence)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "string-length", 1, obj);
        }
        pr = addop.apply2(obj1, Integer.valueOf(strings.stringLength(charsequence)));
        return Scheme.applyToArgs.apply2(staticLink.ut, obj);
    }

    boolean lambda26(Object obj)
    {
        Object obj1 = Special.undefined;
        obj1 = AddOp.$Mn;
        Object obj2 = pr;
        CharSequence charsequence;
        try
        {
            charsequence = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
        }
        obj1 = ((Procedure) (obj1)).apply2(obj2, Integer.valueOf(strings.stringLength(charsequence)));
        try
        {
            obj2 = LangObjType.coerceRealNum(obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "negative?", 1, obj1);
        }
        if (numbers.isNegative(((gnu.math.RealNum) (obj2))))
        {
            gnu.kawa.functions.ApplyToArgs applytoargs = Scheme.applyToArgs;
            Object obj3 = staticLink.ut;
            CharSequence charsequence1;
            int i;
            try
            {
                charsequence1 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "substring", 1, obj);
            }
            obj = pr;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "substring", 3, obj);
            }
            applytoargs.apply2(obj3, strings.substring(charsequence1, 0, i));
            obj = printf.Lit1;
        } else
        {
            Scheme.applyToArgs.apply2(staticLink.ut, obj);
            obj = obj1;
        }
        pr = obj;
        try
        {
            obj = LangObjType.coerceRealNum(obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "positive?", 1, obj1);
        }
        return numbers.isPositive(((gnu.math.RealNum) (obj)));
    }

    Boolean lambda27(Object obj)
    {
        AddOp addop = AddOp.$Mn;
        Object obj2 = pr;
        CharSequence charsequence;
        try
        {
            charsequence = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
        }
        pr = addop.apply2(obj2, Integer.valueOf(strings.stringLength(charsequence)));
        if (os == Boolean.FALSE)
        {
            Scheme.applyToArgs.apply2(staticLink.ut, obj);
        } else
        {
            Object obj1 = pr;
            gnu.math.RealNum realnum;
            try
            {
                realnum = LangObjType.coerceRealNum(obj1);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "negative?", 1, obj1);
            }
            if (numbers.isNegative(realnum))
            {
                Scheme.applyToArgs.apply2(staticLink.ut, os);
                os = Boolean.FALSE;
                Scheme.applyToArgs.apply2(staticLink.ut, obj);
            } else
            {
                os = strings.stringAppend(new Object[] {
                    os, obj
                });
            }
        }
        return Boolean.TRUE;
    }

    boolean lambda28(Object obj)
    {
        Object obj1 = Special.undefined;
        obj1 = AddOp.$Mn;
        Object obj2 = pr;
        CharSequence charsequence;
        try
        {
            charsequence = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
        }
        obj1 = ((Procedure) (obj1)).apply2(obj2, Integer.valueOf(strings.stringLength(charsequence)));
        try
        {
            obj2 = LangObjType.coerceRealNum(obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "negative?", 1, obj1);
        }
        if (numbers.isNegative(((gnu.math.RealNum) (obj2))))
        {
            Object obj3 = os;
            CharSequence charsequence1;
            int i;
            try
            {
                charsequence1 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "substring", 1, obj);
            }
            obj = pr;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "substring", 3, obj);
            }
            os = strings.stringAppend(new Object[] {
                obj3, strings.substring(charsequence1, 0, i)
            });
        } else
        {
            os = strings.stringAppend(new Object[] {
                os, obj
            });
        }
        pr = obj1;
        try
        {
            obj = LangObjType.coerceRealNum(obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "positive?", 1, obj1);
        }
        return numbers.isPositive(((gnu.math.RealNum) (obj)));
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 19: // '\023'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 18: // '\022'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 17: // '\021'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 16: // '\020'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        if (modulemethod.selector == 15)
        {
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        } else
        {
            return super.matchN(modulemethod, aobj, callcontext);
        }
    }

    public ()
    {
        pad = new ModuleMethod(this, 15, printf.Lit67, -4095);
        ModuleMethod modulemethod = new ModuleMethod(this, 16, null, 4097);
        modulemethod.setProperty("source-location", "printf.scm:472");
        lambda$Fn13 = modulemethod;
        modulemethod = new ModuleMethod(this, 17, null, 4097);
        modulemethod.setProperty("source-location", "printf.scm:476");
        lambda$Fn14 = modulemethod;
        modulemethod = new ModuleMethod(this, 18, null, 4097);
        modulemethod.setProperty("source-location", "printf.scm:484");
        lambda$Fn15 = modulemethod;
        modulemethod = new ModuleMethod(this, 19, null, 4097);
        modulemethod.setProperty("source-location", "printf.scm:494");
        lambda$Fn16 = modulemethod;
    }
}
