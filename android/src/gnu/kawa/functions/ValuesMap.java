// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class ValuesMap extends MethodProc
    implements Inlineable
{

    public static final ValuesMap valuesMap = new ValuesMap(-1);
    public static final ValuesMap valuesMapWithPos = new ValuesMap(1);
    private final int startCounter;

    private ValuesMap(int i)
    {
        startCounter = i;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyValuesMap");
    }

    static LambdaExp canInline(ApplyExp applyexp, ValuesMap valuesmap)
    {
        byte byte0 = 2;
        applyexp = applyexp.getArgs();
        if (applyexp.length == 2)
        {
            applyexp = applyexp[0];
            if (applyexp instanceof LambdaExp)
            {
                applyexp = (LambdaExp)applyexp;
                if (((LambdaExp) (applyexp)).min_args == ((LambdaExp) (applyexp)).max_args)
                {
                    int i = ((LambdaExp) (applyexp)).min_args;
                    if (valuesmap.startCounter < 0)
                    {
                        byte0 = 1;
                    }
                    if (i == byte0)
                    {
                        return applyexp;
                    }
                }
            }
        }
        return null;
    }

    public static void compileInlined(LambdaExp lambdaexp, Expression expression, int i, Method method, Compilation compilation, Target target)
    {
        Object obj1 = lambdaexp.firstDecl();
        CodeAttr codeattr = compilation.getCode();
        Object obj = codeattr.pushScope();
        Type type = ((Declaration) (obj1)).getType();
        Object obj2;
        Object obj3;
        Label label;
        if (i >= 0)
        {
            obj = ((Scope) (obj)).addVariable(codeattr, Type.intType, "position");
            codeattr.emitPushInt(i);
            codeattr.emitStore(((gnu.bytecode.Variable) (obj)));
            obj2 = new Declaration(((gnu.bytecode.Variable) (obj)));
        } else
        {
            obj = null;
            obj2 = null;
        }
        if (((Declaration) (obj1)).isSimple() && method == null)
        {
            ((Declaration) (obj1)).allocateVariable(codeattr);
        } else
        {
            obj1 = Compilation.mangleNameIfNeeded(((Declaration) (obj1)).getName());
            obj1 = new Declaration(codeattr.addLocal(type.getImplementationType(), ((String) (obj1))));
        }
        if (i >= 0)
        {
            obj3 = new Expression[2];
            obj3[0] = new ReferenceExp(((Declaration) (obj1)));
            obj3[1] = new ReferenceExp(((Declaration) (obj2)));
        } else
        {
            obj3 = new Expression[1];
            obj3[0] = new ReferenceExp(((Declaration) (obj1)));
        }
        obj3 = new ApplyExp(lambdaexp, ((Expression []) (obj3)));
        lambdaexp = ((LambdaExp) (obj3));
        if (method != null)
        {
            lambdaexp = ((LambdaExp) (obj3));
            if (((Expression) (obj3)).getType().getImplementationType() != Type.booleanType)
            {
                lambdaexp = new ApplyExp(method, new Expression[] {
                    obj3, new ReferenceExp(((Declaration) (obj2)))
                });
            }
            lambdaexp = new IfExp(lambdaexp, new ReferenceExp(((Declaration) (obj1))), QuoteExp.voidExp);
        }
        method = codeattr.addLocal(Type.intType);
        obj2 = codeattr.addLocal(Type.pointer_type);
        obj3 = codeattr.addLocal(Type.intType);
        expression.compileWithPosition(compilation, Target.pushObject);
        codeattr.emitStore(((gnu.bytecode.Variable) (obj2)));
        codeattr.emitPushInt(0);
        codeattr.emitStore(method);
        expression = new Label(codeattr);
        label = new Label(codeattr);
        expression.define(codeattr);
        codeattr.emitLoad(((gnu.bytecode.Variable) (obj2)));
        codeattr.emitLoad(method);
        codeattr.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextIndex", 2));
        codeattr.emitDup(Type.intType);
        codeattr.emitStore(((gnu.bytecode.Variable) (obj3)));
        codeattr.emitGotoIfIntLtZero(label);
        codeattr.emitLoad(((gnu.bytecode.Variable) (obj2)));
        codeattr.emitLoad(method);
        codeattr.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextValue", 2));
        StackTarget.convert(compilation, Type.objectType, type);
        ((Declaration) (obj1)).compileStore(compilation);
        lambdaexp.compile(compilation, target);
        if (i >= 0)
        {
            codeattr.emitInc(((gnu.bytecode.Variable) (obj)), (short)1);
        }
        codeattr.emitLoad(((gnu.bytecode.Variable) (obj3)));
        codeattr.emitStore(method);
        codeattr.emitGoto(expression);
        label.define(codeattr);
        codeattr.popScope();
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Procedure procedure = (Procedure)callcontext.getNextArg();
        Object obj = callcontext.consumer;
        obj = callcontext.getNextArg();
        Procedure.checkArgCount(procedure, 1);
        if (obj instanceof Values)
        {
            int j = 0;
            int i = startCounter;
            obj = (Values)obj;
            do
            {
                j = ((Values) (obj)).nextPos(j);
                if (j == 0)
                {
                    break;
                }
                Object obj1 = ((Values) (obj)).getPosPrevious(j);
                if (startCounter >= 0)
                {
                    procedure.check2(obj1, IntNum.make(i), callcontext);
                    i++;
                } else
                {
                    procedure.check1(obj1, callcontext);
                }
                callcontext.runUntilDone();
            } while (true);
        } else
        {
            if (startCounter >= 0)
            {
                procedure.check2(obj, IntNum.make(startCounter), callcontext);
            } else
            {
                procedure.check1(obj, callcontext);
            }
            callcontext.runUntilDone();
        }
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        LambdaExp lambdaexp = canInline(applyexp, this);
        if (lambdaexp == null)
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        }
        Expression aexpression[] = applyexp.getArgs();
        if (!(target instanceof IgnoreTarget) && !(target instanceof ConsumerTarget))
        {
            ConsumerTarget.compileUsingConsumer(applyexp, compilation, target);
            return;
        } else
        {
            compileInlined(lambdaexp, aexpression[1], startCounter, null, compilation, target);
            return;
        }
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Type.pointer_type;
    }

    public int numArgs()
    {
        return 8194;
    }

}
