// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.append;

public class pregexp extends ModuleBody
{
    public class frame extends ModuleBody
    {

        Object backrefs;
        Object case$Mnsensitive$Qu;
        Procedure identity;
        Object n;
        Object s;
        Object sn;
        Object start;

        public static Object lambda2identity(Object obj)
        {
            return obj;
        }

        static Boolean lambda4()
        {
            return Boolean.FALSE;
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 15)
            {
                return lambda2identity(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        public Object lambda3sub(Object obj, Object obj1, Object obj2, Object obj3)
        {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 15)
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

        public frame()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 15, pregexp.Lit112, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:460");
            identity = modulemethod;
        }
    }

    public class frame0 extends ModuleBody
    {

        boolean could$Mnloop$Mninfinitely$Qu;
        Object fk;
        Object i;
        final ModuleMethod lambda$Fn11;
        final ModuleMethod lambda$Fn12;
        final ModuleMethod lambda$Fn2;
        final ModuleMethod lambda$Fn3;
        final ModuleMethod lambda$Fn4;
        final ModuleMethod lambda$Fn5;
        boolean maximal$Qu;
        Object old;
        Object p;
        Object q;
        Object re;
        Object re$1;
        Object sk;
        frame staticLink;

        static Boolean lambda13()
        {
            return Boolean.FALSE;
        }

        static Boolean lambda14()
        {
            return Boolean.FALSE;
        }

        static Boolean lambda15()
        {
            return Boolean.FALSE;
        }

        static Boolean lambda16()
        {
            return Boolean.FALSE;
        }

        static Boolean lambda17()
        {
            return Boolean.FALSE;
        }

        public Object apply0(ModuleMethod modulemethod)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply0(modulemethod);

            case 10: // '\n'
                return lambda10();

            case 14: // '\016'
                return lambda19();
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            switch (modulemethod.selector)
            {
            case 10: // '\n'
            default:
                return super.apply1(modulemethod, obj);

            case 9: // '\t'
                return lambda9(obj);

            case 11: // '\013'
                return lambda11(obj);

            case 12: // '\f'
                return lambda12(obj);

            case 13: // '\r'
                return lambda18(obj);
            }
        }

        Object lambda10()
        {
            return Scheme.applyToArgs.apply2(sk, AddOp.$Pl.apply2(i, pregexp.Lit8));
        }

        Object lambda11(Object obj)
        {
            return Scheme.applyToArgs.apply2(sk, obj);
        }

        Object lambda12(Object obj)
        {
            Object obj1 = lists.assv(re$1, staticLink.backrefs);
            Pair pair;
            try
            {
                pair = (Pair)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, obj1);
            }
            lists.setCdr$Ex(pair, lists.cons(i, obj));
            return Scheme.applyToArgs.apply2(sk, obj);
        }

        Object lambda18(Object obj)
        {
            staticLink.Qu = old;
            return Scheme.applyToArgs.apply2(sk, obj);
        }

        Object lambda19()
        {
            staticLink.Qu = old;
            return Scheme.applyToArgs.apply1(fk);
        }

        public Object lambda5loupOneOfChars(Object obj)
        {
            frame1 frame1_1 = new frame1();
            frame1_1.staticLink = this;
            frame1_1.chars = obj;
            if (lists.isNull(frame1_1.chars))
            {
                return Scheme.applyToArgs.apply1(fk);
            } else
            {
                return staticLink.lambda3sub(lists.car.apply1(frame1_1.chars), i, sk, frame1_1.Fn13);
            }
        }

        public Object lambda6loupSeq(Object obj, Object obj1)
        {
            frame2 frame2_1 = new frame2();
            frame2_1.staticLink = this;
            frame2_1.res = obj;
            if (lists.isNull(frame2_1.res))
            {
                return Scheme.applyToArgs.apply2(sk, obj1);
            } else
            {
                return staticLink.lambda3sub(lists.car.apply1(frame2_1.res), obj1, frame2_1.Fn14, fk);
            }
        }

        public Object lambda7loupOr(Object obj)
        {
            frame3 frame3_1 = new frame3();
            frame3_1.staticLink = this;
            frame3_1.res = obj;
            if (lists.isNull(frame3_1.res))
            {
                return Scheme.applyToArgs.apply1(fk);
            } else
            {
                return staticLink.lambda3sub(lists.car.apply1(frame3_1.res), i, frame3_1.Fn15, frame3_1.Fn16);
            }
        }

        public Object lambda8loupP(Object obj, Object obj1)
        {
            frame4 frame4_1 = new frame4();
            frame4_1.staticLink = this;
            frame4_1.k = obj;
            frame4_1.i = obj1;
            if (Scheme.numLss.apply2(frame4_1.k, p) != Boolean.FALSE)
            {
                return staticLink.lambda3sub(re, frame4_1.i, frame4_1.Fn17, fk);
            }
            if (q != Boolean.FALSE)
            {
                obj = AddOp.$Mn.apply2(q, p);
            } else
            {
                obj = q;
            }
            frame4_1.q = obj;
            return frame4_1.lambda24loupQ(pregexp.Lit73, frame4_1.i);
        }

        Object lambda9(Object obj)
        {
            return Scheme.applyToArgs.apply1(fk);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match0(modulemethod, callcontext);

            case 14: // '\016'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 10: // '\n'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 10: // '\n'
            default:
                return super.match1(modulemethod, obj, callcontext);

            case 13: // '\r'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;

            case 12: // '\f'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;

            case 11: // '\013'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;

            case 9: // '\t'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }
        }

