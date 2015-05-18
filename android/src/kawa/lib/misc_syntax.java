// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.Compilation;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.GetModuleClass;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.Location;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.standard.syntax_case;

// Referenced classes of package kawa.lib:
//            std_syntax, misc, strings, lists, 
//            prim_syntax, ports

public class misc_syntax extends ModuleBody
{
    public class frame extends ModuleBody
    {

        Object k;
        InPort p;

        public Object lambda4f()
        {
            Object obj = ports.read(p);
            if (ports.isEofObject(obj))
            {
                ports.closeInputPort(p);
                return LList.Empty;
            } else
            {
                return new Pair(std_syntax.datum$To$SyntaxObject(k, obj), lambda4f());
            }
        }

        public frame()
        {
        }
    }


    public static final Location $Prvt$define$Mnconstant = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");
    public static final misc_syntax $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxPattern Lit1 = new SyntaxPattern("\f\007,\f\017\f\027\b\b", new Object[0], 3);
    static final SimpleSymbol Lit10;
    static final SyntaxRules Lit11;
    static final SimpleSymbol Lit12;
    static final SyntaxPattern Lit13 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    static final SyntaxTemplate Lit14 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit15 = new SyntaxTemplate("\001\001", "\003", new Object[0], 0);
    static final SyntaxPattern Lit16 = new SyntaxPattern("\r\027\020\b\b", new Object[0], 3);
    static final SyntaxTemplate Lit17;
    static final SimpleSymbol Lit18;
    static final SyntaxPattern Lit19 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    static final SyntaxTemplate Lit2 = new SyntaxTemplate("\001\001\001", "\030\004", new Object[] {
        (SimpleSymbol)(new SimpleSymbol("define-constant")).readResolve()
    }, 0);
    static final SyntaxTemplate Lit20 = new SyntaxTemplate("\001\001", "\b\013", new Object[0], 0);
    static final SyntaxTemplate Lit21 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    static final SyntaxTemplate Lit22 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SyntaxTemplate Lit3 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SyntaxTemplate Lit4;
    static final SyntaxPattern Lit5 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    static final SimpleSymbol Lit6;
    static final SyntaxRules Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxPattern Lit9 = new SyntaxPattern("\f\007\b", new Object[0], 1);
    public static final Macro include;
    public static final Macro include$Mnrelative;
    public static final Macro module$Mnuri;
    public static final Macro provide;
    public static final Macro resource$Mnurl;
    public static final Macro test$Mnbegin;

