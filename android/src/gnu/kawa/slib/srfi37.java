// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.IsEqual;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.call_with_values;

public class srfi37 extends ModuleBody
{
    public class option.Mntype
    {

        public Object names;
        public Object optional$Mnarg$Qu;
        public Object processor;
        public Object required$Mnarg$Qu;

        public option.Mntype()
        {
        }
    }

    public class frame extends ModuleBody
    {

        Object operand$Mnproc;
        Object options;
        Object unrecognized$Mnoption$Mnproc;

        public static Object lambda1find(Object obj, Object obj1)
        {
            if (lists.isNull(obj))
            {
                return Boolean.FALSE;
            }
            if (Scheme.applyToArgs.apply2(obj1, lists.car.apply1(obj)) != Boolean.FALSE)
            {
                return lists.car.apply1(obj);
            } else
            {
                return lambda1find(lists.cdr.apply1(obj), obj1);
            }
        }

        public Object lambda2findOption(Object obj)
        {
            frame0 frame0_1 = new frame0();
            frame0_1.staticLink = this;
            frame0_1.name = obj;
            return lambda1find(options, frame0_1.Fn1);
        }

        public Object lambda3scanShortOptions(Object obj, Object obj1, Object obj2, Object obj3)
        {
            frame1 frame1_1 = new frame1();
            frame1_1.staticLink = this;
            frame1_1.index = obj;
            frame1_1.shorts = obj1;
            frame1_1.args = obj2;
            frame1_1.seeds = obj3;
            obj1 = Scheme.numEqu;
            obj2 = frame1_1.index;
            obj = frame1_1.shorts;
            int i;
            boolean flag;
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
                return lambda5scanArgs(frame1_1.args, frame1_1.seeds);
            }
            obj = frame1_1.shorts;
            try
            {
                obj1 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
            }
            obj = frame1_1.index;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
            }
            frame1_1.name = strings.stringRef(((CharSequence) (obj1)), i);
            obj = lambda2findOption(Char.make(frame1_1.name));
            if (obj == Boolean.FALSE)
            {
                obj = srfi37.option(LList.list1(Char.make(frame1_1.name)), Boolean.FALSE, Boolean.FALSE, unrecognized$Mnoption$Mnproc);
            }
            frame1_1.option = obj;
            obj1 = Scheme.numLss;
            obj2 = AddOp.$Pl.apply2(frame1_1.index, srfi37.Lit0);
            obj = frame1_1.shorts;
            try
            {
                obj3 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
            }
            obj = ((Procedure) (obj1)).apply2(obj2, Integer.valueOf(strings.stringLength(((CharSequence) (obj3)))));
            try
            {
                flag = ((Boolean)obj).booleanValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "x", -2, obj);
            }
            if (!flag) goto _L2; else goto _L1
_L1:
            obj = frame1_1.option;
            try
            {
                obj1 = (option.Mntype)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "option-required-arg?", 0, obj);
            }
            obj = srfi37.isOptionRequiredArg(((option.Mntype) (obj1)));
            if (obj == Boolean.FALSE) goto _L4; else goto _L3
_L3:
            if (obj == Boolean.FALSE) goto _L6; else goto _L5
_L5:
            return call_with_values.callWithValues(frame1_1.Fn3, frame1_1.Fn4);
_L4:
            obj = frame1_1.option;
            try
            {
                obj1 = (option.Mntype)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "option-optional-arg?", 0, obj);
            }
            if (srfi37.isOptionOptionalArg(((option.Mntype) (obj1))) != Boolean.FALSE) goto _L5; else goto _L6
_L6:
            obj = frame1_1.option;
            try
            {
                obj1 = (option.Mntype)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "option-required-arg?", 0, obj);
            }
            obj = srfi37.isOptionRequiredArg(((option.Mntype) (obj1)));
            if (obj == Boolean.FALSE ? obj != Boolean.FALSE : lists.isPair(frame1_1.args))
            {
                return call_with_values.callWithValues(frame1_1.Fn5, frame1_1.Fn6);
            } else
            {
                return call_with_values.callWithValues(frame1_1.Fn7, frame1_1.Fn8);
            }