        public frame0()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 9, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:513");
            lambda$Fn2 = modulemethod;
            modulemethod = new ModuleMethod(this, 10, null, 0);
            modulemethod.setProperty("source-location", "pregexp.scm:514");
            lambda$Fn3 = modulemethod;
            modulemethod = new ModuleMethod(this, 11, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:541");
            lambda$Fn4 = modulemethod;
            modulemethod = new ModuleMethod(this, 12, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:545");
            lambda$Fn5 = modulemethod;
            modulemethod = new ModuleMethod(this, 13, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:587");
            lambda$Fn11 = modulemethod;
            modulemethod = new ModuleMethod(this, 14, null, 0);
            modulemethod.setProperty("source-location", "pregexp.scm:590");
            lambda$Fn12 = modulemethod;
        }
    }

    public class frame1 extends ModuleBody
    {

        Object chars;
        final ModuleMethod lambda$Fn13;
        frame0 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 1)
            {
                return lambda20();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        Object lambda20()
        {
            return staticLink.lambda5loupOneOfChars(lists.cdr.apply1(chars));
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 1)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public frame1()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 0);
            modulemethod.setProperty("source-location", "pregexp.scm:508");
            lambda$Fn13 = modulemethod;
        }
    }

    public class frame2 extends ModuleBody
    {

        final ModuleMethod lambda$Fn14;
        Object res;
        frame0 staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 2)
            {
                return lambda21(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda21(Object obj)
        {
            return staticLink.lambda6loupSeq(lists.cdr.apply1(res), obj);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 2)
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

        public frame2()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 2, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:519");
            lambda$Fn14 = modulemethod;
        }
    }

    public class frame3 extends ModuleBody
    {

        final ModuleMethod lambda$Fn15;
        final ModuleMethod lambda$Fn16;
        Object res;
        frame0 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 4)
            {
                return lambda23();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 3)
            {
                return lambda22(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda22(Object obj)
        {
            obj = Scheme.applyToArgs.apply2(staticLink.sk, obj);
            if (obj != Boolean.FALSE)
            {
                return obj;
            } else
            {
                return staticLink.lambda7loupOr(lists.cdr.apply1(res));
            }
        }

        Object lambda23()
        {
            return staticLink.lambda7loupOr(lists.cdr.apply1(res));
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 4)
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
            if (modulemethod.selector == 3)
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

        public frame3()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 3, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:526");
            lambda$Fn15 = modulemethod;
            modulemethod = new ModuleMethod(this, 4, null, 0);
            modulemethod.setProperty("source-location", "pregexp.scm:529");
            lambda$Fn16 = modulemethod;
        }
    }

    public class frame4 extends ModuleBody
    {

        Object i;
        Object k;
        final ModuleMethod lambda$Fn17;
        Object q;
        frame0 staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 8)
            {
                return lambda25(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        public Object lambda24loupQ(Object obj, Object obj1)
        {
            frame5 frame5_1 = new frame5();
            frame5_1.staticLink = this;
            frame5_1.k = obj;
            frame5_1.i = obj1;
            frame5_1.fk = frame5_1.fk;
            if (q == Boolean.FALSE ? q != Boolean.FALSE : Scheme.numGEq.apply2(frame5_1.k, q) != Boolean.FALSE)
            {
                obj = frame5_1.lambda26fk();
            } else
            {
                if (staticLink.Qu)
                {
                    return staticLink.staticLink.lambda3sub(staticLink.re, frame5_1.i, frame5_1.Fn18, frame5_1.fk);
                }
                obj1 = frame5_1.lambda26fk();
                obj = obj1;
                if (obj1 == Boolean.FALSE)
                {
                    return staticLink.staticLink.lambda3sub(staticLink.re, frame5_1.i, frame5_1.Fn19, frame5_1.fk);
                }
            }
            return obj;
        }

        Object lambda25(Object obj)
        {
            if (staticLink.Qu ? Scheme.numEqu.apply2(obj, i) != Boolean.FALSE : staticLink.Qu)
            {
                pregexp.pregexpError$V(new Object[] {
                    pregexp.Lit101, pregexp.Lit110
                });
            }
            return staticLink.lambda8loupP(AddOp.$Pl.apply2(k, pregexp.Lit8), obj);
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

        public frame4()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 8, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:602");
            lambda$Fn17 = modulemethod;
        }
    }

    public class frame5 extends ModuleBody
    {

        Procedure fk;
        Object i;
        Object k;
        final ModuleMethod lambda$Fn18;
        final ModuleMethod lambda$Fn19;
        frame4 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 5)
            {
                return lambda26fk();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply1(modulemethod, obj);

            case 6: // '\006'
                return lambda27(obj);

            case 7: // '\007'
                return lambda28(obj);
            }
        }

        public Object lambda26fk()
        {
            return Scheme.applyToArgs.apply2(staticLink.staticLink.sk, i);
        }

        Object lambda27(Object obj)
        {
            if (staticLink.staticLink.Qu ? Scheme.numEqu.apply2(obj, i) != Boolean.FALSE : staticLink.staticLink.Qu)
            {
                pregexp.pregexpError$V(new Object[] {
                    pregexp.Lit101, pregexp.Lit110
                });
            }
            obj = staticLink.lambda24loupQ(AddOp.$Pl.apply2(k, pregexp.Lit8), obj);
            if (obj != Boolean.FALSE)
            {
                return obj;
            } else
            {
                return lambda26fk();
            }
        }

        Object lambda28(Object obj)
        {
            return staticLink.lambda24loupQ(AddOp.$Pl.apply2(k, pregexp.Lit8), obj);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 5)
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
            switch (modulemethod.selector)
            {
            default:
                return super.match1(modulemethod, obj, callcontext);

            case 7: // '\007'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;

            case 6: // '\006'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }
        }

        public frame5()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 5, pregexp.Lit111, 0);
            modulemethod.setProperty("source-location", "pregexp.scm:612");
            fk = modulemethod;
            modulemethod = new ModuleMethod(this, 6, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:617");
            lambda$Fn18 = modulemethod;
            modulemethod = new ModuleMethod(this, 7, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:628");
            lambda$Fn19 = modulemethod;
        }
    }


    public static Char $Stpregexp$Mncomment$Mnchar$St;
    public static Object $Stpregexp$Mnnul$Mnchar$Mnint$St;
    public static Object $Stpregexp$Mnreturn$Mnchar$St;
    public static Object $Stpregexp$Mnspace$Mnsensitive$Qu$St;
    public static Object $Stpregexp$Mntab$Mnchar$St;
    public static IntNum $Stpregexp$Mnversion$St;
    public static final pregexp $instance;
    static final IntNum Lit0 = IntNum.make(0x131f246);
    static final Char Lit1 = Char.make(59);
    static final SimpleSymbol Lit10 = (SimpleSymbol)(new SimpleSymbol(":bos")).readResolve();
    static final SimpleSymbol Lit100;
    static final SimpleSymbol Lit101;
    static final SimpleSymbol Lit102 = (SimpleSymbol)(new SimpleSymbol("non-existent-backref")).readResolve();
    static final SimpleSymbol Lit103;
    static final SimpleSymbol Lit104;
    static final SimpleSymbol Lit105;
    static final PairWithPosition Lit106;
    static final SimpleSymbol Lit107;
    static final PairWithPosition Lit108;
    static final SimpleSymbol Lit109;
    static final Char Lit11;
    static final SimpleSymbol Lit110 = (SimpleSymbol)(new SimpleSymbol("greedy-quantifier-operand-could-be-empty")).readResolve();
    static final SimpleSymbol Lit111 = (SimpleSymbol)(new SimpleSymbol("fk")).readResolve();
    static final SimpleSymbol Lit112 = (SimpleSymbol)(new SimpleSymbol("identity")).readResolve();
    static final Char Lit113 = Char.make(38);
    static final SimpleSymbol Lit114;
    static final SimpleSymbol Lit115 = (SimpleSymbol)(new SimpleSymbol("pattern-must-be-compiled-or-string-regexp")).readResolve();
    static final PairWithPosition Lit116;
    static final SimpleSymbol Lit117;
    static final SimpleSymbol Lit118;
    static final SimpleSymbol Lit119;
    static final SimpleSymbol Lit12 = (SimpleSymbol)(new SimpleSymbol(":eos")).readResolve();
    static final SimpleSymbol Lit120;
    static final SimpleSymbol Lit121;
    static final SimpleSymbol Lit122;
    static final SimpleSymbol Lit123;
    static final SimpleSymbol Lit124;
    static final SimpleSymbol Lit125;
    static final SimpleSymbol Lit126;
    static final SimpleSymbol Lit127;
    static final SimpleSymbol Lit128;
    static final SimpleSymbol Lit129;
    static final Char Lit13;
    static final SimpleSymbol Lit130;
    static final SimpleSymbol Lit131;
    static final SimpleSymbol Lit132;
    static final SimpleSymbol Lit133;
    static final SimpleSymbol Lit134;
    static final SimpleSymbol Lit135;
    static final SimpleSymbol Lit14;
    static final Char Lit15;
    static final IntNum Lit16 = IntNum.make(2);
    static final SimpleSymbol Lit17;
    static final Char Lit18;
    static final Char Lit19;
    static final Char Lit2 = Char.make(97);
    static final SimpleSymbol Lit20 = (SimpleSymbol)(new SimpleSymbol(":backref")).readResolve();
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22 = (SimpleSymbol)(new SimpleSymbol("backslash")).readResolve();
    static final SimpleSymbol Lit23 = (SimpleSymbol)(new SimpleSymbol(":empty")).readResolve();
    static final Char Lit24 = Char.make(10);
    static final Char Lit25 = Char.make(98);
    static final SimpleSymbol Lit26 = (SimpleSymbol)(new SimpleSymbol(":wbdry")).readResolve();
    static final Char Lit27 = Char.make(66);
    static final SimpleSymbol Lit28 = (SimpleSymbol)(new SimpleSymbol(":not-wbdry")).readResolve();
    static final Char Lit29 = Char.make(100);
    static final Char Lit3 = Char.make(32);
    static final SimpleSymbol Lit30;
    static final Char Lit31 = Char.make(68);
    static final PairWithPosition Lit32;
    static final Char Lit33 = Char.make(110);
    static final Char Lit34 = Char.make(114);
    static final Char Lit35 = Char.make(115);
    static final SimpleSymbol Lit36;
    static final Char Lit37 = Char.make(83);
    static final PairWithPosition Lit38;
    static final Char Lit39 = Char.make(116);
    static final SimpleSymbol Lit4 = (SimpleSymbol)(new SimpleSymbol(":or")).readResolve();
    static final Char Lit40 = Char.make(119);
    static final SimpleSymbol Lit41;
    static final Char Lit42 = Char.make(87);
    static final PairWithPosition Lit43;
    static final Char Lit44 = Char.make(58);
    static final SimpleSymbol Lit45;
    static final Char Lit46;
    static final Char Lit47;
    static final Char Lit48 = Char.make(61);
    static final PairWithPosition Lit49;
    static final SimpleSymbol Lit5 = (SimpleSymbol)(new SimpleSymbol(":seq")).readResolve();
    static final Char Lit50 = Char.make(33);
    static final PairWithPosition Lit51;
    static final Char Lit52 = Char.make(62);
    static final PairWithPosition Lit53;
    static final Char Lit54 = Char.make(60);
    static final PairWithPosition Lit55;
    static final PairWithPosition Lit56;
    static final SimpleSymbol Lit57;
    static final Char Lit58 = Char.make(45);
    static final Char Lit59 = Char.make(105);
    static final Char Lit6;
    static final SimpleSymbol Lit60 = (SimpleSymbol)(new SimpleSymbol(":case-sensitive")).readResolve();
    static final SimpleSymbol Lit61 = (SimpleSymbol)(new SimpleSymbol(":case-insensitive")).readResolve();
    static final Char Lit62 = Char.make(120);
    static final PairWithPosition Lit63;
    static final SimpleSymbol Lit64;
    static final Char Lit65;
    static final Char Lit66;
    static final Char Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69 = (SimpleSymbol)(new SimpleSymbol("minimal?")).readResolve();
    static final Char Lit7;
    static final SimpleSymbol Lit70 = (SimpleSymbol)(new SimpleSymbol("at-least")).readResolve();
    static final SimpleSymbol Lit71 = (SimpleSymbol)(new SimpleSymbol("at-most")).readResolve();
    static final SimpleSymbol Lit72 = (SimpleSymbol)(new SimpleSymbol("next-i")).readResolve();
    static final IntNum Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75 = (SimpleSymbol)(new SimpleSymbol("left-brace-must-be-followed-by-number")).readResolve();
    static final SimpleSymbol Lit76;
    static final Char Lit77 = Char.make(44);
    static final Char Lit78;
    static final SimpleSymbol Lit79 = (SimpleSymbol)(new SimpleSymbol(":none-of-chars")).readResolve();
    static final IntNum Lit8 = IntNum.make(1);
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81 = (SimpleSymbol)(new SimpleSymbol("character-class-ended-too-soon")).readResolve();
    static final SimpleSymbol Lit82 = (SimpleSymbol)(new SimpleSymbol(":one-of-chars")).readResolve();
    static final SimpleSymbol Lit83 = (SimpleSymbol)(new SimpleSymbol(":char-range")).readResolve();
    static final Char Lit84 = Char.make(95);
    static final SimpleSymbol Lit85 = (SimpleSymbol)(new SimpleSymbol(":alnum")).readResolve();
    static final SimpleSymbol Lit86 = (SimpleSymbol)(new SimpleSymbol(":alpha")).readResolve();
    static final SimpleSymbol Lit87 = (SimpleSymbol)(new SimpleSymbol(":ascii")).readResolve();
    static final SimpleSymbol Lit88 = (SimpleSymbol)(new SimpleSymbol(":blank")).readResolve();
    static final SimpleSymbol Lit89 = (SimpleSymbol)(new SimpleSymbol(":cntrl")).readResolve();
    static final Char Lit9;
    static final SimpleSymbol Lit90 = (SimpleSymbol)(new SimpleSymbol(":graph")).readResolve();
    static final SimpleSymbol Lit91 = (SimpleSymbol)(new SimpleSymbol(":lower")).readResolve();
    static final SimpleSymbol Lit92 = (SimpleSymbol)(new SimpleSymbol(":print")).readResolve();
    static final SimpleSymbol Lit93 = (SimpleSymbol)(new SimpleSymbol(":punct")).readResolve();
    static final SimpleSymbol Lit94 = (SimpleSymbol)(new SimpleSymbol(":upper")).readResolve();
    static final SimpleSymbol Lit95 = (SimpleSymbol)(new SimpleSymbol(":xdigit")).readResolve();
    static final Char Lit96 = Char.make(99);
    static final Char Lit97 = Char.make(101);
    static final Char Lit98 = Char.make(102);
    static final SimpleSymbol Lit99;
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn10;
    static final ModuleMethod lambda$Fn6;
    static final ModuleMethod lambda$Fn7;
    static final ModuleMethod lambda$Fn8;
    static final ModuleMethod lambda$Fn9;
    public static final ModuleMethod pregexp;
    public static final ModuleMethod pregexp$Mnat$Mnword$Mnboundary$Qu;
    public static final ModuleMethod pregexp$Mnchar$Mnword$Qu;
    public static final ModuleMethod pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu;
    public static final ModuleMethod pregexp$Mnerror;
    public static final ModuleMethod pregexp$Mninvert$Mnchar$Mnlist;
    public static final ModuleMethod pregexp$Mnlist$Mnref;
    public static final ModuleMethod pregexp$Mnmake$Mnbackref$Mnlist;
    public static final ModuleMethod pregexp$Mnmatch;
    public static final ModuleMethod pregexp$Mnmatch$Mnpositions;
    public static final ModuleMethod pregexp$Mnmatch$Mnpositions$Mnaux;
    public static final ModuleMethod pregexp$Mnquote;
    public static final ModuleMethod pregexp$Mnread$Mnbranch;
    public static final ModuleMethod pregexp$Mnread$Mnchar$Mnlist;
    public static final ModuleMethod pregexp$Mnread$Mncluster$Mntype;
    public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnchar;
    public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnnumber;
    public static final ModuleMethod pregexp$Mnread$Mnnums;
    public static final ModuleMethod pregexp$Mnread$Mnpattern;
    public static final ModuleMethod pregexp$Mnread$Mnpiece;
    public static final ModuleMethod pregexp$Mnread$Mnposix$Mnchar$Mnclass;
    public static final ModuleMethod pregexp$Mnread$Mnsubpattern;
    public static final ModuleMethod pregexp$Mnreplace;
    public static final ModuleMethod pregexp$Mnreplace$Mnaux;
    public static final ModuleMethod pregexp$Mnreplace$St;
    public static final ModuleMethod pregexp$Mnreverse$Ex;
    public static final ModuleMethod pregexp$Mnsplit;
    public static final ModuleMethod pregexp$Mnstring$Mnmatch;
    public static final ModuleMethod pregexp$Mnwrap$Mnquantifier$Mnif$Mnany;

    public pregexp()
    {
        ModuleInfo.register(this);
    }

    public static Object isPregexpAtWordBoundary(Object obj, Object obj1, Object obj2)
    {
        Object obj3 = Scheme.numEqu.apply2(obj1, Lit73);
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
        obj2 = Scheme.numGEq.apply2(obj1, obj2);
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
        try
        {
            obj2 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
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
        i = strings.stringRef(((CharSequence) (obj2)), i);
        try
        {
            obj2 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
        }
        obj = AddOp.$Mn.apply2(obj1, Lit8);
        try
        {
            j = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
        }
        j = strings.stringRef(((CharSequence) (obj2)), j);
        obj1 = isPregexpCheckIfInCharClass(Char.make(i), Lit41);
        obj2 = isPregexpCheckIfInCharClass(Char.make(j), Lit41);
        if (obj1 != Boolean.FALSE)
        {
            if (obj2 != Boolean.FALSE)
            {
                obj = Boolean.FALSE;
            } else
            {
                obj = Boolean.TRUE;
            }
        } else
        {
            obj = obj1;
        }
        if (obj != Boolean.FALSE)
        {
            return obj;
        }
        try
        {
            obj = Boolean.FALSE;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj1);
        }
        if (obj1 != obj)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        i = i + 1 & 1;
        if (i != 0)
        {
            return obj2;
        }
        if (i != 0)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static boolean isPregexpCharWord(Object obj)
    {
        Char char1;
        boolean flag;
        try
        {
            char1 = (Char)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "char-alphabetic?", 1, obj);
        }
        flag = unicode.isCharAlphabetic(char1);
        if (!flag)
        {
            Char char2;
            boolean flag1;
            try
            {
                char2 = (Char)obj;
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "char-numeric?", 1, obj);
            }
            flag1 = unicode.isCharNumeric(char2);
            flag = flag1;
            if (!flag1)
            {
                Char char3;
                try
                {
                    char3 = (Char)obj;
                }
                catch (ClassCastException classcastexception2)
                {
                    throw new WrongType(classcastexception2, "char=?", 1, obj);
                }
                return characters.isChar$Eq(char3, Lit84);
            }
        }
        return flag;
    }

    public static Object isPregexpCheckIfInCharClass(Object obj, Object obj1)
    {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public static Object lambda1sub(Object obj)
    {
        if (lists.isPair(obj))
        {
            Object obj1 = lists.car.apply1(obj);
            Object obj2 = lambda1sub(lists.cdr.apply1(obj));
            if (Scheme.isEqv.apply2(obj1, Lit100) != Boolean.FALSE)
            {
                return lists.cons(lists.cons(obj, Boolean.FALSE), obj2);
            } else
            {
                return append.append$V(new Object[] {
                    lambda1sub(obj1), obj2
                });
            }
        } else
        {
            return LList.Empty;
        }
    }

    public static Pair pregexp(Object obj)
    {
        $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
        SimpleSymbol simplesymbol = Lit100;
        gnu.expr.GenericProc genericproc = lists.car;
        IntNum intnum = Lit73;
        CharSequence charsequence;
        try
        {
            charsequence = (CharSequence)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "string-length", 1, obj);
        }
        return LList.list2(simplesymbol, genericproc.apply1(pregexpReadPattern(obj, intnum, Integer.valueOf(strings.stringLength(charsequence)))));
    }

    public static Object pregexpError$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        ports.display("Error:");
        do
        {
            if (aobj == LList.Empty)
            {
                ports.newline();
                return misc.error$V("pregexp-error", new Object[0]);
            }
            Pair pair;
            try
            {
                pair = (Pair)aobj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "arg0", -2, ((Object) (aobj)));
            }
            aobj = ((Object []) (pair.getCar()));
            ports.display(Lit3);
            ports.write(((Object) (aobj)));
            aobj = ((Object []) (pair.getCdr()));
        } while (true);
    }

    public static Object pregexpInvertCharList(Object obj)
    {
        Object obj1 = lists.car.apply1(obj);
        Pair pair;
        try
        {
            pair = (Pair)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj1);
        }
        lists.setCar$Ex(pair, Lit79);
        return obj;
    }

    public static Object pregexpListRef(Object obj, Object obj1)
    {
        IntNum intnum = Lit73;
        Object obj2 = obj;
        obj = intnum;
        do
        {
            if (lists.isNull(obj2))
            {
                return Boolean.FALSE;
            }
            if (Scheme.numEqu.apply2(obj, obj1) != Boolean.FALSE)
            {
                return lists.car.apply1(obj2);
            }
            obj2 = lists.cdr.apply1(obj2);
            obj = AddOp.$Pl.apply2(obj, Lit8);
        } while (true);
    }

    public static Object pregexpMakeBackrefList(Object obj)
    {
        return lambda1sub(obj);
    }

    public static Object pregexpMatch$V(Object obj, Object obj1, Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        obj = Scheme.apply.apply4(pregexp$Mnmatch$Mnpositions, obj, obj1, ((Object) (aobj)));
        aobj = ((Object []) (obj));
        if (obj == Boolean.FALSE) goto _L2; else goto _L1
_L1:
        LList llist = LList.Empty;
        aobj = ((Object []) (obj));
        obj = llist;
_L6:
        if (aobj != LList.Empty) goto _L4; else goto _L3
_L3:
        aobj = LList.reverseInPlace(obj);
_L2:
        return ((Object) (aobj));
_L4:
        Object obj2;
        Object obj3;
        try
        {
            obj3 = (Pair)aobj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "arg0", -2, ((Object) (aobj)));
        }
        obj2 = ((Pair) (obj3)).getCdr();
        obj3 = ((Pair) (obj3)).getCar();
        aobj = ((Object []) (obj3));
        if (obj3 != Boolean.FALSE)
        {
            Object obj4;
            int i;
            int j;
            try
            {
                aobj = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
            }
            obj4 = lists.car.apply1(obj3);
            try
            {
                i = ((Number)obj4).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 2, obj4);
            }
            obj3 = lists.cdr.apply1(obj3);
            try
            {
                j = ((Number)obj3).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj3);
            }
            aobj = strings.substring(((CharSequence) (aobj)), i, j);
        }
        obj = Pair.make(((Object) (aobj)), obj);
        aobj = ((Object []) (obj2));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Object pregexpMatchPositions$V(Object obj, Object obj1, Object aobj[])
    {
        Object obj2 = LList.makeList(aobj, 0);
        Object obj3;
        int i;
        if (strings.isString(obj))
        {
            aobj = pregexp(obj);
        } else
        {
            aobj = ((Object []) (obj));
            if (!lists.isPair(obj))
            {
                pregexpError$V(new Object[] {
                    Lit114, Lit115, obj
                });
                aobj = ((Object []) (obj));
            }
        }
        try
        {
            obj = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
        }
        i = strings.stringLength(((CharSequence) (obj)));
        if (lists.isNull(obj2))
        {
            obj = Lit73;
        } else
        {
            obj = lists.car.apply1(obj2);
            obj3 = lists.cdr.apply1(obj2);
            try
            {
                obj2 = (LList)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "opt-args", -2, obj3);
            }
        }
        if (lists.isNull(obj2))
        {
            obj2 = Integer.valueOf(i);
        } else
        {
            obj2 = lists.car.apply1(obj2);
        }
        obj3 = obj;
        do
        {
            Object obj4 = Scheme.numLEq.apply2(obj3, obj2);
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
            if (flag)
            {
                obj4 = pregexpMatchPositionsAux(((Object) (aobj)), obj1, Integer.valueOf(i), obj, obj2, obj3);
                if (obj4 != Boolean.FALSE)
                {
                    return obj4;
                }
                obj3 = AddOp.$Pl.apply2(obj3, Lit8);
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

    public static Object pregexpMatchPositionsAux(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
    {
        frame frame6 = new frame();
        frame6.s = obj1;
        frame6.sn = obj2;
        frame6.start = obj3;
        frame6.n = obj4;
        obj1 = frame6.identity;
        obj2 = pregexpMakeBackrefList(obj);
        frame6.Qu = Boolean.TRUE;
        frame6.backrefs = obj2;
        frame6.identity = ((Procedure) (obj1));
        frame6.lambda3sub(obj, obj5, frame6.identity, lambda$Fn1);
        obj = frame6.backrefs;
        obj1 = LList.Empty;
        do
        {
            if (obj == LList.Empty)
            {
                obj = LList.reverseInPlace(obj1);
                obj1 = lists.car.apply1(obj);
                if (obj1 != Boolean.FALSE)
                {
                    return obj;
                } else
                {
                    return obj1;
                }
            }
            try
            {
                obj2 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "arg0", -2, obj);
            }
            obj = ((Pair) (obj2)).getCdr();
            obj1 = Pair.make(lists.cdr.apply1(((Pair) (obj2)).getCar()), obj1);
        } while (true);
    }

    public static Object pregexpQuote(Object obj)
    {
        Object obj1;
        Object obj2;
        try
        {
            obj1 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
        }
        obj2 = Integer.valueOf(strings.stringLength(((CharSequence) (obj1))) - 1);
        obj1 = LList.Empty;
        do
        {
            if (Scheme.numLss.apply2(obj2, Lit73) != Boolean.FALSE)
            {
                Object obj3;
                CharSequence charsequence;
                int i;
                try
                {
                    obj = (LList)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "list->string", 1, obj1);
                }
                return strings.list$To$String(((LList) (obj)));
            }
            obj3 = AddOp.$Mn.apply2(obj2, Lit8);
            try
            {
                charsequence = (CharSequence)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "string-ref", 1, obj);
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
            i = strings.stringRef(charsequence, i);
            if (lists.memv(Char.make(i), Lit116) != Boolean.FALSE)
            {
                obj1 = lists.cons(Lit19, lists.cons(Char.make(i), obj1));
            } else
            {
                obj1 = lists.cons(Char.make(i), obj1);
            }
            obj2 = obj3;
        } while (true);
    }

    public static Object pregexpReadBranch(Object obj, Object obj1, Object obj2)
    {
        LList llist = LList.Empty;
        Object obj3 = obj1;
        obj1 = llist;
        do
        {
            if (Scheme.numGEq.apply2(obj3, obj2) != Boolean.FALSE)
            {
                return LList.list2(lists.cons(Lit5, pregexpReverse$Ex(obj1)), obj3);
            }
            CharSequence charsequence;
            int i;
            boolean flag;
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
            i = strings.stringRef(charsequence, i);
            flag = characters.isChar$Eq(Char.make(i), Lit7);
            if (flag ? flag : characters.isChar$Eq(Char.make(i), Lit6))
            {
                return LList.list2(lists.cons(Lit5, pregexpReverse$Ex(obj1)), obj3);
            }
            obj3 = pregexpReadPiece(obj, obj3, obj2);
            obj1 = lists.cons(lists.car.apply1(obj3), obj1);
            obj3 = lists.cadr.apply1(obj3);
        } while (true);
    }

    public static Object pregexpReadCharList(Object obj, Object obj1, Object obj2)
    {
        Object obj3;
        LList llist = LList.Empty;
        obj3 = obj1;
        obj1 = llist;
_L10:
        Object obj4;
        if (Scheme.numGEq.apply2(obj3, obj2) != Boolean.FALSE)
        {
            return pregexpError$V(new Object[] {
                Lit80, Lit81
            });
        }
        SimpleSymbol simplesymbol;
        CharSequence charsequence;
        int i;
        int j;
        boolean flag;
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
            i = ((Number)obj3).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj3);
        }
        i = strings.stringRef(((CharSequence) (obj4)), i);
        if (Scheme.isEqv.apply2(Char.make(i), Lit46) != Boolean.FALSE)
        {
            if (lists.isNull(obj1))
            {
                obj1 = lists.cons(Char.make(i), obj1);
                obj3 = AddOp.$Pl.apply2(obj3, Lit8);
            } else
            {
                return LList.list2(lists.cons(Lit82, pregexpReverse$Ex(obj1)), AddOp.$Pl.apply2(obj3, Lit8));
            }
            continue; /* Loop/switch isn't completed */
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit19) != Boolean.FALSE)
        {
            obj3 = pregexpReadEscapedChar(obj, obj3, obj2);
            if (obj3 != Boolean.FALSE)
            {
                obj1 = lists.cons(lists.car.apply1(obj3), obj1);
                obj3 = lists.cadr.apply1(obj3);
            } else
            {
                return pregexpError$V(new Object[] {
                    Lit80, Lit22
                });
            }
            continue; /* Loop/switch isn't completed */
        }
        if (Scheme.isEqv.apply2(Char.make(i), Lit58) == Boolean.FALSE) goto _L2; else goto _L1
