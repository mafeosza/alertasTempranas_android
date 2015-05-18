// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassFileInput;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.kawa.functions.MakeList;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.ConsumerWriter;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;

// Referenced classes of package gnu.expr:
//            Inlineable, Language, LambdaExp, Compilation, 
//            Expression, Declaration, CheckedTarget, Target, 
//            IgnoreTarget, ConsumerTarget, GenericProc, ModuleMethod, 
//            PairClassType, ApplyExp, ClassExp, ReferenceExp, 
//            LetExp

public class PrimProcedure extends MethodProc
    implements Inlineable
{

    private static ClassLoader systemClassLoader = gnu/expr/PrimProcedure.getClassLoader();
    Type argTypes[];
    Member member;
    Method method;
    char mode;
    int op_code;
    Type retType;
    boolean sideEffectFree;
    LambdaExp source;

    public PrimProcedure(int i, ClassType classtype, String s, Type type, Type atype[])
    {
        char c = '\0';
        super();
        op_code = i;
        byte byte0;
        if (i == 184)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        method = classtype.addMethod(s, byte0, atype, type);
        retType = type;
        argTypes = atype;
        if (i != 184)
        {
            c = 'V';
        }
        mode = c;
    }

    public PrimProcedure(int i, Type type, Type atype[])
    {
        op_code = i;
        retType = type;
        argTypes = atype;
    }

    public PrimProcedure(Method method1)
    {
        init(method1);
        if (method1.getName().endsWith("$X"))
        {
            method1 = Type.objectType;
        } else
        {
            method1 = method1.getReturnType();
        }
        retType = method1;
    }

    public PrimProcedure(Method method1, char c, Language language)
    {
        mode = c;
        init(method1);
        Type atype[] = argTypes;
        int j = atype.length;
        argTypes = null;
        int i = j;
        do
        {
            int k = i - 1;
            if (k < 0)
            {
                break;
            }
            Type type = atype[k];
            Type type1 = language.getLangTypeFor(type);
            i = k;
            if (type != type1)
            {
                if (argTypes == null)
                {
                    argTypes = new Type[j];
                    System.arraycopy(atype, 0, argTypes, 0, j);
                }
                argTypes[k] = type1;
                i = k;
            }
        } while (true);
        if (argTypes == null)
        {
            argTypes = atype;
        }
        if (isConstructor())
        {
            retType = method1.getDeclaringClass();
        } else
        {
            if (method1.getName().endsWith("$X"))
            {
                retType = Type.objectType;
                return;
            }
            retType = language.getLangTypeFor(method1.getReturnType());
            if (retType == Type.toStringType)
            {
                retType = Type.javalangStringType;
                return;
            }
        }
    }

    public PrimProcedure(Method method1, LambdaExp lambdaexp)
    {
        this(method1);
        retType = lambdaexp.getReturnType();
        source = lambdaexp;
    }

    public PrimProcedure(Method method1, Language language)
    {
        this(method1, '\0', language);
    }

    public PrimProcedure(String s, String s1, int i)
    {
        this(ClassType.make(s).getDeclaredMethod(s1, i));
    }

    public PrimProcedure(java.lang.reflect.Method method1, Language language)
    {
        this(((ClassType)language.getTypeFor(method1.getDeclaringClass())).getMethod(method1), language);
    }

    private void compileArgs(Expression aexpression[], int i, Type type, Compilation compilation)
    {
        Object obj;
        Object obj1;
        Object obj2;
        String s;
        CodeAttr codeattr;
        int j;
        int k;
        boolean flag;
        int i1;
        int j1;
        int k1;
        boolean flag4 = takesVarArgs();
        s = getName();
        obj2 = null;
        codeattr = compilation.getCode();
        int l;
        boolean flag1;
        boolean flag3;
        if (type == Type.voidType)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        j = argTypes.length - k;
        l = j;
        if (takesContext())
        {
            l = j - 1;
        }
        k1 = aexpression.length - i;
        if (type == null || k != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = false;
        j1 = 0;
        j = ((flag1) ? 1 : 0);
        flag3 = flag4;
        if (flag4)
        {
            j = ((flag1) ? 1 : 0);
            flag3 = flag4;
            if ((method.getModifiers() & 0x80) != 0)
            {
                j = ((flag1) ? 1 : 0);
                flag3 = flag4;
                if (k1 > 0)
                {
                    j = ((flag1) ? 1 : 0);
                    flag3 = flag4;
                    if (argTypes.length > 0)
                    {
                        if (flag)
                        {
                            i1 = 0;
                        } else
                        {
                            i1 = 1;
                        }
                        j = ((flag1) ? 1 : 0);
                        flag3 = flag4;
                        if (k1 == i1 + l)
                        {
                            Type type1 = aexpression[aexpression.length - 1].getType();
                            Type type2 = argTypes[argTypes.length - 1];
                            j = ((flag1) ? 1 : 0);
                            flag3 = flag4;
                            if (type1 instanceof ObjectType)
                            {
                                j = ((flag1) ? 1 : 0);
                                flag3 = flag4;
                                if (type2 instanceof ArrayType)
                                {
                                    j = ((flag1) ? 1 : 0);
                                    flag3 = flag4;
                                    if (!(((ArrayType)type2).getComponentType() instanceof ArrayType))
                                    {
                                        j = j1;
                                        if (!(type1 instanceof ArrayType))
                                        {
                                            j = 1;
                                        }
                                        flag3 = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (flag3)
        {
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            i1 = l - i1;
        } else
        {
            i1 = aexpression.length - i;
        }
        if (source == null)
        {
            obj1 = null;
        } else
        {
            obj1 = source.firstDecl();
        }
        obj = obj1;
        if (obj1 != null)
        {
            obj = obj1;
            if (((Declaration) (obj1)).isThisParameter())
            {
                obj = ((Declaration) (obj1)).nextDecl();
            }
        }
        j1 = 0;
        obj1 = obj2;
        obj2 = obj;
_L9:
        obj = obj1;
        if (!flag3) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if (j1 != i1) goto _L2; else goto _L3
_L3:
        obj = argTypes[(l - 1) + k];
        if (obj != Compilation.scmListType && obj != LangObjType.listType) goto _L5; else goto _L4
_L4:
        MakeList.compile(aexpression, i + j1, compilation);
_L7:
        return;
_L5:
        codeattr.emitPushInt(aexpression.length - i - i1);
        obj = ((ArrayType)obj).getComponentType();
        codeattr.emitNewArray(((Type) (obj)));
_L2:
        if (j1 >= k1) goto _L7; else goto _L6
_L6:
label0:
        {
            boolean flag2;
            if (j && j1 + 1 == k1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (j1 >= i1)
            {
                codeattr.emitDup(1);
                codeattr.emitPushInt(j1 - i1);
            } else
            if (obj2 != null && (flag || j1 > 0))
            {
                obj = ((Declaration) (obj2)).getType();
            } else
            if (flag)
            {
                obj = argTypes[j1 + k];
            } else
            if (j1 == 0)
            {
                obj = type;
            } else
            {
                obj = argTypes[j1 - 1];
            }
            compilation.usedClass(((Type) (obj)));
            if (flag2)
            {
                obj1 = Type.objectType;
            } else
            {
                obj1 = obj;
            }
            if (source == null)
            {
                obj1 = CheckedTarget.getInstance(((Type) (obj1)), s, j1 + 1);
            } else
            {
                obj1 = CheckedTarget.getInstance(((Type) (obj1)), source, j1);
            }
            aexpression[i + j1].compileNotePosition(compilation, ((Target) (obj1)), aexpression[i + j1]);
            if (flag2)
            {
                obj1 = ((ArrayType)obj).getComponentType();
                codeattr.emitDup();
                codeattr.emitInstanceof(((Type) (obj)));
                codeattr.emitIfIntNotZero();
                codeattr.emitCheckcast(((Type) (obj)));
                codeattr.emitElse();
                codeattr.emitPushInt(1);
                codeattr.emitNewArray(((Type) (obj1)));
                codeattr.emitDupX();
                codeattr.emitSwap();
                codeattr.emitPushInt(0);
                codeattr.emitSwap();
                ((Type) (obj1)).emitCoerceFromObject(codeattr);
                codeattr.emitArrayStore(((Type) (obj)));
                codeattr.emitFi();
            }
            if (j1 >= i1)
            {
                codeattr.emitArrayStore(((Type) (obj)));
            }
            obj1 = obj2;
            if (obj2 == null)
            {
                break label0;
            }
            if (!flag)
            {
                obj1 = obj2;
                if (j1 <= 0)
                {
                    break label0;
                }
            }
            obj1 = ((Declaration) (obj2)).nextDecl();
        }
        j1++;
        obj2 = obj1;
        obj1 = obj;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void compileInvoke(Compilation compilation, Method method1, Target target, boolean flag, int i, Type type)
    {
        CodeAttr codeattr;
        codeattr = compilation.getCode();
        compilation.usedClass(method1.getDeclaringClass());
        compilation.usedClass(method1.getReturnType());
        if (takesContext(method1)) goto _L2; else goto _L1
_L1:
        codeattr.emitInvokeMethod(method1, i);
_L6:
        target.compileFromStack(compilation, type);
_L4:
        return;
_L2:
        if (!(target instanceof IgnoreTarget) && (!(target instanceof ConsumerTarget) || !((ConsumerTarget)target).isContextTarget()))
        {
            break; /* Loop/switch isn't completed */
        }
        type = null;
        Object obj = null;
        compilation.loadCallContext();
        if (target instanceof IgnoreTarget)
        {
            obj = Compilation.typeCallContext;
            type = ((ClassType) (obj)).getDeclaredField("consumer");
            codeattr.pushScope();
            obj = codeattr.addLocal(((Type) (obj)));
            codeattr.emitDup();
            codeattr.emitGetField(type);
            codeattr.emitStore(((gnu.bytecode.Variable) (obj)));
            codeattr.emitDup();
            codeattr.emitGetStatic(ClassType.make("gnu.lists.VoidConsumer").getDeclaredField("instance"));
            codeattr.emitPutField(type);
        }
        codeattr.emitInvokeMethod(method1, i);
        if (flag)
        {
            compilation.loadCallContext();
            codeattr.emitInvoke(Compilation.typeCallContext.getDeclaredMethod("runUntilDone", 0));
        }
        if (target instanceof IgnoreTarget)
        {
            compilation.loadCallContext();
            codeattr.emitLoad(((gnu.bytecode.Variable) (obj)));
            codeattr.emitPutField(type);
            codeattr.popScope();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        compilation.loadCallContext();
        type = Type.objectType;
        codeattr.pushScope();
        gnu.bytecode.Variable variable = codeattr.addLocal(Type.intType);
        compilation.loadCallContext();
        codeattr.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("startFromContext", 0));
        codeattr.emitStore(variable);
        codeattr.emitWithCleanupStart();
        codeattr.emitInvokeMethod(method1, i);
        codeattr.emitWithCleanupCatch(null);
        compilation.loadCallContext();
        codeattr.emitLoad(variable);
        codeattr.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("cleanupFromContext", 1));
        codeattr.emitWithCleanupDone();
        compilation.loadCallContext();
        codeattr.emitLoad(variable);
        codeattr.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("getFromContext", 1));
        codeattr.popScope();
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void disassemble(Procedure procedure, ClassTypeWriter classtypewriter)
        throws Exception
    {
        ClassType classtype;
        Object obj2;
        if (procedure instanceof GenericProc)
        {
            GenericProc genericproc = (GenericProc)procedure;
            int j = genericproc.getMethodCount();
            classtypewriter.print("Generic procedure with ");
            classtypewriter.print(j);
            if (j == 1)
            {
                procedure = " method.";
            } else
            {
                procedure = "methods.";
            }
            classtypewriter.println(procedure);
            for (int i = 0; i < j; i++)
            {
                procedure = genericproc.getMethod(i);
                if (procedure != null)
                {
                    classtypewriter.println();
                    disassemble(procedure, classtypewriter);
                }
            }

            break MISSING_BLOCK_LABEL_348;
        }
        classtype = null;
        obj2 = procedure.getClass();
        if (!(procedure instanceof ModuleMethod)) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj1 = ((ModuleMethod)procedure).module.getClass();
        obj = classtype;
_L4:
        Object obj3;
        java.io.InputStream inputstream;
        obj2 = ((Class) (obj1)).getClassLoader();
        obj1 = ((Class) (obj1)).getName();
        obj3 = (new StringBuilder()).append(((String) (obj1)).replace('.', '/')).append(".class").toString();
        classtype = new ClassType();
        inputstream = ((ClassLoader) (obj2)).getResourceAsStream(((String) (obj3)));
        if (inputstream == null)
        {
            throw new RuntimeException((new StringBuilder()).append("missing resource ").append(((String) (obj3))).toString());
        }
        break; /* Loop/switch isn't completed */
_L2:
        obj1 = obj2;
        obj = classtype;
        if (procedure instanceof PrimProcedure)
        {
            obj3 = ((PrimProcedure)procedure).method;
            obj1 = obj2;
            obj = classtype;
            if (obj3 != null)
            {
                obj1 = ((Method) (obj3)).getDeclaringClass().getReflectClass();
                obj = ((Method) (obj3)).getName();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        new ClassFileInput(classtype, inputstream);
        classtypewriter.setClass(classtype);
        obj2 = ((ClassLoader) (obj2)).getResource(((String) (obj3)));
        classtypewriter.print("In class ");
        classtypewriter.print(((String) (obj1)));
        if (obj2 != null)
        {
            classtypewriter.print(" at ");
            classtypewriter.print(obj2);
        }
        classtypewriter.println();
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        procedure = procedure.getName();
        if (procedure != null)
        {
            break MISSING_BLOCK_LABEL_349;
        }
        classtypewriter.println("Anonymous function - unknown method.");
        return;
        obj1 = Compilation.mangleName(procedure);
        for (procedure = classtype.getMethods(); procedure != null; procedure = procedure.getNext())
        {
            if (procedure.getName().equals(obj1))
            {
                classtypewriter.printMethod(procedure);
            }
        }

        classtypewriter.flush();
        return;
    }

    public static void disassemble(Procedure procedure, Writer writer)
        throws Exception
    {
        disassemble(procedure, new ClassTypeWriter(null, writer, 0));
    }

    public static void disassemble$X(Procedure procedure, CallContext callcontext)
        throws Exception
    {
        callcontext = callcontext.consumer;
        if (callcontext instanceof Writer)
        {
            callcontext = (Writer)callcontext;
        } else
        {
            callcontext = new ConsumerWriter(callcontext);
        }
        disassemble(procedure, callcontext);
    }

    public static PrimProcedure getMethodFor(ClassType classtype, String s, Declaration declaration, Type atype[], Language language)
    {
        Object obj;
        Object obj1;
        Object obj2;
        int i;
        byte byte0;
        obj2 = null;
        obj1 = null;
        byte0 = -1;
        i = 0;
        if (s == null)
        {
            return null;
        }
        obj = obj2;
        String s1 = Compilation.mangleName(s);
        obj = obj2;
        String s2 = (new StringBuilder()).append(s1).append("$V").toString();
        obj = obj2;
        String s3 = (new StringBuilder()).append(s1).append("$V$X").toString();
        obj = obj2;
        String s4 = (new StringBuilder()).append(s1).append("$X").toString();
        boolean flag;
        flag = true;
        obj = obj2;
        Method method1 = classtype.getDeclaredMethods();
        classtype = ((ClassType) (obj1));
_L8:
        obj = classtype;
        if (method1 == null) goto _L2; else goto _L1
_L1:
        obj = classtype;
        if ((method1.getModifiers() & 9) == 9) goto _L4; else goto _L3
_L3:
        int j;
        int k;
        boolean flag2;
        flag2 = flag;
        obj2 = classtype;
        j = byte0;
        k = i;
        if (declaration == null) goto _L6; else goto _L5
_L5:
        obj = classtype;
        if (declaration.base != null) goto _L4; else goto _L7
_L7:
        k = i;
        j = byte0;
        obj2 = classtype;
        flag2 = flag;
_L6:
        obj = obj2;
        method1 = method1.getNext();
        flag = flag2;
        classtype = ((ClassType) (obj2));
        byte0 = j;
        i = k;
          goto _L8
_L4:
        obj = classtype;
        obj1 = method1.getName();
        obj = classtype;
        if (((String) (obj1)).equals(s1)) goto _L10; else goto _L9
_L9:
        obj = classtype;
        if (((String) (obj1)).equals(s2)) goto _L10; else goto _L11
_L11:
        obj = classtype;
        if (((String) (obj1)).equals(s4)) goto _L10; else goto _L12
_L12:
        obj = classtype;
        if (!((String) (obj1)).equals(s3)) goto _L13; else goto _L10
_L22:
        boolean flag1;
        obj1 = classtype;
        byte1 = byte0;
        l = i;
        if (!flag1)
        {
            j = 0;
            flag = j;
            obj1 = classtype;
            byte1 = byte0;
            l = i;
            if (i != 0)
            {
                obj1 = null;
                byte1 = -1;
                l = 0;
                flag = j;
            }
        }
        obj = obj1;
        classtype = new PrimProcedure(method1, language);
        obj = obj1;
        classtype.setName(s);
        obj = obj1;
        i = classtype.isApplicable(atype);
        flag2 = flag;
        obj2 = obj1;
        j = byte1;
        k = l;
        if (i < 0) goto _L6; else goto _L14
_L14:
        flag2 = flag;
        obj2 = obj1;
        j = byte1;
        k = l;
        if (i < byte1) goto _L6; else goto _L15
_L15:
        if (i <= byte1) goto _L17; else goto _L16
_L16:
        obj2 = classtype;
          goto _L18
_L13:
        flag2 = flag;
        obj2 = classtype;
        j = byte0;
        k = i;
        if (!flag) goto _L6; else goto _L19
_L19:
        obj = classtype;
        if (((String) (obj1)).equals("apply"))
        {
            break MISSING_BLOCK_LABEL_562;
        }
        flag2 = flag;
        obj2 = classtype;
        j = byte0;
        k = i;
        obj = classtype;
        if (!((String) (obj1)).equals("apply$V")) goto _L6; else goto _L20
_L20:
        break MISSING_BLOCK_LABEL_562;
_L17:
        obj2 = obj1;
        if (obj1 == null) goto _L18; else goto _L21
_L21:
        obj = obj1;
        classtype = (PrimProcedure)MethodProc.mostSpecific(((MethodProc) (obj1)), classtype);
        obj2 = classtype;
        if (classtype == null)
        {
            obj2 = classtype;
            if (byte1 > 0)
            {
                return null;
            }
        }
          goto _L18
        classtype;
_L2:
        return ((PrimProcedure) (obj));
_L10:
        flag1 = false;
          goto _L22
_L18:
        j = i;
        flag2 = flag;
        k = ((flag1) ? 1 : 0);
          goto _L6
        flag1 = true;
          goto _L22
    }

    public static PrimProcedure getMethodFor(ClassType classtype, String s, Declaration declaration, Expression aexpression[], Language language)
    {
        int i = aexpression.length;
        Type atype[] = new Type[i];
        do
        {
            i--;
            if (i >= 0)
            {
                atype[i] = aexpression[i].getType();
            } else
            {
                return getMethodFor(classtype, s, declaration, atype, language);
            }
        } while (true);
    }

    public static PrimProcedure getMethodFor(Procedure procedure, Declaration declaration, Type atype[], Language language)
    {
        Object obj = procedure;
        if (!(procedure instanceof GenericProc)) goto _L2; else goto _L1
_L1:
        int i;
        GenericProc genericproc = (GenericProc)procedure;
        obj = genericproc.methods;
        procedure = null;
        i = genericproc.count;
_L10:
        int j = i - 1;
        if (j < 0) goto _L4; else goto _L3
_L3:
        i = j;
        if (obj[j].isApplicable(atype) < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (procedure == null) goto _L6; else goto _L5
_L5:
        procedure = null;
_L8:
        return procedure;
_L6:
        procedure = obj[j];
        i = j;
        continue; /* Loop/switch isn't completed */
_L4:
        obj = procedure;
        if (procedure == null)
        {
            return null;
        }
_L2:
        PrimProcedure primprocedure;
        if (!(obj instanceof PrimProcedure))
        {
            break; /* Loop/switch isn't completed */
        }
        primprocedure = (PrimProcedure)obj;
        procedure = primprocedure;
        if (primprocedure.isApplicable(atype) >= 0) goto _L8; else goto _L7
_L7:
        procedure = getProcedureClass(obj);
        if (procedure == null)
        {
            return null;
        }
        return getMethodFor((ClassType)Type.make(procedure), ((Procedure) (obj)).getName(), declaration, atype, language);
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static PrimProcedure getMethodFor(Procedure procedure, Declaration declaration, Expression aexpression[], Language language)
    {
        int i = aexpression.length;
        Type atype[] = new Type[i];
        do
        {
            i--;
            if (i >= 0)
            {
                atype[i] = aexpression[i].getType();
            } else
            {
                return getMethodFor(procedure, declaration, atype, language);
            }
        } while (true);
    }

    public static PrimProcedure getMethodFor(Procedure procedure, Expression aexpression[])
    {
        return getMethodFor(procedure, null, aexpression, Language.getDefaultLanguage());
    }

    public static PrimProcedure getMethodFor(Class class1, String s, Declaration declaration, Expression aexpression[], Language language)
    {
        return getMethodFor((ClassType)Type.make(class1), s, declaration, aexpression, language);
    }

    public static Class getProcedureClass(Object obj)
    {
        ClassLoader classloader;
        ClassLoader classloader1;
        if (obj instanceof ModuleMethod)
        {
            obj = ((ModuleMethod)obj).module.getClass();
        } else
        {
            obj = obj.getClass();
        }
        classloader = ((Class) (obj)).getClassLoader();
        classloader1 = systemClassLoader;
        if (classloader == classloader1)
        {
            return ((Class) (obj));
        }
        break MISSING_BLOCK_LABEL_43;
        obj;
        return null;
    }

    private void init(Method method1)
    {
        method = method1;
        Type atype[];
        Type atype1[];
        if ((method1.getModifiers() & 8) != 0)
        {
            op_code = 184;
        } else
        {
            ClassType classtype = method1.getDeclaringClass();
            if (mode == 'P')
            {
                op_code = 183;
            } else
            {
                mode = 'V';
                if ("<init>".equals(method1.getName()))
                {
                    op_code = 183;
                } else
                if ((classtype.getModifiers() & 0x200) != 0)
                {
                    op_code = 185;
                } else
                {
                    op_code = 182;
                }
            }
        }
        atype1 = method1.getParameterTypes();
        atype = atype1;
        if (isConstructor())
        {
            atype = atype1;
            if (method1.getDeclaringClass().hasOuterLink())
            {
                int i = atype1.length - 1;
                atype = new Type[i];
                System.arraycopy(atype1, 1, atype, 0, i);
            }
        }
        argTypes = atype;
    }

    public static PrimProcedure makeBuiltinBinary(int i, Type type)
    {
        return new PrimProcedure(i, type, new Type[] {
            type, type
        });
    }

    public static PrimProcedure makeBuiltinUnary(int i, Type type)
    {
        return new PrimProcedure(i, type, new Type[] {
            type
        });
    }

    public static boolean takesContext(Method method1)
    {
        return method1.getName().endsWith("$X");
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object obj;
        Class aclass[];
        int i;
        int j;
        int k;
        boolean flag;
        k = argTypes.length;
        flag = isConstructor();
        if (flag && method.getDeclaringClass().hasOuterLink())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (member != null) goto _L2; else goto _L1
_L1:
        obj = method.getDeclaringClass().getReflectClass();
        if (i != 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        try
        {
            aclass = new Class[j + k];
        }
        // Misplaced declaration of an exception variable
        catch (CallContext callcontext)
        {
            throw callcontext.getTargetException();
        }
        j = k;
          goto _L3
_L15:
        aclass[j + k] = argTypes[k].getReflectClass();
        j = k;
          goto _L3
_L13:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L11:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        aclass[0] = method.getDeclaringClass().getOuterLinkType().getReflectClass();
        if (!flag) goto _L5; else goto _L4
_L4:
        member = ((Class) (obj)).getConstructor(aclass);
_L2:
        if (!flag) goto _L7; else goto _L6
_L6:
        aclass = ((Class []) (callcontext.values));
        obj = aclass;
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        i = aclass.length + 1;
        obj = ((Object) (new Object[i]));
        System.arraycopy(aclass, 0, obj, 1, i - 1);
        obj[0] = ((PairClassType)callcontext.value1).staticLink;
        obj = ((Constructor)member).newInstance(((Object []) (obj)));
_L9:
        if (!takesContext())
        {
            callcontext.consumer.writeObject(obj);
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        if (method == Type.clone_method) goto _L2; else goto _L8
_L8:
        member = ((Class) (obj)).getMethod(method.getName(), aclass);
          goto _L2
_L7:
label0:
        {
            if (method != Type.clone_method)
            {
                break label0;
            }
            Object obj1 = callcontext.value1;
            obj = obj1.getClass().getComponentType();
            i = Array.getLength(obj1);
            obj = Array.newInstance(((Class) (obj)), i);
            System.arraycopy(obj1, 0, obj, 0, i);
        }
          goto _L9
        obj = retType.coerceToObject(((java.lang.reflect.Method)member).invoke(callcontext.value1, callcontext.values));
          goto _L9
_L3:
        k = j - 1;
        if (k < 0) goto _L11; else goto _L10
_L10:
        if (i == 0) goto _L13; else goto _L12
_L12:
        j = 1;
        if (true) goto _L15; else goto _L14
_L14:
    }

    void compile(Type type, ApplyExp applyexp, Compilation compilation, Target target)
    {
        ClassType classtype = null;
        Type type1 = null;
        Expression aexpression[] = applyexp.getArgs();
        CodeAttr codeattr = compilation.getCode();
        Type type2 = retType;
        boolean flag = false;
        int i;
        if (isConstructor())
        {
            if (method == null)
            {
                type = type1;
            } else
            {
                type = method.getDeclaringClass();
            }
            if (type.hasOuterLink())
            {
                ClassExp.loadSuperStaticLink(aexpression[0], type, compilation);
            }
            type1 = null;
            i = 1;
        } else
        if (opcode() == 183 && mode == 'P' && "<init>".equals(method.getName()))
        {
            if (method != null)
            {
                classtype = method.getDeclaringClass();
            }
            i = ((flag) ? 1 : 0);
            type1 = type;
            if (classtype.hasOuterLink())
            {
                codeattr.emitPushThis();
                codeattr.emitLoad(codeattr.getCurrentScope().getVariable(1));
                type1 = null;
                i = 1;
            }
        } else
        {
            i = ((flag) ? 1 : 0);
            type1 = type;
            if (takesTarget())
            {
                i = ((flag) ? 1 : 0);
                type1 = type;
                if (method.getStaticFlag())
                {
                    i = 1;
                    type1 = type;
                }
            }
        }
        compileArgs(aexpression, i, type1, compilation);
        if (method == null)
        {
            codeattr.emitPrimop(opcode(), aexpression.length, retType);
            target.compileFromStack(compilation, type2);
            return;
        } else
        {
            compileInvoke(compilation, method, target, applyexp.isTailCall(), op_code, type2);
            return;
        }
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Object obj = compilation.getCode();
        ClassType classtype;
        Expression aexpression[];
        if (method == null)
        {
            classtype = null;
        } else
        {
            classtype = method.getDeclaringClass();
        }
        aexpression = applyexp.getArgs();
        if (isConstructor())
        {
            if (applyexp.getFlag(8))
            {
                int j = aexpression.length;
                compilation.letStart();
                classtype = new Expression[j];
                classtype[0] = aexpression[0];
                for (int i = 1; i < j; i++)
                {
                    obj = aexpression[i];
                    obj = compilation.letVariable(null, ((Expression) (obj)).getType(), ((Expression) (obj)));
                    ((Declaration) (obj)).setCanRead(true);
                    classtype[i] = new ReferenceExp(((Declaration) (obj)));
                }

                compilation.letEnter();
                compilation.letDone(new ApplyExp(applyexp.func, classtype)).compile(compilation, target);
                return;
            }
            ((CodeAttr) (obj)).emitNew(classtype);
            ((CodeAttr) (obj)).emitDup(classtype);
        }
        String s = WrongArguments.checkArgCount(this, aexpression.length);
        if (s != null)
        {
            compilation.error('e', s);
        }
        if (getStaticFlag())
        {
            classtype = null;
        }
        compile(((Type) (classtype)), applyexp, compilation, target);
    }

    public Method getMethod()
    {
        return method;
    }

    public String getName()
    {
        String s = super.getName();
        if (s != null)
        {
            return s;
        } else
        {
            String s1 = getVerboseName();
            setName(s1);
            return s1;
        }
    }

    public Type getParameterType(int i)
    {
        int j = i;
        if (takesTarget())
        {
            if (i == 0)
            {
                if (isConstructor())
                {
                    return Type.objectType;
                } else
                {
                    return method.getDeclaringClass();
                }
            }
            j = i - 1;
        }
        i = argTypes.length;
        if (j < i - 1)
        {
            return argTypes[j];
        }
        boolean flag = takesVarArgs();
        if (j < i && !flag)
        {
            return argTypes[j];
        }
        Type type = argTypes[i - 1];
        if (type instanceof ArrayType)
        {
            return ((ArrayType)type).getComponentType();
        } else
        {
            return Type.objectType;
        }
    }

    public final Type[] getParameterTypes()
    {
        return argTypes;
    }

    public Type getReturnType()
    {
        return retType;
    }

    public Type getReturnType(Expression aexpression[])
    {
        return retType;
    }

    public final boolean getStaticFlag()
    {
        return method == null || method.getStaticFlag() || isConstructor();
    }

    public String getVerboseName()
    {
        StringBuffer stringbuffer = new StringBuffer(100);
        if (method == null)
        {
            stringbuffer.append("<op ");
            stringbuffer.append(op_code);
            stringbuffer.append('>');
        } else
        {
            stringbuffer.append(method.getDeclaringClass().getName());
            stringbuffer.append('.');
            stringbuffer.append(method.getName());
        }
        stringbuffer.append('(');
        for (int i = 0; i < argTypes.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(',');
            }
            stringbuffer.append(argTypes[i].getName());
        }

        stringbuffer.append(')');
        return stringbuffer.toString();
    }

    public int isApplicable(Type atype[])
    {
        int j = super.isApplicable(atype);
        int k = atype.length;
        int i = j;
        if (j == -1)
        {
            i = j;
            if (method != null)
            {
                i = j;
                if ((method.getModifiers() & 0x80) != 0)
                {
                    i = j;
                    if (k > 0)
                    {
                        i = j;
                        if (atype[k - 1] instanceof ArrayType)
                        {
                            Type atype1[] = new Type[k];
                            System.arraycopy(atype, 0, atype1, 0, k - 1);
                            atype1[k - 1] = ((ArrayType)atype[k - 1]).getComponentType();
                            i = super.isApplicable(atype1);
                        }
                    }
                }
            }
        }
        return i;
    }

    public final boolean isConstructor()
    {
        return opcode() == 183 && mode != 'P';
    }

    public boolean isSideEffectFree()
    {
        return sideEffectFree;
    }

    public boolean isSpecial()
    {
        return mode == 'P';
    }

    public int match0(CallContext callcontext)
    {
        return matchN(ProcedureN.noArgs, callcontext);
    }

    public int match1(Object obj, CallContext callcontext)
    {
        return matchN(new Object[] {
            obj
        }, callcontext);
    }

    public int match2(Object obj, Object obj1, CallContext callcontext)
    {
        return matchN(new Object[] {
            obj, obj1
        }, callcontext);
    }

    public int match3(Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        return matchN(new Object[] {
            obj, obj1, obj2
        }, callcontext);
    }

    public int match4(Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        return matchN(new Object[] {
            obj, obj1, obj2, obj3
        }, callcontext);
    }

    public int matchN(Object aobj[], CallContext callcontext)
    {
        int i1 = aobj.length;
        boolean flag = takesVarArgs();
        int l = minArgs();
        if (i1 < l)
        {
            return 0xfff10000 | l;
        }
        if (!flag && i1 > l)
        {
            return 0xfff20000 | l;
        }
        int k = argTypes.length;
        Object obj = null;
        Object obj1 = null;
        Object aobj1[];
        Object aobj2[];
        int i;
        int j;
        boolean flag1;
        if (takesTarget() || isConstructor())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        flag1 = takesContext();
        aobj2 = new Object[k];
        j = k;
        if (flag1)
        {
            j = k - 1;
            aobj2[j] = callcontext;
        }
        aobj1 = ((Object []) (obj1));
        if (flag)
        {
            obj = argTypes[j - 1];
            Object obj4;
            if (obj == Compilation.scmListType || obj == LangObjType.listType)
            {
                aobj2[j - 1] = LList.makeList(aobj, l);
                obj = Type.objectType;
                aobj1 = ((Object []) (obj1));
            } else
            {
                obj = ((ArrayType)obj).getComponentType();
                aobj1 = (Object[])(Object[])Array.newInstance(((Type) (obj)).getReflectClass(), i1 - l);
                aobj2[j - 1] = ((Object) (aobj1));
            }
        }
        if (isConstructor())
        {
            obj1 = aobj[0];
        } else
        if (i != 0)
        {
            try
            {
                obj1 = method.getDeclaringClass().coerceFromObject(aobj[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                return 0xfff40001;
            }
        } else
        {
            obj1 = null;
        }
        j = i;
        do
        {
            if (j >= aobj.length)
            {
                break;
            }
            obj4 = aobj[j];
            Object obj2;
            Object obj3;
            if (j < l)
            {
                obj2 = argTypes[j - i];
            } else
            {
                obj2 = obj;
            }
            obj3 = obj4;
            if (obj2 != Type.objectType)
            {
                try
                {
                    obj3 = ((Type) (obj2)).coerceFromObject(obj4);
                }
                // Misplaced declaration of an exception variable
                catch (Object aobj[])
                {
                    return 0xfff40000 | j + 1;
                }
            }
            if (j < l)
            {
                aobj2[j - i] = obj3;
            } else
            if (aobj1 != null)
            {
                aobj1[j - l] = obj3;
            }
            j++;
        } while (true);
        callcontext.value1 = obj1;
        callcontext.values = aobj2;
        callcontext.proc = this;
        return 0;
    }

    public int numArgs()
    {
        int j = argTypes.length;
        int i = j;
        if (takesTarget())
        {
            i = j + 1;
        }
        j = i;
        if (takesContext())
        {
            j = i - 1;
        }
        if (takesVarArgs())
        {
            return j - 1 - 4096;
        } else
        {
            return (j << 12) + j;
        }
    }

    public final int opcode()
    {
        return op_code;
    }

    public void print(PrintWriter printwriter)
    {
        printwriter.print("#<primitive procedure ");
        printwriter.print(toString());
        printwriter.print('>');
    }

    public void setReturnType(Type type)
    {
        retType = type;
    }

    public void setSideEffectFree()
    {
        sideEffectFree = true;
    }

    public boolean takesContext()
    {
        return method != null && takesContext(method);
    }

    public boolean takesTarget()
    {
        return mode != 0;
    }

    public boolean takesVarArgs()
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (method == null) goto _L2; else goto _L1
_L1:
        if ((method.getModifiers() & 0x80) == 0) goto _L4; else goto _L3
_L3:
        flag = true;
_L2:
        return flag;
_L4:
        String s;
        s = method.getName();
        if (s.endsWith("$V"))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!s.endsWith("$V$X")) goto _L2; else goto _L5
_L5:
        return true;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(100);
        String s;
        if (retType == null)
        {
            s = "<unknown>";
        } else
        {
            s = retType.getName();
        }
        stringbuffer.append(s);
        stringbuffer.append(' ');
        stringbuffer.append(getVerboseName());
        return stringbuffer.toString();
    }

}
