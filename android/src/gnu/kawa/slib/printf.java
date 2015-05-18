// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.CharSeq;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.Complex;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;
import kawa.standard.append;

// Referenced classes of package gnu.kawa.slib:
//            genwrite

public class printf extends ModuleBody
{
    public class frame extends ModuleBody
    {

        final ModuleMethod lambda$Fn1;
        int n;
        Object proc;
        Object str;

        public static Boolean lambda1parseError()
        {
            return Boolean.FALSE;
        }

        public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
        {
            if (modulemethod.selector == 12)
            {
                return lambda5(obj, obj1, obj2, obj3);
            } else
            {
                return super.apply4(modulemethod, obj, obj1, obj2, obj3);
            }
        }

        public Object lambda2sign(Object obj, Object obj1)
        {
            if (Scheme.numLss.apply2(obj, Integer.valueOf(n)) != Boolean.FALSE)
            {
                Object obj2 = str;
                CharSequence charsequence;
                int i;
                try
                {
                    charsequence = (CharSequence)obj2;
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
                i = strings.stringRef(charsequence, i);
                obj2 = Scheme.isEqv.apply2(Char.make(i), printf.Lit5);
                if (obj2 == Boolean.FALSE ? Scheme.isEqv.apply2(Char.make(i), printf.Lit6) != Boolean.FALSE : obj2 != Boolean.FALSE)
                {
                    return Scheme.applyToArgs.apply3(obj1, AddOp.$Pl.apply2(obj, printf.Lit7), Char.make(i));
                } else
                {
                    return Scheme.applyToArgs.apply3(obj1, obj, printf.Lit6);
                }
            } else
            {
                return Values.empty;
            }
        }

        public Object lambda3digits(Object obj, Object obj1)
        {
            Object obj2 = obj;
_L5:
            Object obj3;
            obj3 = Scheme.numGEq.apply2(obj2, Integer.valueOf(n));
            Object obj4;
            CharSequence charsequence;
            int i;
            int j;
            boolean flag;
            try
            {
                flag = ((Boolean)obj3).booleanValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "x", -2, obj3);
            }
            if (!flag) goto _L2; else goto _L1
_L1:
            if (flag) goto _L4; else goto _L3
_L3:
            obj2 = AddOp.$Pl.apply2(obj2, printf.Lit7);
              goto _L5
_L2:
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
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj2);
            }
            flag = unicode.isCharNumeric(Char.make(strings.stringRef(((CharSequence) (obj4)), i)));
            if (!flag) goto _L7; else goto _L6
_L6:
            if (flag) goto _L3; else goto _L4
_L4:
            obj3 = Scheme.applyToArgs;
            if (Scheme.numEqu.apply2(obj, obj2) != Boolean.FALSE)
            {
                obj = "0";
            } else
            {
                Object obj5 = str;
                try
                {
                    charsequence = (CharSequence)obj5;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj5);
                }
                try
                {
                    i = ((Number)obj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "substring", 2, obj);
                }
                try
                {
                    j = ((Number)obj2).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj2);
                }
                obj = strings.substring(charsequence, i, j);
            }
            return ((Procedure) (obj3)).apply3(obj1, obj2, obj);
_L7:
            obj4 = printf.Lit8;
            obj3 = str;
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
            if (!characters.isChar$Eq(((Char) (obj4)), Char.make(strings.stringRef(charsequence, i)))) goto _L4; else goto _L3
        }

        public Object lambda4real(Object obj, Object obj1)
        {
            frame2 frame2_1 = new frame2();
            frame2_1.staticLink = this;
            frame2_1.cont = obj1;
            obj1 = frame2_1.Fn5;
_L5:
            Object obj2;
            obj2 = Scheme.numLss.apply2(obj, Integer.valueOf(n - 1));
            Object obj3;
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
            if (!flag) goto _L2; else goto _L1
_L1:
            obj3 = printf.Lit8;
            obj2 = str;
            try
            {
                charsequence = (CharSequence)obj2;
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
            if (!characters.isChar$Eq(((Char) (obj3)), Char.make(strings.stringRef(charsequence, i)))) goto _L4; else goto _L3
_L3:
            obj2 = str;
            try
            {
                obj3 = (CharSequence)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj2);
            }
            obj2 = AddOp.$Pl.apply2(obj, printf.Lit7);
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj2);
            }
            i = strings.stringRef(((CharSequence) (obj3)), i);
            obj2 = Scheme.isEqv.apply2(Char.make(i), printf.Lit12);
            if (obj2 == Boolean.FALSE ? (obj2 = Scheme.isEqv.apply2(Char.make(i), printf.Lit3)) == Boolean.FALSE ? Scheme.isEqv.apply2(Char.make(i), printf.Lit13) != Boolean.FALSE : obj2 != Boolean.FALSE : obj2 != Boolean.FALSE)
            {
                obj = AddOp.$Pl.apply2(obj, printf.Lit14);
            } else
            if (Scheme.isEqv.apply2(Char.make(i), printf.Lit11) != Boolean.FALSE)
            {
                return Scheme.applyToArgs.apply2(obj1, obj);
            } else
            {
                return lambda1parseError();
            }
              goto _L5
_L2:
            if (flag) goto _L3; else goto _L4