_L1:
        flag = lists.isNull(obj1);
        if (!flag) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        obj1 = lists.cons(Char.make(i), obj1);
        obj3 = AddOp.$Pl.apply2(obj3, Lit8);
        continue; /* Loop/switch isn't completed */
_L4:
        obj4 = AddOp.$Pl.apply2(obj3, Lit8);
        Object obj5 = Scheme.numLss.apply2(obj4, obj2);
        try
        {
            flag = ((Boolean)obj5).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj5);
        }
        if (!flag) goto _L8; else goto _L7
_L7:
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
            j = ((Number)obj4).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj4);
        }
        if (characters.isChar$Eq(Char.make(strings.stringRef(((CharSequence) (obj5)), j)), Lit46)) goto _L5; else goto _L6
_L6:
        obj5 = lists.car.apply1(obj1);
        if (characters.isChar(obj5))
        {
            simplesymbol = Lit83;
            try
            {
                charsequence = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
            }
            obj4 = AddOp.$Pl.apply2(obj3, Lit8);
            try
            {
                i = ((Number)obj4).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj4);
            }
            obj1 = lists.cons(LList.list3(simplesymbol, obj5, Char.make(strings.stringRef(charsequence, i))), lists.cdr.apply1(obj1));
            obj3 = AddOp.$Pl.apply2(obj3, Lit16);
        } else
        {
            obj1 = lists.cons(Char.make(i), obj1);
            obj3 = AddOp.$Pl.apply2(obj3, Lit8);
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (!flag) goto _L6; else goto _L5
_L2:
        if (Scheme.isEqv.apply2(Char.make(i), Lit15) != Boolean.FALSE)
        {
            try
            {
                obj5 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
            }
            obj4 = AddOp.$Pl.apply2(obj3, Lit8);
            try
            {
                j = ((Number)obj4).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj4);
            }
            if (characters.isChar$Eq(Char.make(strings.stringRef(((CharSequence) (obj5)), j)), Lit44))
            {
                obj3 = pregexpReadPosixCharClass(obj, AddOp.$Pl.apply2(obj3, Lit16), obj2);
                obj1 = lists.cons(lists.car.apply1(obj3), obj1);
                obj3 = lists.cadr.apply1(obj3);
            } else
            {
                obj1 = lists.cons(Char.make(i), obj1);
                obj3 = AddOp.$Pl.apply2(obj3, Lit8);
            }
        } else
        {
            obj1 = lists.cons(Char.make(i), obj1);
            obj3 = AddOp.$Pl.apply2(obj3, Lit8);
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static Object pregexpReadClusterType(Object obj, Object obj1, Object obj2)
    {
        int i;
        try
        {
            obj2 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
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
        i = strings.stringRef(((CharSequence) (obj2)), i);
        if (Scheme.isEqv.apply2(Char.make(i), Lit47) != Boolean.FALSE)
        {
            obj2 = AddOp.$Pl.apply2(obj1, Lit8);
            int j;
            try
            {
                obj1 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
            }
            try
            {
                j = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj2);
            }
            j = strings.stringRef(((CharSequence) (obj1)), j);
            if (Scheme.isEqv.apply2(Char.make(j), Lit44) != Boolean.FALSE)
            {
                return LList.list2(LList.Empty, AddOp.$Pl.apply2(obj2, Lit8));
            }
            if (Scheme.isEqv.apply2(Char.make(j), Lit48) != Boolean.FALSE)
            {
                return LList.list2(Lit49, AddOp.$Pl.apply2(obj2, Lit8));
            }
            if (Scheme.isEqv.apply2(Char.make(j), Lit50) != Boolean.FALSE)
            {
                return LList.list2(Lit51, AddOp.$Pl.apply2(obj2, Lit8));
            }
            if (Scheme.isEqv.apply2(Char.make(j), Lit52) != Boolean.FALSE)
            {
                return LList.list2(Lit53, AddOp.$Pl.apply2(obj2, Lit8));
            }
            if (Scheme.isEqv.apply2(Char.make(j), Lit54) != Boolean.FALSE)
            {
                Object obj3;
                CharSequence charsequence;
                int k;
                try
                {
                    obj1 = (CharSequence)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
                }
                obj = AddOp.$Pl.apply2(obj2, Lit8);
                try
                {
                    k = ((Number)obj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
                }
                k = strings.stringRef(((CharSequence) (obj1)), k);
                if (Scheme.isEqv.apply2(Char.make(k), Lit48) != Boolean.FALSE)
                {
                    obj = Lit55;
                } else
                if (Scheme.isEqv.apply2(Char.make(k), Lit50) != Boolean.FALSE)
                {
                    obj = Lit56;
                } else
                {
                    obj = pregexpError$V(new Object[] {
                        Lit57
                    });
                }
                return LList.list2(obj, AddOp.$Pl.apply2(obj2, Lit16));
            }
            obj3 = LList.Empty;
            obj1 = Boolean.FALSE;
            do
            {
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
                    k = ((Number)obj2).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj2);
                }
                k = strings.stringRef(charsequence, k);
                if (Scheme.isEqv.apply2(Char.make(k), Lit58) != Boolean.FALSE)
                {
                    obj2 = AddOp.$Pl.apply2(obj2, Lit8);
                    obj1 = Boolean.TRUE;
                } else
                if (Scheme.isEqv.apply2(Char.make(k), Lit59) != Boolean.FALSE)
                {
                    obj2 = AddOp.$Pl.apply2(obj2, Lit8);
                    if (obj1 != Boolean.FALSE)
                    {
                        obj1 = Lit60;
                    } else
                    {
                        obj1 = Lit61;
                    }
                    obj3 = lists.cons(obj1, obj3);
                    obj1 = Boolean.FALSE;
                } else
                if (Scheme.isEqv.apply2(Char.make(k), Lit62) != Boolean.FALSE)
                {
                    $Stpregexp$Mnspace$Mnsensitive$Qu$St = obj1;
                    obj2 = AddOp.$Pl.apply2(obj2, Lit8);
                    obj1 = Boolean.FALSE;
                } else
                if (Scheme.isEqv.apply2(Char.make(k), Lit44) != Boolean.FALSE)
                {
                    return LList.list2(obj3, AddOp.$Pl.apply2(obj2, Lit8));
                } else
                {
                    return pregexpError$V(new Object[] {
                        Lit57
                    });
                }
            } while (true);
        } else
        {
            return LList.list2(Lit63, obj1);
        }
    }

    public static Object pregexpReadEscapedChar(Object obj, Object obj1, Object obj2)
    {
        obj2 = Scheme.numLss.apply2(AddOp.$Pl.apply2(obj1, Lit8), obj2);
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
        if (flag)
        {
            int i;
            try
            {
                obj2 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
            }
            obj = AddOp.$Pl.apply2(obj1, Lit8);
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
            }
            i = strings.stringRef(((CharSequence) (obj2)), i);
            if (Scheme.isEqv.apply2(Char.make(i), Lit25) != Boolean.FALSE)
            {
                return LList.list2(Lit26, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit27) != Boolean.FALSE)
            {
                return LList.list2(Lit28, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit29) != Boolean.FALSE)
            {
                return LList.list2(Lit30, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit31) != Boolean.FALSE)
            {
                return LList.list2(Lit32, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit33) != Boolean.FALSE)
            {
                return LList.list2(Lit24, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit34) != Boolean.FALSE)
            {
                return LList.list2($Stpregexp$Mnreturn$Mnchar$St, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit35) != Boolean.FALSE)
            {
                return LList.list2(Lit36, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit37) != Boolean.FALSE)
            {
                return LList.list2(Lit38, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit39) != Boolean.FALSE)
            {
                return LList.list2($Stpregexp$Mntab$Mnchar$St, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit40) != Boolean.FALSE)
            {
                return LList.list2(Lit41, AddOp.$Pl.apply2(obj1, Lit16));
            }
            if (Scheme.isEqv.apply2(Char.make(i), Lit42) != Boolean.FALSE)
            {
                return LList.list2(Lit43, AddOp.$Pl.apply2(obj1, Lit16));
            } else
            {
                return LList.list2(Char.make(i), AddOp.$Pl.apply2(obj1, Lit16));
            }
        }
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static Object pregexpReadEscapedNumber(Object obj, Object obj1, Object obj2)
    {
        Object obj3 = Scheme.numLss.apply2(AddOp.$Pl.apply2(obj1, Lit8), obj2);
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
        if (flag)
        {
            CharSequence charsequence;
            int i;
            try
            {
                charsequence = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
            }
            obj3 = AddOp.$Pl.apply2(obj1, Lit8);
            try
            {
                i = ((Number)obj3).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj3);
            }
            i = strings.stringRef(charsequence, i);
            flag = unicode.isCharNumeric(Char.make(i));
            if (flag)
            {
                obj1 = AddOp.$Pl.apply2(obj1, Lit16);
                obj3 = LList.list1(Char.make(i));
                do
                {
                    if (Scheme.numGEq.apply2(obj1, obj2) != Boolean.FALSE)
                    {
                        obj = pregexpReverse$Ex(obj3);
                        CharSequence charsequence1;
                        int j;
                        try
                        {
                            obj2 = (LList)obj;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            throw new WrongType(((ClassCastException) (obj1)), "list->string", 1, obj);
                        }
                        return LList.list2(numbers.string$To$Number(strings.list$To$String(((LList) (obj2)))), obj1);
                    }
                    try
                    {
                        charsequence1 = (CharSequence)obj;
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
                    j = strings.stringRef(charsequence1, j);
                    if (unicode.isCharNumeric(Char.make(j)))
                    {
                        obj1 = AddOp.$Pl.apply2(obj1, Lit8);
                        obj3 = lists.cons(Char.make(j), obj3);
                    } else
                    {
                        obj = pregexpReverse$Ex(obj3);
                        try
                        {
                            obj2 = (LList)obj;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            throw new WrongType(((ClassCastException) (obj1)), "list->string", 1, obj);
                        }
                        return LList.list2(numbers.string$To$Number(strings.list$To$String(((LList) (obj2)))), obj1);
                    }
                } while (true);
            }
            if (flag)
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        }
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static Object pregexpReadNums(Object obj, Object obj1, Object obj2)
    {
        Object obj4 = LList.Empty;
        Object obj3 = LList.Empty;
        IntNum intnum = Lit8;
        do
        {
            if (Scheme.numGEq.apply2(obj1, obj2) != Boolean.FALSE)
            {
                pregexpError$V(new Object[] {
                    Lit76
                });
            }
            CharSequence charsequence;
            int i;
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
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
            }
            i = strings.stringRef(charsequence, i);
            if (unicode.isCharNumeric(Char.make(i)))
            {
                if (Scheme.numEqu.apply2(intnum, Lit8) != Boolean.FALSE)
                {
                    obj4 = lists.cons(Char.make(i), obj4);
                    obj1 = AddOp.$Pl.apply2(obj1, Lit8);
                    intnum = Lit8;
                } else
                {
                    obj3 = lists.cons(Char.make(i), obj3);
                    obj1 = AddOp.$Pl.apply2(obj1, Lit8);
                    intnum = Lit16;
                }
            } else
            {
                boolean flag = unicode.isCharWhitespace(Char.make(i));
                if (flag ? $Stpregexp$Mnspace$Mnsensitive$Qu$St == Boolean.FALSE : flag)
                {
                    obj1 = AddOp.$Pl.apply2(obj1, Lit8);
                } else
                {
                    boolean flag1 = characters.isChar$Eq(Char.make(i), Lit77);
                    if (flag1 ? Scheme.numEqu.apply2(intnum, Lit8) != Boolean.FALSE : flag1)
                    {
                        obj1 = AddOp.$Pl.apply2(obj1, Lit8);
                        intnum = Lit16;
                    } else
                    if (characters.isChar$Eq(Char.make(i), Lit78))
                    {
                        obj = pregexpReverse$Ex(obj4);
                        int j;
                        try
                        {
                            obj2 = (LList)obj;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            throw new WrongType(((ClassCastException) (obj1)), "list->string", 1, obj);
                        }
                        obj = numbers.string$To$Number(strings.list$To$String(((LList) (obj2))));
                        obj2 = pregexpReverse$Ex(obj3);
                        try
                        {
                            obj3 = (LList)obj2;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            throw new WrongType(((ClassCastException) (obj)), "list->string", 1, obj2);
                        }
                        obj2 = numbers.string$To$Number(strings.list$To$String(((LList) (obj3))));
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
                            j = 1;
                        } else
                        {
                            j = 0;
                        }
                        j = j + 1 & 1;
                        if (j == 0 ? j != 0 : Scheme.numEqu.apply2(intnum, Lit8) != Boolean.FALSE)
                        {
                            return LList.list3(Lit73, Boolean.FALSE, obj1);
                        }
                        if (Scheme.numEqu.apply2(intnum, Lit8) != Boolean.FALSE)
                        {
                            return LList.list3(obj, obj, obj1);
                        } else
                        {
                            return LList.list3(obj, obj2, obj1);
                        }
                    } else
                    {
                        return Boolean.FALSE;
                    }
                }
            }
        } while (true);
    }

    public static Object pregexpReadPattern(Object obj, Object obj1, Object obj2)
    {
        Object obj3;
        if (Scheme.numGEq.apply2(obj1, obj2) != Boolean.FALSE)
        {
            return LList.list2(LList.list2(Lit4, LList.list1(Lit5)), obj1);
        }
        obj3 = LList.Empty;
_L6:
        Object obj4 = Scheme.numGEq.apply2(obj1, obj2);
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
        if (!flag) goto _L4; else goto _L3
_L3:
        return LList.list2(lists.cons(Lit4, pregexpReverse$Ex(obj3)), obj1);
_L2:
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
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
        }
        if (characters.isChar$Eq(Char.make(strings.stringRef(((CharSequence) (obj4)), i)), Lit6)) goto _L3; else goto _L4
