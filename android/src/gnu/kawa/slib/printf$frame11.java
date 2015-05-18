// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.numbers;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;
import kawa.standard.append;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class lambda.Fn17 extends ModuleBody
{

    Object fc;
    Procedure format$Mnreal;
    final ModuleMethod lambda$Fn17;
    s staticLink;

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        Object obj1;
        Object obj3;
        Object aobj1[];
        int j;
        switch (modulemethod.selector)
        {
        default:
            return super.applyN(modulemethod, aobj);

        case 13: // '\r'
            modulemethod = ((ModuleMethod) (aobj[0]));
            Object obj = aobj[1];
            Object obj2 = aobj[2];
            Object obj4 = aobj[3];
            int i = aobj.length - 4;
            Object aobj2[] = new Object[i];
            do
            {
                i--;
                if (i < 0)
                {
                    return lambda30formatReal$V(modulemethod, obj, obj2, obj4, aobj2);
                }
                aobj2[i] = aobj[i + 4];
            } while (true);

        case 14: // '\016'
            modulemethod = ((ModuleMethod) (aobj[0]));
            obj1 = aobj[1];
            obj3 = aobj[2];
            j = aobj.length - 3;
            aobj1 = new Object[j];
            break;
        }
        do
        {
            j--;
            if (j < 0)
            {
                return lambda31$V(modulemethod, obj1, obj3, aobj1);
            }
            aobj1[j] = aobj[j + 3];
        } while (true);
    }

    public Object lambda29f(Object obj, Object obj1, Object obj2)
    {
        Object obj3;
        Object obj4;
        try
        {
            obj3 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "stdio:round-string", 0, obj);
        }
        obj4 = AddOp.$Pl.apply2(obj1, staticLink.precision);
        if (obj2 != Boolean.FALSE)
        {
            obj = obj1;
        } else
        {
            obj = obj2;
        }
        obj3 = printf.stdio$ClRoundString(((CharSequence) (obj3)), obj4, obj);
        if (Scheme.numGEq.apply2(obj1, printf.Lit1) != Boolean.FALSE)
        {
            int i;
            int k;
            boolean flag;
            try
            {
                obj = (Number)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "zero?", 1, obj1);
            }
            if (numbers.isZero(((Number) (obj))))
            {
                obj = printf.Lit1;
            } else
            {
                obj = printf.Lit9;
                Number number;
                int j;
                try
                {
                    obj2 = (CharSequence)obj3;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj3);
                }
                if (characters.isChar$Eq(((Char) (obj)), Char.make(strings.stringRef(((CharSequence) (obj2)), 0))))
                {
                    obj = printf.Lit7;
                } else
                {
                    obj = printf.Lit1;
                }
            }
            obj2 = numbers.max(new Object[] {
                printf.Lit7, AddOp.$Pl.apply2(printf.Lit7, obj1)
            });
            try
            {
                obj1 = (CharSequence)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj3);
            }
            try
            {
                i = ((Number) (obj)).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "substring", 2, obj);
            }
            try
            {
                k = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj2);
            }
            obj1 = strings.substring(((CharSequence) (obj1)), i, k);
            try
            {
                obj = (CharSequence)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj3);
            }
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 2, obj2);
            }
            try
            {
                obj2 = (CharSequence)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj3);
            }
            obj = strings.substring(((CharSequence) (obj)), i, strings.stringLength(((CharSequence) (obj2))));
            flag = strings.isString$Eq(obj, "");
            if (flag ? staticLink.Mnform == Boolean.FALSE : flag)
            {
                obj = LList.Empty;
            } else
            {
                obj = LList.list2(".", obj);
            }
            obj2 = lists.cons(obj1, obj);
        } else
        {
            obj = staticLink.precision;
            try
            {
                number = (Number)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "zero?", 1, obj);
            }
            if (numbers.isZero(number))
            {
                if (staticLink.Mnform != Boolean.FALSE)
                {
                    obj = "0.";
                } else
                {
                    obj = "0";
                }
                return LList.list1(obj);
            }
            if (obj2 != Boolean.FALSE)
            {
                flag = strings.isString$Eq(obj3, "");
                if (flag)
                {
                    obj = LList.list1("0");
                } else
                if (flag)
                {
                    obj = Boolean.TRUE;
                } else
                {
                    obj = Boolean.FALSE;
                }
            } else
            {
                obj = obj2;
            }
            obj2 = obj;
            if (obj == Boolean.FALSE)
            {
                obj = numbers.min(new Object[] {
                    staticLink.precision, AddOp.$Mn.apply2(printf.Lit17, obj1)
                });
                try
                {
                    j = ((Number)obj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "make-string", 1, obj);
                }
                return LList.list3("0.", strings.makeString(j, printf.Lit9), obj3);
            }
        }
        return obj2;
    }

    public Object lambda30formatReal$V(Object obj, Object obj1, Object obj2, Object obj3, Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        if (!lists.isNull(((Object) (aobj)))) goto _L2; else goto _L1
_L1:
        Object obj4;
        aobj = printf.Lit5;
        CharSequence charsequence;
        int i;
        boolean flag;
        try
        {
            obj4 = (Char)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "char=?", 2, obj1);
        }
        if (characters.isChar$Eq(((Char) (aobj)), ((Char) (obj4))))
        {
            obj1 = "-";
        } else
        if (obj != Boolean.FALSE)
        {
            obj1 = "+";
        } else
        if (staticLink.blank != Boolean.FALSE)
        {
            obj1 = " ";
        } else
        {
            obj1 = "";
        }
