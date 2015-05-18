// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            pregexp

public class lambda.Fn12 extends ModuleBody
{
    public class pregexp.frame1 extends ModuleBody
    {

        Object chars;
        final ModuleMethod lambda$Fn13;
        pregexp.frame0 staticLink;

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

        public pregexp.frame1()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 0);
            modulemethod.setProperty("source-location", "pregexp.scm:508");
            lambda$Fn13 = modulemethod;
        }
    }

    public class pregexp.frame2 extends ModuleBody
    {

        final ModuleMethod lambda$Fn14;
        Object res;
        pregexp.frame0 staticLink;

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

        public pregexp.frame2()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 2, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:519");
            lambda$Fn14 = modulemethod;
        }
    }

    public class pregexp.frame3 extends ModuleBody
    {

        final ModuleMethod lambda$Fn15;
        final ModuleMethod lambda$Fn16;
        Object res;
        pregexp.frame0 staticLink;

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

        public pregexp.frame3()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 3, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:526");
            lambda$Fn15 = modulemethod;
            modulemethod = new ModuleMethod(this, 4, null, 0);
            modulemethod.setProperty("source-location", "pregexp.scm:529");
            lambda$Fn16 = modulemethod;
        }
    }

    public class pregexp.frame4 extends ModuleBody
    {

        Object i;
        Object k;
        final ModuleMethod lambda$Fn17;
        Object q;
        pregexp.frame0 staticLink;

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
            pregexp.frame5 frame5_1 = new pregexp.frame5();
            frame5_1.staticLink = this;
            frame5_1.k = obj;
            frame5_1.i = obj1;
            frame5_1.fk = frame5_1.fk;
            if (q == Boolean.FALSE ? q != Boolean.FALSE : Scheme.numGEq.apply2(frame5_1.k, q) != Boolean.FALSE)
            {
                obj = frame5_1.lambda26fk();
            } else
            {
                if (staticLink.maximal$Qu)
                {
                    return staticLink.staticLink.lambda3sub(staticLink.re, frame5_1.i, frame5_1.lambda$Fn18, frame5_1.fk);
                }
                obj1 = frame5_1.lambda26fk();
                obj = obj1;
                if (obj1 == Boolean.FALSE)
                {
                    return staticLink.staticLink.lambda3sub(staticLink.re, frame5_1.i, frame5_1.lambda$Fn19, frame5_1.fk);
                }
            }
            return obj;
        }

        Object lambda25(Object obj)
        {
            if (staticLink.could$Mnloop$Mninfinitely$Qu ? Scheme.numEqu.apply2(obj, i) != Boolean.FALSE : staticLink.could$Mnloop$Mninfinitely$Qu)
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

        public pregexp.frame4()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 8, null, 4097);
            modulemethod.setProperty("source-location", "pregexp.scm:602");
            lambda$Fn17 = modulemethod;
        }
    }

    public class pregexp.frame5 extends ModuleBody
    {

        Procedure fk;
        Object i;
        Object k;
        final ModuleMethod lambda$Fn18;
        final ModuleMethod lambda$Fn19;
        pregexp.frame4 staticLink;

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
            if (staticLink.staticLink.could$Mnloop$Mninfinitely$Qu ? Scheme.numEqu.apply2(obj, i) != Boolean.FALSE : staticLink.staticLink.could$Mnloop$Mninfinitely$Qu)
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

        public pregexp.frame5()
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
    _cls1 staticLink;

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
        Object obj1 = lists.assv(re$1, staticLink.ackrefs);
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
        fk fk1 = new <init>();
        fk1.staticLink = this;
        fk1.chars = obj;
        if (lists.isNull(fk1.chars))
        {
            return Scheme.applyToArgs.apply1(fk);
        } else
        {
            return staticLink.ambda3sub(lists.car.apply1(fk1.chars), i, sk, fk1.Fn13);
        }
    }

    public Object lambda6loupSeq(Object obj, Object obj1)
    {
        lambda.Fn13 fn13 = new <init>();
        fn13.staticLink = this;
        fn13.res = obj;
        if (lists.isNull(fn13.res))
        {
            return Scheme.applyToArgs.apply2(sk, obj1);
        } else
        {
            return staticLink.ambda3sub(lists.car.apply1(fn13.res), obj1, fn13.Fn14, fk);
        }
    }

    public Object lambda7loupOr(Object obj)
    {
        fk fk1 = new <init>();
        fk1.staticLink = this;
        fk1.res = obj;
        if (lists.isNull(fk1.res))
        {
            return Scheme.applyToArgs.apply1(fk);
        } else
        {
            return staticLink.ambda3sub(lists.car.apply1(fk1.res), i, fk1.Fn15, fk1.Fn16);
        }
    }

    public Object lambda8loupP(Object obj, Object obj1)
    {
        lambda.Fn16 fn16 = new <init>();
        fn16.staticLink = this;
        fn16.k = obj;
        fn16.i = obj1;
        if (Scheme.numLss.apply2(fn16.k, p) != Boolean.FALSE)
        {
            return staticLink.ambda3sub(re, fn16.i, fn16.Fn17, fk);
        }
        if (q != Boolean.FALSE)
        {
            obj = AddOp.$Mn.apply2(q, p);
        } else
        {
            obj = q;
        }
        fn16.q = obj;
        return fn16.lambda24loupQ(pregexp.Lit73, fn16.i);
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

    public lambda.Fn17()
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