    public misc_syntax()
    {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(3, null);
        if (Lit1.match(obj, aobj, 0))
        {
            Object obj1 = TemplateScope.make();
            obj1 = Lit2.execute(aobj, ((TemplateScope) (obj1)));
            Object obj2 = TemplateScope.make();
            obj2 = std_syntax.syntaxObject$To$Datum(Lit3.execute(aobj, ((TemplateScope) (obj2))));
            Symbol symbol;
            try
            {
                symbol = (Symbol)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "symbol->string", 1, obj2);
            }
            obj = std_syntax.datum$To$SyntaxObject(obj, misc.string$To$Symbol(strings.stringAppend(new Object[] {
                "%provide%", misc.symbol$To$String(symbol)
            })));
            obj2 = TemplateScope.make();
            return lists.cons(obj1, lists.cons(obj, Lit4.execute(aobj, ((TemplateScope) (obj2)))));
        }
        if (Lit5.match(obj, aobj, 0))
        {
            if ("provide requires a quoted feature-name" instanceof Object[])
            {
                aobj = (Object[])"provide requires a quoted feature-name";
            } else
            {
                aobj = (new Object[] {
                    "provide requires a quoted feature-name"
                });
            }
            return prim_syntax.syntaxError(obj, aobj);
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda2(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(1, null);
        if (Lit9.match(obj, aobj, 0))
        {
            return GetModuleClass.getModuleClassURI(Compilation.getCurrent());
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda3(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(2, null);
        if (Lit13.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            obj = std_syntax.syntaxObject$To$Datum(Lit14.execute(aobj, ((TemplateScope) (obj))));
            Object obj1 = TemplateScope.make();
            Object obj2 = Lit15.execute(aobj, ((TemplateScope) (obj1)));
            obj1 = new frame();
            obj1.k = obj2;
            try
            {
                obj2 = Path.valueOf(obj);
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "open-input-file", 1, obj);
            }
            obj1.p = ports.openInputFile(((Path) (obj2)));
            obj = ((frame) (obj1)).lambda4f();
            aobj = SyntaxPattern.allocVars(3, aobj);
            if (Lit16.match(obj, aobj, 0))
            {
                obj = TemplateScope.make();
                return Lit17.execute(aobj, ((TemplateScope) (obj)));
            } else
            {
                return syntax_case.error("syntax-case", obj);
            }
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    static Object lambda5(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(2, null);
        if (Lit19.match(obj, aobj, 0))
        {
            obj = TemplateScope.make();
            obj = std_syntax.syntaxObject$To$Datum(Lit20.execute(aobj, ((TemplateScope) (obj))));
            Object obj1;
            Object obj2;
            TemplateScope templatescope;
            try
            {
                obj1 = (PairWithPosition)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "path-pair", -2, obj);
            }
            obj = Path.valueOf(((PairWithPosition) (obj1)).getFileName());
            obj1 = ((PairWithPosition) (obj1)).getCar().toString();
            obj2 = TemplateScope.make();
            obj2 = std_syntax.datum$To$SyntaxObject(Lit21.execute(aobj, ((TemplateScope) (obj2))), Lit12);
            templatescope = TemplateScope.make();
            return LList.list2(obj2, std_syntax.datum$To$SyntaxObject(Lit22.execute(aobj, templatescope), ((Path) (obj)).resolve(((String) (obj1))).toString()));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
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

        case 3: // '\003'
            return lambda3(obj);

        case 4: // '\004'
            return lambda5(obj);
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
        Lit31 = (SimpleSymbol)(new SimpleSymbol("%test-begin")).readResolve();
        Lit30 = (SimpleSymbol)(new SimpleSymbol("quote")).readResolve();
        Lit29 = (SimpleSymbol)(new SimpleSymbol("require")).readResolve();
        Lit28 = (SimpleSymbol)(new SimpleSymbol("else")).readResolve();
        Lit27 = (SimpleSymbol)(new SimpleSymbol("cond-expand")).readResolve();
        Lit26 = (SimpleSymbol)(new SimpleSymbol("srfi-64")).readResolve();
        Lit25 = (SimpleSymbol)(new SimpleSymbol("begin")).readResolve();
        Lit24 = (SimpleSymbol)(new SimpleSymbol("quasiquote")).readResolve();
        Lit23 = (SimpleSymbol)(new SimpleSymbol("$lookup$")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("include-relative")).readResolve();
        Lit17 = new SyntaxTemplate("\001\001\003", "\021\030\004\b\025\023", new Object[] {
            Lit25
        }, 1);
        Lit12 = (SimpleSymbol)(new SimpleSymbol("include")).readResolve();
        Object obj = (SimpleSymbol)(new SimpleSymbol("resource-url")).readResolve();
        Lit10 = ((SimpleSymbol) (obj));
        Object obj1 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
        Object obj2 = PairWithPosition.make(Lit23, Pair.make((SimpleSymbol)(new SimpleSymbol("gnu.text.URLPath")).readResolve(), Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)(new SimpleSymbol("valueOf")).readResolve(), LList.Empty)), LList.Empty)), "misc_syntax.scm", 0x26007);
        SimpleSymbol simplesymbol = Lit23;
        SimpleSymbol simplesymbol1 = Lit23;
        SimpleSymbol simplesymbol2 = (SimpleSymbol)(new SimpleSymbol("module-uri")).readResolve();
        Lit8 = simplesymbol2;
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\001", "\021\030\004\b\b\021\030\f\231\b\021\030\fa\b\021\030\f)\021\030\024\b\003\030\034\030$\030,", new Object[] {
            obj2, simplesymbol, PairWithPosition.make(simplesymbol1, Pair.make(PairWithPosition.make(simplesymbol2, LList.Empty, "misc_syntax.scm", 0x2700b), Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)(new SimpleSymbol("resolve")).readResolve(), LList.Empty)), LList.Empty)), "misc_syntax.scm", 0x2700b), Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)(new SimpleSymbol("toURL")).readResolve(), LList.Empty)), LList.Empty), Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)(new SimpleSymbol("openConnection")).readResolve(), LList.Empty)), LList.Empty), Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)(new SimpleSymbol("getURL")).readResolve(), LList.Empty)), LList.Empty)
        }, 0);
        Lit11 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        obj = (SimpleSymbol)(new SimpleSymbol("test-begin")).readResolve();
        Lit6 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\b", new Object[0], 1), "\001", "\021\030\004\021\030\f\b\021\030\024\t\003\030\034", new Object[] {
            Lit25, PairWithPosition.make(Lit27, PairWithPosition.make(PairWithPosition.make(Lit26, PairWithPosition.make(Values.empty, LList.Empty, "misc_syntax.scm", 0x1501e), "misc_syntax.scm", 0x15015), PairWithPosition.make(PairWithPosition.make(Lit28, PairWithPosition.make(PairWithPosition.make(Lit29, PairWithPosition.make(PairWithPosition.make(Lit30, PairWithPosition.make(Lit26, LList.Empty, "misc_syntax.scm", 0x15036), "misc_syntax.scm", 0x15036), LList.Empty, "misc_syntax.scm", 0x15035), "misc_syntax.scm", 0x1502c), LList.Empty, "misc_syntax.scm", 0x1502c), "misc_syntax.scm", 0x15026), LList.Empty, "misc_syntax.scm", 0x15026), "misc_syntax.scm", 0x15015), "misc_syntax.scm", 0x15008), Lit31, PairWithPosition.make(Boolean.FALSE, LList.Empty, "misc_syntax.scm", 0x16020)
        }, 0);
        obj2 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\021\030\f\b\021\030\024\t\003\b\013", new Object[] {
            Lit25, PairWithPosition.make(Lit27, PairWithPosition.make(PairWithPosition.make(Lit26, PairWithPosition.make(Values.empty, LList.Empty, "misc_syntax.scm", 0x1901e), "misc_syntax.scm", 0x19015), PairWithPosition.make(PairWithPosition.make(Lit28, PairWithPosition.make(PairWithPosition.make(Lit29, PairWithPosition.make(PairWithPosition.make(Lit30, PairWithPosition.make(Lit26, LList.Empty, "misc_syntax.scm", 0x19036), "misc_syntax.scm", 0x19036), LList.Empty, "misc_syntax.scm", 0x19035), "misc_syntax.scm", 0x1902c), LList.Empty, "misc_syntax.scm", 0x1902c), "misc_syntax.scm", 0x19026), LList.Empty, "misc_syntax.scm", 0x19026), "misc_syntax.scm", 0x19015), "misc_syntax.scm", 0x19008), Lit31
        }, 0);
        Lit7 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1, obj2
        }, 2);
        Lit4 = new SyntaxTemplate("\001\001\001", "\030\004", new Object[] {
            PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("::")).readResolve(), PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("<int>")).readResolve(), PairWithPosition.make(IntNum.make(123), LList.Empty, "misc_syntax.scm", 53270), "misc_syntax.scm", 53264), "misc_syntax.scm", 53260)
        }, 0);
        Lit0 = (SimpleSymbol)(new SimpleSymbol("provide")).readResolve();
        $instance = new misc_syntax();
        obj1 = Lit0;
        obj = $instance;
        provide = Macro.make(obj1, new ModuleMethod(((ModuleBody) (obj)), 1, null, 4097), $instance);
        test$Mnbegin = Macro.make(Lit6, Lit7, $instance);
        obj1 = Lit8;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 2, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "misc_syntax.scm:29");
        module$Mnuri = Macro.make(obj1, ((gnu.mapping.Procedure) (obj2)), $instance);
        resource$Mnurl = Macro.make(Lit10, Lit11, $instance);
        obj1 = Lit12;
        obj2 = new ModuleMethod(((ModuleBody) (obj)), 3, null, 4097);
        ((PropertySet) (obj2)).setProperty("source-location", "misc_syntax.scm:54");
        include = Macro.make(obj1, ((gnu.mapping.Procedure) (obj2)), $instance);
        include$Mnrelative = Macro.make(Lit18, new ModuleMethod(((ModuleBody) (obj)), 4, null, 4097), $instance);
        $instance.run();
    }
}
