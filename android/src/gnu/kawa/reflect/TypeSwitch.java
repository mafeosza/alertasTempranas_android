// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

public class TypeSwitch extends MethodProc
    implements Inlineable
{

    public static final TypeSwitch typeSwitch = new TypeSwitch("typeswitch");

    public TypeSwitch(String s)
    {
        setName(s);
        setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplyTypeSwitch");
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object aobj[] = callcontext.getArgs();
        Object obj = aobj[0];
        int j = aobj.length - 1;
        for (int i = 1; i < j; i++)
        {
            if (((MethodProc)aobj[i]).match1(obj, callcontext) >= 0)
            {
                return;
            }
        }

        ((Procedure)aobj[j]).check1(obj, callcontext);
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Expression aexpression[] = applyexp.getArgs();
        CodeAttr codeattr = compilation.getCode();
        codeattr.pushScope();
        gnu.bytecode.Variable variable = codeattr.addLocal(Type.pointer_type);
        aexpression[0].compile(compilation, Target.pushObject);
        codeattr.emitStore(variable);
        for (int i = 1; i < aexpression.length;)
        {
            if (i > 1)
            {
                codeattr.emitElse();
            }
            int k = i + 1;
            applyexp = aexpression[i];
            if (applyexp instanceof LambdaExp)
            {
                LambdaExp lambdaexp = (LambdaExp)applyexp;
                applyexp = lambdaexp.firstDecl();
                Type type = applyexp.getType();
                if (!applyexp.getCanRead())
                {
                    applyexp = null;
                } else
                {
                    applyexp.allocateVariable(codeattr);
                }
                if (type instanceof TypeValue)
                {
                    ((TypeValue)type).emitTestIf(variable, applyexp, compilation);
                } else
                {
                    if (k < aexpression.length)
                    {
                        codeattr.emitLoad(variable);
                        type.emitIsInstance(codeattr);
                        codeattr.emitIfIntNotZero();
                    }
                    if (applyexp != null)
                    {
                        codeattr.emitLoad(variable);
                        applyexp.compileStore(compilation);
                    }
                }
                lambdaexp.allocChildClasses(compilation);
                lambdaexp.body.compileWithPosition(compilation, target);
                i = k;
            } else
            {
                throw new Error("not implemented: typeswitch arg not LambdaExp");
            }
        }

        int j = aexpression.length - 2;
        do
        {
            j--;
            if (j >= 0)
            {
                codeattr.emitFi();
            } else
            {
                codeattr.popScope();
                return;
            }
        } while (true);
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Type.pointer_type;
    }

    public int numArgs()
    {
        return -4094;
    }

}
