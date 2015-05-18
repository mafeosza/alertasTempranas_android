// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;

// Referenced classes of package gnu.expr:
//            StackTarget, LambdaExp, Compilation, Target, 
//            Declaration

public class CheckedTarget extends StackTarget
{

    static Method initWrongTypeProcMethod;
    static Method initWrongTypeStringMethod;
    static ClassType typeClassCastException;
    static ClassType typeWrongType;
    int argno;
    LambdaExp proc;
    String procname;

    public CheckedTarget(Type type)
    {
        super(type);
        argno = -4;
    }

    public CheckedTarget(Type type, LambdaExp lambdaexp, int i)
    {
        super(type);
        proc = lambdaexp;
        procname = lambdaexp.getName();
        argno = i;
    }

    public CheckedTarget(Type type, String s, int i)
    {
        super(type);
        procname = s;
        argno = i;
    }

    public static void emitCheckedCoerce(Compilation compilation, LambdaExp lambdaexp, int i, Type type)
    {
        emitCheckedCoerce(compilation, lambdaexp, lambdaexp.getName(), i, type, null);
    }

    public static void emitCheckedCoerce(Compilation compilation, LambdaExp lambdaexp, int i, Type type, Variable variable)
    {
        emitCheckedCoerce(compilation, lambdaexp, lambdaexp.getName(), i, type, variable);
    }

    static void emitCheckedCoerce(Compilation compilation, LambdaExp lambdaexp, String s, int i, Type type, Variable variable)
    {
        CodeAttr codeattr = compilation.getCode();
        boolean flag1 = codeattr.isInTry();
        initWrongType();
        Label label = new Label(codeattr);
        gnu.bytecode.Scope scope;
        int j;
        if (variable == null && type != Type.toStringType)
        {
            scope = codeattr.pushScope();
            variable = codeattr.addLocal(Type.objectType);
            codeattr.emitDup(1);
            codeattr.emitStore(variable);
        } else
        {
            scope = null;
        }
        j = codeattr.getPC();
        label.define(codeattr);
        emitCoerceFromObject(type, compilation);
        if (codeattr.getPC() == j || type == Type.toStringType)
        {
            if (scope != null)
            {
                codeattr.popScope();
            }
            return;
        }
        Label label1 = new Label(codeattr);
        label1.define(codeattr);
        type = new Label(codeattr);
        type.setTypes(codeattr);
        if (flag1)
        {
            codeattr.emitGoto(type);
        }
        j = 0;
        codeattr.setUnreachable();
        if (!flag1)
        {
            j = codeattr.beginFragment(type);
        }
        codeattr.addHandler(label, label1, typeClassCastException);
        int k = 0;
        boolean flag = k;
        if (lambdaexp != null)
        {
            flag = k;
            if (lambdaexp.isClassGenerated())
            {
                flag = k;
                if (!compilation.method.getStaticFlag())
                {
                    flag = k;
                    if (compilation.method.getDeclaringClass() == lambdaexp.getCompiledClassType(compilation))
                    {
                        flag = true;
                    }
                }
            }
        }
        k = compilation.getLineNumber();
        if (k > 0)
        {
            codeattr.putLineNumber(k);
        }
        codeattr.emitNew(typeWrongType);
        codeattr.emitDupX();
        codeattr.emitSwap();
        if (flag)
        {
            codeattr.emitPushThis();
        } else
        {
            compilation = s;
            if (s == null)
            {
                compilation = s;
                if (i != -4)
                {
                    compilation = "lambda";
                }
            }
            codeattr.emitPushString(compilation);
        }
        codeattr.emitPushInt(i);
        codeattr.emitLoad(variable);
        if (flag)
        {
            compilation = initWrongTypeProcMethod;
        } else
        {
            compilation = initWrongTypeStringMethod;
        }
        codeattr.emitInvokeSpecial(compilation);
        if (scope != null)
        {
            codeattr.popScope();
        }
        codeattr.emitThrow();
        if (flag1)
        {
            type.define(codeattr);
            return;
        } else
        {
            codeattr.endFragment(j);
            return;
        }
    }

    public static void emitCheckedCoerce(Compilation compilation, String s, int i, Type type)
    {
        emitCheckedCoerce(compilation, null, s, i, type, null);
    }

    public static Target getInstance(Type type)
    {
        if (type == Type.objectType)
        {
            return Target.pushObject;
        } else
        {
            return new CheckedTarget(type);
        }
    }

    public static Target getInstance(Type type, LambdaExp lambdaexp, int i)
    {
        if (type == Type.objectType)
        {
            return Target.pushObject;
        } else
        {
            return new CheckedTarget(type, lambdaexp, i);
        }
    }

    public static Target getInstance(Type type, String s, int i)
    {
        if (type == Type.objectType)
        {
            return Target.pushObject;
        } else
        {
            return new CheckedTarget(type, s, i);
        }
    }

    public static Target getInstance(Declaration declaration)
    {
        return getInstance(declaration.getType(), declaration.getName(), -2);
    }

    private static void initWrongType()
    {
        if (typeClassCastException == null)
        {
            typeClassCastException = ClassType.make("java.lang.ClassCastException");
        }
        if (typeWrongType == null)
        {
            typeWrongType = ClassType.make("gnu.mapping.WrongType");
            ClassType classtype = typeClassCastException;
            ClassType classtype1 = Compilation.javaStringType;
            gnu.bytecode.PrimType primtype = Type.intType;
            ClassType classtype2 = Type.objectType;
            ClassType classtype3 = typeWrongType;
            gnu.bytecode.PrimType primtype1 = Type.voidType;
            initWrongTypeStringMethod = classtype3.addMethod("<init>", 1, new Type[] {
                classtype, classtype1, primtype, classtype2
            }, primtype1);
            classtype = typeClassCastException;
            classtype1 = Compilation.typeProcedure;
            primtype = Type.intType;
            classtype2 = Type.objectType;
            classtype3 = typeWrongType;
            primtype1 = Type.voidType;
            initWrongTypeProcMethod = classtype3.addMethod("<init>", 1, new Type[] {
                classtype, classtype1, primtype, classtype2
            }, primtype1);
        }
    }

    public void compileFromStack(Compilation compilation, Type type)
    {
        if (!compileFromStack0(compilation, type))
        {
            emitCheckedCoerce(compilation, proc, procname, argno, this.type, null);
        }
    }
}