_L11:
        obj = Scheme.isEqv.apply2(fc, printf.Lit13);
        if (obj == Boolean.FALSE ? Scheme.isEqv.apply2(fc, printf.Lit54) != Boolean.FALSE : obj != Boolean.FALSE) goto _L4; else goto _L3
_L4:
        obj = Boolean.FALSE;
_L9:
        try
        {
            aobj = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "stdio:round-string", 0, obj2);
        }
        obj4 = AddOp.$Pl.apply2(printf.Lit7, staticLink.precision);
        obj2 = obj;
        if (obj != Boolean.FALSE)
        {
            obj2 = printf.Lit1;
        }
        obj2 = printf.stdio$ClRoundString(((CharSequence) (aobj)), obj4, obj2);
        obj = printf.Lit9;
        try
        {
            aobj = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj2);
        }
        if (characters.isChar$Eq(((Char) (obj)), Char.make(strings.stringRef(((CharSequence) (aobj)), 0))))
        {
            obj = printf.Lit7;
        } else
        {
            obj = printf.Lit1;
        }
        try
        {
            aobj = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj2);
        }
        i = ((Number) (obj)).intValue();
        try
        {
            obj4 = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj2);
        }
        charsequence = strings.substring(((CharSequence) (aobj)), i + 1, strings.stringLength(((CharSequence) (obj4))));
        if (!numbers.isZero(((Number) (obj))))
        {
            obj3 = AddOp.$Mn.apply2(obj3, printf.Lit7);
        }
        try
        {
            aobj = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj2);
        }
        try
        {
            i = ((Number) (obj)).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "substring", 2, obj);
        }
        obj4 = LList.list1(strings.substring(((CharSequence) (aobj)), i, ((Number) (obj)).intValue() + 1));
        flag = strings.isString$Eq(charsequence, "");
        if (flag ? staticLink.Mnform == Boolean.FALSE : flag)
        {
            obj = "";
        } else
        {
            obj = ".";
        }
        obj2 = fc;
        try
        {
            aobj = (Char)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "char-upper-case?", 1, obj2);
        }
        if (unicode.isCharUpperCase(((Char) (aobj))))
        {
            obj2 = "E";
        } else
        {
            obj2 = "e";
        }
        try
        {
            aobj = LangObjType.coerceRealNum(obj3);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "negative?", 1, obj3);
        }
        if (numbers.isNegative(((gnu.math.RealNum) (aobj))))
        {
            aobj = "-";
        } else
        {
            aobj = "+";
        }
        obj2 = LList.chain4(((gnu.lists.Pair) (obj4)), obj, charsequence, obj2, ((Object) (aobj)));
        if (Scheme.numLss.apply3(printf.Lit60, obj3, printf.Lit45) != Boolean.FALSE)
        {
            obj = "0";
        } else
        {
            obj = "";
        }
        obj = LList.chain1(((gnu.lists.Pair) (obj2)), obj);
        try
        {
            obj2 = (Number)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "abs", 1, obj3);
        }
        LList.chain1(((gnu.lists.Pair) (obj)), numbers.number$To$String(numbers.abs(((Number) (obj2)))));
        obj = obj4;
_L5:
        return lists.cons(obj1, obj);
