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
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            pregexp

public class lambda.Fn17 extends ModuleBody
{
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


    Object i;
    Object k;
    final ModuleMethod lambda$Fn17;
    Object q;
    _cls1 staticLink;

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
        lambda25 lambda25_1 = new <init>();
        lambda25_1.staticLink = this;
        lambda25_1.k = obj;
        lambda25_1.i = obj1;
        lambda25_1.fk = lambda25_1.fk;
        if (q == Boolean.FALSE ? q != Boolean.FALSE : Scheme.numGEq.apply2(lambda25_1.k, q) != Boolean.FALSE)
        {
            obj = lambda25_1.lambda26fk();
        } else
        {
            if (staticLink.Qu)
            {
                return staticLink.staticLink.ambda3sub(staticLink.re, lambda25_1.i, lambda25_1.Fn18, lambda25_1.fk);
            }
            obj1 = lambda25_1.lambda26fk();
            obj = obj1;
            if (obj1 == Boolean.FALSE)
            {
                return staticLink.staticLink.ambda3sub(staticLink.re, lambda25_1.i, lambda25_1.Fn19, lambda25_1.fk);
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

    public lambda.Fn19()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 8, null, 4097);
        modulemethod.setProperty("source-location", "pregexp.scm:602");
        lambda$Fn17 = modulemethod;
    }
}
