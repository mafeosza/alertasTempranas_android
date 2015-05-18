// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SynchronizedExp;
import gnu.expr.TryExp;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
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
import kawa.lang.Translator;
import kawa.standard.IfFeature;
import kawa.standard.Scheme;
import kawa.standard.syntax_case;

// Referenced classes of package kawa.lib:
//            lists, std_syntax, prim_syntax

public class syntax extends ModuleBody
{
    public class frame extends ModuleBody
    {

        final ModuleMethod lambda$Fn1;
        Object list;

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

        Object lambda1(Object obj)
        {
            Object obj2 = list;
            Object obj1 = obj;
            obj = obj2;
            do
            {
                boolean flag;
                if (obj1 == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag ? flag : lists.isNull(obj))
                {
                    return obj1;
                }
                Object obj3 = lists.cdr.apply1(obj);
                obj1 = Scheme.applyToArgs.apply3(lists.caar.apply1(obj), obj1, lists.cdar.apply1(obj));
                obj = obj3;
            } while (true);
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

        public frame()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
            modulemethod.setProperty("source-location", "syntax.scm:83");
            lambda$Fn1 = modulemethod;
        }
    }

    public class frame0 extends ModuleBody
    {

        TemplateScope $unnamed$0;
        Object $unnamed$1[];

        public Object lambda6loop(Object obj)
        {
            Object aobj[] = SyntaxPattern.allocVars(5, $unnamed$1);
            if (syntax.Lit85.match(obj, aobj, 0))
            {
                return Pair.make(syntax.Lit86.execute(aobj, $unnamed$0), lambda6loop(syntax.Lit87.execute(aobj, $unnamed$0)));
            }
            if (syntax.Lit88.match(obj, aobj, 0))
            {
                return LList.Empty;
            }
            if (syntax.Lit89.match(obj, aobj, 0))
            {
                Object obj1 = syntax.Lit90.execute(aobj, $unnamed$0);
                if ("invalid case-lambda clause" instanceof Object[])
                {
                    obj = ((Object) ((Object[])"invalid case-lambda clause"));
                } else
                {
                    obj = ((Object) (new Object[] {
                        "invalid case-lambda clause"
                    }));
                }
                return LList.list1(prim_syntax.syntaxError(obj1, ((Object []) (obj))));
            } else
            {
                return syntax_case.error("syntax-case", obj);
            }
        }

        public frame0()
        {
        }
    }


