// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.EofClass;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import gnu.text.SourceMessages;
import kawa.lang.Macro;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.Translator;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class syntaxutils extends ModuleBody
{
    public class frame extends ModuleBody
    {

        LList pack;

        public frame()
        {
        }
    }

    public class frame0 extends ModuleBody
    {

        LList pack;

        public frame0()
        {
        }
    }

    public class frame1 extends ModuleBody
    {

        LList pack;

        public frame1()
        {
        }
    }


    public static final Macro $Prvt$$Ex;
    public static final Macro $Prvt$typecase$Pc;
    public static final syntaxutils $instance;
    static final Keyword Lit0 = Keyword.make("env");
    static final PairWithPosition Lit1;
    static final PairWithPosition Lit10;
    static final PairWithPosition Lit11;
    static final PairWithPosition Lit12;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final SimpleSymbol Lit15;
    static final SyntaxRules Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final Keyword Lit2 = Keyword.make("lang");
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final PairWithPosition Lit3;
    static final PairWithPosition Lit4;
    static final PairWithPosition Lit5;
    static final PairWithPosition Lit6;
    static final IntNum Lit7 = IntNum.make(0);
    static final IntNum Lit8 = IntNum.make(1);
    static final PairWithPosition Lit9;
    public static final ModuleMethod expand;

    public syntaxutils()
    {
        ModuleInfo.register(this);
    }

    public static Object expand$V(Object obj, Object aobj[])
    {
        Object obj1 = Keyword.searchForKeyword(aobj, 0, Lit0);
        aobj = ((Object []) (obj1));
        if (obj1 == Special.dfault)
        {
            aobj = misc.interactionEnvironment();
        }
        return unrewrite(rewriteForm$V(Quote.append$V(new Object[] {
            Lit1, Quote.consX$V(new Object[] {
                obj, LList.Empty
            })
        }), new Object[] {
            Lit0, aobj
        }));
    }

    static Expression rewriteForm$V(Object obj, Object aobj[])
    {
        Object obj2 = Keyword.searchForKeyword(aobj, 0, Lit2);
        Object obj1 = obj2;
        if (obj2 == Special.dfault)
        {
            obj1 = Language.getDefaultLanguage();
        }
        obj2 = Keyword.searchForKeyword(aobj, 0, Lit0);
        aobj = ((Object []) (obj2));
        if (obj2 == Special.dfault)
        {
            aobj = misc.interactionEnvironment();
        }
        Language language;
        try
        {
            obj2 = (Environment)aobj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "gnu.expr.NameLookup.getInstance(gnu.mapping.Environment,gnu.expr.Language)", 1, ((Object) (aobj)));
        }
        try
        {
            aobj = (Language)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "gnu.expr.NameLookup.getInstance(gnu.mapping.Environment,gnu.expr.Language)", 2, obj1);
        }
        aobj = NameLookup.getInstance(((Environment) (obj2)), ((Language) (aobj)));
        obj2 = new SourceMessages();
        try
        {
            language = (Language)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "kawa.lang.Translator.<init>(gnu.expr.Language,gnu.text.SourceMessages,gnu.expr.NameLookup)", 1, obj1);
        }
        obj1 = new Translator(language, ((SourceMessages) (obj2)), ((NameLookup) (aobj)));
        ((Translator) (obj1)).pushNewModule(null);
        aobj = Compilation.setSaveCurrent(((Compilation) (obj1)));
        obj = ((Translator) (obj1)).rewrite(obj);
        Compilation.restoreCurrent(((Compilation) (aobj)));
        return ((Expression) (obj));
        obj;
        Compilation.restoreCurrent(((Compilation) (aobj)));
        throw obj;
    }

    static Object unrewrite(Expression expression)
    {
        Object obj = new frame();
        if (expression instanceof LetExp)
        {
            Object obj1;
            Object obj2;
            IfExp ifexp;
            try
            {
                obj = (LetExp)expression;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "exp", -2, expression);
            }
            obj = unrewriteLet(((LetExp) (obj)));
        } else
        {
            if (expression instanceof QuoteExp)
            {
                try
                {
                    obj = (QuoteExp)expression;
                }
                catch (ClassCastException classcastexception1)
                {
                    throw new WrongType(classcastexception1, "exp", -2, expression);
                }
                return unrewriteQuote(((QuoteExp) (obj)));
            }
            if (expression instanceof SetExp)
            {
                try
                {
                    obj = (SetExp)expression;
                }
                catch (ClassCastException classcastexception2)
                {
                    throw new WrongType(classcastexception2, "exp", -2, expression);
                }
                return Quote.append$V(new Object[] {
                    Lit3, Quote.consX$V(new Object[] {
                        ((SetExp) (obj)).getSymbol(), Quote.consX$V(new Object[] {
                            unrewrite(((SetExp) (obj)).getNewValue()), LList.Empty
                        })
                    })
                });
            }
            if (expression instanceof LambdaExp)
            {
                try
                {
                    obj1 = (LambdaExp)expression;
                }
                catch (ClassCastException classcastexception3)
                {
                    throw new WrongType(classcastexception3, "exp", -2, expression);
                }
                obj2 = Lit4;
                obj.pack = LList.Empty;
                for (expression = ((LambdaExp) (obj1)).firstDecl(); expression != null; expression = expression.nextDecl())
                {
                    obj.pack = lists.cons(expression.getSymbol(), ((frame) (obj)).pack);
                }

                return Quote.append$V(new Object[] {
                    obj2, Quote.consX$V(new Object[] {
                        lists.reverse$Ex(((frame) (obj)).pack), Quote.consX$V(new Object[] {
                            unrewrite(((LambdaExp) (obj1)).body), LList.Empty
                        })
                    })
                });
            }
            if (expression instanceof ReferenceExp)
            {
                try
                {
                    obj = (ReferenceExp)expression;
                }
                catch (ClassCastException classcastexception4)
                {
                    throw new WrongType(classcastexception4, "exp", -2, expression);
                }
                return ((ReferenceExp) (obj)).getSymbol();
            }
            if (expression instanceof ApplyExp)
            {
                try
                {
                    obj = (ApplyExp)expression;
                }
                catch (ClassCastException classcastexception5)
                {
                    throw new WrongType(classcastexception5, "exp", -2, expression);
                }
                return unrewriteApply(((ApplyExp) (obj)));
            }
            if (expression instanceof BeginExp)
            {
                try
                {
                    obj = (BeginExp)expression;
                }
                catch (ClassCastException classcastexception6)
                {
                    throw new WrongType(classcastexception6, "exp", -2, expression);
                }
                return Quote.append$V(new Object[] {
                    Lit5, unrewrite$St(((BeginExp) (obj)).getExpressions())
                });
            }
            obj = expression;
            if (expression instanceof IfExp)
            {
                try
                {
                    ifexp = (IfExp)expression;
                }
                catch (ClassCastException classcastexception7)
                {
                    throw new WrongType(classcastexception7, "exp", -2, expression);
                }
                obj = Lit6;
                obj1 = unrewrite(ifexp.getTest());
                obj2 = unrewrite(ifexp.getThenClause());
                expression = ifexp.getElseClause();
                if (expression == null)
                {
                    expression = LList.Empty;
                } else
                {
                    expression = LList.list1(unrewrite(expression));
                }
                return Quote.append$V(new Object[] {
                    obj, Quote.consX$V(new Object[] {
                        obj1, Quote.consX$V(new Object[] {
                            obj2, Quote.append$V(new Object[] {
                                expression, LList.Empty
                            })
                        })
                    })
                });
            }
        }
        return obj;
    }

    static Object unrewrite$St(Expression aexpression[])
    {
        frame0 frame0_1 = new frame0();
        frame0_1.pack = LList.Empty;
        int i = aexpression.length;
        for (Object obj = Lit7; Scheme.numEqu.apply2(obj, Integer.valueOf(i)) == Boolean.FALSE; obj = AddOp.$Pl.apply2(obj, Lit8))
        {
            frame0_1.pack = lists.cons(unrewrite(aexpression[((Number)obj).intValue()]), frame0_1.pack);
        }

        return lists.reverse$Ex(frame0_1.pack);
    }

    static Object unrewriteApply(ApplyExp applyexp)
    {
        Expression expression = applyexp.getFunction();
        Object obj1 = unrewrite$St(applyexp.getArgs());
        if (expression instanceof ReferenceExp)
        {
            Object obj;
            Declaration declaration;
            int i;
            try
            {
                obj = (ReferenceExp)expression;
            }
            // Misplaced declaration of an exception variable
            catch (ApplyExp applyexp)
            {
                throw new WrongType(applyexp, "fun", -2, expression);
            }
            obj = ((ReferenceExp) (obj)).getBinding();
        } else
        {
            obj = null;
        }
        declaration = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
        applyexp = ((ApplyExp) (applyexp.getFunctionValue()));
        if (obj == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        i = i + 1 & 1;
        if (i != 0)
        {
            if (declaration == null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            i = i + 1 & 1;
            if (i == 0 ? i != 0 : SlotGet.getSlotValue(false, obj, "field", "field", "getField", "isField", Scheme.instance) == declaration.field)
            {
                return obj1;
            }
        } else
        if (i != 0)
        {
            return obj1;
        }
        if (applyexp instanceof Convert)
        {
            applyexp = ((ApplyExp) (Quote.append$V(new Object[] {
                Lit11, obj1
            })));
        } else
        if (applyexp instanceof GetNamedPart)
        {
            applyexp = ((ApplyExp) (Quote.append$V(new Object[] {
                Lit12, obj1
            })));
        } else
        {
            applyexp = Boolean.FALSE;
        }
        if (applyexp != Boolean.FALSE)
        {
            return applyexp;
        } else
        {
            return Quote.consX$V(new Object[] {
                unrewrite(expression), obj1
            });
        }
    }

    static Object unrewriteLet(LetExp letexp)
    {
        frame1 frame1_1 = new frame1();
        PairWithPosition pairwithposition = Lit9;
        frame1_1.pack = LList.Empty;
        Declaration declaration = letexp.firstDecl();
        for (Object obj = Lit7; declaration != null; obj = AddOp.$Pl.apply2(obj, Lit8))
        {
            frame1_1.pack = lists.cons(LList.list2(declaration.getSymbol(), unrewrite(letexp.inits[((Number)obj).intValue()])), frame1_1.pack);
            declaration = declaration.nextDecl();
        }

        return Quote.append$V(new Object[] {
            pairwithposition, Quote.consX$V(new Object[] {
                lists.reverse$Ex(frame1_1.pack), Quote.consX$V(new Object[] {
                    unrewrite(letexp.body), LList.Empty
                })
            })
        });
    }

    static Object unrewriteQuote(QuoteExp quoteexp)
    {
        Object obj = quoteexp.getValue();
        if (Numeric.asNumericOrNull(obj) != null)
        {
            try
            {
                quoteexp = LangObjType.coerceNumeric(obj);
            }
            // Misplaced declaration of an exception variable
            catch (QuoteExp quoteexp)
            {
                throw new WrongType(quoteexp, "val", -2, obj);
            }
        } else
        {
            if (obj instanceof Boolean)
            {
                boolean flag;
                try
                {
                    quoteexp = Boolean.FALSE;
                }
                // Misplaced declaration of an exception variable
                catch (QuoteExp quoteexp)
                {
                    throw new WrongType(quoteexp, "val", -2, obj);
                }
                if (obj != quoteexp)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    quoteexp = Boolean.TRUE;
                } else
                {
                    quoteexp = Boolean.FALSE;
                }
                return quoteexp;
            }
            if (obj instanceof Char)
            {
                try
                {
                    quoteexp = (Char)obj;
                }
                // Misplaced declaration of an exception variable
                catch (QuoteExp quoteexp)
                {
                    throw new WrongType(quoteexp, "val", -2, obj);
                }
                return quoteexp;
            }
            if (obj instanceof Keyword)
            {
                try
                {
                    quoteexp = (Keyword)obj;
                }
                // Misplaced declaration of an exception variable
                catch (QuoteExp quoteexp)
                {
                    throw new WrongType(quoteexp, "val", -2, obj);
                }
                return quoteexp;
            }
            if (obj instanceof CharSequence)
            {
                try
                {
                    quoteexp = (CharSequence)obj;
                }
                // Misplaced declaration of an exception variable
                catch (QuoteExp quoteexp)
                {
                    throw new WrongType(quoteexp, "val", -2, obj);
                }
                return quoteexp;
            }
            quoteexp = ((QuoteExp) (obj));
            if (obj != Special.undefined)
            {
                quoteexp = ((QuoteExp) (obj));
                if (obj != EofClass.eofValue)
                {
                    if (obj instanceof Type)
                    {
                        try
                        {
                            quoteexp = (Type)obj;
                        }
                        // Misplaced declaration of an exception variable
                        catch (QuoteExp quoteexp)
                        {
                            throw new WrongType(quoteexp, "val", -2, obj);
                        }
                        quoteexp = quoteexp.getName();
                    } else
                    if (obj instanceof Class)
                    {
                        try
                        {
                            quoteexp = (Class)obj;
                        }
                        // Misplaced declaration of an exception variable
                        catch (QuoteExp quoteexp)
                        {
                            throw new WrongType(quoteexp, "val", -2, obj);
                        }
                        quoteexp = quoteexp.getName();
                    } else
                    {
                        return Quote.append$V(new Object[] {
                            Lit10, Quote.consX$V(new Object[] {
                                obj, LList.Empty
                            })
                        });
                    }
                    return misc.string$To$Symbol(Format.formatToString(0, new Object[] {
                        "<~a>", quoteexp
                    }));
                }
            }
        }
        return quoteexp;
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
                    return expand$V(modulemethod, aobj1);
                }
                aobj1[i] = aobj[i + 1];
            } while (true);
        } else
        {
            return super.applyN(modulemethod, aobj);
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
        Lit26 = (SimpleSymbol)(new SimpleSymbol("lambda")).readResolve();
        Lit25 = (SimpleSymbol)(new SimpleSymbol("as")).readResolve();
        Lit24 = (SimpleSymbol)(new SimpleSymbol("else")).readResolve();
        Lit23 = (SimpleSymbol)(new SimpleSymbol("let")).readResolve();
        Lit22 = (SimpleSymbol)(new SimpleSymbol("cond")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("begin")).readResolve();
        Lit20 = (SimpleSymbol)(new SimpleSymbol("or")).readResolve();
        Lit19 = (SimpleSymbol)(new SimpleSymbol("quote")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("eql")).readResolve();
        Lit17 = (SimpleSymbol)(new SimpleSymbol("expand")).readResolve();
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("!")).readResolve();
        Lit15 = simplesymbol;
        Object obj = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", new Object[0], 3), "\001\001\003", "\021\030\004\t\013)\021\030\f\b\003\b\025\023", new Object[] {
            (SimpleSymbol)(new SimpleSymbol("invoke")).readResolve(), Lit19
        }, 1);
        Lit16 = new SyntaxRules(new Object[] {
            simplesymbol
        }, new SyntaxRule[] {
            obj
        }, 3);
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("typecase%")).readResolve();
        Lit13 = simplesymbol;
        obj = Lit18;
        SimpleSymbol simplesymbol1 = Lit20;
        SyntaxRule syntaxrule = new SyntaxRule(new SyntaxPattern("\f\030\f\007<\f\002\r\017\b\b\b\r\027\020\b\b", new Object[] {
            Boolean.TRUE
        }, 3), "\001\003\003", "\021\030\004\b\r\013", new Object[] {
            Lit21
        }, 1);
        SyntaxRule syntaxrule1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\\,\f\002\f\017\b\r\027\020\b\b\r\037\030\b\b", new Object[] {
            Lit18
        }, 4), "\001\001\003\003", "\021\030\004yY\021\030\f\t\003\b\021\030\024\b\013\b\025\023\b\021\030\034\b\021\030$\t\003\b\035\033", new Object[] {
            Lit22, (SimpleSymbol)(new SimpleSymbol("eqv?")).readResolve(), Lit19, Lit24, Lit13
        }, 1);
        SyntaxRule syntaxrule2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\\,\f\002\f\017\b\r\027\020\b\b\r\037\030\b\b", new Object[] {
            Lit20
        }, 4), "\001\001\003\003", "\021\030\004\t\003)\t\013\b\025\023\b\035\033", new Object[] {
            Lit13
        }, 1);
        SyntaxRule syntaxrule3 = new SyntaxRule(new SyntaxPattern("\f\030\f\007l<\f\002\r\017\b\b\b\r\027\020\b\b\r\037\030\b\b", new Object[] {
            Lit20
        }, 4), "\001\003\003\003", "\021\030\004\221\b\021\030\f\b\021\030\024\021\b\003\b\021\030\034\b\025\023\b\021\030$\t\003I\r\t\013\b\021\030\f\b\003\b\021\030,\b\021\030$\t\003\b\035\033", new Object[] {
            Lit23, (SimpleSymbol)(new SimpleSymbol("f")).readResolve(), Lit26, Lit21, Lit13, Boolean.TRUE
        }, 1);
        SyntaxRule syntaxrule4 = new SyntaxRule(new SyntaxPattern("\f\030\f\007<\f\017\r\027\020\b\b\r\037\030\b\b", new Object[0], 4), "\001\001\003\003", "\021\030\004\3619\021\030\f\t\003\b\013\b\021\030\024Q\b\t\003\021\030\034\t\013\b\003\b\021\030$\b\025\023\b\021\030,\b\021\0304\t\003\b\035\033", new Object[] {
            Lit22, (SimpleSymbol)(new SimpleSymbol("instance?")).readResolve(), Lit23, (SimpleSymbol)(new SimpleSymbol("::")).readResolve(), Lit21, Lit24, Lit13
        }, 1);
        SyntaxRule syntaxrule5 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\b", new Object[0], 1), "\001", "\021\030\004\021\030\f\t\003\b\021\030\024\021\030\034\b\021\030$\021\030,\b\003", new Object[] {
            (SimpleSymbol)(new SimpleSymbol("error")).readResolve(), "typecase% failed", Lit15, (SimpleSymbol)(new SimpleSymbol("getClass")).readResolve(), Lit25, (SimpleSymbol)(new SimpleSymbol("<object>")).readResolve()
        }, 0);
        Lit14 = new SyntaxRules(new Object[] {
            simplesymbol, obj, simplesymbol1
        }, new SyntaxRule[] {
            syntaxrule, syntaxrule1, syntaxrule2, syntaxrule3, syntaxrule4, syntaxrule5
        }, 4);
        Lit12 = PairWithPosition.make((SimpleSymbol)(new SimpleSymbol(":")).readResolve(), LList.Empty, "syntaxutils.scm", 0x9b010);
        Lit11 = PairWithPosition.make(Lit25, LList.Empty, "syntaxutils.scm", 0x99010);
        Lit10 = PairWithPosition.make(Lit19, LList.Empty, "syntaxutils.scm", 0x8700c);
        Lit9 = PairWithPosition.make(Lit23, LList.Empty, "syntaxutils.scm", 0x75004);
        Lit6 = PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("if")).readResolve(), LList.Empty, "syntaxutils.scm", 0x66007);
        Lit5 = PairWithPosition.make(Lit21, LList.Empty, "syntaxutils.scm", 0x6401b);
        Lit4 = PairWithPosition.make(Lit26, LList.Empty, "syntaxutils.scm", 0x5c007);
        Lit3 = PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("set")).readResolve(), LList.Empty, "syntaxutils.scm", 0x5a007);
        Lit1 = PairWithPosition.make(Lit21, LList.Empty, "syntaxutils.scm", 0x4401d);
        $instance = new syntaxutils();
        $Prvt$typecase$Pc = Macro.make(Lit13, Lit14, $instance);
        $Prvt$$Ex = Macro.make(Lit15, Lit16, $instance);
        expand = new ModuleMethod($instance, 1, Lit17, -4095);
        $instance.run();
    }
}
