// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.OutPort;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package gnu.expr:
//            LambdaExp, PairClassType, Compilation, Target, 
//            Expression, Declaration, IgnoreTarget, ModuleExp, 
//            BeginExp, ApplyExp, QuoteExp, PrimProcedure, 
//            Initializer, ClassInitializer, Language, ObjectExp, 
//            ExpVisitor

public class ClassExp extends LambdaExp
{

    public static final int CLASS_SPECIFIED = 0x10000;
    public static final int HAS_SUBCLASS = 0x20000;
    public static final int INTERFACE_SPECIFIED = 32768;
    public static final int IS_ABSTRACT = 16384;
    public String classNameSpecifier;
    public LambdaExp clinitMethod;
    boolean explicitInit;
    public LambdaExp initMethod;
    ClassType instanceType;
    boolean partsDeclared;
    boolean simple;
    public int superClassIndex;
    public Expression supers[];

    public ClassExp()
    {
        superClassIndex = -1;
    }

    public ClassExp(boolean flag)
    {
        superClassIndex = -1;
        simple = flag;
        ClassType classtype = new ClassType();
        type = classtype;
        instanceType = classtype;
    }

    static void getImplMethods(ClassType classtype, String s, Type atype[], Vector vector)
    {
        if (!(classtype instanceof PairClassType)) goto _L2; else goto _L1
_L1:
        Object obj = ((PairClassType)classtype).instanceType;
_L6:
        Type atype1[] = new Type[atype.length + 1];
        atype1[0] = classtype;
        System.arraycopy(atype, 0, atype1, 1, atype.length);
        obj = ((ClassType) (obj)).getDeclaredMethod(s, atype1);
        if (obj != null)
        {
            int i = vector.size();
            if (i == 0 || !vector.elementAt(i - 1).equals(obj))
            {
                vector.addElement(obj);
            }
        } else
        {
            classtype = classtype.getInterfaces();
            int j = 0;
            while (j < classtype.length) 
            {
                getImplMethods(classtype[j], s, atype, vector);
                j++;
            }
        }
_L4:
        return;
_L2:
        if (!classtype.isInterface()) goto _L4; else goto _L3
_L3:
        try
        {
            obj = classtype.getReflectClass();
        }
        // Misplaced declaration of an exception variable
        catch (ClassType classtype)
        {
            return;
        }
        if (obj == null) goto _L4; else goto _L5
_L5:
        obj = (ClassType)Type.make(Class.forName((new StringBuilder()).append(classtype.getName()).append("$class").toString(), false, ((Class) (obj)).getClassLoader()));
          goto _L6
    }

    static void invokeDefaultSuperConstructor(ClassType classtype, Compilation compilation, LambdaExp lambdaexp)
    {
        CodeAttr codeattr = compilation.getCode();
        Method method = classtype.getDeclaredMethod("<init>", 0);
        if (method == null)
        {
            compilation.error('e', "super class does not have a default constructor");
            return;
        }
        codeattr.emitPushThis();
        if (classtype.hasOuterLink() && (lambdaexp instanceof ClassExp))
        {
            lambdaexp = (ClassExp)lambdaexp;
            loadSuperStaticLink(((ClassExp) (lambdaexp)).supers[((ClassExp) (lambdaexp)).superClassIndex], classtype, compilation);
        }
        codeattr.emitInvokeSpecial(method);
    }

    static void loadSuperStaticLink(Expression expression, ClassType classtype, Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        expression.compile(compilation, Target.pushValue(Compilation.typeClassType));
        codeattr.emitInvokeStatic(ClassType.make("gnu.expr.PairClassType").getDeclaredMethod("extractStaticLink", 1));
        codeattr.emitCheckcast(classtype.getOuterLinkType());
    }

    public static String slotToMethodName(String s, String s1)
    {
        String s2 = s1;
        if (!Compilation.isValidJavaName(s1))
        {
            s2 = Compilation.mangleName(s1, false);
        }
        int i = s2.length();
        s1 = new StringBuffer(i + 3);
        s1.append(s);
        if (i > 0)
        {
            s1.append(Character.toTitleCase(s2.charAt(0)));
            s1.append(s2.substring(1));
        }
        return s1.toString();
    }