_L4:
            return Scheme.applyToArgs.apply2(obj1, obj);
        }

        Object lambda5(Object obj, Object obj1, Object obj2, Object obj3)
        {
            frame0 frame0_1 = new frame0();
            frame0_1.staticLink = this;
            frame0_1.sgn = obj1;
            frame0_1.digs = obj2;
            frame0_1.ex = obj3;
            if (Scheme.numEqu.apply2(obj, Integer.valueOf(n)) != Boolean.FALSE)
            {
                return Scheme.applyToArgs.apply4(proc, frame0_1.sgn, frame0_1.digs, frame0_1.ex);
            }
            obj1 = str;
            int i;
            try
            {
                obj2 = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj1);
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
            if (lists.memv(Char.make(strings.stringRef(((CharSequence) (obj2)), i)), printf.Lit2) != Boolean.FALSE)
            {
                return lambda4real(obj, frame0_1.Fn2);
            }
            obj2 = Scheme.isEqv;
            obj1 = str;
            try
            {
                obj3 = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj1);
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
            if (((Procedure) (obj2)).apply2(Char.make(strings.stringRef(((CharSequence) (obj3)), i)), printf.Lit4) != Boolean.FALSE)
            {
                obj = str;
                try
                {
                    obj1 = (CharSequence)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string->number", 1, obj);
                }
                frame0_1.num = numbers.string$To$Number(((CharSequence) (obj1)));
                if (frame0_1.num != Boolean.FALSE)
                {
                    obj = frame0_1.num;
                    try
                    {
                        obj1 = (Complex)obj;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        throw new WrongType(((ClassCastException) (obj1)), "real-part", 1, obj);
                    }
                    return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.realPart(((Complex) (obj1)))), frame0_1.Fn3);
                } else
                {
                    return lambda1parseError();
                }
            } else
            {
                return Boolean.FALSE;
            }
        }

        public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
        {
            if (modulemethod.selector == 12)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            } else
            {
                return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);
            }
        }

        public frame()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 12, null, 16388);
            modulemethod.setProperty("source-location", "printf.scm:106");
            lambda$Fn1 = modulemethod;
        }
    }

    public class frame0 extends ModuleBody
    {

        Object digs;
        Object ex;
        final ModuleMethod lambda$Fn2;
        final ModuleMethod lambda$Fn3;
        Object num;
        Object sgn;
        frame staticLink;

        public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
        {
            if (modulemethod.selector == 3)
            {
                return lambda7(obj, obj1, obj2);
            } else
            {
                return super.apply3(modulemethod, obj, obj1, obj2);
            }
        }

        public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
        {
            if (modulemethod.selector == 2)
            {
                return lambda6(obj, obj1, obj2, obj3);
            } else
            {
                return super.apply4(modulemethod, obj, obj1, obj2, obj3);
            }
        }

        Object lambda6(Object obj, Object obj1, Object obj2, Object obj3)
        {
            Object obj4;
            obj4 = Scheme.numEqu.apply2(obj, Integer.valueOf(staticLink.n - 1));
            Char char1;
            CharSequence charsequence;
            int i;
            boolean flag;
            try
            {
                flag = ((Boolean)obj4).booleanValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "x", -2, obj4);
            }
            if (!flag) goto _L2; else goto _L1
_L1:
            char1 = printf.Lit3;
            obj4 = staticLink.str;
            try
            {
                charsequence = (CharSequence)obj4;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj4);
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
            if (!unicode.isCharCi$Eq(char1, Char.make(strings.stringRef(charsequence, i)))) goto _L4; else goto _L3
_L3:
            return Scheme.applyToArgs.applyN(new Object[] {
                staticLink.proc, sgn, digs, ex, obj1, obj2, obj3
            });
_L2:
            if (flag) goto _L3; else goto _L4
_L4:
            return frame.lambda1parseError();
        }

        Object lambda7(Object obj, Object obj1, Object obj2)
        {
            frame1 frame1_1 = new frame1();
            frame1_1.staticLink = this;
            frame1_1.sgn = obj;
            frame1_1.digs = obj1;
            frame1_1.ex = obj2;
            obj = num;
            try
            {
                obj1 = (Complex)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "imag-part", 1, obj);
            }
            return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.imagPart(((Complex) (obj1)))), frame1_1.Fn4);
        }

        public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
        {
            if (modulemethod.selector == 3)
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

        public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
        {
            if (modulemethod.selector == 2)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            } else
            {
                return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);
            }
        }

        public frame0()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 2, null, 16388);
            modulemethod.setProperty("source-location", "printf.scm:111");
            lambda$Fn2 = modulemethod;
            modulemethod = new ModuleMethod(this, 3, null, 12291);
            modulemethod.setProperty("source-location", "printf.scm:123");
            lambda$Fn3 = modulemethod;
        }
    }

    public class frame1 extends ModuleBody
    {

        Object digs;
        Object ex;
        final ModuleMethod lambda$Fn4;
        Object sgn;
        frame0 staticLink;

        public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
        {
            if (modulemethod.selector == 1)
            {
                return lambda8(obj, obj1, obj2);
            } else
            {
                return super.apply3(modulemethod, obj, obj1, obj2);
            }
        }

        Object lambda8(Object obj, Object obj1, Object obj2)
        {
            return Scheme.applyToArgs.applyN(new Object[] {
                staticLink.staticLink.proc, sgn, digs, ex, obj, obj1, obj2
            });
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

        public frame1()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 12291);
            modulemethod.setProperty("source-location", "printf.scm:126");
            lambda$Fn4 = modulemethod;
        }
    }

    public class frame10 extends ModuleBody
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
        frame9 staticLink;
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
            if (Scheme.isEqv.apply2(printf.Lit66, staticLink.fc) != Boolean.FALSE)
            {
                staticLink.lambda18mustAdvance();
                Object obj = lists.car.apply1(args);
                args = lists.cdr.apply1(args);
                return obj;
            }
            Object obj1 = staticLink.fc;
            Object obj2 = printf.Lit1;
            do
            {
                Object obj3 = staticLink.fc;
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
                    staticLink.lambda18mustAdvance();
                    obj3 = staticLink.fc;
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
            return Scheme.applyToArgs.apply2(staticLink.out, obj);
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
                Object obj3 = staticLink.out;
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
                Scheme.applyToArgs.apply2(staticLink.out, obj);
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
                Scheme.applyToArgs.apply2(staticLink.out, obj);
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
                    Scheme.applyToArgs.apply2(staticLink.out, os);
                    os = Boolean.FALSE;
                    Scheme.applyToArgs.apply2(staticLink.out, obj);
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

        public frame10()
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

    public class frame11 extends ModuleBody
    {

        Object fc;
        Procedure format$Mnreal;
        final ModuleMethod lambda$Fn17;
        frame10 staticLink;

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
                obj2, LList.list2(((Object) (aobj)), vectors.vectorRef(((FVector) (obj3)), i))
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

        public frame11()
        {
            format$Mnreal = new ModuleMethod(this, 13, printf.Lit64, -4092);
            ModuleMethod modulemethod = new ModuleMethod(this, 14, null, -4093);
            modulemethod.setProperty("source-location", "printf.scm:401");
            lambda$Fn17 = modulemethod;
        }
    }

    public class frame12 extends ModuleBody
    {

        Object cnt;
        final ModuleMethod lambda$Fn18;
        Object port;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 20)
            {
                return lambda32(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Boolean lambda32(Object obj)
        {
            if (strings.isString(obj))
            {
                AddOp addop = AddOp.$Pl;
                CharSequence charsequence;
                try
                {
                    charsequence = (CharSequence)obj;
                }
                catch (ClassCastException classcastexception)
                {
                    throw new WrongType(classcastexception, "string-length", 1, obj);
                }
                cnt = addop.apply2(Integer.valueOf(strings.stringLength(charsequence)), cnt);
                ports.display(obj, port);
                return Boolean.TRUE;
            } else
            {
                cnt = AddOp.$Pl.apply2(printf.Lit7, cnt);
                ports.display(obj, port);
                return Boolean.TRUE;
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 20)
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

        public frame12()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 20, null, 4097);
            modulemethod.setProperty("source-location", "printf.scm:546");
            lambda$Fn18 = modulemethod;
        }
    }

    public class frame13 extends ModuleBody
    {

        Object cnt;
        Object end;
        final ModuleMethod lambda$Fn19;
        Object s;
        Object str;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 21)
            {
                if (lambda33(obj))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        boolean lambda33(Object obj)
        {
            if (!strings.isString(obj)) goto _L2; else goto _L1
_L1:
            Object obj1;
label0:
            {
label1:
                {
                    if (str == Boolean.FALSE)
                    {
                        obj1 = Scheme.numGEq;
                        Object obj2 = AddOp.$Mn.apply2(end, cnt);
                        char c;
                        Object obj3;
                        int i;
                        int j;
                        try
                        {
                            obj3 = (CharSequence)obj;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
                        }
                        if (((Procedure) (obj1)).apply2(obj2, Integer.valueOf(strings.stringLength(((CharSequence) (obj3))))) == Boolean.FALSE)
                        {
                            break label1;
                        }
                    }
                    try
                    {
                        obj1 = (CharSequence)obj;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
                    }
                    obj2 = numbers.min(new Object[] {
                        Integer.valueOf(strings.stringLength(((CharSequence) (obj1)))), AddOp.$Mn.apply2(end, cnt)
                    });
                    obj1 = printf.Lit1;
                    while (Scheme.numGEq.apply2(obj1, obj2) == Boolean.FALSE) 
                    {
                        Object obj4 = s;
                        try
                        {
                            obj3 = (CharSeq)obj4;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, obj4);
                        }
                        obj4 = cnt;
                        try
                        {
                            i = ((Number)obj4).intValue();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, obj4);
                        }
                        try
                        {
                            obj4 = (CharSequence)obj;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
                        }
                        try
                        {
                            j = ((Number)obj1).intValue();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
                        }
                        strings.stringSet$Ex(((CharSeq) (obj3)), i, strings.stringRef(((CharSequence) (obj4)), j));
                        cnt = AddOp.$Pl.apply2(cnt, printf.Lit7);
                        obj1 = AddOp.$Pl.apply2(obj1, printf.Lit7);
                    }
                    break label0;
                }
                obj1 = s;
                try
                {
                    obj2 = (CharSequence)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
                }
                obj1 = cnt;
                try
                {
                    i = ((Number)obj1).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj1);
                }
                s = strings.stringAppend(new Object[] {
                    strings.substring(((CharSequence) (obj2)), 0, i), obj
                });
                obj = s;
                try
                {
                    obj1 = (CharSequence)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
                }
                cnt = Integer.valueOf(strings.stringLength(((CharSequence) (obj1))));
                end = cnt;
            }
_L4:
            if (str != Boolean.FALSE)
            {
                if (Scheme.numGEq.apply2(cnt, end) != Boolean.FALSE)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            } else
            if (str != Boolean.FALSE)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            return i + 1 & 1;
