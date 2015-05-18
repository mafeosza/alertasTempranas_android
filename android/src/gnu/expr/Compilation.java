// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.SwitchState;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.functions.Convert;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import gnu.text.Options;
import gnu.text.Path;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Stack;
import java.util.Vector;
import java.util.jar.JarOutputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kawa.Shell;

// Referenced classes of package gnu.expr:
//            ModuleExp, LambdaExp, Initializer, ClassExp, 
//            ApplyExp, QuoteExp, Expression, LitTable, 
//            Literal, CheckedTarget, Language, PairClassType, 
//            ModuleInfo, IgnoreTarget, ConsumerTarget, ConditionalTarget, 
//            StackTarget, Target, ScopeExp, Declaration, 
//            ModuleManager, TypeValue, ModuleMethod, LetExp, 
//            NameLookup, ReferenceExp, IfExp, BeginExp, 
//            FindCapturedVars, ErrorExp, InlineCalls, PushApply, 
//            ChainLambdas, FindTailCalls

public class Compilation
    implements SourceLocator
{

    public static final int BODY_PARSED = 4;
    public static final int CALL_WITH_CONSUMER = 2;
    public static final int CALL_WITH_CONTINUATIONS = 4;
    public static final int CALL_WITH_RETURN = 1;
    public static final int CALL_WITH_TAILCALLS = 3;
    public static final int CALL_WITH_UNSPECIFIED = 0;
    public static final int CLASS_WRITTEN = 14;
    public static final int COMPILED = 12;
    public static final int COMPILE_SETUP = 10;
    public static final int ERROR_SEEN = 100;
    public static final int MODULE_NONSTATIC = -1;
    public static final int MODULE_STATIC = 1;
    public static final int MODULE_STATIC_DEFAULT = 0;
    public static final int MODULE_STATIC_RUN = 2;
    public static final int PROLOG_PARSED = 2;
    public static final int PROLOG_PARSING = 1;
    public static final int RESOLVED = 6;
    public static final int WALKED = 8;
    public static Type apply0args[];
    public static Method apply0method;
    public static Type apply1args[];
    public static Method apply1method;
    public static Type apply2args[];
    public static Method apply2method;
    public static Method apply3method;
    public static Method apply4method;
    private static Type applyCpsArgs[];
    public static Method applyCpsMethod;
    public static Type applyNargs[];
    public static Method applyNmethod;
    public static Method applymethods[];
    public static Field argsCallContextField;
    private static Compilation chainUninitialized;
    static Method checkArgCountMethod;
    public static String classPrefixDefault = "";
    private static final ThreadLocal current = new InheritableThreadLocal();
    public static boolean debugPrintExpr = false;
    public static boolean debugPrintFinalExpr;
    public static int defaultCallConvention;
    public static int defaultClassFileVersion = 0x310000;
    public static boolean emitSourceDebugExtAttr = true;
    public static final Field falseConstant;
    public static boolean generateMainDefault = false;
    public static Method getCallContextInstanceMethod;
    public static Method getCurrentEnvironmentMethod;
    public static final Method getLocation1EnvironmentMethod;
    public static final Method getLocation2EnvironmentMethod;
    public static final Method getLocationMethod;
    public static final Method getProcedureBindingMethod;
    public static final Method getSymbolProcedureMethod;
    public static final Method getSymbolValueMethod;
    public static boolean inlineOk = true;
    public static final Type int1Args[];
    public static ClassType javaStringType;
    static Method makeListMethod;
    public static int moduleStatic = 0;
    public static Field noArgsField;
    public static final ArrayType objArrayType;
    public static Options options;
    public static Field pcCallContextField;
    public static Field procCallContextField;
    public static ClassType scmBooleanType;
    public static ClassType scmKeywordType = ClassType.make("gnu.expr.Keyword");
    public static ClassType scmListType;
    public static ClassType scmSequenceType = ClassType.make("gnu.lists.Sequence");
    static final Method setNameMethod;
    public static final Type string1Arg[];
    public static final Type sym1Arg[];
    public static final Field trueConstant;
    public static ClassType typeApplet = ClassType.make("java.applet.Applet");
    public static ClassType typeCallContext;
    public static ClassType typeClass;
    public static ClassType typeClassType = ClassType.make("gnu.bytecode.ClassType");
    public static final ClassType typeConsumer = ClassType.make("gnu.lists.Consumer");
    public static ClassType typeEnvironment;
    public static ClassType typeLanguage;
    public static ClassType typeLocation;
    public static ClassType typeMethodProc = ClassType.make("gnu.mapping.MethodProc");
    public static ClassType typeModuleBody = ClassType.make("gnu.expr.ModuleBody");
    public static ClassType typeModuleMethod = ClassType.make("gnu.expr.ModuleMethod");
    public static ClassType typeModuleWithContext = ClassType.make("gnu.expr.ModuleWithContext");
    public static ClassType typeObject;
    public static ClassType typeObjectType = ClassType.make("gnu.bytecode.ObjectType");
    public static ClassType typePair = ClassType.make("gnu.lists.Pair");
    public static ClassType typeProcedure;
    public static ClassType typeProcedure0;
    public static ClassType typeProcedure1;
    public static ClassType typeProcedure2;
    public static ClassType typeProcedure3;
    public static ClassType typeProcedure4;
    public static ClassType typeProcedureArray[];
    public static ClassType typeProcedureN = ClassType.make("gnu.mapping.ProcedureN");
    public static ClassType typeRunnable = ClassType.make("java.lang.Runnable");
    public static ClassType typeServlet = ClassType.make("gnu.kawa.servlet.KawaServlet");
    public static ClassType typeString;
    public static ClassType typeSymbol;
    public static ClassType typeType = ClassType.make("gnu.bytecode.Type");
    public static ClassType typeValues;
    public static gnu.text.Options.OptionInfo warnAsError;
    public static gnu.text.Options.OptionInfo warnInvokeUnknownMethod;
    public static gnu.text.Options.OptionInfo warnUndefinedVariable;
    public static gnu.text.Options.OptionInfo warnUnknownMember;
    Variable callContextVar;
    Variable callContextVarForInit;
    public String classPrefix;
    ClassType classes[];
    Initializer clinitChain;
    Method clinitMethod;
    public ClassType curClass;
    public LambdaExp curLambda;
    public Options currentOptions;
    protected ScopeExp current_scope;
    public boolean explicit;
    public Stack exprStack;
    Method forNameHelper;
    SwitchState fswitch;
    Field fswitchIndex;
    public boolean generateMain;
    public boolean immediate;
    private int keyUninitialized;
    int langOptions;
    protected Language language;
    public Lexer lexer;
    public NameLookup lexical;
    LitTable litTable;
    ArrayClassLoader loader;
    int localFieldIndex;
    public ClassType mainClass;
    public ModuleExp mainLambda;
    int maxSelectorValue;
    protected SourceMessages messages;
    public Method method;
    int method_counter;
    public ModuleInfo minfo;
    public ClassType moduleClass;
    Field moduleInstanceMainField;
    Variable moduleInstanceVar;
    public boolean mustCompile;
    private Compilation nextUninitialized;
    int numClasses;
    boolean pedantic;
    public Stack pendingImports;
    private int state;
    public Variable thisDecl;

    public Compilation(Language language1, SourceMessages sourcemessages, NameLookup namelookup)
    {
        mustCompile = ModuleExp.alwaysCompile;
        currentOptions = new Options(options);
        generateMain = generateMainDefault;
        classPrefix = classPrefixDefault;
        language = language1;
        messages = sourcemessages;
        lexical = namelookup;
    }

    private void checkLoop()
    {
        if (((LambdaExp)current_scope).getName() != "%do%loop")
        {
            throw new Error("internal error - bad loop state");
        } else
        {
            return;
        }
    }

    public static char demangle2(char c, char c1)
    {
        char c2 = '%';
        switch (c << 16 | c1)
        {
        default:
            c2 = '\uFFFF';
            // fall through

        case 5046371: 
        case 5242979: 
            return c2;

        case 4259949: 
            return '&';

        case 4259956: 
            return '@';

        case 4391020: 
            return ':';

        case 4391021: 
            return ',';

        case 4456561: 
            return '"';

        case 4456564: 
            return '.';

        case 4522097: 
            return '=';

        case 4522104: 
            return '!';

        case 4653170: 
            return '>';

        case 4980802: 
            return '[';

        case 4980803: 
            return '{';

        case 4980816: 
            return '(';

        case 4980851: 
            return '<';

        case 5046382: 
            return '-';

        case 5111917: 
            return '#';

        case 5242988: 
            return '+';

        case 5308533: 
            return '?';

        case 5374018: 
            return ']';

        case 5374019: 
            return '}';

        case 5374032: 
            return ')';

        case 5439555: 
            return ';';

        case 5439596: 
            return '/';

        case 5439601: 
            return '\\';

        case 5439604: 
            return '*';

        case 5505132: 
            return '~';

        case 5570672: 
            return '^';

        case 5636162: 
            return '|';
        }
    }

    public static String demangleName(String s)
    {
        return demangleName(s, false);
    }

    public static String demangleName(String s, boolean flag)
    {
        StringBuffer stringbuffer;
        boolean flag1;
        int i;
        boolean flag2;
        boolean flag6;
        int k;
        stringbuffer = new StringBuffer();
        k = s.length();
        flag1 = false;
        flag6 = false;
        flag2 = false;
        i = 0;
_L2:
        char c;
        boolean flag3;
label0:
        {
            if (i >= k)
            {
                break MISSING_BLOCK_LABEL_451;
            }
            char c1 = s.charAt(i);
            c = c1;
            flag3 = flag2;
            if (flag2)
            {
                c = c1;
                flag3 = flag2;
                if (!flag)
                {
                    c = Character.toLowerCase(c1);
                    flag3 = false;
                }
            }
            if (flag || c != 'i' || i != 0 || k <= 2 || s.charAt(i + 1) != 's')
            {
                break; /* Loop/switch isn't completed */
            }
            c1 = s.charAt(i + 2);
            if (Character.isLowerCase(c1))
            {
                break; /* Loop/switch isn't completed */
            }
            boolean flag4 = true;
            boolean flag7 = true;
            int j = i + 1;
            if (!Character.isUpperCase(c1))
            {
                flag2 = flag3;
                i = j;
                flag1 = flag4;
                flag6 = flag7;
                if (!Character.isTitleCase(c1))
                {
                    break label0;
                }
            }
            stringbuffer.append(Character.toLowerCase(c1));
            i = j + 1;
            flag6 = flag7;
            flag1 = flag4;
            flag2 = flag3;
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        char c2;
        boolean flag5;
label1:
        {
            if (c != '$' || i + 2 >= k)
            {
                break label1;
            }
            char c3 = s.charAt(i + 1);
            char c4 = s.charAt(i + 2);
            c2 = demangle2(c3, c4);
            if (c2 != '\uFFFF')
            {
                stringbuffer.append(c2);
                i += 2;
                flag1 = true;
                flag2 = true;
            } else
            {
                c2 = c;
                flag5 = flag1;
                if (c3 != 'T')
                {
                    break MISSING_BLOCK_LABEL_433;
                }
                c2 = c;
                flag5 = flag1;
                if (c4 != 'o')
                {
                    break MISSING_BLOCK_LABEL_433;
                }
                c2 = c;
                flag5 = flag1;
                if (i + 3 >= k)
                {
                    break MISSING_BLOCK_LABEL_433;
                }
                c2 = c;
                flag5 = flag1;
                if (s.charAt(i + 3) != '$')
                {
                    break MISSING_BLOCK_LABEL_433;
                }
                stringbuffer.append("->");
                i += 3;
                flag1 = true;
                flag2 = true;
            }
        }
          goto _L3
        c2 = c;
        flag5 = flag1;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        c2 = c;
        flag5 = flag1;
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        if (!Character.isUpperCase(c))
        {
            c2 = c;
            flag5 = flag1;
            if (!Character.isTitleCase(c))
            {
                break MISSING_BLOCK_LABEL_433;
            }
        }
        c2 = c;
        flag5 = flag1;
        if (Character.isLowerCase(s.charAt(i - 1)))
        {
            stringbuffer.append('-');
            flag5 = true;
            c2 = Character.toLowerCase(c);
        }
        stringbuffer.append(c2);
        flag2 = flag3;
        flag1 = flag5;
          goto _L3
        if (flag6)
        {
            stringbuffer.append('?');
        }
        if (flag1)
        {
            s = stringbuffer.toString();
        }
        return s;
    }

    private void dumpInitializers(Initializer initializer)
    {
        for (initializer = Initializer.reverse(initializer); initializer != null; initializer = initializer.next)
        {
            initializer.emit(this);
        }

    }

    public static Compilation findForImmediateLiterals(int i)
    {
        gnu/expr/Compilation;
        JVM INSTR monitorenter ;
        Object obj1 = null;
        Object obj = chainUninitialized;
_L2:
        Compilation compilation;
        compilation = ((Compilation) (obj)).nextUninitialized;
        if (((Compilation) (obj)).keyUninitialized != i)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        chainUninitialized = compilation;
_L1:
        obj.nextUninitialized = null;
        gnu/expr/Compilation;
        JVM INSTR monitorexit ;
        return ((Compilation) (obj));
        obj1.nextUninitialized = compilation;
          goto _L1
        obj;
        throw obj;
        obj1 = obj;
        obj = compilation;
          goto _L2
    }

    public static final Method getConstructor(ClassType classtype, LambdaExp lambdaexp)
    {
        Method method1 = classtype.getDeclaredMethod("<init>", 0);
        if (method1 != null)
        {
            return method1;
        }
        if ((lambdaexp instanceof ClassExp) && lambdaexp.staticLinkField != null)
        {
            Type atype[] = new Type[1];
            atype[0] = lambdaexp.staticLinkField.getType();
            lambdaexp = atype;
        } else
        {
            lambdaexp = apply0args;
        }
        return classtype.addMethod("<init>", 1, lambdaexp, Type.voidType);
    }

    public static Compilation getCurrent()
    {
        return (Compilation)current.get();
    }

    public static boolean isValidJavaName(String s)
    {
        int i = s.length();
        if (i == 0 || !Character.isJavaIdentifierStart(s.charAt(0)))
        {
            return false;
        }
        do
        {
            int j = i - 1;
            if (j > 0)
            {
                i = j;
                if (!Character.isJavaIdentifierPart(s.charAt(j)))
                {
                    return false;
                }
            } else
            {
                return true;
            }
        } while (true);
    }

    public static ApplyExp makeCoercion(Expression expression, Expression expression1)
    {
        return new ApplyExp(new QuoteExp(Convert.getInstance()), new Expression[] {
            expression1, expression
        });
    }

    public static Expression makeCoercion(Expression expression, Type type)
    {
        return makeCoercion(expression, ((Expression) (new QuoteExp(type))));
    }

    public static String mangleName(String s)
    {
        return mangleName(s, -1);
    }

    public static String mangleName(String s, int i)
    {
        String s1;
        boolean flag2;
        int l;
        if (i >= 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        l = s.length();
        if (l != 6 || !s.equals("*init*")) goto _L2; else goto _L1
_L1:
        s1 = "<init>";
_L37:
        return s1;
_L2:
        Object obj;
        int j;
        boolean flag1;
        obj = new StringBuffer(l);
        flag1 = false;
        j = 0;
_L4:
        char c;
        boolean flag;
        if (j >= l)
        {
            break MISSING_BLOCK_LABEL_1122;
        }
        char c3 = s.charAt(j);
        c = c3;
        flag = flag1;
        if (flag1)
        {
            c = Character.toTitleCase(c3);
            flag = false;
        }
        if (!Character.isDigit(c))
        {
            break; /* Loop/switch isn't completed */
        }
        if (j == 0)
        {
            ((StringBuffer) (obj)).append("$N");
        }
        ((StringBuffer) (obj)).append(c);
_L5:
        j++;
        flag1 = flag;
        if (true) goto _L4; else goto _L3
_L3:
        if (Character.isLetter(c) || c == '_')
        {
            ((StringBuffer) (obj)).append(c);
        } else
        {
label0:
            {
                if (c != '$')
                {
                    break label0;
                }
                if (i > 1)
                {
                    s1 = "$$";
                } else
                {
                    s1 = "$";
                }
                ((StringBuffer) (obj)).append(s1);
            }
        }
          goto _L5
        c;
        JVM INSTR lookupswitch 28: default 428
    //                   33: 1042
    //                   34: 910
    //                   35: 942
    //                   37: 750
    //                   38: 926
    //                   39: 894
    //                   40: 798
    //                   41: 814
    //                   42: 638
    //                   43: 527
    //                   44: 782
    //                   45: 543
    //                   46: 766
    //                   47: 654
    //                   58: 1058
    //                   59: 1074
    //                   60: 686
    //                   61: 670
    //                   62: 702
    //                   63: 958
    //                   64: 718
    //                   91: 830
    //                   93: 846
    //                   94: 1090
    //                   123: 862
    //                   124: 1106
    //                   125: 878
    //                   126: 734;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34
_L32:
        break MISSING_BLOCK_LABEL_1106;
_L6:
        int k;
        ((StringBuffer) (obj)).append('$');
        ((StringBuffer) (obj)).append(Character.forDigit(c >> 12 & 0xf, 16));
        ((StringBuffer) (obj)).append(Character.forDigit(c >> 8 & 0xf, 16));
        ((StringBuffer) (obj)).append(Character.forDigit(c >> 4 & 0xf, 16));
        ((StringBuffer) (obj)).append(Character.forDigit(c & 0xf, 16));
        k = j;
_L35:
        j = k;
        if (!flag2)
        {
            flag = true;
            j = k;
        }
          goto _L5
_L16:
        ((StringBuffer) (obj)).append("$Pl");
        k = j;
          goto _L35
_L18:
        if (flag2)
        {
            ((StringBuffer) (obj)).append("$Mn");
            k = j;
        } else
        {
            char c1;
            if (j + 1 < l)
            {
                c1 = s.charAt(j + 1);
            } else
            {
                c1 = '\0';
            }
            if (c1 == '>')
            {
                ((StringBuffer) (obj)).append("$To$");
                k = j + 1;
            } else
            {
                k = j;
                if (!Character.isLowerCase(c1))
                {
                    ((StringBuffer) (obj)).append("$Mn");
                    k = j;
                }
            }
        }
          goto _L35
_L15:
        ((StringBuffer) (obj)).append("$St");
        k = j;
          goto _L35
_L20:
        ((StringBuffer) (obj)).append("$Sl");
        k = j;
          goto _L35
_L24:
        ((StringBuffer) (obj)).append("$Eq");
        k = j;
          goto _L35
_L23:
        ((StringBuffer) (obj)).append("$Ls");
        k = j;
          goto _L35
_L25:
        ((StringBuffer) (obj)).append("$Gr");
        k = j;
          goto _L35
_L27:
        ((StringBuffer) (obj)).append("$At");
        k = j;
          goto _L35
_L34:
        ((StringBuffer) (obj)).append("$Tl");
        k = j;
          goto _L35
_L10:
        ((StringBuffer) (obj)).append("$Pc");
        k = j;
          goto _L35
_L19:
        ((StringBuffer) (obj)).append("$Dt");
        k = j;
          goto _L35
_L17:
        ((StringBuffer) (obj)).append("$Cm");
        k = j;
          goto _L35
_L13:
        ((StringBuffer) (obj)).append("$LP");
        k = j;
          goto _L35
_L14:
        ((StringBuffer) (obj)).append("$RP");
        k = j;
          goto _L35
_L28:
        ((StringBuffer) (obj)).append("$LB");
        k = j;
          goto _L35
_L29:
        ((StringBuffer) (obj)).append("$RB");
        k = j;
          goto _L35
_L31:
        ((StringBuffer) (obj)).append("$LC");
        k = j;
          goto _L35
_L33:
        ((StringBuffer) (obj)).append("$RC");
        k = j;
          goto _L35
_L12:
        ((StringBuffer) (obj)).append("$Sq");
        k = j;
          goto _L35
_L8:
        ((StringBuffer) (obj)).append("$Dq");
        k = j;
          goto _L35
_L11:
        ((StringBuffer) (obj)).append("$Am");
        k = j;
          goto _L35
_L9:
        ((StringBuffer) (obj)).append("$Nm");
        k = j;
          goto _L35
_L26:
        char c2;
        if (((StringBuffer) (obj)).length() > 0)
        {
            c2 = ((StringBuffer) (obj)).charAt(0);
        } else
        {
            c2 = '\0';
        }
        if (!flag2 && j + 1 == l && Character.isLowerCase(c2))
        {
            ((StringBuffer) (obj)).setCharAt(0, Character.toTitleCase(c2));
            ((StringBuffer) (obj)).insert(0, "is");
            k = j;
        } else
        {
            ((StringBuffer) (obj)).append("$Qu");
            k = j;
        }
          goto _L35
_L7:
        ((StringBuffer) (obj)).append("$Ex");
        k = j;
          goto _L35
_L21:
        ((StringBuffer) (obj)).append("$Cl");
        k = j;
          goto _L35
_L22:
        ((StringBuffer) (obj)).append("$SC");
        k = j;
          goto _L35
_L30:
        ((StringBuffer) (obj)).append("$Up");
        k = j;
          goto _L35
        ((StringBuffer) (obj)).append("$VB");
        k = j;
          goto _L35
        obj = ((StringBuffer) (obj)).toString();
        s1 = s;
        if (!((String) (obj)).equals(s))
        {
            return ((String) (obj));
        }
        if (true) goto _L37; else goto _L36
_L36:
    }

    public static String mangleName(String s, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        return mangleName(s, i);
    }

    public static String mangleNameIfNeeded(String s)
    {
        if (s == null || isValidJavaName(s))
        {
            return s;
        } else
        {
            return mangleName(s, 0);
        }
    }

    public static String mangleURI(String s)
    {
        String s1;
        StringBuffer stringbuffer;
        int i;
        int j;
        int k;
        int i1;
        boolean flag;
        int l1;
        if (s.indexOf('/') >= 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        k = s.length();
        if (k > 6 && s.startsWith("class:"))
        {
            return s.substring(6);
        }
        String s2;
        int l;
        if (k > 5 && s.charAt(4) == ':' && s.substring(0, 4).equalsIgnoreCase("http"))
        {
            s1 = s.substring(5);
            i = k - 5;
            l = 1;
        } else
        {
            l = j;
            i = k;
            s1 = s;
            if (k > 4)
            {
                l = j;
                i = k;
                s1 = s;
                if (s.charAt(3) == ':')
                {
                    l = j;
                    i = k;
                    s1 = s;
                    if (s.substring(0, 3).equalsIgnoreCase("uri"))
                    {
                        s1 = s.substring(4);
                        i = k - 4;
                        l = j;
                    }
                }
            }
        }
        i1 = 0;
        stringbuffer = new StringBuffer();
_L6:
        l1 = s1.indexOf('/', i1);
        if (l1 < 0)
        {
            j = i;
        } else
        {
            j = l1;
        }
        if (stringbuffer.length() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag || l == 0) goto _L2; else goto _L1
_L1:
        s2 = s1.substring(i1, j);
        s = s2;
        if (j - i1 > 4)
        {
            s = s2;
            if (s2.startsWith("www."))
            {
                s = s2.substring(4);
            }
        }
        putURLWords(s, stringbuffer);
        s = s1;
        k = i;
_L4:
        if (l1 < 0)
        {
            return stringbuffer.toString();
        }
        break; /* Loop/switch isn't completed */
_L2:
        int k1;
label0:
        {
            k = i;
            s = s1;
            if (i1 == j)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!flag)
            {
                stringbuffer.append('.');
            }
            k1 = j;
            k = i;
            s = s1;
            if (j != i)
            {
                break label0;
            }
            int i2 = s1.lastIndexOf('.', i);
            k1 = j;
            k = i;
            s = s1;
            if (i2 <= i1 + 1)
            {
                break label0;
            }
            k1 = j;
            k = i;
            s = s1;
            if (flag)
            {
                break label0;
            }
            int j1 = i - i2;
            if (j1 > 4)
            {
                k1 = j;
                k = i;
                s = s1;
                if (j1 != 5)
                {
                    break label0;
                }
                k1 = j;
                k = i;
                s = s1;
                if (!s1.endsWith("html"))
                {
                    break label0;
                }
            }
            k = i - j1;
            k1 = k;
            s = s1.substring(0, k);
        }
        stringbuffer.append(s.substring(i1, k1));
        if (true) goto _L4; else goto _L3
_L3:
        i1 = l1 + 1;
        i = k;
        s1 = s;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static void putURLWords(String s, StringBuffer stringbuffer)
    {
        int i = s.indexOf('.');
        String s1 = s;
        if (i > 0)
        {
            putURLWords(s.substring(i + 1), stringbuffer);
            stringbuffer.append('.');
            s1 = s.substring(0, i);
        }
        stringbuffer.append(s1);
    }

    private void registerClass(ClassType classtype)
    {
        ClassType classtype1;
        int i;
        if (classes == null)
        {
            classes = new ClassType[20];
        } else
        if (numClasses >= classes.length)
        {
            ClassType aclasstype[] = new ClassType[classes.length * 2];
            System.arraycopy(classes, 0, aclasstype, 0, numClasses);
            classes = aclasstype;
        }
        if (classtype.isInterface())
        {
            i = 1;
        } else
        {
            i = 33;
        }
        classtype.addModifiers(i);
        classtype1 = classtype;
        if (classtype == mainClass)
        {
            classtype1 = classtype;
            if (numClasses > 0)
            {
                classtype1 = classes[0];
                classes[0] = mainClass;
            }
        }
        classtype = classes;
        i = numClasses;
        numClasses = i + 1;
        classtype[i] = classtype1;
    }

    public static int registerForImmediateLiterals(Compilation compilation)
    {
        gnu/expr/Compilation;
        JVM INSTR monitorenter ;
        int i = 0;
        Compilation compilation1 = chainUninitialized;
_L2:
        int j;
        if (compilation1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i;
        if (i <= compilation1.keyUninitialized)
        {
            j = compilation1.keyUninitialized + 1;
        }
        compilation1 = compilation1.nextUninitialized;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        compilation.keyUninitialized = i;
        compilation.nextUninitialized = chainUninitialized;
        chainUninitialized = compilation;
        gnu/expr/Compilation;
        JVM INSTR monitorexit ;
        return i;
        compilation;
        throw compilation;
    }

    public static void restoreCurrent(Compilation compilation)
    {
        current.set(compilation);
    }

    public static void setCurrent(Compilation compilation)
    {
        current.set(compilation);
    }

    public static Compilation setSaveCurrent(Compilation compilation)
    {
        Compilation compilation1 = (Compilation)current.get();
        current.set(compilation);
        return compilation1;
    }

    public static void setupLiterals(int i)
    {
        Compilation compilation = findForImmediateLiterals(i);
        Literal literal;
        Class class1;
        try
        {
            class1 = compilation.loader.loadClass(compilation.mainClass.getName());
            literal = compilation.litTable.literalsChain;
        }
        catch (Throwable throwable)
        {
            throw new WrappedException("internal error", throwable);
        }
        if (literal == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        class1.getDeclaredField(literal.field.getName()).set(null, literal.value);
        literal = literal.next;
        break MISSING_BLOCK_LABEL_28;
        compilation.litTable = null;
        return;
    }

    private Method startClassInit()
    {
        method = curClass.addMethod("<clinit>", apply0args, Type.voidType, 9);
        CodeAttr codeattr = method.startCode();
        if (generateMain || generatingApplet() || generatingServlet())
        {
            Method method1 = ((ClassType)Type.make(getLanguage().getClass())).getDeclaredMethod("registerEnvironment", 0);
            if (method1 != null)
            {
                codeattr.emitInvokeStatic(method1);
            }
        }
        return method;
    }

    private void varArgsToArray(LambdaExp lambdaexp, int i, Variable variable, Type type, Variable variable1)
    {
        CodeAttr codeattr = getCode();
        Type type1 = ((ArrayType)type).getComponentType();
        boolean flag;
        if (!"java.lang.Object".equals(type1.getName()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (variable1 != null && !flag)
        {
            codeattr.emitLoad(variable1);
            codeattr.emitPushInt(i);
            codeattr.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsArray", 1));
            return;
        }
        if (i == 0 && !flag)
        {
            codeattr.emitLoad(codeattr.getArg(2));
            return;
        }
        codeattr.pushScope();
        type = variable;
        if (variable == null)
        {
            type = codeattr.addLocal(Type.intType);
            Label label;
            if (variable1 != null)
            {
                codeattr.emitLoad(variable1);
                codeattr.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
            } else
            {
                codeattr.emitLoad(codeattr.getArg(2));
                codeattr.emitArrayLength();
            }
            if (i != 0)
            {
                codeattr.emitPushInt(i);
                codeattr.emitSub(Type.intType);
            }
            codeattr.emitStore(type);
        }
        codeattr.emitLoad(type);
        codeattr.emitNewArray(type1.getImplementationType());
        variable = new Label(codeattr);
        label = new Label(codeattr);
        label.setTypes(codeattr);
        codeattr.emitGoto(variable);
        label.define(codeattr);
        codeattr.emitDup(1);
        codeattr.emitLoad(type);
        if (variable1 != null)
        {
            codeattr.emitLoad(variable1);
        } else
        {
            codeattr.emitLoad(codeattr.getArg(2));
        }
        codeattr.emitLoad(type);
        if (i != 0)
        {
            codeattr.emitPushInt(i);
            codeattr.emitAdd(Type.intType);
        }
        if (variable1 != null)
        {
            codeattr.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getArgAsObject", 1));
        } else
        {
            codeattr.emitArrayLoad(Type.objectType);
        }
        if (flag)
        {
            CheckedTarget.emitCheckedCoerce(this, lambdaexp, lambdaexp.getName(), 0, type1, null);
        }
        codeattr.emitArrayStore(type1);
        variable.define(codeattr);
        codeattr.emitInc(type, (short)-1);
        codeattr.emitLoad(type);
        codeattr.emitGotoIfIntGeZero(label);
        codeattr.popScope();
    }

    public void addClass(ClassType classtype)
    {
        if (mainLambda.filename != null)
        {
            if (emitSourceDebugExtAttr)
            {
                classtype.setStratum(getLanguage().getName());
            }
            classtype.setSourceFile(mainLambda.filename);
        }
        registerClass(classtype);
        classtype.setClassfileVersion(defaultClassFileVersion);
    }

    public void addMainClass(ModuleExp moduleexp)
    {
        mainClass = moduleexp.classFor(this);
        ClassType classtype2 = mainClass;
        ClassType aclasstype[] = moduleexp.getInterfaces();
        if (aclasstype != null)
        {
            classtype2.setInterfaces(aclasstype);
        }
        ClassType classtype1 = moduleexp.getSuperType();
        ClassType classtype = classtype1;
        if (classtype1 == null)
        {
            if (generatingApplet())
            {
                classtype = typeApplet;
            } else
            if (generatingServlet())
            {
                classtype = typeServlet;
            } else
            {
                classtype = getModuleType();
            }
        }
        if (makeRunnable())
        {
            classtype2.addInterface(typeRunnable);
        }
        classtype2.setSuper(classtype);
        moduleexp.type = classtype2;
        addClass(classtype2);
        getConstructor(mainClass, moduleexp);
    }

    public Field allocLocalField(Type type, String s)
    {
        String s1 = s;
        if (s == null)
        {
            s = (new StringBuilder()).append("tmp_");
            int i = localFieldIndex + 1;
            localFieldIndex = i;
            s1 = s.append(i).toString();
        }
        return curClass.addField(s1, type, 0);
    }

    void callInitMethods(ClassType classtype, Vector vector)
    {
        String s;
        if (classtype != null)
        {
            if (!"java.lang.Object".equals(s = classtype.getName()))
            {
                int i = vector.size();
                do
                {
                    int j = i - 1;
                    if (j < 0)
                    {
                        break;
                    }
                    i = j;
                    if (((ClassType)vector.elementAt(j)).getName() == s)
                    {
                        return;
                    }
                } while (true);
                vector.addElement(classtype);
                ClassType aclasstype[] = classtype.getInterfaces();
                if (aclasstype != null)
                {
                    int k = aclasstype.length;
                    for (i = 0; i < k; i++)
                    {
                        callInitMethods(aclasstype[i], vector);
                    }

                }
                i = 1;
                if (classtype.isInterface())
                {
                    if (classtype instanceof PairClassType)
                    {
                        classtype = ((PairClassType)classtype).instanceType;
                    } else
                    {
                        try
                        {
                            classtype = (ClassType)Type.make(Class.forName((new StringBuilder()).append(classtype.getName()).append("$class").toString()));
                        }
                        // Misplaced declaration of an exception variable
                        catch (ClassType classtype)
                        {
                            return;
                        }
                    }
                } else
                {
                    i = 0;
                }
                classtype = classtype.getDeclaredMethod("$finit$", i);
                if (classtype != null)
                {
                    vector = getCode();
                    vector.emitPushThis();
                    vector.emitInvoke(classtype);
                    return;
                }
            }
        }
    }

    public void cleanupAfterCompilation()
    {
        for (int i = 0; i < numClasses; i++)
        {
            classes[i].cleanupAfterCompilation();
        }

        classes = null;
        minfo.comp = null;
        if (minfo.exp != null)
        {
            minfo.exp.body = null;
        }
        mainLambda.body = null;
        mainLambda = null;
        if (!immediate)
        {
            litTable = null;
        }
    }

    public void compileConstant(Object obj)
    {
        CodeAttr codeattr = getCode();
        if (obj == null)
        {
            codeattr.emitPushNull();
            return;
        }
        if ((obj instanceof String) && !immediate)
        {
            codeattr.emitPushString((String)obj);
            return;
        } else
        {
            codeattr.emitGetStatic(compileConstantToField(obj));
            return;
        }
    }

    public void compileConstant(Object obj, Target target)
    {
        if (!(target instanceof IgnoreTarget)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!(obj instanceof Values))
        {
            break; /* Loop/switch isn't completed */
        }
        Object aobj[] = ((Values)obj).getValues();
        int j = aobj.length;
        if (!(target instanceof ConsumerTarget))
        {
            break; /* Loop/switch isn't completed */
        }
        int i = 0;
        while (i < j) 
        {
            compileConstant(aobj[i], target);
            i++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Object obj1;
        if (target instanceof ConditionalTarget)
        {
            ConditionalTarget conditionaltarget = (ConditionalTarget)target;
            target = getCode();
            if (getLanguage().isTrue(obj))
            {
                obj = conditionaltarget.ifTrue;
            } else
            {
                obj = conditionaltarget.ifFalse;
            }
            target.emitGoto(((Label) (obj)));
            return;
        }
        obj1 = obj;
        if (!(target instanceof StackTarget)) goto _L5; else goto _L4
_L4:
        Type type = ((StackTarget)target).getType();
        if (!(type instanceof PrimType)) goto _L7; else goto _L6
_L6:
        Object obj2;
        obj2 = type.getSignature();
        obj1 = getCode();
        if (obj2 == null) goto _L9; else goto _L8
_L8:
        if (((String) (obj2)).length() == 1) goto _L10; else goto _L9
_L23:
        if (!(obj instanceof Number)) goto _L12; else goto _L11
_L11:
        obj2 = (Number)obj;
        char c;
        c;
        JVM INSTR lookupswitch 6: default 524
    //                   66: 313
    //                   68: 343
    //                   70: 333
    //                   73: 293
    //                   74: 323
    //                   83: 303;
           goto _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L12:
        if (c != 'C') goto _L20; else goto _L19
_L19:
        try
        {
            ((CodeAttr) (obj1)).emitPushInt(((PrimType)type).charValue(obj));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
          goto _L7
_L10:
        c = ((String) (obj2)).charAt(0);
        continue; /* Loop/switch isn't completed */
_L16:
        ((CodeAttr) (obj1)).emitPushInt(((Number) (obj2)).intValue());
        return;
_L18:
        ((CodeAttr) (obj1)).emitPushInt(((Number) (obj2)).shortValue());
        return;
_L13:
        ((CodeAttr) (obj1)).emitPushInt(((Number) (obj2)).byteValue());
        return;
_L17:
        ((CodeAttr) (obj1)).emitPushLong(((Number) (obj2)).longValue());
        return;
_L15:
        ((CodeAttr) (obj1)).emitPushFloat(((Number) (obj2)).floatValue());
        return;
_L14:
        ((CodeAttr) (obj1)).emitPushDouble(((Number) (obj2)).doubleValue());
        return;
_L20:
        if (c != 'Z') goto _L7; else goto _L21
_L21:
        if (PrimType.booleanValue(obj))
        {
            c = '\001';
        } else
        {
            c = '\0';
        }
        ((CodeAttr) (obj1)).emitPushInt(c);
        return;
_L7:
        if (type == typeClass && (obj instanceof ClassType))
        {
            loadClassRef((ClassType)obj);
            return;
        }
        try
        {
            obj1 = type.coerceFromObject(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj1 = new StringBuffer();
            if (obj == Values.empty)
            {
                ((StringBuffer) (obj1)).append("cannot convert void to ");
            } else
            {
                ((StringBuffer) (obj1)).append("cannot convert literal (of type ");
                if (obj == null)
                {
                    ((StringBuffer) (obj1)).append("<null>");
                } else
                {
                    ((StringBuffer) (obj1)).append(obj.getClass().getName());
                }
                ((StringBuffer) (obj1)).append(") to ");
            }
            ((StringBuffer) (obj1)).append(type.getName());
            error('w', ((StringBuffer) (obj1)).toString());
            obj1 = obj;
        }
_L5:
        compileConstant(obj1);
        if (obj1 == null)
        {
            obj = target.getType();
        } else
        {
            obj = Type.make(obj1.getClass());
        }
        target.compileFromStack(this, ((Type) (obj)));
        return;
_L9:
        c = ' ';
        if (true) goto _L23; else goto _L22
_L22:
    }

    public Field compileConstantToField(Object obj)
    {
        obj = litTable.findLiteral(obj);
        if (((Literal) (obj)).field == null)
        {
            ((Literal) (obj)).assign(litTable);
        }
        return ((Literal) (obj)).field;
    }

    public void compileToArchive(ModuleExp moduleexp, String s)
        throws IOException
    {
        CRC32 crc32;
        int i;
        if (s.endsWith(".zip"))
        {
            i = 0;
        } else
        if (s.endsWith(".jar"))
        {
            i = 1;
        } else
        {
            s = (new StringBuilder()).append(s).append(".zip").toString();
            i = 0;
        }
        process(12);
        moduleexp = new File(s);
        if (moduleexp.exists())
        {
            moduleexp.delete();
        }
        if (i != 0)
        {
            moduleexp = new JarOutputStream(new FileOutputStream(moduleexp));
        } else
        {
            moduleexp = new ZipOutputStream(new FileOutputStream(moduleexp));
        }
        s = new byte[numClasses][];
        crc32 = new CRC32();
        for (i = 0; i < numClasses; i++)
        {
            Object obj = classes[i];
            s[i] = ((ClassType) (obj)).writeToArray();
            obj = new ZipEntry((new StringBuilder()).append(((ClassType) (obj)).getName().replace('.', '/')).append(".class").toString());
            ((ZipEntry) (obj)).setSize(s[i].length);
            crc32.reset();
            crc32.update(s[i], 0, s[i].length);
            ((ZipEntry) (obj)).setCrc(crc32.getValue());
            moduleexp.putNextEntry(((ZipEntry) (obj)));
            moduleexp.write(s[i]);
        }

        moduleexp.close();
    }

    public LambdaExp currentLambda()
    {
        return current_scope.currentLambda();
    }

    public ModuleExp currentModule()
    {
        return current_scope.currentModule();
    }

    public ScopeExp currentScope()
    {
        return current_scope;
    }

    public void error(char c, Declaration declaration, String s, String s1)
    {
        error(c, (new StringBuilder()).append(s).append(declaration.getName()).append(s1).toString(), null, declaration);
    }

    public void error(char c, String s)
    {
        char c1 = c;
        if (c == 'w')
        {
            c1 = c;
            if (warnAsError())
            {
                c1 = 'e';
            }
        }
        messages.error(c1, this, s);
    }

    public void error(char c, String s, SourceLocator sourcelocator)
    {
        int i;
        int j;
label0:
        {
            String s1 = sourcelocator.getFileName();
            int k = sourcelocator.getLineNumber();
            j = sourcelocator.getColumnNumber();
            if (s1 != null)
            {
                sourcelocator = s1;
                i = k;
                if (k > 0)
                {
                    break label0;
                }
            }
            sourcelocator = getFileName();
            i = getLineNumber();
            j = getColumnNumber();
        }
        char c1 = c;
        if (c == 'w')
        {
            c1 = c;
            if (warnAsError())
            {
                c1 = 'e';
            }
        }
        messages.error(c1, sourcelocator, i, j, s);
    }

    public void error(char c, String s, String s1, Declaration declaration)
    {
        char c1 = c;
        if (c == 'w')
        {
            c1 = c;
            if (warnAsError())
            {
                c1 = 'e';
            }
        }
        String s2 = getFileName();
        int i = getLineNumber();
        int j = getColumnNumber();
        int k = declaration.getLineNumber();
        if (k > 0)
        {
            s2 = declaration.getFileName();
            i = k;
            j = declaration.getColumnNumber();
        }
        messages.error(c1, s2, i, j, s, s1);
    }

    public ClassType findNamedClass(String s)
    {
        for (int i = 0; i < numClasses; i++)
        {
            if (s.equals(classes[i].getName()))
            {
                return classes[i];
            }
        }

        return null;
    }

    public void freeLocalField(Field field)
    {
    }

    public void generateApplyMethodsWithContext(LambdaExp lambdaexp)
    {
        int j;
        if (lambdaexp.applyMethods == null)
        {
            j = 0;
        } else
        {
            j = lambdaexp.applyMethods.size();
        }
        if (j == 0)
        {
            return;
        }
        ClassType classtype2 = curClass;
        curClass = lambdaexp.getHeapFrameType();
        if (!curClass.getSuperclass().isSubtype(typeModuleWithContext))
        {
            curClass = moduleClass;
        }
        ClassType classtype = typeModuleMethod;
        Method method1 = method;
        classtype = typeCallContext;
        ClassType classtype1 = curClass;
        PrimType primtype = Type.voidType;
        method = classtype1.addMethod("apply", new Type[] {
            classtype
        }, primtype, 1);
        CodeAttr codeattr = method.startCode();
        Variable variable1 = codeattr.getArg(1);
        codeattr.emitLoad(variable1);
        codeattr.emitGetField(pcCallContextField);
        SwitchState switchstate = codeattr.startSwitch();
        for (int k = 0; k < j; k++)
        {
            LambdaExp lambdaexp1 = (LambdaExp)lambdaexp.applyMethods.elementAt(k);
            Method amethod[] = lambdaexp1.primMethods;
            int l1 = amethod.length;
            for (int l = 0; l < l1; l++)
            {
                Declaration declaration;
                Variable variable;
                Declaration declaration1;
                SourceLocator sourcelocator;
                Method method2;
                Type atype[];
                int i;
                boolean flag;
                int i1;
                int j1;
                boolean flag1;
                int i2;
                if (l == l1 - 1 && (lambdaexp1.max_args < 0 || lambdaexp1.max_args >= lambdaexp1.min_args + l1))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                switchstate.addCase(lambdaexp1.getSelectorValue(this) + l, codeattr);
                sourcelocator = messages.swapSourceLocator(lambdaexp1);
                i = lambdaexp1.getLineNumber();
                if (i > 0)
                {
                    codeattr.putLineNumber(lambdaexp1.getFileName(), i);
                }
                method2 = amethod[l];
                atype = method2.getParameterTypes();
                i2 = lambdaexp1.min_args + l;
                declaration = null;
                j1 = 0;
                variable = declaration;
                if (l > 4)
                {
                    variable = declaration;
                    if (l1 > 1)
                    {
                        variable = codeattr.addLocal(Type.intType);
                        codeattr.emitLoad(variable1);
                        codeattr.emitInvoke(typeCallContext.getDeclaredMethod("getArgCount", 0));
                        if (lambdaexp1.min_args != 0)
                        {
                            codeattr.emitPushInt(lambdaexp1.min_args);
                            codeattr.emitSub(Type.intType);
                        }
                        codeattr.emitStore(variable);
                    }
                }
                if (method2.getStaticFlag())
                {
                    i = 0;
                } else
                {
                    i = 1;
                }
                if (flag)
                {
                    i1 = 2;
                } else
                {
                    i1 = 1;
                }
                if (i1 + i2 < atype.length)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (i + i1 > 0)
                {
                    codeattr.emitPushThis();
                    if (curClass == moduleClass && mainClass != moduleClass)
                    {
                        codeattr.emitGetField(moduleInstanceMainField);
                    }
                }
                declaration1 = lambdaexp1.firstDecl();
                declaration = declaration1;
                if (declaration1 != null)
                {
                    declaration = declaration1;
                    if (declaration1.isThisParameter())
                    {
                        declaration = declaration1.nextDecl();
                    }
                }
                flag1 = false;
                i = j1;
                j1 = ((flag1) ? 1 : 0);
                while (j1 < i2) 
                {
                    int k1 = i;
                    if (variable != null)
                    {
                        k1 = i;
                        if (j1 >= lambdaexp1.min_args)
                        {
                            codeattr.emitLoad(variable);
                            codeattr.emitIfIntLEqZero();
                            codeattr.emitLoad(variable1);
                            codeattr.emitInvoke(amethod[j1 - lambdaexp1.min_args]);
                            codeattr.emitElse();
                            k1 = i + 1;
                            codeattr.emitInc(variable, (short)-1);
                        }
                    }
                    codeattr.emitLoad(variable1);
                    Type type1;
                    if (j1 <= 4 && !flag && lambdaexp1.max_args <= 4)
                    {
                        codeattr.emitGetField(typeCallContext.getDeclaredField((new StringBuilder()).append("value").append(j1 + 1).toString()));
                    } else
                    {
                        codeattr.emitGetField(typeCallContext.getDeclaredField("values"));
                        codeattr.emitPushInt(j1);
                        codeattr.emitArrayLoad(Type.objectType);
                    }
                    type1 = declaration.getType();
                    if (type1 != Type.objectType)
                    {
                        SourceLocator sourcelocator1 = messages.swapSourceLocator(declaration);
                        CheckedTarget.emitCheckedCoerce(this, lambdaexp1, j1 + 1, type1);
                        messages.swapSourceLocator(sourcelocator1);
                    }
                    declaration = declaration.nextDecl();
                    j1++;
                    i = k1;
                }
                if (flag)
                {
                    Type type = atype[i1 + i2];
                    if (type instanceof ArrayType)
                    {
                        varArgsToArray(lambdaexp1, i2, variable, type, variable1);
                    } else
                    if ("gnu.lists.LList".equals(type.getName()))
                    {
                        codeattr.emitLoad(variable1);
                        codeattr.emitPushInt(i2);
                        codeattr.emitInvokeVirtual(typeCallContext.getDeclaredMethod("getRestArgsList", 1));
                    } else
                    if (type == typeCallContext)
                    {
                        codeattr.emitLoad(variable1);
                    } else
                    {
                        throw new RuntimeException((new StringBuilder()).append("unsupported #!rest type:").append(type).toString());
                    }
                }
                codeattr.emitLoad(variable1);
                codeattr.emitInvoke(method2);
                do
                {
                    i--;
                    if (i < 0)
                    {
                        break;
                    }
                    codeattr.emitFi();
                } while (true);
                if (defaultCallConvention < 2)
                {
                    Target.pushObject.compileFromStack(this, lambdaexp1.getReturnType());
                }
                messages.swapSourceLocator(sourcelocator);
                codeattr.emitReturn();
            }

        }

        switchstate.addDefault(codeattr);
        codeattr.emitInvokeStatic(typeModuleMethod.getDeclaredMethod("applyError", 0));
        codeattr.emitReturn();
        switchstate.finish(codeattr);
        method = method1;
        curClass = classtype2;
    }

    public void generateApplyMethodsWithoutContext(LambdaExp lambdaexp)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Type atype[];
        ClassType classtype;
        ClassType classtype1;
        Method method1;
        LambdaExp lambdaexp1;
        Method amethod[];
        int i;
        int j;
        int l;
        int j1;
        int j2;
        int k2;
        int l2;
        int l1;
        if (lambdaexp.applyMethods == null)
        {
            l1 = 0;
        } else
        {
            l1 = lambdaexp.applyMethods.size();
        }
        if (l1 == 0)
        {
            return;
        }
        classtype = curClass;
        curClass = lambdaexp.getHeapFrameType();
        classtype1 = typeModuleMethod;
        if (!curClass.getSuperclass().isSubtype(typeModuleBody))
        {
            curClass = moduleClass;
        }
        method1 = method;
        obj1 = null;
        int i2;
        if (defaultCallConvention >= 2)
        {
            i = 5;
        } else
        {
            i = 0;
        }
_L6:
        if (i >= 6)
        {
            break MISSING_BLOCK_LABEL_1276;
        }
        l = 0;
        obj2 = null;
        obj = null;
        atype = null;
        i2 = 0;
_L3:
        if (i2 >= l1)
        {
            break MISSING_BLOCK_LABEL_1160;
        }
        lambdaexp1 = (LambdaExp)lambdaexp.applyMethods.elementAt(i2);
        amethod = lambdaexp1.primMethods;
        k2 = amethod.length;
        if (lambdaexp1.max_args < 0 || lambdaexp1.max_args >= lambdaexp1.min_args + k2)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        l2 = 0;
        j2 = 0;
        if (i >= 5) goto _L2; else goto _L1
_L1:
label0:
        {
            l2 = i - lambdaexp1.min_args;
            if (l2 >= 0 && l2 < k2)
            {
                j1 = j2;
                if (l2 != k2 - 1)
                {
                    break label0;
                }
                j1 = j2;
                if (j == 0)
                {
                    break label0;
                }
            }
            j1 = 1;
        }
        k2 = 1;
        j2 = 0;
_L4:
        if (j1 != 0)
        {
            j = l;
        } else
        {
            j = l;
            Variable variable;
            SourceLocator sourcelocator;
            Method method2;
            Type atype1[];
            int k1;
            int i3;
            if (l == 0)
            {
                if (i < 5)
                {
                    obj1 = (new StringBuilder()).append("apply").append(i).toString();
                    obj2 = new Type[i + 1];
                    j = i;
                    do
                    {
                        atype = ((Type []) (obj2));
                        obj = obj1;
                        if (j <= 0)
                        {
                            break;
                        }
                        obj2[j] = typeObject;
                        j--;
                    } while (true);
                } else
                {
                    obj = "applyN";
                    atype = new Type[2];
                    atype[1] = objArrayType;
                }
                atype[0] = classtype1;
                obj2 = curClass;
                Declaration declaration;
                Object obj3;
                Type type1;
                SourceLocator sourcelocator1;
                if (defaultCallConvention >= 2)
                {
                    obj1 = Type.voidType;
                } else
                {
                    obj1 = Type.objectType;
                }
                method = ((ClassType) (obj2)).addMethod(((String) (obj)), atype, ((Type) (obj1)), 1);
                obj1 = method.startCode();
                ((CodeAttr) (obj1)).emitLoad(((CodeAttr) (obj1)).getArg(1));
                ((CodeAttr) (obj1)).emitGetField(classtype1.getField("selector"));
                obj2 = ((CodeAttr) (obj1)).startSwitch();
                j = 1;
            }
            ((SwitchState) (obj2)).addCase(lambdaexp1.getSelectorValue(this), ((CodeAttr) (obj1)));
            sourcelocator = messages.swapSourceLocator(lambdaexp1);
            l = lambdaexp1.getLineNumber();
            if (l > 0)
            {
                ((CodeAttr) (obj1)).putLineNumber(lambdaexp1.getFileName(), l);
            }
            method2 = amethod[l2];
            atype1 = method2.getParameterTypes();
            i3 = lambdaexp1.min_args + l2;
            declaration = null;
            l2 = 0;
            variable = declaration;
            if (i > 4)
            {
                variable = declaration;
                if (k2 > 1)
                {
                    variable = ((CodeAttr) (obj1)).addLocal(Type.intType);
                    ((CodeAttr) (obj1)).emitLoad(((CodeAttr) (obj1)).getArg(2));
                    ((CodeAttr) (obj1)).emitArrayLength();
                    if (lambdaexp1.min_args != 0)
                    {
                        ((CodeAttr) (obj1)).emitPushInt(lambdaexp1.min_args);
                        ((CodeAttr) (obj1)).emitSub(Type.intType);
                    }
                    ((CodeAttr) (obj1)).emitStore(variable);
                }
            }
            if (method2.getStaticFlag())
            {
                l = 0;
            } else
            {
                l = 1;
            }
            if (j2 != 0)
            {
                k1 = 1;
            } else
            {
                k1 = 0;
            }
            if (k1 + i3 < atype1.length)
            {
                k1 = 1;
            } else
            {
                k1 = 0;
            }
            if (l + k1 > 0)
            {
                ((CodeAttr) (obj1)).emitPushThis();
                if (curClass == moduleClass && mainClass != moduleClass)
                {
                    ((CodeAttr) (obj1)).emitGetField(moduleInstanceMainField);
                }
            }
            obj3 = lambdaexp1.firstDecl();
            declaration = ((Declaration) (obj3));
            if (obj3 != null)
            {
                declaration = ((Declaration) (obj3));
                if (((Declaration) (obj3)).isThisParameter())
                {
                    declaration = ((Declaration) (obj3)).nextDecl();
                }
            }
            k2 = 0;
            l = l2;
            while (k2 < i3) 
            {
                l2 = l;
                if (variable != null)
                {
                    l2 = l;
                    if (k2 >= lambdaexp1.min_args)
                    {
                        ((CodeAttr) (obj1)).emitLoad(variable);
                        ((CodeAttr) (obj1)).emitIfIntLEqZero();
                        ((CodeAttr) (obj1)).emitInvoke(amethod[k2 - lambdaexp1.min_args]);
                        ((CodeAttr) (obj1)).emitElse();
                        l2 = l + 1;
                        ((CodeAttr) (obj1)).emitInc(variable, (short)-1);
                    }
                }
                obj3 = null;
                if (i <= 4)
                {
                    obj3 = ((CodeAttr) (obj1)).getArg(k2 + 2);
                    ((CodeAttr) (obj1)).emitLoad(((Variable) (obj3)));
                } else
                {
                    ((CodeAttr) (obj1)).emitLoad(((CodeAttr) (obj1)).getArg(2));
                    ((CodeAttr) (obj1)).emitPushInt(k2);
                    ((CodeAttr) (obj1)).emitArrayLoad(Type.objectType);
                }
                type1 = declaration.getType();
                if (type1 != Type.objectType)
                {
                    sourcelocator1 = messages.swapSourceLocator(declaration);
                    CheckedTarget.emitCheckedCoerce(this, lambdaexp1, k2 + 1, type1, ((Variable) (obj3)));
                    messages.swapSourceLocator(sourcelocator1);
                }
                declaration = declaration.nextDecl();
                k2++;
                l = l2;
            }
            if (j2 != 0)
            {
                Type type = atype1[k1 + i3];
                if (type instanceof ArrayType)
                {
                    varArgsToArray(lambdaexp1, i3, variable, type, null);
                } else
                if ("gnu.lists.LList".equals(type.getName()))
                {
                    ((CodeAttr) (obj1)).emitLoad(((CodeAttr) (obj1)).getArg(2));
                    ((CodeAttr) (obj1)).emitPushInt(i3);
                    ((CodeAttr) (obj1)).emitInvokeStatic(makeListMethod);
                } else
                if (type == typeCallContext)
                {
                    ((CodeAttr) (obj1)).emitLoad(((CodeAttr) (obj1)).getArg(2));
                } else
                {
                    throw new RuntimeException((new StringBuilder()).append("unsupported #!rest type:").append(type).toString());
                }
            }
            ((CodeAttr) (obj1)).emitInvoke(method2);
            do
            {
                l--;
                if (l < 0)
                {
                    break;
                }
                ((CodeAttr) (obj1)).emitFi();
            } while (true);
            if (defaultCallConvention < 2)
            {
                Target.pushObject.compileFromStack(this, lambdaexp1.getReturnType());
            }
            messages.swapSourceLocator(sourcelocator);
            ((CodeAttr) (obj1)).emitReturn();
        }
        i2++;
        l = j;
        if (true) goto _L3; else goto _L2
_L2:
        j2 = 5 - lambdaexp1.min_args;
        j1 = l2;
        if (j2 > 0)
        {
            j1 = l2;
            if (k2 <= j2)
            {
                j1 = l2;
                if (j == 0)
                {
                    j1 = 1;
                }
            }
        }
        l2 = k2 - 1;
        j2 = j;
          goto _L4
        if (l != 0)
        {
            ((SwitchState) (obj2)).addDefault(((CodeAttr) (obj1)));
            if (defaultCallConvention >= 2)
            {
                ((CodeAttr) (obj1)).emitInvokeStatic(typeModuleMethod.getDeclaredMethod("applyError", 0));
            } else
            {
                int k;
                int i1;
                if (i > 4)
                {
                    k = 2;
                } else
                {
                    k = i + 1;
                }
                for (i1 = 0; i1 < k + 1; i1++)
                {
                    ((CodeAttr) (obj1)).emitLoad(((CodeAttr) (obj1)).getArg(i1));
                }

                ((CodeAttr) (obj1)).emitInvokeSpecial(typeModuleBody.getDeclaredMethod(((String) (obj)), atype));
            }
            ((CodeAttr) (obj1)).emitReturn();
            ((SwitchState) (obj2)).finish(((CodeAttr) (obj1)));
        }
        i++;
        continue; /* Loop/switch isn't completed */
        method = method1;
        curClass = classtype;
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    void generateBytecode()
    {
        Object obj;
        Object obj2;
        Object obj4;
        Object obj6;
        LambdaExp lambdaexp;
        Variable variable;
        Method method1;
        Variable variable1;
        CodeAttr codeattr1;
        boolean flag;
        obj6 = getModule();
        if (debugPrintFinalExpr)
        {
            OutPort outport = OutPort.errDefault();
            outport.println((new StringBuilder()).append("[Compiling final ").append(((ModuleExp) (obj6)).getName()).append(" to ").append(mainClass.getName()).append(":").toString());
            ((ModuleExp) (obj6)).print(outport);
            outport.println(']');
            outport.flush();
        }
        obj = getModuleType();
        Initializer initializer;
        int i;
        if (mainClass.getSuperclass().isSubtype(((Type) (obj))))
        {
            moduleClass = mainClass;
        } else
        {
            moduleClass = new ClassType(generateClassName("frame"));
            moduleClass.setSuper(((ClassType) (obj)));
            addClass(moduleClass);
            generateConstructor(moduleClass, null);
        }
        curClass = ((ModuleExp) (obj6)).type;
        lambdaexp = curLambda;
        curLambda = ((LambdaExp) (obj6));
        if (!((ModuleExp) (obj6)).isHandlingTailCalls()) goto _L2; else goto _L1
_L1:
        obj = new Type[1];
        obj[0] = typeCallContext;
_L4:
        variable = ((ModuleExp) (obj6)).heapFrame;
        flag = ((ModuleExp) (obj6)).isStatic();
        method = curClass.addMethod("run", ((Type []) (obj)), Type.voidType, 17);
        method.initCode();
        obj2 = getCode();
        int j;
        if (method.getStaticFlag())
        {
            obj = null;
        } else
        {
            obj = ((ModuleExp) (obj6)).declareThis(((ModuleExp) (obj6)).type);
        }
        thisDecl = ((Variable) (obj));
        obj6.closureEnv = ((ModuleExp) (obj6)).thisVariable;
        if (((ModuleExp) (obj6)).isStatic())
        {
            obj = null;
        } else
        {
            obj = ((ModuleExp) (obj6)).thisVariable;
        }
        obj6.heapFrame = ((Variable) (obj));
        ((ModuleExp) (obj6)).allocChildClasses(this);
        if (((ModuleExp) (obj6)).isHandlingTailCalls() || usingCPStyle())
        {
            callContextVar = new Variable("$ctx", typeCallContext);
            ((ModuleExp) (obj6)).getVarScope().addVariableAfter(thisDecl, callContextVar);
            callContextVar.setParameter(true);
        }
        i = ((ModuleExp) (obj6)).getLineNumber();
        if (i > 0)
        {
            ((CodeAttr) (obj2)).putLineNumber(((ModuleExp) (obj6)).getFileName(), i);
        }
        ((ModuleExp) (obj6)).allocParameters(this);
        ((ModuleExp) (obj6)).enterFunction(this);
        if (usingCPStyle())
        {
            loadCallContext();
            ((CodeAttr) (obj2)).emitGetField(pcCallContextField);
            fswitch = ((CodeAttr) (obj2)).startSwitch();
            fswitch.addCase(0, ((CodeAttr) (obj2)));
        }
        ((ModuleExp) (obj6)).compileBody(this);
        ((ModuleExp) (obj6)).compileEnd(this);
        obj2 = null;
        obj = null;
        obj4 = null;
        if (curClass != mainClass)
        {
            break MISSING_BLOCK_LABEL_1026;
        }
        method1 = method;
        variable1 = callContextVar;
        callContextVar = null;
        obj4 = startClassInit();
        clinitMethod = ((Method) (obj4));
        codeattr1 = getCode();
        obj2 = new Label(codeattr1);
        obj = new Label(codeattr1);
        codeattr1.fixupChain(((Label) (obj)), ((Label) (obj2)));
        if (flag)
        {
            generateConstructor(((LambdaExp) (obj6)));
            codeattr1.emitNew(moduleClass);
            codeattr1.emitDup(moduleClass);
            codeattr1.emitInvokeSpecial(moduleClass.constructor);
            moduleInstanceMainField = moduleClass.addField("$instance", moduleClass, 25);
            codeattr1.emitPutStatic(moduleInstanceMainField);
        }
        do
        {
            initializer = clinitChain;
            if (initializer == null)
            {
                break;
            }
            clinitChain = null;
            dumpInitializers(initializer);
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        if (((ModuleExp) (obj6)).min_args != ((ModuleExp) (obj6)).max_args || ((ModuleExp) (obj6)).min_args > 4)
        {
            obj = new Type[1];
            obj[0] = new ArrayType(typeObject);
        } else
        {
            j = ((ModuleExp) (obj6)).min_args;
            obj2 = new Type[j];
            do
            {
                j--;
                obj = obj2;
                if (j < 0)
                {
                    break;
                }
                obj2[j] = typeObject;
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (((ModuleExp) (obj6)).staticInitRun())
        {
            codeattr1.emitGetStatic(moduleInstanceMainField);
            codeattr1.emitInvoke(typeModuleBody.getDeclaredMethod("run", 0));
        }
        codeattr1.emitReturn();
        if (moduleClass != mainClass && !flag && !generateMain && !immediate)
        {
            method = curClass.addMethod("run", 1, Type.typeArray0, Type.voidType);
            CodeAttr codeattr2 = method.startCode();
            Variable variable2 = codeattr2.addLocal(typeCallContext);
            Variable variable3 = codeattr2.addLocal(typeConsumer);
            Variable variable4 = codeattr2.addLocal(Type.javalangThrowableType);
            codeattr2.emitInvokeStatic(getCallContextInstanceMethod);
            codeattr2.emitStore(variable2);
            Field field = typeCallContext.getDeclaredField("consumer");
            codeattr2.emitLoad(variable2);
            codeattr2.emitGetField(field);
            codeattr2.emitStore(variable3);
            codeattr2.emitLoad(variable2);
            codeattr2.emitGetStatic(ClassType.make("gnu.lists.VoidConsumer").getDeclaredField("instance"));
            codeattr2.emitPutField(field);
            codeattr2.emitTryStart(false, Type.voidType);
            codeattr2.emitPushThis();
            codeattr2.emitLoad(variable2);
            codeattr2.emitInvokeVirtual(method1);
            codeattr2.emitPushNull();
            codeattr2.emitStore(variable4);
            codeattr2.emitTryEnd();
            codeattr2.emitCatchStart(variable4);
            codeattr2.emitCatchEnd();
            codeattr2.emitTryCatchEnd();
            codeattr2.emitLoad(variable2);
            codeattr2.emitLoad(variable4);
            codeattr2.emitLoad(variable3);
            codeattr2.emitInvokeStatic(typeModuleBody.getDeclaredMethod("runCleanup", 3));
            codeattr2.emitReturn();
        }
        method = method1;
        callContextVar = variable1;
        ((ModuleExp) (obj6)).generateApplyMethods(this);
        curLambda = lambdaexp;
        obj6.heapFrame = variable;
        if (usingCPStyle())
        {
            obj6 = getCode();
            fswitch.finish(((CodeAttr) (obj6)));
        }
        if (obj2 == null && callContextVar == null) goto _L6; else goto _L5
_L5:
        method = ((Method) (obj4));
        obj4 = getCode();
        obj6 = new Label(((CodeAttr) (obj4)));
        ((CodeAttr) (obj4)).fixupChain(((Label) (obj2)), ((Label) (obj6)));
        if (callContextVarForInit != null)
        {
            ((CodeAttr) (obj4)).emitInvokeStatic(getCallContextInstanceMethod);
            ((CodeAttr) (obj4)).emitStore(callContextVarForInit);
        }
        if (!immediate) goto _L8; else goto _L7
_L7:
        ((CodeAttr) (obj4)).emitPushInt(registerForImmediateLiterals(this));
        ((CodeAttr) (obj4)).emitInvokeStatic(ClassType.make("gnu.expr.Compilation").getDeclaredMethod("setupLiterals", 1));
_L12:
        ((CodeAttr) (obj4)).fixupChain(((Label) (obj6)), ((Label) (obj)));
_L6:
        Object obj1;
        Object obj5;
        ModuleManager modulemanager;
        CodeAttr codeattr;
        int k;
        if (generateMain && curClass == mainClass)
        {
            obj1 = new ArrayType(javaStringType);
            Object obj3 = curClass;
            obj5 = Type.voidType;
            method = ((ClassType) (obj3)).addMethod("main", 9, new Type[] {
                obj1
            }, ((Type) (obj5)));
            obj1 = method.startCode();
            if (Shell.defaultFormatName != null)
            {
                ((CodeAttr) (obj1)).emitPushString(Shell.defaultFormatName);
                ((CodeAttr) (obj1)).emitInvokeStatic(ClassType.make("kawa.Shell").getDeclaredMethod("setDefaultFormat", 1));
            }
            ((CodeAttr) (obj1)).emitLoad(((CodeAttr) (obj1)).getArg(0));
            ((CodeAttr) (obj1)).emitInvokeStatic(ClassType.make("gnu.expr.ApplicationMainSupport").getDeclaredMethod("processArgs", 1));
            char c;
            Throwable throwable1;
            Object obj7;
            Method method2;
            String s1;
            ModuleInfo moduleinfo;
            int l;
            if (moduleInstanceMainField != null)
            {
                ((CodeAttr) (obj1)).emitGetStatic(moduleInstanceMainField);
            } else
            {
                ((CodeAttr) (obj1)).emitNew(curClass);
                ((CodeAttr) (obj1)).emitDup(curClass);
                ((CodeAttr) (obj1)).emitInvokeSpecial(curClass.constructor);
            }
            ((CodeAttr) (obj1)).emitInvokeVirtual(typeModuleBody.getDeclaredMethod("runAsMain", 0));
            ((CodeAttr) (obj1)).emitReturn();
        }
        if (minfo == null || minfo.getNamespaceUri() == null)
        {
            break MISSING_BLOCK_LABEL_1951;
        }
        modulemanager = ModuleManager.getInstance();
        obj1 = mainClass.getName();
        k = ((String) (obj1)).lastIndexOf('.');
        if (k < 0)
        {
            obj1 = "";
        } else
        {
            String s = ((String) (obj1)).substring(0, k);
            Throwable throwable;
            try
            {
                modulemanager.loadPackageInfo(s);
            }
            catch (ClassNotFoundException classnotfoundexception) { }
            // Misplaced declaration of an exception variable
            catch (Object obj5)
            {
                error('e', (new StringBuilder()).append("error loading map for ").append(s).append(" - ").append(obj5).toString());
            }
            obj1 = ((String) (obj1)).substring(0, k + 1);
        }
        obj3 = new ClassType((new StringBuilder()).append(((String) (obj1))).append("$ModulesMap$").toString());
        obj5 = ClassType.make("gnu.expr.ModuleSet");
        ((ClassType) (obj3)).setSuper(((ClassType) (obj5)));
        registerClass(((ClassType) (obj3)));
        method = ((ClassType) (obj3)).addMethod("<init>", 1, apply0args, Type.voidType);
        obj5 = ((ClassType) (obj5)).addMethod("<init>", 1, apply0args, Type.voidType);
        obj7 = method.startCode();
        ((CodeAttr) (obj7)).emitPushThis();
        ((CodeAttr) (obj7)).emitInvokeSpecial(((Method) (obj5)));
        ((CodeAttr) (obj7)).emitReturn();
        obj5 = ClassType.make("gnu.expr.ModuleManager");
        obj7 = Type.voidType;
        method = ((ClassType) (obj3)).addMethod("register", new Type[] {
            obj5
        }, ((Type) (obj7)), 1);
        codeattr = method.startCode();
        method2 = ((ClassType) (obj5)).getDeclaredMethod("register", 3);
        k = modulemanager.numModules;
        l = k - 1;
        if (l < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        moduleinfo = modulemanager.modules[l];
        obj3 = moduleinfo.getClassName();
        k = l;
        if (obj3 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        k = l;
        if (!((String) (obj3)).startsWith(((String) (obj1))))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj5 = moduleinfo.sourcePath;
        s1 = moduleinfo.getNamespaceUri();
        codeattr.emitLoad(codeattr.getArg(1));
        compileConstant(obj3);
        obj3 = obj5;
        if (Path.valueOf(obj5).isAbsolute())
        {
            break MISSING_BLOCK_LABEL_1746;
        }
        try
        {
            c = File.separatorChar;
            obj3 = modulemanager.getCompilationDirectory();
            obj7 = Path.toURL((new StringBuilder()).append(((String) (obj3))).append(((String) (obj1)).replace('.', c)).toString()).toString();
            k = ((String) (obj7)).length();
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            throw new WrappedException((new StringBuilder()).append("exception while fixing up '").append(((String) (obj5))).append('\'').toString(), throwable);
        }
        obj3 = obj7;
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_1736;
        }
        obj3 = obj7;
        if (((String) (obj7)).charAt(k - 1) != c)
        {
            obj3 = (new StringBuilder()).append(((String) (obj7))).append(c).toString();
        }
        obj3 = Path.relativize(moduleinfo.getSourceAbsPathname(), ((String) (obj3)));
        compileConstant(obj3);
        compileConstant(s1);
        codeattr.emitInvokeVirtual(method2);
        k = l;
        if (true) goto _L10; else goto _L9
_L10:
        break MISSING_BLOCK_LABEL_1552;
_L9:
        break; /* Loop/switch isn't completed */
_L8:
        try
        {
            litTable.emit();
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable1)
        {
            error('e', (new StringBuilder()).append("Literals: Internal error:").append(throwable1).toString());
        }
        if (true) goto _L12; else goto _L11
_L11:
        codeattr.emitReturn();
    }

    public String generateClassName(String s)
    {
        String s1 = mangleName(s, true);
        if (mainClass == null) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder()).append(mainClass.getName()).append('$').append(s1).toString();
_L4:
        if (findNamedClass(s) == null)
        {
            return s;
        }
        break; /* Loop/switch isn't completed */
_L2:
        s = s1;
        if (classPrefix != null)
        {
            s = (new StringBuilder()).append(classPrefix).append(s1).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
        int i = 0;
        do
        {
            String s2 = (new StringBuilder()).append(s).append(i).toString();
            if (findNamedClass(s2) == null)
            {
                return s2;
            }
            i++;
        } while (true);
    }

    public final void generateConstructor(ClassType classtype, LambdaExp lambdaexp)
    {
        Method method1 = method;
        Variable variable = callContextVar;
        callContextVar = null;
        ClassType classtype1 = curClass;
        curClass = classtype;
        Object obj = getConstructor(classtype, lambdaexp);
        classtype.constructor = ((Method) (obj));
        method = ((Method) (obj));
        obj = ((Method) (obj)).startCode();
        if ((lambdaexp instanceof ClassExp) && lambdaexp.staticLinkField != null)
        {
            ((CodeAttr) (obj)).emitPushThis();
            ((CodeAttr) (obj)).emitLoad(((CodeAttr) (obj)).getCurrentScope().getVariable(1));
            ((CodeAttr) (obj)).emitPutField(lambdaexp.staticLinkField);
        }
        ClassExp.invokeDefaultSuperConstructor(classtype.getSuperclass(), this, lambdaexp);
        if (curClass == mainClass && minfo != null && minfo.sourcePath != null)
        {
            ((CodeAttr) (obj)).emitPushThis();
            ((CodeAttr) (obj)).emitInvokeStatic(ClassType.make("gnu.expr.ModuleInfo").getDeclaredMethod("register", 1));
        }
        if (lambdaexp != null && lambdaexp.initChain != null)
        {
            classtype = curLambda;
            curLambda = new LambdaExp();
            curLambda.closureEnv = ((CodeAttr) (obj)).getArg(0);
            curLambda.outer = classtype;
            do
            {
                Initializer initializer = lambdaexp.initChain;
                if (initializer == null)
                {
                    break;
                }
                lambdaexp.initChain = null;
                dumpInitializers(initializer);
            } while (true);
            curLambda = classtype;
        }
        if (lambdaexp instanceof ClassExp)
        {
            callInitMethods(((ClassExp)lambdaexp).getCompiledClassType(this), new Vector(10));
        }
        ((CodeAttr) (obj)).emitReturn();
        method = method1;
        curClass = classtype1;
        callContextVar = variable;
    }

    public final void generateConstructor(LambdaExp lambdaexp)
    {
        generateConstructor(lambdaexp.getHeapFrameType(), lambdaexp);
    }

    public void generateMatchMethods(LambdaExp lambdaexp)
    {
        int i;
        if (lambdaexp.applyMethods == null)
        {
            i = 0;
        } else
        {
            i = lambdaexp.applyMethods.size();
        }
        if (i == 0)
        {
            return;
        }
        Method method1 = method;
        ClassType classtype = curClass;
        ClassType classtype1 = typeModuleMethod;
        curClass = lambdaexp.getHeapFrameType();
        if (!curClass.getSuperclass().isSubtype(typeModuleBody))
        {
            curClass = moduleClass;
        }
        CodeAttr codeattr = null;
        for (int j = 0; j <= 5; j++)
        {
            int l = 0;
            SwitchState switchstate = null;
            String s = null;
            Type atype[] = null;
            int k = i;
            do
            {
                int j1 = k - 1;
                if (j1 < 0)
                {
                    break;
                }
                LambdaExp lambdaexp1 = (LambdaExp)lambdaexp.applyMethods.elementAt(j1);
                int l1 = lambdaexp1.primMethods.length;
                int i1;
                if (lambdaexp1.max_args < 0 || lambdaexp1.max_args >= lambdaexp1.min_args + l1)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (j < 5)
                {
                    int k1 = j - lambdaexp1.min_args;
                    k = j1;
                    if (k1 < 0)
                    {
                        continue;
                    }
                    k = j1;
                    if (k1 >= l1)
                    {
                        continue;
                    }
                    if (k1 == l1 - 1)
                    {
                        k = j1;
                        if (i1 != 0)
                        {
                            continue;
                        }
                    }
                    k = k1;
                } else
                {
                    k = 5 - lambdaexp1.min_args;
                    if (k > 0 && l1 <= k)
                    {
                        k = j1;
                        if (i1 == 0)
                        {
                            continue;
                        }
                    }
                    k = l1 - 1;
                }
                i1 = l;
                Variable variable;
                if (l == 0)
                {
                    Declaration declaration;
                    Label label;
                    Label label1;
                    ConditionalTarget conditionaltarget;
                    if (j < 5)
                    {
                        s = (new StringBuilder()).append("match").append(j).toString();
                        atype = new Type[j + 2];
                        for (l = j; l >= 0; l--)
                        {
                            atype[l + 1] = typeObject;
                        }

                        atype[j + 1] = typeCallContext;
                    } else
                    {
                        s = "matchN";
                        atype = new Type[3];
                        atype[1] = objArrayType;
                        atype[2] = typeCallContext;
                    }
                    atype[0] = classtype1;
                    method = curClass.addMethod(s, atype, Type.intType, 1);
                    codeattr = method.startCode();
                    codeattr.emitLoad(codeattr.getArg(1));
                    codeattr.emitGetField(classtype1.getField("selector"));
                    switchstate = codeattr.startSwitch();
                    i1 = 1;
                }
                switchstate.addCase(lambdaexp1.getSelectorValue(this), codeattr);
                l = lambdaexp1.getLineNumber();
                if (l > 0)
                {
                    codeattr.putLineNumber(lambdaexp1.getFileName(), l);
                }
                if (j == 5)
                {
                    l = 3;
                } else
                {
                    l = j + 2;
                }
                variable = codeattr.getArg(l);
                if (j < 5)
                {
                    declaration = lambdaexp1.firstDecl();
                    l = 1;
                    do
                    {
                        if (l > j)
                        {
                            break;
                        }
                        codeattr.emitLoad(variable);
                        codeattr.emitLoad(codeattr.getArg(l + 1));
                        Type type = declaration.getType();
                        if (type != Type.objectType)
                        {
                            if (type instanceof TypeValue)
                            {
                                label = new Label(codeattr);
                                label1 = new Label(codeattr);
                                conditionaltarget = new ConditionalTarget(label, label1, getLanguage());
                                codeattr.emitDup();
                                ((TypeValue)type).emitIsInstance(null, this, conditionaltarget);
                                label1.define(codeattr);
                                codeattr.emitPushInt(0xfff40000 | l);
                                codeattr.emitReturn();
                                label.define(codeattr);
                            } else
                            if ((type instanceof ClassType) && type != Type.objectType && type != Type.toStringType)
                            {
                                codeattr.emitDup();
                                type.emitIsInstance(codeattr);
                                codeattr.emitIfIntEqZero();
                                codeattr.emitPushInt(0xfff40000 | l);
                                codeattr.emitReturn();
                                codeattr.emitFi();
                            }
                        }
                        codeattr.emitPutField(typeCallContext.getField((new StringBuilder()).append("value").append(l).toString()));
                        declaration = declaration.nextDecl();
                        l++;
                    } while (true);
                } else
                {
                    codeattr.emitLoad(variable);
                    codeattr.emitLoad(codeattr.getArg(2));
                    codeattr.emitPutField(typeCallContext.getField("values"));
                }
                codeattr.emitLoad(variable);
                if (defaultCallConvention < 2)
                {
                    codeattr.emitLoad(codeattr.getArg(1));
                } else
                {
                    codeattr.emitLoad(codeattr.getArg(0));
                }
                codeattr.emitPutField(procCallContextField);
                codeattr.emitLoad(variable);
                if (defaultCallConvention >= 2)
                {
                    codeattr.emitPushInt(lambdaexp1.getSelectorValue(this) + k);
                } else
                {
                    codeattr.emitPushInt(j);
                }
                codeattr.emitPutField(pcCallContextField);
                codeattr.emitPushInt(0);
                codeattr.emitReturn();
                k = j1;
                l = i1;
            } while (true);
            if (l == 0)
            {
                continue;
            }
            switchstate.addDefault(codeattr);
            if (j > 4)
            {
                k = 2;
            } else
            {
                k = j + 1;
            }
            for (l = 0; l <= k + 1; l++)
            {
                codeattr.emitLoad(codeattr.getArg(l));
            }

            codeattr.emitInvokeSpecial(typeModuleBody.getDeclaredMethod(s, atype.length));
            codeattr.emitReturn();
            switchstate.finish(codeattr);
        }

        method = method1;
        curClass = classtype;
    }

    public boolean generatingApplet()
    {
        return (langOptions & 0x10) != 0;
    }

    public boolean generatingServlet()
    {
        return (langOptions & 0x20) != 0;
    }

    public final boolean getBooleanOption(String s)
    {
        return currentOptions.getBoolean(s);
    }

    public final boolean getBooleanOption(String s, boolean flag)
    {
        return currentOptions.getBoolean(s, flag);
    }

    public final CodeAttr getCode()
    {
        return method.getCode();
    }

    public final int getColumnNumber()
    {
        return messages.getColumnNumber();
    }

    public final Method getConstructor(LambdaExp lambdaexp)
    {
        return getConstructor(lambdaexp.getHeapFrameType(), lambdaexp);
    }

    public final String getFileName()
    {
        return messages.getFileName();
    }

    public Method getForNameHelper()
    {
        if (forNameHelper == null)
        {
            Method method1 = method;
            method = curClass.addMethod("class$", 9, string1Arg, typeClass);
            forNameHelper = method;
            CodeAttr codeattr = method.startCode();
            codeattr.emitLoad(codeattr.getArg(0));
            codeattr.emitPushInt(0);
            codeattr.emitPushString(mainClass.getName());
            codeattr.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 1));
            codeattr.emitInvokeVirtual(typeClass.getDeclaredMethod("getClassLoader", 0));
            codeattr.emitInvokeStatic(typeClass.getDeclaredMethod("forName", 3));
            codeattr.emitReturn();
            method = method1;
        }
        return forNameHelper;
    }

    public Language getLanguage()
    {
        return language;
    }

    public final int getLineNumber()
    {
        return messages.getLineNumber();
    }

    public SourceMessages getMessages()
    {
        return messages;
    }

    public final ModuleExp getModule()
    {
        return mainLambda;
    }

    public final ClassType getModuleType()
    {
        if (defaultCallConvention >= 2)
        {
            return typeModuleWithContext;
        } else
        {
            return typeModuleBody;
        }
    }

    public String getPublicId()
    {
        return messages.getPublicId();
    }

    public int getState()
    {
        return state;
    }

    public String getSystemId()
    {
        return messages.getSystemId();
    }

    public boolean inlineOk(Expression expression)
    {
        if (expression instanceof LambdaExp)
        {
            expression = (LambdaExp)expression;
            Declaration declaration = ((LambdaExp) (expression)).nameDecl;
            if (declaration == null || declaration.getSymbol() == null || !(declaration.context instanceof ModuleExp))
            {
                return true;
            }
            if (immediate && declaration.isPublic() && !expression.getFlag(2048) && (curLambda == null || expression.topLevel() != curLambda.topLevel()))
            {
                return false;
            }
        }
        return inlineOk;
    }

    public boolean inlineOk(Procedure procedure)
    {
        if (immediate && (procedure instanceof ModuleMethod) && (((ModuleMethod)procedure).module.getClass().getClassLoader() instanceof ArrayClassLoader))
        {
            return false;
        } else
        {
            return inlineOk;
        }
    }

    public boolean isPedantic()
    {
        return pedantic;
    }

    public boolean isStableSourceLocation()
    {
        return false;
    }

    public boolean isStatic()
    {
        return mainLambda.isStatic();
    }

    public LetExp letDone(Expression expression)
    {
        LetExp letexp = (LetExp)current_scope;
        letexp.body = expression;
        pop(letexp);
        return letexp;
    }

    public void letEnter()
    {
        LetExp letexp = (LetExp)current_scope;
        Expression aexpression[] = new Expression[letexp.countDecls()];
        Declaration declaration = letexp.firstDecl();
        for (int i = 0; declaration != null; i++)
        {
            aexpression[i] = declaration.getValue();
            declaration = declaration.nextDecl();
        }

        letexp.inits = aexpression;
        lexical.push(letexp);
    }

    public void letStart()
    {
        pushScope(new LetExp(null));
    }

    public Declaration letVariable(Object obj, Type type, Expression expression)
    {
        obj = ((LetExp)current_scope).addDeclaration(obj, type);
        ((Declaration) (obj)).noteValue(expression);
        return ((Declaration) (obj));
    }

    public final void loadCallContext()
    {
        CodeAttr codeattr = getCode();
        if (callContextVar != null && !callContextVar.dead())
        {
            codeattr.emitLoad(callContextVar);
            return;
        }
        if (method == clinitMethod)
        {
            callContextVar = new Variable("$ctx", typeCallContext);
            callContextVar.reserveLocal(codeattr.getMaxLocals(), codeattr);
            codeattr.emitLoad(callContextVar);
            callContextVarForInit = callContextVar;
            return;
        } else
        {
            codeattr.emitInvokeStatic(getCallContextInstanceMethod);
            codeattr.emitDup();
            callContextVar = new Variable("$ctx", typeCallContext);
            codeattr.getCurrentScope().addVariable(codeattr, callContextVar);
            codeattr.emitStore(callContextVar);
            return;
        }
    }

    public void loadClassRef(ObjectType objecttype)
    {
        CodeAttr codeattr = getCode();
        if (curClass.getClassfileVersion() >= 0x310000)
        {
            codeattr.emitPushClass(objecttype);
            return;
        }
        if (objecttype == mainClass && mainLambda.isStatic() && moduleInstanceMainField != null)
        {
            codeattr.emitGetStatic(moduleInstanceMainField);
            codeattr.emitInvokeVirtual(Type.objectType.getDeclaredMethod("getClass", 0));
            return;
        }
        if (objecttype instanceof ClassType)
        {
            objecttype = objecttype.getName();
        } else
        {
            objecttype = objecttype.getInternalName().replace('/', '.');
        }
        codeattr.emitPushString(objecttype);
        codeattr.emitInvokeStatic(getForNameHelper());
    }

    public Declaration lookup(Object obj, int i)
    {
        return lexical.lookup(obj, i);
    }

    public void loopBody(Expression expression)
    {
        ((LambdaExp)current_scope).body = expression;
    }

    public void loopCond(Expression expression)
    {
        checkLoop();
        exprStack.push(expression);
    }

    public void loopEnter()
    {
        checkLoop();
        LambdaExp lambdaexp = (LambdaExp)current_scope;
        int i = lambdaexp.min_args;
        lambdaexp.max_args = i;
        Expression aexpression[] = new Expression[i];
        do
        {
            i--;
            if (i >= 0)
            {
                aexpression[i] = (Expression)exprStack.pop();
            } else
            {
                LetExp letexp = (LetExp)lambdaexp.outer;
                letexp.setBody(new ApplyExp(new ReferenceExp(letexp.firstDecl()), aexpression));
                lexical.push(lambdaexp);
                return;
            }
        } while (true);
    }

    public Expression loopRepeat()
    {
        return loopRepeat(Expression.noExpressions);
    }

    public Expression loopRepeat(Expression expression)
    {
        return loopRepeat(new Expression[] {
            expression
        });
    }

    public Expression loopRepeat(Expression aexpression[])
    {
        LambdaExp lambdaexp = (LambdaExp)current_scope;
        ScopeExp scopeexp = lambdaexp.outer;
        Declaration declaration = scopeexp.firstDecl();
        Expression expression = (Expression)exprStack.pop();
        aexpression = new ApplyExp(new ReferenceExp(declaration), aexpression);
        lambdaexp.body = new IfExp(expression, new BeginExp(lambdaexp.body, aexpression), QuoteExp.voidExp);
        lexical.pop(lambdaexp);
        current_scope = scopeexp.outer;
        return scopeexp;
    }

    public void loopStart()
    {
        LambdaExp lambdaexp = new LambdaExp();
        LetExp letexp = new LetExp(new Expression[] {
            lambdaexp
        });
        letexp.addDeclaration("%do%loop").noteValue(lambdaexp);
        lambdaexp.setName("%do%loop");
        letexp.outer = current_scope;
        lambdaexp.outer = letexp;
        current_scope = lambdaexp;
    }

    public Declaration loopVariable(Object obj, Type type, Expression expression)
    {
        checkLoop();
        LambdaExp lambdaexp = (LambdaExp)current_scope;
        obj = lambdaexp.addDeclaration(obj, type);
        if (exprStack == null)
        {
            exprStack = new Stack();
        }
        exprStack.push(expression);
        lambdaexp.min_args = lambdaexp.min_args + 1;
        return ((Declaration) (obj));
    }

    public boolean makeRunnable()
    {
        return !generatingServlet() && !generatingApplet() && !getModule().staticInitRun();
    }

    public void mustCompileHere()
    {
        if (!mustCompile && !ModuleExp.compilerAvailable)
        {
            error('w', "this expression claimed that it must be compiled, but compiler is unavailable");
            return;
        } else
        {
            mustCompile = true;
            return;
        }
    }

    public void outputClass(String s)
        throws IOException
    {
        char c = File.separatorChar;
        for (int i = 0; i < numClasses; i++)
        {
            ClassType classtype = classes[i];
            String s1 = (new StringBuilder()).append(s).append(classtype.getName().replace('.', c)).append(".class").toString();
            String s2 = (new File(s1)).getParent();
            if (s2 != null)
            {
                (new File(s2)).mkdirs();
            }
            classtype.writeToFile(s1);
        }

        minfo.cleanupAfterCompilation();
    }

    public Expression parse(Object obj)
    {
        throw new Error("unimeplemented parse");
    }

    public final void pop()
    {
        pop(current_scope);
    }

    public void pop(ScopeExp scopeexp)
    {
        lexical.pop(scopeexp);
        current_scope = scopeexp.outer;
    }

    public void process(int i)
    {
        Compilation compilation;
        byte byte1;
        byte byte2;
        byte byte3;
        byte byte4;
        byte2 = 10;
        byte3 = 8;
        byte4 = 6;
        byte1 = 100;
        compilation = setSaveCurrent(this);
        ModuleExp moduleexp = getModule();
        if (i < 4)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if (getState() >= 3)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        setState(3);
        language.parse(this, 0);
        lexer.close();
        lexer = null;
        Stack stack;
        byte byte0;
        if (messages.seenErrors())
        {
            byte0 = 100;
        } else
        {
            byte0 = 4;
        }
        setState(byte0);
        stack = pendingImports;
        if (stack != null)
        {
            restoreCurrent(compilation);
            return;
        }
        if (i < 6)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        if (getState() >= 6)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        addMainClass(moduleexp);
        language.resolve(this);
        byte0 = byte4;
        if (messages.seenErrors())
        {
            byte0 = 100;
        }
        setState(byte0);
        if (!explicit && !immediate && minfo.checkCurrent(ModuleManager.getInstance(), System.currentTimeMillis()))
        {
            minfo.cleanupAfterCompilation();
            setState(14);
        }
        if (i < 8)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        if (getState() >= 8)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        walkModule(moduleexp);
        byte0 = byte3;
        if (messages.seenErrors())
        {
            byte0 = 100;
        }
        setState(byte0);
        if (i < 10)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        if (getState() >= 10)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        litTable = new LitTable(this);
        moduleexp.setCanRead(true);
        FindCapturedVars.findCapturedVars(moduleexp, this);
        moduleexp.allocFields(this);
        moduleexp.allocChildMethods(this);
        byte0 = byte2;
        if (messages.seenErrors())
        {
            byte0 = 100;
        }
        setState(byte0);
        if (i < 12)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        if (getState() >= 12)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        if (immediate)
        {
            loader = new ArrayClassLoader(ObjectType.getContextClassLoader());
        }
        generateBytecode();
        if (messages.seenErrors())
        {
            byte0 = byte1;
        } else
        {
            byte0 = 12;
        }
        setState(byte0);
        if (i < 14)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        if (getState() < 14)
        {
            outputClass(ModuleManager.getInstance().getCompilationDirectory());
            setState(14);
        }
        restoreCurrent(compilation);
        return;
        Object obj;
        obj;
        setState(100);
        if (((SyntaxException) (obj)).getMessages() != getMessages())
        {
            throw new RuntimeException((new StringBuilder()).append("confussing syntax error: ").append(obj).toString());
        }
        break MISSING_BLOCK_LABEL_474;
        obj;
        restoreCurrent(compilation);
        throw obj;
        restoreCurrent(compilation);
        return;
        obj;
        ((IOException) (obj)).printStackTrace();
        error('f', (new StringBuilder()).append("caught ").append(obj).toString());
        setState(100);
        restoreCurrent(compilation);
        return;
    }

    public void push(Declaration declaration)
    {
        lexical.push(declaration);
    }

    public void push(ScopeExp scopeexp)
    {
        pushScope(scopeexp);
        lexical.push(scopeexp);
    }

    void pushChain(ScopeExp scopeexp, ScopeExp scopeexp1)
    {
        if (scopeexp != scopeexp1)
        {
            pushChain(scopeexp.outer, scopeexp1);
            pushScope(scopeexp);
            lexical.push(scopeexp);
        }
    }

    public ModuleExp pushNewModule(Lexer lexer1)
    {
        lexer = lexer1;
        return pushNewModule(lexer1.getName());
    }

    public ModuleExp pushNewModule(String s)
    {
        ModuleExp moduleexp = new ModuleExp();
        if (s != null)
        {
            moduleexp.setFile(s);
        }
        if (generatingApplet() || generatingServlet())
        {
            moduleexp.setFlag(0x20000);
        }
        if (immediate)
        {
            moduleexp.setFlag(0x100000);
            (new ModuleInfo()).setCompilation(this);
        }
        mainLambda = moduleexp;
        push(moduleexp);
        return moduleexp;
    }

    public void pushPendingImport(ModuleInfo moduleinfo, ScopeExp scopeexp, int i)
    {
        if (pendingImports == null)
        {
            pendingImports = new Stack();
        }
        pendingImports.push(moduleinfo);
        pendingImports.push(scopeexp);
        moduleinfo = new ReferenceExp((Object)null);
        moduleinfo.setLine(this);
        pendingImports.push(moduleinfo);
        pendingImports.push(Integer.valueOf(i));
    }

    public final void pushScope(ScopeExp scopeexp)
    {
        if (!mustCompile && (scopeexp.mustCompile() || ModuleExp.compilerAvailable && (scopeexp instanceof LambdaExp) && !(scopeexp instanceof ModuleExp)))
        {
            mustCompileHere();
        }
        scopeexp.outer = current_scope;
        current_scope = scopeexp;
    }

    public Object resolve(Object obj, boolean flag)
    {
        Environment environment = Environment.getCurrent();
        if (obj instanceof String)
        {
            obj = environment.defaultNamespace().lookup((String)obj);
        } else
        {
            obj = (Symbol)obj;
        }
        if (obj == null)
        {
            return null;
        }
        if (flag && getLanguage().hasSeparateFunctionNamespace())
        {
            return environment.getFunction(((Symbol) (obj)), null);
        } else
        {
            return environment.get(((gnu.mapping.EnvironmentKey) (obj)), null);
        }
    }

    public void setColumn(int i)
    {
        messages.setColumn(i);
    }

    public void setCurrentScope(ScopeExp scopeexp)
    {
        int j = ScopeExp.nesting(scopeexp);
        int i;
        for (i = ScopeExp.nesting(current_scope); i > j; i--)
        {
            pop(current_scope);
        }

        ScopeExp scopeexp1 = scopeexp;
        ScopeExp scopeexp2;
        do
        {
            scopeexp2 = scopeexp1;
            if (j <= i)
            {
                break;
            }
            scopeexp1 = scopeexp1.outer;
            j--;
        } while (true);
        for (; scopeexp2 != current_scope; scopeexp2 = scopeexp2.outer)
        {
            pop(current_scope);
        }

        pushChain(scopeexp, scopeexp2);
    }

    public void setFile(String s)
    {
        messages.setFile(s);
    }

    public void setLine(int i)
    {
        messages.setLine(i);
    }

    public final void setLine(Expression expression)
    {
        messages.setLocation(expression);
    }

    public void setLine(Object obj)
    {
        if (obj instanceof SourceLocator)
        {
            messages.setLocation((SourceLocator)obj);
        }
    }

    public void setLine(String s, int i, int j)
    {
        messages.setLine(s, i, j);
    }

    public final void setLocation(SourceLocator sourcelocator)
    {
        messages.setLocation(sourcelocator);
    }

    public void setMessages(SourceMessages sourcemessages)
    {
        messages = sourcemessages;
    }

    public void setModule(ModuleExp moduleexp)
    {
        mainLambda = moduleexp;
    }

    public void setSharedModuleDefs(boolean flag)
    {
        if (flag)
        {
            langOptions = langOptions | 2;
            return;
        } else
        {
            langOptions = langOptions & -3;
            return;
        }
    }

    public void setState(int i)
    {
        state = i;
    }

    public boolean sharedModuleDefs()
    {
        return (langOptions & 2) != 0;
    }

    public Expression syntaxError(String s)
    {
        error('e', s);
        return new ErrorExp(s);
    }

    public String toString()
    {
        return (new StringBuilder()).append("<compilation ").append(mainLambda).append(">").toString();
    }

    public void usedClass(Type type)
    {
        for (; type instanceof ArrayType; type = ((ArrayType)type).getComponentType()) { }
        if (immediate && (type instanceof ClassType))
        {
            loader.addClass((ClassType)type);
        }
    }

    public boolean usingCPStyle()
    {
        return defaultCallConvention == 4;
    }

    public boolean usingTailCalls()
    {
        return defaultCallConvention >= 3;
    }

    public void walkModule(ModuleExp moduleexp)
    {
        if (debugPrintExpr)
        {
            OutPort outport = OutPort.errDefault();
            outport.println((new StringBuilder()).append("[Module:").append(moduleexp.getName()).toString());
            moduleexp.print(outport);
            outport.println(']');
            outport.flush();
        }
        InlineCalls.inlineCalls(moduleexp, this);
        PushApply.pushApply(moduleexp);
        ChainLambdas.chainLambdas(moduleexp, this);
        FindTailCalls.findTailCalls(moduleexp, this);
    }

    public boolean warnAsError()
    {
        return currentOptions.getBoolean(warnAsError);
    }

    public boolean warnInvokeUnknownMethod()
    {
        return currentOptions.getBoolean(warnInvokeUnknownMethod);
    }

    public boolean warnUndefinedVariable()
    {
        return currentOptions.getBoolean(warnUndefinedVariable);
    }

    public boolean warnUnknownMember()
    {
        return currentOptions.getBoolean(warnUnknownMember);
    }

    static 
    {
        options = new Options();
        warnUndefinedVariable = options.add("warn-undefined-variable", 1, Boolean.TRUE, "warn if no compiler-visible binding for a variable");
        warnUnknownMember = options.add("warn-unknown-member", 1, Boolean.TRUE, "warn if referencing an unknown method or field");
        warnInvokeUnknownMethod = options.add("warn-invoke-unknown-method", 1, warnUnknownMember, "warn if invoke calls an unknown method (subsumed by warn-unknown-member)");
        warnAsError = options.add("warn-as-error", 1, Boolean.FALSE, "Make all warnings into errors");
        typeObject = Type.objectType;
        scmBooleanType = ClassType.make("java.lang.Boolean");
        typeString = ClassType.make("java.lang.String");
        javaStringType = typeString;
        scmListType = ClassType.make("gnu.lists.LList");
        objArrayType = ArrayType.make(typeObject);
        typeClass = Type.javalangClassType;
        typeProcedure = ClassType.make("gnu.mapping.Procedure");
        typeLanguage = ClassType.make("gnu.expr.Language");
        typeEnvironment = ClassType.make("gnu.mapping.Environment");
        typeLocation = ClassType.make("gnu.mapping.Location");
        typeSymbol = ClassType.make("gnu.mapping.Symbol");
        getSymbolValueMethod = typeLanguage.getDeclaredMethod("getSymbolValue", 1);
        getSymbolProcedureMethod = typeLanguage.getDeclaredMethod("getSymbolProcedure", 1);
        getLocationMethod = typeLocation.addMethod("get", Type.typeArray0, Type.objectType, 1);
        getProcedureBindingMethod = typeSymbol.addMethod("getProcedure", Type.typeArray0, typeProcedure, 1);
        trueConstant = scmBooleanType.getDeclaredField("TRUE");
        falseConstant = scmBooleanType.getDeclaredField("FALSE");
        setNameMethod = typeProcedure.getDeclaredMethod("setName", 1);
        int1Args = (new Type[] {
            Type.intType
        });
        string1Arg = (new Type[] {
            javaStringType
        });
        sym1Arg = string1Arg;
        getLocation1EnvironmentMethod = typeEnvironment.getDeclaredMethod("getLocation", 1);
        Object obj = typeSymbol;
        Object obj1 = Type.objectType;
        ClassType classtype = typeEnvironment;
        Object obj2 = typeLocation;
        getLocation2EnvironmentMethod = classtype.addMethod("getLocation", new Type[] {
            obj, obj1
        }, ((Type) (obj2)), 17);
        obj = objArrayType;
        obj1 = Type.intType;
        classtype = scmListType;
        obj2 = scmListType;
        makeListMethod = classtype.addMethod("makeList", new Type[] {
            obj, obj1
        }, ((Type) (obj2)), 9);
        getCurrentEnvironmentMethod = typeEnvironment.addMethod("getCurrent", Type.typeArray0, typeEnvironment, 9);
        apply0args = Type.typeArray0;
        apply1args = (new Type[] {
            typeObject
        });
        apply2args = (new Type[] {
            typeObject, typeObject
        });
        applyNargs = (new Type[] {
            objArrayType
        });
        apply0method = typeProcedure.addMethod("apply0", apply0args, typeObject, 17);
        apply1method = typeProcedure.addMethod("apply1", apply1args, typeObject, 1);
        apply2method = typeProcedure.addMethod("apply2", apply2args, typeObject, 1);
        obj = typeObject;
        obj1 = typeObject;
        classtype = typeObject;
        obj2 = typeProcedure;
        ClassType classtype1 = typeObject;
        apply3method = ((ClassType) (obj2)).addMethod("apply3", new Type[] {
            obj, obj1, classtype
        }, classtype1, 1);
        obj = typeObject;
        obj1 = typeObject;
        classtype = typeObject;
        obj2 = typeObject;
        classtype1 = typeProcedure;
        ClassType classtype2 = typeObject;
        apply4method = classtype1.addMethod("apply4", new Type[] {
            obj, obj1, classtype, obj2
        }, classtype2, 1);
        applyNmethod = typeProcedure.addMethod("applyN", applyNargs, typeObject, 1);
        obj = typeProcedure;
        obj1 = Type.intType;
        classtype = typeProcedure;
        obj2 = Type.voidType;
        checkArgCountMethod = classtype.addMethod("checkArgCount", new Type[] {
            obj, obj1
        }, ((Type) (obj2)), 9);
        applymethods = (new Method[] {
            apply0method, apply1method, apply2method, apply3method, apply4method, applyNmethod
        });
        typeProcedure0 = ClassType.make("gnu.mapping.Procedure0");
        typeProcedure1 = ClassType.make("gnu.mapping.Procedure1");
        typeProcedure2 = ClassType.make("gnu.mapping.Procedure2");
        typeProcedure3 = ClassType.make("gnu.mapping.Procedure3");
        typeProcedure4 = ClassType.make("gnu.mapping.Procedure4");
        typeCallContext = ClassType.make("gnu.mapping.CallContext");
        getCallContextInstanceMethod = typeCallContext.getDeclaredMethod("getInstance", 0);
        typeValues = ClassType.make("gnu.mapping.Values");
        noArgsField = typeValues.getDeclaredField("noArgs");
        pcCallContextField = typeCallContext.getDeclaredField("pc");
        argsCallContextField = typeCallContext.getDeclaredField("values");
        procCallContextField = typeCallContext.getDeclaredField("proc");
        applyCpsArgs = (new Type[] {
            typeCallContext
        });
        applyCpsMethod = typeProcedure.addMethod("apply", applyCpsArgs, Type.voidType, 1);
        typeProcedureArray = (new ClassType[] {
            typeProcedure0, typeProcedure1, typeProcedure2, typeProcedure3, typeProcedure4
        });
    }
}
