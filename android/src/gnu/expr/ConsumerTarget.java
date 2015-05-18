// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.reflect.OccurrenceType;

// Referenced classes of package gnu.expr:
//            Target, IgnoreTarget, Expression, Compilation, 
//            StackTarget

public class ConsumerTarget extends Target
{

    Variable consumer;
    boolean isContextTarget;

    public ConsumerTarget(Variable variable)
    {
        consumer = variable;
    }

    public static void compileUsingConsumer(Expression expression, Compilation compilation, Target target)
    {
        if ((target instanceof ConsumerTarget) || (target instanceof IgnoreTarget))
        {
            expression.compile(compilation, target);
            return;
        } else
        {
            ClassType classtype = Compilation.typeValues;
            compileUsingConsumer(expression, compilation, target, classtype.getDeclaredMethod("make", 0), classtype.getDeclaredMethod("canonicalize", 0));
            return;
        }
    }

    public static void compileUsingConsumer(Expression expression, Compilation compilation, Target target, Method method, Method method1)
    {
        CodeAttr codeattr = compilation.getCode();
        Scope scope = codeattr.pushScope();
        Variable variable;
        ConsumerTarget consumertarget;
        if (method.getName() == "<init>")
        {
            ClassType classtype1 = method.getDeclaringClass();
            ClassType classtype = classtype1;
            codeattr.emitNew(classtype1);
            codeattr.emitDup(classtype);
            codeattr.emitInvoke(method);
            method = classtype;
        } else
        {
            Type type = method.getReturnType();
            codeattr.emitInvokeStatic(method);
            method = type;
        }
        variable = scope.addVariable(codeattr, method, null);
        consumertarget = new ConsumerTarget(variable);
        codeattr.emitStore(variable);
        expression.compile(compilation, consumertarget);
        codeattr.emitLoad(variable);
        if (method1 != null)
        {
            codeattr.emitInvoke(method1);
        }
        codeattr.popScope();
        if (method1 != null)
        {
            method = method1.getReturnType();
        }
        target.compileFromStack(compilation, method);
    }

    public static Target makeContextTarget(Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        compilation.loadCallContext();
        codeattr.emitGetField(Compilation.typeCallContext.getDeclaredField("consumer"));
        compilation = codeattr.getCurrentScope().addVariable(codeattr, Compilation.typeConsumer, "$result");
        codeattr.emitStore(compilation);
        compilation = new ConsumerTarget(compilation);
        compilation.isContextTarget = true;
        return compilation;
    }

    public void compileFromStack(Compilation compilation, Type type)
    {
        compileFromStack(compilation, type, -1);
    }

    void compileFromStack(Compilation compilation, Type type, int i)
    {
        Object obj;
        Object obj1;
        CodeAttr codeattr;
        Type type1;
        boolean flag;
        char c;
        codeattr = compilation.getCode();
        obj = null;
        obj1 = null;
        compilation = null;
        flag = false;
        type1 = type.getImplementationType();
        if (!(type1 instanceof PrimType))
        {
            break MISSING_BLOCK_LABEL_260;
        }
        c = type1.getSignature().charAt(0);
        c;
        JVM INSTR lookupswitch 9: default 128
    //                   66: 194
    //                   67: 240
    //                   68: 227
    //                   70: 217
    //                   73: 194
    //                   74: 204
    //                   83: 194
    //                   86: 193
    //                   90: 250;
           goto _L1 _L2 _L3 _L4 _L5 _L2 _L6 _L2 _L7 _L8
_L1:
        type = obj;
_L9:
        Method method;
        if (i < 0)
        {
            if (flag)
            {
                codeattr.pushScope();
                Variable variable = codeattr.addLocal(type1);
                codeattr.emitStore(variable);
                codeattr.emitLoad(consumer);
                codeattr.emitLoad(variable);
                codeattr.popScope();
            } else
            {
                codeattr.emitLoad(consumer);
                codeattr.emitSwap();
            }
        }
        method = obj1;
        if (true)
        {
            method = obj1;
            if (type != null)
            {
                method = Compilation.typeConsumer.getDeclaredMethod(type, new Type[] {
                    compilation
                });
            }
        }
        if (method != null)
        {
            codeattr.emitInvokeInterface(method);
        }
        if (c == 'C')
        {
            codeattr.emitPop(1);
        }
_L7:
        return;
_L2:
        type = "writeInt";
        compilation = Type.intType;
          goto _L9
_L6:
        type = "writeLong";
        compilation = Type.longType;
        flag = true;
          goto _L9
_L5:
        type = "writeFloat";
        compilation = Type.floatType;
          goto _L9
_L4:
        type = "writeDouble";
        compilation = Type.doubleType;
        flag = true;
          goto _L9
_L3:
        type = "append";
        compilation = Type.charType;
          goto _L9
_L8:
        type = "writeBoolean";
        compilation = Type.booleanType;
          goto _L9
        c = '\0';
        if (i == 1 || OccurrenceType.itemCountIsOne(type1))
        {
            type = "writeObject";
            compilation = Type.pointer_type;
        } else
        {
            compilation = Compilation.typeValues.getDeclaredMethod("writeValues", 2);
            codeattr.emitLoad(consumer);
            if (i == 0)
            {
                codeattr.emitSwap();
            }
            codeattr.emitInvokeStatic(compilation);
            return;
        }
          goto _L9
    }

    public boolean compileWrite(Expression expression, Compilation compilation)
    {
        Type type = expression.getType().getImplementationType();
        if ((type instanceof PrimType) && !type.isVoid() || OccurrenceType.itemCountIsOne(type))
        {
            compilation.getCode().emitLoad(consumer);
            expression.compile(compilation, StackTarget.getInstance(type));
            compileFromStack(compilation, type, 1);
            return true;
        } else
        {
            return false;
        }
    }

    public Variable getConsumerVariable()
    {
        return consumer;
    }

    public Type getType()
    {
        return Compilation.scmSequenceType;
    }

    public final boolean isContextTarget()
    {
        return isContextTarget;
    }
}