_L2:
            if (!flag) goto _L6; else goto _L5
        }

        public Object lambda4scanOperands(Object obj, Object obj1)
        {
            frame2 frame2_1 = new frame2();
            frame2_1.staticLink = this;
            frame2_1.operands = obj;
            frame2_1.seeds = obj1;
            if (lists.isNull(frame2_1.operands))
            {
                return Scheme.apply.apply2(misc.values, frame2_1.seeds);
            } else
            {
                return call_with_values.callWithValues(frame2_1.Fn9, frame2_1.Fn10);
            }
        }

        public Object lambda5scanArgs(Object obj, Object obj1)
        {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
        }

        public frame()
        {
        }
    }

    public class frame0 extends ModuleBody
    {

        final ModuleMethod lambda$Fn1;
        final ModuleMethod lambda$Fn2;
        Object name;
        frame staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply1(modulemethod, obj);

            case 1: // '\001'
                if (lambda7(obj))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }

            case 2: // '\002'
                return lambda6(obj);
            }
        }

        Object lambda6(Object obj)
        {
            option.Mntype mntype;
            try
            {
                mntype = (option.Mntype)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "option-names", 0, obj);
            }
            return frame.lambda1find(srfi37.optionNames(mntype), lambda$Fn2);
        }

        boolean lambda7(Object obj)
        {
            return IsEqual.apply(name, obj);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match1(modulemethod, obj, callcontext);

            case 2: // '\002'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;

            case 1: // '\001'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }
        }

        public frame0()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
            modulemethod.setProperty("source-location", "srfi37.scm:75");
            lambda$Fn2 = modulemethod;
            modulemethod = new ModuleMethod(this, 2, null, 4097);
            modulemethod.setProperty("source-location", "srfi37.scm:72");
            lambda$Fn1 = modulemethod;
        }
    }

    public class frame1 extends ModuleBody
    {

        Object args;
        Object index;
        final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
        final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 4, null, -4096);
        final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, 0);
        final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 6, null, -4096);
        final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, 0);
        final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 8, null, -4096);
        char name;
        Object option;
        Object seeds;
        Object shorts;
        frame staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            switch (modulemethod.selector)
            {
            case 4: // '\004'
            case 6: // '\006'
            default:
                return super.apply0(modulemethod);

            case 3: // '\003'
                return lambda8();

            case 5: // '\005'
                return lambda10();

            case 7: // '\007'
                return lambda12();
            }
        }

        public Object applyN(ModuleMethod modulemethod, Object aobj[])
        {
            switch (modulemethod.selector)
            {
            case 5: // '\005'
            case 7: // '\007'
            default:
                return super.applyN(modulemethod, aobj);

            case 4: // '\004'
                return lambda9$V(aobj);

            case 6: // '\006'
                return lambda11$V(aobj);

            case 8: // '\b'
                return lambda13$V(aobj);
            }
        }

        Object lambda10()
        {
            gnu.kawa.functions.Apply apply = Scheme.apply;
            Object obj = option;
            option.Mntype mntype;
            try
            {
                mntype = (option.Mntype)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "option-processor", 0, obj);
            }
            return apply.applyN(new Object[] {
                srfi37.optionProcessor(mntype), option, Char.make(name), lists.car.apply1(args), seeds
            });
        }

        Object lambda11$V(Object aobj[])
        {
            aobj = LList.makeList(aobj, 0);
            return staticLink.lambda5scanArgs(lists.cdr.apply1(args), ((Object) (aobj)));
        }

        Object lambda12()
        {
            gnu.kawa.functions.Apply apply = Scheme.apply;
            Object obj = option;
            option.Mntype mntype;
            try
            {
                mntype = (option.Mntype)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "option-processor", 0, obj);
            }
            return apply.applyN(new Object[] {
                srfi37.optionProcessor(mntype), option, Char.make(name), Boolean.FALSE, seeds
            });
        }

        Object lambda13$V(Object aobj[])
        {
            aobj = LList.makeList(aobj, 0);
            return staticLink.lambda3scanShortOptions(AddOp.$Pl.apply2(index, srfi37.Lit0), shorts, args, ((Object) (aobj)));
        }

        Object lambda8()
        {
            gnu.kawa.functions.Apply apply = Scheme.apply;
            Object obj = option;
            Object obj1;
            Char char1;
            CharSequence charsequence;
            Object obj2;
            CharSequence charsequence1;
            int i;
            try
            {
                obj1 = (option.Mntype)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "option-processor", 0, obj);
            }
            obj = srfi37.optionProcessor(((option.Mntype) (obj1)));
            obj1 = option;
            char1 = Char.make(name);
            obj2 = shorts;
            try
            {
                charsequence = (CharSequence)obj2;
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "substring", 1, obj2);
            }
            obj2 = AddOp.$Pl.apply2(index, srfi37.Lit0);
            try
            {
                i = ((Number)obj2).intValue();
            }
            catch (ClassCastException classcastexception2)
            {
                throw new WrongType(classcastexception2, "substring", 2, obj2);
            }
            obj2 = shorts;
            try
            {
                charsequence1 = (CharSequence)obj2;
            }
            catch (ClassCastException classcastexception3)
            {
                throw new WrongType(classcastexception3, "string-length", 1, obj2);
            }
            return apply.applyN(new Object[] {
                obj, obj1, char1, strings.substring(charsequence, i, strings.stringLength(charsequence1)), seeds
            });
        }

        Object lambda9$V(Object aobj[])
        {
            aobj = LList.makeList(aobj, 0);
            return staticLink.lambda5scanArgs(args, ((Object) (aobj)));
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 4: // '\004'
            case 6: // '\006'
            default:
                return super.match0(modulemethod, callcontext);

            case 7: // '\007'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 5: // '\005'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 3: // '\003'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            }
        }

        public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 5: // '\005'
            case 7: // '\007'
            default:
                return super.matchN(modulemethod, aobj, callcontext);

            case 8: // '\b'
                callcontext.values = aobj;
                callcontext.proc = modulemethod;
                callcontext.pc = 5;
                return 0;

            case 6: // '\006'
                callcontext.values = aobj;
                callcontext.proc = modulemethod;
                callcontext.pc = 5;
                return 0;

            case 4: // '\004'
                callcontext.values = aobj;
                callcontext.proc = modulemethod;
                callcontext.pc = 5;
                return 0;
            }
        }

        public frame1()
        {
        }
    }

    public class frame2 extends ModuleBody
    {

        final ModuleMethod lambda$Fn10 = new ModuleMethod(this, 10, null, -4096);
        final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, 0);
        Object operands;
        Object seeds;
        frame staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 9)
            {
                return lambda14();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object applyN(ModuleMethod modulemethod, Object aobj[])
        {
            if (modulemethod.selector == 10)
            {
                return lambda15$V(aobj);
            } else
            {
                return super.applyN(modulemethod, aobj);
            }
        }

        Object lambda14()
        {
            return Scheme.apply.apply3(staticLink.Mnproc, lists.car.apply1(operands), seeds);
        }

        Object lambda15$V(Object aobj[])
        {
            aobj = LList.makeList(aobj, 0);
            return staticLink.lambda4scanOperands(lists.cdr.apply1(operands), ((Object) (aobj)));
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 9)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
        {
            if (modulemethod.selector == 10)
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

        public frame2()
        {
        }
    }

    public class frame3 extends ModuleBody
    {

        Object arg;
        Object args;
        final ModuleMethod lambda$Fn11 = new ModuleMethod(this, 17, null, 0);
        final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 18, null, 4097);
        final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 19, null, 0);
        final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 20, null, -4096);
        final ModuleMethod lambda$Fn21 = new ModuleMethod(this, 21, null, 0);
        final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 22, null, -4096);
        final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 23, null, 0);
        final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 24, null, -4096);
        CharSequence name;
        Object option;
        Object seeds;
        frame staticLink;
        Object temp;

        public Object apply0(ModuleMethod modulemethod)
        {
            switch (modulemethod.selector)
            {
            case 18: // '\022'
            case 20: // '\024'
            case 22: // '\026'
            default:
                return super.apply0(modulemethod);

            case 17: // '\021'
                return lambda16();

            case 19: // '\023'
                return lambda24();

            case 21: // '\025'
                return lambda26();

            case 23: // '\027'
                return lambda28();
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 18)
            {
                return lambda17(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        public Object applyN(ModuleMethod modulemethod, Object aobj[])
        {
            switch (modulemethod.selector)
            {
            case 21: // '\025'
            case 23: // '\027'
            default:
                return super.applyN(modulemethod, aobj);

            case 20: // '\024'
                return lambda25$V(aobj);

            case 22: // '\026'
                return lambda27$V(aobj);

            case 24: // '\030'
                return lambda29$V(aobj);
            }
        }

        CharSequence lambda16()
        {
            Object obj = arg;
            CharSequence charsequence;
            int i;
            try
            {
                charsequence = (CharSequence)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "substring", 1, obj);
            }
            obj = temp;
            try
            {
                i = ((Number)obj).intValue();
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "substring", 3, obj);
            }
            return strings.substring(charsequence, 2, i);
        }

        Object lambda17(Object obj)
        {
            frame4 frame4_1 = new frame4();
            frame4_1.staticLink = this;
            frame4_1.x = obj;
            return call_with_values.callWithValues(frame4_1.Fn13, frame4_1.Fn14);
        }

        Object lambda24()
        {
            gnu.kawa.functions.Apply apply = Scheme.apply;
            Object obj = option;
            option.Mntype mntype;
            try
            {
                mntype = (option.Mntype)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "option-processor", 0, obj);
            }
            return apply.applyN(new Object[] {
                srfi37.optionProcessor(mntype), option, name, lists.car.apply1(args), seeds
            });
        }

        Object lambda25$V(Object aobj[])
        {
            aobj = LList.makeList(aobj, 0);
            return staticLink.lambda5scanArgs(lists.cdr.apply1(args), ((Object) (aobj)));
        }

        Object lambda26()
        {
            gnu.kawa.functions.Apply apply = Scheme.apply;
            Object obj = option;
            option.Mntype mntype;
            try
            {
                mntype = (option.Mntype)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "option-processor", 0, obj);
            }
            return apply.applyN(new Object[] {
                srfi37.optionProcessor(mntype), option, name, Boolean.FALSE, seeds
            });
        }

        Object lambda27$V(Object aobj[])
        {
            aobj = LList.makeList(aobj, 0);
            return staticLink.lambda5scanArgs(args, ((Object) (aobj)));
        }

        Object lambda28()
        {
            return Scheme.apply.apply3(staticLink.Mnproc, arg, seeds);
        }

        Object lambda29$V(Object aobj[])
        {
            aobj = LList.makeList(aobj, 0);
            return staticLink.lambda5scanArgs(args, ((Object) (aobj)));
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 18: // '\022'
            case 20: // '\024'
            case 22: // '\026'
            default:
                return super.match0(modulemethod, callcontext);

            case 23: // '\027'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 21: // '\025'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 19: // '\023'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 17: // '\021'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 18)
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

        public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 21: // '\025'
            case 23: // '\027'
            default:
                return super.matchN(modulemethod, aobj, callcontext);

            case 24: // '\030'
                callcontext.values = aobj;
                callcontext.proc = modulemethod;
                callcontext.pc = 5;
                return 0;

            case 22: // '\026'
                callcontext.values = aobj;
                callcontext.proc = modulemethod;
                callcontext.pc = 5;
                return 0;

            case 20: // '\024'
                callcontext.values = aobj;
                callcontext.proc = modulemethod;
                callcontext.pc = 5;
                return 0;
            }
        }

        public frame3()
        {
        }
    }

    public class frame4 extends ModuleBody
    {

        final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 15, null, 0);
        final ModuleMethod lambda$Fn14 = new ModuleMethod(this, 16, null, 4097);
        frame3 staticLink;
        Object x;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 15)
            {
                return lambda18();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 16)
            {
                return lambda19(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        CharSequence lambda18()
        {
            Object obj = staticLink.arg;
            CharSequence charsequence;
            CharSequence charsequence1;
            int i;
            try
            {
                charsequence = (CharSequence)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "substring", 1, obj);
            }
            obj = AddOp.$Pl.apply2(staticLink.temp, srfi37.Lit0);
            try
            {
                i = ((Number)obj).intValue();
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "substring", 2, obj);
            }
            obj = staticLink.arg;
            try
            {
                charsequence1 = (CharSequence)obj;
            }
            catch (ClassCastException classcastexception2)
            {
                throw new WrongType(classcastexception2, "string-length", 1, obj);
            }
            return strings.substring(charsequence, i, strings.stringLength(charsequence1));
        }

        Object lambda19(Object obj)
        {
            frame5 frame5_1 = new frame5();
            frame5_1.staticLink = this;
            frame5_1.x = obj;
            return call_with_values.callWithValues(frame5_1.Fn15, frame5_1.Fn16);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 15)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 16)
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

        public frame4()
        {
        }
    }

    public class frame5 extends ModuleBody
    {

        final ModuleMethod lambda$Fn15 = new ModuleMethod(this, 13, null, 0);
        final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 14, null, 4097);
        frame4 staticLink;
        Object x;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 13)
            {
                return lambda20();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 14)
            {
                return lambda21(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda20()
        {
            Object obj = staticLink.staticLink.staticLink.lambda2findOption(staticLink.x);
            if (obj != Boolean.FALSE)
            {
                return obj;
            } else
            {
                return srfi37.option(LList.list1(staticLink.x), Boolean.TRUE, Boolean.FALSE, staticLink.staticLink.staticLink.Mnproc);
            }
        }

        Object lambda21(Object obj)
        {
            frame6 frame6_1 = new frame6();
            frame6_1.staticLink = this;
            frame6_1.x = obj;
            return call_with_values.callWithValues(frame6_1.Fn17, frame6_1.Fn18);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 13)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 14)
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

        public frame5()
        {
        }
    }

    public class frame6 extends ModuleBody
    {

        final ModuleMethod lambda$Fn17 = new ModuleMethod(this, 11, null, 0);
        final ModuleMethod lambda$Fn18 = new ModuleMethod(this, 12, null, -4096);
        frame5 staticLink;
        Object x;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 11)
            {
                return lambda22();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object applyN(ModuleMethod modulemethod, Object aobj[])
        {
            if (modulemethod.selector == 12)
            {
                return lambda23$V(aobj);
            } else
            {
                return super.applyN(modulemethod, aobj);
            }
        }

        Object lambda22()
        {
            gnu.kawa.functions.Apply apply = Scheme.apply;
            Object obj = x;
            option.Mntype mntype;
            try
            {
                mntype = (option.Mntype)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "option-processor", 0, obj);
            }
            return apply.applyN(new Object[] {
                srfi37.optionProcessor(mntype), x, staticLink.staticLink.x, staticLink.x, staticLink.staticLink.staticLink.seeds
            });
        }

        Object lambda23$V(Object aobj[])
        {
            aobj = LList.makeList(aobj, 0);
            return staticLink.staticLink.staticLink.staticLink.lambda5scanArgs(staticLink.staticLink.staticLink.args, ((Object) (aobj)));
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 11)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
        {
            if (modulemethod.selector == 12)
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

        public frame6()
        {
        }
    }


    public static final srfi37 $instance;
    static final IntNum Lit0 = IntNum.make(1);
    static final Char Lit1 = Char.make(45);
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final Char Lit2 = Char.make(61);
    static final IntNum Lit3 = IntNum.make(3);
    static final IntNum Lit4 = IntNum.make(0);
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod args$Mnfold;
    public static final ModuleMethod option;
    public static final ModuleMethod option$Mnnames;
    public static final ModuleMethod option$Mnoptional$Mnarg$Qu;
    public static final ModuleMethod option$Mnprocessor;
    public static final ModuleMethod option$Mnrequired$Mnarg$Qu;
    static final Class option$Mntype = gnu/kawa/slib/option$Mntype;
    public static final ModuleMethod option$Qu;

    public srfi37()
    {
        ModuleInfo.register(this);
    }

    public static Object argsFold$V(Object obj, Object obj1, Object obj2, Object obj3, Object aobj[])
    {
        frame frame7 = new frame();
        frame7.options = obj1;
        frame7.Mnproc = obj2;
        frame7.Mnproc = obj3;
        return frame7.lambda5scanArgs(obj, LList.makeList(aobj, 0));
    }

    public static boolean isOption(Object obj)
    {
        return obj instanceof option.Mntype;
    }

    public static Object isOptionOptionalArg(option.Mntype mntype)
    {
        return mntype.optional$Mnarg$Qu;
    }

    public static Object isOptionRequiredArg(option.Mntype mntype)
    {
        return mntype.required$Mnarg$Qu;
    }

    public static option.Mntype option(Object obj, Object obj1, Object obj2, Object obj3)
    {
        option.Mntype mntype = new option.Mntype();
        mntype.names = obj;
        mntype.required$Mnarg$Qu = obj1;
        mntype.optional$Mnarg$Qu = obj2;
        mntype.processor = obj3;
        return mntype;
    }

    public static Object optionNames(option.Mntype mntype)
    {
        return mntype.names;
    }

    public static Object optionProcessor(option.Mntype mntype)
    {
        return mntype.processor;
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 26: // '\032'
        default:
            return super.apply1(modulemethod, obj);

        case 25: // '\031'
            if (isOption(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 27: // '\033'
            try
            {
                modulemethod = (option.Mntype)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "option-names", 1, obj);
            }
            return optionNames(modulemethod);

        case 28: // '\034'
            try
            {
                modulemethod = (option.Mntype)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "option-required-arg?", 1, obj);
            }
            return isOptionRequiredArg(modulemethod);

        case 29: // '\035'
            try
            {
                modulemethod = (option.Mntype)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "option-optional-arg?", 1, obj);
            }
            return isOptionOptionalArg(modulemethod);

        case 30: // '\036'
            break;
        }
        try
        {
            modulemethod = (option.Mntype)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "option-processor", 1, obj);
        }
        return optionProcessor(modulemethod);
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        if (modulemethod.selector == 26)
        {
            return option(obj, obj1, obj2, obj3);
        } else
        {
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        if (modulemethod.selector == 31)
        {
            modulemethod = ((ModuleMethod) (aobj[0]));
            Object obj = aobj[1];
            Object obj1 = aobj[2];
            Object obj2 = aobj[3];
            int i = aobj.length - 4;
            Object aobj1[] = new Object[i];
            do
            {
                i--;
                if (i < 0)
                {
                    return argsFold$V(modulemethod, obj, obj1, obj2, aobj1);
                }
                aobj1[i] = aobj[i + 4];
            } while (true);
        } else
        {
            return super.applyN(modulemethod, aobj);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 25 30: default 48
    //                   25 156
    //                   26 48
    //                   27 132
    //                   28 108
    //                   29 84
    //                   30 60;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L6
_L1:
        i = super.match1(modulemethod, obj, callcontext);
_L8:
        return i;
_L6:
        if (!(obj instanceof option.Mntype)) goto _L8; else goto _L7
_L7:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L5:
        if (!(obj instanceof option.Mntype)) goto _L8; else goto _L9
_L9:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L4:
        if (!(obj instanceof option.Mntype)) goto _L8; else goto _L10
_L10:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L3:
        if (!(obj instanceof option.Mntype)) goto _L8; else goto _L11
_L11:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L2:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        if (modulemethod.selector == 26)
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

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        if (modulemethod.selector == 31)
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

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit11 = (SimpleSymbol)(new SimpleSymbol("args-fold")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("option-processor")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("option-optional-arg?")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("option-required-arg?")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("option-names")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("option")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("option?")).readResolve();
        $instance = new srfi37();
        srfi37 srfi37_1 = $instance;
        option$Qu = new ModuleMethod(srfi37_1, 25, Lit5, 4097);
        option = new ModuleMethod(srfi37_1, 26, Lit6, 16388);
        option$Mnnames = new ModuleMethod(srfi37_1, 27, Lit7, 4097);
        option$Mnrequired$Mnarg$Qu = new ModuleMethod(srfi37_1, 28, Lit8, 4097);
        option$Mnoptional$Mnarg$Qu = new ModuleMethod(srfi37_1, 29, Lit9, 4097);
        option$Mnprocessor = new ModuleMethod(srfi37_1, 30, Lit10, 4097);
        args$Mnfold = new ModuleMethod(srfi37_1, 31, Lit11, -4092);
        $instance.run();
    }
}