_L2:
            if (str != Boolean.FALSE)
            {
                obj1 = Scheme.numGEq.apply2(cnt, end);
            } else
            {
                obj1 = str;
            }
            if (obj1 == Boolean.FALSE)
            {
                obj1 = str;
                try
                {
                    obj2 = Boolean.FALSE;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "x", -2, obj1);
                }
                if (obj1 != obj2)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                i = i + 1 & 1;
                if (i == 0 ? i != 0 : Scheme.numGEq.apply2(cnt, end) != Boolean.FALSE)
                {
                    s = strings.stringAppend(new Object[] {
                        s, strings.makeString(100)
                    });
                    obj1 = s;
                    try
                    {
                        obj2 = (CharSequence)obj1;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
                    }
                    end = Integer.valueOf(strings.stringLength(((CharSequence) (obj2))));
                }
                obj1 = s;
                try
                {
                    obj2 = (CharSeq)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, obj1);
                }
                obj1 = cnt;
                try
                {
                    i = ((Number)obj1).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, obj1);
                }
                if (characters.isChar(obj))
                {
                    try
                    {
                        c = ((Char)obj).charValue();
                    }
                    catch (ClassCastException classcastexception)
                    {
                        throw new WrongType(classcastexception, "string-set!", 3, obj);
                    }
                } else
                {
                    c = '?';
                }
                strings.stringSet$Ex(((CharSeq) (obj2)), i, c);
                cnt = AddOp.$Pl.apply2(cnt, printf.Lit7);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 21)
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

        public frame13()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 21, null, 4097);
            modulemethod.setProperty("source-location", "printf.scm:564");
            lambda$Fn19 = modulemethod;
        }
    }

    public class frame2 extends ModuleBody
    {

        Object cont;
        final ModuleMethod lambda$Fn5;
        final ModuleMethod lambda$Fn6;
        frame staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 11)
            {
                return lambda9(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 10)
            {
                return lambda10(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda10(Object obj, Object obj1)
        {
            frame3 frame3_1 = new frame3();
            frame3_1.staticLink = this;
            frame3_1.sgn = obj1;
            return staticLink.lambda3digits(obj, frame3_1.Fn7);
        }

        Object lambda9(Object obj)
        {
            return staticLink.lambda2sign(obj, lambda$Fn6);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 11)
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
            if (modulemethod.selector == 10)
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

        public frame2()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 10, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:81");
            lambda$Fn6 = modulemethod;
            modulemethod = new ModuleMethod(this, 11, null, 4097);
            modulemethod.setProperty("source-location", "printf.scm:78");
            lambda$Fn5 = modulemethod;
        }
    }

    public class frame3 extends ModuleBody
    {

        final ModuleMethod lambda$Fn7;
        Object sgn;
        frame2 staticLink;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 9)
            {
                return lambda11(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda11(Object obj, Object obj1)
        {
            Object obj2;
            obj2 = new frame4();
            obj2.staticLink = this;
            obj2.idigs = obj1;
            obj1 = ((frame4) (obj2)).Fn8;
            obj2 = Scheme.numLss.apply2(obj, Integer.valueOf(staticLink.staticLink.n));
            Char char1;
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
            if (!flag) goto _L2; else goto _L1
_L1:
            char1 = printf.Lit11;
            obj2 = staticLink.staticLink.str;
            try
            {
                charsequence = (CharSequence)obj2;
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
            if (!characters.isChar$Eq(char1, Char.make(strings.stringRef(charsequence, i)))) goto _L4; else goto _L3
_L3:
            return Scheme.applyToArgs.apply2(obj1, AddOp.$Pl.apply2(obj, printf.Lit7));
_L2:
            if (flag) goto _L3; else goto _L4
_L4:
            return Scheme.applyToArgs.apply2(obj1, obj);
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 9)
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

        public frame3()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 9, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:84");
            lambda$Fn7 = modulemethod;
        }
    }

    public class frame4 extends ModuleBody
    {

        Object idigs;
        final ModuleMethod lambda$Fn8;
        final ModuleMethod lambda$Fn9;
        frame3 staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 8)
            {
                return lambda12(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 7)
            {
                return lambda13(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda12(Object obj)
        {
            return staticLink.staticLink.staticLink.lambda3digits(obj, lambda$Fn9);
        }

        Object lambda13(Object obj, Object obj1)
        {
            Object obj2 = new frame5();
            obj2.staticLink = this;
            obj2.fdigs = obj1;
            obj2 = ((frame5) (obj2)).Fn10;
            Object obj3 = staticLink.staticLink.staticLink;
            obj1 = new frame6();
            obj1.staticLink = ((frame) (obj3));
            obj1.cont = obj2;
            if (Scheme.numGEq.apply2(obj, Integer.valueOf(staticLink.staticLink.staticLink.n)) != Boolean.FALSE)
            {
                return Scheme.applyToArgs.apply3(((frame6) (obj1)).cont, obj, printf.Lit1);
            }
            obj2 = staticLink.staticLink.staticLink.str;
            int i;
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
            if (lists.memv(Char.make(strings.stringRef(((CharSequence) (obj3)), i)), printf.Lit10) != Boolean.FALSE)
            {
                return staticLink.staticLink.staticLink.lambda2sign(AddOp.$Pl.apply2(obj, printf.Lit7), ((frame6) (obj1)).Fn11);
            } else
            {
                return Scheme.applyToArgs.apply3(((frame6) (obj1)).cont, obj, printf.Lit1);
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 8)
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
            if (modulemethod.selector == 7)
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

        public frame4()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 7, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:90");
            lambda$Fn9 = modulemethod;
            modulemethod = new ModuleMethod(this, 8, null, 4097);
            modulemethod.setProperty("source-location", "printf.scm:87");
            lambda$Fn8 = modulemethod;
        }
    }

    public class frame5 extends ModuleBody
    {

        Object fdigs;
        final ModuleMethod lambda$Fn10;
        frame4 staticLink;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 6)
            {
                return lambda14(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda14(Object obj, Object obj1)
        {
            gnu.lists.FString fstring = strings.stringAppend(new Object[] {
                "0", staticLink.idigs, fdigs
            });
            int i = strings.stringLength(fstring);
            Object obj2 = printf.Lit7;
            AddOp addop = AddOp.$Pl;
            Object obj3 = staticLink.idigs;
            CharSequence charsequence;
            try
            {
                charsequence = (CharSequence)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj3);
            }
            obj1 = addop.apply2(obj1, Integer.valueOf(strings.stringLength(charsequence)));
            do
            {
                if (Scheme.numGEq.apply2(obj2, Integer.valueOf(i)) != Boolean.FALSE)
                {
                    return Scheme.applyToArgs.applyN(new Object[] {
                        staticLink.staticLink.staticLink.cont, obj, staticLink.staticLink.sgn, "0", printf.Lit7
                    });
                }
                obj3 = printf.Lit9;
                int j;
                try
                {
                    j = ((Number)obj2).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj2);
                }
                if (characters.isChar$Eq(((Char) (obj3)), Char.make(strings.stringRef(fstring, j))))
                {
                    obj2 = AddOp.$Pl.apply2(obj2, printf.Lit7);
                    obj1 = AddOp.$Mn.apply2(obj1, printf.Lit7);
                } else
                {
                    obj3 = Scheme.applyToArgs;
                    Object obj4 = staticLink.staticLink.staticLink.cont;
                    Object obj5 = staticLink.staticLink.sgn;
                    obj2 = AddOp.$Mn.apply2(obj2, printf.Lit7);
                    int k;
                    try
                    {
                        k = ((Number)obj2).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "substring", 2, obj2);
                    }
                    return ((Procedure) (obj3)).applyN(new Object[] {
                        obj4, obj, obj5, strings.substring(fstring, k, i), obj1
                    });
                }
            } while (true);
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 6)
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

        public frame5()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 6, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:92");
            lambda$Fn10 = modulemethod;
        }
    }

    public class frame6 extends ModuleBody
    {

        Object cont;
        final ModuleMethod lambda$Fn11;
        frame staticLink;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 5)
            {
                return lambda15(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda15(Object obj, Object obj1)
        {
            frame7 frame7_1 = new frame7();
            frame7_1.staticLink = this;
            frame7_1.sgn = obj1;
            return staticLink.lambda3digits(obj, frame7_1.Fn12);
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 5)
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

        public frame6()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 5, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:67");
            lambda$Fn11 = modulemethod;
        }
    }

    public class frame7 extends ModuleBody
    {

        final ModuleMethod lambda$Fn12;
        Object sgn;
        frame6 staticLink;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 4)
            {
                return lambda16(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda16(Object obj, Object obj1)
        {
            gnu.kawa.functions.ApplyToArgs applytoargs = Scheme.applyToArgs;
            Object obj2 = staticLink.cont;
            Char char1 = printf.Lit5;
            Object obj3 = sgn;
            Char char2;
            try
            {
                char2 = (Char)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "char=?", 2, obj3);
            }
            if (characters.isChar$Eq(char1, char2))
            {
                obj3 = AddOp.$Mn;
                CharSequence charsequence;
                try
                {
                    charsequence = (CharSequence)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string->number", 1, obj1);
                }
                obj1 = ((Procedure) (obj3)).apply1(numbers.string$To$Number(charsequence));
            } else
            {
                try
                {
                    obj3 = (CharSequence)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string->number", 1, obj1);
                }
                obj1 = numbers.string$To$Number(((CharSequence) (obj3)));
            }
            return applytoargs.apply3(obj2, obj, obj1);
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 4)
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

        public frame7()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 4, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:69");
            lambda$Fn12 = modulemethod;
        }
    }

    public class frame8 extends ModuleBody
    {

        CharSequence str;

        public Object lambda17dig(Object obj)
        {
            CharSequence charsequence = str;
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "string-ref", 2, obj);
            }
            i = strings.stringRef(charsequence, i);
            if (unicode.isCharNumeric(Char.make(i)))
            {
                return numbers.string$To$Number(strings.$make$string$(new Object[] {
                    Char.make(i)
                }));
            } else
            {
                return printf.Lit1;
            }
        }

        public frame8()
        {
        }
    }

    public class frame9 extends ModuleBody
    {

        LList args;
        Object fc;
        int fl;
        Object format$Mnstring;
        Object out;
        Object pos;

        public Object lambda18mustAdvance()
        {
            pos = AddOp.$Pl.apply2(printf.Lit7, pos);
            if (Scheme.numGEq.apply2(pos, Integer.valueOf(fl)) != Boolean.FALSE)
            {
                return lambda20incomplete();
            }
            Object obj = format$Mnstring;
            CharSequence charsequence;
            int i;
            try
            {
                charsequence = (CharSequence)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "string-ref", 1, obj);
            }
            obj = pos;
            try
            {
                i = ((Number)obj).intValue();
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "string-ref", 2, obj);
            }
            fc = Char.make(strings.stringRef(charsequence, i));
            return Values.empty;
        }

        public boolean lambda19isEndOfFormat()
        {
            return ((Boolean)Scheme.numGEq.apply2(pos, Integer.valueOf(fl))).booleanValue();
        }

        public Object lambda20incomplete()
        {
            return misc.error$V(printf.Lit34, new Object[] {
                "conversion specification incomplete", format$Mnstring
            });
        }

        public Object lambda21out$St(Object obj)
        {
label0:
            {
                Object obj1 = obj;
                if (strings.isString(obj))
                {
                    return Scheme.applyToArgs.apply2(out, obj);
                }
                boolean flag;
                while (!(flag = lists.isNull(obj1))) 
                {
                    obj = Scheme.applyToArgs.apply2(out, lists.car.apply1(obj1));
                    if (obj == Boolean.FALSE)
                    {
                        break label0;
                    }
                    obj1 = lists.cdr.apply1(obj1);
                }
                if (flag)
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            }
            return obj;
        }

        public frame9()
        {
        }
    }


    public static final printf $instance;
    static final IntNum Lit0 = IntNum.make(-15);
    static final IntNum Lit1 = IntNum.make(0);
    static final PairWithPosition Lit10;
    static final Char Lit11 = Char.make(46);
    static final Char Lit12;
    static final Char Lit13;
    static final IntNum Lit14 = IntNum.make(2);
    static final IntNum Lit15 = IntNum.make(5);
    static final IntNum Lit16 = IntNum.make(9);
    static final IntNum Lit17 = IntNum.make(-1);
    static final Char Lit18 = Char.make(92);
    static final Char Lit19 = Char.make(110);
    static final PairWithPosition Lit2;
    static final Char Lit20 = Char.make(78);
    static final Char Lit21 = Char.make(10);
    static final Char Lit22 = Char.make(116);
    static final Char Lit23 = Char.make(84);
    static final Char Lit24 = Char.make(9);
    static final Char Lit25;
    static final Char Lit26;
    static final Char Lit27 = Char.make(12);
    static final Char Lit28 = Char.make(37);
    static final Char Lit29 = Char.make(32);
    static final Char Lit3;
    static final Char Lit30;
    static final Char Lit31;
    static final Char Lit32 = Char.make(104);
    static final PairWithPosition Lit33;
    static final SimpleSymbol Lit34;
    static final Char Lit35;
    static final Char Lit36 = Char.make(67);
    static final Char Lit37;
    static final Char Lit38;
    static final Char Lit39;
    static final Char Lit4 = Char.make(64);
    static final Char Lit40 = Char.make(65);
    static final Char Lit41;
    static final Char Lit42 = Char.make(73);
    static final Char Lit43;
    static final Char Lit44 = Char.make(85);
    static final IntNum Lit45 = IntNum.make(10);
    static final Char Lit46;
    static final Char Lit47 = Char.make(79);
    static final IntNum Lit48 = IntNum.make(8);
    static final Char Lit49;
    static final Char Lit5;
    static final IntNum Lit50 = IntNum.make(16);
    static final Char Lit51 = Char.make(88);
    static final Char Lit52;
    static final Char Lit53 = Char.make(66);
    static final Char Lit54;
    static final Char Lit55;
    static final Char Lit56 = Char.make(71);
    static final Char Lit57;
    static final Char Lit58 = Char.make(75);
    static final IntNum Lit59 = IntNum.make(6);
    static final Char Lit6;
    static final IntNum Lit60 = IntNum.make(-10);
    static final IntNum Lit61 = IntNum.make(3);
    static final FVector Lit62 = FVector.make(new Object[] {
        "y", "z", "a", "f", "p", "n", "u", "m", "", "k", 
        "M", "G", "T", "P", "E", "Z", "Y"
    });
    static final PairWithPosition Lit63;
    static final SimpleSymbol Lit64 = (SimpleSymbol)(new SimpleSymbol("format-real")).readResolve();
    static final Char Lit65 = Char.make(63);
    static final Char Lit66 = Char.make(42);
    static final SimpleSymbol Lit67 = (SimpleSymbol)(new SimpleSymbol("pad")).readResolve();
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final IntNum Lit7 = IntNum.make(1);
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final Char Lit8 = Char.make(35);
    static final Char Lit9 = Char.make(48);
    public static final ModuleMethod fprintf;
    public static final ModuleMethod printf;
    public static final ModuleMethod sprintf;
    public static final boolean stdio$Clhex$Mnupper$Mncase$Qu = false;
    public static final ModuleMethod stdio$Cliprintf;
    public static final ModuleMethod stdio$Clparse$Mnfloat;
    public static final ModuleMethod stdio$Clround$Mnstring;

    public printf()
    {
        ModuleInfo.register(this);
    }

    public static Object fprintf$V(Object obj, Object obj1, Object aobj[])
    {
        frame12 frame12_1 = new frame12();
        frame12_1.port = obj;
        obj = LList.makeList(aobj, 0);
        frame12_1.cnt = Lit1;
        Scheme.apply.apply4(stdio$Cliprintf, frame12_1.Fn18, obj1, obj);
        return frame12_1.cnt;
    }

    public static Object printf$V(Object obj, Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return Scheme.apply.apply4(fprintf, ports.current$Mnoutput$Mnport.apply0(), obj, ((Object) (aobj)));
    }

    public static Object sprintf$V(Object obj, Object obj1, Object aobj[])
    {
        frame13 frame13_1 = new frame13();
        frame13_1.str = obj;
        aobj = LList.makeList(aobj, 0);
        frame13_1.cnt = Lit1;
        CharSequence charsequence;
        if (strings.isString(frame13_1.str))
        {
            obj = frame13_1.str;
        } else
        if (numbers.isNumber(frame13_1.str))
        {
            obj = frame13_1.str;
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "make-string", 1, obj);
            }
            obj = strings.makeString(i);
        } else
        if (frame13_1.str == Boolean.FALSE)
        {
            obj = strings.makeString(100);
        } else
        {
            obj = misc.error$V(Lit68, new Object[] {
                "first argument not understood", frame13_1.str
            });
        }
        frame13_1.s = obj;
        obj = frame13_1.s;
        try
        {
            charsequence = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
        }
        frame13_1.end = Integer.valueOf(strings.stringLength(charsequence));
        Scheme.apply.apply4(stdio$Cliprintf, frame13_1.Fn19, obj1, ((Object) (aobj)));
        if (strings.isString(frame13_1.str))
        {
            return frame13_1.cnt;
        }
        if (Scheme.isEqv.apply2(frame13_1.end, frame13_1.cnt) != Boolean.FALSE)
        {
            return frame13_1.s;
        }
        obj = frame13_1.s;
        try
        {
            obj1 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "substring", 1, obj);
        }
        obj = frame13_1.cnt;
        try
        {
            i = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "substring", 3, obj);
        }
        return strings.substring(((CharSequence) (obj1)), 0, i);
    }

    public static Object stdio$ClIprintf$V(Object obj, Object obj1, Object aobj[])
    {
        Object obj2;
        frame9 frame9_1 = new frame9();
        frame9_1.out = obj;
        frame9_1.Mnstring = obj1;
        frame9_1.args = LList.makeList(aobj, 0);
        if (IsEqual.apply("", frame9_1.Mnstring))
        {
            break MISSING_BLOCK_LABEL_3353;
        }
        obj = Lit17;
        obj1 = frame9_1.Mnstring;
        Object obj3;
        Object obj4;
        Object obj5;
        int i;
        boolean flag;
        try
        {
            aobj = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
        }
        i = strings.stringLength(((CharSequence) (aobj)));
        obj1 = frame9_1.Mnstring;
        try
        {
            aobj = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj1);
        }
        frame9_1.fc = Char.make(strings.stringRef(((CharSequence) (aobj)), 0));
        frame9_1.fl = i;
        frame9_1.pos = obj;
        obj = frame9_1.args;
        aobj = new frame10();
        aobj.staticLink = frame9_1;
        aobj.args = obj;
        frame9_1.pos = AddOp.$Pl.apply2(Lit7, frame9_1.pos);
        if (Scheme.numGEq.apply2(frame9_1.pos, Integer.valueOf(frame9_1.fl)) != Boolean.FALSE)
        {
            frame9_1.fc = Boolean.FALSE;
        } else
        {
            obj = frame9_1.Mnstring;
            try
            {
                obj1 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
            }
            obj = frame9_1.pos;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
            }
            frame9_1.fc = Char.make(strings.stringRef(((CharSequence) (obj1)), i));
        }
        flag = frame9_1.lambda19isEndOfFormat();
        if (!flag) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            obj = Boolean.TRUE;
        } else
        {
            obj = Boolean.FALSE;
        }
