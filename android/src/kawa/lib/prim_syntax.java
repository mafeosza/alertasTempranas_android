// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.math.IntNum;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.standard.syntax_case;
import kawa.standard.syntax_error;
import kawa.standard.try_catch;

public class prim_syntax extends ModuleBody
{
    public class frame extends ModuleBody
    {

        Object $unnamed$0[];
        Object out$Mnbindings;
        Object out$Mninits;

        public Object lambda4processBinding(Object obj)
        {
            Object aobj[] = SyntaxPattern.allocVars(8, $unnamed$0);
            if (prim_syntax.Lit34.match(obj, aobj, 0))
            {
                return Values.empty;
            }
            if (prim_syntax.Lit35.match(obj, aobj, 0))
            {
                obj = TemplateScope.make();
                out$Mnbindings = new Pair(prim_syntax.Lit36.execute(aobj, ((TemplateScope) (obj))), out$Mnbindings);
                obj = TemplateScope.make();
                out$Mninits = new Pair(prim_syntax.Lit37.execute(aobj, ((TemplateScope) (obj))), out$Mninits);
                obj = TemplateScope.make();
                return lambda4processBinding(prim_syntax.Lit38.execute(aobj, ((TemplateScope) (obj))));
            }
            if (prim_syntax.Lit39.match(obj, aobj, 0))
            {
                obj = TemplateScope.make();
                out$Mnbindings = new Pair(prim_syntax.Lit40.execute(aobj, ((TemplateScope) (obj))), out$Mnbindings);
                obj = TemplateScope.make();
                out$Mninits = new Pair(prim_syntax.Lit41.execute(aobj, ((TemplateScope) (obj))), out$Mninits);
                obj = TemplateScope.make();
                return lambda4processBinding(prim_syntax.Lit42.execute(aobj, ((TemplateScope) (obj))));
            }
            if (prim_syntax.Lit43.match(obj, aobj, 0))
            {
                if ("missing initializion in letrec" instanceof Object[])
                {
                    aobj = (Object[])"missing initializion in letrec";
                } else
                {
                    aobj = (new Object[] {
                        "missing initializion in letrec"
                    });
                }
                return prim_syntax.syntaxError(obj, aobj);
            }
            if (prim_syntax.Lit44.match(obj, aobj, 0))
            {
                Object aobj1[];
                if ("invalid bindings syntax in letrec" instanceof Object[])
                {
                    aobj1 = (Object[])"invalid bindings syntax in letrec";
                } else
                {
                    aobj1 = (new Object[] {
                        "invalid bindings syntax in letrec"
                    });
                }
                return prim_syntax.syntaxError(obj, aobj1);
            } else
            {
                return syntax_case.error("syntax-case", obj);
            }
        }

        public frame()
        {
        }
    }


