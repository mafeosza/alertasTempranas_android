// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.prim_syntax;
import kawa.lib.std_syntax;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.syntax_case;

public class enums extends ModuleBody
{

    public static final Macro $Prvt$$Pcdefine$Mnenum;
    public static final enums $instance;
    static final PairWithPosition Lit0;
    static final PairWithPosition Lit1;
    static final PairWithPosition Lit10;
    static final SimpleSymbol Lit11;
    static final SyntaxPattern Lit12 = new SyntaxPattern("\f\007\f\002\f\017,\r\027\020\b\b\f\037\f'\r/(\b\b", new Object[] {
        "findkeywords"
    }, 6);
    static final SyntaxTemplate Lit13 = new SyntaxTemplate("\001\001\003\001\001\003", "\033", new Object[0], 0);
    static final SyntaxTemplate Lit14;
    static final SyntaxPattern Lit15 = new SyntaxPattern("\f\007\f\002\f\017,\r\027\020\b\b\r\037\030\b\b", new Object[] {
        "findkeywords"
    }, 4);
    static final SyntaxTemplate Lit16;
    static final SyntaxPattern Lit17 = new SyntaxPattern("\f\007\b", new Object[0], 1);
    static final SyntaxPattern Lit18 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    static final SyntaxPattern Lit19 = new SyntaxPattern("\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    static final PairWithPosition Lit2;
    static final SyntaxTemplate Lit20;
    static final SimpleSymbol Lit21;
    static final SyntaxPattern Lit22 = new SyntaxPattern("\f\007\f\017\f\027,\r\037\030\b\b\r' \b\b", new Object[0], 5);
    static final SyntaxTemplate Lit23 = new SyntaxTemplate("\001\001\001\003\003", "\013", new Object[0], 0);
    static final SimpleSymbol Lit24 = (SimpleSymbol)(new SimpleSymbol("[]")).readResolve();
    static final SyntaxTemplate Lit25 = new SyntaxTemplate("\001\001\001\003\003", "\b\035\033", new Object[0], 1);
    static final SyntaxTemplate Lit26 = new SyntaxTemplate("\001\001\001\003\003", "\023", new Object[0], 0);
    static final SyntaxTemplate Lit27 = new SyntaxTemplate("\001\001\001\003\003", "\b%#", new Object[0], 1);
    static final SyntaxTemplate Lit28;
    static final SyntaxTemplate Lit29;
    static final PairWithPosition Lit3;
    static final SyntaxTemplate Lit30;
    static final SyntaxTemplate Lit31;
    static final SyntaxTemplate Lit32;
    static final SyntaxTemplate Lit33;
    static final SyntaxTemplate Lit34;
    static final SyntaxTemplate Lit35;
    static final SyntaxTemplate Lit36;
    static final SyntaxTemplate Lit37;
    static final SyntaxTemplate Lit38 = new SyntaxTemplate("\001\001\001\003\003", "\020", new Object[0], 0);
    static final SyntaxTemplate Lit39 = new SyntaxTemplate("\001\001\001\003\003", "\020", new Object[0], 0);
    static final PairWithPosition Lit4;
    static final SimpleSymbol Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final Keyword Lit46;
    static final SimpleSymbol Lit47;
    static final Keyword Lit48;
    static final SimpleSymbol Lit49;
    static final PairWithPosition Lit5;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final PairWithPosition Lit6;
    static final PairWithPosition Lit7;
    static final PairWithPosition Lit8;
    static final PairWithPosition Lit9;
    public static final Macro define$Mnenum;

    public enums()
    {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(6, null);
        if (Lit12.match(obj, aobj, 0))
        {
            TemplateScope templatescope = TemplateScope.make();
            if (std_syntax.isIdentifier(Lit13.execute(aobj, templatescope)))
            {
                obj = TemplateScope.make();
                return Lit14.execute(aobj, ((TemplateScope) (obj)));
            }
        }
        if (Lit15.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit16.execute(aobj, ((TemplateScope) (obj)));
        }
        if (Lit17.match(obj, aobj, 0))
        {
            if ("no enum type name given" instanceof Object[])
            {
                aobj = (Object[])"no enum type name given";
            } else
            {
                aobj = (new Object[] {
                    "no enum type name given"
                });
            }
            return prim_syntax.syntaxError(obj, aobj);
        }
        if (Lit18.match(obj, aobj, 0))
        {
            if ("no enum constants given" instanceof Object[])
            {
                aobj = (Object[])"no enum constants given";
            } else
            {
                aobj = (new Object[] {
                    "no enum constants given"
                });
            }
            return prim_syntax.syntaxError(obj, aobj);
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

    static Object lambda2(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(5, null);
        if (Lit22.match(obj, aobj, 0))
        {
            Object obj1 = TemplateScope.make();
            Object obj2 = Lit23.execute(aobj, ((TemplateScope) (obj1)));
            PairWithPosition pairwithposition;
            Object obj3;
            Object obj4;
            Object obj5;
            LList llist;
            try
            {
                obj1 = (Symbol)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "t-name", -2, obj2);
            }
            obj3 = symbolAppend$V(new Object[] {
                obj1, Lit24
            });
            obj2 = TemplateScope.make();
            obj2 = Lit25.execute(aobj, ((TemplateScope) (obj2)));
            try
            {
                obj4 = (LList)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "e-names", -2, obj2);
            }
            lists.length(((LList) (obj4)));
            obj2 = mapNames(((Symbol) (obj1)), ((LList) (obj4)), 0);
            pairwithposition = makeInit();
            obj3 = makeValues(((Symbol) (obj3)), ((LList) (obj4)));
            obj4 = TemplateScope.make();
            obj5 = Lit26.execute(aobj, ((TemplateScope) (obj4)));
            try
            {
                obj4 = (LList)obj5;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "opts", -2, obj5);
            }
            obj5 = TemplateScope.make();
            obj5 = Lit27.execute(aobj, ((TemplateScope) (obj5)));
            try
            {
                llist = (LList)obj5;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "other-defs", -2, obj5);
            }
            obj5 = TemplateScope.make();
            return Quote.append$V(new Object[] {
                Lit28.execute(aobj, ((TemplateScope) (obj5))), Quote.consX$V(new Object[] {
                    std_syntax.datum$To$SyntaxObject(obj, obj1), Pair.make(Lit29.execute(aobj, ((TemplateScope) (obj5))), Quote.append$V(new Object[] {
                        Lit30.execute(aobj, ((TemplateScope) (obj5))), Pair.make(Lit31.execute(aobj, ((TemplateScope) (obj5))), Quote.append$V(new Object[] {
                            std_syntax.datum$To$SyntaxObject(obj, obj4), Quote.consX$V(new Object[] {
                                std_syntax.datum$To$SyntaxObject(obj, pairwithposition), Quote.consX$V(new Object[] {
                                    std_syntax.datum$To$SyntaxObject(obj, obj3), Pair.make(Pair.make(Lit32.execute(aobj, ((TemplateScope) (obj5))), Quote.append$V(new Object[] {
                                        Lit33.execute(aobj, ((TemplateScope) (obj5))), Quote.consX$V(new Object[] {
                                            std_syntax.datum$To$SyntaxObject(obj, obj1), Quote.append$V(new Object[] {
                                                Lit34.execute(aobj, ((TemplateScope) (obj5))), Pair.make(Lit35.execute(aobj, ((TemplateScope) (obj5))), Pair.make(Pair.make(Lit36.execute(aobj, ((TemplateScope) (obj5))), Quote.consX$V(new Object[] {
                                                    std_syntax.datum$To$SyntaxObject(obj, obj1), Lit37.execute(aobj, ((TemplateScope) (obj5)))
                                                })), Lit38.execute(aobj, ((TemplateScope) (obj5)))))
                                            })
                                        })
                                    })), Quote.append$V(new Object[] {
                                        std_syntax.datum$To$SyntaxObject(obj, obj2), Quote.append$V(new Object[] {
                                            std_syntax.datum$To$SyntaxObject(obj, llist), Lit39.execute(aobj, ((TemplateScope) (obj5)))
                                        })
                                    }))
                                })
                            })
                        }))
                    }))
                })
            });
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object makeFieldDesc(Symbol symbol, Symbol symbol1, int i)
    {
        return Quote.consX$V(new Object[] {
            symbol1, Quote.append$V(new Object[] {
                Lit0, Quote.consX$V(new Object[] {
                    symbol, Quote.append$V(new Object[] {
                        Lit1, Pair.make(Lit2, Quote.append$V(new Object[] {
                            Lit3, Pair.make(Lit4, Quote.append$V(new Object[] {
                                Lit5, Pair.make(Quote.consX$V(new Object[] {
                                    symbol, Quote.consX$V(new Object[] {
                                        misc.symbol$To$String(symbol1), Quote.consX$V(new Object[] {
                                            Integer.valueOf(i), LList.Empty
                                        })
                                    })
                                }), LList.Empty)
                            }))
                        }))
                    })
                })
            })
        });
    }

    static PairWithPosition makeInit()
    {
        return Lit6;
    }

    static Pair makeValues(Symbol symbol, LList llist)
    {
        return Pair.make(Lit7, Quote.append$V(new Object[] {
            Lit8, Quote.consX$V(new Object[] {
                symbol, Quote.append$V(new Object[] {
                    Lit9, Pair.make(Lit10, Pair.make(Quote.consX$V(new Object[] {
                        symbol, Quote.append$V(new Object[] {
                            llist, LList.Empty
                        })
                    }), LList.Empty))
                })
            })
        }));
    }

    static LList mapNames(Symbol symbol, LList llist, int i)
    {
        if (lists.isNull(llist))
        {
            return LList.Empty;
        }
        Object obj = lists.car.apply1(llist);
        Object obj1;
        try
        {
            obj1 = (Symbol)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Symbol symbol)
        {
            throw new WrongType(symbol, "make-field-desc", 1, obj);
        }
        obj = makeFieldDesc(symbol, ((Symbol) (obj1)), i);
        llist = ((LList) (lists.cdr.apply1(llist)));
        try
        {
            obj1 = (LList)llist;
        }
        // Misplaced declaration of an exception variable
        catch (Symbol symbol)
        {
            throw new WrongType(symbol, "map-names", 1, llist);
        }
        return lists.cons(obj, mapNames(symbol, ((LList) (obj1)), i + 1));
    }

    static SimpleSymbol symbolAppend$V(Object aobj[])
    {
        Object obj = LList.makeList(aobj, 0);
        gnu.kawa.functions.Apply apply = Scheme.apply;
        ModuleMethod modulemethod = strings.string$Mnappend;
        aobj = LList.Empty;
        do
        {
            if (obj == LList.Empty)
            {
                aobj = ((Object []) (apply.apply2(modulemethod, LList.reverseInPlace(((Object) (aobj))))));
                Object obj1;
                Symbol symbol;
                try
                {
                    obj = (CharSequence)aobj;
                }
                catch (ClassCastException classcastexception)
                {
                    throw new WrongType(classcastexception, "string->symbol", 1, ((Object) (aobj)));
                }
                return misc.string$To$Symbol(((CharSequence) (obj)));
            }
            try
            {
                obj1 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "arg0", -2, obj);
            }
            obj = ((Pair) (obj1)).getCdr();
            obj1 = ((Pair) (obj1)).getCar();
            try
            {
                symbol = (Symbol)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "symbol->string", 1, obj1);
            }
            aobj = Pair.make(misc.symbol$To$String(symbol), ((Object) (aobj)));
        } while (true);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            return lambda1(obj);