_L8:
        return obj;
_L2:
label0:
        {
            if (Scheme.isEqv.apply2(Lit18, frame9_1.fc) == Boolean.FALSE)
            {
                break label0;
            }
            frame9_1.lambda18mustAdvance();
            obj = frame9_1.fc;
            obj1 = Scheme.isEqv.apply2(obj, Lit19);
            if (obj1 == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit20) != Boolean.FALSE : obj1 != Boolean.FALSE)
            {
                obj = Scheme.applyToArgs.apply2(frame9_1.out, Lit21);
            } else
            {
                obj1 = Scheme.isEqv.apply2(obj, Lit22);
                if (obj1 == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit23) != Boolean.FALSE : obj1 != Boolean.FALSE)
                {
                    obj = Scheme.applyToArgs.apply2(frame9_1.out, Lit24);
                } else
                {
                    obj1 = Scheme.isEqv.apply2(obj, Lit25);
                    if (obj1 == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit26) != Boolean.FALSE : obj1 != Boolean.FALSE)
                    {
                        obj = Scheme.applyToArgs.apply2(frame9_1.out, Lit27);
                    } else
                    if (Scheme.isEqv.apply2(obj, Lit21) != Boolean.FALSE)
                    {
                        obj = Boolean.TRUE;
                    } else
                    {
                        obj = Scheme.applyToArgs.apply2(frame9_1.out, frame9_1.fc);
                    }
                }
            }
            if (obj != Boolean.FALSE)
            {
                obj = ((frame10) (aobj)).args;
            } else
            {
                return obj;
            }
        }
        break MISSING_BLOCK_LABEL_97;
        if (Scheme.isEqv.apply2(Lit28, frame9_1.fc) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_3321;
        }
        frame9_1.lambda18mustAdvance();
        obj = Boolean.FALSE;
        obj1 = Boolean.FALSE;
        obj2 = Boolean.FALSE;
        obj3 = Boolean.FALSE;
        obj4 = Boolean.FALSE;
        obj5 = Lit1;
        aobj.precision = Lit17;
        aobj.width = obj5;
        aobj.Mn0s = obj4;
        aobj.Mnform = obj3;
        aobj.blank = obj2;
        aobj.signed = obj1;
        aobj.Mnadjust = obj;
        aobj.pad = ((frame10) (aobj)).pad;