    public static final Macro $Pccond$Mnexpand;
    public static final Macro $Pcimport;
    public static final Location $Prvt$and = StaticFieldLocation.make("kawa.lib.std_syntax", "and");
    public static final Location $Prvt$define$Mnconstant = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");
    public static final Location $Prvt$define$Mnsyntax = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnsyntax");
    public static final Location $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
    public static final Location $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
    public static final Location $Prvt$or = StaticFieldLocation.make("kawa.lib.std_syntax", "or");
    public static final Location $Prvt$try$Mncatch = StaticFieldLocation.make("kawa.lib.prim_syntax", "try$Mncatch");
    public static final syntax $instance;
    static final SyntaxPattern Lit0 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    static final SyntaxTemplate Lit1 = new SyntaxTemplate("\001\0", "\003", new Object[0], 0);
    static final SyntaxPattern Lit10 = new SyntaxPattern("\003", new Object[0], 1);
    static final SimpleSymbol Lit100;
    static final SyntaxRules Lit101;
    static final SimpleSymbol Lit102;
    static final SimpleSymbol Lit103;
    static final SimpleSymbol Lit104;
    static final SimpleSymbol Lit105;
    static final SimpleSymbol Lit106;
    static final SimpleSymbol Lit107;
    static final SimpleSymbol Lit108;
    static final SimpleSymbol Lit109;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit110;
    static final SimpleSymbol Lit111;
    static final SimpleSymbol Lit112;
    static final SimpleSymbol Lit113;
    static final SimpleSymbol Lit114;
    static final SimpleSymbol Lit115;
    static final SimpleSymbol Lit116;
    static final SimpleSymbol Lit117;
    static final SimpleSymbol Lit118;
    static final SimpleSymbol Lit119;
    static final SyntaxRules Lit12;
    static final SimpleSymbol Lit120;
    static final SimpleSymbol Lit121;
    static final SimpleSymbol Lit122;
    static final SimpleSymbol Lit123;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final SimpleSymbol Lit15;
    static final SyntaxRules Lit16;
    static final SimpleSymbol Lit17;
    static final SyntaxRules Lit18;
    static final SimpleSymbol Lit19;
    static final SyntaxTemplate Lit2 = new SyntaxTemplate("\001\0", "\n", new Object[0], 0);
    static final SyntaxRules Lit20;
    static final SimpleSymbol Lit21;
    static final SyntaxPattern Lit22 = new SyntaxPattern("\f\007\f\017\f\027\b", new Object[0], 3);
    static final SyntaxTemplate Lit23 = new SyntaxTemplate("\001\001\001", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit24 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    static final SimpleSymbol Lit25;
    static final SyntaxPattern Lit26 = new SyntaxPattern("\f\007\f\017\023", new Object[0], 3);
    static final SyntaxTemplate Lit27 = new SyntaxTemplate("\001\001\0", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit28 = new SyntaxTemplate("\001\001\0", "\022", new Object[0], 0);
    static final SimpleSymbol Lit29;
    static final SyntaxPattern Lit3 = new SyntaxPattern("\b", new Object[0], 0);
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SyntaxRules Lit37;
    static final SimpleSymbol Lit38;
    static final SyntaxPattern Lit39 = new SyntaxPattern("\f\007,\f\002\f\017\023\f\037\b", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("rename")).readResolve()
    }, 4);
    static final SyntaxPattern Lit4 = new SyntaxPattern("\003", new Object[0], 1);
    static final SyntaxTemplate Lit40 = new SyntaxTemplate("\001\001\000\001", "\022", new Object[0], 0);
    static final SyntaxTemplate Lit41;
    static final SyntaxTemplate Lit42 = new SyntaxTemplate("\001\001\000\001", "\022", new Object[0], 0);
    static final SyntaxTemplate Lit43 = new SyntaxTemplate("\001\001\000\001", "\033", new Object[0], 0);
    static final SyntaxTemplate Lit44 = new SyntaxTemplate("\001\001\000\001", "\020", new Object[0], 0);
    static final SyntaxTemplate Lit45 = new SyntaxTemplate("\001\001\000\001", "\030\004", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("rest")).readResolve()
    }, 0);
    static final SyntaxPattern Lit46 = new SyntaxPattern("\f\007,\f\002\f\017\023\f\037\b", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("only")).readResolve()
    }, 4);
    static final SyntaxTemplate Lit47 = new SyntaxTemplate("\001\001\000\001", "\022", new Object[0], 0);
    static final SyntaxTemplate Lit48;
    static final SyntaxTemplate Lit49 = new SyntaxTemplate("\001\001\000\001", "\022", new Object[0], 0);
    static final SyntaxPattern Lit5 = new SyntaxPattern(",\f\007\f\017\b\023", new Object[0], 3);
    static final SyntaxTemplate Lit50 = new SyntaxTemplate("\001\001\000\001", "\033", new Object[0], 0);
    static final SyntaxTemplate Lit51 = new SyntaxTemplate("\001\001\000\001", "\020", new Object[0], 0);
    static final SyntaxTemplate Lit52 = new SyntaxTemplate("\001\001\000\001", "\022", new Object[0], 0);
    static final SyntaxPattern Lit53 = new SyntaxPattern("\f\007,\f\002\f\017\023\f\037\b", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("except")).readResolve()
    }, 4);
    static final SyntaxTemplate Lit54 = new SyntaxTemplate("\001\001\000\001", "\022", new Object[0], 0);
    static final SyntaxTemplate Lit55;
    static final SyntaxTemplate Lit56 = new SyntaxTemplate("\001\001\000\001", "\022", new Object[0], 0);
    static final SyntaxTemplate Lit57 = new SyntaxTemplate("\001\001\000\001", "\033", new Object[0], 0);
    static final SyntaxTemplate Lit58 = new SyntaxTemplate("\001\001\000\001", "\020", new Object[0], 0);
    static final SyntaxTemplate Lit59 = new SyntaxTemplate("\001\001\000\001", "\022", new Object[0], 0);
    static final SyntaxTemplate Lit6 = new SyntaxTemplate("\001\001\0", "\003", new Object[0], 0);
    static final SyntaxPattern Lit60;
    static final SyntaxTemplate Lit61;
    static final SyntaxTemplate Lit62 = new SyntaxTemplate("\001\001\001\001", "\023", new Object[0], 0);
    static final SyntaxTemplate Lit63 = new SyntaxTemplate("\001\001\001\001", "\033", new Object[0], 0);
    static final SyntaxTemplate Lit64 = new SyntaxTemplate("\001\001\001\001", "\020", new Object[0], 0);
    static final SyntaxPattern Lit65;
    static final SyntaxTemplate Lit66 = new SyntaxTemplate("\001\001\000\001", "\022", new Object[0], 0);
    static final SyntaxPattern Lit67 = new SyntaxPattern("\f\007,\f\002\f\017\b\f\027\b", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("library")).readResolve()
    }, 3);
    static final SyntaxTemplate Lit68;
    static final SyntaxTemplate Lit69 = new SyntaxTemplate("\001\001\001", "\b\013", new Object[0], 0);
    static final SyntaxTemplate Lit7 = new SyntaxTemplate("\001\001\0", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit70 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    static final SyntaxTemplate Lit71 = new SyntaxTemplate("\001\001\001", "\020", new Object[0], 0);
    static final SyntaxPattern Lit72 = new SyntaxPattern("\f\007\f\017\f\027\b", new Object[0], 3);
    static final SyntaxTemplate Lit73;
    static final SyntaxTemplate Lit74 = new SyntaxTemplate("\001\001\001", "\b\013", new Object[0], 0);
    static final SyntaxTemplate Lit75 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    static final SyntaxTemplate Lit76 = new SyntaxTemplate("\001\001\001", "\020", new Object[0], 0);
    static final SimpleSymbol Lit77;
    static final SyntaxRules Lit78;
    static final SimpleSymbol Lit79;
    static final SyntaxTemplate Lit8 = new SyntaxTemplate("\001\001\0", "\022", new Object[0], 0);
    static final SyntaxRules Lit80;
    static final SimpleSymbol Lit81;
    static final SyntaxPattern Lit82 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    static final SyntaxTemplate Lit83;
    static final SyntaxTemplate Lit84 = new SyntaxTemplate("\001\0", "\n", new Object[0], 0);
    static final SyntaxPattern Lit85 = new SyntaxPattern("\034\f\027\033#", new Object[0], 5);
    static final SyntaxTemplate Lit86;
    static final SyntaxTemplate Lit87 = new SyntaxTemplate("\001\000\001\000\0", "\"", new Object[0], 0);
    static final SyntaxPattern Lit88 = new SyntaxPattern("\b", new Object[0], 2);
    static final SyntaxPattern Lit89 = new SyntaxPattern("\023", new Object[0], 3);
    static final SyntaxPattern Lit9 = new SyntaxPattern("\b", new Object[0], 0);
    static final SyntaxTemplate Lit90 = new SyntaxTemplate("\001\000\0", "\022", new Object[0], 0);
    static final SimpleSymbol Lit91;
    static final SyntaxRules Lit92;
    static final SimpleSymbol Lit93;
    static final SyntaxPattern Lit94 = new SyntaxPattern("\f\007\034\f\017\023\033", new Object[0], 4);
    static final SyntaxTemplate Lit95 = new SyntaxTemplate("\001\001\000\0", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit96;
    static final SyntaxTemplate Lit97;
    static final SimpleSymbol Lit98;
    static final SyntaxRules Lit99;
    public static final Macro case$Mnlambda;
    public static final Macro cond$Mnexpand;
    public static final Macro define$Mnalias$Mnparameter;
    public static final Macro define$Mnmacro;
    public static final Macro define$Mnsyntax$Mncase;
    public static final Macro defmacro;
    public static final ModuleMethod identifier$Mnlist$Qu;
    public static final ModuleMethod identifier$Mnpair$Mnlist$Qu;
    public static final Macro _fldimport;
    public static final ModuleMethod import$Mnhandle$Mnexcept;
    public static final ModuleMethod import$Mnhandle$Mnonly;
    public static final ModuleMethod import$Mnhandle$Mnprefix;
    public static final ModuleMethod import$Mnhandle$Mnrename;
    public static final ModuleMethod import$Mnmapper;
    public static final Macro let$Mnvalues;
    public static final Macro let$St$Mnvalues;
    public static final Macro receive;
    public static final Macro _fldsynchronized;
    public static final Macro try$Mnfinally;
    public static final Macro unless;
    public static final Macro when;

    public syntax()
    {
        ModuleInfo.register(this);
    }

    public static Object importHandleExcept(Object obj, Object obj1)
    {
        Object obj2 = obj;
        if (lists.memq(obj, obj1) != Boolean.FALSE)
        {
            obj2 = null;
        }
        return obj2;
    }

    public static Object importHandleOnly(Object obj, Object obj1)
    {
        if (lists.memq(obj, obj1) != Boolean.FALSE)
        {
            return obj;
        } else
        {
            return null;
        }
    }

    public static Object importHandlePrefix(Object obj, Object obj1)
    {
        if (obj != null);
        return null;
    }

    public static Object importHandleRename(Object obj, Object obj1)
    {
        if (lists.isPair(obj1))
        {
            if (obj == lists.caar.apply1(obj1))
            {
                return lists.cadar.apply1(obj1);
            } else
            {
                return importHandleRename(obj, lists.cdr.apply1(obj1));
            }
        } else
        {
            return obj;
        }
    }

    public static Procedure importMapper(Object obj)
    {
        frame frame1 = new frame();
        frame1.list = obj;
        return frame1.Fn1;
    }

    public static boolean isIdentifierList(Object obj)
    {
        Object aobj[];
label0:
        {
            boolean flag;
label1:
            {
                boolean flag1;
                if (Translator.listLength(obj) >= 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag = flag1;
                if (!flag1)
                {
                    break label1;
                }
                do
                {
                    aobj = SyntaxPattern.allocVars(2, null);
                    if (!Lit0.match(obj, aobj, 0))
                    {
                        break;
                    }
                    obj = TemplateScope.make();
                    flag1 = std_syntax.isIdentifier(Lit1.execute(aobj, ((TemplateScope) (obj))));
                    flag = flag1;
                    if (!flag1)
                    {
                        break label1;
                    }
                    obj = TemplateScope.make();
                    obj = Lit2.execute(aobj, ((TemplateScope) (obj)));
                } while (true);
                if (!Lit3.match(obj, aobj, 0))
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        if (Lit4.match(obj, aobj, 0))
        {
            return false;
        }
        return syntax_case.error("syntax-case", obj) != Boolean.FALSE;
    }

    public static boolean isIdentifierPairList(Object obj)
    {
        Object aobj[];
label0:
        {
            boolean flag;
label1:
            {
                boolean flag1;
                if (Translator.listLength(obj) >= 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag = flag1;
                if (!flag1)
                {
                    break label1;
                }
                do
                {
                    aobj = SyntaxPattern.allocVars(3, null);
                    if (!Lit5.match(obj, aobj, 0))
                    {
                        break;
                    }
                    obj = TemplateScope.make();
                    flag1 = std_syntax.isIdentifier(Lit6.execute(aobj, ((TemplateScope) (obj))));
                    flag = flag1;
                    if (!flag1)
                    {
                        break label1;
                    }
                    obj = TemplateScope.make();
                    flag1 = std_syntax.isIdentifier(Lit7.execute(aobj, ((TemplateScope) (obj))));
                    flag = flag1;
                    if (!flag1)
                    {
                        break label1;
                    }
                    obj = TemplateScope.make();
                    obj = Lit8.execute(aobj, ((TemplateScope) (obj)));
                } while (true);
                if (!Lit9.match(obj, aobj, 0))
                {
                    break label0;
                }
                flag = true;
            }
            return flag;
        }
        if (Lit10.match(obj, aobj, 0))
        {
            return false;
        }
        return syntax_case.error("syntax-case", obj) != Boolean.FALSE;
    }

    static Object lambda2(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(3, null);
        if (Lit22.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            obj = SyntaxForms.rewrite(Lit23.execute(aobj, ((TemplateScope) (obj))));
            TemplateScope templatescope = TemplateScope.make();
            return new TryExp(((gnu.expr.Expression) (obj)), SyntaxForms.rewrite(Lit24.execute(aobj, templatescope)));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda3(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(3, null);
        if (Lit26.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            obj = SyntaxForms.rewrite(Lit27.execute(aobj, ((TemplateScope) (obj))));
            TemplateScope templatescope = TemplateScope.make();
            return new SynchronizedExp(((gnu.expr.Expression) (obj)), SyntaxForms.rewriteBody(Lit28.execute(aobj, templatescope)));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda4(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(4, null);
        if (Lit39.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            if (isIdentifierPairList(Lit40.execute(aobj, ((TemplateScope) (obj)))))
            {
                obj = TemplateScope.make();
                return Quote.append$V(new Object[] {
                    Lit41.execute(aobj, ((TemplateScope) (obj))), Quote.consX$V(new Object[] {
                        lists.cons(lists.cons(import$Mnhandle$Mnrename, Lit42.execute(aobj, ((TemplateScope) (obj)))), Lit43.execute(aobj, ((TemplateScope) (obj)))), Lit44.execute(aobj, ((TemplateScope) (obj)))
                    })
                });
            }
            obj = TemplateScope.make();
            aobj = ((Object []) (Lit45.execute(aobj, ((TemplateScope) (obj)))));
            if ("invalid 'rename' clause in import" instanceof Object[])
            {
                obj = ((Object) ((Object[])"invalid 'rename' clause in import"));
            } else
            {
                obj = ((Object) (new Object[] {
                    "invalid 'rename' clause in import"
                }));
            }
            return prim_syntax.syntaxError(((Object) (aobj)), ((Object []) (obj)));
        }
        if (Lit46.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            if (isIdentifierList(Lit47.execute(aobj, ((TemplateScope) (obj)))))
            {
                obj = TemplateScope.make();
                return Quote.append$V(new Object[] {
                    Lit48.execute(aobj, ((TemplateScope) (obj))), Quote.consX$V(new Object[] {
                        lists.cons(lists.cons(import$Mnhandle$Mnonly, Lit49.execute(aobj, ((TemplateScope) (obj)))), Lit50.execute(aobj, ((TemplateScope) (obj)))), Lit51.execute(aobj, ((TemplateScope) (obj)))
                    })
                });
            }
            obj = TemplateScope.make();
            aobj = ((Object []) (Lit52.execute(aobj, ((TemplateScope) (obj)))));
            if ("invalid 'only' identifier list" instanceof Object[])
            {
                obj = ((Object) ((Object[])"invalid 'only' identifier list"));
            } else
            {
                obj = ((Object) (new Object[] {
                    "invalid 'only' identifier list"
                }));
            }
            return prim_syntax.syntaxError(((Object) (aobj)), ((Object []) (obj)));
        }
        if (Lit53.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            if (isIdentifierList(Lit54.execute(aobj, ((TemplateScope) (obj)))))
            {
                obj = TemplateScope.make();
                return Quote.append$V(new Object[] {
                    Lit55.execute(aobj, ((TemplateScope) (obj))), Quote.consX$V(new Object[] {
                        lists.cons(lists.cons(import$Mnhandle$Mnexcept, Lit56.execute(aobj, ((TemplateScope) (obj)))), Lit57.execute(aobj, ((TemplateScope) (obj)))), Lit58.execute(aobj, ((TemplateScope) (obj)))
                    })
                });
            }
            obj = TemplateScope.make();
            aobj = ((Object []) (Lit59.execute(aobj, ((TemplateScope) (obj)))));
            if ("invalid 'except' identifier list" instanceof Object[])
            {
                obj = ((Object) ((Object[])"invalid 'except' identifier list"));
            } else
            {
                obj = ((Object) (new Object[] {
                    "invalid 'except' identifier list"
                }));
            }
            return prim_syntax.syntaxError(((Object) (aobj)), ((Object []) (obj)));
        }
        if (Lit60.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Quote.append$V(new Object[] {
                Lit61.execute(aobj, ((TemplateScope) (obj))), Quote.consX$V(new Object[] {
                    lists.cons(lists.cons(import$Mnhandle$Mnprefix, Lit62.execute(aobj, ((TemplateScope) (obj)))), Lit63.execute(aobj, ((TemplateScope) (obj)))), Lit64.execute(aobj, ((TemplateScope) (obj)))
                })
            });
        }
        if (Lit65.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            aobj = ((Object []) (Lit66.execute(aobj, ((TemplateScope) (obj)))));
            if ("invalid prefix clause in import" instanceof Object[])
            {
                obj = ((Object) ((Object[])"invalid prefix clause in import"));
            } else
            {
                obj = ((Object) (new Object[] {
                    "invalid prefix clause in import"
                }));
            }
            return prim_syntax.syntaxError(((Object) (aobj)), ((Object []) (obj)));
        }
        if (Lit67.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Pair.make(Lit68.execute(aobj, ((TemplateScope) (obj))), Quote.append$V(new Object[] {
                Lit69.execute(aobj, ((TemplateScope) (obj))), Quote.consX$V(new Object[] {
                    importMapper(std_syntax.syntaxObject$To$Datum(Lit70.execute(aobj, ((TemplateScope) (obj))))), Lit71.execute(aobj, ((TemplateScope) (obj)))
                })
            }));
        }
        if (Lit72.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Pair.make(Lit73.execute(aobj, ((TemplateScope) (obj))), Quote.append$V(new Object[] {
                Lit74.execute(aobj, ((TemplateScope) (obj))), Quote.consX$V(new Object[] {
                    importMapper(std_syntax.syntaxObject$To$Datum(Lit75.execute(aobj, ((TemplateScope) (obj))))), Lit76.execute(aobj, ((TemplateScope) (obj)))
                })
            }));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda5(Object obj)
    {
        frame0 frame0_1 = new frame0();
        frame0_1._fld1 = SyntaxPattern.allocVars(2, null);
        if (Lit82.match(obj, frame0_1._fld1, 0))
        {
            frame0_1._fld0 = TemplateScope.make();
            return Pair.make(Lit83.execute(frame0_1._fld1, frame0_1._fld0), frame0_1.lambda6loop(Lit84.execute(frame0_1._fld1, frame0_1._fld0)));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda7(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(4, null);
        if (Lit94.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            if (IfFeature.testFeature(Lit95.execute(aobj, ((TemplateScope) (obj)))))
            {
                obj = TemplateScope.make();
                return Lit96.execute(aobj, ((TemplateScope) (obj)));
            } else
            {
                obj = TemplateScope.make();
                return Lit97.execute(aobj, ((TemplateScope) (obj)));
            }
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        default:
            return super.apply1(modulemethod, obj);

        case 4: // '\004'
            if (isIdentifierList(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 5: // '\005'
            if (isIdentifierPairList(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 10: // '\n'
            return importMapper(obj);

        case 2: // '\002'
            return lambda2(obj);

        case 3: // '\003'
            return lambda3(obj);

        case 11: // '\013'
            return lambda4(obj);

        case 12: // '\f'
            return lambda5(obj);

        case 13: // '\r'
            return lambda7(obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 6: // '\006'
            return importHandleOnly(obj, obj1);

        case 7: // '\007'
            return importHandleExcept(obj, obj1);

        case 8: // '\b'
            return importHandlePrefix(obj, obj1);

        case 9: // '\t'
            return importHandleRename(obj, obj1);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
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

        case 10: // '\n'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 5: // '\005'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 4: // '\004'
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

        case 9: // '\t'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 8: // '\b'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 7: // '\007'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 6: // '\006'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit123 = (SimpleSymbol)(new SimpleSymbol("%define-macro")).readResolve();
        Lit122 = (SimpleSymbol)(new SimpleSymbol("form")).readResolve();
        Lit121 = (SimpleSymbol)(new SimpleSymbol("if")).readResolve();
        Lit120 = (SimpleSymbol)(new SimpleSymbol("prefix")).readResolve();
        Lit119 = (SimpleSymbol)(new SimpleSymbol("instance")).readResolve();
        Lit118 = (SimpleSymbol)(new SimpleSymbol("kawa.standard.ImportFromLibrary")).readResolve();
        Lit117 = (SimpleSymbol)(new SimpleSymbol("x")).readResolve();
        Lit116 = (SimpleSymbol)(new SimpleSymbol("call-with-values")).readResolve();
        Lit115 = (SimpleSymbol)(new SimpleSymbol("let")).readResolve();
        Lit114 = (SimpleSymbol)(new SimpleSymbol("not")).readResolve();
        Lit113 = (SimpleSymbol)(new SimpleSymbol("or")).readResolve();
        Lit112 = (SimpleSymbol)(new SimpleSymbol("and")).readResolve();
        Lit111 = (SimpleSymbol)(new SimpleSymbol("else")).readResolve();
        Lit110 = (SimpleSymbol)(new SimpleSymbol("begin")).readResolve();
        Lit109 = (SimpleSymbol)(new SimpleSymbol("lambda")).readResolve();
        Lit108 = (SimpleSymbol)(new SimpleSymbol("quote")).readResolve();
        Lit107 = (SimpleSymbol)(new SimpleSymbol("wt")).readResolve();
        Lit106 = (SimpleSymbol)(new SimpleSymbol("as")).readResolve();
        Lit105 = (SimpleSymbol)(new SimpleSymbol("arg")).readResolve();
        Lit104 = (SimpleSymbol)(new SimpleSymbol("quasiquote")).readResolve();
        Lit103 = (SimpleSymbol)(new SimpleSymbol("gnu.mapping.LocationProc")).readResolve();
        Lit102 = (SimpleSymbol)(new SimpleSymbol("$lookup$")).readResolve();
        Object obj = (SimpleSymbol)(new SimpleSymbol("define-alias-parameter")).readResolve();
        Lit100 = ((SimpleSymbol) (obj));
        Object obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3), "\001\001\001", "\021\030\004\271\021\030\f\t\003\021\030\024\021\030\034\b\021\030$)\021\030,\b\003\b\023\b\021\0304\t\003\b\021\030<\021\030D\b\021\030L9\021\030T\t\013\030\\\b\021\030d\021\030l\b\021\030ty\b\021\030|\b\021\030\204\021\030d\t\003\030\214A\021\030\224\021\030\234\b\013\030\244", new Object[] {
            Lit110, (SimpleSymbol)(new SimpleSymbol("define-constant")).readResolve(), (SimpleSymbol)(new SimpleSymbol("::")).readResolve(), (SimpleSymbol)(new SimpleSymbol("<gnu.mapping.LocationProc>")).readResolve(), PairWithPosition.make(Lit102, Pair.make(Lit103, Pair.make(Pair.make(Lit104, Pair.make((SimpleSymbol)(new SimpleSymbol("makeNamed")).readResolve(), LList.Empty)), LList.Empty)), "syntax.scm", 0x105004), Lit108, PairWithPosition.make(Lit102, Pair.make(Lit103, Pair.make(Pair.make(Lit104, Pair.make((SimpleSymbol)(new SimpleSymbol("pushConverter")).readResolve(), LList.Empty)), LList.Empty)), "syntax.scm", 0x106009), Lit109, PairWithPosition.make(Lit105, LList.Empty, "syntax.scm", 0x10800a), (SimpleSymbol)(new SimpleSymbol("try-catch")).readResolve(), 
            Lit106, PairWithPosition.make(Lit105, LList.Empty, "syntax.scm", 0x10a00e), (SimpleSymbol)(new SimpleSymbol("ex")).readResolve(), (SimpleSymbol)(new SimpleSymbol("<java.lang.ClassCastException>")).readResolve(), Lit115, Lit107, PairWithPosition.make(Lit102, Pair.make((SimpleSymbol)(new SimpleSymbol("gnu.mapping.WrongType")).readResolve(), Pair.make(Pair.make(Lit104, Pair.make((SimpleSymbol)(new SimpleSymbol("make")).readResolve(), LList.Empty)), LList.Empty)), "syntax.scm", 0x10c014), PairWithPosition.make(PairWithPosition.make(Lit106, PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("<int>")).readResolve(), PairWithPosition.make(IntNum.make(1), LList.Empty, "syntax.scm", 0x10d016), "syntax.scm", 0x10d010), "syntax.scm", 0x10d00c), PairWithPosition.make(Lit105, LList.Empty, "syntax.scm", 0x10d019), "syntax.scm", 0x10d00c), (SimpleSymbol)(new SimpleSymbol("set!")).readResolve(), PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("field")).readResolve(), PairWithPosition.make(Lit107, PairWithPosition.make(PairWithPosition.make(Lit108, PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("expectedType")).readResolve(), LList.Empty, "syntax.scm", 0x10e015), "syntax.scm", 0x10e015), LList.Empty, "syntax.scm", 0x10e014), "syntax.scm", 0x10e011), "syntax.scm", 0x10e00a), 
            PairWithPosition.make(PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("primitive-throw")).readResolve(), PairWithPosition.make(Lit107, LList.Empty, "syntax.scm", 0x10f015), "syntax.scm", 0x10f004), LList.Empty, "syntax.scm", 0x10f004)
        }, 0);
        Lit101 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 3);
        obj = (SimpleSymbol)(new SimpleSymbol("receive")).readResolve();
        Lit98 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", new Object[0], 3), "\001\001\003", "\021\030\0049\021\030\f\t\020\b\013\b\021\030\f\t\003\b\025\023", new Object[] {
            Lit116, Lit109
        }, 1);
        Lit99 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 3);
        obj = (SimpleSymbol)(new SimpleSymbol("cond-expand")).readResolve();
        Lit91 = ((SimpleSymbol) (obj));
        Lit97 = new SyntaxTemplate("\001\001\000\0", "\021\030\004\032", new Object[] {
            obj
        }, 0);
        Lit96 = new SyntaxTemplate("\001\001\000\0", "\021\030\004\022", new Object[] {
            Lit110
        }, 0);
        Lit93 = (SimpleSymbol)(new SimpleSymbol("%cond-expand")).readResolve();
        obj = Lit91;
        obj1 = Lit112;
        Object obj2 = Lit113;
        Object obj3 = Lit114;
        Object obj4 = Lit111;
        SyntaxRule syntaxrule = new SyntaxRule(new SyntaxPattern("\f\030\b", new Object[0], 0), "", "\030\004", new Object[] {
            PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("%syntax-error")).readResolve(), PairWithPosition.make("Unfulfilled cond-expand", LList.Empty, "syntax.scm", 0xc4023), "syntax.scm", 0xc4014)
        }, 0);
        SyntaxRule syntaxrule1 = new SyntaxRule(new SyntaxPattern("\f\030<\f\002\r\007\000\b\b\b", new Object[] {
            Lit111
        }, 1), "\003", "\021\030\004\b\005\003", new Object[] {
            Lit110
        }, 1);
        SyntaxRule syntaxrule2 = new SyntaxRule(new SyntaxPattern("\f\030L\034\f\002\b\r\007\000\b\b\r\017\b\b\b", new Object[] {
            Lit112
        }, 2), "\003\003", "\021\030\004\b\005\003", new Object[] {
            Lit110
        }, 1);
        SyntaxRule syntaxrule3 = new SyntaxRule(new SyntaxPattern("\f\030|L\f\002\f\007\r\017\b\b\b\r\027\020\b\b\r\037\030\b\b", new Object[] {
            Lit112
        }, 4), "\001\003\003\003", "\021\030\004\241\t\003\b\021\030\004Q1\021\030\f\b\r\013\b\025\023\b\035\033\b\035\033", new Object[] {
            Lit91, Lit112
        }, 1);
        SyntaxRule syntaxrule4 = new SyntaxRule(new SyntaxPattern("\f\030L\034\f\002\b\r\007\000\b\b\r\017\b\b\b", new Object[] {
            Lit113
        }, 2), "\003\003", "\021\030\004\b\r\013", new Object[] {
            Lit91
        }, 1);
        SyntaxRule syntaxrule5 = new SyntaxRule(new SyntaxPattern("\f\030|L\f\002\f\007\r\017\b\b\b\r\027\020\b\b\r\037\030\b\b", new Object[] {
            Lit113
        }, 4), "\001\003\003\003", "\021\030\004I\t\003\b\021\030\f\b\025\023\b\021\030\024\b\021\030\004Q1\021\030\034\b\r\013\b\025\023\b\035\033", new Object[] {
            Lit91, Lit110, Lit111, Lit113
        }, 1);
        SyntaxRule syntaxrule6 = new SyntaxRule(new SyntaxPattern("\f\030\\,\f\002\f\007\b\r\017\b\b\b\r\027\020\b\b", new Object[] {
            Lit114
        }, 3), "\001\003\003", "\021\030\004I\t\003\b\021\030\004\b\025\023\b\021\030\f\b\r\013", new Object[] {
            Lit91, Lit111
        }, 1);
        SyntaxRule syntaxrule7 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3), "\001\000\0", "\021\030\004\031\t\003\n\022", new Object[] {
            Lit93
        }, 0);
        Lit92 = new SyntaxRules(new Object[] {
            obj, obj1, obj2, obj3, obj4
        }, new SyntaxRule[] {
            syntaxrule, syntaxrule1, syntaxrule2, syntaxrule3, syntaxrule4, syntaxrule5, syntaxrule6, syntaxrule7
        }, 4);
        Lit86 = new SyntaxTemplate("\001\000\001\000\0", "\021\030\004\t\023\032", new Object[] {
            Lit109
        }, 0);
        Lit83 = new SyntaxTemplate("\001\0", "\030\004", new Object[] {
            PairWithPosition.make(Lit102, Pair.make((SimpleSymbol)(new SimpleSymbol("gnu.expr.GenericProc")).readResolve(), Pair.make(Pair.make(Lit104, Pair.make((SimpleSymbol)(new SimpleSymbol("makeWithoutSorting")).readResolve(), LList.Empty)), LList.Empty)), "syntax.scm", 0x9f009)
        }, 0);
        Lit81 = (SimpleSymbol)(new SimpleSymbol("case-lambda")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("let*-values")).readResolve();
        Lit79 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\b\f\007\r\017\b\b\b", new Object[0], 2), "\001\003", "\021\030\004\t\003\b\r\013", new Object[] {
            Lit110
        }, 1);
        obj2 = new SyntaxPattern("\f\030<\f\007\r\017\b\b\b\f\027\r\037\030\b\b", new Object[0], 4);
        obj3 = (SimpleSymbol)(new SimpleSymbol("let-values")).readResolve();
        Lit77 = ((SimpleSymbol) (obj3));
        obj2 = new SyntaxRule(((SyntaxPattern) (obj2)), "\001\003\001\003", "\021\030\004\021\b\003\b\021\030\f\031\b\r\013\t\023\b\035\033", new Object[] {
            obj3, Lit79
        }, 1);
        Lit80 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 4);
        obj = Lit77;
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030,\r\007\000\b\b\f\017\r\027\020\b\b", new Object[0], 3), "\003\001\003", "\021\030\004\021\030\f\031\b\005\003\t\020\b\021\030\024\t\013\b\025\023", new Object[] {
            Lit77, "bind", Lit110
        }, 1);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\002\f\b\f\007\f\017\b", new Object[] {
            "bind"
        }, 2), "\001\001", "\021\030\004\t\003\b\013", new Object[] {
            Lit115
        }, 0);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030\f\002\\,\f\007\f\017\b\r\027\020\b\b\f\037\f'\b", new Object[] {
            "bind"
        }, 5), "\001\001\003\001\001", "\021\030\004\021\030\f\t\003\t\013\t\020\031\b\025\023\t\033\b#", new Object[] {
            Lit77, "mktmp"
        }, 1);
        obj4 = new SyntaxRule(new SyntaxPattern("\f\030\f\002\f\b\f\007\f\017\f\027\f\037\f'\b", new Object[] {
            "mktmp"
        }, 5), "\001\001\001\001\001", "\021\030\0049\021\030\f\t\020\b\003\b\021\030\f\t\013\b\021\030\024\021\030\034\t\023\t\033\b#", new Object[] {
            Lit116, Lit109, Lit77, "bind"
        }, 0);
        syntaxrule = new SyntaxRule(new SyntaxPattern("\f\030\f\002\034\f\007\013\f\027,\r\037\030\b\b\f',\r/(\b\b\f7\b", new Object[] {
            "mktmp"
        }, 7), "\001\000\001\003\001\003\001", "\021\030\004\021\030\f\t\n\t\023)\021\035\033\030\024\t#A\021-+\b\t\003\030\034\b3", new Object[] {
            Lit77, "mktmp", PairWithPosition.make(Lit117, LList.Empty, "syntax.scm", 0x8b02b), PairWithPosition.make(Lit117, LList.Empty, "syntax.scm", 0x8b046)
        }, 1);
        syntaxrule1 = new SyntaxRule(new SyntaxPattern("\f\030\f\002\f\007\f\017,\r\027\020\b\b\f\037,\r' \b\b\f/\b", new Object[] {
            "mktmp"
        }, 6), "\001\001\003\001\003\001", "\021\030\0049\021\030\f\t\020\b\013\b\021\030\f)\021\025\023\030\024\b\021\030\034\021\030$\t\033A\021%#\b\t\003\030,\b+", new Object[] {
            Lit116, Lit109, Lit117, Lit77, "bind", PairWithPosition.make(Lit117, LList.Empty, "syntax.scm", 0x91035)
        }, 1);
        Lit78 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2, obj3, obj4, syntaxrule, syntaxrule1
        }, 7);
        Lit73 = new SyntaxTemplate("\001\001\001", "\030\004", new Object[] {
            PairWithPosition.make(Lit102, Pair.make(Lit118, Pair.make(Pair.make(Lit104, Pair.make(Lit119, LList.Empty)), LList.Empty)), "syntax.scm", 0x72007)
        }, 0);
        Lit68 = new SyntaxTemplate("\001\001\001", "\030\004", new Object[] {
            PairWithPosition.make(Lit102, Pair.make(Lit118, Pair.make(Pair.make(Lit104, Pair.make(Lit119, LList.Empty)), LList.Empty)), "syntax.scm", 0x70007)
        }, 0);
        Lit65 = new SyntaxPattern("\f\007,\f\002\f\017\023\f\037\b", new Object[] {
            Lit120
        }, 4);
        obj = (SimpleSymbol)(new SimpleSymbol("%import")).readResolve();
        Lit38 = ((SimpleSymbol) (obj));
        Lit61 = new SyntaxTemplate("\001\001\001\001", "\021\030\004\b\013", new Object[] {
            obj
        }, 0);
        Lit60 = new SyntaxPattern("\f\007<\f\002\f\017\f\027\b\f\037\b", new Object[] {
            Lit120
        }, 4);
        Lit55 = new SyntaxTemplate("\001\001\000\001", "\021\030\004\b\013", new Object[] {
            Lit38
        }, 0);
        Lit48 = new SyntaxTemplate("\001\001\000\001", "\021\030\004\b\013", new Object[] {
            Lit38
        }, 0);
        Lit41 = new SyntaxTemplate("\001\001\000\001", "\021\030\004\b\013", new Object[] {
            Lit38
        }, 0);
        obj = (SimpleSymbol)(new SimpleSymbol("import")).readResolve();
        Lit36 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\r\007\000\b\b", new Object[0], 1), "\003", "\021\030\004\b\005\021\030\f\t\003\030\024", new Object[] {
            Lit110, Lit38, PairWithPosition.make(LList.Empty, LList.Empty, "syntax.scm", 0x5c022)
        }, 1);
        Lit37 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        Lit35 = (SimpleSymbol)(new SimpleSymbol("import-mapper")).readResolve();
        Lit34 = (SimpleSymbol)(new SimpleSymbol("import-handle-rename")).readResolve();
        Lit33 = (SimpleSymbol)(new SimpleSymbol("import-handle-prefix")).readResolve();
        Lit32 = (SimpleSymbol)(new SimpleSymbol("import-handle-except")).readResolve();
        Lit31 = (SimpleSymbol)(new SimpleSymbol("import-handle-only")).readResolve();
        Lit30 = (SimpleSymbol)(new SimpleSymbol("identifier-pair-list?")).readResolve();
        Lit29 = (SimpleSymbol)(new SimpleSymbol("identifier-list?")).readResolve();
        Lit25 = (SimpleSymbol)(new SimpleSymbol("synchronized")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("try-finally")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("when")).readResolve();
        Lit17 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2), "\001\003", "\021\030\004)\021\030\f\b\003\b\021\030\024\b\r\013", new Object[] {
            Lit121, Lit114, Lit110
        }, 1);
        Lit20 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 2);
        Lit19 = (SimpleSymbol)(new SimpleSymbol("unless")).readResolve();
        obj = Lit17;
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2), "\001\003", "\021\030\004\t\003\b\021\030\f\b\r\013", new Object[] {
            Lit121, Lit110
        }, 1);
        Lit18 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 2);
        obj = (SimpleSymbol)(new SimpleSymbol("define-syntax-case")).readResolve();
        Lit15 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\023", new Object[0], 3), "\001\001\0", "\021\030\004\t\003\b\021\030\f\021\030\024\b\021\030\034\021\030$\t\013\022", new Object[] {
            (SimpleSymbol)(new SimpleSymbol("define-syntax")).readResolve(), Lit109, PairWithPosition.make(Lit122, LList.Empty, "syntax.scm", 0x16011), (SimpleSymbol)(new SimpleSymbol("syntax-case")).readResolve(), Lit122
        }, 0);
        Lit16 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 3);
        obj = (SimpleSymbol)(new SimpleSymbol("define-macro")).readResolve();
        Lit13 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3), "\001\000\0", "\021\030\004\t\003\b\021\030\f\t\n\022", new Object[] {
            Lit123, Lit109
        }, 0);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\b\013", new Object[] {
            Lit123
        }, 0);
        Lit14 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 3);
        obj = (SimpleSymbol)(new SimpleSymbol("defmacro")).readResolve();
        Lit11 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\023", new Object[0], 3), "\001\001\0", "\021\030\004\t\003\b\021\030\f\t\013\022", new Object[] {
            Lit123, Lit109
        }, 0);
        Lit12 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 3);
        $instance = new syntax();
        defmacro = Macro.make(Lit11, Lit12, $instance);
        define$Mnmacro = Macro.make(Lit13, Lit14, $instance);
        define$Mnsyntax$Mncase = Macro.make(Lit15, Lit16, $instance);
        when = Macro.make(Lit17, Lit18, $instance);
        unless = Macro.make(Lit19, Lit20, $instance);
        obj1 = Lit21;
        obj = $instance;
        try$Mnfinally = Macro.make(obj1, new ModuleMethod(((ModuleBody) (obj)), 2, null, 4097), $instance);
        _fldsynchronized = Macro.make(Lit25, new ModuleMethod(((ModuleBody) (obj)), 3, null, 4097), $instance);
        identifier$Mnlist$Qu = new ModuleMethod(((ModuleBody) (obj)), 4, Lit29, 4097);
        identifier$Mnpair$Mnlist$Qu = new ModuleMethod(((ModuleBody) (obj)), 5, Lit30, 4097);
        import$Mnhandle$Mnonly = new ModuleMethod(((ModuleBody) (obj)), 6, Lit31, 8194);
        import$Mnhandle$Mnexcept = new ModuleMethod(((ModuleBody) (obj)), 7, Lit32, 8194);
        import$Mnhandle$Mnprefix = new ModuleMethod(((ModuleBody) (obj)), 8, Lit33, 8194);
        import$Mnhandle$Mnrename = new ModuleMethod(((ModuleBody) (obj)), 9, Lit34, 8194);
        import$Mnmapper = new ModuleMethod(((ModuleBody) (obj)), 10, Lit35, 4097);
        _fldimport = Macro.make(Lit36, Lit37, $instance);
        $Pcimport = Macro.make(Lit38, new ModuleMethod(((ModuleBody) (obj)), 11, null, 4097), $instance);
        let$Mnvalues = Macro.make(Lit77, Lit78, $instance);
        let$St$Mnvalues = Macro.make(Lit79, Lit80, $instance);
        case$Mnlambda = Macro.make(Lit81, new ModuleMethod(((ModuleBody) (obj)), 12, null, 4097), $instance);
        cond$Mnexpand = Macro.make(Lit91, Lit92, $instance);
        obj1 = Lit93;
        obj = new ModuleMethod(((ModuleBody) (obj)), 13, null, 4097);
        ((PropertySet) (obj)).setProperty("source-location", "syntax.scm:227");
        $Pccond$Mnexpand = Macro.make(obj1, ((Procedure) (obj)), $instance);
        receive = Macro.make(Lit98, Lit99, $instance);
        define$Mnalias$Mnparameter = Macro.make(Lit100, Lit101, $instance);
        $instance.run();
    }
}
