// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.Namespace;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.SourceLocator;

// Referenced classes of package gnu.expr:
//            QuoteExp, ReferenceExp, PrimProcedure, Compilation, 
//            ScopeExp, Expression, LambdaExp, ModuleExp, 
//            ThisExp, IgnoreTarget, AccessExp, FluidLetExp, 
//            Target, Language, ClassExp, LitTable, 
//            Literal, BindingInitializer, TypeValue, ApplyExp

public class Declaration
    implements SourceLocator
{

    static final int CAN_CALL = 4;
    static final int CAN_READ = 2;
    static final int CAN_WRITE = 8;
    public static final long CLASS_ACCESS_FLAGS = 0x603000000L;
    public static final int EARLY_INIT = 0x20000000;
    public static final long ENUM_ACCESS = 0x200000000L;
    public static final int EXPORT_SPECIFIED = 1024;
    public static final int EXTERNAL_ACCESS = 0x80000;
    public static final long FIELD_ACCESS_FLAGS = 0x78f000000L;
    public static final int FIELD_OR_METHOD = 0x100000;
    public static final long FINAL_ACCESS = 0x400000000L;
    static final int INDIRECT_BINDING = 1;
    public static final int IS_ALIAS = 256;
    public static final int IS_CONSTANT = 16384;
    public static final int IS_DYNAMIC = 0x10000000;
    static final int IS_FLUID = 16;
    public static final int IS_IMPORTED = 0x20000;
    public static final int IS_NAMESPACE_PREFIX = 0x200000;
    static final int IS_SIMPLE = 64;
    public static final int IS_SINGLE_VALUE = 0x40000;
    public static final int IS_SYNTAX = 32768;
    public static final int IS_UNKNOWN = 0x10000;
    public static final long METHOD_ACCESS_FLAGS = 0x40f000000L;
    public static final int MODULE_REFERENCE = 0x40000000;
    public static final int NONSTATIC_SPECIFIED = 4096;
    public static final int NOT_DEFINING = 512;
    public static final int PACKAGE_ACCESS = 0x8000000;
    static final int PRIVATE = 32;
    public static final int PRIVATE_ACCESS = 0x1000000;
    public static final String PRIVATE_PREFIX = "$Prvt$";
    public static final int PRIVATE_SPECIFIED = 0x1000000;
    static final int PROCEDURE = 128;
    public static final int PROTECTED_ACCESS = 0x2000000;
    public static final int PUBLIC_ACCESS = 0x4000000;
    public static final int STATIC_SPECIFIED = 2048;
    public static final long TRANSIENT_ACCESS = 0x100000000L;
    public static final int TYPE_SPECIFIED = 8192;
    static final String UNKNOWN_PREFIX = "loc$";
    public static final long VOLATILE_ACCESS = 0x80000000L;
    static int counter;
    public Declaration base;
    public ScopeExp context;
    int evalIndex;
    public Field field;
    String filename;
    public ApplyExp firstCall;
    protected long flags;
    protected int id;
    Method makeLocationMethod;
    Declaration next;
    Declaration nextCapturedVar;
    int position;
    Object symbol;
    protected Type type;
    protected Expression typeExp;
    protected Expression value;
    Variable var;

    protected Declaration()
    {
        int i = counter + 1;
        counter = i;
        id = i;
        value = QuoteExp.undefined_exp;
        flags = 64L;
        makeLocationMethod = null;
    }

    public Declaration(Variable variable)
    {
        this(variable.getName(), variable.getType());
        var = variable;
    }

    public Declaration(Object obj)
    {
        int i = counter + 1;
        counter = i;
        id = i;
        value = QuoteExp.undefined_exp;
        flags = 64L;
        makeLocationMethod = null;
        setName(obj);
    }

    public Declaration(Object obj, Field field1)
    {
        this(obj, field1.getType());
        field = field1;
        setSimple(false);
    }

    public Declaration(Object obj, Type type1)
    {
        int i = counter + 1;
        counter = i;
        id = i;
        value = QuoteExp.undefined_exp;
        flags = 64L;
        makeLocationMethod = null;
        setName(obj);
        setType(type1);
    }

    public static Declaration followAliases(Declaration declaration)
    {
_L6:
        if (declaration == null || !declaration.isAlias()) goto _L2; else goto _L1
_L1:
        Object obj = declaration.getValue();
        if (obj instanceof ReferenceExp) goto _L3; else goto _L2
_L2:
        return declaration;
_L3:
        if ((obj = ((ReferenceExp)obj).binding) == null) goto _L2; else goto _L4
_L4:
        declaration = ((Declaration) (obj));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Declaration getDeclaration(Named named)
    {
        return getDeclaration(named, named.getName());
    }

    public static Declaration getDeclaration(Object obj, String s)
    {
        Object obj1 = null;
        Field field1 = obj1;
        if (s != null)
        {
            Class class1 = PrimProcedure.getProcedureClass(obj);
            field1 = obj1;
            if (class1 != null)
            {
                field1 = ((ClassType)Type.make(class1)).getDeclaredField(Compilation.mangleNameIfNeeded(s));
            }
        }
        if (field1 != null)
        {
            int i = field1.getModifiers();
            if ((i & 8) != 0)
            {
                s = new Declaration(s, field1);
                s.noteValue(new QuoteExp(obj));
                if ((i & 0x10) != 0)
                {
                    s.setFlag(16384L);
                }
                return s;
            }
        }
        return null;
    }

    public static Declaration getDeclarationFromStatic(String s, String s1)
    {
        s = new Declaration(s1, ClassType.make(s).getDeclaredField(s1));
        s.setFlag(18432L);
        return s;
    }

    public static Declaration getDeclarationValueFromStatic(String s, String s1, String s2)
    {
        try
        {
            Object obj = Class.forName(s).getDeclaredField(s1).get(null);
            s = new Declaration(s2, ClassType.make(s).getDeclaredField(s1));
            s.noteValue(new QuoteExp(obj));
            s.setFlag(18432L);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new WrappedException(s);
        }
        return s;
    }

    public static final boolean isUnknown(Declaration declaration)
    {
        return declaration == null || declaration.getFlag(0x10000L);
    }

    public final Variable allocateVariable(CodeAttr codeattr)
    {
        if (!isSimple() || var == null)
        {
            String s = null;
            if (symbol != null)
            {
                s = Compilation.mangleNameIfNeeded(getName());
            }
            if (isAlias() && (getValue() instanceof ReferenceExp))
            {
                codeattr = followAliases(this);
                if (codeattr == null)
                {
                    codeattr = null;
                } else
                {
                    codeattr = ((Declaration) (codeattr)).var;
                }
                var = codeattr;
            } else
            {
                Object obj;
                if (isIndirectBinding())
                {
                    obj = Compilation.typeLocation;
                } else
                {
                    obj = getType().getImplementationType();
                }
                var = context.getVarScope().addVariable(codeattr, ((Type) (obj)), s);
            }
        }
        return var;
    }

    public void compileStore(Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        if (isSimple())
        {
            codeattr.emitStore(getVariable());
            return;
        }
        if (!field.getStaticFlag())
        {
            loadOwningObject(null, compilation);
            codeattr.emitSwap();
            codeattr.emitPutField(field);
            return;
        } else
        {
            codeattr.emitPutStatic(field);
            return;
        }
    }

    public short getAccessFlags(short word0)
    {
        if (getFlag(0xf000000L))
        {
            word0 = 0;
            if (getFlag(0x1000000L))
            {
                word0 = (short)2;
            }
            short word1 = word0;
            if (getFlag(0x2000000L))
            {
                word1 = (short)(word0 | 4);
            }
            word0 = word1;
            if (getFlag(0x4000000L))
            {
                word0 = (short)(word1 | 1);
            }
        }
        short word2 = word0;
        if (getFlag(0x80000000L))
        {
            word2 = (short)(word0 | 0x40);
        }
        word0 = word2;
        if (getFlag(0x100000000L))
        {
            word0 = (short)(word2 | 0x80);
        }
        word2 = word0;
        if (getFlag(0x200000000L))
        {
            word2 = (short)(word0 | 0x4000);
        }
        word0 = word2;
        if (getFlag(0x400000000L))
        {
            word0 = (short)(word2 | 0x10);
        }
        return word0;
    }

    public final boolean getCanCall()
    {
        return (flags & 4L) != 0L;
    }

    public final boolean getCanRead()
    {
        return (flags & 2L) != 0L;
    }

    public final boolean getCanWrite()
    {
        return (flags & 8L) != 0L;
    }

    public int getCode()
    {
        return id;
    }

    public final int getColumnNumber()
    {
        int j = position & 0xfff;
        int i = j;
        if (j == 0)
        {
            i = -1;
        }
        return i;
    }

    public final Object getConstantValue()
    {
        Expression expression = getValue();
        if (!(expression instanceof QuoteExp) || expression == QuoteExp.undefined_exp)
        {
            return null;
        } else
        {
            return ((QuoteExp)expression).getValue();
        }
    }

    public final ScopeExp getContext()
    {
        return context;
    }

    public final String getFileName()
    {
        return filename;
    }

    public final boolean getFlag(long l)
    {
        return (flags & l) != 0L;
    }

    public final int getLineNumber()
    {
        int j = position >> 12;
        int i = j;
        if (j == 0)
        {
            i = -1;
        }
        return i;
    }

    public final String getName()
    {
        if (symbol == null)
        {
            return null;
        }
        if (symbol instanceof Symbol)
        {
            return ((Symbol)symbol).getName();
        } else
        {
            return symbol.toString();
        }
    }

    public String getPublicId()
    {
        return null;
    }

    public final Object getSymbol()
    {
        return symbol;
    }

    public String getSystemId()
    {
        return filename;
    }

    public final Type getType()
    {
        if (type == null)
        {
            setType(Type.objectType);
        }
        return type;
    }

    public final Expression getTypeExp()
    {
        if (typeExp == null)
        {
            setType(Type.objectType);
        }
        return typeExp;
    }

    public final Expression getValue()
    {
label0:
        {
            {
                if (value != QuoteExp.undefined_exp)
                {
                    break label0;
                }
                Object obj;
                Throwable throwable;
                Type type1;
                if (field != null && (field.getModifiers() & 0x18) == 24 && !isIndirectBinding())
                {
                    try
                    {
                        value = new QuoteExp(field.getReflectField().get(null));
                    }
                    catch (Throwable throwable1) { }
                }
            }
            return value;
        }
        if ((value instanceof QuoteExp) && getFlag(8192L) && value.getType() != type)
        {
            try
            {
                obj = ((QuoteExp)value).getValue();
                type1 = getType();
                value = new QuoteExp(type1.coerceFromObject(obj), type1);
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable) { }
        }
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_61;
        }
    }

    public Variable getVariable()
    {
        return var;
    }

    public final boolean hasConstantValue()
    {
        Expression expression = getValue();
        return (expression instanceof QuoteExp) && expression != QuoteExp.undefined_exp;
    }

    public boolean ignorable()
    {
        if (!getCanRead() && !isPublic() && (!getCanWrite() || !getFlag(0x10000L)))
        {
            if (!getCanCall())
            {
                return true;
            }
            Object obj = getValue();
            if (obj != null && (obj instanceof LambdaExp))
            {
                obj = (LambdaExp)obj;
                if (!((LambdaExp) (obj)).isHandlingTailCalls() || ((LambdaExp) (obj)).getInlineOnly())
                {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isAlias()
    {
        return (flags & 256L) != 0L;
    }

    public boolean isCompiletimeConstant()
    {
        return getFlag(16384L) && hasConstantValue();
    }

    public final boolean isFluid()
    {
        return (flags & 16L) != 0L;
    }

    public final boolean isIndirectBinding()
    {
        return (flags & 1L) != 0L;
    }

    public final boolean isLexical()
    {
        return (flags & 0x10010010L) == 0L;
    }

    public final boolean isNamespaceDecl()
    {
        return (flags & 0x200000L) != 0L;
    }

    public final boolean isPrivate()
    {
        return (flags & 32L) != 0L;
    }

    public final boolean isProcedureDecl()
    {
        return (flags & 128L) != 0L;
    }

    public final boolean isPublic()
    {
        return (context instanceof ModuleExp) && (flags & 32L) == 0L;
    }

    public final boolean isSimple()
    {
        return (flags & 64L) != 0L;
    }

    public boolean isStableSourceLocation()
    {
        return true;
    }

    public boolean isStatic()
    {
        boolean flag1 = true;
        if (field == null) goto _L2; else goto _L1
_L1:
        boolean flag = field.getStaticFlag();
_L4:
        return flag;
_L2:
        flag = flag1;
        if (getFlag(2048L)) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (isCompiletimeConstant()) goto _L4; else goto _L5
_L5:
        LambdaExp lambdaexp;
        if (getFlag(4096L))
        {
            return false;
        }
        lambdaexp = context.currentLambda();
        if (!(lambdaexp instanceof ModuleExp))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((ModuleExp)lambdaexp).isStatic()) goto _L4; else goto _L6
_L6:
        return false;
    }

    public final boolean isThisParameter()
    {
        return symbol == ThisExp.THIS_NAME;
    }

    public void load(AccessExp accessexp, int i, Compilation compilation, Target target)
    {
        Object obj;
        Object obj3;
        CodeAttr codeattr;
        if (target instanceof IgnoreTarget)
        {
            return;
        }
        if (accessexp == null)
        {
            obj = null;
        } else
        {
            obj = accessexp.contextDecl();
        }
        if (isAlias() && (value instanceof ReferenceExp))
        {
            ReferenceExp referenceexp = (ReferenceExp)value;
            Declaration declaration = referenceexp.binding;
            if (declaration != null && ((i & 2) == 0 || declaration.isIndirectBinding()) && (obj == null || !declaration.needsContext()))
            {
                declaration.load(((AccessExp) (referenceexp)), i, compilation, target);
                return;
            }
        }
        if (isFluid() && (context instanceof FluidLetExp))
        {
            base.load(accessexp, i, compilation, target);
            return;
        }
        codeattr = compilation.getCode();
        obj3 = getType();
        if (isIndirectBinding() || (i & 2) == 0) goto _L2; else goto _L1
_L1:
        if (field == null)
        {
            throw new Error((new StringBuilder()).append("internal error: cannot take location of ").append(this).toString());
        }
        boolean flag = compilation.immediate;
        if (field.getStaticFlag())
        {
            accessexp = ClassType.make("gnu.kawa.reflect.StaticFieldLocation");
            if (flag)
            {
                i = 1;
            } else
            {
                i = 2;
            }
            obj = accessexp.getDeclaredMethod("make", i);
        } else
        {
            accessexp = ClassType.make("gnu.kawa.reflect.FieldLocation");
            Method method;
            if (flag)
            {
                i = 2;
            } else
            {
                i = 3;
            }
            method = accessexp.getDeclaredMethod("make", i);
            loadOwningObject(((Declaration) (obj)), compilation);
            obj = method;
        }
        if (flag)
        {
            compilation.compileConstant(this);
        } else
        {
            compilation.compileConstant(field.getDeclaringClass().getName());
            compilation.compileConstant(field.getName());
        }
        codeattr.emitInvokeStatic(((Method) (obj)));
        obj = accessexp;
_L4:
        target.compileFromStack(compilation, ((Type) (obj)));
        return;
_L2:
        if (field != null)
        {
            compilation.usedClass(field.getDeclaringClass());
            compilation.usedClass(field.getType());
            ClassType classtype;
            Label label;
            int j;
            int k;
            boolean flag1;
            if (!field.getStaticFlag())
            {
                loadOwningObject(((Declaration) (obj)), compilation);
                codeattr.emitGetField(field);
            } else
            {
                codeattr.emitGetStatic(field);
            }
        } else
        if (isIndirectBinding() && compilation.immediate && getVariable() == null)
        {
            Environment environment = Environment.getCurrent();
            Object obj1;
            Object obj4;
            if (symbol instanceof Symbol)
            {
                obj = (Symbol)symbol;
            } else
            {
                obj = environment.getSymbol(symbol.toString());
            }
            obj4 = null;
            obj1 = obj4;
            if (isProcedureDecl())
            {
                obj1 = obj4;
                if (compilation.getLanguage().hasSeparateFunctionNamespace())
                {
                    obj1 = EnvironmentKey.FUNCTION;
                }
            }
            compilation.compileConstant(environment.getLocation(((Symbol) (obj)), obj1), Target.pushValue(Compilation.typeLocation));
        } else
        {
label0:
            {
                if (compilation.immediate)
                {
                    obj = getConstantValue();
                    if (obj != null)
                    {
                        compilation.compileConstant(obj, target);
                        return;
                    }
                }
                if (value != QuoteExp.undefined_exp && ignorable() && (!(value instanceof LambdaExp) || !(((LambdaExp)value).outer instanceof ModuleExp)))
                {
                    value.compile(compilation, target);
                    return;
                }
                obj2 = getVariable();
                if (!(context instanceof ClassExp) || obj2 != null || getFlag(128L))
                {
                    break label0;
                }
                obj = (ClassExp)context;
                if (!((ClassExp) (obj)).isMakingClassPair())
                {
                    break label0;
                }
                obj2 = ClassExp.slotToMethodName("get", getName());
                obj2 = ((ClassExp) (obj)).type.getDeclaredMethod(((String) (obj2)), 0);
                ((ClassExp) (obj)).loadHeapFrame(compilation);
                codeattr.emitInvoke(((Method) (obj2)));
            }
        }
_L6:
        obj = obj3;
        if (!isIndirectBinding()) goto _L4; else goto _L3
_L3:
        obj = obj3;
        if ((i & 2) != 0) goto _L4; else goto _L5
_L5:
        if (accessexp == null)
        {
            break MISSING_BLOCK_LABEL_967;
        }
        obj = accessexp.getFileName();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_967;
        }
        j = accessexp.getLineNumber();
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_967;
        }
        classtype = ClassType.make("gnu.mapping.UnboundLocationException");
        flag1 = codeattr.isInTry();
        k = accessexp.getColumnNumber();
        accessexp = new Label(codeattr);
        accessexp.define(codeattr);
        codeattr.emitInvokeVirtual(Compilation.getLocationMethod);
        obj3 = new Label(codeattr);
        ((Label) (obj3)).define(codeattr);
        label = new Label(codeattr);
        label.setTypes(codeattr);
        Object obj2;
        if (flag1)
        {
            codeattr.emitGoto(label);
        } else
        {
            codeattr.setUnreachable();
        }
        i = 0;
        if (!flag1)
        {
            i = codeattr.beginFragment(label);
        }
        codeattr.addHandler(accessexp, ((Label) (obj3)), classtype);
        codeattr.emitDup(classtype);
        codeattr.emitPushString(((String) (obj)));
        codeattr.emitPushInt(j);
        codeattr.emitPushInt(k);
        codeattr.emitInvokeVirtual(classtype.getDeclaredMethod("setLine", 3));
        codeattr.emitThrow();
        if (flag1)
        {
            label.define(codeattr);
        } else
        {
            codeattr.endFragment(i);
        }
_L7:
        obj = Type.pointer_type;
          goto _L4
        obj = obj2;
        if (obj2 == null)
        {
            obj = allocateVariable(codeattr);
        }
        codeattr.emitLoad(((Variable) (obj)));
          goto _L6
        codeattr.emitInvokeVirtual(Compilation.getLocationMethod);
          goto _L7
    }

    void loadOwningObject(Declaration declaration, Compilation compilation)
    {
        Declaration declaration1 = declaration;
        if (declaration == null)
        {
            declaration1 = base;
        }
        if (declaration1 != null)
        {
            declaration1.load(null, 0, compilation, Target.pushObject);
            return;
        } else
        {
            getContext().currentLambda().loadHeapFrame(compilation);
            return;
        }
    }

    public void makeField(ClassType classtype, Compilation compilation, Expression expression)
    {
        int i;
        boolean flag;
        boolean flag1;
label0:
        {
            flag = needsExternalAccess();
            int k = 0;
            flag1 = getFlag(16384L);
            boolean flag2 = getFlag(8192L);
            if (compilation.immediate && (context instanceof ModuleExp) && !flag1 && !flag2)
            {
                setIndirectBinding(true);
            }
            if (isPublic() || flag || compilation.immediate)
            {
                k = false | true;
            }
            if (!isStatic() && (!getFlag(0x10010010L) || !isIndirectBinding() || isAlias()))
            {
                i = k;
                if (!(expression instanceof ClassExp))
                {
                    break label0;
                }
                i = k;
                if (((LambdaExp)expression).getNeedsClosureEnv())
                {
                    break label0;
                }
            }
            i = k | 8;
        }
        int l;
label1:
        {
            if (!isIndirectBinding())
            {
                l = i;
                if (!flag1)
                {
                    break label1;
                }
                if (!shouldEarlyInit())
                {
                    l = i;
                    if (!(context instanceof ModuleExp))
                    {
                        break label1;
                    }
                    l = i;
                    if (!((ModuleExp)context).staticInitRun())
                    {
                        break label1;
                    }
                }
            }
            if (!(context instanceof ClassExp))
            {
                l = i;
                if (!(context instanceof ModuleExp))
                {
                    break label1;
                }
            }
            l = i | 0x10;
        }
        Type type1 = getType().getImplementationType();
        Object obj2 = type1;
        if (isIndirectBinding())
        {
            obj2 = type1;
            if (!type1.isSubtype(Compilation.typeLocation))
            {
                obj2 = Compilation.typeLocation;
            }
        }
        if (!ignorable())
        {
            Object obj = getName();
            String s;
            int j;
            int i1;
            if (obj == null)
            {
                s = "$unnamed$0";
                j = "$unnamed$0".length() - 2;
            } else
            {
                s = Compilation.mangleNameIfNeeded(((String) (obj)));
                obj = s;
                if (getFlag(0x10000L))
                {
                    obj = (new StringBuilder()).append("loc$").append(s).toString();
                }
                s = ((String) (obj));
                if (flag)
                {
                    s = ((String) (obj));
                    if (!getFlag(0x40000000L))
                    {
                        s = (new StringBuilder()).append("$Prvt$").append(((String) (obj))).toString();
                    }
                }
                j = s.length();
            }
            i1 = 0;
            for (; classtype.getDeclaredField(s) != null; s = ((StringBuilder) (obj)).append(i1).toString())
            {
                obj = (new StringBuilder()).append(s.substring(0, j)).append('$');
                i1++;
            }

            field = classtype.addField(s, ((Type) (obj2)), l);
            if (expression instanceof QuoteExp)
            {
                Object obj1 = ((QuoteExp)expression).getValue();
                if (field.getStaticFlag() && obj1.getClass().getName().equals(((Type) (obj2)).getName()))
                {
                    classtype = compilation.litTable.findLiteral(obj1);
                    if (((Literal) (classtype)).field == null)
                    {
                        classtype.assign(field, compilation.litTable);
                    }
                } else
                if ((obj2 instanceof PrimType) || "java.lang.String".equals(((Type) (obj2)).getName()))
                {
                    compilation = ((Compilation) (obj1));
                    if (obj1 instanceof Char)
                    {
                        compilation = IntNum.make(((Char)obj1).intValue());
                    }
                    field.setConstantValue(compilation, classtype);
                    return;
                }
            }
        }
        if (!shouldEarlyInit() && (isIndirectBinding() || expression != null && !(expression instanceof ClassExp)))
        {
            BindingInitializer.create(this, expression, compilation);
        }
    }

    public void makeField(Compilation compilation, Expression expression)
    {
        setSimple(false);
        makeField(compilation.mainClass, compilation, expression);
    }

    Location makeIndirectLocationFor()
    {
        Symbol symbol1;
        if (symbol instanceof Symbol)
        {
            symbol1 = (Symbol)symbol;
        } else
        {
            symbol1 = Namespace.EmptyNamespace.getSymbol(symbol.toString().intern());
        }
        return Location.make(symbol1);
    }

    public void maybeIndirectBinding(Compilation compilation)
    {
        if (isLexical() && !(context instanceof ModuleExp) || context == compilation.mainLambda)
        {
            setIndirectBinding(true);
        }
    }

    public final boolean needsContext()
    {
        return base == null && field != null && !field.getStaticFlag();
    }

    public final boolean needsExternalAccess()
    {
        return (flags & 0x80020L) == 0x80020L || (flags & 0x200020L) == 0x200020L;
    }

    public boolean needsInit()
    {
        return !ignorable() && (value != QuoteExp.nullExp || base == null);
    }

    public final Declaration nextDecl()
    {
        return next;
    }

    public void noteValue(Expression expression)
    {
        if (value == QuoteExp.undefined_exp)
        {
            if (expression instanceof LambdaExp)
            {
                ((LambdaExp)expression).nameDecl = this;
            }
            value = expression;
        } else
        if (value != expression)
        {
            if (value instanceof LambdaExp)
            {
                ((LambdaExp)value).nameDecl = null;
            }
            value = null;
            return;
        }
    }

    public void printInfo(OutPort outport)
    {
        StringBuffer stringbuffer = new StringBuffer();
        printInfo(stringbuffer);
        outport.print(stringbuffer.toString());
    }

    public void printInfo(StringBuffer stringbuffer)
    {
        Expression expression;
        Type type1;
        stringbuffer.append(symbol);
        stringbuffer.append('/');
        stringbuffer.append(id);
        stringbuffer.append("/fl:");
        stringbuffer.append(Long.toHexString(flags));
        if (ignorable())
        {
            stringbuffer.append("(ignorable)");
        }
        expression = typeExp;
        type1 = getType();
        if (expression == null || (expression instanceof QuoteExp)) goto _L2; else goto _L1
_L1:
        stringbuffer.append("::");
        stringbuffer.append(expression);
_L4:
        if (base != null)
        {
            stringbuffer.append("(base:#");
            stringbuffer.append(base.id);
            stringbuffer.append(')');
        }
        return;
_L2:
        if (type != null && type1 != Type.pointer_type)
        {
            stringbuffer.append("::");
            stringbuffer.append(type1.getName());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void pushIndirectBinding(Compilation compilation)
    {
        compilation = compilation.getCode();
        compilation.emitPushString(getName());
        if (makeLocationMethod == null)
        {
            ClassType classtype = Type.pointer_type;
            ClassType classtype1 = Type.string_type;
            ClassType classtype2 = Compilation.typeLocation;
            ClassType classtype3 = Compilation.typeLocation;
            makeLocationMethod = classtype2.addMethod("make", new Type[] {
                classtype, classtype1
            }, classtype3, 9);
        }
        compilation.emitInvokeStatic(makeLocationMethod);
    }

    public final void setAlias(boolean flag)
    {
        setFlag(flag, 256L);
    }

    public final void setCanCall()
    {
        setFlag(true, 4L);
        if (base != null)
        {
            base.setCanRead();
        }
    }

    public final void setCanCall(boolean flag)
    {
        setFlag(flag, 4L);
    }

    public final void setCanRead()
    {
        setFlag(true, 2L);
        if (base != null)
        {
            base.setCanRead();
        }
    }

    public final void setCanRead(boolean flag)
    {
        setFlag(flag, 2L);
    }

    public final void setCanWrite()
    {
        flags = flags | 8L;
        if (base != null)
        {
            base.setCanRead();
        }
    }

    public final void setCanWrite(boolean flag)
    {
        if (flag)
        {
            flags = flags | 8L;
            return;
        } else
        {
            flags = flags & -9L;
            return;
        }
    }

    public void setCode(int i)
    {
        if (i >= 0)
        {
            throw new Error("code must be negative");
        } else
        {
            id = i;
            return;
        }
    }

    public final void setFile(String s)
    {
        filename = s;
    }

    public final void setFlag(long l)
    {
        flags = flags | l;
    }

    public final void setFlag(boolean flag, long l)
    {
        if (flag)
        {
            flags = flags | l;
            return;
        } else
        {
            flags = flags & (-1L ^ l);
            return;
        }
    }

    public final void setFluid(boolean flag)
    {
        setFlag(flag, 16L);
    }

    public final void setIndirectBinding(boolean flag)
    {
        setFlag(flag, 1L);
    }

    public final void setLine(int i)
    {
        setLine(i, 0);
    }

    public final void setLine(int i, int j)
    {
        int k = i;
        if (i < 0)
        {
            k = 0;
        }
        i = j;
        if (j < 0)
        {
            i = 0;
        }
        position = (k << 12) + i;
    }

    public final void setLocation(SourceLocator sourcelocator)
    {
        filename = sourcelocator.getFileName();
        setLine(sourcelocator.getLineNumber(), sourcelocator.getColumnNumber());
    }

    public final void setName(Object obj)
    {
        symbol = obj;
    }

    public final void setNext(Declaration declaration)
    {
        next = declaration;
    }

    public final void setPrivate(boolean flag)
    {
        setFlag(flag, 32L);
    }

    public final void setProcedureDecl(boolean flag)
    {
        setFlag(flag, 128L);
    }

    public final void setSimple(boolean flag)
    {
        setFlag(flag, 64L);
        if (var != null && !var.isParameter())
        {
            var.setSimple(flag);
        }
    }

    public final void setSymbol(Object obj)
    {
        symbol = obj;
    }

    public final void setSyntax()
    {
        setSimple(false);
        setFlag(0x2000c000L);
    }

    public final void setType(Type type1)
    {
        type = type1;
        if (var != null)
        {
            var.setType(type1);
        }
        typeExp = QuoteExp.getInstance(type1);
    }

    public final void setTypeExp(Expression expression)
    {
        typeExp = expression;
        Object obj;
        if (expression instanceof TypeValue)
        {
            expression = ((TypeValue)expression).getImplementationType();
        } else
        {
            expression = Language.getDefaultLanguage().getTypeFor(expression, false);
        }
        obj = expression;
        if (expression == null)
        {
            obj = Type.pointer_type;
        }
        type = ((Type) (obj));
        if (var != null)
        {
            var.setType(((Type) (obj)));
        }
    }

    public final void setValue(Expression expression)
    {
        value = expression;
    }

    boolean shouldEarlyInit()
    {
        return getFlag(0x20000000L) || isCompiletimeConstant();
    }

    public String toString()
    {
        return (new StringBuilder()).append("Declaration[").append(symbol).append('/').append(id).append(']').toString();
    }
}
