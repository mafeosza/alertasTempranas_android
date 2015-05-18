// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExceptionsAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Filter;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import java.util.Set;
import java.util.Vector;

// Referenced classes of package gnu.expr:
//            ScopeExp, ApplyExp, Expression, Compilation, 
//            ModuleExp, Declaration, ClassExp, ReferenceExp, 
//            QuoteExp, Closure, IgnoreTarget, ProcInitializer, 
//            Target, StackTarget, ConsumerTarget, CheckedTarget, 
//            Special, Language, InlineCalls, PrimProcedure, 
//            ThisExp, ExpVisitor, Initializer, Keyword

public class LambdaExp extends ScopeExp
{

    public static final int ATTEMPT_INLINE = 4096;
    static final int CANNOT_INLINE = 32;
    static final int CAN_CALL = 4;
    static final int CAN_READ = 2;
    static final int CLASS_METHOD = 64;
    static final int DEFAULT_CAPTURES_ARG = 512;
    static final int IMPORTS_LEX_VARS = 8;
    static final int INLINE_ONLY = 8192;
    static final int METHODS_COMPILED = 128;
    static final int NEEDS_STATIC_LINK = 16;
    protected static final int NEXT_AVAIL_FLAG = 16384;
    public static final int NO_FIELD = 256;
    public static final int OVERLOADABLE_FIELD = 2048;
    public static final int SEQUENCE_RESULT = 1024;
    static Method searchForKeywordMethod3;
    static Method searchForKeywordMethod4;
    static final ApplyExp unknownContinuation = new ApplyExp((Expression)null, null);
    Vector applyMethods;
    Variable argsArray;
    public Expression body;
    Declaration capturedVars;
    Variable closureEnv;
    public Field closureEnvField;
    public Expression defaultArgs[];
    private Declaration firstArgsArrayArg;
    public LambdaExp firstChild;
    Variable heapFrame;
    Initializer initChain;
    public LambdaExp inlineHome;
    public Keyword keywords[];
    public int max_args;
    public int min_args;
    public Declaration nameDecl;
    public LambdaExp nextSibling;
    Method primBodyMethods[];
    Method primMethods[];
    Object properties[];
    public Expression returnContinuation;
    public Type returnType;
    int selectorValue;
    public Field staticLinkField;
    Set tailCallers;
    Procedure thisValue;
    Variable thisVariable;
    Expression throwsSpecification[];
    ClassType type;

    public LambdaExp()
    {
        type = Compilation.typeProcedure;
    }

    public LambdaExp(int i)
    {
        type = Compilation.typeProcedure;
        min_args = i;
        max_args = i;
    }

    public LambdaExp(Expression expression)
    {
        type = Compilation.typeProcedure;
        body = expression;
    }