_L4:
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
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
        }
        obj4 = obj1;
        if (characters.isChar$Eq(Char.make(strings.stringRef(charsequence, i)), Lit7))
        {
            obj4 = AddOp.$Pl.apply2(obj1, Lit8);
        }
        obj1 = pregexpReadBranch(obj, obj4, obj2);
        obj3 = lists.cons(lists.car.apply1(obj1), obj3);
        obj1 = lists.cadr.apply1(obj1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Object pregexpReadPiece(Object obj, Object obj1, Object obj2)
    {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public static Object pregexpReadPosixCharClass(Object obj, Object obj1, Object obj2)
    {
        Boolean boolean1 = Boolean.FALSE;
        Pair pair = LList.list1(Lit44);
        do
        {
            if (Scheme.numGEq.apply2(obj1, obj2) != Boolean.FALSE)
            {
                return pregexpError$V(new Object[] {
                    Lit45
                });
            }
            CharSequence charsequence;
            int i;
            boolean flag;
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
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
            }
            i = strings.stringRef(charsequence, i);
            if (characters.isChar$Eq(Char.make(i), Lit9))
            {
                boolean1 = Boolean.TRUE;
                obj1 = AddOp.$Pl.apply2(obj1, Lit8);
            } else
            {
label0:
                {
                    if (!unicode.isCharAlphabetic(Char.make(i)))
                    {
                        break label0;
                    }
                    obj1 = AddOp.$Pl.apply2(obj1, Lit8);
                    pair = lists.cons(Char.make(i), pair);
                }
            }
        } while (true);
        if (!characters.isChar$Eq(Char.make(i), Lit44))
        {
            break MISSING_BLOCK_LABEL_292;
        }
        obj2 = Scheme.numGEq.apply2(AddOp.$Pl.apply2(obj1, Lit8), obj2);
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
        if (!flag) goto _L4; else goto _L3
_L3:
        return pregexpError$V(new Object[] {
            Lit45
        });
_L2:
        try
        {
            obj2 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
        }
        obj = AddOp.$Pl.apply2(obj1, Lit8);
        try
        {
            i = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
        }
        if (!characters.isChar$Eq(Char.make(strings.stringRef(((CharSequence) (obj2)), i)), Lit46)) goto _L3; else goto _L4
_L4:
        obj = pregexpReverse$Ex(pair);
        try
        {
            obj2 = (LList)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "list->string", 1, obj);
        }
        obj2 = misc.string$To$Symbol(strings.list$To$String(((LList) (obj2))));
        obj = obj2;
        if (boolean1 != Boolean.FALSE)
        {
            obj = LList.list2(Lit17, obj2);
        }
        return LList.list2(obj, AddOp.$Pl.apply2(obj1, Lit16));
        return pregexpError$V(new Object[] {
            Lit45
        });
    }

    public static Object pregexpReadSubpattern(Object obj, Object obj1, Object obj2)
    {
        Object obj4;
        obj4 = $Stpregexp$Mnspace$Mnsensitive$Qu$St;
        obj1 = pregexpReadClusterType(obj, obj1, obj2);
        Object obj3 = lists.car.apply1(obj1);
        Object obj5 = pregexpReadPattern(obj, lists.cadr.apply1(obj1), obj2);
        $Stpregexp$Mnspace$Mnsensitive$Qu$St = obj4;
        obj1 = lists.car.apply1(obj5);
        obj4 = lists.cadr.apply1(obj5);
        obj2 = Scheme.numLss.apply2(obj4, obj2);
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
        try
        {
            obj2 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
        }
        try
        {
            i = ((Number)obj4).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj4);
        }
        if (!characters.isChar$Eq(Char.make(strings.stringRef(((CharSequence) (obj2)), i)), Lit6)) goto _L4; else goto _L3