        case 2: // '\002'
            return lambda2(obj);
        }
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

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit53 = (SimpleSymbol)(new SimpleSymbol("final")).readResolve();
        Lit52 = (SimpleSymbol)(new SimpleSymbol("enum")).readResolve();
        Lit51 = (SimpleSymbol)(new SimpleSymbol("num")).readResolve();
        Lit50 = (SimpleSymbol)(new SimpleSymbol("str")).readResolve();
        Lit49 = (SimpleSymbol)(new SimpleSymbol("*init*")).readResolve();
        Lit48 = Keyword.make("access");
        Lit47 = (SimpleSymbol)(new SimpleSymbol("String")).readResolve();
        Lit46 = Keyword.make("allocation");
        Lit45 = (SimpleSymbol)(new SimpleSymbol("static")).readResolve();
        Lit44 = (SimpleSymbol)(new SimpleSymbol("java.lang.Enum")).readResolve();
        Lit43 = (SimpleSymbol)(new SimpleSymbol("quote")).readResolve();
        Lit42 = (SimpleSymbol)(new SimpleSymbol("::")).readResolve();
        Lit41 = (SimpleSymbol)(new SimpleSymbol("s")).readResolve();
        Lit40 = (SimpleSymbol)(new SimpleSymbol("valueOf")).readResolve();
        Lit37 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make(Lit41, LList.Empty, "enums.scm", 0x47042)
        }, 0);
        Lit36 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("$lookup$")).readResolve(), Pair.make(Lit44, Pair.make(Pair.make((SimpleSymbol)(new SimpleSymbol("quasiquote")).readResolve(), Pair.make(Lit40, LList.Empty)), LList.Empty)), "enums.scm", 0x47007)
        }, 0);
        Lit35 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make(Lit43, PairWithPosition.make(Lit45, LList.Empty, "enums.scm", 0x46013), "enums.scm", 0x46013)
        }, 0);
        Lit34 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make(Lit46, LList.Empty, "enums.scm", 0x46006)
        }, 0);
        Lit33 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make(Lit42, LList.Empty, "enums.scm", 0x45019)
        }, 0);
        Lit32 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make(Lit40, PairWithPosition.make(Lit41, PairWithPosition.make(Lit42, PairWithPosition.make(Lit47, LList.Empty, "enums.scm", 0x45012), "enums.scm", 0x45010), "enums.scm", 0x4500f), "enums.scm", 0x45006)
        }, 0);
        Lit31 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make(Lit43, PairWithPosition.make(PairWithPosition.make(Lit52, PairWithPosition.make(Lit53, LList.Empty, "enums.scm", 0x4102c), "enums.scm", 0x41026), LList.Empty, "enums.scm", 0x41026), "enums.scm", 0x41026)
        }, 0);
        Lit30 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make(Lit48, LList.Empty, "enums.scm", 0x4101d)
        }, 0);
        Lit29 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make(Lit44, LList.Empty, "enums.scm", 0x4100c)
        }, 0);
        Lit28 = new SyntaxTemplate("\001\001\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("define-simple-class")).readResolve(), LList.Empty, "enums.scm", 0x4000a)
        }, 0);
        Lit21 = (SimpleSymbol)(new SimpleSymbol("%define-enum")).readResolve();
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("define-enum")).readResolve();
        Lit11 = simplesymbol;
        Lit20 = new SyntaxTemplate("\001\001\003", "\021\030\004\021\030\f\t\013\t\020\b\025\023", new Object[] {
            simplesymbol, "findkeywords"
        }, 1);
        Lit16 = new SyntaxTemplate("\001\001\003\003", "\021\030\004\t\013\031\b\025\023\b\035\033", new Object[] {
            Lit21
        }, 1);
        Lit14 = new SyntaxTemplate("\001\001\003\001\001\003", "\021\030\004\021\030\f\t\0139\t\033\t#\b\025\023\b-+", new Object[] {
            Lit11, "findkeywords"
        }, 1);
        Lit10 = PairWithPosition.make(Lit43, PairWithPosition.make(Lit45, LList.Empty, "enums.scm", 0x1f025), "enums.scm", 0x1f025);
        Lit9 = PairWithPosition.make(Lit46, LList.Empty, "enums.scm", 0x1f018);
        Lit8 = PairWithPosition.make(Lit42, LList.Empty, "enums.scm", 0x1f00e);
        Lit7 = PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("values")).readResolve(), LList.Empty, "enums.scm", 0x1f005);
        Lit6 = PairWithPosition.make(PairWithPosition.make(Lit49, PairWithPosition.make(PairWithPosition.make(Lit50, PairWithPosition.make(Lit42, PairWithPosition.make(Lit47, LList.Empty, "enums.scm", 0x16015), "enums.scm", 0x16012), "enums.scm", 0x1600d), PairWithPosition.make(PairWithPosition.make(Lit51, PairWithPosition.make(Lit42, PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("int")).readResolve(), LList.Empty, "enums.scm", 0x16025), "enums.scm", 0x16022), "enums.scm", 0x1601d), LList.Empty, "enums.scm", 0x1601d), "enums.scm", 0x1600d), "enums.scm", 0x16005), PairWithPosition.make(Lit48, PairWithPosition.make(PairWithPosition.make(Lit43, PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("private")).readResolve(), LList.Empty, "enums.scm", 0x1700e), "enums.scm", 0x1700e), PairWithPosition.make(PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("invoke-special")).readResolve(), PairWithPosition.make(Lit44, PairWithPosition.make(PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("this")).readResolve(), LList.Empty, "enums.scm", 0x18024), PairWithPosition.make(PairWithPosition.make(Lit43, PairWithPosition.make(Lit49, LList.Empty, "enums.scm", 0x1802c), "enums.scm", 0x1802c), PairWithPosition.make(Lit50, PairWithPosition.make(Lit51, LList.Empty, "enums.scm", 0x18037), "enums.scm", 0x18033), "enums.scm", 0x1802b), "enums.scm", 0x18024), "enums.scm", 0x18015), "enums.scm", 0x18005), LList.Empty, "enums.scm", 0x18005), "enums.scm", 0x1700d), "enums.scm", 0x17005), "enums.scm", 0x16004);
        Lit5 = PairWithPosition.make(Keyword.make("init"), LList.Empty, "enums.scm", 0x1200d);
        Lit4 = PairWithPosition.make(Lit43, PairWithPosition.make(PairWithPosition.make(Lit52, PairWithPosition.make(Lit53, LList.Empty, "enums.scm", 0x11030), "enums.scm", 0x1102a), LList.Empty, "enums.scm", 0x1102a), "enums.scm", 0x1102a);
        Lit3 = PairWithPosition.make(Lit48, LList.Empty, "enums.scm", 0x11021);
        Lit2 = PairWithPosition.make(Lit43, PairWithPosition.make(Lit45, LList.Empty, "enums.scm", 0x1101a), "enums.scm", 0x1101a);
        Lit1 = PairWithPosition.make(Lit46, LList.Empty, "enums.scm", 0x1100d);
        Lit0 = PairWithPosition.make(Lit42, LList.Empty, "enums.scm", 0x1000d);
        $instance = new enums();
        simplesymbol = Lit11;
        enums enums1 = $instance;
        define$Mnenum = Macro.make(simplesymbol, new ModuleMethod(enums1, 1, null, 4097), $instance);
        $Prvt$$Pcdefine$Mnenum = Macro.make(Lit21, new ModuleMethod(enums1, 2, null, 4097), $instance);
        $instance.run();
    }
}