_L4:
        obj = frame9_1.fc;
        if (Scheme.isEqv.apply2(obj, Lit5) == Boolean.FALSE)
        {
            break; /* Loop/switch isn't completed */
        }
        aobj.Mnadjust = Boolean.TRUE;
_L5:
        frame9_1.lambda18mustAdvance();
        if (true) goto _L4; else goto _L3
_L3:
        if (Scheme.isEqv.apply2(obj, Lit6) != Boolean.FALSE)
        {
            aobj.signed = Boolean.TRUE;
        } else
        if (Scheme.isEqv.apply2(obj, Lit29) != Boolean.FALSE)
        {
            aobj.blank = Boolean.TRUE;
        } else
        if (Scheme.isEqv.apply2(obj, Lit8) != Boolean.FALSE)
        {
            aobj.Mnform = Boolean.TRUE;
        } else
        {
label1:
            {
                if (Scheme.isEqv.apply2(obj, Lit9) == Boolean.FALSE)
                {
                    break label1;
                }
                aobj.Mn0s = Boolean.TRUE;
            }
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        if (((frame10) (aobj)).Mnadjust != Boolean.FALSE)
        {
            aobj.Mn0s = Boolean.FALSE;
        }
        if (((frame10) (aobj)).signed != Boolean.FALSE)
        {
            aobj.blank = Boolean.FALSE;
        }
        aobj.width = ((frame10) (aobj)).lambda22readFormatNumber();
        obj = ((frame10) (aobj)).width;
        try
        {
            obj1 = LangObjType.coerceRealNum(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "negative?", 1, obj);
        }
        if (numbers.isNegative(((gnu.math.RealNum) (obj1))))
        {
            aobj.Mnadjust = Boolean.TRUE;
            aobj.width = AddOp.$Mn.apply1(((frame10) (aobj)).width);
        }
        if (Scheme.isEqv.apply2(Lit11, frame9_1.fc) != Boolean.FALSE)
        {
            frame9_1.lambda18mustAdvance();
            aobj.precision = ((frame10) (aobj)).lambda22readFormatNumber();
        }
        obj = frame9_1.fc;
        obj1 = Scheme.isEqv.apply2(obj, Lit30);
        if (obj1 == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit31)) == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit32) != Boolean.FALSE : obj1 != Boolean.FALSE : obj1 != Boolean.FALSE)
        {
            frame9_1.lambda18mustAdvance();
        }
        if (lists.isNull(((frame10) (aobj)).args))
        {
            obj = frame9_1.fc;
            try
            {
                obj1 = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "char-downcase", 1, obj);
            }
            if (lists.memv(unicode.charDowncase(((Char) (obj1))), Lit33) != Boolean.FALSE)
            {
                misc.error$V(Lit34, new Object[] {
                    "wrong number of arguments", Integer.valueOf(lists.length(frame9_1.args)), frame9_1.Mnstring
                });
            }
        }
        obj = frame9_1.fc;
        obj1 = Scheme.isEqv.apply2(obj, Lit35);
        if (obj1 == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit36) != Boolean.FALSE : obj1 != Boolean.FALSE)
        {
            obj1 = Scheme.applyToArgs;
            obj2 = frame9_1.out;
            obj = lists.car.apply1(((frame10) (aobj)).args);
            if (obj instanceof Object[])
            {
                obj = ((Object) ((Object[])obj));
            } else
            {
                obj = ((Object) (new Object[] {
                    obj
                }));
            }
            obj1 = ((Procedure) (obj1)).apply2(obj2, strings.$make$string$(((Object []) (obj))));
            obj = obj1;
        } else
        {
            break MISSING_BLOCK_LABEL_1110;
        }
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L7
_L7:
        obj = lists.cdr.apply1(((frame10) (aobj)).args);
        break MISSING_BLOCK_LABEL_97;
        obj1 = Scheme.isEqv.apply2(obj, Lit37);
        if (obj1 == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit38) != Boolean.FALSE : obj1 != Boolean.FALSE) goto _L10; else goto _L9
_L10:
        if (misc.isSymbol(lists.car.apply1(((frame10) (aobj)).args)))
        {
            obj = lists.car.apply1(((frame10) (aobj)).args);
            try
            {
                obj1 = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "symbol->string", 1, obj);
            }
            obj = misc.symbol$To$String(((Symbol) (obj1)));
        } else
        if (lists.car.apply1(((frame10) (aobj)).args) == Boolean.FALSE)
        {
            obj = "(NULL)";
        } else
        {
            obj = lists.car.apply1(((frame10) (aobj)).args);
        }
        obj1 = ((frame10) (aobj)).precision;
        try
        {
            obj2 = LangObjType.coerceRealNum(obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "negative?", 1, obj1);
        }
        flag = numbers.isNegative(((gnu.math.RealNum) (obj2)));
        if (!flag) goto _L12; else goto _L11
_L11:
        obj1 = obj;
        if (flag) goto _L14; else goto _L13
_L13:
        try
        {
            obj1 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "substring", 1, obj);
        }
        obj = ((frame10) (aobj)).precision;
        try
        {
            i = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "substring", 3, obj);
        }
        obj1 = strings.substring(((CharSequence) (obj1)), 0, i);
_L14:
        obj = Scheme.numLEq;
        obj2 = ((frame10) (aobj)).width;
        try
        {
            obj3 = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
        }
        if (((Procedure) (obj)).apply2(obj2, Integer.valueOf(strings.stringLength(((CharSequence) (obj3))))) == Boolean.FALSE)
        {
            if (((frame10) (aobj)).Mnadjust != Boolean.FALSE)
            {
                obj = AddOp.$Mn;
                obj2 = ((frame10) (aobj)).width;
                try
                {
                    obj3 = (CharSequence)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
                }
                obj = ((Procedure) (obj)).apply2(obj2, Integer.valueOf(strings.stringLength(((CharSequence) (obj3)))));
                try
                {
                    i = ((Number)obj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "make-string", 1, obj);
                }
                obj1 = LList.list2(obj1, strings.makeString(i, Lit29));
            } else
            {
                obj = AddOp.$Mn;
                obj2 = ((frame10) (aobj)).width;
                try
                {
                    obj3 = (CharSequence)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
                }
                obj = ((Procedure) (obj)).apply2(obj2, Integer.valueOf(strings.stringLength(((CharSequence) (obj3)))));
                try
                {
                    i = ((Number)obj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "make-string", 1, obj);
                }
                if (((frame10) (aobj)).Mn0s != Boolean.FALSE)
                {
                    obj = Lit9;
                } else
                {
                    obj = Lit29;
                }
                obj1 = LList.list2(strings.makeString(i, obj), obj1);
            }
        }
        obj1 = frame9_1.St(obj1);
        obj = obj1;
        if (obj1 != Boolean.FALSE)
        {
            obj = lists.cdr.apply1(((frame10) (aobj)).args);
            break MISSING_BLOCK_LABEL_97;
        }
          goto _L8
_L9:
        obj1 = Scheme.isEqv.apply2(obj, Lit39);
        if (obj1 == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit40) != Boolean.FALSE : obj1 != Boolean.FALSE) goto _L16; else goto _L15
_L16:
        aobj.pr = ((frame10) (aobj)).precision;
        aobj.os = "";
        obj2 = lists.car.apply1(((frame10) (aobj)).args);
        if (((frame10) (aobj)).Mnform != Boolean.FALSE)
        {
            obj1 = Boolean.FALSE;
        } else
        {
            obj1 = Boolean.TRUE;
        }
        obj3 = Boolean.FALSE;
        obj = ((frame10) (aobj)).Mnadjust;
        if (obj == Boolean.FALSE) goto _L18; else goto _L17