    final void addApplyMethod(Compilation compilation, Field field)
    {
        LambdaExp lambdaexp;
        LambdaExp lambdaexp1;
        lambdaexp1 = this;
        lambdaexp = lambdaexp1;
        if (field == null) goto _L2; else goto _L1
_L1:
        lambdaexp = lambdaexp1;
        if (!field.getStaticFlag()) goto _L2; else goto _L3
_L3:
        field = compilation.getModule();
_L5:
        if (((LambdaExp) (field)).applyMethods == null)
        {
            field.applyMethods = new Vector();
        }
        ((LambdaExp) (field)).applyMethods.addElement(this);
        return;
_L2:
        LambdaExp lambdaexp2;
        do
        {
            lambdaexp2 = lambdaexp.outerLambda();
            if (lambdaexp2 instanceof ModuleExp)
            {
                break;
            }
            lambdaexp = lambdaexp2;
        } while (lambdaexp2.heapFrame == null);
        field = lambdaexp2;
        if (!lambdaexp2.getHeapFrameType().getSuperclass().isSubtype(Compilation.typeModuleBody))
        {
            field = compilation.getModule();
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    void addMethodFor(ClassType classtype, Compilation compilation, ObjectType objecttype)
    {
        Object obj;
        Object obj2;
        Declaration declaration;
        LambdaExp lambdaexp;
        Method amethod[];
        StringBuffer stringbuffer;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        boolean flag1;
label0:
        {
            obj = getName();
            lambdaexp = outerLambda();
            boolean flag;
            int l1;
            int l2;
            if (keywords == null)
            {
                j1 = 0;
            } else
            {
                j1 = keywords.length;
            }
            if (defaultArgs == null)
            {
                l = 0;
            } else
            {
                l = defaultArgs.length - j1;
            }
            if ((flags & 0x200) != 0)
            {
                k1 = 0;
            } else
            {
                k1 = l;
            }
            if (max_args < 0 || min_args + k1 < max_args)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            amethod = new Method[k1 + 1];
            primBodyMethods = amethod;
            if (primMethods == null)
            {
                primMethods = amethod;
            }
            i1 = 0;
            if (nameDecl != null && nameDecl.getFlag(4096L))
            {
                i = 0;
            } else
            if (nameDecl != null && nameDecl.getFlag(2048L))
            {
                i = 1;
            } else
            if (isClassMethod())
            {
                if (lambdaexp instanceof ClassExp)
                {
                    obj2 = (ClassExp)lambdaexp;
                    if (((ClassExp) (obj2)).isMakingClassPair() && objecttype != null)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (this == ((ClassExp) (obj2)).initMethod)
                    {
                        i1 = 73;
                    } else
                    if (this == ((ClassExp) (obj2)).clinitMethod)
                    {
                        i1 = 67;
                        i = 1;
                    }
                } else
                {
                    i = 0;
                }
            } else
            if (thisVariable != null || objecttype == classtype)
            {
                i = 0;
            } else
            if (nameDecl != null && (nameDecl.context instanceof ModuleExp))
            {
                obj2 = (ModuleExp)nameDecl.context;
                if (((ModuleExp) (obj2)).getSuperType() == null && ((ModuleExp) (obj2)).getInterfaces() == null)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            } else
            {
                i = 1;
            }
            stringbuffer = new StringBuffer(60);
            if (i != 0)
            {
                k = 8;
            } else
            {
                k = 0;
            }
            j = k;
            if (nameDecl != null)
            {
                if (nameDecl.needsExternalAccess())
                {
                    j = k | 1;
                } else
                {
                    short word0;
                    if (nameDecl.isPrivate())
                    {
                        word0 = 0;
                    } else
                    {
                        word0 = 1;
                    }
                    j = word0;
                    if (isClassMethod())
                    {
                        j = nameDecl.getAccessFlags(word0);
                    }
                    j = k | j;
                }
            }
            if (!lambdaexp.isModuleBody() && !(lambdaexp instanceof ClassExp) || obj == null)
            {
                stringbuffer.append("lambda");
                k = compilation.method_counter + 1;
                compilation.method_counter = k;
                stringbuffer.append(k);
            }
            if (i1 == 67)
            {
                stringbuffer.append("<clinit>");
            } else
            if (getSymbol() != null)
            {
                stringbuffer.append(Compilation.mangleName(((String) (obj))));
            }
            if (getFlag(1024))
            {
                stringbuffer.append("$C");
            }
            if (getCallConvention() >= 2 && i1 == 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            k = j;
            if (i1 != 0)
            {
                if (i != 0)
                {
                    k = (j & -3) + 1;
                } else
                {
                    k = (j & 2) + 2;
                }
            }
            if (!classtype.isInterface())
            {
                i = k;
                if (!isAbstract())
                {
                    break label0;
                }
            }
            i = k | 0x400;
        }
        if (!isClassMethod() || !(lambdaexp instanceof ClassExp) || min_args != max_args) goto _L2; else goto _L1
_L1:
        obj2 = null;
        j = 0;
        declaration = firstDecl();
_L11:
        if (declaration != null) goto _L4; else goto _L3
_L3:
        if (returnType == null) goto _L5; else goto _L2
_L4:
        if (!declaration.isThisParameter()) goto _L7; else goto _L6
_L6:
        k = j - 1;
        obj = obj2;
_L9:
        declaration = declaration.nextDecl();
        j = k + 1;
        obj2 = obj;
        continue; /* Loop/switch isn't completed */
_L7:
        k = j;
        obj = obj2;
        if (declaration.getFlag(8192L))
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        obj = obj2;
        if (obj2 == null)
        {
            obj = classtype.getMethods(new Filter() {

                final LambdaExp this$0;
                final String val$mangled;

                public boolean select(Object obj8)
                {
                    for (obj8 = (Method)obj8; !((Method) (obj8)).getName().equals(mangled) || ((Method) (obj8)).getParameterTypes().length != min_args;)
                    {
                        return false;
                    }

                    return true;
                }

            
            {
                this$0 = LambdaExp.this;
                mangled = s;
                super();
            }
            }, 2);
        }
        obj6 = null;
        k = obj.length;
label1:
        do
        {
            do
            {
                k--;
                if (k < 0)
                {
                    break; /* Loop/switch isn't completed */
                }
                obj2 = obj[k];
                if (declaration == null)
                {
                    obj2 = ((Method) (obj2)).getReturnType();
                } else
                {
                    obj2 = ((Method) (obj2)).getParameterTypes()[j];
                }
                if (obj6 != null)
                {
                    continue label1;
                }
                obj6 = obj2;
            } while (true);
        } while (obj2 == obj6);
        k = j;
        if (declaration == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L9; else goto _L8
_L8:
        if (obj6 != null)
        {
            if (declaration != null)
            {
                declaration.setType(((Type) (obj6)));
            } else
            {
                setCoercedReturnType(((Type) (obj6)));
            }
        }
        k = j;
        if (declaration != null) goto _L9; else goto _L2
_L2:
        Object obj6;
        if (getFlag(1024) || getCallConvention() >= 2)
        {
            obj6 = Type.voidType;
        } else
        {
            obj6 = getReturnType().getImplementationType();
        }
        if (objecttype != null && objecttype != classtype)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        l1 = 0;
        k = l1;
        if (getCallConvention() >= 2)
        {
            k = l1;
            if (i1 == 0)
            {
                k = 1;
            }
        }
        l2 = stringbuffer.length();
        for (i1 = 0; i1 <= k1;)
        {
            stringbuffer.setLength(l2);
            int k2 = min_args + i1;
            l1 = k2;
            int j2 = l1;
            if (i1 == k1)
            {
                j2 = l1;
                if (flag)
                {
                    j2 = l1 + 1;
                }
            }
            Type atype[] = new Type[j + j2 + k];
            if (j > 0)
            {
                atype[0] = objecttype;
            }
            obj2 = firstDecl();
            obj = obj2;
            if (obj2 != null)
            {
                obj = obj2;
                if (((Declaration) (obj2)).isThisParameter())
                {
                    obj = ((Declaration) (obj2)).nextDecl();
                }
            }
            for (l1 = 0; l1 < k2; l1++)
            {
                atype[j + l1] = ((Declaration) (obj)).getType().getImplementationType();
                obj = ((Declaration) (obj)).nextDecl();
            }

            int i2;
label2:
            {
label3:
                {
                    if (k != 0)
                    {
                        atype[atype.length - 1] = Compilation.typeCallContext;
                    }
                    i2 = i;
                    if (k2 >= j2)
                    {
                        break label2;
                    }
                    Type type1 = ((Declaration) (obj)).getType();
                    String s1 = type1.getName();
                    Object obj3;
                    if (classtype.getClassfileVersion() >= 0x310000 && (type1 instanceof ArrayType))
                    {
                        i |= 0x80;
                    } else
                    {
                        stringbuffer.append("$V");
                    }
                    if (j1 <= 0 && k1 >= l)
                    {
                        obj3 = type1;
                        if ("gnu.lists.LList".equals(s1))
                        {
                            break label3;
                        }
                        obj3 = type1;
                        if (type1 instanceof ArrayType)
                        {
                            break label3;
                        }
                    }
                    obj3 = Compilation.objArrayType;
                    argsArray = new Variable("argsArray", Compilation.objArrayType);
                    argsArray.setParameter(true);
                }
                firstArgsArrayArg = ((Declaration) (obj));
                j2 = atype.length;
                if (flag1)
                {
                    i2 = 2;
                } else
                {
                    i2 = 1;
                }
                atype[j2 - i2] = ((Type) (obj3));
                i2 = i;
            }
label4:
            {
                Method method;
                ClassType aclasstype[];
label5:
                {
                    Object obj4;
label6:
                    {
                        {
                            if (flag1)
                            {
                                stringbuffer.append("$X");
                            }
                            String s;
                            if ((lambdaexp instanceof ClassExp) || (lambdaexp instanceof ModuleExp) && ((ModuleExp)lambdaexp).getFlag(0x20000))
                            {
                                i = 1;
                            } else
                            {
                                i = 0;
                            }
                            s = stringbuffer.toString();
                            j2 = 0;
                            k2 = stringbuffer.length();
                            do
                            {
label7:
                                {
                                    for (obj4 = classtype; obj4 == null; obj4 = ((ClassType) (obj4)).getSuperclass())
                                    {
                                        break label6;
                                    }

                                    if (((ClassType) (obj4)).getDeclaredMethod(s, atype) == null)
                                    {
                                        break label7;
                                    }
                                    stringbuffer.setLength(k2);
                                    stringbuffer.append('$');
                                    j2++;
                                    stringbuffer.append(j2);
                                    s = stringbuffer.toString();
                                }
                            } while (true);
                        }
                        if (i == 0)
                        {
                            break label5;
                        }
                    }
                    method = classtype.addMethod(s, atype, ((Type) (obj6)), i2);
                    amethod[i1] = method;
                    if (throwsSpecification == null || throwsSpecification.length <= 0)
                    {
                        break label4;
                    }
                    j2 = throwsSpecification.length;
                    aclasstype = new ClassType[j2];
                    i = 0;
                    while (i < j2) 
                    {
                        Object obj5 = null;
                        obj4 = null;
                        Expression expression = throwsSpecification[i];
                        Object obj7 = null;
                        Object obj1;
                        if (expression instanceof ReferenceExp)
                        {
                            obj5 = (ReferenceExp)expression;
                            obj1 = ((ReferenceExp) (obj5)).getBinding();
                            if (obj1 != null)
                            {
                                obj5 = ((Declaration) (obj1)).getValue();
                                if (obj5 instanceof ClassExp)
                                {
                                    obj4 = ((ClassExp)obj5).getCompiledClassType(compilation);
                                    obj1 = obj7;
                                } else
                                {
                                    obj1 = (new StringBuilder()).append("throws specification ").append(((Declaration) (obj1)).getName()).append(" has non-class lexical binding").toString();
                                }
                            } else
                            {
                                obj1 = (new StringBuilder()).append("unknown class ").append(((ReferenceExp) (obj5)).getName()).toString();
                            }
                        } else
                        {
                            obj1 = obj7;
                            if (expression instanceof QuoteExp)
                            {
                                obj4 = ((QuoteExp)expression).getValue();
                                obj1 = obj4;
                                if (obj4 instanceof Class)
                                {
                                    obj1 = Type.make((Class)obj4);
                                }
                                if (obj1 instanceof ClassType)
                                {
                                    obj5 = (ClassType)obj1;
                                }
                                obj4 = obj5;
                                obj1 = obj7;
                                if (obj5 != null)
                                {
                                    obj4 = obj5;
                                    obj1 = obj7;
                                    if (!((ClassType) (obj5)).isSubtype(Type.javalangThrowableType))
                                    {
                                        obj1 = (new StringBuilder()).append(((ClassType) (obj5)).getName()).append(" does not extend Throwable").toString();
                                        obj4 = obj5;
                                    }
                                }
                            }
                        }
                        obj5 = obj1;
                        if (obj4 == null)
                        {
                            obj5 = obj1;
                            if (obj1 == null)
                            {
                                obj5 = "invalid throws specification";
                            }
                        }
                        if (obj5 != null)
                        {
                            compilation.error('e', ((String) (obj5)), expression);
                            obj4 = Type.javalangThrowableType;
                        }
                        aclasstype[i] = ((ClassType) (obj4));
                        i++;
                    }
                    break MISSING_BLOCK_LABEL_1856;
                }
                (new ExceptionsAttr(method)).setExceptions(aclasstype);
            }
            i1++;
            i = i2;
        }

        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    void addMethodFor(Compilation compilation, ObjectType objecttype)
    {
        Object obj;
        for (obj = this; obj != null && !(obj instanceof ClassExp); obj = ((ScopeExp) (obj)).outer) { }
        if (obj != null)
        {
            obj = ((ClassExp)obj).instanceType;
        } else
        {
            obj = getOwningLambda().getHeapFrameType();
        }
        addMethodFor(((ClassType) (obj)), compilation, objecttype);
    }

    public void allocChildClasses(Compilation compilation)
    {
        Object obj;
        obj = getMainMethod();
        if (obj != null && !((Method) (obj)).getStaticFlag())
        {
            declareThis(((Method) (obj)).getDeclaringClass());
        }
        obj = firstDecl();
_L2:
        if (obj == firstArgsArrayArg && argsArray != null)
        {
            getVarScope().addVariable(argsArray);
        }
        if (!getInlineOnly() && getCallConvention() >= 2 && (firstArgsArrayArg != null ? argsArray == null ? obj == firstArgsArrayArg.nextDecl() : obj == firstArgsArrayArg : obj == null))
        {
            getVarScope().addVariable(null, Compilation.typeCallContext, "$ctx").setParameter(true);
        }
        if (obj == null)
        {
            declareClosureEnv();
            allocFrame(compilation);
            allocChildMethods(compilation);
            return;
        }
        if (((Declaration) (obj)).var == null && (!getInlineOnly() || !((Declaration) (obj)).ignorable()))
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        obj = ((Declaration) (obj)).nextDecl();
        if (true) goto _L2; else goto _L1
_L1:
        if (((Declaration) (obj)).isSimple() && !((Declaration) (obj)).isIndirectBinding())
        {
            ((Declaration) (obj)).allocateVariable(null);
        } else
        {
            Object obj1 = Compilation.mangleName(((Declaration) (obj)).getName()).intern();
            Type type1 = ((Declaration) (obj)).getType().getImplementationType();
            obj1 = getVarScope().addVariable(null, type1, ((String) (obj1)));
            obj.var = ((Variable) (obj1));
            ((Variable) (obj1)).setParameter(true);
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    void allocChildMethods(Compilation compilation)
    {
        LambdaExp lambdaexp = firstChild;
        do
        {
            while (lambdaexp != null) 
            {
                if (!lambdaexp.isClassGenerated() && !lambdaexp.getInlineOnly() && lambdaexp.nameDecl != null)
                {
                    lambdaexp.allocMethod(this, compilation);
                }
                if (lambdaexp instanceof ClassExp)
                {
                    ClassExp classexp = (ClassExp)lambdaexp;
                    if (classexp.getNeedsClosureEnv())
                    {
                        Object obj;
                        if ((this instanceof ModuleExp) || (this instanceof ClassExp))
                        {
                            obj = (ClassType)getType();
                        } else
                        {
                            if (heapFrame != null)
                            {
                                obj = heapFrame;
                            } else
                            {
                                obj = closureEnv;
                            }
                            obj = (ClassType)((Variable) (obj)).getType();
                        }
                        obj = classexp.instanceType.setOuterLink(((ClassType) (obj)));
                        classexp.staticLinkField = ((Field) (obj));
                        classexp.closureEnvField = ((Field) (obj));
                    }
                }
                lambdaexp = lambdaexp.nextSibling;
            }
            return;
        } while (true);
    }

    Field allocFieldFor(Compilation compilation)
    {
        if (nameDecl == null || nameDecl.field == null) goto _L2; else goto _L1
_L1:
        compilation = nameDecl.field;
_L7:
        return compilation;
_L2:
        String s;
        int i;
        boolean flag;
        flag = getNeedsClosureEnv();
        Object obj;
        ClassType classtype;
        int j;
        if (flag)
        {
            classtype = getOwningLambda().getHeapFrameType();
        } else
        {
            classtype = compilation.mainClass;
        }
        obj = getName();
        if (obj == null)
        {
            s = "lambda";
        } else
        {
            s = Compilation.mangleNameIfNeeded(((String) (obj)));
        }
        i = 16;
        if (nameDecl == null || !(nameDecl.context instanceof ModuleExp)) goto _L4; else goto _L3
_L3:
label0:
        {
            flag = nameDecl.needsExternalAccess();
            obj = s;
            if (flag)
            {
                obj = (new StringBuilder()).append("$Prvt$").append(s).toString();
            }
            if (nameDecl.getFlag(2048L))
            {
                j = 0x10 | 8;
                i = j;
                if (!((ModuleExp)nameDecl.context).isStatic())
                {
                    i = j & 0xffffffef;
                }
            }
            if (nameDecl.isPrivate() && !flag)
            {
                j = i;
                if (!compilation.immediate)
                {
                    break label0;
                }
            }
            j = i | 1;
        }
        i = j;
        compilation = ((Compilation) (obj));
        if ((flags & 0x800) == 0) goto _L6; else goto _L5
_L5:
        if (min_args == max_args)
        {
            i = min_args;
        } else
        {
            i = 1;
        }
_L8:
        compilation = (new StringBuilder()).append(((String) (obj))).append('$').append(i).toString();
        if (classtype.getDeclaredField(compilation) != null)
        {
            break MISSING_BLOCK_LABEL_386;
        }
        i = j;
_L6:
        obj = classtype.addField(compilation, Compilation.typeModuleMethod, i);
        compilation = ((Compilation) (obj));
        if (nameDecl != null)
        {
            nameDecl.field = ((Field) (obj));
            return ((Field) (obj));
        }
          goto _L7
_L4:
        Object obj1 = (new StringBuilder()).append(s).append("$Fn");
        int k = compilation.localFieldIndex + 1;
        compilation.localFieldIndex = k;
        obj1 = ((StringBuilder) (obj1)).append(k).toString();
        compilation = ((Compilation) (obj1));
        if (!flag)
        {
            i = 0x10 | 8;
            compilation = ((Compilation) (obj1));
        }
          goto _L6
        i++;
          goto _L8
    }

    public void allocFrame(Compilation compilation)
    {
        if (heapFrame != null)
        {
            if ((this instanceof ModuleExp) || (this instanceof ClassExp))
            {
                compilation = getCompiledClassType(compilation);
            } else
            {
                ClassType classtype = new ClassType(compilation.generateClassName("frame"));
                classtype.setSuper(compilation.getModuleType());
                compilation.addClass(classtype);
                compilation = classtype;
            }
            heapFrame.setType(compilation);
        }
    }

    void allocMethod(LambdaExp lambdaexp, Compilation compilation)
    {
        if (!getNeedsClosureEnv())
        {
            lambdaexp = null;
        } else
        if ((lambdaexp instanceof ClassExp) || (lambdaexp instanceof ModuleExp))
        {
            lambdaexp = lambdaexp.getCompiledClassType(compilation);
        } else
        {
            for (; lambdaexp.heapFrame == null; lambdaexp = lambdaexp.outerLambda()) { }
            lambdaexp = (ClassType)lambdaexp.heapFrame.getType();
        }
        addMethodFor(compilation, lambdaexp);
    }

    void allocParameters(Compilation compilation)
    {
        compilation = compilation.getCode();
        ((CodeAttr) (compilation)).locals.enterScope(getVarScope());
        int i = getLineNumber();
        if (i > 0)
        {
            compilation.putLineNumber(getFileName(), i);
        }
        if (heapFrame != null)
        {
            heapFrame.allocateLocal(compilation);
        }
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        setIndexes();
        callcontext.writeValue(new Closure(this, callcontext));
    }

    public void capture(Declaration declaration)
    {
        if (declaration.isSimple())
        {
            if (capturedVars == null && !declaration.isStatic() && !(this instanceof ModuleExp) && !(this instanceof ClassExp))
            {
                heapFrame = new Variable("heapFrame");
            }
            declaration.setSimple(false);
            if (!declaration.isPublic())
            {
                declaration.nextCapturedVar = capturedVars;
                capturedVars = declaration;
            }
        }
    }

    public void compile(Compilation compilation, Target target)
    {
        if (target instanceof IgnoreTarget)
        {
            return;
        }
        CodeAttr codeattr = compilation.getCode();
        LambdaExp lambdaexp = outerLambda();
        ClassType classtype = Compilation.typeModuleMethod;
        if ((flags & 0x100) != 0 || compilation.immediate && (lambdaexp instanceof ModuleExp))
        {
            if (primMethods == null)
            {
                allocMethod(outerLambda(), compilation);
            }
            compileAsMethod(compilation);
            addApplyMethod(compilation, null);
            ProcInitializer.emitLoadModuleMethod(this, compilation);
        } else
        {
            Field field = compileSetField(compilation);
            if (field.getStaticFlag())
            {
                codeattr.emitGetStatic(field);
            } else
            {
                Object obj = compilation.curLambda;
                if (((LambdaExp) (obj)).heapFrame != null)
                {
                    obj = ((LambdaExp) (obj)).heapFrame;
                } else
                {
                    obj = ((LambdaExp) (obj)).closureEnv;
                }
                codeattr.emitLoad(((Variable) (obj)));
                codeattr.emitGetField(field);
            }
        }
        target.compileFromStack(compilation, classtype);
    }

    void compileAsMethod(Compilation compilation)
    {
        if ((flags & 0x80) == 0 && !isAbstract())
        {
            flags = flags | 0x80;
            if (primMethods != null)
            {
                Method method = compilation.method;
                LambdaExp lambdaexp = compilation.curLambda;
                compilation.curLambda = this;
                boolean flag2 = primMethods[0].getStaticFlag();
                int k1 = primMethods.length - 1;
                Type type1 = restArgType();
                long al1[] = null;
                if (k1 > 0)
                {
                    long al[] = new long[min_args + k1];
                    int i = 0;
                    Declaration declaration = firstDecl();
                    do
                    {
                        al1 = al;
                        if (i >= min_args + k1)
                        {
                            break;
                        }
                        al[i] = declaration.flags;
                        declaration = declaration.nextDecl();
                        i++;
                    } while (true);
                }
                int j;
                boolean flag;
                if (getCallConvention() >= 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                j = 0;
                do
                {
                    while (j <= k1) 
                    {
                        compilation.method = primMethods[j];
                        if (j < k1)
                        {
                            CodeAttr codeattr = compilation.method.startCode();
                            int k;
                            for (k = j + 1; k < k1 && (defaultArgs[k] instanceof QuoteExp); k++) { }
                            Variable variable;
                            Object obj;
                            Variable variable1;
                            boolean flag1;
                            if (k == k1 && type1 != null)
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            variable1 = compilation.callContextVar;
                            obj = codeattr.getArg(0);
                            variable = ((Variable) (obj));
                            if (!flag2)
                            {
                                codeattr.emitPushThis();
                                if (getNeedsClosureEnv())
                                {
                                    closureEnv = ((Variable) (obj));
                                }
                                variable = codeattr.getArg(1);
                            }
                            obj = firstDecl();
                            for (int i1 = 0; i1 < min_args + j;)
                            {
                                obj.flags = ((Declaration) (obj)).flags | 64L;
                                obj.var = variable;
                                codeattr.emitLoad(variable);
                                variable = variable.nextVar();
                                i1++;
                                obj = ((Declaration) (obj)).nextDecl();
                            }

                            Object obj2;
                            if (flag)
                            {
                                obj2 = variable;
                            } else
                            {
                                obj2 = null;
                            }
                            compilation.callContextVar = ((Variable) (obj2));
                            for (int j1 = j; j1 < k;)
                            {
                                obj2 = StackTarget.getInstance(((Declaration) (obj)).getType());
                                defaultArgs[j1].compile(compilation, ((Target) (obj2)));
                                j1++;
                                obj = ((Declaration) (obj)).nextDecl();
                            }

                            if (flag1)
                            {
                                Object obj1 = type1.getName();
                                if ("gnu.lists.LList".equals(obj1))
                                {
                                    obj1 = new QuoteExp(LList.Empty);
                                } else
                                if ("java.lang.Object[]".equals(obj1))
                                {
                                    obj1 = new QuoteExp(((Object) (Values.noArgs)));
                                } else
                                {
                                    throw new Error((new StringBuilder()).append("unimplemented #!rest type ").append(((String) (obj1))).toString());
                                }
                                ((Expression) (obj1)).compile(compilation, type1);
                            }
                            if (flag)
                            {
                                codeattr.emitLoad(variable);
                            }
                            if (flag2)
                            {
                                codeattr.emitInvokeStatic(primMethods[k]);
                            } else
                            {
                                codeattr.emitInvokeVirtual(primMethods[k]);
                            }
                            codeattr.emitReturn();
                            closureEnv = null;
                            compilation.callContextVar = variable1;
                        } else
                        {
                            if (al1 != null)
                            {
                                int l = 0;
                                Declaration declaration1 = firstDecl();
                                for (; l < min_args + k1; l++)
                                {
                                    declaration1.flags = al1[l];
                                    declaration1.var = null;
                                    declaration1 = declaration1.nextDecl();
                                }

                            }
                            compilation.method.initCode();
                            allocChildClasses(compilation);
                            allocParameters(compilation);
                            enterFunction(compilation);
                            compileBody(compilation);
                            compileEnd(compilation);
                            generateApplyMethods(compilation);
                        }
                        j++;
                    }
                    compilation.method = method;
                    compilation.curLambda = lambdaexp;
                    return;
                } while (true);
            }
        }
    }

    public void compileBody(Compilation compilation)
    {
        Variable variable = compilation.callContextVar;
        compilation.callContextVar = null;
        Object obj;
        Object obj1;
        Expression expression;
        if (getCallConvention() >= 2)
        {
            obj = getVarScope().lookup("$ctx");
            if (obj != null && ((Variable) (obj)).getType() == Compilation.typeCallContext)
            {
                compilation.callContextVar = ((Variable) (obj));
            }
            obj = ConsumerTarget.makeContextTarget(compilation);
        } else
        {
            obj = Target.pushValue(getReturnType());
        }
        expression = body;
        obj1 = this;
        if (body.getLineNumber() > 0)
        {
            obj1 = body;
        }
        expression.compileWithPosition(compilation, ((Target) (obj)), ((Expression) (obj1)));
        compilation.callContextVar = variable;
    }

    public void compileEnd(Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        if (!getInlineOnly())
        {
            if (compilation.method.reachableHere() && (Compilation.defaultCallConvention < 3 || isModuleBody() || isClassMethod() || isHandlingTailCalls()))
            {
                codeattr.emitReturn();
            }
            popScope(codeattr);
            codeattr.popScope();
        }
        for (LambdaExp lambdaexp = firstChild; lambdaexp != null; lambdaexp = lambdaexp.nextSibling)
        {
            if (!lambdaexp.getCanRead() && !lambdaexp.getInlineOnly())
            {
                lambdaexp.compileAsMethod(compilation);
            }
        }

        if (heapFrame != null)
        {
            compilation.generateConstructor(this);
        }
    }

    public Field compileSetField(Compilation compilation)
    {
        if (primMethods == null)
        {
            allocMethod(outerLambda(), compilation);
        }
        Field field = allocFieldFor(compilation);
        if (compilation.usingCPStyle())
        {
            compile(compilation, Type.objectType);
        } else
        {
            compileAsMethod(compilation);
            addApplyMethod(compilation, field);
        }
        return (new ProcInitializer(this, compilation, field)).field;
    }

    public Variable declareClosureEnv()
    {
        if (closureEnv == null && getNeedsClosureEnv())
        {
            Object obj1 = outerLambda();
            Object obj = obj1;
            if (obj1 instanceof ClassExp)
            {
                obj = ((LambdaExp) (obj1)).outerLambda();
            }
            if (((LambdaExp) (obj)).heapFrame != null)
            {
                obj1 = ((LambdaExp) (obj)).heapFrame;
            } else
            {
                obj1 = ((LambdaExp) (obj)).closureEnv;
            }
            if (isClassMethod() && !"*init*".equals(getName()))
            {
                closureEnv = declareThis(type);
            } else
            if (((LambdaExp) (obj)).heapFrame == null && !((LambdaExp) (obj)).getNeedsStaticLink() && !(obj instanceof ModuleExp))
            {
                closureEnv = null;
            } else
            if (!isClassGenerated() && !getInlineOnly())
            {
                obj = getMainMethod();
                boolean flag = "*init*".equals(getName());
                if (!((Method) (obj)).getStaticFlag() && !flag)
                {
                    closureEnv = declareThis(((Method) (obj)).getDeclaringClass());
                } else
                {
                    closureEnv = new Variable("closureEnv", ((Method) (obj)).getParameterTypes()[0]);
                    if (flag)
                    {
                        obj = declareThis(((Method) (obj)).getDeclaringClass());
                    } else
                    {
                        obj = null;
                    }
                    getVarScope().addVariableAfter(((Variable) (obj)), closureEnv);
                    closureEnv.setParameter(true);
                }
            } else
            if (inlinedIn(((LambdaExp) (obj))))
            {
                closureEnv = ((Variable) (obj1));
            } else
            {
                closureEnv = new Variable("closureEnv", ((Variable) (obj1)).getType());
                getVarScope().addVariable(closureEnv);
            }
        }
        return closureEnv;
    }

    public Variable declareThis(ClassType classtype)
    {
        if (thisVariable == null)
        {
            thisVariable = new Variable("this");
            getVarScope().addVariableAfter(null, thisVariable);
            thisVariable.setParameter(true);
        }
        if (thisVariable.getType() == null)
        {
            thisVariable.setType(classtype);
        }
        if (decls != null && decls.isThisParameter())
        {
            decls.var = thisVariable;
        }
        return thisVariable;
    }

    void enterFunction(Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        getVarScope().noteStartFunction(codeattr);
        if (closureEnv != null && !closureEnv.isParameter() && !compilation.usingCPStyle())
        {
            if (!getInlineOnly())
            {
                codeattr.emitPushThis();
                Field field1 = closureEnvField;
                Field field = field1;
                if (field1 == null)
                {
                    field = outerLambda().closureEnvField;
                }
                codeattr.emitGetField(field);
                codeattr.emitStore(closureEnv);
            } else
            if (!inlinedIn(outerLambda()))
            {
                outerLambda().loadHeapFrame(compilation);
                codeattr.emitStore(closureEnv);
            }
        }
        if (!compilation.usingCPStyle())
        {
            ClassType classtype;
            Declaration declaration;
            if (heapFrame == null)
            {
                classtype = currentModule().getCompiledClassType(compilation);
            } else
            {
                classtype = (ClassType)heapFrame.getType();
            }
            declaration = capturedVars;
            while (declaration != null) 
            {
                if (declaration.field == null)
                {
                    declaration.makeField(classtype, compilation, null);
                }
                declaration = declaration.nextCapturedVar;
            }
        }
        if (heapFrame != null && !compilation.usingCPStyle())
        {
            ClassType classtype1 = (ClassType)heapFrame.getType();
            if (closureEnv != null && !(this instanceof ModuleExp))
            {
                staticLinkField = classtype1.addField("staticLink", closureEnv.getType());
            }
            if (!(this instanceof ModuleExp) && !(this instanceof ClassExp))
            {
                classtype1.setEnclosingMember(compilation.method);
                codeattr.emitNew(classtype1);
                codeattr.emitDup(classtype1);
                codeattr.emitInvokeSpecial(Compilation.getConstructor(classtype1, this));
                if (staticLinkField != null)
                {
                    codeattr.emitDup(classtype1);
                    codeattr.emitLoad(closureEnv);
                    codeattr.emitPutField(staticLinkField);
                }
                codeattr.emitStore(heapFrame);
            }
        }
        Variable variable = argsArray;
        Variable variable1 = variable;
        if (min_args == max_args)
        {
            variable1 = variable;
            if (primMethods == null)
            {
                variable1 = variable;
                if (getCallConvention() < 2)
                {
                    variable1 = null;
                }
            }
        }
        int k = 0;
        int i;
        int j1;
        if (keywords == null)
        {
            i = 0;
        } else
        {
            i = keywords.length;
        }
        if (defaultArgs == null)
        {
            j1 = 0;
        } else
        {
            j1 = defaultArgs.length - i;
        }
        if (this instanceof ModuleExp)
        {
            return;
        }
        int k1 = -1;
        int j2 = 0;
        getMainMethod();
        Variable variable2 = compilation.callContextVar;
        Declaration declaration1 = firstDecl();
        i = 0;
        int j = 0;
        do
        {
            while (declaration1 != null) 
            {
                Object obj;
                int l;
                int i1;
                if (getCallConvention() < 2)
                {
                    obj = null;
                } else
                {
                    obj = getVarScope().lookup("$ctx");
                }
                compilation.callContextVar = ((Variable) (obj));
                l = j2;
                i1 = k1;
                if (declaration1 == firstArgsArrayArg)
                {
                    l = j2;
                    i1 = k1;
                    if (variable1 != null)
                    {
                        if (primMethods != null)
                        {
                            i1 = k;
                            l = i1 - min_args;
                        } else
                        {
                            i1 = 0;
                            l = 0;
                        }
                    }
                }
                if (i1 >= 0 || !declaration1.isSimple() || declaration1.isIndirectBinding())
                {
                    Type type1 = declaration1.getType();
                    if (i1 >= 0)
                    {
                        obj = Type.objectType;
                    } else
                    {
                        obj = type1;
                    }
                    if (!declaration1.isSimple())
                    {
                        declaration1.loadOwningObject(null, compilation);
                    }
                    if (i1 < 0)
                    {
                        codeattr.emitLoad(declaration1.getVariable());
                    } else
                    if (k < min_args)
                    {
                        codeattr.emitLoad(variable1);
                        codeattr.emitPushInt(k);
                        codeattr.emitArrayLoad(Type.objectType);
                    } else
                    if (k < min_args + j1)
                    {
                        codeattr.emitPushInt(k - i1);
                        codeattr.emitLoad(variable1);
                        codeattr.emitArrayLength();
                        codeattr.emitIfIntLt();
                        codeattr.emitLoad(variable1);
                        codeattr.emitPushInt(k - i1);
                        codeattr.emitArrayLoad();
                        codeattr.emitElse();
                        Expression aexpression[] = defaultArgs;
                        int l1 = j + 1;
                        aexpression[l + j].compile(compilation, type1);
                        codeattr.emitFi();
                        j = l1;
                    } else
                    if (max_args < 0 && k == min_args + j1)
                    {
                        codeattr.emitLoad(variable1);
                        codeattr.emitPushInt(k - i1);
                        codeattr.emitInvokeStatic(Compilation.makeListMethod);
                        obj = Compilation.scmListType;
                    } else
                    {
                        codeattr.emitLoad(variable1);
                        codeattr.emitPushInt((min_args + j1) - i1);
                        Object aobj[] = keywords;
                        int i2 = i + 1;
                        compilation.compileConstant(aobj[i]);
                        aobj = defaultArgs;
                        int k2 = j + 1;
                        Expression expression = aobj[l + j];
                        if (expression instanceof QuoteExp)
                        {
                            if (searchForKeywordMethod4 == null)
                            {
                                ArrayType arraytype = Compilation.objArrayType;
                                gnu.bytecode.PrimType primtype = Type.intType;
                                ClassType classtype2 = Type.objectType;
                                ClassType classtype4 = Type.objectType;
                                ClassType classtype6 = Compilation.scmKeywordType;
                                ClassType classtype8 = Type.objectType;
                                searchForKeywordMethod4 = classtype6.addMethod("searchForKeyword", new Type[] {
                                    arraytype, primtype, classtype2, classtype4
                                }, classtype8, 9);
                            }
                            expression.compile(compilation, type1);
                            codeattr.emitInvokeStatic(searchForKeywordMethod4);
                            i = i2;
                            j = k2;
                        } else
                        {
                            if (searchForKeywordMethod3 == null)
                            {
                                ArrayType arraytype1 = Compilation.objArrayType;
                                gnu.bytecode.PrimType primtype1 = Type.intType;
                                ClassType classtype3 = Type.objectType;
                                ClassType classtype5 = Compilation.scmKeywordType;
                                ClassType classtype7 = Type.objectType;
                                searchForKeywordMethod3 = classtype5.addMethod("searchForKeyword", new Type[] {
                                    arraytype1, primtype1, classtype3
                                }, classtype7, 9);
                            }
                            codeattr.emitInvokeStatic(searchForKeywordMethod3);
                            codeattr.emitDup(1);
                            compilation.compileConstant(Special.dfault);
                            codeattr.emitIfEq();
                            codeattr.emitPop(1);
                            expression.compile(compilation, type1);
                            codeattr.emitFi();
                            i = i2;
                            j = k2;
                        }
                    }
                    if (type1 != obj)
                    {
                        CheckedTarget.emitCheckedCoerce(compilation, this, k + 1, type1);
                    }
                    if (declaration1.isIndirectBinding())
                    {
                        declaration1.pushIndirectBinding(compilation);
                    }
                    if (declaration1.isSimple())
                    {
                        obj = declaration1.getVariable();
                        if (declaration1.isIndirectBinding())
                        {
                            ((Variable) (obj)).setType(Compilation.typeLocation);
                        }
                        codeattr.emitStore(((Variable) (obj)));
                    } else
                    {
                        codeattr.emitPutField(declaration1.field);
                    }
                }
                k++;
                declaration1 = declaration1.nextDecl();
                j2 = l;
                k1 = i1;
            }
            compilation.callContextVar = variable2;
            return;
        } while (true);
    }

    Object evalDefaultArg(int i, CallContext callcontext)
    {
        try
        {
            callcontext = ((CallContext) (defaultArgs[i].eval(callcontext)));
        }
        // Misplaced declaration of an exception variable
        catch (CallContext callcontext)
        {
            throw new WrappedException("error evaluating default argument", callcontext);
        }
        return callcontext;
    }

    public void generateApplyMethods(Compilation compilation)
    {
        compilation.generateMatchMethods(this);
        if (Compilation.defaultCallConvention >= 2)
        {
            compilation.generateApplyMethodsWithContext(this);
            return;
        } else
        {
            compilation.generateApplyMethodsWithoutContext(this);
            return;
        }
    }

    Declaration getArg(int i)
    {
        Declaration declaration = firstDecl();
        do
        {
            if (declaration == null)
            {
                throw new Error("internal error - getArg");
            }
            if (i == 0)
            {
                return declaration;
            }
            i--;
            declaration = declaration.nextDecl();
        } while (true);
    }

    public int getCallConvention()
    {
        int i = 2;
        if (isModuleBody())
        {
            if (Compilation.defaultCallConvention >= 2)
            {
                i = Compilation.defaultCallConvention;
            }
            return i;
        }
        if (isClassMethod())
        {
            return 1;
        }
        if (Compilation.defaultCallConvention != 0)
        {
            return Compilation.defaultCallConvention;
        } else
        {
            return 1;
        }
    }

    public LambdaExp getCaller()
    {
        return inlineHome;
    }

    public final boolean getCanCall()
    {
        return (flags & 4) != 0;
    }

    public final boolean getCanRead()
    {
        return (flags & 2) != 0;
    }

    public ClassType getClassType()
    {
        return type;
    }

    protected ClassType getCompiledClassType(Compilation compilation)
    {
        if (type == Compilation.typeProcedure)
        {
            throw new Error("internal error: getCompiledClassType");
        } else
        {
            return type;
        }
    }

    protected final String getExpClassName()
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

    public ClassType getHeapFrameType()
    {
        if ((this instanceof ModuleExp) || (this instanceof ClassExp))
        {
            return (ClassType)getType();
        } else
        {
            return (ClassType)heapFrame.getType();
        }
    }

    public final boolean getImportsLexVars()
    {
        return (flags & 8) != 0;
    }

    public final boolean getInlineOnly()
    {
        return (flags & 0x2000) != 0;
    }

    public final Method getMainMethod()
    {
        Method amethod[] = primBodyMethods;
        if (amethod == null)
        {
            return null;
        } else
        {
            return amethod[amethod.length - 1];
        }
    }

    public final Method getMethod(int i)
    {
        if (primMethods != null && (max_args < 0 || i <= max_args))
        {
            if ((i -= min_args) >= 0)
            {
                int j = primMethods.length;
                Method amethod[] = primMethods;
                if (i >= j)
                {
                    i = j - 1;
                }
                return amethod[i];
            }
        }
        return null;
    }

    public final boolean getNeedsClosureEnv()
    {
        return (flags & 0x18) != 0;
    }

    public final boolean getNeedsStaticLink()
    {
        return (flags & 0x10) != 0;
    }

    public LambdaExp getOwningLambda()
    {
        ScopeExp scopeexp = outer;
        do
        {
            if (scopeexp == null)
            {
                return null;
            }
            if ((scopeexp instanceof ModuleExp) || (scopeexp instanceof ClassExp) && getNeedsClosureEnv() || (scopeexp instanceof LambdaExp) && ((LambdaExp)scopeexp).heapFrame != null)
            {
                return (LambdaExp)scopeexp;
            }
            scopeexp = scopeexp.outer;
        } while (true);
    }

    public Object getProperty(Object obj, Object obj1)
    {
        Object obj2;
label0:
        {
            obj2 = obj1;
            if (properties == null)
            {
                break label0;
            }
            int i = properties.length;
            int j;
            do
            {
                j = i - 2;
                obj2 = obj1;
                if (j < 0)
                {
                    break label0;
                }
                i = j;
            } while (properties[j] != obj);
            obj2 = properties[j + 1];
        }
        return obj2;
    }

    public final Type getReturnType()
    {
        if (returnType == null)
        {
            returnType = Type.objectType;
            if (body != null && !isAbstract())
            {
                returnType = body.getType();
            }
        }
        return returnType;
    }

    int getSelectorValue(Compilation compilation)
    {
        int j = selectorValue;
        int i = j;
        if (j == 0)
        {
            i = compilation.maxSelectorValue;
            compilation.maxSelectorValue = primMethods.length + i;
            i++;
            selectorValue = i;
        }
        return i;
    }

    public Type getType()
    {
        return type;
    }

    public int incomingArgs()
    {
        if (min_args == max_args && max_args <= 4 && max_args > 0)
        {
            return max_args;
        } else
        {
            return 1;
        }
    }

    boolean inlinedIn(LambdaExp lambdaexp)
    {
        for (LambdaExp lambdaexp1 = this; lambdaexp1.getInlineOnly(); lambdaexp1 = lambdaexp1.getCaller())
        {
            if (lambdaexp1 == lambdaexp)
            {
                return true;
            }
        }

        return false;
    }

    public boolean isAbstract()
    {
        return body == QuoteExp.abstractExp;
    }

    public final boolean isClassGenerated()
    {
        return isModuleBody() || (this instanceof ClassExp);
    }

    public final boolean isClassMethod()
    {
        return (flags & 0x40) != 0;
    }

    public final boolean isHandlingTailCalls()
    {
        return isModuleBody() || Compilation.defaultCallConvention >= 3 && !isClassMethod();
    }

    public final boolean isModuleBody()
    {
        return this instanceof ModuleExp;
    }

    public void loadHeapFrame(Compilation compilation)
    {
        LambdaExp lambdaexp;
        for (lambdaexp = compilation.curLambda; lambdaexp != this && lambdaexp.getInlineOnly(); lambdaexp = lambdaexp.getCaller()) { }
        CodeAttr codeattr = compilation.getCode();
        if (lambdaexp.heapFrame != null && this == lambdaexp)
        {
            codeattr.emitLoad(lambdaexp.heapFrame);
        } else
        {
            if (lambdaexp.closureEnv != null)
            {
                codeattr.emitLoad(lambdaexp.closureEnv);
                compilation = (ClassType)lambdaexp.closureEnv.getType();
            } else
            {
                codeattr.emitPushThis();
                compilation = compilation.curClass;
            }
            while (lambdaexp != this) 
            {
                Field field = lambdaexp.staticLinkField;
                Object obj = compilation;
                if (field != null)
                {
                    obj = compilation;
                    if (field.getDeclaringClass() == compilation)
                    {
                        codeattr.emitGetField(field);
                        obj = (ClassType)field.getType();
                    }
                }
                lambdaexp = lambdaexp.outerLambda();
                compilation = ((Compilation) (obj));
            }
        }
    }

    protected boolean mustCompile()
    {
label0:
        {
            if (keywords != null && keywords.length > 0)
            {
                return true;
            }
            if (defaultArgs == null)
            {
                break label0;
            }
            int i = defaultArgs.length;
            Expression expression;
            do
            {
                int j;
                do
                {
                    j = i - 1;
                    if (j < 0)
                    {
                        break label0;
                    }
                    expression = defaultArgs[j];
                    i = j;
                } while (expression == null);
                i = j;
            } while (expression instanceof QuoteExp);
            return true;
        }
        return false;
    }

    public LambdaExp outerLambda()
    {
        if (outer == null)
        {
            return null;
        } else
        {
            return outer.currentLambda();
        }
    }

    public LambdaExp outerLambdaNotInline()
    {
        Object obj = this;
        do
        {
            ScopeExp scopeexp = ((ScopeExp) (obj)).outer;
            if (scopeexp != null)
            {
                obj = scopeexp;
                if (scopeexp instanceof LambdaExp)
                {
                    LambdaExp lambdaexp = (LambdaExp)scopeexp;
                    obj = scopeexp;
                    if (!lambdaexp.getInlineOnly())
                    {
                        return lambdaexp;
                    }
                }
            } else
            {
                return null;
            }
        } while (true);
    }

    public void print(OutPort outport)
    {
        outport.startLogicalBlock("(Lambda/", ")", 2);
        Object obj = getSymbol();
        if (obj != null)
        {
            outport.print(obj);
            outport.print('/');
        }
        outport.print(id);
        outport.print('/');
        outport.print("fl:");
        outport.print(Integer.toHexString(flags));
        outport.writeSpaceFill();
        printLineColumn(outport);
        outport.startLogicalBlock("(", false, ")");
        Object obj1 = null;
        int j = 0;
        Declaration declaration;
        int i;
        int k;
        if (keywords == null)
        {
            i = 0;
        } else
        {
            i = keywords.length;
        }
        if (defaultArgs == null)
        {
            k = 0;
        } else
        {
            k = defaultArgs.length - i;
        }
        declaration = firstDecl();
        if (declaration != null && declaration.isThisParameter())
        {
            j = -1;
            i = 0;
        } else
        {
            i = 0;
        }
        while (declaration != null) 
        {
            Special special;
            if (j < min_args)
            {
                special = null;
            } else
            if (j < min_args + k)
            {
                special = Special.optional;
            } else
            if (max_args < 0 && j == min_args + k)
            {
                special = Special.rest;
            } else
            {
                special = Special.key;
            }
            if (declaration != firstDecl())
            {
                outport.writeSpaceFill();
            }
            if (special != obj1)
            {
                outport.print(special);
                outport.writeSpaceFill();
            }
            obj1 = null;
            if (special == Special.optional || special == Special.key)
            {
                obj1 = defaultArgs;
                int l = i + 1;
                obj1 = obj1[i];
                i = l;
            }
            if (obj1 != null)
            {
                outport.print('(');
            }
            declaration.printInfo(outport);
            if (obj1 != null && obj1 != QuoteExp.falseExp)
            {
                outport.print(' ');
                ((Expression) (obj1)).print(outport);
                outport.print(')');
            }
            j++;
            declaration = declaration.nextDecl();
            obj1 = special;
        }
        outport.endLogicalBlock(")");
        outport.writeSpaceLinear();
        if (body == null)
        {
            outport.print("<null body>");
        } else
        {
            body.print(outport);
        }
        outport.endLogicalBlock(")");
    }

    public final Type restArgType()
    {
        if (min_args != max_args)
        {
            if (primMethods == null)
            {
                throw new Error("internal error - restArgType");
            }
            Method amethod[] = primMethods;
            if (max_args < 0 || amethod.length <= max_args - min_args)
            {
                Method method = amethod[amethod.length - 1];
                Type atype[] = method.getParameterTypes();
                int j = atype.length - 1;
                int i = j;
                if (method.getName().endsWith("$X"))
                {
                    i = j - 1;
                }
                return atype[i];
            }
        }
        return null;
    }

    void setCallersNeedStaticLink()
    {
        LambdaExp lambdaexp1 = outerLambda();
        for (ApplyExp applyexp = nameDecl.firstCall; applyexp != null; applyexp = applyexp.nextCall)
        {
            for (LambdaExp lambdaexp = applyexp.context; lambdaexp != lambdaexp1 && !(lambdaexp instanceof ModuleExp); lambdaexp = lambdaexp.outerLambda())
            {
                lambdaexp.setNeedsStaticLink();
            }

        }

    }

    public final void setCanCall(boolean flag)
    {
        if (flag)
        {
            flags = flags | 4;
            return;
        } else
        {
            flags = flags & -5;
            return;
        }
    }

    public final void setCanRead(boolean flag)
    {
        if (flag)
        {
            flags = flags | 2;
            return;
        } else
        {
            flags = flags & -3;
            return;
        }
    }

    public final void setClassMethod(boolean flag)
    {
        if (flag)
        {
            flags = flags | 0x40;
            return;
        } else
        {
            flags = flags & 0xffffffbf;
            return;
        }
    }

    public final void setCoercedReturnType(Type type1)
    {
        returnType = type1;
        if (type1 != null && type1 != Type.objectType && type1 != Type.voidType && body != QuoteExp.abstractExp)
        {
            Expression expression = body;
            body = Compilation.makeCoercion(expression, type1);
            body.setLine(expression);
        }
    }

    public final void setCoercedReturnValue(Expression expression, Language language)
    {
        if (!isAbstract())
        {
            Expression expression1 = body;
            body = Compilation.makeCoercion(expression1, expression);
            body.setLine(expression1);
        }
        expression = language.getTypeFor(expression);
        if (expression != null)
        {
            setReturnType(expression);
        }
    }

    public void setExceptions(Expression aexpression[])
    {
        throwsSpecification = aexpression;
    }

    public final void setImportsLexVars()
    {
        int i = flags;
        flags = flags | 8;
        if ((i & 8) == 0 && nameDecl != null)
        {
            setCallersNeedStaticLink();
        }
    }

    public final void setImportsLexVars(boolean flag)
    {
        if (flag)
        {
            flags = flags | 8;
            return;
        } else
        {
            flags = flags & -9;
            return;
        }
    }

    public final void setInlineOnly(boolean flag)
    {
        setFlag(flag, 8192);
    }

    public final void setNeedsStaticLink()
    {
        int i = flags;
        flags = flags | 0x10;
        if ((i & 0x10) == 0 && nameDecl != null)
        {
            setCallersNeedStaticLink();
        }
    }

    public final void setNeedsStaticLink(boolean flag)
    {
        if (flag)
        {
            flags = flags | 0x10;
            return;
        } else
        {
            flags = flags & 0xffffffef;
            return;
        }
    }

    public void setProperty(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        properties = PropertySet.setProperty(properties, obj, obj1);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public final void setReturnType(Type type1)
    {
        returnType = type1;
    }

    public void setType(ClassType classtype)
    {
        type = classtype;
    }

    public boolean side_effects()
    {
        return false;
    }

    public String toString()
    {
        String s1 = (new StringBuilder()).append(getExpClassName()).append(':').append(getSymbol()).append('/').append(id).append('/').toString();
        int j = getLineNumber();
        int i = j;
        if (j <= 0)
        {
            i = j;
            if (body != null)
            {
                i = body.getLineNumber();
            }
        }
        String s = s1;
        if (i > 0)
        {
            s = (new StringBuilder()).append(s1).append("l:").append(i).toString();
        }
        return s;
    }

    public Expression validateApply(ApplyExp applyexp, InlineCalls inlinecalls, Type type1, Declaration declaration)
    {
        declaration = applyexp.getArgs();
        if ((flags & 0x1000) == 0) goto _L2; else goto _L1
_L1:
        declaration = InlineCalls.inlineCall(this, declaration, true);
        if (declaration == null) goto _L2; else goto _L3
_L3:
        type1 = inlinecalls.visit(declaration, type1);
_L5:
        return type1;
_L2:
        int i;
        int k;
        applyexp.visitArgs(inlinecalls);
        i = applyexp.args.length;
        type1 = WrongArguments.checkArgCount(getName(), min_args, max_args, i);
        if (type1 != null)
        {
            return inlinecalls.noteError(type1);
        }
        k = getCallConvention();
        type1 = applyexp;
        if (!inlinecalls.getCompilation().inlineOk(this))
        {
            continue; /* Loop/switch isn't completed */
        }
        type1 = applyexp;
        if (!isClassMethod())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k <= 2)
        {
            break; /* Loop/switch isn't completed */
        }
        type1 = applyexp;
        if (k != 3) goto _L5; else goto _L4
_L4:
        declaration = getMethod(i);
        type1 = applyexp;
        if (declaration != null)
        {
            boolean flag = nameDecl.isStatic();
            if (!flag && (outer instanceof ClassExp))
            {
                if (!((ClassExp)outer).isMakingClassPair());
            }
            declaration = new PrimProcedure(declaration, this);
            if (flag)
            {
                inlinecalls = applyexp.args;
            } else
            {
                type1 = inlinecalls.getCurrentLambda();
                Declaration declaration1;
                do
                {
                    if (type1 == null)
                    {
                        return inlinecalls.noteError((new StringBuilder()).append("internal error: missing ").append(this).toString());
                    }
                    if (((LambdaExp) (type1)).outer == outer)
                    {
                        declaration1 = type1.firstDecl();
                        if (declaration1 == null || !declaration1.isThisParameter())
                        {
                            return inlinecalls.noteError((new StringBuilder()).append("calling non-static method ").append(getName()).append(" from static method ").append(type1.getName()).toString());
                        }
                        break;
                    }
                    type1 = type1.outerLambda();
                } while (true);
                int j = applyexp.getArgCount();
                inlinecalls = new Expression[j + 1];
                System.arraycopy(applyexp.getArgs(), 0, inlinecalls, 1, j);
                inlinecalls[0] = new ThisExp(declaration1);
            }
            return (new ApplyExp(declaration, inlinecalls)).setLine(applyexp);
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final boolean variable_args()
    {
        return max_args < 0;
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        LambdaExp lambdaexp;
        Compilation compilation;
        compilation = expvisitor.getCompilation();
        if (compilation == null)
        {
            lambdaexp = null;
        } else
        {
            lambdaexp = compilation.curLambda;
            compilation.curLambda = this;
        }
        expvisitor = ((ExpVisitor) (expvisitor.visitLambdaExp(this, obj)));
        if (compilation != null)
        {
            compilation.curLambda = lambdaexp;
        }
        return expvisitor;
        expvisitor;
        if (compilation != null)
        {
            compilation.curLambda = lambdaexp;
        }
        throw expvisitor;
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        visitChildrenOnly(expvisitor, obj);
        visitProperties(expvisitor, obj);
    }

    protected final void visitChildrenOnly(ExpVisitor expvisitor, Object obj)
    {
        LambdaExp lambdaexp;
        lambdaexp = expvisitor.currentLambda;
        expvisitor.currentLambda = this;
        throwsSpecification = expvisitor.visitExps(throwsSpecification, obj);
        expvisitor.visitDefaultArgs(this, obj);
        if (expvisitor.exitValue == null && body != null)
        {
            body = expvisitor.update(body, expvisitor.visit(body, obj));
        }
        expvisitor.currentLambda = lambdaexp;
        return;
        obj;
        expvisitor.currentLambda = lambdaexp;
        throw obj;
    }

    protected final void visitProperties(ExpVisitor expvisitor, Object obj)
    {
        if (properties != null)
        {
            int j = properties.length;
            for (int i = 1; i < j; i += 2)
            {
                Object obj1 = properties[i];
                if (obj1 instanceof Expression)
                {
                    properties[i] = expvisitor.visitAndUpdate((Expression)obj1, obj);
                }
            }

        }
    }

}
