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
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import kawa.lang.Eval;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.parameters;
import kawa.lib.ports;
import kawa.lib.std_syntax;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.readchar;
import kawa.standard.syntax_case;

public class testing extends ModuleBody
{
    public class test.Mnrunner
    {

        public Object aux$Mnvalue;
        public Object count$Mnlist;
        public Object fail$Mncount;
        public Object fail$Mnlist;
        public Object fail$Mnsave;
        public Object group$Mnstack;
        public Object on$Mnbad$Mncount;
        public Object on$Mnbad$Mnend$Mnname;
        public Object on$Mnfinal;
        public Object on$Mngroup$Mnbegin;
        public Object on$Mngroup$Mnend;
        public Object on$Mntest$Mnbegin;
        public Object on$Mntest$Mnend;
        public Object pass$Mncount;
        public Object result$Mnalist;
        public Object run$Mnlist;
        public Object skip$Mncount;
        public Object skip$Mnlist;
        public Object skip$Mnsave;
        public Object total$Mncount;
        public Object xfail$Mncount;
        public Object xpass$Mncount;

        public test.Mnrunner()
        {
        }
    }

    public class frame extends ModuleBody
    {

        Object p;

        public Object lambda4loop(Object obj)
        {
            if (obj == p)
            {
                return lists.cdr.apply1(obj);
            } else
            {
                return lists.cons(lists.car.apply1(obj), lambda4loop(lists.cdr.apply1(obj)));
            }
        }

        public frame()
        {
        }
    }

    public class frame0 extends ModuleBody
    {

        Object error;
        final ModuleMethod lambda$Fn4;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 1)
            {
                if (lambda5(obj, obj1))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        boolean lambda5(Object obj, Object obj1)
        {
            Object obj2 = Scheme.numGEq.apply2(obj, AddOp.$Mn.apply2(obj1, error));
            boolean flag;
            boolean flag1;
            try
            {
                flag = ((Boolean)obj2).booleanValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "x", -2, obj2);
            }
            flag1 = flag;
            if (flag)
            {
                flag1 = ((Boolean)Scheme.numLEq.apply2(obj, AddOp.$Pl.apply2(obj1, error))).booleanValue();
            }
            return flag1;
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 1)
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