_L17:
        obj = ((frame10) (aobj)).pr;
        try
        {
            obj4 = LangObjType.coerceRealNum(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "negative?", 1, obj);
        }
        if (!numbers.isNegative(((gnu.math.RealNum) (obj4)))) goto _L20; else goto _L19
_L19:
        aobj.pr = Lit1;
        obj = ((frame10) (aobj)).Fn13;
_L26:
        genwrite.genericWrite(obj2, obj1, obj3, obj);
        obj = ((frame10) (aobj)).Mnadjust;
        if (obj == Boolean.FALSE) goto _L22; else goto _L21
_L21:
        obj = ((frame10) (aobj)).precision;
        try
        {
            obj1 = LangObjType.coerceRealNum(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "negative?", 1, obj);
        }
        if (!numbers.isNegative(((gnu.math.RealNum) (obj1)))) goto _L24; else goto _L23
_L23:
        if (Scheme.numGrt.apply2(((frame10) (aobj)).width, ((frame10) (aobj)).pr) != Boolean.FALSE)
        {
            obj1 = Scheme.applyToArgs;
            obj2 = frame9_1.out;
            obj = AddOp.$Mn.apply2(((frame10) (aobj)).width, ((frame10) (aobj)).pr);
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "make-string", 1, obj);
            }
            ((Procedure) (obj1)).apply2(obj2, strings.makeString(i, Lit29));
        }
_L27:
        obj = lists.cdr.apply1(((frame10) (aobj)).args);
        break MISSING_BLOCK_LABEL_97;
_L12:
        obj2 = Scheme.numGEq;
        obj3 = ((frame10) (aobj)).precision;
        try
        {
            obj4 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
        }
        obj1 = obj;
        if (((Procedure) (obj2)).apply2(obj3, Integer.valueOf(strings.stringLength(((CharSequence) (obj4))))) != Boolean.FALSE) goto _L14; else goto _L13
_L15:
label2:
        {
            obj1 = Scheme.isEqv.apply2(obj, Lit12);
            if (obj1 == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit41)) == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit3)) == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit42)) == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit43)) == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit44) != Boolean.FALSE : obj1 != Boolean.FALSE : obj1 != Boolean.FALSE : obj1 != Boolean.FALSE : obj1 != Boolean.FALSE : obj1 != Boolean.FALSE)
            {
                break label2;
            } else
            {
                break MISSING_BLOCK_LABEL_2264;
            }
        }
        obj1 = frame9_1.St(((frame10) (aobj)).lambda24integerConvert(lists.car.apply1(((frame10) (aobj)).args), Lit45, Boolean.FALSE));
        obj = obj1;
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L25
_L25:
        obj = lists.cdr.apply1(((frame10) (aobj)).args);
        break MISSING_BLOCK_LABEL_97;
_L18:
        if (obj != Boolean.FALSE) goto _L19; else goto _L20
_L20:
        if (((frame10) (aobj)).Mnadjust != Boolean.FALSE)
        {
            obj = ((frame10) (aobj)).Fn14;
        } else
        {
            obj = ((frame10) (aobj)).pr;
            try
            {
                obj4 = LangObjType.coerceRealNum(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "negative?", 1, obj);
            }
            if (numbers.isNegative(((gnu.math.RealNum) (obj4))))
            {
                aobj.pr = ((frame10) (aobj)).width;
                obj = ((frame10) (aobj)).Fn15;
            } else
            {
                obj = ((frame10) (aobj)).Fn16;
            }
        }
          goto _L26
_L22:
        if (obj != Boolean.FALSE) goto _L23; else goto _L24
_L24:
        if (((frame10) (aobj)).Mnadjust != Boolean.FALSE)
        {
            if (Scheme.numGrt.apply2(((frame10) (aobj)).width, AddOp.$Mn.apply2(((frame10) (aobj)).precision, ((frame10) (aobj)).pr)) != Boolean.FALSE)
            {
                obj1 = Scheme.applyToArgs;
                obj2 = frame9_1.out;
                obj = AddOp.$Mn.apply2(((frame10) (aobj)).width, AddOp.$Mn.apply2(((frame10) (aobj)).precision, ((frame10) (aobj)).pr));
                try
                {
                    i = ((Number)obj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "make-string", 1, obj);
                }
                ((Procedure) (obj1)).apply2(obj2, strings.makeString(i, Lit29));
            }
        } else
        {
            obj = ((frame10) (aobj)).os;
            try
            {
                obj1 = Boolean.FALSE;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "x", -2, obj);
            }
            if (obj != obj1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if ((i + 1 & 1) == 0)
            {
                obj1 = Scheme.numLEq;
                obj2 = ((frame10) (aobj)).width;
                obj = ((frame10) (aobj)).os;
                try
                {
                    obj3 = (CharSequence)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
                }
                if (((Procedure) (obj1)).apply2(obj2, Integer.valueOf(strings.stringLength(((CharSequence) (obj3))))) != Boolean.FALSE)
                {
                    Scheme.applyToArgs.apply2(frame9_1.out, ((frame10) (aobj)).os);
                } else
                {
                    obj = Scheme.applyToArgs;
                    obj1 = frame9_1.out;
                    obj3 = AddOp.$Mn;
                    obj4 = ((frame10) (aobj)).width;
                    obj2 = ((frame10) (aobj)).os;
                    try
                    {
                        obj5 = (CharSequence)obj2;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj2);
                    }
                    obj2 = ((Procedure) (obj3)).apply2(obj4, Integer.valueOf(strings.stringLength(((CharSequence) (obj5)))));
                    try
                    {
                        i = ((Number)obj2).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "make-string", 1, obj2);
                    }
                    if (((Procedure) (obj)).apply2(obj1, strings.makeString(i, Lit29)) != Boolean.FALSE)
                    {
                        Scheme.applyToArgs.apply2(frame9_1.out, ((frame10) (aobj)).os);
                    }
                }
            }
        }
          goto _L27
        obj1 = Scheme.isEqv.apply2(obj, Lit46);
        if (obj1 == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit47) != Boolean.FALSE : obj1 != Boolean.FALSE)
        {
            obj1 = frame9_1.St(((frame10) (aobj)).lambda24integerConvert(lists.car.apply1(((frame10) (aobj)).args), Lit48, Boolean.FALSE));
            obj = obj1;
        } else
        {
            break MISSING_BLOCK_LABEL_2456;
        }
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L28
_L28:
        obj = lists.cdr.apply1(((frame10) (aobj)).args);
        break MISSING_BLOCK_LABEL_97;
        if (Scheme.isEqv.apply2(obj, Lit49) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_2541;
        }
        obj1 = lists.car.apply1(((frame10) (aobj)).args);
        obj2 = Lit50;
        if (stdio$Clhex$Mnupper$Mncase$Qu)
        {
            obj = unicode.string$Mndowncase;
        } else
        {
            obj = Boolean.FALSE;
        }
        obj1 = frame9_1.St(((frame10) (aobj)).lambda24integerConvert(obj1, obj2, obj));
        obj = obj1;
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L29
_L29:
        obj = lists.cdr.apply1(((frame10) (aobj)).args);
        break MISSING_BLOCK_LABEL_97;
        if (Scheme.isEqv.apply2(obj, Lit51) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_2626;
        }
        obj1 = lists.car.apply1(((frame10) (aobj)).args);
        obj2 = Lit50;
        if (stdio$Clhex$Mnupper$Mncase$Qu)
        {
            obj = Boolean.FALSE;
        } else
        {
            obj = unicode.string$Mnupcase;
        }
        obj1 = frame9_1.St(((frame10) (aobj)).lambda24integerConvert(obj1, obj2, obj));
        obj = obj1;
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L30
_L30:
        obj = lists.cdr.apply1(((frame10) (aobj)).args);
        break MISSING_BLOCK_LABEL_97;
        obj1 = Scheme.isEqv.apply2(obj, Lit52);
        if (obj1 == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit53) != Boolean.FALSE : obj1 != Boolean.FALSE)
        {
            obj1 = frame9_1.St(((frame10) (aobj)).lambda24integerConvert(lists.car.apply1(((frame10) (aobj)).args), Lit14, Boolean.FALSE));
            obj = obj1;
        } else
        {
            break MISSING_BLOCK_LABEL_2715;
        }
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L31
_L31:
        obj = lists.cdr.apply1(((frame10) (aobj)).args);
        break MISSING_BLOCK_LABEL_97;
        if (Scheme.isEqv.apply2(obj, Lit28) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_2762;
        }
        obj1 = Scheme.applyToArgs.apply2(frame9_1.out, Lit28);
        obj = obj1;
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L32
_L32:
        obj = ((frame10) (aobj)).args;
        break MISSING_BLOCK_LABEL_97;
        obj1 = Scheme.isEqv.apply2(obj, Lit25);
        if (obj1 == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit26)) == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit13)) == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit54)) == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit55)) == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit56)) == Boolean.FALSE ? (obj1 = Scheme.isEqv.apply2(obj, Lit57)) == Boolean.FALSE ? Scheme.isEqv.apply2(obj, Lit58) == Boolean.FALSE : obj1 == Boolean.FALSE : obj1 == Boolean.FALSE : obj1 == Boolean.FALSE : obj1 == Boolean.FALSE : obj1 == Boolean.FALSE : obj1 == Boolean.FALSE : obj1 == Boolean.FALSE) goto _L34; else goto _L33
