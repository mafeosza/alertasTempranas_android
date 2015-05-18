// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.AbstractFormat;
import gnu.lists.CharSeq;
import gnu.lists.Consumer;
import gnu.lists.Convert;
import gnu.lists.FString;
import gnu.lists.PrintConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.InPort;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.NamedLocation;
import gnu.mapping.Namespace;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kawa.repl;

// Referenced classes of package gnu.expr:
//            BuiltinEnvironment, KawaConvert, Compilation, ModuleExp, 
//            Declaration, SimplePrompter, QuoteExp, ReferenceExp, 
//            ClassExp, LambdaExp, ModuleBody, NameLookup, 
//            ModuleInfo, Expression

public abstract class Language
{

    public static final int FUNCTION_NAMESPACE = 2;
    public static final int NAMESPACE_PREFIX_NAMESPACE = 4;
    public static final int PARSE_CURRENT_NAMES = 2;
    public static final int PARSE_EXPLICIT = 64;
    public static final int PARSE_FOR_APPLET = 16;
    public static final int PARSE_FOR_EVAL = 3;
    public static final int PARSE_FOR_SERVLET = 32;
    public static final int PARSE_IMMEDIATE = 1;
    public static final int PARSE_ONE_LINE = 4;
    public static final int PARSE_PROLOG = 8;
    public static final int VALUE_NAMESPACE = 1;
    protected static final InheritableThreadLocal current = new InheritableThreadLocal();
    static int envCounter;
    protected static int env_counter = 0;
    protected static Language global;
    static String languages[][];
    public static boolean requirePedantic;
    protected Environment environ;
    protected Environment userEnv;

    protected Language()
    {
        Convert.setInstance(KawaConvert.getInstance());
    }

    public static Language detect(InPort inport)
        throws IOException
    {
        StringBuffer stringbuffer = new StringBuffer();
        inport.mark(300);
        inport.readLine(stringbuffer, 'P');
        inport.reset();
        return detect(stringbuffer.toString());
    }

