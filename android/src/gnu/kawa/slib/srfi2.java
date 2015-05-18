// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.prim_syntax;
import kawa.lib.std_syntax;
import kawa.standard.syntax_case;

public class srfi2 extends ModuleBody
{

    public static final srfi2 $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxPattern Lit1 = new SyntaxPattern("\f\007,\r\017\b\b\b\f\027\033", new Object[0], 4);
    static final SyntaxTemplate Lit10 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    static final SyntaxPattern Lit11 = new SyntaxPattern("\f\007<,\f\017\f\027\b\033\b", new Object[0], 4);
    static final SyntaxTemplate Lit12;
    static final SyntaxPattern Lit13 = new SyntaxPattern("\f\007,\034\f\017\b\023\b", new Object[0], 3);
    static final SyntaxTemplate Lit14;
    static final SyntaxPattern Lit15 = new SyntaxPattern("\f\007\034\f\017\023\b", new Object[0], 3);
    static final SyntaxTemplate Lit16 = new SyntaxTemplate("\001\001\0", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit17;
    static final SyntaxTemplate Lit18 = new SyntaxTemplate("\001\001\0", "\013", new Object[0], 0);
    static final SyntaxPattern Lit19 = new SyntaxPattern("\f\007\f\b\b", new Object[0], 1);
    static final SyntaxTemplate Lit2 = new SyntaxTemplate("\001\003\001\0", "\t\003\b\021\r\013\b\b\021\030\004\t\023\032", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("begin")).readResolve()
    }, 1);
    static final SyntaxTemplate Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SyntaxPattern Lit3 = new SyntaxPattern("\f\007<,\f\017\f\027\b\b\b", new Object[0], 3);
    static final SyntaxTemplate Lit4;
    static final SyntaxPattern Lit5 = new SyntaxPattern("\f\007,\034\f\017\b\b\b", new Object[0], 2);
    static final SyntaxTemplate Lit6 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    static final SyntaxPattern Lit7 = new SyntaxPattern("\f\007\034\f\017\b\b", new Object[0], 2);
    static final SyntaxTemplate Lit8 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit9 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    public static final Macro and$Mnlet$St;

    public srfi2()
    {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(4, null);
        if (Lit1.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit2.execute(aobj, ((TemplateScope) (obj)));
        }
        if (Lit3.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit4.execute(aobj, ((TemplateScope) (obj)));
        }
        if (Lit5.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit6.execute(aobj, ((TemplateScope) (obj)));
        }
        if (Lit7.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            if (std_syntax.isIdentifier(Lit8.execute(aobj, ((TemplateScope) (obj)))))
            {
                obj = TemplateScope.make();
                return Lit9.execute(aobj, ((TemplateScope) (obj)));
            }
            obj = TemplateScope.make();
            aobj = ((Object []) (Lit10.execute(aobj, ((TemplateScope) (obj)))));
            if ("expected a variable name" instanceof Object[])
            {
                obj = ((Object) ((Object[])"expected a variable name"));
            } else
            {
                obj = ((Object) (new Object[] {
                    "expected a variable name"
                }));
            }
            return prim_syntax.syntaxError(((Object) (aobj)), ((Object []) (obj)));
        }
        if (Lit11.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit12.execute(aobj, ((TemplateScope) (obj)));
        }
        if (Lit13.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit14.execute(aobj, ((TemplateScope) (obj)));
        }
        if (Lit15.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            if (std_syntax.isIdentifier(Lit16.execute(aobj, ((TemplateScope) (obj)))))
            {
                obj = TemplateScope.make();
                return Lit17.execute(aobj, ((TemplateScope) (obj)));
            }
            obj = TemplateScope.make();
            aobj = ((Object []) (Lit18.execute(aobj, ((TemplateScope) (obj)))));
            if ("expected a variable name" instanceof Object[])
            {
                obj = ((Object) ((Object[])"expected a variable name"));
            } else
            {
                obj = ((Object) (new Object[] {
                    "expected a variable name"
                }));
            }
            return prim_syntax.syntaxError(((Object) (aobj)), ((Object []) (obj)));
        }
        if (Lit19.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit20.execute(aobj, ((TemplateScope) (obj)));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            return lambda1(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
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

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit22 = (SimpleSymbol)(new SimpleSymbol("let")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("and")).readResolve();
        Lit20 = new SyntaxTemplate("\001", "\030\004", new Object[] {
            Boolean.TRUE
        }, 0);
        Lit17 = new SyntaxTemplate("\001\001\0", "\021\030\004\t\013\b\t\003\b\022", new Object[] {
            Lit21
        }, 0);
        Lit14 = new SyntaxTemplate("\001\001\0", "\021\030\004\t\013\b\t\003\b\022", new Object[] {
            Lit21
        }, 0);
        Lit12 = new SyntaxTemplate("\001\001\001\0", "\021\030\004)\b\t\013\b\023\b\021\030\f\t\013\b\t\003\b\032", new Object[] {
            Lit22, Lit21
        }, 0);
        Lit4 = new SyntaxTemplate("\001\001\001", "\021\030\004)\b\t\013\b\023\b\013", new Object[] {
            Lit22
        }, 0);
        Lit0 = (SimpleSymbol)(new SimpleSymbol("and-let*")).readResolve();
        $instance = new srfi2();
        and$Mnlet$St = Macro.make(Lit0, new ModuleMethod($instance, 1, null, 4097), $instance);
        $instance.run();
    }
}