_L33:
        obj = lists.car.apply1(((frame10) (aobj)).args);
        obj2 = frame9_1.fc;
        obj1 = new frame11();
        obj1.staticLink = ((frame10) (aobj));
        obj1.fc = obj2;
        obj2 = ((frame10) (aobj)).precision;
        try
        {
            obj3 = LangObjType.coerceRealNum(obj2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "negative?", 1, obj2);
        }
        if (!numbers.isNegative(((gnu.math.RealNum) (obj3)))) goto _L36; else goto _L35
_L35:
        aobj.precision = Lit59;
_L40:
        if (numbers.isNumber(obj))
        {
            try
            {
                obj2 = (Number)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "exact->inexact", 1, obj);
            }
            obj = numbers.number$To$String(numbers.exact$To$Inexact(((Number) (obj2))));
        } else
        if (!strings.isString(obj))
        {
            if (misc.isSymbol(obj))
            {
                try
                {
                    obj2 = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "symbol->string", 1, obj);
                }
                obj = misc.symbol$To$String(((Symbol) (obj2)));
            } else
            {
                obj = "???";
            }
        }
        obj1.Mnreal = ((frame11) (obj1)).Mnreal;
        obj = stdio$ClParseFloat(obj, ((frame11) (obj1)).Fn17);
        if (obj == Boolean.FALSE)
        {
            obj = ((frame10) (aobj)).V("???", new Object[0]);
        }
        obj1 = frame9_1.St(obj);
        obj = obj1;
        if (obj1 != Boolean.FALSE)
        {
            obj = lists.cdr.apply1(((frame10) (aobj)).args);
            break MISSING_BLOCK_LABEL_97;
        }
          goto _L8
_L34:
        if (frame9_1.lambda19isEndOfFormat())
        {
            return frame9_1.lambda20incomplete();
        }
        obj1 = Scheme.applyToArgs.apply2(frame9_1.out, Lit28);
        obj = obj1;
        continue; /* Loop/switch isn't completed */
_L36:
        obj2 = ((frame10) (aobj)).precision;
        try
        {
            obj3 = (Number)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "zero?", 1, obj2);
        }
        flag = numbers.isZero(((Number) (obj3)));
        if (!flag) goto _L38; else goto _L37
_L37:
        obj2 = ((frame11) (obj1)).fc;
        try
        {
            obj3 = (Char)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "char-ci=?", 1, obj2);
        }
        if (!unicode.isCharCi$Eq(((Char) (obj3)), Lit55)) goto _L40; else goto _L39
_L39:
        aobj.precision = Lit7;
        break; /* Loop/switch isn't completed */
_L38:
        if (!flag) goto _L40; else goto _L39
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L41
_L41:
        obj1 = Scheme.applyToArgs.apply2(frame9_1.out, frame9_1.fc);
        obj = obj1;
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L42
_L42:
        obj1 = Scheme.applyToArgs.apply2(frame9_1.out, Lit65);
        obj = obj1;
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L43
_L43:
        obj = ((frame10) (aobj)).args;
        break MISSING_BLOCK_LABEL_97;
        obj1 = Scheme.applyToArgs.apply2(frame9_1.out, frame9_1.fc);
        obj = obj1;
        if (obj1 == Boolean.FALSE) goto _L8; else goto _L44
_L44:
        obj = ((frame10) (aobj)).args;
        break MISSING_BLOCK_LABEL_97;
        return Values.empty;
    }

    public static Object stdio$ClParseFloat(Object obj, Object obj1)
    {
        frame frame14 = new frame();
        frame14.str = obj;
        frame14.proc = obj1;
        obj = frame14.str;
        try
        {
            obj1 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
        }
        frame14.n = strings.stringLength(((CharSequence) (obj1)));
        return frame14.lambda4real(Lit1, frame14.Fn1);
    }

    public static Object stdio$ClRoundString(CharSequence charsequence, Object obj, Object obj1)
    {
        Object obj3;
        int i;
        obj3 = new frame8();
        obj3.str = charsequence;
        i = strings.stringLength(((frame8) (obj3)).str) - 1;
        if (Scheme.numLss.apply2(obj, Lit1) == Boolean.FALSE) goto _L2; else goto _L1
_L1:
        charsequence = "";
_L12:
        obj = charsequence;
        if (obj1 == Boolean.FALSE) goto _L4; else goto _L3
_L3:
        Object obj2;
        Object obj4;
        Number number;
        int j;
        boolean flag;
        try
        {
            obj = (CharSequence)charsequence;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, charsequence);
        }
        obj = Integer.valueOf(strings.stringLength(((CharSequence) (obj))) - 1);
        obj2 = Scheme.numLEq.apply2(obj, obj1);
        try
        {
            flag = ((Boolean)obj2).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new WrongType(charsequence, "x", -2, obj2);
        }
        if (!flag) goto _L6; else goto _L5
_L5:
        if (!flag) goto _L8; else goto _L7
_L7:
        try
        {
            obj1 = (CharSequence)charsequence;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "substring", 1, charsequence);
        }
        charsequence = ((CharSequence) (AddOp.$Pl.apply2(obj, Lit7)));
        try
        {
            i = ((Number)charsequence).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "substring", 3, charsequence);
        }
        obj = strings.substring(((CharSequence) (obj1)), 0, i);
_L4:
        return obj;
_L2:
        {
            if (Scheme.numEqu.apply2(Integer.valueOf(i), obj) != Boolean.FALSE)
            {
                charsequence = ((frame8) (obj3)).str;
                continue; /* Loop/switch isn't completed */
            }
            if (Scheme.numLss.apply2(Integer.valueOf(i), obj) != Boolean.FALSE)
            {
                obj2 = Lit1;
                obj4 = AddOp.$Mn;
                charsequence = ((CharSequence) (obj));
                if (obj1 != Boolean.FALSE)
                {
                    charsequence = ((CharSequence) (obj1));
                }
                charsequence = ((CharSequence) (numbers.max(new Object[] {
                    obj2, ((Procedure) (obj4)).apply2(charsequence, Integer.valueOf(i))
                })));
                try
                {
                    obj = (Number)charsequence;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "zero?", 1, charsequence);
                }
                if (numbers.isZero(((Number) (obj))))
                {
                    charsequence = ((frame8) (obj3)).str;
                } else
                {
                    obj = ((frame8) (obj3)).str;
                    try
                    {
                        j = ((Number)charsequence).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "make-string", 1, charsequence);
                    }
                    if (unicode.isCharNumeric(Char.make(strings.stringRef(((frame8) (obj3)).str, i))))
                    {
                        charsequence = Lit9;
                    } else
                    {
                        charsequence = Lit8;
                    }
                    charsequence = strings.stringAppend(new Object[] {
                        obj, strings.makeString(j, charsequence)
                    });
                }
                continue; /* Loop/switch isn't completed */
            }
            obj2 = ((frame8) (obj3)).str;
            charsequence = ((CharSequence) (AddOp.$Pl.apply2(obj, Lit7)));
            try
            {
                j = ((Number)charsequence).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 3, charsequence);
            }
            obj2 = strings.substring(((CharSequence) (obj2)), 0, j);
            obj4 = ((frame8) (obj3)).lambda17dig(AddOp.$Pl.apply2(Lit7, obj));
            charsequence = ((CharSequence) (Scheme.numGrt.apply2(obj4, Lit15)));
            try
            {
                flag = ((Boolean)charsequence).booleanValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "x", -2, charsequence);
            }
            if (flag)
            {
                charsequence = ((CharSequence) (obj2));
                if (!flag)
                {
                    continue; /* Loop/switch isn't completed */
                }
                break MISSING_BLOCK_LABEL_398;
            }
            charsequence = ((CharSequence) (Scheme.numEqu.apply2(obj4, Lit15)));
            try
            {
                flag = ((Boolean)charsequence).booleanValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "x", -2, charsequence);
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_591;
            }
            charsequence = ((CharSequence) (AddOp.$Pl.apply2(Lit14, obj)));
        }
        if (Scheme.numGrt.apply2(charsequence, Integer.valueOf(i)) == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_554;
        }
        charsequence = ((CharSequence) (obj2));
        if ((((Number)((frame8) (obj3)).lambda17dig(obj)).intValue() & 1) == 0) goto _L10; else goto _L9
_L10:
        break; /* Loop/switch isn't completed */
        obj4 = ((frame8) (obj3)).lambda17dig(charsequence);
        try
        {
            number = (Number)obj4;
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new WrongType(charsequence, "zero?", 1, obj4);
        }
        if (!numbers.isZero(number)) goto _L9; else goto _L11