_L3:
        obj = obj3;
_L6:
        if (lists.isNull(obj))
        {
            return LList.list2(obj1, AddOp.$Pl.apply2(obj4, Lit8));
        }
        obj2 = lists.cdr.apply1(obj);
        obj1 = LList.list2(lists.car.apply1(obj), obj1);
        obj = obj2;
        continue; /* Loop/switch isn't completed */
_L2:
        obj = obj3;
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        return pregexpError$V(new Object[] {
            Lit64
        });
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Object pregexpReplace(Object obj, Object obj1, Object obj2)
    {
        Object obj3;
        Object obj4;
        CharSequence charsequence;
        int i;
        int j;
        int k;
        try
        {
            obj3 = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
        }
        i = strings.stringLength(((CharSequence) (obj3)));
        obj3 = pregexpMatchPositions$V(obj, obj1, new Object[] {
            Lit73, Integer.valueOf(i)
        });
        if (obj3 == Boolean.FALSE)
        {
            return obj1;
        }
        try
        {
            obj = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj2);
        }
        j = strings.stringLength(((CharSequence) (obj)));
        obj4 = lists.caar.apply1(obj3);
        obj = lists.cdar.apply1(obj3);
        try
        {
            charsequence = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
        }
        try
        {
            k = ((Number)obj4).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj4);
        }
        obj4 = strings.substring(charsequence, 0, k);
        obj2 = pregexpReplaceAux(obj1, obj2, Integer.valueOf(j), obj3);
        try
        {
            obj3 = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
        }
        try
        {
            j = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "substring", 2, obj);
        }
        return strings.stringAppend(new Object[] {
            obj4, obj2, strings.substring(((CharSequence) (obj3)), j, i)
        });
    }

    public static Object pregexpReplace$St(Object obj, Object obj1, Object obj2)
    {
        Object obj3 = obj;
        if (strings.isString(obj))
        {
            obj3 = pregexp(obj);
        }
        Object obj4;
        int i;
        int j;
        try
        {
            obj = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
        }
        i = strings.stringLength(((CharSequence) (obj)));
        try
        {
            obj = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj2);
        }
        j = strings.stringLength(((CharSequence) (obj)));
        obj = Lit73;
        obj4 = "";
        do
        {
            if (Scheme.numGEq.apply2(obj, Integer.valueOf(i)) != Boolean.FALSE)
            {
                return obj4;
            }
            Object obj6 = pregexpMatchPositions$V(obj3, obj1, new Object[] {
                obj, Integer.valueOf(i)
            });
            if (obj6 == Boolean.FALSE)
            {
                if (Scheme.numEqu.apply2(obj, Lit73) == Boolean.FALSE)
                {
                    Object obj5;
                    CharSequence charsequence;
                    int k;
                    int l;
                    try
                    {
                        obj2 = (CharSequence)obj1;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
                    }
                    try
                    {
                        j = ((Number)obj).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        throw new WrongType(((ClassCastException) (obj1)), "substring", 2, obj);
                    }
                    obj1 = strings.stringAppend(new Object[] {
                        obj4, strings.substring(((CharSequence) (obj2)), j, i)
                    });
                }
                return obj1;
            }
            obj5 = lists.cdar.apply1(obj6);
            try
            {
                charsequence = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
            }
            try
            {
                k = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "substring", 2, obj);
            }
            obj = lists.caar.apply1(obj6);
            try
            {
                l = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "substring", 3, obj);
            }
            obj4 = strings.stringAppend(new Object[] {
                obj4, strings.substring(charsequence, k, l), pregexpReplaceAux(obj1, obj2, Integer.valueOf(j), obj6)
            });
            obj = obj5;
        } while (true);
    }

    public static Object pregexpReplaceAux(Object obj, Object obj1, Object obj2, Object obj3)
    {
        Object obj5 = Lit73;
        Object obj4 = "";
        do
        {
            if (Scheme.numGEq.apply2(obj5, obj2) != Boolean.FALSE)
            {
                return obj4;
            }
            CharSequence charsequence;
            int i;
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
                i = ((Number)obj5).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj5);
            }
            i = strings.stringRef(charsequence, i);
            if (characters.isChar$Eq(Char.make(i), Lit19))
            {
                Object obj7 = pregexpReadEscapedNumber(obj1, obj5, obj2);
                Object obj6;
                if (obj7 != Boolean.FALSE)
                {
                    obj6 = lists.car.apply1(obj7);
                } else
                {
                    Object obj8;
                    CharSequence charsequence1;
                    int j;
                    try
                    {
                        charsequence1 = (CharSequence)obj1;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj1);
                    }
                    obj6 = AddOp.$Pl.apply2(obj5, Lit8);
                    try
                    {
                        i = ((Number)obj6).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj6);
                    }
                    if (characters.isChar$Eq(Char.make(strings.stringRef(charsequence1, i)), Lit113))
                    {
                        obj6 = Lit73;
                    } else
                    {
                        obj6 = Boolean.FALSE;
                    }
                }
                if (obj7 != Boolean.FALSE)
                {
                    obj5 = lists.cadr.apply1(obj7);
                } else
                if (obj6 != Boolean.FALSE)
                {
                    obj5 = AddOp.$Pl.apply2(obj5, Lit16);
                } else
                {
                    obj5 = AddOp.$Pl.apply2(obj5, Lit8);
                }
                if (obj6 == Boolean.FALSE)
                {
                    try
                    {
                        obj6 = (CharSequence)obj1;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj1);
                    }
                    try
                    {
                        i = ((Number)obj5).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj5);
                    }
                    i = strings.stringRef(((CharSequence) (obj6)), i);
                    obj5 = AddOp.$Pl.apply2(obj5, Lit8);
                    if (!characters.isChar$Eq(Char.make(i), Lit11))
                    {
                        obj4 = strings.stringAppend(new Object[] {
                            obj4, strings.$make$string$(new Object[] {
                                Char.make(i)
                            })
                        });
                    }
                } else
                {
                    obj8 = pregexpListRef(obj3, obj6);
                    obj6 = obj4;
                    if (obj8 != Boolean.FALSE)
                    {
                        Object obj9;
                        Object obj10;
                        try
                        {
                            obj6 = (CharSequence)obj;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj1)
                        {
                            throw new WrongType(((ClassCastException) (obj1)), "substring", 1, obj);
                        }
                        obj10 = lists.car.apply1(obj8);
                        try
                        {
                            i = ((Number)obj10).intValue();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            throw new WrongType(((ClassCastException) (obj)), "substring", 2, obj10);
                        }
                        obj9 = lists.cdr.apply1(obj8);
                        try
                        {
                            j = ((Number)obj9).intValue();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj9);
                        }
                        obj6 = strings.stringAppend(new Object[] {
                            obj4, strings.substring(((CharSequence) (obj6)), i, j)
                        });
                    }
                    obj4 = obj6;
                }
            } else
            {
                obj5 = AddOp.$Pl.apply2(obj5, Lit8);
                obj4 = strings.stringAppend(new Object[] {
                    obj4, strings.$make$string$(new Object[] {
                        Char.make(i)
                    })
                });
            }
        } while (true);
    }

    public static Object pregexpReverse$Ex(Object obj)
    {
        Object obj1 = LList.Empty;
        do
        {
            if (lists.isNull(obj))
            {
                return obj1;
            }
            Object obj2 = lists.cdr.apply1(obj);
            Pair pair;
            try
            {
                pair = (Pair)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "set-cdr!", 1, obj);
            }
            lists.setCdr$Ex(pair, obj1);
            obj1 = obj;
            obj = obj2;
        } while (true);
    }

    public static Object pregexpSplit(Object obj, Object obj1)
    {
        Object obj2;
        Object obj3;
        Object obj4;
        int i;
        try
        {
            obj2 = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
        }
        i = strings.stringLength(((CharSequence) (obj2)));
        obj2 = Lit73;
        obj4 = LList.Empty;
        obj3 = Boolean.FALSE;
        do
        {
            if (Scheme.numGEq.apply2(obj2, Integer.valueOf(i)) != Boolean.FALSE)
            {
                return pregexpReverse$Ex(obj4);
            }
            Object obj5 = pregexpMatchPositions$V(obj, obj1, new Object[] {
                obj2, Integer.valueOf(i)
            });
            if (obj5 != Boolean.FALSE)
            {
                obj5 = lists.car.apply1(obj5);
                Object obj6 = lists.car.apply1(obj5);
                obj5 = lists.cdr.apply1(obj5);
                if (Scheme.numEqu.apply2(obj6, obj5) != Boolean.FALSE)
                {
                    obj3 = AddOp.$Pl.apply2(obj5, Lit8);
                    int j;
                    int k;
                    boolean flag;
                    try
                    {
                        obj5 = (CharSequence)obj1;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
                    }
                    try
                    {
                        j = ((Number)obj2).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "substring", 2, obj2);
                    }
                    obj2 = AddOp.$Pl.apply2(obj6, Lit8);
                    try
                    {
                        k = ((Number)obj2).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj2);
                    }
                    obj4 = lists.cons(strings.substring(((CharSequence) (obj5)), j, k), obj4);
                    obj5 = Boolean.TRUE;
                    obj2 = obj3;
                    obj3 = obj5;
                } else
                {
                    Object obj7 = Scheme.numEqu.apply2(obj6, obj2);
                    try
                    {
                        flag = ((Boolean)obj7).booleanValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "x", -2, obj7);
                    }
                    if (flag ? obj3 != Boolean.FALSE : flag)
                    {
                        obj3 = Boolean.FALSE;
                        obj2 = obj5;
                    } else
                    {
                        try
                        {
                            obj3 = (CharSequence)obj1;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
                        }
                        try
                        {
                            j = ((Number)obj2).intValue();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            throw new WrongType(((ClassCastException) (obj)), "substring", 2, obj2);
                        }
                        try
                        {
                            k = ((Number)obj6).intValue();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj6);
                        }
                        obj4 = lists.cons(strings.substring(((CharSequence) (obj3)), j, k), obj4);
                        obj3 = Boolean.FALSE;
                        obj2 = obj5;
                    }
                }
            } else
            {
                try
                {
                    obj3 = (CharSequence)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
                }
                try
                {
                    j = ((Number)obj2).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "substring", 2, obj2);
                }
                obj4 = lists.cons(strings.substring(((CharSequence) (obj3)), j, i), obj4);
                obj3 = Boolean.FALSE;
                obj2 = Integer.valueOf(i);
            }
        } while (true);
    }

    public static Object pregexpStringMatch(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
    {
        Object obj6;
        int i;
        try
        {
            obj6 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
        }
        i = strings.stringLength(((CharSequence) (obj6)));
        if (Scheme.numGrt.apply2(Integer.valueOf(i), obj3) != Boolean.FALSE)
        {
            return Scheme.applyToArgs.apply1(obj5);
        }
        obj6 = Lit73;
        do
        {
            if (Scheme.numGEq.apply2(obj6, Integer.valueOf(i)) != Boolean.FALSE)
            {
                return Scheme.applyToArgs.apply2(obj4, obj2);
            }
            if (Scheme.numGEq.apply2(obj2, obj3) != Boolean.FALSE)
            {
                return Scheme.applyToArgs.apply1(obj5);
            }
            Object obj7;
            CharSequence charsequence;
            int j;
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
                j = ((Number)obj6).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj6);
            }
            obj7 = Char.make(strings.stringRef(((CharSequence) (obj7)), j));
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
                j = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj2);
            }
            if (characters.isChar$Eq(((Char) (obj7)), Char.make(strings.stringRef(charsequence, j))))
            {
                obj6 = AddOp.$Pl.apply2(obj6, Lit8);
                obj2 = AddOp.$Pl.apply2(obj2, Lit8);
            } else
            {
                return Scheme.applyToArgs.apply1(obj5);
            }
        } while (true);
    }

    public static Object pregexpWrapQuantifierIfAny(Object obj, Object obj1, Object obj2)
    {
        Object obj3;
        Object obj4;
        obj4 = lists.car.apply1(obj);
        obj3 = lists.cadr.apply1(obj);
_L5:
        if (Scheme.numGEq.apply2(obj3, obj2) == Boolean.FALSE) goto _L2; else goto _L1
_L1:
        return obj;
_L2:
        Object obj5;
        Pair pair;
        int i;
        boolean flag;
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
            i = ((Number)obj3).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj3);
        }
        i = strings.stringRef(((CharSequence) (obj5)), i);
        flag = unicode.isCharWhitespace(Char.make(i));
        if (flag ? $Stpregexp$Mnspace$Mnsensitive$Qu$St == Boolean.FALSE : flag)
        {
            obj3 = AddOp.$Pl.apply2(obj3, Lit8);
            continue; /* Loop/switch isn't completed */
        }
        obj5 = Scheme.isEqv.apply2(Char.make(i), Lit65);
        if (obj5 == Boolean.FALSE ? (obj5 = Scheme.isEqv.apply2(Char.make(i), Lit66)) == Boolean.FALSE ? (obj5 = Scheme.isEqv.apply2(Char.make(i), Lit47)) == Boolean.FALSE ? Scheme.isEqv.apply2(Char.make(i), Lit67) == Boolean.FALSE : obj5 == Boolean.FALSE : obj5 == Boolean.FALSE : obj5 == Boolean.FALSE) goto _L1; else goto _L3
