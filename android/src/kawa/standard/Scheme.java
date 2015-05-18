// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.Map;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.Not;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.functions.NumberPredicate;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.kawa.lispexpr.ReaderDispatchMisc;
import gnu.kawa.lispexpr.ReaderParens;
import gnu.kawa.lispexpr.ReaderQuote;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.servlet.HttpRequestContext;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.AbstractFormat;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Unit;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import kawa.lang.Eval;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            expt

public class Scheme extends LispLanguage
{

    public static final Apply apply;
    static final Declaration applyFieldDecl;
    public static final ApplyToArgs applyToArgs;
    public static LangPrimType booleanType;
    public static final AbstractFormat displayFormat;
    public static final Map forEach;
    public static final Scheme instance;
    public static final InstanceOf instanceOf;
    public static final IsEq isEq;
    public static final IsEqual isEqual;
    public static final IsEqv isEqv;
    public static final NumberPredicate isEven;
    public static final NumberPredicate isOdd;
    protected static final SimpleEnvironment kawaEnvironment;
    public static final Map map;
    public static final Not not;
    public static final Environment nullEnvironment;
    public static final NumberCompare numEqu;
    public static final NumberCompare numGEq;
    public static final NumberCompare numGrt;
    public static final NumberCompare numLEq;
    public static final NumberCompare numLss;
    public static final Environment r4Environment;
    public static final Environment r5Environment;
    static HashMap typeToStringMap;
    static HashMap types;
    public static final Namespace unitNamespace;
    public static final AbstractFormat writeFormat;

    public Scheme()
    {
        environ = kawaEnvironment;
        userEnv = getNewEnvironment();
    }

    protected Scheme(Environment environment)
    {
        environ = environment;
    }

    public static Environment builtin()
    {
        return kawaEnvironment;
    }