_L11:
        charsequence = ((CharSequence) (AddOp.$Pl.apply2(charsequence, Lit7)));
        break MISSING_BLOCK_LABEL_514;
        charsequence = ((CharSequence) (obj2));
        if (!flag) goto _L12; else goto _L9
_L9:
        charsequence = ((CharSequence) (obj));
        do
        {
            obj4 = ((frame8) (obj3)).lambda17dig(charsequence);
            if (Scheme.numLss.apply2(obj4, Lit16) != Boolean.FALSE)
            {
                try
                {
                    obj = (CharSeq)obj2;
                }
                // Misplaced declaration of an exception variable
                catch (CharSequence charsequence)
                {
                    throw new WrongType(charsequence, "string-set!", 1, obj2);
                }
                try
                {
                    i = ((Number)charsequence).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, charsequence);
                }
                charsequence = ((CharSequence) (AddOp.$Pl.apply2(obj4, Lit7)));
                try
                {
                    obj3 = (Number)charsequence;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "number->string", 1, charsequence);
                }
                strings.stringSet$Ex(((CharSeq) (obj)), i, strings.stringRef(numbers.number$To$String(((Number) (obj3))), 0));
                charsequence = ((CharSequence) (obj2));
                break; /* Loop/switch isn't completed */
            }
            try
            {
                obj = (CharSeq)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                throw new WrongType(charsequence, "string-set!", 1, obj2);
            }
            try
            {
                i = ((Number)charsequence).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, charsequence);
            }
            strings.stringSet$Ex(((CharSeq) (obj)), i, '0');
            charsequence = ((CharSequence) (AddOp.$Mn.apply2(charsequence, Lit7)));
        } while (true);
_L6:
        obj2 = Lit9;
        try
        {
            obj3 = (CharSequence)charsequence;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, charsequence);
        }
        i = ((Number)obj).intValue();
        if (!characters.isChar$Eq(((Char) (obj2)), Char.make(strings.stringRef(((CharSequence) (obj3)), i)))) goto _L7; else goto _L8
_L8:
        obj = AddOp.$Mn.apply2(obj, Lit7);
        break MISSING_BLOCK_LABEL_70;
        charsequence;
        throw new WrongType(charsequence, "string-ref", 2, obj);
        if (true) goto _L12; else goto _L13
_L13:
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 22)
        {
            return stdio$ClParseFloat(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 23)
        {
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "stdio:round-string", 1, obj);
            }
            return stdio$ClRoundString(modulemethod, obj1, obj2);
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        Object obj2;
        Object aobj4[];
        int l;
        switch (modulemethod.selector)
        {
        default:
            return super.applyN(modulemethod, aobj);

        case 24: // '\030'
            modulemethod = ((ModuleMethod) (aobj[0]));
            Object obj = aobj[1];
            int i = aobj.length - 2;
            Object aobj2[] = new Object[i];
            do
            {
                i--;
                if (i < 0)
                {
                    return stdio$ClIprintf$V(modulemethod, obj, aobj2);
                }
                aobj2[i] = aobj[i + 2];
            } while (true);

        case 25: // '\031'
            modulemethod = ((ModuleMethod) (aobj[0]));
            Object obj1 = aobj[1];
            int j = aobj.length - 2;
            Object aobj3[] = new Object[j];
            do
            {
                j--;
                if (j < 0)
                {
                    return fprintf$V(modulemethod, obj1, aobj3);
                }
                aobj3[j] = aobj[j + 2];
            } while (true);

        case 26: // '\032'
            modulemethod = ((ModuleMethod) (aobj[0]));
            int k = aobj.length - 1;
            Object aobj1[] = new Object[k];
            do
            {
                k--;
                if (k < 0)
                {
                    return printf$V(modulemethod, aobj1);
                }
                aobj1[k] = aobj[k + 1];
            } while (true);

        case 27: // '\033'
            modulemethod = ((ModuleMethod) (aobj[0]));
            obj2 = aobj[1];
            l = aobj.length - 2;
            aobj4 = new Object[l];
            break;
        }
        do
        {
            l--;
            if (l < 0)
            {
                return sprintf$V(modulemethod, obj2, aobj4);
            }
            aobj4[l] = aobj[l + 2];
        } while (true);
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 22)
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
        if (modulemethod.selector == 23)
        {
            if (obj instanceof CharSequence)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            } else
            {
                return 0xfff40001;
            }
        } else
        {
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 27: // '\033'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 26: // '\032'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 25: // '\031'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 24: // '\030'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
        stdio$Clhex$Mnupper$Mncase$Qu = strings.isString$Eq("-F", numbers.number$To$String(Lit0, 16));
    }

    static 
    {
        Lit72 = (SimpleSymbol)(new SimpleSymbol("fprintf")).readResolve();
        Lit71 = (SimpleSymbol)(new SimpleSymbol("stdio:iprintf")).readResolve();
        Lit70 = (SimpleSymbol)(new SimpleSymbol("stdio:round-string")).readResolve();
        Lit69 = (SimpleSymbol)(new SimpleSymbol("stdio:parse-float")).readResolve();
        Lit68 = (SimpleSymbol)(new SimpleSymbol("sprintf")).readResolve();
        Lit63 = PairWithPosition.make("i", LList.Empty, "printf.scm", 0x18f00b);
        Lit57 = Char.make(107);
        Lit55 = Char.make(103);
        Lit54 = Char.make(69);
        Lit52 = Char.make(98);
        Lit49 = Char.make(120);
        Lit46 = Char.make(111);
        Lit43 = Char.make(117);
        Lit41 = Char.make(68);
        Lit39 = Char.make(97);
        Lit38 = Char.make(83);
        Lit37 = Char.make(115);
        Lit35 = Char.make(99);
        Lit34 = (SimpleSymbol)(new SimpleSymbol("printf")).readResolve();
        Object obj = Lit35;
        Char char1 = Lit37;
        Char char2 = Lit39;
        Char char3 = Char.make(100);
        Lit12 = char3;
        Char char4 = Char.make(105);
        Lit3 = char4;
        Char char5 = Lit43;
        Char char6 = Lit46;
        Char char7 = Lit49;
        Char char8 = Lit52;
        Char char9 = Char.make(102);
        Lit25 = char9;
        Char char10 = Char.make(101);
        Lit13 = char10;
        Lit33 = PairWithPosition.make(obj, PairWithPosition.make(char1, PairWithPosition.make(char2, PairWithPosition.make(char3, PairWithPosition.make(char4, PairWithPosition.make(char5, PairWithPosition.make(char6, PairWithPosition.make(char7, PairWithPosition.make(char8, PairWithPosition.make(char9, PairWithPosition.make(char10, PairWithPosition.make(Lit55, PairWithPosition.make(Lit57, LList.Empty, "printf.scm", 0x1b3014), "printf.scm", 0x1b3010), "printf.scm", 0x1b300c), "printf.scm", 0x1b3008), "printf.scm", 0x1b2028), "printf.scm", 0x1b2024), "printf.scm", 0x1b2020), "printf.scm", 0x1b201c), "printf.scm", 0x1b2018), "printf.scm", 0x1b2014), "printf.scm", 0x1b2010), "printf.scm", 0x1b200c), "printf.scm", 0x1b2007);
        Lit31 = Char.make(76);
        Lit30 = Char.make(108);
        Lit26 = Char.make(70);
        Lit10 = PairWithPosition.make(Lit13, PairWithPosition.make(Lit37, PairWithPosition.make(Lit25, PairWithPosition.make(Lit12, PairWithPosition.make(Lit30, PairWithPosition.make(Lit54, PairWithPosition.make(Lit38, PairWithPosition.make(Lit26, PairWithPosition.make(Lit41, PairWithPosition.make(Lit31, LList.Empty, "printf.scm", 0x4102c), "printf.scm", 0x41028), "printf.scm", 0x41024), "printf.scm", 0x41020), "printf.scm", 0x4101c), "printf.scm", 0x41018), "printf.scm", 0x41014), "printf.scm", 0x41010), "printf.scm", 0x4100c), "printf.scm", 0x41007);
        Lit6 = Char.make(43);
        Lit5 = Char.make(45);
        Lit2 = PairWithPosition.make(Lit6, PairWithPosition.make(Lit5, LList.Empty, "printf.scm", 0x6d027), "printf.scm", 0x6d022);
        $instance = new printf();
        obj = $instance;
        stdio$Clparse$Mnfloat = new ModuleMethod(((ModuleBody) (obj)), 22, Lit69, 8194);
        stdio$Clround$Mnstring = new ModuleMethod(((ModuleBody) (obj)), 23, Lit70, 12291);
        stdio$Cliprintf = new ModuleMethod(((ModuleBody) (obj)), 24, Lit71, -4094);
        fprintf = new ModuleMethod(((ModuleBody) (obj)), 25, Lit72, -4094);
        printf = new ModuleMethod(((ModuleBody) (obj)), 26, Lit34, -4095);
        sprintf = new ModuleMethod(((ModuleBody) (obj)), 27, Lit68, -4094);
        $instance.run();
    }
}