    public static Language detect(InputStream inputstream)
        throws IOException
    {
        StringBuffer stringbuffer;
        if (!inputstream.markSupported())
        {
            return null;
        }
        stringbuffer = new StringBuffer();
        inputstream.mark(200);
_L5:
        if (stringbuffer.length() < 200) goto _L2; else goto _L1
_L1:
        int i;
        inputstream.reset();
        return detect(stringbuffer.toString());
_L2:
        if ((i = inputstream.read()) < 0 || i == 10 || i == 13) goto _L1; else goto _L3
_L3:
        stringbuffer.append((char)i);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static Language detect(String s)
    {
        s = s.trim();
        int i = s.indexOf("kawa:");
        if (i >= 0)
        {
            int j = i + 5;
            for (i = j; i < s.length() && Character.isJavaIdentifierPart(s.charAt(i)); i++) { }
            if (i > j)
            {
                Language language = getInstance(s.substring(j, i));
                if (language != null)
                {
                    return language;
                }
            }
        }
        if (s.indexOf("-*- scheme -*-") >= 0)
        {
            return getInstance("scheme");
        }
        if (s.indexOf("-*- xquery -*-") >= 0)
        {
            return getInstance("xquery");
        }
        if (s.indexOf("-*- emacs-lisp -*-") >= 0)
        {
            return getInstance("elisp");
        }
        if (s.indexOf("-*- common-lisp -*-") >= 0 || s.indexOf("-*- lisp -*-") >= 0)
        {
            return getInstance("common-lisp");
        }
        if (s.charAt(0) == '(' && s.charAt(1) == ':' || s.length() >= 7 && s.substring(0, 7).equals("xquery "))
        {
            return getInstance("xquery");
        }
        if (s.charAt(0) == ';' && s.charAt(1) == ';')
        {
            return getInstance("scheme");
        } else
        {
            return null;
        }
    }

    public static Language getDefaultLanguage()
    {
        Language language = (Language)current.get();
        if (language != null)
        {
            return language;
        } else
        {
            return global;
        }
    }

    public static Language getInstance(String s)
    {
        int i;
        int i1;
        i1 = languages.length;
        i = 0;
_L3:
        if (i >= i1) goto _L2; else goto _L1
_L1:
        String as[];
        int k;
        as = languages[i];
        k = as.length - 1;
        int j = k;
        int l;
        do
        {
            l = j - 1;
            if (l < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (s == null)
            {
                break;
            }
            j = l;
        } while (!as[l].equalsIgnoreCase(s));
        Class class1 = Class.forName(as[k]);
        return getInstance(as[0], class1);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        i++;
          goto _L3
_L2:
        return null;
    }

    public static Language getInstance(String s, Class class1)
    {
        Class aclass[] = new Class[0];
        s = (new StringBuilder()).append(Character.toTitleCase(s.charAt(0))).append(s.substring(1).toLowerCase()).toString();
        s = class1.getDeclaredMethod((new StringBuilder()).append("get").append(s).append("Instance").toString(), aclass);
_L1:
        try
        {
            return (Language)s.invoke(null, Values.noArgs);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            class1 = class1.getName();
        }
        break MISSING_BLOCK_LABEL_101;
        s;
        s = class1.getDeclaredMethod("getInstance", aclass);
          goto _L1
        if (s instanceof InvocationTargetException)
        {
            s = ((InvocationTargetException)s).getTargetException();
        }
        throw new WrappedException((new StringBuilder()).append("getInstance for '").append(class1).append("' failed").toString(), s);
    }

    public static Language getInstanceFromFilenameExtension(String s)
    {
        int i = s.lastIndexOf('.');
        if (i > 0)
        {
            s = getInstance(s.substring(i));
            if (s != null)
            {
                return s;
            }
        }
        return null;
    }

    public static String[][] getLanguages()
    {
        return languages;
    }

    public static void registerLanguage(String as[])
    {
        String as1[][] = new String[languages.length + 1][];
        System.arraycopy(languages, 0, as1, 0, languages.length);
        as1[as1.length - 1] = as;
        languages = as1;
    }

    public static void restoreCurrent(Language language)
    {
        current.set(language);
    }

    public static void setCurrentLanguage(Language language)
    {
        current.set(language);
    }

    public static void setDefaults(Language language)
    {
        gnu/expr/Language;
        JVM INSTR monitorenter ;
        setCurrentLanguage(language);
        global = language;
        if (Environment.getGlobal() == BuiltinEnvironment.getInstance())
        {
            Environment.setGlobal(Environment.getCurrent());
        }
        gnu/expr/Language;
        JVM INSTR monitorexit ;
        return;
        language;
        throw language;
    }

    public static Language setSaveCurrent(Language language)
    {
        Language language1 = (Language)current.get();
        current.set(language);
        return language1;
    }

    public static Type string2Type(String s)
    {
        if (s.endsWith("[]"))
        {
            s = string2Type(s.substring(0, s.length() - 2));
            if (s == null)
            {
                return null;
            } else
            {
                return ArrayType.make(s);
            }
        }
        if (Type.isValidJavaTypeName(s))
        {
            return Type.getType(s);
        } else
        {
            return null;
        }
    }

    public static Type unionType(Type type, Type type1)
    {
        Object obj = type;
        if (type == Type.toStringType)
        {
            obj = Type.javalangStringType;
        }
        type = type1;
        if (type1 == Type.toStringType)
        {
            type = Type.javalangStringType;
        }
        if (obj != type)
        {
            if ((obj instanceof PrimType) && (type instanceof PrimType))
            {
                char c = ((Type) (obj)).getSignature().charAt(0);
                char c1 = type.getSignature().charAt(0);
                if (c != c1)
                {
                    if ((c == 'B' || c == 'S' || c == 'I') && (c1 == 'I' || c1 == 'J'))
                    {
                        return type;
                    }
                    if (c1 != 'B' && c1 != 'S' && c1 != 'I' || c != 'I' && c != 'J')
                    {
                        if (c == 'F' && c1 == 'D')
                        {
                            return type;
                        }
                        if (c1 != 'F' || c != 'D')
                        {
                            return Type.objectType;
                        }
                    }
                }
            } else
            {
                return Type.objectType;
            }
        }
        return ((Type) (obj));
    }

    public final Type asType(Object obj)
    {
        Type type = getTypeFor(obj, true);
        if (type == null)
        {
            return (Type)obj;
        } else
        {
            return type;
        }
    }

    public Object booleanObject(boolean flag)
    {
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public Object coerceFromObject(Class class1, Object obj)
    {
        return getTypeFor(class1).coerceFromObject(obj);
    }

    public Object coerceToObject(Class class1, Object obj)
    {
        return getTypeFor(class1).coerceToObject(obj);
    }

    public Declaration declFromField(ModuleExp moduleexp, Object obj, Field field)
    {
        Type type;
        boolean flag1;
        Object obj1 = field.getName();
        type = field.getType();
        boolean flag3 = type.isSubtype(Compilation.typeLocation);
        boolean flag2 = false;
        boolean flag = false;
        boolean flag4;
        if ((field.getModifiers() & 0x10) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag4 = ((String) (obj1)).endsWith("$instance");
        if (flag4)
        {
            obj = obj1;
        } else
        if (flag1 && (obj instanceof Named))
        {
            obj = ((Named)obj).getSymbol();
        } else
        {
            flag = flag2;
            obj = obj1;
            if (((String) (obj1)).startsWith("$Prvt$"))
            {
                flag = true;
                obj = ((String) (obj1)).substring("$Prvt$".length());
            }
            obj = Compilation.demangleName(((String) (obj)), true).intern();
        }
        obj1 = obj;
        if (obj instanceof String)
        {
            obj1 = moduleexp.getNamespaceUri();
            obj = (String)obj;
            if (obj1 == null)
            {
                obj1 = SimpleSymbol.valueOf(((String) (obj)));
            } else
            {
                obj1 = Symbol.make(obj1, ((String) (obj)));
            }
        }
        if (flag3)
        {
            obj = Type.objectType;
        } else
        {
            obj = getTypeFor(type.getReflectClass());
        }
        moduleexp = moduleexp.addDeclaration(obj1, ((Type) (obj)));
        if ((field.getModifiers() & 8) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag3) goto _L2; else goto _L1
_L1:
        moduleexp.setIndirectBinding(true);
        if ((type instanceof ClassType) && ((ClassType)type).isSubclass("gnu.mapping.ThreadLocation"))
        {
            moduleexp.setFlag(0x10000000L);
        }
_L4:
        if (flag2)
        {
            moduleexp.setFlag(2048L);
        }
        moduleexp.field = field;
        if (flag1 && !flag3)
        {
            moduleexp.setFlag(16384L);
        }
        if (flag4)
        {
            moduleexp.setFlag(0x40000000L);
        }
        moduleexp.setSimple(false);
        if (flag)
        {
            moduleexp.setFlag(0x80020L);
        }
        return moduleexp;
_L2:
        if (flag1 && (type instanceof ClassType))
        {
            if (type.isSubtype(Compilation.typeProcedure))
            {
                moduleexp.setProcedureDecl(true);
            } else
            if (((ClassType)type).isSubclass("gnu.mapping.Namespace"))
            {
                moduleexp.setFlag(0x200000L);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void defAliasStFld(String s, String s1, String s2)
    {
        StaticFieldLocation.define(environ, getSymbol(s), null, s1, s2);
    }

    protected void defProcStFld(String s, String s1)
    {
        defProcStFld(s, s1, Compilation.mangleNameIfNeeded(s));
    }

    protected void defProcStFld(String s, String s1, String s2)
    {
        Object obj;
        if (hasSeparateFunctionNamespace())
        {
            obj = EnvironmentKey.FUNCTION;
        } else
        {
            obj = null;
        }
        s = getSymbol(s);
        StaticFieldLocation.define(environ, s, obj, s1, s2).setProcedure();
    }

    public void define(String s, Object obj)
    {
        s = getSymbol(s);
        environ.define(s, null, obj);
    }

    public final void defineFunction(Named named)
    {
        Object obj = named.getSymbol();
        Object obj1;
        if (obj instanceof Symbol)
        {
            obj = (Symbol)obj;
        } else
        {
            obj = getSymbol(obj.toString());
        }
        if (hasSeparateFunctionNamespace())
        {
            obj1 = EnvironmentKey.FUNCTION;
        } else
        {
            obj1 = null;
        }
        environ.define(((Symbol) (obj)), obj1, named);
    }

    public void defineFunction(String s, Object obj)
    {
        Object obj1;
        if (hasSeparateFunctionNamespace())
        {
            obj1 = EnvironmentKey.FUNCTION;
        } else
        {
            obj1 = null;
        }
        environ.define(getSymbol(s), obj1, obj);
    }

    public void emitCoerceToBoolean(CodeAttr codeattr)
    {
        emitPushBoolean(false, codeattr);
        codeattr.emitIfNEq();
        codeattr.emitPushInt(1);
        codeattr.emitElse();
        codeattr.emitPushInt(0);
        codeattr.emitFi();
    }

    public void emitPushBoolean(boolean flag, CodeAttr codeattr)
    {
        Field field;
        if (flag)
        {
            field = Compilation.trueConstant;
        } else
        {
            field = Compilation.falseConstant;
        }
        codeattr.emitGetStatic(field);
    }

    public final Object eval(InPort inport)
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        int i = callcontext.startFromContext();
        try
        {
            eval(inport, callcontext);
            inport = ((InPort) (callcontext.getFromContext(i)));
        }
        // Misplaced declaration of an exception variable
        catch (InPort inport)
        {
            callcontext.cleanupFromContext(i);
            throw inport;
        }
        return inport;
    }

    public final Object eval(Reader reader)
        throws Throwable
    {
        if (reader instanceof InPort)
        {
            reader = (InPort)reader;
        } else
        {
            reader = new InPort(reader);
        }
        return eval(((InPort) (reader)));
    }

    public final Object eval(String s)
        throws Throwable
    {
        return eval(((InPort) (new CharArrayInPort(s))));
    }

    public void eval(InPort inport, CallContext callcontext)
        throws Throwable
    {
        Language language;
        SourceMessages sourcemessages;
        sourcemessages = new SourceMessages();
        language = setSaveCurrent(this);
        inport = parse(inport, sourcemessages, 3);
        ModuleExp.evalModule(getEnvironment(), callcontext, inport, null, null);
        restoreCurrent(language);
        if (sourcemessages.seenErrors())
        {
            throw new RuntimeException((new StringBuilder()).append("invalid syntax in eval form:\n").append(sourcemessages.toString(20)).toString());
        } else
        {
            return;
        }
        inport;
        restoreCurrent(language);
        throw inport;
    }

    public void eval(Reader reader, Consumer consumer)
        throws Throwable
    {
        CallContext callcontext;
        Consumer consumer1;
        if (reader instanceof InPort)
        {
            reader = (InPort)reader;
        } else
        {
            reader = new InPort(reader);
        }
        callcontext = CallContext.getInstance();
        consumer1 = callcontext.consumer;
        callcontext.consumer = consumer;
        eval(((InPort) (reader)), callcontext);
        callcontext.consumer = consumer1;
        return;
        reader;
        callcontext.consumer = consumer1;
        throw reader;
    }

    public final void eval(Reader reader, Writer writer)
        throws Throwable
    {
        eval(reader, getOutputConsumer(writer));
    }

    public final void eval(String s, Consumer consumer)
        throws Throwable
    {
        eval(((Reader) (new CharArrayInPort(s))), consumer);
    }

    public final void eval(String s, PrintConsumer printconsumer)
        throws Throwable
    {
        eval(s, getOutputConsumer(printconsumer));
    }

    public final void eval(String s, Writer writer)
        throws Throwable
    {
        eval(((Reader) (new CharArrayInPort(s))), writer);
    }

    public String formatType(Type type)
    {
        return type.getName();
    }

    public Compilation getCompilation(Lexer lexer, SourceMessages sourcemessages, NameLookup namelookup)
    {
        return new Compilation(this, sourcemessages, namelookup);
    }

    public Object getEnvPropertyFor(Declaration declaration)
    {
        if (hasSeparateFunctionNamespace() && declaration.isProcedureDecl())
        {
            return EnvironmentKey.FUNCTION;
        } else
        {
            return null;
        }
    }

    public Object getEnvPropertyFor(java.lang.reflect.Field field, Object obj)
    {
        while (!hasSeparateFunctionNamespace() || !Compilation.typeProcedure.getReflectClass().isAssignableFrom(field.getType())) 
        {
            return null;
        }
        return EnvironmentKey.FUNCTION;
    }

    public final Environment getEnvironment()
    {
        if (userEnv != null)
        {
            return userEnv;
        } else
        {
            return Environment.getCurrent();
        }
    }

    public AbstractFormat getFormat(boolean flag)
    {
        return null;
    }

    public Environment getLangEnvironment()
    {
        return environ;
    }

    public final Type getLangTypeFor(Type type)
    {
        Type type1 = type;
        if (type.isExisting())
        {
            Class class1 = type.getReflectClass();
            type1 = type;
            if (class1 != null)
            {
                type1 = getTypeFor(class1);
            }
        }
        return type1;
    }

    public abstract Lexer getLexer(InPort inport, SourceMessages sourcemessages);

    public String getName()
    {
        String s1 = getClass().getName();
        int i = s1.lastIndexOf('.');
        String s = s1;
        if (i >= 0)
        {
            s = s1.substring(i + 1);
        }
        return s;
    }

    public int getNamespaceOf(Declaration declaration)
    {
        return 1;
    }

    public final Environment getNewEnvironment()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("environment-");
        int i = envCounter + 1;
        envCounter = i;
        return Environment.make(stringbuilder.append(i).toString(), environ);
    }

    public Consumer getOutputConsumer(Writer writer)
    {
        if (writer instanceof OutPort)
        {
            writer = (OutPort)writer;
        } else
        {
            writer = new OutPort(writer);
        }
        writer.objectFormat = getFormat(false);
        return writer;
    }

    public Procedure getPrompter()
    {
        Object obj = null;
        if (hasSeparateFunctionNamespace())
        {
            obj = EnvironmentKey.FUNCTION;
        }
        obj = (Procedure)getEnvironment().get(getSymbol("default-prompter"), obj, null);
        if (obj != null)
        {
            return ((Procedure) (obj));
        } else
        {
            return new SimplePrompter();
        }
    }

    public Symbol getSymbol(String s)
    {
        return environ.getSymbol(s);
    }

    public final Type getTypeFor(Expression expression)
    {
        return getTypeFor(expression, true);
    }

    public Type getTypeFor(Expression expression, boolean flag)
    {
        Object obj1 = null;
        if (!(expression instanceof QuoteExp)) goto _L2; else goto _L1
_L1:
        expression = ((Expression) (((QuoteExp)expression).getValue()));
        if (!(expression instanceof Type)) goto _L4; else goto _L3
_L3:
        Object obj = (Type)expression;
_L11:
        return ((Type) (obj));
_L4:
        if (expression instanceof Class)
        {
            return Type.make((Class)expression);
        } else
        {
            return getTypeFor(expression, flag);
        }
_L2:
        Object obj2;
        if (!(expression instanceof ReferenceExp))
        {
            break; /* Loop/switch isn't completed */
        }
        expression = (ReferenceExp)expression;
        obj2 = Declaration.followAliases(expression.getBinding());
        obj = expression.getName();
        expression = ((Expression) (obj));
        if (obj2 == null) goto _L6; else goto _L5
_L5:
        Expression expression1;
        expression1 = ((Declaration) (obj2)).getValue();
        if ((expression1 instanceof QuoteExp) && ((Declaration) (obj2)).getFlag(16384L) && !((Declaration) (obj2)).isIndirectBinding())
        {
            return getTypeFor(((QuoteExp)expression1).getValue(), flag);
        }
        if ((expression1 instanceof ClassExp) || (expression1 instanceof ModuleExp))
        {
            ((Declaration) (obj2)).setCanRead(true);
            return ((LambdaExp)expression1).getClassType();
        }
        if (!((Declaration) (obj2)).isAlias() || !(expression1 instanceof QuoteExp)) goto _L8; else goto _L7
_L7:
        obj2 = ((QuoteExp)expression1).getValue();
        expression = ((Expression) (obj));
        if (obj2 instanceof Location)
        {
            expression = (Location)obj2;
            if (expression.isBound())
            {
                return getTypeFor(expression.get(), flag);
            }
            obj = obj1;
            if (!(expression instanceof Named))
            {
                continue; /* Loop/switch isn't completed */
            }
            expression = ((Named)expression).getName();
        }
_L6:
        obj = getEnvironment().get(expression);
        if (obj instanceof Type)
        {
            return (Type)obj;
        }
        break; /* Loop/switch isn't completed */
_L8:
        expression = ((Expression) (obj));
        if (!((Declaration) (obj2)).getFlag(0x10000L))
        {
            return getTypeFor(expression1, flag);
        }
        if (true) goto _L6; else goto _L9
_L9:
        if (obj instanceof ClassNamespace)
        {
            return ((ClassNamespace)obj).getClassType();
        }
        int i = expression.length();
        obj = obj1;
        if (i > 2)
        {
            obj = obj1;
            if (expression.charAt(0) == '<')
            {
                obj = obj1;
                if (expression.charAt(i - 1) == '>')
                {
                    return getTypeFor(expression.substring(1, i - 1));
                }
            }
        }
        if (true) goto _L11; else goto _L10
_L10:
        if (expression instanceof ClassExp)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (!(expression instanceof ModuleExp)) goto _L11; else goto _L12
_L12:
        return ((LambdaExp)expression).getClassType();
    }

    public Type getTypeFor(Class class1)
    {
        return Type.make(class1);
    }

    public final Type getTypeFor(Object obj, boolean flag)
    {
        if (obj instanceof Type)
        {
            return (Type)obj;
        }
        if (obj instanceof Class)
        {
            return getTypeFor((Class)obj);
        }
        if (flag && ((obj instanceof FString) || (obj instanceof String) || (obj instanceof Symbol) && ((Symbol)obj).hasEmptyNamespace() || (obj instanceof CharSeq)))
        {
            return getTypeFor(obj.toString());
        }
        if (obj instanceof Namespace)
        {
            obj = ((Namespace)obj).getName();
            if (obj != null && ((String) (obj)).startsWith("class:"))
            {
                return getLangTypeFor(string2Type(((String) (obj)).substring(6)));
            }
        }
        return null;
    }

    public Type getTypeFor(String s)
    {
        return string2Type(s);
    }

    public boolean hasNamespace(Declaration declaration, int i)
    {
        return (getNamespaceOf(declaration) & i) != 0;
    }

    public boolean hasSeparateFunctionNamespace()
    {
        return false;
    }

    public boolean isTrue(Object obj)
    {
        return obj != Boolean.FALSE;
    }

    public void loadClass(String s)
        throws ClassNotFoundException
    {
        Object obj;
        try
        {
            obj = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        try
        {
            obj = ((Class) (obj)).newInstance();
            ClassMemberLocation.defineAll(obj, this, Environment.getCurrent());
            if (obj instanceof ModuleBody)
            {
                ((ModuleBody)obj).run();
            }
            return;
        }
        catch (Exception exception)
        {
            throw new WrappedException((new StringBuilder()).append("cannot load ").append(s).toString(), exception);
        }
    }

    public Object lookup(String s)
    {
        return environ.get(s);
    }

    public NamedLocation lookupBuiltin(Symbol symbol, Object obj, int i)
    {
        if (environ == null)
        {
            return null;
        } else
        {
            return environ.lookup(symbol, obj, i);
        }
    }

    public Object noValue()
    {
        return Values.empty;
    }

    public final Compilation parse(InPort inport, SourceMessages sourcemessages, int i)
        throws IOException, SyntaxException
    {
        return parse(getLexer(inport, sourcemessages), i, ((ModuleInfo) (null)));
    }

    public final Compilation parse(InPort inport, SourceMessages sourcemessages, int i, ModuleInfo moduleinfo)
        throws IOException, SyntaxException
    {
        return parse(getLexer(inport, sourcemessages), i, moduleinfo);
    }

    public final Compilation parse(InPort inport, SourceMessages sourcemessages, ModuleInfo moduleinfo)
        throws IOException, SyntaxException
    {
        return parse(getLexer(inport, sourcemessages), 8, moduleinfo);
    }

    public final Compilation parse(Lexer lexer, int i, ModuleInfo moduleinfo)
        throws IOException, SyntaxException
    {
        SourceMessages sourcemessages = lexer.getMessages();
        Object obj;
        boolean flag;
        if ((i & 2) != 0)
        {
            obj = NameLookup.getInstance(getEnvironment(), this);
        } else
        {
            obj = new NameLookup(this);
        }
        if ((i & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = getCompilation(lexer, sourcemessages, ((NameLookup) (obj)));
        if (requirePedantic)
        {
            obj.pedantic = true;
        }
        if (!flag)
        {
            obj.mustCompile = true;
        }
        obj.immediate = flag;
        obj.langOptions = i;
        if ((i & 0x40) != 0)
        {
            obj.explicit = true;
        }
        if ((i & 8) != 0)
        {
            ((Compilation) (obj)).setState(1);
        }
        ((Compilation) (obj)).pushNewModule(lexer);
        if (moduleinfo != null)
        {
            moduleinfo.setCompilation(((Compilation) (obj)));
        }
        if (!parse(((Compilation) (obj)), i))
        {
            lexer = null;
        } else
        {
            lexer = ((Lexer) (obj));
            if (((Compilation) (obj)).getState() == 1)
            {
                ((Compilation) (obj)).setState(2);
                return ((Compilation) (obj));
            }
        }
        return lexer;
    }

    public abstract boolean parse(Compilation compilation, int i)
        throws IOException, SyntaxException;

    public void resolve(Compilation compilation)
    {
    }

    public void runAsApplication(String as[])
    {
        setDefaults(this);
        repl.main(as);
    }

    static 
    {
        Environment.setGlobal(BuiltinEnvironment.getInstance());
        String as[] = {
            "scheme", ".scm", ".sc", "kawa.standard.Scheme"
        };
        String as1[] = {
            "brl", ".brl", "gnu.kawa.brl.BRL"
        };
        String as2[] = {
            "xquery", ".xquery", ".xq", ".xql", "gnu.xquery.lang.XQuery"
        };
        String as3[] = {
            "xslt", "xsl", ".xsl", "gnu.kawa.xslt.XSLT"
        };
        languages = (new String[][] {
            as, new String[] {
                "krl", ".krl", "gnu.kawa.brl.BRL"
            }, as1, new String[] {
                "emacs", "elisp", "emacs-lisp", ".el", "gnu.jemacs.lang.ELisp"
            }, as2, new String[] {
                "q2", ".q2", "gnu.q2.lang.Q2"
            }, as3, new String[] {
                "commonlisp", "common-lisp", "clisp", "lisp", ".lisp", ".lsp", ".cl", "gnu.commonlisp.lang.CommonLisp"
            }
        });
    }
}