        public frame0()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 8194);
            modulemethod.setProperty("source-location", "testing.scm:640");
            lambda$Fn4 = modulemethod;
        }
    }

    public class frame1 extends ModuleBody
    {

        Object first;
        final ModuleMethod lambda$Fn10;
        final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 2, null, 0);
        final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 3, null, 0);
        final ModuleMethod lambda$Fn7;
        final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 5, null, 0);
        final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 6, null, 0);
        Object r;
        LList rest;
        Object saved$Mnrunner;
        Object saved$Mnrunner$1;

        public Object apply0(ModuleMethod modulemethod)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply0(modulemethod);

            case 2: // '\002'
                return lambda6();

            case 3: // '\003'
                return lambda7();

            case 4: // '\004'
                return lambda8();

            case 5: // '\005'
                return lambda9();

            case 6: // '\006'
                return lambda10();

            case 7: // '\007'
                return lambda11();
            }
        }

        Object lambda10()
        {
            return Scheme.apply.apply3(testing.test$Mnapply, first, rest);
        }

        Object lambda11()
        {
            return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(saved$Mnrunner);
        }

        Object lambda6()
        {
            return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(first);
        }

        Object lambda7()
        {
            return Scheme.apply.apply2(testing.test$Mnapply, rest);
        }

        Object lambda8()
        {
            return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(saved$Mnrunner$1);
        }

        Object lambda9()
        {
            return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(r);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match0(modulemethod, callcontext);

            case 7: // '\007'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 6: // '\006'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 5: // '\005'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 4: // '\004'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 3: // '\003'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 2: // '\002'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            }
        }

        public frame1()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 4, null, 0);
            modulemethod.setProperty("source-location", "testing.scm:897");
            lambda$Fn7 = modulemethod;
            modulemethod = new ModuleMethod(this, 7, null, 0);
            modulemethod.setProperty("source-location", "testing.scm:897");
            lambda$Fn10 = modulemethod;
        }
    }

    public class frame2 extends ModuleBody
    {

        Object count;
        Object i;
        final ModuleMethod lambda$Fn11;
        Object n;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 8)
            {
                if (lambda12(obj))
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

        boolean lambda12(Object obj)
        {
            i = AddOp.$Pl.apply2(i, testing.Lit13);
            obj = Scheme.numGEq.apply2(i, n);
            boolean flag;
            boolean flag1;
            try
            {
                flag = ((Boolean)obj).booleanValue();
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "x", -2, obj);
            }
            flag1 = flag;
            if (flag)
            {
                flag1 = ((Boolean)Scheme.numLss.apply2(i, AddOp.$Pl.apply2(n, count))).booleanValue();
            }
            return flag1;
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

        public frame2()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 8, null, 4097);
            modulemethod.setProperty("source-location", "testing.scm:903");
            lambda$Fn11 = modulemethod;
        }
    }

    public class frame3 extends ModuleBody
    {

        final ModuleMethod lambda$Fn12;
        LList pred$Mnlist;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 9)
            {
                return lambda13(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda13(Object obj)
        {
            Boolean boolean1 = Boolean.TRUE;
            Object obj1 = pred$Mnlist;
            do
            {
                if (lists.isNull(obj1))
                {
                    return boolean1;
                }
                if (Scheme.applyToArgs.apply2(lists.car.apply1(obj1), obj) == Boolean.FALSE)
                {
                    boolean1 = Boolean.FALSE;
                }
                obj1 = lists.cdr.apply1(obj1);
            } while (true);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 9)
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
            ModuleMethod modulemethod = new ModuleMethod(this, 9, null, 4097);
            modulemethod.setProperty("source-location", "testing.scm:915");
            lambda$Fn12 = modulemethod;
        }
    }

    public class frame4 extends ModuleBody
    {

        final ModuleMethod lambda$Fn13;
        LList pred$Mnlist;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 10)
            {
                return lambda14(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda14(Object obj)
        {
            Boolean boolean1 = Boolean.FALSE;
            Object obj1 = pred$Mnlist;
            do
            {
                if (lists.isNull(obj1))
                {
                    return boolean1;
                }
                if (Scheme.applyToArgs.apply2(lists.car.apply1(obj1), obj) != Boolean.FALSE)
                {
                    boolean1 = Boolean.TRUE;
                }
                obj1 = lists.cdr.apply1(obj1);
            } while (true);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 10)
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
            ModuleMethod modulemethod = new ModuleMethod(this, 10, null, 4097);
            modulemethod.setProperty("source-location", "testing.scm:931");
            lambda$Fn13 = modulemethod;
        }
    }

    public class frame5 extends ModuleBody
    {

        final ModuleMethod lambda$Fn14;
        Object name;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 11)
            {
                if (lambda15(obj))
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

        boolean lambda15(Object obj)
        {
            return IsEqual.apply(name, testing.testRunnerTestName(obj));
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

        public frame5()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 11, null, 4097);
            modulemethod.setProperty("source-location", "testing.scm:971");
            lambda$Fn14 = modulemethod;
        }
    }


    public static final ModuleMethod $Pctest$Mnbegin;
    static final ModuleMethod $Pctest$Mnnull$Mncallback;
    public static final ModuleMethod $Prvt$$Pctest$Mnapproximimate$Eq;
    public static final ModuleMethod $Prvt$$Pctest$Mnas$Mnspecifier;
    public static final Macro $Prvt$$Pctest$Mncomp1body;
    public static final Macro $Prvt$$Pctest$Mncomp2body;
    public static final ModuleMethod $Prvt$$Pctest$Mnend;
    public static final Macro $Prvt$$Pctest$Mnerror;
    public static final Macro $Prvt$$Pctest$Mnevaluate$Mnwith$Mncatch;
    public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnall;
    public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnany;
    public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnnth;
    public static final ModuleMethod $Prvt$$Pctest$Mnon$Mntest$Mnbegin;
    public static final ModuleMethod $Prvt$$Pctest$Mnon$Mntest$Mnend;
    public static final ModuleMethod $Prvt$$Pctest$Mnreport$Mnresult;
    public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist;
    public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist$Ex;
    public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist;
    public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist$Ex;
    public static final ModuleMethod $Prvt$$Pctest$Mnshould$Mnexecute;
    public static final Macro $Prvt$test$Mngroup;
    public static final testing $instance;
    static final IntNum Lit0 = IntNum.make(0);
    static final SimpleSymbol Lit1 = (SimpleSymbol)(new SimpleSymbol("result-kind")).readResolve();
    static final PairWithPosition Lit10;
    static final SyntaxPattern Lit100 = new SyntaxPattern("<\f\007\f\017\f\027\b\f\037\b", new Object[0], 4);
    static final SyntaxTemplate Lit101;
    static final SyntaxPattern Lit102 = new SyntaxPattern(",\f\007\f\017\b\f\027\b", new Object[0], 3);
    static final SyntaxTemplate Lit103;
    static final SimpleSymbol Lit104;
    static final SyntaxTemplate Lit105 = new SyntaxTemplate("", "\030\004", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("eqv?")).readResolve()
    }, 0);
    static final SimpleSymbol Lit106;
    static final SyntaxTemplate Lit107 = new SyntaxTemplate("", "\030\004", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("eq?")).readResolve()
    }, 0);
    static final SimpleSymbol Lit108;
    static final SyntaxTemplate Lit109 = new SyntaxTemplate("", "\030\004", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("equal?")).readResolve()
    }, 0);
    static final PairWithPosition Lit11;
    static final SimpleSymbol Lit110;
    static final SyntaxPattern Lit111 = new SyntaxPattern("\\\f\007\f\017\f\027\f\037\f'\b\f/\b", new Object[0], 6);
    static final SyntaxTemplate Lit112;
    static final SyntaxPattern Lit113 = new SyntaxPattern("L\f\007\f\017\f\027\f\037\b\f'\b", new Object[0], 5);
    static final SyntaxTemplate Lit114;
    static final SimpleSymbol Lit115;
    static final SyntaxRules Lit116;
    static final SimpleSymbol Lit117;
    static final SyntaxPattern Lit118 = new SyntaxPattern("L\f\007\f\017\f\027\f\037\b\f'\b", new Object[0], 5);
    static final SyntaxTemplate Lit119;
    static final SimpleSymbol Lit12;
    static final SyntaxPattern Lit120 = new SyntaxPattern("<\f\007\f\017\f\027\b\f\037\b", new Object[0], 4);
    static final SyntaxTemplate Lit121;
    static final SyntaxPattern Lit122 = new SyntaxPattern(",\f\007\f\017\b\f\027\b", new Object[0], 3);
    static final SyntaxTemplate Lit123;
    static final SimpleSymbol Lit124;
    static final SimpleSymbol Lit125;
    static final SyntaxRules Lit126;
    static final SimpleSymbol Lit127;
    static final SimpleSymbol Lit128;
    static final SyntaxRules Lit129;
    static final IntNum Lit13;
    static final SimpleSymbol Lit130;
    static final SimpleSymbol Lit131;
    static final SyntaxRules Lit132;
    static final SimpleSymbol Lit133;
    static final SimpleSymbol Lit134;
    static final SyntaxRules Lit135;
    static final SimpleSymbol Lit136;
    static final SimpleSymbol Lit137;
    static final SyntaxRules Lit138;
    static final SimpleSymbol Lit139;
    static final SimpleSymbol Lit14;
    static final SyntaxRules Lit140;
    static final SimpleSymbol Lit141;
    static final SimpleSymbol Lit142;
    static final SimpleSymbol Lit143;
    static final SimpleSymbol Lit144;
    static final SimpleSymbol Lit145;
    static final SimpleSymbol Lit146;
    static final SimpleSymbol Lit147;
    static final SimpleSymbol Lit148;
    static final SimpleSymbol Lit149;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit150;
    static final SimpleSymbol Lit151;
    static final SimpleSymbol Lit152;
    static final SimpleSymbol Lit153;
    static final SimpleSymbol Lit154;
    static final SimpleSymbol Lit155;
    static final SimpleSymbol Lit156;
    static final SimpleSymbol Lit157;
    static final SimpleSymbol Lit158;
    static final SimpleSymbol Lit159;
    static final SyntaxPattern Lit16 = new SyntaxPattern("L\f\007\f\017\f\027\f\037\b\f'\f/\b", new Object[0], 6);
    static final SimpleSymbol Lit160;
    static final SimpleSymbol Lit161;
    static final SimpleSymbol Lit162;
    static final SimpleSymbol Lit163;
    static final SimpleSymbol Lit164;
    static final SimpleSymbol Lit165;
    static final SyntaxTemplate Lit17;
    static final SyntaxPattern Lit18 = new SyntaxPattern("<\f\007\f\017\f\027\b\f\037\f'\b", new Object[0], 5);
    static final SyntaxTemplate Lit19;
    static final SimpleSymbol Lit2 = (SimpleSymbol)(new SimpleSymbol("skip")).readResolve();
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit3 = (SimpleSymbol)(new SimpleSymbol("xfail")).readResolve();
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final SimpleSymbol Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit70;
    static final SyntaxRules Lit71;
    static final SimpleSymbol Lit72;
    static final SyntaxRules Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final SyntaxRules Lit76;
    static final SimpleSymbol Lit77;
    static final SimpleSymbol Lit78;
    static final SimpleSymbol Lit79;
    static final PairWithPosition Lit8;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final SimpleSymbol Lit82;
    static final SimpleSymbol Lit83;
    static final SimpleSymbol Lit84;
    static final SyntaxRules Lit85;
    static final SimpleSymbol Lit86;
    static final SimpleSymbol Lit87;
    static final SimpleSymbol Lit88;
    static final SimpleSymbol Lit89;
    static final SimpleSymbol Lit9;
    static final SyntaxRules Lit90;
    static final SimpleSymbol Lit91;
    static final SimpleSymbol Lit92;
    static final SyntaxRules Lit93;
    static final SimpleSymbol Lit94;
    static final SyntaxPattern Lit95 = new SyntaxPattern(",\f\007\f\017\b\f\027\b", new Object[0], 3);
    static final SyntaxTemplate Lit96;
    static final SyntaxPattern Lit97 = new SyntaxPattern("\034\f\007\b\f\017\b", new Object[0], 2);
    static final SyntaxTemplate Lit98;
    static final SimpleSymbol Lit99;
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn3;
    public static final ModuleMethod test$Mnapply;
    public static final Macro test$Mnapproximate;
    public static final Macro test$Mnassert;
    public static final Macro test$Mnend;
    public static final Macro test$Mneq;
    public static final Macro test$Mnequal;
    public static final Macro test$Mneqv;
    public static final Macro test$Mnerror;
    public static final Macro test$Mnexpect$Mnfail;
    public static final Macro test$Mngroup$Mnwith$Mncleanup;
    public static Boolean test$Mnlog$Mnto$Mnfile;
    public static final Macro test$Mnmatch$Mnall;
    public static final Macro test$Mnmatch$Mnany;
    public static final ModuleMethod test$Mnmatch$Mnname;
    public static final Macro test$Mnmatch$Mnnth;
    public static final ModuleMethod test$Mnon$Mnbad$Mncount$Mnsimple;
    public static final ModuleMethod test$Mnon$Mnbad$Mnend$Mnname$Mnsimple;
    public static final ModuleMethod test$Mnon$Mnfinal$Mnsimple;
    public static final ModuleMethod test$Mnon$Mngroup$Mnbegin$Mnsimple;
    public static final ModuleMethod test$Mnon$Mngroup$Mnend$Mnsimple;
    static final ModuleMethod test$Mnon$Mntest$Mnbegin$Mnsimple;
    public static final ModuleMethod test$Mnon$Mntest$Mnend$Mnsimple;
    public static final ModuleMethod test$Mnpassed$Qu;
    public static final ModuleMethod test$Mnread$Mneval$Mnstring;
    public static final ModuleMethod test$Mnresult$Mnalist;
    public static final ModuleMethod test$Mnresult$Mnalist$Ex;
    public static final ModuleMethod test$Mnresult$Mnclear;
    public static final ModuleMethod test$Mnresult$Mnkind;
    public static final Macro test$Mnresult$Mnref;
    public static final ModuleMethod test$Mnresult$Mnremove;
    public static final ModuleMethod test$Mnresult$Mnset$Ex;
    static final Class test$Mnrunner = gnu/kawa/slib/test$Mnrunner;
    public static final ModuleMethod test$Mnrunner$Mnaux$Mnvalue;
    public static final ModuleMethod test$Mnrunner$Mnaux$Mnvalue$Ex;
    public static final ModuleMethod test$Mnrunner$Mncreate;
    public static Object test$Mnrunner$Mncurrent;
    public static Object test$Mnrunner$Mnfactory;
    public static final ModuleMethod test$Mnrunner$Mnfail$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnfail$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mnget;
    public static final ModuleMethod test$Mnrunner$Mngroup$Mnpath;
    public static final ModuleMethod test$Mnrunner$Mngroup$Mnstack;
    public static final ModuleMethod test$Mnrunner$Mngroup$Mnstack$Ex;
    public static final ModuleMethod test$Mnrunner$Mnnull;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mnend$Mnname;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mnend$Mnname$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnfinal;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnfinal$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnbegin;
    public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnbegin$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnend;
    public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnend$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnbegin;
    public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnbegin$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnend;
    public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnend$Ex;
    public static final ModuleMethod test$Mnrunner$Mnpass$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnpass$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mnreset;
    public static final ModuleMethod test$Mnrunner$Mnsimple;
    public static final ModuleMethod test$Mnrunner$Mnskip$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnskip$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mntest$Mnname;
    public static final ModuleMethod test$Mnrunner$Mnxfail$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnxfail$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mnxpass$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnxpass$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Qu;
    public static final Macro test$Mnskip;
    public static final Macro test$Mnwith$Mnrunner;

    static Object $PcTestAnySpecifierMatches(Object obj, Object obj1)
    {
        Boolean boolean1 = Boolean.FALSE;
        do
        {
            if (lists.isNull(obj))
            {
                return boolean1;
            }
            if ($PcTestSpecificierMatches(lists.car.apply1(obj), obj1) != Boolean.FALSE)
            {
                boolean1 = Boolean.TRUE;
            }
            obj = lists.cdr.apply1(obj);
        } while (true);
    }

    public static Procedure $PcTestApproximimate$Eq(Object obj)
    {
        frame0 frame0_1 = new frame0();
        frame0_1.error = obj;
        return frame0_1.Fn4;
    }

    public static Object $PcTestAsSpecifier(Object obj)
    {
        if (misc.isProcedure(obj))
        {
            return obj;
        }
        if (numbers.isInteger(obj))
        {
            return $PcTestMatchNth(Lit13, obj);
        }
        if (strings.isString(obj))
        {
            return testMatchName(obj);
        } else
        {
            return misc.error$V("not a valid test specifier", new Object[0]);
        }
    }

    public static void $PcTestBegin(Object obj, Object obj1)
    {
        if (((Procedure)test$Mnrunner$Mncurrent).apply0() == Boolean.FALSE)
        {
            ((Procedure)test$Mnrunner$Mncurrent).apply1(testRunnerCreate());
        }
        Object obj2 = ((Procedure)test$Mnrunner$Mncurrent).apply0();
        Object obj3 = Scheme.applyToArgs;
        Object obj4;
        test.Mnrunner mnrunner;
        try
        {
            obj4 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "test-runner-on-group-begin", 0, obj2);
        }
        ((Procedure) (obj3)).apply4(testRunnerOnGroupBegin(((test.Mnrunner) (obj4))), obj2, obj, obj1);
        try
        {
            obj3 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-skip-save!", 0, obj2);
        }
        try
        {
            obj4 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-skip-list", 0, obj2);
        }
        obj4 = $PcTestRunnerSkipList(((test.Mnrunner) (obj4)));
        try
        {
            mnrunner = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-skip-save", 0, obj2);
        }
        $PcTestRunnerSkipSave$Ex(((test.Mnrunner) (obj3)), lists.cons(obj4, $PcTestRunnerSkipSave(mnrunner)));
        try
        {
            obj3 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-fail-save!", 0, obj2);
        }
        try
        {
            obj4 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-fail-list", 0, obj2);
        }
        obj4 = $PcTestRunnerFailList(((test.Mnrunner) (obj4)));
        try
        {
            mnrunner = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-fail-save", 0, obj2);
        }
        $PcTestRunnerFailSave$Ex(((test.Mnrunner) (obj3)), lists.cons(obj4, $PcTestRunnerFailSave(mnrunner)));
        try
        {
            obj3 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-count-list!", 0, obj2);
        }
        try
        {
            obj4 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-total-count", 0, obj2);
        }
        obj1 = lists.cons($PcTestRunnerTotalCount(((test.Mnrunner) (obj4))), obj1);
        try
        {
            obj4 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-count-list", 0, obj2);
        }
        $PcTestRunnerCountList$Ex(((test.Mnrunner) (obj3)), lists.cons(obj1, $PcTestRunnerCountList(((test.Mnrunner) (obj4)))));
        try
        {
            obj1 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "test-runner-group-stack!", 0, obj2);
        }
        try
        {
            obj3 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "test-runner-group-stack", 0, obj2);
        }
        testRunnerGroupStack$Ex(((test.Mnrunner) (obj1)), lists.cons(obj, testRunnerGroupStack(((test.Mnrunner) (obj3)))));
    }

    static Object $PcTestComp2(Object obj, Object obj1)
    {
        obj1 = LList.list3(obj1, LList.list2(Lit15, $PcTestSourceLine2(obj1)), obj);
        obj = ((Object) (SyntaxPattern.allocVars(6, null)));
        if (Lit16.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit17.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        }
        if (Lit18.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit19.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        } else
        {
            return syntax_case.error("syntax-case", obj1);
        }
    }

    public static Object $PcTestEnd(Object obj, Object obj1)
    {
        Object obj2 = testRunnerGet();
        Object obj3;
        Object obj4;
        test.Mnrunner mnrunner;
        try
        {
            obj3 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "test-runner-group-stack", 0, obj2);
        }
        obj3 = testRunnerGroupStack(((test.Mnrunner) (obj3)));
        obj4 = $PcTestFormatLine(obj2);
        try
        {
            mnrunner = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "test-result-alist!", 0, obj2);
        }
        testResultAlist$Ex(mnrunner, obj1);
        if (lists.isNull(obj3))
        {
            misc.error$V(strings.stringAppend(new Object[] {
                obj4, "test-end not in a group"
            }), new Object[0]);
        }
        if (obj == Boolean.FALSE ? obj != Boolean.FALSE : !IsEqual.apply(obj, lists.car.apply1(obj3)))
        {
            obj1 = Scheme.applyToArgs;
            Object obj5;
            test.Mnrunner mnrunner1;
            try
            {
                obj5 = (test.Mnrunner)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "test-runner-on-bad-end-name", 0, obj2);
            }
            ((Procedure) (obj1)).apply4(testRunnerOnBadEndName(((test.Mnrunner) (obj5))), obj2, obj, lists.car.apply1(obj3));
        }
        try
        {
            obj = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-count-list", 0, obj2);
        }
        obj = $PcTestRunnerCountList(((test.Mnrunner) (obj)));
        obj1 = lists.cdar.apply1(obj);
        obj3 = lists.caar.apply1(obj);
        obj5 = AddOp.$Mn;
        try
        {
            mnrunner1 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-total-count", 0, obj2);
        }
        obj3 = ((Procedure) (obj5)).apply2($PcTestRunnerTotalCount(mnrunner1), obj3);
        if (obj1 == Boolean.FALSE ? obj1 != Boolean.FALSE : Scheme.numEqu.apply2(obj1, obj3) == Boolean.FALSE)
        {
            obj5 = Scheme.applyToArgs;
            try
            {
                mnrunner1 = (test.Mnrunner)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "test-runner-on-bad-count", 0, obj2);
            }
            ((Procedure) (obj5)).apply4(testRunnerOnBadCount(mnrunner1), obj2, obj3, obj1);
        }
        obj1 = Scheme.applyToArgs;
        try
        {
            obj3 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "test-runner-on-group-end", 0, obj2);
        }
        ((Procedure) (obj1)).apply2(testRunnerOnGroupEnd(((test.Mnrunner) (obj3))), obj2);
        try
        {
            obj1 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "test-runner-group-stack!", 0, obj2);
        }
        obj3 = lists.cdr;
        try
        {
            obj5 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "test-runner-group-stack", 0, obj2);
        }
        testRunnerGroupStack$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj3)).apply1(testRunnerGroupStack(((test.Mnrunner) (obj5)))));
        try
        {
            obj1 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-skip-list!", 0, obj2);
        }
        obj3 = lists.car;
        try
        {
            obj5 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-skip-save", 0, obj2);
        }
        $PcTestRunnerSkipList$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj3)).apply1($PcTestRunnerSkipSave(((test.Mnrunner) (obj5)))));
        try
        {
            obj1 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-skip-save!", 0, obj2);
        }
        obj3 = lists.cdr;
        try
        {
            obj5 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-skip-save", 0, obj2);
        }
        $PcTestRunnerSkipSave$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj3)).apply1($PcTestRunnerSkipSave(((test.Mnrunner) (obj5)))));
        try
        {
            obj1 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-fail-list!", 0, obj2);
        }
        obj3 = lists.car;
        try
        {
            obj5 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-fail-save", 0, obj2);
        }
        $PcTestRunnerFailList$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj3)).apply1($PcTestRunnerFailSave(((test.Mnrunner) (obj5)))));
        try
        {
            obj1 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-fail-save!", 0, obj2);
        }
        obj3 = lists.cdr;
        try
        {
            obj5 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-fail-save", 0, obj2);
        }
        $PcTestRunnerFailSave$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj3)).apply1($PcTestRunnerFailSave(((test.Mnrunner) (obj5)))));
        try
        {
            obj1 = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%test-runner-count-list!", 0, obj2);
        }
        $PcTestRunnerCountList$Ex(((test.Mnrunner) (obj1)), lists.cdr.apply1(obj));
        try
        {
            obj = (test.Mnrunner)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "test-runner-group-stack", 0, obj2);
        }
        if (lists.isNull(testRunnerGroupStack(((test.Mnrunner) (obj)))))
        {
            obj = Scheme.applyToArgs;
            try
            {
                obj1 = (test.Mnrunner)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "test-runner-on-final", 0, obj2);
            }
            return ((Procedure) (obj)).apply2(testRunnerOnFinal(((test.Mnrunner) (obj1))), obj2);
        } else
        {
            return Values.empty;
        }
    }

    static void $PcTestFinalReport1(Object obj, Object obj1, Object obj2)
    {
        if (Scheme.numGrt.apply2(obj, Lit0) != Boolean.FALSE)
        {
            ports.display(obj1, obj2);
            ports.display(obj, obj2);
            ports.newline(obj2);
        }
    }

    static void $PcTestFinalReportSimple(Object obj, Object obj1)
    {
        test.Mnrunner mnrunner;
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-runner-pass-count", 0, obj);
        }
        $PcTestFinalReport1(testRunnerPassCount(mnrunner), "# of expected passes      ", obj1);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-runner-xfail-count", 0, obj);
        }
        $PcTestFinalReport1(testRunnerXfailCount(mnrunner), "# of expected failures    ", obj1);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-runner-xpass-count", 0, obj);
        }
        $PcTestFinalReport1(testRunnerXpassCount(mnrunner), "# of unexpected successes ", obj1);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-runner-fail-count", 0, obj);
        }
        $PcTestFinalReport1(testRunnerFailCount(mnrunner), "# of unexpected failures  ", obj1);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-runner-skip-count", 0, obj);
        }
        $PcTestFinalReport1(testRunnerSkipCount(mnrunner), "# of skipped tests        ", obj1);
    }

    static Object $PcTestFormatLine(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-result-alist", 0, obj);
        }
        obj1 = testResultAlist(((test.Mnrunner) (obj1)));
        obj = lists.assq(Lit4, obj1);
        obj1 = lists.assq(Lit5, obj1);
        if (obj != Boolean.FALSE)
        {
            obj = lists.cdr.apply1(obj);
        } else
        {
            obj = "";
        }
        if (obj1 != Boolean.FALSE)
        {
            obj1 = lists.cdr.apply1(obj1);
            Number number;
            try
            {
                number = (Number)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "number->string", 1, obj1);
            }
            return strings.stringAppend(new Object[] {
                obj, ":", numbers.number$To$String(number), ": "
            });
        } else
        {
            return "";
        }
    }

    public static Procedure $PcTestMatchAll$V(Object aobj[])
    {
        frame3 frame3_1 = new frame3();
        frame3_1.Mnlist = LList.makeList(aobj, 0);
        return frame3_1.Fn12;
    }

    public static Procedure $PcTestMatchAny$V(Object aobj[])
    {
        frame4 frame4_1 = new frame4();
        frame4_1.Mnlist = LList.makeList(aobj, 0);
        return frame4_1.Fn13;
    }

    public static Procedure $PcTestMatchNth(Object obj, Object obj1)
    {
        frame2 frame2_1 = new frame2();
        frame2_1.n = obj;
        frame2_1.count = obj1;
        frame2_1.i = Lit0;
        return frame2_1.Fn11;
    }

    static Boolean $PcTestNullCallback(Object obj)
    {
        return Boolean.FALSE;
    }

    static void $PcTestOnBadCountWrite(Object obj, Object obj1, Object obj2, Object obj3)
    {
        ports.display("*** Total number of tests was ", obj3);
        ports.display(obj1, obj3);
        ports.display(" but should be ", obj3);
        ports.display(obj2, obj3);
        ports.display(". ***", obj3);
        ports.newline(obj3);
        ports.display("*** Discrepancy indicates testsuite error or exceptions. ***", obj3);
        ports.newline(obj3);
    }

    public static boolean $PcTestOnTestBegin(Object obj)
    {
        $PcTestShouldExecute(obj);
        Object obj1 = Scheme.applyToArgs;
        Object obj2;
        test.Mnrunner mnrunner;
        int i;
        try
        {
            obj2 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-runner-on-test-begin", 0, obj);
        }
        ((Procedure) (obj1)).apply2(testRunnerOnTestBegin(((test.Mnrunner) (obj2))), obj);
        obj1 = Lit2;
        obj2 = Lit1;
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "test-result-alist", 0, obj);
        }
        obj = lists.assq(obj2, testResultAlist(mnrunner));
        if (obj != Boolean.FALSE)
        {
            obj = lists.cdr.apply1(obj);
        } else
        {
            obj = Boolean.FALSE;
        }
        if (obj1 == obj)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + 1 & 1;
    }

    public static Object $PcTestOnTestEnd(Object obj, Object obj1)
    {
        SimpleSymbol simplesymbol = Lit1;
        Object obj2 = Lit1;
        test.Mnrunner mnrunner;
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-result-alist", 0, obj);
        }
        obj2 = lists.assq(obj2, testResultAlist(mnrunner));
        if (obj2 != Boolean.FALSE)
        {
            obj2 = lists.cdr.apply1(obj2);
        } else
        {
            obj2 = Boolean.FALSE;
        }
        if (obj2 == Lit3)
        {
            if (obj1 != Boolean.FALSE)
            {
                obj1 = Lit9;
            } else
            {
                obj1 = Lit3;
            }
        } else
        if (obj1 != Boolean.FALSE)
        {
            obj1 = Lit12;
        } else
        {
            obj1 = Lit14;
        }
        return testResultSet$Ex(obj, simplesymbol, obj1);
    }

    public static Object $PcTestReportResult()
    {
        Object obj = testRunnerGet();
        Object obj1 = testResultKind$V(new Object[] {
            obj
        });
        if (Scheme.isEqv.apply2(obj1, Lit12) != Boolean.FALSE)
        {
            Object obj2;
            IntNum intnum;
            test.Mnrunner mnrunner;
            try
            {
                obj1 = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "test-runner-pass-count!", 0, obj);
            }
            obj2 = AddOp.$Pl;
            intnum = Lit13;
            try
            {
                mnrunner = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "test-runner-pass-count", 0, obj);
            }
            testRunnerPassCount$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj2)).apply2(intnum, testRunnerPassCount(mnrunner)));
        } else
        if (Scheme.isEqv.apply2(obj1, Lit14) != Boolean.FALSE)
        {
            try
            {
                obj1 = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception2)
            {
                throw new WrongType(classcastexception2, "test-runner-fail-count!", 0, obj);
            }
            obj2 = AddOp.$Pl;
            intnum = Lit13;
            try
            {
                mnrunner = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception3)
            {
                throw new WrongType(classcastexception3, "test-runner-fail-count", 0, obj);
            }
            testRunnerFailCount$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj2)).apply2(intnum, testRunnerFailCount(mnrunner)));
        } else
        if (Scheme.isEqv.apply2(obj1, Lit9) != Boolean.FALSE)
        {
            try
            {
                obj1 = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception4)
            {
                throw new WrongType(classcastexception4, "test-runner-xpass-count!", 0, obj);
            }
            obj2 = AddOp.$Pl;
            intnum = Lit13;
            try
            {
                mnrunner = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception5)
            {
                throw new WrongType(classcastexception5, "test-runner-xpass-count", 0, obj);
            }
            testRunnerXpassCount$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj2)).apply2(intnum, testRunnerXpassCount(mnrunner)));
        } else
        if (Scheme.isEqv.apply2(obj1, Lit3) != Boolean.FALSE)
        {
            try
            {
                obj1 = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception6)
            {
                throw new WrongType(classcastexception6, "test-runner-xfail-count!", 0, obj);
            }
            obj2 = AddOp.$Pl;
            intnum = Lit13;
            try
            {
                mnrunner = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception7)
            {
                throw new WrongType(classcastexception7, "test-runner-xfail-count", 0, obj);
            }
            testRunnerXfailCount$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj2)).apply2(intnum, testRunnerXfailCount(mnrunner)));
        } else
        {
            try
            {
                obj1 = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception8)
            {
                throw new WrongType(classcastexception8, "test-runner-skip-count!", 0, obj);
            }
            obj2 = AddOp.$Pl;
            intnum = Lit13;
            try
            {
                mnrunner = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception9)
            {
                throw new WrongType(classcastexception9, "test-runner-skip-count", 0, obj);
            }
            testRunnerSkipCount$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj2)).apply2(intnum, testRunnerSkipCount(mnrunner)));
        }
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception10)
        {
            throw new WrongType(classcastexception10, "%test-runner-total-count!", 0, obj);
        }
        obj2 = AddOp.$Pl;
        intnum = Lit13;
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception11)
        {
            throw new WrongType(classcastexception11, "%test-runner-total-count", 0, obj);
        }
        $PcTestRunnerTotalCount$Ex(((test.Mnrunner) (obj1)), ((Procedure) (obj2)).apply2(intnum, $PcTestRunnerTotalCount(mnrunner)));
        obj1 = Scheme.applyToArgs;
        try
        {
            obj2 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception12)
        {
            throw new WrongType(classcastexception12, "test-runner-on-test-end", 0, obj);
        }
        return ((Procedure) (obj1)).apply2(testRunnerOnTestEnd(((test.Mnrunner) (obj2))), obj);
    }

    static test.Mnrunner $PcTestRunnerAlloc()
    {
        return new test.Mnrunner();
    }

    static Object $PcTestRunnerCountList(test.Mnrunner mnrunner)
    {
        return mnrunner.count$Mnlist;
    }

    static void $PcTestRunnerCountList$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.count$Mnlist = obj;
    }

    public static Object $PcTestRunnerFailList(test.Mnrunner mnrunner)
    {
        return mnrunner.fail$Mnlist;
    }

    public static void $PcTestRunnerFailList$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.fail$Mnlist = obj;
    }

    static Object $PcTestRunnerFailSave(test.Mnrunner mnrunner)
    {
        return mnrunner.fail$Mnsave;
    }

    static void $PcTestRunnerFailSave$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.fail$Mnsave = obj;
    }

    static Object $PcTestRunnerRunList(test.Mnrunner mnrunner)
    {
        return mnrunner.run$Mnlist;
    }

    static void $PcTestRunnerRunList$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.run$Mnlist = obj;
    }

    public static Object $PcTestRunnerSkipList(test.Mnrunner mnrunner)
    {
        return mnrunner.skip$Mnlist;
    }

    public static void $PcTestRunnerSkipList$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.skip$Mnlist = obj;
    }

    static Object $PcTestRunnerSkipSave(test.Mnrunner mnrunner)
    {
        return mnrunner.skip$Mnsave;
    }

    static void $PcTestRunnerSkipSave$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.skip$Mnsave = obj;
    }

    static Object $PcTestRunnerTotalCount(test.Mnrunner mnrunner)
    {
        return mnrunner.total$Mncount;
    }

    static void $PcTestRunnerTotalCount$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.total$Mncount = obj;
    }

    public static Object $PcTestShouldExecute(Object obj)
    {
        Object obj1;
        int i;
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "%test-runner-run-list", 0, obj);
        }
        obj1 = $PcTestRunnerRunList(((test.Mnrunner) (obj1)));
        if (obj1 == Boolean.TRUE)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            obj1 = $PcTestAnySpecifierMatches(obj1, obj);
            Boolean boolean1;
            try
            {
                boolean1 = Boolean.FALSE;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "x", -2, obj1);
            }
            if (obj1 != boolean1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        }
        i = i + 1 & 1;
        if (i == 0) goto _L2; else goto _L1