    private static void usedSuperClasses(ClassType classtype, Compilation compilation)
    {
        compilation.usedClass(classtype.getSuperclass());
        classtype = classtype.getInterfaces();
        if (classtype != null)
        {
            int i = classtype.length;
            do
            {
                i--;
                if (i < 0)
                {
                    break;
                }
                compilation.usedClass(classtype[i]);
            } while (true);
        }
    }

    public Declaration addMethod(LambdaExp lambdaexp, Object obj)
    {
        Declaration declaration = addDeclaration(obj, Compilation.typeProcedure);
        lambdaexp.outer = this;
        lambdaexp.setClassMethod(true);
        declaration.noteValue(lambdaexp);
        declaration.setFlag(0x100000L);
        declaration.setProcedureDecl(true);
        lambdaexp.setSymbol(obj);
        return declaration;
    }

    public void compile(Compilation compilation, Target target)
    {
        if (target instanceof IgnoreTarget)
        {
            return;
        } else
        {
            compileMembers(compilation);
            compilePushClass(compilation, target);
            return;
        }
    }

    public ClassType compileMembers(Compilation compilation)
    {
        Method method;
        ClassType classtype;
        classtype = compilation.curClass;
        method = compilation.method;
        Object obj2;
        ClassType classtype1;
        classtype1 = getCompiledClassType(compilation);
        compilation.curClass = classtype1;
        obj2 = outerLambda();
        Object obj1 = null;
        if (!(obj2 instanceof ClassExp)) goto _L2; else goto _L1
_L1:
        Object obj = ((LambdaExp) (obj2)).type;
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        classtype1.setEnclosingMember(((gnu.bytecode.Member) (obj)));
        if (obj instanceof ClassType)
        {
            ((ClassType)obj).addMemberClass(classtype1);
        }
        if (instanceType != classtype1)
        {
            instanceType.setEnclosingMember(type);
            type.addMemberClass(instanceType);
        }
        usedSuperClasses(type, compilation);
        if (type != instanceType)
        {
            usedSuperClasses(instanceType, compilation);
        }
        obj = getFileName();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        classtype1.setSourceFile(((String) (obj)));
        LambdaExp lambdaexp;
        lambdaexp = compilation.curLambda;
        compilation.curLambda = this;
        allocFrame(compilation);
        obj1 = firstChild;
_L4:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_720;
        }
        if (!((LambdaExp) (obj1)).isAbstract())
        {
            break; /* Loop/switch isn't completed */
        }
_L13:
        obj1 = ((LambdaExp) (obj1)).nextSibling;
        if (true) goto _L4; else goto _L3
_L2:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        if (obj2 instanceof ModuleExp)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        obj = method;
          goto _L5
        obj = obj1;
        if (!(obj2 instanceof ModuleExp)) goto _L5; else goto _L6
_L6:
        obj = obj1;
        if (type.getName().indexOf('$') <= 0) goto _L5; else goto _L7
_L7:
        obj = ((LambdaExp) (obj2)).type;
          goto _L5
_L3:
        Object obj4;
        Object obj5;
        String s;
        int i;
        int j;
        obj4 = compilation.method;
        obj5 = compilation.curLambda;
        s = compilation.getFileName();
        i = compilation.getLineNumber();
        j = compilation.getColumnNumber();
        compilation.setLine(((Expression) (obj1)));
        compilation.method = ((LambdaExp) (obj1)).getMainMethod();
        obj = ((LambdaExp) (obj1)).nameDecl;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        if (((Declaration) (obj)).getFlag(2048L))
        {
            break MISSING_BLOCK_LABEL_312;
        }
        ((LambdaExp) (obj1)).declareThis(compilation.curClass);
        compilation.curClass = instanceType;
        compilation.curLambda = ((LambdaExp) (obj1));
        compilation.method.initCode();
        ((LambdaExp) (obj1)).allocChildClasses(compilation);
        ((LambdaExp) (obj1)).allocParameters(compilation);
        if (!"*init*".equals(((LambdaExp) (obj1)).getName()))
        {
            break MISSING_BLOCK_LABEL_707;
        }
        obj = compilation.getCode();
        if (staticLinkField != null)
        {
            ((CodeAttr) (obj)).emitPushThis();
            ((CodeAttr) (obj)).emitLoad(((CodeAttr) (obj)).getCurrentScope().getVariable(1));
            ((CodeAttr) (obj)).emitPutField(staticLinkField);
        }
        obj = ((LambdaExp) (obj1)).body;
_L8:
        if (!(obj instanceof BeginExp))
        {
            break MISSING_BLOCK_LABEL_430;
        }
        obj = (BeginExp)obj;
        if (((BeginExp) (obj)).length != 0)
        {
            break MISSING_BLOCK_LABEL_420;
        }
        obj = null;
          goto _L8
        obj = ((BeginExp) (obj)).exps[0];
          goto _L8
        Object obj3;
        obj3 = null;
        obj2 = obj3;
        Object obj6;
        if (!(obj instanceof ApplyExp))
        {
            break MISSING_BLOCK_LABEL_536;
        }
        obj6 = ((ApplyExp)obj).func;
        obj2 = obj3;
        if (!(obj6 instanceof QuoteExp))
        {
            break MISSING_BLOCK_LABEL_536;
        }
        obj6 = ((QuoteExp)obj6).getValue();
        obj2 = obj3;
        if (!(obj6 instanceof PrimProcedure))
        {
            break MISSING_BLOCK_LABEL_536;
        }
        obj6 = (PrimProcedure)obj6;
        obj2 = obj3;
        if (!((PrimProcedure) (obj6)).isSpecial())
        {
            break MISSING_BLOCK_LABEL_536;
        }
        obj2 = obj3;
        if ("<init>".equals(((PrimProcedure) (obj6)).method.getName()))
        {
            obj2 = ((PrimProcedure) (obj6)).method.getDeclaringClass();
        }
        obj3 = instanceType.getSuperclass();
        if (obj2 == null) goto _L10; else goto _L9
_L9:
        ((Expression) (obj)).compileWithPosition(compilation, Target.Ignore);
        if (obj2 == instanceType || obj2 == obj3)
        {
            break MISSING_BLOCK_LABEL_583;
        }
        compilation.error('e', "call to <init> for not this or super class");
_L15:
        ((LambdaExp) (obj1)).enterFunction(compilation);
        if (obj2 != instanceType)
        {
            compilation.callInitMethods(getCompiledClassType(compilation), new Vector(10));
        }
        if (obj2 == null) goto _L12; else goto _L11
_L11:
        Expression.compileButFirst(((LambdaExp) (obj1)).body, compilation);
_L16:
        ((LambdaExp) (obj1)).compileEnd(compilation);
        ((LambdaExp) (obj1)).generateApplyMethods(compilation);
        compilation.method = ((Method) (obj4));
        compilation.curClass = classtype1;
        compilation.curLambda = ((LambdaExp) (obj5));
        compilation.setLine(s, i, j);
          goto _L13
        Exception exception;
        exception;
        compilation.curClass = classtype;
        compilation.method = method;
        throw exception;
_L10:
        if (obj3 == null) goto _L15; else goto _L14
_L14:
        invokeDefaultSuperConstructor(((ClassType) (obj3)), compilation, this);
          goto _L15
_L12:
        ((LambdaExp) (obj1)).compileBody(compilation);
          goto _L16
        ((LambdaExp) (obj1)).enterFunction(compilation);
        ((LambdaExp) (obj1)).compileBody(compilation);
          goto _L16
        if (explicitInit || instanceType.isInterface()) goto _L18; else goto _L17
_L17:
        compilation.generateConstructor(instanceType, this);
_L27:
        if (!isAbstract()) goto _L20; else goto _L19
_L19:
        Method amethod[];
        amethod = null;
        i = 0;
          goto _L21
_L35:
        if (j >= i) goto _L23; else goto _L22
_L22:
        obj2 = amethod[j];
        Type atype[];
        obj5 = ((Method) (obj2)).getName();
        atype = ((Method) (obj2)).getParameterTypes();
        obj3 = ((Method) (obj2)).getReturnType();
        obj1 = instanceType.getMethod(((String) (obj5)), atype);
        if (obj1 == null) goto _L25; else goto _L24
_L24:
        if (!((Method) (obj1)).isAbstract())
        {
            break MISSING_BLOCK_LABEL_1259;
        }
          goto _L25
_L18:
        if (initChain == null) goto _L27; else goto _L26
_L26:
        initChain.reportError("unimplemented: explicit constructor cannot initialize ", compilation);
          goto _L27
_L20:
        amethod = type.getAbstractMethods();
        i = amethod.length;
          goto _L21
_L25:
        char c;
        if (((String) (obj5)).length() <= 3 || ((String) (obj5)).charAt(2) != 't' || ((String) (obj5)).charAt(1) != 'e')
        {
            break MISSING_BLOCK_LABEL_1088;
        }
        c = ((String) (obj5)).charAt(0);
        if (c != 'g' && c != 's')
        {
            break MISSING_BLOCK_LABEL_1088;
        }
        if (c != 's') goto _L29; else goto _L28
_L28:
        if (!((Type) (obj3)).isVoid() || atype.length != 1) goto _L29; else goto _L30
_L30:
        obj2 = atype[0];
_L31:
        obj6 = (new StringBuilder()).append(Character.toLowerCase(((String) (obj5)).charAt(3))).append(((String) (obj5)).substring(4)).toString();
        obj4 = instanceType.getField(((String) (obj6)));
        obj1 = obj4;
        if (obj4 != null)
        {
            break MISSING_BLOCK_LABEL_1003;
        }
        obj1 = instanceType.addField(((String) (obj6)), ((Type) (obj2)), 1);
        obj2 = instanceType.addMethod(((String) (obj5)), 1, atype, ((Type) (obj3))).startCode();
        ((CodeAttr) (obj2)).emitPushThis();
        if (c != 'g')
        {
            break MISSING_BLOCK_LABEL_1068;
        }
        ((CodeAttr) (obj2)).emitGetField(((Field) (obj1)));
_L32:
        ((CodeAttr) (obj2)).emitReturn();
        break MISSING_BLOCK_LABEL_1259;
_L29:
        if (c != 'g')
        {
            break MISSING_BLOCK_LABEL_1259;
        }
        if (atype.length != 0)
        {
            break MISSING_BLOCK_LABEL_1259;
        }
        obj2 = obj3;
          goto _L31
        ((CodeAttr) (obj2)).emitLoad(((CodeAttr) (obj2)).getArg(1));
        ((CodeAttr) (obj2)).emitPutField(((Field) (obj1)));
          goto _L32
        obj4 = new Vector();
        getImplMethods(type, ((String) (obj5)), atype, ((Vector) (obj4)));
        if (((Vector) (obj4)).size() == 1)
        {
            break MISSING_BLOCK_LABEL_1159;
        }
        if (((Vector) (obj4)).size() == 0)
        {
            obj1 = "missing implementation for ";
        } else
        {
            obj1 = "ambiguous implementation for ";
        }
        compilation.error('e', (new StringBuilder()).append(((String) (obj1))).append(obj2).toString());
        break MISSING_BLOCK_LABEL_1259;
        obj2 = instanceType.addMethod(((String) (obj5)), 1, atype, ((Type) (obj3))).startCode();
        obj1 = ((CodeAttr) (obj2)).getCurrentScope().firstVar();
_L34:
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        ((CodeAttr) (obj2)).emitLoad(((Variable) (obj1)));
        obj1 = ((Variable) (obj1)).nextVar();
        if (true) goto _L34; else goto _L33
_L33:
        ((CodeAttr) (obj2)).emitInvokeStatic((Method)((Vector) (obj4)).elementAt(0));
        ((CodeAttr) (obj2)).emitReturn();
        break MISSING_BLOCK_LABEL_1259;
_L23:
        generateApplyMethods(compilation);
        compilation.curLambda = lambdaexp;
        compilation.curClass = classtype;
        compilation.method = method;
        return classtype1;
_L21:
        j = 0;
          goto _L35
        j++;
          goto _L35
    }

    public void compilePushClass(Compilation compilation, Target target)
    {
        ClassType classtype = type;
        CodeAttr codeattr = compilation.getCode();
        compilation.loadClassRef(classtype);
        boolean flag = getNeedsClosureEnv();
        if (isSimple() && !flag)
        {
            return;
        }
        Type atype[];
        byte byte0;
        if (isMakingClassPair() || flag)
        {
            ClassType classtype1;
            int i;
            if (classtype == instanceType)
            {
                codeattr.emitDup(instanceType);
            } else
            {
                compilation.loadClassRef(instanceType);
            }
            classtype = ClassType.make("gnu.expr.PairClassType");
            if (flag)
            {
                byte0 = 3;
            } else
            {
                byte0 = 2;
            }
        } else
        {
            classtype = ClassType.make("gnu.bytecode.Type");
            byte0 = 1;
        }
        atype = new Type[byte0];
        i = byte0;
        if (flag)
        {
            getOwningLambda().loadHeapFrame(compilation);
            i = byte0 - 1;
            atype[i] = Type.pointer_type;
        }
        classtype1 = ClassType.make("java.lang.Class");
        do
        {
            i--;
            if (i >= 0)
            {
                atype[i] = classtype1;
            } else
            {
                codeattr.emitInvokeStatic(classtype.addMethod("make", atype, classtype, 9));
                target.compileFromStack(compilation, classtype);
                return;
            }
        } while (true);
    }

    public Field compileSetField(Compilation compilation)
    {
        return (new ClassInitializer(this, compilation)).field;
    }

    public void declareParts(Compilation compilation)
    {
        if (!partsDeclared)
        {
            partsDeclared = true;
            Hashtable hashtable = new Hashtable();
            Declaration declaration = firstDecl();
            while (declaration != null) 
            {
                if (declaration.getCanRead())
                {
                    short word0 = declaration.getAccessFlags((short)1);
                    int i = word0;
                    if (declaration.getFlag(2048L))
                    {
                        i = word0 | 8;
                    }
                    if (isMakingClassPair())
                    {
                        i |= 0x400;
                        Type type = declaration.getType().getImplementationType();
                        this.type.addMethod(slotToMethodName("get", declaration.getName()), i, Type.typeArray0, type);
                        ClassType classtype = this.type;
                        String s1 = slotToMethodName("set", declaration.getName());
                        gnu.bytecode.PrimType primtype = Type.voidType;
                        classtype.addMethod(s1, i, new Type[] {
                            type
                        }, primtype);
                    } else
                    {
                        String s = Compilation.mangleNameIfNeeded(declaration.getName());
                        declaration.field = instanceType.addField(s, declaration.getType(), i);
                        declaration.setSimple(false);
                        Declaration declaration1 = (Declaration)hashtable.get(s);
                        if (declaration1 != null)
                        {
                            duplicateDeclarationError(declaration1, declaration, compilation);
                        }
                        hashtable.put(s, declaration);
                    }
                }
                declaration = declaration.nextDecl();
            }
            for (LambdaExp lambdaexp = firstChild; lambdaexp != null; lambdaexp = lambdaexp.nextSibling)
            {
                if (lambdaexp.isAbstract())
                {
                    setFlag(16384);
                }
                if ("*init*".equals(lambdaexp.getName()))
                {
                    explicitInit = true;
                    if (lambdaexp.isAbstract())
                    {
                        compilation.error('e', "*init* method cannot be abstract", lambdaexp);
                    }
                    if (this.type instanceof PairClassType)
                    {
                        compilation.error('e', "'*init*' methods only supported for simple classes");
                    }
                }
                lambdaexp.outer = this;
                if (lambdaexp != initMethod && lambdaexp != clinitMethod && lambdaexp.nameDecl != null && !lambdaexp.nameDecl.getFlag(2048L) || !isMakingClassPair())
                {
                    lambdaexp.addMethodFor(this.type, compilation, null);
                }
                if (isMakingClassPair())
                {
                    lambdaexp.addMethodFor(instanceType, compilation, this.type);
                }
            }

            if (!explicitInit && !instanceType.isInterface())
            {
                Compilation.getConstructor(instanceType, this);
            }
            if (isAbstract())
            {
                instanceType.setModifiers(instanceType.getModifiers() | 0x400);
            }
            if (nameDecl != null)
            {
                instanceType.setModifiers(instanceType.getModifiers() & -2 | nameDecl.getAccessFlags((short)1));
                return;
            }
        }
    }

    public ClassType getClassType()
    {
        return type;
    }

    protected ClassType getCompiledClassType(Compilation compilation)
    {
        return type;
    }

    public Type getType()
    {
        if (simple)
        {
            return Compilation.typeClass;
        } else
        {
            return Compilation.typeClassType;
        }
    }

    public final boolean isAbstract()
    {
        return getFlag(16384);
    }

    public boolean isMakingClassPair()
    {
        return type != instanceType;
    }

    public boolean isSimple()
    {
        return simple;
    }

    protected boolean mustCompile()
    {
        return true;
    }

    public void print(OutPort outport)
    {
        outport.startLogicalBlock((new StringBuilder()).append("(").append(getExpClassName()).append("/").toString(), ")", 2);
        Object obj = getSymbol();
        if (obj != null)
        {
            outport.print(obj);
            outport.print('/');
        }
        outport.print(id);
        outport.print("/fl:");
        outport.print(Integer.toHexString(flags));
        if (supers.length > 0)
        {
            outport.writeSpaceFill();
            outport.startLogicalBlock("supers:", "", 2);
            for (int i = 0; i < supers.length; i++)
            {
                supers[i].print(outport);
                outport.writeSpaceFill();
            }

            outport.endLogicalBlock("");
        }
        outport.print('(');
        int j = 0;
        int k;
        if (keywords != null)
        {
            k = keywords.length;
        }
        for (obj = firstDecl(); obj != null; obj = ((Declaration) (obj)).nextDecl())
        {
            if (j > 0)
            {
                outport.print(' ');
            }
            ((Declaration) (obj)).printInfo(outport);
            j++;
        }

        outport.print(") ");
        for (LambdaExp lambdaexp = firstChild; lambdaexp != null; lambdaexp = lambdaexp.nextSibling)
        {
            outport.writeBreakLinear();
            lambdaexp.print(outport);
        }

        if (body != null)
        {
            outport.writeBreakLinear();
            body.print(outport);
        }
        outport.endLogicalBlock(")");
    }

    public void setSimple(boolean flag)
    {
        simple = flag;
    }

    public void setTypes(Compilation compilation)
    {
        Object obj;
        Object obj3;
        int i;
        int j;
        ClassType aclasstype[];
        int l;
        if (supers == null)
        {
            j = 0;
        } else
        {
            j = supers.length;
        }
        aclasstype = new ClassType[j];
        obj = null;
        l = 0;
        i = 0;
        while (l < j) 
        {
            Object obj1 = Language.getDefaultLanguage().getTypeFor(supers[l]);
            if (!(obj1 instanceof ClassType))
            {
                compilation.setLine(supers[l]);
                compilation.error('e', "invalid super type");
            } else
            {
                obj1 = (ClassType)obj1;
                int i1;
                try
                {
                    i1 = ((ClassType) (obj1)).getModifiers();
                }
                catch (RuntimeException runtimeexception)
                {
                    boolean flag = false;
                    i1 = ((flag) ? 1 : 0);
                    if (compilation != null)
                    {
                        compilation.error('e', (new StringBuilder()).append("unknown super-type ").append(((ClassType) (obj1)).getName()).toString());
                        i1 = ((flag) ? 1 : 0);
                    }
                }
                if ((i1 & 0x200) == 0)
                {
                    if (i < l)
                    {
                        compilation.error('e', (new StringBuilder()).append("duplicate superclass for ").append(this).toString());
                    }
                    obj = obj1;
                    superClassIndex = l;
                } else
                {
                    int j1 = i + 1;
                    aclasstype[i] = ((ClassType) (obj1));
                    i = j1;
                }
            }
            l++;
        }
        if (obj != null && (flags & 0x8000) != 0)
        {
            compilation.error('e', "cannot be interface since has superclass");
        }
        ClassType classtype;
        if (!simple && obj == null && (flags & 0x10000) == 0 && (getFlag(0x20000) || nameDecl != null && nameDecl.isPublic()))
        {
            Object obj2 = new PairClassType();
            type = ((ClassType) (obj2));
            ((PairClassType) (obj2)).setInterface(true);
            obj2.instanceType = instanceType;
            obj2 = type;
            instanceType.setSuper(Type.pointer_type);
            instanceType.setInterfaces(new ClassType[] {
                obj2
            });
        } else
        if (getFlag(32768))
        {
            instanceType.setInterface(true);
        }
        classtype = type;
        obj3 = obj;
        if (obj == null)
        {
            obj3 = Type.pointer_type;
        }
        classtype.setSuper(((ClassType) (obj3)));
        if (i == j)
        {
            obj = aclasstype;
        } else
        {
            obj = new ClassType[i];
            System.arraycopy(aclasstype, 0, obj, 0, i);
        }
        type.setInterfaces(((ClassType []) (obj)));
        if (type.getName() != null) goto _L2; else goto _L1
_L1:
        if (classNameSpecifier != null)
        {
            obj = classNameSpecifier;
        } else
        {
            obj3 = getName();
            obj = obj3;
            if (obj3 != null)
            {
                i = ((String) (obj3)).length();
                obj = obj3;
                if (i > 2)
                {
                    obj = obj3;
                    if (((String) (obj3)).charAt(0) == '<')
                    {
                        obj = obj3;
                        if (((String) (obj3)).charAt(i - 1) == '>')
                        {
                            obj = ((String) (obj3)).substring(1, i - 1);
                        }
                    }
                }
            }
        }
        if (obj != null) goto _L4; else goto _L3
_L3:
        obj3 = new StringBuffer(100);
        compilation.getModule().classFor(compilation);
        ((StringBuffer) (obj3)).append(compilation.mainClass.getName());
        ((StringBuffer) (obj3)).append('$');
        j = ((StringBuffer) (obj3)).length();
        i = 0;
_L7:
        ((StringBuffer) (obj3)).append(i);
        obj = ((StringBuffer) (obj3)).toString();
        if (compilation.findNamedClass(((String) (obj))) != null) goto _L6; else goto _L5
_L5:
        type.setName(((String) (obj)));
        compilation.addClass(type);
        if (isMakingClassPair())
        {
            instanceType.setName((new StringBuilder()).append(type.getName()).append("$class").toString());
            compilation.addClass(instanceType);
        }
_L2:
        return;
_L6:
        ((StringBuffer) (obj3)).setLength(j);
        i++;
          goto _L7
_L4:
label0:
        {
            if (isSimple() && !(this instanceof ObjectExp))
            {
                break label0;
            }
            obj = compilation.generateClassName(((String) (obj)));
        }
          goto _L5
        StringBuffer stringbuffer;
        i = 0;
        stringbuffer = new StringBuffer(100);
_L8:
label1:
        {
            int k = ((String) (obj)).indexOf('.', i);
            if (k >= 0)
            {
                break label1;
            }
            if (i == 0)
            {
                String s;
                if (compilation.mainClass == null)
                {
                    s = null;
                } else
                {
                    s = compilation.mainClass.getName();
                }
                if (s == null)
                {
                    k = -1;
                } else
                {
                    k = s.lastIndexOf('.');
                }
                if (k > 0)
                {
                    stringbuffer.append(s.substring(0, k + 1));
                } else
                if (compilation.classPrefix != null)
                {
                    stringbuffer.append(compilation.classPrefix);
                }
            } else
            if (i == 1 && i < ((String) (obj)).length())
            {
                stringbuffer.setLength(0);
                stringbuffer.append(compilation.mainClass.getName());
                stringbuffer.append('$');
            }
            if (i < ((String) (obj)).length())
            {
                stringbuffer.append(Compilation.mangleNameIfNeeded(((String) (obj)).substring(i)));
            }
            obj = stringbuffer.toString();
        }
          goto _L5
        stringbuffer.append(Compilation.mangleNameIfNeeded(((String) (obj)).substring(i, k)));
        k++;
        i = k;
        if (k < ((String) (obj)).length())
        {
            stringbuffer.append('.');
            i = k;
        }
          goto _L8
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        Compilation compilation;
        ClassType classtype;
        compilation = expvisitor.getCompilation();
        if (compilation == null)
        {
            return expvisitor.visitClassExp(this, obj);
        }
        classtype = compilation.curClass;
        compilation.curClass = type;
        expvisitor = ((ExpVisitor) (expvisitor.visitClassExp(this, obj)));
        compilation.curClass = classtype;
        return expvisitor;
        expvisitor;
        compilation.curClass = classtype;
        throw expvisitor;
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        LambdaExp lambdaexp1;
        lambdaexp1 = expvisitor.currentLambda;
        expvisitor.currentLambda = this;
        supers = expvisitor.visitExps(supers, supers.length, obj);
        LambdaExp lambdaexp = firstChild;
_L2:
        if (lambdaexp == null)
        {
            break; /* Loop/switch isn't completed */
        }
        Declaration declaration;
        if (expvisitor.exitValue != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (instanceType == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        declaration = lambdaexp.firstDecl();
        if (declaration == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (declaration.isThisParameter())
        {
            declaration.setType(type);
        }
        expvisitor.visitLambdaExp(lambdaexp, obj);
        lambdaexp = lambdaexp.nextSibling;
        if (true) goto _L2; else goto _L1
_L1:
        expvisitor.currentLambda = lambdaexp1;
        return;
        obj;
        expvisitor.currentLambda = lambdaexp1;
        throw obj;
    }
}
