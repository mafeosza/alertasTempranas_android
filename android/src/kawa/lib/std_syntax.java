// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.QuoteExp;
import gnu.expr.Symbols;
import gnu.kawa.functions.AddOp;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Eval;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;
import kawa.standard.Scheme;
import kawa.standard.syntax_case;

public class std_syntax extends ModuleBody
{

    public static final Macro $Prvt$$Pccase;
    public static final Macro $Prvt$$Pccase$Mnmatch;
    public static final Macro $Prvt$$Pcdo$Mninit;
    public static final Macro $Prvt$$Pcdo$Mnlambda1;
    public static final Macro $Prvt$$Pcdo$Mnlambda2;
    public static final Macro $Prvt$$Pcdo$Mnstep;
    public static final Macro $Prvt$$Pclet$Mninit;
    public static final Macro $Prvt$$Pclet$Mnlambda1;
    public static final Macro $Prvt$$Pclet$Mnlambda2;
    public static final Location $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
    public static final Location $Prvt$define$Mnconstant = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");
    public static final Location $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
    public static final Location $Prvt$letrec = StaticFieldLocation.make("kawa.lib.prim_syntax", "letrec");
    public static final std_syntax $instance;
    static final IntNum Lit0 = IntNum.make(0);
    static final IntNum Lit1 = IntNum.make(1);
    static final SimpleSymbol Lit10;
    static final SyntaxPattern Lit11 = new SyntaxPattern("\f\007\b", new Object[0], 1);
    static final SyntaxPattern Lit12 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    static final SyntaxTemplate Lit13 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    static final SyntaxPattern Lit14 = new SyntaxPattern("\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    static final SyntaxTemplate Lit15;
    static final SimpleSymbol Lit16;
    static final SyntaxPattern Lit17 = new SyntaxPattern("\f\007\b", new Object[0], 1);
    static final SyntaxPattern Lit18 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    static final SyntaxTemplate Lit19 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    static final SimpleSymbol Lit2;
    static final SyntaxPattern Lit20 = new SyntaxPattern("\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    static final SyntaxTemplate Lit21;
    static final SimpleSymbol Lit22;
    static final SyntaxRules Lit23;
    static final SimpleSymbol Lit24;
    static final SyntaxRules Lit25;
    static final SimpleSymbol Lit26;
    static final SyntaxRules Lit27;
    static final SimpleSymbol Lit28;
    static final SyntaxRules Lit29;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit30;
    static final SyntaxRules Lit31;
    static final SimpleSymbol Lit32;
    static final SyntaxRules Lit33;
    static final SimpleSymbol Lit34;
    static final SyntaxRules Lit35;
    static final SimpleSymbol Lit36;
    static final SyntaxRules Lit37;
    static final SimpleSymbol Lit38;
    static final SyntaxRules Lit39;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit40;
    static final SyntaxRules Lit41;
    static final SimpleSymbol Lit42;
    static final SyntaxRules Lit43;
    static final SimpleSymbol Lit44;
    static final SyntaxRules Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SyntaxPattern Lit55 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    static final SimpleSymbol Lit56;
    static final SyntaxTemplate Lit57 = new SyntaxTemplate("\001\0", "\n", new Object[0], 0);
    static final SyntaxTemplate Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit6;
    static final SyntaxRules Lit60;
    static final SimpleSymbol Lit61;
    static final SyntaxRules Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SyntaxRules Lit7;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final SimpleSymbol Lit77;
    static final SimpleSymbol Lit8;
    static final SyntaxRules Lit9;
    public static final Macro and;
    public static final Macro begin$Mnfor$Mnsyntax;
    public static final Macro _fldcase;
    public static final Macro cond;
    public static final ModuleMethod datum$Mn$Grsyntax$Mnobject;
    public static final Macro define$Mnfor$Mnsyntax;
    public static final Macro define$Mnprocedure;
    public static final Macro delay;
    public static final Macro _flddo;
    public static final ModuleMethod free$Mnidentifier$Eq$Qu;
    public static final ModuleMethod generate$Mntemporaries;
    public static final ModuleMethod identifier$Qu;
    public static final Macro let;
    public static final Macro let$St;
    public static final Macro or;
    public static final ModuleMethod syntax$Mncolumn;
    public static final ModuleMethod syntax$Mnline;
    public static final ModuleMethod syntax$Mnobject$Mn$Grdatum;
    public static final ModuleMethod syntax$Mnsource;
    public static final Macro with$Mnsyntax;

    public std_syntax()
    {
        ModuleInfo.register(this);
    }

    public static Object datum$To$SyntaxObject(Object obj, Object obj1)
    {
        return SyntaxForms.makeWithTemplate(obj, obj1);
    }

    public static Object generateTemporaries(Object obj)
    {
        Object obj2 = Integer.valueOf(Translator.listLength(obj));
        Object obj1 = LList.Empty;
        do
        {
            if (Scheme.numEqu.apply2(obj2, Lit0) != Boolean.FALSE)
            {
                return obj1;
            }
            obj2 = AddOp.$Mn.apply2(obj2, Lit1);
            obj1 = new Pair(datum$To$SyntaxObject(obj, Symbols.gentemp()), obj1);
        } while (true);
    }

    public static boolean isFreeIdentifier$Eq(Object obj, Object obj1)
    {
        SyntaxForm syntaxform;
        try
        {
            syntaxform = (SyntaxForm)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "kawa.lang.SyntaxForms.freeIdentifierEquals(kawa.lang.SyntaxForm,kawa.lang.SyntaxForm)", 1, obj);
        }
        try
        {
            obj = (SyntaxForm)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "kawa.lang.SyntaxForms.freeIdentifierEquals(kawa.lang.SyntaxForm,kawa.lang.SyntaxForm)", 2, obj1);
        }
        return SyntaxForms.freeIdentifierEquals(syntaxform, ((SyntaxForm) (obj)));
    }