_L3:
        obj = Scheme.isEqv.apply2(fc, printf.Lit25);
        if (obj == Boolean.FALSE ? Scheme.isEqv.apply2(fc, printf.Lit26) != Boolean.FALSE : obj != Boolean.FALSE)
        {
            obj = lambda29f(obj2, obj3, Boolean.FALSE);
        } else
        {
            break MISSING_BLOCK_LABEL_533;
        }
          goto _L5
        obj = Scheme.isEqv.apply2(fc, printf.Lit55);
        if (obj == Boolean.FALSE ? Scheme.isEqv.apply2(fc, printf.Lit56) != Boolean.FALSE : obj != Boolean.FALSE) goto _L7; else goto _L6
_L7:
        obj = staticLink.Mnform;
        try
        {
            aobj = Boolean.FALSE;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "strip-0s", -2, obj);
        }
        if (obj != aobj)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        i = i + 1 & 1;
        staticLink.Mnform = Boolean.FALSE;
        if (Scheme.numLEq.apply3(AddOp.$Mn.apply2(printf.Lit7, staticLink.precision), obj3, staticLink.precision) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_946;
        }
        staticLink.precision = AddOp.$Mn.apply2(staticLink.precision, obj3);
        if (i != 0)
        {
            obj = Boolean.TRUE;
        } else
        {
            obj = Boolean.FALSE;
        }
        obj = lambda29f(obj2, obj3, obj);
          goto _L5
_L6:
        if (Scheme.isEqv.apply2(fc, printf.Lit57) != Boolean.FALSE)
        {
            aobj = "";
        } else
        {
label0:
            {
                if (Scheme.isEqv.apply2(fc, printf.Lit58) == Boolean.FALSE)
                {
                    break label0;
                }
                aobj = " ";
            }
        }
        try
        {
            obj = LangObjType.coerceRealNum(obj3);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "negative?", 1, obj3);
        }
        if (numbers.isNegative(((gnu.math.RealNum) (obj))))
        {
            obj = DivideOp.quotient.apply2(AddOp.$Mn.apply2(obj3, printf.Lit61), printf.Lit61);
        } else
        {
            obj = DivideOp.quotient.apply2(AddOp.$Mn.apply2(obj3, printf.Lit7), printf.Lit61);
        }
        obj4 = Scheme.numLss.apply3(printf.Lit17, AddOp.$Pl.apply2(obj, printf.Lit48), Integer.valueOf(vectors.vectorLength(printf.Lit62)));
        try
        {
            flag = ((Boolean)obj4).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj4);
        }
        if (!flag)
        {
            if (flag)
            {
                obj = Boolean.TRUE;
            } else
            {
                obj = Boolean.FALSE;
            }
        }
        if (obj == Boolean.FALSE) goto _L7; else goto _L8
_L8:
        obj3 = AddOp.$Mn.apply2(obj3, MultiplyOp.$St.apply2(printf.Lit61, obj));
        staticLink.precision = numbers.max(new Object[] {
            printf.Lit1, AddOp.$Mn.apply2(staticLink.precision, obj3)
        });
        obj2 = lambda29f(obj2, obj3, Boolean.FALSE);
        obj3 = printf.Lit62;
        obj = AddOp.$Pl.apply2(obj, printf.Lit48);
        i = ((Number)obj).intValue();
        obj = append.append$V(new Object[] {
            obj2, LList.list2(((Object) (aobj)), vectors.vectorRef(((gnu.lists.FVector) (obj3)), i))
        });
          goto _L5
        staticLink.precision = AddOp.$Mn.apply2(staticLink.precision, printf.Lit7);
        if (i != 0)
        {
            obj = Boolean.TRUE;
        } else
        {
            obj = Boolean.FALSE;
        }
          goto _L9
        obj = Values.empty;
          goto _L5
_L2:
        return append.append$V(new Object[] {
            lambda30formatReal$V(obj, obj1, obj2, obj3, new Object[0]), Scheme.apply.apply3(format$Mnreal, Boolean.TRUE, ((Object) (aobj))), printf.Lit63
        });
          goto _L9
        obj1;
        throw new WrongType(((ClassCastException) (obj1)), "vector-ref", 2, obj);
        if (true) goto _L11; else goto _L10
_L10:
    }

    Object lambda31$V(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return Scheme.apply.apply2(staticLink.pad, Scheme.apply.applyN(new Object[] {
            format$Mnreal, staticLink.signed, obj, obj1, obj2, aobj
        }));
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 14: // '\016'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 13: // '\r'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        }
    }

    public ()
    {
        format$Mnreal = new ModuleMethod(this, 13, printf.Lit64, -4092);
        ModuleMethod modulemethod = new ModuleMethod(this, 14, null, -4093);
        modulemethod.setProperty("source-location", "printf.scm:401");
        lambda$Fn17 = modulemethod;
    }
}