    public static final prim_syntax $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final SyntaxRules Lit10;
    static final SimpleSymbol Lit11;
    static final SyntaxRules Lit12;
    static final SimpleSymbol Lit13;
    static final SyntaxPattern Lit14 = new SyntaxPattern("\f\007\f\017\f\027\b", new Object[0], 3);
    static final SyntaxTemplate Lit15 = new SyntaxTemplate("\001\001\001", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit16 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    static final SyntaxPattern Lit17 = new SyntaxPattern("\f\007\f\017\f\027\f\037\b", new Object[0], 4);
    static final SyntaxTemplate Lit18 = new SyntaxTemplate("\001\001\001\001", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit19 = new SyntaxTemplate("\001\001\001\001", "\023", new Object[0], 0);
    static final SimpleSymbol Lit2;
    static final SyntaxTemplate Lit20 = new SyntaxTemplate("\001\001\001\001", "\033", new Object[0], 0);
    static final SyntaxPattern Lit21 = new SyntaxPattern("\f\007\f\017\f\027\f\037\f'+", new Object[0], 6);
    static final SyntaxTemplate Lit22 = new SyntaxTemplate("\001\001\001\001\001\0", "#", new Object[0], 0);
    static final SyntaxPattern Lit23 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    static final SyntaxTemplate Lit24 = new SyntaxTemplate("\001\0", "\n", new Object[0], 0);
    static final SimpleSymbol Lit25;
    static final SyntaxPattern Lit26 = new SyntaxPattern("\f\007\f\017-\f\027\f\037#\020\030\b", new Object[0], 5);
    static final SyntaxTemplate Lit27 = new SyntaxTemplate("\001\001\003\003\002", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit28;
    static final SimpleSymbol Lit29;
    static final SyntaxRules Lit3;
    static final SyntaxPattern Lit30 = new SyntaxPattern("\f\007\f\017\023", new Object[0], 3);
    static final SyntaxTemplate Lit31 = new SyntaxTemplate("\001\001\0", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit32;
    static final SyntaxTemplate Lit33 = new SyntaxTemplate("\001\001\0", "\022", new Object[0], 0);
    static final SyntaxPattern Lit34 = new SyntaxPattern("\b", new Object[0], 3);
    static final SyntaxPattern Lit35 = new SyntaxPattern(",\f\037\f'\b+", new Object[0], 6);
    static final SyntaxTemplate Lit36;
    static final SyntaxTemplate Lit37;
    static final SyntaxTemplate Lit38 = new SyntaxTemplate("\001\001\000\001\001\0", "*", new Object[0], 0);
    static final SyntaxPattern Lit39 = new SyntaxPattern("L\f\037\f'\f/\f7\b;", new Object[0], 8);
    static final SimpleSymbol Lit4;
    static final SyntaxTemplate Lit40;
    static final SyntaxTemplate Lit41;
    static final SyntaxTemplate Lit42 = new SyntaxTemplate("\001\001\000\001\001\001\001\0", ":", new Object[0], 0);
    static final SyntaxPattern Lit43 = new SyntaxPattern("\034\f\037\b#", new Object[0], 5);
    static final SyntaxPattern Lit44 = new SyntaxPattern("\033", new Object[0], 4);
    static final SimpleSymbol Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit50;
    static final IntNum Lit51;
    static final IntNum Lit52;
    static final IntNum Lit53;
    static final IntNum Lit54;
    static final IntNum Lit55;
    static final IntNum Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit6;
    static final SyntaxRules Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final Macro define;
    public static final Macro define$Mnconstant;
    public static final Macro define$Mnprivate;
    public static final Macro define$Mnsyntax;
    public static final Macro _fldif;
    public static final Macro letrec;
    public static final Macro syntax$Mn$Grexpression;
    public static final Macro syntax$Mnbody$Mn$Grexpression;
    public static final ModuleMethod syntax$Mnerror;
    public static final Macro try$Mncatch;

    public prim_syntax()
    {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(6, null);
        if (Lit14.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            obj = SyntaxForms.rewrite(Lit15.execute(aobj, ((TemplateScope) (obj))));
            TemplateScope templatescope = TemplateScope.make();
            return new IfExp(((Expression) (obj)), SyntaxForms.rewrite(Lit16.execute(aobj, templatescope)), null);
        }
        if (Lit17.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            obj = SyntaxForms.rewrite(Lit18.execute(aobj, ((TemplateScope) (obj))));
            Object obj2 = TemplateScope.make();
            obj2 = SyntaxForms.rewrite(Lit19.execute(aobj, ((TemplateScope) (obj2))));
            TemplateScope templatescope1 = TemplateScope.make();
            return new IfExp(((Expression) (obj)), ((Expression) (obj2)), SyntaxForms.rewrite(Lit20.execute(aobj, templatescope1)));
        }
        if (Lit21.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            aobj = ((Object []) (Lit22.execute(aobj, ((TemplateScope) (obj)))));
            if ("too many expressions for 'if'" instanceof Object[])
            {
                obj = ((Object) ((Object[])"too many expressions for 'if'"));
            } else
            {
                obj = ((Object) (new Object[] {
                    "too many expressions for 'if'"
                }));
            }
            return syntaxError(((Object) (aobj)), ((Object []) (obj)));
        }
        if (Lit23.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            Object obj1 = Lit24.execute(aobj, ((TemplateScope) (obj)));
            if ("too few expressions for 'if'" instanceof Object[])
            {
                obj = ((Object) ((Object[])"too few expressions for 'if'"));
            } else
            {
                obj = ((Object) (new Object[] {
                    "too few expressions for 'if'"
                }));
            }
            return syntaxError(obj1, ((Object []) (obj)));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda2(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(5, null);
        if (Lit26.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            obj = Lit27.execute(aobj, ((TemplateScope) (obj)));
            TemplateScope templatescope = TemplateScope.make();
            return try_catch.rewrite(obj, Lit28.execute(aobj, templatescope));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda3(Object obj)
    {
        frame frame1 = new frame();
        LList llist = LList.Empty;
        frame1.Mninits = LList.Empty;
        frame1.Mnbindings = llist;
        frame1._fld0 = SyntaxPattern.allocVars(3, null);
        if (Lit30.match(obj, frame1._fld0, 0))
        {
            obj = TemplateScope.make();
            frame1.lambda4processBinding(Lit31.execute(frame1._fld0, ((TemplateScope) (obj))));
            frame1.Mnbindings = LList.reverseInPlace(frame1.Mnbindings);
            frame1.Mninits = LList.reverseInPlace(frame1.Mninits);
            obj = TemplateScope.make();
            return Quote.append$V(new Object[] {
                Lit32.execute(frame1._fld0, ((TemplateScope) (obj))), Quote.consX$V(new Object[] {
                    frame1.Mnbindings, Quote.append$V(new Object[] {
                        frame1.Mninits, Lit33.execute(frame1._fld0, ((TemplateScope) (obj)))
                    })
                })
            });
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    public static transient Expression syntaxError(Object obj, Object aobj[])
    {
        return syntax_error.error(obj, aobj);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 2: // '\002'
            return lambda1(obj);

        case 3: // '\003'
            return lambda2(obj);

        case 4: // '\004'
            return lambda3(obj);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        if (modulemethod.selector == 1)
        {
            modulemethod = ((ModuleMethod) (aobj[0]));
            int i = aobj.length - 1;
            Object aobj1[] = new Object[i];
            do
            {
                i--;
                if (i < 0)
                {
                    return syntaxError(modulemethod, aobj1);
                }
                aobj1[i] = aobj[i + 1];
            } while (true);
        } else
        {
            return super.applyN(modulemethod, aobj);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 4: // '\004'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 3: // '\003'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        if (modulemethod.selector == 1)
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
        Lit58 = (SimpleSymbol)(new SimpleSymbol("lambda")).readResolve();
        Lit57 = (SimpleSymbol)(new SimpleSymbol("%define-syntax")).readResolve();
        Lit56 = IntNum.make(0);
        Lit55 = IntNum.make(1);
        Lit54 = IntNum.make(4);
        Lit53 = IntNum.make(5);
        Lit52 = IntNum.make(8);
        Lit51 = IntNum.make(9);
        Lit50 = (SimpleSymbol)(new SimpleSymbol("%define")).readResolve();
        Lit49 = (SimpleSymbol)(new SimpleSymbol("::")).readResolve();
        Lit48 = (SimpleSymbol)(new SimpleSymbol("quasiquote")).readResolve();
        Lit47 = (SimpleSymbol)(new SimpleSymbol("kawa.lang.SyntaxForms")).readResolve();
        Lit46 = (SimpleSymbol)(new SimpleSymbol("$lookup$")).readResolve();
        Lit45 = (SimpleSymbol)(new SimpleSymbol("set!")).readResolve();
        Lit41 = new SyntaxTemplate("\001\001\000\001\001\001\001\0", "\021\030\004\t\033\b3", new Object[] {
            Lit45
        }, 0);
        Lit40 = new SyntaxTemplate("\001\001\000\001\001\001\001\0", "\t\033\t#\t+\030\004", new Object[] {
            PairWithPosition.make(Special.undefined, LList.Empty, "prim_syntax.scm", 0x7303e)
        }, 0);
        Lit37 = new SyntaxTemplate("\001\001\000\001\001\0", "\021\030\004\t\033\b#", new Object[] {
            Lit45
        }, 0);
        Lit36 = new SyntaxTemplate("\001\001\000\001\001\0", "\t\033\030\004", new Object[] {
            PairWithPosition.make(Special.undefined, LList.Empty, "prim_syntax.scm", 0x6e022)
        }, 0);
        Lit32 = new SyntaxTemplate("\001\001\0", "\030\004", new Object[] {
            PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("%let")).readResolve(), LList.Empty, "prim_syntax.scm", 0x7d00b)
        }, 0);
        Lit29 = (SimpleSymbol)(new SimpleSymbol("letrec")).readResolve();
        Lit28 = new SyntaxTemplate("\001\001\003\003\002", "(\b\025A\b\t\023\021\030\004\b\033\"", new Object[] {
            Lit49
        }, 1);
        Lit25 = (SimpleSymbol)(new SimpleSymbol("try-catch")).readResolve();
        Lit13 = (SimpleSymbol)(new SimpleSymbol("if")).readResolve();
        Object obj = (SimpleSymbol)(new SimpleSymbol("syntax-body->expression")).readResolve();
        Lit11 = ((SimpleSymbol) (obj));
        Object obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\b", new Object[0], 1), "\001", "\021\030\004\b\003", new Object[] {
            PairWithPosition.make(Lit46, Pair.make(Lit47, Pair.make(Pair.make(Lit48, Pair.make((SimpleSymbol)(new SimpleSymbol("rewriteBody")).readResolve(), LList.Empty)), LList.Empty)), "prim_syntax.scm", 0x42007)
        }, 0);
        Lit12 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        obj = (SimpleSymbol)(new SimpleSymbol("syntax->expression")).readResolve();
        Lit9 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\b", new Object[0], 1), "\001", "\021\030\004\b\003", new Object[] {
            PairWithPosition.make(Lit46, Pair.make(Lit47, Pair.make(Pair.make(Lit48, Pair.make((SimpleSymbol)(new SimpleSymbol("rewrite")).readResolve(), LList.Empty)), LList.Empty)), "prim_syntax.scm", 0x3d007)
        }, 0);
        Lit10 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        Lit8 = (SimpleSymbol)(new SimpleSymbol("syntax-error")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("define-constant")).readResolve();
        Lit6 = ((SimpleSymbol) (obj));
        obj1 = Lit49;
        Object obj2 = Lit46;
        SyntaxRule syntaxrule = new SyntaxRule(new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", new Object[] {
            Lit46, Lit49
        }, 5), "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\t\033\b#", new Object[] {
            Lit50, Lit46, Lit51
        }, 0);
        Object obj3 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", new Object[] {
            Lit46
        }, 4);
        Object aobj[] = new Object[4];
        aobj[0] = Lit50;
        aobj[1] = Lit46;
        aobj[2] = Lit52;
        obj3 = new SyntaxRule(((SyntaxPattern) (obj3)), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\021\030\034\b\033", aobj, 0);
        SyntaxRule syntaxrule1 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3), "\001\000\0", "\021\030\004\t\003\021\030\f\021\030\024\t\n\022", new Object[] {
            Lit50, IntNum.make(10), Boolean.TRUE
        }, 0);
        SyntaxRule syntaxrule2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", new Object[] {
            Lit49
        }, 3), "\001\001\001", "\021\030\004\t\003\021\030\f\t\013\b\023", new Object[] {
            Lit50, Lit51
        }, 0);
        Object obj4 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
        Object aobj1[] = new Object[3];
        aobj1[0] = Lit50;
        aobj1[1] = Lit52;
        obj4 = new SyntaxRule(((SyntaxPattern) (obj4)), "\001\001", "\021\030\004\t\003\021\030\f\021\030\024\b\013", aobj1, 0);
        Lit7 = new SyntaxRules(new Object[] {
            obj, obj1, obj2
        }, new SyntaxRule[] {
            syntaxrule, obj3, syntaxrule1, syntaxrule2, obj4
        }, 5);
        obj = (SimpleSymbol)(new SimpleSymbol("define-private")).readResolve();
        Lit4 = ((SimpleSymbol) (obj));
        obj1 = Lit49;
        obj2 = Lit46;
        syntaxrule = new SyntaxRule(new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", new Object[] {
            Lit46, Lit49
        }, 5), "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\t\033\b#", new Object[] {
            Lit50, Lit46, Lit53
        }, 0);
        obj3 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", new Object[] {
            Lit46
        }, 4);
        syntaxrule1 = ((SyntaxRule) (new Object[4]));
        syntaxrule1[0] = Lit50;
        syntaxrule1[1] = Lit46;
        syntaxrule1[2] = Lit54;
        obj3 = new SyntaxRule(((SyntaxPattern) (obj3)), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\021\030\034\b\033", syntaxrule1, 0);
        syntaxrule1 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3), "\001\000\0", "\021\030\004\t\003\021\030\f\021\030\024\t\n\022", new Object[] {
            Lit50, IntNum.make(6), Boolean.TRUE
        }, 0);
        syntaxrule2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", new Object[] {
            Lit49
        }, 3), "\001\001\001", "\021\030\004\t\003\021\030\f\t\013\b\023", new Object[] {
            Lit50, Lit53
        }, 0);
        obj4 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
        aobj1 = new Object[3];
        aobj1[0] = Lit50;
        aobj1[1] = Lit54;
        obj4 = new SyntaxRule(((SyntaxPattern) (obj4)), "\001\001", "\021\030\004\t\003\021\030\f\021\030\024\b\013", aobj1, 0);
        Lit5 = new SyntaxRules(new Object[] {
            obj, obj1, obj2
        }, new SyntaxRule[] {
            syntaxrule, obj3, syntaxrule1, syntaxrule2, obj4
        }, 5);
        obj = (SimpleSymbol)(new SimpleSymbol("define")).readResolve();
        Lit2 = ((SimpleSymbol) (obj));
        obj1 = Lit49;
        obj2 = Lit46;
        syntaxrule = new SyntaxRule(new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", new Object[] {
            Lit46, Lit49
        }, 5), "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\t\033\b#", new Object[] {
            Lit50, Lit46, Lit55
        }, 0);
        obj3 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", new Object[] {
            Lit46
        }, 4);
        syntaxrule1 = ((SyntaxRule) (new Object[4]));
        syntaxrule1[0] = Lit50;
        syntaxrule1[1] = Lit46;
        syntaxrule1[2] = Lit56;
        obj3 = new SyntaxRule(((SyntaxPattern) (obj3)), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\021\030\034\b\033", syntaxrule1, 0);
        syntaxrule1 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3), "\001\000\0", "\021\030\004\t\003\021\030\f\021\030\024\t\n\022", new Object[] {
            Lit50, IntNum.make(2), Boolean.TRUE
        }, 0);
        syntaxrule2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", new Object[] {
            Lit49
        }, 3), "\001\001\001", "\021\030\004\t\003\021\030\f\t\013\b\023", new Object[] {
            Lit50, Lit55
        }, 0);
        obj4 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
        aobj1 = new Object[3];
        aobj1[0] = Lit50;
        aobj1[1] = Lit56;
        obj4 = new SyntaxRule(((SyntaxPattern) (obj4)), "\001\001", "\021\030\004\t\003\021\030\f\021\030\024\b\013", aobj1, 0);
        Lit3 = new SyntaxRules(new Object[] {
            obj, obj1, obj2
        }, new SyntaxRule[] {
            syntaxrule, obj3, syntaxrule1, syntaxrule2, obj4
        }, 5);
        obj = (SimpleSymbol)(new SimpleSymbol("define-syntax")).readResolve();
        Lit0 = ((SimpleSymbol) (obj));
        obj1 = Lit46;
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030l\\\f\002\f\007,\f\017\f\027\b\b\033#", new Object[] {
            Lit46
        }, 5), "\001\001\001\000\0", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\b\021\030\024\t\032\"", new Object[] {
            Lit57, Lit46, Lit58
        }, 0);
        syntaxrule = new SyntaxRule(new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", new Object[] {
            Lit46
        }, 4), "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\b\033", new Object[] {
            Lit57, Lit46
        }, 0);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3), "\001\000\0", "\021\030\004\t\003\b\021\030\f\t\n\022", new Object[] {
            Lit57, Lit58
        }, 0);
        syntaxrule1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\b\013", new Object[] {
            Lit57
        }, 0);
        Lit1 = new SyntaxRules(new Object[] {
            obj, obj1
        }, new SyntaxRule[] {
            obj2, syntaxrule, obj3, syntaxrule1
        }, 5);
        $instance = new prim_syntax();
        define$Mnsyntax = Macro.make(Lit0, Lit1, $instance);
        define = Macro.make(Lit2, Lit3, $instance);
        define$Mnprivate = Macro.make(Lit4, Lit5, $instance);
        define$Mnconstant = Macro.make(Lit6, Lit7, $instance);
        obj = $instance;
        syntax$Mnerror = new ModuleMethod(((ModuleBody) (obj)), 1, Lit8, -4095);
        syntax$Mn$Grexpression = Macro.make(Lit9, Lit10, $instance);
        syntax$Mnbody$Mn$Grexpression = Macro.make(Lit11, Lit12, $instance);
        obj1 = Lit13;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 2, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "prim_syntax.scm:69");
        _fldif = Macro.make(obj1, ((gnu.mapping.Procedure) (obj2)), $instance);
        obj1 = Lit25;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 3, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "prim_syntax.scm:89");
        try$Mncatch = Macro.make(obj1, ((gnu.mapping.Procedure) (obj2)), $instance);
        obj1 = Lit29;
        obj = new ModuleMethod(((ModuleBody) (obj)), 4, null, 4097);
        ((PropertySet) (obj)).setProperty("source-location", "prim_syntax.scm:98");
        letrec = Macro.make(obj1, ((gnu.mapping.Procedure) (obj)), $instance);
        $instance.run();
    }
}