    public static boolean isIdentifier(Object obj)
    {
        boolean flag = obj instanceof Symbol;
        if (!flag)
        {
            boolean flag1 = obj instanceof SyntaxForm;
            flag = flag1;
            if (flag1)
            {
                SyntaxForm syntaxform;
                try
                {
                    syntaxform = (SyntaxForm)obj;
                }
                catch (ClassCastException classcastexception)
                {
                    throw new WrongType(classcastexception, "kawa.lang.SyntaxForms.isIdentifier(kawa.lang.SyntaxForm)", 1, obj);
                }
                return SyntaxForms.isIdentifier(syntaxform);
            }
        }
        return flag;
    }

    static Object lambda1(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(3, null);
        if (Lit11.match(obj, aobj, 0))
        {
            return new QuoteExp(Language.getDefaultLanguage().booleanObject(true));
        }
        if (Lit12.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit13.execute(aobj, ((TemplateScope) (obj)));
        }
        if (Lit14.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit15.execute(aobj, ((TemplateScope) (obj)));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda2(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(3, null);
        if (Lit17.match(obj, aobj, 0))
        {
            return new QuoteExp(Language.getDefaultLanguage().booleanObject(false));
        }
        if (Lit18.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit19.execute(aobj, ((TemplateScope) (obj)));
        }
        if (Lit20.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            return Lit21.execute(aobj, ((TemplateScope) (obj)));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda3(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(2, null);
        if (Lit55.match(obj, aobj, 0))
        {
            Eval eval = Eval.eval;
            SimpleSymbol simplesymbol = Lit56;
            TemplateScope templatescope = TemplateScope.make();
            if (eval.apply1(syntaxObject$To$Datum(new Pair(simplesymbol, Lit57.execute(aobj, templatescope)))) != Boolean.FALSE)
            {
                obj = TemplateScope.make();
                return Lit58.execute(aobj, ((TemplateScope) (obj)));
            }
        }
        return syntax_case.error("syntax-case", obj);
    }

    public static Object syntaxColumn(Object obj)
    {
        if (obj instanceof SyntaxForm)
        {
            return syntaxLine(((SyntaxForm)obj).getDatum());
        }
        if (obj instanceof PairWithPosition)
        {
            return Integer.valueOf(((PairWithPosition)obj).getColumnNumber() + 0);
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static Object syntaxLine(Object obj)
    {
        if (obj instanceof SyntaxForm)
        {
            return syntaxLine(((SyntaxForm)obj).getDatum());
        }
        if (obj instanceof PairWithPosition)
        {
            return Integer.valueOf(((PairWithPosition)obj).getLineNumber());
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static Object syntaxObject$To$Datum(Object obj)
    {
        return Quote.quote(obj);
    }

    public static Object syntaxSource(Object obj)
    {
        if (obj instanceof SyntaxForm)
        {
            obj = syntaxSource(((SyntaxForm)obj).getDatum());
        } else
        if (obj instanceof PairWithPosition)
        {
            String s = ((PairWithPosition)obj).getFileName();
            obj = s;
            if (s == null)
            {
                return Boolean.FALSE;
            }
        } else
        {
            return Boolean.FALSE;
        }
        return obj;
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        case 7: // '\007'
        default:
            return super.apply1(modulemethod, obj);

        case 3: // '\003'
            return syntaxObject$To$Datum(obj);

        case 5: // '\005'
            return generateTemporaries(obj);

        case 6: // '\006'
            if (isIdentifier(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 8: // '\b'
            return syntaxSource(obj);

        case 9: // '\t'
            return syntaxLine(obj);

        case 10: // '\n'
            return syntaxColumn(obj);

        case 1: // '\001'
            return lambda1(obj);

        case 2: // '\002'
            return lambda2(obj);

        case 11: // '\013'
            return lambda3(obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        case 5: // '\005'
        case 6: // '\006'
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 4: // '\004'
            return datum$To$SyntaxObject(obj, obj1);

        case 7: // '\007'
            break;
        }
        if (isFreeIdentifier$Eq(obj, obj1))
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        case 7: // '\007'
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 11: // '\013'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

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

        case 10: // '\n'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 9: // '\t'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 8: // '\b'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 6: // '\006'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 5: // '\005'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 3: // '\003'
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
        case 5: // '\005'
        case 6: // '\006'
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 7: // '\007'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 4: // '\004'
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
        Lit77 = (SimpleSymbol)(new SimpleSymbol("temp")).readResolve();
        Lit76 = (SimpleSymbol)(new SimpleSymbol("=>")).readResolve();
        Lit75 = (SimpleSymbol)(new SimpleSymbol("else")).readResolve();
        Lit74 = (SimpleSymbol)(new SimpleSymbol("eqv?")).readResolve();
        Lit73 = (SimpleSymbol)(new SimpleSymbol("x")).readResolve();
        Lit72 = (SimpleSymbol)(new SimpleSymbol("if")).readResolve();
        Lit71 = (SimpleSymbol)(new SimpleSymbol("letrec")).readResolve();
        Lit70 = (SimpleSymbol)(new SimpleSymbol("%let")).readResolve();
        Lit69 = (SimpleSymbol)(new SimpleSymbol("%syntax-error")).readResolve();
        Lit68 = (SimpleSymbol)(new SimpleSymbol("lambda")).readResolve();
        Lit67 = (SimpleSymbol)(new SimpleSymbol("make")).readResolve();
        Lit66 = (SimpleSymbol)(new SimpleSymbol("quote")).readResolve();
        Lit65 = (SimpleSymbol)(new SimpleSymbol("<gnu.expr.GenericProc>")).readResolve();
        Lit64 = (SimpleSymbol)(new SimpleSymbol("::")).readResolve();
        Lit63 = (SimpleSymbol)(new SimpleSymbol("syntax-case")).readResolve();
        Object obj = (SimpleSymbol)(new SimpleSymbol("with-syntax")).readResolve();
        Lit61 = ((SimpleSymbol) (obj));
        Object obj1 = new SyntaxPattern("\f\030\f\b\f\007\r\017\b\b\b", new Object[0], 2);
        Object obj2 = (SimpleSymbol)(new SimpleSymbol("begin")).readResolve();
        Lit56 = ((SimpleSymbol) (obj2));
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\001\003", "\021\030\004\t\003\b\r\013", new Object[] {
            obj2
        }, 1);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030<,\f\007\f\017\b\b\f\027\r\037\030\b\b", new Object[0], 4), "\001\001\001\003", "\021\030\004\t\013\t\020\b\t\003\b\021\030\f\t\023\b\035\033", new Object[] {
            Lit63, Lit56
        }, 1);
        Object obj3 = new SyntaxRule(new SyntaxPattern("\f\030L-\f\007\f\017\b\000\020\b\f\027\r\037\030\b\b", new Object[0], 4), "\003\003\001\003", "\021\030\0041\021\030\f\b\r\013\t\020\b\031\b\005\003\b\021\030\024\t\023\b\035\033", new Object[] {
            Lit63, (SimpleSymbol)(new SimpleSymbol("list")).readResolve(), Lit56
        }, 1);
        Lit62 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2, obj3
        }, 4);
        obj = (SimpleSymbol)(new SimpleSymbol("define-for-syntax")).readResolve();
        Lit59 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxPattern("\f\030\003", new Object[0], 1);
        obj2 = (SimpleSymbol)(new SimpleSymbol("begin-for-syntax")).readResolve();
        Lit54 = ((SimpleSymbol) (obj2));
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\0", "\021\030\004\b\021\030\f\002", new Object[] {
            obj2, (SimpleSymbol)(new SimpleSymbol("define")).readResolve()
        }, 0);
        Lit60 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        Lit58 = new SyntaxTemplate("\001\0", "\030\004", new Object[] {
            Values.empty
        }, 0);
        Lit53 = (SimpleSymbol)(new SimpleSymbol("syntax-column")).readResolve();
        Lit52 = (SimpleSymbol)(new SimpleSymbol("syntax-line")).readResolve();
        Lit51 = (SimpleSymbol)(new SimpleSymbol("syntax-source")).readResolve();
        Lit50 = (SimpleSymbol)(new SimpleSymbol("free-identifier=?")).readResolve();
        Lit49 = (SimpleSymbol)(new SimpleSymbol("identifier?")).readResolve();
        Lit48 = (SimpleSymbol)(new SimpleSymbol("generate-temporaries")).readResolve();
        Lit47 = (SimpleSymbol)(new SimpleSymbol("datum->syntax-object")).readResolve();
        Lit46 = (SimpleSymbol)(new SimpleSymbol("syntax-object->datum")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("define-procedure")).readResolve();
        Lit44 = ((SimpleSymbol) (obj));
        obj1 = Lit64;
        obj2 = Lit65;
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2), "\001\003", "\021\030\004\301\021\030\f\t\003\021\030\024\021\030\034\b\021\030$\021\030\034\b\021\030,\b\003\b\021\0304\t\003\021\030<\b\021\030D\b\r\013", new Object[] {
            Lit56, (SimpleSymbol)(new SimpleSymbol("define-constant")).readResolve(), Lit64, Lit65, Lit67, Lit66, (SimpleSymbol)(new SimpleSymbol("invoke")).readResolve(), PairWithPosition.make(Lit66, PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("setProperties")).readResolve(), LList.Empty, "std_syntax.scm", 0xfa014), "std_syntax.scm", 0xfa014), (SimpleSymbol)(new SimpleSymbol("java.lang.Object[]")).readResolve()
        }, 1);
        Lit45 = new SyntaxRules(new Object[] {
            obj, obj1, obj2
        }, new SyntaxRule[] {
            obj3
        }, 2);
        obj = (SimpleSymbol)(new SimpleSymbol("delay")).readResolve();
        Lit42 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\b", new Object[0], 1), "\001", "\021\030\004\021\030\f\b\021\030\024\t\020\b\003", new Object[] {
            Lit67, (SimpleSymbol)(new SimpleSymbol("<kawa.lang.Promise>")).readResolve(), Lit68
        }, 0);
        Lit43 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        obj = (SimpleSymbol)(new SimpleSymbol("do")).readResolve();
        Lit40 = ((SimpleSymbol) (obj));
        obj1 = Lit64;
        obj2 = new SyntaxPattern("\f\030,\r\007\000\b\b\034\f\017\023\r\037\030\b\b", new Object[0], 4);
        obj3 = Lit71;
        Object obj4 = (SimpleSymbol)(new SimpleSymbol("%do%loop")).readResolve();
        Object obj5 = (SimpleSymbol)(new SimpleSymbol("%do-lambda1")).readResolve();
        Lit36 = ((SimpleSymbol) (obj5));
        Object obj6 = Lit72;
        Object obj7 = (SimpleSymbol)(new SimpleSymbol("not")).readResolve();
        Object obj8 = Lit56;
        Object obj9 = (SimpleSymbol)(new SimpleSymbol("%do-step")).readResolve();
        Lit32 = ((SimpleSymbol) (obj9));
        Object obj10 = Values.empty;
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("%do-init")).readResolve();
        Lit34 = simplesymbol;
        obj2 = new SyntaxRule(((SyntaxPattern) (obj2)), "\003\001\000\003", "\021\030\004\u0189\b\021\030\f\b\021\030\024\031\b\005\003\t\020\b\021\030\034)\021\030$\b\013\201\021\030,\021\035\033\b\021\030\f\b\005\021\0304\003\b\021\030,\021\030<\022\b\021\030\f\b\005\021\030D\b\003", new Object[] {
            obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, simplesymbol
        }, 1);
        Lit41 = new SyntaxRules(new Object[] {
            obj, obj1
        }, new SyntaxRule[] {
            obj2
        }, 4);
        obj = (SimpleSymbol)(new SimpleSymbol("%do-lambda2")).readResolve();
        Lit38 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\013\f\027\f\037\b", new Object[0], 4), "\001\000\001\001", "\021\030\004\t\n\031\t\003\023\b\033", new Object[] {
            Lit38
        }, 0);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\b\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\b\013", new Object[] {
            Lit68
        }, 0);
        Lit39 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 4);
        obj = Lit36;
        obj1 = Lit64;
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030l\\\f\007\f\002\f\017\f\027\f\037\b#\f/\f7\b", new Object[] {
            Lit64
        }, 7), "\001\001\001\001\000\001\001", "\021\030\004\t\"I9\t\003\021\030\f\b\013+\b3", new Object[] {
            Lit36, Lit64
        }, 0);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030\\L\f\007\f\002\f\017\f\027\b\033\f'\f/\b", new Object[] {
            Lit64
        }, 6), "\001\001\001\000\001\001", "\021\030\004\t\032I9\t\003\021\030\f\b\013#\b+", new Object[] {
            Lit36, Lit64
        }, 0);
        obj4 = new SyntaxRule(new SyntaxPattern("\f\030L<\f\007\f\017\f\027\b\033\f'\f/\b", new Object[0], 6), "\001\001\001\000\001\001", "\021\030\004\t\032\031\t\003#\b+", new Object[] {
            Lit36
        }, 0);
        obj5 = new SyntaxRule(new SyntaxPattern("\f\030<,\f\007\f\017\b\023\f\037\f'\b", new Object[0], 5), "\001\001\000\001\001", "\021\030\004\t\022\031\t\003\033\b#", new Object[] {
            Lit36
        }, 0);
        obj6 = new SyntaxRule(new SyntaxPattern("\f\030\f\b\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\t\020\b\013", new Object[] {
            Lit38
        }, 0);
        Lit37 = new SyntaxRules(new Object[] {
            obj, obj1
        }, new SyntaxRule[] {
            obj2, obj3, obj4, obj5, obj6
        }, 7);
        obj = Lit34;
        obj1 = Lit64;
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\\\f\007\f\002\f\017\f\027\f\037\b\b", new Object[] {
            Lit64
        }, 4), "\001\001\001\001", "\023", new Object[0], 0);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030L\f\007\f\002\f\017\f\027\b\b", new Object[] {
            Lit64
        }, 3), "\001\001\001", "\023", new Object[0], 0);
        obj4 = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\017\f\027\b\b", new Object[0], 3), "\001\001\001", "\013", new Object[0], 0);
        obj5 = new SyntaxRule(new SyntaxPattern("\f\030,\f\007\f\017\b\b", new Object[0], 2), "\001\001", "\013", new Object[0], 0);
        obj6 = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\017\f\027\b\b", new Object[0], 3), "\001\001\001", "\023", new Object[0], 0);
        obj7 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\b\b", new Object[0], 1), "\001", "\030\004", new Object[] {
            PairWithPosition.make(Lit69, PairWithPosition.make("do binding with no value", LList.Empty, "std_syntax.scm", 0xc2013), "std_syntax.scm", 0xc2004)
        }, 0);
        obj8 = new SyntaxRule(new SyntaxPattern("\f\030L\f\007\f\017\f\027\f\037\b\b", new Object[0], 4), "\001\001\001\001", "\030\004", new Object[] {
            PairWithPosition.make(Lit69, PairWithPosition.make("do binding must have syntax: (var [:: type] init [step])", LList.Empty, "std_syntax.scm", 0xc5005), "std_syntax.scm", 0xc4004)
        }, 0);
        Lit35 = new SyntaxRules(new Object[] {
            obj, obj1
        }, new SyntaxRule[] {
            obj2, obj3, obj4, obj5, obj6, obj7, obj8
        }, 4);
        obj = Lit32;
        obj1 = Lit64;
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\f\037\b", new Object[] {
            Lit64
        }, 4), "\001\001\001\001", "\033", new Object[0], 0);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", new Object[] {
            Lit64
        }, 3), "\001\001\001", "\003", new Object[0], 0);
        obj4 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3), "\001\001\001", "\023", new Object[0], 0);
        obj5 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2), "\001\001", "\003", new Object[0], 0);
        Lit33 = new SyntaxRules(new Object[] {
            obj, obj1
        }, new SyntaxRule[] {
            obj2, obj3, obj4, obj5
        }, 4);
        obj = (SimpleSymbol)(new SimpleSymbol("let*")).readResolve();
        Lit30 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\b\003", new Object[0], 1), "\0", "\021\030\004\t\020\002", new Object[] {
            Lit70
        }, 0);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\b\013", new Object[0], 2), "\001\0", "\021\030\004\021\b\003\n", new Object[] {
            Lit70
        }, 0);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3), "\001\000\0", "\021\030\004\021\b\003\b\021\030\f\t\n\022", new Object[] {
            Lit70, Lit30
        }, 0);
        obj4 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\013", new Object[0], 2), "\001\0", "\030\004", new Object[] {
            PairWithPosition.make(Lit69, PairWithPosition.make("invalid bindings list in let*", LList.Empty, "std_syntax.scm", 0xa6007), "std_syntax.scm", 0xa5006)
        }, 0);
        obj5 = new SyntaxRule(new SyntaxPattern("\f\030\003", new Object[0], 1), "\0", "\030\004", new Object[] {
            PairWithPosition.make(Lit69, PairWithPosition.make("missing bindings list in let*", LList.Empty, "std_syntax.scm", 0xa9007), "std_syntax.scm", 0xa8006)
        }, 0);
        Lit31 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2, obj3, obj4, obj5
        }, 3);
        obj = (SimpleSymbol)(new SimpleSymbol("let")).readResolve();
        Lit28 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030,\r\007\000\b\b\013", new Object[0], 2), "\003\0", "\021\030\004\031\b\005\003\n", new Object[] {
            Lit70
        }, 1);
        obj2 = new SyntaxPattern("\f\030\f\007,\r\017\b\b\b\023", new Object[0], 3);
        obj3 = Lit71;
        obj4 = (SimpleSymbol)(new SimpleSymbol("%let-lambda1")).readResolve();
        Lit22 = ((SimpleSymbol) (obj4));
        obj5 = (SimpleSymbol)(new SimpleSymbol("%let-init")).readResolve();
        Lit26 = ((SimpleSymbol) (obj5));
        obj2 = new SyntaxRule(((SyntaxPattern) (obj2)), "\001\003\0", "\251\021\030\004y\b\t\003\b\021\030\f\031\b\r\013\t\020\b\022\b\003\b\r\021\030\024\b\013", new Object[] {
            obj3, obj4, obj5
        }, 1);
        Lit29 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 3);
        obj = Lit26;
        obj1 = Lit64;
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030,\f\007\f\017\b\b", new Object[0], 2), "\001\001", "\013", new Object[0], 0);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030L\f\007\f\002\f\017\f\027\b\b", new Object[] {
            Lit64
        }, 3), "\001\001\001", "\023", new Object[0], 0);
        obj4 = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\017\f\027\b\b", new Object[0], 3), "\001\001\001", "\023", new Object[0], 0);
        obj5 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\b\b", new Object[0], 1), "\001", "\030\004", new Object[] {
            PairWithPosition.make(Lit69, PairWithPosition.make("let binding with no value", LList.Empty, "std_syntax.scm", 0x87013), "std_syntax.scm", 0x87004)
        }, 0);
        obj6 = new SyntaxRule(new SyntaxPattern("\f\030L\f\007\f\017\f\027\f\037\b\b", new Object[0], 4), "\001\001\001\001", "\030\004", new Object[] {
            PairWithPosition.make(Lit69, PairWithPosition.make("let binding must have syntax: (var [type] init)", LList.Empty, "std_syntax.scm", 0x8a005), "std_syntax.scm", 0x89004)
        }, 0);
        Lit27 = new SyntaxRules(new Object[] {
            obj, obj1
        }, new SyntaxRule[] {
            obj2, obj3, obj4, obj5, obj6
        }, 4);
        obj = (SimpleSymbol)(new SimpleSymbol("%let-lambda2")).readResolve();
        Lit24 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\013\f\027\f\037\b", new Object[0], 4), "\001\000\001\001", "\021\030\004\t\n\031\t\003\023\b\033", new Object[] {
            Lit24
        }, 0);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\b\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\013", new Object[] {
            Lit68
        }, 0);
        Lit25 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 4);
        obj = Lit22;
        obj1 = Lit64;
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030L<\f\007\f\017\f\027\b\033\f'\f/\b", new Object[0], 6), "\001\001\001\000\001\001", "\021\030\004\t\0321!\t\003\b\013#\b+", new Object[] {
            Lit22
        }, 0);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030\\L\f\007\f\002\f\017\f\027\b\033\f'\f/\b", new Object[] {
            Lit64
        }, 6), "\001\001\001\000\001\001", "\021\030\004\t\0321!\t\003\b\013#\b+", new Object[] {
            Lit22
        }, 0);
        obj4 = new SyntaxRule(new SyntaxPattern("\f\030<,\f\007\f\017\b\023\f\037\f'\b", new Object[0], 5), "\001\001\000\001\001", "\021\030\004\t\022\031\t\003\033\b#", new Object[] {
            Lit22
        }, 0);
        obj5 = new SyntaxRule(new SyntaxPattern("\f\030\f\b\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\t\020\b\013", new Object[] {
            Lit24
        }, 0);
        Lit23 = new SyntaxRules(new Object[] {
            obj, obj1
        }, new SyntaxRule[] {
            obj2, obj3, obj4, obj5
        }, 6);
        Lit21 = new SyntaxTemplate("\001\001\003", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f\021\030\f\b\t\003\b\025\023", new Object[] {
            Lit70, Lit73, Lit72
        }, 1);
        Lit16 = (SimpleSymbol)(new SimpleSymbol("or")).readResolve();
        Lit15 = new SyntaxTemplate("\001\001\003", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f)\t\003\b\025\023\030\034", new Object[] {
            Lit70, Lit73, Lit72, PairWithPosition.make(Lit73, LList.Empty, "std_syntax.scm", 0x5e01c)
        }, 1);
        Lit10 = (SimpleSymbol)(new SimpleSymbol("and")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("%case-match")).readResolve();
        Lit8 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\b\021\030\f\b\013", new Object[] {
            Lit74, Lit66
        }, 0);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", new Object[0], 3), "\001\001\003", "\021\030\004Y\021\030\f\t\003\b\021\030\024\b\013\b\021\030\034\t\003\b\025\023", new Object[] {
            Lit16, Lit74, Lit66, Lit8
        }, 1);
        Lit9 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 3);
        obj = (SimpleSymbol)(new SimpleSymbol("%case")).readResolve();
        Lit6 = ((SimpleSymbol) (obj));
        obj1 = Lit75;
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007<\f\002\r\017\b\b\b\b", new Object[] {
            Lit75
        }, 2), "\001\003", "\021\030\004\b\r\013", new Object[] {
            Lit56
        }, 1);
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030\f\007<\f\002\r\017\b\b\b\023", new Object[] {
            Lit75
        }, 3), "\001\003\0", "\030\004", new Object[] {
            PairWithPosition.make(Lit69, PairWithPosition.make("junk following else (in case)", LList.Empty, "std_syntax.scm", 0x3b00a), "std_syntax.scm", 0x3a009)
        }, 0);
        obj4 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\\,\r\017\b\b\b\r\027\020\b\b\b", new Object[0], 3), "\001\003\003", "\021\030\004A\021\030\f\t\003\b\r\013\b\021\030\024\b\025\023", new Object[] {
            Lit72, Lit8, Lit56
        }, 1);
        obj5 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\\,\r\017\b\b\b\r\027\020\b\b\f\037\r' \b\b", new Object[0], 5), "\001\003\003\001\003", "\021\030\004A\021\030\f\t\003\b\r\0131\021\030\024\b\025\023\b\021\030\034\t\003\t\033\b%#", new Object[] {
            Lit72, Lit8, Lit56, Lit6
        }, 1);
        Lit7 = new SyntaxRules(new Object[] {
            obj, obj1
        }, new SyntaxRule[] {
            obj2, obj3, obj4, obj5
        }, 5);
        obj = (SimpleSymbol)(new SimpleSymbol("case")).readResolve();
        Lit4 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2), "\001\003", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f\b\r\013", new Object[] {
            Lit70, (SimpleSymbol)(new SimpleSymbol("tmp")).readResolve(), Lit6
        }, 1);
        Lit5 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 2);
        obj = (SimpleSymbol)(new SimpleSymbol("cond")).readResolve();
        Lit2 = ((SimpleSymbol) (obj));
        obj1 = Lit75;
        obj2 = Lit76;
        obj3 = new SyntaxRule(new SyntaxPattern("\f\030L\f\002\f\007\r\017\b\b\b\b", new Object[] {
            Lit75
        }, 2), "\001\003", "\021\030\004\t\003\b\r\013", new Object[] {
            Lit56
        }, 1);
        obj4 = new SyntaxRule(new SyntaxPattern("\f\030L\f\002\f\007\r\017\b\b\b\r\027\020\b\b", new Object[] {
            Lit75
        }, 3), "\001\003\003", "\030\004", new Object[] {
            PairWithPosition.make(Lit69, PairWithPosition.make("else clause must be last clause of cond", LList.Empty, "std_syntax.scm", 0x15013), "std_syntax.scm", 0x15004)
        }, 0);
        obj5 = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\002\f\017\b\b", new Object[] {
            Lit76
        }, 2), "\001\001", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f\b\t\013\030\034", new Object[] {
            Lit70, Lit77, Lit72, PairWithPosition.make(Lit77, LList.Empty, "std_syntax.scm", 0x19017)
        }, 0);
        obj6 = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\002\f\017\b\f\027\r\037\030\b\b", new Object[] {
            Lit76
        }, 4), "\001\001\001\003", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f!\t\013\030\034\b\021\030$\t\023\b\035\033", new Object[] {
            Lit70, Lit77, Lit72, PairWithPosition.make(Lit77, LList.Empty, "std_syntax.scm", 0x1e012), Lit2
        }, 1);
        obj7 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\b\b", new Object[0], 1), "\001", "\003", new Object[0], 0);
        obj8 = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\b\f\017\r\027\020\b\b", new Object[0], 3), "\001\001\003", "\021\030\004\t\003\b\021\030\f\t\013\b\025\023", new Object[] {
            Lit16, Lit2
        }, 1);
        obj9 = new SyntaxRule(new SyntaxPattern("\f\030L\f\007\f\017\r\027\020\b\b\b", new Object[0], 3), "\001\001\003", "\021\030\004\t\003\b\021\030\f\t\013\b\025\023", new Object[] {
            Lit72, Lit56
        }, 1);
        obj10 = new SyntaxRule(new SyntaxPattern("\f\030L\f\007\f\017\r\027\020\b\b\f\037\r' \b\b", new Object[0], 5), "\001\001\003\001\003", "\021\030\004\t\003A\021\030\f\t\013\b\025\023\b\021\030\024\t\033\b%#", new Object[] {
            Lit72, Lit56, Lit2
        }, 1);
        Lit3 = new SyntaxRules(new Object[] {
            obj, obj1, obj2
        }, new SyntaxRule[] {
            obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10
        }, 5);
        $instance = new std_syntax();
        cond = Macro.make(Lit2, Lit3, $instance);
        _fldcase = Macro.make(Lit4, Lit5, $instance);
        $Prvt$$Pccase = Macro.make(Lit6, Lit7, $instance);
        $Prvt$$Pccase$Mnmatch = Macro.make(Lit8, Lit9, $instance);
        obj1 = Lit10;
        obj = $instance;
        and = Macro.make(obj1, new ModuleMethod(((ModuleBody) (obj)), 1, null, 4097), $instance);
        or = Macro.make(Lit16, new ModuleMethod(((ModuleBody) (obj)), 2, null, 4097), $instance);
        $Prvt$$Pclet$Mnlambda1 = Macro.make(Lit22, Lit23, $instance);
        $Prvt$$Pclet$Mnlambda2 = Macro.make(Lit24, Lit25, $instance);
        $Prvt$$Pclet$Mninit = Macro.make(Lit26, Lit27, $instance);
        let = Macro.make(Lit28, Lit29, $instance);
        let$St = Macro.make(Lit30, Lit31, $instance);
        $Prvt$$Pcdo$Mnstep = Macro.make(Lit32, Lit33, $instance);
        $Prvt$$Pcdo$Mninit = Macro.make(Lit34, Lit35, $instance);
        $Prvt$$Pcdo$Mnlambda1 = Macro.make(Lit36, Lit37, $instance);
        $Prvt$$Pcdo$Mnlambda2 = Macro.make(Lit38, Lit39, $instance);
        _flddo = Macro.make(Lit40, Lit41, $instance);
        delay = Macro.make(Lit42, Lit43, $instance);
        define$Mnprocedure = Macro.make(Lit44, Lit45, $instance);
        syntax$Mnobject$Mn$Grdatum = new ModuleMethod(((ModuleBody) (obj)), 3, Lit46, 4097);
        datum$Mn$Grsyntax$Mnobject = new ModuleMethod(((ModuleBody) (obj)), 4, Lit47, 8194);
        generate$Mntemporaries = new ModuleMethod(((ModuleBody) (obj)), 5, Lit48, 4097);
        identifier$Qu = new ModuleMethod(((ModuleBody) (obj)), 6, Lit49, 4097);
        free$Mnidentifier$Eq$Qu = new ModuleMethod(((ModuleBody) (obj)), 7, Lit50, 8194);
        syntax$Mnsource = new ModuleMethod(((ModuleBody) (obj)), 8, Lit51, 4097);
        syntax$Mnline = new ModuleMethod(((ModuleBody) (obj)), 9, Lit52, 4097);
        syntax$Mncolumn = new ModuleMethod(((ModuleBody) (obj)), 10, Lit53, 4097);
        obj1 = Lit54;
        obj = new ModuleMethod(((ModuleBody) (obj)), 11, null, 4097);
        ((PropertySet) (obj)).setProperty("source-location", "std_syntax.scm:298");
        begin$Mnfor$Mnsyntax = Macro.make(obj1, ((Procedure) (obj)), $instance);
        define$Mnfor$Mnsyntax = Macro.make(Lit59, Lit60, $instance);
        with$Mnsyntax = Macro.make(Lit61, Lit62, $instance);
        $instance.run();
    }
}