_L3:
        obj5 = LList.list1(Lit68);
        LList.chain4(((Pair) (obj5)), Lit69, Lit70, Lit71, obj4);
        obj4 = LList.list2(obj5, Lit72);
        if (Scheme.isEqv.apply2(Char.make(i), Lit65) != Boolean.FALSE)
        {
            obj = lists.cddr.apply1(obj5);
            try
            {
                pair = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-car!", 1, obj);
            }
            lists.setCar$Ex(pair, Lit73);
            obj = lists.cdddr.apply1(obj5);
            try
            {
                pair = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-car!", 1, obj);
            }
            lists.setCar$Ex(pair, Boolean.FALSE);
            obj = obj3;
        } else
        if (Scheme.isEqv.apply2(Char.make(i), Lit66) != Boolean.FALSE)
        {
            obj = lists.cddr.apply1(obj5);
            try
            {
                pair = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-car!", 1, obj);
            }
            lists.setCar$Ex(pair, Lit8);
            obj = lists.cdddr.apply1(obj5);
            try
            {
                pair = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-car!", 1, obj);
            }
            lists.setCar$Ex(pair, Boolean.FALSE);
            obj = obj3;
        } else
        if (Scheme.isEqv.apply2(Char.make(i), Lit47) != Boolean.FALSE)
        {
            obj = lists.cddr.apply1(obj5);
            try
            {
                pair = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-car!", 1, obj);
            }
            lists.setCar$Ex(pair, Lit73);
            obj = lists.cdddr.apply1(obj5);
            try
            {
                pair = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-car!", 1, obj);
            }
            lists.setCar$Ex(pair, Lit8);
            obj = obj3;
        } else
        {
            obj = obj3;
            if (Scheme.isEqv.apply2(Char.make(i), Lit67) != Boolean.FALSE)
            {
                obj = pregexpReadNums(obj1, AddOp.$Pl.apply2(obj3, Lit8), obj2);
                if (obj == Boolean.FALSE)
                {
                    pregexpError$V(new Object[] {
                        Lit74, Lit75
                    });
                }
                obj3 = lists.cddr.apply1(obj5);
                try
                {
                    pair = (Pair)obj3;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj3);
                }
                lists.setCar$Ex(pair, lists.car.apply1(obj));
                obj3 = lists.cdddr.apply1(obj5);
                try
                {
                    pair = (Pair)obj3;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj3);
                }
                lists.setCar$Ex(pair, lists.cadr.apply1(obj));
                obj = lists.caddr.apply1(obj);
            }
        }
        obj = AddOp.$Pl.apply2(obj, Lit8);
        do
        {
label0:
            {
                {
                    if (Scheme.numGEq.apply2(obj, obj2) == Boolean.FALSE)
                    {
                        break label0;
                    }
                    obj1 = lists.cdr.apply1(obj5);
                    try
                    {
                        obj2 = (Pair)obj1;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj1);
                    }
                    lists.setCar$Ex(((Pair) (obj2)), Boolean.FALSE);
                    obj1 = lists.cdr.apply1(obj4);
                    try
                    {
                        obj2 = (Pair)obj1;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj1);
                    }
                    lists.setCar$Ex(((Pair) (obj2)), obj);
                }
                return obj4;
            }
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
            i = strings.stringRef(((CharSequence) (obj3)), i);
            flag = unicode.isCharWhitespace(Char.make(i));
            if (flag ? $Stpregexp$Mnspace$Mnsensitive$Qu$St == Boolean.FALSE : flag)
            {
                obj = AddOp.$Pl.apply2(obj, Lit8);
            } else
            {
                break MISSING_BLOCK_LABEL_733;
            }
        } while (true);