    public static Object eval(InPort inport, Environment environment)
    {
        SourceMessages sourcemessages = new SourceMessages();
        try
        {
            inport = ((InPort) (ReaderParens.readList((LispReader)Language.getDefaultLanguage().getLexer(inport, sourcemessages), 0, 1, -1)));
            if (sourcemessages.seenErrors())
            {
                throw new SyntaxException(sourcemessages);
            }
        }
        // Misplaced declaration of an exception variable
        catch (InPort inport)
        {
            throw new RuntimeException((new StringBuilder()).append("eval: errors while compiling:\n").append(inport.getMessages().toString(20)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (InPort inport)
        {
            throw new RuntimeException((new StringBuilder()).append("eval: I/O exception: ").append(inport.toString()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (InPort inport)
        {
            throw inport;
        }
        // Misplaced declaration of an exception variable
        catch (InPort inport)
        {
            throw inport;
        }
        // Misplaced declaration of an exception variable
        catch (InPort inport)
        {
            throw new WrappedException(inport);
        }
        inport = ((InPort) (Eval.evalBody(inport, environment, sourcemessages)));
        return inport;
    }

    public static Object eval(Object obj, Environment environment)
    {
        try
        {
            obj = Eval.eval(obj, environment);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrappedException(((Throwable) (obj)));
        }
        return obj;
    }

    public static Object eval(String s, Environment environment)
    {
        return eval(((InPort) (new CharArrayInPort(s))), environment);
    }

    public static Type exp2Type(Expression expression)
    {
        return getInstance().getTypeFor(expression);
    }

    public static Scheme getInstance()
    {
        return instance;
    }

    public static Type getNamedType(String s)
    {
        Object obj;
label0:
        {
            getTypeMap();
            Object obj1 = (Type)types.get(s);
            obj = obj1;
            if (obj1 != null)
            {
                break label0;
            }
            if (!s.startsWith("elisp:"))
            {
                obj = obj1;
                if (!s.startsWith("clisp:"))
                {
                    break label0;
                }
            }
            int i = s.indexOf(':');
            obj = getNamedType(s.substring(i + 1)).getReflectClass();
            obj1 = s.substring(0, i);
            Language language = Language.getInstance(((String) (obj1)));
            if (language == null)
            {
                throw new RuntimeException((new StringBuilder()).append("unknown type '").append(s).append("' - unknown language '").append(((String) (obj1))).append('\'').toString());
            }
            obj1 = language.getTypeFor(((Class) (obj)));
            obj = obj1;
            if (obj1 != null)
            {
                types.put(s, obj1);
                obj = obj1;
            }
        }
        return ((Type) (obj));
    }

    static HashMap getTypeMap()
    {
        kawa/standard/Scheme;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        if (types == null)
        {
            booleanType = new LangPrimType(Type.booleanType, getInstance());
            types = new HashMap();
            types.put("void", LangPrimType.voidType);
            types.put("int", LangPrimType.intType);
            types.put("char", LangPrimType.charType);
            types.put("boolean", booleanType);
            types.put("byte", LangPrimType.byteType);
            types.put("short", LangPrimType.shortType);
            types.put("long", LangPrimType.longType);
            types.put("float", LangPrimType.floatType);
            types.put("double", LangPrimType.doubleType);
            types.put("never-returns", Type.neverReturnsType);
            types.put("Object", Type.objectType);
            types.put("String", Type.toStringType);
            types.put("object", Type.objectType);
            types.put("number", LangObjType.numericType);
            types.put("quantity", ClassType.make("gnu.math.Quantity"));
            types.put("complex", ClassType.make("gnu.math.Complex"));
            types.put("real", LangObjType.realType);
            types.put("rational", LangObjType.rationalType);
            types.put("integer", LangObjType.integerType);
            types.put("symbol", ClassType.make("gnu.mapping.Symbol"));
            types.put("namespace", ClassType.make("gnu.mapping.Namespace"));
            types.put("keyword", ClassType.make("gnu.expr.Keyword"));
            types.put("pair", ClassType.make("gnu.lists.Pair"));
            types.put("pair-with-position", ClassType.make("gnu.lists.PairWithPosition"));
            types.put("constant-string", ClassType.make("java.lang.String"));
            types.put("abstract-string", ClassType.make("gnu.lists.CharSeq"));
            types.put("character", ClassType.make("gnu.text.Char"));
            types.put("vector", LangObjType.vectorType);
            types.put("string", LangObjType.stringType);
            types.put("list", LangObjType.listType);
            types.put("function", ClassType.make("gnu.mapping.Procedure"));
            types.put("procedure", ClassType.make("gnu.mapping.Procedure"));
            types.put("input-port", ClassType.make("gnu.mapping.InPort"));
            types.put("output-port", ClassType.make("gnu.mapping.OutPort"));
            types.put("string-output-port", ClassType.make("gnu.mapping.CharArrayOutPort"));
            types.put("record", ClassType.make("kawa.lang.Record"));
            types.put("type", LangObjType.typeType);
            types.put("class-type", LangObjType.typeClassType);
            types.put("class", LangObjType.typeClass);
            types.put("s8vector", ClassType.make("gnu.lists.S8Vector"));
            types.put("u8vector", ClassType.make("gnu.lists.U8Vector"));
            types.put("s16vector", ClassType.make("gnu.lists.S16Vector"));
            types.put("u16vector", ClassType.make("gnu.lists.U16Vector"));
            types.put("s32vector", ClassType.make("gnu.lists.S32Vector"));
            types.put("u32vector", ClassType.make("gnu.lists.U32Vector"));
            types.put("s64vector", ClassType.make("gnu.lists.S64Vector"));
            types.put("u64vector", ClassType.make("gnu.lists.U64Vector"));
            types.put("f32vector", ClassType.make("gnu.lists.F32Vector"));
            types.put("f64vector", ClassType.make("gnu.lists.F64Vector"));
            types.put("document", ClassType.make("gnu.kawa.xml.KDocument"));
            types.put("readtable", ClassType.make("gnu.kawa.lispexpr.ReadTable"));
        }
        hashmap = types;
        kawa/standard/Scheme;
        JVM INSTR monitorexit ;
        return hashmap;
        Exception exception;
        exception;
        throw exception;
    }

    public static Type getTypeValue(Expression expression)
    {
        return getInstance().getTypeFor(expression);
    }

    private void initScheme()
    {
        environ = nullEnvironment;
        environ.addLocation(LispLanguage.lookup_sym, null, getNamedPartLocation);
        defSntxStFld("lambda", "kawa.standard.SchemeCompilation", "lambda");
        defSntxStFld("quote", "kawa.lang.Quote", "plainQuote");
        defSntxStFld("%define", "kawa.standard.define", "defineRaw");
        defSntxStFld("define", "kawa.lib.prim_syntax");
        defSntxStFld("if", "kawa.lib.prim_syntax");
        defSntxStFld("set!", "kawa.standard.set_b", "set");
        defSntxStFld("cond", "kawa.lib.std_syntax");
        defSntxStFld("case", "kawa.lib.std_syntax");
        defSntxStFld("and", "kawa.lib.std_syntax");
        defSntxStFld("or", "kawa.lib.std_syntax");
        defSntxStFld("%let", "kawa.standard.let", "let");
        defSntxStFld("let", "kawa.lib.std_syntax");
        defSntxStFld("let*", "kawa.lib.std_syntax");
        defSntxStFld("letrec", "kawa.lib.prim_syntax");
        defSntxStFld("begin", "kawa.standard.begin", "begin");
        defSntxStFld("do", "kawa.lib.std_syntax");
        defSntxStFld("delay", "kawa.lib.std_syntax");
        defProcStFld("%make-promise", "kawa.lib.std_syntax");
        defSntxStFld("quasiquote", "kawa.lang.Quote", "quasiQuote");
        defSntxStFld("define-syntax", "kawa.lib.prim_syntax");
        defSntxStFld("let-syntax", "kawa.standard.let_syntax", "let_syntax");
        defSntxStFld("letrec-syntax", "kawa.standard.let_syntax", "letrec_syntax");
        defSntxStFld("syntax-rules", "kawa.standard.syntax_rules", "syntax_rules");
        nullEnvironment.setLocked();
        environ = r4Environment;
        defProcStFld("not", "kawa.standard.Scheme");
        defProcStFld("boolean?", "kawa.lib.misc");
        defProcStFld("eq?", "kawa.standard.Scheme", "isEq");
        defProcStFld("eqv?", "kawa.standard.Scheme", "isEqv");
        defProcStFld("equal?", "kawa.standard.Scheme", "isEqual");
        defProcStFld("pair?", "kawa.lib.lists");
        defProcStFld("cons", "kawa.lib.lists");
        defProcStFld("car", "kawa.lib.lists");
        defProcStFld("cdr", "kawa.lib.lists");
        defProcStFld("set-car!", "kawa.lib.lists");
        defProcStFld("set-cdr!", "kawa.lib.lists");
        defProcStFld("caar", "kawa.lib.lists");
        defProcStFld("cadr", "kawa.lib.lists");
        defProcStFld("cdar", "kawa.lib.lists");
        defProcStFld("cddr", "kawa.lib.lists");
        defProcStFld("caaar", "kawa.lib.lists");
        defProcStFld("caadr", "kawa.lib.lists");
        defProcStFld("cadar", "kawa.lib.lists");
        defProcStFld("caddr", "kawa.lib.lists");
        defProcStFld("cdaar", "kawa.lib.lists");
        defProcStFld("cdadr", "kawa.lib.lists");
        defProcStFld("cddar", "kawa.lib.lists");
        defProcStFld("cdddr", "kawa.lib.lists");
        defProcStFld("caaaar", "kawa.lib.lists");
        defProcStFld("caaadr", "kawa.lib.lists");
        defProcStFld("caadar", "kawa.lib.lists");
        defProcStFld("caaddr", "kawa.lib.lists");
        defProcStFld("cadaar", "kawa.lib.lists");
        defProcStFld("cadadr", "kawa.lib.lists");
        defProcStFld("caddar", "kawa.lib.lists");
        defProcStFld("cadddr", "kawa.lib.lists");
        defProcStFld("cdaaar", "kawa.lib.lists");
        defProcStFld("cdaadr", "kawa.lib.lists");
        defProcStFld("cdadar", "kawa.lib.lists");
        defProcStFld("cdaddr", "kawa.lib.lists");
        defProcStFld("cddaar", "kawa.lib.lists");
        defProcStFld("cddadr", "kawa.lib.lists");
        defProcStFld("cdddar", "kawa.lib.lists");
        defProcStFld("cddddr", "kawa.lib.lists");
        defProcStFld("null?", "kawa.lib.lists");
        defProcStFld("list?", "kawa.lib.lists");
        defProcStFld("length", "kawa.lib.lists");
        defProcStFld("append", "kawa.standard.append", "append");
        defProcStFld("reverse", "kawa.lib.lists");
        defProcStFld("reverse!", "kawa.lib.lists");
        defProcStFld("list-tail", "kawa.lib.lists");
        defProcStFld("list-ref", "kawa.lib.lists");
        defProcStFld("memq", "kawa.lib.lists");
        defProcStFld("memv", "kawa.lib.lists");
        defProcStFld("member", "kawa.lib.lists");
        defProcStFld("assq", "kawa.lib.lists");
        defProcStFld("assv", "kawa.lib.lists");
        defProcStFld("assoc", "kawa.lib.lists");
        defProcStFld("symbol?", "kawa.lib.misc");
        defProcStFld("symbol->string", "kawa.lib.misc");
        defProcStFld("string->symbol", "kawa.lib.misc");
        defProcStFld("symbol=?", "kawa.lib.misc");
        defProcStFld("symbol-local-name", "kawa.lib.misc");
        defProcStFld("symbol-namespace", "kawa.lib.misc");
        defProcStFld("symbol-namespace-uri", "kawa.lib.misc");
        defProcStFld("symbol-prefix", "kawa.lib.misc");
        defProcStFld("namespace-uri", "kawa.lib.misc");
        defProcStFld("namespace-prefix", "kawa.lib.misc");
        defProcStFld("number?", "kawa.lib.numbers");
        defProcStFld("quantity?", "kawa.lib.numbers");
        defProcStFld("complex?", "kawa.lib.numbers");
        defProcStFld("real?", "kawa.lib.numbers");
        defProcStFld("rational?", "kawa.lib.numbers");
        defProcStFld("integer?", "kawa.lib.numbers");
        defProcStFld("exact?", "kawa.lib.numbers");
        defProcStFld("inexact?", "kawa.lib.numbers");
        defProcStFld("=", "kawa.standard.Scheme", "numEqu");
        defProcStFld("<", "kawa.standard.Scheme", "numLss");
        defProcStFld(">", "kawa.standard.Scheme", "numGrt");
        defProcStFld("<=", "kawa.standard.Scheme", "numLEq");
        defProcStFld(">=", "kawa.standard.Scheme", "numGEq");
        defProcStFld("zero?", "kawa.lib.numbers");
        defProcStFld("positive?", "kawa.lib.numbers");
        defProcStFld("negative?", "kawa.lib.numbers");
        defProcStFld("odd?", "kawa.standard.Scheme", "isOdd");
        defProcStFld("even?", "kawa.standard.Scheme", "isEven");
        defProcStFld("max", "kawa.lib.numbers");
        defProcStFld("min", "kawa.lib.numbers");
        defProcStFld("+", "gnu.kawa.functions.AddOp", "$Pl");
        defProcStFld("-", "gnu.kawa.functions.AddOp", "$Mn");
        defProcStFld("*", "gnu.kawa.functions.MultiplyOp", "$St");
        defProcStFld("/", "gnu.kawa.functions.DivideOp", "$Sl");
        defProcStFld("abs", "kawa.lib.numbers");
        defProcStFld("quotient", "gnu.kawa.functions.DivideOp", "quotient");
        defProcStFld("remainder", "gnu.kawa.functions.DivideOp", "remainder");
        defProcStFld("modulo", "gnu.kawa.functions.DivideOp", "modulo");
        defProcStFld("div", "gnu.kawa.functions.DivideOp", "div");
        defProcStFld("mod", "gnu.kawa.functions.DivideOp", "mod");
        defProcStFld("div0", "gnu.kawa.functions.DivideOp", "div0");
        defProcStFld("mod0", "gnu.kawa.functions.DivideOp", "mod0");
        defProcStFld("div-and-mod", "kawa.lib.numbers");
        defProcStFld("div0-and-mod0", "kawa.lib.numbers");
        defProcStFld("gcd", "kawa.lib.numbers");
        defProcStFld("lcm", "kawa.lib.numbers");
        defProcStFld("numerator", "kawa.lib.numbers");
        defProcStFld("denominator", "kawa.lib.numbers");
        defProcStFld("floor", "kawa.lib.numbers");
        defProcStFld("ceiling", "kawa.lib.numbers");
        defProcStFld("truncate", "kawa.lib.numbers");
        defProcStFld("round", "kawa.lib.numbers");
        defProcStFld("rationalize", "kawa.lib.numbers");
        defProcStFld("exp", "kawa.lib.numbers");
        defProcStFld("log", "kawa.lib.numbers");
        defProcStFld("sin", "kawa.lib.numbers");
        defProcStFld("cos", "kawa.lib.numbers");
        defProcStFld("tan", "kawa.lib.numbers");
        defProcStFld("asin", "kawa.lib.numbers");
        defProcStFld("acos", "kawa.lib.numbers");
        defProcStFld("atan", "kawa.lib.numbers");
        defProcStFld("sqrt", "kawa.lib.numbers");
        defProcStFld("expt", "kawa.standard.expt");
        defProcStFld("make-rectangular", "kawa.lib.numbers");
        defProcStFld("make-polar", "kawa.lib.numbers");
        defProcStFld("real-part", "kawa.lib.numbers");
        defProcStFld("imag-part", "kawa.lib.numbers");
        defProcStFld("magnitude", "kawa.lib.numbers");
        defProcStFld("angle", "kawa.lib.numbers");
        defProcStFld("inexact", "kawa.lib.numbers");
        defProcStFld("exact", "kawa.lib.numbers");
        defProcStFld("exact->inexact", "kawa.lib.numbers");
        defProcStFld("inexact->exact", "kawa.lib.numbers");
        defProcStFld("number->string", "kawa.lib.numbers");
        defProcStFld("string->number", "kawa.lib.numbers");
        defProcStFld("char?", "kawa.lib.characters");
        defProcStFld("char=?", "kawa.lib.characters");
        defProcStFld("char<?", "kawa.lib.characters");
        defProcStFld("char>?", "kawa.lib.characters");
        defProcStFld("char<=?", "kawa.lib.characters");
        defProcStFld("char>=?", "kawa.lib.characters");
        defProcStFld("char-ci=?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-ci<?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-ci>?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-ci<=?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-ci>=?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-alphabetic?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-numeric?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-whitespace?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-upper-case?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-lower-case?", "kawa.lib.rnrs.unicode");
        defProcStFld("char-title-case?", "kawa.lib.rnrs.unicode");
        defProcStFld("char->integer", "kawa.lib.characters");
        defProcStFld("integer->char", "kawa.lib.characters");
        defProcStFld("char-upcase", "kawa.lib.rnrs.unicode");
        defProcStFld("char-downcase", "kawa.lib.rnrs.unicode");
        defProcStFld("char-titlecase", "kawa.lib.rnrs.unicode");
        defProcStFld("char-foldcase", "kawa.lib.rnrs.unicode");
        defProcStFld("char-general-category", "kawa.lib.rnrs.unicode");
        defProcStFld("string?", "kawa.lib.strings");
        defProcStFld("make-string", "kawa.lib.strings");
        defProcStFld("string-length", "kawa.lib.strings");
        defProcStFld("string-ref", "kawa.lib.strings");
        defProcStFld("string-set!", "kawa.lib.strings");
        defProcStFld("string=?", "kawa.lib.strings");
        defProcStFld("string<?", "kawa.lib.strings");
        defProcStFld("string>?", "kawa.lib.strings");
        defProcStFld("string<=?", "kawa.lib.strings");
        defProcStFld("string>=?", "kawa.lib.strings");
        defProcStFld("string-ci=?", "kawa.lib.rnrs.unicode");
        defProcStFld("string-ci<?", "kawa.lib.rnrs.unicode");
        defProcStFld("string-ci>?", "kawa.lib.rnrs.unicode");
        defProcStFld("string-ci<=?", "kawa.lib.rnrs.unicode");
        defProcStFld("string-ci>=?", "kawa.lib.rnrs.unicode");
        defProcStFld("string-normalize-nfd", "kawa.lib.rnrs.unicode");
        defProcStFld("string-normalize-nfkd", "kawa.lib.rnrs.unicode");
        defProcStFld("string-normalize-nfc", "kawa.lib.rnrs.unicode");
        defProcStFld("string-normalize-nfkc", "kawa.lib.rnrs.unicode");
        defProcStFld("substring", "kawa.lib.strings");
        defProcStFld("string-append", "kawa.lib.strings");
        defProcStFld("string-append/shared", "kawa.lib.strings");
        defProcStFld("string->list", "kawa.lib.strings");
        defProcStFld("list->string", "kawa.lib.strings");
        defProcStFld("string-copy", "kawa.lib.strings");
        defProcStFld("string-fill!", "kawa.lib.strings");
        defProcStFld("vector?", "kawa.lib.vectors");
        defProcStFld("make-vector", "kawa.lib.vectors");
        defProcStFld("vector-length", "kawa.lib.vectors");
        defProcStFld("vector-ref", "kawa.lib.vectors");
        defProcStFld("vector-set!", "kawa.lib.vectors");
        defProcStFld("list->vector", "kawa.lib.vectors");
        defProcStFld("vector->list", "kawa.lib.vectors");
        defProcStFld("vector-fill!", "kawa.lib.vectors");
        defProcStFld("vector-append", "kawa.standard.vector_append", "vectorAppend");
        defProcStFld("values-append", "gnu.kawa.functions.AppendValues", "appendValues");
        defProcStFld("procedure?", "kawa.lib.misc");
        defProcStFld("apply", "kawa.standard.Scheme", "apply");
        defProcStFld("map", "kawa.standard.Scheme", "map");
        defProcStFld("for-each", "kawa.standard.Scheme", "forEach");
        defProcStFld("call-with-current-continuation", "gnu.kawa.functions.CallCC", "callcc");
        defProcStFld("call/cc", "kawa.standard.callcc", "callcc");
        defProcStFld("force", "kawa.lib.misc");
        defProcStFld("call-with-input-file", "kawa.lib.ports");
        defProcStFld("call-with-output-file", "kawa.lib.ports");
        defProcStFld("input-port?", "kawa.lib.ports");
        defProcStFld("output-port?", "kawa.lib.ports");
        defProcStFld("current-input-port", "kawa.lib.ports");
        defProcStFld("current-output-port", "kawa.lib.ports");
        defProcStFld("with-input-from-file", "kawa.lib.ports");
        defProcStFld("with-output-to-file", "kawa.lib.ports");
        defProcStFld("open-input-file", "kawa.lib.ports");
        defProcStFld("open-output-file", "kawa.lib.ports");
        defProcStFld("close-input-port", "kawa.lib.ports");
        defProcStFld("close-output-port", "kawa.lib.ports");
        defProcStFld("read", "kawa.lib.ports");
        defProcStFld("read-line", "kawa.lib.ports");
        defProcStFld("read-char", "kawa.standard.readchar", "readChar");
        defProcStFld("peek-char", "kawa.standard.readchar", "peekChar");
        defProcStFld("eof-object?", "kawa.lib.ports");
        defProcStFld("char-ready?", "kawa.lib.ports");
        defProcStFld("write", "kawa.lib.ports");
        defProcStFld("display", "kawa.lib.ports");
        defProcStFld("print-as-xml", "gnu.xquery.lang.XQuery", "writeFormat");
        defProcStFld("write-char", "kawa.lib.ports");
        defProcStFld("newline", "kawa.lib.ports");
        defProcStFld("load", "kawa.standard.load", "load");
        defProcStFld("load-relative", "kawa.standard.load", "loadRelative");
        defProcStFld("transcript-off", "kawa.lib.ports");
        defProcStFld("transcript-on", "kawa.lib.ports");
        defProcStFld("call-with-input-string", "kawa.lib.ports");
        defProcStFld("open-input-string", "kawa.lib.ports");
        defProcStFld("open-output-string", "kawa.lib.ports");
        defProcStFld("get-output-string", "kawa.lib.ports");
        defProcStFld("call-with-output-string", "kawa.lib.ports");
        defProcStFld("force-output", "kawa.lib.ports");
        defProcStFld("port-line", "kawa.lib.ports");
        defProcStFld("set-port-line!", "kawa.lib.ports");
        defProcStFld("port-column", "kawa.lib.ports");
        defProcStFld("current-error-port", "kawa.lib.ports");
        defProcStFld("input-port-line-number", "kawa.lib.ports");
        defProcStFld("set-input-port-line-number!", "kawa.lib.ports");
        defProcStFld("input-port-column-number", "kawa.lib.ports");
        defProcStFld("input-port-read-state", "kawa.lib.ports");
        defProcStFld("default-prompter", "kawa.lib.ports");
        defProcStFld("input-port-prompter", "kawa.lib.ports");
        defProcStFld("set-input-port-prompter!", "kawa.lib.ports");
        defProcStFld("base-uri", "kawa.lib.misc");
        defProcStFld("%syntax-error", "kawa.standard.syntax_error", "syntax_error");
        defProcStFld("syntax-error", "kawa.lib.prim_syntax");
        r4Environment.setLocked();
        environ = r5Environment;
        defProcStFld("values", "kawa.lib.misc");
        defProcStFld("call-with-values", "kawa.standard.call_with_values", "callWithValues");
        defSntxStFld("let-values", "kawa.lib.syntax");
        defSntxStFld("let*-values", "kawa.lib.syntax");
        defSntxStFld("case-lambda", "kawa.lib.syntax");
        defSntxStFld("receive", "kawa.lib.syntax");
        defProcStFld("eval", "kawa.lang.Eval");
        defProcStFld("repl", "kawa.standard.SchemeCompilation", "repl");
        defProcStFld("scheme-report-environment", "kawa.lib.misc");
        defProcStFld("null-environment", "kawa.lib.misc");
        defProcStFld("interaction-environment", "kawa.lib.misc");
        defProcStFld("dynamic-wind", "kawa.lib.misc");
        r5Environment.setLocked();
        environ = kawaEnvironment;
        defSntxStFld("define-private", "kawa.lib.prim_syntax");
        defSntxStFld("define-constant", "kawa.lib.prim_syntax");
        defSntxStFld("define-autoload", "kawa.standard.define_autoload", "define_autoload");
        defSntxStFld("define-autoloads-from-file", "kawa.standard.define_autoload", "define_autoloads_from_file");
        defProcStFld("exit", "kawa.lib.rnrs.programs");
        defProcStFld("command-line", "kawa.lib.rnrs.programs");
        defProcStFld("bitwise-arithmetic-shift", "gnu.kawa.functions.BitwiseOp", "ashift");
        defProcStFld("arithmetic-shift", "gnu.kawa.functions.BitwiseOp", "ashift");
        defProcStFld("ash", "gnu.kawa.functions.BitwiseOp", "ashift");
        defProcStFld("bitwise-arithmetic-shift-left", "gnu.kawa.functions.BitwiseOp", "ashiftl");
        defProcStFld("bitwise-arithmetic-shift-right", "gnu.kawa.functions.BitwiseOp", "ashiftr");
        defProcStFld("bitwise-and", "gnu.kawa.functions.BitwiseOp", "and");
        defProcStFld("logand", "gnu.kawa.functions.BitwiseOp", "and");
        defProcStFld("bitwise-ior", "gnu.kawa.functions.BitwiseOp", "ior");
        defProcStFld("logior", "gnu.kawa.functions.BitwiseOp", "ior");
        defProcStFld("bitwise-xor", "gnu.kawa.functions.BitwiseOp", "xor");
        defProcStFld("logxor", "gnu.kawa.functions.BitwiseOp", "xor");
        defProcStFld("bitwise-if", "kawa.lib.numbers");
        defProcStFld("bitwise-not", "gnu.kawa.functions.BitwiseOp", "not");
        defProcStFld("lognot", "gnu.kawa.functions.BitwiseOp", "not");
        defProcStFld("logop", "kawa.lib.numbers");
        defProcStFld("bitwise-bit-set?", "kawa.lib.numbers");
        defProcStFld("logbit?", "kawa.lib.numbers", Compilation.mangleNameIfNeeded("bitwise-bit-set?"));
        defProcStFld("logtest", "kawa.lib.numbers");
        defProcStFld("bitwise-bit-count", "kawa.lib.numbers");
        defProcStFld("logcount", "kawa.lib.numbers");
        defProcStFld("bitwise-copy-bit", "kawa.lib.numbers");
        defProcStFld("bitwise-copy-bit-field", "kawa.lib.numbers");
        defProcStFld("bitwise-bit-field", "kawa.lib.numbers");
        defProcStFld("bit-extract", "kawa.lib.numbers", Compilation.mangleNameIfNeeded("bitwise-bit-field"));
        defProcStFld("bitwise-length", "kawa.lib.numbers");
        defProcStFld("integer-length", "kawa.lib.numbers", "bitwise$Mnlength");
        defProcStFld("bitwise-first-bit-set", "kawa.lib.numbers");
        defProcStFld("bitwise-rotate-bit-field", "kawa.lib.numbers");
        defProcStFld("bitwise-reverse-bit-field", "kawa.lib.numbers");
        defProcStFld("string-upcase!", "kawa.lib.strings");
        defProcStFld("string-downcase!", "kawa.lib.strings");
        defProcStFld("string-capitalize!", "kawa.lib.strings");
        defProcStFld("string-upcase", "kawa.lib.rnrs.unicode");
        defProcStFld("string-downcase", "kawa.lib.rnrs.unicode");
        defProcStFld("string-titlecase", "kawa.lib.rnrs.unicode");
        defProcStFld("string-foldcase", "kawa.lib.rnrs.unicode");
        defProcStFld("string-capitalize", "kawa.lib.strings");
        defSntxStFld("primitive-virtual-method", "kawa.standard.prim_method", "virtual_method");
        defSntxStFld("primitive-static-method", "kawa.standard.prim_method", "static_method");
        defSntxStFld("primitive-interface-method", "kawa.standard.prim_method", "interface_method");
        defSntxStFld("primitive-constructor", "kawa.lib.reflection");
        defSntxStFld("primitive-op1", "kawa.standard.prim_method", "op1");
        defSntxStFld("primitive-get-field", "kawa.lib.reflection");
        defSntxStFld("primitive-set-field", "kawa.lib.reflection");
        defSntxStFld("primitive-get-static", "kawa.lib.reflection");
        defSntxStFld("primitive-set-static", "kawa.lib.reflection");
        defSntxStFld("primitive-array-new", "kawa.lib.reflection");
        defSntxStFld("primitive-array-get", "kawa.lib.reflection");
        defSntxStFld("primitive-array-set", "kawa.lib.reflection");
        defSntxStFld("primitive-array-length", "kawa.lib.reflection");
        defProcStFld("subtype?", "kawa.lib.reflection");
        defProcStFld("primitive-throw", "kawa.standard.prim_throw", "primitiveThrow");
        defSntxStFld("try-finally", "kawa.lib.syntax");
        defSntxStFld("try-catch", "kawa.lib.prim_syntax");
        defProcStFld("throw", "kawa.standard.throw_name", "throwName");
        defProcStFld("catch", "kawa.lib.system");
        defProcStFld("error", "kawa.lib.misc");
        defProcStFld("as", "gnu.kawa.functions.Convert", "as");
        defProcStFld("instance?", "kawa.standard.Scheme", "instanceOf");
        defSntxStFld("synchronized", "kawa.lib.syntax");
        defSntxStFld("object", "kawa.standard.object", "objectSyntax");
        defSntxStFld("define-class", "kawa.standard.define_class", "define_class");
        defSntxStFld("define-simple-class", "kawa.standard.define_class", "define_simple_class");
        defSntxStFld("this", "kawa.standard.thisRef", "thisSyntax");
        defProcStFld("make", "gnu.kawa.reflect.Invoke", "make");
        defProcStFld("slot-ref", "gnu.kawa.reflect.SlotGet", "slotRef");
        defProcStFld("slot-set!", "gnu.kawa.reflect.SlotSet", "set$Mnfield$Ex");
        defProcStFld("field", "gnu.kawa.reflect.SlotGet");
        defProcStFld("class-methods", "gnu.kawa.reflect.ClassMethods", "classMethods");
        defProcStFld("static-field", "gnu.kawa.reflect.SlotGet", "staticField");
        defProcStFld("invoke", "gnu.kawa.reflect.Invoke", "invoke");
        defProcStFld("invoke-static", "gnu.kawa.reflect.Invoke", "invokeStatic");
        defProcStFld("invoke-special", "gnu.kawa.reflect.Invoke", "invokeSpecial");
        defSntxStFld("define-macro", "kawa.lib.syntax");
        defSntxStFld("%define-macro", "kawa.standard.define_syntax", "define_macro");
        defSntxStFld("define-syntax-case", "kawa.lib.syntax");
        defSntxStFld("syntax-case", "kawa.standard.syntax_case", "syntax_case");
        defSntxStFld("%define-syntax", "kawa.standard.define_syntax", "define_syntax");
        defSntxStFld("syntax", "kawa.standard.syntax", "syntax");
        defSntxStFld("quasisyntax", "kawa.standard.syntax", "quasiSyntax");
        defProcStFld("syntax-object->datum", "kawa.lib.std_syntax");
        defProcStFld("datum->syntax-object", "kawa.lib.std_syntax");
        defProcStFld("syntax->expression", "kawa.lib.prim_syntax");
        defProcStFld("syntax-body->expression", "kawa.lib.prim_syntax");
        defProcStFld("generate-temporaries", "kawa.lib.std_syntax");
        defSntxStFld("with-syntax", "kawa.lib.std_syntax");
        defProcStFld("identifier?", "kawa.lib.std_syntax");
        defProcStFld("free-identifier=?", "kawa.lib.std_syntax");
        defProcStFld("syntax-source", "kawa.lib.std_syntax");
        defProcStFld("syntax-line", "kawa.lib.std_syntax");
        defProcStFld("syntax-column", "kawa.lib.std_syntax");
        defSntxStFld("begin-for-syntax", "kawa.lib.std_syntax");
        defSntxStFld("define-for-syntax", "kawa.lib.std_syntax");
        defSntxStFld("include", "kawa.lib.misc_syntax");
        defSntxStFld("include-relative", "kawa.lib.misc_syntax");
        defProcStFld("file-exists?", "kawa.lib.files");
        defProcStFld("file-directory?", "kawa.lib.files");
        defProcStFld("file-readable?", "kawa.lib.files");
        defProcStFld("file-writable?", "kawa.lib.files");
        defProcStFld("delete-file", "kawa.lib.files");
        defProcStFld("system-tmpdir", "kawa.lib.files");
        defProcStFld("make-temporary-file", "kawa.lib.files");
        defProcStFld("rename-file", "kawa.lib.files");
        defProcStFld("copy-file", "kawa.lib.files");
        defProcStFld("create-directory", "kawa.lib.files");
        defProcStFld("->pathname", "kawa.lib.files");
        define("port-char-encoding", Boolean.TRUE);
        define("symbol-read-case", "P");
        defProcStFld("system", "kawa.lib.system");
        defProcStFld("make-process", "kawa.lib.system");
        defProcStFld("tokenize-string-to-string-array", "kawa.lib.system");
        defProcStFld("tokenize-string-using-shell", "kawa.lib.system");
        defProcStFld("command-parse", "kawa.lib.system");
        defProcStFld("process-command-line-assignments", "kawa.lib.system");
        defProcStFld("record-accessor", "kawa.lib.reflection");
        defProcStFld("record-modifier", "kawa.lib.reflection");
        defProcStFld("record-predicate", "kawa.lib.reflection");
        defProcStFld("record-constructor", "kawa.lib.reflection");
        defProcStFld("make-record-type", "kawa.lib.reflection");
        defProcStFld("record-type-descriptor", "kawa.lib.reflection");
        defProcStFld("record-type-name", "kawa.lib.reflection");
        defProcStFld("record-type-field-names", "kawa.lib.reflection");
        defProcStFld("record?", "kawa.lib.reflection");
        defSntxStFld("define-record-type", "gnu.kawa.slib.DefineRecordType");
        defSntxStFld("when", "kawa.lib.syntax");
        defSntxStFld("unless", "kawa.lib.syntax");
        defSntxStFld("fluid-let", "kawa.standard.fluid_let", "fluid_let");
        defSntxStFld("constant-fold", "kawa.standard.constant_fold", "constant_fold");
        defProcStFld("make-parameter", "kawa.lib.parameters");
        defSntxStFld("parameterize", "kawa.lib.parameters");
        defProcStFld("compile-file", "kawa.lib.system");
        defProcStFld("environment-bound?", "kawa.lib.misc");
        defProcStFld("scheme-implementation-version", "kawa.lib.misc");
        defProcStFld("scheme-window", "kawa.lib.windows");
        defSntxStFld("define-procedure", "kawa.lib.std_syntax");
        defProcStFld("add-procedure-properties", "kawa.lib.misc");
        defProcStFld("make-procedure", "gnu.kawa.functions.MakeProcedure", "makeProcedure");
        defProcStFld("procedure-property", "kawa.lib.misc");
        defProcStFld("set-procedure-property!", "kawa.lib.misc");
        defSntxStFld("provide", "kawa.lib.misc_syntax");
        defSntxStFld("test-begin", "kawa.lib.misc_syntax");
        defProcStFld("quantity->number", "kawa.lib.numbers");
        defProcStFld("quantity->unit", "kawa.lib.numbers");
        defProcStFld("make-quantity", "kawa.lib.numbers");
        defSntxStFld("define-namespace", "gnu.kawa.lispexpr.DefineNamespace", "define_namespace");
        defSntxStFld("define-xml-namespace", "gnu.kawa.lispexpr.DefineNamespace", "define_xml_namespace");
        defSntxStFld("define-private-namespace", "gnu.kawa.lispexpr.DefineNamespace", "define_private_namespace");
        defSntxStFld("define-unit", "kawa.standard.define_unit", "define_unit");
        defSntxStFld("define-base-unit", "kawa.standard.define_unit", "define_base_unit");
        defProcStFld("duration", "kawa.lib.numbers");
        defProcStFld("gentemp", "kawa.lib.misc");
        defSntxStFld("defmacro", "kawa.lib.syntax");
        defProcStFld("setter", "gnu.kawa.functions.Setter", "setter");
        defSntxStFld("resource-url", "kawa.lib.misc_syntax");
        defSntxStFld("module-uri", "kawa.lib.misc_syntax");
        defSntxStFld("future", "kawa.lib.thread");
        defProcStFld("sleep", "kawa.lib.thread");
        defProcStFld("runnable", "kawa.lib.thread");
        defSntxStFld("trace", "kawa.lib.trace");
        defSntxStFld("untrace", "kawa.lib.trace");
        defSntxStFld("disassemble", "kawa.lib.trace");
        defProcStFld("format", "gnu.kawa.functions.Format");
        defProcStFld("parse-format", "gnu.kawa.functions.ParseFormat", "parseFormat");
        defProcStFld("make-element", "gnu.kawa.xml.MakeElement", "makeElement");
        defProcStFld("make-attribute", "gnu.kawa.xml.MakeAttribute", "makeAttribute");
        defProcStFld("map-values", "gnu.kawa.functions.ValuesMap", "valuesMap");
        defProcStFld("children", "gnu.kawa.xml.Children", "children");
        defProcStFld("attributes", "gnu.kawa.xml.Attributes");
        defProcStFld("unescaped-data", "gnu.kawa.xml.MakeUnescapedData", "unescapedData");
        defProcStFld("keyword?", "kawa.lib.keywords");
        defProcStFld("keyword->string", "kawa.lib.keywords");
        defProcStFld("string->keyword", "kawa.lib.keywords");
        defSntxStFld("location", "kawa.standard.location", "location");
        defSntxStFld("define-alias", "kawa.standard.define_alias", "define_alias");
        defSntxStFld("define-variable", "kawa.standard.define_variable", "define_variable");
        defSntxStFld("define-member-alias", "kawa.standard.define_member_alias", "define_member_alias");
        defSntxStFld("define-enum", "gnu.kawa.slib.enums");
        defSntxStFld("import", "kawa.lib.syntax");
        defSntxStFld("require", "kawa.standard.require", "require");
        defSntxStFld("module-name", "kawa.standard.module_name", "module_name");
        defSntxStFld("module-extends", "kawa.standard.module_extends", "module_extends");
        defSntxStFld("module-implements", "kawa.standard.module_implements", "module_implements");
        defSntxStFld("module-static", "kawa.standard.module_static", "module_static");
        defSntxStFld("module-export", "kawa.standard.export", "module_export");
        defSntxStFld("export", "kawa.standard.export", "export");
        defSntxStFld("module-compile-options", "kawa.standard.module_compile_options", "module_compile_options");
        defSntxStFld("with-compile-options", "kawa.standard.with_compile_options", "with_compile_options");
        defProcStFld("array?", "kawa.lib.arrays");
        defProcStFld("array-rank", "kawa.lib.arrays");
        defProcStFld("make-array", "kawa.lib.arrays");
        defProcStFld("array", "kawa.lib.arrays");
        defProcStFld("array-start", "kawa.lib.arrays");
        defProcStFld("array-end", "kawa.lib.arrays");
        defProcStFld("shape", "kawa.lib.arrays");
        defProcStFld("array-ref", "gnu.kawa.functions.ArrayRef", "arrayRef");
        defProcStFld("array-set!", "gnu.kawa.functions.ArraySet", "arraySet");
        defProcStFld("share-array", "kawa.lib.arrays");
        defProcStFld("s8vector?", "kawa.lib.uniform");
        defProcStFld("make-s8vector", "kawa.lib.uniform");
        defProcStFld("s8vector", "kawa.lib.uniform");
        defProcStFld("s8vector-length", "kawa.lib.uniform");
        defProcStFld("s8vector-ref", "kawa.lib.uniform");
        defProcStFld("s8vector-set!", "kawa.lib.uniform");
        defProcStFld("s8vector->list", "kawa.lib.uniform");
        defProcStFld("list->s8vector", "kawa.lib.uniform");
        defProcStFld("u8vector?", "kawa.lib.uniform");
        defProcStFld("make-u8vector", "kawa.lib.uniform");
        defProcStFld("u8vector", "kawa.lib.uniform");
        defProcStFld("u8vector-length", "kawa.lib.uniform");
        defProcStFld("u8vector-ref", "kawa.lib.uniform");
        defProcStFld("u8vector-set!", "kawa.lib.uniform");
        defProcStFld("u8vector->list", "kawa.lib.uniform");
        defProcStFld("list->u8vector", "kawa.lib.uniform");
        defProcStFld("s16vector?", "kawa.lib.uniform");
        defProcStFld("make-s16vector", "kawa.lib.uniform");
        defProcStFld("s16vector", "kawa.lib.uniform");
        defProcStFld("s16vector-length", "kawa.lib.uniform");
        defProcStFld("s16vector-ref", "kawa.lib.uniform");
        defProcStFld("s16vector-set!", "kawa.lib.uniform");
        defProcStFld("s16vector->list", "kawa.lib.uniform");
        defProcStFld("list->s16vector", "kawa.lib.uniform");
        defProcStFld("u16vector?", "kawa.lib.uniform");
        defProcStFld("make-u16vector", "kawa.lib.uniform");
        defProcStFld("u16vector", "kawa.lib.uniform");
        defProcStFld("u16vector-length", "kawa.lib.uniform");
        defProcStFld("u16vector-ref", "kawa.lib.uniform");
        defProcStFld("u16vector-set!", "kawa.lib.uniform");
        defProcStFld("u16vector->list", "kawa.lib.uniform");
        defProcStFld("list->u16vector", "kawa.lib.uniform");
        defProcStFld("s32vector?", "kawa.lib.uniform");
        defProcStFld("make-s32vector", "kawa.lib.uniform");
        defProcStFld("s32vector", "kawa.lib.uniform");
        defProcStFld("s32vector-length", "kawa.lib.uniform");
        defProcStFld("s32vector-ref", "kawa.lib.uniform");
        defProcStFld("s32vector-set!", "kawa.lib.uniform");
        defProcStFld("s32vector->list", "kawa.lib.uniform");
        defProcStFld("list->s32vector", "kawa.lib.uniform");
        defProcStFld("u32vector?", "kawa.lib.uniform");
        defProcStFld("make-u32vector", "kawa.lib.uniform");
        defProcStFld("u32vector", "kawa.lib.uniform");
        defProcStFld("u32vector-length", "kawa.lib.uniform");
        defProcStFld("u32vector-ref", "kawa.lib.uniform");
        defProcStFld("u32vector-set!", "kawa.lib.uniform");
        defProcStFld("u32vector->list", "kawa.lib.uniform");
        defProcStFld("list->u32vector", "kawa.lib.uniform");
        defProcStFld("s64vector?", "kawa.lib.uniform");
        defProcStFld("make-s64vector", "kawa.lib.uniform");
        defProcStFld("s64vector", "kawa.lib.uniform");
        defProcStFld("s64vector-length", "kawa.lib.uniform");
        defProcStFld("s64vector-ref", "kawa.lib.uniform");
        defProcStFld("s64vector-set!", "kawa.lib.uniform");
        defProcStFld("s64vector->list", "kawa.lib.uniform");
        defProcStFld("list->s64vector", "kawa.lib.uniform");
        defProcStFld("u64vector?", "kawa.lib.uniform");
        defProcStFld("make-u64vector", "kawa.lib.uniform");
        defProcStFld("u64vector", "kawa.lib.uniform");
        defProcStFld("u64vector-length", "kawa.lib.uniform");
        defProcStFld("u64vector-ref", "kawa.lib.uniform");
        defProcStFld("u64vector-set!", "kawa.lib.uniform");
        defProcStFld("u64vector->list", "kawa.lib.uniform");
        defProcStFld("list->u64vector", "kawa.lib.uniform");
        defProcStFld("f32vector?", "kawa.lib.uniform");
        defProcStFld("make-f32vector", "kawa.lib.uniform");
        defProcStFld("f32vector", "kawa.lib.uniform");
        defProcStFld("f32vector-length", "kawa.lib.uniform");
        defProcStFld("f32vector-ref", "kawa.lib.uniform");
        defProcStFld("f32vector-set!", "kawa.lib.uniform");
        defProcStFld("f32vector->list", "kawa.lib.uniform");
        defProcStFld("list->f32vector", "kawa.lib.uniform");
        defProcStFld("f64vector?", "kawa.lib.uniform");
        defProcStFld("make-f64vector", "kawa.lib.uniform");
        defProcStFld("f64vector", "kawa.lib.uniform");
        defProcStFld("f64vector-length", "kawa.lib.uniform");
        defProcStFld("f64vector-ref", "kawa.lib.uniform");
        defProcStFld("f64vector-set!", "kawa.lib.uniform");
        defProcStFld("f64vector->list", "kawa.lib.uniform");
        defProcStFld("list->f64vector", "kawa.lib.uniform");
        defSntxStFld("cut", "gnu.kawa.slib.cut");
        defSntxStFld("cute", "gnu.kawa.slib.cut");
        defSntxStFld("cond-expand", "kawa.lib.syntax");
        defSntxStFld("%cond-expand", "kawa.lib.syntax");
        defAliasStFld("*print-base*", "gnu.kawa.functions.DisplayFormat", "outBase");
        defAliasStFld("*print-radix*", "gnu.kawa.functions.DisplayFormat", "outRadix");
        defAliasStFld("*print-right-margin*", "gnu.text.PrettyWriter", "lineLengthLoc");
        defAliasStFld("*print-miser-width*", "gnu.text.PrettyWriter", "miserWidthLoc");
        defAliasStFld("html", "gnu.kawa.xml.XmlNamespace", "HTML");
        defAliasStFld("unit", "kawa.standard.Scheme", "unitNamespace");
        defAliasStFld("path", "gnu.kawa.lispexpr.LangObjType", "pathType");
        defAliasStFld("filepath", "gnu.kawa.lispexpr.LangObjType", "filepathType");
        defAliasStFld("URI", "gnu.kawa.lispexpr.LangObjType", "URIType");
        defProcStFld("resolve-uri", "kawa.lib.files");
        defAliasStFld("vector", "gnu.kawa.lispexpr.LangObjType", "vectorType");
        defAliasStFld("string", "gnu.kawa.lispexpr.LangObjType", "stringType");
        defAliasStFld("list", "gnu.kawa.lispexpr.LangObjType", "listType");
        defAliasStFld("regex", "gnu.kawa.lispexpr.LangObjType", "regexType");
        defProcStFld("path?", "kawa.lib.files");
        defProcStFld("filepath?", "kawa.lib.files");
        defProcStFld("URI?", "kawa.lib.files");
        defProcStFld("absolute-path?", "kawa.lib.files");
        defProcStFld("path-scheme", "kawa.lib.files");
        defProcStFld("path-authority", "kawa.lib.files");
        defProcStFld("path-user-info", "kawa.lib.files");
        defProcStFld("path-host", "kawa.lib.files");
        defProcStFld("path-port", "kawa.lib.files");
        defProcStFld("path-file", "kawa.lib.files");
        defProcStFld("path-parent", "kawa.lib.files");
        defProcStFld("path-directory", "kawa.lib.files");
        defProcStFld("path-last", "kawa.lib.files");
        defProcStFld("path-extension", "kawa.lib.files");
        defProcStFld("path-fragment", "kawa.lib.files");
        defProcStFld("path-query", "kawa.lib.files");
        kawaEnvironment.setLocked();
    }

    public static void registerEnvironment()
    {
        Language.setDefaults(getInstance());
    }

    public static Type string2Type(String s)
    {
        Object obj;
        if (s.endsWith("[]"))
        {
            Type type = string2Type(s.substring(0, s.length() - 2));
            obj = type;
            if (type != null)
            {
                obj = ArrayType.make(type);
            }
        } else
        {
            obj = getNamedType(s);
        }
        if (obj != null)
        {
            return ((Type) (obj));
        }
        obj = Language.string2Type(s);
        if (obj != null)
        {
            types.put(s, obj);
        }
        return ((Type) (obj));
    }

    public Symbol asSymbol(String s)
    {
        return Namespace.EmptyNamespace.getSymbol(s);
    }

    public Expression checkDefaultBinding(Symbol symbol, Translator translator)
    {
        Object obj;
        Expression aexpression[];
        Object obj3;
        int k2;
        obj3 = symbol.getNamespace();
        obj = symbol.getLocalPart();
        if (obj3 instanceof XmlNamespace)
        {
            return QuoteExp.getInstance(((XmlNamespace)obj3).get(((String) (obj))));
        }
        if (((Namespace) (obj3)).getName() == unitNamespace.getName())
        {
            gnu.math.NamedUnit namedunit = Unit.lookup(((String) (obj)));
            if (namedunit != null)
            {
                return QuoteExp.getInstance(namedunit);
            }
        }
        aexpression = symbol.toString();
        k2 = aexpression.length();
        if (k2 == 0)
        {
            return null;
        }
        if (k2 <= 1 || aexpression.charAt(k2 - 1) != '?') goto _L2; else goto _L1
_L1:
        int i = ((String) (obj)).length();
        if (i <= 1) goto _L2; else goto _L3
_L3:
        Object obj2 = translator.rewrite(((Namespace) (obj3)).getSymbol(((String) (obj)).substring(0, i - 1).intern()), false);
        if (!(obj2 instanceof ReferenceExp)) goto _L5; else goto _L4
_L4:
label0:
        {
            Declaration declaration = ((ReferenceExp)obj2).getBinding();
            if (declaration != null)
            {
                obj = obj2;
                if (!declaration.getFlag(0x10000L))
                {
                    break label0;
                }
            }
            obj = null;
        }
_L6:
        if (obj != null)
        {
            translator = new LambdaExp(1);
            translator.setSymbol(symbol);
            symbol = translator.addDeclaration((Object)null);
            translator.body = new ApplyExp(instanceOf, new Expression[] {
                new ReferenceExp(symbol), obj
            });
            return translator;
        }
        break; /* Loop/switch isn't completed */
_L5:
        obj = obj2;
        if (!(obj2 instanceof QuoteExp))
        {
            obj = null;
        }
        if (true) goto _L6; else goto _L2
_L2:
        char c4 = aexpression.charAt(0);
        if (c4 != '-' && c4 != '+' && Character.digit(c4, 10) < 0) goto _L8; else goto _L7
_L7:
        int j;
        i = 0;
        j = 0;
_L10:
        char c;
        if (j >= k2)
        {
            break; /* Loop/switch isn't completed */
        }
        c = aexpression.charAt(j);
        if (Character.digit(c, 10) >= 0)
        {
            if (i < 3)
            {
                i = 2;
            } else
            if (i < 5)
            {
                i = 4;
            } else
            {
                i = 5;
            }
        } else
        if ((c == '+' || c == '-') && i == 0)
        {
            i = 1;
        } else
        {
label1:
            {
                if (c != '.' || i >= 3)
                {
                    break label1;
                }
                i = 3;
            }
        }
_L17:
        j++;
        if (true) goto _L10; else goto _L9
        if (c != 'e' && c != 'E' || i != 2 && i != 4 || j + 1 >= k2) goto _L9; else goto _L11
_L11:
        int k;
label2:
        {
            int l = j + 1;
            char c2 = aexpression.charAt(l);
            if (c2 != '-')
            {
                k = l;
                c = c2;
                if (c2 != '+')
                {
                    break label2;
                }
            }
            l++;
            k = l;
            c = c2;
            if (l < k2)
            {
                c = aexpression.charAt(l);
                k = l;
            }
        }
        if (Character.digit(c, 10) >= 0) goto _L12; else goto _L9
_L9:
        if (j >= k2 || i <= 1) goto _L8; else goto _L13
_L13:
        Vector vector;
        obj2 = new DFloNum(aexpression.substring(0, j));
        k = 0;
        vector = new Vector();
        i = j;
_L28:
        char c3;
        int i1;
        if (i >= k2)
        {
            break MISSING_BLOCK_LABEL_1112;
        }
        i1 = i + 1;
        c3 = aexpression.charAt(i);
        if (c3 != '*') goto _L15; else goto _L14
_L14:
        if (i1 != k2) goto _L16; else goto _L8
_L8:
        char c1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (k2 > 2 && c4 == '<' && aexpression.charAt(k2 - 1) == '>')
        {
            symbol = aexpression.substring(1, k2 - 1);
            j = k2 - 2;
            k = 1;
        } else
        {
            k = 0;
            j = k2;
            symbol = aexpression;
        }
        for (i = 0; j > 2 && symbol.charAt(j - 2) == '[' && symbol.charAt(j - 1) == ']'; i++)
        {
            j -= 2;
        }

        break MISSING_BLOCK_LABEL_1313;
_L12:
        i = 5;
        j = k + 1;
          goto _L17
_L16:
        c1 = aexpression.charAt(i1);
        i = i1 + 1;
        j = k;
_L30:
        i1 = i - 1;
_L32:
        if (Character.isLetter(c1)) goto _L19; else goto _L18
_L18:
        k = i - 1;
        if (k == i1) goto _L8; else goto _L20
_L20:
        vector.addElement(aexpression.substring(i1, k));
        k = 0;
        if (c1 != '^')
        {
            break MISSING_BLOCK_LABEL_802;
        }
        k = 1;
        if (i == k2) goto _L8; else goto _L21
_L21:
        i1 = i + 1;
        c1 = aexpression.charAt(i);
        i = i1;
        l1 = j;
        if (c1 != '+') goto _L23; else goto _L22
_L22:
        k = 1;
        if (i == k2) goto _L8; else goto _L24
_L24:
        i1 = i + 1;
        c1 = aexpression.charAt(i);
        i = i1;
_L34:
        k1 = 0;
        j1 = 0;
        i1 = i;
_L38:
        i = Character.digit(c1, 10);
        if (i > 0) goto _L26; else goto _L25
_L25:
        i = i1 - 1;
_L37:
        if (k1 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = 1;
        if (k != 0) goto _L8; else goto _L27
_L27:
        k = j1;
        if (l1 != 0)
        {
            k = -j1;
        }
        vector.addElement(IntNum.make(k));
        k = j;
          goto _L28
_L15:
        c1 = c3;
        j = k;
        i = i1;
        if (c3 != '/') goto _L30; else goto _L29
_L29:
        if (i1 == k2 || k != 0) goto _L8; else goto _L31
_L31:
        j = 1;
        c1 = aexpression.charAt(i1);
        i = i1 + 1;
          goto _L30
_L19:
label3:
        {
            if (i != k2)
            {
                break label3;
            }
            k = i;
            c1 = '1';
        }
          goto _L20
        c1 = aexpression.charAt(i);
        i++;
          goto _L32
_L23:
        if (c1 != '-') goto _L34; else goto _L33
_L33:
        k = 1;
        if (i == k2) goto _L8; else goto _L35
_L35:
        j1 = i + 1;
        c1 = aexpression.charAt(i);
        if (l1 == 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        i = j1;
        l1 = i1;
          goto _L34
_L26:
        i2 = j1 * 10 + i;
        j2 = k1 + 1;
        j1 = i2;
        i = i1;
        k1 = j2;
        if (i1 == k2) goto _L37; else goto _L36
_L36:
        c1 = aexpression.charAt(i1);
        i1++;
        j1 = i2;
        k1 = j2;
          goto _L38
        if (i == k2)
        {
            j = vector.size() >> 1;
            aexpression = new Expression[j];
            for (i = 0; i < j; i++)
            {
                symbol = (String)vector.elementAt(i * 2);
                obj = translator.rewrite(unitNamespace.getSymbol(symbol.intern()));
                obj3 = (IntNum)vector.elementAt(i * 2 + 1);
                symbol = ((Symbol) (obj));
                if (((IntNum) (obj3)).longValue() != 1L)
                {
                    symbol = new ApplyExp(expt.expt, new Expression[] {
                        obj, QuoteExp.getInstance(obj3)
                    });
                }
                aexpression[i] = symbol;
            }

            if (j == 1)
            {
                symbol = aexpression[0];
            } else
            {
                symbol = new ApplyExp(MultiplyOp.$St, aexpression);
            }
            return new ApplyExp(MultiplyOp.$St, new Expression[] {
                QuoteExp.getInstance(obj2), symbol
            });
        }
          goto _L8
        obj = symbol;
        if (i != 0)
        {
            obj = symbol.substring(0, j);
        }
        obj2 = getNamedType(((String) (obj)));
        Object obj1 = obj2;
        if (i <= 0) goto _L40; else goto _L39
_L39:
        if (k == 0) goto _L42; else goto _L41
_L41:
        obj1 = obj2;
        if (obj2 != null) goto _L40; else goto _L42
_L42:
        obj3 = InlineCalls.inlineCalls(translator.rewrite(((Namespace) (obj3)).getSymbol(((String) (obj)).intern()), false), translator);
        obj1 = obj2;
        if (!(obj3 instanceof ErrorExp))
        {
            obj1 = translator.getLanguage().getTypeFor(((Expression) (obj3)));
        }
          goto _L40
_L43:
        i--;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_1428;
        }
        obj1 = ArrayType.make(((Type) (obj1)));
          goto _L43
        return QuoteExp.getInstance(obj1);
_L53:
        obj1 = Type.lookupType(((String) (obj)));
        if (!(obj1 instanceof PrimType)) goto _L45; else goto _L44
_L44:
        translator = ((Type) (obj1)).getReflectClass();
_L52:
        if (translator == null) goto _L47; else goto _L46
_L46:
        obj = translator;
        if (i <= 0) goto _L49; else goto _L48
_L48:
        translator = Type.make(translator);
_L51:
        i--;
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        translator = ArrayType.make(translator);
        if (true) goto _L51; else goto _L50
_L45:
        obj1 = obj;
        if (((String) (obj)).indexOf('.') < 0)
        {
            obj1 = (new StringBuilder()).append(translator.classPrefix).append(Compilation.mangleNameIfNeeded(((String) (obj)))).toString();
        }
        translator = ClassType.getContextClass(((String) (obj1)));
          goto _L52
_L50:
        obj = translator.getReflectClass();
_L49:
        translator = QuoteExp.getInstance(obj);
        return translator;
        translator;
        symbol = ArrayClassLoader.getContextPackage(symbol);
        if (symbol != null)
        {
            return QuoteExp.getInstance(symbol);
        }
          goto _L47
        symbol;
_L47:
        return null;
_L40:
        if (obj1 == null) goto _L53; else goto _L43
    }

    public ReadTable createReadTable()
    {
        ReadTable readtable = ReadTable.createInitial();
        readtable.postfixLookupOperator = ':';
        ReaderDispatch readerdispatch = (ReaderDispatch)readtable.lookup(35);
        readerdispatch.set(39, new ReaderQuote(asSymbol("syntax")));
        readerdispatch.set(96, new ReaderQuote(asSymbol("quasisyntax")));
        readerdispatch.set(44, ReaderDispatchMisc.getInstance());
        readtable.putReaderCtorFld("path", "gnu.kawa.lispexpr.LangObjType", "pathType");
        readtable.putReaderCtorFld("filepath", "gnu.kawa.lispexpr.LangObjType", "filepathType");
        readtable.putReaderCtorFld("URI", "gnu.kawa.lispexpr.LangObjType", "URIType");
        readtable.putReaderCtor("symbol", ClassType.make("gnu.mapping.Symbol"));
        readtable.putReaderCtor("namespace", ClassType.make("gnu.mapping.Namespace"));
        readtable.putReaderCtorFld("duration", "kawa.lib.numbers", "duration");
        readtable.setFinalColonIsKeyword(true);
        return readtable;
    }

    public String formatType(Type type)
    {
        if (typeToStringMap == null)
        {
            typeToStringMap = new HashMap();
            Iterator iterator = getTypeMap().entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)iterator.next();
                String s1 = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (Type)((java.util.Map.Entry) (obj)).getValue();
                typeToStringMap.put(obj, s1);
                Type type1 = ((Type) (obj)).getImplementationType();
                if (type1 != obj)
                {
                    typeToStringMap.put(type1, s1);
                }
            } while (true);
        }
        String s = (String)typeToStringMap.get(type);
        if (s != null)
        {
            return s;
        } else
        {
            return super.formatType(type);
        }
    }

    public AbstractFormat getFormat(boolean flag)
    {
        if (flag)
        {
            return writeFormat;
        } else
        {
            return displayFormat;
        }
    }

    public String getName()
    {
        return "Scheme";
    }

    public int getNamespaceOf(Declaration declaration)
    {
        return 3;
    }

    public Type getTypeFor(Class class1)
    {
        String s = class1.getName();
        if (class1.isPrimitive())
        {
            return getNamedType(s);
        }
        if ("java.lang.String".equals(s))
        {
            return Type.toStringType;
        }
        if ("gnu.math.IntNum".equals(s))
        {
            return LangObjType.integerType;
        }
        if ("gnu.math.DFloNum".equals(s))
        {
            return LangObjType.dflonumType;
        }
        if ("gnu.math.RatNum".equals(s))
        {
            return LangObjType.rationalType;
        }
        if ("gnu.math.RealNum".equals(s))
        {
            return LangObjType.realType;
        }
        if ("gnu.math.Numeric".equals(s))
        {
            return LangObjType.numericType;
        }
        if ("gnu.lists.FVector".equals(s))
        {
            return LangObjType.vectorType;
        }
        if ("gnu.lists.LList".equals(s))
        {
            return LangObjType.listType;
        }
        if ("gnu.text.Path".equals(s))
        {
            return LangObjType.pathType;
        }
        if ("gnu.text.URIPath".equals(s))
        {
            return LangObjType.URIType;
        }
        if ("gnu.text.FilePath".equals(s))
        {
            return LangObjType.filepathType;
        }
        if ("java.lang.Class".equals(s))
        {
            return LangObjType.typeClass;
        }
        if ("gnu.bytecode.Type".equals(s))
        {
            return LangObjType.typeType;
        }
        if ("gnu.bytecode.ClassType".equals(s))
        {
            return LangObjType.typeClassType;
        } else
        {
            return Type.make(class1);
        }
    }

    public Type getTypeFor(String s)
    {
        return string2Type(s);
    }

    public Expression makeApply(Expression expression, Expression aexpression[])
    {
        Expression aexpression1[] = new Expression[aexpression.length + 1];
        aexpression1[0] = expression;
        System.arraycopy(aexpression, 0, aexpression1, 1, aexpression.length);
        return new ApplyExp(new ReferenceExp(applyFieldDecl), aexpression1);
    }

    static 
    {
        int i;
        nullEnvironment = Environment.make("null-environment");
        r4Environment = Environment.make("r4rs-environment", nullEnvironment);
        r5Environment = Environment.make("r5rs-environment", r4Environment);
        kawaEnvironment = Environment.make("kawa-environment", r5Environment);
        instance = new Scheme(kawaEnvironment);
        instanceOf = new InstanceOf(instance, "instance?");
        not = new Not(instance, "not");
        applyToArgs = new ApplyToArgs("apply-to-args", instance);
        applyFieldDecl = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
        apply = new Apply("apply", applyToArgs);
        isEq = new IsEq(instance, "eq?");
        isEqv = new IsEqv(instance, "eqv?", isEq);
        isEqual = new IsEqual(instance, "equal?");
        map = new Map(true, applyToArgs, applyFieldDecl, isEq);
        forEach = new Map(false, applyToArgs, applyFieldDecl, isEq);
        numEqu = NumberCompare.make(instance, "=", 8);
        numGrt = NumberCompare.make(instance, ">", 16);
        numGEq = NumberCompare.make(instance, ">=", 24);
        numLss = NumberCompare.make(instance, "<", 4);
        numLEq = NumberCompare.make(instance, "<=", 12);
        isOdd = new NumberPredicate(instance, "odd?", 1);
        isEven = new NumberPredicate(instance, "even?", 2);
        instance.initScheme();
        i = HttpRequestContext.importServletDefinitions;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_339;
        }
        Scheme scheme = instance;
        String s;
        if (i > 1)
        {
            s = "gnu.kawa.servlet.servlets";
        } else
        {
            s = "gnu.kawa.servlet.HTTP";
        }
        try
        {
            scheme.loadClass(s);
        }
        catch (Throwable throwable) { }
        writeFormat = new DisplayFormat(true, 'S');
        displayFormat = new DisplayFormat(false, 'S');
        unitNamespace = Namespace.valueOf("http://kawa.gnu.org/unit", "unit");
        return;
    }
}