_L1:
        if (i == 0) goto _L4; else goto _L3
_L3:
        testResultSet$Ex(obj, Lit1, Lit2);
        return Boolean.FALSE;
_L2:
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "%test-runner-skip-list", 0, obj);
        }
        if ($PcTestAnySpecifierMatches($PcTestRunnerSkipList(((test.Mnrunner) (obj1))), obj) != Boolean.FALSE) goto _L3; else goto _L4
_L4:
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "%test-runner-fail-list", 0, obj);
        }
        if ($PcTestAnySpecifierMatches($PcTestRunnerFailList(((test.Mnrunner) (obj1))), obj) != Boolean.FALSE)
        {
            testResultSet$Ex(obj, Lit1, Lit3);
            return Lit3;
        } else
        {
            return Boolean.TRUE;
        }
    }

    static Pair $PcTestSourceLine2(Object obj)
    {
        Object obj1 = std_syntax.syntaxLine(obj);
        Object obj2 = $PcTestSyntaxFile(obj);
        Pair pair;
        if (obj1 != Boolean.FALSE)
        {
            obj1 = LList.list1(lists.cons(Lit5, obj1));
        } else
        {
            obj1 = LList.Empty;
        }
        pair = lists.cons(Lit6, std_syntax.syntaxObject$To$Datum(obj));
        obj = obj1;
        if (obj2 != Boolean.FALSE)
        {
            obj = lists.cons(lists.cons(Lit4, obj2), obj1);
        }
        return lists.cons(pair, obj);
    }

    static Object $PcTestSpecificierMatches(Object obj, Object obj1)
    {
        return Scheme.applyToArgs.apply2(obj, obj1);
    }

    static Object $PcTestSyntaxFile(Object obj)
    {
        return std_syntax.syntaxSource(obj);
    }

    static Object $PcTestWriteResult1(Object obj, Object obj1)
    {
        ports.display("  ", obj1);
        ports.display(lists.car.apply1(obj), obj1);
        ports.display(": ", obj1);
        ports.write(lists.cdr.apply1(obj), obj1);
        ports.newline(obj1);
        return Values.empty;
    }

    public testing()
    {
        ModuleInfo.register(this);
    }

    public static Object isTestPassed$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        SimpleSymbol simplesymbol;
        test.Mnrunner mnrunner;
        if (lists.isPair(((Object) (aobj))))
        {
            aobj = ((Object []) (lists.car.apply1(((Object) (aobj)))));
        } else
        {
            aobj = ((Object []) (testRunnerGet()));
        }
        simplesymbol = Lit1;
        try
        {
            mnrunner = (test.Mnrunner)aobj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-result-alist", 0, ((Object) (aobj)));
        }
        aobj = ((Object []) (lists.assq(simplesymbol, testResultAlist(mnrunner))));
        if (aobj != Boolean.FALSE)
        {
            aobj = ((Object []) (lists.cdr.apply1(((Object) (aobj)))));
        } else
        {
            aobj = Boolean.FALSE;
        }
        return lists.memq(((Object) (aobj)), Lit11);
    }

    public static boolean isTestRunner(Object obj)
    {
        return obj instanceof test.Mnrunner;
    }

    static Boolean lambda1(Object obj, Object obj1, Object obj2)
    {
        return Boolean.FALSE;
    }

    static Object lambda16(Object obj)
    {
        Object obj1 = LList.list2(obj, LList.list2(Lit15, $PcTestSourceLine2(obj)));
        obj = ((Object) (SyntaxPattern.allocVars(3, null)));
        if (Lit95.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit96.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        }
        if (Lit97.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit98.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        } else
        {
            return syntax_case.error("syntax-case", obj1);
        }
    }

    static Object lambda17(Object obj)
    {
        Object obj1 = LList.list2(obj, LList.list2(Lit15, $PcTestSourceLine2(obj)));
        obj = ((Object) (SyntaxPattern.allocVars(4, null)));
        if (Lit100.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit101.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        }
        if (Lit102.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit103.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        } else
        {
            return syntax_case.error("syntax-case", obj1);
        }
    }

    static Object lambda18(Object obj)
    {
        TemplateScope templatescope = TemplateScope.make();
        return $PcTestComp2(Lit105.execute(null, templatescope), obj);
    }

    static Object lambda19(Object obj)
    {
        TemplateScope templatescope = TemplateScope.make();
        return $PcTestComp2(Lit107.execute(null, templatescope), obj);
    }

    static Boolean lambda2(Object obj, Object obj1, Object obj2)
    {
        return Boolean.FALSE;
    }

    static Object lambda20(Object obj)
    {
        TemplateScope templatescope = TemplateScope.make();
        return $PcTestComp2(Lit109.execute(null, templatescope), obj);
    }

    static Object lambda21(Object obj)
    {
        Object obj1 = LList.list2(obj, LList.list2(Lit15, $PcTestSourceLine2(obj)));
        obj = ((Object) (SyntaxPattern.allocVars(6, null)));
        if (Lit111.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit112.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        }
        if (Lit113.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit114.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        } else
        {
            return syntax_case.error("syntax-case", obj1);
        }
    }

    static Object lambda22(Object obj)
    {
        Object obj1 = LList.list2(obj, LList.list2(Lit15, $PcTestSourceLine2(obj)));
        obj = ((Object) (SyntaxPattern.allocVars(5, null)));
        if (Lit118.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit119.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        }
        if (Lit120.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit121.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        }
        if (Lit122.match(obj1, ((Object []) (obj)), 0))
        {
            obj1 = TemplateScope.make();
            return Lit123.execute(((Object []) (obj)), ((TemplateScope) (obj1)));
        } else
        {
            return syntax_case.error("syntax-case", obj1);
        }
    }

    static Boolean lambda3(Object obj, Object obj1, Object obj2)
    {
        return Boolean.FALSE;
    }

    public static Object testApply$V(Object obj, Object aobj[])
    {
        frame1 frame1_1 = new frame1();
        frame1_1.first = obj;
        frame1_1.rest = LList.makeList(aobj, 0);
        if (isTestRunner(frame1_1.first))
        {
            frame1_1._fld1 = ((Procedure)test$Mnrunner$Mncurrent).apply0();
            return misc.dynamicWind(frame1_1.Fn5, frame1_1.Fn6, frame1_1.Fn7);
        }
        aobj = ((Object []) (((Procedure)test$Mnrunner$Mncurrent).apply0()));
        if (aobj != Boolean.FALSE)
        {
            Object obj1;
            try
            {
                obj = (test.Mnrunner)aobj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "%test-runner-run-list", 0, ((Object) (aobj)));
            }
            obj1 = $PcTestRunnerRunList(((test.Mnrunner) (obj)));
            if (lists.isNull(frame1_1.rest))
            {
                test.Mnrunner mnrunner;
                try
                {
                    obj = (test.Mnrunner)aobj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "%test-runner-run-list!", 0, ((Object) (aobj)));
                }
                try
                {
                    aobj = (LList)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "reverse!", 1, obj1);
                }
                $PcTestRunnerRunList$Ex(((test.Mnrunner) (obj)), lists.reverse$Ex(((LList) (aobj))));
                return Scheme.applyToArgs.apply1(frame1_1.first);
            }
            try
            {
                mnrunner = (test.Mnrunner)aobj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "%test-runner-run-list!", 0, ((Object) (aobj)));
            }
            if (obj1 == Boolean.TRUE)
            {
                obj = LList.list1(frame1_1.first);
            } else
            {
                obj = lists.cons(frame1_1.first, obj1);
            }
            $PcTestRunnerRunList$Ex(mnrunner, obj);
            Scheme.apply.apply2(test$Mnapply, frame1_1.rest);
            try
            {
                obj = (test.Mnrunner)aobj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "%test-runner-run-list!", 0, ((Object) (aobj)));
            }
            $PcTestRunnerRunList$Ex(((test.Mnrunner) (obj)), obj1);
            return Values.empty;
        }
        frame1_1.r = testRunnerCreate();
        frame1_1.Mnrunner = ((Procedure)test$Mnrunner$Mncurrent).apply0();
        misc.dynamicWind(frame1_1.Fn8, frame1_1.Fn9, frame1_1.Fn10);
        aobj = Scheme.applyToArgs;
        obj = frame1_1.r;
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new WrongType(((ClassCastException) (aobj)), "test-runner-on-final", 0, obj);
        }
        return ((Procedure) (aobj)).apply2(testRunnerOnFinal(((test.Mnrunner) (obj1))), frame1_1.r);
    }

    public static Procedure testMatchName(Object obj)
    {
        frame5 frame5_1 = new frame5();
        frame5_1.name = obj;
        return frame5_1.Fn14;
    }

    public static void testOnBadCountSimple(Object obj, Object obj1, Object obj2)
    {
        $PcTestOnBadCountWrite(obj, obj1, obj2, ports.current$Mnoutput$Mnport.apply0());
        Object obj3;
        try
        {
            obj3 = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-runner-aux-value", 0, obj);
        }
        obj3 = testRunnerAuxValue(((test.Mnrunner) (obj3)));
        if (ports.isOutputPort(obj3))
        {
            $PcTestOnBadCountWrite(obj, obj1, obj2, obj3);
        }
    }

    public static Object testOnBadEndNameSimple(Object obj, Object obj1, Object obj2)
    {
        return misc.error$V(strings.stringAppend(new Object[] {
            $PcTestFormatLine(obj), "test-end ", obj1, " does not match test-begin ", obj2
        }), new Object[0]);
    }

    public static void testOnFinalSimple(Object obj)
    {
        $PcTestFinalReportSimple(obj, ports.current$Mnoutput$Mnport.apply0());
        Object obj1;
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-runner-aux-value", 0, obj);
        }
        obj1 = testRunnerAuxValue(((test.Mnrunner) (obj1)));
        if (ports.isOutputPort(obj1))
        {
            $PcTestFinalReportSimple(obj, obj1);
        }
    }

    public static Boolean testOnGroupBeginSimple(Object obj, Object obj1, Object obj2)
    {
        try
        {
            obj2 = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-runner-group-stack", 0, obj);
        }
        if (lists.isNull(testRunnerGroupStack(((test.Mnrunner) (obj2)))))
        {
            ports.display("%%%% Starting test ");
            ports.display(obj1);
            Object obj3;
            test.Mnrunner mnrunner;
            if (strings.isString(Boolean.TRUE))
            {
                obj2 = Boolean.TRUE;
            } else
            {
                obj2 = strings.stringAppend(new Object[] {
                    obj1, ".log"
                });
            }
            try
            {
                obj3 = Path.valueOf(obj2);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "open-output-file", 1, obj2);
            }
            obj3 = ports.openOutputFile(((Path) (obj3)));
            ports.display("%%%% Starting test ", obj3);
            ports.display(obj1, obj3);
            ports.newline(obj3);
            try
            {
                mnrunner = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "test-runner-aux-value!", 0, obj);
            }
            testRunnerAuxValue$Ex(mnrunner, obj3);
            ports.display("  (Writing full log to \"");
            ports.display(obj2);
            ports.display("\")");
            ports.newline();
        }
        try
        {
            obj2 = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-runner-aux-value", 0, obj);
        }
        obj = testRunnerAuxValue(((test.Mnrunner) (obj2)));
        if (ports.isOutputPort(obj))
        {
            ports.display("Group begin: ", obj);
            ports.display(obj1, obj);
            ports.newline(obj);
        }
        return Boolean.FALSE;
    }

    public static Boolean testOnGroupEndSimple(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-runner-aux-value", 0, obj);
        }
        obj1 = testRunnerAuxValue(((test.Mnrunner) (obj1)));
        if (ports.isOutputPort(obj1))
        {
            ports.display("Group end: ", obj1);
            gnu.expr.GenericProc genericproc = lists.car;
            test.Mnrunner mnrunner;
            try
            {
                mnrunner = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "test-runner-group-stack", 0, obj);
            }
            ports.display(genericproc.apply1(testRunnerGroupStack(mnrunner)), obj1);
            ports.newline(obj1);
        }
        return Boolean.FALSE;
    }

    static Object testOnTestBeginSimple(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-runner-aux-value", 0, obj);
        }
        obj1 = testRunnerAuxValue(((test.Mnrunner) (obj1)));
        if (ports.isOutputPort(obj1))
        {
            Object obj2;
            Object obj3;
            Object obj4;
            try
            {
                obj2 = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "test-result-alist", 0, obj);
            }
            obj4 = testResultAlist(((test.Mnrunner) (obj2)));
            obj = lists.assq(Lit4, obj4);
            obj2 = lists.assq(Lit5, obj4);
            obj3 = lists.assq(Lit6, obj4);
            obj4 = lists.assq(Lit7, obj4);
            ports.display("Test begin:", obj1);
            ports.newline(obj1);
            if (obj4 != Boolean.FALSE)
            {
                $PcTestWriteResult1(obj4, obj1);
            }
            if (obj != Boolean.FALSE)
            {
                $PcTestWriteResult1(obj, obj1);
            }
            if (obj2 != Boolean.FALSE)
            {
                $PcTestWriteResult1(obj2, obj1);
            }
            if (obj != Boolean.FALSE)
            {
                return $PcTestWriteResult1(obj3, obj1);
            } else
            {
                return Values.empty;
            }
        } else
        {
            return Values.empty;
        }
    }

    public static Object testOnTestEndSimple(Object obj)
    {
        Object obj1;
        Object obj2;
        test.Mnrunner mnrunner;
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-runner-aux-value", 0, obj);
        }
        obj2 = testRunnerAuxValue(((test.Mnrunner) (obj1)));
        obj1 = Lit1;
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "test-result-alist", 0, obj);
        }
        obj1 = lists.assq(obj1, testResultAlist(mnrunner));
        if (obj1 != Boolean.FALSE)
        {
            obj1 = lists.cdr.apply1(obj1);
        } else
        {
            obj1 = Boolean.FALSE;
        }
        if (lists.memq(obj1, Lit8) != Boolean.FALSE)
        {
            Object obj3;
            Object obj4;
            Object obj5;
            try
            {
                obj3 = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception2)
            {
                throw new WrongType(classcastexception2, "test-result-alist", 0, obj);
            }
            obj3 = testResultAlist(((test.Mnrunner) (obj3)));
            obj4 = lists.assq(Lit4, obj3);
            obj5 = lists.assq(Lit5, obj3);
            obj3 = lists.assq(Lit7, obj3);
            if (obj4 != Boolean.FALSE || obj5 != Boolean.FALSE)
            {
                if (obj4 != Boolean.FALSE)
                {
                    ports.display(lists.cdr.apply1(obj4));
                }
                ports.display(":");
                if (obj5 != Boolean.FALSE)
                {
                    ports.display(lists.cdr.apply1(obj5));
                }
                ports.display(": ");
            }
            if (obj1 == Lit9)
            {
                obj1 = "XPASS";
            } else
            {
                obj1 = "FAIL";
            }
            ports.display(obj1);
            if (obj3 != Boolean.FALSE)
            {
                ports.display(" ");
                ports.display(lists.cdr.apply1(obj3));
            }
            ports.newline();
        }
        if (ports.isOutputPort(obj2))
        {
            ports.display("Test end:", obj2);
            ports.newline(obj2);
            try
            {
                obj1 = (test.Mnrunner)obj;
            }
            catch (ClassCastException classcastexception3)
            {
                throw new WrongType(classcastexception3, "test-result-alist", 0, obj);
            }
            for (obj = testResultAlist(((test.Mnrunner) (obj1))); lists.isPair(obj); obj = lists.cdr.apply1(obj))
            {
                obj1 = lists.car.apply1(obj);
                if (lists.memq(lists.car.apply1(obj1), Lit10) == Boolean.FALSE)
                {
                    $PcTestWriteResult1(obj1, obj2);
                }
            }

            return Values.empty;
        } else
        {
            return Values.empty;
        }
    }

    public static Object testReadEvalString(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = (CharSequence)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "open-input-string", 1, obj);
        }
        obj = ports.openInputString(((CharSequence) (obj1)));
        obj1 = ports.read(((gnu.mapping.InPort) (obj)));
        if (ports.isEofObject(readchar.readChar.apply1(obj)))
        {
            return Eval.eval.apply1(obj1);
        } else
        {
            return misc.error$V("(not at eof)", new Object[0]);
        }
    }

    public static Object testResultAlist(test.Mnrunner mnrunner)
    {
        return mnrunner.result$Mnalist;
    }

    public static void testResultAlist$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.result$Mnalist = obj;
    }

    public static void testResultClear(Object obj)
    {
        test.Mnrunner mnrunner;
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-result-alist!", 0, obj);
        }
        testResultAlist$Ex(mnrunner, LList.Empty);
    }

    public static Object testResultKind$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        SimpleSymbol simplesymbol;
        test.Mnrunner mnrunner;
        if (lists.isPair(((Object) (aobj))))
        {
            aobj = ((Object []) (lists.car.apply1(((Object) (aobj)))));
        } else
        {
            aobj = ((Object []) (((Procedure)test$Mnrunner$Mncurrent).apply0()));
        }
        simplesymbol = Lit1;
        try
        {
            mnrunner = (test.Mnrunner)aobj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-result-alist", 0, ((Object) (aobj)));
        }
        aobj = ((Object []) (lists.assq(simplesymbol, testResultAlist(mnrunner))));
        if (aobj != Boolean.FALSE)
        {
            return lists.cdr.apply1(((Object) (aobj)));
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static void testResultRemove(Object obj, Object obj1)
    {
        frame frame6 = new frame();
        Object obj2;
        try
        {
            obj2 = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-result-alist", 0, obj);
        }
        obj2 = testResultAlist(((test.Mnrunner) (obj2)));
        frame6.p = lists.assq(obj1, obj2);
        if (frame6.p != Boolean.FALSE)
        {
            try
            {
                obj1 = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "test-result-alist!", 0, obj);
            }
            testResultAlist$Ex(((test.Mnrunner) (obj1)), frame6.lambda4loop(obj2));
        }
    }

    public static Object testResultSet$Ex(Object obj, Object obj1, Object obj2)
    {
        Object obj3;
        Object obj4;
        try
        {
            obj3 = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-result-alist", 0, obj);
        }
        obj4 = testResultAlist(((test.Mnrunner) (obj3)));
        obj3 = lists.assq(obj1, obj4);
        if (obj3 != Boolean.FALSE)
        {
            try
            {
                obj = (Pair)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, obj3);
            }
            lists.setCdr$Ex(((Pair) (obj)), obj2);
            return Values.empty;
        }
        try
        {
            obj3 = (test.Mnrunner)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "test-result-alist!", 0, obj);
        }
        testResultAlist$Ex(((test.Mnrunner) (obj3)), lists.cons(lists.cons(obj1, obj2), obj4));
        return Values.empty;
    }

    public static Object testRunnerAuxValue(test.Mnrunner mnrunner)
    {
        return mnrunner.aux$Mnvalue;
    }

    public static void testRunnerAuxValue$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.aux$Mnvalue = obj;
    }

    public static Object testRunnerCreate()
    {
        return Scheme.applyToArgs.apply1(((Procedure)test$Mnrunner$Mnfactory).apply0());
    }

    public static Object testRunnerFailCount(test.Mnrunner mnrunner)
    {
        return mnrunner.fail$Mncount;
    }

    public static void testRunnerFailCount$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.fail$Mncount = obj;
    }

    public static Object testRunnerGet()
    {
        Object obj = ((Procedure)test$Mnrunner$Mncurrent).apply0();
        if (obj == Boolean.FALSE)
        {
            misc.error$V("test-runner not initialized - test-begin missing?", new Object[0]);
        }
        return obj;
    }

    public static LList testRunnerGroupPath(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-runner-group-stack", 0, obj);
        }
        obj = testRunnerGroupStack(((test.Mnrunner) (obj1)));
        try
        {
            obj1 = (LList)obj;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "reverse", 1, obj);
        }
        return lists.reverse(((LList) (obj1)));
    }

    public static Object testRunnerGroupStack(test.Mnrunner mnrunner)
    {
        return mnrunner.group$Mnstack;
    }

    public static void testRunnerGroupStack$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.group$Mnstack = obj;
    }

    public static test.Mnrunner testRunnerNull()
    {
        test.Mnrunner mnrunner = $PcTestRunnerAlloc();
        testRunnerReset(mnrunner);
        testRunnerOnGroupBegin$Ex(mnrunner, lambda$Fn1);
        testRunnerOnGroupEnd$Ex(mnrunner, $Pctest$Mnnull$Mncallback);
        testRunnerOnFinal$Ex(mnrunner, $Pctest$Mnnull$Mncallback);
        testRunnerOnTestBegin$Ex(mnrunner, $Pctest$Mnnull$Mncallback);
        testRunnerOnTestEnd$Ex(mnrunner, $Pctest$Mnnull$Mncallback);
        testRunnerOnBadCount$Ex(mnrunner, lambda$Fn2);
        testRunnerOnBadEndName$Ex(mnrunner, lambda$Fn3);
        return mnrunner;
    }

    public static Object testRunnerOnBadCount(test.Mnrunner mnrunner)
    {
        return mnrunner.on$Mnbad$Mncount;
    }

    public static void testRunnerOnBadCount$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.on$Mnbad$Mncount = obj;
    }

    public static Object testRunnerOnBadEndName(test.Mnrunner mnrunner)
    {
        return mnrunner.on$Mnbad$Mnend$Mnname;
    }

    public static void testRunnerOnBadEndName$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.on$Mnbad$Mnend$Mnname = obj;
    }

    public static Object testRunnerOnFinal(test.Mnrunner mnrunner)
    {
        return mnrunner.on$Mnfinal;
    }

    public static void testRunnerOnFinal$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.on$Mnfinal = obj;
    }

    public static Object testRunnerOnGroupBegin(test.Mnrunner mnrunner)
    {
        return mnrunner.on$Mngroup$Mnbegin;
    }

    public static void testRunnerOnGroupBegin$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.on$Mngroup$Mnbegin = obj;
    }

    public static Object testRunnerOnGroupEnd(test.Mnrunner mnrunner)
    {
        return mnrunner.on$Mngroup$Mnend;
    }

    public static void testRunnerOnGroupEnd$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.on$Mngroup$Mnend = obj;
    }

    public static Object testRunnerOnTestBegin(test.Mnrunner mnrunner)
    {
        return mnrunner.on$Mntest$Mnbegin;
    }

    public static void testRunnerOnTestBegin$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.on$Mntest$Mnbegin = obj;
    }

    public static Object testRunnerOnTestEnd(test.Mnrunner mnrunner)
    {
        return mnrunner.on$Mntest$Mnend;
    }

    public static void testRunnerOnTestEnd$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.on$Mntest$Mnend = obj;
    }

    public static Object testRunnerPassCount(test.Mnrunner mnrunner)
    {
        return mnrunner.pass$Mncount;
    }

    public static void testRunnerPassCount$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.pass$Mncount = obj;
    }

    public static void testRunnerReset(Object obj)
    {
        test.Mnrunner mnrunner;
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-result-alist!", 0, obj);
        }
        testResultAlist$Ex(mnrunner, LList.Empty);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "test-runner-pass-count!", 0, obj);
        }
        testRunnerPassCount$Ex(mnrunner, Lit0);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception2)
        {
            throw new WrongType(classcastexception2, "test-runner-fail-count!", 0, obj);
        }
        testRunnerFailCount$Ex(mnrunner, Lit0);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception3)
        {
            throw new WrongType(classcastexception3, "test-runner-xpass-count!", 0, obj);
        }
        testRunnerXpassCount$Ex(mnrunner, Lit0);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception4)
        {
            throw new WrongType(classcastexception4, "test-runner-xfail-count!", 0, obj);
        }
        testRunnerXfailCount$Ex(mnrunner, Lit0);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception5)
        {
            throw new WrongType(classcastexception5, "test-runner-skip-count!", 0, obj);
        }
        testRunnerSkipCount$Ex(mnrunner, Lit0);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception6)
        {
            throw new WrongType(classcastexception6, "%test-runner-total-count!", 0, obj);
        }
        $PcTestRunnerTotalCount$Ex(mnrunner, Lit0);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception7)
        {
            throw new WrongType(classcastexception7, "%test-runner-count-list!", 0, obj);
        }
        $PcTestRunnerCountList$Ex(mnrunner, LList.Empty);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception8)
        {
            throw new WrongType(classcastexception8, "%test-runner-run-list!", 0, obj);
        }
        $PcTestRunnerRunList$Ex(mnrunner, Boolean.TRUE);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception9)
        {
            throw new WrongType(classcastexception9, "%test-runner-skip-list!", 0, obj);
        }
        $PcTestRunnerSkipList$Ex(mnrunner, LList.Empty);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception10)
        {
            throw new WrongType(classcastexception10, "%test-runner-fail-list!", 0, obj);
        }
        $PcTestRunnerFailList$Ex(mnrunner, LList.Empty);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception11)
        {
            throw new WrongType(classcastexception11, "%test-runner-skip-save!", 0, obj);
        }
        $PcTestRunnerSkipSave$Ex(mnrunner, LList.Empty);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception12)
        {
            throw new WrongType(classcastexception12, "%test-runner-fail-save!", 0, obj);
        }
        $PcTestRunnerFailSave$Ex(mnrunner, LList.Empty);
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception13)
        {
            throw new WrongType(classcastexception13, "test-runner-group-stack!", 0, obj);
        }
        testRunnerGroupStack$Ex(mnrunner, LList.Empty);
    }

    public static test.Mnrunner testRunnerSimple()
    {
        test.Mnrunner mnrunner = $PcTestRunnerAlloc();
        testRunnerReset(mnrunner);
        testRunnerOnGroupBegin$Ex(mnrunner, test$Mnon$Mngroup$Mnbegin$Mnsimple);
        testRunnerOnGroupEnd$Ex(mnrunner, test$Mnon$Mngroup$Mnend$Mnsimple);
        testRunnerOnFinal$Ex(mnrunner, test$Mnon$Mnfinal$Mnsimple);
        testRunnerOnTestBegin$Ex(mnrunner, test$Mnon$Mntest$Mnbegin$Mnsimple);
        testRunnerOnTestEnd$Ex(mnrunner, test$Mnon$Mntest$Mnend$Mnsimple);
        testRunnerOnBadCount$Ex(mnrunner, test$Mnon$Mnbad$Mncount$Mnsimple);
        testRunnerOnBadEndName$Ex(mnrunner, test$Mnon$Mnbad$Mnend$Mnname$Mnsimple);
        return mnrunner;
    }

    public static Object testRunnerSkipCount(test.Mnrunner mnrunner)
    {
        return mnrunner.skip$Mncount;
    }

    public static void testRunnerSkipCount$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.skip$Mncount = obj;
    }

    public static Object testRunnerTestName(Object obj)
    {
        SimpleSymbol simplesymbol = Lit7;
        test.Mnrunner mnrunner;
        try
        {
            mnrunner = (test.Mnrunner)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "test-result-alist", 0, obj);
        }
        obj = lists.assq(simplesymbol, testResultAlist(mnrunner));
        if (obj != Boolean.FALSE)
        {
            return lists.cdr.apply1(obj);
        } else
        {
            return "";
        }
    }

    public static Object testRunnerXfailCount(test.Mnrunner mnrunner)
    {
        return mnrunner.xfail$Mncount;
    }

    public static void testRunnerXfailCount$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.xfail$Mncount = obj;
    }

    public static Object testRunnerXpassCount(test.Mnrunner mnrunner)
    {
        return mnrunner.xpass$Mncount;
    }

    public static void testRunnerXpassCount$Ex(test.Mnrunner mnrunner, Object obj)
    {
        mnrunner.xpass$Mncount = obj;
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply0(modulemethod);

        case 53: // '5'
            return testRunnerNull();

        case 54: // '6'
            return testRunnerSimple();

        case 55: // '7'
            return testRunnerGet();

        case 56: // '8'
            return testRunnerCreate();

        case 72: // 'H'
            return $PcTestReportResult();
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 14: // '\016'
        case 16: // '\020'
        case 18: // '\022'
        case 20: // '\024'
        case 22: // '\026'
        case 24: // '\030'
        case 26: // '\032'
        case 28: // '\034'
        case 30: // '\036'
        case 32: // ' '
        case 34: // '"'
        case 36: // '$'
        case 38: // '&'
        case 40: // '('
        case 42: // '*'
        case 44: // ','
        case 46: // '.'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 58: // ':'
        case 59: // ';'
        case 61: // '='
        case 62: // '>'
        case 64: // '@'
        case 67: // 'C'
        case 69: // 'E'
        case 70: // 'F'
        case 71: // 'G'
        case 72: // 'H'
        case 74: // 'J'
        case 84: // 'T'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        default:
            return super.apply1(modulemethod, obj);

        case 12: // '\f'
            if (isTestRunner(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 13: // '\r'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-pass-count", 1, obj);
            }
            return testRunnerPassCount(modulemethod);

        case 15: // '\017'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-fail-count", 1, obj);
            }
            return testRunnerFailCount(modulemethod);

        case 17: // '\021'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-xpass-count", 1, obj);
            }
            return testRunnerXpassCount(modulemethod);

        case 19: // '\023'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-xfail-count", 1, obj);
            }
            return testRunnerXfailCount(modulemethod);

        case 21: // '\025'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-skip-count", 1, obj);
            }
            return testRunnerSkipCount(modulemethod);

        case 23: // '\027'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "%test-runner-skip-list", 1, obj);
            }
            return $PcTestRunnerSkipList(modulemethod);

        case 25: // '\031'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "%test-runner-fail-list", 1, obj);
            }
            return $PcTestRunnerFailList(modulemethod);

        case 27: // '\033'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-group-stack", 1, obj);
            }
            return testRunnerGroupStack(modulemethod);

        case 29: // '\035'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-test-begin", 1, obj);
            }
            return testRunnerOnTestBegin(modulemethod);

        case 31: // '\037'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-test-end", 1, obj);
            }
            return testRunnerOnTestEnd(modulemethod);

        case 33: // '!'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-group-begin", 1, obj);
            }
            return testRunnerOnGroupBegin(modulemethod);

        case 35: // '#'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-group-end", 1, obj);
            }
            return testRunnerOnGroupEnd(modulemethod);

        case 37: // '%'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-final", 1, obj);
            }
            return testRunnerOnFinal(modulemethod);

        case 39: // '\''
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-bad-count", 1, obj);
            }
            return testRunnerOnBadCount(modulemethod);

        case 41: // ')'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-bad-end-name", 1, obj);
            }
            return testRunnerOnBadEndName(modulemethod);

        case 43: // '+'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-result-alist", 1, obj);
            }
            return testResultAlist(modulemethod);

        case 45: // '-'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-aux-value", 1, obj);
            }
            return testRunnerAuxValue(modulemethod);

        case 47: // '/'
            testRunnerReset(obj);
            return Values.empty;

        case 48: // '0'
            return testRunnerGroupPath(obj);

        case 49: // '1'
            return $PcTestNullCallback(obj);

        case 57: // '9'
            return $PcTestShouldExecute(obj);

        case 60: // '<'
            return testOnGroupEndSimple(obj);

        case 63: // '?'
            testOnFinalSimple(obj);
            return Values.empty;

        case 65: // 'A'
            return testOnTestBeginSimple(obj);

        case 66: // 'B'
            return testOnTestEndSimple(obj);

        case 68: // 'D'
            testResultClear(obj);
            return Values.empty;

        case 73: // 'I'
            if ($PcTestOnTestBegin(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 75: // 'K'
            return testRunnerTestName(obj);

        case 76: // 'L'
            return $PcTestApproximimate$Eq(obj);

        case 88: // 'X'
            return $PcTestAsSpecifier(obj);

        case 89: // 'Y'
            return testMatchName(obj);

        case 90: // 'Z'
            return testReadEvalString(obj);

        case 77: // 'M'
            return lambda16(obj);

        case 78: // 'N'
            return lambda17(obj);

        case 79: // 'O'
            return lambda18(obj);

        case 80: // 'P'
            return lambda19(obj);

        case 81: // 'Q'
            return lambda20(obj);

        case 82: // 'R'
            return lambda21(obj);

        case 83: // 'S'
            return lambda22(obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 14: // '\016'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-pass-count!", 1, obj);
            }
            testRunnerPassCount$Ex(modulemethod, obj1);
            return Values.empty;

        case 16: // '\020'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-fail-count!", 1, obj);
            }
            testRunnerFailCount$Ex(modulemethod, obj1);
            return Values.empty;

        case 18: // '\022'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-xpass-count!", 1, obj);
            }
            testRunnerXpassCount$Ex(modulemethod, obj1);
            return Values.empty;

        case 20: // '\024'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-xfail-count!", 1, obj);
            }
            testRunnerXfailCount$Ex(modulemethod, obj1);
            return Values.empty;

        case 22: // '\026'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-skip-count!", 1, obj);
            }
            testRunnerSkipCount$Ex(modulemethod, obj1);
            return Values.empty;

        case 24: // '\030'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "%test-runner-skip-list!", 1, obj);
            }
            $PcTestRunnerSkipList$Ex(modulemethod, obj1);
            return Values.empty;

        case 26: // '\032'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "%test-runner-fail-list!", 1, obj);
            }
            $PcTestRunnerFailList$Ex(modulemethod, obj1);
            return Values.empty;

        case 28: // '\034'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-group-stack!", 1, obj);
            }
            testRunnerGroupStack$Ex(modulemethod, obj1);
            return Values.empty;

        case 30: // '\036'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-test-begin!", 1, obj);
            }
            testRunnerOnTestBegin$Ex(modulemethod, obj1);
            return Values.empty;

        case 32: // ' '
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-test-end!", 1, obj);
            }
            testRunnerOnTestEnd$Ex(modulemethod, obj1);
            return Values.empty;

        case 34: // '"'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-group-begin!", 1, obj);
            }
            testRunnerOnGroupBegin$Ex(modulemethod, obj1);
            return Values.empty;

        case 36: // '$'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-group-end!", 1, obj);
            }
            testRunnerOnGroupEnd$Ex(modulemethod, obj1);
            return Values.empty;

        case 38: // '&'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-final!", 1, obj);
            }
            testRunnerOnFinal$Ex(modulemethod, obj1);
            return Values.empty;

        case 40: // '('
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-bad-count!", 1, obj);
            }
            testRunnerOnBadCount$Ex(modulemethod, obj1);
            return Values.empty;

        case 42: // '*'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-on-bad-end-name!", 1, obj);
            }
            testRunnerOnBadEndName$Ex(modulemethod, obj1);
            return Values.empty;

        case 44: // ','
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-result-alist!", 1, obj);
            }
            testResultAlist$Ex(modulemethod, obj1);
            return Values.empty;

        case 46: // '.'
            try
            {
                modulemethod = (test.Mnrunner)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "test-runner-aux-value!", 1, obj);
            }
            testRunnerAuxValue$Ex(modulemethod, obj1);
            return Values.empty;

        case 58: // ':'
            $PcTestBegin(obj, obj1);
            return Values.empty;

        case 64: // '@'
            return $PcTestEnd(obj, obj1);

        case 69: // 'E'
            testResultRemove(obj, obj1);
            return Values.empty;

        case 74: // 'J'
            return $PcTestOnTestEnd(obj, obj1);

        case 85: // 'U'
            return $PcTestMatchNth(obj, obj1);
        }
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 50: // '2'
            return lambda1(obj, obj1, obj2);

        case 51: // '3'
            return lambda2(obj, obj1, obj2);

        case 52: // '4'
            return lambda3(obj, obj1, obj2);

        case 59: // ';'
            return testOnGroupBeginSimple(obj, obj1, obj2);

        case 61: // '='
            testOnBadCountSimple(obj, obj1, obj2);
            return Values.empty;

        case 62: // '>'
            return testOnBadEndNameSimple(obj, obj1, obj2);

        case 67: // 'C'
            return testResultSet$Ex(obj, obj1, obj2);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        switch (modulemethod.selector)
        {
        default:
            return super.applyN(modulemethod, aobj);

        case 70: // 'F'
            return testResultKind$V(aobj);

        case 71: // 'G'
            return isTestPassed$V(aobj);

        case 84: // 'T'
            modulemethod = ((ModuleMethod) (aobj[0]));
            int i = aobj.length - 1;
            Object aobj1[] = new Object[i];
            do
            {
                i--;
                if (i < 0)
                {
                    return testApply$V(modulemethod, aobj1);
                }
                aobj1[i] = aobj[i + 1];
            } while (true);

        case 86: // 'V'
            return $PcTestMatchAll$V(aobj);

        case 87: // 'W'
            return $PcTestMatchAny$V(aobj);
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match0(modulemethod, callcontext);

        case 72: // 'H'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 56: // '8'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 55: // '7'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 54: // '6'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 53: // '5'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 14: // '\016'
        case 16: // '\020'
        case 18: // '\022'
        case 20: // '\024'
        case 22: // '\026'
        case 24: // '\030'
        case 26: // '\032'
        case 28: // '\034'
        case 30: // '\036'
        case 32: // ' '
        case 34: // '"'
        case 36: // '$'
        case 38: // '&'
        case 40: // '('
        case 42: // '*'
        case 44: // ','
        case 46: // '.'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 58: // ':'
        case 59: // ';'
        case 61: // '='
        case 62: // '>'
        case 64: // '@'
        case 67: // 'C'
        case 69: // 'E'
        case 70: // 'F'
        case 71: // 'G'
        case 72: // 'H'
        case 74: // 'J'
        case 84: // 'T'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 83: // 'S'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 82: // 'R'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 81: // 'Q'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 80: // 'P'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 79: // 'O'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 78: // 'N'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 77: // 'M'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 90: // 'Z'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 89: // 'Y'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 88: // 'X'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 76: // 'L'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 75: // 'K'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 73: // 'I'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 68: // 'D'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 66: // 'B'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 65: // 'A'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 63: // '?'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 60: // '<'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 57: // '9'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 49: // '1'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 48: // '0'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 47: // '/'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 45: // '-'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 43: // '+'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 41: // ')'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 39: // '\''
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 37: // '%'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 35: // '#'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 33: // '!'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 31: // '\037'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 29: // '\035'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 27: // '\033'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 25: // '\031'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 23: // '\027'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 21: // '\025'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 19: // '\023'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 17: // '\021'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 15: // '\017'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 13: // '\r'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 12: // '\f'
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

        case 85: // 'U'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 74: // 'J'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 69: // 'E'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 64: // '@'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 58: // ':'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 46: // '.'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 44: // ','
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 42: // '*'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 40: // '('
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 38: // '&'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 36: // '$'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 34: // '"'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 32: // ' '
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 30: // '\036'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 28: // '\034'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 26: // '\032'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 24: // '\030'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 22: // '\026'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 20: // '\024'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 18: // '\022'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 16: // '\020'
            if (!(obj instanceof test.Mnrunner))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 14: // '\016'
            break;
        }
        if (!(obj instanceof test.Mnrunner))
        {
            return 0xfff40001;
        } else
        {
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
        default:
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);

        case 67: // 'C'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 62: // '>'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 61: // '='
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 59: // ';'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 52: // '4'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 51: // '3'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 50: // '2'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 87: // 'W'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 86: // 'V'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 84: // 'T'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 71: // 'G'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 70: // 'F'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
        test$Mnlog$Mnto$Mnfile = Boolean.TRUE;
        test$Mnrunner$Mncurrent = parameters.makeParameter(Boolean.FALSE);
        test$Mnrunner$Mnfactory = parameters.makeParameter(test$Mnrunner$Mnsimple);
    }

    static 
    {
        Lit165 = (SimpleSymbol)(new SimpleSymbol("dynamic-wind")).readResolve();
        Lit164 = (SimpleSymbol)(new SimpleSymbol("p")).readResolve();
        Lit163 = (SimpleSymbol)(new SimpleSymbol("exp")).readResolve();
        Lit162 = (SimpleSymbol)(new SimpleSymbol("res")).readResolve();
        Lit161 = (SimpleSymbol)(new SimpleSymbol("if")).readResolve();
        Lit160 = (SimpleSymbol)(new SimpleSymbol("name")).readResolve();
        Lit159 = (SimpleSymbol)(new SimpleSymbol("instance?")).readResolve();
        Lit158 = (SimpleSymbol)(new SimpleSymbol("cond")).readResolve();
        Lit157 = (SimpleSymbol)(new SimpleSymbol("actual-error")).readResolve();
        Lit156 = (SimpleSymbol)(new SimpleSymbol("<java.lang.Throwable>")).readResolve();
        Lit155 = (SimpleSymbol)(new SimpleSymbol("actual-value")).readResolve();
        Lit154 = (SimpleSymbol)(new SimpleSymbol("try-catch")).readResolve();
        Lit153 = (SimpleSymbol)(new SimpleSymbol("et")).readResolve();
        Lit152 = (SimpleSymbol)(new SimpleSymbol("expected-error")).readResolve();
        Lit151 = (SimpleSymbol)(new SimpleSymbol("ex")).readResolve();
        Lit150 = (SimpleSymbol)(new SimpleSymbol("let*")).readResolve();
        Lit149 = (SimpleSymbol)(new SimpleSymbol("r")).readResolve();
        Lit148 = (SimpleSymbol)(new SimpleSymbol("saved-runner")).readResolve();
        Lit147 = (SimpleSymbol)(new SimpleSymbol("lambda")).readResolve();
        Lit146 = (SimpleSymbol)(new SimpleSymbol("test-runner-current")).readResolve();
        Lit145 = (SimpleSymbol)(new SimpleSymbol("cons")).readResolve();
        Lit144 = (SimpleSymbol)(new SimpleSymbol("let")).readResolve();
        Lit143 = (SimpleSymbol)(new SimpleSymbol("runner")).readResolve();
        Lit142 = (SimpleSymbol)(new SimpleSymbol("test-read-eval-string")).readResolve();
        Lit141 = (SimpleSymbol)(new SimpleSymbol("test-match-name")).readResolve();
        Object obj = (SimpleSymbol)(new SimpleSymbol("test-expect-fail")).readResolve();
        Lit139 = ((SimpleSymbol) (obj));
        Object obj1 = new SyntaxPattern("\f\030\r\007\000\b\b", new Object[0], 1);
        Object obj2 = Lit144;
        Object obj3 = Lit143;
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("test-runner-get")).readResolve();
        Lit60 = simplesymbol;
        obj3 = PairWithPosition.make(PairWithPosition.make(obj3, PairWithPosition.make(PairWithPosition.make(simplesymbol, LList.Empty, "testing.scm", 0x3c5014), LList.Empty, "testing.scm", 0x3c5014), "testing.scm", 0x3c500c), LList.Empty, "testing.scm", 0x3c500b);
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("%test-runner-fail-list!")).readResolve();
        Lit34 = simplesymbol;
        Object obj4 = Lit143;
        SimpleSymbol simplesymbol1 = Lit145;
        SimpleSymbol simplesymbol2 = (SimpleSymbol)(new SimpleSymbol("test-match-all")).readResolve();
        Lit131 = simplesymbol2;
        Object obj5 = (SimpleSymbol)(new SimpleSymbol("%test-as-specifier")).readResolve();
        Lit136 = ((SimpleSymbol) (obj5));
        Object obj6 = (SimpleSymbol)(new SimpleSymbol("%test-runner-fail-list")).readResolve();
        Lit33 = ((SimpleSymbol) (obj6));
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\003", "\021\030\004\021\030\f\b\021\030\024\021\030\034\b\021\030$Q\021\030,\b\005\021\0304\b\003\030<", new Object[] {
            obj2, obj3, simplesymbol, obj4, simplesymbol1, simplesymbol2, obj5, PairWithPosition.make(PairWithPosition.make(obj6, PairWithPosition.make(Lit143, LList.Empty, "testing.scm", 0x3c801e), "testing.scm", 0x3c8006), LList.Empty, "testing.scm", 0x3c8006)
        }, 1);
        Lit140 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        obj = (SimpleSymbol)(new SimpleSymbol("test-skip")).readResolve();
        Lit137 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxPattern("\f\030\r\007\000\b\b", new Object[0], 1);
        obj2 = Lit144;
        obj3 = PairWithPosition.make(PairWithPosition.make(Lit143, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x3bd014), LList.Empty, "testing.scm", 0x3bd014), "testing.scm", 0x3bd00c), LList.Empty, "testing.scm", 0x3bd00b);
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("%test-runner-skip-list!")).readResolve();
        Lit32 = simplesymbol;
        obj4 = Lit143;
        simplesymbol1 = Lit145;
        simplesymbol2 = Lit131;
        obj5 = Lit136;
        obj6 = (SimpleSymbol)(new SimpleSymbol("%test-runner-skip-list")).readResolve();
        Lit31 = ((SimpleSymbol) (obj6));
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\003", "\021\030\004\021\030\f\b\021\030\024\021\030\034\b\021\030$Q\021\030,\b\005\021\0304\b\003\030<", new Object[] {
            obj2, obj3, simplesymbol, obj4, simplesymbol1, simplesymbol2, obj5, PairWithPosition.make(PairWithPosition.make(obj6, PairWithPosition.make(Lit143, LList.Empty, "testing.scm", 0x3c001e), "testing.scm", 0x3c0006), LList.Empty, "testing.scm", 0x3c0006)
        }, 1);
        Lit138 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        obj = (SimpleSymbol)(new SimpleSymbol("test-match-any")).readResolve();
        Lit134 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxPattern("\f\030\r\007\000\b\b", new Object[0], 1);
        obj2 = (SimpleSymbol)(new SimpleSymbol("%test-match-any")).readResolve();
        Lit133 = ((SimpleSymbol) (obj2));
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\003", "\021\030\004\b\005\021\030\f\b\003", new Object[] {
            obj2, Lit136
        }, 1);
        Lit135 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        obj = Lit131;
        obj1 = new SyntaxPattern("\f\030\r\007\000\b\b", new Object[0], 1);
        obj2 = (SimpleSymbol)(new SimpleSymbol("%test-match-all")).readResolve();
        Lit130 = ((SimpleSymbol) (obj2));
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\003", "\021\030\004\b\005\021\030\f\b\003", new Object[] {
            obj2, Lit136
        }, 1);
        Lit132 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        obj = (SimpleSymbol)(new SimpleSymbol("test-match-nth")).readResolve();
        Lit128 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
        obj2 = Lit128;
        obj3 = IntNum.make(1);
        Lit13 = ((IntNum) (obj3));
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\001", "\021\030\004\t\003\030\f", new Object[] {
            obj2, PairWithPosition.make(obj3, LList.Empty, "testing.scm", 0x38e018)
        }, 0);
        obj2 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
        obj3 = (SimpleSymbol)(new SimpleSymbol("%test-match-nth")).readResolve();
        Lit127 = ((SimpleSymbol) (obj3));
        obj2 = new SyntaxRule(((SyntaxPattern) (obj2)), "\001\001", "\021\030\004\t\003\b\013", new Object[] {
            obj3
        }, 0);
        Lit129 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 2);
        obj = (SimpleSymbol)(new SimpleSymbol("test-with-runner")).readResolve();
        Lit125 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2), "\001\003", "\021\030\004\021\030\f\b\021\030\024Y\021\030\034\t\020\b\021\030$\b\003A\021\030\034\t\020\b\r\013\030,", new Object[] {
            Lit144, PairWithPosition.make(PairWithPosition.make(Lit148, PairWithPosition.make(PairWithPosition.make(Lit146, LList.Empty, "testing.scm", 0x37d01a), LList.Empty, "testing.scm", 0x37d01a), "testing.scm", 0x37d00c), LList.Empty, "testing.scm", 0x37d00b), Lit165, Lit147, Lit146, PairWithPosition.make(PairWithPosition.make(Lit147, PairWithPosition.make(LList.Empty, PairWithPosition.make(PairWithPosition.make(Lit146, PairWithPosition.make(Lit148, LList.Empty, "testing.scm", 0x38102c), "testing.scm", 0x381017), LList.Empty, "testing.scm", 0x381017), "testing.scm", 0x381014), "testing.scm", 0x38100c), LList.Empty, "testing.scm", 0x38100c)
        }, 1);
        Lit126 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 2);
        Lit124 = (SimpleSymbol)(new SimpleSymbol("test-apply")).readResolve();
        obj = Lit150;
        obj1 = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x35a00e), LList.Empty, "testing.scm", 0x35a00e), "testing.scm", 0x35a00b), LList.Empty, "testing.scm", 0x35a00a);
        obj2 = (SimpleSymbol)(new SimpleSymbol("test-result-alist!")).readResolve();
        Lit52 = ((SimpleSymbol) (obj2));
        obj3 = Lit149;
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("%test-error")).readResolve();
        Lit115 = simplesymbol;
        Lit123 = new SyntaxTemplate("\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\023\b\021\030$\021\030\034\021\030,\b\013", new Object[] {
            obj, obj1, obj2, obj3, simplesymbol, Boolean.TRUE
        }, 0);
        Lit121 = new SyntaxTemplate("\001\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\033\b\021\030$\021\030\034\t\013\b\023", new Object[] {
            Lit150, PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x35500e), LList.Empty, "testing.scm", 0x35500e), "testing.scm", 0x35500b), LList.Empty, "testing.scm", 0x35500a), Lit52, Lit149, Lit115
        }, 0);
        obj = Lit150;
        obj1 = PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x34f00e), LList.Empty, "testing.scm", 0x34f00e), "testing.scm", 0x34f00b);
        obj2 = Lit160;
        obj3 = Lit52;
        simplesymbol = Lit149;
        obj4 = Lit145;
        simplesymbol1 = (SimpleSymbol)(new SimpleSymbol("quote")).readResolve();
        Lit15 = simplesymbol1;
        simplesymbol2 = (SimpleSymbol)(new SimpleSymbol("test-name")).readResolve();
        Lit7 = simplesymbol2;
        Lit119 = new SyntaxTemplate("\001\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013\251\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b#\b\021\030<\021\030$\t\023\b\033", new Object[] {
            obj, obj1, obj2, obj3, simplesymbol, obj4, PairWithPosition.make(simplesymbol1, PairWithPosition.make(simplesymbol2, LList.Empty, "testing.scm", 0x351029), "testing.scm", 0x351029), Lit115
        }, 0);
        Lit117 = (SimpleSymbol)(new SimpleSymbol("test-error")).readResolve();
        obj = Lit115;
        obj1 = new SyntaxPattern("\f\030\f\007\f\002\f\017\b", new Object[] {
            Boolean.TRUE
        }, 2);
        obj2 = Lit158;
        obj3 = (SimpleSymbol)(new SimpleSymbol("%test-on-test-begin")).readResolve();
        Lit86 = ((SimpleSymbol) (obj3));
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("test-result-set!")).readResolve();
        Lit78 = simplesymbol;
        obj4 = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit152, LList.Empty, "testing.scm", 0x31301d), "testing.scm", 0x31301d), PairWithPosition.make(Boolean.TRUE, LList.Empty, "testing.scm", 0x31302c), "testing.scm", 0x31301c);
        simplesymbol1 = (SimpleSymbol)(new SimpleSymbol("%test-on-test-end")).readResolve();
        Lit87 = simplesymbol1;
        simplesymbol2 = Lit154;
        obj5 = Lit144;
        obj6 = PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 0x31701e), "testing.scm", 0x31701e);
        Object obj7 = PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 0x318009);
        SimpleSymbol simplesymbol3 = Lit151;
        SimpleSymbol simplesymbol4 = Lit156;
        PairWithPosition pairwithposition = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit157, LList.Empty, "testing.scm", 0x31a020), "testing.scm", 0x31a020), PairWithPosition.make(Lit151, LList.Empty, "testing.scm", 0x31a02d), "testing.scm", 0x31a01f);
        PairWithPosition pairwithposition1 = PairWithPosition.make(Boolean.TRUE, LList.Empty, "testing.scm", 0x31b00b);
        SimpleSymbol simplesymbol5 = (SimpleSymbol)(new SimpleSymbol("%test-report-result")).readResolve();
        Lit83 = simplesymbol5;
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\001\001", "\021\030\004\b)\021\030\f\b\0039\021\030\024\t\003\030\034\u0169\021\030$\t\003\b\021\030,\221\021\0304\t\020Q\021\030\024\t\003\021\030<\b\013\030D\b\021\030L\021\030T9\021\030\024\t\003\030\\\030d\030l", new Object[] {
            obj2, obj3, simplesymbol, obj4, simplesymbol1, simplesymbol2, obj5, obj6, obj7, simplesymbol3, 
            simplesymbol4, pairwithposition, pairwithposition1, PairWithPosition.make(PairWithPosition.make(simplesymbol5, LList.Empty, "testing.scm", 0x31c008), LList.Empty, "testing.scm", 0x31c008)
        }, 0);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3), "\001\001\001", "\021\030\004)\021\030\f\b\003\b\021\030\0241\b\021\030\034\b\0139\021\030$\t\003\030,\u0169\021\0304\t\003\b\021\030<\221\021\030\024\t\020Q\021\030$\t\003\021\030D\b\023\030L\b\021\030T\021\030\\9\021\030$\t\003\030d\030l\030t", new Object[] {
            Lit161, Lit86, Lit144, Lit153, Lit78, PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit152, LList.Empty, "testing.scm", 0x32001c), "testing.scm", 0x32001c), PairWithPosition.make(Lit153, LList.Empty, "testing.scm", 0x32002b), "testing.scm", 0x32001b), Lit87, Lit154, PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 0x32401d), "testing.scm", 0x32401d), PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 0x325008), 
            Lit151, Lit156, PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit157, LList.Empty, "testing.scm", 0x32701f), "testing.scm", 0x32701f), PairWithPosition.make(Lit151, LList.Empty, "testing.scm", 0x32702c), "testing.scm", 0x32701e), PairWithPosition.make(PairWithPosition.make(Lit158, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("and")).readResolve(), PairWithPosition.make(PairWithPosition.make(Lit159, PairWithPosition.make(Lit153, PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("<gnu.bytecode.ClassType>")).readResolve(), LList.Empty, "testing.scm", 0x328024), "testing.scm", 0x328021), "testing.scm", 0x328016), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("$lookup$")).readResolve(), Pair.make((SimpleSymbol)(new SimpleSymbol("gnu.bytecode.ClassType")).readResolve(), Pair.make(Pair.make((SimpleSymbol)(new SimpleSymbol("quasiquote")).readResolve(), Pair.make((SimpleSymbol)(new SimpleSymbol("isSubclass")).readResolve(), LList.Empty)), LList.Empty)), "testing.scm", 0x329009), PairWithPosition.make(Lit153, PairWithPosition.make(Lit156, LList.Empty, "testing.scm", 0x32902e), "testing.scm", 0x32902b), "testing.scm", 0x329008), LList.Empty, "testing.scm", 0x329008), "testing.scm", 0x328016), "testing.scm", 0x328011), PairWithPosition.make(PairWithPosition.make(Lit159, PairWithPosition.make(Lit151, PairWithPosition.make(Lit153, LList.Empty, "testing.scm", 0x32a018), "testing.scm", 0x32a015), "testing.scm", 0x32a00a), LList.Empty, "testing.scm", 0x32a00a), "testing.scm", 0x328010), PairWithPosition.make(PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("else")).readResolve(), PairWithPosition.make(Boolean.TRUE, LList.Empty, "testing.scm", 0x32b00f), "testing.scm", 0x32b009), LList.Empty, "testing.scm", 0x32b009), "testing.scm", 0x328010), "testing.scm", 0x32800a), LList.Empty, "testing.scm", 0x32800a), PairWithPosition.make(PairWithPosition.make(Lit83, LList.Empty, "testing.scm", 0x32c007), LList.Empty, "testing.scm", 0x32c007)
        }, 0);
        Lit116 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 3);
        obj = Lit150;
        obj1 = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x2c800c), LList.Empty, "testing.scm", 0x2c800c), "testing.scm", 0x2c8009), LList.Empty, "testing.scm", 0x2c8008);
        obj2 = Lit52;
        obj3 = Lit149;
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("%test-comp2body")).readResolve();
        Lit89 = simplesymbol;
        obj4 = (SimpleSymbol)(new SimpleSymbol("%test-approximimate=")).readResolve();
        Lit91 = ((SimpleSymbol) (obj4));
        Lit114 = new SyntaxTemplate("\001\001\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b#\b\021\030$\021\030\034)\021\030,\b\033\t\013\b\023", new Object[] {
            obj, obj1, obj2, obj3, simplesymbol, obj4
        }, 0);
        Lit112 = new SyntaxTemplate("\001\001\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013\251\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b+\b\021\030<\021\030$)\021\030D\b#\t\023\b\033", new Object[] {
            Lit150, PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x2c200c), LList.Empty, "testing.scm", 0x2c200c), "testing.scm", 0x2c2009), Lit160, Lit52, Lit149, Lit145, PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 0x2c4027), "testing.scm", 0x2c4027), Lit89, Lit91
        }, 0);
        Lit110 = (SimpleSymbol)(new SimpleSymbol("test-approximate")).readResolve();
        Lit108 = (SimpleSymbol)(new SimpleSymbol("test-equal")).readResolve();
        Lit106 = (SimpleSymbol)(new SimpleSymbol("test-eq")).readResolve();
        Lit104 = (SimpleSymbol)(new SimpleSymbol("test-eqv")).readResolve();
        obj = Lit150;
        obj1 = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x2a700e), LList.Empty, "testing.scm", 0x2a700e), "testing.scm", 0x2a700b), LList.Empty, "testing.scm", 0x2a700a);
        obj2 = Lit52;
        obj3 = Lit149;
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("%test-comp1body")).readResolve();
        Lit92 = simplesymbol;
        Lit103 = new SyntaxTemplate("\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\023\b\021\030$\021\030\034\b\013", new Object[] {
            obj, obj1, obj2, obj3, simplesymbol
        }, 0);
        Lit101 = new SyntaxTemplate("\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013\251\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b\033\b\021\030<\021\030$\b\023", new Object[] {
            Lit150, PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x2a100e), LList.Empty, "testing.scm", 0x2a100e), "testing.scm", 0x2a100b), Lit160, Lit52, Lit149, Lit145, PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 0x2a3029), "testing.scm", 0x2a3029), Lit92
        }, 0);
        Lit99 = (SimpleSymbol)(new SimpleSymbol("test-assert")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("%test-end")).readResolve();
        Lit69 = ((SimpleSymbol) (obj));
        Lit98 = new SyntaxTemplate("\001\001", "\021\030\004\021\030\f\b\013", new Object[] {
            obj, Boolean.FALSE
        }, 0);
        Lit96 = new SyntaxTemplate("\001\001\001", "\021\030\004\t\013\b\023", new Object[] {
            Lit69
        }, 0);
        Lit94 = (SimpleSymbol)(new SimpleSymbol("test-end")).readResolve();
        obj = Lit92;
        obj1 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
        obj2 = Lit144;
        obj3 = Lit161;
        simplesymbol = Lit86;
        obj4 = Lit162;
        simplesymbol1 = (SimpleSymbol)(new SimpleSymbol("%test-evaluate-with-catch")).readResolve();
        Lit84 = simplesymbol1;
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\001\001", "\021\030\004\t\020\u0171\021\030\f)\021\030\024\b\003\b\021\030\004\t\020\b\021\030\004Q\b\021\030\034\b\021\030$\b\0139\021\030,\t\003\0304\b\021\030<\t\003\030D\030L", new Object[] {
            obj2, obj3, simplesymbol, obj4, simplesymbol1, Lit78, PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 0x28b01e), "testing.scm", 0x28b01e), PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 0x28b02b), "testing.scm", 0x28b01d), Lit87, PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 0x28c01e), PairWithPosition.make(PairWithPosition.make(Lit83, LList.Empty, "testing.scm", 0x28d008), LList.Empty, "testing.scm", 0x28d008)
        }, 0);
        Lit93 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 2);
        obj = Lit89;
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037\b", new Object[0], 4), "\001\001\001\001", "\021\030\004\t\020\u01F1\021\030\f)\021\030\024\b\003\b\021\030\0041\b\021\030\034\b\0239\021\030$\t\003\030,\b\021\030\004Q\b\021\0304\b\021\030<\b\0339\021\030$\t\003\030D\b\021\030L\t\003\b\t\013\030T\030\\", new Object[] {
            Lit144, Lit161, Lit86, Lit163, Lit78, PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("expected-value")).readResolve(), LList.Empty, "testing.scm", 0x27901a), "testing.scm", 0x27901a), PairWithPosition.make(Lit163, LList.Empty, "testing.scm", 0x279029), "testing.scm", 0x279019), Lit162, Lit84, PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 0x27b01c), "testing.scm", 0x27b01c), PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 0x27b029), "testing.scm", 0x27b01b), Lit87, 
            PairWithPosition.make(Lit163, PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 0x27c026), "testing.scm", 0x27c022), PairWithPosition.make(PairWithPosition.make(Lit83, LList.Empty, "testing.scm", 0x27d006), LList.Empty, "testing.scm", 0x27d006)
        }, 0);
        Lit90 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 4);
        Lit88 = (SimpleSymbol)(new SimpleSymbol("test-runner-test-name")).readResolve();
        obj = Lit84;
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\b", new Object[0], 1), "\001", "\021\030\004\t\003\030\f", new Object[] {
            Lit154, PairWithPosition.make(PairWithPosition.make(Lit151, PairWithPosition.make(Lit156, PairWithPosition.make(PairWithPosition.make(Lit78, PairWithPosition.make(PairWithPosition.make(Lit146, LList.Empty, "testing.scm", 0x23d01b), PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit157, LList.Empty, "testing.scm", 0x23d032), "testing.scm", 0x23d032), PairWithPosition.make(Lit151, LList.Empty, "testing.scm", 0x23d03f), "testing.scm", 0x23d031), "testing.scm", 0x23d01b), "testing.scm", 0x23d009), PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 0x23e009), "testing.scm", 0x23d009), "testing.scm", 0x23c009), "testing.scm", 0x23c005), LList.Empty, "testing.scm", 0x23c005)
        }, 0);
        Lit85 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        Lit82 = (SimpleSymbol)(new SimpleSymbol("test-passed?")).readResolve();
        Lit81 = (SimpleSymbol)(new SimpleSymbol("test-result-kind")).readResolve();
        Lit80 = (SimpleSymbol)(new SimpleSymbol("test-result-remove")).readResolve();
        Lit79 = (SimpleSymbol)(new SimpleSymbol("test-result-clear")).readResolve();
        Lit77 = (SimpleSymbol)(new SimpleSymbol("test-on-test-end-simple")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("test-result-ref")).readResolve();
        Lit75 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\t\013\030\f", new Object[] {
            Lit75, PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 0x1d8024)
        }, 0);
        obj2 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
        obj3 = Lit144;
        simplesymbol = Lit164;
        obj4 = (SimpleSymbol)(new SimpleSymbol("assq")).readResolve();
        simplesymbol1 = (SimpleSymbol)(new SimpleSymbol("test-result-alist")).readResolve();
        Lit51 = simplesymbol1;
        obj2 = new SyntaxRule(((SyntaxPattern) (obj2)), "\001\001\001", "\021\030\004\201\b\021\030\f\b\021\030\024\t\013\b\021\030\034\b\003\b\021\030$\021\030\f\021\030,\b\023", new Object[] {
            obj3, simplesymbol, obj4, simplesymbol1, Lit161, PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("cdr")).readResolve(), PairWithPosition.make(Lit164, LList.Empty, "testing.scm", 0x1db013), "testing.scm", 0x1db00e)
        }, 0);
        Lit76 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 3);
        Lit74 = (SimpleSymbol)(new SimpleSymbol("test-on-test-begin-simple")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("test-group-with-cleanup")).readResolve();
        Lit72 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
        obj2 = (SimpleSymbol)(new SimpleSymbol("test-group")).readResolve();
        Lit70 = ((SimpleSymbol) (obj2));
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\001\001\001", "\021\030\004\t\003\b\021\030\f\021\030\0249\021\030\034\t\020\b\013\b\021\030\034\t\020\b\023", new Object[] {
            obj2, Lit165, PairWithPosition.make(Lit147, PairWithPosition.make(LList.Empty, PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 0x1be00f), "testing.scm", 0x1be00c), "testing.scm", 0x1be004), Lit147
        }, 0);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\021\030\f\b\013", new Object[] {
            Lit72, Boolean.FALSE
        }, 0);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037#", new Object[0], 5), "\001\001\001\001\0", "\021\030\004\t\0039\021\030\f\t\013\b\023\t\033\"", new Object[] {
            Lit72, (SimpleSymbol)(new SimpleSymbol("begin")).readResolve()
        }, 0);
        Lit73 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2, obj3
        }, 5);
        obj = Lit70;
        obj1 = new SyntaxPattern("\f\030\f\007\013", new Object[0], 2);
        obj2 = Lit144;
        obj3 = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit146, LList.Empty, "testing.scm", 0x1b000f), LList.Empty, "testing.scm", 0x1b000f), "testing.scm", 0x1b000c), LList.Empty, "testing.scm", 0x1b000b);
        simplesymbol = Lit52;
        obj4 = Lit149;
        simplesymbol1 = (SimpleSymbol)(new SimpleSymbol("list")).readResolve();
        simplesymbol2 = Lit145;
        obj5 = PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 0x1b202b), "testing.scm", 0x1b202b);
        obj6 = Lit161;
        obj7 = (SimpleSymbol)(new SimpleSymbol("%test-should-execute")).readResolve();
        Lit62 = ((SimpleSymbol) (obj7));
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\001\0", "\021\030\004\021\030\f\231\021\030\024\021\030\034\b\021\030$\b\021\030,\021\0304\b\003\b\021\030<\021\030D\b\021\030LY\021\030T\t\020\b\021\030\\\b\0031\021\030T\t\020\n\b\021\030T\t\020\b\021\030d\b\003", new Object[] {
            obj2, obj3, simplesymbol, obj4, simplesymbol1, simplesymbol2, obj5, obj6, PairWithPosition.make(obj7, PairWithPosition.make(Lit149, LList.Empty, "testing.scm", 0x1b3022), "testing.scm", 0x1b300c), Lit165, 
            Lit147, (SimpleSymbol)(new SimpleSymbol("test-begin")).readResolve(), Lit94
        }, 0);
        Lit71 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 2);
        Lit68 = (SimpleSymbol)(new SimpleSymbol("test-on-final-simple")).readResolve();
        Lit67 = (SimpleSymbol)(new SimpleSymbol("test-on-bad-end-name-simple")).readResolve();
        Lit66 = (SimpleSymbol)(new SimpleSymbol("test-on-bad-count-simple")).readResolve();
        Lit65 = (SimpleSymbol)(new SimpleSymbol("test-on-group-end-simple")).readResolve();
        Lit64 = (SimpleSymbol)(new SimpleSymbol("test-on-group-begin-simple")).readResolve();
        Lit63 = (SimpleSymbol)(new SimpleSymbol("%test-begin")).readResolve();
        Lit61 = (SimpleSymbol)(new SimpleSymbol("test-runner-create")).readResolve();
        Lit59 = (SimpleSymbol)(new SimpleSymbol("test-runner-simple")).readResolve();
        Lit58 = (SimpleSymbol)(new SimpleSymbol("test-runner-null")).readResolve();
        Lit57 = (SimpleSymbol)(new SimpleSymbol("%test-null-callback")).readResolve();
        Lit56 = (SimpleSymbol)(new SimpleSymbol("test-runner-group-path")).readResolve();
        Lit55 = (SimpleSymbol)(new SimpleSymbol("test-runner-reset")).readResolve();
        Lit54 = (SimpleSymbol)(new SimpleSymbol("test-runner-aux-value!")).readResolve();
        Lit53 = (SimpleSymbol)(new SimpleSymbol("test-runner-aux-value")).readResolve();
        Lit50 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-bad-end-name!")).readResolve();
        Lit49 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-bad-end-name")).readResolve();
        Lit48 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-bad-count!")).readResolve();
        Lit47 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-bad-count")).readResolve();
        Lit46 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-final!")).readResolve();
        Lit45 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-final")).readResolve();
        Lit44 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-group-end!")).readResolve();
        Lit43 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-group-end")).readResolve();
        Lit42 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-group-begin!")).readResolve();
        Lit41 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-group-begin")).readResolve();
        Lit40 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-test-end!")).readResolve();
        Lit39 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-test-end")).readResolve();
        Lit38 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-test-begin!")).readResolve();
        Lit37 = (SimpleSymbol)(new SimpleSymbol("test-runner-on-test-begin")).readResolve();
        Lit36 = (SimpleSymbol)(new SimpleSymbol("test-runner-group-stack!")).readResolve();
        Lit35 = (SimpleSymbol)(new SimpleSymbol("test-runner-group-stack")).readResolve();
        Lit30 = (SimpleSymbol)(new SimpleSymbol("test-runner-skip-count!")).readResolve();
        Lit29 = (SimpleSymbol)(new SimpleSymbol("test-runner-skip-count")).readResolve();
        Lit28 = (SimpleSymbol)(new SimpleSymbol("test-runner-xfail-count!")).readResolve();
        Lit27 = (SimpleSymbol)(new SimpleSymbol("test-runner-xfail-count")).readResolve();
        Lit26 = (SimpleSymbol)(new SimpleSymbol("test-runner-xpass-count!")).readResolve();
        Lit25 = (SimpleSymbol)(new SimpleSymbol("test-runner-xpass-count")).readResolve();
        Lit24 = (SimpleSymbol)(new SimpleSymbol("test-runner-fail-count!")).readResolve();
        Lit23 = (SimpleSymbol)(new SimpleSymbol("test-runner-fail-count")).readResolve();
        Lit22 = (SimpleSymbol)(new SimpleSymbol("test-runner-pass-count!")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("test-runner-pass-count")).readResolve();
        Lit20 = (SimpleSymbol)(new SimpleSymbol("test-runner?")).readResolve();
        Lit19 = new SyntaxTemplate("\001\001\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\033\b\021\030$\021\030\034\t#\t\013\b\023", new Object[] {
            Lit150, PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x2b400c), LList.Empty, "testing.scm", 0x2b400c), "testing.scm", 0x2b4009), LList.Empty, "testing.scm", 0x2b4008), Lit52, Lit149, Lit89
        }, 0);
        Lit17 = new SyntaxTemplate("\001\001\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013\251\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b#\b\021\030<\021\030$\t+\t\023\b\033", new Object[] {
            Lit150, PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 0x2ae00c), LList.Empty, "testing.scm", 0x2ae00c), "testing.scm", 0x2ae009), Lit160, Lit52, Lit149, Lit145, PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 0x2b0027), "testing.scm", 0x2b0027), Lit89
        }, 0);
        Lit14 = (SimpleSymbol)(new SimpleSymbol("fail")).readResolve();
        Lit12 = (SimpleSymbol)(new SimpleSymbol("pass")).readResolve();
        obj = Lit12;
        obj1 = (SimpleSymbol)(new SimpleSymbol("xpass")).readResolve();
        Lit9 = ((SimpleSymbol) (obj1));
        Lit11 = PairWithPosition.make(obj, PairWithPosition.make(obj1, LList.Empty, "testing.scm", 0x21e038), "testing.scm", 0x21e032);
        obj = Lit7;
        obj1 = (SimpleSymbol)(new SimpleSymbol("source-file")).readResolve();
        Lit4 = ((SimpleSymbol) (obj1));
        obj2 = (SimpleSymbol)(new SimpleSymbol("source-line")).readResolve();
        Lit5 = ((SimpleSymbol) (obj2));
        obj3 = (SimpleSymbol)(new SimpleSymbol("source-form")).readResolve();
        Lit6 = ((SimpleSymbol) (obj3));
        Lit10 = PairWithPosition.make(obj, PairWithPosition.make(obj1, PairWithPosition.make(obj2, PairWithPosition.make(obj3, LList.Empty, "testing.scm", 0x1fa02a), "testing.scm", 0x1fa01e), "testing.scm", 0x1fa012), "testing.scm", 0x1fa007);
        Lit8 = PairWithPosition.make(Lit14, PairWithPosition.make(Lit9, LList.Empty, "testing.scm", 0x1e001b), "testing.scm", 0x1e0015);
        $instance = new testing();
        obj = $instance;
        test$Mnrunner$Qu = new ModuleMethod(((ModuleBody) (obj)), 12, Lit20, 4097);
        test$Mnrunner$Mnpass$Mncount = new ModuleMethod(((ModuleBody) (obj)), 13, Lit21, 4097);
        test$Mnrunner$Mnpass$Mncount$Ex = new ModuleMethod(((ModuleBody) (obj)), 14, Lit22, 8194);
        test$Mnrunner$Mnfail$Mncount = new ModuleMethod(((ModuleBody) (obj)), 15, Lit23, 4097);
        test$Mnrunner$Mnfail$Mncount$Ex = new ModuleMethod(((ModuleBody) (obj)), 16, Lit24, 8194);
        test$Mnrunner$Mnxpass$Mncount = new ModuleMethod(((ModuleBody) (obj)), 17, Lit25, 4097);
        test$Mnrunner$Mnxpass$Mncount$Ex = new ModuleMethod(((ModuleBody) (obj)), 18, Lit26, 8194);
        test$Mnrunner$Mnxfail$Mncount = new ModuleMethod(((ModuleBody) (obj)), 19, Lit27, 4097);
        test$Mnrunner$Mnxfail$Mncount$Ex = new ModuleMethod(((ModuleBody) (obj)), 20, Lit28, 8194);
        test$Mnrunner$Mnskip$Mncount = new ModuleMethod(((ModuleBody) (obj)), 21, Lit29, 4097);
        test$Mnrunner$Mnskip$Mncount$Ex = new ModuleMethod(((ModuleBody) (obj)), 22, Lit30, 8194);
        $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist = new ModuleMethod(((ModuleBody) (obj)), 23, Lit31, 4097);
        $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist$Ex = new ModuleMethod(((ModuleBody) (obj)), 24, Lit32, 8194);
        $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist = new ModuleMethod(((ModuleBody) (obj)), 25, Lit33, 4097);
        $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist$Ex = new ModuleMethod(((ModuleBody) (obj)), 26, Lit34, 8194);
        test$Mnrunner$Mngroup$Mnstack = new ModuleMethod(((ModuleBody) (obj)), 27, Lit35, 4097);
        test$Mnrunner$Mngroup$Mnstack$Ex = new ModuleMethod(((ModuleBody) (obj)), 28, Lit36, 8194);
        test$Mnrunner$Mnon$Mntest$Mnbegin = new ModuleMethod(((ModuleBody) (obj)), 29, Lit37, 4097);
        test$Mnrunner$Mnon$Mntest$Mnbegin$Ex = new ModuleMethod(((ModuleBody) (obj)), 30, Lit38, 8194);
        test$Mnrunner$Mnon$Mntest$Mnend = new ModuleMethod(((ModuleBody) (obj)), 31, Lit39, 4097);
        test$Mnrunner$Mnon$Mntest$Mnend$Ex = new ModuleMethod(((ModuleBody) (obj)), 32, Lit40, 8194);
        test$Mnrunner$Mnon$Mngroup$Mnbegin = new ModuleMethod(((ModuleBody) (obj)), 33, Lit41, 4097);
        test$Mnrunner$Mnon$Mngroup$Mnbegin$Ex = new ModuleMethod(((ModuleBody) (obj)), 34, Lit42, 8194);
        test$Mnrunner$Mnon$Mngroup$Mnend = new ModuleMethod(((ModuleBody) (obj)), 35, Lit43, 4097);
        test$Mnrunner$Mnon$Mngroup$Mnend$Ex = new ModuleMethod(((ModuleBody) (obj)), 36, Lit44, 8194);
        test$Mnrunner$Mnon$Mnfinal = new ModuleMethod(((ModuleBody) (obj)), 37, Lit45, 4097);
        test$Mnrunner$Mnon$Mnfinal$Ex = new ModuleMethod(((ModuleBody) (obj)), 38, Lit46, 8194);
        test$Mnrunner$Mnon$Mnbad$Mncount = new ModuleMethod(((ModuleBody) (obj)), 39, Lit47, 4097);
        test$Mnrunner$Mnon$Mnbad$Mncount$Ex = new ModuleMethod(((ModuleBody) (obj)), 40, Lit48, 8194);
        test$Mnrunner$Mnon$Mnbad$Mnend$Mnname = new ModuleMethod(((ModuleBody) (obj)), 41, Lit49, 4097);
        test$Mnrunner$Mnon$Mnbad$Mnend$Mnname$Ex = new ModuleMethod(((ModuleBody) (obj)), 42, Lit50, 8194);
        test$Mnresult$Mnalist = new ModuleMethod(((ModuleBody) (obj)), 43, Lit51, 4097);
        test$Mnresult$Mnalist$Ex = new ModuleMethod(((ModuleBody) (obj)), 44, Lit52, 8194);
        test$Mnrunner$Mnaux$Mnvalue = new ModuleMethod(((ModuleBody) (obj)), 45, Lit53, 4097);
        test$Mnrunner$Mnaux$Mnvalue$Ex = new ModuleMethod(((ModuleBody) (obj)), 46, Lit54, 8194);
        test$Mnrunner$Mnreset = new ModuleMethod(((ModuleBody) (obj)), 47, Lit55, 4097);
        test$Mnrunner$Mngroup$Mnpath = new ModuleMethod(((ModuleBody) (obj)), 48, Lit56, 4097);
        $Pctest$Mnnull$Mncallback = new ModuleMethod(((ModuleBody) (obj)), 49, Lit57, 4097);
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 50, null, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "testing.scm:182");
        lambda$Fn1 = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 51, null, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "testing.scm:187");
        lambda$Fn2 = ((ModuleMethod) (obj1));
        obj1 = new ModuleMethod(((ModuleBody) (obj)), 52, null, 12291);
        ((PropertySet) (obj1)).setProperty("source-location", "testing.scm:188");
        lambda$Fn3 = ((ModuleMethod) (obj1));
        test$Mnrunner$Mnnull = new ModuleMethod(((ModuleBody) (obj)), 53, Lit58, 0);
        test$Mnrunner$Mnsimple = new ModuleMethod(((ModuleBody) (obj)), 54, Lit59, 0);
        test$Mnrunner$Mnget = new ModuleMethod(((ModuleBody) (obj)), 55, Lit60, 0);
        test$Mnrunner$Mncreate = new ModuleMethod(((ModuleBody) (obj)), 56, Lit61, 0);
        $Prvt$$Pctest$Mnshould$Mnexecute = new ModuleMethod(((ModuleBody) (obj)), 57, Lit62, 4097);
        $Pctest$Mnbegin = new ModuleMethod(((ModuleBody) (obj)), 58, Lit63, 8194);
        test$Mnon$Mngroup$Mnbegin$Mnsimple = new ModuleMethod(((ModuleBody) (obj)), 59, Lit64, 12291);
        test$Mnon$Mngroup$Mnend$Mnsimple = new ModuleMethod(((ModuleBody) (obj)), 60, Lit65, 4097);
        test$Mnon$Mnbad$Mncount$Mnsimple = new ModuleMethod(((ModuleBody) (obj)), 61, Lit66, 12291);
        test$Mnon$Mnbad$Mnend$Mnname$Mnsimple = new ModuleMethod(((ModuleBody) (obj)), 62, Lit67, 12291);
        test$Mnon$Mnfinal$Mnsimple = new ModuleMethod(((ModuleBody) (obj)), 63, Lit68, 4097);
        $Prvt$$Pctest$Mnend = new ModuleMethod(((ModuleBody) (obj)), 64, Lit69, 8194);
        $Prvt$test$Mngroup = Macro.make(Lit70, Lit71, $instance);
        test$Mngroup$Mnwith$Mncleanup = Macro.make(Lit72, Lit73, $instance);
        test$Mnon$Mntest$Mnbegin$Mnsimple = new ModuleMethod(((ModuleBody) (obj)), 65, Lit74, 4097);
        test$Mnresult$Mnref = Macro.make(Lit75, Lit76, $instance);
        test$Mnon$Mntest$Mnend$Mnsimple = new ModuleMethod(((ModuleBody) (obj)), 66, Lit77, 4097);
        test$Mnresult$Mnset$Ex = new ModuleMethod(((ModuleBody) (obj)), 67, Lit78, 12291);
        test$Mnresult$Mnclear = new ModuleMethod(((ModuleBody) (obj)), 68, Lit79, 4097);
        test$Mnresult$Mnremove = new ModuleMethod(((ModuleBody) (obj)), 69, Lit80, 8194);
        test$Mnresult$Mnkind = new ModuleMethod(((ModuleBody) (obj)), 70, Lit81, -4096);
        test$Mnpassed$Qu = new ModuleMethod(((ModuleBody) (obj)), 71, Lit82, -4096);
        $Prvt$$Pctest$Mnreport$Mnresult = new ModuleMethod(((ModuleBody) (obj)), 72, Lit83, 0);
        $Prvt$$Pctest$Mnevaluate$Mnwith$Mncatch = Macro.make(Lit84, Lit85, $instance);
        $Prvt$$Pctest$Mnon$Mntest$Mnbegin = new ModuleMethod(((ModuleBody) (obj)), 73, Lit86, 4097);
        $Prvt$$Pctest$Mnon$Mntest$Mnend = new ModuleMethod(((ModuleBody) (obj)), 74, Lit87, 8194);
        test$Mnrunner$Mntest$Mnname = new ModuleMethod(((ModuleBody) (obj)), 75, Lit88, 4097);
        $Prvt$$Pctest$Mncomp2body = Macro.make(Lit89, Lit90, $instance);
        $Prvt$$Pctest$Mnapproximimate$Eq = new ModuleMethod(((ModuleBody) (obj)), 76, Lit91, 4097);
        $Prvt$$Pctest$Mncomp1body = Macro.make(Lit92, Lit93, $instance);
        obj1 = Lit94;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 77, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "testing.scm:660");
        test$Mnend = Macro.make(obj1, ((Procedure) (obj2)), $instance);
        obj1 = Lit99;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 78, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "testing.scm:669");
        test$Mnassert = Macro.make(obj1, ((Procedure) (obj2)), $instance);
        obj1 = Lit104;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 79, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "testing.scm:696");
        test$Mneqv = Macro.make(obj1, ((Procedure) (obj2)), $instance);
        obj1 = Lit106;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 80, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "testing.scm:698");
        test$Mneq = Macro.make(obj1, ((Procedure) (obj2)), $instance);
        obj1 = Lit108;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 81, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "testing.scm:700");
        test$Mnequal = Macro.make(obj1, ((Procedure) (obj2)), $instance);
        obj1 = Lit110;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 82, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "testing.scm:702");
        test$Mnapproximate = Macro.make(obj1, ((Procedure) (obj2)), $instance);
        $Prvt$$Pctest$Mnerror = Macro.make(Lit115, Lit116, $instance);
        obj1 = Lit117;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 83, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "testing.scm:843");
        test$Mnerror = Macro.make(obj1, ((Procedure) (obj2)), $instance);
        test$Mnapply = new ModuleMethod(((ModuleBody) (obj)), 84, Lit124, -4095);
        test$Mnwith$Mnrunner = Macro.make(Lit125, Lit126, $instance);
        $Prvt$$Pctest$Mnmatch$Mnnth = new ModuleMethod(((ModuleBody) (obj)), 85, Lit127, 8194);
        test$Mnmatch$Mnnth = Macro.make(Lit128, Lit129, $instance);
        $Prvt$$Pctest$Mnmatch$Mnall = new ModuleMethod(((ModuleBody) (obj)), 86, Lit130, -4096);
        test$Mnmatch$Mnall = Macro.make(Lit131, Lit132, $instance);
        $Prvt$$Pctest$Mnmatch$Mnany = new ModuleMethod(((ModuleBody) (obj)), 87, Lit133, -4096);
        test$Mnmatch$Mnany = Macro.make(Lit134, Lit135, $instance);
        $Prvt$$Pctest$Mnas$Mnspecifier = new ModuleMethod(((ModuleBody) (obj)), 88, Lit136, 4097);
        test$Mnskip = Macro.make(Lit137, Lit138, $instance);
        test$Mnexpect$Mnfail = Macro.make(Lit139, Lit140, $instance);
        test$Mnmatch$Mnname = new ModuleMethod(((ModuleBody) (obj)), 89, Lit141, 4097);
        test$Mnread$Mneval$Mnstring = new ModuleMethod(((ModuleBody) (obj)), 90, Lit142, 4097);
        $instance.run();
    }
}