label1:
        {
            if (!characters.isChar$Eq(Char.make(i), Lit47))
            {
                break label1;
            }
            obj1 = lists.cdr.apply1(obj5);
            try
            {
                obj2 = (Pair)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj1);
            }
            lists.setCar$Ex(((Pair) (obj2)), Boolean.TRUE);
            obj1 = lists.cdr.apply1(obj4);
            try
            {
                obj2 = (Pair)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj1);
            }
            lists.setCar$Ex(((Pair) (obj2)), AddOp.$Pl.apply2(obj, Lit8));
        }
        break MISSING_BLOCK_LABEL_300;
        obj1 = lists.cdr.apply1(obj5);
        try
        {
            obj2 = (Pair)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj1);
        }
        lists.setCar$Ex(((Pair) (obj2)), Boolean.FALSE);
        obj1 = lists.cdr.apply1(obj4);
        obj2 = (Pair)obj1;
        lists.setCar$Ex(((Pair) (obj2)), obj);
        break MISSING_BLOCK_LABEL_300;
        obj;
        throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj1);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply0(modulemethod);

        case 36: // '$'
            return frame.lambda4();

        case 37: // '%'
            return frame0.lambda13();

        case 38: // '&'
            return frame0.lambda14();

        case 39: // '\''
            return frame0.lambda15();

        case 40: // '('
            return frame0.lambda16();

        case 41: // ')'
            return frame0.lambda17();
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 16: // '\020'
            return pregexpReverse$Ex(obj);

        case 28: // '\034'
            return pregexpInvertCharList(obj);

        case 31: // '\037'
            if (isPregexpCharWord(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 35: // '#'
            return pregexpMakeBackrefList(obj);

        case 44: // ','
            return pregexp(obj);

        case 50: // '2'
            return pregexpQuote(obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 33: // '!'
            return isPregexpCheckIfInCharClass(obj, obj1);

        case 34: // '"'
            return pregexpListRef(obj, obj1);

        case 47: // '/'
            return pregexpSplit(obj, obj1);
        }
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        case 28: // '\034'
        case 30: // '\036'
        case 31: // '\037'
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 42: // '*'
        case 43: // '+'
        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 47: // '/'
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 18: // '\022'
            return pregexpReadPattern(obj, obj1, obj2);

        case 19: // '\023'
            return pregexpReadBranch(obj, obj1, obj2);

        case 20: // '\024'
            return pregexpReadPiece(obj, obj1, obj2);

        case 21: // '\025'
            return pregexpReadEscapedNumber(obj, obj1, obj2);

        case 22: // '\026'
            return pregexpReadEscapedChar(obj, obj1, obj2);

        case 23: // '\027'
            return pregexpReadPosixCharClass(obj, obj1, obj2);

        case 24: // '\030'
            return pregexpReadClusterType(obj, obj1, obj2);

        case 25: // '\031'
            return pregexpReadSubpattern(obj, obj1, obj2);

        case 26: // '\032'
            return pregexpWrapQuantifierIfAny(obj, obj1, obj2);

        case 27: // '\033'
            return pregexpReadNums(obj, obj1, obj2);

        case 29: // '\035'
            return pregexpReadCharList(obj, obj1, obj2);

        case 32: // ' '
            return isPregexpAtWordBoundary(obj, obj1, obj2);

        case 48: // '0'
            return pregexpReplace(obj, obj1, obj2);

        case 49: // '1'
            return pregexpReplace$St(obj, obj1, obj2);
        }
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        if (modulemethod.selector == 43)
        {
            return pregexpReplaceAux(obj, obj1, obj2, obj3);
        } else
        {
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        Object obj1;
        Object aobj2[];
        int j;
        switch (modulemethod.selector)
        {
        default:
            return super.applyN(modulemethod, aobj);

        case 17: // '\021'
            return pregexpError$V(aobj);

        case 30: // '\036'
            return pregexpStringMatch(aobj[0], aobj[1], aobj[2], aobj[3], aobj[4], aobj[5]);

        case 42: // '*'
            return pregexpMatchPositionsAux(aobj[0], aobj[1], aobj[2], aobj[3], aobj[4], aobj[5]);

        case 45: // '-'
            modulemethod = ((ModuleMethod) (aobj[0]));
            Object obj = aobj[1];
            int i = aobj.length - 2;
            Object aobj1[] = new Object[i];
            do
            {
                i--;
                if (i < 0)
                {
                    return pregexpMatchPositions$V(modulemethod, obj, aobj1);
                }
                aobj1[i] = aobj[i + 2];
            } while (true);

        case 46: // '.'
            modulemethod = ((ModuleMethod) (aobj[0]));
            obj1 = aobj[1];
            j = aobj.length - 2;
            aobj2 = new Object[j];
            break;
        }
        do
        {
            j--;
            if (j < 0)
            {
                return pregexpMatch$V(modulemethod, obj1, aobj2);
            }
            aobj2[j] = aobj[j + 2];
        } while (true);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match0(modulemethod, callcontext);

        case 41: // ')'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 40: // '('
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 39: // '\''
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 38: // '&'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 37: // '%'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 36: // '$'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 50: // '2'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 44: // ','
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 35: // '#'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 31: // '\037'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 28: // '\034'
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

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 47: // '/'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 34: // '"'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 33: // '!'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 28: // '\034'
        case 30: // '\036'
        case 31: // '\037'
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 42: // '*'
        case 43: // '+'
        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 47: // '/'
        default:
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);

        case 49: // '1'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 48: // '0'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 32: // ' '
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 29: // '\035'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 27: // '\033'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 26: // '\032'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 25: // '\031'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 24: // '\030'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 23: // '\027'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 22: // '\026'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 21: // '\025'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 20: // '\024'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 19: // '\023'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 18: // '\022'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        if (modulemethod.selector == 43)
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
        switch (modulemethod.selector)
        {
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 46: // '.'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 45: // '-'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 42: // '*'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 30: // '\036'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 17: // '\021'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
        $Stpregexp$Mnversion$St = Lit0;
        $Stpregexp$Mncomment$Mnchar$St = Lit1;
        $Stpregexp$Mnnul$Mnchar$Mnint$St = Integer.valueOf(characters.char$To$Integer(Lit2) - 97);
        $Stpregexp$Mnreturn$Mnchar$St = characters.integer$To$Char(((Number)$Stpregexp$Mnnul$Mnchar$Mnint$St).intValue() + 13);
        $Stpregexp$Mntab$Mnchar$St = characters.integer$To$Char(((Number)$Stpregexp$Mnnul$Mnchar$Mnint$St).intValue() + 9);
        $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
    }

    static 
    {
        Lit135 = (SimpleSymbol)(new SimpleSymbol("pregexp-quote")).readResolve();
        Lit134 = (SimpleSymbol)(new SimpleSymbol("pregexp-replace*")).readResolve();
        Lit133 = (SimpleSymbol)(new SimpleSymbol("pregexp-replace")).readResolve();
        Lit132 = (SimpleSymbol)(new SimpleSymbol("pregexp-split")).readResolve();
        Lit131 = (SimpleSymbol)(new SimpleSymbol("pregexp-match")).readResolve();
        Lit130 = (SimpleSymbol)(new SimpleSymbol("pregexp")).readResolve();
        Lit129 = (SimpleSymbol)(new SimpleSymbol("pregexp-replace-aux")).readResolve();
        Lit128 = (SimpleSymbol)(new SimpleSymbol("pregexp-make-backref-list")).readResolve();
        Lit127 = (SimpleSymbol)(new SimpleSymbol("pregexp-list-ref")).readResolve();
        Lit126 = (SimpleSymbol)(new SimpleSymbol("pregexp-at-word-boundary?")).readResolve();
        Lit125 = (SimpleSymbol)(new SimpleSymbol("pregexp-char-word?")).readResolve();
        Lit124 = (SimpleSymbol)(new SimpleSymbol("pregexp-string-match")).readResolve();
        Lit123 = (SimpleSymbol)(new SimpleSymbol("pregexp-invert-char-list")).readResolve();
        Lit122 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-escaped-char")).readResolve();
        Lit121 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-escaped-number")).readResolve();
        Lit120 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-branch")).readResolve();
        Lit119 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-pattern")).readResolve();
        Lit118 = (SimpleSymbol)(new SimpleSymbol("pregexp-error")).readResolve();
        Lit117 = (SimpleSymbol)(new SimpleSymbol("pregexp-reverse!")).readResolve();
        Object obj = Char.make(92);
        Lit19 = ((Char) (obj));
        Object obj1 = Char.make(46);
        Lit13 = ((Char) (obj1));
        Object obj2 = Char.make(63);
        Lit47 = ((Char) (obj2));
        Object obj3 = Char.make(42);
        Lit65 = ((Char) (obj3));
        Object obj4 = Char.make(43);
        Lit66 = ((Char) (obj4));
        Char char1 = Char.make(124);
        Lit7 = char1;
        Char char2 = Char.make(94);
        Lit9 = char2;
        Char char3 = Char.make(36);
        Lit11 = char3;
        Char char4 = Char.make(91);
        Lit15 = char4;
        Char char5 = Char.make(93);
        Lit46 = char5;
        Char char6 = Char.make(123);
        Lit67 = char6;
        Char char7 = Char.make(125);
        Lit78 = char7;
        Char char8 = Char.make(40);
        Lit18 = char8;
        Char char9 = Char.make(41);
        Lit6 = char9;
        Lit116 = PairWithPosition.make(obj, PairWithPosition.make(obj1, PairWithPosition.make(obj2, PairWithPosition.make(obj3, PairWithPosition.make(obj4, PairWithPosition.make(char1, PairWithPosition.make(char2, PairWithPosition.make(char3, PairWithPosition.make(char4, PairWithPosition.make(char5, PairWithPosition.make(char6, PairWithPosition.make(char7, PairWithPosition.make(char8, PairWithPosition.make(char9, LList.Empty, "pregexp.scm", 0x302039), "pregexp.scm", 0x302035), "pregexp.scm", 0x302031), "pregexp.scm", 0x30202d), "pregexp.scm", 0x302029), "pregexp.scm", 0x302025), "pregexp.scm", 0x30103d), "pregexp.scm", 0x301039), "pregexp.scm", 0x301035), "pregexp.scm", 0x301031), "pregexp.scm", 0x30102d), "pregexp.scm", 0x301029), "pregexp.scm", 0x301025), "pregexp.scm", 0x301020);
        Lit114 = (SimpleSymbol)(new SimpleSymbol("pregexp-match-positions")).readResolve();
        Lit109 = (SimpleSymbol)(new SimpleSymbol(":no-backtrack")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol(":between")).readResolve();
        Lit68 = ((SimpleSymbol) (obj));
        obj1 = Boolean.FALSE;
        obj2 = IntNum.make(0);
        Lit73 = ((IntNum) (obj2));
        obj3 = Boolean.FALSE;
        obj4 = (SimpleSymbol)(new SimpleSymbol(":any")).readResolve();
        Lit14 = ((SimpleSymbol) (obj4));
        Lit108 = PairWithPosition.make(obj, PairWithPosition.make(obj1, PairWithPosition.make(obj2, PairWithPosition.make(obj3, PairWithPosition.make(obj4, LList.Empty, "pregexp.scm", 0x23b041), "pregexp.scm", 0x23b03e), "pregexp.scm", 0x23b03c), "pregexp.scm", 0x23b039), "pregexp.scm", 0x23b02f);
        Lit107 = (SimpleSymbol)(new SimpleSymbol(":neg-lookbehind")).readResolve();
        Lit106 = PairWithPosition.make(Lit68, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit73, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit14, LList.Empty, "pregexp.scm", 0x232041), "pregexp.scm", 0x23203e), "pregexp.scm", 0x23203c), "pregexp.scm", 0x232039), "pregexp.scm", 0x23202f);
        Lit105 = (SimpleSymbol)(new SimpleSymbol(":lookbehind")).readResolve();
        Lit104 = (SimpleSymbol)(new SimpleSymbol(":neg-lookahead")).readResolve();
        Lit103 = (SimpleSymbol)(new SimpleSymbol(":lookahead")).readResolve();
        Lit101 = (SimpleSymbol)(new SimpleSymbol("pregexp-match-positions-aux")).readResolve();
        Lit100 = (SimpleSymbol)(new SimpleSymbol(":sub")).readResolve();
        Lit99 = (SimpleSymbol)(new SimpleSymbol("pregexp-check-if-in-char-class?")).readResolve();
        Lit80 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-char-list")).readResolve();
        Lit76 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-nums")).readResolve();
        Lit74 = (SimpleSymbol)(new SimpleSymbol("pregexp-wrap-quantifier-if-any")).readResolve();
        Lit64 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-subpattern")).readResolve();
        Lit63 = PairWithPosition.make(Lit100, LList.Empty, "pregexp.scm", 0xe6016);
        Lit57 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-cluster-type")).readResolve();
        Lit56 = PairWithPosition.make(Lit107, LList.Empty, "pregexp.scm", 0xd601f);
        Lit55 = PairWithPosition.make(Lit105, LList.Empty, "pregexp.scm", 0xd501f);
        Lit53 = PairWithPosition.make(Lit109, LList.Empty, "pregexp.scm", 0xd201c);
        Lit51 = PairWithPosition.make(Lit104, LList.Empty, "pregexp.scm", 0xd101c);
        Lit49 = PairWithPosition.make(Lit103, LList.Empty, "pregexp.scm", 0xd001c);
        Lit45 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-posix-char-class")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol(":neg-char")).readResolve();
        Lit17 = ((SimpleSymbol) (obj));
        obj1 = (SimpleSymbol)(new SimpleSymbol(":word")).readResolve();
        Lit41 = ((SimpleSymbol) (obj1));
        Lit43 = PairWithPosition.make(obj, PairWithPosition.make(obj1, LList.Empty, "pregexp.scm", 0xaa027), "pregexp.scm", 0xaa01c);
        obj = Lit17;
        obj1 = (SimpleSymbol)(new SimpleSymbol(":space")).readResolve();
        Lit36 = ((SimpleSymbol) (obj1));
        Lit38 = PairWithPosition.make(obj, PairWithPosition.make(obj1, LList.Empty, "pregexp.scm", 0xa7027), "pregexp.scm", 0xa701c);
        obj = Lit17;
        obj1 = (SimpleSymbol)(new SimpleSymbol(":digit")).readResolve();
        Lit30 = ((SimpleSymbol) (obj1));
        Lit32 = PairWithPosition.make(obj, PairWithPosition.make(obj1, LList.Empty, "pregexp.scm", 0xa3027), "pregexp.scm", 0xa301c);
        Lit21 = (SimpleSymbol)(new SimpleSymbol("pregexp-read-piece")).readResolve();
        $instance = new pregexp();
        obj = $instance;
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 16, Lit117, 4097);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:47");
        pregexp$Mnreverse$Ex = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 17, Lit118, -4096);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:57");
        pregexp$Mnerror = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 18, Lit119, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:65");
        pregexp$Mnread$Mnpattern = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 19, Lit120, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:79");
        pregexp$Mnread$Mnbranch = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 20, Lit21, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:91");
        pregexp$Mnread$Mnpiece = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 21, Lit121, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:138");
        pregexp$Mnread$Mnescaped$Mnnumber = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 22, Lit122, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:155");
        pregexp$Mnread$Mnescaped$Mnchar = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 23, Lit45, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:174");
        pregexp$Mnread$Mnposix$Mnchar$Mnclass = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 24, Lit57, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:200");
        pregexp$Mnread$Mncluster$Mntype = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 25, Lit64, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:233");
        pregexp$Mnread$Mnsubpattern = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 26, Lit74, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:254");
        pregexp$Mnwrap$Mnquantifier$Mnif$Mnany = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 27, Lit76, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:300");
        pregexp$Mnread$Mnnums = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 28, Lit123, 4097);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:323");
        pregexp$Mninvert$Mnchar$Mnlist = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 29, Lit80, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:330");
        pregexp$Mnread$Mnchar$Mnlist = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 30, Lit124, 24582);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:368");
        pregexp$Mnstring$Mnmatch = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 31, Lit125, 4097);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:379");
        pregexp$Mnchar$Mnword$Qu = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 32, Lit126, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:387");
        pregexp$Mnat$Mnword$Mnboundary$Qu = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 33, Lit99, 8194);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:399");
        pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 34, Lit127, 8194);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:429");
        pregexp$Mnlist$Mnref = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 35, Lit128, 4097);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:448");
        pregexp$Mnmake$Mnbackref$Mnlist = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 36, null, 0);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:463");
        lambda$Fn1 = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 37, null, 0);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:551");
        lambda$Fn6 = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 38, null, 0);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:556");
        lambda$Fn7 = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 39, null, 0);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:564");
        lambda$Fn8 = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 40, null, 0);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:573");
        lambda$Fn9 = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 41, null, 0);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:578");
        lambda$Fn10 = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 42, Lit101, 24582);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:459");
        pregexp$Mnmatch$Mnpositions$Mnaux = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 43, Lit129, 16388);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:639");
        pregexp$Mnreplace$Mnaux = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 44, Lit130, 4097);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:665");
        pregexp = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 45, Lit114, -4094);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:670");
        pregexp$Mnmatch$Mnpositions = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 46, Lit131, -4094);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:690");
        pregexp$Mnmatch = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 47, Lit132, 8194);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:700");
        pregexp$Mnsplit = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 48, Lit133, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:723");
        pregexp$Mnreplace = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 49, Lit134, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "pregexp.scm:736");
        pregexp$Mnreplace$St = ((ModuleMethod) (obj1));
        obj = new ModuleMethod(((ModuleBody) (obj)), 50, Lit135, 4097);
        ((PropertySet) (obj)).setProperty("source-location", "pregexp.scm:764");
        pregexp$Mnquote = ((ModuleMethod) (obj));
        $instance.run();
    }
}
