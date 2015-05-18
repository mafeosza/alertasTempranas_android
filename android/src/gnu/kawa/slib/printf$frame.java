// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.Complex;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.numbers;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class lambda.Fn1 extends ModuleBody
{
    public class printf.frame0 extends ModuleBody
    {

        Object digs;
        Object ex;
        final ModuleMethod lambda$Fn2;
        final ModuleMethod lambda$Fn3;
        Object num;
        Object sgn;
        printf.frame staticLink;

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
            return printf.frame.lambda1parseError();
        }

        Object lambda7(Object obj, Object obj1, Object obj2)
        {
            printf.frame1 frame1_1 = new printf.frame1();
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
            return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.imagPart(((Complex) (obj1)))), frame1_1.lambda$Fn4);
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

        public printf.frame0()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 2, null, 16388);
            modulemethod.setProperty("source-location", "printf.scm:111");
            lambda$Fn2 = modulemethod;
            modulemethod = new ModuleMethod(this, 3, null, 12291);
            modulemethod.setProperty("source-location", "printf.scm:123");
            lambda$Fn3 = modulemethod;
        }
    }

    public class printf.frame1 extends ModuleBody
    {

        Object digs;
        Object ex;
        final ModuleMethod lambda$Fn4;
        Object sgn;
        printf.frame0 staticLink;

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

        public printf.frame1()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 12291);
            modulemethod.setProperty("source-location", "printf.scm:126");
            lambda$Fn4 = modulemethod;
        }
    }

    public class printf.frame2 extends ModuleBody
    {

        Object cont;
        final ModuleMethod lambda$Fn5;
        final ModuleMethod lambda$Fn6;
        printf.frame staticLink;

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
            printf.frame3 frame3_1 = new printf.frame3();
            frame3_1.staticLink = this;
            frame3_1.sgn = obj1;
            return staticLink.lambda3digits(obj, frame3_1.lambda$Fn7);
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

        public printf.frame2()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 10, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:81");
            lambda$Fn6 = modulemethod;
            modulemethod = new ModuleMethod(this, 11, null, 4097);
            modulemethod.setProperty("source-location", "printf.scm:78");
            lambda$Fn5 = modulemethod;
        }
    }

    public class printf.frame3 extends ModuleBody
    {

        final ModuleMethod lambda$Fn7;
        Object sgn;
        printf.frame2 staticLink;

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
            obj2 = new printf.frame4();
            obj2.staticLink = this;
            obj2.idigs = obj1;
            obj1 = ((printf.frame4) (obj2)).lambda$Fn8;
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

        public printf.frame3()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 9, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:84");
            lambda$Fn7 = modulemethod;
        }
    }

    public class printf.frame4 extends ModuleBody
    {

        Object idigs;
        final ModuleMethod lambda$Fn8;
        final ModuleMethod lambda$Fn9;
        printf.frame3 staticLink;

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
            Object obj2 = new printf.frame5();
            obj2.staticLink = this;
            obj2.fdigs = obj1;
            obj2 = ((printf.frame5) (obj2)).lambda$Fn10;
            Object obj3 = staticLink.staticLink.staticLink;
            obj1 = new printf.frame6();
            obj1.staticLink = ((printf.frame) (obj3));
            obj1.cont = obj2;
            if (Scheme.numGEq.apply2(obj, Integer.valueOf(staticLink.staticLink.staticLink.n)) != Boolean.FALSE)
            {
                return Scheme.applyToArgs.apply3(((printf.frame6) (obj1)).cont, obj, printf.Lit1);
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
                return staticLink.staticLink.staticLink.lambda2sign(AddOp.$Pl.apply2(obj, printf.Lit7), ((printf.frame6) (obj1)).lambda$Fn11);
            } else
            {
                return Scheme.applyToArgs.apply3(((printf.frame6) (obj1)).cont, obj, printf.Lit1);
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

        public printf.frame4()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 7, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:90");
            lambda$Fn9 = modulemethod;
            modulemethod = new ModuleMethod(this, 8, null, 4097);
            modulemethod.setProperty("source-location", "printf.scm:87");
            lambda$Fn8 = modulemethod;
        }
    }

    public class printf.frame5 extends ModuleBody
    {

        Object fdigs;
        final ModuleMethod lambda$Fn10;
        printf.frame4 staticLink;

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

        public printf.frame5()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 6, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:92");
            lambda$Fn10 = modulemethod;
        }
    }

    public class printf.frame6 extends ModuleBody
    {

        Object cont;
        final ModuleMethod lambda$Fn11;
        printf.frame staticLink;

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
            printf.frame7 frame7_1 = new printf.frame7();
            frame7_1.staticLink = this;
            frame7_1.sgn = obj1;
            return staticLink.lambda3digits(obj, frame7_1.lambda$Fn12);
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

        public printf.frame6()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 5, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:67");
            lambda$Fn11 = modulemethod;
        }
    }

    public class printf.frame7 extends ModuleBody
    {

        final ModuleMethod lambda$Fn12;
        Object sgn;
        printf.frame6 staticLink;

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

        public printf.frame7()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 4, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:69");
            lambda$Fn12 = modulemethod;
        }
    }


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
          = new ();
        .staticLink = this;
        .cont = obj1;
        obj1 = .Fn5;
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
          = new ();
        .staticLink = this;
        .sgn = obj1;
        .digs = obj2;
        .ex = obj3;
        if (Scheme.numEqu.apply2(obj, Integer.valueOf(n)) != Boolean.FALSE)
        {
            return Scheme.applyToArgs.apply4(proc, .sgn, .digs, .ex);
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
            return lambda4real(obj, .Fn2);
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
            .num = numbers.string$To$Number(((CharSequence) (obj1)));
            if (.num != Boolean.FALSE)
            {
                obj = .num;
                try
                {
                    obj1 = (Complex)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "real-part", 1, obj);
                }
                return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.realPart(((Complex) (obj1)))), .Fn3);
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

    public .lambda.Fn5()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 12, null, 16388);
        modulemethod.setProperty("source-location", "printf.scm:106");
        lambda$Fn1 = modulemethod;
    }
}
